package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.f.b.cl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class r extends cl {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqkey";
        aVar.xrT.put("reqkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "reqkey";
        aVar.columns[1] = "ack_key";
        aVar.xrT.put("ack_key", "TEXT");
        stringBuilder.append(" ack_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "receive_time";
        aVar.xrT.put("receive_time", "LONG");
        stringBuilder.append(" receive_time LONG");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
