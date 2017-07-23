/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.entity;

import java.util.Objects;

/**
 * Wrap 2 same objects.
 * <p>
 * @author HlubyLuk
 */
public class Same2<T> {

    public final T a, b;

    public Same2(T a, T b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.a);
        hash = 67 * hash + Objects.hashCode(this.b);
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
        final Same2<?> other = (Same2<?>) obj;
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
        return "Same2{" + "a=" + a + ", b=" + b + '}';
    }
}
