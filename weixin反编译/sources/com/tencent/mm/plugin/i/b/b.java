package com.tencent.mm.plugin.i.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b extends i<a> {
    public static final String[] fNF = new String[]{"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] gLy = new String[]{i.a(a.gKN, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public e gLA;

    public b(e eVar) {
        super(eVar, a.gKN, "WxFileIndex2", fNF);
        this.gLA = eVar;
    }

    public final boolean delete() {
        long delete;
        try {
            delete = (long) this.gLA.delete("WxFileIndex2", null, null);
        } catch (Exception e) {
            delete = 0;
        }
        return delete > 0;
    }

    public final long nT(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gLA.rawQuery("select sum(size)  from WxFileIndex2  where msgType=" + i, null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long nU(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gLA.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long atx() {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gLA.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor aty() {
        Cursor cursor = null;
        try {
            return this.gLA.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e) {
            return cursor;
        }
    }

    public final List<a> h(String str, long j, long j2) {
        long Wz = bi.Wz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgSubType in (1,20,23,30,32,34 ) and size" + " > 0  order by msgtime DESC,msgSubType" + " ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.b(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bB(Wz)));
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bB(Wz)));
        return arrayList;
    }

    public final List<a> i(String str, long j, long j2) {
        long Wz = bi.Wz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgType in (43,62,44,3,49,268435505 ) order by msgtime" + " DESC,msgSubType ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.b(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bB(Wz)));
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bi.bB(Wz)));
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.i.b.a> L(com.tencent.mm.storage.au r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.lang.StringBuilder;
        r2 = "select *, rowid from WxFileIndex2  where msgId=";
        r1.<init>(r2);
        r2 = r7.field_msgId;
        r1 = r1.append(r2);
        r2 = " AND username='";
        r1 = r1.append(r2);
        r2 = r7.field_talker;
        r1 = r1.append(r2);
        r2 = "' order by msgSubType ASC ";
        r1 = r1.append(r2);
        r2 = r1.toString();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = r6.gLA;	 Catch:{ Exception -> 0x0048, all -> 0x0056 }
        r4 = 0;
        r0 = r3.rawQuery(r2, r4);	 Catch:{ Exception -> 0x0048, all -> 0x0056 }
    L_0x0036:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0048, all -> 0x0060 }
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r2 = new com.tencent.mm.plugin.i.b.a;	 Catch:{ Exception -> 0x0048, all -> 0x0060 }
        r2.<init>();	 Catch:{ Exception -> 0x0048, all -> 0x0060 }
        r2.b(r0);	 Catch:{ Exception -> 0x0048, all -> 0x0060 }
        r1.add(r2);	 Catch:{ Exception -> 0x0048, all -> 0x0060 }
        goto L_0x0036;
    L_0x0048:
        r2 = move-exception;
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0.close();
    L_0x004e:
        r0 = r1;
        goto L_0x0003;
    L_0x0050:
        if (r0 == 0) goto L_0x004e;
    L_0x0052:
        r0.close();
        goto L_0x004e;
    L_0x0056:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x005a:
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.close();
    L_0x005f:
        throw r0;
    L_0x0060:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.i.b.b.L(com.tencent.mm.storage.au):java.util.List<com.tencent.mm.plugin.i.b.a>");
    }

    public final int al(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long Wz = bi.Wz();
        int i = 0;
        for (a a : list) {
            int i2;
            if (a((c) a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bi.bB(Wz)));
        return i;
    }

    public final int am(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long Wz = bi.Wz();
        int i = 0;
        for (a aVar : list) {
            int i2;
            if (a(aVar.xrR, (c) aVar, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bi.bB(Wz)));
        return i;
    }
}
