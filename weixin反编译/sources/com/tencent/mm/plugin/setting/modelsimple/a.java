package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gLE;
    private List<String> mgp;

    public a(List<String> list) {
        this.mgp = list;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hom = i;
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a cbVar = new cb();
        Collection arrayList = new ArrayList();
        if (this.mgp != null) {
            for (int i = 0; i < this.mgp.size(); i++) {
                bqe bqe = new bqe();
                bqe.kyG = (String) this.mgp.get(i);
                arrayList.add(bqe);
            }
        }
        cbVar.vOa.addAll(arrayList);
        aVar.hnT = cbVar;
        aVar.hnU = new cc();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.hnS = 583;
        aVar.hnV = 0;
        aVar.hnV = 0;
        return a(eVar, aVar.Kf(), this);
    }
}
