package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public abstract class l extends i implements a {
    private int errCode = 0;
    private String foE = "";
    public boolean pQj = false;
    private RetryPayInfo sEm;
    public boolean sLK = false;
    private boolean zRG = false;
    public boolean zRH = false;
    public boolean zRI;

    public final void F(boolean z, boolean z2) {
        super.F(z, z2);
    }

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.foE = str;
    }

    public boolean cCy() {
        return false;
    }

    public final boolean boh() {
        return !this.pQj;
    }

    public void a(c cVar, JSONObject jSONObject) {
        boolean z = true;
        super.a(cVar, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.zRI = z;
        this.sEm = new RetryPayInfo();
        this.sEm.Y(jSONObject);
    }

    public final void cCK() {
        reset();
        this.zRH = true;
        this.zRu = false;
    }
}
