package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;
import com.tencent.smtt.sdk.WebView;

public class ThreeDotsLoadingView extends FrameLayout {
    private boolean AV = false;
    private int zFM = WebView.NIGHT_MODE_COLOR;
    private boolean zFN = false;
    private ViewGroup zFO;
    private ImageView zFP;
    private ImageView zFQ;
    private ImageView zFR;
    private final Runnable zFS = new Runnable() {
        public final void run() {
            ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
            ((AnimationDrawable) ThreeDotsLoadingView.this.zFP.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zFQ.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zFR.getDrawable()).start();
        }
    };

    static /* synthetic */ void a(ThreeDotsLoadingView threeDotsLoadingView) {
        threeDotsLoadingView.zFP.setImageDrawable(d(threeDotsLoadingView.zFM, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.zFQ.setImageDrawable(d(threeDotsLoadingView.zFM, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.zFR.setImageDrawable(d(threeDotsLoadingView.zFM, new float[]{0.3f, 0.5f, 0.4f}));
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.zFO = (ViewGroup) LayoutInflater.from(context).inflate(h.gYX, this, true);
        this.zFP = (ImageView) this.zFO.findViewById(g.gXq);
        this.zFQ = (ImageView) this.zFO.findViewById(g.gXr);
        this.zFR = (ImageView) this.zFO.findViewById(g.gXs);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fbl);
            this.zFM = obtainStyledAttributes.getColor(m.hbo, WebView.NIGHT_MODE_COLOR);
            obtainStyledAttributes.recycle();
        }
        czX();
    }

    public void setVisibility(int i) {
        if (8 == i || 4 == i) {
            ajR();
        }
        super.setVisibility(i);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.zFN) {
            this.zFN = false;
            czW();
        }
    }

    public void setAlpha(float f) {
        this.zFP.setAlpha(f);
        this.zFQ.setAlpha(f);
        this.zFR.setAlpha(f);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f));
        }
    }

    public final void czW() {
        if (!z.ak(this)) {
            this.zFN = true;
        } else if (!this.AV) {
            this.AV = true;
            czX();
            postDelayed(this.zFS, 300);
        }
    }

    public final void ajR() {
        this.zFN = false;
        if (this.AV) {
            this.AV = false;
            removeCallbacks(this.zFS);
            if (this.zFP.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.zFP.getDrawable()).stop();
                ((AnimationDrawable) this.zFQ.getDrawable()).stop();
                ((AnimationDrawable) this.zFR.getDrawable()).stop();
            }
        }
    }

    private void czX() {
        this.zFP.setImageDrawable(g(this.zFM, 0.5f));
        this.zFQ.setImageDrawable(g(this.zFM, 0.4f));
        this.zFR.setImageDrawable(g(this.zFM, 0.3f));
    }

    private static AnimationDrawable d(int i, float[] fArr) {
        int i2 = 0;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        while (i2 < 3) {
            animationDrawable.addFrame(g(i, fArr[i2]), 300);
            i2++;
        }
        return animationDrawable;
    }

    private static Drawable g(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
