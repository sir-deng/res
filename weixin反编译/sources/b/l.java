package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class l<T> implements b<T>, Serializable {
    private a<? extends T> ADR;
    private Object ADS = j.ADW;

    public l(a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.ADR = aVar;
    }

    public final T getValue() {
        if (this.ADS == j.ADW) {
            a aVar = this.ADR;
            if (aVar == null) {
                e.cKr();
            }
            this.ADS = aVar.invoke();
            this.ADR = null;
        }
        return this.ADS;
    }

    public final String toString() {
        return (this.ADS != j.ADW ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
