package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class p extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fRX = "xml".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int fRZ = "description".hashCode();
    private static final int fSa = "source".hashCode();
    private boolean fNJ = true;
    private boolean fOz = true;
    private boolean fPp = true;
    private boolean fRT = true;
    private boolean fRU = true;
    private boolean fRV = true;
    private boolean fRW = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fNJ = true;
                } else if (fRX == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fRZ == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (fSa == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNJ) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fRT) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRV) {
            contentValues.put("description", this.field_description);
        }
        if (this.fRW) {
            contentValues.put("source", this.field_source);
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
