package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int gtk = "cmsgId".hashCode();
    private boolean fNJ = true;
    private boolean fOE = true;
    public String field_cmsgId;
    public String field_content;
    public long field_msgId;
    private boolean gtj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fNJ = true;
                } else if (gtk == hashCode) {
                    this.field_cmsgId = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNJ) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gtj) {
            contentValues.put("cmsgId", this.field_cmsgId);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
