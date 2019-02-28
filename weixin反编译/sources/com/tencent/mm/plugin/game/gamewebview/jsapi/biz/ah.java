package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.byu;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ah extends a {
    public static final int CTRL_BYTE = 10000;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "openWeAppPage";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "invoke");
        JSONObject sx = d.sx(str);
        if (sx == null) {
            x.e("MicroMsg.GameJsApiOpenWeAppPage", "data is null");
            aVar.sE(a.e("openWeAppPage:fail_null_data", null));
            return;
        }
        String optString = sx.optString("userName");
        String optString2 = sx.optString("relativeURL");
        int optInt = sx.optInt("appVersion", 0);
        String optString3 = sx.optString("searchId");
        String optString4 = sx.optString("docId");
        int optInt2 = sx.optInt("position", 1);
        int optInt3 = sx.optInt("scene", 1000);
        b qrVar = new qr();
        if (optInt3 == 201) {
            qrVar.fJd.scene = 1006;
        } else if (optInt3 == 3) {
            qrVar.fJd.scene = 1005;
        } else if (optInt3 == 16) {
            qrVar.fJd.scene = 1042;
        } else {
            qrVar.fJd.scene = 1000;
        }
        qrVar.fJd.userName = optString;
        qrVar.fJd.fJf = optString2;
        qrVar.fJd.fJh = optInt;
        qrVar.fJd.fJk = false;
        optString = sx.optString("statSessionId");
        optString2 = sx.optString("statKeywordId");
        String optString5 = sx.optString("subScene");
        qrVar.fJd.foi = optString + ":" + optString2 + ":" + optString3 + ":" + optString4 + ":" + optInt2 + ":" + optString5;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new byu();
        aVar2.hnU = new byv();
        aVar2.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar2.hnS = 1873;
        com.tencent.mm.ad.b Kf = aVar2.Kf();
        byu byu = (byu) Kf.hnQ.hnY;
        byu.xfP = sx.optString("statSessionId");
        byu.xfQ = sx.optString("statKeywordId");
        byu.wDX = sx.optString("searchId");
        byu.wQr = sx.optString("docId");
        byu.xfR = sx.optInt("position", 1);
        byu.pho = sx.optString("userName");
        byu.xfS = sx.optInt("appVersion", 0);
        byu.xfT = sx.optString("adBuffer");
        byu.xfU = sx.optString("clickExtInfo");
        final com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20StatSessionId", byu.xfP + ",");
        dVar.q("21KeywordId", byu.xfQ + ",");
        dVar.q("22SearchId", byu.wDX + ",");
        dVar.q("23DocId", byu.wQr + ",");
        dVar.q("24Pos", byu.xfR + ",");
        dVar.q("25AppUserName", byu.pho + ",");
        dVar.q("26AppVersion", byu.xfS + ",");
        dVar.q("27AdBuffer", byu.xfT + ",");
        dVar.q("28AdClickBuffer", byu.xfU + ",");
        dVar.q("29scene", optInt3 + ",");
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "doClickReportScene oreh" + dVar.SG());
        u.a(Kf, new u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.GameJsApiOpenWeAppPage", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (!(i == 0 && i2 == 0)) {
                    x.i("MicroMsg.GameJsApiOpenWeAppPage", "report oreh logbuffer(13927)");
                    g.pWK.h(13927, dVar);
                    g.pWK.a(457, 0, 1, false);
                }
                return 0;
            }
        });
        if (qrVar.fJe.fJp) {
            aVar.sE(a.e("openWeAppPage:ok", null));
        } else {
            aVar.sE(a.e("openWeAppPage:fail:" + bi.oM(qrVar.fJe.fJq), null));
        }
    }
}
