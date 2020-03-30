package cloud.mistry.combo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Combo
{
    private static final Logger logger = LogManager.getLogger("Combo");
    private final int CHARS_IN_ALPHABET = 26;
    private Multimap<Integer,Character> ALPHABET = HashMultimap.create(26,3);


    public Combo()
    {
        initialiseAlphabet();
        logger.debug("Alphabet: " +ALPHABET);
    }



    public Object lookupWord(String word) {
        return null;
    }

    public List<String> lookupNumber(String nums)
    {
        return null;
    }


    private void initialiseAlphabet()
    {
        Character aChar = new Character('A');
        Integer currCount = 1;

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
