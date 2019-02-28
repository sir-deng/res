package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ee extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gfo = "receiveTime".hashCode();
    private static final int gow = "receiveStatus".hashCode();
    private static final int gvn = "mNativeUrl".hashCode();
    private static final int gvo = "hbType".hashCode();
    private static final int gvp = "receiveAmount".hashCode();
    private static final int gvq = "hbStatus".hashCode();
    public int field_hbStatus;
    public int field_hbType;
    public String field_mNativeUrl;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;
    private boolean gff = true;
    private boolean gou = true;
    private boolean gvj = true;
    private boolean gvk = true;
    private boolean gvl = true;
    private boolean gvm = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvn == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i);
                    this.gvj = true;
                } else if (gvo == hashCode) {
                    this.field_hbType = cursor.getInt(i);
                } else if (gvp == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i);
                } else if (gfo == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (gow == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (gvq == hashCode) {
                    this.field_hbStatus = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gvj) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.gvk) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.gvl) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.gff) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.gou) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.gvm) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
