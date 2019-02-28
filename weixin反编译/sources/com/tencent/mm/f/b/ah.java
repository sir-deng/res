package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ah extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fXG = "cmdbuf".hashCode();
    private boolean fPX = true;
    private boolean fXF = true;
    public byte[] field_cmdbuf;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (fXG == hashCode) {
                    this.field_cmdbuf = cursor.getBlob(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fXF) {
            contentValues.put("cmdbuf", this.field_cmdbuf);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
