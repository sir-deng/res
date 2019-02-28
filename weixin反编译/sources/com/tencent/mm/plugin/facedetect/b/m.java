package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k, e {
    private b gLB;
    private e gLE;
    private boolean mkY = false;
    public String mkZ = null;
    public boolean mla = false;
    private String mlb = "";

    public m(long j, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hnT = new uq();
        aVar.hnU = new ur();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.hnS = 1080;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        uq uqVar = (uq) this.gLB.hnQ.hnY;
        uqVar.fGh = str;
        uqVar.wjo = j;
        uqVar.wjj = str2;
        uqVar.wjq = str3;
        uqVar.wjp = str4;
    }

    public final int getType() {
        return 1080;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        ur urVar = (ur) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", urVar.wjr);
        this.mkZ = urVar.wjr;
        this.mla = urVar.wjs;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final String aGP() {
        return this.mkZ;
    }

    public final boolean aGO() {
        return this.mla;
    }
}
