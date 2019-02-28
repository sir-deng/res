package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cq extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int gfk = "isRead".hashCode();
    private static final int gnt = "msgContentXml".hashCode();
    private boolean fNJ = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;
    private boolean gfb = true;
    private boolean gns = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.fNJ = true;
                } else if (gnt == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (gfk == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNJ) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.gns) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.gfb) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
