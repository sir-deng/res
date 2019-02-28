package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;

final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase {
    private int kee = 0;
    int kef = -1;
    private boolean mInLayout = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final c any() {
        return new ag();
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int min;
            int[] alC;
            if (!j.aS(getContext())) {
                alC = c.alC();
                min = (Math.min(alC[0], alC[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.iuZ);
            } else if (this.kef > 0) {
                min = this.kef;
            } else if (this.kee > 0) {
                min = this.kee;
            } else {
                alC = c.alC();
                min = (Math.max(alC[0], alC[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.iuZ);
                this.kee = min;
            }
            ca(i, MeasureSpec.makeMeasureSpec(min, 1073741824));
            return;
        }
        ca(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
    }

    public final void setVisibility(int i) {
        mt(i);
        if (i == 0) {
            initView();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = false;
    }

    final boolean anz() {
        if (d.fN(18)) {
            return super.isInLayout();
        }
        return this.mInLayout;
    }
}
