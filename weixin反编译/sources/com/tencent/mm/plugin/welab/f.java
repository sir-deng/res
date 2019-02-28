package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.bp.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f {
    private static boolean DEBUG = false;
    private static boolean Vx = false;

    static /* synthetic */ void F(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.WelabUpdater", "No Exp");
            return;
        }
        List arrayList = new ArrayList();
        for (b a : list) {
            a Rd = g.Rd(n.a(a));
            if (Rd != null && Rd.isValid()) {
                arrayList.add(Rd);
                com.tencent.mm.plugin.welab.d.b.bWw().f(Rd);
                e.o(Rd.field_LabsAppId, 8, com.tencent.mm.plugin.welab.d.b.bWw().e(Rd));
            }
        }
        x.i("MicroMsg.WelabUpdater", "save exp " + arrayList);
        b.bWh().tVV.cv(arrayList);
    }

    static /* synthetic */ void cu(List list) {
        if (bi.cC(list)) {
            x.w("MicroMsg.WelabUpdater", "No expired Exp");
            return;
        }
        x.i("MicroMsg.WelabUpdater", "expired exp " + list);
        List arrayList = new ArrayList();
        for (Integer num : list) {
            c aVar = new a();
            aVar.field_expId = num.toString();
            b.bWh().tVV.b(aVar, "expId");
            if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                aVar.field_Switch = 3;
                arrayList.add(aVar);
            }
        }
        b.bWh().tVV.cv(arrayList);
    }

    static void M(boolean z, boolean z2) {
        x.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (g.Do().CF()) {
            if (!(DEBUG || z || z2)) {
                Object obj;
                Long l = (Long) g.Dq().Db().get(w.a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, null);
                long longValue = l == null ? 0 : l.longValue();
                int intValue;
                if (longValue == 0) {
                    he(new Random().nextInt(86400));
                    IH();
                    II();
                    x.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", Integer.valueOf(intValue));
                    obj = 1;
                } else {
                    Integer num = (Integer) g.Dq().Db().get(w.a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, null);
                    intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                    long j = (long) intValue;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = "MicroMsg.WelabUpdater";
                    String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Long.valueOf(j);
                    objArr[3] = Long.valueOf(currentTimeMillis);
                    x.i(str, str2, objArr);
                    obj = currentTimeMillis > longValue + j ? 1 : null;
                }
                if (obj == null) {
                    x.v("MicroMsg.WelabUpdater", "No need to update");
                    return;
                }
            }
            if (Vx) {
                x.i("MicroMsg.WelabUpdater", "Updating");
                return;
            }
            Vx = true;
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new xr();
            aVar.hnU = new xs();
            aVar.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            aVar.hnS = 1816;
            com.tencent.mm.ad.b Kf = aVar.Kf();
            xr xrVar = (xr) Kf.hnQ.hnY;
            Integer num2 = (Integer) g.Dq().Db().get(w.a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, null);
            xrVar.wpc = num2 == null ? 0 : num2.intValue();
            xrVar.wpd = bWj();
            xrVar.wpe = (int) bi.Wx();
            if (z) {
                xrVar.fEo |= 1;
            }
            if (z2) {
                xrVar.fEo |= 2;
            }
            x.i("MicroMsg.WelabUpdater", "update abtest: %s", at(xrVar.wpd));
            u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        xs xsVar = (xs) bVar.hnR.hnY;
                        f.IH();
                        g.Dq().Db().a(w.a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, Integer.valueOf(xsVar.wid));
                        f.he(xsVar.wpg);
                        f.cu(xsVar.wph);
                        f.F(xsVar.wpf);
                        f.II();
                        x.i("MicroMsg.WelabUpdater", "Update Interval: %d", Integer.valueOf(xsVar.wpg));
                        f.Vx = false;
                    } else {
                        x.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                        f.IH();
                        f.he(86400);
                        f.II();
                    }
                    return 0;
                }
            });
            return;
        }
        x.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
    }

    private static String at(LinkedList<to> linkedList) {
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            to toVar = (to) it.next();
            str = str2 + toVar.wfY + ":" + toVar.priority + "|";
        }
    }

    private static LinkedList<to> bWj() {
        LinkedList<to> linkedList = new LinkedList();
        try {
            for (a aVar : b.bWh().tVV.bWr()) {
                to toVar = new to();
                toVar.wfY = bi.getInt(aVar.field_expId, 0);
                toVar.priority = aVar.field_prioritylevel;
                linkedList.add(toVar);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WelabUpdater", e, "", new Object[0]);
        }
        return linkedList;
    }

    private static void IH() {
        g.Dq().Db().a(w.a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void he(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Dq().Db().a(w.a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
    }

    private static void II() {
        g.Dq().Db().lO(true);
    }
}
