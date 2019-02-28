package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.j;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final q hoZ = new j();

    public final int getType() {
        return 381;
    }

    public final boolean Km() {
        return false;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }
}
