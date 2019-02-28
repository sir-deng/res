package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ad extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fVA = "need_insert_show_timestamp".hashCode();
    private static final int fVB = "show_timestamp_encrypt_key".hashCode();
    private static final int fVC = "expire_time_interval".hashCode();
    private static final int fVD = "show_expire_interval".hashCode();
    private static final int fVE = "fetch_time".hashCode();
    private static final int fVd = "card_id".hashCode();
    private static final int fVz = "lower_bound".hashCode();
    private boolean fUK = true;
    private boolean fVt = true;
    private boolean fVu = true;
    private boolean fVv = true;
    private boolean fVw = true;
    private boolean fVx = true;
    private boolean fVy = true;
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVd == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fUK = true;
                } else if (fVz == hashCode) {
                    this.field_lower_bound = cursor.getInt(i);
                } else if (fVA == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i) != 0;
                } else if (fVB == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i);
                } else if (fVC == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i);
                } else if (fVD == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i);
                } else if (fVE == hashCode) {
                    this.field_fetch_time = cursor.getLong(i);
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
        if (this.fVt) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.fVu) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.fVv) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.fVw) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.fVx) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.fVy) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
