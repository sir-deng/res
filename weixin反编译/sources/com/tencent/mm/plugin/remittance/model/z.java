package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z extends a {
    public int loD = 0;
    public String pQo = "";
    public int pQu;
    public String pRq = "";
    public int pRr;

    public z(double d, String str, String str2, String str3, String str4, int i) {
        x.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        Map hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", str2);
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(bi.aD(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put("currency", String.valueOf(i));
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        D(hashMap);
    }

    public final int azv() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.pQo = jSONObject.optString("payurl");
        this.pRq = jSONObject.optString("tradeurl");
        this.pQu = jSONObject.optInt("transfering_num");
        this.pRr = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.pQo);
        stringBuffer.append(" tradeurl:" + this.pRq);
        stringBuffer.append(" transfering_num:" + this.pQu);
        stringBuffer.append(" transfering_type:" + this.pRr);
        x.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1622;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
