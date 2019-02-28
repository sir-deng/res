package com.tencent.mm.svg.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.mm.svg.b.b;

public final class c extends b {
    private a xLd;

    public static class a extends ConstantState {
        protected int jxX;
        protected Picture xLe;
        protected Bitmap xLf;

        public a(Picture picture, int i) {
            this.xLe = picture;
            this.jxX = i;
        }

        public final Drawable newDrawable() {
            return new c(this.xLe, this.jxX);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        this.xLd = new a(picture, i);
        clR();
    }

    public final ConstantState getConstantState() {
        return this.xLd;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        long clY = b.clY();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.xLd.xLe == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.xKV));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.xLd.xLf == null || this.xLd.xLf.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.xKV));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.xLd.xLe.draw(canvas2);
                            this.xLd.xLf = createBitmap;
                            b.fU(nanoTime);
                            j(canvas2);
                        }
                    }
                }
                if (this.xLd.xLf == null || this.xLd.xLf.isRecycled()) {
                    obj = null;
                } else {
                    clS();
                    canvas.drawBitmap(this.xLd.xLf, null, this.uk, this.xKX);
                }
                obj2 = obj;
            } else if (!(this.xLd.xLf == null || this.xLd.xLf.isRecycled())) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.xLd.xLf.toString());
                this.xLd.xLf.recycle();
                this.xLd.xLf = null;
            }
            if (this.msX == null) {
                this.msX = a.v(this);
            }
            a.b(this.msX, this.xKX);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.xLd.xLe;
                    if (picture != null) {
                        clS();
                        canvas.save();
                        canvas.drawPicture(picture, this.uk);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.fU(clY);
            j(canvas);
        } finally {
            this.mDuration = b.fU(clY);
            j(canvas);
        }
    }
}
