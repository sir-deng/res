package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.b;

public abstract class CustomStatusBarMMActivity extends MMActivity {
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
        a.d(this.mController.contentView, getStatusBarColor(), true);
    }

    public boolean initNavigationSwipeBack() {
        boolean initNavigationSwipeBack = super.initNavigationSwipeBack();
        if (!isSupportNavigationSwipeBack()) {
            a.d(this.mController.contentView, getStatusBarColor(), true);
        }
        return initNavigationSwipeBack;
    }

    protected int getStatusBarColor() {
        return getResources().getColor(R.e.btT);
    }
}
