package com.tencent.mm.plugin.fts.c;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements h {
    private boolean fis;
    private boolean mPA;
    public g mPC;
    public SQLiteStatement mPD;
    public SQLiteStatement mPE;
    public SQLiteStatement mUg;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public d() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", "FTS5SOSHistoryStorage");
    }

    public final void create() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.fis));
        if (!this.fis) {
            int i;
            if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
                this.mPC = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexDB();
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.mPC.BA(aNz()) && this.mPC.BA(aNy())) {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{aNz()});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{aNy()});
                    this.mPC.execSQL(format);
                    this.mPC.execSQL(format2);
                    this.mPC.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{aNz()}));
                    this.mPC.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[]{aNy()}));
                    this.mPC.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[]{aNy()}));
                    this.mPC.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[]{aNy()}));
                }
                this.mPD = this.mPC.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{aNz()}));
                this.mPE = this.mPC.compileStatement(String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[]{aNy()}));
                this.mUg = this.mPC.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[]{aNy()}));
                boolean i2 = true;
            } else {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i2 = 0;
            }
            if (i2 != 0) {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.fis = true;
            }
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.mPA), Boolean.valueOf(this.fis));
        if (!this.mPA && this.fis) {
            this.mPD.close();
            this.mUg.close();
            this.mPE.close();
            x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.mPA = true;
        }
    }

    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    public final int getType() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public final int getPriority() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public static String aNy() {
        return new StringBuilder("FTS5MetaSOSHistory").toString();
    }

    public static String aNz() {
        return new StringBuilder("FTS5IndexSOSHistory").toString();
    }

    public final String br(String str, int i) {
        return null;
    }
}
