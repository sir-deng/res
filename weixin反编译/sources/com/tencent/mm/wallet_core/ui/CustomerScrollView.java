package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView extends ScrollView {
    private float zRJ;
    private float zRK;
    private float zRL;
    private float zRM;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.zRK = 0.0f;
                this.zRJ = 0.0f;
                this.zRL = motionEvent.getX();
                this.zRM = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.zRJ += Math.abs(x - this.zRL);
                this.zRK += Math.abs(y - this.zRM);
                this.zRL = x;
                this.zRM = y;
                if (this.zRJ > this.zRK) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
