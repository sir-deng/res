package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;

public class AnimImageView extends TextView {
    private boolean bgH = false;
    private Context context;
    private AlphaAnimation pMj;
    private AnimationDrawable pMk;
    private int type = 1;
    public boolean yfW = false;
    private AnimationDrawable yfX;

    public final void setType(int i) {
        this.type = i;
        if (this.yfW) {
            if (i == 2) {
                setBackgroundResource(R.e.brD);
            } else {
                setBackgroundDrawable(a.b(this.context, R.g.bAS));
            }
        } else if (i == 2) {
            setBackgroundResource(R.e.brE);
        } else {
            setBackgroundDrawable(a.b(this.context, R.g.bBu));
        }
    }

    public final void cpw() {
        switch (this.type) {
            case 0:
                if (this.yfW) {
                    setBackgroundDrawable(a.b(this.context, R.g.bAS));
                } else {
                    setBackgroundDrawable(a.b(this.context, R.g.bBu));
                }
                setAnimation(this.pMj);
                this.pMj.startNow();
                return;
            case 1:
                break;
            case 2:
                if (!this.yfW) {
                    setBackgroundResource(R.e.brE);
                    break;
                } else {
                    setBackgroundResource(R.e.brD);
                    break;
                }
            default:
                return;
        }
        if (!this.bgH) {
            this.bgH = true;
            if (this.yfW) {
                setCompoundDrawablesWithIntrinsicBounds(this.pMk, null, null, null);
                this.pMk.stop();
                this.pMk.start();
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.yfX, null);
            this.yfX.stop();
            this.yfX.start();
        }
    }

    public final void bnQ() {
        if (this.pMj != null && this.pMj.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.bgH = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.pMk.stop();
            this.yfX.stop();
        }
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bnP();
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bnP();
    }

    private void bnP() {
        this.pMj = new AlphaAnimation(0.1f, 1.0f);
        this.pMj.setDuration(1000);
        this.pMj.setRepeatCount(-1);
        this.pMj.setRepeatMode(2);
        this.pMk = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dxC);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxD);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxE);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        this.pMk.setOneShot(false);
        this.pMk.setVisible(true, true);
        this.yfX = new AnimationDrawable();
        drawable = getResources().getDrawable(R.k.dxW);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.yfX.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxX);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.yfX.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxY);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.yfX.addFrame(drawable, 300);
        this.yfX.setOneShot(false);
        this.yfX.setVisible(true, true);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
