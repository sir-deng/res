package com.tencent.mm.plugin.accountsync.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static a inm = new a();
    private Map<String, String> inn;

    public final Map<String, String> bI(Context context) {
        try {
            String q = bi.q(context.getAssets().open("config/EmailAddress.xml"));
            if (bi.oN(q)) {
                return null;
            }
            Map y = bj.y(q, "config");
            if (y == null || y.isEmpty()) {
                x.d("MicroMsg.EmailFormater", "values null");
                return null;
            } else if (this.inn != null) {
                return this.inn;
            } else {
                this.inn = new HashMap();
                int i = 0;
                while (true) {
                    q = ".config.format" + (i == 0 ? "" : Integer.valueOf(i));
                    if (y.get(q) == null) {
                        return this.inn;
                    }
                    String str = q + ".emaildomain";
                    String str2 = q + ".loginpage";
                    q = (String) y.get(str);
                    str = (String) y.get(str2);
                    if (!(bi.oN(q) || bi.oN(str))) {
                        this.inn.put(q, str);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.EmailFormater", "parse email failed:[%s]", e.getMessage());
            return null;
        }
    }
}
