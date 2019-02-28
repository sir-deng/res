package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class e extends b {
    public String jfn;

    public final String e(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", getName() + ":" + str);
        if (map != null) {
            if (b.cfx() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        c.m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public final String a(j jVar, String str, Map<String, ? extends Object> map) {
        if (l.a(jVar, (Map) map, (b) this)) {
            return e(str, map);
        }
        return e(this.jfn, null);
    }

    public MMActivity a(j jVar) {
        n nVar = jVar.iuk.isX;
        if (nVar == null) {
            return null;
        }
        Context context = nVar.getContext();
        if (context instanceof MMActivity) {
            return (MMActivity) context;
        }
        return null;
    }

    public static p b(j jVar) {
        n nVar = jVar.iuk.isX;
        if (nVar == null || nVar.ajy() == null) {
            return null;
        }
        return nVar.ajy().aeO();
    }
}
