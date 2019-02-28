package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gst = "tableHash".hashCode();
    private static final int gsu = "tableSQLMD5".hashCode();
    public int field_tableHash;
    public String field_tableSQLMD5;
    private boolean gsr = true;
    private boolean gss = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gst == hashCode) {
                    this.field_tableHash = cursor.getInt(i);
                    this.gsr = true;
                } else if (gsu == hashCode) {
                    this.field_tableSQLMD5 = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gsr) {
            contentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
        }
        if (this.gss) {
            contentValues.put("tableSQLMD5", this.field_tableSQLMD5);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
