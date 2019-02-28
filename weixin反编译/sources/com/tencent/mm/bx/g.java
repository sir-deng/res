package com.tencent.mm.bx;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g implements e {
    public static String xJM = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean vlG;
    public h xJL;
    public Map<String, i> xJN;
    public Queue<a> xJO;
    public f xJn;

    public interface a {
        int a(g gVar);

        String getTableName();
    }

    public final boolean chz() {
        if (this.xJn != null && this.xJn.isOpen()) {
            return false;
        }
        x.e("MicroMsg.MemoryStorage", "memory db is close [%s]", xJM);
        return true;
    }

    public final int YN(String str) {
        String str2 = null;
        if (!this.vlG) {
            return -4;
        }
        if (this.xJL == null || this.xJL.inTransaction()) {
            x.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            return -3;
        }
        try {
            if (f.a(this.xJn, str)) {
                this.xJn.execSQL("drop table " + str);
                x.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
            }
            Cursor a = this.xJL.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
            if (a != null) {
                if (a.getCount() == 1) {
                    a.moveToFirst();
                    str2 = a.getString(0);
                }
                a.close();
            }
            if (str2 == null) {
                x.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                return -1;
            }
            this.xJn.execSQL(str2);
            this.xJn.execSQL("insert into " + str + " select * from old." + str);
            x.d("MicroMsg.MemoryStorage", "copy table %s success", str);
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xJN.containsKey(str));
        if (this.xJn == null || !this.xJn.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, xJM);
            if (this.xJL == null || !this.xJL.isOpen()) {
                return -1;
            }
            return this.xJL.delete(str, str2, strArr);
        }
        i iVar = (i) this.xJN.get(str);
        com.tencent.mm.bx.i.a aVar = new com.tencent.mm.bx.i.a();
        aVar.xpW = 5;
        aVar.xKh = str2;
        aVar.J(strArr);
        iVar.a(aVar);
        return this.xJn.delete(str, str2, strArr);
    }

    public final boolean fD(String str, String str2) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xJN.containsKey(str));
        if (this.xJn == null || !this.xJn.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, xJM);
            if (this.xJL == null || !this.xJL.isOpen()) {
                return false;
            }
            this.xJL.fD(str2, str);
            return true;
        }
        i iVar = (i) this.xJN.get(str);
        com.tencent.mm.bx.i.a aVar = new com.tencent.mm.bx.i.a();
        aVar.xpW = 1;
        aVar.xrU = str2;
        iVar.a(aVar);
        this.xJn.execSQL(str2);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xJN.containsKey(str));
        if (this.xJn == null || !this.xJn.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, xJM);
            if (this.xJL == null || !this.xJL.isOpen()) {
                return -1;
            }
            return this.xJL.insert(str, str2, contentValues);
        }
        i iVar = (i) this.xJN.get(str);
        com.tencent.mm.bx.i.a aVar = new com.tencent.mm.bx.i.a();
        aVar.xpW = 2;
        aVar.xrS = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.xJn.insert(str, str2, contentValues);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xJN.containsKey(str));
        if (this.xJn == null || !this.xJn.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, xJM);
            if (this.xJL == null || !this.xJL.isOpen()) {
                return -1;
            }
            return this.xJL.replace(str, str2, contentValues);
        }
        i iVar = (i) this.xJN.get(str);
        com.tencent.mm.bx.i.a aVar = new com.tencent.mm.bx.i.a();
        aVar.xpW = 4;
        aVar.xrS = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.xJn.replace(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xJN.containsKey(str));
        if (this.xJn == null || !this.xJn.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, xJM);
            if (this.xJL == null || !this.xJL.isOpen()) {
                return -1;
            }
            return this.xJL.update(str, contentValues, str2, strArr);
        }
        i iVar = (i) this.xJN.get(str);
        com.tencent.mm.bx.i.a aVar = new com.tencent.mm.bx.i.a();
        aVar.xpW = 3;
        aVar.xKh = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.J(strArr);
        iVar.a(aVar);
        return this.xJn.update(str, contentValues, str2, strArr);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.xJn != null && this.xJn.isOpen()) {
            return this.xJn.a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, xJM);
        return d.clB();
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        return query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.xJn != null && this.xJn.isOpen()) {
            return this.xJn.a(str, strArr, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, xJM);
        return d.clB();
    }

    public final Cursor a(String str, String[] strArr, int i) {
        return rawQuery(str, strArr);
    }
}
