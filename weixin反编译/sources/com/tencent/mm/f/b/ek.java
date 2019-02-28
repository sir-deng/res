package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ek extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOe = Columns.VALUE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQi = "size".hashCode();
    private static final int gfi = "expireTime".hashCode();
    private static final int gfn = "weight".hashCode();
    private static final int gwD = "appIdKey".hashCode();
    private static final int gwE = "timeStamp".hashCode();
    private boolean fNW = true;
    private boolean fPp = true;
    private boolean fQf = true;
    public String field_appId;
    public String field_appIdKey;
    public long field_expireTime;
    public long field_size;
    public long field_timeStamp;
    public String field_value;
    public String field_weight;
    private boolean geZ = true;
    private boolean gfe = true;
    private boolean gwB = true;
    private boolean gwC = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gwD == hashCode) {
                    this.field_appIdKey = cursor.getString(i);
                    this.gwB = true;
                } else if (fOe == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (gfn == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (gfi == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gwE == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (fQi == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gwB) {
            contentValues.put("appIdKey", this.field_appIdKey);
        }
        if (this.fNW) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.gfe) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.geZ) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gwC) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.fQf) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
