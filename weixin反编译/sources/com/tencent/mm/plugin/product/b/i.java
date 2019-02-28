package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public String mUrl;
    public LinkedList<rl> pjQ;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new afh();
        aVar.hnU = new afi();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        this.gLB = aVar.Kf();
        afh afh = (afh) this.gLB.hnQ.hnY;
        afh.vXS = str;
        this.mUrl = str2;
        afh.nlE = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        afi afi = (afi) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0 && afi.vXT == 0) {
            x.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + afi.wtV);
            try {
                JSONArray optJSONArray = new JSONObject(afi.wtV).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.pjQ = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        rl rlVar = new rl();
                        rlVar.fpg = jSONObject.getString("title");
                        rlVar.vWH = jSONObject.getInt("fee");
                        this.pjQ.add(rlVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && afi.vXT != 0) {
            i3 = afi.vXT;
            str = afi.vXU;
        }
        x.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
