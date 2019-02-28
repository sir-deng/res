package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Random;

public class SprayLayout extends FrameLayout {
    private ag handler;
    private ImageView kJc;
    private ImageView kJd;
    private ImageView kJe;
    Animation kJf;
    Animation kJg;
    Animation kJh;
    Animation kJi;
    Animation kJj;
    AnimationSet kJk;
    AnimationSet kJl;
    AnimationSet kJm;
    private int kJn;
    private int kJo;
    private int kJp;
    private int kJq;
    private int kJr;
    private int kJs;
    private Runnable kJt;
    private int repeatCount;

    static /* synthetic */ void d(SprayLayout sprayLayout) {
        int i = -1;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sprayLayout.getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) sprayLayout.getParent();
        if (marginLayoutParams != null && frameLayout != null) {
            if (sprayLayout.kJp == -1 && sprayLayout.kJq == -1) {
                Random random = new Random();
                int nextInt = (random.nextBoolean() ? 1 : -1) * random.nextInt(sprayLayout.kJr);
                int sqrt = (int) Math.sqrt((double) (((((sprayLayout.kJr * sprayLayout.kJr) - (nextInt * nextInt)) * sprayLayout.kJs) * sprayLayout.kJs) / (sprayLayout.kJr * sprayLayout.kJr)));
                if (random.nextBoolean()) {
                    i = 1;
                }
                marginLayoutParams.setMargins(nextInt, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((frameLayout.getHeight() * 300) / 800) + (random.nextInt(Math.max(sqrt, 1)) * i));
            } else {
                marginLayoutParams.setMargins(sprayLayout.kJp - (frameLayout.getWidth() / 2), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, frameLayout.getHeight() - sprayLayout.kJq);
            }
            sprayLayout.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ int k(SprayLayout sprayLayout) {
        int i = sprayLayout.kJn + 1;
        sprayLayout.kJn = i;
        return i;
    }

    public SprayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SprayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kJf = new ScaleAnimation(0.6f, 0.8f, 0.6f, 0.8f, 1, 0.5f, 1, 1.0f);
        this.kJg = new AlphaAnimation(0.2f, 1.0f);
        this.kJh = new ScaleAnimation(0.8f, 1.27f, 0.8f, 1.27f, 1, 0.5f, 1, 1.0f);
        this.kJi = new AlphaAnimation(1.0f, 0.5f);
        this.kJj = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.kJk = new AnimationSet(true);
        this.kJl = new AnimationSet(true);
        this.kJm = new AnimationSet(true);
        this.kJf.setDuration(280);
        this.kJg.setDuration(280);
        this.kJh.setDuration(280);
        this.kJi.setDuration(280);
        this.kJk.addAnimation(this.kJf);
        this.kJk.addAnimation(this.kJg);
        this.kJk.setRepeatCount(1);
        this.kJk.setDuration(280);
        this.kJl.addAnimation(this.kJh);
        this.kJl.setRepeatCount(1);
        this.kJl.setDuration(280);
        this.kJm.addAnimation(this.kJj);
        this.kJm.setRepeatCount(1);
        this.kJm.setDuration(280);
        this.kJn = 0;
        this.repeatCount = 1;
        this.kJp = -1;
        this.kJq = -1;
        this.handler = new ag();
        this.kJt = new Runnable() {
            public final void run() {
                if (SprayLayout.this.kJn == 0) {
                    SprayLayout.this.kJo = SprayLayout.this.kJo + 1;
                    SprayLayout.this.kJe.clearAnimation();
                    SprayLayout.this.kJe.setVisibility(8);
                    SprayLayout.d(SprayLayout.this);
                } else if (SprayLayout.this.kJn == 1) {
                    SprayLayout.this.kJc.startAnimation(SprayLayout.this.kJk);
                    SprayLayout.this.kJc.setVisibility(0);
                    SprayLayout.this.kJd.setVisibility(8);
                    SprayLayout.this.kJe.setVisibility(8);
                } else if (SprayLayout.this.kJn == 2) {
                    SprayLayout.this.kJc.startAnimation(SprayLayout.this.kJl);
                    SprayLayout.this.kJd.startAnimation(SprayLayout.this.kJk);
                    SprayLayout.this.kJd.setVisibility(0);
                } else if (SprayLayout.this.kJn == 3) {
                    SprayLayout.this.kJc.clearAnimation();
                    SprayLayout.this.kJc.setVisibility(8);
                    SprayLayout.this.kJd.startAnimation(SprayLayout.this.kJl);
                    SprayLayout.this.kJe.startAnimation(SprayLayout.this.kJk);
                    SprayLayout.this.kJe.setVisibility(0);
                } else if (SprayLayout.this.kJn == 4) {
                    SprayLayout.this.kJe.startAnimation(SprayLayout.this.kJm);
                    SprayLayout.this.kJd.clearAnimation();
                    SprayLayout.this.kJd.setVisibility(8);
                }
                if (SprayLayout.this.kJo > SprayLayout.this.repeatCount) {
                    SprayLayout.this.stop();
                    return;
                }
                SprayLayout.this.handler.postDelayed(SprayLayout.this.kJt, 280);
                SprayLayout.this.kJn = SprayLayout.k(SprayLayout.this) % 5;
            }
        };
    }

    public final void G(int i, int i2, int i3) {
        this.kJn = 0;
        this.repeatCount = i;
        this.kJo = 0;
        this.kJp = i2;
        this.kJq = i3;
        if (this.kJc == null) {
            this.kJc = (ImageView) findViewById(R.h.bOB);
            this.kJd = (ImageView) findViewById(R.h.bOD);
            this.kJe = (ImageView) findViewById(R.h.bOC);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.kJr = (displayMetrics.widthPixels * 35) / 96;
            this.kJs = displayMetrics.heightPixels / 16;
        }
        this.kJc.setVisibility(8);
        this.kJd.setVisibility(8);
        this.kJe.setVisibility(8);
        setVisibility(0);
        this.handler.removeCallbacks(this.kJt);
        this.handler.postDelayed(this.kJt, 0);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.kJt);
        setVisibility(8);
    }
}
