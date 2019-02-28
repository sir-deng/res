package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.x;
import f.a;

public final class c extends a {
    public final byte[] fGr;
    public int height;
    public int left;
    final int qfI;
    final int qfJ;
    public int top;
    public int width;

    public c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        x.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
        this.fGr = bArr;
        this.qfI = i;
        this.qfJ = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
    }

    public final byte[] l(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        Object bArr2;
        if (bArr2 == null || bArr2.length < this.width) {
            bArr2 = new byte[this.width];
        }
        System.arraycopy(this.fGr, ((this.top + i) * this.qfI) + this.left, bArr2, 0, this.width);
        return bArr2;
    }

    public static void bqe() {
        l bqw = l.bqw();
        if (bqw.qgT != null) {
            bqw.qgT = null;
        }
        if (bqw.qgU != null) {
            bqw.qgU = null;
        }
        System.gc();
    }

    public final byte[] bqf() {
        if (this.width == this.qfI && this.height == this.qfJ) {
            return this.fGr;
        }
        try {
            int i = this.width * this.height;
            l bqw = l.bqw();
            if (bqw.qgT == null) {
                bqw.qgT = new byte[i];
            } else if (bqw.qgT.length != i) {
                bqw.qgT = null;
                bqw.qgT = new byte[i];
            }
            byte[] bArr = bqw.qgT;
            int i2 = (this.top * this.qfI) + this.left;
            if (this.width == this.qfI) {
                System.arraycopy(this.fGr, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.fGr;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.qfI;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.fGr.length + " dataWidth:" + this.qfI + " dataHeight:" + this.qfJ + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }

    public final byte[] bqg() {
        if (this.width == this.qfI && this.height == this.qfJ) {
            return this.fGr;
        }
        try {
            int i = this.width * this.height;
            byte[] bArr = new byte[i];
            int i2 = (this.top * this.qfI) + this.left;
            if (this.width == this.qfI) {
                System.arraycopy(this.fGr, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.fGr;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.qfI;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.fGr.length + " dataWidth:" + this.qfI + " dataHeight:" + this.qfJ + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }
}
