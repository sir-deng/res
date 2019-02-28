package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import b.c.b.e;

public class RadarSpecialSmoothScrollView extends ScrollView {
    private final Rect fD = new Rect();
    private RadarSpecialTableLayout pEm;
    private TranslateAnimation pEn;
    private final a pEo = new a();
    private float zb;

    private static final class a implements Interpolator {
        private static final float pEq = pEq;
        public static final a pEr = new a();
        private final float pEp = pEq;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (((f2 * (this.pEp + 1.0f)) + this.pEp) * (f2 * f2)) + 1.0f;
        }
    }

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (!(childAt instanceof RadarSpecialTableLayout)) {
                childAt = null;
            }
            this.pEm = (RadarSpecialTableLayout) childAt;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        e.i(motionEvent, "ev");
        if (this.pEm == null) {
            return super.onTouchEvent(motionEvent);
        }
        RadarSpecialTableLayout radarSpecialTableLayout;
        switch (motionEvent.getAction()) {
            case 0:
                this.zb = motionEvent.getY();
                break;
            case 1:
                this.zb = 0.0f;
                if (this.fD.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    radarSpecialTableLayout = this.pEm;
                    if (radarSpecialTableLayout == null) {
                        e.cKr();
                    }
                    this.pEn = new TranslateAnimation(0.0f, 0.0f, (float) (radarSpecialTableLayout.getTop() - this.fD.top), 0.0f);
                    TranslateAnimation translateAnimation = this.pEn;
                    if (translateAnimation == null) {
                        e.cKr();
                    }
                    translateAnimation.setInterpolator(this.pEo);
                    TranslateAnimation translateAnimation2 = this.pEn;
                    if (translateAnimation2 == null) {
                        e.cKr();
                    }
                    radarSpecialTableLayout = this.pEm;
                    if (radarSpecialTableLayout == null) {
                        e.cKr();
                    }
                    translateAnimation2.setDuration((long) Math.abs(radarSpecialTableLayout.getTop() - this.fD.top));
                    radarSpecialTableLayout = this.pEm;
                    if (radarSpecialTableLayout == null) {
                        e.cKr();
                    }
                    radarSpecialTableLayout.startAnimation(this.pEn);
                    RadarSpecialTableLayout radarSpecialTableLayout2 = this.pEm;
                    if (radarSpecialTableLayout2 == null) {
                        e.cKr();
                    }
                    radarSpecialTableLayout2.p(this.fD.left, this.fD.top, this.fD.right, this.fD.bottom);
                    this.fD.setEmpty();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.zb == 0.0f) {
                    this.zb = y;
                }
                RadarSpecialTableLayout radarSpecialTableLayout3 = this.pEm;
                if (radarSpecialTableLayout3 == null) {
                    e.cKr();
                }
                int measuredHeight = radarSpecialTableLayout3.getMeasuredHeight() - getHeight();
                int scrollY = getScrollY();
                if (!(scrollY == 0 || scrollY == measuredHeight)) {
                    i = 0;
                }
                if (i != 0) {
                    RadarSpecialTableLayout radarSpecialTableLayout4;
                    RadarSpecialTableLayout radarSpecialTableLayout5;
                    int right;
                    RadarSpecialTableLayout radarSpecialTableLayout6;
                    i = (int) (this.zb - y);
                    scrollBy(0, i);
                    if (this.fD.isEmpty()) {
                        Rect rect = this.fD;
                        radarSpecialTableLayout3 = this.pEm;
                        if (radarSpecialTableLayout3 == null) {
                            e.cKr();
                        }
                        measuredHeight = radarSpecialTableLayout3.getLeft();
                        radarSpecialTableLayout4 = this.pEm;
                        if (radarSpecialTableLayout4 == null) {
                            e.cKr();
                        }
                        scrollY = radarSpecialTableLayout4.getTop();
                        radarSpecialTableLayout5 = this.pEm;
                        if (radarSpecialTableLayout5 == null) {
                            e.cKr();
                        }
                        right = radarSpecialTableLayout5.getRight();
                        radarSpecialTableLayout6 = this.pEm;
                        if (radarSpecialTableLayout6 == null) {
                            e.cKr();
                        }
                        rect.set(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom());
                    }
                    radarSpecialTableLayout = this.pEm;
                    if (radarSpecialTableLayout == null) {
                        e.cKr();
                    }
                    radarSpecialTableLayout3 = this.pEm;
                    if (radarSpecialTableLayout3 == null) {
                        e.cKr();
                    }
                    measuredHeight = radarSpecialTableLayout3.getLeft();
                    radarSpecialTableLayout4 = this.pEm;
                    if (radarSpecialTableLayout4 == null) {
                        e.cKr();
                    }
                    scrollY = radarSpecialTableLayout4.getTop() - (i / 2);
                    radarSpecialTableLayout5 = this.pEm;
                    if (radarSpecialTableLayout5 == null) {
                        e.cKr();
                    }
                    right = radarSpecialTableLayout5.getRight();
                    radarSpecialTableLayout6 = this.pEm;
                    if (radarSpecialTableLayout6 == null) {
                        e.cKr();
                    }
                    radarSpecialTableLayout.p(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.zb - y)) / 2);
                }
                this.zb = y;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
