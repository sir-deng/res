package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private boolean hasInit = false;
    private f inW;
    private Bankcard sJg;
    private k ugA;
    private OnClickListener ugx = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.uGY) {
                if (WalletWXCreditDetailUI.this.ugA != null) {
                    e.T(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.ugA.ufR.username);
                }
            } else if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.uGW && WalletWXCreditDetailUI.this.ugA != null) {
                e.l(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.ugA.ufQ, false);
            }
        }
    };
    private c ugz;

    static /* synthetic */ void bYF() {
    }

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        Bundle bundle = walletWXCreditDetailUI.ugz.mym;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
    }

    public final int XK() {
        return l.vhd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cCY().jl(621);
        cCY().jl(600);
        uV(4);
        this.ugz = com.tencent.mm.wallet_core.a.ag(this);
        if (this.sJg == null) {
            this.sJg = (Bankcard) this.ugz.mym.getParcelable("key_bankcard");
        }
        if (bYE()) {
            if (this.zSj == null) {
                if (this.zSh == null) {
                    this.zSh = com.tencent.mm.wallet_core.a.ag(this);
                }
                this.zSj = this.zSh.a((MMActivity) this, this.zSi);
            }
            if (!this.zSj.p(this.sJg)) {
                uV(0);
                initView();
            }
        }
    }

    private boolean bYE() {
        if (this.sJg == null) {
            return false;
        }
        if (this.sJg.field_bankcardState == 0) {
            return true;
        }
        int i = this.sJg.field_wxcreditState;
        if (this.ugA != null) {
            i = this.ugA.ufC;
        }
        switch (i) {
            case 1:
                long bz = bi.bz(o.bMc().sWr);
                x.d("MicroMsg.WalletUserInfoManger", "pass time " + bz);
                if (bz > 300) {
                    i = 1;
                } else {
                    boolean z = false;
                }
                if (i != 0) {
                    return true;
                }
                return false;
            case 3:
                h.a((Context) this, i.veC, -1, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletWXCreditDetailUI.this.cCY().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.this.sJg.field_bankcardType, WalletWXCreditDetailUI.this.sJg.sRk), true, 1);
                    }
                });
                return false;
            case 4:
                break;
            case 5:
                this.ugz.mym.putBoolean("key_can_unbind", false);
                break;
            default:
                return true;
        }
        if (this.ugA == null) {
            return true;
        }
        this.ugz.mym.putString("key_repayment_url", this.ugA.ufK);
        this.ugz.a((Activity) this, 1, this.ugz.mym);
        return false;
    }

    protected void onDestroy() {
        cCY().jm(621);
        cCY().jm(600);
        super.onDestroy();
    }

    protected final void initView() {
        this.hasInit = true;
        setMMTitle(i.veD);
        this.inW = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletWXCreditDetailUI.this.aWY();
                WalletWXCreditDetailUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                List arrayList = new ArrayList();
                o.bMc();
                String str = WalletWXCreditDetailUI.this.sJg.field_bindSerial;
                h.a(WalletWXCreditDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletWXCreditDetailUI.this.getString(i.uYF), false, new h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                o.bMc();
                                String str = WalletWXCreditDetailUI.this.sJg.field_bindSerial;
                                WalletWXCreditDetailUI.bYF();
                                return;
                            case 1:
                                WalletWXCreditDetailUI.c(WalletWXCreditDetailUI.this);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
    }

    private void av() {
        String str;
        if (!this.hasInit) {
            initView();
        }
        if (this.ugA != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.inW.Zu("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.ikp.setText(e.u(this.ugA.ufD));
            String str2 = this.sJg.field_bankName;
            str = this.ugA.ufP;
            walletWXCreditDetailHeaderPreference.ugy.setText(walletWXCreditDetailHeaderPreference.mContext.getString(i.uHe, new Object[]{str, str2}));
        }
        if (this.ugA != null) {
            boolean z;
            this.inW.Zu("wallet_wxcredit_total_amount").setTitle(getString(i.veE, new Object[]{e.u(this.ugA.ufx)}));
            f fVar = this.inW;
            str = "wallet_wxcredit_change_amount";
            if (this.ugA.ufI) {
                z = false;
            } else {
                z = true;
            }
            fVar.bl(str, z);
            Preference Zu = this.inW.Zu("wallet_wxcredit_bill");
            if (this.ugA.ufE != 0.0d) {
                Zu.setSummary(e.u(this.ugA.ufE));
            }
            Zu = this.inW.Zu("wallet_wxcredit_repayment");
            Preference Zu2 = this.inW.Zu("wallet_wxcredit_repayment_tips");
            if (this.ugA.ufG > 0.0d) {
                Zu.setSummary(e.u(this.ugA.ufG));
                Zu2.setTitle(getString(i.veQ, new Object[]{this.ugA.ufL}));
                this.inW.bl("wallet_wxcredit_repayment_tips", false);
            } else {
                this.inW.bl("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.sJg != null) {
            this.inW.Zu("wallet_wxcredit_bank_name").setTitle(this.sJg.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.inW.Zu("wallet_wxcredit_footer")).ugx = this.ugx;
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        Bundle bundle;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("key_bankcard", this.sJg);
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle2);
            return true;
        } else if ("wallet_wxcredit_bill".equals(str)) {
            if (this.ugA == null) {
                return false;
            }
            bundle = new Bundle();
            bundle.putString("key_url", this.ugA.ufO);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle);
            return false;
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.ugA == null) {
                return false;
            }
            bundle = new Bundle();
            bundle.putString("key_url", this.ugA.ufM);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle);
            return false;
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.ugA == null) {
                return false;
            }
            e.l(this, this.ugA.ufN, false);
            return false;
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.ugA == null) {
                return false;
            }
            e.l(this, this.ugA.ufK, false);
            return false;
        } else if (!"wallet_wxcredit_bank_name".equals(str) || this.ugA == null) {
            return false;
        } else {
            e.S(this, this.ugA.ufR.username);
            return false;
        }
    }

    public final boolean g(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                o.bMc().sWr = System.currentTimeMillis() / 1000;
                this.ugA = ((d) kVar).ufy;
                if (this.ugA != null && this.ugA.ufC == 2) {
                    g.Dr();
                    if (((Boolean) g.Dq().Db().get(196658, Boolean.valueOf(false))).booleanValue()) {
                        c ag = com.tencent.mm.wallet_core.a.ag(this);
                        Bundle bundle = ag.mym;
                        bundle.putDouble("key_total_amount", this.ugA.ufx);
                        bundle.putBoolean("key_can_upgrade_amount", this.ugA.ufI);
                        ag.a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        return true;
                    }
                }
                if (bYE()) {
                    uV(0);
                    av();
                }
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.i) {
                cCY().a(new y(), true, 1);
            } else if (kVar instanceof y) {
                finish();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        uV(0);
        av();
        super.onActivityResult(i, i2, intent);
    }
}
