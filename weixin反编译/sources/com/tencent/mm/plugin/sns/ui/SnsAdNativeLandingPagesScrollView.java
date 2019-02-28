package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    private an rDA = null;
    private long rDB = System.currentTimeMillis();
    private Runnable rDC = new Runnable() {
        public final void run() {
            int scrollY = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            x.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rDy), Integer.valueOf(scrollY));
            if (scrollY != SnsAdNativeLandingPagesScrollView.this.rDy) {
                if (SnsAdNativeLandingPagesScrollView.this.rDA != null) {
                    SnsAdNativeLandingPagesScrollView.this.rDA;
                    SnsAdNativeLandingPagesScrollView.this.rDx;
                }
                SnsAdNativeLandingPagesScrollView.this.rDB = System.currentTimeMillis();
            }
            if (SnsAdNativeLandingPagesScrollView.this.rDy - scrollY == 0) {
                if (SnsAdNativeLandingPagesScrollView.this.rDA != null) {
                    SnsAdNativeLandingPagesScrollView.this.rDA;
                    SnsAdNativeLandingPagesScrollView.this.rDy;
                    SnsAdNativeLandingPagesScrollView.this.rDx;
                }
                SnsAdNativeLandingPagesScrollView.this.rDx = SnsAdNativeLandingPagesScrollView.this.rDy;
            }
            SnsAdNativeLandingPagesScrollView.this.rDy = SnsAdNativeLandingPagesScrollView.this.getScrollY();
            x.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", Integer.valueOf(SnsAdNativeLandingPagesScrollView.this.rDy), Integer.valueOf(scrollY));
            SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.this.rDC, (long) SnsAdNativeLandingPagesScrollView.this.rDz);
        }
    };
    private int rDx = 0;
    private int rDy = 0;
    private int rDz = 50;

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        x.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
