package com.tencent.mm.plugin.favorite.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tw;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.o;
import com.tencent.mm.y.u;

public final class l extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;
    public f mwg;

    public l(f fVar) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", Long.valueOf(fVar.field_localId));
        a aVar = new a();
        aVar.hnT = new bt();
        aVar.hnU = new bu();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.hnS = 401;
        aVar.hnV = JsApiChooseMedia.CTRL_INDEX;
        aVar.hnW = 1000000193;
        this.gLB = aVar.Kf();
        this.mwg = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bt btVar = (bt) this.gLB.hnQ.hnY;
        btVar.vNF = o.k(this.mwg.field_xml, System.currentTimeMillis());
        btVar.kzz = this.mwg.field_type;
        btVar.vNG = this.mwg.field_sourceType;
        this.mwg.field_xml = f.c(this.mwg);
        h.getFavItemInfoStorage().a(this.mwg, "localId");
        btVar.vNI = this.mwg.field_xml;
        btVar.vNH = this.mwg.field_sourceId;
        this.mwg.Aw("MicroMsg.Fav.NetSceneAddFav");
        this.gLE = eVar2;
        x.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", this.mwg.field_sourceId, Long.valueOf(this.mwg.field_localId), Integer.valueOf(this.mwg.field_id));
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            bu buVar = (bu) ((b) qVar).hnR.hnY;
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", Integer.valueOf(buVar.vNB), Long.valueOf(this.mwg.field_localId), Integer.valueOf(this.mwg.field_itemStatus), Integer.valueOf(buVar.vNE));
            this.mwg.field_id = buVar.vNB;
            this.mwg.field_localSeq = buVar.vNE;
            if (this.mwg.field_itemStatus == 12) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.mwg.field_itemStatus = 13;
            }
            if (this.mwg.field_itemStatus == 9) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.mwg.field_itemStatus = 10;
                h.aIZ().cZ(this.mwg.field_localId);
                g.pWK.h(10659, Integer.valueOf(0), Integer.valueOf(this.mwg.field_type), Integer.valueOf(0), Long.valueOf(j.b(this.mwg)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cV(this.mwg.field_localId)));
            }
            f dd = h.getFavItemInfoStorage().dd((long) buVar.vNB);
            if (dd != null) {
                this.mwg.field_updateSeq = dd.field_updateSeq;
                h.getFavItemInfoStorage().g(dd);
                x.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", Integer.valueOf(dd.field_id));
            }
            u.b hB = u.GQ().hB(this.mwg.field_sessionId);
            if (!(bi.oN(this.mwg.field_sessionId) || this.mwg.field_type != 5 || hB == null)) {
                com.tencent.mm.sdk.b.b twVar = new tw();
                twVar.fNj.fNk = hB.getString("prePublishId", "");
                if (!(this.mwg.field_favProto == null || this.mwg.field_favProto.wlW == null)) {
                    twVar.fNj.url = this.mwg.field_favProto.wlW.hPT;
                }
                if (!(!bi.oN(twVar.fNj.url) || this.mwg.field_favProto == null || this.mwg.field_favProto.wlf == null || this.mwg.field_favProto.wlf.wmD == null)) {
                    twVar.fNj.url = this.mwg.field_favProto.wlf.wmD;
                }
                if (bi.oN(twVar.fNj.url)) {
                    twVar.fNj.url = hB.getString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                }
                twVar.fNj.fNm = hB.getString("preUsername", "");
                twVar.fNj.fNn = hB.getString("preChatName", "");
                twVar.fNj.fNo = hB.getInt("preMsgIndex", 0);
                twVar.fNj.fNs = hB.getInt("sendAppMsgScene", 0);
                twVar.fNj.fNt = hB.getInt("getA8KeyScene", 0);
                twVar.fNj.fNu = hB.getString("referUrl", null);
                twVar.fNj.fNv = hB.getString("adExtStr", null);
                twVar.fNj.fNp = "";
                twVar.fNj.fNq = "";
                twVar.fNj.fNr = 0;
                twVar.fNj.fNl = "fav_" + com.tencent.mm.y.q.FY() + "_" + this.mwg.field_id;
                com.tencent.mm.sdk.b.a.xmy.m(twVar);
            }
            this.mwg.field_sessionId = null;
            h.getFavItemInfoStorage().a(this.mwg, "localId");
            j.dj(buVar.vNJ);
        }
        if (i2 == 4 && i3 == -401) {
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.mwg.aIv()) {
                h.getFavItemInfoStorage().t(16, this.mwg.field_localId);
            } else {
                h.getFavItemInfoStorage().t(6, this.mwg.field_localId);
            }
        }
        j.z(this.mwg);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 401;
    }
}
