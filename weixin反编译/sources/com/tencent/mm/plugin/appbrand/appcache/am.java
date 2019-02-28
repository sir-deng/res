package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class am {
    public static final Runnable iIC = new Runnable() {
        private static void aax() {
            List list = null;
            if (g.Do().CF()) {
                ap Zz = e.Zz();
                Cursor a = Zz.iIR.a(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
                List<String> arrayList = new ArrayList();
                while (a.moveToNext()) {
                    arrayList.add(a.getString(0));
                }
                a.close();
                if (!bi.cC(arrayList)) {
                    List linkedList = new LinkedList();
                    for (String s : arrayList) {
                        Collection s2 = Zz.s(s, 0, 2);
                        if (!bi.cC(s2)) {
                            linkedList.addAll(s2);
                        }
                    }
                    list = linkedList;
                }
                if (!bi.cC(list)) {
                    for (al alVar : list) {
                        am.el(alVar.field_pkgPath);
                        e.Zz().a(alVar);
                        e.ZF().af(alVar.field_appId, alVar.field_version);
                    }
                }
            }
        }

        private static void aay() {
            File file = new File(ah.aak());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    boolean z;
                    ap Zz = e.Zz();
                    String absolutePath = file2.getAbsolutePath();
                    Cursor a = Zz.iIR.a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{absolutePath}, null, null, null, 2);
                    if (a == null) {
                        z = false;
                    } else {
                        z = a.moveToFirst();
                        a.close();
                    }
                    if (!z) {
                        am.el(file2.getAbsolutePath());
                    }
                }
            }
        }

        public final void run() {
            try {
                ap Zz = e.Zz();
                StringBuilder stringBuilder = new StringBuilder("debugType");
                stringBuilder.append(" in (");
                for (int append : d.iGh) {
                    stringBuilder.append(append).append(',');
                }
                stringBuilder.append(-1).append(')');
                Cursor a = Zz.iIR.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
                List list;
                if (a == null) {
                    list = null;
                } else if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        al alVar = new al();
                        alVar.b(a);
                        list.add(alVar);
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    list = null;
                }
                if (!bi.cC(list)) {
                    long Wx = bi.Wx();
                    for (al alVar2 : list) {
                        if (alVar2.field_endTime > 0 && alVar2.field_endTime <= Wx) {
                            am.el(alVar2.field_pkgPath);
                            e.Zz().a(alVar2);
                            d.aL(alVar2.field_appId, alVar2.field_debugType);
                        }
                    }
                }
                AnonymousClass1.aax();
                AnonymousClass1.aay();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", bi.i(e));
            }
        }
    };

    static /* synthetic */ void el(String str) {
        b.deleteFile(str);
        try {
            Runtime.getRuntime().exec("rm -r " + str + "_xdir");
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WxaPkgPruner", "rm -r %s, e = %s", str + "_xdir", e);
        }
    }

    public static void aaw() {
        c.Dt().F(iIC);
    }
}
