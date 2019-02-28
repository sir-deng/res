package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.Arrays;
import java.util.Map;

public final class j {
    public static final c iMB = new c();

    public enum a {
        NONE(0),
        REDDOT(1),
        NEW(2);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static final class c {
    }

    public static final class d {
        public final String[] iMM = new String[9];

        public d() {
            Arrays.fill(this.iMM, "0");
            this.iMM[0] = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) "");
            this.iMM[1] = String.valueOf(g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0)));
            this.iMM[2] = String.valueOf(bi.Wx());
        }
    }

    public static final class e {
        public static final e iMN = new e();

        static int abq() {
            if (g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, false)) {
                return 1;
            }
            int intValue = ((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(0))).intValue();
            if (intValue > 0) {
                return intValue + 1;
            }
            return intValue;
        }

        static void a(String str, long j, int i, int i2) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14112, Integer.valueOf(1), bi.oM(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static final class b implements com.tencent.mm.y.bt.a {
        private static final b iMG = new b();

        static /* synthetic */ void qv(String str) {
            x.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(g.Do().CF()), str);
            if (g.Do().CF()) {
                Map y = bj.y(str, "sysmsg");
                if (y != null && y.size() > 0) {
                    Object obj = (String) y.get(".sysmsg.wxareddot.id");
                    int i = bi.getInt((String) y.get(".sysmsg.wxareddot.activitytype"), 0);
                    if (!bi.oN(obj)) {
                        if (i == 1 || i == 2) {
                            int i2 = bi.getInt((String) y.get(".sysmsg.wxareddot.close"), 0);
                            long j = bi.getLong((String) y.get(".sysmsg.wxareddot.pushtime"), 0);
                            long j2 = bi.getLong((String) y.get(".sysmsg.wxareddot.duration"), 0);
                            long j3 = bi.getLong((String) y.get(".sysmsg.wxareddot.frequency"), 0);
                            y.get(".sysmsg.wxareddot.tips");
                            int i3 = bi.getInt((String) y.get(".sysmsg.wxareddot.showType"), 0);
                            int i4 = bi.getInt((String) y.get(".sysmsg.wxareddot.reason"), 0);
                            switch (i) {
                                case 1:
                                    if (!obj.equals((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, null)) && !b.aaT() && !bi.by(ad.getContext()).equals(AppBrandLauncherUI.class.getName()) && i.abd() != a.iMx) {
                                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, obj);
                                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(j));
                                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(i3));
                                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(i4));
                                        if (i2 == 1 && j.abm()) {
                                            e eVar = e.iMN;
                                            e.a((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 4, e.abq());
                                        }
                                        j.a(i2 != 1, j2);
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (!obj.equals((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_MSG_ID_STRING, null))) {
                                        j.a(i2 != 1, j2, j3);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }
            }
        }

        private b() {
        }

        public static void abp() {
            i.abb();
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("wxareddot", iMG, true);
        }

        public static void unregister() {
            i.abb();
            ((n) g.k(n.class)).getSysCmdMsgExtension().b("wxareddot", iMG, true);
        }

        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = com.tencent.mm.platformtools.n.a(aVar.hoa.vNO);
            if (!bi.oN(a)) {
                com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                    public final void run() {
                        b.qv(a);
                    }
                });
            }
        }
    }

    private static void a(boolean z, long j) {
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = bi.Wx() + Math.max(0, j);
            }
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(j2));
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.valueOf(true));
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.valueOf(false));
            e eVar = e.iMN;
            e.a((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 1, e.abq());
            return;
        }
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
    }

    private static void a(boolean z, long j, long j2) {
        long j3 = 0;
        t Db = g.Dq().Db();
        com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG;
        if (z) {
            j3 = Math.max(0, j) + bi.Wx();
        }
        Db.a(aVar, Long.valueOf(j3));
        t Db2 = g.Dq().Db();
        com.tencent.mm.storage.w.a aVar2 = com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        Db2.a(aVar2, Long.valueOf(j2));
    }

    public static boolean abk() {
        i.abb();
        if (g.Do().CF()) {
            return ((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static a abl() {
        int i = 0;
        if (!abm()) {
            return a.NONE;
        }
        int intValue = ((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(0))).intValue();
        a[] values = a.values();
        int length = values.length;
        while (i < length) {
            a aVar = values[i];
            if (aVar.value == intValue) {
                return aVar;
            }
            i++;
        }
        return a.NONE;
    }

    public static boolean abm() {
        if (!g.Do().CF()) {
            return false;
        }
        long longValue = ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
        boolean z = longValue > bi.Wx();
        if (!z && longValue > 0) {
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
            e eVar = e.iMN;
            e.a((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 3, e.abq());
        }
        return z;
    }

    static void abn() {
        i.abb();
        if (g.Do().CF()) {
            e eVar = e.iMN;
            if (!((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                e.a((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 0, e.abq());
                g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.valueOf(true));
            }
        }
    }

    public static void abo() {
        if (g.Do().CF() && abm()) {
            a(false, 0);
            a(false, 0, 0);
            e eVar = e.iMN;
            e.a((String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 2, e.abq());
        }
    }
}
