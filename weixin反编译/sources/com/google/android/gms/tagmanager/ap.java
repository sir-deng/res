package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class ap implements c {
    private static final String bcX = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", Columns.VALUE, "expires"});
    private v aFD;
    private final Executor bcY;
    private a bcZ;
    private int bda;
    private final Context mContext;

    class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, null, 1);
        }

        private static boolean b(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            try {
                new StringBuilder("Error querying for table ").append(str);
                m.qF();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                cursor2 = cursor;
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public final SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                ap.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            String path = sQLiteDatabase.getPath();
            if (h.version() >= 9) {
                File file = new File(path);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (b("datalayer", sQLiteDatabase)) {
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
                Set hashSet = new HashSet();
                try {
                    String[] columnNames = rawQuery2.getColumnNames();
                    for (Object add : columnNames) {
                        hashSet.add(add);
                    }
                    if (!hashSet.remove("key") || !hashSet.remove(Columns.VALUE) || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                        throw new SQLiteException("Database column missing");
                    } else if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    }
                } finally {
                    rawQuery2.close();
                }
            } else {
                sQLiteDatabase.execSQL(ap.bcX);
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class b {
        final String aXw;
        final byte[] bdf;

        b(String str, byte[] bArr) {
            this.aXw = str;
            this.bdf = bArr;
        }

        public final String toString() {
            return "KeyAndSerialized: key = " + this.aXw + " serialized hash = " + Arrays.hashCode(this.bdf);
        }
    }

    public ap(Context context) {
        this(context, w.pI(), "google_tagmanager.db", Executors.newSingleThreadExecutor());
    }

    private ap(Context context, v vVar, String str, Executor executor) {
        this.mContext = context;
        this.aFD = vVar;
        this.bda = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        this.bcY = executor;
        this.bcZ = new a(this.mContext, str);
    }

    private void ac(long j) {
        SQLiteDatabase bi = bi("Error opening database for deleteOlderThan.");
        if (bi != null) {
            try {
                new StringBuilder("Deleted ").append(bi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)})).append(" expired items");
                m.qH();
            } catch (SQLiteException e) {
                m.qF();
            }
        }
    }

    private static byte[] ao(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e4) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e5) {
                }
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private synchronized void b(List<b> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.aFD.currentTimeMillis();
            ac(currentTimeMillis);
            int size = list.size() + (rm() - this.bda);
            if (size > 0) {
                List dM = dM(size);
                new StringBuilder("DataLayer store full, deleting ").append(dM.size()).append(" entries to make room.");
                m.qG();
                strArr = (String[]) dM.toArray(new String[0]);
                if (!(strArr == null || strArr.length == 0)) {
                    SQLiteDatabase bi = bi("Error opening database for deleteEntries.");
                    if (bi != null) {
                        bi.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    }
                }
            }
        } catch (SQLiteException e) {
            new StringBuilder("Error deleting entries ").append(Arrays.toString(strArr));
            m.qF();
        } catch (Throwable th) {
            rn();
        }
        c(list, currentTimeMillis + j);
        rn();
    }

    private SQLiteDatabase bi(String str) {
        try {
            return this.bcZ.getWritableDatabase();
        } catch (SQLiteException e) {
            m.qF();
            return null;
        }
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase bi = bi("Error opening database for writeEntryToDatabase.");
        if (bi != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.aXw);
                contentValues.put(Columns.VALUE, bVar.bdf);
                bi.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<String> dM(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            m.qF();
            return arrayList;
        }
        SQLiteDatabase bi = bi("Error opening database for peekEntryIds.");
        if (bi == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = bi.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
                    m.qF();
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private static Object m(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream readObject2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject2 = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
            } catch (ClassNotFoundException e3) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                byteArrayInputStream.close();
                return readObject2;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e6) {
            objectInputStream = readObject2;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                }
            }
            byteArrayInputStream.close();
            return readObject2;
        } catch (ClassNotFoundException e8) {
            objectInputStream = readObject2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = readObject2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject2;
    }

    private List<a> rk() {
        try {
            ac(this.aFD.currentTimeMillis());
            List<b> rl = rl();
            List<a> arrayList = new ArrayList();
            for (b bVar : rl) {
                arrayList.add(new a(bVar.aXw, m(bVar.bdf)));
            }
            return arrayList;
        } finally {
            rn();
        }
    }

    private List<b> rl() {
        SQLiteDatabase bi = bi("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (bi == null) {
            return arrayList;
        }
        Cursor query = bi.query("datalayer", new String[]{"key", Columns.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int rm() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase bi = bi("Error opening database for getNumStoredEntries.");
        if (bi != null) {
            try {
                cursor = bi.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                m.qF();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void rn() {
        try {
            this.bcZ.close();
        } catch (SQLiteException e) {
        }
    }

    public final void a(final com.google.android.gms.tagmanager.c.c.a aVar) {
        this.bcY.execute(new Runnable() {
            public final void run() {
                aVar.t(ap.this.rk());
            }
        });
    }

    public final void a(List<a> list, final long j) {
        final List arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.aXw, ao(aVar.bbw)));
        }
        this.bcY.execute(new Runnable() {
            public final void run() {
                ap.this.b(arrayList, j);
            }
        });
    }
}
