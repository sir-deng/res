package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.j.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.j.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.a.a.j.AnonymousClass4;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k implements com.tencent.mm.vending.c.b<j> {
    protected j sEB;
    public final b sEC;
    public final a sED;
    public final d sEE;
    public final c sEF;

    public class b implements e<bar, Void> {
        public final /* synthetic */ Object call(Object obj) {
            j jVar = k.this.sEB;
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            if (!ao.isNetworkConnected(ad.getContext())) {
                cAI.cm(Boolean.valueOf(false));
            }
            new g().Kb().g(new AnonymousClass1(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class c implements e<aul, Integer> {
        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            j jVar = k.this.sEB;
            x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", Integer.valueOf(num.intValue()));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new b(r1).Kb().i(new AnonymousClass4(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class d implements e<aun, Integer> {
        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            j jVar = k.this.sEB;
            x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem, accountType: %s", Integer.valueOf(num.intValue()));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new c(r1).Kb().i(new AnonymousClass3(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class a implements e<or, com.tencent.mm.vending.j.c<String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            j jVar = k.this.sEB;
            String str = (String) cVar.get(0);
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            x.i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", Integer.valueOf(intValue));
            new a(str, intValue).Kb().g(new AnonymousClass2(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.sEB;
    }

    public k() {
        this(new j());
    }

    private k(j jVar) {
        this.sEC = new b();
        this.sED = new a();
        this.sEE = new d();
        this.sEF = new c();
        this.sEB = jVar;
    }
}
