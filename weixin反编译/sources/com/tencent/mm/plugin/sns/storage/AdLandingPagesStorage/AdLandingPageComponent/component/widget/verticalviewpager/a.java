package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;

public final class a implements OnTouchListener {
    private float iTX = Float.MIN_VALUE;
    private DummyViewPager rsP;
    private float rsQ = Float.MIN_VALUE;

    public a(DummyViewPager dummyViewPager) {
        this.rsP = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.rsQ).append(",downY ").append(this.iTX);
        switch (motionEvent.getAction()) {
            case 0:
                this.iTX = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.rsP.zg) {
                    try {
                        AdLandingViewPager adLandingViewPager = this.rsP;
                        if (adLandingViewPager.zg) {
                            VelocityTracker velocityTracker = adLandingViewPager.ft;
                            velocityTracker.computeCurrentVelocity(1000, (float) adLandingViewPager.zd);
                            int a = (int) y.a(velocityTracker, adLandingViewPager.fu);
                            adLandingViewPager.yV = true;
                            int bR = adLandingViewPager.bR();
                            int scrollX = adLandingViewPager.getScrollX();
                            b byk = adLandingViewPager.byk();
                            adLandingViewPager.a(adLandingViewPager.a(byk.position, ((((float) scrollX) / ((float) bR)) - byk.zA) / byk.zz, a, (int) (adLandingViewPager.za - adLandingViewPager.xP)), true, true, a);
                            adLandingViewPager.cE();
                            adLandingViewPager.zg = false;
                        } else {
                            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                        }
                    } catch (Exception e) {
                    }
                }
                this.iTX = Float.MIN_VALUE;
                this.rsQ = Float.MIN_VALUE;
                break;
            case 2:
                if (this.iTX == Float.MIN_VALUE && this.rsQ == Float.MIN_VALUE) {
                    this.iTX = motionEvent.getRawY();
                    break;
                }
                float rawY = motionEvent.getRawY() - (this.rsQ == Float.MIN_VALUE ? this.iTX : this.rsQ);
                this.rsQ = motionEvent.getRawY();
                float f = rawY / 2.0f;
                new StringBuilder("scrollX ").append(this.rsP.getScrollX()).append(",basescrollX ").append(this.rsP.bym());
                if (this.rsP.getScrollX() == this.rsP.bym()) {
                    if (z.h(view, (-f) > 0.0f ? 1 : -1)) {
                        new StringBuilder("scroll vertically  ").append(f).append(", move.lastMotionY ").append(motionEvent.getY());
                        break;
                    }
                    this.rsP.byl();
                    a(view, motionEvent, f);
                    b(view, motionEvent);
                    return false;
                } else if (a(view, motionEvent, f)) {
                    return false;
                }
                break;
        }
        return view.onTouchEvent(motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent, float f) {
        if (!this.rsP.zg) {
            return false;
        }
        boolean z;
        float scrollX;
        float scrollX2 = (float) (((int) (((float) this.rsP.getScrollX()) - f)) - this.rsP.bym());
        float scrollX3 = (float) (this.rsP.getScrollX() - this.rsP.bym());
        if (Math.abs(scrollX2 + scrollX3) < Math.abs(scrollX2 - scrollX3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            scrollX = (float) (this.rsP.getScrollX() - this.rsP.bym());
        } else {
            scrollX = f;
        }
        AdLandingViewPager adLandingViewPager = this.rsP;
        if (adLandingViewPager.zg) {
            adLandingViewPager.za += scrollX;
            float scrollX4 = ((float) adLandingViewPager.getScrollX()) - scrollX;
            int bR = adLandingViewPager.bR();
            float f2 = ((float) bR) * adLandingViewPager.yR;
            b bVar = (b) adLandingViewPager.ep.get(0);
            b bVar2 = (b) adLandingViewPager.ep.get(adLandingViewPager.ep.size() - 1);
            scrollX2 = bVar.position != 0 ? bVar.zA * ((float) bR) : ((float) bR) * adLandingViewPager.yQ;
            scrollX3 = bVar2.position != adLandingViewPager.yE.getCount() + -1 ? bVar2.zA * ((float) bR) : f2;
            if (scrollX4 >= scrollX2) {
                scrollX2 = scrollX4 > scrollX3 ? scrollX3 : scrollX4;
            }
            adLandingViewPager.za += scrollX2 - ((float) ((int) scrollX2));
            adLandingViewPager.scrollTo((int) scrollX2, adLandingViewPager.getScrollY());
            adLandingViewPager.ak((int) scrollX2);
            MotionEvent obtain = MotionEvent.obtain(adLandingViewPager.rsG, SystemClock.uptimeMillis(), 2, adLandingViewPager.za, 0.0f, 0);
            adLandingViewPager.ft.addMovement(obtain);
            obtain.recycle();
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.rsP.getScrollX());
            b(view, motionEvent);
            return true;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    private static void b(View view, MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
    }
}
