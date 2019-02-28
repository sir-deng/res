package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class s implements p {
    private q alA;
    private k alW;
    private boolean aoM;

    public final void a(q qVar, f fVar, d dVar) {
        this.alA = qVar;
        dVar.jG();
        this.alW = fVar.ck(dVar.jH());
        this.alW.f(Format.g(dVar.jI(), "application/x-scte35"));
    }

    public final void b(j jVar) {
        long j = -9223372036854775807L;
        if (!this.aoM) {
            if (this.alA.lR() != -9223372036854775807L) {
                this.alW.f(Format.b("application/x-scte35", this.alA.lR()));
                this.aoM = true;
            } else {
                return;
            }
        }
        int lG = jVar.lG();
        this.alW.a(jVar, lG);
        k kVar = this.alW;
        q qVar = this.alA;
        if (qVar.aCH != -9223372036854775807L) {
            j = qVar.aCH;
        } else if (qVar.amG != Long.MAX_VALUE) {
            j = qVar.amG;
        }
        kVar.a(j, 1, lG, 0, null);
    }
}
