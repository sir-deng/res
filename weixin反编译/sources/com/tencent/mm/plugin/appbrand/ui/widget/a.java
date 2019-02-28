package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements f {
    private final int jVK;
    private final int jVM;
    private final int jVN = -1;

    public a(int i, int i2) {
        this.jVK = i;
        this.jVM = i2;
    }

    public final Bitmap k(Bitmap bitmap) {
        Bitmap a = d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.jVK, this.jVK, false);
        if (a != createScaledBitmap) {
            l.EH().h(a);
        }
        a = Bitmap.createBitmap(this.jVK + (this.jVM * 2), this.jVK + (this.jVM * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(a);
        canvas.drawBitmap(createScaledBitmap, (float) this.jVM, (float) this.jVM, new Paint());
        l.EH().h(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.jVN);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.jVM);
        canvas.drawCircle((float) ((this.jVK / 2) + this.jVM), (float) ((this.jVK / 2) + this.jVM), (float) (this.jVK / 2), paint);
        return a;
    }

    public final String Ju() {
        return "WxaNearbyShowcaseIcon";
    }
}
