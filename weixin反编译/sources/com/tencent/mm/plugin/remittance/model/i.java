package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

public final class i extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public ja pQf;

    public i(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6, int i4, int i5, String str7, wd wdVar, String str8, int i6) {
        a aVar = new a();
        aVar.hnT = new iz();
        aVar.hnU = new ja();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.hnV = 0;
        aVar.hnW = 0;
        c bDz = com.tencent.mm.plugin.soter.c.b.bDz();
        String str9 = bDz.rYp;
        String str10 = bDz.rYq;
        this.hPx = aVar.Kf();
        iz izVar = (iz) this.hPx.hnQ.hnY;
        izVar.pQZ = str;
        izVar.vVN = URLDecoder.decode(str2);
        izVar.scene = i;
        izVar.vVO = str3;
        izVar.pQT = str4;
        izVar.vOl = i2;
        izVar.fDM = i3;
        izVar.pQU = str5;
        izVar.pRa = str6;
        izVar.pQY = i4;
        izVar.vOk = str7;
        if (wdVar != null) {
            izVar.vOj = wdVar;
        }
        izVar.vVH = str8;
        izVar.pPM = i6;
        if (i5 == 1) {
            WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
            if (wifiInfo != null) {
                izVar.vVP = wifiInfo.getBSSID();
            } else {
                x.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            izVar.vVQ = 0;
        }
        izVar.rYp = str9;
        izVar.rYq = str10;
        izVar.vVS = o.bMc().bMA();
        g.h(l.class);
        izVar.vVR = false;
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), str2, Integer.valueOf(i5), a.a(wdVar));
    }

    public final int getType() {
        return 1633;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pQf = (ja) ((b) qVar).hnR.hnY;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("trans_id: %s,", new Object[]{this.pQf.vOh}));
        stringBuffer.append(String.format("zero_pay_flag: %s,", new Object[]{Integer.valueOf(this.pQf.vVY)}));
        stringBuffer.append(String.format("can_use_fingerprint: %s,", new Object[]{Integer.valueOf(this.pQf.vWe)}));
        stringBuffer.append(String.format("payer_need_auth_flag: %s,", new Object[]{Integer.valueOf(this.pQf.vVZ)}));
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", Integer.valueOf(this.pQf.kRz), this.pQf.kRA, this.pQf.vOh, this.pQf.vOg, Integer.valueOf(this.pQf.vVX), this.pQf.vOi, this.pQf.fxT, stringBuffer.toString());
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
