package com.tencent.mm.y;

import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bc;

public final class x {
    public static aq hE(String str) {
        return new aq("@black.android", null, str, null, true, true);
    }

    public static aq hF(String str) {
        as.Hm();
        bc FE = c.Fn().FE("@t.qq.com");
        if (FE == null) {
            return null;
        }
        return new aq("@t.qq.com", null, str, null, FE.isEnable(), FE.ckH());
    }

    public static aq P(String str, String str2) {
        aq aqVar = null;
        if (str != null && str.length() > 0) {
            as.Hm();
            bc FE = c.Fn().FE(str);
            if (FE != null) {
                if (FE.xIy == 1) {
                    String str3 = "@domain.android";
                    String str4 = FE.name;
                    String Yo = FE.xIx.Yo("");
                    String str5 = "";
                    if (Yo != null) {
                        str5 = str5 + Yo.replace("@", "");
                    }
                    if (str2 != null) {
                        str5 = str5 + str2;
                    }
                    aqVar = new aq(str3, str4, str5, FE.xIx.Yo(""), FE.isEnable(), true);
                }
            }
        }
        return aqVar;
    }
}
