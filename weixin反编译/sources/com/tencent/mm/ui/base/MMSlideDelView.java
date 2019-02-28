package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView extends ViewGroup {
    private VelocityTracker ft;
    private final int iN;
    public f kHo;
    public c kHp;
    public d kHr;
    private boolean kNs = false;
    public boolean mGx = true;
    private ag mHandler = new ag();
    private int oda;
    long time;
    private final Scroller yJ;
    private boolean ylR = false;
    private b ylS;
    private Runnable ylT;
    private long ylU;
    private boolean ylV = false;
    private a ylW = null;
    private float za;
    private float zb;

    private class a extends g implements Runnable {
        private a() {
            super(MMSlideDelView.this, (byte) 0);
        }

        /* synthetic */ a(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }

        public final void run() {
            Object obj = (this.ylX.hasWindowFocus() && this.ylX.getWindowAttachCount() == this.ylY) ? 1 : null;
            if (obj != null && !MMSlideDelView.this.kNs) {
                x.i("MicroMsg.MMSlideDelView", "is long press");
                if (MMSlideDelView.this.getParent() != null) {
                    MMSlideDelView.this.ylV = true;
                    MMSlideDelView.this.performLongClick();
                }
            }
        }
    }

    public interface c {
        int ci(View view);
    }

    public interface e {
        void bp(Object obj);
    }

    public interface f {
        void t(View view, int i);
    }

    private class g {
        int ylY;

        private g() {
        }

        /* synthetic */ g(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            x.v("MicroMsg.MMSlideDelView", "checkfortap");
            MMSlideDelView.this.setPressed(true);
        }
    }

    public interface d {
        public static final Set<MMSlideDelView> nQt = new HashSet();

        void a(MMSlideDelView mMSlideDelView, boolean z);

        boolean aVe();

        void aVf();

        void aVg();
    }

    public static d cql() {
        return new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    nQt.add(mMSlideDelView);
                } else {
                    nQt.remove(mMSlideDelView);
                }
            }

            public final boolean aVe() {
                return nQt.size() > 0;
            }

            public final void aVf() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqp();
                    }
                }
                nQt.clear();
            }

            public final void aVg() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqo();
                    }
                }
                nQt.clear();
            }
        };
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yJ = new Scroller(context, new LinearInterpolator());
        this.iN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ylU = (long) ViewConfiguration.getLongPressTimeout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() >= 2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                    i5 += measuredWidth;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() >= 2) {
            int size = MeasureSpec.getSize(i);
            try {
                getChildAt(0).measure(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int max = Math.max(0, getChildAt(0).getMeasuredHeight());
            LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            View childAt = getChildAt(1);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                try {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(max, 1073741824));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
                max = Math.max(max, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        }
    }

    public final void setView(View view) {
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mGx) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.kHr.aVe() && !this.ylR) {
            x.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.ylV = false;
            this.kHr.aVf();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        if (this.ylV) {
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).aWY();
                }
                this.kNs = false;
                if (!this.yJ.isFinished()) {
                    this.yJ.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.kHp != null) {
                    this.oda = this.kHp.ci(this);
                }
                if (this.ylS == null) {
                    this.ylS = new b();
                }
                this.mHandler.postDelayed(this.ylS, (long) ViewConfiguration.getTapTimeout());
                this.za = x;
                this.zb = y;
                if (this.ylW == null) {
                    this.ylW = new a();
                }
                g gVar = this.ylW;
                gVar.ylY = gVar.ylX.getWindowAttachCount();
                this.mHandler.postDelayed(this.ylW, this.ylU);
                return true;
            case 1:
                cqm();
                if (this.kNs || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.kHo == null || this.ylR)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.ylT != null) {
                        removeCallbacks(this.ylT);
                    }
                    this.ylT = new Runnable() {
                        public final void run() {
                            MMSlideDelView.this.setPressed(false);
                            x.v("MicroMsg.MMSlideDelView", "onClick");
                            MMSlideDelView.this.kHo.t(MMSlideDelView.this, MMSlideDelView.this.oda);
                            MMSlideDelView.this.cqo();
                        }
                    };
                    this.mHandler.postDelayed(this.ylT, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.kNs) {
                    cqn();
                }
                hg();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ylW);
                return true;
            case 2:
                int i = (int) (this.za - x);
                action = (int) (this.zb - y);
                int scrollX = getScrollX();
                if (!this.kNs) {
                    boolean z;
                    if (i >= 0 && Math.abs(i) >= this.iN / 3) {
                        if (action == 0) {
                            action = 1;
                        }
                        if (Math.abs(i / action) > 3) {
                            z = true;
                            if (z || this.ylR) {
                                this.kNs = true;
                                eC(true);
                            }
                        }
                    }
                    z = false;
                    this.kNs = true;
                    eC(true);
                }
                if (this.kNs) {
                    View childAt = getChildAt(1);
                    if (!(childAt == null || childAt.isShown())) {
                        childAt.setVisibility(0);
                    }
                    cqm();
                    setPressed(false);
                    eC(true);
                    if (scrollX + i < 0) {
                        action = -scrollX;
                    } else if (scrollX + i > getChildAt(1).getWidth()) {
                        action = getChildAt(1).getWidth() - scrollX;
                    } else {
                        action = i;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.ylW);
                    }
                    scrollBy(action, 0);
                }
                this.za = x;
                this.zb = y;
                return true;
            case 3:
                cqm();
                setPressed(false);
                if (this.kNs) {
                    cqn();
                }
                hg();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ylW);
                return true;
            default:
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ylW);
                return true;
        }
    }

    private void hg() {
        if (this.ft != null) {
            this.ft.clear();
            this.ft = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        x.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.ylV = false;
        super.onWindowFocusChanged(z);
    }

    private void cqm() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ylS);
        }
    }

    private void cqn() {
        setPressed(false);
        if (this.ylR) {
            cqp();
            return;
        }
        MMSlideDelView mMSlideDelView;
        VelocityTracker velocityTracker = this.ft;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int scrollX;
        int width;
        if (xVelocity < -600) {
            scrollX = getScrollX();
            width = getChildAt(1).getWidth() - scrollX;
            this.kHr.a(this, true);
            this.ylR = true;
            this.yJ.startScroll(scrollX, 0, width, 0, 100);
            mMSlideDelView = this;
        } else if (xVelocity > 600) {
            cqp();
            if (this.ft != null) {
                this.ft.recycle();
                this.ft = null;
            }
            this.kNs = false;
            eC(false);
        } else {
            scrollX = getScrollX();
            xVelocity = getChildAt(1).getWidth();
            width = xVelocity - scrollX;
            if (scrollX > xVelocity / 2) {
                this.kHr.a(this, true);
                this.ylR = true;
                this.yJ.startScroll(scrollX, 0, width, 0, 100);
                mMSlideDelView = this;
            } else {
                this.ylR = false;
                this.kHr.a(this, false);
                this.yJ.startScroll(scrollX, 0, -scrollX, 0, 100);
                mMSlideDelView = this;
            }
        }
        mMSlideDelView.invalidate();
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
        this.kNs = false;
        eC(false);
    }

    private void eC(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void cqo() {
        this.kHr.a(this, false);
        this.ylR = false;
        scrollTo(0, 0);
        invalidate();
    }

    public final void cqp() {
        int scrollX = getScrollX();
        this.kHr.a(this, false);
        this.ylR = false;
        this.yJ.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        }
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
