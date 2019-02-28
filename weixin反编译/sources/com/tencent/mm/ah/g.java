package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class g extends af {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean gO(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.g.pWK.h(336, 15);
        as.Hm();
        h Fc = c.Fc();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904").append(" != 0");
        x.d("MicroMsg.App.SyncTopConversation", "sql:%s", stringBuilder);
        Cursor a = Fc.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                x.v("MicroMsg.App.SyncTopConversation", "userName %s", a.getString(0));
                s.r(r1, false);
            }
            a.close();
        }
    }
}
