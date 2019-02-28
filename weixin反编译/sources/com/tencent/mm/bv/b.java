package com.tencent.mm.bv;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class b {
    public byte[] kCs;
    public SparseArray<a> xjQ;

    static class a {
        public final int xjR;
        public final int[] xjS;
        public final int[] xjT;

        public a(int i, int[] iArr, int[] iArr2) {
            this.xjR = i;
            this.xjS = iArr;
            this.xjT = iArr2;
        }
    }

    private b(SparseArray<a> sparseArray, byte[] bArr) {
        this.xjQ = sparseArray;
        this.kCs = bArr;
    }

    public static b a(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new b(sparseArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", bi.i(e));
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        Throwable e;
        String str;
        try {
            int indexOfKey = this.xjQ.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            a aVar = (a) this.xjQ.valueAt(indexOfKey);
            int length = aVar.xjS.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (aVar.xjS[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.xjQ.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.kCs, aVar.xjT[i4], ((a) this.xjQ.valueAt(indexOfKey + 1)).xjT[0] - aVar.xjT[i4]);
                } else {
                    str = new String(this.kCs, aVar.xjT[i4], aVar.xjT[i4 + 1] - aVar.xjT[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.kCs, aVar.xjT[i4], this.kCs.length - aVar.xjT[i4]);
            } else {
                str = new String(this.kCs, aVar.xjT[i4], aVar.xjT[i4 + 1] - aVar.xjT[i4]);
            }
            try {
                if (bi.oN(str) || objArr != null) {
                    return String.format(str, objArr);
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bi.i(e));
                return str;
            }
        } catch (Throwable e3) {
            e = e3;
            str = null;
            x.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bi.i(e));
            return str;
        }
    }
}
