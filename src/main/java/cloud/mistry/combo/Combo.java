package cloud.mistry.combo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Combo
{
    private static final Logger logger = LogManager.getLogger("Combo");
    private final int CHARS_IN_ALPHABET = 26;
    private static Multimap<Integer,Character> ALPHABET = HashMultimap.create(26,3);


    /**
     * Public constructor. Simply initialises an Alphabet to perform lookups against.
     */
    public Combo()
    {
        initialiseAlphabet();
        logger.info("Alphabet: " +ALPHABET);
    }


    /**
     * Takes in a 6 character word and returns the numerical pattern for it.
     *
     * @param word - The word to lookup.
     * @return - The integers that represent the word.
     */
    public ArrayList<Integer> lookupWord(String word)
    {
        if( word==null || word.length()!=6 )
        {
            throw new IllegalArgumentException(String.format("Error. %s needs to be a 6 character string", word));
        }

        word = word.toUpperCase();
        logger.info("Analysing: " + word);

        final ArrayList<Integer> numList = new ArrayList<>(6);

        // Convert each char to correct number and add to array to return
        for( int i=0; i<6; i++ )
        {
            numList.add(convertCharToNum(word.charAt(i)));
        }

        return numList;
    }

    /**
     * Converts the char to the ordinal I want.
     *
     * @param ch The character to convert.
     * @return An Integer representation of the character.
     */
    private Integer convertCharToNum(char ch)
    {
        return (ch-64) % 10;
    }


    /**
     * Converts a 6 digit number into potential real words that could be generated from them.
     *
     * @param nums 6 digit number, passed in as a String.
     * @return The potential words that can be generated from the input numbers.
     */
    public List<String> lookupNumber(String nums)
    {
        if( nums==null || nums.length()!=6 )
        {
            throw new IllegalArgumentException(String.format("Error. %s needs to be a 6 character string", nums));
        }

        for( int i=0; i<6; i++ )
        {
            if( !Character.isDigit(nums.charAt(i)) )
            {
                throw new IllegalArgumentException(String.format("Error. All elements of passed in nums %s must be numbers", nums));
            }
        }

        logger.info("Analysing: " + nums);

        HashMap allCombos = new HashMap(6);
        for( int pos=1; pos<7; pos++ )
        {
            //System.out.println(nums.charAt(pos-1));
            int index = Character.digit(nums.charAt(pos-1), 10);
            allCombos.put( pos, ALPHABET.get(index));
        }
        logger.info( "All combinations of letters = \n" + allCombos );

        Set<Character> set1 = (Set<Character>) allCombos.get(1);

        Set<List<Character>> retSet = Sets.cartesianProduct(
                (Set<Character>) allCombos.get(1),
                (Set<Character>) allCombos.get(2),
                (Set<Character>) allCombos.get(3),
                (Set<Character>) allCombos.get(4),
                (Set<Character>) allCombos.get(5),
                (Set<Character>) allCombos.get(6)
        );


        //logger.trace(retSet);

        ArrayList<String> retVals = convertCharsToStrings(retSet);
        logger.debug(String.format("%d items in set", retVals.size()));

        // Remove non-words from set
        removeNoneWords(retVals);

        logger.debug(String.format("%d items in filtered set", retVals.size()));
        logger.trace(retVals);

        return retVals;
    }

    /**
     * Filters out words that are not in the standard linux words file.
     *
     * @param values The list to filter.
     */
    private void removeNoneWords(ArrayList<String> values)
    {
        Set<String> sixLetterWords = new HashSet<>(42000);

        // Put dictionary into set
        try
        {
            Files.lines(Paths.get("/usr/share/dict/words")).
                    filter(line -> line.length()==6).
                    //forEach(word -> sixLetterWords.add(word.substring(0,6).toUpperCase()));
                    forEach(word -> sixLetterWords.add(word.toUpperCase()));

            logger.info("Number of 6 letter words = " + sixLetterWords.size());
            logger.info(sixLetterWords);

            // Do a set union to only keep appropriate words in my main list
            values.retainAll(sixLetterWords);
        }
        catch (IOException e)
        {
            logger.error("Unable to find words file in /usr/share/dict/words");
        }
    }

    /**
     * Converts a Set of Lists of Characters into an Array of Strings.
     *
     * @param theSet The Set of List of Characters.
     * @return Array of Strings.
     */
    private ArrayList<String> convertCharsToStrings(Set<List<Character>> theSet)
    {
        ArrayList<String> retStrings = new ArrayList<>(theSet.size());

        for( List<Character> charList : theSet )
        {
            StringBuilder sb = new StringBuilder(charList.size());

            for( Character ch : charList )
            {
                sb.append(ch);
            }

            retStrings.add(sb.toString());
        }

        return retStrings;
    }


    /**
     * Initialised a Multivalue hashmap {@link Multimap}. The key is a number between 0-9 and the values are the letters that
     * match such that 1=A, 2=B...10=J, 1=K etc.
     */
    private void initialiseAlphabet()
    {
        Character aChar = 'A';
        int currCount = 1;

        for( int charPosition=1; charPosition!=CHARS_IN_ALPHABET+1; charPosition++, currCount++)
        {
            if( currCount%10 == 0 )
            {
                currCount = 0;
            }

            ALPHABET.put(currCount, aChar);
            aChar++;
        }
    }
}
