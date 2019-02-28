package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class d implements com.google.android.exoplayer2.c.d {
    public static final g aiT = new g() {
    };
    private static final int alr = t.ak("seig");
    private static final byte[] als = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private long aes;
    private f ajb;
    private final q alA;
    private final j alB;
    private final byte[] alC;
    private final Stack<a> alD;
    private final LinkedList<a> alE;
    private int alF;
    private int alG;
    private long alH;
    private int alI;
    private j alJ;
    private long alK;
    private int alL;
    private long alM;
    private b alN;
    private int alO;
    private int alP;
    private boolean alQ;
    private k alR;
    private k[] alS;
    private boolean alT;
    private final e alt;
    private final SparseArray<b> alu;
    private final j alv;
    private final j alw;
    private final j alx;
    private final j aly;
    private final j alz;
    private final int flags;
    private int sampleSize;

    private static final class a {
        public final long alU;
        public final int size;

        public a(long j, int i) {
            this.alU = j;
            this.size = i;
        }
    }

    private static final class b {
        public final g alV = new g();
        public final k alW;
        public e alX;
        public c alY;
        public int alZ;
        public int ama;
        public int amb;

        public b(k kVar) {
            this.alW = kVar;
        }

        public final void a(e eVar, c cVar) {
            this.alX = (e) com.google.android.exoplayer2.i.a.Y(eVar);
            this.alY = (c) com.google.android.exoplayer2.i.a.Y(cVar);
            this.alW.f(eVar.aeo);
            reset();
        }

        public final void reset() {
            g gVar = this.alV;
            gVar.amr = 0;
            gVar.amE = 0;
            gVar.amy = false;
            gVar.amD = false;
            gVar.amA = null;
            this.alZ = 0;
            this.amb = 0;
            this.ama = 0;
        }
    }

    public d() {
        this((byte) 0);
    }

    private d(byte b) {
        this(0, null);
    }

    public d(int i, q qVar) {
        this(0, qVar, (byte) 0);
    }

    private d(int i, q qVar, byte b) {
        this.flags = i | 0;
        this.alA = qVar;
        this.alt = null;
        this.alB = new j(16);
        this.alv = new j(h.aBW);
        this.alw = new j(5);
        this.alx = new j();
        this.aly = new j(1);
        this.alz = new j();
        this.alC = new byte[16];
        this.alD = new Stack();
        this.alE = new LinkedList();
        this.alu = new SparseArray();
        this.aes = -9223372036854775807L;
        this.alM = -9223372036854775807L;
        jw();
    }

    public final void a(f fVar) {
        this.ajb = fVar;
        if (this.alt != null) {
            b bVar = new b(fVar.ck(0));
            bVar.a(this.alt, new c(0, 0, 0, 0));
            this.alu.put(0, bVar);
            jx();
            this.ajb.jv();
        }
    }

    public final int a(e eVar) {
        while (true) {
            Object obj;
            long length;
            long position;
            int size;
            g gVar;
            int i;
            long aL;
            long j;
            int lG;
            b bVar;
            b bVar2;
            switch (this.alF) {
                case 0:
                    if (this.alI == 0) {
                        if (!eVar.a(this.alB.data, 0, 8, true)) {
                            obj = null;
                            if (obj != null) {
                                break;
                            }
                            return -1;
                        }
                        this.alI = 8;
                        this.alB.cR(0);
                        this.alH = this.alB.aL();
                        this.alG = this.alB.readInt();
                    }
                    if (this.alH == 1) {
                        eVar.readFully(this.alB.data, 8, 8);
                        this.alI += 8;
                        this.alH = this.alB.lK();
                    } else if (this.alH == 0) {
                        length = eVar.getLength();
                        if (length == -1 && !this.alD.isEmpty()) {
                            length = ((a) this.alD.peek()).alc;
                        }
                        if (length != -1) {
                            this.alH = (length - eVar.getPosition()) + ((long) this.alI);
                        }
                    }
                    if (this.alH < ((long) this.alI)) {
                        throw new o("Atom size less than header length (unsupported).");
                    }
                    position = eVar.getPosition() - ((long) this.alI);
                    if (this.alG == a.ajX) {
                        size = this.alu.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            gVar = ((b) this.alu.valueAt(i2)).alV;
                            gVar.amo = position;
                            gVar.amq = position;
                            gVar.amp = position;
                        }
                    }
                    if (this.alG == a.aju) {
                        this.alN = null;
                        this.alK = this.alH + position;
                        if (!this.alT) {
                            com.google.android.exoplayer2.c.j.a aVar = new com.google.android.exoplayer2.c.j.a(this.aes);
                            this.alT = true;
                        }
                        this.alF = 2;
                    } else {
                        i = this.alG;
                        obj = (i == a.ajO || i == a.ajQ || i == a.ajR || i == a.ajS || i == a.ajT || i == a.ajX || i == a.ajY || i == a.ajZ || i == a.akc) ? 1 : null;
                        if (obj != null) {
                            length = (eVar.getPosition() + this.alH) - 8;
                            this.alD.add(new a(this.alG, length));
                            if (this.alH == ((long) this.alI)) {
                                z(length);
                            } else {
                                jw();
                            }
                        } else {
                            i = this.alG;
                            obj = (i == a.akf || i == a.ake || i == a.ajP || i == a.ajN || i == a.akg || i == a.ajJ || i == a.ajK || i == a.akb || i == a.ajL || i == a.ajM || i == a.akh || i == a.akp || i == a.akq || i == a.aku || i == a.akt || i == a.akr || i == a.aks || i == a.akd || i == a.aka || i == a.akT) ? 1 : null;
                            if (obj != null) {
                                if (this.alI != 8) {
                                    throw new o("Leaf atom defines extended atom size (unsupported).");
                                } else if (this.alH > 2147483647L) {
                                    throw new o("Leaf atom with length > 2147483647 (unsupported).");
                                } else {
                                    this.alJ = new j((int) this.alH);
                                    System.arraycopy(this.alB.data, 0, this.alJ.data, 0, 8);
                                    this.alF = 1;
                                }
                            } else if (this.alH > 2147483647L) {
                                throw new o("Skipping atom with length > 2147483647 (unsupported).");
                            } else {
                                this.alJ = null;
                                this.alF = 1;
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        return -1;
                    }
                    break;
                case 1:
                    i = ((int) this.alH) - this.alI;
                    if (this.alJ != null) {
                        eVar.readFully(this.alJ.data, 8, i);
                        b bVar3 = new b(this.alG, this.alJ);
                        long position2 = eVar.getPosition();
                        if (!this.alD.isEmpty()) {
                            ((a) this.alD.peek()).ald.add(bVar3);
                        } else if (bVar3.type == a.ajN) {
                            j jVar = bVar3.alf;
                            jVar.cR(8);
                            i = a.cn(jVar.readInt());
                            jVar.cV(4);
                            aL = jVar.aL();
                            if (i == 0) {
                                position2 = jVar.aL() + position2;
                                length = jVar.aL();
                            } else {
                                position2 = jVar.lK() + position2;
                                length = jVar.lK();
                            }
                            long a = t.a(length, 1000000, aL);
                            jVar.cV(2);
                            int readUnsignedShort = jVar.readUnsignedShort();
                            int[] iArr = new int[readUnsignedShort];
                            long[] jArr = new long[readUnsignedShort];
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            int i3 = 0;
                            position = length;
                            length = a;
                            while (i3 < readUnsignedShort) {
                                int readInt = jVar.readInt();
                                if ((Integer.MIN_VALUE & readInt) != 0) {
                                    throw new o("Unhandled indirect reference");
                                }
                                long aL2 = jVar.aL();
                                iArr[i3] = readInt & Integer.MAX_VALUE;
                                jArr[i3] = position2;
                                jArr3[i3] = length;
                                length = position + aL2;
                                position = t.a(length, 1000000, aL);
                                jArr2[i3] = position - jArr3[i3];
                                jVar.cV(4);
                                position2 += (long) iArr[i3];
                                i3++;
                                j = position;
                                position = length;
                                length = j;
                            }
                            Pair create = Pair.create(Long.valueOf(a), new com.google.android.exoplayer2.c.a(iArr, jArr, jArr2, jArr3));
                            this.alM = ((Long) create.first).longValue();
                            obj = create.second;
                            this.alT = true;
                        } else if (bVar3.type == a.akT) {
                            j jVar2 = bVar3.alf;
                            if (this.alR != null) {
                                jVar2.cR(12);
                                jVar2.lL();
                                jVar2.lL();
                                position = t.a(jVar2.aL(), 1000000, jVar2.aL());
                                jVar2.cR(12);
                                lG = jVar2.lG();
                                this.alR.a(jVar2, lG);
                                if (this.alM != -9223372036854775807L) {
                                    this.alR.a(position + this.alM, 1, lG, 0, null);
                                } else {
                                    this.alE.addLast(new a(position, lG));
                                    this.alL += lG;
                                }
                            }
                        }
                    } else {
                        eVar.cf(i);
                    }
                    z(eVar.getPosition());
                    break;
                case 2:
                    bVar = null;
                    position = Long.MAX_VALUE;
                    lG = this.alu.size();
                    size = 0;
                    while (size < lG) {
                        gVar = ((b) this.alu.valueAt(size)).alV;
                        if (!gVar.amD || gVar.amq >= position) {
                            j = position;
                            bVar2 = bVar;
                        } else {
                            j = gVar.amq;
                            bVar2 = (b) this.alu.valueAt(size);
                        }
                        size++;
                        bVar = bVar2;
                        position = j;
                    }
                    if (bVar != null) {
                        i = (int) (position - eVar.getPosition());
                        if (i >= 0) {
                            eVar.cf(i);
                            gVar = bVar.alV;
                            eVar.readFully(gVar.amC.data, 0, gVar.amB);
                            gVar.amC.cR(0);
                            gVar.amD = false;
                            break;
                        }
                        throw new o("Offset to encryption data was negative.");
                    }
                    this.alF = 3;
                    break;
                default:
                    int size2;
                    int i4;
                    b bVar4;
                    if (this.alF == 3) {
                        if (this.alN == null) {
                            SparseArray sparseArray = this.alu;
                            bVar = null;
                            aL = Long.MAX_VALUE;
                            size2 = sparseArray.size();
                            i4 = 0;
                            while (i4 < size2) {
                                bVar4 = (b) sparseArray.valueAt(i4);
                                if (bVar4.amb != bVar4.alV.amr) {
                                    position = bVar4.alV.ams[bVar4.amb];
                                    if (position < aL) {
                                        j = position;
                                        bVar2 = bVar4;
                                        length = j;
                                        i4++;
                                        aL = length;
                                        bVar = bVar2;
                                    }
                                }
                                bVar2 = bVar;
                                length = aL;
                                i4++;
                                aL = length;
                                bVar = bVar2;
                            }
                            if (bVar == null) {
                                i = (int) (this.alK - eVar.getPosition());
                                if (i >= 0) {
                                    eVar.cf(i);
                                    jw();
                                    obj = null;
                                    if (obj == null) {
                                        break;
                                    }
                                    return 0;
                                }
                                throw new o("Offset to end of mdat was negative.");
                            }
                            i = (int) (bVar.alV.ams[bVar.amb] - eVar.getPosition());
                            if (i < 0) {
                                i = 0;
                            }
                            eVar.cf(i);
                            this.alN = bVar;
                        }
                        this.sampleSize = this.alN.alV.amu[this.alN.alZ];
                        if (this.alN.alV.amy) {
                            j jVar3;
                            b bVar5 = this.alN;
                            g gVar2 = bVar5.alV;
                            f cs = gVar2.amA != null ? gVar2.amA : bVar5.alX.cs(gVar2.amn.alq);
                            if (cs.aml != 0) {
                                jVar3 = gVar2.amC;
                                i = cs.aml;
                            } else {
                                byte[] bArr = cs.amm;
                                this.alz.l(bArr, bArr.length);
                                jVar3 = this.alz;
                                i = bArr.length;
                            }
                            boolean z = gVar2.amz[bVar5.alZ];
                            this.aly.data[0] = (byte) ((z ? FileUtils.S_IWUSR : 0) | i);
                            this.aly.cR(0);
                            k kVar = bVar5.alW;
                            kVar.a(this.aly, 1);
                            kVar.a(jVar3, i);
                            if (z) {
                                jVar3 = gVar2.amC;
                                int readUnsignedShort2 = jVar3.readUnsignedShort();
                                jVar3.cV(-2);
                                readUnsignedShort2 = (readUnsignedShort2 * 6) + 2;
                                kVar.a(jVar3, readUnsignedShort2);
                                i = (i + 1) + readUnsignedShort2;
                            } else {
                                i++;
                            }
                            this.alO = i;
                            this.sampleSize += this.alO;
                        } else {
                            this.alO = 0;
                        }
                        if (this.alN.alX.ame == 1) {
                            this.sampleSize -= 8;
                            eVar.cf(8);
                        }
                        this.alF = 4;
                        this.alP = 0;
                    }
                    g gVar3 = this.alN.alV;
                    e eVar2 = this.alN.alX;
                    k kVar2 = this.alN.alW;
                    size = this.alN.alZ;
                    if (eVar2.alo != 0) {
                        byte[] bArr2 = this.alw.data;
                        bArr2[0] = (byte) 0;
                        bArr2[1] = (byte) 0;
                        bArr2[2] = (byte) 0;
                        i4 = eVar2.alo + 1;
                        int i5 = 4 - eVar2.alo;
                        while (this.alO < this.sampleSize) {
                            if (this.alP == 0) {
                                eVar.readFully(bArr2, i5, i4);
                                this.alw.cR(0);
                                this.alP = this.alw.lJ() - 1;
                                this.alv.cR(0);
                                kVar2.a(this.alv, 4);
                                kVar2.a(this.alw, 1);
                                boolean z2 = this.alS != null && h.a(eVar2.aeo.adV, bArr2[4]);
                                this.alQ = z2;
                                this.alO += 5;
                                this.sampleSize += i5;
                            } else {
                                if (this.alQ) {
                                    this.alx.reset(this.alP);
                                    eVar.readFully(this.alx.data, 0, this.alP);
                                    kVar2.a(this.alx, this.alP);
                                    int i6 = this.alP;
                                    size2 = h.h(this.alx.data, this.alx.asN);
                                    this.alx.cR("video/hevc".equals(eVar2.aeo.adV) ? 1 : 0);
                                    this.alx.cU(size2);
                                    com.google.android.exoplayer2.f.a.g.a(gVar3.cu(size) * 1000, this.alx, this.alS);
                                    i = i6;
                                } else {
                                    i = kVar2.a(eVar, this.alP, false);
                                }
                                this.alO += i;
                                this.alP -= i;
                            }
                        }
                    } else {
                        while (this.alO < this.sampleSize) {
                            this.alO = kVar2.a(eVar, this.sampleSize - this.alO, false) + this.alO;
                        }
                    }
                    position = gVar3.cu(size) * 1000;
                    if (this.alA != null) {
                        position = this.alA.R(position);
                    }
                    i = gVar3.amx[size] ? 1 : 0;
                    com.google.android.exoplayer2.c.k.a aVar2 = null;
                    if (gVar3.amy) {
                        size = 1073741824 | i;
                        aVar2 = (gVar3.amA != null ? gVar3.amA : eVar2.cs(gVar3.amn.alq)).amk;
                    } else {
                        size = i;
                    }
                    kVar2.a(position, size, this.sampleSize, 0, aVar2);
                    while (!this.alE.isEmpty()) {
                        a aVar3 = (a) this.alE.removeFirst();
                        this.alL -= aVar3.size;
                        this.alR.a(aVar3.alU + position, 1, aVar3.size, this.alL, null);
                    }
                    bVar4 = this.alN;
                    bVar4.alZ++;
                    bVar4 = this.alN;
                    bVar4.ama++;
                    if (this.alN.ama == gVar3.amt[this.alN.amb]) {
                        bVar4 = this.alN;
                        bVar4.amb++;
                        this.alN.ama = 0;
                        this.alN = null;
                    }
                    this.alF = 3;
                    obj = 1;
                    if (obj == null) {
                        return 0;
                    }
                    break;
            }
        }
    }

    private void jw() {
        this.alF = 0;
        this.alI = 0;
    }

    private void z(long j) {
        while (!this.alD.isEmpty() && ((a) this.alD.peek()).alc == j) {
            a aVar = (a) this.alD.pop();
            if (aVar.type == a.ajO) {
                e a;
                com.google.android.exoplayer2.i.a.c(this.alt == null, "Unexpected moov box.");
                DrmInitData j2 = j(aVar.ald);
                a cr = aVar.cr(a.ajZ);
                SparseArray sparseArray = new SparseArray();
                long j3 = -9223372036854775807L;
                int size = cr.ald.size();
                for (int i = 0; i < size; i++) {
                    b bVar = (b) cr.ald.get(i);
                    j jVar;
                    if (bVar.type == a.ajL) {
                        jVar = bVar.alf;
                        jVar.cR(12);
                        Pair create = Pair.create(Integer.valueOf(jVar.readInt()), new c(jVar.lJ() - 1, jVar.lJ(), jVar.lJ(), jVar.readInt()));
                        sparseArray.put(((Integer) create.first).intValue(), create.second);
                    } else if (bVar.type == a.aka) {
                        jVar = bVar.alf;
                        jVar.cR(8);
                        j3 = a.cn(jVar.readInt()) == 0 ? jVar.aL() : jVar.lK();
                    }
                }
                SparseArray sparseArray2 = new SparseArray();
                int size2 = aVar.ale.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    a aVar2 = (a) aVar.ale.get(i2);
                    if (aVar2.type == a.ajQ) {
                        a = b.a(aVar2, aVar.cq(a.ajP), j3, j2, (this.flags & 32) != 0);
                        if (a != null) {
                            sparseArray2.put(a.id, a);
                        }
                    }
                }
                int size3 = sparseArray2.size();
                if (this.alu.size() == 0) {
                    for (int i3 = 0; i3 < size3; i3++) {
                        e eVar = (e) sparseArray2.valueAt(i3);
                        b bVar2 = new b(this.ajb.ck(i3));
                        bVar2.a(eVar, (c) sparseArray.get(eVar.id));
                        this.alu.put(eVar.id, bVar2);
                        this.aes = Math.max(this.aes, eVar.aes);
                    }
                    jx();
                    this.ajb.jv();
                } else {
                    com.google.android.exoplayer2.i.a.ap(this.alu.size() == size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        a = (e) sparseArray2.valueAt(i4);
                        ((b) this.alu.get(a.id)).a(a, (c) sparseArray.get(a.id));
                    }
                }
            } else if (aVar.type == a.ajX) {
                b(aVar);
            } else if (!this.alD.isEmpty()) {
                ((a) this.alD.peek()).ale.add(aVar);
            }
        }
        jw();
    }

    private void b(a aVar) {
        SparseArray sparseArray = this.alu;
        int i = this.flags;
        byte[] bArr = this.alC;
        int size = aVar.ale.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            b bVar;
            if (i3 < size) {
                a aVar2 = (a) aVar.ale.get(i3);
                if (aVar2.type == a.ajY) {
                    b bVar2;
                    j jVar = aVar2.cq(a.ajK).alf;
                    jVar.cR(8);
                    int co = a.co(jVar.readInt());
                    i2 = jVar.readInt();
                    if ((i & 16) != 0) {
                        i2 = 0;
                    }
                    bVar = (b) sparseArray.get(i2);
                    if (bVar == null) {
                        bVar2 = null;
                    } else {
                        if ((co & 1) != 0) {
                            long lK = jVar.lK();
                            bVar.alV.amp = lK;
                            bVar.alV.amq = lK;
                        }
                        c cVar = bVar.alY;
                        bVar.alV.amn = new c((co & 2) != 0 ? jVar.lJ() - 1 : cVar.alq, (co & 8) != 0 ? jVar.lJ() : cVar.duration, (co & 16) != 0 ? jVar.lJ() : cVar.size, (co & 32) != 0 ? jVar.lJ() : cVar.flags);
                        bVar2 = bVar;
                    }
                    if (bVar2 != null) {
                        long j;
                        j jVar2;
                        int i4;
                        b bVar3;
                        int i5;
                        g gVar = bVar2.alV;
                        long j2 = gVar.amE;
                        bVar2.reset();
                        if (aVar2.cq(a.ajJ) == null || (i & 2) != 0) {
                            j = j2;
                        } else {
                            jVar2 = aVar2.cq(a.ajJ).alf;
                            jVar2.cR(8);
                            j = a.cn(jVar2.readInt()) == 1 ? jVar2.lK() : jVar2.aL();
                        }
                        int i6 = 0;
                        int i7 = 0;
                        List list = aVar2.ald;
                        int size2 = list.size();
                        i2 = 0;
                        while (true) {
                            i4 = i2;
                            if (i4 >= size2) {
                                break;
                            }
                            bVar3 = (b) list.get(i4);
                            if (bVar3.type == a.ajM) {
                                jVar2 = bVar3.alf;
                                jVar2.cR(12);
                                i2 = jVar2.lJ();
                                if (i2 > 0) {
                                    i2 += i7;
                                    i7 = i6 + 1;
                                    i4++;
                                    i6 = i7;
                                }
                            }
                            i2 = i7;
                            i7 = i6;
                            i4++;
                            i6 = i7;
                        }
                        bVar2.amb = 0;
                        bVar2.ama = 0;
                        bVar2.alZ = 0;
                        g gVar2 = bVar2.alV;
                        gVar2.amr = i6;
                        gVar2.sampleCount = i7;
                        if (gVar2.amt == null || gVar2.amt.length < i6) {
                            gVar2.ams = new long[i6];
                            gVar2.amt = new int[i6];
                        }
                        if (gVar2.amu == null || gVar2.amu.length < i7) {
                            i7 = (i7 * 125) / 100;
                            gVar2.amu = new int[i7];
                            gVar2.amv = new int[i7];
                            gVar2.amw = new long[i7];
                            gVar2.amx = new boolean[i7];
                            gVar2.amz = new boolean[i7];
                        }
                        int i8 = 0;
                        int i9 = 0;
                        for (int i10 = 0; i10 < size2; i10++) {
                            bVar3 = (b) list.get(i10);
                            if (bVar3.type == a.ajM) {
                                long a;
                                int i11 = i8 + 1;
                                j jVar3 = bVar3.alf;
                                jVar3.cR(8);
                                i7 = a.co(jVar3.readInt());
                                e eVar = bVar2.alX;
                                g gVar3 = bVar2.alV;
                                c cVar2 = gVar3.amn;
                                gVar3.amt[i8] = jVar3.lJ();
                                gVar3.ams[i8] = gVar3.amp;
                                if ((i7 & 1) != 0) {
                                    long[] jArr = gVar3.ams;
                                    jArr[i8] = jArr[i8] + ((long) jVar3.readInt());
                                }
                                Object obj = (i7 & 4) != 0 ? 1 : null;
                                int i12 = cVar2.flags;
                                if (obj != null) {
                                    i12 = jVar3.lJ();
                                }
                                Object obj2 = (i7 & 256) != 0 ? 1 : null;
                                Object obj3 = (i7 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 ? 1 : null;
                                Object obj4 = (i7 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 1 : null;
                                Object obj5 = (i7 & 2048) != 0 ? 1 : null;
                                if (eVar.amf != null && eVar.amf.length == 1 && eVar.amf[0] == 0) {
                                    a = t.a(eVar.amg[0], 1000, eVar.amc);
                                } else {
                                    a = 0;
                                }
                                int[] iArr = gVar3.amu;
                                int[] iArr2 = gVar3.amv;
                                long[] jArr2 = gVar3.amw;
                                boolean[] zArr = gVar3.amx;
                                Object obj6 = (eVar.type != 2 || (i & 1) == 0) ? null : 1;
                                int i13 = i9 + gVar3.amt[i8];
                                long j3 = eVar.amc;
                                j2 = i8 > 0 ? gVar3.amE : j;
                                while (true) {
                                    int i14 = i9;
                                    if (i14 >= i13) {
                                        break;
                                    }
                                    int lJ = obj2 != null ? jVar3.lJ() : cVar2.duration;
                                    i8 = obj3 != null ? jVar3.lJ() : cVar2.size;
                                    i9 = (i14 != 0 || obj == null) ? obj4 != null ? jVar3.readInt() : cVar2.flags : i12;
                                    if (obj5 != null) {
                                        iArr2[i14] = (int) ((((long) jVar3.readInt()) * 1000) / j3);
                                    } else {
                                        iArr2[i14] = 0;
                                    }
                                    jArr2[i14] = t.a(j2, 1000, j3) - a;
                                    iArr[i14] = i8;
                                    boolean z = ((i9 >> 16) & 1) == 0 && (obj6 == null || i14 == 0);
                                    zArr[i14] = z;
                                    j2 += (long) lJ;
                                    i9 = i14 + 1;
                                }
                                gVar3.amE = j2;
                                i2 = i13;
                                i7 = i11;
                            } else {
                                i2 = i9;
                                i7 = i8;
                            }
                            i9 = i2;
                            i8 = i7;
                        }
                        f cs = bVar2.alX.cs(gVar.amn.alq);
                        bVar3 = aVar2.cq(a.akp);
                        if (bVar3 != null) {
                            j jVar4 = bVar3.alf;
                            i5 = cs.aml;
                            jVar4.cR(8);
                            if ((a.co(jVar4.readInt()) & 1) == 1) {
                                jVar4.cV(8);
                            }
                            i7 = jVar4.readUnsignedByte();
                            co = jVar4.lJ();
                            if (co != gVar.sampleCount) {
                                throw new o("Length mismatch: " + co + ", " + gVar.sampleCount);
                            }
                            i2 = 0;
                            if (i7 == 0) {
                                boolean[] zArr2 = gVar.amz;
                                i6 = 0;
                                while (i6 < co) {
                                    int readUnsignedByte = jVar4.readUnsignedByte();
                                    i7 = i2 + readUnsignedByte;
                                    zArr2[i6] = readUnsignedByte > i5;
                                    i6++;
                                    i2 = i7;
                                }
                            } else {
                                boolean z2 = i7 > i5;
                                i7 = (i7 * co) + 0;
                                Arrays.fill(gVar.amz, 0, co, z2);
                                i2 = i7;
                            }
                            gVar.ct(i2);
                        }
                        bVar3 = aVar2.cq(a.akq);
                        if (bVar3 != null) {
                            jVar2 = bVar3.alf;
                            jVar2.cR(8);
                            i7 = jVar2.readInt();
                            if ((a.co(i7) & 1) == 1) {
                                jVar2.cV(8);
                            }
                            i6 = jVar2.lJ();
                            if (i6 != 1) {
                                throw new o("Unexpected saio entry count: " + i6);
                            }
                            gVar.amq = (a.cn(i7) == 0 ? jVar2.aL() : jVar2.lK()) + gVar.amq;
                        }
                        bVar3 = aVar2.cq(a.aku);
                        if (bVar3 != null) {
                            a(bVar3.alf, 0, gVar);
                        }
                        bVar3 = aVar2.cq(a.akr);
                        b cq = aVar2.cq(a.aks);
                        if (!(bVar3 == null || cq == null)) {
                            jVar2 = bVar3.alf;
                            j jVar5 = cq.alf;
                            String str = cs != null ? cs.amj : null;
                            jVar2.cR(8);
                            i4 = jVar2.readInt();
                            if (jVar2.readInt() == alr) {
                                if (a.cn(i4) == 1) {
                                    jVar2.cV(4);
                                }
                                if (jVar2.readInt() != 1) {
                                    throw new o("Entry count in sbgp != 1 (unsupported).");
                                }
                                jVar5.cR(8);
                                i2 = jVar5.readInt();
                                if (jVar5.readInt() == alr) {
                                    i2 = a.cn(i2);
                                    if (i2 == 1) {
                                        if (jVar5.aL() == 0) {
                                            throw new o("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (i2 >= 2) {
                                        jVar5.cV(4);
                                    }
                                    if (jVar5.aL() != 1) {
                                        throw new o("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    jVar5.cV(1);
                                    i2 = jVar5.readUnsignedByte();
                                    i5 = (i2 & 240) >> 4;
                                    co = i2 & 15;
                                    if ((jVar5.readUnsignedByte() == 1 ? 1 : null) != null) {
                                        i4 = jVar5.readUnsignedByte();
                                        byte[] bArr2 = new byte[16];
                                        jVar5.readBytes(bArr2, 0, 16);
                                        byte[] bArr3 = null;
                                        if (i4 == 0) {
                                            i2 = jVar5.readUnsignedByte();
                                            bArr3 = new byte[i2];
                                            jVar5.readBytes(bArr3, 0, i2);
                                        }
                                        gVar.amy = true;
                                        gVar.amA = new f(true, str, i4, bArr2, i5, co, bArr3);
                                    }
                                }
                            }
                        }
                        i6 = aVar2.ald.size();
                        for (i7 = 0; i7 < i6; i7++) {
                            bVar3 = (b) aVar2.ald.get(i7);
                            if (bVar3.type == a.akt) {
                                jVar2 = bVar3.alf;
                                jVar2.cR(8);
                                jVar2.readBytes(bArr, 0, 16);
                                if (Arrays.equals(bArr, als)) {
                                    a(jVar2, 16, gVar);
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i2 = i3 + 1;
            } else {
                DrmInitData j4 = j(aVar.ald);
                if (j4 != null) {
                    int size3 = this.alu.size();
                    i2 = 0;
                    while (true) {
                        int i15 = i2;
                        if (i15 < size3) {
                            bVar = (b) this.alu.valueAt(i15);
                            f cs2 = bVar.alX.cs(bVar.alV.amn.alq);
                            String str2 = cs2 != null ? cs2.amj : null;
                            k kVar = bVar.alW;
                            Format format = bVar.alX.aeo;
                            kVar.f(new Format(format.id, format.adU, format.adV, format.adS, format.bitrate, format.adW, format.width, format.height, format.adZ, format.aea, format.aeb, format.aed, format.aec, format.aee, format.aef, format.sampleRate, format.aeg, format.aeh, format.aei, format.aek, format.ael, format.aem, format.aej, format.adX, j4.O(str2), format.adT));
                            i2 = i15 + 1;
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
        }
    }

    private void jx() {
        if ((this.flags & 4) != 0 && this.alR == null) {
            this.alR = this.ajb.ck(this.alu.size());
            this.alR.f(Format.b("application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.flags & 8) != 0 && this.alS == null) {
            this.ajb.ck(this.alu.size() + 1).f(Format.L("application/cea-608"));
            this.alS = new k[]{r0};
        }
    }

    private static void a(j jVar, int i, g gVar) {
        jVar.cR(i + 8);
        int co = a.co(jVar.readInt());
        if ((co & 1) != 0) {
            throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z;
        if ((co & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int lJ = jVar.lJ();
        if (lJ != gVar.sampleCount) {
            throw new o("Length mismatch: " + lJ + ", " + gVar.sampleCount);
        }
        Arrays.fill(gVar.amz, 0, lJ, z);
        gVar.ct(jVar.lG());
        jVar.readBytes(gVar.amC.data, 0, gVar.amB);
        gVar.amC.cR(0);
        gVar.amD = false;
    }

    private static DrmInitData j(List<b> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) list.get(i);
            if (bVar.type == a.akh) {
                Pair pair;
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = bVar.alf.data;
                j jVar = new j(bArr);
                if (jVar.asN < 32) {
                    pair = null;
                } else {
                    jVar.cR(0);
                    if (jVar.readInt() != jVar.lG() + 4) {
                        pair = null;
                    } else if (jVar.readInt() != a.akh) {
                        pair = null;
                    } else {
                        int cn = a.cn(jVar.readInt());
                        if (cn > 1) {
                            pair = null;
                        } else {
                            UUID uuid = new UUID(jVar.readLong(), jVar.readLong());
                            if (cn == 1) {
                                jVar.cV(jVar.lJ() * 16);
                            }
                            cn = jVar.lJ();
                            if (cn != jVar.lG()) {
                                pair = null;
                            } else {
                                Object obj = new byte[cn];
                                jVar.readBytes(obj, 0, cn);
                                pair = Pair.create(uuid, obj);
                            }
                        }
                    }
                }
                UUID uuid2 = pair == null ? null : (UUID) pair.first;
                if (uuid2 != null) {
                    list2.add(new SchemeData(uuid2, "video/mp4", bArr));
                }
            }
        }
        return list2 == null ? null : new DrmInitData(list2);
    }
}
