package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;

    public c(String str, String str2) {
        this(str, 18, 5, str2, 2, -1);
    }

    public c(String str, int i, int i2, String str2, int i3, long j) {
        this(str, i, i2, str2, i3, "", j);
    }

    public c(String str, int i, int i2, String str2, int i3, String str3) {
        this(str, i, i2, str2, i3, 0, 0, "", str3);
    }

    private c(String str, int i, int i2, String str2, int i3, String str3, long j) {
        this(str, i, i2, str2, i3, 0, str3, n.qWH.eo(j), 0);
    }

    private c(String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, int i6) {
        a aVar = new a();
        aVar.hnT = new ba();
        aVar.hnU = new bb();
        if (i5 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
            aVar.hnS = 1232;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adclick";
            aVar.hnS = 1817;
        }
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneAdClick", "uri %s", this.gLB.uri);
        x.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + i + " viewId: " + str + " sceneType: " + i2 + " adtype " + i3 + ", clickAction " + i4 + ",source " + i5 + ", descXml " + str2);
        if (!bi.oN(str2)) {
            x.i("MicroMsg.NetSceneAdClick", "descXml: " + str2);
        }
        ba baVar = (ba) this.gLB.hnQ.hnY;
        baVar.hQl = i;
        baVar.hQh = str;
        baVar.scene = i2;
        baVar.vMR = str2;
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                baVar.bssid = bi.aD(connectionInfo.getBSSID(), "");
                baVar.ssid = bi.aD(connectionInfo.getSSID(), "");
            }
        }
        baVar.vMS = System.currentTimeMillis();
        baVar.vMU = i3;
        baVar.vMV = i4;
        baVar.cPf = i5;
        baVar.vMW = str3;
        baVar.vMX = i6;
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, int i5, String str3, String str4) {
        this(str, i, i2, str2, i3, i4, str3, str4, 0);
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, int i5) {
        this(str, i, i2, str2, i3, i4, str3, n.qWH.Kg(str4), i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
