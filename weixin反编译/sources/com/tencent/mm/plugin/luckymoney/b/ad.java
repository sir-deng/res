package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends aa {
    public a fIb;
    public int lon;
    public String oeH;
    public String oiX;
    public String oiY;
    public String oiZ;
    public String oja;
    public String ojb = "";
    public String ojc = "";
    public String ojd = "";
    public String oje;

    public ad(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.lon = i;
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bi.oM(str)));
        hashMap.put("sendUserName", str5);
        if (!bi.oN(str3)) {
            hashMap.put("username", str3);
        }
        if (!bi.oN(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(bi.oM(str6)));
            if (!bi.oN(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", "0");
        }
        D(hashMap);
    }

    public final int getType() {
        return 1575;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.oeH = jSONObject.optString("sendId");
        this.oiX = jSONObject.optString("reqkey");
        this.oiY = jSONObject.optString("sendMsgXml");
        this.oiZ = jSONObject.optString("guide_flag", "0");
        this.oja = jSONObject.optString("guide_wording");
        this.ojb = jSONObject.optString("left_button_wording", "");
        this.ojc = jSONObject.optString("right_button_wording", "");
        this.ojd = jSONObject.optString("upload_credit_url", "");
        this.oje = jSONObject.optString("id_sign", "");
        if (jSONObject.has("showmess")) {
            x.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
            this.fIb = L(jSONObject);
        }
    }

    public static a L(JSONObject jSONObject) {
        a aVar = new a();
        aVar.fzT = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.ojb = optJSONObject.optString("left_button_wording");
        aVar.ojc = optJSONObject.optString("right_button_wording");
        aVar.loA = optJSONObject.optString("right_button_url");
        return aVar;
    }
}
