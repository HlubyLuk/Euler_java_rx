/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.entity;

import java.util.Objects;

/**
 *
 * @author HlubyLuk
 */
public class Tup2<A, B> {

    public final A a;
    public final B b;

    public Tup2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.a);
        hash = 97 * hash + Objects.hashCode(this.b);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tup2<?, ?> other = (Tup2<?, ?>) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tup{" + "a=" + a + ", b=" + b + '}';
    }

}
