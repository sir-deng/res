package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class l extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLocalUsageRecordUpdateTimeIndex ON AppBrandLocalUsageRecord(updateTime)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fQo = "versionType".hashCode();
    private boolean fPX = true;
    private boolean fPY = true;
    private boolean fQl = true;
    public long field_updateTime;
    public String field_username;
    public int field_versionType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fQo == hashCode) {
                    this.field_versionType = cursor.getInt(i);
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
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fQl) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
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
