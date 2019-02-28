package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

final class w extends e {
    final ValueAnimator lC = new ValueAnimator();

    w() {
    }

    public final void start() {
        this.lC.start();
    }

    public final boolean isRunning() {
        return this.lC.isRunning();
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.lC.setInterpolator(interpolator);
    }

    public final void a(final b bVar) {
        this.lC.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.ay();
            }
        });
    }

    public final void a(final a aVar) {
        this.lC.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                aVar.onAnimationEnd();
            }

            public final void onAnimationCancel(Animator animator) {
            }
        });
    }

    public final void g(int i, int i2) {
        this.lC.setIntValues(new int[]{i, i2});
    }

    public final int aA() {
        return ((Integer) this.lC.getAnimatedValue()).intValue();
    }

    public final void e(float f, float f2) {
        this.lC.setFloatValues(new float[]{f, f2});
    }

    public final float aB() {
        return ((Float) this.lC.getAnimatedValue()).floatValue();
    }

    public final void setDuration(int i) {
        this.lC.setDuration((long) i);
    }

    public final void cancel() {
        this.lC.cancel();
    }

    public final float getAnimatedFraction() {
        return this.lC.getAnimatedFraction();
    }

    public final long getDuration() {
        return this.lC.getDuration();
    }
}
