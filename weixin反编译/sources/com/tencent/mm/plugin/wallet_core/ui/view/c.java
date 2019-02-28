package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class c implements i {
    private b lnR = new b() {
        public final Bitmap oG(String str) {
            return d.decodeFile(str, null);
        }
    };
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final String Wo() {
        return com.tencent.mm.plugin.wallet_core.d.b.HZ(this.url);
    }

    public final String Wp() {
        return this.url;
    }

    public final String Wq() {
        return this.url;
    }

    public final String Wr() {
        return this.url;
    }

    public final boolean Ws() {
        return true;
    }

    public final boolean Wt() {
        return false;
    }

    public final Bitmap Wu() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.NET == aVar) {
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.HZ(this.url), false);
                } catch (IOException e) {
                    try {
                        File file = new File(com.tencent.mm.plugin.wallet_core.d.b.bMW());
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        x.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                        d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.HZ(this.url), false);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                        x.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                    }
                }
            } else {
                x.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
                FileOp.x(str, com.tencent.mm.plugin.wallet_core.d.b.HZ(this.url));
                return bitmap;
            }
        }
        x.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", aVar.toString());
        return bitmap;
    }

    public final void Wv() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final b Wn() {
        return this.lnR;
    }
}
