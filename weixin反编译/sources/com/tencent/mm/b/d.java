package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.view.b.a;

public final class d extends b {
    public float fdA;
    public float fdB;
    public boolean fdC = true;
    public boolean fdD = false;
    public ValueAnimator fde;
    public a fdz;
    public float gr = 1.0f;

    /* renamed from: com.tencent.mm.b.d$1 */
    class AnonymousClass1 implements AnimatorUpdateListener {
        int fdE = 0;
        float fdF = ((float) Math.pow((double) (d.this.gr / this.fdG), 0.25d));
        final /* synthetic */ float fdG;
        float fdw = 0.0f;
        float fdx = 0.0f;

        public AnonymousClass1(float f) {
            this.fdG = f;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.fdE < 4 && d.this.fdC) {
                d.this.fdz.uS().postScale(this.fdF, this.fdF);
                this.fdE++;
            }
            RectF cBn = d.this.fdz.cBn();
            Rect rect = d.this.fdz.zNL;
            if (d.this.fdD) {
                if (cBn.top > ((float) rect.top)) {
                    f = ((float) rect.top) - cBn.top;
                } else {
                    f = 0.0f;
                }
                if (cBn.right < ((float) rect.right)) {
                    f2 = ((float) rect.right) - cBn.right;
                }
                if (cBn.bottom < ((float) rect.bottom)) {
                    f = ((float) rect.bottom) - cBn.bottom;
                }
                if (cBn.left > ((float) rect.left)) {
                    f2 = ((float) rect.left) - cBn.left;
                }
            } else {
                d dVar = d.this;
                dVar.fdA += floatValue2 - this.fdx;
                dVar = d.this;
                dVar.fdB += floatValue - this.fdw;
                f2 = d.this.fdA - cBn.centerX();
                f = d.this.fdB - cBn.centerY();
            }
            d.this.fdz.uS().postTranslate(f2, f);
            d.this.fdz.postInvalidate();
            this.fdw = floatValue;
            this.fdx = floatValue2;
        }
    }

    public d(a aVar) {
        this.fdz = aVar;
    }
}
