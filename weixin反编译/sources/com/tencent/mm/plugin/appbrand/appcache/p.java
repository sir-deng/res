package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class p {
    private static final byte[] iGZ = new byte[0];

    public enum a {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL
    }

    public static void ae(String str, int i) {
        if (!bi.oN(str)) {
            String rl = q.rl(str);
            if (!bi.oN(rl)) {
                v vVar = (v) e.u(v.class);
                if (vVar != null) {
                    synchronized (iGZ) {
                        c uVar = new u();
                        uVar.field_appId = rl;
                        uVar.field_type = i;
                        if (vVar.b(uVar, u.iHh)) {
                            uVar.field_hit++;
                            uVar.field_hitTimeMS = bi.Wy();
                            vVar.c(uVar, u.iHh);
                        } else {
                            uVar.field_hit = 1;
                            uVar.field_hitTimeMS = bi.Wy();
                            vVar.b(uVar);
                        }
                    }
                }
            }
        }
    }

    public static a bD(long j) {
        if (j <= 0) {
            return a.NO_NEED;
        }
        StatFs statFs = new StatFs(ah.aak());
        long blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            return a.NO_NEED;
        }
        v vVar = (v) e.u(v.class);
        if (vVar == null) {
            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j));
            return a.TRIM_FAIL;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        LinkedList linkedList = new LinkedList();
        synchronized (iGZ) {
            Cursor a = vVar.gLA.a("PkgUsageLRURecord", new String[]{"appId", Columns.TYPE}, null, null, null, null, format, 2);
            a aVar;
            if (a == null) {
                aVar = a.TRIM_FAIL;
                return aVar;
            } else if (a.moveToFirst()) {
                while (true) {
                    try {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                        if (!a.moveToNext()) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", e);
                        ap Zz = e.Zz();
                        if (Zz == null) {
                            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j));
                            return a.TRIM_FAIL;
                        }
                        long j2 = 0;
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            for (al alVar : Zz.a((String) pair.first, ((Integer) pair.second).intValue(), com.tencent.mm.plugin.appbrand.appcache.ap.a.ASC, "pkgPath")) {
                                j2 += (long) com.tencent.mm.a.e.bN(alVar.field_pkgPath);
                                b.deleteFile(alVar.field_pkgPath);
                                if (j2 >= j) {
                                    return a.TRIMMED;
                                }
                            }
                        }
                        return a.TRIM_FAIL;
                    } finally {
                        a.close();
                    }
                }
            } else {
                a.close();
                aVar = a.TRIM_FAIL;
                return aVar;
            }
        }
    }
}
