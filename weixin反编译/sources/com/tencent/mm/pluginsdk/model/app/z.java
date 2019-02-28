package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class z extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private final a vln;

    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, long j);
    }

    public z(com.tencent.mm.x.g.a aVar, String str, String str2, a aVar2) {
        com.tencent.mm.ad.b.a aVar3 = new com.tencent.mm.ad.b.a();
        aVar3.hnT = new ms();
        aVar3.hnU = new mt();
        aVar3.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.gLB = aVar3.Kf();
        ms msVar = (ms) this.gLB.hnQ.hnY;
        if (aVar != null) {
            msVar.vXE = aVar.hda;
            msVar.wcf = aVar.filemd5;
            msVar.hLi = aVar.title;
            msVar.wcg = aVar.hcN;
            msVar.wce = (long) aVar.hcM;
        } else {
            g.MQ();
            msVar.vXE = com.tencent.mm.modelcdntran.b.MI();
            g.MQ();
            msVar.wcf = com.tencent.mm.modelcdntran.b.kE(str);
            msVar.hLi = com.tencent.mm.a.e.bR(str);
            msVar.wcg = com.tencent.mm.a.e.bQ(str);
            msVar.wce = (long) com.tencent.mm.a.e.bN(str);
        }
        msVar.vPv = com.tencent.mm.modelcdntran.b.htw;
        msVar.npV = str2;
        msVar.npW = q.FY();
        this.vln = aVar2;
        x.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", aVar, msVar.vXE, msVar.wcf, msVar.hLi, Long.valueOf(msVar.wce), msVar.wcg, msVar.npV, msVar.npW, bi.chl());
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
            ms msVar = (ms) ((b) qVar).hnQ.hnY;
            mt mtVar = (mt) ((b) qVar).hnR.hnY;
            x.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", mtVar.hxh, Integer.valueOf(mtVar.wch), mtVar.wci, mtVar.wcj);
            if (this.vln != null) {
                this.vln.a(msVar.wcf, msVar.vXE, mtVar.hxh, mtVar.wci, mtVar.wcj, msVar.wce);
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
        if (this.vln != null) {
            this.vln.a("", "", "", "", "", 0);
        }
    }
}
