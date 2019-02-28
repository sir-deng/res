package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cw extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQv = "version".hashCode();
    private static final int gnP = "reportId".hashCode();
    private static final int gnX = "retryTimes".hashCode();
    private static final int gnY = "retriedCount".hashCode();
    private static final int gnZ = "retryInterval".hashCode();
    private static final int goa = "networkType".hashCode();
    private static final int gob = "pkgMd5".hashCode();
    private static final int goc = "lastRetryTime".hashCode();
    private static final int god = "firstTimeTried".hashCode();
    private boolean fOz = true;
    private boolean fPp = true;
    private boolean fQp = true;
    public String field_appId;
    public boolean field_firstTimeTried;
    public long field_lastRetryTime;
    public int field_networkType;
    public String field_pkgMd5;
    public int field_reportId;
    public int field_retriedCount;
    public long field_retryInterval;
    public int field_retryTimes;
    public int field_type;
    public int field_version;
    private boolean gnM = true;
    private boolean gnQ = true;
    private boolean gnR = true;
    private boolean gnS = true;
    private boolean gnT = true;
    private boolean gnU = true;
    private boolean gnV = true;
    private boolean gnW = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fQv == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gnX == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (gnY == hashCode) {
                    this.field_retriedCount = cursor.getInt(i);
                } else if (gnZ == hashCode) {
                    this.field_retryInterval = cursor.getLong(i);
                } else if (goa == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (gob == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (goc == hashCode) {
                    this.field_lastRetryTime = cursor.getLong(i);
                } else if (god == hashCode) {
                    this.field_firstTimeTried = cursor.getInt(i) != 0;
                } else if (gnP == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.fQp) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gnQ) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.gnR) {
            contentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
        }
        if (this.gnS) {
            contentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
        }
        if (this.gnT) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.gnU) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.gnV) {
            contentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
        }
        if (this.gnW) {
            contentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
        }
        if (this.gnM) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
