package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends a {
    public String desc;
    public long fMM;
    public String loA;
    public String loB;
    public String loC;
    public int loD;
    public String loE;
    public String loF;
    public String loG;
    public String loH;
    public int loI;
    public int lot;
    public String lou;
    public String lov;
    public int low;
    public String lox;
    public String loy;
    public String loz;

    public m(int i) {
        Map hashMap = new HashMap();
        hashMap.put("set_amount", "0");
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", Integer.valueOf(0), Integer.valueOf(i));
    }

    public m(long j, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!bi.oN(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
        this.fMM = j;
        this.desc = str;
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i));
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.lot = jSONObject.optInt("retcode", 0);
        this.lou = jSONObject.optString("retmsg", "");
        this.lov = jSONObject.optString("qrcode_url", "");
        this.low = jSONObject.optInt("alert_type", 0);
        this.lox = jSONObject.optString("alert_title", "");
        this.loy = jSONObject.optString("left_button_text", "");
        this.loz = jSONObject.optString("right_button_text", "");
        this.loA = jSONObject.optString("right_button_url", "");
        this.loB = jSONObject.optString("bottom_text", "");
        this.loC = jSONObject.optString("bottom_url", "");
        this.loD = jSONObject.optInt("currency", 0);
        this.loE = jSONObject.optString("currencyunit", "");
        this.loF = jSONObject.optString("notice", "");
        this.loG = jSONObject.optString("notice_url", "");
        this.loH = jSONObject.optString("recv_realname", "");
        this.loI = jSONObject.optInt("set_amount", 0);
        if (this.loI == 0) {
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_HK_PAY_URL_STRING, this.lov);
            x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", this.lov);
        }
        x.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", this.lov, Integer.valueOf(this.loD));
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    public final int getType() {
        return 1335;
    }

    public final int azv() {
        return 1335;
    }

    public final boolean azw() {
        return true;
    }
}
