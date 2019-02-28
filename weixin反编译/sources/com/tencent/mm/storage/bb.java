package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bb extends i<ba> {
    public static final String[] gLy = new String[]{i.a(ba.gKN, "OpenMsgListener")};
    public e gLA;

    public final /* synthetic */ boolean a(c cVar) {
        ba baVar = (ba) cVar;
        if (baVar == null || bi.oN(baVar.field_appId)) {
            x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            return false;
        }
        x.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", baVar.field_appId, Boolean.valueOf(this.gLA.replace("OpenMsgListener", ba.gKN.xrS, baVar.vP()) > 0));
        return this.gLA.replace("OpenMsgListener", ba.gKN.xrS, baVar.vP()) > 0;
    }

    public bb(e eVar) {
        super(eVar, ba.gKN, "OpenMsgListener", null);
        this.gLA = eVar;
        eVar.fD("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        eVar.fD("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    }

    public final ba Yj(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gLA.a("OpenMsgListener", null, "appId=?", new String[]{bi.oL(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            ba baVar = new ba();
            baVar.b(a);
            a.close();
            return baVar;
        }
        x.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + str);
        a.close();
        return null;
    }

    public final Cursor ckD() {
        return rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
    }
}
