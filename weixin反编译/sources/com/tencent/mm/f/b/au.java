package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fZj = "productID".hashCode();
    private static final int gaU = "lan".hashCode();
    private boolean fOE = true;
    private boolean fYJ = true;
    public byte[] field_content;
    public String field_lan;
    public String field_productID;
    private boolean gaT = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZj == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.fYJ = true;
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (gaU == hashCode) {
                    this.field_lan = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYJ) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.gaT) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
