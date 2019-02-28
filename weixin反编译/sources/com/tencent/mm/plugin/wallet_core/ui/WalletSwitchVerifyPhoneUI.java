package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView tcJ;
    private List<fa> tcK;
    public boolean tcL = false;

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        walletSwitchVerifyPhoneUI.vf.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.vf.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.j(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.vf);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, fa faVar) {
        Object bankcard = new Bankcard();
        bankcard.field_bindSerial = faVar.pfg;
        bankcard.field_mobile = faVar.sOP;
        bankcard.field_bankcardType = faVar.pff;
        bankcard.field_desc = faVar.nHt;
        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName);
        walletSwitchVerifyPhoneUI.vf.putParcelable("key_bankcard", bankcard);
        if (o.bMk().Ny(bankcard.field_bankcardType) != null) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.bKB();
            return;
        }
        walletSwitchVerifyPhoneUI.b(new t("", "", null), true);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqo, com.tencent.mm.plugin.wxpay.a.a.bpQ);
        super.onCreate(bundle);
        setMMTitle(getString(i.vdC));
        initView();
        this.tcL = this.vf.getBoolean("key_block_bind_new_card", false);
        if (!this.tcL) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.xRr);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(i.vdy), null);
            this.tcJ.a(switchPhoneItemView, -1);
        }
        if (cCT() != null && cCT().aLn() == "PayProcess" && this.vf.getInt("key_can_verify_tail", 0) == 1) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            CharSequence string = getString(i.uYt);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.xRr, g.uMv);
            switchPhoneItemView2.setTag(Integer.valueOf(-2));
            switchPhoneItemView2.a(string, null);
            this.tcJ.a(switchPhoneItemView2, -1);
        }
        jl(1667);
        jl(461);
        jl(1505);
        l(new e(bKA()));
    }

    protected final void initView() {
        this.tcJ = (SwitchPhoneItemGroupView) findViewById(f.uzV);
        this.tcJ.tdJ = new SwitchPhoneItemGroupView.a() {
            public final void cT(View view) {
                if (view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", Integer.valueOf(intValue));
                    if (intValue == -1) {
                        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
                    } else if (intValue == -2) {
                        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                        WalletSwitchVerifyPhoneUI.this.vf.putBoolean("key_forward_to_id_verify", true);
                        com.tencent.mm.wallet_core.a.j(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.vf);
                    } else {
                        fa faVar = (fa) WalletSwitchVerifyPhoneUI.this.tcK.get(intValue);
                        WalletSwitchVerifyPhoneUI.this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", Boolean.valueOf(faVar.vRu.equals("wx")));
                        WalletSwitchVerifyPhoneUI.this.cCU().k(faVar);
                    }
                }
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1667);
        jm(461);
        jm(1505);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                e eVar = (e) kVar;
                this.tcK = ((e) kVar).sOt.wpO;
                Collections.sort(this.tcK, new Comparator<fa>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        fa faVar = (fa) obj;
                        fa faVar2 = (fa) obj2;
                        if (faVar.vRu.equals("wx") && faVar2.vRu.equals("cft")) {
                            return -1;
                        }
                        return (faVar.vRu.equals("cft") && faVar2.vRu.equals("wx")) ? 1 : 0;
                    }
                });
                if (eVar.sOt.wpP != null) {
                    pr prVar = eVar.sOt.wpP;
                    this.vf.putString("key_true_name", prVar.sQD);
                    this.vf.putString("key_cre_name", prVar.wfw);
                    this.vf.putString("key_cre_type", prVar.sVw);
                }
                if (this.tcK == null || this.tcK.isEmpty()) {
                    x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.tcK.size() - 1; size >= 0; size--) {
                        final fa faVar = (fa) this.tcK.get(size);
                        if (faVar.vRu.equals("cft")) {
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.xRr);
                            String string = faVar.vRv.equals("1") ? getString(i.vdB) : getString(i.vdA);
                            Object string2 = getString(i.vdz, new Object[]{faVar.nHt, string, faVar.vRw});
                            if (this.tcL) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(i.vdD);
                                g gVar = new g(this);
                                String str2 = string2 + "，";
                                gVar.su = getResources().getColor(c.brA);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(gVar, str2.length(), str2.length() + string3.length(), 33);
                                gVar.sZF = new g.a() {
                                    public final void onClick(View view) {
                                        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, faVar);
                                    }
                                };
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(faVar.sOP, spannableString);
                            this.tcJ.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.xRr);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(faVar.sOP, getString(i.vdE));
                            this.tcJ.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                return true;
            } else if (kVar instanceof t) {
                bKB();
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uMx;
    }

    protected final boolean bKK() {
        return true;
    }

    private void bKB() {
        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.vf.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        Object Ny = o.bMk().Ny(bankcard.field_bankcardType);
        this.vf.putParcelable("elemt_query", Ny);
        authen.pff = bankcard.field_bankcardType;
        authen.pfg = bankcard.field_bindSerial;
        bankcard.field_bankPhone = Ny.sSL;
        this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.vf.putBoolean("key_is_changing_balance_phone_num", true);
        this.vf.putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.j(this, this.vf);
    }
}
