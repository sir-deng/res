package com.tencent.mm.plugin.sport.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class m extends i<e> {
    public static final String[] sam = new String[]{i.a(e.gKN, "SportStepItem")};
    private static final String[] san;

    static {
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[]{"SportStepItem", "SportStepItem"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{"SportStepItem", "SportStepItem"});
        san = r0;
    }

    public m() {
        super(g.Dq().gRU, e.gKN, "SportStepItem", san);
    }

    public static List<e> E(long j, long j2) {
        List arrayList = new ArrayList();
        String format = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[]{"SportStepItem"});
        Cursor a = g.Dq().gRU.a(format, new String[]{String.valueOf(j), String.valueOf(j2)}, 0);
        while (a.moveToNext()) {
            e eVar = new e();
            eVar.b(a);
            arrayList.add(eVar);
        }
        a.close();
        return arrayList;
    }

    public static e bDQ() {
        e eVar = null;
        Cursor a = g.Dq().gRU.a(String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[]{"SportStepItem"}), null, 0);
        try {
            if (a.moveToNext()) {
                eVar = new e();
                eVar.b(a);
            } else {
                a.close();
            }
            return eVar;
        } finally {
            a.close();
        }
    }

    public static void F(long j, long j2) {
        g.Dq().gRU.fD(null, String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[]{"SportStepItem", Long.valueOf(j), Long.valueOf(j2)}));
    }

    public static void cd(List<e> list) {
        SQLiteDatabase clK = g.Dq().gRU.clK();
        if (!clK.inTransaction()) {
            clK.beginTransaction();
        }
        SQLiteStatement compileStatement = clK.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[]{"SportStepItem"}));
        for (e eVar : list) {
            compileStatement.bindString(1, eVar.field_date);
            compileStatement.bindLong(2, (long) eVar.field_step);
            compileStatement.bindLong(3, eVar.field_timestamp);
            compileStatement.execute();
        }
        if (clK.inTransaction()) {
            clK.setTransactionSuccessful();
            clK.endTransaction();
        }
    }
}
