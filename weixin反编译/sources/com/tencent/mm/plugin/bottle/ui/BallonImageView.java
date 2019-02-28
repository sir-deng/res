package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView extends ImageView {
    private Animation kGH = new Animation() {
        private int iTU;
        private int iTV;
        private float kGI = 0.1f;
        private float kGJ = AnonymousClass1.s(0.1f, 0.8f);
        private float kGK = 0.1f;
        private float kGL = AnonymousClass1.s(0.1f, 0.3f);
        private float kGM = 1.0f;
        private float kGN = AnonymousClass1.s(0.7f, 1.0f);
        private float kGO;
        private float kGP;
        private float kGQ;
        private float kGR;

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.kGO;
            float f3 = this.kGQ;
            if (this.kGO != this.kGP) {
                f2 = this.kGO + ((this.kGP - this.kGO) * f);
            }
            if (this.kGQ != this.kGR) {
                f3 = this.kGQ + ((this.kGR - this.kGQ) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            f2 = this.kGM + ((this.kGN - this.kGM) * f);
            transformation.getMatrix().postScale(f2, f2);
            if (f == 1.0f) {
                this.kGI = this.kGJ;
                this.kGK = this.kGL;
                this.kGJ = AnonymousClass1.s(0.1f, 0.8f);
                this.kGL = AnonymousClass1.s(0.1f, 0.3f);
                this.kGM = this.kGN;
                this.kGN = AnonymousClass1.s(0.7f, 1.0f);
                asp();
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.iTU = i3;
            this.iTV = i4;
            asp();
        }

        private void asp() {
            this.kGO = this.kGI * ((float) this.iTU);
            this.kGP = this.kGJ * ((float) this.iTU);
            this.kGQ = this.kGK * ((float) this.iTV);
            this.kGR = this.kGL * ((float) this.iTV);
        }

        private static float s(float f, float f2) {
            return (((float) Math.random()) * (f2 - f)) + f;
        }
    };

    public BallonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGH.setRepeatCount(-1);
        this.kGH.setDuration(15000);
        this.kGH.setFillAfter(true);
    }

    public BallonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGH.setRepeatCount(-1);
        this.kGH.setDuration(15000);
        this.kGH.setFillAfter(true);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(this.kGH);
        } else {
            a.c(this, this.kGH);
        }
        super.setVisibility(i);
    }
}
