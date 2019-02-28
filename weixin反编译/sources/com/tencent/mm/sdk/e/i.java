package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class i<T extends c> extends j implements d<T> {
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final e gLA;
    public final a xrV;
    private final String xrW;

    public i(e eVar, a aVar, String str, String[] strArr) {
        int i = 0;
        this.gLA = eVar;
        this.xrV = aVar;
        this.xrV.xrS = bi.oN(this.xrV.xrS) ? "rowid" : this.xrV.xrS;
        this.xrW = str;
        List a = a(this.xrV, getTableName(), this.gLA);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (!this.gLA.fD(this.xrW, (String) a.get(i2))) {
                x.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.xrW, a.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.gLA.fD(this.xrW, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.xrW;
    }

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.xrU);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, e eVar) {
        List<String> arrayList = new ArrayList();
        if (eVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.e(str2, str3, objArr);
            return arrayList;
        }
        Cursor a = eVar.a("PRAGMA table_info( " + str + " )", new String[0], 2);
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
        for (Entry entry : aVar.xrT.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    x.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    public final boolean fD(String str, String str2) {
        if (str.length() == 0) {
            WK("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.gLA.fD(str, str2);
        } else {
            WK("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public boolean a(T t, boolean z) {
        ContentValues vP = t.vP();
        if (vP == null || vP.size() <= 0) {
            WK("insert failed, value.size <= 0");
            return false;
        }
        t.xrR = this.gLA.insert(getTableName(), this.xrV.xrS, vP);
        if (t.xrR <= 0) {
            WK("insert failed");
            return false;
        }
        vP.put("rowid", Long.valueOf(t.xrR));
        if (z) {
            WI(vP.getAsString(this.xrV.xrS));
        }
        return true;
    }

    public boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues vP = t.vP();
        if (vP == null || vP.size() <= 0) {
            WK("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            WJ("delete with primary key");
            if (this.gLA.delete(getTableName(), this.xrV.xrS + " = ?", new String[]{bi.oM(vP.getAsString(this.xrV.xrS))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(vP, strArr);
            if (a == null) {
                WK("delete failed, check keys failed");
                return false;
            } else if (this.gLA.delete(getTableName(), a.toString(), a(strArr, vP)) <= 0 || !z) {
                WK("delete failed");
                return false;
            } else {
                WI(this.xrV.xrS);
                return true;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return a((c) t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.gLA.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        }
        return z;
    }

    public final boolean b(long j, T t) {
        Cursor a = this.gLA.a(getTableName(), this.xrV.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.b(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues vP = t.vP();
        Cursor a;
        if (vP == null || vP.size() <= 0) {
            WK("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            WJ("get with primary key");
            a = this.gLA.a(getTableName(), this.xrV.columns, this.xrV.xrS + " = ?", new String[]{bi.oM(vP.getAsString(this.xrV.xrS))}, null, null, null, 2);
            if (a.moveToFirst()) {
                t.b(a);
                a.close();
                return true;
            }
            a.close();
            return false;
        } else {
            StringBuilder a2 = a(vP, strArr);
            if (a2 == null) {
                WK("get failed, check keys failed");
                return false;
            }
            a = this.gLA.a(getTableName(), this.xrV.columns, a2.toString(), a(strArr, vP), null, null, null, 2);
            if (a.moveToFirst()) {
                t.b(a);
                a.close();
                return true;
            }
            a.close();
            WJ("get failed, not found");
            return false;
        }
    }

    public final boolean a(long j, T t, boolean z) {
        ContentValues vP = t.vP();
        if (vP == null || vP.size() <= 0) {
            WK("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.gLA.query(getTableName(), this.xrV.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(vP, query)) {
            query.close();
            WJ("no need replace , fields no change");
            return true;
        }
        boolean z2;
        query.close();
        if (this.gLA.update(getTableName(), vP, "rowid = ?", new String[]{String.valueOf(j)}) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !z) {
            return z2;
        }
        doNotify();
        return z2;
    }

    public boolean a(long j, T t) {
        return a(j, (c) t, true);
    }

    public boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues vP = t.vP();
        if (vP == null || vP.size() <= 0) {
            WK("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            WJ("update with primary key");
            if (b(vP)) {
                WJ("no need replace , fields no change");
                return true;
            }
            if (this.gLA.update(getTableName(), vP, this.xrV.xrS + " = ?", new String[]{bi.oM(vP.getAsString(this.xrV.xrS))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(vP, strArr);
            if (a == null) {
                WK("update failed, check keys failed");
                return false;
            } else if (this.gLA.update(getTableName(), vP, a.toString(), a(strArr, vP)) > 0) {
                if (z) {
                    WI(vP.getAsString(this.xrV.xrS));
                }
                return true;
            } else {
                WK("update failed");
                return false;
            }
        }
    }

    public boolean c(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !bi.oN(this.xrV.xrS));
        ContentValues vP = t.vP();
        if (vP != null) {
            int i;
            int size = vP.size();
            int length = t.Aj().hUM.length;
            if (vP.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (b(vP)) {
                    WJ("no need replace , fields no change");
                    return true;
                } else if (this.gLA.replace(getTableName(), this.xrV.xrS, vP) > 0) {
                    WI(this.xrV.xrS);
                    return true;
                } else {
                    WK("replace failed");
                    return false;
                }
            }
        }
        WK("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean b(ContentValues contentValues) {
        Cursor query = this.gLA.query(getTableName(), this.xrV.columns, this.xrV.xrS + " = ?", new String[]{bi.oM(contentValues.getAsString(this.xrV.xrS))}, null, null, null);
        boolean a = c.a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor Tq() {
        return this.gLA.query(getTableName(), this.xrV.columns, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.gLA.rawQuery(str, strArr);
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = bi.oM(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void WJ(String str) {
        x.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void WK(String str) {
        x.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }
}
