package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

public class MailMMWebView extends MMWebViewWithJsApi {
    private float iTW;
    private float iTX;
    boolean pzn;
    View pzo;
    View pzp;
    private boolean pzq;
    private boolean pzr;

    private class a extends FrameLayout {
        public a(Context context) {
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!MailMMWebView.this.pzq && !MailMMWebView.this.pzr) {
                return false;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    MailMMWebView.this.pzq = false;
                    MailMMWebView.this.pzr = false;
                    break;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }

        protected final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this == MailMMWebView.this.pzo && MailMMWebView.this.getTitleHeight() > 0) {
                MailMMWebView.this.blK();
            } else if (this == MailMMWebView.this.pzp && MailMMWebView.this.blJ() > 0) {
                MailMMWebView.this.blL();
            }
        }
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.pzn = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.iTW = x;
                this.iTX = y;
                if (this.pzo == null || ((int) this.iTX) >= blI()) {
                    if (this.pzp != null && this.pzp.getVisibility() == 0 && this.iTX + ((float) blJ()) > ((float) getHeight())) {
                        this.pzr = true;
                        break;
                    }
                }
                this.pzq = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.iTX) > 50.0f && this.pzq) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.iTW, this.iTX + ((float) webScrollY));
                    this.pzo.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.iTW, this.iTX);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.pzq && this.pzo != null) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            return this.pzo.dispatchTouchEvent(motionEvent);
        } else if (!this.pzr || this.pzp == null) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setLocation(x, (y + ((float) blJ())) - ((float) getHeight()));
            return this.pzp.dispatchTouchEvent(motionEvent);
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onWebViewScrollChanged(i, i2, i3, i4);
        invalidate();
        if (contentHeight - height < blJ()) {
            if (Math.abs(contentHeight - height) > 20) {
                blL();
                hv(false);
            } else {
                hv(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            blK();
        }
    }

    public int computeVerticalScrollExtent() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        return height - blI();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(getWebScrollY() - getTitleHeight(), 0);
    }

    private int blI() {
        return Math.max(getTitleHeight() - getWebScrollY(), 0);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.pzo) {
            return super.drawChild(canvas, view, j);
        }
        int webScrollY = getWebScrollY();
        canvas.save();
        canvas.translate(0.0f, (float) (-webScrollY));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public final int getTitleHeight() {
        if (this.pzo != null) {
            return this.pzo.getHeight();
        }
        return 0;
    }

    public final int blJ() {
        if (this.pzp != null) {
            return this.pzp.getHeight();
        }
        return 0;
    }

    public final void blK() {
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
    }

    public final void blL() {
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) blJ()) / getScale())) + ");", null);
    }

    public final void hv(boolean z) {
        if (this.pzp == null) {
            return;
        }
        if (z) {
            this.pzp.setVisibility(0);
        } else {
            this.pzp.setVisibility(4);
        }
    }
}
