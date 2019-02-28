package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.w;

public interface f {

    public static final class b {
        public static final b arR = new b(-1, -1, -1);
        public final int arS;
        public final int arT;
        public final int arU;

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.arS = i;
            this.arT = i2;
            this.arU = i3;
        }

        public final b cA(int i) {
            return this.arS == i ? this : new b(i, this.arT, this.arU);
        }

        public final boolean kg() {
            return this.arT != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.arS == bVar.arS && this.arT == bVar.arT && this.arU == bVar.arU) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ((((this.arS + 527) * 31) + this.arT) * 31) + this.arU;
        }
    }

    public interface a {
        void a(w wVar, Object obj);
    }

    e a(b bVar, com.google.android.exoplayer2.h.b bVar2);

    void a(a aVar);

    void b(e eVar);

    void ke();

    void kf();
}
