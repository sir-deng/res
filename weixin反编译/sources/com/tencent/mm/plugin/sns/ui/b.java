package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private int Wu = 0;
    private final Context context;
    private ag mHandler = new ag();
    int mHeight = 0;
    int mWidth = 0;
    private int rvB = 0;
    int rvC = 0;
    int rvD = 0;
    int rvE = 0;
    int rvF = 0;
    private float rvG = 0.0f;
    private float rvH = 0.0f;
    float rvI = 0.0f;
    float rvJ = 1.0f;
    int rvK = 0;
    int rvL = 0;
    int rvM = 0;
    int rvN = 0;
    int rvO = 0;
    private int rvP = 300;
    private int rvQ = 0;
    int rvR = 1;
    int rvS = 2;
    int rvT = 3;
    int rvU = 4;
    int rvV = this.rvQ;

    @TargetApi(18)
    public interface a {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b$3 */
    class AnonymousClass3 implements AnimationListener {
        final /* synthetic */ b rvW;

        AnonymousClass3(b bVar) {
            this.rvW = bVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.rvW != null) {
                this.rvW.onAnimationStart();
            }
            b.this.rvV = b.this.rvU;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.rvW != null) {
                this.rvW.onAnimationEnd();
            }
            b.this.rvV = b.this.rvR;
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b$2 */
    class AnonymousClass2 extends ScaleAnimation {
        final /* synthetic */ View rvY;
        final /* synthetic */ a rvZ = null;

        AnonymousClass2(float f, float f2, View view, a aVar) {
            this.rvY = view;
            super(1.0f, f, 1.0f, f2);
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (!(b.this.rvC == 0 || b.this.rvD == 0)) {
                Rect rect = new Rect();
                this.rvY.getGlobalVisibleRect(rect);
                int i = (rect.right - rect.left) / 2;
                int i2 = ((rect.bottom - rect.top) + b.this.rvK) / 2;
                int i3 = (int) (((((float) (b.this.rvC - b.this.mWidth)) * (1.0f - f)) + ((float) b.this.mWidth)) / (1.0f - ((1.0f - b.this.rvI) * f)));
                int i4 = (int) (((((float) (b.this.rvD - b.this.mHeight)) * (1.0f - f)) + ((float) b.this.mHeight)) / (1.0f - ((1.0f - b.this.rvI) * f)));
                int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) b.this.rvL) * f) / (1.0f - ((1.0f - b.this.rvI) * f))));
                int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) b.this.rvK) * (1.0f - f)) / 2.0f)) + ((((float) b.this.rvN) * f) / (1.0f - ((1.0f - b.this.rvI) * f))));
                i = (int) (((float) (i + (i3 / 2))) - ((((float) b.this.rvM) * f) / (1.0f - ((1.0f - b.this.rvI) * f))));
                i2 = (int) (((float) (i2 + (i4 / 2))) - ((((float) b.this.rvO) * f) / (1.0f - ((1.0f - b.this.rvI) * f))));
                if (VERSION.SDK_INT >= 21) {
                    this.rvY.setClipBounds(new Rect(i5, i6, i, i2));
                } else if (VERSION.SDK_INT >= 18 && this.rvZ == null) {
                    this.rvY.setClipBounds(new Rect(i5 + this.rvY.getScrollX(), i6, i + this.rvY.getScrollX(), i2));
                }
            }
            super.applyTransformation(f, transformation);
        }
    }

    public interface b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public b(Context context) {
        this.context = context;
    }

    public final void r(int i, int i2, int i3, int i4) {
        this.Wu = i;
        this.rvB = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    final void i(View view, boolean z) {
        int i;
        float f;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.Wu == 0 && this.rvB == 0) {
            this.Wu = view.getWidth() / 2;
            this.rvB = view.getHeight() / 2;
        }
        this.rvE = this.Wu - iArr[0];
        this.rvF = this.rvB - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.rvC;
            i = this.rvD;
            height = width;
        } else {
            i = height;
            height = width;
        }
        if (!(height == 0 || i == 0)) {
            this.rvG = ((float) this.mWidth) / ((float) height);
            this.rvH = ((float) this.mHeight) / ((float) i);
        }
        if (this.rvL == 0 && this.rvM == 0 && this.rvN == 0 && this.rvO == 0) {
            f = 1.0f;
        } else {
            f = 1.1f;
        }
        if (z) {
            if (!(this.rvC == 0 || this.rvD == 0)) {
                this.rvG = ((float) this.mWidth) / ((float) this.rvC);
                this.rvH = ((float) this.mHeight) / ((float) this.rvD);
            }
            f = 1.0f;
        }
        if (this.rvG > this.rvH) {
            this.rvI = this.rvG * f;
            this.rvF = (int) (((float) this.rvF) - (((((float) i) * this.rvI) - (((float) this.mHeight) * f)) / 2.0f));
        } else {
            this.rvI = this.rvH * f;
            this.rvE = (int) (((float) this.rvE) - (((((float) height) * this.rvI) - (((float) this.mWidth) * f)) / 2.0f));
            if (this.rvD != 0 && this.rvD < i) {
                this.rvF = (int) (((float) this.rvF) - (((((float) i) * this.rvI) - (((float) this.mHeight) * f)) / 2.0f));
            }
        }
        this.rvF = (int) ((((float) this.rvF) - ((((float) this.mHeight) * (f - 1.0f)) / 2.0f)) - ((((float) this.rvK) * this.rvI) / 2.0f));
        this.rvE = (int) (((float) this.rvE) - ((((float) this.mWidth) * (f - 1.0f)) / 2.0f));
        if (this.rvD != 0 && this.rvB < (i - this.rvD) / 2) {
            this.rvF = (int) ((((f - 1.0f) * ((float) this.mHeight)) / 2.0f) + ((float) this.rvF));
        } else if (this.rvD != 0 && this.rvB + this.mHeight > (this.rvD + i) / 2) {
            this.rvF = (int) (((float) this.rvF) - (((f - 1.0f) * ((float) this.mHeight)) / 2.0f));
        }
        if (this.mWidth == 0 && this.mHeight == 0) {
            this.rvI = 0.5f;
            this.rvJ = 0.0f;
            this.rvE = (int) (((float) this.rvE) - ((((float) height) * this.rvI) / 2.0f));
            this.rvF = (int) ((((float) this.rvF) - ((((float) i) * this.rvI) / 2.0f)) - ((((float) this.rvK) * this.rvI) / 2.0f));
        }
    }

    @TargetApi(16)
    public final void a(View view, LinkedList<View> linkedList, View view2, final b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.rvV != this.rvS && this.rvV != this.rvU && this.rvV != this.rvT) {
            i(view, false);
            e.ec(this.context);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.rvI);
            view.setScaleY(this.rvI);
            view.setTranslationX((float) this.rvE);
            view.setTranslationY((float) this.rvF);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.rvP);
            animatorSet.setInterpolator(new DecelerateInterpolator(1.2f));
            Builder play = animatorSet.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f}));
            Animator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{view.getScaleX(), 1.0f});
            Animator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{view.getScaleY(), 1.0f});
            Animator ofFloat3 = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{view.getTranslationX(), 0.0f});
            play.with(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{view.getTranslationY(), 0.0f}));
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                view3.setAlpha(0.0f);
                view3.setVisibility(0);
                view3.setTranslationY(100.0f);
                ofFloat3 = ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat = ObjectAnimator.ofFloat(view3, View.TRANSLATION_Y, new float[]{view3.getTranslationY(), 0.0f});
                ofFloat3.setDuration((long) (this.rvP >>> 1));
                ofFloat.setDuration((long) (this.rvP >>> 1));
                play.before(ofFloat3);
                play.before(ofFloat);
            }
            animatorSet.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationStart();
                    }
                    b.this.rvV = b.this.rvS;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                    b.this.rvV = b.this.rvT;
                }

                public final void onAnimationCancel(Animator animator) {
                    b.this.rvV = b.this.rvT;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.start();
        }
    }
}
