package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class q extends FrameLayout {
    View Iv;
    private int iN;
    View jJZ;
    FrameLayout jKa;
    FrameLayout jKb;
    public boolean jKc = true;
    boolean jKd = false;
    private boolean jKe = false;
    private boolean jKf = false;
    private boolean jKg = false;
    private int jKh;
    private int jKi;
    private int jKj;
    private ObjectAnimator jKk = null;

    public q(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final void dg(boolean z) {
        this.jKc = !z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jKc) {
            return this.jKg;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            return false;
        }
        if (this.jKf) {
            return true;
        }
        switch (action) {
            case 0:
                if (ajO()) {
                    this.jKh = (int) motionEvent.getX();
                    this.jKi = (int) motionEvent.getY();
                    this.jKj = (int) motionEvent.getY();
                    break;
                }
                break;
            case 2:
                if (ajO()) {
                    action = ((int) motionEvent.getX()) - this.jKh;
                    int y = ((int) motionEvent.getY()) - this.jKi;
                    if (Math.abs(y) > this.iN && Math.abs(y) > Math.abs(action) && y > 0) {
                        this.jKf = true;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jKc) {
            if (this.jKg) {
                ajL();
            }
            return this.jKg;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jKj = (int) motionEvent.getY();
                return true;
            case 1:
            case 3:
                if (this.jKb.getTranslationY() <= ((float) this.jJZ.getHeight()) || !this.jKd) {
                    ajL();
                } else {
                    ajK();
                }
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.jKj) >> 1;
                int height = getHeight();
                if (y <= height) {
                    height = y;
                }
                if (this.jKe) {
                    height += ajP();
                }
                height = Math.max(height, 0);
                x.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(r4), Integer.valueOf(height));
                this.jKb.setTranslationY((float) Math.min(getHeight(), height));
                ly(height);
                return true;
            default:
                return false;
        }
    }

    protected final void ajK() {
        lA(ajP());
        if (!this.jKe) {
            ajM();
        }
        this.jKf = true;
        this.jKe = true;
        this.jKg = true;
    }

    protected final void ajL() {
        lA(0);
        if (this.jKe) {
            ajN();
        }
        this.jKf = false;
        this.jKe = false;
        this.jKg = false;
    }

    protected void ajM() {
    }

    protected void ajN() {
    }

    protected void ly(int i) {
    }

    public final void lz(int i) {
        this.jKa.setBackgroundColor(i);
    }

    private boolean ajO() {
        if (this.Iv instanceof WebView) {
            return ((WebView) this.Iv).isOverScrollStart();
        }
        return this.Iv.getScrollY() == 0;
    }

    protected int ajP() {
        return this.jJZ.getHeight();
    }

    private void lA(int i) {
        int translationY = (int) this.jKb.getTranslationY();
        if (translationY != i) {
            x.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", Integer.valueOf(translationY), Integer.valueOf(i));
            if (this.jKk != null) {
                this.jKk.cancel();
            }
            long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) ajP())) * 250.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jKb, "translationY", new float[]{(float) translationY, (float) i});
            ofFloat.setDuration(Math.min(abs, 250));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    q.this.ly((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.jKk = ofFloat;
        }
    }
}
