package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private a vlo;

    public interface a {
        void S(String str, int i, int i2);
    }

    public aa(String str, String str2, String str3, int i, a aVar) {
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new nl();
        aVar2.hnU = new nm();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        this.gLB = aVar2.Kf();
        nl nlVar = (nl) this.gLB.hnQ.hnY;
        nlVar.fileid = str;
        nlVar.frM = str2;
        nlVar.wdb = str3;
        nlVar.wdc = i;
        this.vlo = aVar;
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", nlVar.fileid, nlVar.frM, nlVar.wdb, Integer.valueOf(nlVar.wdc), bi.chl());
    }

    public final int getType() {
        return 939;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
        if (this.vlo != null) {
            a aVar;
            String str2;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                nm nmVar = (nm) ((b) qVar).hnR.hnY;
                aVar = this.vlo;
                if (nmVar != null) {
                    str2 = nmVar.aeskey;
                    aVar.S(str2, i2, i3);
                }
                aVar2 = aVar;
            } else {
                aVar2 = this.vlo;
            }
            aVar = aVar2;
            str2 = "";
            aVar.S(str2, i2, i3);
        }
    }
}
