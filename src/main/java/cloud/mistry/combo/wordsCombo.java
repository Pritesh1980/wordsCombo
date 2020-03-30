package cloud.mistry.combo;

public class wordsCombo
{

    public static void main(String[] args)
    {
        System.out.println("Starting Word Combination Analysis\n");

        final Combo myCombo = new Combo();
        final String myWord = "RANDOM";
        final String myNumber = "813358";

        System.out.println( "Perform lookup on a word: " +myWord );
        System.out.println( myCombo.lookupWord(myWord) );


        System.out.println( "\nPerform lookup on a number: " +myNumber );
        System.out.println( myCombo.lookupNumber(myNumber) );

    }
}
