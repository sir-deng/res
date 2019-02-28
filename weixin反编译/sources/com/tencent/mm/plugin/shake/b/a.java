package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private String kTd;
    List<d> qtD;
    private int qtE;
    int ret;

    public a(byte[] bArr) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bja();
        aVar.hnU = new bjb();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        this.gLB = aVar.Kf();
        bja bja = (bja) this.gLB.hnQ.hnY;
        bja.vQW = new bes().bl(bArr);
        bja.wSZ = 1;
        bja.wCD = new bes().bl(d.oXY.bgp());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 162;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bjb bjb = (bjb) this.gLB.hnR.hnY;
        this.qtD = new LinkedList();
        this.qtE = bjb.wTb;
        this.ret = bjb.vQL;
        this.kTd = bjb.pke;
        int i4 = bjb.kyA;
        x.d("MicroMsg.NetSceneShakeGet", "size:" + i4);
        as.Hm();
        ar Ff = c.Ff();
        if (i4 > 0) {
            e bsm = m.bsm();
            bsm.bse();
            x.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i4);
            if (bsm.gLA.fD("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                x.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i4);
                bsm.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                if (!com.tencent.mm.y.q.FY().equals(((biz) bjb.wTa.get(i4)).kyG)) {
                    com.tencent.mm.af.d jN = y.Ml().jN(((biz) bjb.wTa.get(i4)).kyG);
                    jN.field_username = ((biz) bjb.wTa.get(i4)).kyG;
                    jN.field_brandList = ((biz) bjb.wTa.get(i4)).hxo;
                    py pyVar = ((biz) bjb.wTa.get(i4)).wCx;
                    if (pyVar != null) {
                        jN.field_brandFlag = pyVar.hxs;
                        jN.field_brandInfo = pyVar.hxu;
                        jN.field_brandIconURL = pyVar.hxv;
                        jN.field_extInfo = pyVar.hxt;
                    }
                    if (!y.Ml().e(jN)) {
                        y.Ml().d(jN);
                    }
                }
                d dVar = new d((biz) bjb.wTa.get(i4));
                h hVar = new h();
                hVar.username = dVar.field_username;
                hVar.bC(dVar.field_hasHDImg > 0);
                hVar.fWZ = dVar.field_imgstatus;
                hVar.hni = ((biz) bjb.wTa.get(i4)).wbY;
                hVar.hnh = ((biz) bjb.wTa.get(i4)).wbZ;
                n.JW().a(hVar);
                hVar.fEo = -1;
                x.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
                dVar.field_reserved2 = Ff.Xr(dVar.field_username) ? 1 : 0;
                ag Xv = Ff.Xv(dVar.field_username);
                if (Xv != null && ((int) Xv.gKO) > 0) {
                    bsm.JJ(Xv.field_username);
                    bsm.JJ(Xv.field_encryptUsername);
                }
                bsm.a(dVar, false);
                as.Hm();
                c.FP().y(dVar.field_username, this.qtE, ((biz) bjb.wTa.get(i4)).woW);
                dVar.scene = this.qtE;
                this.qtD.add(dVar);
                x.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
