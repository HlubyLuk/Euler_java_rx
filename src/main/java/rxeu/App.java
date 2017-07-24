package rxeu;

import java.time.Duration;
import java.time.Instant;
import rxeu.problems.*;

/**
 * Problem runner
 * <p>
 * <a target="https://projecteuler.net/">Project euler</a>
 * <p>
 * @author HlubyLuk
 */
public class App {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i += 1) {
            System.out.printf("%s\n", i % 2 == 0 ? "jool" : "rxjava");
            Instant start = Instant.now();
            run(new P1(), i);
            run(new P2(), i);
            run(new P3(), i);
            run(new P4(), i);
            run(new P5(), i);
            run(new P6(), i);
            run(new P7(), i);
            run(new P8(), i);
            run(new P9(), i);
            run(new P10(), i);
            run(new P11(), i);
            Instant stop = Instant.now();
            System.out.println(Duration.between(start, stop));
        }
    }

    public static void run(PBase problem, int i) {
        if (i % 2 == 0) {
            problem.jool();
        } else {
            problem.rxJava();
        }
    }
}
