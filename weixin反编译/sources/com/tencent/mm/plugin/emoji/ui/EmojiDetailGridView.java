package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    String lEs;
    EmojiDetailScrollView lHY;
    private volatile boolean lHZ = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected final void eA(boolean z) {
        if (this.lHY != null) {
            this.lHY.lIa = z;
        }
    }

    protected final int aDA() {
        return 200;
    }
}
