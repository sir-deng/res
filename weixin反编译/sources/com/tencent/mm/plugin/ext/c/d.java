package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static SparseArray<byte[]> mgU = new SparseArray(1);

    interface c {
        b ak(String str, boolean z);
    }

    public static class a implements c {
        public final b ak(String str, boolean z) {
            if (FileOp.bO(str)) {
                return d.c(FileOp.d(str, 0, -1), z);
            }
            x.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
            return null;
        }
    }

    static class b {
        byte[] fGr;
        int fGt;
        public String frM;
        int mgV;
        int mgW;
        Rect mgX;

        public b(byte[] bArr, int i, int i2, int i3, Rect rect, String str) {
            this.fGr = bArr;
            this.mgV = i;
            this.mgW = i2;
            this.fGt = i3;
            this.mgX = rect;
            this.frM = str;
        }

        public final String toString() {
            return "RetrieveResult{yuvDataLength=" + (this.fGr != null ? Integer.valueOf(this.fGr.length) : "null") + ", previewWidth=" + this.mgV + ", previewHeight=" + this.mgW + ", rotate=" + this.fGt + ", scanRect=" + this.mgX + ", md5=" + this.frM + '}';
        }
    }

    static /* synthetic */ b c(byte[] bArr, boolean z) {
        String str = null;
        if (bArr == null || bArr.length <= 14) {
            x.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            return null;
        }
        Object obj;
        if (z) {
            str = g.s(bArr);
        }
        Object obj2 = new byte[4];
        System.arraycopy(bArr, 0, obj2, 0, 4);
        Object obj3 = new byte[4];
        System.arraycopy(bArr, 4, obj3, 0, 4);
        Object obj4 = new byte[4];
        System.arraycopy(bArr, 8, obj4, 0, 4);
        Object obj5 = new byte[4];
        System.arraycopy(bArr, 12, obj5, 0, 4);
        Object obj6 = new byte[4];
        System.arraycopy(bArr, 16, obj6, 0, 4);
        Object obj7 = new byte[4];
        System.arraycopy(bArr, 20, obj7, 0, 4);
        Object obj8 = new byte[4];
        System.arraycopy(bArr, 24, obj8, 0, 4);
        int length = bArr.length - 28;
        Object obj9 = (byte[]) mgU.get(length);
        if (obj9 == null) {
            obj = new byte[length];
            mgU.put(length, obj);
        } else {
            obj = obj9;
        }
        System.arraycopy(bArr, 28, obj, 0, length);
        int av = av(obj2);
        int av2 = av(obj3);
        length = av(obj4);
        int av3 = av(obj5);
        x.i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", new b(obj, av, av2, av(obj8), new Rect(length, av3, av(obj6) + length, av(obj7) + av3), str));
        return new b(obj, av, av2, av(obj8), new Rect(length, av3, av(obj6) + length, av(obj7) + av3), str);
    }

    static c aGD() {
        return new a();
    }

    private static int av(byte[] bArr) {
        return (((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24);
    }
}
