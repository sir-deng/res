package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bn extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gfr = "reqType".hashCode();
    private static final int gfs = "cache".hashCode();
    public byte[] field_cache;
    public String field_reqType;
    private boolean gfp = true;
    private boolean gfq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfr == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.gfp = true;
                } else if (gfs == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gfp) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.gfq) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
