package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQm = "recordId".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int fSa = "source".hashCode();
    private static final int gwE = "timeStamp".hashCode();
    private static final int gwH = "link".hashCode();
    private static final int gwI = "imgUrl".hashCode();
    private boolean fQj = true;
    private boolean fRU = true;
    private boolean fRW = true;
    public String field_imgUrl;
    public String field_link;
    public String field_recordId;
    public String field_source;
    public long field_timeStamp;
    public String field_title;
    private boolean gwC = true;
    private boolean gwF = true;
    private boolean gwG = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQm == hashCode) {
                    this.field_recordId = cursor.getString(i);
                    this.fQj = true;
                } else if (gwH == hashCode) {
                    this.field_link = cursor.getString(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fSa == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (gwI == hashCode) {
                    this.field_imgUrl = cursor.getString(i);
                } else if (gwE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fQj) {
            contentValues.put("recordId", this.field_recordId);
        }
        if (this.gwF) {
            contentValues.put("link", this.field_link);
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRW) {
            contentValues.put("source", this.field_source);
        }
        if (this.gwG) {
            contentValues.put("imgUrl", this.field_imgUrl);
        }
        if (this.gwC) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
