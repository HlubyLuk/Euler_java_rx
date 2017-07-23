/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import java.math.BigInteger;
import org.jooq.lambda.Seq;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 * <p>
 * Answer: 142913828922
 * <p>
 * @author HlubyLuk
 */
public class P10 extends PBase {

    @Override
    public int problem() {
        return 10;
    }

    @Override
    public void jool() {
        this.r(
                Seq.iterate(3, f -> f + 2)
                        .filter(x -> Seq.range(2, sqrt(x) + 1).allMatch(y -> x % y != 0))
                        .limitWhile(x -> x < 2000000)
                        .map(BigInteger::valueOf)
                        .reduce((x, y) -> x.add(y)).get().add(BigInteger.valueOf(2))
        );
    }

    @Override
    public void rxJava() {
        this.r(
                Observable.<Integer, Integer>generate(() -> 3, (x, y) -> {
                    y.onNext(x);
                    return x + 1;
                }).filter(x -> Observable.range(1, x).skip(1).take(sqrt(x))
                .all(y -> x % y != 0).blockingGet())
                        .takeWhile(x -> x < 2000000)
                        .map(BigInteger::valueOf)
                        .reduce((x, y) -> x.add(y))
                        .blockingGet().add(BigInteger.valueOf(2))
        );
    }

}
