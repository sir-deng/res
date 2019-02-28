package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Intent;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.plugin.wallet.balance.a.a.o.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public final class p implements com.tencent.mm.vending.c.b<o> {
    protected o sFc;
    public final c sFd;
    public final a sFe;
    public final b sFf;
    public final d sFg;

    public class b implements e<y, Integer> {
        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            o oVar = p.this.sFc;
            int intValue = num.intValue();
            oVar.iiC = g.cAI();
            oVar.iiC.cAH();
            oVar.sEU.b(new y(null, intValue == 1 ? 24 : 25), true);
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class c implements e<bap, com.tencent.mm.vending.j.d<Integer, Integer, Bankcard>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            o oVar = p.this.sFc;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            Bankcard bankcard = (Bankcard) dVar.get(2);
            String str = "MicroMsg.LqtSaveFetchLogic";
            String str2 = "saveLqt, accountType: %s, bankcard: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(intValue2);
            objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
            x.i(str, str2, objArr);
            x.d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", Integer.valueOf(intValue));
            String stringExtra = oVar.sEU.getIntent().getStringExtra("lqt_save_fund_code");
            oVar.sEW = intValue;
            oVar.accountType = intValue2;
            oVar.sEU.agP();
            g.a(g.a(stringExtra, Integer.valueOf(intValue), Integer.valueOf(intValue2)).b(oVar.sET.sEL).b(new com.tencent.mm.vending.c.a<baa, baa>() {
                public final /* synthetic */ Object call(Object obj) {
                    baa baa = (baa) obj;
                    o.this.sEV = baa.vKd;
                    o.this.sEU.bKl();
                    x.i("MicroMsg.LqtSaveFetchLogic", "get tradeNo: %s", o.this.sEV);
                    return baa;
                }
            }).b(new AnonymousClass3(bankcard)).a(new com.tencent.mm.vending.g.d.a() {
                public final void aW(Object obj) {
                    x.i("MicroMsg.LqtSaveFetchLogic", "onInterrupt %s", obj);
                    o.this.sEU.bKl();
                    g.cAI().cm(obj);
                }
            }));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class a implements e<bcs, com.tencent.mm.vending.j.d<Integer, Integer, fb>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            o oVar = p.this.sFc;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            fb fbVar = (fb) dVar.get(2);
            x.i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s", Integer.valueOf(intValue2));
            x.d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            oVar.sEX = intValue;
            oVar.accountType = intValue2;
            oVar.sEU.agP();
            g.a(g.a(Integer.valueOf(intValue), fbVar, Integer.valueOf(intValue2)).b(oVar.sET.sEO).b(new com.tencent.mm.vending.c.a<Void, ayv>() {
                public final /* synthetic */ Object call(Object obj) {
                    x.i("MicroMsg.LqtSaveFetchLogic", "pre redeem finish: %s", (ayv) obj);
                    o.this.sEU.bKl();
                    o.this.iiC = g.cAI();
                    o.this.iiC.cAH();
                    o.this.sEY = r9.wMs;
                    Intent intent = new Intent(o.this.sEU, WalletLqtCheckPwdInputDialogUI.class);
                    intent.putExtra("lqt_fetch_pwd_title", o.this.sEU.getString(i.uZh));
                    intent.putExtra("lqt_fetch_pwd_money", (((double) o.this.sEX) / 100.0d));
                    o.this.sEU.startActivityForResult(intent, o.sER);
                    return zLb;
                }
            }));
            return null;
        }

        public final String wE() {
            return "Vending.UI";
        }
    }

    public class d implements e<Void, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            o oVar = p.this.sFc;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            x.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            oVar.iiC = g.cAI();
            oVar.iiC.cAH();
            if (intValue == 1) {
                new b(0).Kb().i(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<aul>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        return c((a) obj);
                    }

                    private Void c(a<aul> aVar) {
                        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            i.sEu.a(((aul) aVar.fKE).wJd, true);
                        }
                        if (o.this.iiC != null) {
                            o.this.iiC.resume();
                        }
                        return zLb;
                    }
                });
            } else {
                new c(0).Kb().i(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<aun>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        return c((a) obj);
                    }

                    private Void c(a<aun> aVar) {
                        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            l.bJX().a((aun) aVar.fKE);
                            i.sEu.a(((aun) aVar.fKE).wJd, false);
                        }
                        if (o.this.iiC != null) {
                            o.this.iiC.resume();
                        }
                        return zLb;
                    }
                });
            }
            return zLb;
        }

        public final String wE() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<Void> ea(int i, int i2) {
            return g.t(Integer.valueOf(i), Integer.valueOf(i2)).b(this);
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.sFc;
    }

    public p() {
        this(new o());
    }

    public p(o oVar) {
        this.sFd = new c();
        this.sFe = new a();
        this.sFf = new b();
        this.sFg = new d();
        this.sFc = oVar;
    }
}
