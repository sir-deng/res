package com.tencent.mm.plugin.w;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.g;

public final class d extends k implements com.tencent.mm.network.k {
    private String aeskey;
    private String fAM;
    private String gAM;
    private b gLB;
    private e gLE;
    private int oLb;

    public d(String str, String str2, int i, String str3) {
        this.fAM = str;
        this.aeskey = str2;
        this.oLb = i;
        this.gAM = str3;
        a aVar = new a();
        aVar.hnT = new bgv();
        aVar.hnU = new bgw();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        this.gLB = aVar.Kf();
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene fileId[%s], fileLen[%d], selfName[%s], stack[%s]", str, Integer.valueOf(i), str3, bi.chl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        g.a aVar = new g.a();
        aVar.title = "PCSYNC";
        aVar.description = "ANDROID_PCSYNC";
        aVar.type = 35;
        aVar.url = this.fAM;
        aVar.hda = this.aeskey;
        aVar.hcM = this.oLb;
        aVar.hdb = this.aeskey;
        aVar.showType = 0;
        bgv bgv = (bgv) this.gLB.hnQ.hnY;
        db dbVar = new db();
        dbVar.npW = this.gAM;
        dbVar.vOK = aVar.sdkVer;
        dbVar.kzz = 35;
        dbVar.npV = this.gAM;
        dbVar.noL = g.a.a(aVar, null, null, 0, 0);
        dbVar.pgR = (int) bi.Wx();
        bgv.wSn = dbVar;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 222;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }
}
