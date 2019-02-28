package com.tencent.mm.bx;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    public static final Pattern xJm = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    String aAM;
    private String foE = "";
    f xJn;
    String xJo = "";
    public boolean xJp = false;
    private boolean xJq = false;
    String xJr = "";
    public boolean xJs = false;

    public final String getError() {
        if (bi.oN(this.foE) || bi.oN(this.xJr)) {
            return "";
        }
        if (!bi.oN(com.tencent.mm.sdk.e.a.getValue(this.xJr, "Reported"))) {
            return "";
        }
        com.tencent.mm.sdk.e.a.ah(this.xJr, "Reported", "true");
        return this.foE;
    }

    private void fM(String str, String str2) {
        Set hashSet = new HashSet();
        String str3 = "";
        Cursor a = this.xJn.a("select * from " + str + " limit 1 ", null, 0);
        if (a.getCount() == 0) {
            a.close();
            return;
        }
        a.moveToFirst();
        for (int i = 0; i < a.getColumnCount(); i++) {
            hashSet.add(a.getColumnName(i));
        }
        a.close();
        a = this.xJn.a("PRAGMA table_info( " + str2 + " )", null, 0);
        String str4 = str3;
        while (a.moveToNext()) {
            str3 = a.getString(a.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        a.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.xJn.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
    }

    private boolean l(Cursor cursor) {
        int i;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            hashSet.add(cursor.getString(0));
        }
        Cursor a = this.xJn.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (a == null) {
            return false;
        }
        for (i = 0; i < a.getCount(); i++) {
            a.moveToPosition(i);
            hashSet2.add(a.getString(0));
        }
        a.close();
        this.xJn.beginTransaction();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashSet.contains(str)) {
                Cursor a2 = this.xJn.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0);
                if (a2 != null) {
                    this.xJn.execSQL(a2.getString(0));
                    a2.close();
                }
            }
        }
        this.xJn.endTransaction();
        return true;
    }

    private List<String> fN(String str, String str2) {
        List<String> arrayList = new ArrayList();
        if (this.xJn == null) {
            return arrayList;
        }
        Cursor a = this.xJn.a("PRAGMA table_info( " + str + " )", null, 0);
        if (a == null) {
            return arrayList;
        }
        Map hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex(Columns.TYPE);
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        a = this.xJn.a("PRAGMA table_info( " + str2 + " )", null, 0);
        if (a == null) {
            return arrayList;
        }
        Map hashMap2 = new HashMap();
        columnIndex = a.getColumnIndex("name");
        columnIndex2 = a.getColumnIndex(Columns.TYPE);
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        Iterator it = new HashSet(hashMap.entrySet()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 != null && str4.length() > 0) {
                String str5 = (String) hashMap2.get(str3);
                if (str5 == null) {
                    arrayList.add("ALTER TABLE " + str2 + " ADD COLUMN " + str3 + " " + str4 + ";");
                    hashMap.remove(str3);
                } else if (!str4.toLowerCase().startsWith(str5.toLowerCase())) {
                    x.e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        return arrayList;
    }

    private boolean fO(String str, String str2) {
        Cursor a = this.xJn.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (a == null) {
            return false;
        }
        try {
            if (bi.oN(str2)) {
                this.xJn.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.xJn.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (!l(a)) {
                return false;
            }
            this.xJn.beginTransaction();
            for (int i = 0; i < a.getCount(); i++) {
                int count;
                a.moveToPosition(i);
                Cursor a2 = this.xJn.a("select * from old.sqlite_master where tbl_name = '" + a.getString(0) + "'", null, 0);
                if (a2 != null) {
                    count = a2.getCount();
                    a2.close();
                } else {
                    count = 0;
                }
                if (count == 0) {
                    x.w("MicroMsg.DBInit", "In old db not found :" + a.getString(0));
                } else {
                    try {
                        for (String execSQL : fN("old." + a.getString(0), a.getString(0))) {
                            this.xJn.execSQL(execSQL);
                        }
                        fM("old." + a.getString(0), a.getString(0));
                    } catch (Exception e) {
                        x.w("MicroMsg.DBInit", "Insertselect FAILED :" + a.getString(0));
                    }
                }
            }
            this.xJn.endTransaction();
            a.close();
            this.xJn.execSQL("DETACH DATABASE old;");
            return true;
        } catch (SQLiteDatabaseCorruptException e2) {
            x.e("MicroMsg.DBInit", "Attached database is corrupted: " + str);
            FileOp.deleteFile(str);
            throw e2;
        }
    }

    public final boolean a(String str, HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.xJn != null) {
            this.xJn.close();
            this.xJn = null;
        }
        try {
            x.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.valueOf(z), Boolean.valueOf(e.bO(str)), str);
            this.xJn = f.bh(str, z2);
            if (!e.bO(str)) {
                z3 = true;
            }
            a(hashMap, z, z3);
            return true;
        } catch (SQLiteException e) {
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        Object obj;
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !bi.oN(str2));
        this.xJr = str2 + ".errreport";
        if (this.xJn != null) {
            this.xJn.close();
            this.xJn = null;
        }
        boolean bO = e.bO(str2);
        boolean bO2 = e.bO(str);
        boolean bO3 = e.bO(str3);
        Object obj2 = (bO || !bO2) ? null : 1;
        this.xJp = a(str2, j, str4, f.clG(), str3);
        String str5 = "MicroMsg.DBInit";
        String str6 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(bO);
        objArr[2] = Boolean.valueOf(bO2);
        objArr[3] = Boolean.valueOf(true);
        objArr[4] = Boolean.valueOf(this.xJp);
        objArr[5] = Boolean.valueOf(this.xJn != null);
        objArr[6] = Thread.currentThread().getName();
        x.i(str5, str6, objArr);
        if (this.xJn == null || this.xJn.getPath().equals(str3) || !bO3) {
            obj = null;
        } else {
            obj = 1;
            x.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        a(hashMap, z, this.xJq);
        if (!bO2 && !bO3) {
            return true;
        }
        if (!(obj == null && obj2 == null)) {
            this.xJs = true;
        }
        if (obj != null) {
            this.aAM = g.s((str4 + j).getBytes()).substring(0, 7);
            fP(str3, this.aAM);
            com.tencent.mm.blink.a.i(201, 1);
        }
        if (obj2 != null) {
            boolean fP = fP(str, "");
            com.tencent.mm.blink.a.i(200, 1);
            return fP;
        } else if (this.xJn != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean fP(String str, String str2) {
        if (fO(str, str2)) {
            x.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            x.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(b.deleteFile(str)));
            return true;
        }
        x.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        return false;
    }

    private static void a(f fVar) {
        Cursor rawQueryWithFactory = (fVar.xJx != null ? fVar.xJx : fVar.xJy).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            return;
        }
        throw new SQLiteException("Cannot get count for sqlite_master");
    }

    private boolean a(String str, long j, String str2, boolean z, String str3) {
        Object obj;
        int i;
        if (this.xJn != null) {
            throw new AssertionError();
        }
        this.aAM = g.s((str2 + j).getBytes()).substring(0, 7);
        this.xJq = !FileOp.bO(str);
        try {
            this.xJn = f.t(str, this.aAM, z);
            a(this.xJn);
            return true;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseCorruptException) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String deviceID = q.getDeviceID(ad.getContext());
                if (!(deviceID == null || deviceID.equals(str2))) {
                    obj = null;
                    String substring = g.s((deviceID + j).getBytes()).substring(0, 7);
                    try {
                        this.xJn = f.t(str, substring, z);
                        a(this.xJn);
                        this.aAM = substring;
                        l.yu().set(258, deviceID);
                        com.tencent.mm.plugin.report.d.pVE.a(181, 5, 1, false);
                        return true;
                    } catch (SQLiteException e2) {
                        if (e2 instanceof SQLiteDatabaseCorruptException) {
                            obj = 1;
                        }
                        if (!z) {
                            i = 42;
                        } else if (f.clH()) {
                            i = 43;
                        } else {
                            i = 41;
                        }
                        com.tencent.mm.plugin.report.d.pVE.a(181, (long) i, 1, true);
                        f.YM(str);
                        if (str.endsWith("EnMicroMsg.db")) {
                            f.YM(com.tencent.mm.kernel.g.Dq().gRT + "dbback/EnMicroMsg.db");
                        }
                        try {
                            this.xJn = f.t(str, this.aAM, z);
                            a(this.xJn);
                            this.xJq = true;
                            com.tencent.mm.plugin.report.d.pVE.a(181, 6, 1, false);
                            return true;
                        } catch (SQLiteException e3) {
                            com.tencent.mm.plugin.report.d.pVE.a(181, 7, 1, false);
                            if (this.xJn != null) {
                                this.xJn.close();
                                this.xJn = null;
                            }
                            this.aAM = null;
                            return false;
                        }
                    }
                }
                if (this.xJn == null && r2 != null) {
                    if (!z) {
                        i = 42;
                    } else if (f.clH()) {
                        i = 43;
                    } else {
                        i = 41;
                    }
                    com.tencent.mm.plugin.report.d.pVE.a(181, (long) i, 1, true);
                    f.YM(str);
                    if (str.endsWith("EnMicroMsg.db")) {
                        f.YM(com.tencent.mm.kernel.g.Dq().gRT + "dbback/EnMicroMsg.db");
                    }
                    this.xJn = f.t(str, this.aAM, z);
                    a(this.xJn);
                    this.xJq = true;
                    com.tencent.mm.plugin.report.d.pVE.a(181, 6, 1, false);
                    return true;
                }
            } else if (str3 != null && str3.length() > 0) {
                this.xJq = !FileOp.bO(str3);
                try {
                    this.xJn = f.t(str3, this.aAM, z);
                    a(this.xJn);
                    com.tencent.mm.plugin.report.d.pVE.a(181, 6, 1, false);
                    return true;
                } catch (SQLiteException e4) {
                    com.tencent.mm.plugin.report.d.pVE.a(181, 7, 1, false);
                    if (this.xJn != null) {
                        this.xJn.close();
                        this.xJn = null;
                    }
                    this.aAM = null;
                    return false;
                }
            }
            if (this.xJn != null) {
                this.xJn.close();
                this.xJn = null;
            }
            this.aAM = null;
            return false;
        }
    }

    private boolean a(HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        int i;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        x.d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.xJo = this.xJn.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (d dVar : hashMap.values()) {
                    if (dVar.wn() == null) {
                        x.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", dVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + dVar.getClass().toString(), false);
                    }
                    for (String hashCode : dVar.wn()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.s(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.e.a.getValue(this.xJo, "createmd5");
                if (!bi.oN(str) && str3.equals(str)) {
                    x.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.xJn.getPath());
                    return true;
                }
            }
        }
        str = str3;
        this.xJn.execSQL("pragma auto_vacuum = 0 ");
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        int i2 = 0;
        this.xJn.beginTransaction();
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = i;
                for (String str4 : ((d) it.next()).wn()) {
                    try {
                        this.xJn.execSQL(str4);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = xJm.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            x.w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        long zp = aVar.zp();
        this.xJn.endTransaction();
        x.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(zp), Long.valueOf(aVar.zp()), Integer.valueOf(i));
        if (z) {
            com.tencent.mm.sdk.e.a.ah(this.xJo, "createmd5", str);
        }
        return true;
    }
}
