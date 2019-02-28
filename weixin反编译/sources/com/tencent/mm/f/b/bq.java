package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int ggh = "championUrl".hashCode();
    private static final int ggi = "championMotto".hashCode();
    private boolean fPX = true;
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;
    private boolean ggf = true;
    private boolean ggg = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ggh == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (ggi == hashCode) {
                    this.field_championMotto = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.ggf) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.ggg) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
