package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.b;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.c$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] juU = new int[b.a.ajp().length];

        static {
            try {
                juU[b.a.jIl - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                juU[b.a.jIi - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                juU[b.a.jIj - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                juU[b.a.jIk - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("hide", false);
        jSONObject.optString("text", "");
        jSONObject.optString("iconPath", "");
        int a = b.a(e.b(jVar), optBoolean);
        String str = "fail";
        switch (AnonymousClass1.juU[a - 1]) {
            case 1:
                str = "ok";
                break;
            case 2:
                str = "fail no page available";
                break;
            case 3:
                str = "fail iconPath not found";
                break;
            case 4:
                str = "fail invalid text length";
                break;
        }
        jVar.E(i, e(str, null));
    }
}
