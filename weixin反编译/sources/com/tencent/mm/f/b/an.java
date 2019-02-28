package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class an extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fYB = "bakLogId".hashCode();
    private static final int fYC = "valueStr".hashCode();
    private boolean fYA;
    private boolean fYz;
    public int field_bakLogId;
    public String field_valueStr;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYB == hashCode) {
                    this.field_bakLogId = cursor.getInt(i);
                } else if (fYC == hashCode) {
                    this.field_valueStr = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYz) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.fYA) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
