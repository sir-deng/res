package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public k ufy;

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        aB(hashMap);
    }

    public final int azx() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.ufy = new k();
                this.ufy.ufC = jSONObject.optInt("credit_state");
                this.ufy.ufx = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
                this.ufy.ufD = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
                this.ufy.ufE = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
                this.ufy.ufF = jSONObject.optInt("bill_date");
                this.ufy.ufG = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
                this.ufy.ufH = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
                k kVar = this.ufy;
                if (jSONObject.optInt("upgrade_amount") != 1) {
                    z = false;
                }
                kVar.ufI = z;
                this.ufy.ufJ = jSONObject.optInt("bill_month");
                this.ufy.ufK = jSONObject.optString("repay_url");
                this.ufy.ufL = jSONObject.optString("repay_lasttime");
                this.ufy.ufP = jSONObject.optString("lasttime");
                JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.getString("jump_name");
                        if ("account_rights_url".equals(string)) {
                            this.ufy.ufN = jSONObject2.getString("jump_url");
                        } else if ("bill_url".equals(string)) {
                            this.ufy.ufO = jSONObject2.getString("jump_url");
                        } else if ("card_detail_url".equals(string)) {
                            this.ufy.ufM = jSONObject2.getString("jump_url");
                        } else if ("know_more_url".equals(string)) {
                            this.ufy.ufQ = jSONObject2.getString("jump_url");
                        }
                    }
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
                if (jSONObject3 != null) {
                    this.ufy.ufR = new j();
                    this.ufy.ufR.ufB = jSONObject3.getString("app_telephone");
                    this.ufy.ufR.fqG = jSONObject3.getString("nickname");
                    this.ufy.ufR.username = jSONObject3.getString("username");
                    this.ufy.ufR.url = jSONObject3.getString("jump_url");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
