package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.ag;

public class MMCallBackScrollView extends ScrollView {
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            int scrollY = MMCallBackScrollView.this.getScrollY();
            if (scrollY == MMCallBackScrollView.this.psk) {
                MMCallBackScrollView.this.vo(0);
                return;
            }
            MMCallBackScrollView.this.psk = scrollY;
            MMCallBackScrollView.this.mHandler.sendMessageDelayed(MMCallBackScrollView.this.mHandler.obtainMessage(), 5);
            MMCallBackScrollView.this.vo(1);
        }
    };
    private int mState = 0;
    private int psk;
    public a psl;

    public interface a {
        void bp(int i);
    }

    private void vo(int i) {
        if (this.psl != null && this.mState != i) {
            this.mState = i;
            this.psl.bp(i);
        }
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.psk = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                vo(1);
                break;
        }
        return onTouchEvent;
    }
}
