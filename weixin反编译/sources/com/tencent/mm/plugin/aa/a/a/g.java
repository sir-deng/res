package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private e gLE;
    private b hPx;
    private h ijr;
    public i ijs;

    public g(String str, long j, List<j> list, int i, String str2, long j2) {
        a aVar = new a();
        aVar.hnT = new h();
        aVar.hnU = new i();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.ijr = (h) this.hPx.hnQ.hnY;
        this.hPx.hoh = true;
        try {
            this.ijr.title = p.encode(str, "UTF-8");
            this.ijr.vJR = j;
            this.ijr.vJN = new LinkedList();
            this.ijr.vJN.addAll(list);
            this.ijr.scene = i;
            this.ijr.vJJ = str2;
            this.ijr.vJO = com.tencent.mm.plugin.wallet_core.model.i.bLR();
            this.ijr.vJP = j2;
            x.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", this.ijr.vJO);
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", e.getMessage());
        }
        this.chatroomName = str2;
        x.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", this.ijr.title, Long.valueOf(this.ijr.vJR), this.ijr.vJN, Integer.valueOf(this.ijr.scene), this.ijr.vJJ, Long.valueOf(this.ijr.vJP));
    }

    public final int getType() {
        return 1655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ijs = (i) ((b) qVar).hnR.hnY;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.ijs.lot);
        objArr[1] = this.ijs.lou;
        objArr[2] = this.ijs.vJI;
        objArr[3] = Boolean.valueOf(this.ijs.vJK == null);
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", this.ijs.vJK);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
