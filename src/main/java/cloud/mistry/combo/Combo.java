package cloud.mistry.combo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Combo
{
    private static final Logger logger = LogManager.getLogger("Combo");
    private final int CHARS_IN_ALPHABET = 26;
    private Multimap<Integer,Character> ALPHABET = HashMultimap.create(26,3);


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


    public List<String> lookupNumber(String nums)
    {
        return null;
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
