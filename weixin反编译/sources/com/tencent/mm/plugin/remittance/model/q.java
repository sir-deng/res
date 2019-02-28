package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends a {
    public String desc;
    public long fMM;
    public int loD;
    public String loE;
    public String loF;
    public String loG;
    public String loH;
    public int loI;
    public String pQp;
    public String pQq;
    public String pQr;

    public q(String str) {
        Map hashMap = new HashMap();
        try {
            if (!bi.oN(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", str);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pQp = jSONObject.optString("recv_username", "");
        this.loH = jSONObject.optString("recv_realname", "");
        this.pQq = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.fMM = jSONObject.optLong("amount", 0);
        this.loI = jSONObject.optInt("set_amount", 0);
        this.loD = jSONObject.optInt("currency", 0);
        this.loE = jSONObject.optString("currencyunit", "");
        this.pQr = jSONObject.optString("qrcodeid", "");
        this.loF = jSONObject.optString("notice", "");
        this.loG = jSONObject.optString("notice_url", "");
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", this.pQp, this.pQq, this.desc, Long.valueOf(this.fMM), Integer.valueOf(this.loI), this.loE);
        x.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", this.loH);
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    public final int getType() {
        return 1301;
    }

    public final int azv() {
        return 1301;
    }
}
