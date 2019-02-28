package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.a.h.b;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.smtt.sdk.WebView;

public final class AppBrandNearbyEmptyUI extends DrawStatusBarActivity {
    protected final int getLayoutId() {
        return h.izw;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        a.d(this.mController.contentView, getStatusBarColor(), true);
        this.mController.contentView.setBackgroundColor(-1052684);
        if (!(getSupportActionBar() == null || getSupportActionBar().getCustomView() == null)) {
            getSupportActionBar().getCustomView().setBackgroundColor(-1052684);
        }
        setMMTitle(j.dEj);
        oj(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandNearbyEmptyUI.this.onBackPressed();
                return true;
            }
        }, f.ivE);
        k.a(this);
        TextView textView = (TextView) findViewById(g.ixY);
        TextView textView2 = (TextView) findViewById(g.ixW);
        com.tencent.mm.plugin.appbrand.report.a.h hVar;
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                hVar = new com.tencent.mm.plugin.appbrand.report.a.h();
                hVar.jNW = b.TOP_ENTRANCE_IN_DESKTOP;
                hVar.jOa = com.tencent.mm.plugin.appbrand.report.a.h.a.EMPTY_PAGE;
                hVar.xd();
                break;
            case 1:
                textView.setText(j.iCD);
                textView2.setText(j.iCC);
                hVar = new com.tencent.mm.plugin.appbrand.report.a.h();
                hVar.jNW = b.TOP_ENTRANCE_IN_DESKTOP;
                hVar.jOa = com.tencent.mm.plugin.appbrand.report.a.h.a.LBS_NOT_ALLOW;
                hVar.xd();
                break;
            default:
                finish();
                return;
        }
        setResult(-1);
    }

    public final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jQu;
        }
        return super.getStatusBarColor();
    }
}
