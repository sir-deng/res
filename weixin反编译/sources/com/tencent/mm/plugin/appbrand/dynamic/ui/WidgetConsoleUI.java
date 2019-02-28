package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.h.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI extends MMActivity implements a {
    String appId;
    int fwH;
    int iJb;
    ConsolePanel iYl;
    String id;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetConsoleUI.this.finish();
                return false;
            }
        });
        setMMTitle(e.kmV);
        this.iYl = (ConsolePanel) findViewById(b.kml);
        if (!adC()) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!adC()) {
            finish();
        }
    }

    private boolean adC() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fwH = intent.getIntExtra("pkg_type", 0);
        this.iJb = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{stringExtra}));
        if (bi.oN(stringExtra)) {
            return false;
        }
        if (stringExtra.equals(this.id)) {
            return true;
        }
        ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jd().b(this.id, (a) this);
        ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jd().a(stringExtra, this);
        this.id = stringExtra;
        d.a(this.iYl);
        return true;
    }

    public final void hj(int i) {
        String str;
        switch (i) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        com.tencent.mm.by.a.Z(new Runnable() {
            public final void run() {
                WidgetConsoleUI.this.setMMTitle(String.format("%s%s", new Object[]{WidgetConsoleUI.this.getString(e.kmV), str}));
                Toast.makeText(WidgetConsoleUI.this.mController.xRr, String.format("%s%s", new Object[]{WidgetConsoleUI.this.id, str}), 1).show();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jd().b(this.id, (a) this);
        d.b(this.iYl);
    }

    public void finish() {
        if (!isFinishing() && !this.xQV) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return c.kmR;
    }
}
