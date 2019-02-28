package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bkv;
import com.tencent.mm.protocal.c.bkw;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class n extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;
    private String qZJ;
    private bkp qZK;
    private int type;

    public n(bkp bkp, String str) {
        a aVar = new a();
        aVar.hnT = new bkv();
        aVar.hnU = new bkw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.hnS = c.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bkv bkv = (bkv) this.gLB.hnQ.hnY;
        bkv.wUa = bkp;
        this.type = bkp.wUu.kzz;
        this.qZK = bkp;
        bkv.vNF = str;
        this.qZJ = str;
        x.d("MicroMsg.NetSceneSnsComment", bkp.wUu.wNo + " " + bkp.wUu.wik);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        m eS = ae.bwf().eS(this.qZK.vWS);
        if (eS == null) {
            com.tencent.mm.plugin.sns.storage.e eL = ae.bwi().eL(this.qZK.vWS);
            if (eL != null) {
                eS = eL.byH();
            }
        }
        if (eS != null) {
            try {
                blf blf = (blf) new blf().aH(eS.field_attrBuf);
                if (blf.wVe != null && blf.wVe.wRn) {
                    bln bln = (bln) new bln().aH(blf.wVe.wRm.oz);
                    bkv bkv = (bkv) this.gLB.hnQ.hnY;
                    if (bln.wVt != null) {
                        x.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(bln.wVt.wfX), Integer.valueOf(bln.wVt.wfY)}));
                        bkv.wUb = new bet().Vf(r0);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.bwe().c(this.qZK.vWS, this.type, this.qZJ);
            bko bko = this.qZK.wUu;
            if (bko.kzz == 1 || bko.kzz == 2 || bko.kzz == 3 || bko.kzz == 5) {
                bku bku = new bku();
                bku.pgR = bko.pgR;
                bku.kzz = bko.kzz;
                bku.vON = bko.vON;
                bku.vPp = bko.wNo;
                bku.wDh = bko.wUk;
                bku.noL = bko.noL;
                bku.wUs = bko.wUs;
                try {
                    blf blf = ((bkw) this.gLB.hnR.hnY).wUd;
                    if (bko.kzz == 1 || bko.kzz == 5) {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + blf.vWS + " " + com.tencent.mm.platformtools.n.b(blf.wUN) + " " + blf.wUR.size() + " " + blf.wUU.size());
                    } else {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + blf.vWS + " " + blf.wUR.size() + " " + blf.wUU.size());
                    }
                    ai.d(blf);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            ae.bwe().bvG();
        } else if (i2 == 4) {
            ae.bwe().c(this.qZK.vWS, this.type, this.qZJ);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
