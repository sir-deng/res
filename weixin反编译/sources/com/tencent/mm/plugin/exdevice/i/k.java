package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class k extends ae implements e {
    private int lEp = -1;
    private String lRC = null;
    private String lRD = null;
    private String lWS = null;

    public k(String str, String str2, String str3, int i) {
        this.lRC = str;
        this.lWS = str2;
        this.lRD = str3;
        this.lEp = i;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        as.CN().b(1090, (e) this);
    }

    public final boolean a(m mVar, d dVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "excute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lRC + ",deviceType=" + this.lWS + ",deviceId=" + this.lRD + ",reqType=" + this.lEp);
        as.CN().a(1090, (e) this);
        as.CN().a(new s(this.lRC, this.lWS, this.lRD, this.lEp), 0);
        return false;
    }
}
