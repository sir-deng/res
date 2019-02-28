package com.tencent.mm.bx;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.util.StringBuilderPrinter;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.CursorWrapper;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteAsyncCheckpointer;
import com.tencent.wcdb.database.SQLiteCheckpointListener;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteCursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wcdb.database.SQLiteTrace;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements DatabaseErrorHandler, SQLiteTrace {
    private static final SQLiteCipherSpec lvJ = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private static final SharedPreferences xJA;
    private static int xJB;
    private static final SQLiteCheckpointListener xJC;
    private static SQLiteTrace xJG;
    private static com.tencent.mm.plugin.report.a xJH = new com.tencent.mm.plugin.report.a();
    private static final int[] xJI = new int[]{27, 39, 24, 36, 27, 39, 48, 54, 33, 45, 30, 42, 33, 45, 51, 57};
    private static Map<String, SQLiteDatabase> xJz = new HashMap();
    private boolean xJD = false;
    private boolean xJE = false;
    private String xJF = null;
    SQLiteDatabase xJx = null;
    SQLiteDatabase xJy = null;

    private static class a extends CursorWrapper {
        private long mCreateTime;
        private int xJJ;
        private String xJK;

        public a(Cursor cursor, String str) {
            super(cursor);
            this.xJK = str;
            if (cursor instanceof SQLiteDirectCursor) {
                this.xJJ = 2;
            } else if (cursor instanceof SQLiteCursor) {
                this.xJJ = 1;
            } else {
                this.xJJ = -1;
            }
            this.mCreateTime = System.nanoTime();
        }

        public final void close() {
            this.mCursor.close();
            long nanoTime = (System.nanoTime() - this.mCreateTime) / 1000;
            int i = -1;
            if (this.xJJ == 1) {
                i = 0;
            } else if (this.xJJ == 2) {
                i = 3;
            }
            if (i >= 0) {
                f.xJH.f(i + 1, i + 2, nanoTime);
            }
        }

        public final int getCount() {
            x.w("MicroMsg.MMDataBase", "Slow operation: " + bi.i(new Throwable()));
            return this.mCursor.getCount();
        }

        public final double getDouble(int i) {
            try {
                return super.getDouble(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
                return 0.0d;
            }
        }

        public final float getFloat(int i) {
            try {
                return super.getFloat(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
                return 0.0f;
            }
        }

        public final int getInt(int i) {
            int i2 = 0;
            try {
                return super.getInt(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[i2]);
                return i2;
            }
        }

        public final long getLong(int i) {
            try {
                return super.getLong(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
                return 0;
            }
        }

        public final short getShort(int i) {
            short s = (short) 0;
            try {
                return super.getShort(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[s]);
                return s;
            }
        }

        public final String getString(int i) {
            try {
                return super.getString(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
                return null;
            }
        }

        public final byte[] getBlob(int i) {
            try {
                return super.getBlob(i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
                return null;
            }
        }
    }

    static {
        SQLiteGlobal.loadLib();
        SQLiteDebug.setIOTraceFlags(0);
        CursorWindow.windowSize(3145728);
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("db_config", 0);
        xJA = sharedPreferences;
        xJB = sharedPreferences.getInt("flags", 0);
        int i = xJA.getInt("acp", 100);
        xJC = new SQLiteAsyncCheckpointer(i >>> 16, i & 65535) {
            protected final void onCheckpointResult(SQLiteDatabase sQLiteDatabase, int i, int i2, long j) {
                int i3 = i == i2 ? 18 : 21;
                f.xJH.f(i3 + 1, i3 + 2, j);
                x.d("MicroMsg.MMDataBase", "Checkpointed, pages: %d/%d, time: %d, db: %s", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j), sQLiteDatabase.getPath());
            }
        };
    }

    public static void a(SQLiteTrace sQLiteTrace) {
        xJG = sQLiteTrace;
    }

    public static void aw(Map<String, ?> map) {
        Map all = xJA.getAll();
        if (all != null && !all.equals(map)) {
            Editor edit = xJA.edit();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    edit.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof String) {
                    edit.putString(str, value.toString());
                } else if (value instanceof Float) {
                    edit.putFloat(str, ((Float) value).floatValue());
                }
            }
            edit.apply();
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String clF() {
        int i = xJA.getInt("acp", 100);
        int i2 = i >>> 16;
        i &= 65535;
        return String.format("flags: 0x%04x\nacp: %d / %d", new Object[]{Integer.valueOf(xJA.getInt("flags", 0)), Integer.valueOf(i2), Integer.valueOf(i)});
    }

    static void YM(String str) {
        int i = 0;
        File file = new File(str);
        File parentFile = file.getParentFile();
        String name = file.getName();
        File file2 = new File(file.getParentFile(), "corrupted");
        file2.mkdirs();
        String[] strArr = new String[]{"", "-journal", "-wal", ".ini", ".bak", ".sm", "-vfslog", "-vfslo1"};
        while (i < 8) {
            String str2 = strArr[i];
            new File(parentFile, name + str2).renameTo(new File(file2, name + str2));
            i++;
        }
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        boolean isOpen = sQLiteDatabase.isOpen();
        x.e("MicroMsg.MMDataBase", "Database corrupted, isOpen: %s, path: %s", Boolean.toString(isOpen), sQLiteDatabase.getPath());
        if (!this.xJE) {
            this.xJE = true;
            int lastErrorLine = SQLiteDebug.getLastErrorLine();
            String clF = clF();
            String format = String.format("%s (line: %d, open: %s)\n%s", new Object[]{new File(sQLiteDatabase.getPath()).getName(), Integer.valueOf(lastErrorLine), Boolean.toString(sQLiteDatabase.isOpen()), clF});
            Map hashMap = new HashMap();
            hashMap.put("fileSystem", b.clA());
            d.pVE.c("DBCorrupt", format, hashMap);
        }
        List<Pair> attachedDbs = sQLiteDatabase.getAttachedDbs();
        if (isOpen) {
            int i;
            if (!sQLiteDatabase.isWriteAheadLoggingEnabled()) {
                i = 42;
            } else if (sQLiteDatabase.getAsyncCheckpointEnabled()) {
                i = 43;
            } else {
                i = 41;
            }
            d.pVE.a(181, (long) i, 1, true);
            sQLiteDatabase.close();
            if (attachedDbs == null) {
                YM(r9);
                return;
            }
            for (Pair pair : attachedDbs) {
                YM((String) pair.second);
            }
        }
    }

    public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
        int i2 = 0;
        if (sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i3;
            int i4 = sQLiteDatabase.isWriteAheadLoggingEnabled() ? 2 : 0;
            if (sQLiteDatabase.getAsyncCheckpointEnabled()) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            if (i != 1) {
                i2 = 8;
            }
            i4 = xJI[(i4 + i3) + i2];
            xJH.f(i4 + 1, i4 + 2, (long) ((int) j));
        }
        if (xJG != null) {
            xJG.onSQLExecuted(sQLiteDatabase, str, i, j);
        }
    }

    public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
        int i = 0;
        if (sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i2;
            int i3 = sQLiteDatabase.isWriteAheadLoggingEnabled() ? 2 : 0;
            if (sQLiteDatabase.getAsyncCheckpointEnabled()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            if (z) {
                i = 8;
            }
            i3 = xJI[((i3 + i2) + i) + 1];
            xJH.f(i3 + 1, i3 + 2, (long) ((int) j));
        }
    }

    public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
        if (this.xJF == null || !this.xJF.equals(str)) {
            this.xJF = str;
            StringBuilder stringBuilder = new StringBuilder(2048);
            stringBuilder.append("Waiting SQL: ").append(str).append(10).append("Running SQL: \n");
            for (String append : list) {
                stringBuilder.append("  ").append(append).append(10);
            }
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.setLength(0);
            try {
                sQLiteDatabase.dump(new StringBuilderPrinter(stringBuilder), false);
            } catch (Exception e) {
                stringBuilder.append(e.getMessage()).append(10).append(str2);
            }
            Map hashMap = new HashMap();
            hashMap.put("SQL", str);
            hashMap.put("message", stringBuilder.toString());
            hashMap.put("settings", clF());
            d.pVE.c("DBPoolBusy", stringBuilder2, hashMap);
            d.pVE.a(463, 6, 1, false);
        }
    }

    public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
    }

    public static f bh(String str, boolean z) {
        f fVar = new f();
        if (str == null || str.length() == 0) {
            fVar.xJy = SQLiteDatabase.create(null);
            fVar.xJD = true;
            if (fVar.xJy == null) {
                return null;
            }
            return fVar;
        }
        int i = SQLiteDatabase.CREATE_IF_NECESSARY;
        if (z) {
            i = 805306368;
        }
        try {
            fVar.xJy = SQLiteDatabase.openDatabase(str, null, i, fVar);
            fVar.xJy.setTraceCallback(fVar);
            if (clH()) {
                fVar.xJy.setCheckpointCallback(xJC);
                x.i("MicroMsg.MMDataBase", "Enable async checkpointer for DB: " + fVar.getPath());
            }
            if (BaseBuildInfo.ENABLE_STETHO) {
                xJz.put(fVar.getPath(), fVar.xJy);
            }
            if (fVar.xJy != null) {
                return fVar;
            }
            return null;
        } catch (Throwable e) {
            d.pVE.c("DBCantOpen", "DB (" + new File(str).getName() + ") can't open: " + bi.i(e), null);
            throw e;
        }
    }

    public final String getPath() {
        if (this.xJx != null) {
            return this.xJx.getPath();
        }
        return this.xJy.getPath();
    }

    public static boolean clG() {
        return (xJB & 1) == 0;
    }

    public static boolean clH() {
        return (xJB & 8) != 0;
    }

    public static f t(String str, String str2, boolean z) {
        String str3;
        SQLiteCipherSpec sQLiteCipherSpec;
        byte[] bArr;
        try {
            File file = new File(str + "-vfslog");
            File file2 = new File(str + "-vfslo1");
            if (file.exists() && file.length() > 256) {
                file.delete();
            }
            if (file2.exists() && file2.length() > 256) {
                file2.delete();
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMDataBase", th, "", new Object[0]);
        }
        f fVar = new f();
        int i = SQLiteDatabase.CREATE_IF_NECESSARY;
        if (bi.oN(str)) {
            str3 = SQLiteDatabaseConfiguration.MEMORY_DB_PATH;
            fVar.xJD = true;
        } else {
            str3 = str;
        }
        if (bi.oN(str2)) {
            sQLiteCipherSpec = null;
            bArr = null;
        } else {
            bArr = str2.getBytes();
            sQLiteCipherSpec = lvJ;
        }
        boolean clG = clG();
        if (z || clG) {
            i = 805306368;
        }
        try {
            fVar.xJx = SQLiteDatabase.openDatabase(str3, bArr, sQLiteCipherSpec, null, i, fVar);
            fVar.xJx.setTraceCallback(fVar);
            if (clH()) {
                fVar.xJx.setCheckpointCallback(xJC);
                x.i("MicroMsg.MMDataBase", "Enable async checkpointer for DB: " + fVar.getPath());
            }
            if (BaseBuildInfo.ENABLE_STETHO) {
                xJz.put(fVar.getPath(), fVar.xJx);
            }
            if (fVar.xJx == null) {
                return null;
            }
            return fVar;
        } catch (Throwable e) {
            d.pVE.c("DBCantOpen", "DB (" + new File(str3).getName() + ") can't open: " + bi.i(e), null);
            throw e;
        }
    }

    public final boolean isOpen() {
        if (this.xJx != null) {
            return this.xJx.isOpen();
        }
        if (this.xJy != null) {
            return this.xJy.isOpen();
        }
        return false;
    }

    public final void close() {
        try {
            if (this.xJx != null && this.xJx.isOpen()) {
                this.xJx.close();
                this.xJx = null;
            }
            if (this.xJy != null && this.xJy.isOpen()) {
                this.xJy.close();
                this.xJy = null;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MMDataBase", "exception:%s", bi.i(e));
        }
    }

    public final android.database.Cursor a(String str, String[] strArr, int i) {
        CursorFactory cursorFactory;
        SQLiteDatabase sQLiteDatabase = this.xJx != null ? this.xJx : this.xJy;
        Object obj = (xJB & 2) != 0 ? 1 : null;
        if (i == 4) {
            cursorFactory = com.tencent.mm.bx.a.f.FACTORY;
        } else if (b.cfx() || obj != null) {
            switch (i) {
                case 0:
                    cursorFactory = null;
                    break;
                case 1:
                    cursorFactory = SQLiteCursor.FACTORY;
                    break;
                case 2:
                    cursorFactory = SQLiteDirectCursor.FACTORY;
                    break;
                case 3:
                    cursorFactory = null;
                    break;
                default:
                    cursorFactory = null;
                    break;
            }
        } else {
            cursorFactory = null;
        }
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, null);
        if (i == 0 || i == 4) {
            return rawQueryWithFactory;
        }
        return new a(rawQueryWithFactory, str);
    }

    public final void execSQL(String str) {
        if (this.xJx != null) {
            this.xJx.execSQL(str);
        } else {
            this.xJy.execSQL(str);
        }
    }

    public final android.database.Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        SQLiteDatabase sQLiteDatabase = this.xJx != null ? this.xJx : this.xJy;
        Object obj = (xJB & 2) != 0 ? 1 : null;
        CursorFactory cursorFactory = null;
        if (i != 4) {
            if (b.cfx() || obj != null) {
                switch (i) {
                    case 0:
                        cursorFactory = null;
                        break;
                    case 1:
                        cursorFactory = SQLiteCursor.FACTORY;
                        break;
                    case 2:
                        cursorFactory = SQLiteDirectCursor.FACTORY;
                        break;
                    case 3:
                        cursorFactory = null;
                        break;
                    default:
                        cursorFactory = null;
                        break;
                }
            }
        }
        cursorFactory = com.tencent.mm.bx.a.f.FACTORY;
        Cursor queryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, false, str, strArr, str2, strArr2, str3, str4, str5, null);
        if (i == 0 || i == 4) {
            return queryWithFactory;
        }
        return new a(queryWithFactory, str);
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        if (this.xJx != null) {
            return this.xJx.insert(str, str2, contentValues);
        }
        return this.xJy.insert(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (this.xJx != null) {
            return this.xJx.update(str, contentValues, str2, strArr);
        }
        return this.xJy.update(str, contentValues, str2, strArr);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        if (this.xJx != null) {
            return this.xJx.replace(str, str2, contentValues);
        }
        return this.xJy.replace(str, str2, contentValues);
    }

    public final int delete(String str, String str2, String[] strArr) {
        if (this.xJx != null) {
            return this.xJx.delete(str, str2, strArr);
        }
        return this.xJy.delete(str, str2, strArr);
    }

    public final void beginTransaction() {
        try {
            if (this.xJx != null) {
                this.xJx.beginTransaction();
            } else {
                this.xJy.beginTransaction();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
        }
    }

    public final void endTransaction() {
        try {
            if (this.xJx != null) {
                this.xJx.setTransactionSuccessful();
                this.xJx.endTransaction();
                return;
            }
            this.xJy.setTransactionSuccessful();
            this.xJy.endTransaction();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
        }
    }

    public static boolean a(f fVar, String str) {
        if (fVar == null || str == null) {
            String str2 = "MicroMsg.MMDataBase";
            String str3 = "[arthurdan.checkTableExist] Notice!!! null == db: %b, table: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(fVar == null);
            objArr[1] = str;
            x.e(str2, str3, objArr);
            return false;
        }
        android.database.Cursor a = fVar.a("select tbl_name from sqlite_master  where type = \"table\" and tbl_name=\"" + str + "\"", null, 0);
        if (a == null) {
            return false;
        }
        int count = a.getCount();
        a.close();
        if (count > 0) {
            return true;
        }
        return false;
    }
}
