package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.b;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;

public final class j implements h {
    private k alW;
    private String amW;
    private final n anA = new n(7);
    private final n anB = new n(8);
    private final n anC = new n(6);
    private a anD;
    private final com.google.android.exoplayer2.i.j anE = new com.google.android.exoplayer2.i.j();
    private boolean ana;
    private final boolean[] anm = new boolean[3];
    private long ano;
    private long anq;
    private final r anx;
    private final boolean any;
    private final boolean anz;

    private static final class a {
        final k alW;
        final SparseArray<b> anF = new SparseArray();
        final SparseArray<com.google.android.exoplayer2.i.h.a> anG = new SparseArray();
        final com.google.android.exoplayer2.i.k anH = new com.google.android.exoplayer2.i.k(this.buffer, 0, 0);
        int anI;
        int anJ;
        long anK;
        long anL;
        a anM = new a();
        a anN = new a();
        boolean anO;
        long anj;
        long anr;
        boolean ans;
        boolean anv;
        final boolean any;
        final boolean anz;
        byte[] buffer = new byte[FileUtils.S_IWUSR];

        private static final class a {
            boolean anP;
            boolean anQ;
            b anR;
            int anS;
            int anT;
            int anU;
            int anV;
            boolean anW;
            boolean anX;
            boolean anY;
            boolean anZ;
            int aoa;
            int aob;
            int aoc;
            int aod;
            int aoe;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }

            public final void clear() {
                this.anQ = false;
                this.anP = false;
            }
        }

        public a(k kVar, boolean z, boolean z2) {
            this.alW = kVar;
            this.any = z;
            this.anz = z2;
            reset();
        }

        public final void a(b bVar) {
            this.anF.append(bVar.aCh, bVar);
        }

        public final void a(com.google.android.exoplayer2.i.h.a aVar) {
            this.anG.append(aVar.anV, aVar);
        }

        public final void reset() {
            this.anv = false;
            this.anO = false;
            this.anN.clear();
        }
    }

    public j(r rVar, boolean z, boolean z2) {
        this.anx = rVar;
        this.any = z;
        this.anz = z2;
    }

    public final void jy() {
        h.a(this.anm);
        this.anA.reset();
        this.anB.reset();
        this.anC.reset();
        this.anD.reset();
        this.ano = 0;
    }

    public final void a(f fVar, d dVar) {
        dVar.jG();
        this.amW = dVar.jI();
        this.alW = fVar.ck(dVar.jH());
        this.anD = new a(this.alW, this.any, this.anz);
        this.anx.a(fVar, dVar);
    }

    public final void c(long j, boolean z) {
        this.anq = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j r22) {
        /*
        r21 = this;
        r0 = r22;
        r2 = r0.position;
        r0 = r22;
        r10 = r0.asN;
        r0 = r22;
        r11 = r0.data;
        r0 = r21;
        r4 = r0.ano;
        r3 = r22.lG();
        r6 = (long) r3;
        r4 = r4 + r6;
        r0 = r21;
        r0.ano = r4;
        r0 = r21;
        r3 = r0.alW;
        r4 = r22.lG();
        r0 = r22;
        r3.a(r0, r4);
    L_0x0027:
        r0 = r21;
        r3 = r0.anm;
        r12 = com.google.android.exoplayer2.i.h.a(r11, r2, r10, r3);
        if (r12 != r10) goto L_0x0037;
    L_0x0031:
        r0 = r21;
        r0.e(r11, r2, r10);
        return;
    L_0x0037:
        r13 = com.google.android.exoplayer2.i.h.i(r11, r12);
        r3 = r12 - r2;
        if (r3 <= 0) goto L_0x0044;
    L_0x003f:
        r0 = r21;
        r0.e(r11, r2, r12);
    L_0x0044:
        r9 = r10 - r12;
        r0 = r21;
        r4 = r0.ano;
        r6 = (long) r9;
        r14 = r4 - r6;
        if (r3 >= 0) goto L_0x02d0;
    L_0x004f:
        r2 = -r3;
        r8 = r2;
    L_0x0051:
        r0 = r21;
        r0 = r0.anq;
        r16 = r0;
        r0 = r21;
        r2 = r0.ana;
        if (r2 == 0) goto L_0x0065;
    L_0x005d:
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.anz;
        if (r2 == 0) goto L_0x011c;
    L_0x0065:
        r0 = r21;
        r2 = r0.anA;
        r2.cx(r8);
        r0 = r21;
        r2 = r0.anB;
        r2.cx(r8);
        r0 = r21;
        r2 = r0.ana;
        if (r2 != 0) goto L_0x02d4;
    L_0x0079:
        r0 = r21;
        r2 = r0.anA;
        r2 = r2.aow;
        if (r2 == 0) goto L_0x011c;
    L_0x0081:
        r0 = r21;
        r2 = r0.anB;
        r2 = r2.aow;
        if (r2 == 0) goto L_0x011c;
    L_0x0089:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r0 = r21;
        r2 = r0.anA;
        r2 = r2.aox;
        r0 = r21;
        r3 = r0.anA;
        r3 = r3.aoy;
        r2 = java.util.Arrays.copyOf(r2, r3);
        r6.add(r2);
        r0 = r21;
        r2 = r0.anB;
        r2 = r2.aox;
        r0 = r21;
        r3 = r0.anB;
        r3 = r3.aoy;
        r2 = java.util.Arrays.copyOf(r2, r3);
        r6.add(r2);
        r0 = r21;
        r2 = r0.anA;
        r2 = r2.aox;
        r3 = 3;
        r0 = r21;
        r4 = r0.anA;
        r4 = r4.aoy;
        r18 = com.google.android.exoplayer2.i.h.j(r2, r3, r4);
        r0 = r21;
        r2 = r0.anB;
        r2 = r2.aox;
        r0 = r21;
        r3 = r0.anB;
        r3 = r3.aoy;
        r19 = com.google.android.exoplayer2.i.h.k(r2, r3);
        r0 = r21;
        r0 = r0.alW;
        r20 = r0;
        r0 = r21;
        r2 = r0.amW;
        r3 = "video/avc";
        r0 = r18;
        r4 = r0.width;
        r0 = r18;
        r5 = r0.height;
        r0 = r18;
        r7 = r0.aCj;
        r2 = com.google.android.exoplayer2.Format.a(r2, r3, r4, r5, r6, r7);
        r0 = r20;
        r0.f(r2);
        r2 = 1;
        r0 = r21;
        r0.ana = r2;
        r0 = r21;
        r2 = r0.anD;
        r0 = r18;
        r2.a(r0);
        r0 = r21;
        r2 = r0.anD;
        r0 = r19;
        r2.a(r0);
        r0 = r21;
        r2 = r0.anA;
        r2.reset();
        r0 = r21;
        r2 = r0.anB;
        r2.reset();
    L_0x011c:
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.cx(r8);
        if (r2 == 0) goto L_0x0158;
    L_0x0126:
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aox;
        r0 = r21;
        r3 = r0.anC;
        r3 = r3.aoy;
        r2 = com.google.android.exoplayer2.i.h.h(r2, r3);
        r0 = r21;
        r3 = r0.anE;
        r0 = r21;
        r4 = r0.anC;
        r4 = r4.aox;
        r3.l(r4, r2);
        r0 = r21;
        r2 = r0.anE;
        r3 = 4;
        r2.cR(r3);
        r0 = r21;
        r2 = r0.anx;
        r0 = r21;
        r3 = r0.anE;
        r0 = r16;
        r2.a(r0, r3);
    L_0x0158:
        r0 = r21;
        r0 = r0.anD;
        r16 = r0;
        r0 = r16;
        r2 = r0.anJ;
        r3 = 9;
        if (r2 == r3) goto L_0x01f3;
    L_0x0166:
        r0 = r16;
        r2 = r0.anz;
        if (r2 == 0) goto L_0x0239;
    L_0x016c:
        r0 = r16;
        r2 = r0.anN;
        r0 = r16;
        r3 = r0.anM;
        r4 = r2.anP;
        if (r4 == 0) goto L_0x0325;
    L_0x0178:
        r4 = r3.anP;
        if (r4 == 0) goto L_0x01f0;
    L_0x017c:
        r4 = r2.anU;
        r5 = r3.anU;
        if (r4 != r5) goto L_0x01f0;
    L_0x0182:
        r4 = r2.anV;
        r5 = r3.anV;
        if (r4 != r5) goto L_0x01f0;
    L_0x0188:
        r4 = r2.anW;
        r5 = r3.anW;
        if (r4 != r5) goto L_0x01f0;
    L_0x018e:
        r4 = r2.anX;
        if (r4 == 0) goto L_0x019c;
    L_0x0192:
        r4 = r3.anX;
        if (r4 == 0) goto L_0x019c;
    L_0x0196:
        r4 = r2.anY;
        r5 = r3.anY;
        if (r4 != r5) goto L_0x01f0;
    L_0x019c:
        r4 = r2.anS;
        r5 = r3.anS;
        if (r4 == r5) goto L_0x01aa;
    L_0x01a2:
        r4 = r2.anS;
        if (r4 == 0) goto L_0x01f0;
    L_0x01a6:
        r4 = r3.anS;
        if (r4 == 0) goto L_0x01f0;
    L_0x01aa:
        r4 = r2.anR;
        r4 = r4.aCn;
        if (r4 != 0) goto L_0x01c2;
    L_0x01b0:
        r4 = r3.anR;
        r4 = r4.aCn;
        if (r4 != 0) goto L_0x01c2;
    L_0x01b6:
        r4 = r2.aob;
        r5 = r3.aob;
        if (r4 != r5) goto L_0x01f0;
    L_0x01bc:
        r4 = r2.aoc;
        r5 = r3.aoc;
        if (r4 != r5) goto L_0x01f0;
    L_0x01c2:
        r4 = r2.anR;
        r4 = r4.aCn;
        r5 = 1;
        if (r4 != r5) goto L_0x01dc;
    L_0x01c9:
        r4 = r3.anR;
        r4 = r4.aCn;
        r5 = 1;
        if (r4 != r5) goto L_0x01dc;
    L_0x01d0:
        r4 = r2.aod;
        r5 = r3.aod;
        if (r4 != r5) goto L_0x01f0;
    L_0x01d6:
        r4 = r2.aoe;
        r5 = r3.aoe;
        if (r4 != r5) goto L_0x01f0;
    L_0x01dc:
        r4 = r2.anZ;
        r5 = r3.anZ;
        if (r4 != r5) goto L_0x01f0;
    L_0x01e2:
        r4 = r2.anZ;
        if (r4 == 0) goto L_0x0325;
    L_0x01e6:
        r4 = r3.anZ;
        if (r4 == 0) goto L_0x0325;
    L_0x01ea:
        r2 = r2.aoa;
        r3 = r3.aoa;
        if (r2 == r3) goto L_0x0325;
    L_0x01f0:
        r2 = 1;
    L_0x01f1:
        if (r2 == 0) goto L_0x0239;
    L_0x01f3:
        r0 = r16;
        r2 = r0.anO;
        if (r2 == 0) goto L_0x021f;
    L_0x01f9:
        r0 = r16;
        r2 = r0.anK;
        r2 = r14 - r2;
        r2 = (int) r2;
        r8 = r9 + r2;
        r0 = r16;
        r2 = r0.ans;
        if (r2 == 0) goto L_0x0328;
    L_0x0208:
        r6 = 1;
    L_0x0209:
        r0 = r16;
        r2 = r0.anK;
        r0 = r16;
        r4 = r0.anr;
        r2 = r2 - r4;
        r7 = (int) r2;
        r0 = r16;
        r3 = r0.alW;
        r0 = r16;
        r4 = r0.anj;
        r9 = 0;
        r3.a(r4, r6, r7, r8, r9);
    L_0x021f:
        r0 = r16;
        r2 = r0.anK;
        r0 = r16;
        r0.anr = r2;
        r0 = r16;
        r2 = r0.anL;
        r0 = r16;
        r0.anj = r2;
        r2 = 0;
        r0 = r16;
        r0.ans = r2;
        r2 = 1;
        r0 = r16;
        r0.anO = r2;
    L_0x0239:
        r0 = r16;
        r3 = r0.ans;
        r0 = r16;
        r2 = r0.anJ;
        r4 = 5;
        if (r2 == r4) goto L_0x0266;
    L_0x0244:
        r0 = r16;
        r2 = r0.any;
        if (r2 == 0) goto L_0x032e;
    L_0x024a:
        r0 = r16;
        r2 = r0.anJ;
        r4 = 1;
        if (r2 != r4) goto L_0x032e;
    L_0x0251:
        r0 = r16;
        r2 = r0.anN;
        r4 = r2.anQ;
        if (r4 == 0) goto L_0x032b;
    L_0x0259:
        r4 = r2.anT;
        r5 = 7;
        if (r4 == r5) goto L_0x0263;
    L_0x025e:
        r2 = r2.anT;
        r4 = 2;
        if (r2 != r4) goto L_0x032b;
    L_0x0263:
        r2 = 1;
    L_0x0264:
        if (r2 == 0) goto L_0x032e;
    L_0x0266:
        r2 = 1;
    L_0x0267:
        r2 = r2 | r3;
        r0 = r16;
        r0.ans = r2;
        r0 = r21;
        r2 = r0.anq;
        r0 = r21;
        r4 = r0.ana;
        if (r4 == 0) goto L_0x027e;
    L_0x0276:
        r0 = r21;
        r4 = r0.anD;
        r4 = r4.anz;
        if (r4 == 0) goto L_0x028c;
    L_0x027e:
        r0 = r21;
        r4 = r0.anA;
        r4.cw(r13);
        r0 = r21;
        r4 = r0.anB;
        r4.cw(r13);
    L_0x028c:
        r0 = r21;
        r4 = r0.anC;
        r4.cw(r13);
        r0 = r21;
        r4 = r0.anD;
        r4.anJ = r13;
        r4.anL = r2;
        r4.anK = r14;
        r2 = r4.any;
        if (r2 == 0) goto L_0x02a6;
    L_0x02a1:
        r2 = r4.anJ;
        r3 = 1;
        if (r2 == r3) goto L_0x02b9;
    L_0x02a6:
        r2 = r4.anz;
        if (r2 == 0) goto L_0x02cc;
    L_0x02aa:
        r2 = r4.anJ;
        r3 = 5;
        if (r2 == r3) goto L_0x02b9;
    L_0x02af:
        r2 = r4.anJ;
        r3 = 1;
        if (r2 == r3) goto L_0x02b9;
    L_0x02b4:
        r2 = r4.anJ;
        r3 = 2;
        if (r2 != r3) goto L_0x02cc;
    L_0x02b9:
        r2 = r4.anM;
        r3 = r4.anN;
        r4.anM = r3;
        r4.anN = r2;
        r2 = r4.anN;
        r2.clear();
        r2 = 0;
        r4.anI = r2;
        r2 = 1;
        r4.anv = r2;
    L_0x02cc:
        r2 = r12 + 3;
        goto L_0x0027;
    L_0x02d0:
        r2 = 0;
        r8 = r2;
        goto L_0x0051;
    L_0x02d4:
        r0 = r21;
        r2 = r0.anA;
        r2 = r2.aow;
        if (r2 == 0) goto L_0x02fd;
    L_0x02dc:
        r0 = r21;
        r2 = r0.anA;
        r2 = r2.aox;
        r3 = 3;
        r0 = r21;
        r4 = r0.anA;
        r4 = r4.aoy;
        r2 = com.google.android.exoplayer2.i.h.j(r2, r3, r4);
        r0 = r21;
        r3 = r0.anD;
        r3.a(r2);
        r0 = r21;
        r2 = r0.anA;
        r2.reset();
        goto L_0x011c;
    L_0x02fd:
        r0 = r21;
        r2 = r0.anB;
        r2 = r2.aow;
        if (r2 == 0) goto L_0x011c;
    L_0x0305:
        r0 = r21;
        r2 = r0.anB;
        r2 = r2.aox;
        r0 = r21;
        r3 = r0.anB;
        r3 = r3.aoy;
        r2 = com.google.android.exoplayer2.i.h.k(r2, r3);
        r0 = r21;
        r3 = r0.anD;
        r3.a(r2);
        r0 = r21;
        r2 = r0.anB;
        r2.reset();
        goto L_0x011c;
    L_0x0325:
        r2 = 0;
        goto L_0x01f1;
    L_0x0328:
        r6 = 0;
        goto L_0x0209;
    L_0x032b:
        r2 = 0;
        goto L_0x0264;
    L_0x032e:
        r2 = 0;
        goto L_0x0267;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.j.b(com.google.android.exoplayer2.i.j):void");
    }

    public final void jz() {
    }

    private void e(byte[] bArr, int i, int i2) {
        if (!this.ana || this.anD.anz) {
            this.anA.f(bArr, i, i2);
            this.anB.f(bArr, i, i2);
        }
        this.anC.f(bArr, i, i2);
        a aVar = this.anD;
        if (aVar.anv) {
            int i3 = i2 - i;
            if (aVar.buffer.length < aVar.anI + i3) {
                aVar.buffer = Arrays.copyOf(aVar.buffer, (aVar.anI + i3) * 2);
            }
            System.arraycopy(bArr, i, aVar.buffer, aVar.anI, i3);
            aVar.anI = i3 + aVar.anI;
            aVar.anH.k(aVar.buffer, 0, aVar.anI);
            if (aVar.anH.cW(8)) {
                aVar.anH.lM();
                int cT = aVar.anH.cT(2);
                aVar.anH.cS(5);
                if (aVar.anH.lN()) {
                    aVar.anH.lP();
                    if (aVar.anH.lN()) {
                        int lP = aVar.anH.lP();
                        if (!aVar.anz) {
                            aVar.anv = false;
                            a aVar2 = aVar.anN;
                            aVar2.anT = lP;
                            aVar2.anQ = true;
                        } else if (aVar.anH.lN()) {
                            int lP2 = aVar.anH.lP();
                            if (aVar.anG.indexOfKey(lP2) < 0) {
                                aVar.anv = false;
                                return;
                            }
                            com.google.android.exoplayer2.i.h.a aVar3 = (com.google.android.exoplayer2.i.h.a) aVar.anG.get(lP2);
                            b bVar = (b) aVar.anF.get(aVar3.aCh);
                            if (bVar.aCk) {
                                if (aVar.anH.cW(2)) {
                                    aVar.anH.cS(2);
                                } else {
                                    return;
                                }
                            }
                            if (aVar.anH.cW(bVar.aCm)) {
                                int i4;
                                int i5;
                                boolean z = false;
                                boolean z2 = false;
                                boolean z3 = false;
                                int cT2 = aVar.anH.cT(bVar.aCm);
                                if (!bVar.aCl) {
                                    if (aVar.anH.cW(1)) {
                                        z = aVar.anH.lD();
                                        if (z) {
                                            if (aVar.anH.cW(1)) {
                                                z3 = aVar.anH.lD();
                                                z2 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                boolean z4 = aVar.anJ == 5;
                                int i6 = 0;
                                if (z4) {
                                    if (aVar.anH.lN()) {
                                        i6 = aVar.anH.lP();
                                    } else {
                                        return;
                                    }
                                }
                                int i7 = 0;
                                int i8 = 0;
                                if (bVar.aCn != 0) {
                                    if (bVar.aCn == 1 && !bVar.aCp) {
                                        if (aVar.anH.lN()) {
                                            i8 = aVar.anH.lO();
                                            if (aVar3.aCi && !z) {
                                                if (aVar.anH.lN()) {
                                                    i3 = aVar.anH.lO();
                                                    i4 = i8;
                                                    i8 = 0;
                                                    i5 = 0;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    i3 = 0;
                                    i4 = i8;
                                    i8 = 0;
                                    i5 = i7;
                                } else if (aVar.anH.cW(bVar.aCo)) {
                                    i7 = aVar.anH.cT(bVar.aCo);
                                    if (aVar3.aCi && !z) {
                                        if (aVar.anH.lN()) {
                                            i5 = i7;
                                            i8 = aVar.anH.lO();
                                            i3 = 0;
                                            i4 = 0;
                                        } else {
                                            return;
                                        }
                                    }
                                    i3 = 0;
                                    i4 = i8;
                                    i8 = 0;
                                    i5 = i7;
                                } else {
                                    return;
                                }
                                a aVar4 = aVar.anN;
                                aVar4.anR = bVar;
                                aVar4.anS = cT;
                                aVar4.anT = lP;
                                aVar4.anU = cT2;
                                aVar4.anV = lP2;
                                aVar4.anW = z;
                                aVar4.anX = z2;
                                aVar4.anY = z3;
                                aVar4.anZ = z4;
                                aVar4.aoa = i6;
                                aVar4.aob = i5;
                                aVar4.aoc = i8;
                                aVar4.aod = i4;
                                aVar4.aoe = i3;
                                aVar4.anP = true;
                                aVar4.anQ = true;
                                aVar.anv = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
