package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class j extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQc = "key".hashCode();
    private static final int fQg = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int fQh = "dataType".hashCode();
    private static final int fQi = "size".hashCode();
    private boolean fQb = true;
    private boolean fQd = true;
    private boolean fQe = true;
    private boolean fQf = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQc == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fQb = true;
                } else if (fQg == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (fQh == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (fQi == hashCode) {
                    this.field_size = cursor.getInt(i);
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
        if (this.fQd) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.fQe) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.fQf) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
