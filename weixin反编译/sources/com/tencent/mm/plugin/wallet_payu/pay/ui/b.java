package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class b extends n {
    private b tjC;
    private int tjD = 0;
    private boolean tjE = false;
    private a tjF;

    public interface b {
        void a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.b$1 */
    static class AnonymousClass1 extends b {
        final /* synthetic */ a tjG;

        AnonymousClass1(Context context, int i, a aVar) {
            this.tjG = aVar;
            super(context);
        }

        public final int bNC() {
            int i = 3;
            if (this.tjG.tjI != null && this.tjG.tjI.field_bankcardClientType == 1) {
                x.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.tjG.tjI).sXb;
            }
            if (i != 4) {
                return g.uJN;
            }
            x.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
            return g.uJM;
        }
    }

    private class a {
        public com.tencent.mm.plugin.wallet_core.ui.n.a tcl;
        public String tjH;
        public Bankcard tjI;
        public FavorPayInfo tjJ;
        public boolean tjK;
        public b tjL;
        public OnCancelListener tjM;

        public a(String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, com.tencent.mm.plugin.wallet_core.ui.n.a aVar, b bVar) {
            this.tjH = str;
            this.tjI = bankcard;
            this.tjJ = favorPayInfo;
            this.tjK = z;
            this.tjM = onCancelListener;
            this.tcl = aVar;
            this.tjL = bVar;
        }
    }

    public b(Context context) {
        super(context);
    }

    protected final void ce(Context context) {
        dK(context);
        super.dL(context);
        if (this.tbT != null) {
            this.tbT.setVisibility(8);
        }
    }

    protected final void dL(Context context) {
        super.dL(context);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        List bNa;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        boolean z2;
        com.tencent.mm.plugin.wallet_core.ui.a a = com.tencent.mm.plugin.wallet_core.ui.b.sXj.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.sTe))) {
                    String aM = a.aM(favorPayInfo.sTc, false);
                    com.tencent.mm.plugin.wallet_core.ui.a.a aVar = (com.tencent.mm.plugin.wallet_core.ui.a.a) a.aL(aM, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.sXg == null || bi.oN(aVar.sXg.sJI)) {
                        favorPayInfo.sTc = aM;
                    } else {
                        favorPayInfo.sTc = aVar.sXg.sJI;
                    }
                }
            } else if (orders.sUg != null) {
                favorPayInfo = a.NQ(a.NR(orders.sUg.sJu));
            }
            bNa = a.bNa();
        } else {
            x.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            bNa = null;
        }
        Commodity commodity = (Commodity) orders.sUf.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (bi.oN(commodity.pfU)) {
            str = "";
        } else {
            str = commodity.pfU + "\n";
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.sUf.get(0)).desc).toString();
        double d = orders.pTQ;
        if (a == null || favorPayInfo == null) {
            str2 = null;
            str3 = null;
            charSequence = null;
            z2 = false;
        } else {
            h NN = a.NN(favorPayInfo.sTc);
            if (NN != null && NN.sJJ > 0.0d) {
                double d2 = NN.sJt;
                String d3 = e.d(orders.pTQ, orders.pgf);
                String d4 = e.d(NN.sJt, orders.pgf);
                String string = context.getString(i.vbq, new Object[]{e.t(NN.sJJ)});
                str3 = d4;
                str2 = d3;
                charSequence = string;
                z2 = true;
                d = d2;
            } else if (bNa == null || bNa.size() <= 0) {
                charSequence = null;
                str2 = null;
                str3 = e.d(orders.pTQ, orders.pgf);
                z2 = false;
            } else {
                z2 = true;
                str2 = null;
                str3 = null;
                Object charSequence2 = context.getString(i.vbU);
            }
        }
        if (bankcard == null) {
            str = "";
        } else {
            str = bankcard.field_desc;
        }
        Dialog bVar2 = new b(context);
        bVar2.tbS = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.bND();
        bVar2.a(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.NU(stringBuilder2);
        bVar2.c(str3, d);
        bVar2.NW(str2);
        bVar2.a(str, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence2)) {
            bVar2.tbD.setVisibility(8);
        } else {
            bVar2.tbD.setVisibility(0);
            bVar2.tbD.setText(charSequence2);
        }
        bVar2.tjE = z;
        bVar2.tbE.zSL = -10;
        bVar2.tjC = bVar;
        bVar2.show();
        com.tencent.mm.ui.base.h.a(context, bVar2);
        return bVar2;
    }

    protected final void bNy() {
        if (this.tbP != null) {
            this.tbP.onClick(this, 0);
        }
        dismiss();
        if (this.tjC == null) {
            return;
        }
        if (!this.tjE) {
            this.tjC.a(this.tbE.getText(), "", this.sKV);
        } else if (this.tjD == 0) {
            Context context = getContext();
            a aVar = new a(this.tbE.getText(), this.tbS, this.sKV, this.tbQ, this.Gj, this.tcl, this.tjC);
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                Dialog anonymousClass1 = new AnonymousClass1(context, j.vfj, aVar);
                anonymousClass1.tjD = 1;
                anonymousClass1.tjE = true;
                anonymousClass1.tjF = aVar;
                if (anonymousClass1.tjF != null) {
                    anonymousClass1.bND();
                    anonymousClass1.a(anonymousClass1.tjF.tjM);
                    anonymousClass1.setOnCancelListener(anonymousClass1.tjF.tjM);
                    anonymousClass1.setCancelable(true);
                    anonymousClass1.c(anonymousClass1.tjF.tjI == null ? "" : anonymousClass1.tjF.tjI.field_desc, 0.0d);
                    anonymousClass1.jW(false);
                    anonymousClass1.tcl = anonymousClass1.tjF.tcl;
                    anonymousClass1.tjC = anonymousClass1.tjF.tjL;
                    anonymousClass1.tbE.zSL = 30;
                    anonymousClass1.show();
                    com.tencent.mm.ui.base.h.a(context, anonymousClass1);
                }
            }
        } else if (this.tjD == 1) {
            this.tjC.a(this.tjF.tjH, this.tbE.getText(), this.tjF.tjJ);
        } else {
            x.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        }
    }
}
