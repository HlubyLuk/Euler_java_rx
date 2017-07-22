/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.entity;

/**
 * Fibonacci sequence element holder.
 * <p>
 * @author HlubyLuk
 */
public class Fib extends Tup<Integer, Integer> {

    public Fib() {
        super(1, 2);
    }

    public Fib(int a, int b) {
        super(a, b);
    }
}
