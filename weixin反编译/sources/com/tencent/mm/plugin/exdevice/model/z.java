package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class z extends k implements com.tencent.mm.network.k {
    private e gQm = null;
    b lSH = null;
    private String lST = "";

    public z(LinkedList<adc> linkedList, String str, String str2) {
        this.lST = str2;
        a aVar = new a();
        aVar.hnT = new add();
        aVar.hnU = new ade();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.hnS = 543;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        add add = (add) this.lSH.hnQ.hnY;
        if (!bi.oN(str)) {
            adb adb = new adb();
            adb.vSi = str;
            add.wsx = adb;
        }
        add.wsw = linkedList;
    }

    public final int getType() {
        return 543;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
    }
}
