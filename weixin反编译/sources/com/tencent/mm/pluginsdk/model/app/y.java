package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class y extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private final b vlm;

    public y(b bVar, String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hnT = new mq();
        aVar.hnU = new mr();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        this.gLB = aVar.Kf();
        this.vlm = bVar;
        mq mqVar = (mq) this.gLB.hnQ.hnY;
        mqVar.vXE = str;
        mqVar.wce = bVar.field_totalLen;
        mqVar.wcf = str2;
        mqVar.hLi = str3;
        mqVar.wcg = str4;
        mqVar.npW = str5;
        as.Hm();
        mqVar.npV = (String) c.Db().get(2, (Object) "");
        mqVar.vPv = com.tencent.mm.modelcdntran.b.htw;
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", bi.Wz(mqVar.vXE), mqVar.wcf, mqVar.hLi, mqVar.wcg, Long.valueOf(mqVar.wce), Integer.valueOf(mqVar.vPv), bi.chl());
    }

    public final int getType() {
        return 728;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            mr mrVar = (mr) ((b) qVar).hnR.hnY;
            this.vlm.field_signature = mrVar.hxh;
            this.vlm.field_fakeAeskey = mrVar.wci;
            this.vlm.field_fakeSignature = mrVar.wcj;
            boolean c = an.aqK().c(this.vlm, new String[0]);
            x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", bi.Wz(this.vlm.field_signature), bi.Wz(this.vlm.field_fakeAeskey), bi.Wz(this.vlm.field_fakeSignature), Boolean.valueOf(c));
        }
        this.gLE.a(i2, i3, str, this);
    }
}
