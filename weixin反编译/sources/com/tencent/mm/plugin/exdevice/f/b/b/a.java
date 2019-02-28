package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "HardDeviceRankFollowInfo")};
    private e gLA;

    public a(e eVar) {
        super(eVar, c.gKN, "HardDeviceRankFollowInfo", null);
        this.gLA = eVar;
        eVar.fD("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    }

    public final c a(b bVar) {
        c cVar = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor a = this.gLA.a(format, new String[]{bi.aD(bVar.lUU, ""), bi.aD(bVar.username, ""), bi.aD(bVar.appName, "")}, 2);
        if (a == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
        } else {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.b(a);
            } else {
                x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
        }
        return cVar;
    }

    public final boolean zG(String str) {
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"});
        Cursor a = this.gLA.a(format, new String[]{bi.aD("hardcode_rank_id", ""), bi.aD("hardcode_app_name", ""), bi.aD(str, "")}, 2);
        if (a == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        x.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", Boolean.valueOf(moveToFirst));
        return moveToFirst;
    }

    public final ArrayList<c> aFf() {
        ArrayList<c> arrayList = null;
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor a = this.gLA.a(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (a == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    c cVar = new c();
                    cVar.b(a);
                    x.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", Integer.valueOf(a.getColumnIndex("rowid")), cVar.toString());
                    arrayList.add(cVar);
                } while (a.moveToNext());
                x.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", Integer.valueOf(arrayList.size()), arrayList.toString());
            } else {
                x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
        }
        return arrayList;
    }

    public final void a(ArrayList<wk> arrayList, String str, String str2) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                wk wkVar = (wk) it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = wkVar.jhF;
                cVar.field_username = wkVar.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
    }

    public final void aG(List<c> list) {
        String str = "hardcode_app_name";
        if (bi.oN("hardcode_rank_id") || bi.oN(str)) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.gLA.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", r0, str, Integer.valueOf(delete));
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
    }

    private boolean a(c cVar) {
        boolean z;
        boolean z2 = false;
        if (cVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        com.tencent.mm.sdk.e.c a = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a != null) {
            a.field_step = cVar.field_step;
            c(a, "rankID", "appusername", "username");
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (cVar != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            b((com.tencent.mm.sdk.e.c) cVar);
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        }
        return true;
    }

    public final boolean zH(String str) {
        com.tencent.mm.sdk.e.c a = a(new b("hardcode_rank_id", "hardcode_app_name", str));
        if (a == null) {
            return false;
        }
        a(a, "rankID", "appusername", "username");
        x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
        return true;
    }
}
