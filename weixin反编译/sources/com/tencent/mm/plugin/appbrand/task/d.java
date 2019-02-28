package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appusage.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class d {
    private static final LinkedList<e> jPH;
    private static final LinkedList<e> jPI;
    private static final e jPJ = new b();
    private static final e jPK = new a();

    static {
        LinkedList linkedList = new LinkedList();
        jPH = linkedList;
        linkedList.add(new e(AppBrandUI.class, AppBrandTaskPreloadReceiver.class));
        jPH.add(new e(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class));
        jPH.add(new e(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class));
        jPH.add(new e(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class));
        jPH.add(new e(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class));
        linkedList = new LinkedList();
        jPI = linkedList;
        linkedList.addAll(jPH);
        jPI.add(jPJ);
        jPI.add(jPK);
    }

    public static int b(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        e eVar;
        int i;
        Context context2;
        if (appBrandInitConfig.iRc) {
            eVar = jPJ;
            i = 1;
        } else {
            e uR = uR(appBrandInitConfig.appId);
            if (uR == null || uR == jPJ) {
                if (appBrandInitConfig.iRd) {
                    uR = jPK;
                } else {
                    uR = alc();
                }
                a(uR);
                eVar = uR;
                i = 1;
            } else {
                eVar = uR;
                i = 2;
            }
        }
        eVar.a(appBrandInitConfig.appId, appBrandInitConfig.iIZ, null);
        if (context == null) {
            context2 = ad.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, eVar.jPO);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (context2 instanceof Activity) {
            RunningTaskInfo ah = bi.ah(context2, ((Activity) context2).getTaskId());
            if (!(ah == null || ah.baseActivity == null || !bi.oM(ah.baseActivity.getClassName()).equals(eVar.jPN))) {
                intent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
                intent.addFlags(603979776);
            }
        }
        context2.startActivity(intent);
        if (i == 1) {
            uP(appBrandInitConfig.appId);
        }
        return i;
    }

    public static void aL(String str, int i) {
        e uR = uR(str);
        if (uR != null && ((Integer) uR.jPQ.get(str)).intValue() == i && uR.uV(str) != null) {
            uR.uV(str).uO(str);
        }
    }

    public static void lN(int i) {
        Iterator it;
        if (2 == i) {
            it = ald().iterator();
            while (it.hasNext()) {
                ((e) it.next()).akO();
            }
            alb();
            return;
        }
        it = ald().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            eVar.akO();
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : eVar.jPR.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jPq = a.jPz;
                    appBrandRemoteTaskController.jPr = i;
                    appBrandRemoteTaskController.afF();
                }
            }
        }
    }

    public static void uP(String str) {
        e uR = uR(str);
        if (uR != null && uR.uV(str) != null) {
            uR.uV(str).uO(str);
        }
    }

    public static void alb() {
        if (b.aaR()) {
            alc().EB();
        }
    }

    public static void uQ(String str) {
        final e uS = uS(str);
        if (uS != null) {
            ah.h(new Runnable() {
                public final void run() {
                    uS.EB();
                }
            }, 500);
        }
    }

    public static void onNetworkChange() {
        Iterator it = ald().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((e) it.next()).jPR.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jPq = a.jPD;
                    appBrandRemoteTaskController.afF();
                }
            }
        }
    }

    private static e alc() {
        e eVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jPH.size()) {
                eVar = null;
                break;
            } else if (((e) jPH.get(i2)).jPQ.keySet().isEmpty()) {
                eVar = (e) jPH.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        return eVar != null ? eVar : (e) jPH.getFirst();
    }

    private static e uR(String str) {
        Iterator it = ald().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jPQ.keySet().contains(str)) {
                return eVar;
            }
        }
        return null;
    }

    static e uS(String str) {
        Iterator it = ald().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jPN.equals(str)) {
                return eVar;
            }
        }
        Assert.assertTrue(true);
        return null;
    }

    static e bG(String str, String str2) {
        Iterator it = ald().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jPQ.keySet().contains(str) && eVar.jPN.equals(str2)) {
                return eVar;
            }
        }
        return null;
    }

    public static boolean uT(String str) {
        e uR = uR(str);
        if (!(uR == null || uR.uV(str) == null)) {
            AppBrandRemoteTaskController uV = uR.uV(str);
            uV.jPq = a.jPC;
            if (uV.afF()) {
                return true;
            }
        }
        return false;
    }

    private static LinkedList<e> ald() {
        LinkedList<e> linkedList;
        synchronized (jPI) {
            linkedList = new LinkedList(jPI);
        }
        return linkedList;
    }

    static void uU(String str) {
        e uR = uR(str);
        if (uR != null) {
            uR.jPQ.remove(str);
            uR.jPR.remove(str);
            if (uR.jPQ.keySet().isEmpty()) {
                synchronized (jPI) {
                    jPI.remove(uR);
                    jPI.addFirst(uR);
                }
            }
        }
    }

    static void a(e eVar) {
        synchronized (jPI) {
            jPI.remove(eVar);
            jPI.addLast(eVar);
        }
    }
}
