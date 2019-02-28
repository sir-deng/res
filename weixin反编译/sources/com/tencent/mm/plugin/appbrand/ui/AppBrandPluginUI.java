package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class AppBrandPluginUI extends AppBrandUI {
    private boolean jQU = false;

    protected void initActivityOpenAnimation(Intent intent) {
        super.overridePendingTransition(MMFragmentActivity.a.xSL, MMFragmentActivity.a.xSM);
    }

    protected void initActivityCloseAnimation() {
        if (!this.jQU) {
            super.overridePendingTransition(MMFragmentActivity.a.xSN, MMFragmentActivity.a.xSO);
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
        this.jQU = true;
    }

    public final boolean alr() {
        return true;
    }
}
