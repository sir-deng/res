package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class ep extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fQc = "key".hashCode();
    private static final int fQi = "size".hashCode();
    private static final int fQv = "version".hashCode();
    private static final int gai = "md5".hashCode();
    private static final int gdD = "downloadUrl".hashCode();
    private static final int gdH = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gxi = "pkgId".hashCode();
    private static final int gxj = "rid".hashCode();
    private static final int gxk = "mimeType".hashCode();
    private static final int gxl = "downloadNetType".hashCode();
    private static final int gxm = "completeDownload".hashCode();
    private static final int gxn = "autoDownloadCount".hashCode();
    private static final int gxo = "fileDownloadCount".hashCode();
    private boolean fOw = true;
    private boolean fQb = true;
    private boolean fQf = true;
    private boolean fQp = true;
    private boolean fZJ = true;
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;
    private boolean gdk = true;
    private boolean gdo = true;
    private boolean gxb = true;
    private boolean gxc = true;
    private boolean gxd = true;
    private boolean gxe = true;
    private boolean gxf = true;
    private boolean gxg = true;
    private boolean gxh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQc == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fQb = true;
                } else if (gxi == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                } else if (fQv == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gdH == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gxj == hashCode) {
                    this.field_rid = cursor.getString(i);
                } else if (gxk == hashCode) {
                    this.field_mimeType = cursor.getString(i);
                } else if (gai == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gdD == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (fQi == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gxl == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (gxm == hashCode) {
                    this.field_completeDownload = cursor.getInt(i) != 0;
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gxn == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (gxo == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i);
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
        if (this.gxb) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.fQp) {
            contentValues.put("version", this.field_version);
        }
        if (this.gdo) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gxc) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.gxd) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.fZJ) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gdk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.fQf) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.gxe) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.gxf) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gxg) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.gxh) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
