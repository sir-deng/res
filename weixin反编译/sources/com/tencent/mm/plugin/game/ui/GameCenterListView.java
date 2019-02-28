package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.mm.R;

public class GameCenterListView extends ListView {
    static boolean nsn;
    static int nsp;
    private View Lr;
    private Context mContext;
    private boolean nsj;
    private float nsk;
    private int nsl;
    private boolean nsm;
    private boolean nso;
    private ImageView nsq;
    private ImageView nsr;
    private Scroller yJ;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nsl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.yJ = new Scroller(this.mContext);
        super.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && GameCenterListView.this.Lr != null && GameCenterListView.this.Lr.getTop() == 0) {
                    GameCenterListView.this.nsm = true;
                } else {
                    GameCenterListView.this.nsm = false;
                }
            }
        });
    }

    public static void fK(boolean z) {
        nsn = z;
    }

    public static void rk(int i) {
        nsp = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.nsj) {
            this.Lr = getChildAt(0);
            this.nsr = (ImageView) this.Lr.findViewById(R.h.cOT);
            this.nsq = (ImageView) this.Lr.findViewById(R.h.bMY);
            this.nsj = true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!nsn || this.Lr == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nso = false;
                this.nsk = motionEvent.getRawY();
                break;
            case 2:
                if (this.nsm) {
                    if (this.nso) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nsk);
                    if (this.Lr.getPaddingTop() <= nsp + this.nsl) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nsl) {
                            this.nso = true;
                            this.yJ.startScroll(0, this.Lr.getPaddingTop(), 0, -this.Lr.getPaddingTop(), 500);
                            this.nsq.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Lr.getPaddingTop() >= (-this.nsl) && rawY < 0 && Math.abs(rawY) >= this.nsl) {
                        this.nso = true;
                        this.yJ.startScroll(0, 0, 0, nsp, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Lr != null && this.yJ.computeScrollOffset()) {
            int currY = this.yJ.getCurrY();
            this.Lr.setPadding(0, currY, 0, 0);
            float f = (((float) (nsp - currY)) / ((float) nsp)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nsr.setAlpha(i);
            this.nsq.setAlpha(currY);
            invalidate();
        }
    }
}
