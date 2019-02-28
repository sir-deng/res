package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class n extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fOj = "endTime".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQA = "downloadURL".hashCode();
    private static final int fQv = "version".hashCode();
    private static final int fQw = "versionMd5".hashCode();
    private static final int fQx = "versionState".hashCode();
    private static final int fQy = "pkgPath".hashCode();
    private static final int fQz = "debugType".hashCode();
    private boolean fOa = true;
    private boolean fOb = true;
    private boolean fOw = true;
    private boolean fPp = true;
    private boolean fQp = true;
    private boolean fQq = true;
    private boolean fQr = true;
    private boolean fQs = true;
    private boolean fQt = true;
    private boolean fQu = true;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;

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
                } else if (fQw == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (fQx == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (fQy == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fQz == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (fQA == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (fOi == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fOj == hashCode) {
                    this.field_endTime = cursor.getLong(i);
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
        if (this.fQq) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.fQr) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.fQs) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fQt) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.fQu) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.fOa) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fOb) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
