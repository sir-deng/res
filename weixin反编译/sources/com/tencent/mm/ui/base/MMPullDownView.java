package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.v.a.h;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int yls = 400;
    private static final int ylv = Color.parseColor("#00000000");
    public int bgColor;
    public Context context;
    private GestureDetector mbL;
    public View xNM;
    private Scroller yJ;
    private int yhp;
    private int yiO;
    public g ykU;
    public e ykV;
    public int ykW;
    public int ykX;
    private boolean ykY;
    private boolean ykZ;
    private boolean yla;
    private boolean ylb;
    public boolean ylc;
    private boolean yld;
    private boolean yle;
    private boolean ylf;
    public c ylg;
    public d ylh;
    public View yli;
    private int ylj;
    private int ylk;
    private int yll;
    private boolean ylm;
    public f yln;
    public boolean ylo;
    private k ylp;
    public boolean ylq;
    public a ylr;
    private ag ylt;
    boolean ylu;
    public boolean ylw;
    private int ylx;
    public int yly;
    public b ylz;

    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface c {
        boolean azT();
    }

    public interface e {
        boolean azR();
    }

    public interface f {
        void ax(float f);

        void bCB();
    }

    public interface g {
        boolean azU();
    }

    public interface b {
        void aFP();
    }

    public interface d {
        boolean azS();
    }

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yiO = 1;
        this.ykY = false;
        this.ykZ = false;
        this.yla = false;
        this.ylb = false;
        this.ylc = true;
        this.yld = false;
        this.yle = true;
        this.ylf = true;
        this.ylk = 4;
        this.yll = 4;
        this.ylm = false;
        this.ylo = true;
        this.ylq = false;
        this.ylt = new ag() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (MMPullDownView.this.ylj) {
                    case 0:
                        if (MMPullDownView.this.ykU != null) {
                            MMPullDownView.this.ylc = MMPullDownView.this.ykU.azU();
                        }
                        if (MMPullDownView.this.ylc && MMPullDownView.this.yli.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ykW);
                            break;
                        }
                    case 1:
                        if (MMPullDownView.this.ykV != null) {
                            MMPullDownView.this.ylc = MMPullDownView.this.ykV.azR();
                        }
                        if (MMPullDownView.this.ylc && MMPullDownView.this.xNM.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ykW);
                            break;
                        }
                }
                x.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(MMPullDownView.this.ylj), Boolean.valueOf(MMPullDownView.this.ylc));
            }
        };
        this.ylu = false;
        this.ylw = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.ylx = Integer.MIN_VALUE;
        this.yly = this.bgColor;
        this.yJ = new Scroller(context, new AccelerateInterpolator());
        this.yhp = this.yiO;
        this.mbL = new GestureDetector(context, this);
        this.ylp = new k(context);
        this.context = context;
    }

    public void aAg() {
        View inflate = inflate(this.context, h.ctI, null);
        View inflate2 = inflate(this.context, h.ctI, null);
        addView(inflate, 0, new LayoutParams(-1, -2));
        addView(inflate2, new LayoutParams(-1, -2));
    }

    public final void mt(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.yle), bi.chl());
        this.yle = z;
    }

    public final void mu(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ylf), bi.chl());
        this.ylf = z;
    }

    public final void mv(boolean z) {
        this.ylk = z ? 0 : 4;
        if (this.xNM != null) {
            this.xNM.setVisibility(this.ylk);
        }
        x.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bi.chl());
    }

    public final void mw(boolean z) {
        this.yll = z ? 0 : 4;
        if (this.yli != null) {
            this.yli.setVisibility(this.yll);
        }
        x.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bi.chl());
    }

    public static void e(ViewGroup viewGroup, int i) {
        x.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            if (viewGroup.getTag() == null) {
                viewGroup.setTag(viewGroup.findViewById(com.tencent.mm.v.a.g.bUx));
            }
            View view = (View) viewGroup.getTag();
            if (view != null) {
                view.setVisibility(i);
            }
        }
    }

    private void cqh() {
        e((ViewGroup) this.yli, 0);
        e((ViewGroup) this.xNM, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!this.ylm) {
            aAg();
            this.ylm = true;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), i5 + measuredHeight);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight));
                }
                i5 += measuredHeight;
            }
        }
        this.yli = getChildAt(0);
        this.xNM = getChildAt(getChildCount() - 1);
        this.yli.setVisibility(this.yll);
        this.xNM.setVisibility(this.ylk);
        this.ykW = this.yli.getHeight();
        this.ykX = this.xNM.getHeight();
        this.ylx = this.ykW;
        if (!this.yld && this.ykW != 0) {
            this.yld = true;
            scrollTo(0, this.ykW);
        }
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        } else if (this.ylb) {
            x.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.ylb = false;
            this.ylt.sendEmptyMessageDelayed(0, (long) yls);
            cqh();
        }
        this.yJ.isFinished();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ylr != null) {
            this.ylr.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.ykW < 0) {
                    this.ykY = true;
                }
                if (getScrollY() > this.ykX) {
                    this.ykZ = true;
                }
                cqi();
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        k kVar = this.ylp;
        if (kVar.zuc != null) {
            kVar.zub.onTouchEvent(motionEvent);
        }
        if (!this.ylc) {
            return z;
        }
        if (this.ylh == null) {
            this.ykY = false;
        } else {
            this.ykY = this.ylh.azS();
        }
        if (this.ylg == null) {
            this.ykZ = false;
        } else {
            this.ykZ = this.ylg.azT();
        }
        if (this.yll == 0) {
            if (this.yle) {
                this.yli.setVisibility(4);
            } else {
                this.yli.setVisibility(0);
            }
        }
        if (this.ylk == 0) {
            if (this.ylf) {
                this.xNM.setVisibility(4);
            } else {
                this.xNM.setVisibility(0);
            }
        }
        if (motionEvent.getAction() == z) {
            cqi();
            return super.dispatchTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            cqi();
            return this.ylq ? super.dispatchTouchEvent(motionEvent) : false;
        } else if (this.mbL.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
            this.ylu = z;
            return super.dispatchTouchEvent(motionEvent);
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMPullDownView", e, "", new Object[0]);
                return z;
            }
        }
    }

    public final void mx(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ylb), Boolean.valueOf(this.ylc), Boolean.valueOf(this.yle), Integer.valueOf(getScrollY()), bi.chl());
        if (z) {
            if (this.yle) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ykW + (-getScrollY()), 200);
            } else {
                if (this.yli != null && this.yli.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykW + (-getScrollY()), 200);
                }
                if (this.yli != null && this.yli.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ylj = 0;
                this.ylb = true;
                this.ylc = false;
            }
            postInvalidate();
        } else if (!this.ylc) {
            this.ylc = true;
            this.ylb = false;
            if (this.yli != null && this.yli.getVisibility() == 0) {
                scrollTo(0, this.ykW);
            }
        }
        cqh();
    }

    public final void my(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ylb), Boolean.valueOf(this.ylc), Boolean.valueOf(this.ylf), Integer.valueOf(getScrollY()), bi.chl());
        if (z) {
            if (this.ylf) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ykX - getScrollY(), 200);
            } else {
                if (this.xNM != null && this.xNM.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykX - getScrollY(), 200);
                }
                if (this.xNM != null && this.xNM.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykX + (this.ykX - getScrollY()), 200);
                }
                this.ylj = 1;
                this.ylb = true;
                this.ylc = false;
            }
            postInvalidate();
            return;
        }
        if (!this.ylc) {
            this.ylc = true;
            this.ylb = false;
        }
        if (this.xNM != null && this.xNM.getVisibility() == 0) {
            x.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.ykW);
        }
    }

    private void cqi() {
        if (this.yln != null) {
            this.yln.bCB();
        }
        if (getScrollY() - this.ykW < 0) {
            if (this.yle) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ykW + (-getScrollY()), 200);
            } else {
                if (this.yli.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykW + (-getScrollY()), 200);
                }
                if (this.yli.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ylj = 0;
                this.ylb = true;
                this.ylc = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.ykX) {
            if (this.ylf) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ykX - getScrollY(), 200);
            } else {
                if (this.xNM.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykX - getScrollY(), 200);
                }
                if (this.xNM.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ykX + (this.ykX - getScrollY()), 200);
                }
                this.ylj = 1;
                this.ylb = true;
                this.ylc = false;
            }
            postInvalidate();
        }
        this.yla = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.yJ.isFinished()) {
            this.yJ.abortAnimation();
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f), Float.valueOf(f2));
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.yln != null) {
            this.yln.ax(f2);
        }
        if (f2 > 0.0f) {
            this.yla = true;
        } else {
            this.yla = false;
        }
        int i2;
        if (this.ykZ && (this.yla || getScrollY() - this.ykW > 0)) {
            if (!this.ylo) {
                if (this.xNM.getVisibility() != 0) {
                    return true;
                }
                if (this.yla && getScrollY() >= this.ykW * 2) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            x.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.ykW && !this.yla) {
                i = this.ykW - getScrollY();
            } else if (!this.ylo && getScrollY() + i >= this.ykW * 2) {
                i = (this.ykW * 2) - getScrollY();
            }
            scrollBy(0, i);
            return true;
        } else if (!this.ykY || (this.yla && getScrollY() - this.ykW >= 0)) {
            return false;
        } else {
            if (!this.ylo) {
                if (this.yli.getVisibility() != 0) {
                    return true;
                }
                if (!this.yla && getScrollY() <= 0) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            if (getScrollY() + i > this.ykW) {
                i = this.ykW - getScrollY();
            } else if (!this.ylo && getScrollY() + i < 0) {
                i = -getScrollY();
            }
            scrollBy(0, i);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ylz != null) {
            this.ylz.aFP();
        }
        if (this.ylw) {
            if (this.ylx == Integer.MIN_VALUE) {
                this.ylx = this.ykW;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.ylx);
            }
            if (i2 <= this.ylx && this.yly != ylv) {
                setBackgroundResource(com.tencent.mm.v.a.f.bDK);
                this.yly = ylv;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            } else if (i2 > this.ylx && this.yly != this.bgColor) {
                x.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.yly = this.bgColor;
            }
        }
    }
}
