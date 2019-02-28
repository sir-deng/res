package com.tencent.mm.be;

import com.tencent.mm.f.b.dh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public class j extends dh {
    protected static a gKN;
    protected static Field[] hUM = c.D(j.class).hUM;

    static {
        a aVar = new a();
        aVar.hUM = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrid";
        aVar.xrT.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "svrid";
        aVar.columns[1] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "scene";
        aVar.xrT.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createtime";
        aVar.xrT.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "talker";
        aVar.xrT.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.xrT.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sayhiuser";
        aVar.xrT.put("sayhiuser", "TEXT");
        stringBuilder.append(" sayhiuser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "sayhicontent";
        aVar.xrT.put("sayhicontent", "TEXT");
        stringBuilder.append(" sayhicontent TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgpath";
        aVar.xrT.put("imgpath", "TEXT");
        stringBuilder.append(" imgpath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "isSend";
        aVar.xrT.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[11] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
