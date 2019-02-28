package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.util.Pair;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ccs;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int iXv = 0;
    public static int iXw = 1;
    final String appId;
    final int fwH;
    volatile int iJb;
    String iVa;
    int iXt;
    volatile String iXx;
    final String id;

    public final /* synthetic */ Object call() {
        return ads();
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this.id = str;
        this.appId = str2;
        this.fwH = i;
        this.iJb = i2;
        this.iXx = str4;
        this.iXt = i3;
        this.iVa = str3;
    }

    public final WxaPkgWrappingInfo ads() {
        int i = 1;
        Pair r = ak.r(this.appId, this.fwH, this.iJb);
        if (r.second != null) {
            return (WxaPkgWrappingInfo) r.second;
        }
        int i2;
        if (a.iIy.equals(r.first)) {
            if (this.fwH == 10002 || this.fwH == 10102) {
                al a = ((c) g.h(c.class)).Zf().a(this.appId, this.fwH, "version", "versionMd5", "versionState");
                if (a == null) {
                    a((a) r.first);
                    return null;
                }
                i2 = this.fwH == 10102 ? 2 : 1;
                com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rV(this.appId);
                com.tencent.mm.ad.a.a c = d.c(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, i2).gLB);
                if (c != null && c.errType == 0 && c.errCode == 0) {
                    if (this.iXt == 1) {
                        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.R(this.appId, true);
                    }
                    if (bi.oN(((aja) c.fKE).url)) {
                        if (this.iXt == 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(14452, this.iVa + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()));
                        }
                        return null;
                    }
                    if (this.iXt == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(14452, this.iVa + "-" + this.appId, Integer.valueOf(5), Long.valueOf(System.currentTimeMillis()));
                    }
                    ccs ccs = new ccs();
                    String str = ((aja) c.fKE).url;
                    this.iXx = str;
                    ccs.xiq = str;
                    i2 = a.field_version;
                    this.iJb = i2;
                    ccs.vTR = i2;
                    ccs.xio = a.field_versionState;
                    ccs.xip = a.field_versionMd5;
                    ((c) g.h(c.class)).Zf().a(this.appId, ccs, this.fwH);
                } else {
                    if (this.iXt == 1) {
                        if (this.id != null && this.id.length() > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, this.id);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        }
                        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.R(this.appId, false);
                        com.tencent.mm.plugin.report.service.g.pWK.h(14452, this.iVa + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()));
                    }
                    return null;
                }
            }
            WxaPkgWrappingInfo adt = adt();
            if (adt != null) {
                if (this.iXt != 1) {
                    return adt;
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(14452, this.iVa + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()));
                return adt;
            } else if (this.iXt == 1) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14452, this.iVa + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()));
            }
        } else if (!a.iIu.equals(r.first)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", this.appId, Integer.valueOf(this.fwH), Integer.valueOf(this.iJb), Integer.valueOf(((a) r.first).aav()));
        }
        if (this.fwH == 10002 || this.fwH == 10102) {
            int[] qf = ((c) g.h(c.class)).Zf().qf(this.appId);
            if (qf != null && qf.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair r2 = ak.r(this.appId, this.fwH, qf[i]);
                    if (r2 != null && r2.first == a.iIu && r2.second != null) {
                        return (WxaPkgWrappingInfo) r2.second;
                    }
                    if (i2 >= qf.length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        a((a) r.first);
        return null;
    }

    private WxaPkgWrappingInfo adt() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final h hVar = new h();
        aq.a anonymousClass1 = new aq.a() {
            public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                com.tencent.mm.plugin.appbrand.appcache.aq.b bVar = (com.tencent.mm.plugin.appbrand.appcache.aq.b) obj;
                x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, appId = %s, return = %s", str, aVar.name());
                if (com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar)) {
                    WxaPkgWrappingInfo qh = WxaPkgWrappingInfo.qh(bVar.filePath);
                    if (qh == null) {
                        x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
                    } else {
                        qh.iJb = bVar.version;
                        qh.iJc = bi.Wx();
                        qh.iJa = bVar.iIZ;
                        hVar.jXv = qh;
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.SEVER_FILE_NOT_FOUND.equals(aVar);
                }
                countDownLatch.countDown();
            }
        };
        if (this.fwH == 10002 || this.fwH == 10102) {
            x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", this.appId, Integer.valueOf(this.iJb));
            if (!aq.b(this.appId, this.fwH, this.iJb, this.iXx, anonymousClass1)) {
                a(a.iIz);
                return null;
            }
        }
        x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", this.appId, Integer.valueOf(this.fwH));
        if (((c) g.h(c.class)).Zf() == null) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            a(a.iIz);
            return null;
        }
        String ah = ((c) g.h(c.class)).Zf().ah(this.appId, this.fwH);
        if (bi.oN(ah)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil");
            a(a.iIv);
            return null;
        }
        aq.a(this.appId, this.fwH, ah, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) hVar.jXv;
    }

    private static void a(com.tencent.mm.plugin.appbrand.appcache.ak.a r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.mm.plugin.appbrand.appcache.ak.a.iIv;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.tencent.mm.plugin.appbrand.appcache.ak.a.iIx;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0008;
    L_0x0011:
        r0 = com.tencent.mm.plugin.appbrand.appcache.ak.a.iIw;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0008;
    L_0x0019:
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.launching.b.a(com.tencent.mm.plugin.appbrand.appcache.ak$a):void");
    }
}
