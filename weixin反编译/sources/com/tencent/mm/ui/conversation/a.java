package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.jg;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.i;
import com.tencent.mm.ui.conversation.a.o;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ac.d.a, b, ao {
    Context context;
    n qaE;
    List<com.tencent.mm.pluginsdk.ui.b.b> zeN = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zeO = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zeP = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zeQ = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zeR = new LinkedList();
    c zeS;
    c zeT;
    ListView zeU;
    View zeV;

    public final void a(Context context, ListView listView, View view) {
        this.context = context;
        this.zeU = listView;
        this.zeV = view;
        this.zeT = new c<ae>() {
            {
                this.xmG = ae.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ae aeVar = (ae) bVar;
                com.tencent.mm.pluginsdk.ui.b.b bVar2 = aeVar.foO.foQ;
                if (bVar2 != null && bVar2.getView() != null) {
                    x.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", bVar2, Integer.valueOf(a.this.hashCode()));
                    if (!aeVar.foO.foP) {
                        switch (aeVar.foO.level) {
                            case 1:
                                a.this.zeO.add(bVar2);
                                break;
                            case 2:
                                a.this.zeP.add(bVar2);
                                break;
                            default:
                                a.this.zeQ.add(bVar2);
                                break;
                        }
                    }
                    a.this.zeN.add(bVar2);
                } else {
                    x.w("MicroMsg.BannerHelper", "banner is null, event:%s", aeVar);
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xmy.b(this.zeT);
        com.tencent.mm.sdk.b.b adVar = new ad();
        adVar.foN.activity = (Activity) context;
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        adVar = new ae();
        adVar.foO.foQ = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zjJ, null);
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        com.tencent.mm.pluginsdk.ui.b.b bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zjD, null);
        adVar = new ae();
        adVar.foO.foQ = bVar;
        adVar.foO.foP = false;
        adVar.foO.level = 1;
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        o oVar = (o) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zjI, null);
        adVar = new ae();
        adVar.foO.foQ = oVar;
        adVar.foO.foP = false;
        adVar.foO.level = 2;
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        com.tencent.mm.ui.conversation.a.a aVar = (com.tencent.mm.ui.conversation.a.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zjF, null);
        adVar = new ae();
        adVar.foO.foQ = aVar;
        adVar.foO.foP = false;
        adVar.foO.level = 3;
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        com.tencent.mm.ui.d.a aVar2 = (com.tencent.mm.ui.d.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zjK, new Object[]{com.tencent.mm.y.b.b.b.Main});
        adVar = new ae();
        adVar.foO.foQ = aVar2;
        adVar.foO.foP = true;
        com.tencent.mm.sdk.b.a.xmy.m(adVar);
        com.tencent.mm.sdk.b.a.xmy.c(this.zeT);
        List linkedList = new LinkedList();
        linkedList.addAll(this.zeN);
        linkedList.addAll(this.zeO);
        linkedList.addAll(this.zeP);
        linkedList.addAll(this.zeQ);
        Collections.sort(linkedList, new Comparator<com.tencent.mm.pluginsdk.ui.b.b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((com.tencent.mm.pluginsdk.ui.b.b) obj2).getOrder() - ((com.tencent.mm.pluginsdk.ui.b.b) obj).getOrder();
            }
        });
        dB(linkedList);
        LinkedList linkedList2 = new LinkedList();
        bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(context, com.tencent.mm.ui.conversation.a.e.a.zjE, null);
        if (!(bVar == null || bVar.getView() == null)) {
            listView.addFooterView(bVar.getView());
        }
        this.zeR.add(bVar);
        listView.addFooterView(new i(context).getView(), null, true);
        this.zeR.add(bVar);
        this.qaE = new com.tencent.mm.network.n.a() {
            private final al zeX = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    a.this.cxg();
                    return false;
                }
            }, false);

            public final void eq(int i) {
                if (this.zeX != null) {
                    this.zeX.K(10, 10);
                }
            }
        };
        as.a(this.qaE);
        this.zeS = new c<jg>() {
            {
                this.xmG = jg.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (a.this.zeU.getVisibility() != 0) {
                    a.this.zeU.setVisibility(0);
                    a.this.zeV.setVisibility(8);
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xmy.b(this.zeS);
        as.Hm();
        com.tencent.mm.y.c.a(this);
        cxg();
    }

    public final void cxg() {
        boolean z = true;
        if (this.context != null && as.Hp()) {
            x.i("MicroMsg.BannerHelper", "updateBanner, :%d", Integer.valueOf(hashCode()));
            boolean l = l(this.zeN, true);
            boolean l2 = l(this.zeO, true);
            boolean l3 = l(this.zeP, true);
            boolean l4 = l(this.zeQ, true);
            if (!(l || l2 || l3 || l4)) {
                z = false;
            }
            if (l2) {
                dD(this.zeP);
                dD(this.zeQ);
            } else if (l3) {
                dD(this.zeQ);
            }
            if (z && this.zeU.getVisibility() != 0) {
                this.zeU.setVisibility(0);
                this.zeV.setVisibility(8);
            }
            for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.zeR) {
                if (bVar != null) {
                    bVar.alN();
                }
            }
        }
    }

    public final void jk(String str) {
        if (as.Hp() && !as.Cz() && t.oM(str).length() > 0 && str.equals(q.FY())) {
            cxg();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (as.Hp()) {
            as.Hm();
            if (mVar == com.tencent.mm.y.c.Db()) {
                int aV = t.aV(obj);
                if (8193 == aV) {
                    cxg();
                }
                if (42 == aV) {
                    cxg();
                }
            }
        }
    }

    public final void Hd() {
        cxg();
    }

    private void dB(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b view : list) {
            this.zeU.addHeaderView(view.getView());
        }
    }

    final void dC(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.zeU.removeHeaderView(bVar.getView());
            }
        }
    }

    final boolean l(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        boolean z2 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            boolean z3;
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.alN()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                x.i(str, str2, objArr);
                if (!z) {
                    return true;
                }
                z3 = true;
            } else {
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", bVar, Boolean.valueOf(z), Integer.valueOf(hashCode()));
                }
                z3 = z2;
            }
            z2 = z3;
        }
        return z2;
    }

    private static void dD(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b visibility : list) {
            visibility.setVisibility(8);
        }
    }

    static void dE(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b release : list) {
            release.release();
        }
    }

    static void dF(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b destroy : list) {
            destroy.destroy();
        }
        list.clear();
    }
}
