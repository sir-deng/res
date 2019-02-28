package com.tencent.mm.ap.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ap.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements Runnable {
    private String aAM;
    private Bitmap bitmap;
    private b hFT;
    private com.tencent.mm.ap.a.c hFV;
    private String url;

    public c(String str, com.tencent.mm.ap.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.hFV = cVar;
        this.bitmap = bitmap;
        this.hFT = bVar;
        this.aAM = str2;
    }

    public final void run() {
        if (bi.oN(this.url) || this.hFV == null || this.bitmap == null || this.bitmap.isRecycled() || this.hFT == null) {
            x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            return;
        }
        if (this.url.equals((String) this.hFT.hEJ.get(Integer.valueOf(this.hFV.PO())))) {
            com.tencent.mm.ap.a.c cVar = this.hFV;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.hEL != null) {
                ImageView imageView = (ImageView) cVar.hEL.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.hFT.a(this.hFV);
            return;
        }
        x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
    }
}
