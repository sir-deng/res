package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.q.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;

public final class k implements c {
    public final boolean auQ() {
        return l.axM();
    }

    public final boolean auR() {
        return l.axO();
    }

    public final String auS() {
        as.Hm();
        return (String) com.tencent.mm.y.c.Db().get(a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null);
    }

    public final int auT() {
        int i = 0;
        com.tencent.mm.plugin.card.model.c avh = am.avh();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
        Cursor a = avh.gLA.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        x.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
        return i;
    }

    public final boolean nY(int i) {
        return l.nY(i);
    }
}
