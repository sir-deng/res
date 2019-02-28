package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dq extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOe = Columns.VALUE.hashCode();
    private static final int fPM = "offset".hashCode();
    private static final int gsa = "logtime".hashCode();
    private static final int gsb = "logsize".hashCode();
    private static final int gsc = "errorcount".hashCode();
    private boolean fNW = true;
    private boolean fPv = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;
    private boolean grX = true;
    private boolean grY = true;
    private boolean grZ = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gsa == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (fPM == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gsb == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (gsc == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (fOe == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.grX) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.fPv) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.grY) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.grZ) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
        }
        if (this.fNW) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
