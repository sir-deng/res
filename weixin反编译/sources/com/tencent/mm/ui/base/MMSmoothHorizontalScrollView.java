package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private Rect fD = new Rect();
    private Interpolator fe = new DecelerateInterpolator();
    private TranslateAnimation pEn;
    private View ylZ;
    private float za;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFadingEdgeLength(0);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.ylZ = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (this.ylZ == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.za = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.za = 0.0f;
                if (this.fD.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.pEn = new TranslateAnimation((float) this.ylZ.getLeft(), (float) this.fD.left, 0.0f, 0.0f);
                    this.pEn.setInterpolator(this.fe);
                    this.pEn.setDuration((long) Math.abs(this.ylZ.getLeft() - this.fD.left));
                    this.ylZ.startAnimation(this.pEn);
                    this.ylZ.layout(this.fD.left, this.fD.top, this.fD.right, this.fD.bottom);
                    this.fD.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.za == 0.0f) {
                    this.za = x;
                }
                int i3 = ((int) (this.za - x)) / 2;
                scrollBy(i3, 0);
                this.za = x;
                int measuredWidth = this.ylZ.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.fD.isEmpty()) {
                        this.fD.set(this.ylZ.getLeft(), this.ylZ.getTop(), this.ylZ.getRight(), this.ylZ.getBottom());
                    }
                    this.ylZ.layout(this.ylZ.getLeft() - i3, this.ylZ.getTop(), this.ylZ.getRight() - i3, this.ylZ.getBottom());
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
