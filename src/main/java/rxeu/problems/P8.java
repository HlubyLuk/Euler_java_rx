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

/**
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 ×
 * 9 = 5832.
 * <p>
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * <p>
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What
 * is the value of this product?
 * <p>
 * Answer: 23514624000
 *
 * @author HlubyLuk
 */
public class P8 extends PBase {

    private static final String NUMBER
            = "73167176531330624919225119674426574742355349194934"
            + "96983520312774506326239578318016984801869478851843"
            + "85861560789112949495459501737958331952853208805511"
            + "12540698747158523863050715693290963295227443043557"
            + "66896648950445244523161731856403098711121722383113"
            + "62229893423380308135336276614282806444486645238749"
            + "30358907296290491560440772390713810515859307960866"
            + "70172427121883998797908792274921901699720888093776"
            + "65727333001053367881220235421809751254540594752243"
            + "52584907711670556013604839586446706324415722155397"
            + "53697817977846174064955149290862569321978468622482"
            + "83972241375657056057490261407972968652414535100474"
            + "82166370484403199890008895243450658541227588666881"
            + "16427171479924442928230863465674813919123162824586"
            + "17866458359124566529476545682848912883142607690042"
            + "24219022671055626321111109370544217506941658960408"
            + "07198403850962455444362981230987879927244284909188"
            + "84580156166097919133875499200524063689912560717606"
            + "05886116467109405077541002256983155200055935729725"
            + "71636269561882670428252483600823257530420752963450";

    @Override
    public int problem() {
        return 8;
    }

    @Override
    public void jool() {
        this.r(
                Seq.iterate(Tuple.tuple(0, 13), x -> Tuple.tuple(x.v1 + 1, x.v2 + 1))
                        .limitWhile(x -> x.v2 <= NUMBER.length())
                        .map(x -> Seq.range(x.v1, x.v2))
                        .map(x -> x.map(y -> NUMBER.charAt(y) - '0'))
                        .map(x -> x.map(y -> BigInteger.valueOf(y)))
                        .map(x -> x.reduce((y, z) -> y.multiply(z)).get())
                        .max().get()
        );
    }

    @Override
    public void rxJava() {
        Observable.<Integer, Integer>generate(() -> 0, (x, y) -> {
            y.onNext(x);
            return x + 1;
        })
                .takeWhile(x -> x <= NUMBER.length() - 13)
                .map(x -> Observable.range(x, 13).map(y -> NUMBER.charAt(y) - '0'))
                .map(x -> x.map(y -> BigInteger.valueOf(y)))
                .map(x -> x.reduce((a, b) -> a.multiply(b)).blockingGet())
                .map(x -> x.longValue())
                .reduce((x, y) -> x > y ? x : y)
                .subscribe(this::r);
    }

    @Override
    public void java() {
        BigInteger a = BigInteger.ZERO;
        for (int i = 0; i < NUMBER.length() - 13; i += 1) {
            BigInteger b = BigInteger.ONE;
            for (int j = 0; j < 13; j += 1) {
                b = b.multiply(BigInteger.valueOf(NUMBER.charAt(i + j) - '0'));
            }
            if (a.compareTo(b) == -1) {
                a = b;
            }
        }
        this.r(a);
    }
}
