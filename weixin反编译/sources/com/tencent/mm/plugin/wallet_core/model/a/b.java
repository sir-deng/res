package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b {
    public boolean mkY;
    public Bankcard sWX;
    public String sWY;
    public String sWZ;
    public boolean sXa;
    public int sXb;

    public static String ad(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
        return jSONObject2.toString();
    }

    public b(Bankcard bankcard) {
        this.sWX = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.sWX.field_ext_msg);
            this.sWY = jSONObject.optString("information");
            this.mkY = jSONObject.optBoolean("verified");
            this.sWZ = jSONObject.optString("card_expiry");
            this.sXb = jSONObject.optInt("cvv_length");
            this.sXa = jSONObject.optBoolean("is_credit");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
    }
}
