package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bhb;
import com.tencent.mm.protocal.c.bhc;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private e gQm = null;
    public b lSH = null;
    String lSQ;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i));
        this.lSQ = str2;
        a aVar = new a();
        aVar.hnT = new bhb();
        aVar.hnU = new bhc();
        aVar.hnS = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        bhb bhb = (bhb) this.lSH.hnQ.hnY;
        ake ake = new ake();
        ake.vQr = str;
        ake.kyJ = str2;
        bhb.vSI = ake;
        aki aki = new aki();
        aki.wym = j2;
        aki.pgR = (int) j3;
        aki.vQW = new bes().bl(bArr);
        aki.kzz = i;
        bhb.wSt = aki;
        if (j != 0) {
            bhb.wyh = new bes().bl(u.aFs().m(j, 2));
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b zM = ad.aER().zM(str2);
        if (zM != null) {
            bhb.wyh = new bes().bl(zM.field_sessionBuf);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 538;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.lSH, this);
    }
}
