package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.q;
import java.util.ArrayList;

@a(3)
public class WalletBalanceSaveUI extends WalletBaseUI {
    private final int ild = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 270);
    private View kTo;
    protected Button lXK;
    protected WalletFormView lrK;
    public double pRD;
    private ArrayList<Bankcard> sFo;
    protected Bankcard sFp;
    private String sFq;
    public WalletFormView sFs;

    static /* synthetic */ void d(WalletBalanceSaveUI walletBalanceSaveUI) {
        if (walletBalanceSaveUI.kTo != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceSaveUI.lXK.getLocationInWindow(iArr);
            int eC = (com.tencent.mm.bu.a.eC(walletBalanceSaveUI) - i) - com.tencent.mm.bu.a.fromDPToPix(walletBalanceSaveUI, 30);
            x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + walletBalanceSaveUI.lXK.getHeight()), Integer.valueOf(com.tencent.mm.bu.a.eC(walletBalanceSaveUI)), Integer.valueOf(eC), Integer.valueOf(walletBalanceSaveUI.ild));
            if (eC > 0 && eC < walletBalanceSaveUI.ild) {
                i = walletBalanceSaveUI.ild - eC;
                x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                walletBalanceSaveUI.kTo.post(new Runnable() {
                    public final void run() {
                        WalletBalanceSaveUI.this.kTo.scrollBy(0, i);
                    }
                });
            }
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                String str2;
                boolean a;
                c cVar = (c) kVar;
                if ("1".equals(cVar.fLK)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str3 = cVar.fLL;
                    str3 = cVar.fLM;
                    str2 = cVar.fLN;
                    aYL();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(cVar.fLK)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, cVar.fLL, cVar.fLO, cVar.fLM, cVar.fLN, aYL(), null);
                } else {
                    x.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + cVar.fLK);
                    a = false;
                }
                if (!a) {
                    String str4 = ((c) kVar).fxT;
                    t.j(11, str4, i2);
                    if (com.tencent.mm.plugin.wallet.b.a.bLr()) {
                        str2 = this.sFp == null ? "" : this.sFp.field_bindSerial;
                        String str5 = "";
                        double d = this.pRD;
                        if (!bi.oN(str4)) {
                            PayInfo a2 = h.a(str4, str5, null, null, 11, 0);
                            a2.vGs = d;
                            h.a((Context) this, true, str2, a2, 1);
                        }
                    } else {
                        h.a((Context) this, this.sFp == null ? "" : this.sFp.field_bindSerial, str4, "", 11, 1);
                    }
                }
            } else if (kVar instanceof y) {
                boc();
                av();
            }
        } else if (kVar instanceof c) {
            t.j(11, "", i2);
        }
        return false;
    }

    private void boc() {
        int i;
        p.bKx();
        ag bKy = p.bKy();
        this.sFo = bKy.bML();
        this.sFp = bKy.a(this.sFo, null, false, true);
        if (this.sFp != null && bi.oN(this.sFp.field_forbidWord)) {
            this.sFp = null;
            i = 0;
            while (i < this.sFo.size()) {
                if (this.sFo.get(i) != null && bi.oN(((Bankcard) this.sFo.get(i)).field_forbidWord)) {
                    this.sFp = (Bankcard) this.sFo.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.sFp == null || bi.oN(this.sFp.field_forbidWord))) {
            this.sFp = null;
        }
        ArrayList arrayList = this.sFo;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                x.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord);
            }
        }
    }

    protected final int getLayoutId() {
        return g.uKV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.Gl()) {
            if (com.tencent.mm.plugin.wallet.b.a.bLr()) {
                b(new ab(), false);
            } else {
                b(new y(null, 3), false);
            }
        }
        boc();
        this.sFq = getString(i.uWb);
        initView();
        av();
        com.tencent.mm.wallet_core.c.p.fw(3, 0);
    }

    protected final void initView() {
        setMMTitle(i.uWe);
        this.kTo = findViewById(f.uCN);
        this.lrK = (WalletFormView) findViewById(f.uye);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.lrK);
        this.lrK.jOY.setText(u.cCu());
        e(this.lrK, 2, false);
        this.lXK = (Button) findViewById(f.cAl);
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBalanceSaveUI.this.pRD = bi.getDouble(WalletBalanceSaveUI.this.lrK.getText(), 0.0d);
                if (WalletBalanceSaveUI.this.pRD <= 0.0d || !WalletBalanceSaveUI.this.lrK.XX()) {
                    com.tencent.mm.ui.base.u.makeText(WalletBalanceSaveUI.this.mController.xRr, i.uWd, 0).show();
                } else {
                    WalletBalanceSaveUI.this.bKi();
                }
            }
        });
        this.sFs = (WalletFormView) findViewById(f.ulk);
        if (this.sFs != null) {
            com.tencent.mm.wallet_core.ui.formview.a.g(this.sFs);
            this.sFs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Context context = WalletBalanceSaveUI.this.mController.xRr;
                    com.tencent.mm.plugin.wallet_core.ui.h.a(context, WalletBalanceSaveUI.this.sFo, WalletBalanceSaveUI.this.sFq, context.getString(i.uWf), WalletBalanceSaveUI.this.sFp, new com.tencent.mm.ui.base.h.a() {
                        public final void vE(int i) {
                            if (WalletBalanceSaveUI.this.sFo == null || i < 0 || i >= WalletBalanceSaveUI.this.sFo.size()) {
                                WalletBalanceSaveUI.this.sFp = null;
                            } else {
                                WalletBalanceSaveUI.this.sFp = (Bankcard) WalletBalanceSaveUI.this.sFo.get(i);
                            }
                            if (!(WalletBalanceSaveUI.this.sFp == null || bi.oN(WalletBalanceSaveUI.this.sFp.field_forbidWord))) {
                                com.tencent.mm.ui.base.h.a(WalletBalanceSaveUI.this.mController.xRr, WalletBalanceSaveUI.this.getString(i.uWc), "", WalletBalanceSaveUI.this.getString(i.dGf), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                WalletBalanceSaveUI.this.sFp = null;
                            }
                            WalletBalanceSaveUI.this.av();
                        }
                    });
                }
            });
        }
        this.olj = new com.tencent.mm.wallet_core.ui.a() {
            public final void hE(boolean z) {
                if (z) {
                    WalletBalanceSaveUI.d(WalletBalanceSaveUI.this);
                } else {
                    WalletBalanceSaveUI.this.kTo.scrollTo(0, 0);
                }
            }
        };
    }

    private void av() {
        if (this.sFs == null) {
            return;
        }
        if (this.sFp != null) {
            this.sFs.setText(getString(i.uVZ, new Object[]{this.sFp.field_bankName, this.sFp.field_bankcardTail}));
            this.sFs.yb(this.sFp.field_bankcardTypeName);
            String str = this.sFp.field_avail_save_wording;
            if (this.sFs.pJS == null) {
                x.e("MicroMsg.WalletBalanceSaveUI", "why layout is null !!!???");
                return;
            } else if (bi.oN(str)) {
                x.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                this.sFs.pJS.setText("");
                return;
            } else {
                this.sFs.pJS.setText(this.sFp.field_avail_save_wording);
                return;
            }
        }
        this.sFs.setText(this.sFq);
        if (this.sFs.pJS != null) {
            this.sFs.pJS.setText("");
        }
        this.sFs.yb(getString(i.uVY));
    }

    public void bKi() {
        if (this.sFp != null) {
            l(new c(this.pRD, "CNY", this.sFp.field_bindSerial, this.sFp.field_bankcardType));
            return;
        }
        com.tencent.mm.plugin.wallet_core.model.g bLJ = com.tencent.mm.plugin.wallet_core.model.g.bLJ();
        if (bLJ.aHO()) {
            com.tencent.mm.ui.base.h.b(this, bLJ.pfh, getString(i.dGZ), true);
        } else {
            l(new c(this.pRD, "CNY", "", ""));
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
