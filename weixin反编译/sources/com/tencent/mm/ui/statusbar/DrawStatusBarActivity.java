package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.a.d;

public abstract class DrawStatusBarActivity extends MMActivity {
    private b jQc = null;

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jQc = new b(this);
            this.jQc.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.jQc);
            getSwipeBackLayout().Iv = this.jQc;
        }
    }

    public int getStatusBarColor() {
        return getResources().getColor(d.btT);
    }
}
