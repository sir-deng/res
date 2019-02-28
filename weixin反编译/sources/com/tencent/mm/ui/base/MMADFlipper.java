package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;

public class MMADFlipper extends ViewGroup {
    private VelocityTracker ft;
    private int iN;
    private Context mContext;
    private Scroller yJ;
    private int yhn;
    private Interpolator yho;
    private int yhp;
    private int yhq;
    private boolean yhr;
    private boolean yhs;
    private float za;
    private float zb;

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yhn = 0;
        this.yhr = false;
        this.yhs = true;
        this.mContext = context;
        this.yho = new LinearInterpolator();
        this.yJ = new Scroller(this.mContext, this.yho);
        this.iN = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.yhs) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.yhn != 0) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.za = x;
                this.zb = y;
                this.yhn = this.yJ.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.yhn = 0;
                break;
            case 2:
                boolean z;
                action = (int) Math.abs(this.za - x);
                int abs = (int) Math.abs(this.zb - y);
                if (action <= this.iN || abs >= this.iN) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.yhn = 0;
                    break;
                }
                this.yhn = 1;
                break;
                break;
        }
        if (this.yhn == 0) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                if (!this.yJ.isFinished()) {
                    this.yJ.abortAnimation();
                }
                this.za = x;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.ft;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600) {
                    if (cpF()) {
                        this.yhp--;
                        EN(this.yhp);
                    }
                    this.yhr = true;
                } else if (action < -600) {
                    if (cpF()) {
                        this.yhp++;
                        EN(this.yhp);
                    }
                    this.yhr = true;
                } else {
                    action = getWidth();
                    EN((getScrollX() + (action / 2)) / action);
                }
                if (this.ft != null) {
                    this.ft.recycle();
                    this.ft = null;
                }
                this.yhn = 0;
                this.za = 0.0f;
                this.zb = 0.0f;
                return true;
            case 2:
                action = (int) (this.za - x);
                this.za = x;
                scrollBy(action, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean cpF() {
        if (getChildCount() > 1) {
            return true;
        }
        return false;
    }

    private void EN(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.yJ.startScroll(getScrollX(), 0, width, 0, a.ad(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        x.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", Integer.valueOf(this.yhp), Integer.valueOf(this.yhq), Integer.valueOf(i));
        this.yhq = i;
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        } else if (this.yhr) {
            this.yhr = false;
            if (this.yhp <= 0) {
                this.yhp = getChildCount() > 1 ? getChildCount() - 2 : getChildCount();
                EO(this.yhp * getWidth());
            } else if (this.yhp >= getChildCount() - 1) {
                this.yhp = 1;
                EO(this.yhp * getWidth());
            }
        }
    }

    @TargetApi(14)
    private void EO(int i) {
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
        } else if (this.yJ != null) {
            this.yJ.setFinalX(i);
        }
    }
}
