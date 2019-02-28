package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import org.xwalk.core.Log;

public final class d extends a {
    public d(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                d.this.tKI = layoutParams.leftMargin - d.this.oND;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                d.this.tKH = 0;
                return true;
            }
        });
    }

    protected final void bUI() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "search to init");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tKR[0][0] - ((float) this.tKG) >= 0.0f) {
            ofFloat.addUpdateListener(this.tKW);
        } else {
            ofFloat.addUpdateListener(this.tKX);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tKK, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tKM, "alpha", new float[]{0.0f, 1.0f});
        this.tKN.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                d.this.isAnimating = true;
                if (d.this.tKT != null) {
                    d.this.tKT.onAnimationStart();
                }
                d.this.tKM.setVisibility(0);
                d.this.tKK.setVisibility(0);
                d.this.tKO.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                d.this.isAnimating = false;
                if (d.this.tKT != null) {
                    d.this.tKT.onAnimationEnd();
                }
                d.this.tKL.setVisibility(0);
                d.this.tKJ.setPadding(0, 0, 0, 0);
                d.this.tKN.setAlpha(1.0f);
                d.this.tKN.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bUJ() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "init to search");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tKR[0][0] - ((float) this.tKG) >= 0.0f) {
            ofFloat.addUpdateListener(this.tKU);
        } else {
            ofFloat.addUpdateListener(this.tKV);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tKK, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tKM, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.tKN, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                d.this.isAnimating = true;
                if (d.this.tKT != null) {
                    d.this.tKT.onAnimationStart();
                }
                d.this.tKL.setVisibility(8);
                d.this.tKN.setVisibility(0);
            }

            public final void onAnimationEnd(Animator animator) {
                d.this.isAnimating = false;
                if (d.this.tKT != null) {
                    d.this.tKT.onAnimationEnd();
                }
                d.this.tKO.setVisibility(0);
                d.this.tKM.setAlpha(1.0f);
                d.this.tKM.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
