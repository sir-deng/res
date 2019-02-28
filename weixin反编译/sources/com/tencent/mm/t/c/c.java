package com.tencent.mm.t.c;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u.b;

public final class c {
    public a gQr;
    private com.tencent.mm.t.d.a gQs;
    public d gQt;
    public b gQu;

    private static final class a implements a {
        e gQx;
        public b gQy = new b();
        Context mContext;

        a(Context context, e eVar) {
            this.mContext = context;
            this.gQx = eVar;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final b Ci() {
            return this.gQy;
        }
    }

    public c(Context context, e eVar, com.tencent.mm.t.d.a aVar, b bVar) {
        this.gQr = new a(context, eVar);
        this.gQs = aVar;
        this.gQu = bVar;
    }

    public final String b(String str, String str2, final int i) {
        try {
            com.tencent.mm.t.b.b bVar = bi.oN(str) ? null : (com.tencent.mm.t.b.b) this.gQt.gQz.get(str);
            if (bVar == null) {
                return this.gQu.ft(str);
            }
            return this.gQu.a(this.gQr, this.gQs, bVar, str2, new com.tencent.mm.t.b.b.a() {
                public final void aw(Object obj) {
                    e eVar = c.this.gQr.gQx;
                    int i = i;
                    String obj2 = obj == null ? "" : obj.toString();
                    if (bi.oN(obj2)) {
                        obj2 = "{}";
                    }
                    eVar.gQD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), obj2}), null);
                }
            });
        } catch (Throwable e) {
            x.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", str, Log.getStackTraceString(e));
            throw e;
        }
    }
}
