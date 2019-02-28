package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fXT = "labelId".hashCode();
    private static final int fXU = "contactName".hashCode();
    private boolean fXR;
    private boolean fXS;
    public String field_contactName;
    public String field_labelId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXT == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (fXU == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fXR) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.fXS) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
