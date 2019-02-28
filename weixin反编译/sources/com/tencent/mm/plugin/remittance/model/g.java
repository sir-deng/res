package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    iv pPW;
    public iw pPX;
    public c pPY;
    public d pPZ;
    public boolean pQa = false;
    public String pQb = "";
    public boolean pQc = false;
    public int pQd = 0;

    public g(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, c cVar, d dVar) {
        this.pQb = System.currentTimeMillis() + i;
        a aVar = new a();
        this.pQd = i;
        aVar.hnT = new iv();
        aVar.hnU = new iw();
        aVar.hnS = 2677;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.pPW = (iv) this.hPx.hnQ.hnY;
        this.pPW.oeK = i;
        this.pPW.fDM = i2;
        this.pPW.pPM = i3;
        this.pPW.vVJ = str;
        this.pPW.pQW = str2;
        this.pPW.pPN = str3;
        this.pPW.pQZ = str4;
        this.pPW.vOk = str5;
        this.pPW.pPO = str6;
        this.pPW.vVK = i4;
        this.pPY = cVar;
        this.pPZ = dVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", new Object[]{Integer.valueOf(this.pPW.oeK)}));
        stringBuffer.append(String.format("request.channel %s", new Object[]{Integer.valueOf(this.pPW.fDM)}));
        stringBuffer.append(String.format("request.scan_scene %s", new Object[]{Integer.valueOf(this.pPW.pPM)}));
        stringBuffer.append(String.format("request.receiver_desc %s", new Object[]{this.pPW.vVJ}));
        stringBuffer.append(String.format("request.mch_name %s", new Object[]{this.pPW.pQW}));
        stringBuffer.append(String.format("request.favor_req_sign %s", new Object[]{this.pPW.pPN}));
        stringBuffer.append(String.format("request.receiver_openid %s", new Object[]{this.pPW.pQZ}));
        stringBuffer.append(String.format("request.receiver_username %s", new Object[]{this.pPW.vOk}));
        stringBuffer.append(String.format("request.favor_req_extend %s", new Object[]{this.pPW.pPO}));
        stringBuffer.append(String.format("request.fail_click_cell %s", new Object[]{Integer.valueOf(this.pPW.vVK)}));
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", stringBuffer.toString());
    }

    public final int getType() {
        return 2677;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPX = (iw) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", Integer.valueOf(this.pPX.kRz), this.pPX.kRA, a.a(this.pPX.pPQ));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
