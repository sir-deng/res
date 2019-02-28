package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gnw = "cardUserId".hashCode();
    private static final int gnx = "retryCount".hashCode();
    public String field_cardUserId;
    public int field_retryCount;
    private boolean gnu = true;
    private boolean gnv = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnw == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.gnu = true;
                } else if (gnx == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gnu) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.gnv) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
