package com.tencent.mm.plugin.card.model;

import com.tencent.mm.f.b.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

public final class k extends ae {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "code_id";
        aVar.xrT.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "card_id";
        aVar.xrT.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        aVar.xrT.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
