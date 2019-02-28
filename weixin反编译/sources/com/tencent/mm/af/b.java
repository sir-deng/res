package com.tencent.mm.af;

import com.tencent.mm.f.b.y;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends y {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xrT.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "userName";
        aVar.columns[1] = "qyUin";
        aVar.xrT.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "userUin";
        aVar.xrT.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "userFlag";
        aVar.xrT.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wwExposeTimes";
        aVar.xrT.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wwMaxExposeTimes";
        aVar.xrT.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wwCorpId";
        aVar.xrT.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "wwUserVid";
        aVar.xrT.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "userType";
        aVar.xrT.put("userType", "INTEGER");
        stringBuilder.append(" userType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "chatOpen";
        aVar.xrT.put("chatOpen", "INTEGER");
        stringBuilder.append(" chatOpen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "wwUnreadCnt";
        aVar.xrT.put("wwUnreadCnt", "INTEGER default '0' ");
        stringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "show_confirm";
        aVar.xrT.put("show_confirm", "INTEGER");
        stringBuilder.append(" show_confirm INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "use_preset_banner_tips";
        aVar.xrT.put("use_preset_banner_tips", "INTEGER");
        stringBuilder.append(" use_preset_banner_tips INTEGER");
        aVar.columns[13] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
