package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private l gKV;
    com.tencent.mm.plugin.fts.c.d mTG;

    public class b extends com.tencent.mm.plugin.fts.a.a.a {
        public final boolean execute() {
            d.this.mTG.mPC.execSQL(String.format("DELETE FROM %s ;", new Object[]{com.tencent.mm.plugin.fts.c.d.aNy()}));
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class d extends f {
        public d(g gVar) {
            super(gVar);
        }

        protected final void a(h hVar) {
            Cursor rawQuery;
            super.a(hVar);
            hVar.mRN = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mTG;
            String str = this.mRy.fEe;
            int i = this.mRy.mRH;
            if (str.trim().length() > 0) {
                str = com.tencent.mm.plugin.fts.a.d.u(new String[]{str});
                rawQuery = dVar.mPC.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.aNy(), com.tencent.mm.plugin.fts.c.d.aNz(), com.tencent.mm.plugin.fts.c.d.aNy(), com.tencent.mm.plugin.fts.c.d.aNz(), com.tencent.mm.plugin.fts.c.d.aNz(), str}), null);
            } else {
                rawQuery = dVar.mPC.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.aNy()}), null);
            }
            while (rawQuery != null && rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                j kVar = new k();
                kVar.content = str;
                hVar.mRN.add(kVar);
            }
            rawQuery.close();
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.a.a {
        public String mTH;

        public final boolean execute() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.mTH);
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.am(this.mTH, false));
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.am(this.mTH, true));
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mTG;
            String str = this.mTH;
            String stringBuffer2 = stringBuffer.toString();
            Cursor rawQuery = dVar.mPC.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{com.tencent.mm.plugin.fts.c.d.aNy()}), new String[]{str});
            long j = -1;
            if (rawQuery.moveToNext()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            if (j >= 0) {
                dVar.mUg.bindLong(1, System.currentTimeMillis());
                dVar.mUg.bindLong(2, j);
                dVar.mUg.execute();
            } else {
                if (!dVar.mPC.inTransaction()) {
                    dVar.mPC.beginTransaction();
                }
                dVar.mPD.bindString(1, stringBuffer2);
                dVar.mPD.execute();
                dVar.mPE.bindString(1, str);
                dVar.mPE.bindLong(2, System.currentTimeMillis());
                dVar.mPE.execute();
                if (dVar.mPC.inTransaction()) {
                    dVar.mPC.commit();
                }
            }
            return true;
        }

        public final String getName() {
            return "AddSOSHistoryTask";
        }
    }

    public class c extends com.tencent.mm.plugin.fts.a.a.a {
        public String mTH;

        public final boolean execute() {
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mTG;
            String str = this.mTH;
            dVar.mPC.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{com.tencent.mm.plugin.fts.c.d.aNy()}), new String[]{str});
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.mTG = (com.tencent.mm.plugin.fts.c.d) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.gKV = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        return false;
    }

    public final void addSOSHistory(String str) {
        com.tencent.mm.plugin.fts.a.a.a aVar = new a();
        aVar.mTH = str;
        this.gKV.a(132072, aVar);
    }

    public final void deleteSOSHistory() {
        this.gKV.a(132072, new b());
    }

    public final void deleteSOSHistory(String str) {
        com.tencent.mm.plugin.fts.a.a.a cVar = new c();
        cVar.mTH = str;
        this.gKV.a(132072, cVar);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        com.tencent.mm.plugin.fts.a.a.a dVar = new d(gVar);
        this.gKV.a(-65536, dVar);
        return dVar;
    }

    protected final boolean Bg() {
        this.mTG = null;
        this.gKV = null;
        return true;
    }
}
