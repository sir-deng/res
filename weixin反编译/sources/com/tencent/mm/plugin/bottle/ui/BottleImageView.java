package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class BottleImageView extends ImageView {
    int Rn;
    int Ro;
    int Rp;
    int Rq;
    Context context;
    private int kHJ;
    private int kHK;
    Animation kHL = new Animation() {
        private float kGI = -1.0f;
        private float kGJ = -1.0f;
        private float kGK = -1.0f;
        private float kGL = -1.0f;
        private float kGM = 1.0f;
        private float kGN = 0.1f;
        private float kHM;
        private float kHN;
        private float kHO;
        private float kHP;
        private float kHQ;
        private boolean kHR = false;
        private float kHS = 0.0f;
        private float kHT = -850.0f;
        private float kHU = 1.0f;
        private float kHV = 0.3f;

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.kGI == -1.0f) {
                this.kGI = (float) BottleImageView.this.Rn;
                this.kGJ = (float) BottleImageView.this.Rp;
                this.kGK = (float) BottleImageView.this.Ro;
                this.kGL = (float) BottleImageView.this.Rq;
                this.kHM = this.kGI + ((this.kGJ - this.kGI) / 5.0f);
                this.kHN = this.kGI + (((this.kGJ - this.kGI) * 3.0f) / 5.0f);
                this.kHO = ((((this.kHM - this.kGI) / (this.kGJ - this.kGI)) * (this.kGL - this.kGK)) + this.kGK) - ((float) b.b(BottleImageView.this.context, 67.0f));
                this.kHP = ((((this.kHN - this.kGI) / (this.kGJ - this.kGI)) * (this.kGL - this.kGK)) + this.kGK) - ((float) b.b(BottleImageView.this.context, 53.0f));
            }
            transformation.setAlpha(this.kHU + ((this.kHV - this.kHU) * f));
            float f2 = this.kGM + ((this.kGN - this.kGM) * f);
            transformation.getMatrix().setScale(f2, f2, (float) (BottleImageView.this.kHJ / 2), (float) (BottleImageView.this.kHK / 2));
            transformation.getMatrix().postRotate(this.kHS + ((this.kHT - this.kHS) * f), (float) (BottleImageView.this.kHJ / 2), (float) (BottleImageView.this.kHK / 2));
            float f3 = ((this.kGJ - this.kGI) * f) + this.kGI;
            if (f3 >= this.kHM) {
                f2 = (((f3 - this.kGI) / (this.kHM - this.kGI)) * (this.kHO - this.kGK)) + this.kGK;
            } else if (f3 >= this.kHN) {
                if (!this.kHR) {
                    this.kHR = true;
                    this.kHO = this.kHQ;
                }
                f2 = (((f3 - this.kHM) / (this.kHN - this.kHM)) * (this.kHP - this.kHO)) + this.kHO;
            } else {
                f2 = (((f3 - this.kHN) / (this.kGJ - this.kHN)) * (this.kGL - this.kHP)) + this.kHP;
            }
            this.kHQ = f2;
            transformation.getMatrix().postTranslate(f3, f2);
            if (f == 1.0f) {
                this.kGI = -1.0f;
                this.kGJ = -1.0f;
                this.kGK = -1.0f;
                this.kGL = -1.0f;
                this.kHR = false;
            }
        }
    };

    public BottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        ass();
    }

    public BottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        ass();
    }

    private void ass() {
        Drawable background = getBackground();
        if (background != null) {
            this.kHJ = background.getIntrinsicWidth();
            this.kHK = background.getIntrinsicHeight();
        }
    }
}
