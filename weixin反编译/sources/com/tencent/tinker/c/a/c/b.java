package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;

public final class b {
    final a AqU;

    private final class a extends e {
        a(e eVar) {
            super(eVar);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j) {
            super.a(i, i2, fS(i3, i4), i4, i5, j);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.a(i, i2, fS(i3, i4), i4, i5, j, i6);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.a(i, i2, fS(i3, i4), i4, i5, j, i6, i7);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.a(i, i2, fS(i3, i4), i4, i5, j, i6, i7, i8);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.a(i, i2, fS(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.a(i, i2, fS(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.b(i, i2, fS(i3, i4), i4, i5, j, i6, i7);
        }

        private int fS(int i, int i2) {
            switch (i2) {
                case 2:
                    return b.this.AqU.IW(i);
                case 3:
                    return b.this.AqU.IV(i);
                case 4:
                    return b.this.AqU.IZ(i);
                case 5:
                    return b.this.AqU.IY(i);
                default:
                    return i;
            }
        }
    }

    public b(a aVar) {
        this.AqU = aVar;
    }

    public final short[] a(short[] sArr) {
        com.tencent.tinker.a.b.a.a hVar = new h(sArr.length);
        e cVar = new c();
        e fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(cVar));
            dVar.a(new a(fVar));
            int i = hVar.Apj;
            if (i == hVar.Apr.length) {
                return hVar.Apr;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.Apr, 0, sArr2, 0, i);
            return sArr2;
        } catch (Throwable e) {
            throw new j(e);
        }
    }
}
