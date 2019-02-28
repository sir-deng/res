package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kPl;
    public int kPm = 0;
    public String kPn;
    public int kPo;
    public String kPp;
    public String kSR;

    public f(String str, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hnT = new aqx();
        aVar.hnU = new aqy();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.hnS = 907;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aqx aqx = (aqx) this.gLB.hnQ.hnY;
        aqx.fHP = str;
        aqx.wEs = i2;
        aqx.wEr = i;
        aqx.scene = i3;
        this.kSR = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aqy aqy = (aqy) this.gLB.hnR.hnY;
            x.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + aqy.kRy);
            Object obj = aqy.kRy;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    this.kPl = jSONObject.optString("mark_user");
                    this.kPm = jSONObject.optInt("mark_succ", 0);
                    this.kPn = jSONObject.optString("mark_card_id");
                    this.kPo = jSONObject.optInt("expire_time", 0);
                    this.kPp = jSONObject.optString("pay_qrcode_wording");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 907;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
