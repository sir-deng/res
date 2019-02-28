package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class g extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPH = "sdkVer".hashCode();
    private static final int fPI = "mediaSvrId".hashCode();
    private static final int fPJ = "mediaId".hashCode();
    private static final int fPK = "clientAppDataId".hashCode();
    private static final int fPL = "totalLen".hashCode();
    private static final int fPM = "offset".hashCode();
    private static final int fPN = "isUpload".hashCode();
    private static final int fPO = "lastModifyTime".hashCode();
    private static final int fPP = "fileFullPath".hashCode();
    private static final int fPQ = "fullXml".hashCode();
    private static final int fPR = "msgInfoId".hashCode();
    private static final int fPS = "netTimes".hashCode();
    private static final int fPT = "isUseCdn".hashCode();
    private static final int fPU = "signature".hashCode();
    private static final int fPV = "fakeAeskey".hashCode();
    private static final int fPW = "fakeSignature".hashCode();
    private boolean fNR = true;
    private boolean fOw = true;
    private boolean fOz = true;
    private boolean fPA = true;
    private boolean fPB = true;
    private boolean fPC = true;
    private boolean fPD = true;
    private boolean fPE = true;
    private boolean fPF = true;
    private boolean fPp = true;
    private boolean fPq = true;
    private boolean fPr = true;
    private boolean fPs = true;
    private boolean fPt = true;
    private boolean fPu = true;
    private boolean fPv = true;
    private boolean fPw = true;
    private boolean fPx = true;
    private boolean fPy = true;
    private boolean fPz = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPH == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (fPI == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (fPJ == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (fPK == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (fPL == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (fPM == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (fPN == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fPO == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (fPP == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (fPQ == hashCode) {
                    this.field_fullXml = cursor.getString(i);
                } else if (fPR == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (fPS == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (fPT == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (fPU == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (fPV == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (fPW == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
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
        if (this.fPq) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.fPr) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.fPs) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.fPt) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Long.valueOf(this.field_type));
        }
        if (this.fPu) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.fPv) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Long.valueOf(this.field_status));
        }
        if (this.fPw) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fPx) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.fPy) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.fPz) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.fPA) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.fPB) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.fPC) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.fPD) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fPE) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.fPF) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
