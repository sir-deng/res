package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOd = "abtestkey".hashCode();
    private static final int fOe = Columns.VALUE.hashCode();
    private static final int fOf = "expId".hashCode();
    private static final int fOg = "sequence".hashCode();
    private static final int fOh = "prioritylevel".hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fOj = "endTime".hashCode();
    private static final int fOk = "noReport".hashCode();
    private boolean fNV = true;
    private boolean fNW = true;
    private boolean fNX = true;
    private boolean fNY = true;
    private boolean fNZ = true;
    private boolean fOa = true;
    private boolean fOb = true;
    private boolean fOc = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOd == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.fNV = true;
                } else if (fOe == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (fOg == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (fOh == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (fOi == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fOj == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (fOk == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNV) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.fNW) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.fNX) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.fNY) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fNZ) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fOa) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fOb) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fOc) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
