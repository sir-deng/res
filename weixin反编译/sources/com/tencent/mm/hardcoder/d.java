package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static a gMN = null;

    public interface a {
        void a(int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr2, int[] iArr3);

        void a(int i, long j, int i2, int i3, int i4);

        void reportIDKey(boolean z, int i, int i2, boolean z2);
    }

    public static void a(a aVar) {
        int i;
        int i2 = (int) (aVar.gMo - aVar.gLY);
        int i3 = HardCoderJNI.isHCEnable() ? 1 : 0;
        int i4 = i2 - aVar.delay <= 0 ? 1 : 0;
        int i5 = aVar.scene;
        long j = aVar.gLX;
        int i6 = aVar.gLU;
        int i7 = aVar.gLV;
        int[] iArr = aVar.gMf;
        int i8 = (int) (aVar.gLZ - aVar.startTime);
        int i9 = aVar.gMj;
        int i10 = 0;
        if (aVar.gMl != null) {
            i10 = (int) (0 + aVar.gMl.gMU);
        }
        if (aVar.gMm != null) {
            i = (int) (((long) i10) + aVar.gMm.gMU);
        } else {
            i = i10;
        }
        int i11 = HardCoderJNI.TICK_RATE;
        long j2 = aVar.gMk;
        int[] iArr2 = aVar.gMd;
        int[] iArr3 = aVar.gMe;
        StringBuilder stringBuilder = new StringBuilder();
        if (iArr != null) {
            for (int i12 : iArr) {
                stringBuilder.append(i12 + "#");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                stringBuilder2.append(i13 + "#");
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        if (iArr3 != null) {
            for (int i14 : iArr3) {
                stringBuilder3.append(i14 + "#");
            }
        }
        if (aVar.gLW != 0 && HardCoderJNI.hcDebug) {
            x.i("MicroMsg.HardCoderReporter", "[oneliang]performance report,hash:%s,threadId:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", Integer.valueOf(aVar.hashCode()), Integer.valueOf(aVar.gLW), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(aVar.gMb), Integer.valueOf(i6), Integer.valueOf(aVar.gMc), Integer.valueOf(i7), stringBuilder.toString(), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i9), Integer.valueOf(i), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder3.toString());
        }
        if (gMN != null) {
            gMN.a(aVar.gLW, i3, i4, i5, j, i6, i7, iArr, i8, i2, i9, i, i11, j2, iArr2, iArr3);
        }
    }

    public static void a(int i, long j, int i2, int i3, int i4) {
        if (gMN != null) {
            gMN.a(i, j, i2, i3, i4);
        }
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        if (gMN != null) {
            gMN.reportIDKey(z, i, i2, z2);
        }
    }

    public static void a(a aVar) {
        if (gMN == null) {
            x.i("MicroMsg.HardCoderReporter", "hardcoder setReporter[%s], stack[%s]", aVar, bi.chl());
            gMN = aVar;
        }
    }
}
