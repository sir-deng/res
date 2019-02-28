package com.tencent.mm.modelvideo;

import com.tencent.mm.f.b.dk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class j extends dk {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xrT.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "localId";
        aVar.columns[1] = DownloadInfo.FILENAME;
        aVar.xrT.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileNameHash";
        aVar.xrT.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileMd5";
        aVar.xrT.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileLength";
        aVar.xrT.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "fileStatus";
        aVar.xrT.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileDuration";
        aVar.xrT.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.xrT.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.columns[8] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
