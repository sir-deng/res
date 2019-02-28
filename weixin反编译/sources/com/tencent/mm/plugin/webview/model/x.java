package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.btl;

public final class x extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b hGV;

    public x(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new btk();
        aVar.hnU = new btl();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        this.hGV = aVar.Kf();
        btk btk = (btk) this.hGV.hnQ.hnY;
        btk.nlE = str;
        btk.fGh = str2;
        btk.fsK = str3;
    }

    public final int getType() {
        return 1702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.gLE.a(i2, i3, str, this);
    }
}
