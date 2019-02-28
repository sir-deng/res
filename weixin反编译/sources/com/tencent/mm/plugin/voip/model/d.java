package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ad.d.c;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.aq;
import com.tencent.mm.y.as;
import com.tencent.mm.y.b;
import com.tencent.mm.y.bq;
import java.util.HashMap;

public final class d implements ap {
    private m spA = null;
    private i spB = new i();
    g spC;
    private a spD = new a();

    private static d bGS() {
        as.Hg();
        d dVar = (d) bq.ib("plugin.voip");
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        as.Hg().a("plugin.voip", dVar2);
        return dVar2;
    }

    public static m bGT() {
        if (as.Hp()) {
            if (bGS().spA == null) {
                bGS().spA = new m();
            }
            return bGS().spA;
        }
        throw new b();
    }

    public static g bGU() {
        if (as.Hp()) {
            if (bGS().spC == null) {
                bGS().spC = new g();
            }
            return bGS().spC;
        }
        throw new b();
    }

    public final void onAccountRelease() {
        if (this.spC != null) {
            ah.y(new Runnable() {
                public final void run() {
                    d.this.spC.dismiss();
                    d.this.spC = null;
                }
            });
        }
        c.b(Integer.valueOf(50), this.spB);
        bGT();
        m.bIh();
        com.tencent.mm.sdk.b.a.xmy.c(this.spD);
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        c.a(Integer.valueOf(50), this.spB);
        bGT();
        m.bIg();
        com.tencent.mm.sdk.b.a.xmy.b(this.spD);
        as.getNotification().cancel(40);
        as.Hm();
        boolean booleanValue = ((Boolean) com.tencent.mm.y.c.Db().get(73217, Boolean.valueOf(true))).booleanValue();
        as.Hm();
        boolean booleanValue2 = ((Boolean) com.tencent.mm.y.c.Db().get(73218, Boolean.valueOf(true))).booleanValue();
        boolean zy = com.tencent.mm.j.a.zy();
        as.Hm();
        x.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(zy), Boolean.valueOf(((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()));
        if (!((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
            boolean z2 = booleanValue || booleanValue2;
            if (z2 != zy) {
                if (z2 && !zy) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(500, 13, 1, false);
                } else if (!z2 && zy) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(500, 14, 1, false);
                }
            }
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.valueOf(true));
        }
        aq.gS(1);
    }

    public final void bt(boolean z) {
    }
}
