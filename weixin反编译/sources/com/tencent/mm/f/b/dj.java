package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dj extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fVd = "card_id".hashCode();
    private static final int gnx = "retryCount".hashCode();
    private static final int gqE = "state_flag".hashCode();
    private static final int gqF = "update_time".hashCode();
    private static final int gqG = "seq".hashCode();
    private boolean fUK = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;
    private boolean gnv = true;
    private boolean gqB = true;
    private boolean gqC = true;
    private boolean gqD = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVd == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fUK = true;
                } else if (gqE == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (gqF == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (gqG == hashCode) {
                    this.field_seq = cursor.getLong(i);
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
        if (this.fUK) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.gqB) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.gqC) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.gqD) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
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
