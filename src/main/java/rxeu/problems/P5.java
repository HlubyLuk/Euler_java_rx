/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.math.BigInteger;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple;
import rxeu.entity.Tup;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any
 * remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * <p>
 * Answer: 232792560
 * <p>
 * @author HlubyLuk
 */
public class P5 extends PBase {

    @Override
    public int problem() {
        return 5;
    }

    @Override
    public void jool() {
        this.r(
                Seq.iterate(
                        Tuple.tuple(BigInteger.ONE, BigInteger.ONE),
                        f -> Tuple.tuple(
                                f.v1.add(BigInteger.ONE),
                                f.v1.divide(f.v1.gcd(f.v2)).multiply(f.v2))
                ).limit(20).findLast().get().v2
        );
    }

    @Override
    public void rxJava() {
        this.r((Number) Observable.<BigInteger, Tup<BigInteger, BigInteger>>generate(
                () -> new Tup<>(BigInteger.ONE, BigInteger.ONE),
                (x, y) -> {
                    y.onNext(x.b);
                    return new Tup(x.a.add(BigInteger.ONE), x.a.divide(x.a.gcd(x.b)).multiply(x.b));
                }).take(20)
                .last(1).blockingGet()
        );

    }

//@Override
//public void jool() {
//this.r(
//Seq.of(Seq.iterate(1, x -> x + 1).limitWhileClosed(x -> Seq.range(2, 21)
//.anyMatch(y -> x % y != 0))
//.findLast().get() + 1).findFirst().get()
//);
//}
//@Override
//public void rxJava() {
//    Single.just(Observable.<Integer, Integer>generate(() -> 2, (x, y) -> {
//        y.onNext(x);
//        return x + 1;
//    })
//            .takeWhile(x -> Observable.range(2, 19)
//            .any(y -> x % y != 0).blockingGet())
//            .lastElement().blockingGet() + 1)
//            .subscribe(this::r);
//}
}
