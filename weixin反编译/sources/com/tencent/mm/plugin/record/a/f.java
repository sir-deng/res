package com.tencent.mm.plugin.record.a;

import com.tencent.mm.f.b.da;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class f extends da implements b {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xrT.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "localId";
        aVar.columns[1] = "recordLocalId";
        aVar.xrT.put("recordLocalId", "INTEGER");
        stringBuilder.append(" recordLocalId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "toUser";
        aVar.xrT.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "dataId";
        aVar.xrT.put("dataId", "TEXT");
        stringBuilder.append(" dataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "mediaId";
        aVar.xrT.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "path";
        aVar.xrT.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "cdnUrl";
        aVar.xrT.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "cdnKey";
        aVar.xrT.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "totalLen";
        aVar.xrT.put("totalLen", "INTEGER default '0' ");
        stringBuilder.append(" totalLen INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "isThumb";
        aVar.xrT.put("isThumb", "INTEGER default 'false' ");
        stringBuilder.append(" isThumb INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "offset";
        aVar.xrT.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileType";
        aVar.xrT.put("fileType", "INTEGER default '5' ");
        stringBuilder.append(" fileType INTEGER default '5' ");
        stringBuilder.append(", ");
        aVar.columns[13] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "errCode";
        aVar.xrT.put("errCode", "INTEGER default '0' ");
        stringBuilder.append(" errCode INTEGER default '0' ");
        aVar.columns[15] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final int bnr() {
        return this.field_localId;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("localid[").append(this.field_localId).append("]\n");
        stringBuilder.append("recordId[").append(this.field_recordLocalId).append("]\n");
        stringBuilder.append("mediaId[").append(this.field_mediaId).append("]\n");
        stringBuilder.append("dataId[").append(this.field_dataId).append("]\n");
        stringBuilder.append("path[").append(this.field_path).append("]\n");
        stringBuilder.append("cdnurl[").append(this.field_cdnUrl).append("]\n");
        stringBuilder.append("cdnkey[").append(this.field_cdnKey).append("]\n");
        stringBuilder.append("type[").append(this.field_type).append("]\n");
        stringBuilder.append("errCode[").append(this.field_errCode).append("]\n");
        stringBuilder.append("fileType[").append(this.field_fileType).append("]\n");
        stringBuilder.append("isThumb[").append(this.field_isThumb).append("]\n");
        stringBuilder.append("status[").append(this.field_status).append("]\n");
        stringBuilder.append("totalLen[").append(this.field_totalLen).append("]\n");
        stringBuilder.append("offset[").append(this.field_offset).append("]\n");
        stringBuilder.append("toUser[").append(this.field_toUser).append("]\n");
        return stringBuilder.toString();
    }
}
