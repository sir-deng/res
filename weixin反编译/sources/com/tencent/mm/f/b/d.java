package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOf = "expId".hashCode();
    private static final int fOg = "sequence".hashCode();
    private static final int fOh = "prioritylevel".hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fOj = "endTime".hashCode();
    private static final int fOp = "layerId".hashCode();
    private static final int fOq = "business".hashCode();
    private static final int fOr = "needReport".hashCode();
    private static final int fOs = "rawXML".hashCode();
    private boolean fNX = true;
    private boolean fNY = true;
    private boolean fNZ = true;
    private boolean fOa = true;
    private boolean fOb = true;
    private boolean fOl = true;
    private boolean fOm = true;
    private boolean fOn = true;
    private boolean fOo = true;
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOp == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.fOl = true;
                } else if (fOq == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (fOr == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (fOs == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fOl) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.fOm) {
            contentValues.put("business", this.field_business);
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
        if (this.fOn) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fOo) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
