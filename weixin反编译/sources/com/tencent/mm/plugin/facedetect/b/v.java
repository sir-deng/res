package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends p implements k, b {
    private final q hoZ = new h();
    private long mlj = -1;
    private byte[] mlk = null;

    public final long aGM() {
        return this.mlj;
    }

    public final byte[] aGN() {
        return this.mlk;
    }

    public v(int i) {
        a aVar = (a) this.hoZ.Kh();
        aVar.mkP.wqc = p.mle;
        aVar.mkP.kzz = 1;
        aVar.mkP.sfa = i;
    }

    final int g(e eVar) {
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
        return 733;
    }

    public final void c(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            b bVar = (b) qVar.Hv();
            this.mlj = bVar.mkQ.wqd;
            if (bVar.mkQ.wqe != null) {
                this.mlk = bVar.mkQ.wqe.oz;
            }
            if (bVar.mkQ.wqg != null) {
                byte[] bArr;
                byte[] bArr2;
                if (bVar.mkQ.wqg.vZK == null || bVar.mkQ.wqg.vZK.wRk <= 0) {
                    bArr = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(bVar.mkQ.wqg.vZK.wRk));
                    bArr = n.a(bVar.mkQ.wqg.vZK);
                }
                if (bVar.mkQ.wqg.vZL == null || bVar.mkQ.wqg.vZL.wRk <= 0) {
                    bArr2 = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(bVar.mkQ.wqg.vZL.wRk));
                    bArr2 = n.a(bVar.mkQ.wqg.vZL);
                }
                g.MQ().a(bVar.mkQ.wqg.vZH, bVar.mkQ.wqg.vZI, bVar.mkQ.wqg.vZJ, bArr, bArr2, bVar.mkQ.wqg.vZM);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.mlj);
            objArr[1] = Integer.valueOf(this.mlk == null ? 0 : this.mlk.length);
            x.i(str2, str3, objArr);
        }
        this.gLE.a(i, i2, str, this);
    }

    final void An(String str) {
        ((a) this.hoZ.Kh()).mkP.wqc = str;
    }

    protected final atl g(q qVar) {
        return ((b) qVar.Hv()).mkQ.wqf;
    }
}
