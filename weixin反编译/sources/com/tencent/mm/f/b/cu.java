package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cu extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int gnI = "hit".hashCode();
    private static final int gnJ = "hitTimeMS".hashCode();
    private boolean fOz = true;
    private boolean fPp = true;
    public String field_appId;
    public int field_hit;
    public long field_hitTimeMS;
    public int field_type;
    private boolean gnG = true;
    private boolean gnH = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gnI == hashCode) {
                    this.field_hit = cursor.getInt(i);
                } else if (gnJ == hashCode) {
                    this.field_hitTimeMS = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gnG) {
            contentValues.put("hit", Integer.valueOf(this.field_hit));
        }
        if (this.gnH) {
            contentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
