package com.tencent.mm.openim.d;

import com.tencent.mm.f.b.cn;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends cn {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.xrT.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        aVar.xrT.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appRec";
        aVar.xrT.put("appRec", "BLOB");
        stringBuilder.append(" appRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xrT.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "acctTypeId";
        aVar.xrT.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
