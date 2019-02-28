package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.sdk.platformtools.x;

public final class aj extends w {
    public int cmdId;
    private String vlI;

    public aj(String str, int i, String str2) {
        a aVar = new a();
        aVar.hnT = new bif();
        aVar.hnU = new big();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        this.lSH = aVar.Kf();
        bif bif = (bif) this.lSH.hnQ.hnY;
        bif.nkU = str;
        bif.wSP = i;
        bif.wSQ = str2;
        this.cmdId = i;
        this.vlI = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            big big = (big) this.lSH.hnR.hnY;
            if (big != null) {
                i biW = com.tencent.mm.plugin.y.a.a.a.biY().biW();
                f aZ = g.aZ(big.nkU, false);
                if (aZ != null) {
                    aZ.field_authFlag = big.vPc;
                    x.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + biW.a(aZ, new String[0]) + ", appId = " + big.nkU);
                }
            }
        }
    }

    public final byte[] aRE() {
        try {
            return ((b) this.lSH.Kh()).Hw();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void az(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            return;
        }
        try {
            this.lSH.hnR.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 2;
    }
}
