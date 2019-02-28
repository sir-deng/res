package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.d.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private int fdd = 200;
    private ValueAnimator fde;
    c fdf;
    public float fdg;
    public float fdh;
    public float fdi;
    public Rect fdj;
    public RectF fdk;
    Matrix fdl;
    public long fdm = 0;
    public AnimatorListener fdn;

    public a(c cVar) {
        this.fdf = cVar;
        this.fdl = new Matrix();
        this.fdk = new RectF();
    }

    public final void play() {
        x.i("MicroMsg.CropActionUpAnim", "[play]");
        if (this.fdr) {
            this.fds = false;
            this.fdr = false;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{1.0f, this.fdg});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.fdh});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.fdi});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
            this.fde = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.fde.addUpdateListener(new AnimatorUpdateListener() {
                Matrix fdo = new Matrix(a.this.fdf.uS());
                Rect fdp = new Rect(a.this.fdj);

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
                    float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
                    a.this.fdl.reset();
                    a.this.fdl.postTranslate(floatValue2, floatValue);
                    RectF rectF = new RectF(this.fdp);
                    a.this.fdl.mapRect(rectF);
                    rectF.round(a.this.fdj);
                    a.this.fdl.postScale(floatValue3, floatValue3, (float) a.this.fdj.centerX(), (float) a.this.fdj.centerY());
                    Matrix matrix = new Matrix(this.fdo);
                    matrix.postConcat(a.this.fdl);
                    a.this.fdf.uS().set(matrix);
                    com.tencent.mm.s.a aVar = a.this.fdf.fiJ;
                    com.tencent.mm.s.a.gn((int) floatValue4);
                    RectF rectF2 = new RectF(this.fdp);
                    a.this.fdl.mapRect(rectF2);
                    rectF2.round(a.this.fdj);
                    a.this.fdf.uT();
                }
            });
            this.fde.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    a.this.fdf.fiS = true;
                    a.this.fdr = false;
                    a.this.fds = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    a.this.fdr = true;
                    a.this.fds = false;
                    a.this.fdm = 0;
                    a.this.fdf.uW();
                    a.this.fdf.uU();
                    if (a.this.fdn != null) {
                        a.this.fdn.onAnimationEnd(animator);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.fde.setInterpolator(new LinearInterpolator());
            this.fde.setDuration((long) this.fdd);
            this.fde.setStartDelay(this.fdm);
            this.fde.start();
        }
    }

    public final void cancel() {
        x.d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.fds = false;
        this.fdr = true;
        if (this.fde != null) {
            this.fde.cancel();
        }
    }
}
