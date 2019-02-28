package com.tencent.mm.app;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
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
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

public class AppBrandProfile extends e {
    protected static String feQ = "";

    public final void onCreate() {
        feQ = ad.By();
        ClassLoader classLoader = AppBrandProfile.class.getClassLoader();
        a.ay(ad.getContext());
        i.a(new c() {
            public final void a(String str, Throwable th) {
                g.pWK.a(365, 3, 1, false);
                KVCommCrossProcessReceiver.boQ();
            }
        });
        q pVar = new p(com.tencent.mm.booter.c.aA(this.app.getBaseContext()));
        pVar.eg("APPBRAND" + feQ.replace(ad.getPackageName() + ":appbrand", ""));
        r.ifb = bi.a(pVar.eh(".com.tencent.mm.debug.test.display_errcode"), false);
        r.ifc = bi.a(pVar.eh(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.ifd = bi.a(pVar.eh(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.ife = bi.a(pVar.eh(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iff = bi.a(pVar.eh(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.ifg = bi.a(pVar.eh(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.ifk = bi.a(pVar.eh(".com.tencent.mm.debug.test.album_show_info"), false);
        r.ifl = bi.a(pVar.eh(".com.tencent.mm.debug.test.location_help"), false);
        r.ifo = bi.a(pVar.eh(".com.tencent.mm.debug.test.force_soso"), false);
        r.ifp = bi.a(pVar.eh(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.ifq = bi.a(pVar.eh(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.ifr = bi.a(pVar.eh(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ifu = bi.a(pVar.eh(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.ifv = bi.a(pVar.eh(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(pVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.ifs = a;
        if (a != 4 && r.ifs > 0) {
            v.xuZ = r.ifs;
            x.e("MicroMsg.AppBDebugger", "cdn thread num " + r.ifs);
        }
        r.ift = bi.a(pVar.eh(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.ifL = bi.a(pVar.eh(".com.tencent.mm.debug.forcex5webview"), false);
        r.ifI = bi.aD(pVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + r.ifI);
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CX(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            String string = pVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oN(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vHg = "android-" + string;
                d.vHi = string;
                b.Vn(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.cfy());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vHk).append(" new: ").append(a);
            d.vHk = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            pVar.gAA.gzJ = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(pVar.eh(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(pVar.eh(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(pVar.eh(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(pVar.eh(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        i.cq(feQ);
        a.cl(feQ);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.xmq, classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int yw = m.yw();
        if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            x.i("MicroMsg.AppBrandProfile", "load wechatsight_v7a, core number: %d", Integer.valueOf(yw >> 12));
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
            x.i("MicroMsg.AppBrandProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.qyY = 1;
            com.tencent.mm.plugin.sight.base.b.qza = 1;
            com.tencent.mm.plugin.sight.base.b.qzb = 640000;
        }
        a.ay(ad.getContext());
        m.ua();
        MMActivity.initLanguage(this.app.getBaseContext());
        FileOp.init(false);
        MMBitmapFactory.init();
        com.tencent.xweb.r.a(ad.getContext(), new com.tencent.xweb.util.b() {
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
        }, new com.tencent.xweb.q() {
            public final void h(long j, long j2) {
                x.v("MicroMsg.AppBrandProfile", "callback: idkeyStat:577" + ", " + j + ", 1");
                g.pWK.a(577, j, 1, true);
            }

            public final void w(int i, int i2, int i3) {
                x.v("MicroMsg.AppBrandProfile", "callback: idkeyForPair:577" + ", " + i + ", 1, 577" + ", " + i2 + ", " + i3);
                g.pWK.a(577, 577, i, i2, 1, i3, true);
            }

            public final void k(int i, String str) {
                x.v("MicroMsg.AppBrandProfile", "callback: kvStat:" + i + ", " + str);
                g.pWK.k(i, str);
            }

            public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
                x.v("MicroMsg.AppBrandProfile", "callback: kvStat:15003" + ", 17," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
                g.pWK.h(15003, Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(ao.getNetType(AppBrandProfile.this.app.getBaseContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            }
        }, new WebViewExtensionListener() {
            public final Object onMiscCallBack(String str, Object... objArr) {
                if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                    com.tencent.mm.svg.a.e.a((Resources) objArr[0], (Map) objArr[1]);
                }
                return null;
            }
        });
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.downloader.f.a.aAR());
        if (bi.chp()) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        WebView.initWebviewCore(ad.getContext(), MMWebView.zEH, "appbrand", new WebView.b() {
            public final void tI() {
                x.i("MicroMsg.AppBrandProfile", "onCoreInitFinished");
            }

            public final void tJ() {
                x.i("MicroMsg.AppBrandProfile", "onCoreInitFailed");
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(new j(42, 52));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        x.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", Integer.valueOf(i));
    }
}
