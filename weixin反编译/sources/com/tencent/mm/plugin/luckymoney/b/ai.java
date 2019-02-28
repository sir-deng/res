package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Iterator;

public final class ai implements e {
    boolean ojm;
    public af ojn;
    public ac ojo;
    private v ojp;
    public c ojq = new c<tl>() {
        {
            this.xmG = tl.class.getName().hashCode();
        }

        private boolean a(tl tlVar) {
            if (tlVar instanceof tl) {
                switch (tlVar.fMJ.action) {
                    case 1:
                        e eVar = ai.this;
                        long j = tlVar.fMJ.fqB;
                        if (!eVar.ojm) {
                            eVar.ojm = true;
                            cg dI = ((h) g.h(h.class)).aZO().dI(j);
                            String str = dI.field_content;
                            a I = str != null ? a.I(str, dI.field_reserved) : null;
                            if (I != null) {
                                String oM = bi.oM(I.hes);
                                Uri parse = Uri.parse(oM);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = bi.getInt(parse.getQueryParameter("channelid"), 1);
                                if (eVar.ojn != null) {
                                    g.Dr();
                                    g.Dp().gRu.c(eVar.ojn);
                                    eVar.ojn = null;
                                }
                                g.Dr();
                                g.Dp().gRu.a(1581, eVar);
                                eVar.ojn = new af(i, queryParameter, oM, 3, "v1.0");
                                eVar.ojn.talker = dI.field_talker;
                                eVar.ojn.frh = j;
                                g.Dr();
                                g.Dp().gRu.a(eVar.ojn, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            return false;
        }
    };

    public ai() {
        com.tencent.mm.sdk.b.a.xmy.b(this.ojq);
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dr();
        g.Dp().gRu.b(1581, (e) this);
        g.Dr();
        g.Dp().gRu.b(1685, (e) this);
        g.Dr();
        g.Dp().gRu.b(1585, (e) this);
        if (kVar instanceof af) {
            af afVar = (af) kVar;
            if (i != 0 || i2 != 0) {
                this.ojm = false;
                dG(afVar.frh);
            } else if (afVar.fMy == 4) {
                if (this.ojp != null) {
                    g.Dr();
                    g.Dp().gRu.c(this.ojp);
                    this.ojp = null;
                }
                g.Dr();
                g.Dp().gRu.a(1585, (e) this);
                this.ojp = new v(afVar.oeH, 11, 0, afVar.fMx, "v1.0");
                this.ojp.talker = afVar.talker;
                this.ojp.frh = afVar.frh;
                g.Dr();
                g.Dp().gRu.a(this.ojp, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
            } else if (afVar.fMz == 1 || afVar.fMy == 5 || afVar.fMy == 1) {
                this.ojm = false;
                x.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                dG(afVar.frh);
            } else {
                if (this.ojo != null) {
                    g.Dr();
                    g.Dp().gRu.c(this.ojo);
                    this.ojo = null;
                }
                g.Dr();
                g.Dp().gRu.a(1685, (e) this);
                this.ojo = new ac(afVar.msgType, afVar.fei, afVar.oeH, afVar.fMx, n.aXM(), q.Ga(), afVar.talker, "v1.0", afVar.ojj);
                this.ojo.frh = afVar.frh;
                g.Dr();
                g.Dp().gRu.a(this.ojo, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
            }
        } else if (kVar instanceof ac) {
            this.ojm = false;
            ac acVar = (ac) kVar;
            if (i == 0 && i2 == 0) {
                e eVar = acVar.oiv;
                if (eVar.fMz == 2) {
                    a(eVar, acVar.frh, acVar.talker);
                    return;
                } else {
                    dG(acVar.frh);
                    return;
                }
            }
            dG(acVar.frh);
        } else if (kVar instanceof v) {
            this.ojm = false;
            v vVar = (v) kVar;
            if (i == 0 && i2 == 0) {
                a(vVar.oiv, vVar.frh, vVar.talker);
            } else {
                dG(vVar.frh);
            }
        }
    }

    private static void dG(long j) {
        b tlVar = new tl();
        tlVar.fMJ.action = 2;
        tlVar.fMK.fqB = j;
        tlVar.fMK.fMM = 0;
        tlVar.fMK.fMN = "";
        com.tencent.mm.sdk.b.a.xmy.a(tlVar, Looper.getMainLooper());
    }

    private static void a(e eVar, long j, String str) {
        b tlVar = new tl();
        tlVar.fMJ.action = 2;
        tlVar.fMK.fqB = j;
        tlVar.fMK.fMM = eVar.fMM;
        tlVar.fMK.fMN = eVar.ohF;
        tlVar.fMK.fMO = new ArrayList();
        if (s.eX(str)) {
            Iterator it = eVar.ohN.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                tlVar.fMK.fMO.add(n.JY().je(mVar.oij) + "=" + mVar.oii + "=" + mVar.ohW);
            }
        }
        com.tencent.mm.sdk.b.a.xmy.a(tlVar, Looper.getMainLooper());
    }
}
