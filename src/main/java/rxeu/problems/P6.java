/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple;
import rxeu.entity.Tup2;

/**
 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ... + 102 = 385
 * <p>
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the
 * square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and
 * the square of the sum.
 * <p>
 * Answer: 25164150
 *
 * @author HlubyLuk
 */
public class P6 extends PBase {

    @Override
    public int problem() {
        return 6;
    }

    @Override
    public void jool() {
        this.r(
                Seq.range(1, 101).zip(Seq.range(1, 101).map(x -> x * x))
                        .reduce((x, y) -> Tuple.tuple(x.v1 + y.v1, x.v2 + y.v2))
                        .map(x -> x.v1 * x.v1 - x.v2)
                        .get()
        );
    }

    @Override
    public void rxJava() {
        Observable.zip(Observable.range(1, 100),
                Observable.range(1, 100).map(z -> z * z),
                (x, y) -> new Tup2<>(x, y))
                .reduce((x, y) -> new Tup2<>(x.a + y.a, x.b + y.b))
                .map(x -> x.a * x.a - x.b)
                .subscribe(this::r);
    }

    @Override
    public void java() {
        int x = 0, y = 0;
        for (int i = 1; i < 101; i += 1) {
            x += i * i;
        }
        for (int i = 1; i < 101; i += 1) {
            y += i;
        }
        this.r(y * y - x);
    }
}
