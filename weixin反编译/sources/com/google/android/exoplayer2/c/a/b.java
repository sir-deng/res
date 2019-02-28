package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;

public final class b implements d {
    public static final g aiT = new g() {
    };
    private static final int aiU = t.ak("Xing");
    private static final int aiV = t.ak("Info");
    private static final int aiW = t.ak("VBRI");
    private Metadata adT;
    private final long aiX;
    private final j aiY;
    private final i aiZ;
    private final h aja;
    private f ajb;
    private k ajc;
    private int ajd;
    private a aje;
    private long ajf;
    private long ajg;
    private int ajh;
    private final int flags;

    interface a extends com.google.android.exoplayer2.c.j {
        long y(long j);
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this(0, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = 0;
        this.aiX = j;
        this.aiY = new j(10);
        this.aiZ = new i();
        this.aja = new h();
        this.ajf = -9223372036854775807L;
    }

    public final void a(f fVar) {
        this.ajb = fVar;
        this.ajc = this.ajb.ck(0);
        this.ajb.jv();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.e r24) {
        /*
        r23 = this;
        r0 = r23;
        r2 = r0.ajd;
        if (r2 != 0) goto L_0x0142;
    L_0x0006:
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r24.jt();	 Catch:{ EOFException -> 0x0111 }
        r6 = r24.getPosition();	 Catch:{ EOFException -> 0x0111 }
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x00ca;
    L_0x0016:
        r2 = 0;
        r7 = r2;
    L_0x0018:
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.data;	 Catch:{ EOFException -> 0x0111 }
        r6 = 0;
        r8 = 10;
        r0 = r24;
        r0.b(r2, r6, r8);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r6 = 0;
        r2.cR(r6);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.lH();	 Catch:{ EOFException -> 0x0111 }
        r6 = com.google.android.exoplayer2.metadata.id3.a.amF;	 Catch:{ EOFException -> 0x0111 }
        if (r2 != r6) goto L_0x00b8;
    L_0x003a:
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r6 = 3;
        r2.cV(r6);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.lI();	 Catch:{ EOFException -> 0x0111 }
        r8 = r2 + 10;
        r0 = r23;
        r6 = r0.adT;	 Catch:{ EOFException -> 0x0111 }
        if (r6 != 0) goto L_0x00ae;
    L_0x0052:
        r6 = new byte[r8];	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r9 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r9 = r9.data;	 Catch:{ EOFException -> 0x0111 }
        r10 = 0;
        r11 = 0;
        r12 = 10;
        java.lang.System.arraycopy(r9, r10, r6, r11, r12);	 Catch:{ EOFException -> 0x0111 }
        r9 = 10;
        r0 = r24;
        r0.b(r6, r9, r2);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.flags;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x00ac;
    L_0x0070:
        r2 = com.google.android.exoplayer2.c.h.aiG;	 Catch:{ EOFException -> 0x0111 }
    L_0x0072:
        r9 = new com.google.android.exoplayer2.metadata.id3.a;	 Catch:{ EOFException -> 0x0111 }
        r9.<init>(r2);	 Catch:{ EOFException -> 0x0111 }
        r2 = r9.b(r6, r8);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r0.adT = r2;	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.adT;	 Catch:{ EOFException -> 0x0111 }
        if (r2 == 0) goto L_0x00b3;
    L_0x0085:
        r0 = r23;
        r9 = r0.aja;	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r10 = r0.adT;	 Catch:{ EOFException -> 0x0111 }
        r2 = 0;
        r6 = r2;
    L_0x008f:
        r2 = r10.aqo;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.length;	 Catch:{ EOFException -> 0x0111 }
        if (r6 >= r2) goto L_0x00b3;
    L_0x0094:
        r2 = r10.aqo;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2[r6];	 Catch:{ EOFException -> 0x0111 }
        r11 = r2 instanceof com.google.android.exoplayer2.metadata.id3.CommentFrame;	 Catch:{ EOFException -> 0x0111 }
        if (r11 == 0) goto L_0x00a8;
    L_0x009c:
        r2 = (com.google.android.exoplayer2.metadata.id3.CommentFrame) r2;	 Catch:{ EOFException -> 0x0111 }
        r11 = r2.description;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.text;	 Catch:{ EOFException -> 0x0111 }
        r2 = r9.h(r11, r2);	 Catch:{ EOFException -> 0x0111 }
        if (r2 != 0) goto L_0x00b3;
    L_0x00a8:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x008f;
    L_0x00ac:
        r2 = 0;
        goto L_0x0072;
    L_0x00ae:
        r0 = r24;
        r0.cg(r2);	 Catch:{ EOFException -> 0x0111 }
    L_0x00b3:
        r2 = r7 + r8;
        r7 = r2;
        goto L_0x0018;
    L_0x00b8:
        r24.jt();	 Catch:{ EOFException -> 0x0111 }
        r0 = r24;
        r0.cg(r7);	 Catch:{ EOFException -> 0x0111 }
        r6 = r24.ju();	 Catch:{ EOFException -> 0x0111 }
        r2 = (int) r6;	 Catch:{ EOFException -> 0x0111 }
        r0 = r24;
        r0.cf(r2);	 Catch:{ EOFException -> 0x0111 }
    L_0x00ca:
        r22 = r3;
        r3 = r4;
        r4 = r22;
    L_0x00cf:
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r6 = r2.data;	 Catch:{ EOFException -> 0x0111 }
        r7 = 0;
        r8 = 4;
        if (r5 <= 0) goto L_0x0114;
    L_0x00d9:
        r2 = 1;
    L_0x00da:
        r0 = r24;
        r2 = r0.b(r6, r7, r8, r2);	 Catch:{ EOFException -> 0x0111 }
        if (r2 == 0) goto L_0x013b;
    L_0x00e2:
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r6 = 0;
        r2.cR(r6);	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r2 = r0.aiY;	 Catch:{ EOFException -> 0x0111 }
        r2 = r2.readInt();	 Catch:{ EOFException -> 0x0111 }
        if (r3 == 0) goto L_0x00fb;
    L_0x00f4:
        r6 = (long) r3;	 Catch:{ EOFException -> 0x0111 }
        r6 = e(r2, r6);	 Catch:{ EOFException -> 0x0111 }
        if (r6 == 0) goto L_0x0102;
    L_0x00fb:
        r6 = com.google.android.exoplayer2.c.i.cl(r2);	 Catch:{ EOFException -> 0x0111 }
        r7 = -1;
        if (r6 != r7) goto L_0x0121;
    L_0x0102:
        r2 = r4 + 1;
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r4 != r3) goto L_0x0116;
    L_0x0108:
        r2 = new com.google.android.exoplayer2.o;	 Catch:{ EOFException -> 0x0111 }
        r3 = "Searched too many bytes.";
        r2.<init>(r3);	 Catch:{ EOFException -> 0x0111 }
        throw r2;	 Catch:{ EOFException -> 0x0111 }
    L_0x0111:
        r2 = move-exception;
        r2 = -1;
    L_0x0113:
        return r2;
    L_0x0114:
        r2 = 0;
        goto L_0x00da;
    L_0x0116:
        r4 = 0;
        r3 = 0;
        r5 = 1;
        r0 = r24;
        r0.cf(r5);	 Catch:{ EOFException -> 0x0111 }
        r5 = r4;
        r4 = r2;
        goto L_0x00cf;
    L_0x0121:
        r5 = r5 + 1;
        r7 = 1;
        if (r5 != r7) goto L_0x0136;
    L_0x0126:
        r0 = r23;
        r3 = r0.aiZ;	 Catch:{ EOFException -> 0x0111 }
        com.google.android.exoplayer2.c.i.a(r2, r3);	 Catch:{ EOFException -> 0x0111 }
    L_0x012d:
        r3 = r6 + -4;
        r0 = r24;
        r0.cg(r3);	 Catch:{ EOFException -> 0x0111 }
        r3 = r2;
        goto L_0x00cf;
    L_0x0136:
        r2 = 4;
        if (r5 == r2) goto L_0x013b;
    L_0x0139:
        r2 = r3;
        goto L_0x012d;
    L_0x013b:
        r24.jt();	 Catch:{ EOFException -> 0x0111 }
        r0 = r23;
        r0.ajd = r3;	 Catch:{ EOFException -> 0x0111 }
    L_0x0142:
        r0 = r23;
        r2 = r0.aje;
        if (r2 != 0) goto L_0x028f;
    L_0x0148:
        r13 = new com.google.android.exoplayer2.i.j;
        r0 = r23;
        r2 = r0.aiZ;
        r2 = r2.afs;
        r13.<init>(r2);
        r2 = r13.data;
        r3 = 0;
        r0 = r23;
        r4 = r0.aiZ;
        r4 = r4.afs;
        r0 = r24;
        r0.b(r2, r3, r4);
        r0 = r23;
        r2 = r0.aiZ;
        r2 = r2.version;
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x02b1;
    L_0x016b:
        r0 = r23;
        r2 = r0.aiZ;
        r2 = r2.channels;
        r3 = 1;
        if (r2 == r3) goto L_0x02ac;
    L_0x0174:
        r2 = 36;
        r14 = r2;
    L_0x0177:
        r2 = r13.asN;
        r3 = r14 + 4;
        if (r2 < r3) goto L_0x02c4;
    L_0x017d:
        r13.cR(r14);
        r2 = r13.readInt();
        r3 = aiU;
        if (r2 == r3) goto L_0x018c;
    L_0x0188:
        r3 = aiV;
        if (r2 != r3) goto L_0x02c4;
    L_0x018c:
        r15 = r2;
    L_0x018d:
        r2 = aiU;
        if (r15 == r2) goto L_0x0195;
    L_0x0191:
        r2 = aiV;
        if (r15 != r2) goto L_0x0328;
    L_0x0195:
        r0 = r23;
        r0 = r0.aiZ;
        r16 = r0;
        r2 = r24.getPosition();
        r8 = r24.getLength();
        r0 = r16;
        r4 = r0.aiP;
        r0 = r16;
        r6 = r0.sampleRate;
        r0 = r16;
        r5 = r0.afs;
        r10 = (long) r5;
        r18 = r2 + r10;
        r10 = r13.readInt();
        r2 = r10 & 1;
        r3 = 1;
        if (r2 != r3) goto L_0x01c1;
    L_0x01bb:
        r2 = r13.lJ();
        if (r2 != 0) goto L_0x02e0;
    L_0x01c1:
        r3 = 0;
        r2 = r3;
    L_0x01c3:
        if (r2 == 0) goto L_0x020d;
    L_0x01c5:
        r0 = r23;
        r3 = r0.aja;
        r4 = r3.aeh;
        r5 = -1;
        if (r4 == r5) goto L_0x0325;
    L_0x01ce:
        r3 = r3.aei;
        r4 = -1;
        if (r3 == r4) goto L_0x0325;
    L_0x01d3:
        r3 = 1;
    L_0x01d4:
        if (r3 != 0) goto L_0x020d;
    L_0x01d6:
        r24.jt();
        r3 = r14 + 141;
        r0 = r24;
        r0.cg(r3);
        r0 = r23;
        r3 = r0.aiY;
        r3 = r3.data;
        r4 = 0;
        r5 = 3;
        r0 = r24;
        r0.b(r3, r4, r5);
        r0 = r23;
        r3 = r0.aiY;
        r4 = 0;
        r3.cR(r4);
        r0 = r23;
        r3 = r0.aja;
        r0 = r23;
        r4 = r0.aiY;
        r4 = r4.lH();
        r5 = r4 >> 12;
        r4 = r4 & 4095;
        if (r5 > 0) goto L_0x0209;
    L_0x0207:
        if (r4 <= 0) goto L_0x020d;
    L_0x0209:
        r3.aeh = r5;
        r3.aei = r4;
    L_0x020d:
        r0 = r23;
        r3 = r0.aiZ;
        r3 = r3.afs;
        r0 = r24;
        r0.cf(r3);
        if (r2 == 0) goto L_0x0228;
    L_0x021a:
        r3 = r2.js();
        if (r3 != 0) goto L_0x0228;
    L_0x0220:
        r3 = aiV;
        if (r15 != r3) goto L_0x0228;
    L_0x0224:
        r2 = r23.b(r24);
    L_0x0228:
        r0 = r23;
        r0.aje = r2;
        r0 = r23;
        r2 = r0.aje;
        if (r2 == 0) goto L_0x0244;
    L_0x0232:
        r0 = r23;
        r2 = r0.aje;
        r2 = r2.js();
        if (r2 != 0) goto L_0x024c;
    L_0x023c:
        r0 = r23;
        r2 = r0.flags;
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x024c;
    L_0x0244:
        r2 = r23.b(r24);
        r0 = r23;
        r0.aje = r2;
    L_0x024c:
        r0 = r23;
        r0 = r0.ajc;
        r17 = r0;
        r2 = 0;
        r0 = r23;
        r3 = r0.aiZ;
        r3 = r3.mimeType;
        r4 = 0;
        r5 = -1;
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = r23;
        r7 = r0.aiZ;
        r7 = r7.channels;
        r0 = r23;
        r8 = r0.aiZ;
        r8 = r8.sampleRate;
        r9 = -1;
        r0 = r23;
        r10 = r0.aja;
        r10 = r10.aeh;
        r0 = r23;
        r11 = r0.aja;
        r11 = r11.aei;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r0 = r23;
        r0 = r0.flags;
        r16 = r0;
        r16 = r16 & 2;
        if (r16 == 0) goto L_0x03d6;
    L_0x0284:
        r16 = 0;
    L_0x0286:
        r2 = com.google.android.exoplayer2.Format.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r0 = r17;
        r0.f(r2);
    L_0x028f:
        r0 = r23;
        r2 = r0.ajh;
        if (r2 != 0) goto L_0x0462;
    L_0x0295:
        r24.jt();
        r0 = r23;
        r2 = r0.aiY;
        r2 = r2.data;
        r3 = 0;
        r4 = 4;
        r5 = 1;
        r0 = r24;
        r2 = r0.b(r2, r3, r4, r5);
        if (r2 != 0) goto L_0x03de;
    L_0x02a9:
        r2 = -1;
        goto L_0x0113;
    L_0x02ac:
        r2 = 21;
        r14 = r2;
        goto L_0x0177;
    L_0x02b1:
        r0 = r23;
        r2 = r0.aiZ;
        r2 = r2.channels;
        r3 = 1;
        if (r2 == r3) goto L_0x02bf;
    L_0x02ba:
        r2 = 21;
        r14 = r2;
        goto L_0x0177;
    L_0x02bf:
        r2 = 13;
        r14 = r2;
        goto L_0x0177;
    L_0x02c4:
        r2 = r13.asN;
        r3 = 40;
        if (r2 < r3) goto L_0x02dc;
    L_0x02ca:
        r2 = 36;
        r13.cR(r2);
        r2 = r13.readInt();
        r3 = aiW;
        if (r2 != r3) goto L_0x02dc;
    L_0x02d7:
        r2 = aiW;
        r15 = r2;
        goto L_0x018d;
    L_0x02dc:
        r2 = 0;
        r15 = r2;
        goto L_0x018d;
    L_0x02e0:
        r2 = (long) r2;
        r4 = (long) r4;
        r20 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r4 * r20;
        r6 = (long) r6;
        r6 = com.google.android.exoplayer2.i.t.a(r2, r4, r6);
        r2 = r10 & 6;
        r3 = 6;
        if (r2 == r3) goto L_0x02fb;
    L_0x02f1:
        r3 = new com.google.android.exoplayer2.c.a.d;
        r4 = r18;
        r3.<init>(r4, r6, r8);
        r2 = r3;
        goto L_0x01c3;
    L_0x02fb:
        r2 = r13.lJ();
        r11 = (long) r2;
        r2 = 1;
        r13.cV(r2);
        r2 = 99;
        r10 = new long[r2];
        r2 = 0;
    L_0x0309:
        r3 = 99;
        if (r2 >= r3) goto L_0x0317;
    L_0x030d:
        r3 = r13.readUnsignedByte();
        r4 = (long) r3;
        r10[r2] = r4;
        r2 = r2 + 1;
        goto L_0x0309;
    L_0x0317:
        r3 = new com.google.android.exoplayer2.c.a.d;
        r0 = r16;
        r13 = r0.afs;
        r4 = r18;
        r3.<init>(r4, r6, r8, r10, r11, r13);
        r2 = r3;
        goto L_0x01c3;
    L_0x0325:
        r3 = 0;
        goto L_0x01d4;
    L_0x0328:
        r2 = aiW;
        if (r15 != r2) goto L_0x03d0;
    L_0x032c:
        r0 = r23;
        r8 = r0.aiZ;
        r10 = r24.getPosition();
        r14 = r24.getLength();
        r2 = 10;
        r13.cV(r2);
        r2 = r13.readInt();
        if (r2 > 0) goto L_0x0351;
    L_0x0343:
        r2 = 0;
    L_0x0344:
        r0 = r23;
        r3 = r0.aiZ;
        r3 = r3.afs;
        r0 = r24;
        r0.cf(r3);
        goto L_0x0228;
    L_0x0351:
        r6 = r8.sampleRate;
        r2 = (long) r2;
        r16 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = 32000; // 0x7d00 float:4.4842E-41 double:1.581E-319;
        if (r6 < r4) goto L_0x0393;
    L_0x035b:
        r4 = 1152; // 0x480 float:1.614E-42 double:5.69E-321;
    L_0x035d:
        r4 = (long) r4;
        r4 = r4 * r16;
        r6 = (long) r6;
        r16 = com.google.android.exoplayer2.i.t.a(r2, r4, r6);
        r9 = r13.readUnsignedShort();
        r12 = r13.readUnsignedShort();
        r18 = r13.readUnsignedShort();
        r2 = 2;
        r13.cV(r2);
        r2 = r8.afs;
        r2 = (long) r2;
        r4 = r10 + r2;
        r2 = r9 + 1;
        r8 = new long[r2];
        r2 = r9 + 1;
        r10 = new long[r2];
        r2 = 0;
        r6 = 0;
        r8[r2] = r6;
        r2 = 0;
        r10[r2] = r4;
        r2 = 1;
    L_0x038b:
        r3 = r8.length;
        if (r2 >= r3) goto L_0x03c7;
    L_0x038e:
        switch(r18) {
            case 1: goto L_0x0396;
            case 2: goto L_0x03b3;
            case 3: goto L_0x03b8;
            case 4: goto L_0x03bd;
            default: goto L_0x0391;
        };
    L_0x0391:
        r2 = 0;
        goto L_0x0344;
    L_0x0393:
        r4 = 576; // 0x240 float:8.07E-43 double:2.846E-321;
        goto L_0x035d;
    L_0x0396:
        r3 = r13.readUnsignedByte();
    L_0x039a:
        r3 = r3 * r12;
        r6 = (long) r3;
        r4 = r4 + r6;
        r6 = (long) r2;
        r6 = r6 * r16;
        r0 = (long) r9;
        r20 = r0;
        r6 = r6 / r20;
        r8[r2] = r6;
        r6 = -1;
        r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r3 != 0) goto L_0x03c2;
    L_0x03ad:
        r6 = r4;
    L_0x03ae:
        r10[r2] = r6;
        r2 = r2 + 1;
        goto L_0x038b;
    L_0x03b3:
        r3 = r13.readUnsignedShort();
        goto L_0x039a;
    L_0x03b8:
        r3 = r13.lH();
        goto L_0x039a;
    L_0x03bd:
        r3 = r13.lJ();
        goto L_0x039a;
    L_0x03c2:
        r6 = java.lang.Math.min(r14, r4);
        goto L_0x03ae;
    L_0x03c7:
        r2 = new com.google.android.exoplayer2.c.a.c;
        r0 = r16;
        r2.<init>(r8, r10, r0);
        goto L_0x0344;
    L_0x03d0:
        r2 = 0;
        r24.jt();
        goto L_0x0228;
    L_0x03d6:
        r0 = r23;
        r0 = r0.adT;
        r16 = r0;
        goto L_0x0286;
    L_0x03de:
        r0 = r23;
        r2 = r0.aiY;
        r3 = 0;
        r2.cR(r3);
        r0 = r23;
        r2 = r0.aiY;
        r2 = r2.readInt();
        r0 = r23;
        r3 = r0.ajd;
        r4 = (long) r3;
        r3 = e(r2, r4);
        if (r3 == 0) goto L_0x0400;
    L_0x03f9:
        r3 = com.google.android.exoplayer2.c.i.cl(r2);
        r4 = -1;
        if (r3 != r4) goto L_0x040e;
    L_0x0400:
        r2 = 1;
        r0 = r24;
        r0.cf(r2);
        r2 = 0;
        r0 = r23;
        r0.ajd = r2;
        r2 = 0;
        goto L_0x0113;
    L_0x040e:
        r0 = r23;
        r3 = r0.aiZ;
        com.google.android.exoplayer2.c.i.a(r2, r3);
        r0 = r23;
        r2 = r0.ajf;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0458;
    L_0x0422:
        r0 = r23;
        r2 = r0.aje;
        r4 = r24.getPosition();
        r2 = r2.y(r4);
        r0 = r23;
        r0.ajf = r2;
        r0 = r23;
        r2 = r0.aiX;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0458;
    L_0x043f:
        r0 = r23;
        r2 = r0.aje;
        r4 = 0;
        r2 = r2.y(r4);
        r0 = r23;
        r4 = r0.ajf;
        r0 = r23;
        r6 = r0.aiX;
        r2 = r6 - r2;
        r2 = r2 + r4;
        r0 = r23;
        r0.ajf = r2;
    L_0x0458:
        r0 = r23;
        r2 = r0.aiZ;
        r2 = r2.afs;
        r0 = r23;
        r0.ajh = r2;
    L_0x0462:
        r0 = r23;
        r2 = r0.ajc;
        r0 = r23;
        r3 = r0.ajh;
        r4 = 1;
        r0 = r24;
        r2 = r2.a(r0, r3, r4);
        r3 = -1;
        if (r2 != r3) goto L_0x0477;
    L_0x0474:
        r2 = -1;
        goto L_0x0113;
    L_0x0477:
        r0 = r23;
        r3 = r0.ajh;
        r2 = r3 - r2;
        r0 = r23;
        r0.ajh = r2;
        r0 = r23;
        r2 = r0.ajh;
        if (r2 <= 0) goto L_0x048a;
    L_0x0487:
        r2 = 0;
        goto L_0x0113;
    L_0x048a:
        r0 = r23;
        r2 = r0.ajf;
        r0 = r23;
        r4 = r0.ajg;
        r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r4 * r6;
        r0 = r23;
        r6 = r0.aiZ;
        r6 = r6.sampleRate;
        r6 = (long) r6;
        r4 = r4 / r6;
        r4 = r4 + r2;
        r0 = r23;
        r3 = r0.ajc;
        r6 = 1;
        r0 = r23;
        r2 = r0.aiZ;
        r7 = r2.afs;
        r8 = 0;
        r9 = 0;
        r3.a(r4, r6, r7, r8, r9);
        r0 = r23;
        r2 = r0.ajg;
        r0 = r23;
        r4 = r0.aiZ;
        r4 = r4.aiP;
        r4 = (long) r4;
        r2 = r2 + r4;
        r0 = r23;
        r0.ajg = r2;
        r2 = 0;
        r0 = r23;
        r0.ajh = r2;
        r2 = 0;
        goto L_0x0113;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.a.b.a(com.google.android.exoplayer2.c.e):int");
    }

    private a b(e eVar) {
        eVar.b(this.aiY.data, 0, 4);
        this.aiY.cR(0);
        i.a(this.aiY.readInt(), this.aiZ);
        return new a(eVar.getPosition(), this.aiZ.bitrate, eVar.getLength());
    }

    private static boolean e(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }
}
