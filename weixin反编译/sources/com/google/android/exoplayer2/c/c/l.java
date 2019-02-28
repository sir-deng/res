package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class l implements h {
    private k alW;
    private boolean anh;
    private long anj;
    private final j aop = new j(10);
    private int aoq;
    private int sampleSize;

    public final void jy() {
        this.anh = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.jG();
        this.alW = fVar.ck(dVar.jH());
        this.alW.f(Format.g(dVar.jI(), "application/id3"));
    }

    public final void c(long j, boolean z) {
        if (z) {
            this.anh = true;
            this.anj = j;
            this.sampleSize = 0;
            this.aoq = 0;
        }
    }

    public final void b(j jVar) {
        if (this.anh) {
            int lG = jVar.lG();
            if (this.aoq < 10) {
                int min = Math.min(lG, 10 - this.aoq);
                System.arraycopy(jVar.data, jVar.position, this.aop.data, this.aoq, min);
                if (min + this.aoq == 10) {
                    this.aop.cR(0);
                    if (73 == this.aop.readUnsignedByte() && 68 == this.aop.readUnsignedByte() && 51 == this.aop.readUnsignedByte()) {
                        this.aop.cV(3);
                        this.sampleSize = this.aop.lI() + 10;
                    } else {
                        this.anh = false;
                        return;
                    }
                }
            }
            lG = Math.min(lG, this.sampleSize - this.aoq);
            this.alW.a(jVar, lG);
            this.aoq = lG + this.aoq;
        }
    }

    public final void jz() {
        if (this.anh && this.sampleSize != 0 && this.aoq == this.sampleSize) {
            this.alW.a(this.anj, 1, this.sampleSize, 0, null);
            this.anh = false;
        }
    }
}
