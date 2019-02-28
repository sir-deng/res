package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.aaf;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e extends k implements com.tencent.mm.network.k {
    public static long huC = 0;
    private static Map<String, a> huD = new HashMap();
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    private String huE = "";
    int scene = 0;
    public long startTime = 0;

    static class a {
        boolean huF = false;
        long huG = 0;
        long huH = 0;
        long huI = 0;

        a() {
        }

        public final String toString() {
            return String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.huF), Long.valueOf(this.huG), Long.valueOf(this.huH), Long.valueOf(this.huI)});
        }
    }

    protected e(int i) {
        x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i), bi.chl());
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aae();
        aVar.hnU = new aaf();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.hnS = 379;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.scene = i;
        ((aae) this.gLB.hnQ.hnY).wqv = "";
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        g.Do();
        int Cn = com.tencent.mm.kernel.a.Cn();
        if (Cn == 0) {
            x.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            return -1;
        }
        if (huC != ((long) Cn)) {
            huC = (long) Cn;
            huD.clear();
        }
        long Wx = bi.Wx();
        a aVar;
        if (this.scene == 0) {
            this.huE = bi.aD(ML(), "");
            aVar = (a) huD.get(this.huE);
            if (aVar == null) {
                aVar = new a();
                huD.put(this.huE, aVar);
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", aVar, this.huE);
            }
            if (aVar.huF) {
                aVar.huG = Wx;
                aVar.huH = Wx;
                aVar.huI = 0;
            }
            x.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(Wx - aVar.huG), Long.valueOf(Wx - aVar.huH), Long.valueOf(aVar.huI));
            if (Wx > aVar.huG && Wx - aVar.huG < 10) {
                x.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", Long.valueOf(Wx - aVar.huG), aVar);
                return -1;
            } else if (Wx <= aVar.huH || Wx - aVar.huH >= 3600 || aVar.huI < 90) {
                aVar.huG = Wx;
                if (Wx < aVar.huH || Wx - aVar.huI > 3600) {
                    aVar.huH = Wx;
                    aVar.huI = 0;
                } else {
                    aVar.huI++;
                }
            } else {
                x.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", Long.valueOf(Wx - aVar.huH), aVar);
                return -1;
            }
        }
        this.huE = "";
        Iterator it = huD.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar != null) {
                    aVar.huG = Wx;
                    if (Wx < aVar.huH || Wx - aVar.huI > 3600) {
                        aVar.huH = Wx;
                        aVar.huI = 0;
                    } else {
                        aVar.huI++;
                    }
                }
            }
        }
        this.startTime = Wx;
        com.tencent.mm.plugin.report.service.g.pWK.a(546, this.scene == 0 ? 0 : 1, 1, true);
        return a(eVar, this.gLB, this);
    }

    private static String ML() {
        if (!ao.isConnected(ad.getContext())) {
            return null;
        }
        String str;
        if (ao.isWifi(ad.getContext())) {
            WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
            if (wifiInfo == null) {
                return null;
            }
            str = "wifi_" + wifiInfo.getSSID();
        } else {
            str = "mobile_" + ao.getNetTypeString(ad.getContext()) + "_" + ao.getISPCode(ad.getContext());
        }
        x.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
        if (str == null || str.length() < 2) {
            return null;
        }
        str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
        StringBuilder stringBuilder = new StringBuilder();
        g.MM();
        return stringBuilder.append(g.MN()).append(str).toString();
    }

    private static CdnInfoParams a(jw jwVar) {
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = jwVar.vWZ;
        cdnInfoParams.c2CrwtimeoutMs = jwVar.vXb;
        cdnInfoParams.c2CshowErrorDelayMs = jwVar.vWX;
        cdnInfoParams.snsretryIntervalMs = jwVar.vXa;
        cdnInfoParams.snsrwtimeoutMs = jwVar.vXc;
        cdnInfoParams.snsshowErrorDelayMs = jwVar.vWY;
        return cdnInfoParams;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        aaf aaf = (aaf) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0 && aaf.vZH != null) {
            String ML = ML();
            if (!(bi.oN(ML) || bi.oN(this.huE) || ML.equals(this.huE))) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", ML, this.huE);
                com.tencent.mm.plugin.report.service.g.pWK.a(546, 6, 1, true);
            }
            huD.clear();
            byte[] bArr2 = null;
            if (aaf.vZK != null && aaf.vZK.wRk > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(aaf.vZK.wRk));
                bArr2 = n.a(aaf.vZK);
            }
            byte[] bArr3 = null;
            if (aaf.vZL != null && aaf.vZL.wRk > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(aaf.vZL.wRk));
                bArr3 = n.a(aaf.vZL);
            }
            x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", aaf.vZM);
            if (aaf.vZM != null) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(aaf.vZM.lTO), aaf.vZM.vXj);
            }
            if (g.MQ().a(aaf.vZH, aaf.vZI, aaf.vZJ, bArr2, bArr3, aaf.vZM)) {
                x.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", aaf.vZO, aaf.vZP, Integer.valueOf(aaf.vZN));
                if (!(aaf.vZO == null || aaf.vZP == null)) {
                    CdnLogic.setCdnInfoParams(a(aaf.vZO), a(aaf.vZP), aaf.vZN);
                }
                this.gLE.a(i2, i3, str, this);
                return;
            }
            x.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.gLE.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(10769, Integer.valueOf(d.huB), Integer.valueOf(0), Long.valueOf(this.startTime));
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(aaf.vZH == null);
        x.w(str2, str3, objArr);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 379;
    }
}
