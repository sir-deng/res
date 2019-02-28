package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends m {
    public n(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Bitmap bitmap = ((k) this.qdg).qgR;
        com.tencent.mm.sdk.b.b olVar = new ol();
        olVar.fHf.cardType = "identity";
        olVar.fHf.fHg = 1;
        if (this.qdg instanceof k) {
            olVar.fHf.fHi = bitmap;
        }
        a.xmy.a(olVar, Looper.getMainLooper());
        this.qdm.getContext().finish();
    }
}
