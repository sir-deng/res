package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.f.b.ci;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class b extends ci {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "memberUuid";
        aVar.xrT.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "wxGroupId";
        aVar.xrT.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userName";
        aVar.xrT.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "inviteUserName";
        aVar.xrT.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "memberId";
        aVar.xrT.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
