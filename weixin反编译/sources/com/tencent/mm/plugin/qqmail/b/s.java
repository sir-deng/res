package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;

public final class s {
    r pva;

    public s() {
        as.Hm();
        String str = (String) c.Db().get(282625, (Object) "");
        try {
            this.pva = new r();
            this.pva.aH(Base64.decode(str, 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.pva = new r();
        }
    }

    public final void Ir(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pva.osz.size()) {
                break;
            } else if (((q) this.pva.osz.get(i2)).ptS.equals(str)) {
                this.pva.osz.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        save();
    }

    static void Is(String str) {
        au auVar = new au();
        auVar.dU("qqmail");
        auVar.aq(bb.hU("qqmail"));
        auVar.eS(0);
        auVar.setContent(String.format(ad.getContext().getString(R.l.eKf), new Object[]{str}));
        auVar.setType(1);
        auVar.eR(3);
        as.Hm();
        x.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", Long.valueOf(c.Fh().Q(auVar)));
    }

    final void save() {
        try {
            x.d("MicroMsg.ShareMailInfoMgr", "save %s", Base64.encodeToString(this.pva.toByteArray(), 0));
            as.Hm();
            c.Db().set(282625, r0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
        }
    }
}
