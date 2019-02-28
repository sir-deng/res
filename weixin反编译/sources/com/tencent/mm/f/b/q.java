package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class q extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int fSe = "sortId".hashCode();
    private boolean fPp = true;
    private boolean fSb = true;
    private boolean fSc = true;
    public String field_appId;
    public long field_flag;
    public int field_sortId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSd == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fSe == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fSb) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fSc) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
