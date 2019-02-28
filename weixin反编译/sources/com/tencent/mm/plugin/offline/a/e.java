package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONObject;

public final class e extends l {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    public int lot = -1;
    private String lou = "";
    public String pbT = "";
    public int pbU = -1;
    public String pbV = "";
    public int pbW = 1;
    public RealnameGuideHelper pbX;
    private String pbY;
    private String pbZ;
    private String pca;
    private String pcb;
    private String pcc;

    public e(int i, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new aui();
        aVar.hnU = new auj();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.hnS = 609;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aui aui = (aui) this.gLB.hnQ.hnY;
        aui.wJc = i;
        aui.nMq = str;
        aui.sVs = str2;
        aui.vXW = i.bLR();
        this.pbW = i;
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        auj auj = (auj) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            try {
                if (auj.wts != null) {
                    JSONObject jSONObject = new JSONObject(auj.wts);
                    this.pbT = jSONObject.optString("transaction_id");
                    this.lot = jSONObject.optInt("retcode");
                    this.lou = jSONObject.optString("retmsg");
                    this.pbU = jSONObject.optInt("wx_error_type");
                    this.pbV = jSONObject.optString("wx_error_msg");
                    x.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", jSONObject.toString());
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.pbY = optJSONObject.optString("guide_flag");
                        this.pbZ = optJSONObject.optString("guide_wording");
                        this.pca = optJSONObject.optString("left_button_wording");
                        this.pcb = optJSONObject.optString("right_button_wording");
                        this.pcc = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.pbY) || "2".equals(this.pbY)) {
                            this.pbX = new RealnameGuideHelper();
                            this.pbX.a(this.pbY, this.pbZ, this.pca, this.pcb, this.pcc, 0);
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uXI);
            }
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
