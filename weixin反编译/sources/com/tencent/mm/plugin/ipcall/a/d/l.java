package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE;
    private azr nLs = null;
    private azs nLt = null;

    public l(int i, long j, boolean z) {
        a aVar = new a();
        aVar.hnT = new azr();
        aVar.hnU = new azs();
        aVar.hnS = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLs = (azr) this.gLB.hnQ.hnY;
        this.nLs.wil = i;
        this.nLs.wMU = j;
        this.nLs.wNn = z ? 1 : 0;
        x.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", Integer.valueOf(this.nLs.wil), Long.valueOf(this.nLs.wMU), Integer.valueOf(this.nLs.wNn));
        azr azr = this.nLs;
        com.tencent.mm.plugin.ipcall.a.c.b aUg = i.aUg();
        x.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", aUg.nJe + "," + aUg.nJf + "," + aUg.nKE + "," + aUg.int + "," + aUg.nKF + "," + aUg.nKu + "," + aUg.nKv + "," + aUg.nKw + "," + aUg.nKx + "," + aUg.nKy + "," + aUg.nKz + "," + aUg.nKA + "," + aUg.nKB + "," + aUg.nKC + "," + aUg.nKD + "," + aUg.nKG + "," + c.aVt() + "," + aUg.nKP + "," + aUg.countryCode + "," + aUg.nKQ + "," + aUg.nKR + "," + aUg.nKS + aUg.nKN + "," + aUg.nKU);
        azr.wNk = n.oK(r3);
        azr = this.nLs;
        aUg = i.aUg();
        x.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", aUg.nJe + "," + aUg.nJf + "," + aUg.nKE + aUg.nKM);
        azr.wNl = n.oK(r3);
        azr = this.nLs;
        aUg = i.aUg();
        x.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", aUg.nJe + "," + aUg.nJf + "," + aUg.nKE + aUg.nKL);
        azr.wNm = n.oK(r3);
    }

    public final int getType() {
        return GameJsApiGetOpenDeviceId.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLt = (azs) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
