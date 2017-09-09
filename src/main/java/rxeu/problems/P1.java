/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * <p>
 * Answer: 233168
 * <p>
 * @author HlubyLuk
 */
public class P1 extends PBase {

    private static final int START = 1, STOP = 1000;

    @Override
    public int problem() {
        return 1;
    }

    @Override
    public void jool() {
        this.r(
                Seq.range(START, STOP)
                        .filter(x -> x % 3 == 0 || x % 5 == 0)
                        .sum()
                        .get()
        );
    }

    @Override
    public void rxJava() {
        Observable.range(START, STOP)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .reduce((x, y) -> x + y)
                .subscribe(this::r);
    }

    @Override
    public void java() {
        int ret = 0;
        for (int i = START; i < STOP; i += 1) {
            if (i % 3 == 0 || i % 5 == 0) {
                ret += i;
            }
        }
        this.r(ret);
    }
}
