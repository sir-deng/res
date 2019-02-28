package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import b.c.b.e;

public final class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    a pEi;
    public RadarSpecialTableLayout pEj;
    private int pEk;
    private int pEl;

    public interface a {
        void g(int i, View view);
    }

    public final RadarSpecialTableLayout bms() {
        RadarSpecialTableLayout radarSpecialTableLayout = this.pEj;
        if (radarSpecialTableLayout == null) {
            e.adf("mTable");
        }
        return radarSpecialTableLayout;
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
        Object context2 = getContext();
        e.h(context2, "context");
        this.pEj = new RadarSpecialTableLayout(context2);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        RadarSpecialTableLayout radarSpecialTableLayout = this.pEj;
        if (radarSpecialTableLayout == null) {
            e.adf("mTable");
        }
        radarSpecialTableLayout.setLayoutParams(layoutParams);
        RadarSpecialTableLayout radarSpecialTableLayout2 = this.pEj;
        if (radarSpecialTableLayout2 == null) {
            e.adf("mTable");
        }
        radarSpecialTableLayout2.setStretchAllColumns(true);
        radarSpecialTableLayout2 = this.pEj;
        if (radarSpecialTableLayout2 == null) {
            e.adf("mTable");
        }
        radarSpecialTableLayout2.setShrinkAllColumns(true);
        radarSpecialTableLayout2 = this.pEj;
        if (radarSpecialTableLayout2 == null) {
            e.adf("mTable");
        }
        radarSpecialTableLayout2.setGravity(80);
        radarSpecialTableLayout2 = this.pEj;
        if (radarSpecialTableLayout2 == null) {
            e.adf("mTable");
        }
        addView(radarSpecialTableLayout2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int scrollX;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            Object childAt = getChildAt(0);
            scrollX = getScrollX();
            e.h(childAt, "child");
            scrollX = (scrollX + childAt.getWidth()) - this.pEl;
            this.pEl = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            Object childAt2 = getChildAt(0);
            int scrollY = getScrollY();
            e.h(childAt2, "child");
            scrollY = (scrollY + childAt2.getHeight()) - this.pEk;
            this.pEk = childAt2.getHeight();
            if (scrollY > 0) {
                i5 = scrollY;
            }
        } else {
            i5 = getScrollY();
        }
        scrollTo(scrollX, i5);
    }
}
