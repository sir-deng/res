package com.tencent.mm.wallet_core.tenpay.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends i {
    public String appId;
    public int fDM;
    public String frQ;
    public String fvC;
    public String jgc;
    public int scene;
    public String tgP;
    public String zRF;

    public k(String str, int i, int i2, int i3, int i4, String str2) {
        this.scene = i;
        this.fDM = i3;
        Map hashMap = new HashMap();
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        x.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", Integer.valueOf(i4), str2);
        if (i4 < 0) {
            x.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", Integer.valueOf(i4), str2);
            hashMap.put("source_type", "0");
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        D(hashMap);
    }

    public final int azx() {
        return 127;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        x.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", jSONObject.toString());
        this.fvC = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.tgP = jSONObject.optString("appsource");
        this.frQ = jSONObject.optString("productid");
        this.zRF = jSONObject.optString("retcode");
        this.jgc = jSONObject.optString("retmsg");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    public final int Hx() {
        return 1694;
    }
}
