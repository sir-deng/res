package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.plugin.facedetect.b.k.b;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends p implements k, e {
    private final q hoZ = new g();
    private boolean mkY = false;
    private String mld = "";

    public final boolean aGO() {
        return true;
    }

    public final String aGP() {
        return this.mld;
    }

    public t(long j, String str, String str2) {
        a aVar = (a) this.hoZ.Kh();
        aVar.mkT.wqc = p.mle;
        aVar.mkT.wqd = j;
        aVar.mkT.wPE = str2;
        aVar.mkT.wPD = str;
    }

    final int g(e eVar) {
        this.hoZ.Kh();
        return a(eVar, this.hoZ, this);
    }

    protected final int Bo() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 930;
    }

    public final void c(int i, int i2, String str, q qVar) {
        boolean z = true;
        x.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        b bVar = (b) qVar.Hv();
        if (i == 0 && i2 == 0) {
            this.mkY = bVar.mkU.wPG == 0;
            this.mld = bVar.mkU.wPF;
            String str2 = "MicroMsg.NetSceneFaceVerifyFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.mkY);
            objArr[1] = Integer.valueOf(bVar.mkU.wPG);
            if (bi.oN(this.mld)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
            i2 = bVar.mkU.wPG;
        } else if (!(bVar == null || bVar.mkU == null || bVar.mkU.wPG == 0)) {
            x.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i2 = bVar.mkU.wPG;
        }
        this.gLE.a(i, i2, str, this);
    }

    final void An(String str) {
        ((a) this.hoZ.Kh()).mkT.wqc = str;
    }

    protected final atl g(q qVar) {
        return ((b) qVar.Hv()).mkU.wqf;
    }
}
