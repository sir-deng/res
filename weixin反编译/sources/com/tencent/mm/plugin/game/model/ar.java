package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class ar implements i {
    protected String mPicUrl;

    public ar(String str) {
        this.mPicUrl = str;
        File file = new File(e.gJh);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final b Wn() {
        return null;
    }

    public final String Wo() {
        return e.gJh + g.s(this.mPicUrl.getBytes());
    }

    public final String Wp() {
        return this.mPicUrl;
    }

    public final String Wq() {
        return this.mPicUrl.hashCode();
    }

    public final String Wr() {
        return this.mPicUrl.hashCode();
    }

    public final boolean Ws() {
        return true;
    }

    public final boolean Wt() {
        return false;
    }

    public final Bitmap Wu() {
        return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.DISK != aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
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
}
