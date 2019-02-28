package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gvv = "pref_key".hashCode();
    private static final int gvw = "pref_title".hashCode();
    private static final int gvx = "pref_url".hashCode();
    private static final int gvy = "is_show".hashCode();
    public int field_is_show;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;
    private boolean gvr = true;
    private boolean gvs = true;
    private boolean gvt = true;
    private boolean gvu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvv == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.gvr = true;
                } else if (gvw == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (gvx == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (gvy == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gvr) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.gvs) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.gvt) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.gvu) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
