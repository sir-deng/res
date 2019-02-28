package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class h<T> implements b<T>, Serializable {
    private a<? extends T> ADR;
    private volatile Object ADS;
    private final Object lock;

    public /* synthetic */ h(a aVar) {
        this(aVar, null);
    }

    private h(a<? extends T> aVar, Object obj) {
        e.i(aVar, "initializer");
        this.ADR = aVar;
        this.ADS = j.ADW;
        this.lock = this;
    }

    public final T getValue() {
        T t = this.ADS;
        if (t == j.ADW) {
            synchronized (this.lock) {
                t = this.ADS;
                if (t == j.ADW) {
                    a aVar = this.ADR;
                    if (aVar == null) {
                        e.cKr();
                    }
                    t = aVar.invoke();
                    this.ADS = t;
                    this.ADR = null;
                }
            }
        }
        return t;
    }

    public final String toString() {
        return (this.ADS != j.ADW ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
