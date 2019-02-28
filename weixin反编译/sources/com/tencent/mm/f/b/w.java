package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fSC = "brandUserName".hashCode();
    private static final int fTo = "userId".hashCode();
    private boolean fSo = true;
    private boolean fTn = true;
    public String field_brandUserName;
    public String field_userId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSC == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.fSo = true;
                } else if (fTo == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fSo) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fTn) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
