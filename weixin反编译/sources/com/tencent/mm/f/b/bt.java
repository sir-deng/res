package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int ggZ = "appusername".hashCode();
    private static final int ghc = "score".hashCode();
    private boolean fRU;
    public String field_appusername;
    public int field_score;
    public String field_title;
    private boolean ggW;
    private boolean ghb;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggZ == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (ghc == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.ggW) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.ghb) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
