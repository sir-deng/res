package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static Bitmap feZ;
    private static ag hcb = new ag(Looper.getMainLooper());
    private Runnable hcd;
    private Bitmap kMO;
    private String mUrl;

    public static class a {

        /* renamed from: com.tencent.mm.plugin.game.ui.k$a$1 */
        static class AnonymousClass1 implements com.tencent.mm.sdk.e.j.a {
            final /* synthetic */ String fhk;
            final /* synthetic */ ImageView lUB;
            final /* synthetic */ float nvy;

            AnonymousClass1(String str, float f, ImageView imageView) {
                this.fhk = str;
                this.nvy = f;
                this.lUB = imageView;
            }

            public final void a(String str, l lVar) {
                if (this.fhk.equals(str)) {
                    Bitmap b = g.b(this.fhk, 1, this.nvy);
                    if (b != null) {
                        this.lUB.setImageBitmap(b);
                        an.biT().j(this);
                    }
                }
            }
        }
    }

    /* synthetic */ k(String str, byte b) {
        this(str);
    }

    private k(String str) {
        Bitmap createBitmap;
        if (feZ == null || feZ.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            feZ = createBitmap;
        } else {
            createBitmap = feZ;
        }
        this(str, createBitmap);
    }

    private k(String str, Bitmap bitmap) {
        super(bitmap);
        this.hcd = new Runnable() {
            public final void run() {
                k.this.invalidateSelf();
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        j.a((com.tencent.mm.platformtools.j.a) this);
        setUrl(str);
    }

    public final void l(String str, Bitmap bitmap) {
        if (this.mUrl != null && (this.mUrl.hashCode()).equals(str) && bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.kMO = bitmap;
            hcb.post(this.hcd);
        }
    }

    public final void draw(Canvas canvas) {
        if (this.kMO == null || this.kMO.isRecycled()) {
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.kMO, new Rect(0, 0, this.kMO.getWidth(), this.kMO.getHeight()), bounds, getPaint());
    }

    public final void setUrl(String str) {
        if (str != null && !str.equals(this.mUrl)) {
            x.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", str);
            this.mUrl = str;
            Bitmap a = j.a(new ar(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.kMO = a;
            }
            hcb.post(this.hcd);
        }
    }
}
