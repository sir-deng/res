package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class er extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fQi = "size".hashCode();
    private static final int fSN = "msgType".hashCode();
    private static final int gca = "path".hashCode();
    private static final int gxP = "msgSubType".hashCode();
    private static final int gxQ = "msgtime".hashCode();
    private boolean fNJ = true;
    private boolean fPX = true;
    private boolean fQf = true;
    private boolean fSz = true;
    public long field_msgId;
    public int field_msgSubType;
    public int field_msgType;
    public long field_msgtime;
    public String field_path;
    public long field_size;
    public String field_username;
    private boolean gbU = true;
    private boolean gxN = true;
    private boolean gxO = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fSN == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (gxP == hashCode) {
                    this.field_msgSubType = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (fQi == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (gxQ == hashCode) {
                    this.field_msgtime = cursor.getLong(i);
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
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fSz) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.gxN) {
            contentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
        }
        if (this.gbU) {
            contentValues.put("path", this.field_path);
        }
        if (this.fQf) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.gxO) {
            contentValues.put("msgtime", Long.valueOf(this.field_msgtime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
