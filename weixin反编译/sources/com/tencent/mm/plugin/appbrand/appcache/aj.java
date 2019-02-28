package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aj implements InvocationHandler {
    private final Map<String, Method> iIp = new ConcurrentHashMap();
    private final a iIq;

    private static final class a implements Closeable {
        private final m iIr;
        private final Map<ag, o> iIs;

        /* synthetic */ a(m mVar, byte b) {
            this(mVar);
        }

        private a(m mVar) {
            this.iIs = new HashMap();
            this.iIr = mVar;
        }

        final Collection<o> aau() {
            Collection<o> values;
            synchronized (this.iIs) {
                values = this.iIs.values();
            }
            return values;
        }

        final o qc(String str) {
            ag pT = this.iIr.pT(str);
            if (pT == null) {
                return null;
            }
            o oVar;
            synchronized (this.iIs) {
                oVar = (o) this.iIs.get(pT);
                if (oVar == null) {
                    Map map = this.iIs;
                    oVar = new o(pT);
                    map.put(pT, oVar);
                }
            }
            return oVar;
        }

        public final void close() {
            synchronized (this.iIs) {
                this.iIs.clear();
            }
            this.iIr.close();
        }
    }

    public static l i(e eVar) {
        try {
            InvocationHandler ajVar = new aj(ao.k(eVar));
            return (l) Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{l.class}, ajVar);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", e);
            return new g();
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getReturnType().equals(Boolean.TYPE)) {
            return Boolean.TRUE;
        }
        if (Modifier.isStatic(method.getModifiers())) {
            return null;
        }
        o qc;
        Method a;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            qc = this.iIq.qc((String) objArr[0]);
            if (qc == null) {
                return method.getReturnType().equals(j.class) ? j.ERR_PERMISSION_DENIED : null;
            } else {
                a = a(method);
                if (a != null) {
                    return a.invoke(qc, objArr);
                }
            }
        } else if (method.getReturnType().equals(Void.TYPE)) {
            Collection<o> aau = this.iIq.aau();
            if (aau != null) {
                a = a(method);
                if (a != null) {
                    for (o qc2 : aau) {
                        a.invoke(qc2, objArr);
                    }
                }
            }
            return null;
        }
        return null;
    }

    private Method a(Method method) {
        Method method2 = (Method) this.iIp.get(method.getName());
        if (method2 == null) {
            method2 = o.class.getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                this.iIp.put(method.getName(), method2);
            }
        }
        return method2;
    }

    private aj(m mVar) {
        this.iIq = new a(mVar, (byte) 0);
    }
}
