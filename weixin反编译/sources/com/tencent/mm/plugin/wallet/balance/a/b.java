package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String fLK;
    public String fLL;
    public String fLM;
    public String fLN;
    public String fLO;
    public int fql = 0;
    public String fxT = null;
    public double pQI = 0.0d;
    public double pQx = 0.0d;
    public boolean sEh = false;
    public String sEi = "";
    public com.tencent.mm.plugin.wallet_core.model.b sEj;
    public com.tencent.mm.plugin.wallet_core.model.b sEk;
    public double sEl;

    public b(double d, String str, String str2, int i) {
        Map hashMap = new HashMap();
        this.sEl = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", this.sEl);
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        D(hashMap);
    }

    public final int azx() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fxT = jSONObject.optString("req_key");
            this.sEh = "1".equals(jSONObject.optString("should_alert"));
            this.sEi = jSONObject.optString("alert_msg");
            this.pQx = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            this.pQI = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
            JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
                this.sEj = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
            }
            optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
                this.sEk = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
            }
            this.fql = jSONObject.optInt("operation", 0);
            x.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.pQx + " total_fee:" + this.pQI + " operation:" + this.fql);
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject.toString());
                this.fLK = optJSONObject.optString("guide_flag");
                this.fLL = optJSONObject.optString("guide_wording");
                this.fLM = optJSONObject.optString("left_button_wording");
                this.fLN = optJSONObject.optString("right_button_wording");
                this.fLO = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int Hx() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }
}
