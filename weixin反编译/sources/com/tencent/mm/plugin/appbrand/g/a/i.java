package com.tencent.mm.plugin.appbrand.g.a;

import android.util.Log;
import android.util.Pair;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.plugin.appbrand.g.a.f.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class i {
    j iuy;
    private final AtomicInteger jBX = new AtomicInteger(0);
    public final HashMap<Integer, f> jBY = new HashMap();
    private a jBZ = new a() {
        public final int air() {
            return i.this.iuy.Zd();
        }

        public final ByteBuffer jw(int i) {
            return i.this.iuy.jw(i);
        }

        public final void a(int i, ByteBuffer byteBuffer) {
            i.this.iuy.a(i, byteBuffer);
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.g.a.i$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String gKe;
        final /* synthetic */ f jCa;

        public AnonymousClass3(f fVar, String str) {
            this.jCa = fVar;
            this.gKe = str;
        }

        public final void run() {
            f fVar = this.jCa;
            String str = this.gKe;
            if (fVar.jBI.getType("onmessage") == 7) {
                V8Function v8Function = (V8Function) fVar.jBI.get("onmessage");
                V8Array v8Array = new V8Array(fVar.jBI);
                v8Array.push(str);
                v8Function.call(null, v8Array);
                v8Function.release();
                v8Array.release();
            }
        }
    }

    public i(j jVar) {
        this.iuy = jVar;
    }

    public final int a(Pair<String, String>... pairArr) {
        final int addAndGet = this.jBX.addAndGet(1);
        final f fVar = new f(this.jBZ);
        fVar.jBK.p(new AnonymousClass5(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() > 0 && v8Array.getType(0) == 4) {
                    i.this.iuy.z(addAndGet, v8Array.getString(0));
                }
            }
        }, "postMessage"));
        fVar.jBK.jBV = new d() {
            public final void aN(String str, String str2) {
                x.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", str, str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message", str);
                    jSONObject.put("stack", str2);
                } catch (Throwable e) {
                    x.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(e));
                }
                f fVar = fVar;
                fVar.jBK.p(new com.tencent.mm.plugin.appbrand.g.a.f.AnonymousClass3(null, String.format("WeixinWorker.errorHandler(%s)", new Object[]{jSONObject})));
            }
        };
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 5) {
                Pair pair = pairArr[i2];
                if (!(pair == null || pair.second == null || ((String) pair.second).length() == 0)) {
                    String str = (String) pair.first;
                    fVar.jBK.p(new com.tencent.mm.plugin.appbrand.g.a.f.AnonymousClass4(null, (String) pair.second, str));
                }
                i = i2 + 1;
            } else {
                this.jBY.put(Integer.valueOf(addAndGet), fVar);
                return addAndGet;
            }
        }
    }
}
