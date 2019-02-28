package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    private Map<String, String> pcB = new HashMap();
    public String sKI = null;
    private Map<String, String> sKu = new HashMap();
    public String token = null;

    public a(Authen authen) {
        a(authen.pHW, this.pcB, this.sKu);
        this.pcB.put("flag", authen.fEo);
        this.pcB.put("bank_type", authen.pff);
        if (!bi.oN(authen.sQC)) {
            this.pcB.put("passwd", authen.sQC);
        }
        if (!bi.oN(authen.token)) {
            this.pcB.put("token", authen.token);
        }
        if (!bi.oN(authen.sHU)) {
            g.Dr();
            o oVar = new o(bi.a((Integer) g.Dq().Db().get(9, null), 0));
            this.pcB.put("import_code", authen.sHU);
            this.pcB.put("qqid", oVar.toString());
            if (authen.sQF > 0) {
                this.pcB.put("cre_type", authen.sQF);
            }
            this.pcB.put("bind_serailno", authen.pfg);
        }
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
            this.pcB.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.cfV());
        }
        if (!bi.oN(authen.sQD)) {
            this.pcB.put("true_name", authen.sQD);
        }
        if (!bi.oN(authen.sQE)) {
            this.pcB.put("identify_card", authen.sQE);
        }
        if (authen.sQF > 0) {
            this.pcB.put("cre_type", authen.sQF);
        }
        if (!bi.oN(authen.sOP)) {
            this.pcB.put("mobile_no", authen.sOP);
        }
        this.pcB.put("bank_card_id", authen.sQG);
        if (!bi.oN(authen.sQH)) {
            this.pcB.put("cvv2", authen.sQH);
        }
        if (!bi.oN(authen.sQI)) {
            this.pcB.put("valid_thru", authen.sQI);
        }
        if (com.tencent.mm.wallet_core.c.o.cCj()) {
            this.sKu.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.o.cCl());
            this.sKu.put("bindcard_scene", com.tencent.mm.wallet_core.c.o.cCk());
        }
        D(this.pcB);
        aB(this.sKu);
    }

    public final boolean bhI() {
        super.bhI();
        this.pcB.put("is_repeat_send", "1");
        D(this.pcB);
        return true;
    }

    public final int azx() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.sKI = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
    }

    public final String biB() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int Hx() {
        return 471;
    }
}
