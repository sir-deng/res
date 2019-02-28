package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class bd extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fVc = "time".hashCode();
    private static final int gcN = "tagContent".hashCode();
    private static final int gcO = "subtype".hashCode();
    private static final int gch = "localId".hashCode();
    private boolean fOE = true;
    private boolean fOz = true;
    private boolean fUJ = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;
    private boolean gcL = true;
    private boolean gcM = true;
    private boolean gcf = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xrT.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "localId";
        aVar.columns[1] = "content";
        aVar.xrT.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "tagContent";
        aVar.xrT.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "time";
        aVar.xrT.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "subtype";
        aVar.xrT.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gch == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gcf = true;
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gcN == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (fVc == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcO == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcf) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.gcL) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.fUJ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcM) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
