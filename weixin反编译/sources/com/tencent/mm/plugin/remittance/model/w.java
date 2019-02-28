package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w extends i {
    public double loS;
    private String pRd = null;
    public int pRe;
    private String pRf;
    public String pRg;
    public boolean pRh;
    public int pRi;
    public String pRj;
    public String pRk;
    public int pRl;
    public String pRm;
    public String pRn;
    public String pgD;
    public int pgN;
    public String pgf;
    public int status;

    public w(int i, String str, String str2, int i2) {
        this.pRd = str;
        this.pgN = i;
        Map hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        D(hashMap);
    }

    public final int azx() {
        return 0;
    }

    public final int Hx() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.pRe = jSONObject.optInt("pay_time");
            this.loS = jSONObject.optDouble("fee") / 100.0d;
            this.pgf = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("trans_status");
            this.pRf = jSONObject.optString("trans_status_name");
            this.pRi = jSONObject.optInt("modify_time");
            this.pRh = jSONObject.optBoolean("is_payer");
            this.pgD = jSONObject.optString("refund_bank_type");
            this.pRj = jSONObject.optString("status_desc");
            this.pRk = jSONObject.optString("status_supplementary");
            this.pRl = jSONObject.optInt("delay_confirm_flag");
            this.pRm = jSONObject.optString("banner_content");
            this.pRn = jSONObject.optString("banner_url");
        }
    }
}
