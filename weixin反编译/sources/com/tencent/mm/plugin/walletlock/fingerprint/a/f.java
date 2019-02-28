package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public final int getType() {
        return 1967;
    }

    public f(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new avw();
        aVar.hnU = new avx();
        aVar.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        this.gLB = aVar.Kf();
        avw avw = (avw) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", str, str2, str3);
        avw.wKi = str;
        avw.signature = str2;
        avw.sOX = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
