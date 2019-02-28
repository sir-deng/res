package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class em extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gfi = "expireTime".hashCode();
    private static final int gwK = "host".hashCode();
    public long field_expireTime;
    public String field_host;
    private boolean geZ = true;
    private boolean gwJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwK == hashCode) {
                    this.field_host = cursor.getString(i);
                } else if (gfi == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gwJ) {
            contentValues.put("host", this.field_host);
        }
        if (this.geZ) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
