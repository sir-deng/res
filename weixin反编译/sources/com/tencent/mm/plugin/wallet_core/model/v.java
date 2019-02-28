package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.f.a.sw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

public final class v extends c<sw> implements e {
    private boolean fLB;
    private boolean mEN;
    private sw sVE;

    public v() {
        this.mEN = false;
        this.fLB = false;
        this.xmG = sw.class.getName().hashCode();
    }

    private boolean a(sw swVar) {
        if (swVar instanceof sw) {
            this.mEN = false;
            this.sVE = swVar;
            this.fLB = swVar.fLz.fLB;
            g.Dr();
            g.Dp().gRu.a(385, (e) this);
            g.Dr();
            g.Dp().gRu.a(1518, (e) this);
            ag bMc;
            if (o.bMc().bMx()) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (q.Gl()) {
                    g.Dr();
                    g.Dp().gRu.a(new a(), 0);
                } else {
                    g.Dr();
                    g.Dp().gRu.a(new y(null, zA(swVar.fLz.scene) ? swVar.fLz.scene : 0), 0);
                }
            } else if (swVar.fLz.fLB) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
                bMc = o.bMc();
                x.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", Long.valueOf(bi.Wx()), Long.valueOf(bMc.sWq));
                Object obj = (bMc.sWq <= 0 || bi.Wx() > bMc.sWq) ? 1 : null;
                if (obj == null) {
                    this.mEN = true;
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                    a(0, "", null);
                    if (q.Gl()) {
                        g.Dr();
                        g.Dp().gRu.a(new a(), 0);
                    } else {
                        g.Dr();
                        g.Dp().gRu.a(new y(null, zA(swVar.fLz.scene) ? swVar.fLz.scene : 0), 0);
                    }
                } else {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                    if (q.Gl()) {
                        g.Dr();
                        g.Dp().gRu.a(new a(), 0);
                    } else {
                        g.Dr();
                        g.Dp().gRu.a(new y(null, zA(swVar.fLz.scene) ? swVar.fLz.scene : 0), 0);
                    }
                }
            } else {
                long bz = bi.bz(o.bMc().sWp);
                x.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + bz, Long.valueOf(bMc.sWp), Long.valueOf(System.currentTimeMillis() / 1000));
                if ((bz > 0 ? 1 : null) != null) {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (q.Gl()) {
                        g.Dr();
                        g.Dp().gRu.a(new a(), 0);
                    } else {
                        g.Dr();
                        g.Dp().gRu.a(new y(null, zA(swVar.fLz.scene) ? swVar.fLz.scene : 0), 0);
                    }
                } else {
                    this.mEN = true;
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    a(0, "", null);
                }
            }
            return true;
        }
        x.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof y) || (kVar instanceof a)) {
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            g.Dr();
            g.Dp().gRu.b(1518, (e) this);
            if (this.fLB && this.mEN) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
                return;
            }
            this.mEN = true;
            a(i2, str, kVar);
        }
    }

    private void a(int i, String str, k kVar) {
        boolean z = false;
        if (this.sVE != null) {
            int i2;
            String str2;
            this.sVE.fLA.errCode = i;
            this.sVE.fLA.foE = str;
            this.sVE.fLA.fLC = o.bMc().bMy();
            b bVar = this.sVE.fLA;
            ag bMc = o.bMc();
            boolean z2 = (bMc.sWk != null && bMc.sWk.bMp()) || (bMc.sIx != null && bMc.sIx.size() > 0);
            z2 = z2 ? false : bMc.sIw == null || bMc.sIw.size() <= 0;
            bVar.fLD = z2;
            bVar = this.sVE.fLA;
            ag bMc2 = o.bMc();
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            bMc2.d(arrayList, arrayList2);
            if (ag.cg(arrayList2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.fLE = z2;
            this.sVE.fLA.fLF = o.bMc().bMC().bMp();
            this.sVE.fLA.fLG = o.bMc().bMB();
            this.sVE.fLA.fLH = o.bMc().azW();
            this.sVE.fLA.fLI = o.bMc().bMz();
            this.sVE.fLA.fLJ = o.bMc().bMC().bMs();
            this.sVE.fLA.fLK = "";
            bVar = this.sVE.fLA;
            bMc2 = o.bMc();
            if (bMc2.sWi == null) {
                z2 = false;
            } else if (bMc2.sWi.field_paymenu_use_new == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.fLY = z2;
            if (kVar != null && (kVar instanceof y)) {
                this.sVE.fLA.fLK = ((y) kVar).fLK;
                this.sVE.fLA.fLL = ((y) kVar).fLL;
                this.sVE.fLA.fLM = ((y) kVar).fLM;
                this.sVE.fLA.fLN = ((y) kVar).fLN;
                this.sVE.fLA.fLO = ((y) kVar).fLO;
                this.sVE.fLA.scene = ((y) kVar).scene;
                this.sVE.fLA.fLP = ((y) kVar).fLP;
                this.sVE.fLA.fLQ = ((y) kVar).fLQ;
                this.sVE.fLA.fLR = ((y) kVar).fLR;
                this.sVE.fLA.fLS = ((y) kVar).fLS;
                this.sVE.fLA.fLT = ((y) kVar).fLT;
                this.sVE.fLA.fLU = ((y) kVar).fLU;
                this.sVE.fLA.fLV = ((y) kVar).fLV;
                this.sVE.fLA.title = ((y) kVar).title;
                this.sVE.fLA.fLW = ((y) kVar).fLW;
                this.sVE.fLA.fLX = ((y) kVar).fLX;
            }
            this.sVE.fLA.fLZ = o.bMc().bMI() ? 1 : 0;
            bVar = this.sVE.fLA;
            bMc2 = o.bMc();
            if (bMc2.sWi != null) {
                i2 = bMc2.sWi.field_is_show_lqb;
            } else {
                i2 = 0;
            }
            bVar.fMa = i2;
            b bVar2 = this.sVE.fLA;
            ag bMc3 = o.bMc();
            if (bMc3.sWi != null && bMc3.sWi.field_is_open_lqb == 1) {
                z = true;
            }
            bVar2.fMb = z;
            b bVar3 = this.sVE.fLA;
            bMc2 = o.bMc();
            if (bMc2.sWi != null) {
                str2 = bMc2.sWi.field_lqb_open_url;
            } else {
                str2 = null;
            }
            bVar3.fMc = str2;
            x.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.sVE.fLA.fLD + " hasNewTips : " + this.sVE.fLA.fLE + " swipeOn : " + this.sVE.fLA.fLF);
            if (this.sVE.frD != null) {
                this.sVE.frD.run();
            }
            if (this.sVE.fLA.fLu != null) {
                this.sVE.fLA.fLu.run();
            }
        }
        if (this.mEN) {
            this.sVE = null;
        }
    }

    private static boolean zA(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }
}
