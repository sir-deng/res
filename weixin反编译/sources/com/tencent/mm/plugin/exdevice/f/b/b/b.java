package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.gKN, "HardDeviceChampionInfo")};
    private e gLA;

    public b(e eVar) {
        super(eVar, a.gKN, "HardDeviceChampionInfo", null);
        this.gLA = eVar;
        eVar.fD("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    }

    public final a zI(String str) {
        a aVar = null;
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor a = this.gLA.a(format, new String[]{bi.aD(str, "")}, 2);
        if (a == null) {
            x.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
        } else {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            } else {
                x.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            a.close();
        }
        return aVar;
    }

    public final boolean a(a aVar, boolean z) {
        Assert.assertTrue(aVar != null);
        if (c(aVar, "username")) {
            x.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ad.aFa().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else if (b((c) aVar)) {
            x.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ad.aFa().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else {
            x.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            return false;
        }
    }
}
