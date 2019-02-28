package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

public final class e {
    volatile boolean gUI;
    public MMActivity isO;
    public o isP;
    e isQ;
    public volatile AppBrandInitConfig isR;
    public volatile AppBrandSysConfig isS;
    public volatile a isT;
    public volatile com.tencent.mm.plugin.appbrand.jsapi.file.a isU;
    final Deque<Runnable> isV = new LinkedBlockingDeque();
    public j isW;
    public n isX;
    public FrameLayout isY;
    public l isZ;
    h ita;
    public com.tencent.mm.plugin.appbrand.widget.c.e itb;
    public AppBrandStatObject itc;
    AppBrandRemoteTaskController itd;
    private g ite;
    private f itf;
    private b itg;
    public g ith;
    public k iti;
    public volatile com.tencent.mm.plugin.appbrand.b.b itj;
    public p itk;
    private int itl = 0;
    private boolean itm;
    boolean itn;
    boolean ito;
    public boolean itp;
    private int itq;
    boolean itr;
    boolean its;
    boolean itt;
    boolean itu;
    boolean itv;
    com.tencent.mm.plugin.appbrand.report.a.k itw;
    private AppBrandRemoteTaskController.b itx = new AppBrandRemoteTaskController.b() {
        public final void finish() {
            e.this.finish();
        }
    };
    private AppBrandMainProcessService.a ity = new AppBrandMainProcessService.a() {
        private boolean itC = false;

        public final void YQ() {
            if (this.itC) {
                e eVar = e.this;
                x.i("MicroMsg.AppBrandRuntime", "onReconnected: %s", eVar.mAppId);
                eVar.itd.aK(eVar.mAppId, eVar.isR.iIZ);
                MMToClientEvent.sv(eVar.mAppId);
                c.pu(eVar.mAppId);
                if (!(eVar.gUI || eVar.itr)) {
                    x.e("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
                    eVar.YK();
                }
            }
            this.itC = false;
        }

        public final void onDisconnected(String str) {
            this.itC = true;
            long j = e.this.itd.jPs;
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4);
            Editor edit = sharedPreferences.edit();
            if (sharedPreferences.getLong("on_wxa_process_connected_time", 0) == j) {
                edit.remove("on_wxa_process_connected_time");
                edit.commit();
                d.pVE.a(365, 1, 1, false);
                x.v("MicroMsg.AppBrandReporter", "delete timestamp(%s) and report(%d)", Long.valueOf(j), Integer.valueOf(365));
                return;
            }
            x.v("MicroMsg.AppBrandReporter", "do not need to report(%d), timestamp(cur : %s, sp : %s)", Long.valueOf(j), Integer.valueOf(365), Long.valueOf(j), Long.valueOf(sharedPreferences.getLong("on_wxa_process_connected_time", 0)));
        }
    };
    Runnable itz = new Runnable() {
        public final void run() {
            e.this.ju(11);
        }
    };
    public volatile String mAppId;
    public boolean mFinished;
    Handler mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.e$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ JSONObject itB;

        public AnonymousClass6(JSONObject jSONObject) {
            this.itB = jSONObject;
        }

        public final void run() {
            e.a(e.this, this.itB);
        }
    }

    static /* synthetic */ void a(e eVar) {
        while (!eVar.isV.isEmpty()) {
            eVar.isO.runOnUiThread((Runnable) eVar.isV.removeFirst());
        }
    }

    static /* synthetic */ void a(e eVar, JSONObject jSONObject) {
        if (eVar.isP.YS() == 1 && eVar.isP.c(eVar)) {
            eVar.isP.finish();
            return;
        }
        e YD = eVar.YD();
        if (eVar.isQ != null && eVar.isQ == YD) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = eVar.mAppId;
            appBrandLaunchReferrer.iRp = 3;
            appBrandLaunchReferrer.iRq = jSONObject == null ? null : jSONObject.toString();
            YD.isR.iRl.a(appBrandLaunchReferrer);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1038;
            appBrandStatObject.foi = eVar.mAppId + ':' + eVar.isR.iub;
            YD.isR.acj();
            YD.a(appBrandStatObject);
        }
        Runnable anonymousClass7 = new Runnable() {
            public final void run() {
                e.this.isP.d(e.this);
            }
        };
        e YD2 = eVar.YD();
        Object obj = (eVar.isX == null || eVar.isX.ajy() == null || !eVar.isX.ajy().mSwiping) ? 1 : null;
        if (obj == null) {
            anonymousClass7.run();
        } else if (eVar != null) {
            com.tencent.mm.plugin.appbrand.ui.f.a(eVar, eVar.YH() ? MMFragmentActivity.a.xSO : q.a.iuI, anonymousClass7);
            if (YD2 != null) {
                com.tencent.mm.plugin.appbrand.ui.f.a(YD2, eVar.YH() ? MMFragmentActivity.a.xSN : q.a.bpQ, null);
            }
        }
        if (YD2 != null) {
            YD2.onResume();
        }
    }

    public e(MMActivity mMActivity, o oVar) {
        this.isO = mMActivity;
        this.isP = oVar;
        this.mHandler = new Handler();
        this.isY = new com.tencent.mm.plugin.appbrand.widget.e(mMActivity);
        this.isY.setLayoutParams(new LayoutParams(-1, -1));
        this.itd = new AppBrandRemoteTaskController();
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.itd;
        c YT = oVar.YT();
        AppBrandRemoteTaskController.b bVar = this.itx;
        appBrandRemoteTaskController.jPp = mMActivity.getClass().getName();
        appBrandRemoteTaskController.itM = YT;
        appBrandRemoteTaskController.itx = bVar;
        this.ite = new g();
        this.itf = new f();
        this.itg = new b();
        this.ith = new g();
        this.iti = new k();
    }

    final void a(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig == null || appBrandStatObject == null) {
            x.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            return;
        }
        this.isR = appBrandInitConfig;
        this.itc = appBrandStatObject;
        this.mAppId = appBrandInitConfig.appId;
        x.i("MicroMsg.AppBrandRuntime", "init %s, isGame %b, scene %d", this.mAppId, Boolean.valueOf(appBrandInitConfig.YI()), Integer.valueOf(YF()));
        this.itj = new com.tencent.mm.plugin.appbrand.b.b(this);
        com.tencent.mm.plugin.appbrand.b.b bVar = this.itj;
        com.tencent.mm.ipcinvoker.g.fk("com.tencent.mm");
        ad.getContext().registerComponentCallbacks(bVar.iKd);
        bVar.iKb.start();
        this.itj.a(new com.tencent.mm.plugin.appbrand.b.b.a() {
            public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
                Object obj;
                e eVar = e.this;
                Map hashMap = new HashMap();
                switch (com.tencent.mm.plugin.appbrand.page.h.AnonymousClass1.iKf[aVar.ordinal()]) {
                    case 1:
                        obj = "background";
                        break;
                    case 2:
                        obj = "active";
                        break;
                    case 3:
                        obj = "suspend";
                        break;
                    default:
                        return;
                }
                hashMap.put(DownloadInfo.STATUS, obj);
                new com.tencent.mm.plugin.appbrand.page.h().v(hashMap).a(eVar.isW).afI();
            }
        });
        if (!this.mFinished) {
            MMToClientEvent.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.AnonymousClass1(this);
            MMToClientEvent.a(anonymousClass1);
            this.itj.a(new com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.AnonymousClass2(anonymousClass1));
        }
        x.i("MicroMsg.AppBrandRuntime", "init %s, config %s, stat %s", this.mAppId, this.isR, this.itc);
        this.gUI = false;
        this.itm = false;
        this.mFinished = false;
        this.itn = false;
        this.ito = false;
        this.itp = false;
        this.itr = false;
        this.its = false;
        this.itu = false;
        this.itv = false;
        this.itt = false;
        this.itq = 0;
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, this.isR.appId);
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, this.isR.fsi);
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.valueOf(false));
        a.a(this.mAppId, this);
        a.a(this.mAppId, this.itc);
        i.pB(this.mAppId);
        this.ith.o(0, System.currentTimeMillis() - appBrandInitConfig.startTime);
        ju(1);
        com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "ActivityCreate", this.isR.startTime, System.currentTimeMillis());
    }

    final void YC() {
        this.itw = new com.tencent.mm.plugin.appbrand.report.a.k(this);
        this.itw.jOm = bi.Wy();
        if (this.isZ != null) {
            YE();
        }
        String str = this.isR.iconUrl;
        String str2 = this.isR.fsi;
        l b = l.a.b(this.isO, this);
        b.bH(str, str2);
        if (YF() == 1023) {
            b.alh();
        }
        this.isY.addView(b.getView(), -1, -1);
        this.isZ = b;
        if (YI()) {
            this.its = true;
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.appbrand.task.c.a(new com.tencent.mm.plugin.appbrand.task.c.a() {
                public final void onReady() {
                    e.this.its = true;
                    e.this.ith.o(2, System.currentTimeMillis() - currentTimeMillis);
                    com.tencent.mm.plugin.appbrand.performance.a.a(e.this.mAppId, "X5Prepare", currentTimeMillis, System.currentTimeMillis());
                    e.this.YL();
                }
            }, false);
        }
        YK();
        AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask(new Runnable() {
            public final void run() {
                e.this.itu = true;
                e.this.YL();
            }
        }));
        x.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", this.isR.fsi, this.isR.appId);
        AppBrandMainProcessService.a(this.ity);
        MainProcessTask mainProcessTask = this.itd;
        String str3 = this.mAppId;
        mainProcessTask.jPq = a.jPE;
        mainProcessTask.mAppId = str3;
        AppBrandMainProcessService.a(mainProcessTask);
        this.itd.aK(this.mAppId, this.isR.iIZ);
        this.itj.iKb.jC(3);
        MMToClientEvent.sv(this.mAppId);
        c.pw(this.mAppId);
        c.pp(this.mAppId);
        c.a(this.mAppId, c.a.ON_CREATE);
        AppBrandStickyBannerLogic.a.Y(this.mAppId, this.isR.iRj);
        b bVar = this.itg;
        bVar.appId = this.mAppId;
        x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
        aw.a(bVar.jXx);
        com.tencent.mm.plugin.appbrand.media.a.onCreate();
        YL();
        this.mHandler.postDelayed(this.itz, 10000);
    }

    final void a(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            x.e("MicroMsg.AppBrandRuntime", "statObject is null!");
            return;
        }
        String str = this.mAppId;
        int YF = YF();
        AppBrandIDKeyBatchReport.akn().jMC = 1;
        AppBrandIDKeyBatchReport.akn().jME = str;
        AppBrandIDKeyBatchReport.akn().jMF = YF;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.akn());
        a.a(this.isR.appId, appBrandStatObject);
        h.e(this).iub = this.isR.iub;
        if (this.isX != null) {
            this.isX.jIP.acj();
        }
        this.itc = appBrandStatObject;
        x.i("MicroMsg.AppBrandRuntime", "updateStat %s, scene %d", this.mAppId, Integer.valueOf(YF()));
    }

    public final e YD() {
        return this.isP.b(this);
    }

    public final void a(final com.tencent.mm.plugin.appbrand.widget.c.h hVar) {
        if (ah.isMainThread()) {
            this.isO.aWY();
            if (hVar != null && !this.mFinished && this.itb != null) {
                ViewParent viewParent = this.itb;
                com.tencent.mm.plugin.appbrand.widget.c.g gVar = viewParent.kcg;
                int i = (gVar.kco == null || !gVar.kco.isRunning()) ? 0 : 1;
                if (i != 0) {
                    gVar = viewParent.kcg;
                    if (gVar.kco != null) {
                        gVar.kco.cancel();
                    }
                }
                View contentView = hVar.getContentView();
                if (contentView.getParent() != viewParent) {
                    com.tencent.mm.plugin.appbrand.widget.c.e.bQ(contentView);
                    viewParent.addView(contentView, new FrameLayout.LayoutParams(-2, -2, 17));
                    if (viewParent.kck != hVar) {
                        contentView.clearAnimation();
                        contentView.startAnimation(AnimationUtils.loadAnimation(viewParent.getContext(), q.a.iuG));
                    }
                    viewParent.kck = hVar;
                }
                contentView.setOnClickListener(viewParent.mOnClickListener);
                viewParent.kch.add(hVar);
                hVar.a(viewParent);
                viewParent.setVisibility(0);
                viewParent.kcg.b(Color.argb(127, 0, 0, 0), null);
                return;
            }
            return;
        }
        ah.y(new Runnable() {
            public final void run() {
                e.this.a(hVar);
            }
        });
    }

    final void YE() {
        if (this.isZ == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            return;
        }
        com.tencent.mm.plugin.appbrand.page.l ajy = this.isX.ajy();
        if (ajy == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, null currentPage, appId %s", this.mAppId);
        } else {
            this.isZ.a(ajy.ajv());
        }
        this.isZ.alg();
        this.isZ = null;
    }

    public final int YF() {
        if (this.itc == null) {
            return 0;
        }
        return this.itc.scene;
    }

    public final String YG() {
        if (this.isR == null) {
            return "";
        }
        if (!bi.oN(this.isR.iRi)) {
            return this.isR.iRi;
        }
        if (this.isT == null) {
            return "";
        }
        return this.isT.acc();
    }

    public final boolean YH() {
        return this.isR == null || this.isR.iRc;
    }

    public final boolean YI() {
        return this.isR == null || this.isR.YI();
    }

    public final boolean YJ() {
        return this.isR != null && this.isR.iRh && (this.itc.scene == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE || this.itc.scene == HardCoderJNI.FUNC_TERMINATE_APP || this.itc.scene == HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE);
    }

    final void YK() {
        if (com.tencent.mm.plugin.appbrand.task.c.akU() || YI()) {
            final long currentTimeMillis = System.currentTimeMillis();
            AppBrandPrepareTask appBrandPrepareTask = new AppBrandPrepareTask(this.isO, this);
            appBrandPrepareTask.jCs = new AppBrandPrepareTask.b() {
                public final void b(AppBrandSysConfig appBrandSysConfig) {
                    x.i("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask.onPrepareDone");
                    if (!e.this.isO.isFinishing()) {
                        if (appBrandSysConfig == null) {
                            e.this.finish();
                            return;
                        }
                        ah.y(new Runnable() {
                            public final void run() {
                            }
                        });
                        e.this.ith.o(1, System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.mm.plugin.appbrand.performance.a.a(e.this.mAppId, "ResourcePrepare", currentTimeMillis, System.currentTimeMillis());
                        e.this.isS = appBrandSysConfig;
                        e.this.isT = a.m(e.this);
                        e.this.isU = com.tencent.mm.plugin.appbrand.jsapi.file.a.p(e.this);
                        x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. app-config parsed.");
                        e.this.isO.runOnUiThread(new Runnable() {
                            public final void run() {
                                x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. runOnUiThread");
                                e eVar = e.this;
                                boolean j = j.j(eVar.isO);
                                if (eVar.YI() && j) {
                                    Toast makeText = Toast.makeText(eVar.isO, q.j.iEh, 1);
                                    makeText.setGravity(17, 0, 0);
                                    makeText.show();
                                    eVar.isO.finish();
                                } else {
                                    eVar.a(new com.tencent.mm.plugin.appbrand.config.d.a() {
                                        public final void a(com.tencent.mm.plugin.appbrand.config.d.b bVar, boolean z) {
                                            x.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime.onOrientationChanged");
                                            if (!z) {
                                                String str = "MicroMsg.AppBrandRuntime";
                                                String str2 = "OnOrientationChanged failure  ret:[%s]";
                                                Object[] objArr = new Object[1];
                                                objArr[0] = bVar == null ? "null" : bVar.name();
                                                x.f(str, str2, objArr);
                                            }
                                            e.this.itt = true;
                                            e.this.YL();
                                        }
                                    });
                                }
                                e.this.itr = true;
                                e.this.YL();
                            }
                        });
                    }
                }

                public final void onDownloadStarted() {
                    e.this.itv = true;
                    if (e.this.itw != null) {
                        e.this.itw.jOn = true;
                    }
                }

                public final void jv(final int i) {
                    x.i("MicroMsg.AppBrandRuntime", "onDownloadProgress %d", Integer.valueOf(i));
                    ah.y(new Runnable() {
                        public final void run() {
                        }
                    });
                }

                public final void a(final com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
                    e eVar = e.this;
                    Runnable anonymousClass4 = new Runnable() {
                        public final void run() {
                            com.tencent.mm.plugin.appbrand.jsapi.version.a aVar = aVar;
                            com.tencent.mm.plugin.appbrand.jsapi.c cVar = e.this.isW;
                            x.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", aVar.jvf, cVar);
                            if (cVar != null) {
                                Map hashMap = new HashMap(1);
                                hashMap.put("state", aVar.jvf);
                                new a().a(cVar).v(hashMap).afI();
                            }
                        }
                    };
                    if (eVar.gUI) {
                        eVar.isO.runOnUiThread(anonymousClass4);
                    } else {
                        eVar.isV.offerLast(anonymousClass4);
                    }
                }
            };
            appBrandPrepareTask.ait();
            return;
        }
        com.tencent.mm.plugin.appbrand.task.c.a(new com.tencent.mm.plugin.appbrand.task.c.a() {
            public final void onReady() {
                if (!e.this.mFinished) {
                    e.this.YK();
                }
            }
        }, false);
    }

    final void a(com.tencent.mm.plugin.appbrand.config.d.a aVar) {
        if (this.mFinished) {
            x.i("MicroMsg.AppBrandRuntime", "mFinished is true return,mAppId:%s", this.mAppId);
            return;
        }
        x.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime.mayRequestOrientation %s,mAppId:%s", this.isT.acb(), this.mAppId);
        e.iQr.a(this.isO, com.tencent.mm.plugin.appbrand.config.d.a(this.isR, this.isT), aVar);
    }

    final void YL() {
        x.i("MicroMsg.AppBrandRuntime", "initRuntime, mFinished: %b, ResourceReady: %b, WebViewReady: %b,isOrientationReady: %b, MainProcessReady: %b", Boolean.valueOf(this.mFinished), Boolean.valueOf(this.itr), Boolean.valueOf(this.its), Boolean.valueOf(this.itt), Boolean.valueOf(this.itu));
        if (this.mFinished || !this.itr || !this.its || !this.itt || !this.itu) {
            return;
        }
        if (this.gUI) {
            x.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee");
            return;
        }
        final Runnable anonymousClass18 = new Runnable() {
            public final void run() {
                boolean z;
                e eVar = e.this;
                eVar.ith.o(6, System.currentTimeMillis() - eVar.isR.startTime);
                AppBrandStatObject appBrandStatObject = eVar.itc;
                String str = eVar.isR.iRi;
                eVar.a(appBrandStatObject);
                if (eVar.isS == null || bi.cC(eVar.isS.iRU.iJe)) {
                    z = false;
                } else {
                    z = true;
                }
                eVar.itk = z ? new r(eVar) : new p.b();
                if (eVar.YI()) {
                    eVar.isW = new com.tencent.mm.plugin.appbrand.game.d();
                } else if (eVar.YJ()) {
                    eVar.isW = new m();
                } else {
                    eVar.isW = com.tencent.mm.plugin.appbrand.task.c.uM(eVar.mAppId);
                    if (eVar.isW == null) {
                        eVar.isW = new j();
                    }
                }
                eVar.isW.f(eVar);
                com.tencent.mm.plugin.appbrand.jsapi.j.sA(eVar.mAppId);
                eVar.isX = new n(eVar.isO, eVar);
                eVar.isX.jIS = new n.a() {
                    public final void YP() {
                        e.this.YE();
                        e eVar = e.this;
                        if (AppBrandPerformanceManager.uy(eVar.mAppId) && eVar.ita == null) {
                            AppBrandPerformanceManager.uv(eVar.mAppId);
                            if (!DebuggerShell.acx()) {
                                eVar.ita = new h(eVar.isO, eVar.mAppId);
                                eVar.isY.addView(eVar.ita);
                                a.a(eVar.mAppId, eVar.ita);
                                h hVar = eVar.ita;
                                AppBrandPerformanceManager.uz(hVar.mAppId);
                                hVar.setVisibility(0);
                                hVar.setAlpha(0.0f);
                                hVar.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
                            }
                        }
                        e eVar2 = e.this;
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.isR.startTime;
                        boolean z = eVar2.itv;
                        boolean YI = eVar2.YI();
                        int i = YI ? 775 : 367;
                        int i2 = currentTimeMillis <= 2000 ? z ? 8 : 1 : currentTimeMillis <= 3000 ? z ? 9 : 2 : currentTimeMillis <= 4000 ? z ? 10 : 3 : currentTimeMillis <= 5000 ? z ? 11 : 4 : currentTimeMillis <= 6000 ? z ? 12 : 5 : YI ? currentTimeMillis <= 7000 ? z ? 19 : 14 : currentTimeMillis <= 8000 ? z ? 20 : 15 : currentTimeMillis <= 9000 ? z ? 21 : 16 : currentTimeMillis <= 10000 ? z ? 22 : 17 : z ? 23 : 18 : z ? 13 : 6;
                        com.tencent.mm.plugin.report.service.g.pWK.a((long) i, (long) i2, 1, false);
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.pWK.a((long) i, 7, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.a((long) i, 0, 1, false);
                        }
                        x.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", Long.valueOf(currentTimeMillis), Boolean.valueOf(z));
                        String str = "MicroMsg.AppBrandRuntime";
                        String str2 = "onHideSplash: %s, cost: %dms, download : %b";
                        Object[] objArr = new Object[3];
                        objArr[0] = eVar2.isR != null ? eVar2.isR.fsi : "";
                        objArr[1] = Long.valueOf(currentTimeMillis);
                        objArr[2] = Boolean.valueOf(eVar2.itv);
                        x.i(str, str2, objArr);
                        long currentTimeMillis2 = System.currentTimeMillis() - eVar2.isR.startTime;
                        eVar2.ith.o(5, currentTimeMillis2);
                        g gVar = eVar2.ith;
                        boolean z2 = eVar2.itv;
                        boolean z3 = eVar2.isR.iRk;
                        boolean z4 = eVar2.isS.iRz;
                        String str3 = eVar2.mAppId;
                        gVar.aIt = 0;
                        gVar.mType = 0;
                        if (eVar2.isS != null) {
                            gVar.aIt = eVar2.isS.iRU.iJb;
                            gVar.mType = eVar2.isS.iRU.iJa + 1;
                        }
                        gVar.itT = z2 ? 1 : 0;
                        gVar.itU = eVar2.YF();
                        gVar.itW = z3;
                        gVar.itX = z4;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i2 = 0; i2 < gVar.itS.length; i2++) {
                            if (gVar.itS[i2] < 0) {
                                x.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", Integer.valueOf(i2), Long.valueOf(gVar.itS[i2]));
                                break;
                            }
                            stringBuilder.append(gVar.itS[i2]);
                            stringBuilder.append(",");
                        }
                        AppBrandInitConfig appBrandInitConfig = eVar2.isR;
                        if (appBrandInitConfig != null) {
                            i2 = appBrandInitConfig.foo;
                        } else {
                            i2 = com.tencent.mm.plugin.appbrand.report.b.uE(str3);
                            x.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(i2));
                        }
                        i2 += 1000;
                        x.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", str3, stringBuilder.toString(), Boolean.valueOf(z2), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.c.akU()), Integer.valueOf(i2));
                        gVar.e(str3, 1, 0, i2);
                        gVar.e(str3, 2, 1, i2);
                        gVar.e(str3, 3, 2, i2);
                        gVar.e(str3, 4, 3, i2);
                        gVar.e(str3, 6, 4, i2);
                        gVar.e(str3, 7, 5, i2);
                        gVar.e(str3, 23, 6, i2);
                        gVar.e(str3, 24, 7, i2);
                        gVar.e(str3, 25, 8, i2);
                        gVar.e(str3, 26, 9, i2);
                        gVar.e(str3, 27, 10, i2);
                        gVar.e(str3, 28, 11, i2);
                        gVar.e(str3, 29, 12, i2);
                        AppBrandPerformanceManager.a(eVar2.mAppId, 202, currentTimeMillis2);
                        com.tencent.mm.plugin.appbrand.performance.a.bG(eVar2.isR.startTime);
                        com.tencent.mm.plugin.appbrand.performance.a.a(eVar2.mAppId, "startupDone", eVar2.isR.startTime, System.currentTimeMillis());
                        e.a(e.this);
                        e.this.itw = null;
                        MainProcessTask mainProcessTask = e.this.itd;
                        mainProcessTask.jPq = a.jPF;
                        AppBrandMainProcessService.a(mainProcessTask);
                    }
                };
                eVar.isY.addView(eVar.isX, 0);
                FrameLayout frameLayout = eVar.isY;
                View eVar2 = new com.tencent.mm.plugin.appbrand.widget.c.e(eVar.isO);
                eVar.itb = eVar2;
                frameLayout.addView(eVar2);
                n nVar = eVar.isX;
                nVar.runOnUiThread(new com.tencent.mm.plugin.appbrand.page.n.AnonymousClass1(eVar.isR.iRi));
                eVar.ith.o(8, System.currentTimeMillis() - eVar.isR.startTime);
                eVar.isW.init();
                eVar.a(eVar.isS);
                eVar.ju(2);
                e.this.gUI = true;
                e eVar3 = e.this;
                eVar3.mHandler.removeCallbacks(eVar3.itz);
            }
        };
        int i = this.itl + 1;
        this.itl = i;
        if (i > 1) {
            anonymousClass18.run();
        } else {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    Looper.myQueue().removeIdleHandler(this);
                    anonymousClass18.run();
                    return false;
                }
            });
        }
    }

    public final void YM() {
        this.itq++;
    }

    public final void YN() {
        if (this.itq != 0) {
            this.itq--;
        }
    }

    public final void onPause() {
        if (this.gUI) {
            x.i("MicroMsg.AppBrandRuntime", "onPause: %s", this.mAppId);
            this.itm = true;
            this.itj.iKb.jC(1);
            f fVar = this.itf;
            Map hashMap = new HashMap(1);
            Object obj = "hide";
            switch (com.tencent.mm.plugin.appbrand.page.f.AnonymousClass1.iKC[c.px(this.mAppId).ordinal()]) {
                case 1:
                    obj = "close";
                    break;
                case 2:
                    obj = "back";
                    break;
                case 3:
                case 4:
                case 5:
                    obj = "hide";
                    break;
                case 6:
                    obj = "hang";
                    break;
                case 7:
                    obj = "launchMiniProgram";
                    break;
            }
            hashMap.put("mode", obj);
            fVar.v(hashMap).a(this.isW).afI();
            n nVar = this.isX;
            if (nVar.jIM.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.page.l) nVar.jIM.getFirst()).aeK();
                nVar.jIP.d(((com.tencent.mm.plugin.appbrand.page.l) nVar.jIM.getFirst()).aeO());
            }
            c.pr(this.mAppId);
            c.a(this.mAppId, c.a.ON_PAUSE);
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            aw.a(null);
        }
    }

    public final void onResume() {
        if (this.gUI) {
            x.i("MicroMsg.AppBrandRuntime", "onResume: %s", this.mAppId);
            if (this.mFinished || this.itn) {
                reload();
                return;
            }
            String YG;
            this.itm = false;
            c.pw(this.mAppId);
            c.pt(this.mAppId);
            c.a(this.mAppId, c.a.ON_RESUME);
            MainProcessTask mainProcessTask = this.itd;
            String str = this.mAppId;
            int i = this.isR.iIZ;
            mainProcessTask.jPq = a.jPx;
            mainProcessTask.mAppId = str;
            mainProcessTask.jCG = i;
            AppBrandMainProcessService.a(mainProcessTask);
            if (this.ito) {
                this.isX.jIP.jMY = true;
            }
            n nVar = this.isX;
            if (nVar.jIM.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.page.l) nVar.jIM.getFirst()).aeJ();
                nVar.jIP.e(((com.tencent.mm.plugin.appbrand.page.l) nVar.jIM.getFirst()).aeO());
            }
            this.itj.iKb.jC(3);
            this.isW.onResume();
            g gVar = this.ite;
            boolean z = this.ito;
            Map hashMap = new HashMap();
            AppBrandStatObject appBrandStatObject = this.itc;
            if (appBrandStatObject != null) {
                hashMap.put("scene", Integer.valueOf(appBrandStatObject.scene));
            }
            JSONObject acn = this.isR.iRl.acn();
            if (acn != null) {
                hashMap.put("referrerInfo", acn);
            }
            acn = this.isR.acl();
            if (acn != null) {
                hashMap.put("shareInfo", acn);
            }
            hashMap.put("relaunch", Boolean.valueOf(z));
            hashMap.put("reLaunch", Boolean.valueOf(z));
            if (z) {
                YG = YG();
                hashMap.put("path", com.tencent.mm.plugin.appbrand.q.l.vh(YG));
                hashMap.put("query", com.tencent.mm.plugin.appbrand.q.l.vi(YG));
            } else {
                YG = this.isX.aeH();
            }
            x.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get("query"), hashMap.get("relaunch"), YG);
            com.tencent.mm.plugin.appbrand.r.c.m(hashMap);
            gVar.v(hashMap).a(this.isW).afI();
            if (this.ito) {
                if (YI()) {
                    this.isX.ajy().loadUrl(YG());
                } else {
                    this.isX.W(YG(), true);
                }
            }
            AppBrandInitConfig appBrandInitConfig = this.isR;
            if (!bi.oN(appBrandInitConfig.appId)) {
                AppBrandSysConfig pk = a.pk(appBrandInitConfig.appId);
                if (pk != null) {
                    AppBrandStatObject pl = a.pl(appBrandInitConfig.appId);
                    if (pl != null) {
                        x.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", appBrandInitConfig.appId, Integer.valueOf(appBrandInitConfig.iIZ));
                        AppBrandMainProcessService.a(new UpdateTask(new LaunchCheckParams(appBrandInitConfig, pl, pk.iRU.iJb, ab.aaa().iJb, h.pA(appBrandInitConfig.appId).iub)));
                    }
                }
            }
            b bVar = this.itg;
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            aw.a(bVar.jXx);
            a(this.isS);
            com.tencent.mm.plugin.appbrand.task.c.uL(this.mAppId);
            this.itn = false;
            this.ito = false;
            a(new com.tencent.mm.plugin.appbrand.config.d.a() {
                public final void a(com.tencent.mm.plugin.appbrand.config.d.b bVar, boolean z) {
                    x.i("MicroMsg.AppBrandRuntime", "resume OnOrientationChanged orientation = [%s] success = [%b]", bVar, Boolean.valueOf(z));
                }
            });
        }
    }

    public final void cleanup() {
        if (!this.mFinished) {
            this.mFinished = true;
            x.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", this.mAppId);
            final String str = this.mAppId;
            if (DebuggerShell.acx()) {
                com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                    public final void run() {
                        com.tencent.mm.plugin.appbrand.performance.a.uB(str);
                    }
                });
            }
            MainProcessTask mainProcessTask = this.itd;
            String str2 = this.mAppId;
            mainProcessTask.jPq = a.jPy;
            mainProcessTask.mAppId = str2;
            AppBrandMainProcessService.a(mainProcessTask);
            AppBrandMainProcessService.b(this.ity);
            MMToClientEvent.sw(this.mAppId);
            c.pq(this.mAppId);
            c.a(this.mAppId, c.a.ON_DESTROY);
            com.tencent.mm.plugin.appbrand.jsapi.j.sB(this.mAppId);
            AppBrandStickyBannerLogic.a.vb(this.mAppId);
            a.pn(this.mAppId);
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jFa;
            appBrandMusicClientService.jEZ.clear();
            appBrandMusicClientService.jFb = "";
            com.tencent.mm.plugin.appbrand.media.a.onDestroy();
            com.tencent.mm.plugin.appbrand.permission.b.uC(this.mAppId);
            this.isO.aWY();
            com.tencent.mm.plugin.appbrand.b.b bVar = this.itj;
            com.tencent.mm.plugin.appbrand.b.c cVar = bVar.iKb;
            cVar.iKl.set(true);
            cVar.quit();
            cVar.b(com.tencent.mm.plugin.appbrand.b.a.DESTROYED);
            ad.getContext().unregisterComponentCallbacks(bVar.iKd);
            synchronized (bVar.iKc) {
                bVar.iKc.clear();
            }
            if (this.itb != null) {
                this.isY.removeView(this.itb);
            }
            com.tencent.mm.plugin.appbrand.jsapi.file.a aVar = this.isU;
            if (aVar != null) {
                aVar.release();
                this.isU = null;
            }
            if (this.itw != null) {
                com.tencent.mm.plugin.appbrand.report.a.k kVar = this.itw;
                try {
                    i pE = i.pE(kVar.iua.mAppId);
                    kVar.jNL = com.tencent.mm.plugin.appbrand.report.a.cf(ad.getContext());
                    kVar.appId = kVar.iua.mAppId;
                    kVar.fJh = kVar.iua.isS == null ? 0 : kVar.iua.isS.iRU.iJb;
                    kVar.foh = kVar.iua.isR.iIZ + 1;
                    kVar.scene = kVar.iua.YF();
                    kVar.jOo = kVar.jOn ? 1 : 0;
                    kVar.jOp = pE.iuf.get() ? 1 : 0;
                    kVar.jOq = bi.Wy() - kVar.jOm;
                    kVar.jOr = bi.Wy();
                    x.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + kVar.toString());
                    d.pVE.h(14576, kVar.jNL, kVar.appId, Integer.valueOf(kVar.fJh), Integer.valueOf(kVar.foh), Integer.valueOf(kVar.scene), kVar.frp, Integer.valueOf(kVar.jOo), Integer.valueOf(kVar.jOp), Long.valueOf(kVar.jOq), Long.valueOf(kVar.jOr));
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", e);
                }
            }
            this.itw = null;
            c.pv(this.mAppId);
            if (this.isW != null) {
                this.isW.cleanup();
            }
            if (this.isX != null) {
                this.isX.cleanup();
                this.isY.removeView(this.isX);
            }
            a.a(this.mAppId, null);
            a.a(this.mAppId, null);
            i.remove(this.mAppId);
            this.isV.clear();
            this.isR.startTime = System.currentTimeMillis();
        }
    }

    public final void finish() {
        this.isO.runOnUiThread(new Runnable() {
            public final void run() {
                e.a(e.this, null);
            }
        });
    }

    final void reload() {
        cleanup();
        a(this.isR, this.itc);
        YC();
        x.i("MicroMsg.AppBrandRuntime", "reload: %s", this.mAppId);
    }

    public final void close() {
        if (this.isP.YS() != 1) {
            finish();
        } else if (YH()) {
            this.isP.finish();
        } else {
            this.isP.close();
        }
    }

    @TargetApi(21)
    final void a(final AppBrandSysConfig appBrandSysConfig) {
        if (VERSION.SDK_INT >= 21 && !YH()) {
            final int aM = j.aM(this.isT.iPE.iQa, WebView.NIGHT_MODE_COLOR);
            this.isO.setTaskDescription(new TaskDescription(appBrandSysConfig.fsi, null, aM));
            com.tencent.mm.modelappbrand.a.b.Jp().a(new com.tencent.mm.modelappbrand.a.b.b() {
                public final void j(Bitmap bitmap) {
                    e.this.isO.setTaskDescription(new TaskDescription(appBrandSysConfig.fsi, bitmap, aM));
                }
            }, appBrandSysConfig.iRs, null);
        }
    }

    public final boolean YO() {
        if (!this.itm || this.itq != 0) {
            return false;
        }
        cleanup();
        return true;
    }

    final void ju(int i) {
        int i2 = 369;
        if (YI()) {
            i2 = 777;
        }
        com.tencent.mm.plugin.report.service.g.pWK.a((long) i2, (long) i, 1, false);
    }
}
