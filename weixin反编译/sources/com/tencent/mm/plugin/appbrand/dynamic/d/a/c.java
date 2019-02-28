package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.dynamic.i.a;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.c.b;
import com.tencent.mm.u.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c implements b {
    private Handler iWP;
    public a iWQ;

    public c() {
        HandlerThread handlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
        handlerThread.start();
        this.iWP = new Handler(handlerThread.getLooper());
    }

    public final String ft(String str) {
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", str);
        return G(str, "fail:not supported");
    }

    public final String a(com.tencent.mm.t.c.a aVar, com.tencent.mm.t.d.a aVar2, com.tencent.mm.t.b.b bVar, String str, com.tencent.mm.t.b.b.a aVar3) {
        String str2 = "";
        final String str3 = bVar.name;
        if (aVar2.go(bVar.index)) {
            String a;
            final String bH = k.bH(System.nanoTime());
            final boolean qN = d.qN(str3);
            com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", bH, "start_jsapi_invoke", qN);
            com.tencent.mm.plugin.appbrand.collector.c.aV(bH, "after_draw_actions");
            if (bVar instanceof b) {
                JSONObject rQ = rQ(str);
                if (rQ == null) {
                    return G(str3, "fail:invalid data");
                }
                a = bVar.a(aVar, rQ, aVar3);
            } else {
                final String str4 = str;
                final com.tencent.mm.t.b.b.a aVar4 = aVar3;
                final com.tencent.mm.t.b.b bVar2 = bVar;
                final com.tencent.mm.t.c.a aVar5 = aVar;
                this.iWP.post(new Runnable() {
                    public final void run() {
                        com.tencent.mm.plugin.appbrand.collector.c.f(bH, "parse_json_start", qN);
                        JSONObject rQ = c.rQ(str4);
                        if (rQ == null) {
                            aVar4.aw(c.this.G(str3, "fail:invalid data"));
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.collector.c.f(bH, "parse_json_end", qN);
                        d.a(bH, str4, rQ);
                        bVar2.a(aVar5, rQ, aVar4);
                    }
                });
                a = str2;
            }
            if (this.iWQ == null) {
                return a;
            }
            this.iWQ.rS(str3);
            return a;
        }
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", str3);
        return G(str3, "fail:access denied");
    }

    public final void quit() {
        this.iWP.getLooper().quit();
        if (this.iWQ != null) {
            this.iWQ.xd();
        }
    }

    static JSONObject rQ(String str) {
        try {
            if (bi.oN(str)) {
                str = "{}";
            }
            long nanoTime = System.nanoTime();
            JSONObject fA = g.fA(str);
            com.tencent.mm.plugin.appbrand.dynamic.i.b.f(System.nanoTime() - nanoTime, str.length());
            return fA;
        } catch (Throwable e) {
            x.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(e));
            return null;
        }
    }

    public final String G(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }
}
