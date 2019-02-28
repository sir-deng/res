package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private ag handler = null;
    private f inW;
    private com.tencent.mm.pluginsdk.model.app.f nrn;
    private AppHeaderPreference.a sdO;

    public final int XK() {
        return R.o.fbw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        super.onResume();
        an.biT().c(this);
    }

    protected void onPause() {
        an.biT().j(this);
        super.onPause();
    }

    protected final void initView() {
        boolean z = true;
        this.sdO = new AppHeaderPreference.a() {
            public final String bEO() {
                return g.a(AppProfileUI.this.mController.xRr, AppProfileUI.this.nrn, null);
            }

            public final Bitmap bEP() {
                return g.b(AppProfileUI.this.nrn.field_appId, 1, com.tencent.mm.bu.a.getDensity(AppProfileUI.this));
            }

            public final String iX(boolean z) {
                return AppProfileUI.this.mController.xRr.getString(z ? R.l.eMM : R.l.eMT);
            }

            public final String getHint() {
                Context context = AppProfileUI.this.mController.xRr;
                com.tencent.mm.pluginsdk.model.app.f a = AppProfileUI.this.nrn;
                if (context == null || a == null) {
                    return null;
                }
                String ej = g.ej(context);
                if (ej.equalsIgnoreCase("zh_CN")) {
                    return a.field_appDiscription;
                }
                return (ej.equalsIgnoreCase("zh_TW") || ej.equalsIgnoreCase("zh_HK")) ? bi.oN(a.field_appDiscription_tw) ? a.field_appDiscription : a.field_appDiscription_tw : ej.equalsIgnoreCase("en") ? bi.oN(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en : bi.oN(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en;
            }
        };
        this.nrn = g.aZ(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.nrn == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        setMMTitle(R.l.dGA);
        this.inW = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppProfileUI.this.finish();
                return true;
            }
        });
        refresh();
    }

    private void refresh() {
        boolean z;
        boolean z2 = true;
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbw);
        if (this.nrn.field_status == 1) {
            this.inW.Zv("app_profile_add");
        } else {
            this.inW.Zv("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.inW.Zu("app_profile_header");
        AppHeaderPreference.a aVar = this.sdO;
        if (this.nrn.field_status == 1) {
            z = true;
        } else {
            z = false;
        }
        if (aVar == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        appHeaderPreference.sdF = aVar;
        appHeaderPreference.fKG = z;
    }

    private void bEQ() {
        this.handler = new ag() {
            public final void handleMessage(Message message) {
                AppProfileUI.this.finish();
            }
        };
        this.handler.sendEmptyMessageDelayed(0, 30);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        x.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.nrn.field_status = 1;
            this.nrn.field_modifyTime = System.currentTimeMillis();
            an.biT().a(this.nrn, new String[0]);
            refresh();
            a(this.nrn, true);
            bEQ();
            return true;
        } else if (!str.equals("app_profile_remove")) {
            return false;
        } else {
            this.nrn.field_status = 0;
            this.nrn.field_modifyTime = System.currentTimeMillis();
            an.biT().a(this.nrn, new String[0]);
            refresh();
            a(this.nrn, false);
            bEQ();
            return true;
        }
    }

    public final void a(String str, l lVar) {
        if (str.equals(this.nrn.field_appId)) {
            initView();
        }
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        List linkedList = new LinkedList();
        linkedList.add(new i.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        as.Hm();
        c.Fe().b(new i(linkedList));
    }
}
