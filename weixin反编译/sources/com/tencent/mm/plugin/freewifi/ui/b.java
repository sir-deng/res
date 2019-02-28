package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    Activity activity;
    int fDM;
    String fqu;
    Intent intent;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.b$2 */
    class AnonymousClass2 implements e {
        final /* synthetic */ String mMB;
        final /* synthetic */ String mMC;
        final /* synthetic */ String mMD;
        final /* synthetic */ String mME;

        AnonymousClass2(String str, String str2, String str3, String str4) {
            this.mMB = str;
            this.mMC = str2;
            this.mMD = str3;
            this.mME = str4;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", m.D(b.this.intent), Integer.valueOf(m.E(b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
            a aLL;
            if (i == 0 && i2 == 0) {
                aLL = com.tencent.mm.plugin.freewifi.k.aLL();
                aLL.fqu = b.this.fqu;
                aLL.mIi = m.D(b.this.intent);
                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.mIW;
                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
                aLL.fDM = b.this.fDM;
                aLL.result = i2;
                aLL.lfa = str;
                aLL.aLN().b(b.this.intent, false).aLM();
                i iVar = (i) kVar;
                String aMN = iVar.aMN();
                if (m.Bf(aMN)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", m.D(b.this.intent), Integer.valueOf(m.E(b.this.intent)));
                    b.this.By(b.this.activity.getString(R.l.ejV));
                    aLL = com.tencent.mm.plugin.freewifi.k.aLL();
                    aLL.fqu = b.this.fqu;
                    aLL.mIi = m.D(b.this.intent);
                    aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.mIW;
                    aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                    aLL.fDM = b.this.fDM;
                    aLL.mIj = m.F(b.this.intent);
                    aLL.result = -1;
                    aLL.lfa = "31 auth url is empty.";
                    aLL.aLN().b(b.this.intent, true).aLM();
                    return;
                }
                String Bh = m.Bh(iVar.aMO());
                String Bh2 = m.Bh(this.mMB);
                String Bh3 = m.Bh(this.mMC);
                StringBuilder stringBuilder = new StringBuilder(aMN);
                if (aMN.indexOf("?") != -1) {
                    stringBuilder.append("&extend=").append(Bh);
                } else {
                    stringBuilder.append("?extend=").append(Bh);
                }
                stringBuilder.append("&openId=").append(Bh2).append("&tid=").append(Bh3).append("&timestamp=").append(m.Bh(this.mMD)).append("&sign=").append(m.Bh(this.mME));
                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", m.D(b.this.intent), Integer.valueOf(m.E(b.this.intent)), stringBuilder.toString());
                b.this.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
                b.this.intent.setClass(b.this.activity, FreeWifiFrontPageUI.class);
                b.this.activity.startActivity(b.this.intent);
                b.this.activity.finish();
                b.this.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                aLL = com.tencent.mm.plugin.freewifi.k.aLL();
                aLL.fqu = b.this.fqu;
                aLL.mIi = m.D(b.this.intent);
                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.mIW;
                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                aLL.fDM = b.this.fDM;
                aLL.mIj = m.F(b.this.intent);
                aLL.result = 0;
                aLL.lfa = "";
                aLL.aLN().b(b.this.intent, true).aLM();
                return;
            }
            aLL = com.tencent.mm.plugin.freewifi.k.aLL();
            aLL.fqu = b.this.fqu;
            aLL.mIi = m.D(b.this.intent);
            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.mIW;
            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
            aLL.fDM = b.this.fDM;
            aLL.mIj = m.F(b.this.intent);
            aLL.result = i2;
            aLL.lfa = str;
            aLL.aLN().b(b.this.intent, true).aLM();
            if (m.cE(i, i2) && !m.Bf(str)) {
                b.this.By(str + "(" + m.a(m.F(b.this.intent), com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn, i2) + ")");
            } else if (m.Bf(str)) {
                b.this.By(b.this.activity.getString(R.l.ejV));
            } else {
                b.this.By(str);
            }
        }
    }

    public b(Activity activity, String str, int i) {
        if (activity == null || bi.oN(str)) {
            throw new IllegalArgumentException("acitvity or apKey cannot be null.");
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.fqu = str;
        this.fDM = i;
    }

    final void By(String str) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
    }
}
