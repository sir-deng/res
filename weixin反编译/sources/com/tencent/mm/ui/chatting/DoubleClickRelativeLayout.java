package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.widget.MMTextView.b;

public class DoubleClickRelativeLayout extends RelativeLayout {
    public b yFI = null;
    private GestureDetector yFJ = null;

    public DoubleClickRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DoubleClickRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.yFJ = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (DoubleClickRelativeLayout.this.yFI == null) {
                    return false;
                }
                return DoubleClickRelativeLayout.this.yFI.do(DoubleClickRelativeLayout.this);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!(this.yFI == null || this.yFJ == null)) {
            z = this.yFJ.onTouchEvent(motionEvent);
        }
        if (z) {
            return z;
        }
        return super.onTouchEvent(motionEvent);
    }
}
