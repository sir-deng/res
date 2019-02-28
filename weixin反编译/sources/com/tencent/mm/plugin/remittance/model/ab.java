package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ab {
    public static void IX(String str) {
        if (!bi.oN(str)) {
            String boi = boi();
            x.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + boi);
            StringBuilder stringBuilder = new StringBuilder();
            if (!bi.oN(boi)) {
                String[] split = boi.split(",");
                if (split != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!str.equals(split[i2])) {
                            stringBuilder.append(split[i2]);
                            stringBuilder.append(",");
                            i++;
                            if (i >= 4) {
                                break;
                            }
                        }
                    }
                }
            }
            stringBuilder.insert(0, ",");
            stringBuilder.insert(0, str);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            x.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
            g.Dr();
            g.Dq().Db().set(327733, stringBuilder.toString());
            g.Dr();
            g.Dq().Db().lO(true);
        }
    }

    public static String boi() {
        g.Dr();
        return bi.oM((String) g.Dq().Db().get(327733, null));
    }
}
