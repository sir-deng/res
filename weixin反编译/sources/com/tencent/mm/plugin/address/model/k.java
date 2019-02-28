package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.f.a.mh;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class k extends c<mh> implements e {
    private mh ior;
    private d ios;

    public k() {
        this.xmG = mh.class.getName().hashCode();
    }

    private boolean a(mh mhVar) {
        if (mhVar instanceof mh) {
            this.ior = mhVar;
            as.CN().a(417, (e) this);
            as.CN().a(new e(this.ior.fEO.url, this.ior.fEO.appId, 1), 0);
        }
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
        if (!(kVar instanceof e)) {
            return;
        }
        if (i2 == 0) {
            u(i2, true);
        } else {
            u(i2, false);
        }
    }

    private void u(int i, boolean z) {
        x.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", Integer.valueOf(i), Boolean.valueOf(z));
        this.ior.fEP.errCode = i;
        d dVar;
        if (i != 0) {
            this.ior.fEP.fEQ = false;
        } else if (z) {
            dVar = this.ios;
            if (dVar != null) {
                dVar.field_brandFlag |= 8;
                f.g(dVar);
            }
            this.ior.fEP.fEQ = true;
            a.XN();
            com.tencent.mm.plugin.address.d.a aVar = a.XP().iov;
            if (aVar.ioD.size() > 0) {
                b bVar = (b) aVar.ioD.getFirst();
                this.ior.fEP.fER = bVar.ioM;
                this.ior.fEP.userName = bVar.ioK;
                this.ior.fEP.fES = bVar.ioL;
                this.ior.fEP.fET = bVar.ioI;
                this.ior.fEP.fEU = bVar.ioF;
                this.ior.fEP.fEV = bVar.ioG;
                this.ior.fEP.fEW = bVar.ioH;
                this.ior.fEP.fEX = bVar.ioJ;
            }
        } else {
            dVar = this.ios;
            if (dVar != null) {
                dVar.field_brandFlag &= -9;
                f.g(dVar);
            }
            this.ior.fEP.fEQ = false;
        }
        if (this.ior.frD != null) {
            this.ior.frD.run();
        }
        as.CN().b(417, (e) this);
    }
}
