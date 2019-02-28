package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int mMF = 111;
    private String appId;
    private int fei;
    private String fqu;
    private ag hbP = new ag() {
        public final void handleMessage(Message message) {
            b bVar = (b) message.obj;
            if (bVar.mMP == FreeWifiCopyPwdUI.this.mMG) {
                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, bVar.data);
            } else {
                FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, bVar.data);
            }
        }
    };
    private Intent intent;
    private int mKO;
    private int mMG = 1;
    private int mMH = 2;
    protected TextView mMI;
    protected TextView mMJ;
    protected TextView mMK;
    private String ssid;

    public class b {
        Object data;
        int mMP;

        public b(int i, Object obj) {
            this.mMP = i;
            this.data = obj;
        }
    }

    public static class a {
        public static a mMN = new a();
        private int jHN;
        String mMO;
        String text;
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, b bVar) {
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        freeWifiCopyPwdUI.hbP.sendMessage(obtain);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof em) {
            com.tencent.mm.plugin.freewifi.k.a aLL;
            em emVar = (em) obj;
            Intent intent = freeWifiCopyPwdUI.getIntent();
            intent.putExtra("free_wifi_appid", emVar.nqc);
            intent.putExtra("free_wifi_app_nickname", emVar.kzN);
            intent.putExtra("free_wifi_app_username", emVar.kyG);
            intent.putExtra("free_wifi_signature", emVar.hxh);
            intent.putExtra("free_wifi_finish_actioncode", emVar.vQy);
            intent.putExtra("free_wifi_finish_url", emVar.vQz);
            intent.putExtra(c.xMN, emVar.mOo);
            if (emVar.vQy == 2) {
                if (bi.oN(emVar.kyG)) {
                    intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", emVar.kyG);
                    d.b(freeWifiCopyPwdUI, "profile", ".ui.ContactInfoUI", intent2);
                    d.xd();
                    x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent())));
                    aLL = k.aLL();
                    aLL.fqu = freeWifiCopyPwdUI.fqu;
                    aLL.mIi = m.D(intent);
                    aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.mIW;
                    aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    aLL.fDM = m.G(intent);
                    aLL.mIj = m.F(intent);
                    aLL.result = 0;
                    aLL.lfa = "";
                    aLL.aLN().b(intent, true).aLM();
                    return;
                }
            } else if (m.Bf(emVar.vQA)) {
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", emVar.vQA);
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccWebViewUI.class);
            }
            aLL = k.aLL();
            aLL.fqu = freeWifiCopyPwdUI.fqu;
            aLL.mIi = m.D(intent);
            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.mIW;
            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            aLL.fDM = m.G(intent);
            aLL.mIj = m.F(intent);
            aLL.result = 0;
            aLL.lfa = "";
            aLL.aLN().b(intent, true).aLM();
            freeWifiCopyPwdUI.finish();
            freeWifiCopyPwdUI.startActivity(intent);
            d.xd();
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent())));
        }
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.D(freeWifiCopyPwdUI.intent), Integer.valueOf(m.E(freeWifiCopyPwdUI.intent)), aVar.mMO);
            freeWifiCopyPwdUI.mMI.setVisibility(0);
            if (m.Bf(aVar.text)) {
                if (aVar.jHN == 0) {
                    aVar.jHN = R.l.ejN;
                }
                string = freeWifiCopyPwdUI.getString(aVar.jHN);
            } else {
                string = aVar.text;
            }
            freeWifiCopyPwdUI.mMI.setText(string);
            freeWifiCopyPwdUI.mMI.setVisibility(0);
            freeWifiCopyPwdUI.mMJ.setVisibility(0);
            freeWifiCopyPwdUI.mMK.setVisibility(0);
            final String str = freeWifiCopyPwdUI.getString(R.l.ejY) + ": " + aVar.mMO;
            freeWifiCopyPwdUI.mMK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiCopyPwdUI.this.getString(R.l.ejM));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiCopyPwdUI.this, FreeWifiErrorUI.class);
                    FreeWifiCopyPwdUI.this.startActivity(intent);
                }
            });
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent())));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiCopyPwdUI.this.goBack();
                return true;
            }
        });
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.fqu = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.fei = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.mKO = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.h.cjH)).setText(this.ssid);
        com.tencent.mm.pluginsdk.h.c.a(this.mController.xRr, "wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.h.cjr)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FreeWifiCopyPwdUI.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.mMF);
            }
        });
        this.mMI = (TextView) findViewById(R.h.cjt);
        this.mMJ = (TextView) findViewById(R.h.cjs);
        this.mMK = (TextView) findViewById(R.h.cju);
        String aMm = com.tencent.mm.plugin.freewifi.model.d.aMm();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        g.pWK.h(12651, Integer.valueOf(6), aMm, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == mMF && m.aLS() && !com.tencent.pb.common.c.g.isNullOrEmpty(this.ssid) && this.ssid.equals(com.tencent.mm.plugin.freewifi.model.d.aMn())) {
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", m.D(this.intent), Integer.valueOf(m.E(this.intent)));
            com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
            aLL.ssid = this.ssid;
            aLL.bssid = m.Bj("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aLL.fqv = m.Bk("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aLL.fqu = this.fqu;
            aLL.mIh = this.appId;
            aLL.mIi = m.D(this.intent);
            aLL.mIj = m.F(this.intent);
            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.mIW;
            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.name;
            aLL.result = 0;
            aLL.fDM = m.G(this.intent);
            aLL.aLN().aLM();
            m.a(this.intent, this.fqu, this.mKO, this.fei, new com.tencent.mm.plugin.freewifi.m.a() {
                public final void i(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI;
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
                    int c;
                    a aVar;
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                            em aMJ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).aMJ();
                            if (aMJ != null) {
                                x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh, aMJ.vQA);
                                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new b(FreeWifiCopyPwdUI.this.mMG, aMJ));
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                            freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                            freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                            c = FreeWifiCopyPwdUI.this.mMH;
                            aVar = new a();
                            aVar.mMO = m.a(FreeWifiCopyPwdUI.this.mKO, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, 21);
                            FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                        }
                    } else if (!m.cE(i, i2) || m.Bf(str)) {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.mMH;
                        aVar = new a();
                        aVar.mMO = m.a(FreeWifiCopyPwdUI.this.mKO, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                    } else {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.mMH;
                        aVar = new a();
                        aVar.text = str;
                        aVar.mMO = m.a(FreeWifiCopyPwdUI.this.mKO, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        l.t(com.tencent.mm.plugin.freewifi.model.d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
        aLL.fqu = this.fqu;
        aLL.mIi = m.D(this.intent);
        aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.mIW;
        aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.name;
        aLL.fDM = m.G(this.intent);
        aLL.mIj = m.F(this.intent);
        aLL.result = 0;
        aLL.lfa = "";
        aLL.aLN().b(this.intent, true).aLM();
        com.tencent.mm.plugin.freewifi.g.ihN.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.diD;
    }
}
