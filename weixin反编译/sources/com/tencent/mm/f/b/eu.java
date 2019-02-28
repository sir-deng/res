package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eu extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int gjI = "appIdHash".hashCode();
    private static final int gyq = "openDebug".hashCode();
    private boolean fPp = true;
    public String field_appId;
    public int field_appIdHash;
    public boolean field_openDebug;
    private boolean gjD = true;
    private boolean gyp = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gjI == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.gjD = true;
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gyq == hashCode) {
                    this.field_openDebug = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gjD) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gyp) {
            contentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
