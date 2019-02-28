package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fXM = "labelID".hashCode();
    private static final int fXN = "labelName".hashCode();
    private static final int fXO = "labelPYFull".hashCode();
    private static final int fXP = "labelPYShort".hashCode();
    private static final int fXQ = "isTemporary".hashCode();
    private boolean fOw = true;
    private boolean fXH = true;
    private boolean fXI = true;
    private boolean fXJ = true;
    private boolean fXK = true;
    private boolean fXL = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXM == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.fXH = true;
                } else if (fXN == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (fXO == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (fXP == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fXQ == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fXH) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.fXI) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.fXJ) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.fXK) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fXL) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
