package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelvoice.a;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.pi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class e extends k implements com.tencent.mm.network.k {
    private String fileName = "";
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    private String kGw = "";
    private int kGx = 0;
    private a kGy = null;
    private int msgType = 0;

    public e(String str, int i) {
        b.a aVar = new b.a();
        aVar.hnT = new ava();
        aVar.hnU = new avb();
        aVar.uri = "/cgi-bin/micromsg-bin/openbottle";
        aVar.hnS = 156;
        aVar.hnV = 55;
        aVar.hnW = 1000000055;
        this.gLB = aVar.Kf();
        this.kGw = str;
        this.msgType = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        ava ava = (ava) this.gLB.hnQ.hnY;
        ava.nlX = this.msgType;
        ava.wJH = this.kGw;
        if (ava.wJI == null) {
            ava.wJI = new pi();
        }
        if (ava.wJJ == null) {
            ava.wJJ = new pi();
        }
        if (this.msgType == 1) {
            ava.wJI.vPt = 0;
            ava.wJI.wfe = 0;
        } else if (this.msgType != 3) {
            x.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
            return -1;
        }
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        ava ava = (ava) ((b) qVar).hnQ.hnY;
        if (ava.nlX == 1) {
            return b.hoz;
        }
        if (ava.nlX != 3) {
            return b.hoA;
        }
        if (ava.wJI == null) {
            x.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
            return b.hoA;
        } else if (ava.wJI.wfe == 0 && ava.wJI.vPt == 0) {
            return b.hoz;
        } else {
            if (ava.wJI.wfe <= ava.wJI.vPt) {
                return b.hoA;
            }
            return b.hoz;
        }
    }

    protected final int Bo() {
        return 10;
    }

    private int asj() {
        ava ava = (ava) this.gLB.hnQ.hnY;
        avb avb = (avb) this.gLB.hnR.hnY;
        a aVar = new a();
        aVar.msgType = ava.nlX;
        aVar.kGp = 0;
        aVar.kGr = 2;
        aVar.kGq = c.wt(ava.wJH);
        aVar.kGt = bi.Wy();
        aVar.kGo = g.s(ava.wJH.getBytes());
        if (this.msgType == 3) {
            aVar.content = this.fileName;
            aVar.kGs = avb.wgC;
        } else {
            aVar.content = new String(avb.wJL.wff.wRm.oz);
        }
        i.asn().a(aVar);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ava ava = (ava) this.gLB.hnQ.hnY;
            avb avb = (avb) this.gLB.hnR.hnY;
            if (this.msgType == 1) {
                asj();
                cg auVar = new au();
                auVar.dU(ava.wJH);
                auVar.setContent(n.b(avb.wJL.wff));
                auVar.aq(bi.Wy());
                auVar.eS(0);
                auVar.eR(3);
                auVar.setType(c.nA(ava.nlX));
                as.Hm();
                c.Fh().Q(auVar);
                x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + auVar.field_content);
                this.gLE.a(i2, i3, str, this);
                return;
            }
            if (bi.oN(this.fileName)) {
                this.fileName = u.oi(this.kGw);
                this.kGy = new a(com.tencent.mm.modelvoice.q.getFullPath(this.fileName));
                this.kGx = 0;
            }
            if (avb.wJL.wfe < avb.wJL.vPt + avb.wJL.wff.wRk) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + avb.wJL.wfe + " start:" + avb.wJL.vPt + " len:" + avb.wJL.wff.wRk);
                this.gLE.a(3, -1, str, this);
                return;
            } else if (avb.wJL.vPt != this.kGx) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + avb.wJL.vPt + " off:" + this.kGx);
                this.gLE.a(3, -1, str, this);
                return;
            } else {
                int write = this.kGy.write(avb.wJL.wff.wRm.oz, avb.wJL.wff.wRk, avb.wJL.vPt);
                if (write != avb.wJL.wff.wRk + avb.wJL.vPt) {
                    x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + avb.wJL.vPt + " len:" + avb.wJL.wff.wRk + " writeRet:" + write);
                    this.gLE.a(3, -1, str, this);
                    return;
                }
                this.kGx = write;
                if (avb.wJL.wfe <= this.kGx) {
                    asj();
                    au auVar2 = new au();
                    auVar2.dU(ava.wJH);
                    auVar2.setContent(com.tencent.mm.modelvoice.n.b("bottle", (long) avb.wgC, false));
                    auVar2.dV(this.fileName);
                    auVar2.aq(bi.Wy());
                    auVar2.eS(0);
                    auVar2.eR(3);
                    auVar2.setType(c.nA(ava.nlX));
                    as.Hm();
                    c.Fh().Q(auVar2);
                    x.d("MicroMsg.NetSceneOpenBottle", "voice :" + avb.wgC + " file:" + this.fileName);
                    this.gLE.a(i2, i3, str, this);
                    return;
                } else if (a(this.hok, this.gLE) == -1) {
                    this.gLE.a(3, -1, "doScene failed", this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 156;
    }
}
