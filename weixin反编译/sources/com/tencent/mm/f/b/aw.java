package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aw extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fRf = "modifyTime".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int gba = "prodcutID".hashCode();
    private static final int gbb = "totalCount".hashCode();
    private static final int gbc = "continuCount".hashCode();
    private static final int gbd = "showTipsTime".hashCode();
    private static final int gbe = "setFlagTime".hashCode();
    private boolean fQI = true;
    private boolean fSb = true;
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;
    private boolean gaV = true;
    private boolean gaW = true;
    private boolean gaX = true;
    private boolean gaY = true;
    private boolean gaZ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gba == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.gaV = true;
                } else if (gbb == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (gbc == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fRf == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gbd == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (gbe == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gaV) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.gaW) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.gaX) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fQI) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gaY) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.gaZ) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
