package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String oXM = null;
    private boolean oXN = false;
    private a oXO = new a();

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (R(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            intent.putExtra("key_trust_url", false);
            super.onCreate(bundle);
            finish();
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.b(this.oXO);
        d.cdJ();
        x.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (NfcWebViewUI.this.oXN) {
                    NfcWebViewUI.this.bgh();
                } else {
                    NfcWebViewUI.this.finish();
                }
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        kA(false);
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.oXO);
    }

    protected final void alu() {
        if (bgf()) {
            finish();
            x.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            return;
        }
        super.alu();
        a(AutoLoginActivity.a.LOGIN_OK, getIntent());
    }

    public void onNewIntent(Intent intent) {
        if (R(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = t.a(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        x.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + a);
        if (a != Integer.MAX_VALUE) {
            this.oXN = true;
        }
        switch (a) {
            case -1:
                a(AutoLoginActivity.a.LOGIN_OK, intent);
                break;
            case 0:
                bgf();
                return;
            case 1:
                a(AutoLoginActivity.a.LOGIN_CANCEL, intent);
                break;
        }
        hf(true);
        x.i("Foreground dispatch", "Discovered tag with intent: " + intent);
    }

    private boolean bgf() {
        try {
            if (!this.jAm.bSO()) {
                return false;
            }
            x.w("MicroMsg.NfcWebViewUI", "not login");
            Intent intent = new Intent(this, getClass());
            intent.putExtras(getIntent());
            intent.addFlags(67108864);
            this.jAm.aa(intent);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        switch (aVar) {
            case LOGIN_OK:
                Tag tag;
                Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    x.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.c.a.a.bgb().a(tag);
                    x.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + com.tencent.mm.plugin.nfc.c.a.a.bgb().dk(this.mController.xRr));
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.NfcWebViewUI", "exp protect");
                    return;
                }
            default:
                finish();
                return;
        }
    }

    protected final void hf(boolean z) {
        if (this.jAm == null) {
            x.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            return;
        }
        a(AutoLoginActivity.a.LOGIN_OK, getIntent());
        String bgg = bgg();
        String str = this.fJB;
        if (!z || bi.oN(this.fJB) || this.fJB.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
            this.fJB = bgg;
            if (bi.oN(this.fJB)) {
                this.fJB = uo(0);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
            }
            getIntent().putExtra("rawUrl", this.fJB);
            if (!this.fJB.equals(str)) {
                x.i("MicroMsg.NfcWebViewUI", "lo-nfc-dealwithNFC: onNewIntent load:" + this.fJB);
                this.pzt.loadUrl(this.fJB);
                return;
            }
            return;
        }
        try {
            int i;
            if (!bi.oN(bgg)) {
                try {
                    Uri parse = Uri.parse(bgg);
                    Uri parse2 = Uri.parse(this.fJB);
                    bgg = parse.getHost();
                    str = parse2.getHost();
                    x.i("MicroMsg.NfcWebViewUI", "targetHost=" + bgg + ", curHost=" + str);
                    if (bgg.equals(str)) {
                        i = 1;
                        if (i != 0) {
                            this.fCC.n(4007, new Bundle());
                        }
                        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
                    }
                } catch (Exception e) {
                }
            }
            i = 0;
            if (i != 0) {
                this.fCC.n(4007, new Bundle());
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
    }

    private static String uo(int i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!f.xmW && w.cfV().equals("zh_CN")) {
            str = "zh_CN";
        } else if (w.cfT()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        return stringBuilder.toString();
    }

    private String bgg() {
        String str = null;
        x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle e = this.jAm.e(4006, null);
            if (e == null) {
                x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                return str;
            }
            e.setClassLoader(getClass().getClassLoader());
            String string = e.getString("debugConfig");
            String string2 = e.getString("config");
            if (string != null) {
                str = Hj(string);
            } else {
                str = Hk(string2);
            }
            x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bi.oM(str));
            return str;
        } catch (Throwable e2) {
            x.e("MicroMsg.NfcWebViewUI", e2.toString());
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
    }

    private String Hj(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.oXM = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    String str2 = split[i];
                    String str3 = split[i + 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.oXM = split[split.length - 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.oXM);
                    return this.oXM;
                }
            }
            return this.oXM;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            x.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bgb().dj(this.mController.xRr));
            this.oXM = uo(1);
            return this.oXM;
        }
    }

    private String Hk(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.oXM = "";
        atx atx = new atx();
        if (!bi.oN(str)) {
            try {
                atx.aH(str.getBytes("ISO-8859-1"));
                if (atx.wfs != null) {
                    int i = 0;
                    int i2 = 0;
                    while (i2 < atx.wfs.size()) {
                        kn knVar = (kn) atx.wfs.get(i2);
                        com.tencent.mm.plugin.nfc.c.a.a bgb = com.tencent.mm.plugin.nfc.c.a.a.bgb();
                        if (bgb.oXB != null) {
                            bgb.oXB.bgc();
                        }
                        if (!(knVar == null || bi.oN(knVar.vJU) || bi.cC(knVar.vXY))) {
                            String str2;
                            int i3 = 0;
                            while (true) {
                                int i4 = i;
                                if (i3 >= knVar.vXY.size()) {
                                    i = i4;
                                    break;
                                }
                                if (!bi.cC(((pq) knVar.vXY.get(i3)).wfv)) {
                                    int i5 = 0;
                                    while (i5 < ((pq) knVar.vXY.get(i3)).wfv.size()) {
                                        if (((pq) knVar.vXY.get(i3)).wfv.get(i5) != null && !bi.oN(((os) ((pq) knVar.vXY.get(i3)).wfv.get(i5)).wes) && !bi.oN(((os) ((pq) knVar.vXY.get(i3)).wfv.get(i5)).oik)) {
                                            String str3 = ((os) ((pq) knVar.vXY.get(i3)).wfv.get(i5)).wes;
                                            str2 = ((os) ((pq) knVar.vXY.get(i3)).wfv.get(i5)).oik;
                                            x.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str3 + " anwser = " + str2);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str3)), str2)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                            }
                            if (i != 0) {
                                str2 = knVar.vJU;
                                x.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                e.post(new Runnable() {
                                    public final void run() {
                                        g.pWK.h(12794, str2, Integer.valueOf(0));
                                        x.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str2);
                                    }
                                }, getClass().getName());
                                return knVar.vJU;
                            }
                        }
                        i2++;
                        i = i;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bgb().dj(this.mController.xRr));
                this.oXM = uo(1);
                return this.oXM;
            }
        }
        return this.oXM;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        boolean z;
        x.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        CharSequence cVar = com.tencent.mm.plugin.nfc.c.a.a.bgb().a(aVar).toString();
        if (!bi.oN(cVar)) {
            x.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bi.oM(str) + " resp = " + bi.oM(cVar));
            if (Pattern.compile(str, 2).matcher(cVar).find()) {
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        if (this.oXN) {
            bgh();
        } else {
            super.onBackPressed();
        }
    }

    private void bgh() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.a((Context) this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.a.bpQ, R.a.bql);
        x.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    }

    private static boolean R(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.NfcWebViewUI", "intent is null");
            return true;
        }
        Tag tag;
        Iterator it = intent.getExtras().keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(str == null || str.startsWith("android.nfc"))) {
                x.e("MicroMsg.NfcWebViewUI", "extra wrong key = " + str);
                it.remove();
            }
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
            tag = null;
        } else {
            tag = (Tag) parcelableExtra;
        }
        if (tag != null) {
            return false;
        }
        x.e("MicroMsg.NfcWebViewUI", "tag is null");
        return true;
    }
}
