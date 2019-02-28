package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int qtx = "lastshaketime".hashCode();
    private static final int qty = "isshowed".hashCode();
    private boolean fPX;
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;
    private boolean qtv;
    private boolean qtw;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (qtx == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i);
                } else if (qty == hashCode) {
                    this.field_isshowed = cursor.getInt(i) != 0;
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
        if (this.qtv) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.qtw) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
