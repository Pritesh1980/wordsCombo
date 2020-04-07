package cloud.mistry.combo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ComboRunner
{
    public static void main(String[] args)
    {
        // AWS CodeGuru profiler
//        System.setProperty("aws.region", "eu-west-1");
//        new Profiler.Builder()
//                .profilingGroupName("JavaWordsComboProfileGroup")
//                .build()
//                .start();

        SpringApplication.run(ComboRunner.class, args);

//        System.out.println("Starting Word Combination Analysis\n");

//        final Combo myCombo = new Combo();
//        final String myWord = "RANDOM";
//        final String myNumber = "813358";
//
//
//        System.out.println( "\nPerform lookup on a word: " +myWord );
//        System.out.println( myCombo.lookupWord(myWord) );
//
//        System.out.println( "\nPerform lookup on a number: " +myNumber );
//        System.out.println( myCombo.lookupNumber(myNumber) );

    }
}
