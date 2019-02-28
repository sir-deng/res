package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.ca.a.h;
import com.tencent.mm.ca.a.j;
import com.tencent.mm.sdk.platformtools.bi;

public class MMSwitchBtn extends View {
    private int maxHeight;
    private int maxWidth;
    private int nsl;
    private Paint oOJ = new Paint(1);
    private float rXk;
    private float rXl;
    private long zDW;
    private int zDX;
    private int zDY;
    private int zDZ;
    private boolean zEa = false;
    private boolean zEb = false;
    private int zEc;
    private int zEd = 80;
    private int zEe = 300;
    private float zEf;
    private float zEg;
    private int zEh;
    private int zEi;
    private int zEj;
    public boolean zEk = false;
    private RectF zEl = new RectF();
    private RectF zEm = new RectF();
    private int zEn;
    private int zEo;
    private int zEp;
    private String zEq;
    private String zEr;
    private b zEs = new b();
    public a zEt;

    private class b extends Animation {
        int direction = 0;
        float zEu = 0.0f;
        long zEv = 0;

        public b() {
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new AnimationListener(MMSwitchBtn.this) {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    boolean z = true;
                    if (MMSwitchBtn.this.zEk != (b.this.direction == 1)) {
                        MMSwitchBtn mMSwitchBtn = MMSwitchBtn.this;
                        if (b.this.direction != 1) {
                            z = false;
                        }
                        mMSwitchBtn.zEk = z;
                        MMSwitchBtn.this.post(new Runnable() {
                            public final void run() {
                                if (MMSwitchBtn.this.zEt != null) {
                                    MMSwitchBtn.this.zEt.cy(MMSwitchBtn.this.zEk);
                                }
                            }
                        });
                    }
                    MMSwitchBtn.this.zEa = false;
                }
            });
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.direction == 0) {
                MMSwitchBtn.this.zEm.left = this.zEu - (((float) this.zEv) * f);
            } else {
                MMSwitchBtn.this.zEm.left = this.zEu + (((float) this.zEv) * f);
            }
            MMSwitchBtn.this.czL();
            MMSwitchBtn.this.invalidate();
        }
    }

    public interface a {
        void cy(boolean z);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        b(context.obtainStyledAttributes(attributeSet, j.faX));
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        b(context.obtainStyledAttributes(attributeSet, j.faX));
    }

    private void init() {
        this.zEc = getResources().getDimensionPixelSize(c.bvW);
        this.zEf = (float) getResources().getDimensionPixelSize(c.zId);
        this.zEg = (float) getResources().getDimensionPixelSize(c.zIc);
        this.zEh = getResources().getColor(com.tencent.mm.ca.a.b.white);
        this.zEi = getResources().getColor(com.tencent.mm.ca.a.b.zHV);
        this.zEj = getResources().getColor(com.tencent.mm.ca.a.b.zHW);
        this.zEo = this.zEj;
        this.zEn = this.zEi;
        this.zEp = this.zEh;
        this.nsl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void b(TypedArray typedArray) {
        this.zEo = typedArray.getColor(j.zJQ, this.zEj);
        this.zEn = typedArray.getColor(j.zJR, this.zEi);
        this.zEp = typedArray.getColor(j.zJS, this.zEh);
        this.zEq = typedArray.getString(j.zJT);
        this.zEr = typedArray.getString(j.zJU);
        typedArray.recycle();
    }

    public final void nJ(boolean z) {
        if (this.zEk != z) {
            clearAnimation();
            this.zEk = z;
            czK();
            this.zEa = false;
            invalidate();
        }
        setContentDescription(z ? getContext().getString(h.zIL) : getContext().getString(h.zIM));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.zDY = (this.maxWidth - ((int) (this.zEg * 2.0f))) - (this.zEc * 2);
        this.zDX = this.zDY / 2;
        this.zDZ = getResources().getDimensionPixelSize(c.zIb);
        if (this.zDZ < this.maxHeight) {
            this.zEl.top = (float) ((this.maxHeight - this.zDZ) / 2);
            this.zEl.bottom = this.zEl.top + ((float) this.zDZ);
        } else {
            this.zEl.top = 0.0f;
            this.zEl.bottom = (float) this.maxHeight;
        }
        this.zEl.left = 0.0f;
        this.zEl.right = (float) this.maxWidth;
        czK();
        this.oOJ.setStyle(Style.FILL);
        this.oOJ.setColor(this.zEi);
    }

    private void czK() {
        if (this.zDZ < this.maxHeight) {
            this.zEm.top = (float) (((this.maxHeight - this.zDZ) / 2) + this.zEc);
            this.zEm.bottom = (this.zEm.top + ((float) this.zDZ)) - ((float) (this.zEc * 2));
        } else {
            this.zEm.top = (float) this.zEc;
            this.zEm.bottom = (float) (this.maxHeight - this.zEc);
        }
        if (this.zEk) {
            this.zEm.left = (float) (this.zDY + this.zEc);
            this.zEm.right = (float) (this.maxWidth - this.zEc);
            return;
        }
        this.zEm.left = (float) this.zEc;
        this.zEm.right = (float) (((int) (this.zEg * 2.0f)) + this.zEc);
    }

    private void czL() {
        if (this.zEm.left < ((float) this.zEc)) {
            this.zEm.left = (float) this.zEc;
        }
        if (this.zEm.left > ((float) (this.zDY + this.zEc))) {
            this.zEm.left = (float) (this.zDY + this.zEc);
        }
        this.zEm.right = this.zEm.left + ((float) ((int) (this.zEg * 2.0f)));
    }

    private void nK(boolean z) {
        this.zEa = true;
        this.zEs.reset();
        if (z) {
            this.zEs.zEv = (((long) this.zDY) - ((long) this.zEm.left)) + ((long) this.zEc);
            this.zEs.direction = 1;
        } else {
            this.zEs.zEv = (long) this.zEm.left;
            this.zEs.direction = 0;
        }
        this.zEs.zEu = this.zEm.left;
        this.zEs.setDuration((((long) this.zEd) * this.zEs.zEv) / ((long) this.zDY));
        startAnimation(this.zEs);
    }

    private void eC(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void cyW() {
        if (this.zEm.left > ((float) this.zDX)) {
            nK(true);
        } else {
            nK(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.zEa && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.rXk = motionEvent.getX();
                    this.rXl = motionEvent.getY();
                    this.zDW = SystemClock.elapsedRealtime();
                    this.zEb = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.zDW < ((long) this.zEe)) {
                        nK(!this.zEk);
                    } else {
                        cyW();
                    }
                    eC(false);
                    this.zEb = false;
                    break;
                case 2:
                    float x;
                    if (this.zEb) {
                        eC(true);
                        x = motionEvent.getX() - this.rXk;
                        RectF rectF = this.zEm;
                        rectF.left = x + rectF.left;
                        czL();
                    } else {
                        float x2 = motionEvent.getX() - this.rXk;
                        x = motionEvent.getY() - this.rXl;
                        if (Math.abs(x2) >= ((float) this.nsl) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.zEb = true;
                            eC(true);
                        }
                    }
                    this.rXk = motionEvent.getX();
                    this.rXl = motionEvent.getY();
                    break;
                case 3:
                    if (this.zEb) {
                        cyW();
                    }
                    eC(false);
                    this.zEb = false;
                    break;
            }
            if (this.zEb) {
                invalidate();
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        this.oOJ.setColor(this.zEn);
        this.oOJ.setAlpha(255);
        canvas.drawRoundRect(this.zEl, this.zEf, this.zEf, this.oOJ);
        this.oOJ.setColor(this.zEo);
        this.oOJ.setAlpha(Math.min(255, (int) (((this.zEm.left - ((float) this.zEc)) / ((float) this.zDY)) * 255.0f)));
        canvas.drawRoundRect(this.zEl, this.zEf, this.zEf, this.oOJ);
        this.oOJ.setColor(this.zEp);
        canvas.drawRoundRect(this.zEm, this.zEg, this.zEg, this.oOJ);
        if (!bi.oN(this.zEq) && !bi.oN(this.zEr)) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(c.uij));
            paint.setColor(getResources().getColor(com.tencent.mm.ca.a.b.buk));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.zEm.left - ((float) this.zEc)) / ((float) this.zDY)) * 255.0f));
            int measureText = (int) paint.measureText(this.zEq);
            Rect rect = new Rect();
            paint.getTextBounds(this.zEq, 0, this.zEq.length(), rect);
            paint.setAlpha(min);
            float height = ((((float) rect.height()) / 2.0f) + ((this.zEl.top + this.zEl.bottom) / 2.0f)) - ((float) com.tencent.mm.bu.a.fromDPToPix(getContext(), 1));
            canvas.drawText(this.zEq, ((this.zEl.left + this.zEf) - (((float) measureText) / 2.0f)) + ((float) com.tencent.mm.bu.a.fromDPToPix(getContext(), 1)), height, paint);
            float fromDPToPix = ((this.zEl.right - this.zEf) - (((float) measureText) / 2.0f)) - ((float) com.tencent.mm.bu.a.fromDPToPix(getContext(), 1));
            paint.setAlpha(255 - min);
            canvas.drawText(this.zEr, fromDPToPix, height, paint);
        }
    }
}
