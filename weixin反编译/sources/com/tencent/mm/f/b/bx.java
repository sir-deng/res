package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int fSN = "msgType".hashCode();
    private static final int gbP = "svrId".hashCode();
    private static final int gfk = "isRead".hashCode();
    private static final int ghv = "pushTime".hashCode();
    private static final int ghw = "descUrl".hashCode();
    private boolean fOE = true;
    private boolean fRU = true;
    private boolean fSz = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;
    private boolean gbM = true;
    private boolean gfb = true;
    private boolean ght = true;
    private boolean ghu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbP == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.gbM = true;
                } else if (gfk == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ghv == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (fSN == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (ghw == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gbM) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.gfb) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.ght) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.fSz) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.ghu) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
