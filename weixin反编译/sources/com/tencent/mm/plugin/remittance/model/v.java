package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v extends i {
    public String desc;
    public double loS;
    public String pQP;
    public String pQQ;
    public String pQR = "";
    public String pQS = "";
    public String pQT = "";
    public String pQU = "";
    public int pQV;
    public String pQW = "";
    public String pQX = "";
    public int pQY;
    public String pQZ;
    public String pRa;
    public int pRb;
    public BusiRemittanceResp pRc;
    public int scene;
    public String username;

    public v(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        aB(hashMap);
    }

    public final int azx() {
        return 0;
    }

    public final int Hx() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
            if (i == 0) {
                x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", jSONObject.toString());
                this.username = jSONObject.optString("user_name", "");
                this.pQP = jSONObject.optString("true_name");
                this.loS = jSONObject.optDouble("fee") / 100.0d;
                this.desc = jSONObject.optString("desc");
                this.scene = jSONObject.optInt("scene");
                this.pQQ = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
                this.pQR = jSONObject.optString("f2f_pay_desc");
                this.pQS = jSONObject.optString("rcvr_desc");
                this.pQT = jSONObject.optString("payer_desc");
                this.pQU = jSONObject.optString("rcvr_ticket");
                this.pQV = jSONObject.optInt("busi_type", 0);
                this.pQW = jSONObject.optString("mch_name");
                this.pQX = jSONObject.optString("mch_photo");
                this.pRa = jSONObject.optString("mch_type", "");
                this.pQY = jSONObject.optInt("mch_time", 0);
                this.pQZ = jSONObject.optString("receiver_openid");
                this.pRb = jSONObject.optInt("get_pay_wifi");
                this.pRc = new BusiRemittanceResp(jSONObject);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e, "", new Object[0]);
        }
    }
}
