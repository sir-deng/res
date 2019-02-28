package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.TimeZone;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    private bro rZW;

    public f(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        int i5;
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a aVar = new a();
        aVar.hnT = new bro();
        aVar.hnU = new brp();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.hnS = 1261;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.rZW = (bro) this.gLB.hnQ.hnY;
        this.rZW.ffG = str;
        this.rZW.fsb = str2;
        this.rZW.wZz = i;
        this.rZW.wZA = i2;
        this.rZW.blZ = i3;
        bro bro = this.rZW;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        bro.wZB = String.valueOf(i5 + (rawOffset / 3600));
        this.rZW.wZD = str3;
        this.rZW.wZG = i4;
    }

    public final int getType() {
        return 1261;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
