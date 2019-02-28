package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MMLoadScrollView extends ScrollView {
    public a zCX;

    public interface a {
        void aEc();
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (z2 && i2 > 0 && this.zCX != null) {
            this.zCX.aEc();
        }
        super.onOverScrolled(i, i2, z, z2);
    }
}
