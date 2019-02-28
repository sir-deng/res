package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.mm.plugin.appbrand.compat.a.b.d;

public abstract class e {
    d kix;
    AnimatorSet kiy = new AnimatorSet();
    long mDuration;

    protected abstract ValueAnimator mC(int i);

    protected e(d dVar, long j) {
        this.kix = dVar;
        this.mDuration = j;
    }

    public void aom() {
        this.kiy.start();
    }

    public final void a(AnimatorListener animatorListener) {
        this.kiy.addListener(animatorListener);
    }
}
