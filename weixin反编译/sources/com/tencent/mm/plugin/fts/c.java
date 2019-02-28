package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.File;

public final class c implements g {
    private SQLiteDatabase mOQ;
    private SQLiteStatement mOR;
    private SQLiteStatement mOS;
    private SQLiteStatement mOT;

    public c(String str) {
        x.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", str);
        if (this.mOQ != null) {
            x.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.mOQ.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        this.mOQ = SQLiteDatabase.openOrCreateDatabase(absolutePath, null);
        String yL = q.yL();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Do();
        byte[] t = com.tencent.mm.a.g.t((yL + ((long) a.Cn())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.mOQ;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, t);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mOQ.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.mOQ.execSQL("PRAGMA synchronous=NORMAL;");
        this.mOQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.mOR = this.mOQ.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.mOS = this.mOQ.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.mOT = this.mOQ.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
        e.u(18, System.currentTimeMillis() - currentTimeMillis);
        x.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s", Long.valueOf(r4 - currentTimeMillis), bi.fL((long) absolutePath.length()));
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        return new a(this.mOQ.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
    }

    public final Cursor a(String str, String[] strArr, CancellationSignal cancellationSignal) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        return new a(this.mOQ.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
    }

    public final SQLiteStatement compileStatement(String str) {
        x.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", str);
        return this.mOQ.compileStatement(str);
    }

    public final boolean cF(int i, int i2) {
        int i3;
        if (!BA("FTS5IndexVersion") || this.mOR == null) {
            i3 = 0;
        } else {
            i3 = (int) u((long) i, 0);
        }
        x.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final long u(long j, long j2) {
        this.mOR.bindLong(1, j);
        try {
            return this.mOR.simpleQueryForLong();
        } catch (SQLiteDoneException e) {
            return j2;
        }
    }

    public final void v(long j, long j2) {
        this.mOS.bindLong(1, j);
        this.mOS.bindLong(2, j2);
        this.mOS.execute();
    }

    public final boolean BA(String str) {
        Cursor rawQuery = this.mOQ.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    public final void execSQL(String str) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mOQ.execSQL(str);
    }

    public final void execSQL(String str, Object[] objArr) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mOQ.execSQL(str, objArr);
    }

    public final void close() {
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.mOQ;
        objArr[1] = Boolean.valueOf(this.mOQ == null ? false : this.mOQ.isOpen());
        x.w(str, str2, objArr);
        if (this.mOQ != null && this.mOQ.isOpen()) {
            x.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", Boolean.valueOf(this.mOQ.inTransaction()));
            while (this.mOQ.inTransaction()) {
                this.mOQ.endTransaction();
            }
            this.mOR.close();
            this.mOS.close();
            this.mOQ.close();
            this.mOQ = null;
        }
    }

    public final synchronized void beginTransaction() {
        if (!(this.mOQ == null || this.mOQ.inTransaction())) {
            this.mOQ.beginTransaction();
        }
    }

    public final boolean inTransaction() {
        if (this.mOQ == null || !this.mOQ.inTransaction()) {
            return false;
        }
        return true;
    }

    public final synchronized void commit() {
        if (this.mOQ != null && this.mOQ.inTransaction()) {
            this.mOQ.setTransactionSuccessful();
            this.mOQ.endTransaction();
        }
    }

    public final synchronized void rollback() {
        if (this.mOQ != null && this.mOQ.isOpen() && this.mOQ.inTransaction()) {
            x.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.mOQ.endTransaction();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", e);
            }
        }
        return;
    }

    protected static final void aNv() {
        com.tencent.mm.kernel.g.Dr();
        new File(com.tencent.mm.kernel.g.Dq().cachePath, "FTS5IndexMicroMsg.db").delete();
    }

    public static final File aNw() {
        com.tencent.mm.kernel.g.Dr();
        return new File(com.tencent.mm.kernel.g.Dq().cachePath, "FTS5IndexMicroMsg.db");
    }
}
