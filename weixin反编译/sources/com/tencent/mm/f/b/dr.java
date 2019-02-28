package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fZI = "count".hashCode();
    private static final int gsg = "tagId".hashCode();
    private static final int gsh = "tagName".hashCode();
    private static final int gsi = "memberList".hashCode();
    private boolean fZi = true;
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;
    private boolean gsd = true;
    private boolean gse = true;
    private boolean gsf = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gsg == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (gsh == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (fZI == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (gsi == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gsd) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.gse) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.fZi) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.gsf) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
