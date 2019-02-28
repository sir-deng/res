package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mtV;

    protected final void Be() {
        if (Bf()) {
            this.mPC.v(-106, 4);
        }
        this.mtV = this.mPC.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{aNy()}));
    }

    protected final boolean Bf() {
        return !cF(-106, 4);
    }

    protected final String getTableName() {
        return "Favorite";
    }

    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    public final int getType() {
        return 256;
    }

    public final int getPriority() {
        return 256;
    }

    protected final String aIQ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[]{aNy()});
    }

    public final void a(int i, long j, String str, long j2, String str2, int i2) {
        String BH = d.BH(str2);
        if (!bi.oN(BH)) {
            boolean inTransaction = this.mPC.inTransaction();
            if (!inTransaction) {
                this.mPC.beginTransaction();
            }
            try {
                this.mPD.bindString(1, BH);
                this.mPD.execute();
                this.mtV.bindLong(1, 196608);
                this.mtV.bindLong(2, (long) i);
                this.mtV.bindLong(3, j);
                this.mtV.bindString(4, str);
                this.mtV.bindLong(5, j2);
                this.mtV.bindLong(6, (long) i2);
                this.mtV.execute();
                if (!inTransaction) {
                    this.mPC.commit();
                }
            } catch (SQLiteException e) {
                x.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(196608), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.mPK.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    x.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }
}
