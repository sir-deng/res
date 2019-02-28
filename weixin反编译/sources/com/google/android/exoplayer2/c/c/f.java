package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class f implements h {
    private final String ael;
    private Format aeo;
    private long aig;
    private k alW;
    private final j amL = new j(new byte[15]);
    private int amN;
    private long amP;
    private String amW;
    private int ane;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.amL.data[0] = Byte.MAX_VALUE;
        this.amL.data[1] = (byte) -2;
        this.amL.data[2] = Byte.MIN_VALUE;
        this.amL.data[3] = (byte) 1;
        this.state = 0;
        this.ael = str;
    }

    public final void jy() {
        this.state = 0;
        this.amN = 0;
        this.ane = 0;
    }

    public final void a(com.google.android.exoplayer2.c.f fVar, d dVar) {
        dVar.jG();
        this.amW = dVar.jI();
        this.alW = fVar.ck(dVar.jH());
    }

    public final void c(long j, boolean z) {
        this.aig = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j r10) {
        /*
        r9 = this;
        r8 = 15;
        r4 = 1;
        r6 = 0;
    L_0x0004:
        r0 = r10.lG();
        if (r0 <= 0) goto L_0x00d1;
    L_0x000a:
        r0 = r9.state;
        switch(r0) {
            case 0: goto L_0x0010;
            case 1: goto L_0x0039;
            case 2: goto L_0x009f;
            default: goto L_0x000f;
        };
    L_0x000f:
        goto L_0x0004;
    L_0x0010:
        r0 = r10.lG();
        if (r0 <= 0) goto L_0x0037;
    L_0x0016:
        r0 = r9.ane;
        r0 = r0 << 8;
        r9.ane = r0;
        r0 = r9.ane;
        r1 = r10.readUnsignedByte();
        r0 = r0 | r1;
        r9.ane = r0;
        r0 = r9.ane;
        r1 = 2147385345; // 0x7ffe8001 float:NaN double:1.0609493273E-314;
        if (r0 != r1) goto L_0x0010;
    L_0x002c:
        r9.ane = r6;
        r0 = r4;
    L_0x002f:
        if (r0 == 0) goto L_0x0004;
    L_0x0031:
        r0 = 4;
        r9.amN = r0;
        r9.state = r4;
        goto L_0x0004;
    L_0x0037:
        r0 = r6;
        goto L_0x002f;
    L_0x0039:
        r0 = r9.amL;
        r0 = r0.data;
        r1 = r10.lG();
        r2 = r9.amN;
        r2 = 15 - r2;
        r1 = java.lang.Math.min(r1, r2);
        r2 = r9.amN;
        r10.readBytes(r0, r2, r1);
        r0 = r9.amN;
        r0 = r0 + r1;
        r9.amN = r0;
        r0 = r9.amN;
        if (r0 != r8) goto L_0x009d;
    L_0x0057:
        r0 = r4;
    L_0x0058:
        if (r0 == 0) goto L_0x0004;
    L_0x005a:
        r0 = r9.amL;
        r0 = r0.data;
        r1 = r9.aeo;
        if (r1 != 0) goto L_0x0073;
    L_0x0062:
        r1 = r9.amW;
        r2 = r9.ael;
        r1 = com.google.android.exoplayer2.a.h.a(r0, r1, r2);
        r9.aeo = r1;
        r1 = r9.alW;
        r2 = r9.aeo;
        r1.f(r2);
    L_0x0073:
        r1 = com.google.android.exoplayer2.a.h.g(r0);
        r9.sampleSize = r1;
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r0 = com.google.android.exoplayer2.a.h.f(r0);
        r0 = (long) r0;
        r0 = r0 * r2;
        r2 = r9.aeo;
        r2 = r2.sampleRate;
        r2 = (long) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r0 = (long) r0;
        r9.amP = r0;
        r0 = r9.amL;
        r0.cR(r6);
        r0 = r9.alW;
        r1 = r9.amL;
        r0.a(r1, r8);
        r0 = 2;
        r9.state = r0;
        goto L_0x0004;
    L_0x009d:
        r0 = r6;
        goto L_0x0058;
    L_0x009f:
        r0 = r10.lG();
        r1 = r9.sampleSize;
        r2 = r9.amN;
        r1 = r1 - r2;
        r0 = java.lang.Math.min(r0, r1);
        r1 = r9.alW;
        r1.a(r10, r0);
        r1 = r9.amN;
        r0 = r0 + r1;
        r9.amN = r0;
        r0 = r9.amN;
        r1 = r9.sampleSize;
        if (r0 != r1) goto L_0x0004;
    L_0x00bc:
        r1 = r9.alW;
        r2 = r9.aig;
        r5 = r9.sampleSize;
        r7 = 0;
        r1.a(r2, r4, r5, r6, r7);
        r0 = r9.aig;
        r2 = r9.amP;
        r0 = r0 + r2;
        r9.aig = r0;
        r9.state = r6;
        goto L_0x0004;
    L_0x00d1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.f.b(com.google.android.exoplayer2.i.j):void");
    }

    public final void jz() {
    }
}
