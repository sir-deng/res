package com.tencent.mm.plugin.record.b;

import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends c<mv> {
    public l() {
        this.xmG = mv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mv mvVar = (mv) bVar;
        x.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", Integer.valueOf(mvVar.fFz.type));
        switch (mvVar.fFz.type) {
            case 0:
                mvVar.fFA.fFJ = h.IP(mvVar.fFz.fFB);
                break;
            case 1:
                x.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", Long.valueOf(mvVar.fFz.frh));
                mvVar.fFA.fFL = h.d(mvVar.fFz.fvZ, mvVar.fFz.frh);
                mvVar.fFA.fFK = h.c(mvVar.fFz.fvZ, mvVar.fFz.frh);
                mvVar.fFA.fFM = h.e(mvVar.fFz.fvZ, mvVar.fFz.frh);
                mvVar.fFA.fwx = h.f(mvVar.fFz.fvZ, mvVar.fFz.frh);
                break;
            case 2:
                x.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", mvVar.fFz.toUser, mvVar.fFz.fwx, Integer.valueOf(mvVar.fFz.fFD));
                h.a(mvVar.fFz.toUser, mvVar.fFz.fFC, mvVar.fFz.title, mvVar.fFz.desc, mvVar.fFz.fwx, mvVar.fFz.fFD, mvVar.fFz.fFH);
                break;
            case 3:
                x.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", Long.valueOf(mvVar.fFz.frh));
                h.ed(mvVar.fFz.frh);
                break;
            case 4:
                x.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", mvVar.fFz.toUser, Long.valueOf(mvVar.fFz.fFE.field_msgId));
                h.a(mvVar.fFz.toUser, mvVar.fFz.fwr, mvVar.fFz.fFE);
                break;
            case 5:
                x.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", mvVar.fFz.toUser);
                h.a(mvVar.fFz.context, mvVar.fFz.toUser, mvVar.fFz.fFG, mvVar.fFz.fFF, mvVar.fFz.fFb, mvVar.fFz.fFI);
                break;
            case 6:
                cg cgVar = new cg();
                h.a(mvVar.fFz.context, cgVar, mvVar.fFz.fFG, mvVar.fFz.fFF, true, true);
                d a = h.a(mvVar.fFz.context, cgVar, mvVar.fFz.fFG);
                mvVar.fFA.fFb = cgVar;
                mvVar.fFA.fFI = a;
                break;
            case 8:
                if (!bi.oN(mvVar.fFz.fwx)) {
                    h.b(mvVar.fFz.fvZ, mvVar.fFz.frh, true);
                    break;
                }
                h.a(mvVar.fFz.fvZ, mvVar.fFz.frh, true);
                break;
            case 9:
                mvVar.fFA.fFL = h.g(mvVar.fFz.fvZ, mvVar.fFz.frh);
                break;
        }
        return false;
    }
}
