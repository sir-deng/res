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

public final class b extends a {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.b$6 */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] tLb = new int[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.bUL().length];

        static {
            try {
                tLb[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.tLc - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tLb[com.tencent.mm.plugin.webview.ui.tools.fts.a.b.tLd - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                b.this.tKI = layoutParams.leftMargin - b.this.oND;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                b.this.tKH = (int) view6.getX();
                return true;
            }
        });
    }

    public final void Bn(int i) {
        V(i, true);
    }

    public final void V(int i, boolean z) {
        if (i != this.tKS) {
            switch (AnonymousClass6.tLb[i - 1]) {
                case 1:
                    bUI();
                    return;
                case 2:
                    if (z) {
                        bUJ();
                        return;
                    }
                    this.tKK.setAlpha(0.0f);
                    this.tKO.setVisibility(0);
                    this.tKM.setAlpha(1.0f);
                    this.tKM.setVisibility(8);
                    this.tKN.setAlpha(1.0f);
                    this.tKJ.setPadding(this.tKI, 0, 0, 0);
                    int i2 = this.tKF;
                    LayoutParams layoutParams = (LayoutParams) this.tKJ.getLayoutParams();
                    layoutParams.leftMargin = this.tKF - i2;
                    layoutParams.rightMargin = this.tKF - i2;
                    layoutParams.width = (i2 * 2) + ((int) this.tKR[2][0]);
                    this.tKJ.setLayoutParams(layoutParams);
                    this.tKJ.post(new Runnable() {
                        public final void run() {
                            b.this.tKJ.setY(b.this.tKR[0][1]);
                            b.this.tKJ.setX(b.this.tKR[1][1]);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    protected final void bUI() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tKR[0][0] - ((float) this.tKG) >= 0.0f) {
            ofFloat.addUpdateListener(this.tKW);
        } else {
            ofFloat.addUpdateListener(this.tKX);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tKQ, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tKK, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.tKM, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat4, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                b.this.isAnimating = true;
                if (b.this.tKT != null) {
                    b.this.tKT.onAnimationStart();
                }
                b.this.tKM.setVisibility(0);
                b.this.tKK.setVisibility(0);
                b.this.tKO.setVisibility(8);
                b.this.tKN.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                b.this.isAnimating = false;
                if (b.this.tKT != null) {
                    b.this.tKT.onAnimationEnd();
                }
                b.this.tKL.setVisibility(0);
                b.this.tKJ.setPadding(0, 0, 0, 0);
                b.this.tKN.setAlpha(1.0f);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bUJ() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tKR[0][0] - ((float) this.tKG) >= 0.0f) {
            ofFloat.addUpdateListener(this.tKU);
        } else {
            ofFloat.addUpdateListener(this.tKV);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tKQ, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tKK, "alpha", new float[]{1.0f, 0.0f});
        this.tKM.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                b.this.isAnimating = true;
                if (b.this.tKT != null) {
                    b.this.tKT.onAnimationStart();
                }
                b.this.tKL.setVisibility(8);
                b.this.tKN.setVisibility(0);
            }

            public final void onAnimationEnd(Animator animator) {
                b.this.isAnimating = false;
                if (b.this.tKT != null) {
                    b.this.tKT.onAnimationEnd();
                }
                b.this.tKO.setVisibility(0);
                b.this.tKM.setAlpha(1.0f);
                b.this.tKM.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
