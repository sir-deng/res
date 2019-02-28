package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a sWW = null;

    public static a bMV() {
        if (sWW == null) {
            sWW = new a();
        }
        return sWW;
    }

    public final Bankcard W(JSONObject jSONObject) {
        Bankcard W = super.W(jSONObject);
        W.field_ext_msg = b.ad(jSONObject);
        W.field_bankcardClientType = 1;
        W.field_desc = jSONObject.optString("description");
        W.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            W.field_cardType |= Bankcard.sRc;
        } else {
            W.field_cardType |= Bankcard.sRe;
        }
        return W;
    }
}
