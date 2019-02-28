package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.R;

public class MaxHeightScrollView extends ScrollView {
    private int vxz;

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.faZ, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.n.fba) {
                    this.vxz = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                }
                i++;
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.vxz > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.vxz, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
