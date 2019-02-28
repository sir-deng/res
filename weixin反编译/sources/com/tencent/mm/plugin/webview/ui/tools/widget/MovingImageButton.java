package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;

public class MovingImageButton extends ImageView {
    private int jKh;
    private int jKi;
    private int kJB;
    private int kJC;
    private Context mContext;
    private int nsl;
    private int tQV;
    private int tQW;
    private int tQX = 0;
    private int tQY = 0;
    private MarginLayoutParams tQZ;
    private final int tRa = 100;
    private int tRb;
    private boolean tRc = false;
    public boolean tRd = true;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.tRb = a.fromDPToPix(this.mContext, 100);
        this.kJB = a.eB(this.mContext);
        this.kJC = a.eC(this.mContext);
        this.nsl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.tRd) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.tQX == 0 || this.tQY == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.tQX = rect.right - rect.left;
            this.tQY = rect.bottom - rect.top;
            x.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.tQX), Integer.valueOf(this.tQY));
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.tQV = this.x;
                this.tQW = this.y;
                break;
            case 1:
                if (Math.abs(this.tQV - this.x) + Math.abs(this.tQW - this.y) <= this.nsl) {
                    performClick();
                    break;
                }
                if (this.y < this.tRb) {
                    this.tQZ.topMargin = 0;
                } else if (this.y > this.tQY - this.tRb) {
                    this.tQZ.topMargin = this.tQY - getHeight();
                } else if (this.x > this.tQX / 2) {
                    this.tQZ.rightMargin = 0;
                } else {
                    this.tQZ.rightMargin = this.tQX - getWidth();
                }
                requestLayout();
                break;
            case 2:
                int i = this.x - this.jKh;
                int i2 = this.y - this.jKi;
                if (!(i == 0 && i2 == 0)) {
                    this.tQZ = (MarginLayoutParams) getLayoutParams();
                    MarginLayoutParams marginLayoutParams = this.tQZ;
                    marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                    marginLayoutParams = this.tQZ;
                    marginLayoutParams.topMargin += i2;
                    if (this.tQZ.rightMargin < 0) {
                        this.tQZ.rightMargin = 0;
                    } else if (this.tQZ.rightMargin > this.tQX - getWidth()) {
                        this.tQZ.rightMargin = this.tQX - getWidth();
                    }
                    if (this.tQZ.topMargin < 0) {
                        this.tQZ.topMargin = 0;
                    } else if (this.tQZ.topMargin > this.tQY - getHeight()) {
                        this.tQZ.topMargin = this.tQY - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.jKh = this.x;
        this.jKi = this.y;
        return true;
    }
}
