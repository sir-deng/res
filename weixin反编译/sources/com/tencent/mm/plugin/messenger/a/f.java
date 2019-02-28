package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static d otT;

    public static d aZN() {
        if (otT == null) {
            otT = new b();
        }
        if (otT instanceof b) {
            x.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        return otT;
    }
}
