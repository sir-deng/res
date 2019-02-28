package com.tencent.mm.plugin.appbrand.game.a.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c extends i<b> {
    public static final String[] iHj = new String[]{i.a(b.gKN, "WxagGameInfo")};
    private final boolean jbr;

    public c(e eVar) {
        super(eVar, b.gKN, "WxagGameInfo", null);
        this.jbr = eVar != null;
        if (!this.jbr) {
            x.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
    }

    public final List<b> aes() {
        List<b> list = null;
        if (this.jbr) {
            Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"WxagGameInfo"}), new String[0]);
            x.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", r1);
            if (rawQuery == null) {
                x.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    list.add(bVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", Integer.valueOf(list.size()));
            } else {
                rawQuery.close();
                x.i("MicroMsg.MiniGameInfoStorage", "no record");
            }
        }
        return list;
    }

    public final b sd(String str) {
        if (!this.jbr || bi.oN(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WxagGameInfo", "RecordId"}), str);
        if (rawQuery.moveToFirst()) {
            b bVar = new b();
            bVar.b(rawQuery);
            rawQuery.close();
            return bVar;
        }
        x.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", str);
        rawQuery.close();
        return null;
    }

    public final void c(a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
    }

    public final boolean d(List<a> list, boolean z) {
        if (!this.jbr || bi.cC(list)) {
            return false;
        }
        List arrayList = new ArrayList();
        for (a aVar : list) {
            a(aVar, false, false);
            arrayList.add(aVar.gIR);
        }
        if (z) {
            b("batch", 2, arrayList);
        }
        x.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", Integer.valueOf(list.size()), Boolean.valueOf(false));
        return true;
    }

    public final boolean S(String str, boolean z) {
        boolean z2 = false;
        if (this.jbr && !bi.oN(str)) {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_RecordId = str;
            z2 = super.a(bVar, new String[0]);
            if (z2 && z) {
                b("single", 5, str);
            }
        }
        return z2;
    }

    public final boolean ad(List<String> list) {
        if (!this.jbr || bi.cC(list)) {
            return false;
        }
        for (String S : list) {
            S(S, false);
        }
        b("batch", 5, list);
        return true;
    }

    public final boolean a(a aVar, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.jbr && aVar != null) {
            com.tencent.mm.sdk.e.c bVar;
            com.tencent.mm.sdk.e.c cVar;
            boolean z4;
            String str = aVar.nlV;
            int i = aVar.iIZ;
            if (this.jbr) {
                Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[]{"WxagGameInfo", "AppId", "debugType"}), str, String.valueOf(i));
                if (rawQuery.moveToFirst()) {
                    bVar = new b();
                    bVar.b(rawQuery);
                    rawQuery.close();
                    cVar = bVar;
                } else {
                    rawQuery.close();
                    cVar = null;
                }
            } else {
                cVar = null;
            }
            if (cVar == null || !cVar.field_isSync) {
                z4 = true;
            } else {
                z4 = false;
            }
            x.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", Boolean.valueOf(z4));
            if (z4) {
                if (this.jbr && cVar != null) {
                    super.a(cVar, new String[0]);
                }
                bVar = new b();
                if (bi.oN(aVar.gIR)) {
                    str = aVar.kyG;
                    i = aVar.iIZ;
                    aVar.gIR = String.valueOf(String.format(Locale.US, "%s|%d", new Object[]{str, Integer.valueOf(i)}).hashCode());
                }
                bVar.field_RecordId = aVar.gIR;
                bVar.field_AppId = aVar.nlV;
                bVar.field_AppName = aVar.noG;
                bVar.field_UserName = aVar.kyG;
                bVar.field_IconUrl = aVar.nlA;
                bVar.field_BriefIntro = aVar.nmj;
                bVar.field_isSync = false;
                bVar.field_createTime = System.currentTimeMillis();
                z3 = b(bVar);
                if (z3 && z2) {
                    b("single", 2, bVar.field_RecordId);
                }
            }
        }
        return z3;
    }
}
