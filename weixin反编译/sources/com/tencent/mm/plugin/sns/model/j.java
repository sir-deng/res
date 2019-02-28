package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bkg;
import com.tencent.mm.protocal.c.bkh;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;
    private String qZJ;
    private bkp qZK;
    private int type;

    public j(bkp bkp, String str, String str2) {
        bne mR;
        a aVar = new a();
        aVar.hnT = new bkg();
        aVar.hnU = new bkh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        this.gLB = aVar.Kf();
        bkg bkg = (bkg) this.gLB.hnQ.hnY;
        bkg.wUa = bkp;
        this.type = bkp.wUu.kzz;
        this.qZK = bkp;
        bkg.vNF = str;
        this.qZJ = str;
        com.tencent.mm.plugin.sns.storage.e eL = ae.bwi().eL(bkp.vWS);
        if (eL != null) {
            bpb byF = eL.byF();
            if (byF != null) {
                mR = p.mR(byF.rzD);
            } else {
                x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
                mR = null;
            }
        } else {
            x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
            mR = null;
        }
        if (mR != null) {
            bkg.wUb = n.oK(p.a(mR));
            bkg.vON = mR.cPf;
        }
        bkg.wTZ = n.oK(bi.aD(str2, ""));
        x.i("MicroMsg.NetSceneSnsAdComment", bkp.wUu.wNo + " " + bkp.wUu.wik + " type " + bkp.wUu.kzz + " aduxinfo " + str2 + ", SnsStat=" + bkg.wUb + ", source=" + bkg.vON);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.bwe().c(this.qZK.vWS, this.type, this.qZJ);
            bko bko = this.qZK.wUu;
            if (bko.kzz == 1 || bko.kzz == 2 || bko.kzz == 3 || bko.kzz == 5 || bko.kzz == 7 || bko.kzz == 8) {
                bku bku = new bku();
                bku.pgR = bko.pgR;
                bku.kzz = bko.kzz;
                bku.vON = bko.vON;
                bku.vPp = bko.wNo;
                bku.wDh = bko.wUk;
                bku.noL = bko.noL;
                bku.wUs = bko.wUs;
                try {
                    blf blf;
                    bkg bkg = (bkg) this.gLB.hnQ.hnY;
                    bkh bkh = (bkh) this.gLB.hnR.hnY;
                    if (bkg.vON == 1 || bkg.vON == 2) {
                        blt blt = bkh.wPn;
                        blf = blt.wUd;
                        a.a(blt);
                    } else {
                        bkj bkj = bkh.vOe;
                        blf = bkj.wUd;
                        a.a(bkj);
                    }
                    x.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + blf.toString() + " " + blf.wUR.size() + " " + blf.wUU.size());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            ae.bwe().bvG();
        } else if (i2 == 4) {
            ae.bwe().c(this.qZK.vWS, this.type, this.qZJ);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
