package com.tencent.mm.plugin.sns.a.b;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;

    public d(String str, int i, bh bhVar, int i2, int i3, int i4) {
        this(str, i, 1, 0, null, bhVar, i2, "", i3, i4, 0, 0, 0);
    }

    public d(String str, int i, int i2, int i3, be beVar, bh bhVar, int i4, String str2, int i5, int i6, int i7, int i8, int i9) {
        a aVar = new a();
        aVar.hnT = new bf();
        aVar.hnU = new bg();
        if (i6 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            aVar.hnS = 1231;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adexposure";
            aVar.hnS = 1875;
        }
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneAdExposure", "uri %s", this.gLB.uri);
        bf bfVar = (bf) this.gLB.hnQ.hnY;
        bfVar.vNg = i3;
        bfVar.type = i2;
        bfVar.scene = i;
        bfVar.hQh = str;
        bfVar.vNj = i5;
        bfVar.vNk = i7;
        bfVar.vNl = i8;
        bfVar.vMX = i9;
        if (beVar != null) {
            bfVar.vNh = beVar;
            x.i("MicroMsg.NetSceneAdExposure", "exposure_info " + beVar.vNe);
        }
        if (bhVar != null) {
            bfVar.vNi = bhVar;
            x.i("MicroMsg.NetSceneAdExposure", "social_info " + bhVar.vNm + " " + bhVar.csY);
        }
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                bfVar.bssid = bi.aD(connectionInfo.getBSSID(), "");
                bfVar.ssid = bi.aD(connectionInfo.getSSID(), "");
            }
        }
        bfVar.vMS = System.currentTimeMillis();
        bfVar.vMU = i4;
        if (str2 != null) {
            bfVar.vMR = str2;
        }
        x.i("MicroMsg.NetSceneAdExposure", "##time viewid " + str + " sceneType " + i + " type: " + i2 + " duration " + i3 + "feed_duration " + i7 + "feed_full_duration " + i8 + " ad_type " + i4 + " exposureCount " + i5 + " descXml:" + str2 + " flip_status " + i9);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bg bgVar = (bg) this.gLB.hnR.hnY;
        x.i("MicroMsg.NetSceneAdExposure", "resp " + bgVar.ret + " msg: " + bgVar.fpV);
        this.gLE.a(i2, i3, str, this);
    }
}
