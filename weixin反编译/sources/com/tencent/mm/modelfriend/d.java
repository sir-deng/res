package com.tencent.mm.modelfriend;

import com.tencent.mm.ax.n;
import com.tencent.mm.f.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

final class d extends c<af> {
    d() {
        this.xmG = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (afVar.foR.foT == 0) {
            try {
                int Gj = q.Gj() | Downloads.RECV_BUFFER_SIZE;
                as.Hm();
                com.tencent.mm.y.c.Db().set(34, Integer.valueOf(Gj));
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new n("", "", "", "", "", "", "", "", Gj, "", ""));
                x.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
