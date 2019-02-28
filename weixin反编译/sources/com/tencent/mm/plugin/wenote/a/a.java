package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g.AnonymousClass1;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a extends c<kp> {
    public a() {
        this.xmG = kp.class.getName().hashCode();
    }

    private static boolean a(kp kpVar) {
        switch (kpVar.fCH.type) {
            case 0:
                com.tencent.mm.plugin.wenote.model.c.bWA().tWL.b(kpVar);
                break;
            case 2:
                if (kpVar.fCH.fCO == 4) {
                    long j;
                    String str;
                    String str2;
                    g.pWK.h(14789, Integer.valueOf(4));
                    x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    d gVar = new com.tencent.mm.plugin.wenote.model.g();
                    com.tencent.mm.plugin.wenote.model.c.bWA().tWL = gVar;
                    Context context = kpVar.fCH.context;
                    vn vnVar = kpVar.fCH.field_favProto;
                    Bundle bundle = kpVar.fCH.fCM;
                    boolean z = kpVar.fCH.fCQ;
                    String str3 = "";
                    String str4 = "";
                    if (bundle != null) {
                        String string = bundle.getString("noteauthor", "");
                        String string2 = bundle.getString("noteeditor", "");
                        j = bundle.getLong("edittime", 0);
                        gVar.tXe = bundle.getString("snslocalid");
                        gVar.tXf = bundle.getString("notexml", "");
                        gVar.tXm = bundle.getString("snsthumbpath", "");
                        gVar.tXn = bundle.getString("snsnotelinkxml", "");
                        str = string2;
                        str2 = string;
                    } else {
                        str = str4;
                        str2 = str3;
                        j = 0;
                    }
                    gVar.fCW = System.currentTimeMillis();
                    gVar.fCQ = z;
                    gVar.tWW = false;
                    gVar.tXj = str2 + ";" + str + ";" + j;
                    gVar.P(context, 4);
                    as.Dt().F(new AnonymousClass1(vnVar));
                    break;
                }
                g.pWK.h(14789, Integer.valueOf(1));
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                d gVar2 = new com.tencent.mm.plugin.wenote.model.g();
                com.tencent.mm.plugin.wenote.model.c.bWA().tWL = gVar2;
                if (!(kpVar.fCH.field_favProto == null || kpVar.fCH.field_favProto.wlW == null)) {
                    gVar2.tXk = kpVar.fCH.field_favProto.wlW.fqY;
                }
                if (kpVar.fCH.fCM != null) {
                    gVar2.tXl = kpVar.fCH.fCM.getLong("edittime", 0);
                }
                gVar2.a(kpVar.fCH.field_localId, kpVar.fCH.context, Boolean.valueOf(kpVar.fCH.fCQ), 0, 0, kpVar.fCH.fCR);
                break;
            case 3:
                kpVar.fCI.path = com.tencent.mm.bh.a.Vo();
                break;
            case 7:
                switch (kpVar.fCH.fCN) {
                    case 2:
                        h.aa(kpVar.fCH.fCP);
                        break;
                    case 3:
                        try {
                            h.Rq(kpVar.fCH.fCK);
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e, "", new Object[0]);
                            break;
                        }
                    case 4:
                        h.m(kpVar.fCH.context, kpVar.fCH.path, kpVar.fCH.fCO);
                        break;
                    case 5:
                        h.Rp(kpVar.fCH.path);
                        break;
                }
                break;
            case 8:
                h.aQ(kpVar.fCH.context, kpVar.fCH.path);
                break;
            case 9:
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                d gVar3 = new com.tencent.mm.plugin.wenote.model.g();
                gVar3.fCW = kpVar.fCH.field_localId;
                com.tencent.mm.plugin.wenote.model.c.bWA().tWL = gVar3;
                Context context2 = kpVar.fCH.context;
                gVar3.tWW = true;
                if (com.tencent.mm.pluginsdk.model.c.vjO) {
                    gVar3.P(context2, 2);
                    break;
                }
                break;
            case 10:
                f.s(kpVar.fCH.field_localId, kpVar.fCH.path);
                break;
            case 11:
                f.Z(kpVar.fCH.fCP);
                break;
            case 12:
                as.Dt().g(new Runnable() {
                    public final void run() {
                        c.this.bXd();
                        c.this.tZc = null;
                        c.this.tZd = null;
                        c.this.tZe = 0;
                        c.tZb = null;
                        c.this.tZc = null;
                    }
                }, 700);
                break;
        }
        return false;
    }
}
