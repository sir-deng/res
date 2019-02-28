package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class i extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOe = Columns.VALUE.hashCode();
    private static final int fQc = "key".hashCode();
    private boolean fNW = true;
    private boolean fQb = true;
    public String field_key;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQc == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fQb = true;
                } else if (fOe == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fQb) {
            contentValues.put("key", this.field_key);
        }
        if (this.fNW) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
