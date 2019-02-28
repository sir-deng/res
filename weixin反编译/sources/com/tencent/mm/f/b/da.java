package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class da extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPJ = "mediaId".hashCode();
    private static final int fPL = "totalLen".hashCode();
    private static final int fPM = "offset".hashCode();
    private static final int gaz = "cdnUrl".hashCode();
    private static final int gbX = "dataId".hashCode();
    private static final int gbZ = "cdnKey".hashCode();
    private static final int gcD = "toUser".hashCode();
    private static final int gca = "path".hashCode();
    private static final int gch = "localId".hashCode();
    private static final int gdI = "fileType".hashCode();
    private static final int gdS = "errCode".hashCode();
    private static final int gok = "recordLocalId".hashCode();
    private static final int gol = "isThumb".hashCode();
    private boolean fNR = true;
    private boolean fOz = true;
    private boolean fPs = true;
    private boolean fPu = true;
    private boolean fPv = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public int field_type;
    private boolean gaa = true;
    private boolean gbR = true;
    private boolean gbT = true;
    private boolean gbU = true;
    private boolean gcf = true;
    private boolean gcp = true;
    private boolean gdp = true;
    private boolean gdz = true;
    private boolean goi = true;
    private boolean goj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gch == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gcf = true;
                } else if (gok == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (gcD == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (fPJ == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (gaz == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gbZ == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (fPL == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (gol == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (fPM == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gdI == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gdS == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcf) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.goi) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.gcp) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gbR) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.fPs) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.gbU) {
            contentValues.put("path", this.field_path);
        }
        if (this.gaa) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.gbT) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.fPu) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.goj) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.fPv) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gdp) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gdz) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
