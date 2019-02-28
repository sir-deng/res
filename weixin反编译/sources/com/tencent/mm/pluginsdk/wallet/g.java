package com.tencent.mm.pluginsdk.wallet;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.a.lp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    public String appId;
    public String extInfo;
    public String fDO;
    public String fDP;
    public int fDQ;
    public int fDR;
    public int frE;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public String signType;
    public String timeStamp;
    public String url;
    public int vGv = 0;
    public String vGw;
    public int vGx = 0;

    public g(Map<String, Object> map) {
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.fDO = (String) map.get("paySign");
        this.url = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.fDP = (String) map.get("src_username");
        this.fDQ = bi.getInt((String) map.get("scene"), 0);
        if (this.fDQ == 0) {
            this.fDQ = bi.getInt((String) map.get("pay_scene"), 0);
        }
        this.frE = bi.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = bi.oM((String) map.get("ext_info"));
        this.vGw = bi.oM((String) map.get("token"));
        this.vGx = bi.getInt(bi.aD((String) map.get("result_jump_mode"), "0"), 0);
    }

    public g(JSONObject jSONObject) {
        this.appId = jSONObject.optString("appId");
        this.partnerId = jSONObject.optString("partnerId");
        this.signType = jSONObject.optString("signType");
        this.nonceStr = jSONObject.optString("nonceStr");
        this.timeStamp = jSONObject.optString("timeStamp");
        this.packageExt = jSONObject.optString("package");
        this.fDO = jSONObject.optString("paySign");
        this.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.fDP = jSONObject.optString("src_username");
        this.fDQ = jSONObject.optInt("scene", 0);
        if (this.fDQ == 0) {
            this.fDQ = jSONObject.optInt("pay_scene", 0);
        }
        this.frE = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", "");
        this.vGw = jSONObject.optString("token", "");
        this.vGx = bi.getInt(jSONObject.optString("result_jump_mode", "0"), 0);
        this.vGv = jSONObject.optInt("pay_for_wallet_type", 0);
    }

    public g(lp lpVar) {
        if (lpVar != null && lpVar.fDN != null) {
            this.appId = lpVar.fDN.appId;
            this.partnerId = lpVar.fDN.partnerId;
            this.signType = lpVar.fDN.signType;
            this.nonceStr = lpVar.fDN.nonceStr;
            this.timeStamp = lpVar.fDN.timeStamp;
            this.packageExt = lpVar.fDN.packageExt;
            this.fDO = lpVar.fDN.fDO;
            this.url = lpVar.fDN.url;
            this.fDP = lpVar.fDN.fDP;
            this.fDQ = lpVar.fDN.fDQ;
            this.frE = lpVar.fDN.frE;
            this.fDR = lpVar.fDN.fDR;
        }
    }

    public static int eG(int i, int i2) {
        int i3;
        if (i != 1037) {
            i3 = i;
        } else if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = i;
        }
        i3 = (i3 == 1000 || i3 == 1018 || i3 == 1017 || i3 == 1033) ? 0 : i3 == 1019 ? 1 : i3 == 1010 ? 5 : (i3 == 1007 || i3 == 1008) ? 6 : i3 == 1009 ? 7 : (i3 == 1035 || i3 == 1020) ? 8 : (i3 == 1011 || i3 == 1047 || i3 == 1025) ? 12 : (i3 == 1012 || i3 == 1032 || i3 == 1048 || i3 == 1050) ? 13 : (i3 == 1005 || i3 == 1027 || i3 == 1042 || i3 == 1006) ? 15 : (i3 == 1024 || i3 == 1021) ? 16 : (i3 == 1029 || i3 == 1028) ? 23 : (i3 == 1013 || i3 == 1031 || i3 == 1049) ? 24 : (i3 == 1001 || i3 == 1003) ? 25 : (i3 == 1045 || i3 == 1046) ? 26 : i3 == 1022 ? 27 : i3 == 1023 ? 28 : i3 == 1026 ? 29 : i3 == 1039 ? 30 : (i3 == 1034 || i3 == 1060) ? 31 : (i3 == 1014 || i3 == 1043 || i3 == 1044 || i3 == 1036) ? 32 : 0;
        x.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        return i3;
    }
}
