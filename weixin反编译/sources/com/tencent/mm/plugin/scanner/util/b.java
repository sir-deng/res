package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int qfE = 0;
    protected int fqW;
    protected int fqX;
    protected a qfA = null;
    protected byte[] qfB = null;
    protected byte[] qfC = null;
    public String qfD;
    public boolean[] qfF = null;

    public interface a {
        void D(Bundle bundle);

        void a(int i, String str, byte[] bArr, int i2, int i3);

        void bpp();
    }

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void bqd();

    public abstract void kM();

    public b(a aVar) {
        this.qfA = aVar;
    }

    public final void a(byte[] bArr, Point point, int i, Rect rect) {
        x.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
        final byte[] bArr2 = bArr;
        final int i2 = i;
        final Point point2 = point;
        final Rect rect2 = rect;
        e.b(new Runnable() {
            public final void run() {
                byte[] bArr = bArr2;
                if (270 == i2) {
                    byte[] bArr2 = new byte[bArr2.length];
                    QbarNative.a(bArr2, bArr2, point2.x, point2.y);
                    bArr = new byte[bArr2.length];
                    QbarNative.a(bArr, bArr2, point2.y, point2.x);
                    QbarNative.nativeRelease();
                }
                x.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                if (bArr == null || !b.this.a(bArr, point2, rect2)) {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (b.this.qfA != null) {
                                x.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                                b.this.qfA.bpp();
                            }
                        }
                    });
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (b.this.qfA != null) {
                                b.this.qfA.a(b.qfE, b.this.qfD, b.this.qfC, b.this.fqW, b.this.fqX);
                            }
                        }
                    });
                }
            }
        }, "scan_decode", 10);
    }
}
