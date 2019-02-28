package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac extends aa {
    public String fMx;
    long frh;
    public String oeH;
    public String oiW;
    public e oiv = null;
    public RealnameGuideHelper oiw;
    public String talker;

    public ac(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.oeH = str;
        this.fMx = str2;
        this.talker = str5;
        Map hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!bi.oN(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!bi.oN(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(bi.oM(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        D(hashMap);
    }

    public final int getType() {
        return 1685;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.oiv = l.I(jSONObject);
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.oiw = new RealnameGuideHelper();
                    this.oiw.a(optString, optString2, optString3, optString4, optString5, 1003);
                }
            }
            this.oiW = jSONObject.optString("SystemMsgContext");
            if (i == 0 && !bi.oN(this.oiW) && !bi.oN(this.oiv.ohP)) {
                try {
                    this.oiW = this.oiW.replace("$" + this.oiv.ohP + "$", ((b) g.h(b.class)).gw(this.oiv.ohP));
                    n.dn(this.oiW, this.talker);
                } catch (Exception e) {
                    x.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", e.getMessage());
                }
            }
        } catch (JSONException e2) {
            x.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
        }
    }
}
