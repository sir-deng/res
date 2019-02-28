package b.c.b;

import b.c.a;
import b.e.b;

public final class c implements b, b<Object> {
    private final Class<?> AEb;

    public c(Class<?> cls) {
        e.i(cls, "jClass");
        this.AEb = cls;
    }

    public final Class<?> cKq() {
        return this.AEb;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && e.h(a.a(this), a.a((b) obj));
    }

    public final int hashCode() {
        return a.a(this).hashCode();
    }

    public final String toString() {
        return this.AEb.toString() + " (Kotlin reflection is not available)";
    }
}
