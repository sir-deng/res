package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import org.json.JSONObject;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public boolean sOv = false;
    private long sQa = 10;

    public b() {
        x.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        com.tencent.mm.bp.a aft = new aft();
        aft.vXW = i.bLR();
        if (!f.cdG()) {
            aft.wbD = f.cdH();
        }
        aVar.hnT = aft;
        aVar.hnU = new afu();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.hnS = 1666;
        this.gLB = aVar.Kf();
        this.gLB.hoh = true;
    }

    public final int getType() {
        return 1666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            afu afu = (afu) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
            if (afu.wuv <= 0) {
                j = this.sQa;
            } else {
                j = afu.wuv;
            }
            this.sOv = afu.sOv;
            x.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", Boolean.valueOf(this.sOv));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", afu.wuo);
                jSONObject.put("bindcardSubTitle", afu.wup);
                jSONObject.put("bindIdTitle", afu.wuq);
                jSONObject.put("bindIdSubTitle", afu.wur);
                jSONObject.put("extral_wording", afu.wus);
                jSONObject.put("question_answer_switch", afu.wut);
                jSONObject.put("question_answer_url", afu.wuu);
                jSONObject.put("cache_time", j);
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", afu.wuw);
                jSONObject.put("isShowBindCardVerify", afu.wuy);
                jSONObject.put("isShowBindId", afu.wux);
                jSONObject.put("bindCardVerifyTitle", afu.wuz);
                jSONObject.put("bindCardVerifySubtitle", afu.wuA);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", afu.wuB);
                jSONObject.put("bindCardVerifyAlertViewContent", afu.wuC);
                jSONObject.put("isShowBindCardVerifyAlertView", afu.wuD);
                if (afu.wuE != null && afu.wuE.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = null;
                    Iterator it = afu.wuE.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (obj != null) {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(str2);
                        int obj2 = 1;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                g.Dr();
                g.Dq().Db().a(w.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, jSONObject.toString());
                g.Dr();
                g.Dq().Db().lO(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
