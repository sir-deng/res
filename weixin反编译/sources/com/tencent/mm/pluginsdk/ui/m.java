package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class m extends Drawable {
    private Context context;
    private Paint jbA = new Paint(1);
    private ValueAnimator kco = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private Random random = new Random(System.currentTimeMillis());
    private Drawable vrM = null;
    private int vrN = 0;
    private int vrO = 0;
    private Interpolator vrP = new LinearInterpolator();
    private Interpolator vrQ = new AccelerateDecelerateInterpolator();
    private int vrR;
    private int vrS;
    private int vrT;
    private int vrU;
    private int vrV;
    private int vrW;
    private int vrX;
    private int vrY;
    private int vrZ;
    private int vsa;
    private int vsb = 0;
    private float vsc = 0.0f;
    private float vsd = -90.0f;
    private float vse = 0.0f;
    private float vsf = 0.0f;
    private float vsg = 5.0f;
    private boolean vsh = false;
    private int vsi;
    private int vsj;
    private int vsk;
    private int vsl = 2;
    private RectF vsm;

    public m(Context context) {
        this.kco.setInterpolator(this.vrP);
        this.kco.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                m.this.vsc = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                m.this.invalidateSelf();
            }
        });
        this.vsm = new RectF();
        this.context = context;
        this.vrN = a.c(context, R.e.buj);
        this.vrO = a.c(context, R.e.bts);
        this.vrM = context.getResources().getDrawable(R.k.dBI);
        this.vrU = a.ab(context, R.f.byq);
        this.vrV = a.ab(context, R.f.byp);
        this.vrW = a.ab(context, R.f.byj);
        this.vsb = a.ab(context, R.f.byo);
        this.vrS = a.c(context, R.e.bua);
        this.vrT = a.ab(context, R.f.byl);
        this.vrZ = a.ab(context, R.f.byk);
        this.vsa = a.c(context, R.e.bub);
        this.vsi = this.vrZ;
        this.vsj = this.vsi;
        this.vsk = a.ab(context, R.f.byn);
        this.vrX = a.ab(context, R.f.byn);
        this.vrY = a.ab(context, R.f.bym);
        this.vrR = a.ab(context, R.f.byr);
    }

    public final void cbd() {
        x.d("MicroMsg.VoiceInputDrawable", "longClickState %s", Integer.valueOf(this.vsl));
        this.vsl = 7;
        this.kco.cancel();
        this.vsc = 0.0f;
        invalidateSelf();
    }

    public final void cbe() {
        x.d("MicroMsg.VoiceInputDrawable", "readyState %s", Integer.valueOf(this.vsl));
        this.vsl = 2;
        this.kco.cancel();
        this.vsc = 0.0f;
        this.vsd = -90.0f;
        this.vse = 0.0f;
        this.vsf = 0.0f;
        this.vsg = 5.0f;
        invalidateSelf();
    }

    public final void cbf() {
        x.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", Integer.valueOf(this.vsl));
        this.vsl = 6;
        this.kco.cancel();
        this.vsc = 0.0f;
        invalidateSelf();
    }

    public final void lb(boolean z) {
        x.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(z));
        if (!z) {
            this.vsl = 3;
        }
        this.vsh = true;
        invalidateSelf();
    }

    public final void Ck(int i) {
        boolean z = true;
        x.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
        if (i >= 28) {
            z = false;
        }
        this.vsh = z;
        invalidateSelf();
    }

    public final void cbg() {
        x.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", Integer.valueOf(this.vsl));
        this.vsl = 4;
        this.kco.cancel();
        this.vsc = 0.0f;
        this.kco.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kco.setDuration(1000);
        this.kco.setRepeatCount(-1);
        this.kco.start();
    }

    public final void cbh() {
        x.d("MicroMsg.VoiceInputDrawable", "disableState %s", Integer.valueOf(this.vsl));
        this.vsl = 5;
        this.kco.cancel();
        this.vsc = 0.0f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        if ((this.vsl == 6 || this.vsl == 7) && !i(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.jbA.setShader(null);
            this.jbA.setStyle(Style.FILL);
            this.jbA.setColor(this.vrS);
            if (this.vsl == 7) {
                if (this.vsh) {
                    this.vsk -= 4;
                } else {
                    this.vsk += 4;
                }
                this.vsk = Math.min(Math.max(this.vrX, this.vsk), this.vrY);
                canvas.drawCircle((float) width, (float) height, (float) this.vsk, this.jbA);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.vrX, this.jbA);
            }
        }
        if (!(this.vrM == null || i(canvas))) {
            if (this.vsl == 5) {
                this.vrM.setColorFilter(this.vrO, Mode.SRC_ATOP);
            } else {
                this.vrM.setColorFilter(this.vrN, Mode.SRC_ATOP);
            }
            width = canvas.getWidth() / 2;
            height = canvas.getHeight() / 2;
            this.vrM.setBounds(width - this.vsb, height - this.vsb, width + this.vsb, height + this.vsb);
            this.vrM.draw(canvas);
        }
        if (this.vsl == 4 && canvas != null) {
            this.jbA.setColor(this.vrN);
            this.jbA.setStrokeWidth((float) this.vrR);
            this.jbA.setStyle(Style.STROKE);
            this.jbA.clearShadowLayer();
            this.jbA.setShader(null);
            this.vsm.left = (float) ((canvas.getWidth() / 2) - this.vrZ);
            this.vsm.top = (float) ((canvas.getHeight() / 2) - this.vrZ);
            this.vsm.right = (float) ((canvas.getWidth() / 2) + this.vrZ);
            this.vsm.bottom = (float) ((canvas.getHeight() / 2) + this.vrZ);
            canvas.drawArc(this.vsm, this.vsd, this.vsf, false, this.jbA);
            this.vsd += this.vse;
            this.vsf += this.vsg;
            if (this.vsf >= 360.0f) {
                this.vsg = -this.vsg;
                this.vse = 5.0f;
            } else if (this.vsf <= 0.0f) {
                this.vsg = -this.vsg;
                this.vse = 0.0f;
                this.vsd = -90.0f;
                this.vsf = 0.0f;
            }
        }
        if ((this.vsl == 6 || this.vsl == 7) && !i(canvas)) {
            this.jbA.setStyle(Style.FILL);
            this.jbA.setColor(this.vsa);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.vsb, this.jbA);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        if (this.context == null) {
            return 0;
        }
        return a.eB(this.context);
    }

    public final int getIntrinsicHeight() {
        return this.vsb * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean i(Canvas canvas) {
        return canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0;
    }
}
