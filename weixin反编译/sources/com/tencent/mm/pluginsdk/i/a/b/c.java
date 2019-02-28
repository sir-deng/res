package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bi;

final class c extends k {
    final long fileSize;
    private final boolean fqn;
    final String frM;
    volatile boolean ttd;
    final long vmS;
    volatile byte[] vns;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.Sw(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        this.frM = str2;
        this.vmS = j;
        this.fqn = z;
        this.fileSize = j2;
    }

    public final boolean caa() {
        return true;
    }

    public final String getFilePath() {
        return i.Sw(this.vmK);
    }

    public final String aam() {
        return "CheckResUpdate";
    }

    static c c(q qVar) {
        return new c(qVar.field_urlKey, bi.getInt(qVar.field_fileVersion, 0), qVar.field_md5, bi.oM(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_fileSize, qVar.field_networkType, qVar.field_priority);
    }
}
