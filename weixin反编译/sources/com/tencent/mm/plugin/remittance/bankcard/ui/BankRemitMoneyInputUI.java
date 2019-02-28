package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private String gCB;
    private final int ild = a.fromDPToPix(ad.getContext(), 270);
    private Button lXK;
    private CdnImageView pNq;
    private TextView pNs;
    private TextView pOL;
    private ScrollView pOM;
    private WalletFormView pON;
    private LinearLayout pOO;
    private TextView pOP;
    private TextView pOQ;
    private TextView pOR;
    private TextView pOS;
    private BankcardElemParcel pOT;
    private String pOU;
    private String pOV;
    private String pOW;
    private String pOX;
    private String pOY;
    private int pOZ;
    private String pOx;
    private int pPa;
    private l pPb;
    private long pPc;
    private int pPd;
    private int pPe;

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str) {
        double d = bi.getDouble(str, 0.0d);
        long round = Math.round(bi.getDouble(str, 0.0d) * 100.0d);
        if (bankRemitMoneyInputUI.pOT.pNa >= 0 && round > 0) {
            bankRemitMoneyInputUI.pPc = com.tencent.mm.plugin.remittance.bankcard.model.a.dT(String.valueOf(com.tencent.mm.plugin.remittance.bankcard.model.a.dV(String.valueOf(round), bankRemitMoneyInputUI.pOT.pNa)), "10000");
            x.d("MicroMsg.BankRemitMoneyInputUI", "moneyYuan: %s, money: %s, a: %s, fee: %s", Double.valueOf(d), Long.valueOf(round), Double.valueOf(r4), Long.valueOf(bankRemitMoneyInputUI.pPc));
            if (bankRemitMoneyInputUI.pPc < ((long) bankRemitMoneyInputUI.pPd) && bankRemitMoneyInputUI.pOT.pNa > 0) {
                bankRemitMoneyInputUI.pPc = (long) bankRemitMoneyInputUI.pPd;
            }
            double dU = com.tencent.mm.plugin.remittance.bankcard.model.a.dU(bankRemitMoneyInputUI.pPc, "100");
            d += dU;
            bankRemitMoneyInputUI.pOQ.setText(e.u(dU));
            bankRemitMoneyInputUI.pOR.setText(e.u(d));
        }
    }

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = str;
        payInfo.fDQ = 49;
        String str5 = bankRemitMoneyInputUI.getString(i.uOx, new Object[]{str3, str4}) + str2;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str5);
        payInfo.vGl = bundle;
        h.a((Context) bankRemitMoneyInputUI, payInfo, 1);
    }

    static /* synthetic */ boolean a(BankRemitMoneyInputUI bankRemitMoneyInputUI, final n nVar) {
        final cj cjVar = nVar.pMY.wQJ;
        if (cjVar == null || cjVar.fEo != 1) {
            return false;
        }
        x.i("MicroMsg.BankRemitMoneyInputUI", "show alert item");
        com.tencent.mm.ui.base.h.a((Context) bankRemitMoneyInputUI, cjVar.fzT, "", cjVar.ojc, cjVar.ojb, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (nVar.pMY.lot == 0) {
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar.pMY.oiX, nVar.pMY.pNv, nVar.pMY.nHt, nVar.pMY.pNu);
                } else if (!bi.oN(cjVar.loA)) {
                    e.l(BankRemitMoneyInputUI.this.mController.xRr, cjVar.loA, false);
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    static /* synthetic */ void e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", Integer.valueOf((int) Math.round(bi.getDouble(bankRemitMoneyInputUI.pON.getText(), 0.0d) * 100.0d)), Long.valueOf(bankRemitMoneyInputUI.pPc), bankRemitMoneyInputUI.gCB, Integer.valueOf(bankRemitMoneyInputUI.pPa), Integer.valueOf(bankRemitMoneyInputUI.pOZ));
        k nVar = new n(bankRemitMoneyInputUI.pOV, bankRemitMoneyInputUI.pOW, bankRemitMoneyInputUI.pOY, bankRemitMoneyInputUI.pOZ, r5, bankRemitMoneyInputUI.gCB, (int) bankRemitMoneyInputUI.pPc, bankRemitMoneyInputUI.pPa, bankRemitMoneyInputUI.pOX);
        nVar.k(bankRemitMoneyInputUI);
        bankRemitMoneyInputUI.l(nVar);
    }

    static /* synthetic */ void f(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        if (bankRemitMoneyInputUI.pOM != null) {
            final int i;
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.lXK.getLocationInWindow(iArr);
            int eC = (a.eC(bankRemitMoneyInputUI) - i) - a.fromDPToPix(bankRemitMoneyInputUI, 30);
            x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + bankRemitMoneyInputUI.lXK.getHeight()), Integer.valueOf(a.eC(bankRemitMoneyInputUI)), Integer.valueOf(eC), Integer.valueOf(bankRemitMoneyInputUI.ild));
            if (eC > 0 && eC < bankRemitMoneyInputUI.ild) {
                i = bankRemitMoneyInputUI.ild - eC;
                x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                bankRemitMoneyInputUI.pOM.post(new Runnable() {
                    public final void run() {
                        BankRemitMoneyInputUI.this.pOM.scrollBy(0, i);
                    }
                });
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1380);
        int intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(10))).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.pPd = intValue;
        intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(5000000))).intValue();
        if (intValue <= 0) {
            intValue = 5000000;
        }
        this.pPe = intValue;
        x.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", Integer.valueOf(this.pPd), Integer.valueOf(this.pPe));
        this.pOT = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.pOU = getIntent().getStringExtra("key_payee_name");
        this.pOV = getIntent().getStringExtra("key_bank_card_seqno");
        this.pOW = getIntent().getStringExtra("key_bank_card_tailno");
        this.pOX = getIntent().getStringExtra("key_encrypt_data");
        this.pOZ = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.pPa = getIntent().getIntExtra("key_input_type", 0);
        if (this.pOT == null) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.pOT = new BankcardElemParcel();
        }
        this.pOY = this.pOT.pff;
        initView();
        setMMTitle(i.uOC);
    }

    protected final void initView() {
        this.pOM = (ScrollView) findViewById(f.uCJ);
        this.pNq = (CdnImageView) findViewById(f.umX);
        this.pNs = (TextView) findViewById(f.umZ);
        this.pOL = (TextView) findViewById(f.une);
        this.pON = (WalletFormView) findViewById(f.umY);
        this.pOO = (LinearLayout) findViewById(f.una);
        this.pOP = (TextView) this.pOO.findViewById(f.unb);
        this.pOQ = (TextView) this.pOO.findViewById(f.unc);
        this.pOR = (TextView) this.pOO.findViewById(f.ung);
        this.pOS = (TextView) this.pOO.findViewById(f.unf);
        this.lXK = (Button) findViewById(f.und);
        String str = com.tencent.mm.plugin.remittance.bankcard.model.a.dU(this.pOT.pNa, "100") + "%";
        this.pOP.setText(getString(i.uOl, new Object[]{str}));
        this.pNq.setUrl(this.pOT.pMZ);
        this.pNs.setText(getString(i.uOx, new Object[]{this.pOT.nHt, this.pOW}));
        this.pOL.setText(this.pOU);
        this.pON.yb(u.cCu());
        e(this.pON, 2, false);
        this.pON.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                obj = editable.toString();
                if (bi.oN(obj) || bi.getDouble(obj, 0.0d) <= 0.0d) {
                    BankRemitMoneyInputUI.this.pOO.setVisibility(8);
                } else {
                    BankRemitMoneyInputUI.this.pOO.setVisibility(0);
                }
                BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, obj);
                BankRemitMoneyInputUI.this.boa();
            }
        });
        this.pOS.setClickable(true);
        this.pOS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        this.pPb = new l(new l.a() {
            public final void azL() {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(i.uOs), BankRemitMoneyInputUI.this.gCB, BankRemitMoneyInputUI.this.getString(i.uTJ), 20, new b() {
                    public final boolean v(CharSequence charSequence) {
                        if (bi.oN(charSequence.toString())) {
                            BankRemitMoneyInputUI.this.gCB = null;
                            BankRemitMoneyInputUI.this.bod();
                        } else {
                            BankRemitMoneyInputUI.this.gCB = charSequence.toString();
                            BankRemitMoneyInputUI.this.bod();
                        }
                        return true;
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ah.h(new Runnable() {
                            public final void run() {
                                BankRemitMoneyInputUI.this.aWY();
                            }
                        }, 500);
                    }
                });
                com.tencent.mm.plugin.report.service.g.pWK.h(14673, Integer.valueOf(4));
            }
        });
        bod();
        this.lXK.setOnClickListener(new r() {
            public final void azE() {
                x.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
                double dV = com.tencent.mm.plugin.remittance.bankcard.model.a.dV(BankRemitMoneyInputUI.this.pON.getText(), "100");
                if (dV <= 0.0d) {
                    x.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", Double.valueOf(dV));
                    Toast.makeText(BankRemitMoneyInputUI.this, i.uOp, 1).show();
                } else if (dV > ((double) BankRemitMoneyInputUI.this.pPe)) {
                    x.w("MicroMsg.BankRemitMoneyInputUI", "more than max: %s", Double.valueOf(dV));
                    Toast.makeText(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(i.uOq, new Object[]{com.tencent.mm.plugin.remittance.bankcard.model.a.dU(BankRemitMoneyInputUI.this.pPe, "100")}), 0).show();
                } else {
                    BankRemitMoneyInputUI.e(BankRemitMoneyInputUI.this);
                }
            }
        });
        boa();
        this.olj = new com.tencent.mm.wallet_core.ui.a() {
            public final void hE(boolean z) {
                if (z) {
                    BankRemitMoneyInputUI.f(BankRemitMoneyInputUI.this);
                } else {
                    BankRemitMoneyInputUI.this.pOM.scrollTo(0, 0);
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof n) {
            final n nVar = (n) kVar;
            nVar.a(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", nVar.pMY.oiX, nVar.pMY.vWn);
                    x.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", nVar.pMY.pNv, nVar.pMY.nHt);
                    BankRemitMoneyInputUI.this.pOx = nVar.pMY.vWn;
                    if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar)) {
                        BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar.pMY.oiX, nVar.pMY.pNv, nVar.pMY.nHt, nVar.pMY.pNu);
                    }
                }
            }).b(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", Integer.valueOf(nVar.pMY.lot), nVar.pMY.lou);
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar);
                }
            }).c(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", kVar);
                }
            });
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1380);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uHE;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        if (i == 1) {
            if (i2 == -1) {
                x.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                intent2 = new Intent(this.mController.xRr, BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.pOx);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                x.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", this.pOx, str);
                b(new c(this.pOx, str), false);
                return;
            }
            x.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", Integer.valueOf(i2));
        } else if (i == 2) {
            x.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            intent2 = new Intent();
            intent2.addFlags(67108864);
            d.b(this.mController.xRr, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bod() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (bi.oN(this.gCB)) {
            spannableStringBuilder.append(getString(i.uOs));
            spannableStringBuilder.setSpan(this.pPb, 0, spannableStringBuilder.length(), 18);
        } else {
            spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xRr, this.gCB));
            spannableStringBuilder.append(getString(i.uOr));
            spannableStringBuilder.setSpan(this.pPb, this.gCB.length(), spannableStringBuilder.length(), 34);
        }
        this.pOS.setText(spannableStringBuilder);
    }

    private void boa() {
        if (bi.getDouble(this.pON.getText(), 0.0d) <= 0.0d || bi.oN(this.pOV) || bi.oN(this.pOW) || bi.oN(this.pOY) || bi.oN(this.pOX)) {
            x.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", this.pON.getText(), Boolean.valueOf(bi.oN(this.pOV)), Boolean.valueOf(bi.oN(this.pOW)), Boolean.valueOf(bi.oN(this.pOY)), Boolean.valueOf(bi.oN(this.pOX)));
            this.lXK.setEnabled(false);
            return;
        }
        this.lXK.setEnabled(true);
    }
}
