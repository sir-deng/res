package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private e gLE;
    private b hPx;
    private com.tencent.mm.protocal.c.f ijp;
    public g ijq;

    public f(long j, String str, List<String> list, int i, long j2, String str2) {
        a aVar = new a();
        aVar.hnT = new com.tencent.mm.protocal.c.f();
        aVar.hnU = new g();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.chatroomName = str2;
        this.hPx = aVar.Kf();
        this.ijp = (com.tencent.mm.protocal.c.f) this.hPx.hnQ.hnY;
        this.hPx.hoh = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.ijp.vJL = list.size();
                    this.ijp.vJM = j;
                    this.ijp.title = URLEncoder.encode(str, "UTF-8");
                    this.ijp.vJN = new LinkedList();
                    this.ijp.vJN.addAll(list);
                    this.ijp.scene = i;
                    this.ijp.vJJ = str2;
                    this.ijp.vJO = i.bLR();
                    this.ijp.vJP = j2;
                    x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.ijp.vJO);
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
            }
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", Integer.valueOf(this.ijp.vJL), Long.valueOf(this.ijp.vJM), this.ijp.title, this.ijp.vJN, Integer.valueOf(this.ijp.scene), this.ijp.vJJ, Long.valueOf(this.ijp.vJP));
    }

    public f(long j, String str, int i, int i2, long j2, String str2) {
        a aVar = new a();
        aVar.hnT = new com.tencent.mm.protocal.c.f();
        aVar.hnU = new g();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.ijp = (com.tencent.mm.protocal.c.f) this.hPx.hnQ.hnY;
        this.chatroomName = str2;
        try {
            this.ijp.vJL = i;
            this.ijp.vJM = j;
            this.ijp.title = URLEncoder.encode(str, "UTF-8");
            this.ijp.vJN = new LinkedList();
            this.ijp.scene = i2;
            this.ijp.vJJ = str2;
            this.ijp.vJO = i.bLR();
            x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.ijp.vJO);
            this.ijp.vJP = j2;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", Integer.valueOf(this.ijp.vJL), Long.valueOf(this.ijp.vJM), this.ijp.title, this.ijp.vJN, Integer.valueOf(this.ijp.scene), this.ijp.vJJ, Long.valueOf(this.ijp.vJP));
    }

    public final int getType() {
        return 1624;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ijq = (g) ((b) qVar).hnR.hnY;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.ijq.lot);
        objArr[1] = this.ijq.lou;
        objArr[2] = Boolean.valueOf(this.ijq.vJK == null);
        objArr[3] = this.ijq.vJI;
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", this.ijq.vJK);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
