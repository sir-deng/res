package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dl extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQc = "key".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int gdG = DownloadInfo.FILENAME.hashCode();
    private static final int gqY = "cnValue".hashCode();
    private static final int gqZ = "qqValue".hashCode();
    private static final int gra = "twValue".hashCode();
    private static final int grb = "enValue".hashCode();
    private static final int grc = "thValue".hashCode();
    private static final int grd = "eggIndex".hashCode();
    private static final int gre = "position".hashCode();
    private boolean fQb = true;
    private boolean fSb = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;
    private boolean gdn = true;
    private boolean gqR = true;
    private boolean gqS = true;
    private boolean gqT = true;
    private boolean gqU = true;
    private boolean gqV = true;
    private boolean gqW = true;
    private boolean gqX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQc == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fQb = true;
                } else if (gqY == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (gqZ == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (gra == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (grb == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (grc == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (gdG == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (grd == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (gre == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fQb) {
            contentValues.put("key", this.field_key);
        }
        if (this.gqR) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.gqS) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.gqT) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.gqU) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.gqV) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.gdn) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gqW) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.gqX) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
