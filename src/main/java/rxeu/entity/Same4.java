/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.entity;

import java.util.Objects;

/**
 * Wrap 4 objects;
 * <p>
 * @author HlubyLuk
 */
public class Same4<T> {

    public final T a, b, c, d;

    public Same4(T a, T b, T c, T d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.a);
        hash = 67 * hash + Objects.hashCode(this.b);
        hash = 67 * hash + Objects.hashCode(this.c);
        hash = 67 * hash + Objects.hashCode(this.d);
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
        final Same4<?> other = (Same4<?>) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        if (!Objects.equals(this.d, other.d)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Same4{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + '}';
    }
}
