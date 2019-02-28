package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.af;

public final class r {
    public p fhH;
    public aa yEu;

    public r(p pVar) {
        this.fhH = pVar;
    }

    public final boolean aP(au auVar) {
        if (!auVar.aNL()) {
            return false;
        }
        af.aI(auVar);
        this.fhH.mT(true);
        return true;
    }

    public final void cuG() {
        Intent intent = new Intent();
        g.pWK.h(12809, Integer.valueOf(1), "");
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.fhH.ctj());
        intent.putExtra("map_talker_name", this.fhH.csn());
        d.b(this.fhH.cte().getContext(), "location", ".ui.RedirectUI", intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cuH() {
        /*
        r5 = this;
        r1 = 1;
        r0 = r5.fhH;
        r0 = r0.cte();
        r0 = r0.getContext();
        r0 = com.tencent.mm.o.a.aW(r0);
        if (r0 != 0) goto L_0x004b;
    L_0x0011:
        r0 = r5.fhH;
        r0 = r0.cte();
        r0 = r0.getContext();
        r0 = com.tencent.mm.o.a.aU(r0);
        if (r0 != 0) goto L_0x004b;
    L_0x0021:
        r0 = com.tencent.mm.pluginsdk.q.a.vjf;
        r2 = r5.fhH;
        r2 = r2.csW();
        r2 = r2.field_username;
        r0 = r0.FY(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x0031:
        r0 = "MicroMsg.ChattingUI.LocationImp";
        r1 = "click share location, but now is in multitalk!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r5.fhH;
        r0 = r0.cte();
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.ewB;
        r2 = com.tencent.mm.R.l.dGZ;
        com.tencent.mm.ui.base.h.h(r0, r1, r2);
    L_0x004b:
        return;
    L_0x004c:
        r0 = 0;
        r2 = new com.tencent.mm.f.a.rk;
        r2.<init>();
        r3 = com.tencent.mm.pluginsdk.q.a.viX;
        if (r3 == 0) goto L_0x0075;
    L_0x0056:
        r3 = r2.fJX;
        r3.fJZ = r1;
        r3 = com.tencent.mm.sdk.b.a.xmy;
        r3.m(r2);
        r2 = r2.fJY;
        r2 = r2.fKb;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x00d7;
    L_0x0069:
        r0 = r5.fhH;
        r0 = r0.cte();
        r2 = com.tencent.mm.R.l.ebQ;
        r0 = r0.getMMString(r2);
    L_0x0075:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r2 != 0) goto L_0x00f4;
    L_0x007b:
        r2 = 0;
        r3 = com.tencent.mm.pluginsdk.q.a.vje;
        if (r3 == 0) goto L_0x00fe;
    L_0x0080:
        r3 = com.tencent.mm.pluginsdk.q.a.vje;
        r4 = r5.fhH;
        r4 = r4.csW();
        r4 = r4.field_username;
        r3 = r3.Ei(r4);
        if (r3 == 0) goto L_0x00fe;
    L_0x0090:
        r3 = com.tencent.mm.pluginsdk.q.a.vje;
        r4 = r5.fhH;
        r4 = r4.csW();
        r4 = r4.field_username;
        r3 = r3.Eg(r4);
        if (r3 == 0) goto L_0x00fe;
    L_0x00a0:
        r4 = r5.fhH;
        r4 = r4.ctj();
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00fe;
    L_0x00ac:
        if (r1 != 0) goto L_0x00f4;
    L_0x00ae:
        r1 = new com.tencent.mm.ui.base.i$a;
        r2 = r5.fhH;
        r2 = r2.cte();
        r2 = r2.getContext();
        r1.<init>(r2);
        r1.Zn(r0);
        r0 = com.tencent.mm.R.l.epx;
        r0 = r1.EV(r0);
        r2 = new com.tencent.mm.ui.chatting.b.r$2;
        r2.<init>();
        r0.a(r2);
        r0 = r1.ale();
        r0.show();
        goto L_0x004b;
    L_0x00d7:
        r2 = com.tencent.mm.pluginsdk.q.a.viX;
        r3 = r5.fhH;
        r3 = r3.csW();
        r3 = r3.field_username;
        r2 = r2.MW(r3);
        if (r2 == 0) goto L_0x0075;
    L_0x00e7:
        r0 = r5.fhH;
        r0 = r0.cte();
        r2 = com.tencent.mm.R.l.ebR;
        r0 = r0.getMMString(r2);
        goto L_0x0075;
    L_0x00f4:
        r0 = r5.yEu;
        r1 = "fromPluginLocation";
        r0.ZQ(r1);
        goto L_0x004b;
    L_0x00fe:
        r1 = r2;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.b.r.cuH():void");
    }
}
