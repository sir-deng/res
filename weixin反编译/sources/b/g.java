package b;

import b.c.b.e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class g<T> implements b<T>, Serializable {
    private static final AtomicReferenceFieldUpdater<g<?>, Object> ADU = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "ADS");
    public static final a ADV = new a();
    private b.c.a.a<? extends T> ADR;
    private volatile Object ADS = j.ADW;
    private final Object ADT = j.ADW;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(b.c.a.a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.ADR = aVar;
    }

    public final T getValue() {
        if (this.ADS == j.ADW) {
            b.c.a.a aVar = this.ADR;
            if (aVar != null) {
                if (ADU.compareAndSet(this, j.ADW, aVar.invoke())) {
                    this.ADR = null;
                }
            }
        }
        return this.ADS;
    }

    public final String toString() {
        return (this.ADS != j.ADW ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
