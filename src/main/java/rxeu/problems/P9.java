/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple;
import rxeu.entity.Same3;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
 * <p>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 * <p>
 * Answer: 31875000
 * <p>
 * @author HlubyLuk
 */
public class P9 extends PBase {

    private static final int STOP = 500;

    @Override
    public int problem() {
        return 9;
    }

    @Override
    public void jool() {
        this.r(Seq.crossJoin(Seq.range(1, STOP), Seq.range(1, STOP))
                .map(x -> Tuple.tuple(x.v1, x.v2, 1000 - x.v1 - x.v2))
                .findFirst(x -> x.v1 * x.v1 + x.v2 * x.v2 == x.v3 * x.v3)
                .map(x -> x.v1 * x.v2 * x.v3)
                .get());
    }

    @Override
    public void rxJava() {
        Observable.range(1, STOP)
                .flatMap(x -> Observable.range(1, STOP).map(y -> new Same3<>(x, y, 1000 - x - y)))
                .filter(x -> x.a * x.a + x.b * x.b == x.c * x.c)
                .take(1)
                .map(x -> x.a * x.b * x.c)
                .subscribe(this::r);
    }

    @Override
    public void java() {
//        int a = Integer.MIN_VALUE;
//        for (int i = 1; i < STOP; i += 1) {
//            for (int j = 1; j < STOP; j += 1) {
//                for (int k = 1; k < STOP; k += 1) {
//                    if (i * i + j * j == k * k && i + j + k == 1000) {
//                        a = i * j * k;
//                        break;
//                    }
//                }
//                if (a != Integer.MIN_VALUE) {
//                    break;
//                }
//            }
//            if (a != Integer.MIN_VALUE) {
//                break;
//            }
//        }
//        this.r(a);
        for (int a = 1; a < STOP; a += 1) {
            for (int b = 1, c = 0; b < STOP; b += 1, c = 1000 - a - b) {
                if (a * a + b * b == c * c) {
                    this.r(a * b * c);
                    return;
                }
            }
        }
    }
}
