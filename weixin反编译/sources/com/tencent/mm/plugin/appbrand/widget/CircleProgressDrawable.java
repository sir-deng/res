package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF kaD = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF kaE = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private Paint fC;
    private int kaF = Math.round(ad.getResources().getDisplayMetrics().density * 48.0f);
    private int kaG = 4;
    private boolean kaH = false;
    private int kaI = 0;
    public RingPathTransform kaJ = new RingPathTransform();
    public RingRotation kaK = new RingRotation();
    public ArrayList<Animator> mg = new ArrayList();
    public int mz = WebView.NIGHT_MODE_COLOR;

    private static class a {
        public static final Interpolator kaL = new LinearInterpolator();
    }

    private static class c {
        public static final Interpolator kaL = e.b(kaN);
        private static final Path kaN;

        static {
            Path path = new Path();
            kaN = path;
            path.lineTo(0.5f, 0.0f);
            kaN.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
        }
    }

    private static class RingRotation {
        private float fN;

        private RingRotation() {
        }

        /* synthetic */ RingRotation(byte b) {
            this();
        }

        @Keep
        public void setRotation(float f) {
            this.fN = f;
        }
    }

    private static class b {
        public static final Interpolator kaL = e.b(kaM);
        private static final Path kaM;

        static {
            Path path = new Path();
            kaM = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            kaM.lineTo(1.0f, 1.0f);
        }
    }

    private static class RingPathTransform {
        public float mF;
        public float mG;
        public float mH;

        private RingPathTransform() {
            this.mF = 0.0f;
            this.mG = 0.0f;
            this.mH = 0.0f;
        }

        /* synthetic */ RingPathTransform(byte b) {
            this();
        }

        @Keep
        public void setTrimPathStart(float f) {
            this.mF = f;
        }

        @Keep
        public void setTrimPathEnd(float f) {
            this.mG = f;
        }

        @Keep
        public void setTrimPathOffset(float f) {
            this.mH = f;
        }
    }

    public final void start() {
        Object obj;
        Iterator it = this.mg.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            it = this.mg.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        Iterator it = this.mg.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
    }

    public final int getIntrinsicWidth() {
        return this.kaF;
    }

    public final int getIntrinsicHeight() {
        return this.kaF;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save;
            if (this.fC == null) {
                this.fC = new Paint();
                this.fC.setAntiAlias(true);
                this.fC.setStyle(Style.STROKE);
                this.fC.setStrokeWidth((float) this.kaG);
                this.fC.setStrokeCap(Cap.SQUARE);
                this.fC.setStrokeJoin(Join.MITER);
            }
            int save2 = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            int width = bounds.width();
            int height = bounds.height();
            Paint paint = this.fC;
            canvas.scale(((float) width) / kaD.width(), ((float) height) / kaD.height());
            canvas.translate(kaD.width() / 2.0f, kaD.height() / 2.0f);
            if (this.kaH) {
                save = canvas.save();
                paint.setColor(this.kaI);
                canvas.drawArc(kaE, 0.0f, 360.0f, false, paint);
                canvas.restoreToCount(save);
            }
            save = canvas.save();
            paint.setColor(this.mz);
            canvas.rotate(this.kaK.fN);
            Canvas canvas2 = canvas;
            canvas2.drawArc(kaE, -90.0f + ((this.kaJ.mH + this.kaJ.mF) * 360.0f), 360.0f * (this.kaJ.mG - this.kaJ.mF), false, paint);
            canvas.restoreToCount(save);
            canvas.restoreToCount(save2);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }
}
