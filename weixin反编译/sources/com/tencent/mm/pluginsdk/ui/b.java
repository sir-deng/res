package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends j implements a {
    Bitmap kNe;
    private float vpT;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.caI(), str);
        this.vpT = 0.5f;
        this.kNe = null;
    }

    public b(String str, float f) {
        this(str);
        this.vpT = f;
    }

    public final void jk(String str) {
        super.jk(str);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        com.tencent.mm.bq.a.a aVar = com.tencent.mm.bq.a.a.a.xjs;
        if (aVar != null) {
            bitmap = com.tencent.mm.bq.a.a.a.xjs.Ee(this.tag);
        }
        if (bitmap != null) {
            a(canvas, bitmap);
            return;
        }
        if (this.vqL) {
            bitmap = this.prd.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else {
            bitmap = this.prd.cm(this.tag);
        }
        if (bitmap != null) {
            bitmap = d.a(bitmap, false, this.vpT * ((float) bitmap.getWidth()));
            if (aVar != null) {
                aVar.p(this.tag, bitmap);
            }
            a(canvas, bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
            if (this.kNe == null) {
                try {
                    this.kNe = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bu.a.getDensity(null));
                    this.kNe = d.a(this.kNe, false, this.vpT * ((float) this.kNe.getWidth()));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                }
            }
            a(canvas, this.kNe);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vqQ > 1.0f || this.oCI) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, hca);
    }
}
