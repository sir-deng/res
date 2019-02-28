package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.f.b.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class b extends g {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "sdkVer";
        aVar.xrT.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "mediaSvrId";
        aVar.xrT.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "mediaId";
        aVar.xrT.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "clientAppDataId";
        aVar.xrT.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "totalLen";
        aVar.xrT.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "offset";
        aVar.xrT.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "isUpload";
        aVar.xrT.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "lastModifyTime";
        aVar.xrT.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileFullPath";
        aVar.xrT.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "fullXml";
        aVar.xrT.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgInfoId";
        aVar.xrT.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "netTimes";
        aVar.xrT.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "isUseCdn";
        aVar.xrT.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "signature";
        aVar.xrT.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "fakeAeskey";
        aVar.xrT.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "fakeSignature";
        aVar.xrT.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.columns[20] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean aPj() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }
}
