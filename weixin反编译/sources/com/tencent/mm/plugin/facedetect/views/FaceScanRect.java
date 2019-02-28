package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class FaceScanRect extends RelativeLayout {
    public View msX;
    private ImageView msY;
    private ImageView msZ;
    private ImageView mta;
    private ImageView mtb;
    private ImageView mtc;
    private ImageView mtd;
    private ImageView mte;
    private ImageView mtf;
    public ImageView[] mtg;
    private ScaleAnimation mth;
    private ScaleAnimation mti;
    private ScaleAnimation mtj;
    private ScaleAnimation mtk;
    public TranslateAnimation mtl;
    public b mtm;
    public ViewGroup mtn;
    public View mto;
    public int mtp;

    private enum a {
        ;

        static {
            mtq = 1;
            mtr = 2;
            mts = 3;
            mtt = new int[]{mtq, mtr, mts};
        }
    }

    public interface b {
        void aHX();
    }

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.msX = null;
        this.msY = null;
        this.msZ = null;
        this.mta = null;
        this.mtb = null;
        this.mtc = null;
        this.mtd = null;
        this.mte = null;
        this.mtf = null;
        this.mtg = null;
        this.mth = null;
        this.mti = null;
        this.mtj = null;
        this.mtk = null;
        this.mtl = null;
        this.mtm = null;
        this.mtn = null;
        this.mto = null;
        LayoutInflater.from(context).inflate(g.mjx, this, true);
        this.msX = findViewById(e.miZ);
        this.msY = (ImageView) findViewById(e.miX);
        this.msZ = (ImageView) findViewById(e.miY);
        this.mta = (ImageView) findViewById(e.miU);
        this.mtb = (ImageView) findViewById(e.miT);
        this.mtc = (ImageView) findViewById(e.miW);
        this.mtd = (ImageView) findViewById(e.miV);
        this.mte = (ImageView) findViewById(e.miR);
        this.mtf = (ImageView) findViewById(e.miS);
        this.mto = findViewById(e.miI);
        this.mtn = (ViewGroup) findViewById(e.miF);
        this.mtg = new ImageView[]{this.msY, this.msZ, this.mta, this.mtb, this.mtc, this.mtd, this.mte, this.mtf};
        this.mtp = a.mts;
        this.mtl = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.mtl.setRepeatCount(-1);
        this.mtl.setRepeatMode(1);
        this.mtl.setDuration(1000);
    }

    public final void b(AnimationListener animationListener) {
        if (this.mtp == a.mtr) {
            x.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
                return;
            }
            return;
        }
        this.mtp = a.mtr;
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.mik);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.mil);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        x.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", Float.valueOf(f), Float.valueOf(f2));
        this.mth = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.mth.setFillAfter(true);
        this.mth.setDuration(1500);
        this.mth.setInterpolator(getContext(), 17563654);
        this.mth.setAnimationListener(animationListener);
        this.mti = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.mti.setFillAfter(true);
        this.mti.setDuration(1500);
        this.mti.setInterpolator(getContext(), 17563654);
        this.mtj = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 0.0f);
        this.mtj.setFillAfter(true);
        this.mtj.setDuration(1500);
        this.mtj.setInterpolator(getContext(), 17563654);
        this.mtk = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 1.0f);
        this.mtk.setFillAfter(true);
        this.mtk.setDuration(1500);
        this.mtk.setInterpolator(getContext(), 17563654);
        this.msY.startAnimation(this.mth);
        this.mtb.startAnimation(this.mtk);
        this.mtc.startAnimation(this.mtj);
        this.mtf.startAnimation(this.mti);
        this.mto.setVisibility(8);
        this.msX.setBackground(null);
        this.mto.clearAnimation();
        for (ImageView backgroundColor : this.mtg) {
            backgroundColor.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.mig));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mtm != null) {
            this.mtm.aHX();
        }
    }
}
