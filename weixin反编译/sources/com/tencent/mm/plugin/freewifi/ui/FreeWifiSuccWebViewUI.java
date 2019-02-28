package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;

public class FreeWifiSuccWebViewUI extends WebViewUI implements e {
    private int fDM;
    private String fGh;
    private String fwG;
    private String mKP;
    private int mOc;
    private String mOd;
    private boolean mOp = false;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        String str = j.userName;
        if (bi.oN(freeWifiSuccWebViewUI.fwG) || !freeWifiSuccWebViewUI.fwG.equals(str)) {
            freeWifiSuccWebViewUI.mOp = false;
        } else {
            freeWifiSuccWebViewUI.mOp = true;
        }
        if (!(!freeWifiSuccWebViewUI.mOp || bi.oN(freeWifiSuccWebViewUI.fGh) || (s.gI(freeWifiSuccWebViewUI.fwG) && s.gH(freeWifiSuccWebViewUI.fwG)))) {
            as.CN().a(1703, (e) freeWifiSuccWebViewUI);
            as.CN().a(new i(freeWifiSuccWebViewUI.fGh, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), m.D(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.c(d.aMm(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.mOp);
        WifiInfo aMl = d.aMl();
        a aLL = k.aLL();
        if (aMl != null) {
            str = aMl.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aLQ();
            }
            aLL.ssid = m.Bg(aMl.getSSID());
            aLL.bssid = aMl.getBSSID();
            aLL.fqv = str;
        }
        aLL.fqu = m.H(freeWifiSuccWebViewUI.getIntent());
        aLL.mIh = freeWifiSuccWebViewUI.fGh;
        aLL.mIi = m.D(freeWifiSuccWebViewUI.getIntent());
        aLL.mIj = m.F(freeWifiSuccWebViewUI.getIntent());
        aLL.mIk = b.QinghuaiBackpageFinished.mIW;
        aLL.mIl = b.QinghuaiBackpageFinished.name;
        aLL.fDM = m.G(freeWifiSuccWebViewUI.getIntent());
        aLL.mIm = freeWifiSuccWebViewUI.fwG;
        aLL.aLN().aLM();
        String stringExtra = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.mOc == 1 && !bi.oN(stringExtra)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(stringExtra).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccWebViewUI.getSharedPreferences(ad.cgf(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bl.d.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        } else if (freeWifiSuccWebViewUI.mOc == 3 && !bi.oN(stringExtra)) {
            ((com.tencent.mm.plugin.appbrand.n.e) g.h(com.tencent.mm.plugin.appbrand.n.e.class)).b(freeWifiSuccWebViewUI, stringExtra, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", stringExtra);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        j.userName = "";
        j.type = 0;
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", getIntent().getStringExtra("free_wifi_qinghuai_url"));
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.fGh = getIntent().getStringExtra("free_wifi_appid");
        this.mKP = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fwG = getIntent().getStringExtra("free_wifi_app_username");
        this.mOc = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mOd = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.fDM = m.G(getIntent());
        if (this.fDM == 10) {
            str = q.gHK.gIg;
            String aI = q.aI(this.mController.xRr);
            if (!(m.Bf(str) || m.Bf(aI))) {
                this.mOd = Uri.parse(this.mOd).buildUpon().appendQueryParameter("manufacturer", aI).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.fGh, this.mKP, this.fwG, Integer.valueOf(this.mOc), this.mOd, this.signature);
        WifiInfo aMl = d.aMl();
        a aLL = k.aLL();
        if (aMl != null) {
            str = aMl.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aLQ();
            }
            aLL.ssid = m.Bg(aMl.getSSID());
            aLL.bssid = aMl.getBSSID();
            aLL.fqv = str;
        }
        aLL.fqu = getIntent().getStringExtra("free_wifi_ap_key");
        aLL.mIh = this.fGh;
        aLL.mIi = m.D(getIntent());
        aLL.mIj = m.F(getIntent());
        aLL.mIk = b.GetBackPage.mIW;
        aLL.mIl = b.GetBackPage.name;
        aLL.fDM = m.G(getIntent());
        aLL.mIm = this.fwG;
        aLL.aLN().aLM();
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(1703, (e) this);
    }

    protected final void alu() {
        super.alu();
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void initView() {
        super.initView();
        mc(false);
        a(0, getString(R.l.eka), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiSuccWebViewUI.this.finish();
                FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                return true;
            }
        }, p.b.xSj);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!getString(R.l.eka).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(R.l.eka), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    FreeWifiSuccWebViewUI.this.finish();
                    FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                    return true;
                }
            }, p.b.xSj);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        as.CN().b(1703, (e) this);
    }
}
