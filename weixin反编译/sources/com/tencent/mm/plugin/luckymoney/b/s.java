package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends q {
    public long fMM;
    public int fMy;
    public int fMz;
    public int lon;
    public String oeH;
    public a ohH;
    public String ohr;
    public String oin;
    public String oio;
    public int oip;
    public String oiq;
    public int oir;
    public String ois;
    public String oit;
    public int oiu;
    public e oiv = null;
    public RealnameGuideHelper oiw;

    public s(String str, String str2, int i, String str3, String str4) {
        this.oeH = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bi.oN(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        D(hashMap);
    }

    public final int azv() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.oin = jSONObject.optString("spidName");
        this.fMy = jSONObject.optInt("hbStatus");
        this.fMz = jSONObject.optInt("receiveStatus");
        this.ohr = jSONObject.optString("statusMess");
        this.oio = jSONObject.optString("hintMess");
        this.fMM = jSONObject.optLong("amount");
        this.oip = jSONObject.optInt("recNum");
        this.lon = jSONObject.optInt("totalNum");
        this.ohH = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.ohH.gGi = optJSONObject.optInt("enable");
            this.ohH.ohc = optJSONObject.optString("fissionContent");
            this.ohH.ohb = optJSONObject.optString("fissionUrl");
        }
        this.oir = jSONObject.optInt("focusFlag");
        this.ois = jSONObject.optString("focusWording");
        this.oit = jSONObject.optString("focusAppidUserName");
        this.oiu = jSONObject.optInt("isFocus");
        this.oiq = jSONObject.optString("smallHbButtonMess");
        try {
            this.oiv = l.I(jSONObject);
            this.oiv.ohv = jSONObject.optString("spidLogo");
            this.oiv.ohu = jSONObject.optString("spidName");
            this.oiv.oht = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            x.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.oiw = new RealnameGuideHelper();
                this.oiw.a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
    }
}
