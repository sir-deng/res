package com.tencent.mm.y;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ar extends c {
    public static ar hhz = new ar(c.hby);

    private ar(c cVar) {
        super(cVar.hbz);
    }

    public final void S(String str, String str2) {
        x.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.hbz.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            ad.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", str2).commit();
        }
    }

    public final void c(String str, int i, String str2) {
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
            S("last_login_bind_qq", String.valueOf(i));
        }
        if (!bi.oN(str2)) {
            i2 |= 2;
            S("last_login_bind_email", String.valueOf(str2));
        }
        if (!bi.oN(str)) {
            i2 |= 4;
            S("last_login_bind_mobile", str);
        }
        S("last_bind_info", String.valueOf(i2));
    }

    public final String He() {
        return H("last_avatar_path", "");
    }

    public final void hP(String str) {
        x.i("MicroMsg.LastLoginInfo", "Save last avatar: " + str);
        if (!bi.oN(str)) {
            String substring = str.substring(str.lastIndexOf(47) + 1);
            if (!bi.oN(substring)) {
                substring = e.hbv + substring;
                boolean deleteFile = FileOp.deleteFile(substring);
                x.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", substring, Boolean.valueOf(deleteFile));
                FileOp.x(str, substring);
                S("last_avatar_path", substring);
            }
        }
    }
}
