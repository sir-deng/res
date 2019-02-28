package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<nn> implements a {
    private boolean mWf;
    private d pZf;
    private q pZg;

    public m() {
        this.pZf = null;
        this.mWf = false;
        this.pZg = null;
        this.xmG = nn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nn nnVar = (nn) bVar;
        q qVar = nnVar.fGq.fGu;
        if (!this.mWf || qVar == null) {
            this.pZg = qVar;
            this.mWf = true;
            if (this.pZf == null) {
                this.pZf = new d(this, 3, false);
            }
            if (this.pZf.qcF) {
                this.pZf.bqd();
            }
            int i = nnVar.fGq.width;
            int i2 = nnVar.fGq.height;
            Rect rect = nnVar.fGq.fGs;
            byte[] bArr = nnVar.fGq.fGr;
            int i3 = nnVar.fGq.fGt;
            String str = "MicroMsg.RecogQBarInYUVListener";
            String str2 = "hy: request scanning width: %d, height: %d, scanRect: %s, yuvLen: %d, rotate: %d";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = rect;
            objArr[3] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[4] = Integer.valueOf(i3);
            x.i(str, str2, objArr);
            this.pZf.ozC = i3 != 0;
            this.pZf.a(bArr, new Point(i, i2), i3, rect);
        } else {
            x.w("MicroMsg.RecogQBarInYUVListener", "hy: is decoding. direct return");
            qVar.I("", -1, -1);
        }
        return false;
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pZg != null) {
            this.pZg.I(str, i2, i3);
        }
        this.mWf = false;
    }

    public final void bpp() {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
        if (this.pZg != null) {
            this.pZg.I("", -2, -1);
        }
        this.mWf = false;
    }

    public final void D(Bundle bundle) {
    }
}
