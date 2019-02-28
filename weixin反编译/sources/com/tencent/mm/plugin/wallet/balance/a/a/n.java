package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.m.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.m.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.m.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.a.a.m.AnonymousClass4;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class n implements com.tencent.mm.vending.c.b<m> {
    protected m sEK;
    public final d sEL;
    public final b sEM;
    public final c sEN;
    public final a sEO;

    public class a implements e<ayv, com.tencent.mm.vending.j.d<Integer, fb, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            m mVar = n.this.sEK;
            int intValue = ((Integer) dVar.get(0)).intValue();
            fb fbVar = (fb) dVar.get(1);
            x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", Integer.valueOf(((Integer) dVar.get(2)).intValue()));
            x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new d(intValue, fbVar, r1).Kb().i(new AnonymousClass4(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class c implements e<bcs, com.tencent.mm.vending.j.e<Integer, String, String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            m mVar = n.this.sEK;
            int intValue = ((Integer) eVar.get(0)).intValue();
            String str = (String) eVar.get(1);
            x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemListId: %s, accountType: %s", (String) eVar.get(2), Integer.valueOf(((Integer) eVar.get(3)).intValue()));
            x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemFee: %s, payPasswdEnc: %s, redeemListId: %s", Integer.valueOf(intValue), str, r1);
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new h(intValue, str, r1, r2).Kb().i(new AnonymousClass3(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class b implements e<bap, com.tencent.mm.vending.j.e<String, String, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            m mVar = n.this.sEK;
            String str = (String) eVar.get(0);
            String str2 = (String) eVar.get(1);
            int intValue = ((Integer) eVar.get(2)).intValue();
            x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, accountType: %s", str, str2, Integer.valueOf(((Integer) eVar.get(3)).intValue()));
            x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, purchaseFee: %s", str, str2, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new f(str, str2, intValue, r2).Kb().i(new AnonymousClass2(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class d implements e<baa, com.tencent.mm.vending.j.d<String, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            m mVar = n.this.sEK;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s", str, Integer.valueOf(((Integer) dVar.get(2)).intValue()));
            x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", str, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            new e(str, intValue, r1).Kb().i(new AnonymousClass1(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.sEK;
    }

    public n() {
        this(new m());
    }

    private n(m mVar) {
        this.sEL = new d();
        this.sEM = new b();
        this.sEN = new c();
        this.sEO = new a();
        this.sEK = mVar;
    }
}
