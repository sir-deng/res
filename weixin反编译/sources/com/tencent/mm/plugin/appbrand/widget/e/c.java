package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

public final class c extends e {
    private float kik;
    private float kil;

    public c(h hVar, long j, float f, float f2) {
        super(hVar, j);
        this.kik = f;
        this.kil = f2;
        this.kiy.play(mC(0));
    }

    protected final ValueAnimator mC(int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.kik, this.kil});
        ofFloat.setDuration(this.mDuration);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((h) c.this.kix).setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
            }
        });
        return ofFloat;
    }
}
