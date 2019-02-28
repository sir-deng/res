package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ev extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fQz = "debugType".hashCode();
    private static final int gyA = "AppName".hashCode();
    private static final int gyB = "UserName".hashCode();
    private static final int gyC = "IconUrl".hashCode();
    private static final int gyD = "BriefIntro".hashCode();
    private static final int gyE = "isSync".hashCode();
    private static final int gyy = "RecordId".hashCode();
    private static final int gyz = "AppId".hashCode();
    private boolean fOw = true;
    private boolean fQt = true;
    public String field_AppId;
    public String field_AppName;
    public String field_BriefIntro;
    public String field_IconUrl;
    public String field_RecordId;
    public String field_UserName;
    public long field_createTime;
    public int field_debugType;
    public boolean field_isSync;
    private boolean gyr = true;
    private boolean gys = true;
    private boolean gyt = true;
    private boolean gyu = true;
    private boolean gyv = true;
    private boolean gyw = true;
    private boolean gyx = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gyy == hashCode) {
                    this.field_RecordId = cursor.getString(i);
                    this.gyr = true;
                } else if (gyz == hashCode) {
                    this.field_AppId = cursor.getString(i);
                } else if (gyA == hashCode) {
                    this.field_AppName = cursor.getString(i);
                } else if (gyB == hashCode) {
                    this.field_UserName = cursor.getString(i);
                } else if (gyC == hashCode) {
                    this.field_IconUrl = cursor.getString(i);
                } else if (gyD == hashCode) {
                    this.field_BriefIntro = cursor.getString(i);
                } else if (gyE == hashCode) {
                    this.field_isSync = cursor.getInt(i) != 0;
                } else if (fQz == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gyr) {
            contentValues.put("RecordId", this.field_RecordId);
        }
        if (this.gys) {
            contentValues.put("AppId", this.field_AppId);
        }
        if (this.gyt) {
            contentValues.put("AppName", this.field_AppName);
        }
        if (this.gyu) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.gyv) {
            contentValues.put("IconUrl", this.field_IconUrl);
        }
        if (this.gyw) {
            contentValues.put("BriefIntro", this.field_BriefIntro);
        }
        if (this.gyx) {
            contentValues.put("isSync", Boolean.valueOf(this.field_isSync));
        }
        if (this.fQt) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
