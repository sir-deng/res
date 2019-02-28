package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements k {
    public final int a(ev evVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        return auVar.field_content == null ? 0 : auVar.field_content.getBytes().length;
    }

    public final int a(String str, ev evVar, au auVar) {
        String str2 = new String(evVar.vNO.wRo);
        c Fh = b.arq().arr().Fh();
        auVar.setContent(str2);
        switch (evVar.kzz) {
            case 50:
                auVar.eR(6);
                break;
        }
        if (auVar.field_msgId == 0) {
            d.i(auVar);
        } else {
            Fh.b(evVar.vNT, auVar);
        }
        return 0;
    }
}
