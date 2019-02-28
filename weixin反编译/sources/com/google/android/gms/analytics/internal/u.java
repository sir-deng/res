package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.io.Closeable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

final class u extends o implements Closeable {
    private static final String aGA = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String aGB = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final a aGC;
    private final j aGD = new j(this.aFo.aFD);
    private final j aGE = new j(this.aFo.aFD);

    class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, null, 1);
        }

        private static void a(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            Set b = b(sQLiteDatabase, "properties");
            String[] strArr = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            while (i < 6) {
                String str = strArr[i];
                if (b.remove(str)) {
                    i++;
                } else {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        private boolean a(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor query;
            Object e;
            Throwable th;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            try {
                u.this.c("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private static Set<String> b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public final SQLiteDatabase getWritableDatabase() {
            if (u.this.aGE.V(3600000)) {
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException e) {
                    u.this.aGE.start();
                    u.this.ay("Opening the database failed, dropping the table and recreating it");
                    u.this.aFo.mContext.getDatabasePath(u.this.ng()).delete();
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        u.this.aGE.aFE = 0;
                        return writableDatabase;
                    } catch (SQLiteException e2) {
                        u.this.f("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
            }
            throw new SQLiteException("Database open failed");
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            String path = sQLiteDatabase.getPath();
            if (ai.version() >= 9) {
                File file = new File(path);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            int i = 1;
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (a(sQLiteDatabase, "hits2")) {
                Set b = b(sQLiteDatabase, "hits2");
                String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
                int i2 = 0;
                while (i2 < 4) {
                    String str = strArr[i2];
                    if (b.remove(str)) {
                        i2++;
                    } else {
                        throw new SQLiteException("Database hits2 is missing required column: " + str);
                    }
                }
                if (b.remove("hit_app_id")) {
                    i = 0;
                }
                if (!b.isEmpty()) {
                    throw new SQLiteException("Database hits2 has extra columns");
                } else if (i != 0) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                }
            } else {
                sQLiteDatabase.execSQL(u.aGA);
            }
            if (a(sQLiteDatabase, "properties")) {
                a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    u(q qVar) {
        super(qVar);
        this.aGC = new a(qVar.mContext, ng());
    }

    private List<Long> W(long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        q.mZ();
        mR();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        List<Long> arrayList = new ArrayList();
        Cursor query;
        try {
            query = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e("Error selecting hit ids", e);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    private Map<String, String> aA(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            f("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private Map<String, String> aB(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            f("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    private long az(String str) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, null);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long b(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery == null) {
                        return j;
                    }
                    rawQuery.close();
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    d("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        }
    }

    private SQLiteDatabase getWritableDatabase() {
        try {
            return this.aGC.getWritableDatabase();
        } catch (SQLiteException e) {
            e("Error opening database", e);
            throw e;
        }
    }

    private long nc() {
        q.mZ();
        mR();
        return az("SELECT COUNT(*) FROM hits2");
    }

    private String ng() {
        return !f.aNs ? "google_analytics_v4.db" : this.aFo.aFW.nv() ? "google_analytics_v4.db" : "google_analytics2_v4.db";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.analytics.internal.c> X(long r14) {
        /*
        r13 = this;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0097;
    L_0x0009:
        com.google.android.gms.common.internal.w.au(r0);
        com.google.android.gms.analytics.internal.q.mZ();
        r13.mR();
        r0 = r13.getWritableDatabase();
        r1 = "hits2";
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 1;
        r4 = "hit_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 2;
        r4 = "hit_string";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 3;
        r4 = "hit_url";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 4;
        r4 = "hit_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = 0;
        r11 = "hit_id";
        r8[r10] = r11;	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x009a, all -> 0x00ab }
        r10 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.<init>();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 == 0) goto L_0x0091;
    L_0x0061:
        r0 = 0;
        r6 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 1;
        r3 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = 2;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = 3;
        r1 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = 4;
        r8 = r9.getInt(r2);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r2 = r13.aA(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r5 = com.google.android.gms.analytics.internal.k.at(r1);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = new com.google.android.gms.analytics.internal.c;	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r1 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r10.add(r0);	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00ad, all -> 0x00ab }
        if (r0 != 0) goto L_0x0061;
    L_0x0091:
        if (r9 == 0) goto L_0x0096;
    L_0x0093:
        r9.close();
    L_0x0096:
        return r10;
    L_0x0097:
        r0 = r1;
        goto L_0x0009;
    L_0x009a:
        r0 = move-exception;
        r1 = r9;
    L_0x009c:
        r2 = "Error loading hits from the database";
        r13.f(r2, r0);	 Catch:{ all -> 0x00a3 }
        throw r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r0 = move-exception;
        r9 = r1;
    L_0x00a5:
        if (r9 == 0) goto L_0x00aa;
    L_0x00a7:
        r9.close();
    L_0x00aa:
        throw r0;
    L_0x00ab:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x00ad:
        r0 = move-exception;
        r1 = r9;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.u.X(long):java.util.List<com.google.android.gms.analytics.internal.c>");
    }

    public final void Y(long j) {
        q.mZ();
        mR();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        c("Deleting hit, id", Long.valueOf(j));
        s(arrayList);
    }

    public final long a(long j, String str, String str2) {
        w.aM(str);
        w.aM(str2);
        mR();
        q.mZ();
        return b("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2});
    }

    public final void b(long j, String str) {
        w.aM(str);
        mR();
        q.mZ();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            c("Deleted property records", Integer.valueOf(delete));
        }
    }

    public final void b(s sVar) {
        w.ag(sVar);
        mR();
        q.mZ();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Map map = sVar.aFb;
        w.ag(map);
        Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(sVar.aGl));
        contentValues.put("cid", sVar.aGm);
        contentValues.put("tid", sVar.aGn);
        contentValues.put("adid", Integer.valueOf(sVar.aGo ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(sVar.aGp));
        contentValues.put("params", encodedQuery);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                ay("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            f("Error storing a property", e);
        }
    }

    public final void beginTransaction() {
        mR();
        getWritableDatabase().beginTransaction();
    }

    public final void close() {
        try {
            this.aGC.close();
        } catch (SQLiteException e) {
            f("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            f("Error closing database", e2);
        }
    }

    public final void e(c cVar) {
        String str;
        w.ag(cVar);
        q.mZ();
        mR();
        w.ag(cVar);
        Builder builder = new Builder();
        for (Entry entry : cVar.aFb.entrySet()) {
            str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        str = encodedQuery == null ? "" : encodedQuery;
        if (str.length() > 8192) {
            this.aFo.mT().a(cVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) aj.aHx.get()).intValue();
        long nc = nc();
        if (nc > ((long) (intValue - 1))) {
            List W = W((nc - ((long) intValue)) + 1);
            e("Store full, deleting hits to make room, count", Integer.valueOf(W.size()));
            s(W);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", str);
        contentValues.put("hit_time", Long.valueOf(cVar.aFe));
        contentValues.put("hit_app_id", Integer.valueOf(cVar.aFf));
        contentValues.put("hit_url", cVar.aFg ? ac.nC() : ac.nD());
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                ay("Failed to insert a hit (got -1)");
            } else {
                b("Hit saved to database. db-id, hit", Long.valueOf(insert), cVar);
            }
        } catch (SQLiteException e) {
            f("Error storing a hit", e);
        }
    }

    public final void endTransaction() {
        mR();
        getWritableDatabase().endTransaction();
    }

    final boolean isEmpty() {
        return nc() == 0;
    }

    protected final void mg() {
    }

    public final int nd() {
        q.mZ();
        mR();
        if (!this.aGD.V(86400000)) {
            return 0;
        }
        this.aGD.start();
        au("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(this.aFo.aFD.currentTimeMillis() - 2592000000L)});
        c("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long ne() {
        q.mZ();
        mR();
        return b(aGB, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.analytics.internal.s> nf() {
        /*
        r14 = this;
        r9 = 0;
        r10 = 1;
        r11 = 0;
        r14.mR();
        com.google.android.gms.analytics.internal.q.mZ();
        r0 = r14.getWritableDatabase();
        r1 = 5;
        r2 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 0;
        r3 = "cid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 1;
        r3 = "tid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 2;
        r3 = "adid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 3;
        r3 = "hits_count";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 4;
        r3 = "params";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = com.google.android.gms.analytics.internal.aj.aHz;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = r1.get();	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = (java.lang.Integer) r1;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r12 = r1.intValue();	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r8 = java.lang.String.valueOf(r12);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r3 = "app_uid=?";
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = 0;
        r5 = "0";
        r4[r1] = r5;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r1 = "properties";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00c8 }
        r13 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r13.<init>();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 == 0) goto L_0x0098;
    L_0x005f:
        r0 = 0;
        r3 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r0 = 1;
        r4 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r0 = 2;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 == 0) goto L_0x00aa;
    L_0x0070:
        r5 = r10;
    L_0x0071:
        r0 = 3;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r6 = (long) r0;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r0 = 4;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r8 = r14.aB(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 != 0) goto L_0x008c;
    L_0x0086:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 == 0) goto L_0x00ac;
    L_0x008c:
        r0 = "Read property with empty client id or tracker id";
        r14.c(r0, r3, r4);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
    L_0x0092:
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 != 0) goto L_0x005f;
    L_0x0098:
        r0 = r13.size();	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        if (r0 < r12) goto L_0x00a4;
    L_0x009e:
        r0 = "Sending hits to too many properties. Campaign report might be incorrect";
        r14.ax(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
    L_0x00a4:
        if (r9 == 0) goto L_0x00a9;
    L_0x00a6:
        r9.close();
    L_0x00a9:
        return r13;
    L_0x00aa:
        r5 = r11;
        goto L_0x0071;
    L_0x00ac:
        r0 = new com.google.android.gms.analytics.internal.s;	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r1 = 0;
        r0.<init>(r1, r3, r4, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        r13.add(r0);	 Catch:{ SQLiteException -> 0x00b7, all -> 0x00c8 }
        goto L_0x0092;
    L_0x00b7:
        r0 = move-exception;
        r1 = r9;
    L_0x00b9:
        r2 = "Error loading hits from the database";
        r14.f(r2, r0);	 Catch:{ all -> 0x00c0 }
        throw r0;	 Catch:{ all -> 0x00c0 }
    L_0x00c0:
        r0 = move-exception;
        r9 = r1;
    L_0x00c2:
        if (r9 == 0) goto L_0x00c7;
    L_0x00c4:
        r9.close();
    L_0x00c7:
        throw r0;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x00c2;
    L_0x00ca:
        r0 = move-exception;
        r1 = r9;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.u.nf():java.util.List<com.google.android.gms.analytics.internal.s>");
    }

    public final void s(List<Long> list) {
        w.ag(list);
        q.mZ();
        mR();
        if (!list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Long l = (Long) list.get(i2);
                    if (l != null && l.longValue() != 0) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(l);
                        i = i2 + 1;
                    }
                } else {
                    stringBuilder.append(")");
                    String stringBuilder2 = stringBuilder.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        c("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                        i = writableDatabase.delete("hits2", stringBuilder2, null);
                        if (i != list.size()) {
                            a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                            return;
                        }
                        return;
                    } catch (SQLiteException e) {
                        f("Error deleting hits", e);
                        throw e;
                    }
                }
            }
            throw new SQLiteException("Invalid hit id");
        }
    }

    public final void setTransactionSuccessful() {
        mR();
        getWritableDatabase().setTransactionSuccessful();
    }
}
