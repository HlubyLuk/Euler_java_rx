/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rxeu.entity;

import java.util.Objects;

/**
 * Wrap three same object.
 * <p>
 * @author HlubyLuk
 */
public class Same3<T> {

    public final T a, b, c;

    public Same3(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.a);
        hash = 97 * hash + Objects.hashCode(this.b);
        hash = 97 * hash + Objects.hashCode(this.c);
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
        final Same3<?> other = (Same3<?>) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Same3{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
}
