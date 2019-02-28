package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.k;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class p extends j {
    public static final String[] iHj = new String[]{i.a(a.iHk, "AppBrandLauncherLayoutItem")};
    final h iIR;
    final b iNf;
    public final c iNg = new c();

    public final class c {
        /* synthetic */ c(p pVar, byte b) {
            this();
        }

        private c() {
        }

        public final ArrayList<k> abt() {
            return e(Long.MAX_VALUE, 30);
        }

        public final ArrayList<k> e(long j, int i) {
            return p.c(p.this.iIR.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
        }
    }

    static final class a extends k {
        static final String[] iHh = new String[]{"brandId", "versionType", "scene"};
        static final com.tencent.mm.sdk.e.c.a iHk;

        a() {
        }

        protected final com.tencent.mm.sdk.e.c.a Aj() {
            return iHk;
        }

        public final ContentValues vP() {
            this.xrR = 0;
            ContentValues vP = super.vP();
            int x = p.w(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = x;
            vP.put("recordId", Integer.valueOf(x));
            return vP;
        }

        static {
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.hUM = new Field[5];
            aVar.columns = new String[6];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "recordId";
            aVar.xrT.put("recordId", "INTEGER PRIMARY KEY ");
            stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
            stringBuilder.append(", ");
            aVar.xrS = "recordId";
            aVar.columns[1] = "brandId";
            aVar.xrT.put("brandId", "TEXT");
            stringBuilder.append(" brandId TEXT");
            stringBuilder.append(", ");
            aVar.columns[2] = "versionType";
            aVar.xrT.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[3] = "updateTime";
            aVar.xrT.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            aVar.columns[4] = "scene";
            aVar.xrT.put("scene", "INTEGER");
            stringBuilder.append(" scene INTEGER");
            aVar.columns[5] = "rowid";
            aVar.xrU = stringBuilder.toString();
            iHk = aVar;
        }
    }

    private static final class b extends i<a> {
        b(e eVar) {
            super(eVar, a.iHk, "AppBrandLauncherLayoutItem", a.fNF);
        }
    }

    public p(h hVar) {
        this.iIR = hVar;
        this.iNf = new b(hVar);
    }

    public final void c(com.tencent.mm.sdk.e.j.a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
    }

    public final boolean ap(String str, int i) {
        boolean z = true;
        if (bi.oN(str)) {
            return false;
        }
        Cursor a = this.iIR.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (a == null) {
            return false;
        }
        if (!a.moveToFirst()) {
            z = false;
        } else if (a.getInt(0) <= 0) {
            z = false;
        }
        a.close();
        return z;
    }

    final Cursor a(String[] strArr, int i, int i2) {
        return this.iIR.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
    }

    private static ArrayList<k> c(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList<k> arrayList;
        if (cursor.moveToFirst()) {
            Collection linkedList = new LinkedList();
            a aVar = new a();
            do {
                aVar.b(cursor);
                if (!bi.oN(aVar.field_brandId)) {
                    linkedList.add(q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
        } else {
            arrayList = new ArrayList();
        }
        cursor.close();
        return arrayList;
    }

    public final ArrayList<k> abr() {
        return c(a(null, 200, 0));
    }

    public final k qx(String str) {
        k kVar = null;
        if (!bi.oN(str)) {
            Cursor query = this.iIR.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    a aVar = new a();
                    aVar.b(query);
                    if (!bi.oN(aVar.field_brandId)) {
                        kVar = q.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime);
                    }
                }
                query.close();
            }
        }
        return kVar;
    }

    public final List<String> qy(String str) {
        List<String> linkedList = new LinkedList();
        if (!bi.oN(str)) {
            Cursor query = this.iIR.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, boolean z, boolean z2, int i2, int i3, String str2) {
        if (bi.oN(str) || 999 == i) {
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor a = this.iIR.a(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long max = Math.max(j + 1, bi.Wx());
        int w = w(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.iIR.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(w)}) > 0 ? 1 : null;
        if (obj != null) {
            b("single", 3, String.valueOf(w));
        }
        if (obj == null) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i;
            boolean a2 = a(aVar);
            if (a2) {
                b("single", 2, String.valueOf(w));
            }
            z3 = a2;
            z4 = a2;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z && com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
            Pair u = ((com.tencent.mm.plugin.appbrand.appcache.b.d.b) com.tencent.mm.plugin.appbrand.app.e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.b.class)).u(str, 3, i2);
            if (((Boolean) u.first).booleanValue()) {
                x.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", str, Integer.valueOf(i2));
                int i4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) ((Integer) u.second).intValue(), 165);
            } else {
                new s(i2, z2, i, 2, 1, str, i3, str2).Kb();
            }
        }
        if (z4) {
            com.tencent.mm.plugin.appbrand.appcache.p.ae(str, i);
        }
        if (z3) {
            abs();
        }
        if (z4 && i2 != 1086) {
            ((g) com.tencent.mm.plugin.appbrand.app.e.u(g.class)).a(str, i, com.tencent.mm.plugin.appbrand.appusage.g.a.USAGE_LIST);
        }
        return z4;
    }

    private void abs() {
        int i;
        int i2 = 0;
        Cursor a = this.iIR.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            i = 0;
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        }
        if (i > 200) {
            a = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, 200);
            if (a != null) {
                List<String> linkedList = new LinkedList();
                List arrayList = new ArrayList(i - 200);
                List arrayList2 = new ArrayList(i - 200);
                if (a.moveToFirst()) {
                    do {
                        linkedList.add(String.valueOf(a.getInt(0)));
                        arrayList.add(a.getString(1));
                        arrayList2.add(Integer.valueOf(a.getInt(2)));
                    } while (a.moveToNext());
                }
                a.close();
                if (!bi.cC(linkedList)) {
                    String rl;
                    long dA = this.iIR.dA(Thread.currentThread().getId());
                    for (String rl2 : linkedList) {
                        this.iIR.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{rl2});
                    }
                    this.iIR.fT(dA);
                    List arrayList3 = new ArrayList(arrayList.size());
                    List arrayList4 = new ArrayList(arrayList.size());
                    while (i2 < arrayList.size()) {
                        rl2 = q.rl((String) arrayList.get(i2));
                        if (!bi.oN(rl2)) {
                            arrayList3.add(rl2);
                            arrayList4.add(arrayList2.get(i2));
                        }
                        i2++;
                    }
                    if (com.tencent.mm.plugin.appbrand.app.e.Zz() != null) {
                        com.tencent.mm.plugin.appbrand.app.e.Zz().d(arrayList3, arrayList4);
                    }
                    b("batch", 5, linkedList);
                }
            }
        }
    }

    public final boolean a(String str, int i, boolean z, int i2, int i3, String str2) {
        boolean a = a(str, i, true, z, i2, i3, str2);
        if (a) {
            b.qu(str2);
        }
        return a;
    }

    final boolean a(a aVar) {
        if (bi.oN(aVar.field_brandId)) {
            return false;
        }
        long insert = this.iIR.insert("AppBrandLauncherLayoutItem", "", aVar.vP());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            return true;
        }
        return false;
    }

    static int w(String str, int i, int i2) {
        return String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
    }
}
