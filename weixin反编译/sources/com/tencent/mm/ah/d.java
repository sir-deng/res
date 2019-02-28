package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class d extends af {
    public final void transfer(int i) {
        x.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (gO(i)) {
            g.pWK.h(336, 10);
            long currentTimeMillis = System.currentTimeMillis();
            as.Hm();
            if (bi.e((Integer) c.Db().get(86017, null)) == 3) {
                x.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                return;
            }
            as.Hm();
            c.Fc().fD("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            as.Hm();
            Cursor b = c.Ff().b("@all.weixin.android", "", null);
            b.moveToFirst();
            while (!b.isAfterLast()) {
                com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
                xVar.b(b);
                as.Hm();
                c.Ff().c(xVar.field_username, xVar);
                b.moveToNext();
            }
            b.close();
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            as.Hm();
            c.Db().set(86017, Integer.valueOf(3));
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        x.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
    }

    public final boolean gO(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
