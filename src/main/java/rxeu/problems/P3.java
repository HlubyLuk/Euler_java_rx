/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;
import rxeu.entity.Tup2;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143?
 * <p>
 * Answer: 6857
 * <p>
 * @author HlubyLuk
 */
public class P3 extends PBase {

    private static final long NUMBER = 600851475143l;

    @Override
    public int problem() {
        return 3;
    }

    @Override
    public void jool() {
        this.r(
                Seq.iterate(new Tuple2<>(NUMBER, sqrt(NUMBER)), f -> new Tuple2<>(f.v1, f.v2 - 1))
                        .filter(x -> x.v1 % x.v2 == 0)
                        .limitWhile(x -> x.v2 > 1)
                        .map(x -> x.v2)
                        .filter(x -> Seq.range(2, sqrt(x)).allMatch(y -> x % y != 0))
                        .findFirst()
                        .get()
        );
    }

    @Override
    public void rxJava() {
        Observable.<Tup2<Long, Long>, Tup2<Long, Long>>generate(() -> new Tup2<>(NUMBER, sqrt(NUMBER)),
                (x, y) -> {
                    y.onNext(x);
                    return new Tup2<>(x.a, x.b - 1);
                })
                .takeWhile(x -> x.b > 1)
                .filter(x -> x.a % x.b == 0)
                .map(x -> x.b)
                .filter(x -> Observable.rangeLong(2, sqrt(x)).all(y -> x % y != 0).blockingGet())
                .reduce((x, y) -> x > y ? x : y)
                .subscribe(this::r);
    }
}
