package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public final class b extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mUc;

    public static class a {
        public int mUd;
        public long timestamp;
    }

    protected final void Be() {
        if (Bf()) {
            this.mPC.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            v(-101, 2);
        }
        if (!this.mPC.BA("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(c.gKN.xrU);
            stringBuilder.append(");");
            this.mPC.execSQL(stringBuilder.toString());
        }
        this.mUc = this.mPC.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
    }

    protected final boolean Bf() {
        return !cF(XWalkUpdater.ERROR_SET_VERNUM, 2);
    }

    public final List<a> aNR() {
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.mPC.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{aNy()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                a aVar = new a();
                aVar.mUd = i;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean aV(List<c> list) {
        boolean inTransaction = this.mPC.inTransaction();
        if (!inTransaction) {
            this.mPC.beginTransaction();
        }
        this.mPC.execSQL("Delete from Feature");
        for (c cVar : list) {
            try {
                this.mUc.bindLong(1, (long) cVar.field_featureId);
                this.mUc.bindString(2, cVar.field_title);
                this.mUc.bindString(3, cVar.field_titlePY);
                this.mUc.bindString(4, cVar.field_titleShortPY);
                this.mUc.bindString(5, cVar.field_tag);
                this.mUc.bindLong(6, (long) cVar.field_actionType);
                this.mUc.bindString(7, cVar.field_url);
                this.mUc.bindString(8, cVar.field_helpUrl);
                this.mUc.bindString(9, cVar.field_updateUrl);
                this.mUc.bindString(10, cVar.field_androidUrl);
                this.mUc.bindString(11, cVar.field_iconPath);
                this.mUc.bindLong(12, cVar.field_timestamp);
                long executeInsert = this.mUc.executeInsert();
                x.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", Long.valueOf(executeInsert), Long.valueOf(cVar.field_timestamp));
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.mPC.commit();
        }
        return true;
    }

    public final c qv(int i) {
        c cVar = null;
        Cursor rawQuery = this.mPC.rawQuery("Select * from Feature where featureId = " + i, null);
        try {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
                rawQuery.close();
            }
            return cVar;
        } finally {
            rawQuery.close();
        }
    }

    protected final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTS5FeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    protected final boolean Bg() {
        super.Bg();
        this.mUc.close();
        return true;
    }

    protected final boolean aNA() {
        return true;
    }
}
