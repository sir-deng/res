package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class es extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fRc = "appVersion".hashCode();
    private static final int gnP = "reportId".hashCode();
    private boolean fPX = true;
    private boolean fQF = true;
    public int field_appVersion;
    public int field_reportId;
    public String field_username;
    private boolean gnM = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (fRc == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (gnP == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.fQF) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.gnM) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
