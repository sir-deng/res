package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends Drawable {
    public float Wl = 0.0f;
    public final Paint fC = new Paint(1);
    private final RectF kii = new RectF();
    private float kij = ((float) a.fromDPToPix(ad.getContext(), 3));
    private final Path mY = new Path();

    public final void draw(Canvas canvas) {
        float width = this.kii.width();
        float height = this.kii.height();
        float f = this.kii.left;
        float f2 = this.kii.top;
        float f3 = this.kii.right;
        float f4 = this.kii.bottom;
        width = Math.min(this.Wl, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(f + this.kij, f2 + this.kij, f3 - this.kij, f4 - this.kij), width, width, this.fC);
        canvas.drawPath(this.mY, this.fC);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.kii.set((float) i, (float) i2, (float) i3, (float) i4);
        float f = ((float) (i + i3)) / 2.0f;
        this.mY.moveTo(f, (float) i4);
        this.mY.lineTo(f - this.kij, ((float) i4) - this.kij);
        this.mY.lineTo(f + this.kij, ((float) i4) - this.kij);
        this.mY.close();
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
