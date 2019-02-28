package com.tencent.mm.storage;

import com.tencent.mm.f.b.cp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class ba extends cp {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "appId";
        aVar.columns[1] = DownloadInfoColumns.PACKAGENAME;
        aVar.xrT.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "sceneFlag";
        aVar.xrT.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "msgTypeFlag";
        aVar.xrT.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgState";
        aVar.xrT.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
