package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    public final b hGV;

    public e(List<alg> list, long j, ali ali) {
        a aVar = new a();
        aVar.hnT = new zi();
        aVar.hnU = new zj();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        this.hGV = aVar.Kf();
        zi ziVar = (zi) this.hGV.hnQ.hnY;
        ziVar.wpV.addAll(list);
        ziVar.wpY = j;
        ziVar.wpX = ali;
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(ziVar.wpV.size()));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
        zi ziVar = (zi) this.hGV.hnQ.hnY;
        alg alg = (alg) ziVar.wpV.get(0);
        ali ali = ziVar.wpX;
        zj zjVar = (zj) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            if (zjVar.result != 0) {
                g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), alg.njL, Integer.valueOf(alg.major), Integer.valueOf(alg.minor), String.valueOf(ali.latitude), String.valueOf(ali.longitude), Integer.valueOf(2), Integer.valueOf(zjVar.result));
            }
            x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            return;
        }
        g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), alg.njL, Integer.valueOf(alg.major), Integer.valueOf(alg.minor), String.valueOf(ali.latitude), String.valueOf(ali.longitude), Integer.valueOf(1), Integer.valueOf(zjVar.result));
        x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    }

    public final int getType() {
        return 1708;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }
}
