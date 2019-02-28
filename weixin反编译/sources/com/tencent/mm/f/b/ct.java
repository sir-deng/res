package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ct extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fQc = "key".hashCode();
    private static final int fQv = "version".hashCode();
    private boolean fPY = true;
    private boolean fPl = true;
    private boolean fQb = true;
    private boolean fQp = true;
    public String field_key;
    public int field_scene;
    public long field_updateTime;
    public int field_version;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQc == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (fQv == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fQb) {
            contentValues.put("key", this.field_key);
        }
        if (this.fQp) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
