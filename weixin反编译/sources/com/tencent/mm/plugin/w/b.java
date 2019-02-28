package com.tencent.mm.plugin.w;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static int oKP = 0;
    public static int oKQ = 1644429312;
    public static int oKR = 302122240;
    public static int oKS = 50;
    public static int oKT = 20;
    public static int oKU = 100;
    public static int oKV = 3;

    public static void bcr() {
        c fp = com.tencent.mm.y.c.c.IL().fp("100224");
        if (fp.isValid()) {
            Map civ = fp.civ();
            oKP = bi.getInt((String) civ.get("SyncOpen"), 0);
            oKQ = bi.getInt((String) civ.get("WindowsVersion"), 1644429312);
            oKR = bi.getInt((String) civ.get("MacVersion"), 302122240);
            oKS = bi.getInt((String) civ.get("MsgSyncSessionCount"), 50);
            oKT = bi.getInt((String) civ.get("MsgSyncMsgCount"), 20);
            oKU = bi.getInt((String) civ.get("MsgSyncSessionListCount"), 100);
            oKV = bi.getInt((String) civ.get("MsgSyncTimeLimit"), 3);
        }
        x.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d", Integer.valueOf(oKP), Integer.valueOf(oKQ), Integer.valueOf(oKR), Integer.valueOf(oKS), Integer.valueOf(oKT), Integer.valueOf(oKU), Integer.valueOf(oKV));
    }
}
