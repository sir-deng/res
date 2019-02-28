package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.j.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class d {
    public static boolean aTK() {
        if (!as.Hp()) {
            return false;
        }
        if (g.Af().getInt("WCOEntranceSwitch", 0) > 0) {
            as.Hm();
            c.Db().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(true));
            return true;
        }
        as.Hm();
        c.Db().a(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false));
        return false;
    }
}
