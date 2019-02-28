package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.appcache.b.d.h;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.sdk.e.e;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

final class a {
    static final Map<a, String[]> iFm = new HashMap();
    private static final Map<Class, Object> iFn = new HashMap();

    public interface a<T> {
        T b(e eVar);
    }

    private static void a(a aVar, String[] strArr) {
        iFm.put(aVar, strArr);
    }

    static {
        a(new a<i>() {
            public final /* synthetic */ Object b(e eVar) {
                return new i(eVar);
            }
        }, i.iHj);
        a(new a<v>() {
            public final /* synthetic */ Object b(e eVar) {
                return new v(eVar);
            }
        }, v.iHj);
        a(new a<g>() {
            public final /* synthetic */ Object b(e eVar) {
                return new g(eVar);
            }
        }, g.iHj);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.b.d.e>() {
            public final /* synthetic */ Object b(e eVar) {
                return new com.tencent.mm.plugin.appbrand.appcache.b.d.e(eVar);
            }
        }, com.tencent.mm.plugin.appbrand.appcache.b.d.e.iHj);
        a(new a<z>() {
            public final /* synthetic */ Object b(e eVar) {
                return new z(eVar);
            }
        }, z.iHj);
        a(new a<d>() {
            public final /* synthetic */ Object b(e eVar) {
                return new d(eVar);
            }
        }, d.iHj);
        a(new a<h>() {
            public final /* synthetic */ Object b(e eVar) {
                return new h(eVar);
            }
        }, h.iHj);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.b.d.d>() {
            public final /* synthetic */ Object b(e eVar) {
                return new com.tencent.mm.plugin.appbrand.appcache.b.d.d(eVar);
            }
        }, com.tencent.mm.plugin.appbrand.appcache.b.d.d.iHj);
        a(new a<x>() {
            public final /* synthetic */ Object b(e eVar) {
                return new x(eVar);
            }
        }, x.iHj);
        a(new a<b>() {
            public final /* synthetic */ Object b(e eVar) {
                return new b(eVar);
            }
        }, b.iHj);
    }

    static void a(e eVar) {
        synchronized (iFn) {
            iFn.clear();
            for (a b : iFm.keySet()) {
                Object b2 = b.b(eVar);
                iFn.put(b2.getClass(), b2);
            }
        }
    }

    static void Zh() {
        synchronized (iFn) {
            iFn.clear();
        }
    }

    static <T> T u(Class<T> cls) {
        T t;
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (iFn) {
            t = iFn.get(cls);
        }
        return t;
    }
}
