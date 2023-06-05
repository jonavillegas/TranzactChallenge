package bdd;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

class LabsTest {


    @Test
    void pruebasParalelas() {
        Results results =
                Runner.path("classpath:bdd/feature")
                        .outputCucumberJson(true)
                        .parallel(2);
    }


}