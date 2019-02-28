package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.d.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    boolean Vx;
    public Handler iWP;
    final c jeZ;
    private final b jfa;
    private final Map<String, e> jfb;
    private int jfc;
    private ConcurrentHashMap<Integer, String> jfd;

    public d(j jVar, b bVar) {
        this(jVar, bVar, g.afJ());
    }

    public d(p pVar, b bVar) {
        this(pVar, bVar, g.afK());
    }

    public d(com.tencent.mm.plugin.appbrand.game.d dVar, b bVar) {
        this(dVar, bVar, c.aeC());
    }

    private d(c cVar, b bVar, Map<String, e> map) {
        this.jfc = 0;
        this.jfd = new ConcurrentHashMap();
        this.jeZ = cVar;
        this.jfa = bVar;
        this.Vx = true;
        this.jfb = map;
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.iWP = new Handler(handlerThread.getLooper());
    }

    public final void cleanup() {
        this.iWP.getLooper().quit();
        this.Vx = false;
        this.jfd.clear();
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void publishHandler(final String str, final String str2, final String str3) {
        int i = 0;
        this.iWP.post(new Runnable() {
            public final void run() {
                d.this.jeZ.a(str, str2, d.sy(str3));
            }
        });
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "publishHandler, event: %s, data size: %d, data : %s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = str2;
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        try {
            final int a = this.jeZ.a(this.jfa, i);
            e eVar = (e) this.jfb.get(str);
            if (eVar == null) {
                this.jeZ.E(a, G(str, "fail:not supported"));
                return "fail:not supported";
            }
            String str4;
            String a2;
            boolean z = eVar instanceof l;
            h hVar = this.jeZ.jeV;
            c cVar = this.jeZ;
            if (this.jeZ.YZ() == null) {
                str4 = "";
            } else {
                n nVar = this.jeZ.YZ().isX;
                str4 = (nVar == null || nVar.ajy() == null) ? "" : nVar.ajy().aeH();
            }
            hVar.jfr.put(Integer.valueOf(a), new a(cVar, eVar, str2, System.currentTimeMillis(), str4));
            if (z) {
                a2 = a(str, str2, a, true);
            } else {
                final String str5 = str;
                final String str6 = str2;
                this.iWP.post(new Runnable() {
                    public final void run() {
                        if (d.this.Vx) {
                            d.this.a(str5, str6, a, false);
                        }
                    }
                });
                a2 = str3;
            }
            if ((!a.a(m.jfA, eVar.getClass()) ? 1 : null) == null) {
                return a2;
            }
            int i2;
            String str7 = "MicroMsg.AppBrandJSInterface";
            String str8 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                i2 = 0;
            } else {
                i2 = str2.length();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            x.i(str7, str8, objArr);
            return a2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, " Invoke Error %s", str);
            throw e;
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String retrieveEvent(int i) {
        String str = (String) this.jfd.get(Integer.valueOf(i));
        this.jfd.remove(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final boolean isDebugPackage() {
        return com.tencent.mm.sdk.a.b.cfx();
    }

    private String a(String str, String str2, int i, boolean z) {
        if (this.jeZ.YZ() == null || !this.jeZ.isRunning()) {
            return G(str, "fail:interrupted");
        }
        final e eVar = (e) this.jfb.get(str);
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        final boolean z2 = z;
        com.tencent.mm.plugin.appbrand.permission.c.a a = com.tencent.mm.plugin.appbrand.permission.c.r(this.jeZ.YZ()).a(this.jeZ, eVar, new com.tencent.mm.plugin.appbrand.permission.c.b() {
            public final void a(com.tencent.mm.plugin.appbrand.permission.c.a aVar) {
                if (d.this.jeZ != null && d.this.jeZ.isRunning()) {
                    if (aVar.code == 1) {
                        d.this.iWP.post(new Runnable() {
                            public final void run() {
                                if (d.this.jeZ != null && d.this.jeZ.isRunning()) {
                                    d.this.a(str3, str4, i2, z2);
                                }
                            }
                        });
                    } else {
                        d.this.jeZ.E(i2, eVar.e(aVar.fpV, null));
                    }
                }
            }
        });
        if (3 == a.code) {
            return "";
        }
        String e;
        if (a.code != 1) {
            e = eVar.e(a.fpV, null);
        } else {
            JSONObject sx = sx(str2);
            if (sx == null) {
                e = eVar.e("fail:invalid data", null);
            } else if (z) {
                e = ((l) eVar).a(this.jeZ, sx);
            } else {
                ((a) eVar).a(this.jeZ, sx, i);
                e = null;
            }
        }
        if (e != null) {
            this.jeZ.jeV.H(i, e);
        }
        if (!z) {
            if (e != null) {
                this.jeZ.E(i, e);
            }
            return "";
        } else if (bi.oN(e)) {
            return "{}";
        } else {
            return e;
        }
    }

    private static JSONObject sx(String str) {
        try {
            if (bi.oN(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return null;
        }
    }

    private static String G(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    static int[] sy(String str) {
        int[] iArr;
        Exception e;
        int[] iArr2 = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    iArr[i] = jSONArray.getInt(i);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            iArr = iArr2;
            e = exception;
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return iArr;
        }
        return iArr;
    }
}
