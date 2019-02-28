package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class bf extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int fRe = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int gai = "md5".hashCode();
    private static final int gdC = "downloadId".hashCode();
    private static final int gdD = "downloadUrl".hashCode();
    private static final int gdE = DownloadInfo.SECONDARYURL.hashCode();
    private static final int gdF = "fileSize".hashCode();
    private static final int gdG = DownloadInfo.FILENAME.hashCode();
    private static final int gdH = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gdI = "fileType".hashCode();
    private static final int gdJ = "autoInstall".hashCode();
    private static final int gdK = "showNotification".hashCode();
    private static final int gdL = "sysDownloadId".hashCode();
    private static final int gdM = "downloaderType".hashCode();
    private static final int gdN = "downloadUrlHashCode".hashCode();
    private static final int gdO = "downloadedSize".hashCode();
    private static final int gdP = "totalSize".hashCode();
    private static final int gdQ = "autoDownload".hashCode();
    private static final int gdR = DownloadInfoColumns.CHANNELID.hashCode();
    private static final int gdS = "errCode".hashCode();
    private static final int gdT = "startSize".hashCode();
    private static final int gdU = "startState".hashCode();
    private boolean fNR = true;
    private boolean fOa = true;
    private boolean fPl = true;
    private boolean fPp = true;
    private boolean fQH = true;
    private boolean fZJ = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public String field_md5;
    public String field_packageName;
    public int field_scene;
    public String field_secondaryUrl;
    public boolean field_showNotification;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;
    private boolean gdA = true;
    private boolean gdB = true;
    private boolean gdj = true;
    private boolean gdk = true;
    private boolean gdl = true;
    private boolean gdm = true;
    private boolean gdn = true;
    private boolean gdo = true;
    private boolean gdp = true;
    private boolean gdq = true;
    private boolean gdr = true;
    private boolean gds = true;
    private boolean gdt = true;
    private boolean gdu = true;
    private boolean gdv = true;
    private boolean gdw = true;
    private boolean gdx = true;
    private boolean gdy = true;
    private boolean gdz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdC == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.gdj = true;
                } else if (gdD == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gdE == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i);
                } else if (gdF == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gdG == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gdH == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gdI == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gai == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gdJ == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (gdK == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (gdL == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (gdM == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gdN == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (fRe == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (gdO == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (gdP == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (gdQ == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (gdR == hashCode) {
                    this.field_channelId = cursor.getString(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gdS == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (fOi == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (gdT == hashCode) {
                    this.field_startSize = cursor.getLong(i);
                } else if (gdU == hashCode) {
                    this.field_startState = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gdj) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.gdk) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.gdl) {
            contentValues.put(DownloadInfo.SECONDARYURL, this.field_secondaryUrl);
        }
        if (this.gdm) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.gdn) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.gdo) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gdp) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.fZJ) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gdq) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.gdr) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.gds) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.gdt) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gdu) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.fQH) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.gdv) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.gdw) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.gdx) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.gdy) {
            contentValues.put(DownloadInfoColumns.CHANNELID, this.field_channelId);
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.gdz) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.fOa) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.gdA) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.gdB) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
