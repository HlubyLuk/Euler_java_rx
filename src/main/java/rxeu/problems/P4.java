/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.problems;

import io.reactivex.Observable;
import org.jooq.lambda.Seq;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * <p>
 * Answer: 906609
 * <p>
 * @author HlubyLuk
 */
public class P4 extends PBase {

    @Override
    public int problem() {
        return 4;
    }

    @Override
    public void jool() {
        this.r(
                Seq.crossJoin(Seq.range(100, 1000), Seq.range(100, 1000))
                        .map(x -> x.v1 * x.v2).distinct()
                        .filter(x -> true == Seq.of(x)
                        .map(String::valueOf)
                        .map(y -> y.equals(new StringBuilder(y).reverse().toString()))
                        .findFirst().get())
                        .reduce((x, y) -> x > y ? x : y).get()
        );
    }

    @Override
    public void rxJava() {
        Observable.range(100, 900).flatMap(x -> Observable.range(100, 900).map(y -> x * y))
                .distinct()
                .filter(x -> true == Observable.just(x)
                .map(String::valueOf)
                .map(y -> y.equals(new StringBuilder(y).reverse().toString()))
                .blockingFirst().booleanValue())
                .reduce((x, y) -> x > y ? x : y)
                .subscribe(this::r);
    }
}
