package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI extends MMPreference implements e {
    private f inW;
    private AppPreference sdA;
    private AppPreference sdB;

    static /* synthetic */ void a(AddAppUI addAppUI, String str) {
        Intent intent = new Intent(addAppUI, AppProfileUI.class);
        intent.putExtra("AppProfileUI_AppId", str);
        addAppUI.startActivity(intent);
    }

    static /* synthetic */ void f(com.tencent.mm.pluginsdk.model.app.f fVar) {
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        an.biT().a(fVar, new String[0]);
    }

    public final int XK() {
        return R.o.fbv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.sdA != null) {
            this.sdA.onResume();
        }
        if (this.sdB != null) {
            this.sdB.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.sdA != null) {
            this.sdA.onPause();
        }
        if (this.sdB != null) {
            this.sdB.onPause();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dCN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AddAppUI.this.finish();
                return true;
            }
        });
        this.inW = this.yrJ;
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbv);
        this.sdA = (AppPreference) this.inW.Zu("addapp_added");
        this.sdA.sdE = 1;
        this.sdA.sdH = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(AddAppUI.this, AddAppUI.this.sdA.yy(i).field_appId);
            }
        };
        this.sdA.sdI = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.f(AddAppUI.this.sdA.yy(i));
                AddAppUI.this.initView();
            }
        };
        this.sdB = (AppPreference) this.inW.Zu("addapp_available");
        this.sdB.sdE = 0;
        this.sdB.sdH = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(AddAppUI.this, AddAppUI.this.sdB.yy(i).field_appId);
            }
        };
    }

    public final boolean a(f fVar, Preference preference) {
        if (!preference.idX.equals("addapp_recommend")) {
            return false;
        }
        SharedPreferences sharedPreferences = this.mController.xRr.getSharedPreferences(ad.cgf(), 0);
        ActionBarActivity actionBarActivity = this.mController.xRr;
        String d = w.d(sharedPreferences);
        String string = getString(R.l.dCO, new Object[]{Integer.valueOf(d.vHl), d, w.cfU()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
