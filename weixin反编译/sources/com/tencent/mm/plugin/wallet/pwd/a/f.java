package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    private Map<String, String> pcB = new HashMap();
    public String token = null;

    public f(Authen authen, boolean z) {
        this.pcB.put("flag", authen.fEo);
        if (!bi.oN(authen.sQL)) {
            this.pcB.put("first_name", authen.sQL);
            this.pcB.put("last_name", authen.sQM);
            this.pcB.put("country", authen.country);
            this.pcB.put("area", authen.fXk);
            this.pcB.put("city", authen.fXl);
            this.pcB.put("address", authen.hzf);
            this.pcB.put("phone_number", authen.nHv);
            this.pcB.put("zip_code", authen.iot);
            this.pcB.put("email", authen.fXd);
        }
        this.pcB.put("bank_type", authen.pff);
        if (authen.sQF > 0) {
            this.pcB.put("cre_type", authen.sQF);
        }
        if (!bi.oN(authen.sQD)) {
            this.pcB.put("true_name", authen.sQD);
        }
        if (!bi.oN(authen.sQE)) {
            this.pcB.put("identify_card", authen.sQE);
        }
        this.pcB.put("mobile_no", authen.sOP);
        this.pcB.put("bank_card_id", authen.sQG);
        if (!bi.oN(authen.sQH)) {
            this.pcB.put("cvv2", authen.sQH);
        }
        if (!bi.oN(authen.sQI)) {
            this.pcB.put("valid_thru", authen.sQI);
        }
        this.pcB.put("new_card_reset_pwd", z ? "1" : "0");
        D(this.pcB);
    }

    public final boolean bhI() {
        super.bhI();
        this.pcB.put("is_repeat_send", "1");
        D(this.pcB);
        return true;
    }

    public final int azx() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
    }

    public final String biB() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int Hx() {
        return 469;
    }
}
