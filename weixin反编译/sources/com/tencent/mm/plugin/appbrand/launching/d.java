package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.e.h;
import com.tencent.mm.ay.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class d implements ILaunchWxaAppInfoNotify {
    private static final android.support.v4.e.a<String, d> jCR = new android.support.v4.e.a();
    static final h<AppBrandSysConfig, AppBrandLaunchErrorAction> jCY = h.d(null, null);
    final String appId;
    final int fJn;
    final int iNi;
    final String iRi;
    final AppBrandLaunchReferrer iRl;
    final boolean jCS;
    volatile b jCT;
    volatile h<AppBrandSysConfig, AppBrandLaunchErrorAction> jCU;
    final int jCV;
    final String jCW;
    final int jCX;
    final boolean jCu;
    volatile boolean started;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.d$2 */
    class AnonymousClass2 extends aa {
        AnonymousClass2(String str, int i, String str2, int i2, com.tencent.mm.plugin.appbrand.config.WxaAttributes.d dVar) {
            super(str, i, str2, i2, dVar);
        }

        public final void aiu() {
            d.a(d.this);
        }

        public final void aiw() {
            d.b(d.this);
        }

        public final void lg(int i) {
            if (d.this.jCT != null) {
                d.this.jCT.lg(i);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.d$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String jDb;

        AnonymousClass3(String str) {
            this.jDb = str;
        }

        public final void run() {
            String[] rk = q.rk(this.jDb);
            if (rk != null && rk.length > 0) {
                for (String str : rk) {
                    com.tencent.mm.modelappbrand.a.b Jp = com.tencent.mm.modelappbrand.a.b.Jp();
                    if (!bi.oN(str)) {
                        Jp.a(new com.tencent.mm.modelappbrand.a.b.b(), str, null);
                    }
                }
            }
            if (g.Dq().isSDCardAvailable()) {
                g.Dp().gRu.a(new k(12), 0);
            }
        }
    }

    interface b {
        void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction);

        void aiu();

        void lg(int i);
    }

    private static final class a extends al {
        public a(final String str) {
            super(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    d.tD(str);
                    return false;
                }
            }, false);
        }
    }

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "preDownload, appId %s, versionType %d", dVar.appId, Integer.valueOf(dVar.iNi));
        if (dVar.jCT != null) {
            dVar.jCT.aiu();
        }
    }

    static /* synthetic */ void a(d dVar, h hVar) {
        x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] onPrepareDone %s %d in mm process", dVar.appId, Integer.valueOf(dVar.iNi));
        dVar.a(hVar);
        LaunchBroadCast.a(dVar.appId, dVar.iNi, dVar.jCV, ((AppBrandSysConfig) hVar.first) != null);
    }

    static /* synthetic */ void b(d dVar) {
        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "postDownload, appId %s, versionType %d", dVar.appId, Integer.valueOf(dVar.iNi));
        if (dVar.jCT != null) {
            b bVar = dVar.jCT;
        }
    }

    static d tD(String str) {
        d dVar;
        synchronized (jCR) {
            dVar = (d) jCR.remove(str);
        }
        return dVar;
    }

    static d tE(String str) {
        d dVar;
        synchronized (jCR) {
            dVar = (d) jCR.get(str);
        }
        return dVar;
    }

    public d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfig.appId, appBrandInitConfig.iIZ, appBrandStatObject.fJn, appBrandStatObject.scene, appBrandInitConfig.iRi, appBrandInitConfig.iRl, appBrandInitConfig.iub, -1, true, appBrandInitConfig.YI());
        if (appBrandInitConfig.YI()) {
            com.tencent.mm.plugin.appbrand.appcache.k.pR(appBrandInitConfig.appId);
        }
    }

    public d(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4, boolean z, boolean z2) {
        this.appId = str;
        this.iNi = i;
        this.fJn = i2;
        this.jCV = i3;
        this.iRi = str2;
        this.iRl = appBrandLaunchReferrer;
        this.jCW = str3;
        this.jCX = i4;
        this.jCu = z2;
        this.jCS = z;
    }

    final void a(h<AppBrandSysConfig, AppBrandLaunchErrorAction> hVar) {
        this.jCU = hVar;
        if (this.jCT != null) {
            this.jCT.a((AppBrandSysConfig) hVar.first, (AppBrandLaunchErrorAction) hVar.second);
            tD(this.jCW);
        }
    }

    public final void a(String str, int i, String str2, u uVar) {
        if (this.jCU != null) {
            a aVar = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = a.a(this.appId, this.iNi, uVar);
            if (a != null) {
                this.jCU = h.d(null, a);
                return;
            }
            AppBrandSysConfig appBrandSysConfig = (AppBrandSysConfig) this.jCU.first;
            if (appBrandSysConfig == null) {
                x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "notifyLaunchInfoUpdate null config with appId(%s)", str);
                return;
            }
            uVar.c(appBrandSysConfig);
            this.jCU = h.d(appBrandSysConfig, null);
        }
    }

    public final void ait() {
        if (!this.started) {
            this.started = true;
            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] startPrepare in mm %s %d", this.appId, Integer.valueOf(this.iNi));
            if (this.jCS) {
                synchronized (jCR) {
                    jCR.put(this.jCW, this);
                }
                al aVar = new a(this.jCW);
                long toMillis = TimeUnit.SECONDS.toMillis(300);
                aVar.K(toMillis, toMillis);
            }
            final HandlerThread WL = e.WL(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{this.appId, Integer.valueOf(this.iNi)}));
            WL.start();
            new ag(WL.getLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        h hVar;
                        d dVar = d.this;
                        d dVar2 = d.this;
                        AppBrandSysConfig rj = q.rj(dVar2.appId);
                        if (rj == null) {
                            y.tF(c.getMMString(j.iDp, ""));
                        }
                        if (rj == null) {
                            x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "get null config!!!");
                            hVar = d.jCY;
                        } else {
                            com.tencent.mm.plugin.appbrand.q.h hVar2 = new com.tencent.mm.plugin.appbrand.q.h();
                            String str = rj.appId;
                            String str2 = rj.foe;
                            Object anonymousClass2 = new AnonymousClass2(rj.appId, dVar2.iNi, dVar2.iRi, dVar2.jCV, com.tencent.mm.plugin.appbrand.app.e.Zs().g(str, "versionInfo").acs());
                            Future futureTask = new FutureTask(anonymousClass2);
                            e.post(futureTask, anonymousClass2.getTag());
                            u aiH = new ab(str, dVar2.iNi, dVar2.fJn, dVar2.jCV, dVar2.iRi, dVar2.iRl, dVar2.jCW, dVar2.jCX).aiH();
                            if (aiH == null) {
                                x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null launchInfo", rj.foe);
                                anonymousClass2 = null;
                            } else {
                                a aVar = AppBrandLaunchErrorAction.CREATOR;
                                AppBrandLaunchErrorAction a = a.a(str, dVar2.iNi, aiH);
                                if (a != null) {
                                    hVar2.jXv = a;
                                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, launch ban code %d", rj.foe, Integer.valueOf(aiH.field_launchAction.vKQ));
                                    anonymousClass2 = null;
                                } else if (aiH.field_jsapiInfo == null || aiH.field_jsapiInfo.wcZ == null) {
                                    x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null jsapi_info", rj.foe);
                                    anonymousClass2 = null;
                                } else {
                                    aiH.c(rj);
                                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) futureTask.get();
                                    if (wxaPkgWrappingInfo == null) {
                                        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig null app pkg, username %s appId %s", rj.foe, rj.appId);
                                        anonymousClass2 = null;
                                    } else {
                                        rj.iRU.a(wxaPkgWrappingInfo);
                                        if (rj.iRU.iJa != 0) {
                                            rj.iRU.iJb = 0;
                                        }
                                        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, app pkg %s", rj.foe, rj.appId, rj.iRU);
                                        rj.iRV = AppBrandGlobalSystemConfig.aci();
                                        g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
                                        rj.iRw = !g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, false);
                                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, Boolean.valueOf(true));
                                        e.post(new AnonymousClass3(str2), "AppLaunchPrepareProcess#ExtraWorks");
                                        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig ok username %s, appId %s", rj.foe, rj.appId);
                                        anonymousClass2 = 1;
                                    }
                                }
                            }
                            if (anonymousClass2 == null) {
                                x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig, false, username %s, appId %s", rj.foe, rj.appId);
                                hVar = h.d(null, hVar2.jXv);
                            } else {
                                x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "prepare ok, just go weapp, username %s, appId %s", rj.foe, rj.appId);
                                hVar = h.d(rj, null);
                            }
                        }
                        d.a(dVar, hVar);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess", e, "call() exp ", new Object[0]);
                        y.lh(j.iCy);
                        d.a(d.this, d.jCY);
                    }
                    WL.quit();
                }
            });
        }
    }
}
