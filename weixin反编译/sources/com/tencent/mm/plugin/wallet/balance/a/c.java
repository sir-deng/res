package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i implements ITenpaySave {
    public String fLK;
    public String fLL;
    public String fLM;
    public String fLN;
    public String fLO;
    public String fxT = null;
    public boolean sEh = false;
    public String sEi = "";
    public double sEl;
    private RetryPayInfo sEm;

    public c(double d, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        this.sEl = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", this.sEl);
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        D(hashMap);
    }

    public final int azx() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fxT = jSONObject.optString("req_key");
            this.sEh = "1".equals(jSONObject.optString("should_alert"));
            this.sEi = jSONObject.optString("alert_msg");
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", optJSONObject.toString());
                this.fLK = optJSONObject.optString("guide_flag");
                this.fLL = optJSONObject.optString("guide_wording");
                this.fLM = optJSONObject.optString("left_button_wording");
                this.fLN = optJSONObject.optString("right_button_wording");
                this.fLO = optJSONObject.optString("upload_credit_url");
            }
            this.sEm = new RetryPayInfo();
            this.sEm.Y(jSONObject);
        }
    }

    public final int Hx() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    public final RetryPayInfo bJV() {
        return this.sEm;
    }
}
