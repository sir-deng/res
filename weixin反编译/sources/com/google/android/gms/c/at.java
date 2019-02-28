package com.google.android.gms.c;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class at {

    public static class a {
        public final Map<String, com.google.android.gms.c.b.a> aZm;
        public final com.google.android.gms.c.b.a aZn;

        public final String toString() {
            return "Properties: " + Collections.unmodifiableMap(this.aZm) + " pushAfterEvaluate: " + this.aZn;
        }
    }

    public static class b {
        public final List<a> aZo;
        public final List<a> aZp;
        public final List<a> aZq;
        public final List<a> aZr;
        private final List<a> aZs;
        private final List<a> aZt;

        public final String toString() {
            return "Positive predicates: " + this.aZo + "  Negative predicates: " + this.aZp + "  Add tags: " + this.aZq + "  Remove tags: " + this.aZr + "  Add macros: " + this.aZs + "  Remove macros: " + this.aZt;
        }
    }

    public static com.google.android.gms.c.b.a a(com.google.android.gms.c.b.a aVar) {
        com.google.android.gms.c.b.a aVar2 = new com.google.android.gms.c.b.a();
        aVar2.type = aVar.type;
        aVar2.aWk = (int[]) aVar.aWk.clone();
        if (aVar.aWl) {
            aVar2.aWl = aVar.aWl;
        }
        return aVar2;
    }
}
