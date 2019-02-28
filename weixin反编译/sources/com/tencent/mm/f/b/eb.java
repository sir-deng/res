package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int guK = "bulletin_scene".hashCode();
    private static final int guL = "bulletin_content".hashCode();
    private static final int guM = "bulletin_url".hashCode();
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;
    private boolean guH = true;
    private boolean guI = true;
    private boolean guJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guK == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.guH = true;
                } else if (guL == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (guM == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.guH) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.guI) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.guJ) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
