package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> mIe = new HashMap<String, String>() {
        {
            for (b bVar : b.values()) {
                put(bVar.name, bVar.mIX);
            }
        }
    };
    private String bssid;
    private int fDM;
    private String fqu;
    private String fqv;
    private String lfa;
    private int mIf;
    private String mIg;
    private String mIh;
    private String mIi;
    private int mIj;
    private long mIk;
    private String mIl;
    private String mIm;
    private long mIn;
    private int result;
    private String ssid;

    public enum b {
        GetFrontPage(10, "getFrontPage", "a"),
        GetFrontPageReturn(11, "getFrontpageReturn", "ar"),
        GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
        AddNetwork(20, "addNetwork", "n"),
        GetBackPage(30, "getBackPage", "b"),
        GetBackPageReturn(31, "getBackPageReturn", "br"),
        GetBackPage33(32, "getBackPage33", "b33"),
        GetBackPage33Return(33, "getBackPage33Return", "b33r"),
        BackpageFinished(40, "backpageFinished", "bf"),
        QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
        ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
        GetThreeOneLock(290, "getThreeOneLock", "31lk"),
        GetPortalApInfo(300, "getPortalApInfo", "o"),
        GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
        GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
        FrontPageUIClosed(303, "frontPageUIClosed", "af"),
        FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
        FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
        FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
        ThreeOneAuth(305, "threeOneAuth", "31a"),
        ThreeTwoAuth(306, "threeTwoAuth", "32a"),
        ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
        ThreeThreeAuth(308, "threeThreeAuth", "33a"),
        GetPcFrontPage(210, "getPcFrontPage", "pca"),
        GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
        SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
        SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
        ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld"),
        CopyPwdPageUIClosedByGoBack(600, "CopyPwdPageUIClosedByGoBack", "cpg");
        
        public long mIW;
        String mIX;
        public String name;

        private b(long j, String str, String str2) {
            if (j > 999 || j < 0) {
                throw new IllegalArgumentException("code must be between 0 and 999");
            }
            this.mIW = j;
            this.name = str;
            this.mIX = str2;
        }
    }

    public static class a {
        public String bssid;
        public int fDM;
        public String fqu;
        public String fqv;
        public String lfa;
        private int mIf;
        public String mIg;
        public String mIh;
        public String mIi;
        public int mIj;
        public long mIk;
        public String mIl;
        public String mIm;
        private long mIn;
        public int result;
        public String ssid;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
        }

        public final k aLN() {
            k kVar = new k();
            kVar.ssid = this.ssid;
            kVar.bssid = this.bssid;
            kVar.fqv = this.fqv;
            kVar.fqu = this.fqu;
            kVar.mIf = this.mIf;
            kVar.mIg = this.mIg;
            kVar.mIh = this.mIh;
            kVar.mIi = this.mIi;
            kVar.mIj = this.mIj;
            kVar.mIk = (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.mIj)}) + String.format("%03d", new Object[]{Long.valueOf(this.mIk)})).intValue();
            kVar.mIl = this.mIl;
            kVar.result = this.result;
            kVar.fDM = this.fDM;
            kVar.mIm = this.mIm;
            kVar.mIn = this.mIn;
            kVar.lfa = this.lfa;
            return kVar;
        }
    }

    /* synthetic */ k(byte b) {
        this();
    }

    public static String Be(String str) {
        return m.Bh((String) mIe.get(str));
    }

    private k() {
    }

    public static a aLL() {
        return new a();
    }

    public final k aLM() {
        g.pWK.h(12804, m.Bh(this.ssid), m.Bh(this.bssid), m.Bh(this.fqv), m.Bh(this.fqu), Integer.valueOf(this.mIf), m.Bh(this.mIg), m.Bh(this.mIh), m.Bh(this.mIi), Integer.valueOf(this.mIj), Long.valueOf(this.mIk), m.Bh(this.mIl), Integer.valueOf(this.result), Integer.valueOf(this.fDM), m.Bh(this.mIm), Long.valueOf(this.mIn), m.Bh(this.lfa));
        return this;
    }

    public final k b(Intent intent, boolean z) {
        try {
            final int F = m.F(intent);
            if (F == 31) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ssid", this.ssid);
                    jSONObject.put("bssid", this.bssid);
                    jSONObject.put("clientMac", this.fqv);
                    jSONObject.put("apKey", this.fqu);
                    jSONObject.put("qrtype", this.mIf);
                    jSONObject.put("mpShopId", this.mIg);
                    jSONObject.put("mpAppId", this.mIh);
                    jSONObject.put("sessionKey", this.mIi);
                    jSONObject.put("protocolType", this.mIj);
                    jSONObject.put("stageCode", this.mIk);
                    jSONObject.put("stageName", this.mIl);
                    jSONObject.put("result", this.result);
                    jSONObject.put("channel", this.fDM);
                    jSONObject.put("mpUserName", this.mIm);
                    jSONObject.put("timeCost", this.mIn);
                    jSONObject.put("resultMsg", this.lfa);
                    jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
                } catch (Exception e) {
                    x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.f(e));
                }
                String jSONObject2 = jSONObject.toString();
                String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (m.Bf(stringExtra)) {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
                } else {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
                final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (z) {
                    j.aMz().aMg().post(new Runnable() {
                        public final void run() {
                            j.aMx().a(stringExtra2, F, stringExtra3, currentTimeMillis);
                            if (m.aLS()) {
                                com.tencent.mm.plugin.freewifi.f.b.qq(1);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.f(e2));
        }
        return this;
    }
}
