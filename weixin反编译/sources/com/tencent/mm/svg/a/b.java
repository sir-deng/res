package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;

public abstract class b extends Drawable {
    public long mDuration = 0;
    protected View msX;
    protected final Rect uk = new Rect();
    protected int xKV = 0;
    protected boolean xKW = false;
    protected Paint xKX = new Paint();
    protected int xKY = 0;
    protected int xKZ = 0;
    protected int xLa = 0;
    protected int xLb = 0;
    protected float xLc;

    public b(int i, int i2, int i3) {
        this.xLa = i;
        this.xLb = i2;
        this.xLc = 1.0f;
        this.xKY = this.xLa;
        this.xKZ = this.xLb;
        setLevel(10000);
        this.xKV = i3;
    }

    protected final void clR() {
        this.uk.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.xKW = true;
    }

    protected boolean onLevelChange(int i) {
        clT();
        return super.onLevelChange(i);
    }

    protected final void clS() {
        if (this.xKW) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.uk);
        }
        this.xKW = false;
    }

    private void clT() {
        this.msX = a.v(this);
        if (this.msX != null) {
            a.b(this.msX, this.xKX);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        clT();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.xKX.setAlpha(i);
        if (this.msX != null && VERSION.SDK_INT >= 17) {
            try {
                this.msX.setLayerPaint(this.xKX);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.xKX.setColorFilter(colorFilter);
        if (this.msX != null && VERSION.SDK_INT >= 17) {
            try {
                this.msX.setLayerPaint(this.xKX);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    public int getOpacity() {
        if (this.msX != null && this.msX.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.xKX == null || this.xKX.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    protected final void j(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.clV()) {
            int height = this.uk.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(127);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.uk.width()) - paint.measureText("SVG"), (float) ((this.uk.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.xKY;
    }

    public int getIntrinsicHeight() {
        return this.xKZ;
    }
}
