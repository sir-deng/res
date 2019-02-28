package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class BizChatSearchListView extends ListView {
    a yww;

    public interface a {
        boolean atb();
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.yww != null) {
            this.yww.atb();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
