package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cx extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQv = "version".hashCode();
    private static final int fQy = "pkgPath".hashCode();
    private static final int gob = "pkgMd5".hashCode();
    private boolean fOz = true;
    private boolean fPp = true;
    private boolean fQp = true;
    private boolean fQs = true;
    public String field_appId;
    public String field_pkgMd5;
    public String field_pkgPath;
    public int field_type;
    public int field_version;
    private boolean gnU = true;

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
                } else if (gob == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (fQy == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
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
        if (this.gnU) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.fQs) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
