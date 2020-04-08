package cloud.mistry.combo;

import java.util.stream.IntStream;


public class StressTest
{
    public static void main(String[] args)
    {
        final Combo combo = new Combo();
        // Do all 1,000,000 combinations of numbers and time it

        long startTime = System.nanoTime();

        // Loop version
//        for( int i=0; i<1_000_000; i++ )
//        {
//            String strNum = String.format("%06d", i);
//            combo.lookupNumber(strNum);
//        }

        // Parallel stream version
        IntStream range = IntStream.range(0, 1_000_000);
        range
            .parallel()
            .forEach( e -> combo.lookupNumber(String.format("%06d", e)));

        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.println(String.format("%n%nRunning all tests took %dms [%ds]", duration/1_000_000, duration/1_000_000_000));
    }
}
