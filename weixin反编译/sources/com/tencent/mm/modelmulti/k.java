package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private e gLE;
    private WakerLock gzE = new WakerLock(ad.getContext());
    private final q hoZ;

    public static class a extends i {
        private final com.tencent.mm.protocal.aa.a hHw = new com.tencent.mm.protocal.aa.a();
        private final b hHx = new b();

        protected final d Hu() {
            return this.hHw;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hHx;
        }

        public final int getType() {
            return 39;
        }

        public final String getUri() {
            return null;
        }

        public final int Ke() {
            return 1;
        }
    }

    public k() {
        this.gzE.lock(3000, "NetSceneSynCheck");
        this.hoZ = new a();
        g.Dr();
        if (g.Dq() != null) {
            g.Dr();
            if (g.Dq().Db() != null) {
                g.Dr();
                com.tencent.mm.protocal.aa.a aVar = (com.tencent.mm.protocal.aa.a) this.hoZ.Kh();
                aVar.hHj = bi.Wj((String) g.Dq().Db().get(8195, null));
                com.tencent.mm.protocal.aa.a aVar2 = (com.tencent.mm.protocal.aa.a) this.hoZ.Kh();
                g.Dr();
                g.Do();
                aVar2.uin = com.tencent.mm.kernel.a.Cn();
                ((com.tencent.mm.protocal.aa.a) this.hoZ.Kh()).netType = com.tencent.mm.protocal.a.getNetType(ad.getContext());
                ((com.tencent.mm.protocal.aa.a) this.hoZ.Kh()).vIe = com.tencent.mm.protocal.a.ced();
                x.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                return;
            }
        }
        x.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        int a = a(eVar, this.hoZ, this);
        if (a == -1 && this.gzE.isLocking()) {
            this.gzE.unLock();
        }
        return a;
    }

    public final boolean Kj() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        b bVar = (b) qVar.Hv();
        x.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.vII);
        if (g.Do().CF() && !com.tencent.mm.kernel.a.Cz()) {
            byte[] bArr2 = ((com.tencent.mm.protocal.aa.a) qVar.Kh()).gRB;
            if (bi.by(bArr2)) {
                x.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.gRB = bArr2;
            ((com.tencent.mm.plugin.zero.b.b) g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a(bVar.vII, 2, bVar.cex());
        }
        this.gLE.a(i2, i3, str, this);
        this.gzE.unLock();
    }
}
