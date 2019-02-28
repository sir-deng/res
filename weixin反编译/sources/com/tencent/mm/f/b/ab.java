package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ab extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fUF = "canvasId".hashCode();
    private static final int fUG = "canvasXml".hashCode();
    private boolean fOw = true;
    private boolean fUD = true;
    private boolean fUE = true;
    public long field_canvasId;
    public String field_canvasXml;
    public long field_createTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUF == hashCode) {
                    this.field_canvasId = cursor.getLong(i);
                    this.fUD = true;
                } else if (fUG == hashCode) {
                    this.field_canvasXml = cursor.getString(i);
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
        if (this.fUD) {
            contentValues.put("canvasId", Long.valueOf(this.field_canvasId));
        }
        if (this.fUE) {
            contentValues.put("canvasXml", this.field_canvasXml);
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
