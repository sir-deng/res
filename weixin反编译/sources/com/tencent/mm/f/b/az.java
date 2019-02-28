package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class az extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPL = "totalLen".hashCode();
    private static final int fPM = "offset".hashCode();
    private static final int fQh = "dataType".hashCode();
    private static final int fRf = "modifyTime".hashCode();
    private static final int gaz = "cdnUrl".hashCode();
    private static final int gbX = "dataId".hashCode();
    private static final int gbY = "favLocalId".hashCode();
    private static final int gbZ = "cdnKey".hashCode();
    private static final int gca = "path".hashCode();
    private static final int gcb = "extFlag".hashCode();
    private static final int gcc = "attrFlag".hashCode();
    private boolean fNR = true;
    private boolean fOz = true;
    private boolean fPu = true;
    private boolean fPv = true;
    private boolean fQI = true;
    private boolean fQe = true;
    public long field_attrFlag;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;
    private boolean gaa = true;
    private boolean gbR = true;
    private boolean gbS = true;
    private boolean gbT = true;
    private boolean gbU = true;
    private boolean gbV = true;
    private boolean gbW = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "dataId";
        aVar.xrT.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "dataId";
        aVar.columns[1] = "favLocalId";
        aVar.xrT.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "cdnUrl";
        aVar.xrT.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "cdnKey";
        aVar.xrT.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "totalLen";
        aVar.xrT.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "offset";
        aVar.xrT.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "path";
        aVar.xrT.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "dataType";
        aVar.xrT.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.xrT.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "extFlag";
        aVar.xrT.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrFlag";
        aVar.xrT.put("attrFlag", "LONG default '0' ");
        stringBuilder.append(" attrFlag LONG default '0' ");
        aVar.columns[13] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbX == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.gbR = true;
                } else if (gbY == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gaz == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gbZ == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (fPL == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (fPM == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (fQh == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (fRf == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gcb == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (gcc == hashCode) {
                    this.field_attrFlag = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gbR) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.gbS) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
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
        if (this.fPv) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gbU) {
            contentValues.put("path", this.field_path);
        }
        if (this.fQe) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.fQI) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gbV) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.gbW) {
            contentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
