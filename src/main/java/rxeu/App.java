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

    private static final int COUNT = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 3 * COUNT; i += 1) {
            name(i);
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
            run(new P12(), i);
            run(new P13(), i);
            Instant stop = Instant.now();
            System.out.println(Duration.between(start, stop));
        }
    }

    public static void name(int i) {
        switch (i % 3) {
            case 0:
                System.out.println("jool");
                break;
            case 1:
                System.out.println("rx java");
                break;
            case 2:
                System.out.println("java");
                break;
        }
    }

    public static void run(PBase problem, int i) {
        Instant start = Instant.now();
        System.out.printf("Problem->%2d, result->%15d, duration-> %s\n", problem.problem(),
                problem.run(i), Duration.between(start, Instant.now()));
    }
}
