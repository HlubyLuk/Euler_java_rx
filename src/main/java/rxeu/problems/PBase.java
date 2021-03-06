/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import java.io.PrintStream;

/**
 * Common method implementation for problems
 * <p>
 * @author HlubyLuk
 */
public abstract class PBase {

    protected static final PrintStream OUT = System.out;
    private Number result;

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

    public abstract void java();

    public Number run(int type) {
        switch (type % 3) {
            case 0:
                this.jool();
                break;
            case 1:
                this.rxJava();
                break;
            case 2:
                this.java();
                break;
        }
        return this.result;
    }

    /**
     * Print log.
     * <p>
     * @param template of message.
     */
    protected void l(Object template) {
        System.out.printf("Problem %02d, \n" + template + '\n', this.problem());
    }

    /**
     * Print result.
     * <p>
     * @param result number.
     */
    protected void r(Number result) {
        this.result = result;
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
