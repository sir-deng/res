package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;
    Map<String, String> htg = new HashMap();

    public r(LinkedList<ip> linkedList, Object obj) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ip ipVar = (ip) it.next();
            LinkedList linkedList2 = ipVar.vVu;
            String str = ipVar.vUh;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.htg.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.hnT = new zs();
        aVar.hnU = new zt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.hnS = 1353;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((zs) this.gLB.hnQ.hnY).wqj = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1353;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
