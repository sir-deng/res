package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class dd extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPj = "subType".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gai = "md5".hashCode();
    private static final int gdF = "fileSize".hashCode();
    private static final int gdH = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gfi = "expireTime".hashCode();
    private static final int gnP = "reportId".hashCode();
    private static final int gnX = "retryTimes".hashCode();
    private static final int goU = "urlKey_hashcode".hashCode();
    private static final int goV = "urlKey".hashCode();
    private static final int goW = "fileVersion".hashCode();
    private static final int goX = "maxRetryTimes".hashCode();
    private static final int goY = "contentLength".hashCode();
    private static final int goZ = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int goa = "networkType".hashCode();
    private static final int gpa = "groupId1".hashCode();
    private static final int gpb = "groupId2".hashCode();
    private static final int gpc = DownloadInfo.PRIORITY.hashCode();
    private static final int gpd = "fileUpdated".hashCode();
    private static final int gpe = "deleted".hashCode();
    private static final int gpf = "resType".hashCode();
    private static final int gpg = "sampleId".hashCode();
    private static final int gph = "eccSignature".hashCode();
    private static final int gpi = "originalMd5".hashCode();
    private static final int gpj = "fileCompress".hashCode();
    private static final int gpk = "fileEncrypt".hashCode();
    private static final int gpl = "encryptKey".hashCode();
    private static final int gpm = "keyVersion".hashCode();
    private static final int gpn = "EID".hashCode();
    private static final int gpo = "needRetry".hashCode();
    private static final int gpp = "wvCacheType".hashCode();
    private static final int gpq = "packageId".hashCode();
    private boolean fNR = true;
    private boolean fON = true;
    private boolean fPp = true;
    private boolean fUP = true;
    private boolean fZJ = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;
    private boolean gdm = true;
    private boolean gdo = true;
    private boolean geZ = true;
    private boolean gnM = true;
    private boolean gnQ = true;
    private boolean gnT = true;
    private boolean goA = true;
    private boolean goB = true;
    private boolean goC = true;
    private boolean goD = true;
    private boolean goE = true;
    private boolean goF = true;
    private boolean goG = true;
    private boolean goH = true;
    private boolean goI = true;
    private boolean goJ = true;
    private boolean goK = true;
    private boolean goL = true;
    private boolean goM = true;
    private boolean goN = true;
    private boolean goO = true;
    private boolean goP = true;
    private boolean goQ = true;
    private boolean goR = true;
    private boolean goS = true;
    private boolean goT = true;
    private boolean gox = true;
    private boolean goy = true;
    private boolean goz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goU == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.gox = true;
                } else if (goV == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (goW == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (goa == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (goX == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (gnX == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (gdH == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (goY == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (goZ == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (gfi == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gai == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gpa == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (gpb == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (gpc == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (gpd == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (gpe == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (gpf == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (fPj == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (gnP == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (gpg == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (gph == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (gpi == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (gpj == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (gpk == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (gpl == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (gpm == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (gpn == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (gdF == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gpo == hashCode) {
                    this.field_needRetry = cursor.getInt(i) != 0;
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gpp == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (gpq == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gox) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.goy) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.goz) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.gnT) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.goA) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.gnQ) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.gdo) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.goB) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.goC) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.geZ) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fZJ) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.goD) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.goE) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.goF) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.goG) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.goH) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.goI) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.fON) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.gnM) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.goJ) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.goK) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.goL) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.goM) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.goN) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.goO) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.goP) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.goQ) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.gdm) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.goR) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.goS) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.goT) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
