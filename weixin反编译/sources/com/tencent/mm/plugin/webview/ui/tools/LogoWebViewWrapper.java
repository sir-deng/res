package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    private int iN;
    WebView lhb;
    private int meV;
    FrameLayout tCA;
    private boolean tCB = false;
    private int tCC;
    private int tCD;
    private c tCE;
    private int tCF = 0;
    boolean tCG = false;
    boolean tCH = false;
    int tCI = 0;
    a tCJ;
    b tCK;
    private boolean tCL = false;
    private boolean tCM = false;
    private boolean tCN = false;
    private int tCO = -1;

    public interface a {
        void bSU();
    }

    final class c implements Runnable {
        private final long duration;
        private long startTime = -1;
        private final Interpolator tCQ;
        private final int tCR;
        private final int tCS;
        boolean tCT = true;
        private int tCU = -1;

        public c(int i, int i2, long j) {
            this.tCS = i;
            this.tCR = i2;
            this.tCQ = LogoWebViewWrapper.this.tCH ? new AccelerateInterpolator() : new DecelerateInterpolator();
            this.duration = j;
        }

        public final void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                long j = 500;
                if (this.duration > 0) {
                    j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000), 0);
                }
                this.tCU = this.tCS - Math.round(this.tCQ.getInterpolation(((float) j) / 1000.0f) * ((float) (this.tCS - this.tCR)));
                LogoWebViewWrapper.this.AS(this.tCU);
                if (LogoWebViewWrapper.this.tCK != null) {
                    LogoWebViewWrapper.this.tCK.T(this.tCU, false);
                }
            }
            if (this.tCT && this.tCR != this.tCU) {
                z.a(LogoWebViewWrapper.this, (Runnable) this);
            }
        }
    }

    public interface b {
        void T(int i, boolean z);
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(1);
        this.iN = ViewConfiguration.get(this.context).getScaledTouchSlop();
    }

    public final FrameLayout bST() {
        if (this.tCA == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == R.h.cuD) {
                    this.tCA = (FrameLayout) childAt;
                    break;
                }
            }
        }
        return this.tCA;
    }

    public final void ky(boolean z) {
        this.tCG = z;
        if (this.tCG) {
            this.tCB = false;
            this.tCF = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.tCG && !this.tCL) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.tCB = false;
            this.tCF = 0;
            this.tCM = false;
            return false;
        } else if (action == 2 && this.tCB) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (this.lhb.isOverScrollStart()) {
                        this.tCC = (int) motionEvent.getY();
                        this.meV = (int) motionEvent.getY();
                        this.tCD = (int) motionEvent.getX();
                        this.tCB = false;
                        this.tCF = 0;
                        this.tCL = true;
                        this.tCM = true;
                        break;
                    }
                    break;
                case 2:
                    if (this.lhb.isOverScrollStart()) {
                        if (this.tCM) {
                            action = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            int i = action - this.tCC;
                            int i2 = x - this.tCD;
                            if (Math.abs(i) > this.iN && Math.abs(i) > Math.abs(i2) && i > 0) {
                                this.tCC = action;
                                this.tCD = x;
                                if (this.tCF != 1) {
                                    this.tCF++;
                                    break;
                                }
                                this.tCB = true;
                                this.tCM = false;
                                x.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                                if (this.tCJ != null) {
                                    this.tCJ.bSU();
                                    break;
                                }
                            }
                        }
                        this.tCC = (int) motionEvent.getY();
                        this.meV = (int) motionEvent.getY();
                        this.tCD = (int) motionEvent.getX();
                        this.tCB = false;
                        this.tCF = 0;
                        this.tCL = true;
                        this.tCM = true;
                        return this.tCB;
                    }
                    break;
            }
            return this.tCB;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tCG && !this.tCL) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.tCL = true;
                if (!this.lhb.isOverScrollStart()) {
                    return false;
                }
                this.tCC = (int) motionEvent.getY();
                this.meV = (int) motionEvent.getY();
                this.tCD = (int) motionEvent.getX();
                this.tCN = true;
                return true;
            case 1:
            case 3:
                this.tCN = false;
                if (!this.tCB && !this.tCL) {
                    return false;
                }
                this.tCB = false;
                i = -this.tCI;
                long abs = (long) Math.abs(getScrollY());
                long abs2 = Math.abs(abs - ((long) Math.abs(this.tCI)));
                if (abs2 >= abs) {
                    abs = 300;
                } else {
                    abs = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
                }
                O(i, abs);
                post(new Runnable() {
                    public final void run() {
                        LogoWebViewWrapper.this.tCL = false;
                    }
                });
                return true;
            case 2:
                if (!this.tCB) {
                    return false;
                }
                if (this.tCN) {
                    this.tCC = (int) motionEvent.getY();
                    this.tCD = (int) motionEvent.getX();
                    int min = Math.min(this.meV - this.tCC, 0) >> 1;
                    int height = getHeight();
                    if (this.tCO < 0) {
                        this.tCO = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
                    }
                    i = ((int) Math.sqrt((double) ((this.tCO >> 1) * Math.abs(min)))) << 1;
                    if (i <= Math.abs(min)) {
                        min = -i;
                    } else if (Math.abs(min) > height) {
                        min = -height;
                    }
                    AS(min);
                    if (this.tCK != null) {
                        this.tCK.T(min, true);
                    }
                    return true;
                }
                this.tCC = (int) motionEvent.getY();
                this.meV = (int) motionEvent.getY();
                this.tCD = (int) motionEvent.getX();
                this.tCN = true;
                return true;
            default:
                return false;
        }
    }

    public final void AS(int i) {
        int height = getHeight();
        scrollTo(0, Math.min(height, Math.max(-height, i)));
    }

    public final void O(int i, long j) {
        if (this.tCE != null) {
            Runnable runnable = this.tCE;
            runnable.tCT = false;
            runnable.tCP.removeCallbacks(runnable);
        }
        int scrollY = getScrollY();
        x.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", Integer.valueOf(scrollY), Integer.valueOf(i));
        if (scrollY != i) {
            this.tCE = new c(scrollY, i, j);
            post(this.tCE);
        }
    }
}
