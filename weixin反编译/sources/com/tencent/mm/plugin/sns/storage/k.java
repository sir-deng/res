package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.f.b.do;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class k extends do {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xrT.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "userName";
        aVar.columns[1] = "md5";
        aVar.xrT.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "newerIds";
        aVar.xrT.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "bgId";
        aVar.xrT.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bgUrl";
        aVar.xrT.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "older_bgId";
        aVar.xrT.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "local_flag";
        aVar.xrT.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "istyle";
        aVar.xrT.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "iFlag";
        aVar.xrT.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "icount";
        aVar.xrT.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "faultS";
        aVar.xrT.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "snsBgId";
        aVar.xrT.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "snsuser";
        aVar.xrT.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "adsession";
        aVar.xrT.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "lastFirstPageRequestErrCode";
        aVar.xrT.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastFirstPageRequestErrType";
        aVar.xrT.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        aVar.columns[16] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void byO() {
        this.field_local_flag &= -3;
    }

    public final boolean byP() {
        return (this.field_local_flag & 2) > 0;
    }

    public final bmk byQ() {
        try {
            return (bmk) new bmk().aH(this.field_snsuser);
        } catch (Exception e) {
            return null;
        }
    }

    public final ux byR() {
        wt wtVar = new wt();
        ux uxVar = new ux();
        if (bi.by(this.field_faultS)) {
            return uxVar;
        }
        try {
            ux uxVar2;
            wtVar = (wt) new wt().aH(this.field_faultS);
            if (wtVar.wnO.size() > 0) {
                uxVar2 = (ux) wtVar.wnO.getFirst();
            } else {
                uxVar2 = uxVar;
            }
            return uxVar2;
        } catch (Exception e) {
            return uxVar;
        }
    }
}
