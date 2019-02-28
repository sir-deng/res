package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum i {
    ;
    
    private static volatile long iMo;
    private static volatile ajc iMp;
    private static final Set<b> iMq = null;

    enum a {
        private static final /* synthetic */ a[] iMA = null;
        public static final a iMx = null;
        public static final a iMy = null;
        public static final a iMz = null;
        final int value;

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) iMA.clone();
        }

        static {
            iMx = new a("FORCE_OFF", 0, 0);
            iMy = new a("FORCE_ON", 1, 1);
            iMz = new a("DYNAMIC_THRESHOLD", 2, 2);
            iMA = new a[]{iMx, iMy, iMz};
        }

        private a(String str, int i, int i2) {
            this.value = i2;
        }
    }

    public interface b {
        void abj();
    }

    static {
        iMq = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(b bVar) {
        if (bVar != null) {
            iMq.add(bVar);
        }
    }

    public static void b(b bVar) {
        if (bVar != null) {
            iMq.remove(bVar);
        }
    }

    public static boolean abb() {
        return true;
    }

    public static boolean abc() {
        switch (abd()) {
            case iMy:
                return true;
            case iMz:
                if (abe()) {
                    return true;
                }
                return iMp != null && iMp.kqh >= iMp.wxf;
            default:
                return false;
        }
    }

    public static boolean refresh() {
        iMp = null;
        iMo = 0;
        if (a.iMx == abd()) {
            return false;
        }
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        al alVar = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (!pBool2.value) {
                    pBool.value = true;
                    i.a(null);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        alVar.K(toMillis, toMillis);
        c.OV().b((com.tencent.mm.modelgeo.a.a) com.tencent.mm.plugin.appbrand.r.c.bk(new com.tencent.mm.modelgeo.a.a() {
            private int iMu;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                com.tencent.mm.plugin.appbrand.r.c.bl(this);
                c.OV().c(this);
                int i2 = this.iMu + 1;
                this.iMu = i2;
                if (i2 > 1 || pBool.value) {
                    return false;
                }
                pBool2.value = true;
                if (z) {
                    com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                    aVar.hnS = 1056;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
                    com.tencent.mm.bp.a ajb = new ajb();
                    ajb.wwY = (double) f;
                    ajb.wwZ = (double) f2;
                    ajb.wxb = !i.abe();
                    aVar.hnT = ajb;
                    aVar.hnU = new ajc();
                    u.a(aVar.Kf(), new com.tencent.mm.ad.u.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                            if (i == 0 && i2 == 0 && bVar != null && bVar.hnR.hnY != null && (bVar.hnR.hnY instanceof ajc)) {
                                i.a((ajc) bVar.hnR.hnY);
                            } else {
                                x.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                i.a(null);
                            }
                            return 0;
                        }
                    }, true);
                    return false;
                }
                i.a(null);
                return false;
            }
        }), false);
        return true;
    }

    static a abd() {
        int i = 0;
        if (!g.Do().CF()) {
            return a.iMx;
        }
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100215");
        if (fp.isValid()) {
            int i2 = bi.getInt((String) fp.civ().get("isOpenNewNearEntry"), 0);
            a[] values = a.values();
            int length = values.length;
            while (i < length) {
                a aVar = values[i];
                if (aVar.value == i2) {
                    return aVar;
                }
                i++;
            }
        }
        return a.iMx;
    }

    static boolean abe() {
        return g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, false);
    }

    static void abf() {
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, Boolean.valueOf(true));
    }

    public static ajc abg() {
        return iMp;
    }

    public static boolean abh() {
        long Wx = bi.Wx();
        long j = (!g.Do().CF() || iMp == null) ? 0 : iMo;
        return Wx >= j;
    }

    public static void abi() {
        iMp = null;
    }
}
