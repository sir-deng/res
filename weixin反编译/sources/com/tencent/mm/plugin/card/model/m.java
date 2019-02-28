package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class m implements i {
    public static final String kRo = (e.bnF + "card");
    public static final String kRp = (kRo + File.separator + SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    public m(String str) {
        this.mPicUrl = str;
    }

    public final b Wn() {
        return null;
    }

    public final String Wo() {
        return String.format("%s/%s", new Object[]{kRo, g.s(this.mPicUrl.getBytes())});
    }

    public static String wQ(String str) {
        return String.format("%s/%s", new Object[]{kRo, g.s(str.getBytes())});
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
        return true;
    }

    public final boolean Wt() {
        return false;
    }

    public final Bitmap Wu() {
        x.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
            } catch (IOException e) {
                try {
                    File file = new File(Wo());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    x.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e2, "", new Object[0]);
                    x.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        x.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", aVar.toString());
        return bitmap;
    }

    public final void Wv() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
