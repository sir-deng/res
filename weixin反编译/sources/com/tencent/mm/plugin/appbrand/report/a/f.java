package com.tencent.mm.plugin.appbrand.report.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.plugin.appbrand.jsapi.f.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.map.n;
import com.tencent.mm.plugin.appbrand.jsapi.storage.i;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.g;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static final ThreadPoolExecutor jNA = new ThreadPoolExecutor(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            Thread d = e.d(runnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
            if (d.isDaemon()) {
                d.setDaemon(false);
            }
            return d;
        }
    }) {
        protected final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (runnable instanceof a) {
                f.jNB.a((a) runnable);
            }
        }
    };
    private static final b jNB = new b();
    private static final Pattern jNC = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");
    private static final Set<String> jNx = new HashSet();
    private static final String[] jNy = new String[]{com.tencent.mm.plugin.appbrand.jsapi.map.a.NAME, com.tencent.mm.plugin.appbrand.jsapi.map.b.NAME, c.NAME, d.NAME, JsApiCreateAudioInstance.NAME, com.tencent.mm.plugin.appbrand.jsapi.f.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.f.d.NAME, JsApiDestroyInstanceAudio.NAME, v.NAME, com.tencent.mm.plugin.appbrand.jsapi.c.b.NAME, JsApiGetAudioState.NAME, "getCurrentRoute", com.tencent.mm.plugin.appbrand.jsapi.map.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, ad.NAME, "hideToast", j.NAME, "onAccelerometerChange", "onCompassChange", com.tencent.mm.plugin.appbrand.jsapi.e.f.b.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", JsApiOperateAudio.NAME, h.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.h.NAME, "reportIDKey", com.tencent.mm.plugin.appbrand.jsapi.j.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.j.d.NAME, JsApiSetAudioState.NAME, i.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.j.NAME, "showModal", "showToast", "syncAudioEvent", com.tencent.mm.plugin.appbrand.jsapi.c.f.NAME, n.NAME};
    private static final Set<String> jNz = new HashSet(Arrays.asList(jNy));

    private static final class a implements Runnable {
        String appId;
        String foj;
        String fxq;
        String jND;
        int jNE;
        long jNF;
        String jiz;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(this.appId);
            if (pl == null) {
                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
            } else if (!f.jNz.contains(this.jND)) {
                String str = "";
                if (!(bi.oN(this.jiz) || bi.oN(this.jND))) {
                    try {
                        com.tencent.mm.u.c fB = g.fB(this.jiz);
                        if (fB.has(SlookSmartClipMetaTag.TAG_TYPE_URL) && (this.jND.equals(ao.NAME) || this.jND.equals(ax.NAME) || this.jND.equals(ak.NAME) || this.jND.equals("request") || this.jND.equals("connectSocket") || this.jND.equals("uploadFile") || this.jND.equals("downloadFile"))) {
                            str = fB.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        } else if (this.jND.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME)) {
                            try {
                                com.tencent.mm.u.a fC = g.fC(fB.optString("scope"));
                                LinkedList linkedList = new LinkedList();
                                for (int i = 0; i < fC.length(); i++) {
                                    linkedList.add(fC.optString(i));
                                }
                                str = linkedList.toString();
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", e.getMessage());
                                return;
                            }
                        } else if (this.jND.equals(com.tencent.mm.plugin.appbrand.jsapi.share.c.NAME)) {
                            try {
                                str = URLEncoder.encode(bi.oM(fB.toString()), "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "", new Object[0]);
                            }
                        } else if (this.jND.equals(com.tencent.mm.plugin.appbrand.jsapi.g.e.NAME)) {
                            str = fB.optString("package");
                        } else if (this.jND.equals(ay.NAME)) {
                            str = com.tencent.mm.plugin.appbrand.i.pE(this.appId).iud;
                        } else if (this.jND.equals(ai.NAME)) {
                            str = fB.optString("phoneNumber");
                        } else if (this.jND.equals("chooseVideo")) {
                            str = fB.optString("maxDuration");
                        } else if (this.jND.equals(com.tencent.mm.plugin.appbrand.jsapi.n.h.NAME)) {
                            str = fB.optString("src");
                            try {
                                str = URLEncoder.encode(fB.optString("src"), "UTF-8");
                            } catch (Exception e3) {
                                x.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3.toString());
                            }
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e22, "get keyParam error!", new Object[0]);
                    }
                }
                String str2 = "";
                if (!bi.oN(this.foj) && this.foj.contains(".html")) {
                    str2 = this.foj.substring(0, this.foj.lastIndexOf(".html") + 5);
                }
                String str3 = "";
                try {
                    str3 = URLEncoder.encode(bi.oM(str2), "UTF-8");
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e4, "encode page path error!", new Object[0]);
                }
                String str4 = "";
                try {
                    str4 = URLEncoder.encode(bi.oM(str), "UTF-8");
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e5, "encode keyParam path error!", new Object[0]);
                }
                String oM = bi.oM(this.jND);
                int uJ = f.uJ(f.uI(this.fxq));
                String oM2 = bi.oM(pl.foi);
                String cf = com.tencent.mm.plugin.appbrand.report.a.cf(com.tencent.mm.sdk.platformtools.ad.getContext());
                if (pl.scene == 0) {
                    pl.scene = 1000;
                }
                AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(this.appId);
                if (pk != null) {
                    int i2 = pk.iRU.iJb;
                    int i3 = pk.iRU.iJa + 1;
                    int uD = com.tencent.mm.plugin.appbrand.report.a.uD(this.appId);
                    x.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d", Integer.valueOf(pl.scene), oM2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str2, cf, oM, str, Integer.valueOf(uJ), Integer.valueOf(this.jNE), Integer.valueOf(0), Long.valueOf(this.jNF), Integer.valueOf(0), r8, Integer.valueOf(pl.jMN), Integer.valueOf(uD));
                    Object[] objArr = new Object[]{Integer.valueOf(pl.scene), oM2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str3, cf, oM, str4, Integer.valueOf(uJ), Integer.valueOf(this.jNE), Integer.valueOf(0), Long.valueOf(this.jNF), Integer.valueOf(0), r8, Integer.valueOf(pl.jMN), Integer.valueOf(pl.fJn), pl.fJo, Integer.valueOf(uD)};
                    com.tencent.mm.plugin.report.service.g.pWK.h(13542, objArr);
                    if (f.jNx.contains(oM)) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(15007, objArr);
                    }
                }
            }
        }
    }

    private static final class b implements android.support.v4.e.i.a<a> {
        private final Queue<a> jNG;

        private b() {
            this.jNG = new ConcurrentLinkedQueue();
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final /* synthetic */ Object bH() {
            return akG();
        }

        public final /* synthetic */ boolean j(Object obj) {
            return a((a) obj);
        }

        public final a akG() {
            a aVar = (a) this.jNG.poll();
            return aVar == null ? new a() : aVar;
        }

        public final boolean a(a aVar) {
            return this.jNG.offer(aVar);
        }
    }

    static /* synthetic */ String uI(String str) {
        if (!bi.oN(str)) {
            Matcher matcher = jNC.matcher(str);
            if (matcher.matches()) {
                return bi.oM(matcher.group(1));
            }
        }
        return "";
    }

    static /* synthetic */ int uJ(String str) {
        return (bi.oN(str) || str.startsWith("ok") || !str.startsWith("fail")) ? 1 : 2;
    }

    public static void akC() {
    }

    static {
        InputStream open;
        try {
            open = com.tencent.mm.sdk.platformtools.ad.getContext().getAssets().open("15007_api_list.txt");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "open read 15007_api_list.txt", new Object[0]);
            open = null;
        }
        if (open != null) {
            Closeable inputStreamReader = new InputStreamReader(open);
            Closeable bufferedReader = new BufferedReader(inputStreamReader);
            loop0:
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break loop0;
                    } else if (!bi.oN(readLine)) {
                        jNx.add(readLine);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "readLine()", new Object[0]);
                } finally {
                    bi.d(bufferedReader);
                    bi.d(inputStreamReader);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        if (!bi.oN(str)) {
            Runnable akG = jNB.akG();
            akG.appId = str;
            akG.foj = str2;
            akG.jND = str3;
            akG.jiz = str4;
            akG.jNE = i;
            akG.jNF = j;
            akG.fxq = str5;
            jNA.submit(akG);
        }
    }
}
