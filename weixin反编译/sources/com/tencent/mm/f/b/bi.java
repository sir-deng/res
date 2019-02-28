package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class bi extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fYG = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gex = "protocolNumber".hashCode();
    private static final int gey = "logContent".hashCode();
    private boolean fOw = true;
    private boolean fYD = true;
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;
    private boolean gev = true;
    private boolean gew = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYG == hashCode) {
                    this.field_id = cursor.getString(i);
                    this.fYD = true;
                } else if (gex == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i);
                } else if (gey == hashCode) {
                    this.field_logContent = cursor.getString(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYD) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, this.field_id);
        }
        if (this.gev) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.gew) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
