package com.tencent.mm.y.c;

import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean Vx = false;

    static /* synthetic */ void F(List list) {
        if (bi.cC(list)) {
            x.w("MicroMsg.ABTestUpdater", "No expired Exp");
            return;
        }
        c cVar;
        d IL = c.IL();
        if (!bi.cC(list)) {
            for (Integer num : list) {
                if (num != null) {
                    cVar = new com.tencent.mm.storage.c();
                    cVar.field_expId = String.valueOf(num);
                    IL.a(cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b IM = c.IM();
        if (!bi.cC(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    cVar = new a();
                    cVar.field_expId = String.valueOf(num2);
                    IM.a(cVar, "expId");
                }
            }
        }
    }

    static /* synthetic */ void G(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.ABTestUpdater", "No Exp");
            return;
        }
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (com.tencent.mm.bp.b a : list) {
            a.a ip = a.ip(n.a(a));
            linkedList.addAll(ip.hkf);
            linkedList2.addAll(ip.hkg);
        }
        c.IL().i(linkedList, 0);
        c.IM().i(linkedList2, 1);
    }

    static void IF() {
        int i = 1;
        if (g.Do().CF()) {
            Long l = (Long) g.Dq().Db().get(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            long longValue = l == null ? 0 : l.longValue();
            int intValue;
            if (longValue == 0) {
                he(new Random().nextInt(86400));
                IH();
                II();
                x.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(intValue));
            } else {
                Integer num = (Integer) g.Dq().Db().get(w.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
                intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                long j = (long) intValue;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(currentTimeMillis);
                x.i(str, str2, objArr);
                if (currentTimeMillis <= longValue + j) {
                    i = 0;
                }
            }
            if (i == 0) {
                x.v("MicroMsg.ABTestUpdater", "No need to update");
                return;
            } else if (Vx) {
                x.i("MicroMsg.ABTestUpdater", "Updating");
                return;
            } else {
                update();
                return;
            }
        }
        x.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
    }

    static void IG() {
        if (!g.Do().CF()) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
        } else if (Vx) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
        } else {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
        }
    }

    private static void update() {
        Vx = true;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new xr();
        aVar.hnU = new xs();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.hnS = 1801;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        xr xrVar = (xr) Kf.hnQ.hnY;
        Integer num = (Integer) g.Dq().Db().get(w.a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
        xrVar.wpc = num == null ? 0 : num.intValue();
        xrVar.wpd = c.IL().cit();
        xrVar.wpd.addAll(c.IM().cit());
        String str = "MicroMsg.ABTestUpdater";
        String str2 = "update abtest: %s";
        Object[] objArr = new Object[1];
        LinkedList linkedList = xrVar.wpd;
        String str3 = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str4 = str3;
            if (it.hasNext()) {
                to toVar = (to) it.next();
                str3 = str4 + toVar.wfY + ":" + toVar.priority + "|";
            } else {
                objArr[0] = str4;
                x.i(str, str2, objArr);
                u.a(Kf, new u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                        b.Vx = false;
                        if (i == 0 && i2 == 0) {
                            xs xsVar = (xs) bVar.hnR.hnY;
                            b.IH();
                            g.Dq().Db().a(w.a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(xsVar.wid));
                            b.he(xsVar.wpg);
                            b.F(xsVar.wph);
                            b.G(xsVar.wpf);
                            b.II();
                            x.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(xsVar.wpg));
                        } else {
                            x.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                            b.IH();
                            b.he(86400);
                            b.II();
                        }
                        return 0;
                    }
                }, true);
                return;
            }
        }
    }

    private static void IH() {
        g.Dq().Db().a(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void he(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Dq().Db().a(w.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
    }

    private static void II() {
        g.Dq().Db().lO(true);
    }
}
