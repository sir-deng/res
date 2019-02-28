package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public final class g {
    private int kcn;
    public ValueAnimator kco;
    View view;

    public g(View view) {
        this.view = view;
    }

    public final void b(int i, final Runnable runnable) {
        if (this.view != null) {
            this.kcn = i;
            if ((this.view.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.view.getBackground()).getColor() == i) {
                if (runnable != null) {
                    runnable.run();
                }
                if (this.kco != null) {
                    this.kco.cancel();
                    return;
                }
                return;
            }
            AnimatorListener anonymousClass1 = new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    g.this.kco = null;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    g.this.kco = null;
                }
            };
            if (this.kco != null && this.kco.isStarted() && this.kco.isRunning() && this.kcn == i) {
                this.kco.addListener(anonymousClass1);
                return;
            }
            if (this.kco != null) {
                this.kco.cancel();
            }
            int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
            this.kco = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.kcn)});
            this.kco.addListener(anonymousClass1);
            this.kco.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (g.this.view != null) {
                        g.this.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.kco.start();
        }
    }
}
