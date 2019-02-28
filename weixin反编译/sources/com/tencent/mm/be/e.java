package com.tencent.mm.be;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static long n(String str, long j) {
        long j2 = 0;
        if (str != null) {
            f na = l.TD().na(str);
            if (na != null) {
                j2 = na.field_createTime + 1;
            }
        }
        return j2 > j * 1000 ? j2 : j * 1000;
    }

    public static void e(long j, String str) {
        boolean z = false;
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(j), str);
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + l.TE().d(j, str));
        g TD = l.TD();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
        } else {
            z = TD.gLA.fD("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + bi.oL(str) + "'");
        }
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + z);
    }
}
