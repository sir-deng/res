package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y extends a {
    public int loD = 0;
    public String loF;
    public String loG;
    public String pRo = "";
    public String pRp = "";

    public y(int i) {
        x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        Map hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
    }

    public final int azv() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.loD = jSONObject.optInt("currency");
        this.pRo = jSONObject.optString("currencyUint");
        this.pRp = jSONObject.optString("currencyWording");
        this.loF = jSONObject.optString("notice");
        this.loG = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.loD);
        stringBuffer.append(" currencyuint:" + this.pRo);
        stringBuffer.append(" currencywording:" + this.pRp);
        stringBuffer.append(" notice:" + this.loF);
        stringBuffer.append(" notice_url:" + this.loG);
        x.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1574;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
