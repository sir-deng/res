package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.x;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String kEe = h.kDY;
    public static String kEf = h.kDZ;
    public static String kEg = h.kEa;
    private final int kEh;
    private final int kEi;
    private final int kEj;
    private final int kEk;
    private final int kEl;
    b kEm;
    a kEn;
    int kEo;

    private class b {
        public boolean kEp = false;
        public int kEr = 0;
        public int kEs = 0;
        public int kEt = 0;
        public c kEu = new c();
        public double kEw = 0.0d;
        public double kEx = 0.0d;
        public double kEy = 0.0d;
    }

    private class a {
        public boolean kEp = false;
        public double kEq = 0.0d;
        public int kEr = 0;
        public int kEs = 0;
        public int kEt = 0;
        public c kEu = new c();
    }

    public static class c {
        public int kEA = 0;
        public int kEB = 0;
        public int kEC = 0;
        public int kED = 0;
        public int kEE = 0;
        public int kEz = 0;

        public final boolean I(byte[] bArr, int i) {
            String bz = b.TAG;
            String str = "data size = %d, offset = %d, lenght = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(7);
            x.d(bz, str, objArr);
            if (bArr == null || i < 0 || bArr.length < i + 7) {
                x.e(b.TAG, "data input error");
                return false;
            }
            this.kEz = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            this.kEA = bArr[i + 2] & 255;
            this.kEB = bArr[i + 3] & 255;
            this.kEC = bArr[i + 4] & 255;
            this.kED = bArr[i + 5] & 255;
            this.kEE = bArr[i + 6] & 255;
            x.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(this.kEz), Integer.valueOf(this.kEA), Integer.valueOf(this.kEB), Integer.valueOf(this.kEC), Integer.valueOf(this.kED), Integer.valueOf(this.kEE));
            return true;
        }
    }

    public b() {
        this.kEh = 1;
        this.kEi = 2;
        this.kEj = 4;
        this.kEk = 8;
        this.kEl = 16;
        this.kEc = null;
        this.kEd = 2;
        this.kDv = 8;
        this.kEm = null;
    }

    static double H(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        x.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        return pow;
    }

    public final byte[] arZ() {
        return null;
    }
}
