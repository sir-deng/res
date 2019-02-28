package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public k(List<b> list) {
        a aVar = new a();
        aVar.hnT = new bid();
        aVar.hnU = new bie();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        this.gLB = aVar.Kf();
        bid bid = (bid) this.gLB.hnQ.hnY;
        LinkedList linkedList = new LinkedList();
        for (b bVar : list) {
            ah ahVar = new ah();
            ahVar.kyG = bVar.userName;
            linkedList.add(ahVar);
        }
        bid.kyA = linkedList.size();
        bid.kyB = linkedList;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", Integer.valueOf(linkedList.size()), linkedList.toString());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", Integer.valueOf(((bie) this.gLB.hnR.hnY).wpk));
            com.tencent.mm.plugin.brandservice.a.f(196610, Integer.valueOf(r0.wpk));
            com.tencent.mm.plugin.brandservice.a.f(196611, Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.brandservice.a.f(196611, Boolean.valueOf(true));
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 386;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
