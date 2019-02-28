package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int fwH;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WxaWidgetSettingsUI.this.finish();
                return false;
            }
        });
        setMMTitle(e.kna);
        this.appId = getIntent().getStringExtra("app_id");
        this.fwH = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.kmE);
        DebuggerInfo rN = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rN(this.appId);
        boolean z2 = rN != null && rN.iWh;
        mMSwitchBtn.nJ(z2);
        mMSwitchBtn.zEt = new a() {
            public final void cy(boolean z) {
                DebuggerInfo rN = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rN(WxaWidgetSettingsUI.this.appId);
                if (rN == null) {
                    rN = new DebuggerInfo();
                    com.tencent.mm.plugin.appbrand.dynamic.debugger.b.a(WxaWidgetSettingsUI.this.appId, rN);
                }
                rN.iWh = z;
            }
        };
        mMSwitchBtn = (MMSwitchBtn) findViewById(b.kms);
        if ((rN != null && rN.iWf) || d.a.hi(this.fwH)) {
            z = true;
        }
        mMSwitchBtn.nJ(z);
        mMSwitchBtn.setEnabled(d.a.jy(this.fwH));
        mMSwitchBtn.zEt = new a() {
            public final void cy(boolean z) {
                DebuggerInfo rN = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rN(WxaWidgetSettingsUI.this.appId);
                if (rN == null) {
                    rN = new DebuggerInfo();
                    com.tencent.mm.plugin.appbrand.dynamic.debugger.b.a(WxaWidgetSettingsUI.this.appId, rN);
                }
                rN.iWf = z;
            }
        };
    }

    protected final int getLayoutId() {
        return c.kmU;
    }
}
