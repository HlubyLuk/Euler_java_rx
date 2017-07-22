/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is
 * 13.
 * <p>
 * What is the 10 001st prime number?
 * <p>
 * Answer: 104743
 * <p>
 * @author HlubyLuk
 */
public class P7 extends PBase {

    @Override
    public int problem() {
        return 7;
    }

    @Override
    public void jool() {
        this.r(
                Seq.iterate(1, x -> x + 1)
                        .filter(x -> Seq.range(2, sqrt(x) + 1).allMatch(y -> x % y != 0))
                        .take(10002)
                        .findLast().get()
        );
    }

    @Override
    public void rxJava() {
        this.r(
                Observable.<Integer, Integer>generate(
                        () -> 1,
                        (x, y) -> {
                            y.onNext(x);
                            return x + 1;
                        }
                ).filter(x -> Observable.range(1, x)
                        .skip(1)
                        .takeWhile(y -> y * y < x + 1)
                        .all(y -> x % y != 0)
                        .blockingGet()
                ).take(10002).lastElement().blockingGet()
        );
    }
}
