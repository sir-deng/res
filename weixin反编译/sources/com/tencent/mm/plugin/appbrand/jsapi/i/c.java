package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = e.b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            jVar.E(i, e("fail", null));
            return;
        }
        m.o(b);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("confirmText", jVar.getContext().getString(q.j.dGf));
        final String optString3 = jSONObject.optString("cancelText", jVar.getContext().getString(q.j.dEy));
        final Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showCancel", true));
        final int aR = f.aR(jSONObject.optString("confirmColor", ""), Color.parseColor("#3CC51F"));
        final int aR2 = f.aR(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"));
        final String optString4 = jSONObject.optString("content");
        final j jVar2 = jVar;
        final int i2 = i;
        ah.y(new Runnable() {
            public final void run() {
                if (jVar2.Vx) {
                    h bVar = new b(c.this.a(jVar2));
                    if (!bi.oN(optString)) {
                        bVar.setTitle(optString);
                    }
                    bVar.setMessage(optString4);
                    bVar.a(optString2, true, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(true));
                            hashMap.put("cancel", Boolean.valueOf(false));
                            jVar2.E(i2, c.this.e("ok", hashMap));
                        }
                    });
                    if (valueOf.booleanValue()) {
                        bVar.b(optString3, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Map hashMap = new HashMap();
                                hashMap.put("confirm", Boolean.valueOf(false));
                                hashMap.put("cancel", Boolean.valueOf(true));
                                dialogInterface.dismiss();
                                jVar2.E(i2, c.this.e("ok", hashMap));
                            }
                        });
                    }
                    bVar.setOnCancelListener(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(false));
                            hashMap.put("cancel", Boolean.valueOf(false));
                            jVar2.E(i2, c.this.e("ok", hashMap));
                        }
                    });
                    bVar.EQ(aR);
                    if (valueOf.booleanValue()) {
                        bVar.ER(aR2);
                    }
                    jVar2.iuk.a(bVar);
                }
            }
        });
    }
}
