package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.c.u.c;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class t implements d {
    public static final g aiT = new g() {
    };
    private static final long aoN = ((long) com.google.android.exoplayer2.i.t.ak("AC-3"));
    private static final long aoO = ((long) com.google.android.exoplayer2.i.t.ak("EAC3"));
    private static final long aoP = ((long) com.google.android.exoplayer2.i.t.ak("HEVC"));
    private final List<q> aoQ;
    private final j aoR;
    private final SparseIntArray aoS;
    private final c aoT;
    private final SparseArray<u> aoU;
    private final SparseBooleanArray aoV;
    private f aoW;
    private int aoX;
    private boolean aoY;
    private u aoZ;
    private final int mode;

    private class a implements p {
        private final i apa = new i(new byte[4]);

        public final void a(q qVar, f fVar, u.d dVar) {
        }

        public final void b(j jVar) {
            if (jVar.readUnsignedByte() == 0) {
                jVar.cV(7);
                int lG = jVar.lG() / 4;
                for (int i = 0; i < lG; i++) {
                    jVar.c(this.apa, 4);
                    int cT = this.apa.cT(16);
                    this.apa.cS(3);
                    if (cT == 0) {
                        this.apa.cS(13);
                    } else {
                        cT = this.apa.cT(13);
                        t.this.aoU.put(cT, new q(new b(cT)));
                        t.this.aoX = t.this.aoX + 1;
                    }
                }
                if (t.this.mode != 2) {
                    t.this.aoU.remove(0);
                }
            }
        }
    }

    private class b implements p {
        private final i apc = new i(new byte[5]);
        private final SparseArray<u> apd = new SparseArray();
        private final SparseIntArray ape = new SparseIntArray();
        private final int pid;

        public b(int i) {
            this.pid = i;
        }

        public final void a(q qVar, f fVar, u.d dVar) {
        }

        public final void b(j jVar) {
            if (jVar.readUnsignedByte() == 2) {
                q qVar;
                int cT;
                int i;
                int i2;
                if (t.this.mode == 1 || t.this.mode == 2 || t.this.aoX == 1) {
                    qVar = (q) t.this.aoQ.get(0);
                } else {
                    qVar = new q(((q) t.this.aoQ.get(0)).amG);
                    t.this.aoQ.add(qVar);
                }
                jVar.cV(2);
                int readUnsignedShort = jVar.readUnsignedShort();
                jVar.cV(5);
                jVar.c(this.apc, 2);
                this.apc.cS(4);
                jVar.cV(this.apc.cT(12));
                if (t.this.mode == 2 && t.this.aoZ == null) {
                    t.this.aoZ = t.this.aoT.a(21, new com.google.android.exoplayer2.c.c.u.b(21, null, null, new byte[0]));
                    t.this.aoZ.a(qVar, t.this.aoW, new u.d(readUnsignedShort, 21, 8192));
                }
                this.apd.clear();
                this.ape.clear();
                int lG = jVar.lG();
                while (lG > 0) {
                    int i3;
                    jVar.c(this.apc, 5);
                    cT = this.apc.cT(8);
                    this.apc.cS(3);
                    int cT2 = this.apc.cT(13);
                    this.apc.cS(4);
                    int cT3 = this.apc.cT(12);
                    int i4 = jVar.position;
                    int i5 = i4 + cT3;
                    i = -1;
                    String str = null;
                    List list = null;
                    while (jVar.position < i5) {
                        int readUnsignedByte = jVar.readUnsignedByte();
                        int readUnsignedByte2 = jVar.readUnsignedByte() + jVar.position;
                        if (readUnsignedByte == 5) {
                            long aL = jVar.aL();
                            if (aL == t.aoN) {
                                i = 129;
                            } else if (aL == t.aoO) {
                                i = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
                            } else if (aL == t.aoP) {
                                i = 36;
                            }
                        } else if (readUnsignedByte == 106) {
                            i = 129;
                        } else if (readUnsignedByte == 122) {
                            i = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
                        } else if (readUnsignedByte == 123) {
                            i = 138;
                        } else if (readUnsignedByte == 10) {
                            str = jVar.readString(3).trim();
                        } else if (readUnsignedByte == 89) {
                            i = 89;
                            list = new ArrayList();
                            while (jVar.position < readUnsignedByte2) {
                                String trim = jVar.readString(3).trim();
                                int readUnsignedByte3 = jVar.readUnsignedByte();
                                byte[] bArr = new byte[4];
                                jVar.readBytes(bArr, 0, 4);
                                list.add(new com.google.android.exoplayer2.c.c.u.a(trim, readUnsignedByte3, bArr));
                            }
                        }
                        jVar.cV(readUnsignedByte2 - jVar.position);
                    }
                    jVar.cR(i5);
                    com.google.android.exoplayer2.c.c.u.b bVar = new com.google.android.exoplayer2.c.c.u.b(i, str, list, Arrays.copyOfRange(jVar.data, i4, i5));
                    if (cT == 6) {
                        i3 = bVar.streamType;
                    } else {
                        i3 = cT;
                    }
                    i = lG - (cT3 + 5);
                    i2 = t.this.mode == 2 ? i3 : cT2;
                    if (t.this.aoV.get(i2)) {
                        lG = i;
                    } else {
                        Object f;
                        if (t.this.mode == 2 && i3 == 21) {
                            f = t.this.aoZ;
                        } else {
                            f = t.this.aoT.a(i3, bVar);
                        }
                        if (t.this.mode != 2 || cT2 < this.ape.get(i2, 8192)) {
                            this.ape.put(i2, cT2);
                            this.apd.put(i2, f);
                        }
                        lG = i;
                    }
                }
                i = this.ape.size();
                for (i2 = 0; i2 < i; i2++) {
                    cT = this.ape.keyAt(i2);
                    t.this.aoV.put(cT, true);
                    u uVar = (u) this.apd.valueAt(i2);
                    if (uVar != null) {
                        if (uVar != t.this.aoZ) {
                            uVar.a(qVar, t.this.aoW, new u.d(readUnsignedShort, cT, 8192));
                        }
                        t.this.aoU.put(this.ape.valueAt(i2), uVar);
                    }
                }
                if (t.this.mode != 2) {
                    t.this.aoU.remove(this.pid);
                    t.this.aoX = t.this.mode == 1 ? 0 : t.this.aoX - 1;
                    if (t.this.aoX == 0) {
                        t.this.aoW.jv();
                        t.this.aoY = true;
                    }
                } else if (!t.this.aoY) {
                    t.this.aoW.jv();
                    t.this.aoX = 0;
                    t.this.aoY = true;
                }
            }
        }
    }

    public t() {
        this((byte) 0);
    }

    private t(byte b) {
        this(0);
    }

    private t(int i) {
        this(1, new q(0), new e(0));
    }

    public t(int i, q qVar, c cVar) {
        this.aoT = (c) com.google.android.exoplayer2.i.a.Y(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.aoQ = Collections.singletonList(qVar);
        } else {
            this.aoQ = new ArrayList();
            this.aoQ.add(qVar);
        }
        this.aoR = new j(9400);
        this.aoV = new SparseBooleanArray();
        this.aoU = new SparseArray();
        this.aoS = new SparseIntArray();
        jC();
    }

    public final void a(f fVar) {
        this.aoW = fVar;
        com.google.android.exoplayer2.c.j.a aVar = new com.google.android.exoplayer2.c.j.a(-9223372036854775807L);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.e r12) {
        /*
        r11 = this;
        r7 = 188; // 0xbc float:2.63E-43 double:9.3E-322;
        r0 = -1;
        r1 = 1;
        r2 = 0;
        r3 = r11.aoR;
        r3 = r3.data;
        r4 = r11.aoR;
        r4 = r4.position;
        r4 = 9400 - r4;
        if (r4 >= r7) goto L_0x0025;
    L_0x0011:
        r4 = r11.aoR;
        r4 = r4.lG();
        if (r4 <= 0) goto L_0x0020;
    L_0x0019:
        r5 = r11.aoR;
        r5 = r5.position;
        java.lang.System.arraycopy(r3, r5, r3, r2, r4);
    L_0x0020:
        r5 = r11.aoR;
        r5.l(r3, r4);
    L_0x0025:
        r4 = r11.aoR;
        r4 = r4.lG();
        if (r4 >= r7) goto L_0x0042;
    L_0x002d:
        r4 = r11.aoR;
        r4 = r4.asN;
        r5 = 9400 - r4;
        r5 = r12.read(r3, r4, r5);
        if (r5 != r0) goto L_0x003b;
    L_0x0039:
        r2 = r0;
    L_0x003a:
        return r2;
    L_0x003b:
        r6 = r11.aoR;
        r4 = r4 + r5;
        r6.cU(r4);
        goto L_0x0025;
    L_0x0042:
        r0 = r11.aoR;
        r5 = r0.asN;
        r0 = r11.aoR;
        r0 = r0.position;
    L_0x004a:
        if (r0 >= r5) goto L_0x0055;
    L_0x004c:
        r4 = r3[r0];
        r6 = 71;
        if (r4 == r6) goto L_0x0055;
    L_0x0052:
        r0 = r0 + 1;
        goto L_0x004a;
    L_0x0055:
        r3 = r11.aoR;
        r3.cR(r0);
        r6 = r0 + 188;
        if (r6 > r5) goto L_0x003a;
    L_0x005e:
        r0 = r11.aoR;
        r7 = r0.readInt();
        r0 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r0 = r0 & r7;
        if (r0 == 0) goto L_0x006f;
    L_0x0069:
        r0 = r11.aoR;
        r0.cR(r6);
        goto L_0x003a;
    L_0x006f:
        r0 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
        r0 = r0 & r7;
        if (r0 == 0) goto L_0x00a3;
    L_0x0074:
        r4 = r1;
    L_0x0075:
        r0 = 2096896; // 0x1fff00 float:2.938377E-39 double:1.0360043E-317;
        r0 = r0 & r7;
        r8 = r0 >> 8;
        r0 = r7 & 32;
        if (r0 == 0) goto L_0x00a5;
    L_0x007f:
        r3 = r1;
    L_0x0080:
        r0 = r7 & 16;
        if (r0 == 0) goto L_0x00a7;
    L_0x0084:
        r0 = r1;
    L_0x0085:
        r9 = r11.mode;
        r10 = 2;
        if (r9 == r10) goto L_0x00e3;
    L_0x008a:
        r7 = r7 & 15;
        r9 = r11.aoS;
        r10 = r7 + -1;
        r9 = r9.get(r8, r10);
        r10 = r11.aoS;
        r10.put(r8, r7);
        if (r9 != r7) goto L_0x00a9;
    L_0x009b:
        if (r0 == 0) goto L_0x00e3;
    L_0x009d:
        r0 = r11.aoR;
        r0.cR(r6);
        goto L_0x003a;
    L_0x00a3:
        r4 = r2;
        goto L_0x0075;
    L_0x00a5:
        r3 = r2;
        goto L_0x0080;
    L_0x00a7:
        r0 = r2;
        goto L_0x0085;
    L_0x00a9:
        r9 = r9 + 1;
        r9 = r9 & 15;
        if (r7 == r9) goto L_0x00e3;
    L_0x00af:
        if (r3 == 0) goto L_0x00bc;
    L_0x00b1:
        r3 = r11.aoR;
        r3 = r3.readUnsignedByte();
        r7 = r11.aoR;
        r7.cV(r3);
    L_0x00bc:
        if (r0 == 0) goto L_0x00dc;
    L_0x00be:
        r0 = r11.aoU;
        r0 = r0.get(r8);
        r0 = (com.google.android.exoplayer2.c.c.u) r0;
        if (r0 == 0) goto L_0x00dc;
    L_0x00c8:
        if (r1 == 0) goto L_0x00cd;
    L_0x00ca:
        r0.jy();
    L_0x00cd:
        r1 = r11.aoR;
        r1.cU(r6);
        r1 = r11.aoR;
        r0.a(r1, r4);
        r0 = r11.aoR;
        r0.cU(r5);
    L_0x00dc:
        r0 = r11.aoR;
        r0.cR(r6);
        goto L_0x003a;
    L_0x00e3:
        r1 = r2;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.t.a(com.google.android.exoplayer2.c.e):int");
    }

    private void jC() {
        this.aoV.clear();
        this.aoU.clear();
        SparseArray jB = this.aoT.jB();
        int size = jB.size();
        for (int i = 0; i < size; i++) {
            this.aoU.put(jB.keyAt(i), jB.valueAt(i));
        }
        this.aoU.put(0, new q(new a()));
        this.aoZ = null;
    }
}
