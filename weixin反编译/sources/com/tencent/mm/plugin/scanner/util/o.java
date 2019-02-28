package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements i {
    private String mPicUrl = null;

    public o(String str) {
        this.mPicUrl = str;
    }

    public final String Wo() {
        return c.bpi().dZ(this.mPicUrl, "@S");
    }

    public final String Wp() {
        return this.mPicUrl;
    }

    public final String Wq() {
        return this.mPicUrl;
    }

    public final String Wr() {
        return this.mPicUrl;
    }

    public final boolean Ws() {
        return false;
    }

    public final boolean Wt() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Wv() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final Bitmap Wu() {
        if (ad.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
    }

    public final b Wn() {
        return null;
    }
}
