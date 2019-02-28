package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.exdevice.f.a.f;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.a.m;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements e {
    public f lVo;
    public f lVp;

    public c() {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        as.CN().a(1042, (e) this);
        as.CN().a(1041, (e) this);
        as.CN().a(1043, (e) this);
        as.CN().a(1040, (e) this);
    }

    public static void b(String str, String str2, String str3, int i) {
        as.CN().a(new l(str3, str2, i, str), 0);
    }

    public static ArrayList<d> zE(String str) {
        ArrayList<d> arrayList = null;
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (bi.oN(str)) {
            x.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d aES = ad.aES();
            if (bi.oN(str)) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", "score"});
                Cursor a = aES.gLA.a(format, new String[]{bi.aD(str, "")}, 2);
                if (a == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                } else {
                    if (a.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            d dVar = new d();
                            dVar.b(a);
                            arrayList.add(dVar);
                        } while (a.moveToNext());
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    a.close();
                }
            }
        }
        return arrayList;
    }

    public static void d(String str, ArrayList<d> arrayList) {
        com.tencent.mm.plugin.exdevice.f.b.b.d aES = ad.aES();
        Assert.assertTrue(!bi.oN(str));
        if (arrayList != null) {
            int i;
            Cursor a = aES.gLA.a(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{bi.aD(str, "")}, 2);
            if (a == null) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                a.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    aES.a((d) it.next(), false);
                }
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                aES.b((d) it.next(), false);
            }
            return;
        }
        x.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (kVar instanceof j) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
            }
        } else if (kVar instanceof l) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        } else if (!(kVar instanceof m)) {
        } else {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        }
    }
}
