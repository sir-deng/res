package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bk extends i<bj> {
    public static final String[] gLy = new String[]{i.a(bj.gKN, "UserOpenIdInApp")};
    public e gLA;

    public bk(e eVar) {
        super(eVar, bj.gKN, "UserOpenIdInApp", null);
        this.gLA = eVar;
        eVar.fD("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        eVar.fD("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    }

    public final bj Yt(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gLA.a("UserOpenIdInApp", null, "openId=?", new String[]{bi.oL(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bj bjVar = new bj();
            bjVar.b(a);
            a.close();
            return bjVar;
        }
        x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public final boolean a(bj bjVar) {
        if (bjVar == null || bi.oN(bjVar.field_appId) || bi.oN(bjVar.field_openId) || bi.oN(bjVar.field_username)) {
            x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gLA.replace("UserOpenIdInApp", bj.gKN.xrS, bjVar.vP()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", bjVar.field_appId, bjVar.field_username, Boolean.valueOf(z));
        return z;
    }
}
