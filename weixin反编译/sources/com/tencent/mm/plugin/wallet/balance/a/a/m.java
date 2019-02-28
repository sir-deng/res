package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class m extends a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.m$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<bap>> {
        final /* synthetic */ b iJz;

        AnonymousClass2(b bVar) {
            this.iJz = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bap bap = (bap) aVar.fKE;
                x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s, purchase_state: %s", Integer.valueOf(bap.kRz), bap.kRA, Integer.valueOf(bap.wOa));
                if (bap.kRz == 0) {
                    this.iJz.t(bap);
                    g.pWK.a(663, 6, 1, false);
                } else {
                    this.iJz.cm(bap.kRA);
                    g.pWK.a(663, 7, 1, false);
                }
            } else {
                this.iJz.cm(Boolean.valueOf(false));
                g.pWK.a(663, 8, 1, false);
            }
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.m$4 */
    class AnonymousClass4 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<ayv>> {
        final /* synthetic */ b iJz;

        AnonymousClass4(b bVar) {
            this.iJz = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ayv ayv = (ayv) aVar.fKE;
                x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s, redeem_listid: %s", Integer.valueOf(ayv.kRz), ayv.kRA, ayv.wMs);
                if (ayv.kRz == 0) {
                    this.iJz.t(ayv);
                    g.pWK.a(663, 9, 1, false);
                } else {
                    this.iJz.cm(ayv.kRA);
                    g.pWK.a(663, 10, 1, false);
                }
            } else {
                this.iJz.cm(Boolean.valueOf(false));
                g.pWK.a(663, 11, 1, false);
            }
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.m$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<baa>> {
        final /* synthetic */ b iJz;

        AnonymousClass1(b bVar) {
            this.iJz = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                baa baa = (baa) aVar.fKE;
                x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s, prepayid: %s, out_trade_no: %s", Integer.valueOf(baa.kRz), baa.kRA, baa.wNy, baa.vKd);
                if (baa.kRz == 0) {
                    this.iJz.t(aVar.fKE);
                    g.pWK.a(663, 3, 1, false);
                } else {
                    this.iJz.cm(baa.kRA);
                    g.pWK.a(664, 4, 1, false);
                }
            } else {
                this.iJz.cm(Boolean.valueOf(false));
                g.pWK.a(664, 5, 1, false);
            }
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.m$3 */
    class AnonymousClass3 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<bcs>> {
        final /* synthetic */ b iJz;

        AnonymousClass3(b bVar) {
            this.iJz = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bcs bcs = (bcs) aVar.fKE;
                x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", Integer.valueOf(bcs.kRz), bcs.kRA);
                if (bcs.kRz == 0) {
                    this.iJz.t(bcs);
                    g.pWK.a(663, 12, 1, false);
                } else {
                    this.iJz.cm(bcs.kRA);
                    g.pWK.a(663, 13, 1, false);
                }
            } else {
                this.iJz.cm(Boolean.valueOf(false));
                g.pWK.a(663, 14, 1, false);
            }
            return zLb;
        }
    }

    protected final void onCreate() {
        super.onCreate();
    }
}
