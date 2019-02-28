package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement mTV;
    public SQLiteStatement mTW;
    private SQLiteStatement mTX;
    public SQLiteStatement mTY;
    public SQLiteStatement mTZ;
    private SQLiteStatement mUa;
    public SQLiteStatement mUb;

    protected final void Be() {
        if (Bf()) {
            this.mPC.v(-102, 4);
        }
        this.mPC.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.mPC.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.mPC.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.mPC.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.mPC.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.mPC.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.mTV = this.mPC.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.mTW = this.mPC.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.mTX = this.mPC.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.mTY = this.mPC.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.mTZ = this.mPC.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.mUa = this.mPC.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.mUb = this.mPC.compileStatement("SELECT changes();");
    }

    protected final boolean Bg() {
        super.Bg();
        this.mTV.close();
        this.mTW.close();
        this.mTX.close();
        this.mTY.close();
        this.mTZ.close();
        this.mUa.close();
        this.mUb.close();
        return true;
    }

    public final void g(String str, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            boolean inTransaction = this.mPC.inTransaction();
            if (!inTransaction) {
                this.mPC.beginTransaction();
            }
            this.mTY.bindString(1, str);
            for (Long longValue : list) {
                this.mTY.bindLong(2, longValue.longValue());
                this.mTY.execute();
            }
            if (!inTransaction) {
                this.mPC.commit();
            }
        }
    }

    public final void BS(String str) {
        this.mUa.bindString(1, str);
        this.mUa.execute();
    }

    public final Cursor BT(String str) {
        return this.mPC.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
    }

    public final void k(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            boolean inTransaction = this.mPC.inTransaction();
            if (!inTransaction) {
                this.mPC.beginTransaction();
            }
            this.mTV.bindString(1, str);
            for (String bindString : strArr) {
                this.mTV.bindString(2, bindString);
                this.mTV.execute();
            }
            if (!inTransaction) {
                this.mPC.commit();
            }
        }
    }

    public final void BU(String str) {
        this.mTX.bindString(1, str);
        this.mTX.execute();
    }

    protected final String getTableName() {
        return "Contact";
    }

    public final String getName() {
        return "FTS5ContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    protected final String aIQ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{aNy()});
    }

    protected final boolean Bf() {
        return !cF(-102, 4);
    }

    public final Cursor a(e eVar, String str, int[] iArr, int[] iArr2) {
        String aNE = eVar.aNE();
        String format = bi.oN(str) ? "" : String.format(" AND aux_index = '%s'", new Object[]{str});
        String str2 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.i(iArr);
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.i(iArr2);
        return this.mPC.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + str2 + str3 + " AND status >= 0 ORDER BY subtype;", new Object[]{aNy(), aNz(), aNy(), aNz(), aNz(), aNE}), null);
    }

    public final boolean b(e eVar) {
        Cursor rawQuery = this.mPC.rawQuery(String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[]{aNy(), aNz(), aNy(), aNz(), aNz(), eVar.aNE()}), null);
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    protected final boolean aNA() {
        return true;
    }
}
