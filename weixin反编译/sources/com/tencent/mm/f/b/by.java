package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int ghA = "countryCode".hashCode();
    private static final int ghB = "callTimeCount".hashCode();
    private static final int ghC = "lastCallTime".hashCode();
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;
    private boolean ghx = true;
    private boolean ghy = true;
    private boolean ghz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ghA == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.ghx = true;
                } else if (ghB == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (ghC == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.ghx) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.ghy) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.ghz) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
