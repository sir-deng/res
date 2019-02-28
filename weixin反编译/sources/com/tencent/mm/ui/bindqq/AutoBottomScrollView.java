package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class AutoBottomScrollView extends ScrollView {
    public AutoBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBottomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        postDelayed(new Runnable() {
            public final void run() {
                AutoBottomScrollView.this.smoothScrollTo(0, AutoBottomScrollView.this.getBottom());
            }
        }, 100);
    }
}
