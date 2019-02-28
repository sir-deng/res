package com.tencent.mm.plugin.favorite.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class b implements i {
    private int height;
    private String mvj;
    private String url;
    private int width;

    public b(String str, String str2, int i, int i2) {
        this.mvj = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final com.tencent.mm.platformtools.i.b Wn() {
        return null;
    }

    public final String Wo() {
        return j.aJl() + g.s(this.url.getBytes());
    }

    public final String Wp() {
        return this.url;
    }

    public final String Wq() {
        return this.mvj;
    }

    public final String Wr() {
        return this.mvj;
    }

    public final boolean Ws() {
        return true;
    }

    public final boolean Wt() {
        return false;
    }

    public final Bitmap Wu() {
        return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEl);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        if (a.NET == aVar) {
            try {
                x.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                File file = new File(j.aJl());
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = d.a(bitmap, this.width, this.height, true);
                }
                File file2 = new File(Wo());
                file2.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
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
