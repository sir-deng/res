package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b hGV;

    public h(List<alg> list, String str) {
        a aVar = new a();
        aVar.hnT = new zg();
        aVar.hnU = new zh();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        this.hGV = aVar.Kf();
        zg zgVar = (zg) this.hGV.hnQ.hnY;
        zgVar.wpV.addAll(list);
        zgVar.fGh = str;
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", Integer.valueOf(zgVar.wpV.size()));
    }

    public final int getType() {
        return 1704;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.gLE.a(i2, i3, str, this);
    }
}
