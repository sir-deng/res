package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.ccu;
import com.tencent.mm.protocal.c.ccv;
import com.tencent.mm.protocal.c.ccx;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.i;
import java.util.Iterator;
import java.util.List;

public final class r {

    public interface b<T> {
        void d(int i, T t);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ List iSo;

        public AnonymousClass2(List list) {
            this.iSo = list;
        }

        public final void run() {
            for (String O : this.iSo) {
                r.O(O, true);
            }
        }
    }

    interface a<T> {
        boolean aZ(T t);

        String getUsername();

        l rv(String str);

        T rw(String str);
    }

    static boolean rq(String str) {
        if (e.Zs() == null) {
            x.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
            return false;
        }
        long Wx = bi.Wx();
        WxaAttributes f = e.Zs().f(str, "syncTimeSecond");
        x.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", str, Long.valueOf(Wx), Long.valueOf(f == null ? 0 : f.field_syncTimeSecond), Integer.valueOf(g.Af().getInt("MMBizAttrSyncFreq", 3600)));
        if (Wx - (f == null ? 0 : f.field_syncTimeSecond) >= ((long) g.Af().getInt("MMBizAttrSyncFreq", 3600))) {
            return true;
        }
        return false;
    }

    private static boolean rr(String str) {
        if (bi.oN(str) || i.fX(str)) {
            return false;
        }
        x.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", str, aj.i(new Throwable()));
        d.pVE.a(648, 1, 1, false);
        return true;
    }

    static com.tencent.mm.bp.b rs(String str) {
        WxaAttributes f = e.Zs().f(str, "syncVersion");
        return new com.tencent.mm.bp.b(f == null ? new byte[0] : bi.Wj(bi.oM(f.field_syncVersion)));
    }

    public static void rt(final String str) {
        if (!rr(str)) {
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    r.ru(str);
                }
            }, "WxaAttrSync");
        }
    }

    public static Pair<WxaAttributes, com.tencent.mm.ad.a.a> O(final String str, boolean z) {
        return a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean aZ(Object obj) {
                return bi.oN(((WxaAttributes) obj).field_versionInfo);
            }

            public final /* synthetic */ Object rw(String str) {
                return e.Zs().g(str, new String[0]);
            }

            public final String getUsername() {
                return q.rn(str);
            }

            public final l rv(String str) {
                return new l(null, str);
            }
        });
    }

    static <T> Pair<T, com.tencent.mm.ad.a.a> a(String str, boolean z, a<T> aVar) {
        int i = -1;
        Object obj = null;
        if (bi.oN(str)) {
            return Pair.create(null, null);
        }
        Object obj2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = aVar.rw(str);
            if (!(obj2 == null || aVar.aZ(obj2))) {
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", Boolean.valueOf(z), obj2);
                return Pair.create(obj2, obj);
            }
        }
        com.tencent.mm.ad.a.a c = com.tencent.mm.plugin.appbrand.i.d.c(aVar.rv(str).gLB);
        if (c == null || (c instanceof com.tencent.mm.plugin.appbrand.i.d.a) || c.errType != 0 || c.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(c == null ? -1 : c.errType);
            if (c != null) {
                i = c.errCode;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = c == null ? "null resp" : c.foE;
            x.e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = aVar.rw(str);
                if (obj2 == null) {
                    return Pair.create(null, c);
                }
            }
            return Pair.create(obj2, c);
        }
        String str4;
        String str5;
        Iterator it = ((ccv) c.fKE).vTZ.iterator();
        while (it.hasNext()) {
            ccu ccu = (ccu) it.next();
            if ("UserName".equalsIgnoreCase(ccu.vUa)) {
                str4 = ccu.pWq;
                if (!str4.endsWith("@app")) {
                    str4 = str4 + "@app";
                }
                if (bi.oN(str4)) {
                    str4 = aVar.getUsername();
                    if (bi.oN(str4)) {
                        x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", Boolean.valueOf(z), str);
                        return Pair.create(null, null);
                    }
                }
                str5 = str4;
                if (e.Zs().a(str5, ((ccv) c.fKE).vTY, ((ccv) c.fKE).vTZ)) {
                    q.acp().b("single", 3, str5);
                }
                obj2 = aVar.rw(str);
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
                obj = c;
                return Pair.create(obj2, obj);
            }
        }
        str4 = null;
        if (bi.oN(str4)) {
            str4 = aVar.getUsername();
            if (bi.oN(str4)) {
                x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", Boolean.valueOf(z), str);
                return Pair.create(null, null);
            }
        }
        str5 = str4;
        if (e.Zs().a(str5, ((ccv) c.fKE).vTY, ((ccv) c.fKE).vTZ)) {
            q.acp().b("single", 3, str5);
        }
        obj2 = aVar.rw(str);
        x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
        obj = c;
        return Pair.create(obj2, obj);
    }

    public static Pair<WxaAttributes, com.tencent.mm.ad.a.a> P(final String str, boolean z) {
        if (rr(str)) {
            return new Pair(null, null);
        }
        return a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean aZ(Object obj) {
                return bi.oN(((WxaAttributes) obj).field_versionInfo);
            }

            public final /* synthetic */ Object rw(String str) {
                return e.Zs().f(str, new String[0]);
            }

            public final String getUsername() {
                return str;
            }

            public final l rv(String str) {
                return new l(str, null);
            }
        });
    }

    public static void a(final String str, final boolean z, final b<WxaAttributes> bVar) {
        if (!rr(str)) {
            Looper looper;
            boolean z2;
            if (ah.isMainThread() || Looper.myLooper() == null) {
                looper = new ah().oFY.getLooper();
                z2 = true;
            } else {
                looper = Looper.myLooper();
                z2 = false;
            }
            new ag(looper).post(new Runnable() {
                public final void run() {
                    int i = 1;
                    String str = str;
                    boolean z = z && r.rq(str);
                    Pair a = r.a(str, z, new a<WxaAttributes>() {
                        public final /* synthetic */ boolean aZ(Object obj) {
                            return bi.oN(((WxaAttributes) obj).field_versionInfo);
                        }

                        public final /* synthetic */ Object rw(String str) {
                            return e.Zs().f(str, new String[0]);
                        }

                        public final String getUsername() {
                            return str;
                        }

                        public final l rv(String str) {
                            return new l(str, null);
                        }
                    });
                    if (bVar != null) {
                        if (a.second != null) {
                            if (((com.tencent.mm.ad.a.a) a.second).errType == 0 && ((com.tencent.mm.ad.a.a) a.second).errCode == 0) {
                                i = 2;
                            } else {
                                i = 3;
                            }
                        }
                        bVar.d(i, a.first);
                    }
                    if (z2) {
                        try {
                            ((HandlerThread) Looper.myLooper().getThread()).quit();
                        } catch (Exception e) {
                        }
                    }
                }
            });
        }
    }

    public static void ru(String str) {
        if (!rr(str) && rq(str)) {
            P(str, true);
        }
    }

    public static void a(final List<String> list, com.tencent.mm.plugin.appbrand.config.k.a aVar) {
        int i = 0;
        if (!bi.cC(list)) {
            if (ah.isMainThread()) {
                c.Dt().F(new Runnable() {
                    public final void run() {
                        r.a(list, com.tencent.mm.plugin.appbrand.config.k.a.DEFAULT);
                    }
                });
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!rq((String) it.next())) {
                    it.remove();
                }
            }
            if (!bi.cC(list)) {
                x.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.ordinal()));
                for (int i2 = 0; i2 < list.size() / 20; i2++) {
                    int i3 = i2 * 20;
                    i = i3 + 20;
                    b(list.subList(i3, i), aVar);
                }
                if (i < list.size()) {
                    b(list.subList(i, list.size()), aVar);
                }
            }
        }
    }

    private static void b(List<String> list, com.tencent.mm.plugin.appbrand.config.k.a aVar) {
        if (!bi.cC(list)) {
            new k(list, aVar).Kb().h(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<gp>>() {
                public final /* synthetic */ Object call(Object obj) {
                    int i = 0;
                    com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                    if (aVar.errType != 0 || aVar.errCode != 0) {
                        x.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.foE);
                    } else if (aVar.fKE != null) {
                        long dA = e.Zs().hiZ.dA(Thread.currentThread().getId());
                        Iterator it = ((gp) aVar.fKE).vSv.iterator();
                        while (it.hasNext()) {
                            ccx ccx = (ccx) it.next();
                            i = e.Zs().a(ccx.wXQ, ccx.vTY, ccx.vTZ) | i;
                        }
                        e.Zs().hiZ.fT(dA);
                        if (i != 0) {
                            q.acp().b("batch", 3, null);
                        }
                    }
                    return zLb;
                }
            });
        }
    }
}
