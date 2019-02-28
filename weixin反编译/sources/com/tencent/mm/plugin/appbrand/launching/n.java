package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.launching.k.a;
import com.tencent.mm.plugin.appbrand.launching.k.b;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class n implements j {
    final String appId;
    final int iNi;
    final String iRi;
    final List<e> iSU;
    final String iSW;
    final int jCV;
    final int jDo;
    final int jDp;

    public /* synthetic */ Object call() {
        String str;
        Object obj;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final h hVar = new h();
        final h hVar2 = new h();
        k g = a.g(this.appId, "__APP__", this.iNi, this.jDo);
        g.a(new b() {
            public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                hVar.jXv = wxaPkgWrappingInfo;
                countDownLatch.countDown();
            }
        });
        g.prepareAsync();
        String vh = bi.oN(this.iRi) ? "" : l.vh(this.iRi);
        if (bi.oN(vh)) {
            str = this.iSW;
        } else {
            String str2;
            for (e eVar : this.iSU) {
                if (vh.startsWith(eVar.name)) {
                    str2 = eVar.name;
                    break;
                }
            }
            str2 = null;
            str = bi.oN(str2) ? this.iSW : str2;
        }
        if ("__APP__".equals(str) || bi.oN(str)) {
            countDownLatch.countDown();
            obj = null;
        } else {
            k g2 = a.g(this.appId, str, this.iNi, this.jDo);
            g2.a(new b() {
                public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    hVar2.jXv = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                }
            });
            g2.prepareAsync();
            int obj2 = 1;
        }
        countDownLatch.await();
        if (hVar.jXv == null) {
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) hVar.jXv;
        for (e eVar2 : this.iSU) {
            if (!"__APP__".equals(eVar2.name)) {
                ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
                modulePkgInfo.name = eVar2.name;
                modulePkgInfo.frM = eVar2.frM;
                wxaPkgWrappingInfo.iJe.add(modulePkgInfo);
            }
        }
        if (obj2 == null) {
            return wxaPkgWrappingInfo;
        }
        if (hVar2.jXv == null) {
            return null;
        }
        for (e eVar22 : this.iSU) {
            ModulePkgInfo modulePkgInfo2 = new ModulePkgInfo();
            modulePkgInfo2.frM = eVar22.frM;
            modulePkgInfo2.name = eVar22.name;
            if (str.equals(eVar22.name)) {
                modulePkgInfo2.iGz = ((WxaPkgWrappingInfo) hVar2.jXv).iGz;
            }
        }
        return wxaPkgWrappingInfo;
    }

    n(String str, int i, String str2, int i2, int i3, int i4, String str3, List<e> list) {
        this.appId = str;
        this.iNi = i;
        this.iRi = str2;
        this.jCV = i2;
        this.jDo = i3;
        this.jDp = i4;
        this.iSW = str3;
        this.iSU = list;
    }

    public final void lg(int i) {
    }
}
