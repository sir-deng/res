package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.b;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.AnonymousClass5;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

final class i implements com.google.android.exoplayer2.source.i {
    public final int atY;
    private final j atZ;

    public i(j jVar, int i) {
        this.atZ = jVar;
        this.atY = i;
    }

    public final boolean it() {
        j jVar = this.atZ;
        return jVar.auv || (!jVar.kF() && jVar.auh[this.atY].asl.kh());
    }

    public final void kd() {
        this.atZ.kd();
    }

    public final int b(k kVar, e eVar, boolean z) {
        j jVar = this.atZ;
        int i = this.atY;
        if (jVar.kF()) {
            return -3;
        }
        int i2;
        int i3;
        Object obj;
        int i4;
        if (!jVar.auf.isEmpty()) {
            while (jVar.auf.size() > 1) {
                i2 = ((f) jVar.auf.getFirst()).uid;
                for (i3 = 0; i3 < jVar.auh.length; i3++) {
                    if (jVar.aup[i3]) {
                        g gVar = jVar.auh[i3].asl;
                        if ((gVar.kh() ? gVar.arW[gVar.cD(gVar.asc)] : gVar.asi) == i2) {
                            obj = null;
                            break;
                        }
                    }
                }
                obj = 1;
                if (obj == null) {
                    break;
                }
                jVar.auf.removeFirst();
            }
            f fVar = (f) jVar.auf.getFirst();
            Format format = fVar.asI;
            if (!format.equals(jVar.aul)) {
                a aVar = jVar.atO;
                i2 = jVar.ach;
                i4 = fVar.asJ;
                Object obj2 = fVar.asK;
                long j = fVar.asL;
                if (aVar.ars != null) {
                    aVar.handler.post(new AnonymousClass5(i2, format, i4, obj2, j));
                }
            }
            jVar.aul = format;
        }
        h hVar = jVar.auh[i];
        boolean z2 = jVar.auv;
        long j2 = jVar.aur;
        switch (hVar.asl.a(kVar, eVar, z, z2, hVar.asq, hVar.asm)) {
            case -5:
                hVar.asq = kVar.aeo;
                return -5;
            case -4:
                if (!eVar.iZ()) {
                    long j3;
                    if (eVar.aig < j2) {
                        eVar.ca(Integer.MIN_VALUE);
                    }
                    if (eVar.je()) {
                        g.a aVar2 = hVar.asm;
                        j3 = aVar2.oJ;
                        hVar.aiY.reset(1);
                        hVar.a(j3, hVar.aiY.data, 1);
                        long j4 = 1 + j3;
                        byte b = hVar.aiY.data[0];
                        obj = (b & FileUtils.S_IWUSR) != 0 ? 1 : null;
                        int i5 = b & 127;
                        if (eVar.aie.iv == null) {
                            eVar.aie.iv = new byte[16];
                        }
                        hVar.a(j4, eVar.aie.iv, i5);
                        j4 += (long) i5;
                        if (obj != null) {
                            hVar.aiY.reset(2);
                            hVar.a(j4, hVar.aiY.data, 2);
                            j4 += 2;
                            i5 = hVar.aiY.readUnsignedShort();
                        } else {
                            i5 = 1;
                        }
                        int[] iArr = eVar.aie.numBytesOfClearData;
                        if (iArr == null || iArr.length < i5) {
                            iArr = new int[i5];
                        }
                        int[] iArr2 = eVar.aie.numBytesOfEncryptedData;
                        if (iArr2 == null || iArr2.length < i5) {
                            iArr2 = new int[i5];
                        }
                        if (obj != null) {
                            i3 = i5 * 6;
                            hVar.aiY.reset(i3);
                            hVar.a(j4, hVar.aiY.data, i3);
                            j4 += (long) i3;
                            hVar.aiY.cR(0);
                            for (i3 = 0; i3 < i5; i3++) {
                                iArr[i3] = hVar.aiY.readUnsignedShort();
                                iArr2[i3] = hVar.aiY.lJ();
                            }
                        } else {
                            iArr[0] = 0;
                            iArr2[0] = aVar2.size - ((int) (j4 - aVar2.oJ));
                        }
                        com.google.android.exoplayer2.c.k.a aVar3 = aVar2.amk;
                        b bVar = eVar.aie;
                        byte[] bArr = aVar3.aiR;
                        byte[] bArr2 = eVar.aie.iv;
                        int i6 = aVar3.aiQ;
                        int i7 = aVar3.ahS;
                        i3 = aVar3.ahT;
                        bVar.numSubSamples = i5;
                        bVar.numBytesOfClearData = iArr;
                        bVar.numBytesOfEncryptedData = iArr2;
                        bVar.key = bArr;
                        bVar.iv = bArr2;
                        bVar.mode = i6;
                        bVar.ahS = i7;
                        bVar.ahT = i3;
                        if (t.SDK_INT >= 16) {
                            bVar.ahU.numSubSamples = bVar.numSubSamples;
                            bVar.ahU.numBytesOfClearData = bVar.numBytesOfClearData;
                            bVar.ahU.numBytesOfEncryptedData = bVar.numBytesOfEncryptedData;
                            bVar.ahU.key = bVar.key;
                            bVar.ahU.iv = bVar.iv;
                            bVar.ahU.mode = bVar.mode;
                            if (t.SDK_INT >= 24) {
                                a aVar4 = bVar.ahV;
                                aVar4.ahW.set(bVar.ahS, bVar.ahT);
                                aVar4.ahU.setPattern(aVar4.ahW);
                            }
                        }
                        i3 = (int) (j4 - aVar2.oJ);
                        aVar2.oJ += (long) i3;
                        aVar2.size -= i3;
                    }
                    eVar.cc(hVar.asm.size);
                    j3 = hVar.asm.oJ;
                    ByteBuffer byteBuffer = eVar.aif;
                    i2 = hVar.asm.size;
                    hVar.G(j3);
                    while (i2 > 0) {
                        i4 = Math.min(i2, (int) (hVar.aso.alc - j3));
                        byteBuffer.put(hVar.aso.asy.data, hVar.aso.I(j3), i4);
                        i2 -= i4;
                        j3 += (long) i4;
                        if (j3 == hVar.aso.alc) {
                            hVar.aso = hVar.aso.asz;
                        }
                    }
                }
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final void D(long j) {
        j jVar = this.atZ;
        h hVar = jVar.auh[this.atY];
        if (!jVar.auv || j <= hVar.asl.kj()) {
            hVar.d(j, true);
        } else {
            hVar.asl.kk();
        }
    }
}
