package com.tencent.mm.plugin.hp.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bt.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;

public final class h implements a {
    public final void a(d.a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar.nlX == 10002) {
            String a = n.a(bxVar.vNO);
            if (bi.oN(a)) {
                x.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                a = (String) y.get(".sysmsg.$type");
                if (!bi.oN(a) && a.equalsIgnoreCase("checktinkerupdate")) {
                    int i;
                    int Wo = bi.Wo((String) y.get(".sysmsg.tinkerboots.ignorenetwork"));
                    String aD = bi.aD((String) y.get(".sysmsg.tinkerboots.xmlkey"), "");
                    x.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", Integer.valueOf(Wo), aD);
                    com.tinkerboots.sdk.a go = com.tinkerboots.sdk.a.cKg().go(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.CH()) & 4294967295L));
                    String str = TencentLocation.NETWORK_PROVIDER;
                    if (ao.isWifi(ad.getContext()) || Wo == 1) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    go.go(str, String.valueOf(i));
                    if (!bi.oN(aD)) {
                        com.tinkerboots.sdk.a.cKg().go("xmlkey", aD);
                    }
                    com.tinkerboots.sdk.a.cKg().om(true);
                }
            }
        }
    }
}
