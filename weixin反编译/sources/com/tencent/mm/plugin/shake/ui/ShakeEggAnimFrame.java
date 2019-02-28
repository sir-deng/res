package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.bw.c;
import com.tencent.mm.bw.g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> qwo = new ArrayList();
    int qwp = 0;
    int size = 0;

    class b extends a {
        private int iTU;
        private int iTV;
        private float qwA;
        private float qwB;
        private float qws;
        private float qwt;
        private float qwu;
        private float qwv;
        private float qww = 0.01f;
        private float qwx = 0.02f;
        private float qwy;
        private float qwz;

        public b(int i, int i2) {
            super();
            this.iTU = i;
            this.iTV = i2;
            this.qws = ShakeEggAnimFrame.s(0.1f, 0.9f);
            this.qwt = this.qws;
            this.qwv = ShakeEggAnimFrame.s(-0.3f, -0.1f);
            restart();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.qwy;
            float f3 = this.qwA;
            if (this.qwy != this.qwz) {
                f2 = this.qwy + ((this.qwz - this.qwy) * f);
            }
            if (this.qwA != this.qwB) {
                f3 = this.qwA + ((this.qwB - this.qwA) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
        }

        private void restart() {
            if (this.qwv > 0.0f) {
                this.qwx += this.qww;
            }
            this.qwu = this.qwv;
            this.qwv += this.qwx;
            if (this.qwu > 1.1f) {
                Assert.assertTrue(this.targetView != null);
                this.targetView.post(new Runnable() {
                    public final void run() {
                        if (a.this.targetView != null) {
                            a.this.targetView.clearAnimation();
                            ShakeEggAnimFrame shakeEggAnimFrame = ShakeEggAnimFrame.this;
                            View view = a.this.targetView;
                            shakeEggAnimFrame.qwo.remove(view);
                            shakeEggAnimFrame.removeView(view);
                        }
                    }
                });
            }
            this.qwy = this.qws * ((float) this.iTU);
            this.qwz = this.qwt * ((float) this.iTU);
            this.qwA = this.qwu * ((float) this.iTV);
            this.qwB = this.qwv * ((float) this.iTV);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
        }
    }

    abstract class a extends Animation {
        protected int duration = 100;
        View targetView;

        a() {
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void J(Activity activity) {
        for (View view : this.qwo) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            Animation bVar = new b(displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.chT();
            com.tencent.mm.bw.b chK = com.tencent.mm.bw.b.chK();
            Drawable a = chK.a((c) chK.xsT.get(107));
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            CharSequence spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            View textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            ((a) bVar).targetView = textView;
            this.qwo.add(textView);
        }
    }

    static float s(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }

    private int getSize() {
        if (this.size == 0) {
            return (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
        }
        return this.size;
    }
}
