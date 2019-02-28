package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public String mFileName = "";

    public r(String str, long j, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hnT = new us();
        aVar.hnU = new ut();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.hnS = 1197;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.mFileName = str;
        us usVar = (us) this.gLB.hnQ.hnY;
        usVar.fGh = str2;
        usVar.wjo = j;
        usVar.wjp = str4;
        usVar.wjt = str3;
    }

    public final int getType() {
        return 1197;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
