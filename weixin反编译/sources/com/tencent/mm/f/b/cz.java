package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fRc = "appVersion".hashCode();
    private static final int gnP = "reportId".hashCode();
    private static final int gob = "pkgMd5".hashCode();
    private static final int goh = "decryptKey".hashCode();
    private boolean fPp = true;
    private boolean fQF = true;
    public String field_appId;
    public int field_appVersion;
    public String field_decryptKey;
    public String field_pkgMd5;
    public int field_reportId;
    private boolean gnM = true;
    private boolean gnU = true;
    private boolean gog = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fRc == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (goh == hashCode) {
                    this.field_decryptKey = cursor.getString(i);
                } else if (gob == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
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
        if (this.fQF) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.gog) {
            contentValues.put("decryptKey", this.field_decryptKey);
        }
        if (this.gnU) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
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
