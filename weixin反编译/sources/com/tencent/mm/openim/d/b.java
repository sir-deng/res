package com.tencent.mm.openim.d;

import com.tencent.mm.f.b.cm;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends cm {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "acctTypeId";
        aVar.xrT.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        aVar.xrT.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "accTypeRec";
        aVar.xrT.put("accTypeRec", "BLOB");
        stringBuilder.append(" accTypeRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xrT.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
