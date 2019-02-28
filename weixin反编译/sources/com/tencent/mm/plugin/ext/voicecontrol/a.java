package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public String appId;
    public int fvo = 1;
    b gLB;
    private e gLE;
    public int hmZ;
    public int hna;
    public com.tencent.mm.bp.b mhA;
    public String mhB;
    public dm mhC;
    public dg mhD;
    int mhE = 5000;
    long mhF = 0;
    public int mhz;
    public int vo;

    public a(int i, String str, int i2, String str2, dm dmVar) {
        boolean z = true;
        this.appId = str;
        this.mhz = i;
        this.vo = 1;
        this.hmZ = i2;
        this.mhC = dmVar;
        this.mhD = null;
        this.mhB = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (dmVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(false);
        x.i(str3, str4, objArr);
    }

    public a(int i, String str, dg dgVar, long j) {
        this.appId = str;
        this.mhz = i;
        this.vo = 1;
        this.mhC = null;
        this.mhD = dgVar;
        this.mhF = j;
        x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0 && qVar != null) {
            x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        }
    }

    public final int getType() {
        return 985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.hnT = new dh();
        aVar.hnU = new di();
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        dh dhVar = (dh) this.gLB.hnQ.hnY;
        dhVar.vKI = this.fvo;
        dhVar.nlV = this.appId;
        dhVar.vPe = this.mhz;
        dhVar.vPf = this.vo;
        dhVar.vPg = this.mhC;
        dhVar.vPh = this.mhD;
        return a(eVar, this.gLB, this);
    }
}
