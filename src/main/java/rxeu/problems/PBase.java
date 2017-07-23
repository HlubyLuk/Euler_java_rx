/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import java.io.PrintStream;
import org.jooq.lambda.Seq;

/**
 * Common method implementation for problems
 * <p>
 * @author HlubyLuk
 */
public abstract class PBase {

    protected static final PrintStream OUT = System.out;

    /**
     * Number of solving problem.
     * <p>
     * @return order of problem.
     */
    public abstract int problem();

    /**
     * JOOL implementation.
     */
    public abstract void jool();

    /**
     * RxJava implementation.
     */
    public abstract void rxJava();

    /**
     * Print log.
     * <p>
     * @param template of message.
     */
    protected void l(String template) {
        System.out.printf("Problem %02d, \n" + template + '\n', this.problem());
    }

    /**
     * Print result.
     * <p>
     * @param result number.
     */
    protected void r(Number result) {
        System.out.printf("Problem %02d, result->%d\n", this.problem(), result);
    }

    /**
     * Returns floor(sqrt(x)), for x >= 0.
     * <p>
     * Copy and paste from
     * https://github.com/nayuki/Project-Euler-solutions/blob/master/java/Library.java
     * <p>
     * @param x input.
     * @return output.
     */
    public static int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of negative number");
        }
        int y = 0;
        for (int i = 1 << 15; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x) {
                y ^= i;
            }
        }
        return y;
    }

    /**
     * Returns floor(sqrt(x)), for x >= 0.
     * <p>
     * Copy and paste from
     * https://github.com/nayuki/Project-Euler-solutions/blob/master/java/Library.java
     * <p>
     * @param x input.
     * @return output.
     */
    public static long sqrt(long x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of negative number");
        }
        long y = 0;
        for (long i = 1L << 31; i != 0; i >>>= 1) {
            y |= i;
            if (y > 3037000499L || y * y > x) {
                y ^= i;
            }
        }
        return y;
    }
}
