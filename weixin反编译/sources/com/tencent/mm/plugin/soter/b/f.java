package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements e, com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    private q hoZ;
    private b<e.b> mFx = null;

    public final /* synthetic */ void br(Object obj) {
        a aVar = (a) obj;
        this.hoZ = new b();
        c.a aVar2 = (c.a) this.hoZ.Kh();
        aVar2.rYg.wZs = aVar.Amd;
        aVar2.rYg.wZt = aVar.Amc;
    }

    protected final int Bo() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final int getType() {
        return 627;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.mFx != null) {
                this.mFx.cz(new e.b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.mFx != null) {
            this.mFx.cz(new e.b(false));
        }
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        g.CN().a((k) this, 0);
    }

    public final void a(b<e.b> bVar) {
        this.mFx = bVar;
    }
}
