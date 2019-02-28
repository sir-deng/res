package com.tencent.mm.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak.c;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":tools");
    private static Locale locale;

    public static final class a {
        private static final AtomicInteger fgf = new AtomicInteger(0);

        public static boolean isLocked() {
            if (fgf.get() <= 0) {
                Object obj;
                ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
                if (activityManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (((h) g.Dn().CU()).gQd.equals(runningAppProcessInfo.processName)) {
                                if (runningAppProcessInfo.importance == 300) {
                                    obj = 1;
                                    if (obj == null) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    return false;
                }
            }
            return true;
        }

        static void ub() {
            x.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", Integer.valueOf(fgf.getAndSet(0)));
        }
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        com.tencent.mm.e.a.ay(ad.getContext());
        i.a(new c() {
            public final void a(String str, Throwable th) {
                KVCommCrossProcessReceiver.boQ();
            }
        });
        i.cq(ffs);
        k.setupBrokenLibraryHandler();
        AppLogic.setCallBack(new AppCallBack(ad.getContext()));
        k.b(com.tencent.mm.sdk.a.xmo, ToolsProfile.class.getClassLoader());
        q wVar = new w(com.tencent.mm.booter.c.aA(this.app.getBaseContext()));
        wVar.eg("TOOL");
        r.ifb = bi.a(wVar.eh(".com.tencent.mm.debug.test.display_errcode"), false);
        r.ifc = bi.a(wVar.eh(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.ifd = bi.a(wVar.eh(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.ife = bi.a(wVar.eh(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iff = bi.a(wVar.eh(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.ifg = bi.a(wVar.eh(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.ifk = bi.a(wVar.eh(".com.tencent.mm.debug.test.album_show_info"), false);
        r.ifl = bi.a(wVar.eh(".com.tencent.mm.debug.test.location_help"), false);
        r.ifo = bi.a(wVar.eh(".com.tencent.mm.debug.test.force_soso"), false);
        r.ifp = bi.a(wVar.eh(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.ifq = bi.a(wVar.eh(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.ifr = bi.a(wVar.eh(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ifu = bi.a(wVar.eh(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.ifv = bi.a(wVar.eh(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.ifs = a;
        if (a != 4 && r.ifs > 0) {
            v.xuZ = r.ifs;
            x.e("MicroMsg.ToolDebugger", "cdn thread num " + r.ifs);
        }
        r.ift = bi.a(wVar.eh(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CX(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oN(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vHg = "android-" + string;
                d.vHi = string;
                b.Vn(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.cfy());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vHk).append(" new: ").append(a);
            d.vHk = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.gAA.gzJ = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(wVar.eh(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(wVar.eh(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(wVar.eh(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(wVar.eh(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        r.ifI = bi.aD(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + r.ifI);
        r.ifJ = bi.aD(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + r.ifJ);
        r.ifK = bi.a(wVar.eh(".com.tencent.mm.debug.skiploadurlcheck"), false);
        x.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + r.ifK);
        r.ifL = bi.a(wVar.eh(".com.tencent.mm.debug.forcex5webview"), false);
        x.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + r.ifL);
        a.cl(ffs);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.xmq, classLoader);
        k.b("wechatImgTools", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int yw = m.yw();
        if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            x.i("MicroMsg.ToolsProfile", "load wechatsight_v7a, core number: %d ", Integer.valueOf(yw >> 12));
            k.b("wechatsight_v7a", classLoader);
            if ((yw >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.qyY = 3;
                com.tencent.mm.plugin.sight.base.b.qza = 3;
                com.tencent.mm.plugin.sight.base.b.qzb = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.qyY = 1;
                com.tencent.mm.plugin.sight.base.b.qza = 1;
                com.tencent.mm.plugin.sight.base.b.qzb = 640000;
            }
        } else {
            x.i("MicroMsg.ToolsProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.qyY = 1;
            com.tencent.mm.plugin.sight.base.b.qza = 1;
            com.tencent.mm.plugin.sight.base.b.qzb = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        m.ua();
        if (com.tencent.mm.compatible.util.d.fN(14) && MMApplicationLike.applicationLike != null) {
            MMApplicationLike.applicationLike.getApplication().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                private int fgd = 0;
                private Set<Activity> fge = new HashSet();

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    this.fgd++;
                    this.fge.add(activity);
                }

                public final void onActivityDestroyed(Activity activity) {
                    this.fgd--;
                    x.d("MicroMsg.ToolsProfile", "onActivityDestroyed, after destroy, activityInstanceNum = %d", Integer.valueOf(this.fgd));
                    if (this.fgd == 0) {
                        a.ub();
                        x.i("MicroMsg.ToolsProfile", "onActivityDestroyed, xwebCanReboot = %b", Boolean.valueOf(WebView.getCanReboot()));
                        if (WebView.getCanReboot()) {
                            Process.killProcess(Process.myPid());
                        }
                    }
                }

                public final void onActivityPaused(Activity activity) {
                    this.fge.remove(activity);
                    x.i("MicroMsg.ToolsProcessLocker", "doLocalLock, counter %d", Integer.valueOf(a.fgf.incrementAndGet()));
                }

                public final void onActivityResumed(Activity activity) {
                    if (!this.fge.contains(activity)) {
                        x.i("MicroMsg.ToolsProcessLocker", "doLocalUnlock, counter %d", Integer.valueOf(a.fgf.decrementAndGet()));
                    }
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }
            });
        }
        FileOp.init(false);
        MMBitmapFactory.init();
        x.i("MicroMsg.ToolsProfile", "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.pluginsdk.model.x.a.eg(ad.getContext());
        com.tencent.xweb.util.b anonymousClass2 = new com.tencent.xweb.util.b() {
            public final void i(String str, String str2) {
                x.i(str, str2);
            }

            public final void e(String str, String str2) {
                x.e(str, str2);
            }

            public final void w(String str, String str2) {
                x.w(str, str2);
            }

            public final void d(String str, String str2) {
                x.d(str, str2);
            }

            public final void v(String str, String str2) {
                x.v(str, str2);
            }
        };
        com.tencent.xweb.q anonymousClass3 = new com.tencent.xweb.q() {
            public final void h(long j, long j2) {
                x.v("MicroMsg.ToolsProfile", "callback: idkeyStat:577" + ", " + j + ", 1");
                com.tencent.mm.plugin.report.service.g.pWK.a(577, j, 1, true);
            }

            public final void w(int i, int i2, int i3) {
                x.v("MicroMsg.ToolsProfile", "callback: idkeyForPair:577" + ", " + i + ", 1, 577" + ", " + i2 + ", " + i3);
                com.tencent.mm.plugin.report.service.g.pWK.a(577, 577, i, i2, 1, i3, true);
            }

            public final void k(int i, String str) {
                x.v("MicroMsg.ToolsProfile", "callback: kvStat:" + i + ", " + str);
                com.tencent.mm.plugin.report.service.g.pWK.k(i, str);
            }

            public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
                x.v("MicroMsg.ToolsProfile", "callback: kvStat:15003" + ", 17," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
                com.tencent.mm.plugin.report.service.g.pWK.h(15003, Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(ao.getNetType(ad.getContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            }
        };
        WebViewExtensionListener anonymousClass4 = new WebViewExtensionListener() {
            public final Object onMiscCallBack(String str, Object... objArr) {
                if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                    com.tencent.mm.svg.a.e.a((Resources) objArr[0], (Map) objArr[1]);
                }
                return null;
            }
        };
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.zEI);
        com.tencent.xweb.r.a(ad.getContext(), anonymousClass2, anonymousClass3, anonymousClass4);
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.downloader.f.a.aAR());
        WebView.initWebviewCore(ad.getContext(), MMWebView.zEH, "tools", new WebView.b() {
            public final void tI() {
                x.i("MicroMsg.ToolsProfile", "onCoreInitFinished");
            }

            public final void tJ() {
                x.i("MicroMsg.ToolsProfile", "onCoreInitFailed");
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(new j(22, 32));
        com.tencent.mm.pluginsdk.model.x.a.bZi();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.ToolsProfile", "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            x.w("MicroMsg.ToolsProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return ffs;
    }
}
