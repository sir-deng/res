package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;

public interface g {
    boolean BA(String str);

    Cursor a(String str, String[] strArr, CancellationSignal cancellationSignal);

    void beginTransaction();

    boolean cF(int i, int i2);

    void commit();

    SQLiteStatement compileStatement(String str);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);

    long u(long j, long j2);

    void v(long j, long j2);
}
