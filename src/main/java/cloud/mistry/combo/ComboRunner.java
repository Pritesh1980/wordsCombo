package cloud.mistry.combo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.codeguruprofilerjavaagent.Profiler;

@SpringBootApplication
public class ComboRunner
{
    public static void main(String[] args)
    {
        // AWS CodeGuru profiler
        System.setProperty("aws.region", "eu-west-1");

        new Profiler.Builder()
                .profilingGroupName("WordsCombo-ProfilingGroup")
                .build()
                .start();

        SpringApplication.run(ComboRunner.class, args);

    }
}
