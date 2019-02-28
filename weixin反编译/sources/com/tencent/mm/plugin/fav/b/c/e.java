package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends i<h> implements p {
    private com.tencent.mm.sdk.e.e gLA;

    public final /* synthetic */ boolean a(h hVar) {
        return super.b((c) hVar);
    }

    public final /* synthetic */ boolean a(h hVar, String[] strArr) {
        return super.c(hVar, strArr);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, h.gKN, "FavSearchInfo", null);
        this.gLA = eVar;
    }

    public final ArrayList<Long> a(List<String> list, List<String> list2, List<Integer> list3) {
        Iterator it;
        String str;
        ArrayList<Long> arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            it = list.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and content like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            it = list2.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and tagContent like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        str3 = str2 + " where " + str3;
        if (!(list3 == null || list3.isEmpty())) {
            str3 = str3 + " and ((1=1 ";
            Iterator it2 = list3.iterator();
            while (true) {
                str = str3;
                if (!it2.hasNext()) {
                    break;
                }
                str3 = str + " and type = " + ((Integer) it2.next()).intValue();
            }
            str3 = str + ") or (1=1";
            it2 = list3.iterator();
            while (true) {
                str = str3;
                if (!it2.hasNext()) {
                    break;
                }
                str3 = str + " and subtype & " + h.pY(((Integer) it2.next()).intValue()) + " != 0";
            }
            str3 = str + "))";
        }
        x.d("MicroMsg.FavSearchStorage", "search id sql {%s}", str3 + " order by time desc");
        Cursor a = this.gLA.a(str3, null, 2);
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean AA(String str) {
        if (bi.oN(str)) {
            return false;
        }
        int i;
        x.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", "select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'");
        Cursor a = this.gLA.a(r2, null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        if (a != null) {
            a.close();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final void de(long j) {
        this.gLA.fD("FavSearchInfo", "delete from FavSearchInfo where localId = " + j);
    }

    public final h df(long j) {
        h hVar = null;
        Cursor a = this.gLA.a("select * from FavSearchInfo where localId = " + j, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                hVar = new h();
                hVar.b(a);
            }
            a.close();
        }
        return hVar;
    }
}
