/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import java.math.BigInteger;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple;
import rxeu.entity.Tup2;

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

    private static final int STOP = 2000000;

    @Override
    public int problem() {
        return 10;
    }

    @Override
    public void jool() {
        this.r(Seq.iterate(Tuple.tuple(2, BigInteger.ZERO), a -> {
            for (int i = 2; i * i <= a.v1; i += 1) {
                if (a.v1 % i == 0) {
                    return Tuple.tuple(a.v1 + 1, a.v2);
                }
            }
            return Tuple.tuple(a.v1 + 1, a.v2.add(BigInteger.valueOf(a.v1)));
        }).skip(STOP - 1).limit(1).findAny().get().v2);
    }

    @Override
    public void rxJava() {
        Observable.<BigInteger, Tup2<Integer, BigInteger>>generate(()
                -> new Tup2<>(2, BigInteger.ZERO), (a, b) -> {
            b.onNext(a.b);
            for (int i = 2; i * i <= a.a; i += 1) {
                if (a.a % i == 0) {
                    return new Tup2<>(a.a + 1, a.b);
                }
            }
            return new Tup2<>(a.a + 1, a.b.add(BigInteger.valueOf(a.a)));
        }).skip(STOP - 1).take(1).subscribe(this::r);
    }

    @Override
    public void java() {
        int a = 1;
        BigInteger b = BigInteger.ZERO;
        while (a < STOP) {
            a += 1;
            boolean add = true;
            for (int i = 2; i * i < a + 1; i += 1) {
                add &= a % i != 0;
                if (!add) {
                    break;
                }
            }
            if (add) {
                b = b.add(BigInteger.valueOf(a));
            }
        }
        this.r(b);
    }
}
