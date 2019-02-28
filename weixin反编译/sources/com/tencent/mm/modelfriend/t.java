package com.tencent.mm.modelfriend;

import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sb;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class t extends k implements com.tencent.mm.network.k {
    private String fyO;
    private String fyQ;
    public final b gLB;
    private e gLE;
    private int hoC;

    public t(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        this.fyO = str4;
        this.fyQ = str5;
        hd hdVar = (hd) this.gLB.hnQ.hnY;
        hdVar.vSX = str4;
        hdVar.vSY = str5;
    }

    public t(String str, int i, String str2, int i2, String str3) {
        this.gLE = null;
        this.hoC = 2;
        this.fyO = null;
        this.fyQ = null;
        a aVar = new a();
        aVar.hnT = new hd();
        aVar.hnU = new he();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.hnS = 132;
        aVar.hnV = 45;
        aVar.hnW = 1000000045;
        this.gLB = aVar.Kf();
        hd hdVar = (hd) this.gLB.hnQ.hnY;
        hdVar.vQC = i;
        hdVar.vSU = i2;
        hdVar.vSV = str3;
        if (bi.oN(this.fyO) && bi.oN(this.fyQ)) {
            hdVar.vSX = f.xmW ? ad.getContext().getString(R.l.eGS) : ad.getContext().getString(R.l.eGR);
            hdVar.vSY = d.vHj;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            as.Hm();
            c.Db().set(4097, str);
        } else if (i == 2 || i == 19) {
            as.Hm();
            str = (String) c.Db().get(4097, null);
        } else if (i == 3) {
            as.Hm();
            str = (String) c.Db().get(6, null);
        }
        x.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        hdVar.vSS = str;
        hdVar.vST = str2;
        hdVar.lTZ = w.cfV();
    }

    public final int IY() {
        return ((hd) this.gLB.hnQ.hnY).vQC;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        hd hdVar = (hd) this.gLB.hnQ.hnY;
        if (hdVar.vSS == null || hdVar.vSS.length() <= 0) {
            x.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + hdVar.vSS);
            return -1;
        } else if ((hdVar.vQC != 2 && hdVar.vQC != 19) || (hdVar.vST != null && hdVar.vST.length() > 0)) {
            return a(eVar, this.gLB, this);
        } else {
            x.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + hdVar.vSS);
            return -1;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        hd hdVar = (hd) this.gLB.hnQ.hnY;
        he heVar = (he) this.gLB.hnR.hnY;
        if (heVar != null) {
            int i4 = heVar.vQg;
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", Integer.valueOf(i4));
            g.Dr();
            g.Dq().gRO.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Dp().gRu.hoF;
            if (eVar != null) {
                eVar.bJ((i4 & 1) == 0);
            }
        } else {
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", heVar);
        }
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + heVar.vTe + "safedevice status = " + heVar.vMj);
            if (hdVar.vQC == 2 || hdVar.vQC == 4 || hdVar.vQC == 11 || hdVar.vQC == 19) {
                as.Hm();
                c.Db().set(4097, "");
                as.Hm();
                c.Db().set(6, hdVar.vSS);
                if (bi.oN(this.fyO) || bi.oN(this.fyQ)) {
                    m.NQ();
                }
                if (!(bi.oN(this.fyO) || bi.oN(this.fyQ))) {
                    com.tencent.mm.sdk.b.b sbVar = new sb();
                    sbVar.fKD.fKE = heVar;
                    com.tencent.mm.sdk.b.a.xmy.m(sbVar);
                    as.Hm();
                    c.Db().set(64, Integer.valueOf(heVar.vMj));
                    com.tencent.mm.sdk.b.b scVar = new sc();
                    scVar.fKF.fKG = true;
                    scVar.fKF.fKH = true;
                    com.tencent.mm.sdk.b.a.xmy.m(scVar);
                }
                if (hdVar.vQC == 19) {
                    as.Hm();
                    c.Db().set(12322, null);
                }
                x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (hdVar.vQC == 3) {
                as.Hm();
                c.Db().set(4097, "");
                as.Hm();
                c.Db().set(6, "");
                as.Hm();
                c.Db().set(12322, null);
                as.Hm();
                c.Db().set(64, Integer.valueOf(heVar.vMj));
                com.tencent.mm.sdk.b.b scVar2 = new sc();
                scVar2.fKF.fKG = false;
                scVar2.fKF.fKH = true;
                com.tencent.mm.sdk.b.a.xmy.m(scVar2);
                m.NX();
                m.NY();
                x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.hoC));
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
                return;
            } else {
                a(this.hok, this.gLE);
                return;
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
