package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.e.d;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class b extends com.tencent.mm.plugin.wallet_core.b.a {

    private abstract class a extends c {
        public a(WalletBaseUI walletBaseUI, i iVar) {
            super(walletBaseUI, iVar);
        }
    }

    public final c a(Activity activity, Bundle bundle) {
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.fDQ);
        bundle.putInt("key_pay_channel", payInfo.fDM);
        if (!e(activity, bundle)) {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.fDQ == 11) {
                o.HS(13);
            }
            x.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    x.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    c(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    x.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    c(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !bNL()) {
                        x.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        c(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    x.i("MicroMsg.PayProcess", "jump to result ui!");
                    f(activity, bundle);
                    break;
            }
        }
        x.w("MicroMsg.PayProcess", "hy: has err. return");
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (e(activity, bundle)) {
            x.i("MicroMsg.PayProcess", "deal with the err!");
            return;
        }
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.mym.getBoolean("key_forward_to_id_verify", false)) {
                x.i("MicroMsg.PayProcess", "go to verify id tail");
                c(activity, WalletVerifyIdCardUI.class, this.mym);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            f(activity, bundle);
        }
        int i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.mym.getInt("key_pay_flag", 0);
        x.i("MicroMsg.PayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 1:
                x.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    c(activity, WalletPwdConfirmUI.class, bundle);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bNL()) {
                        x.i("MicroMsg.PayProcess", "oversea, set pwd");
                        c(activity, WalletSetPasswordUI.class, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 2:
                x.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bNL()) {
                        x.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 3:
                x.i("MicroMsg.PayProcess", "forwardBound()");
                if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if ((activity instanceof WalletResetInfoUI) || (activity instanceof WalletChangeBankcardUI)) {
                    if ((!bundle.getBoolean("key_need_verify_sms", false) || bNL()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        x.i("MicroMsg.PayProcess", "jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else if ((activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    x.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void d(Activity activity, int i) {
        x.i("MicroMsg.PayProcess", "back pay_flag : " + this.mym.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            return;
        }
        o.cCm();
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i = -1;
        x.i("MicroMsg.PayProcess", "end pay_flag : " + this.mym.getInt("key_pay_flag", 0));
        o.cCm();
        int i2 = this.mym.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            payInfo = (PayInfo) this.mym.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.mym.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.mym.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.mym.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.mym.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.mym.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.fDM);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.mym.getParcelable("key_orders"));
        com.tencent.mm.sdk.b.b tbVar = new tb();
        tbVar.fMn.intent = intent;
        tbVar.fMn.fvC = bKA();
        com.tencent.mm.f.a.tb.a aVar = tbVar.fMn;
        if (!this.mym.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.result = i;
        if (tbVar.fMn.result == 0 && bundle != null) {
            payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                com.tencent.mm.plugin.wallet.pay.a.b.b.V(payInfo.fvC, payInfo.fDQ, payInfo.fDM);
            }
        }
        com.tencent.mm.sdk.b.a.xmy.m(tbVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
    }

    private boolean e(Activity activity, Bundle bundle) {
        x.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", Integer.valueOf(bundle.getInt("key_err_code", 0)));
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                c(activity, WalletChangeBankcardUI.class, bundle);
                return true;
            case -1003:
                p.bKx();
                if (p.bKy().bMy()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
                return true;
            case e.CTRL_INDEX /*402*/:
            case ap.CTRL_INDEX /*403*/:
            case av.CTRL_INDEX /*408*/:
                Bankcard bankcard = (Bankcard) this.mym.get("key_bankcard");
                if (bankcard == null || !bankcard.bLB()) {
                    c(activity, WalletResetInfoUI.class, bundle);
                } else if (com.tencent.mm.plugin.wallet_core.model.o.bMc().bMJ() == null || com.tencent.mm.plugin.wallet_core.model.o.bMc().bMJ().size() <= 0) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    x.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", com.tencent.mm.plugin.wallet_core.model.o.bMc().bMJ());
                    bundle2.putString("key_top_tips", activity.getString(com.tencent.mm.plugin.wxpay.a.i.vcZ));
                    c(activity, WalletSelectBankcardUI.class, bundle2);
                }
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletResetInfoUI.class, bundle);
                return true;
            default:
                return false;
        }
    }

    private void f(Activity activity, Bundle bundle) {
        if (this.mym != null && this.mym.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.mym.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        x.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", Integer.valueOf(i));
        if (i == 11 || i == 21) {
            c(activity, WalletBalanceResultUI.class, bundle);
        } else if (i == 5 || i == 31 || i == 32 || i == 33 || i == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.pQV != 1) {
                a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                return;
            }
            x.i("MicroMsg.PayProcess", "is busi f2f");
            b(activity, bundle);
        } else if (i == 37 || i == 39 || i == 42 || i == 45 || i == 52 || i == 49) {
            b(activity, bundle);
        } else {
            c(activity, WalletOrderInfoUI.class, bundle);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayProcess", "pay_flag : " + this.mym.getInt("key_pay_flag", 0));
        switch (this.mym.getInt("key_pay_flag", 0)) {
            case 1:
                return activity instanceof WalletOrderInfoUI;
            case 2:
                return activity instanceof WalletOrderInfoUI;
            default:
                return false;
        }
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    this.zRf.a(new r((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBankcardIdUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    if (b.this.mym.getInt("key_pay_scene", 0) == 11) {
                        p.bKx();
                        b.this.mym.putParcelable("key_history_bankcard", p.bKy().sWj);
                    }
                    return super.p(objArr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        b.this.mym.putString("kreq_token", bVar.token);
                        if (bVar.sLK) {
                            b.this.mym.putParcelable("key_orders", bVar.sKw);
                        }
                        Parcelable parcelable = bVar.pbX;
                        if (parcelable != null) {
                            b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                        }
                    } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.c) {
                        com.tencent.mm.plugin.wallet.pay.a.a.c cVar = (com.tencent.mm.plugin.wallet.pay.a.a.c) kVar;
                        b.this.mym.putString("kreq_token", cVar.token);
                        if (cVar.sLK) {
                            b.this.mym.putParcelable("key_orders", cVar.sKw);
                        }
                    }
                    if (b.this.c(this.zRe, null)) {
                        this.zRf.a(new y(b.this.bKA(), 13), true, 1);
                        return true;
                    }
                    b.this.a(this.zRe, 0, b.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    x.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + b.this.mym.getInt("key_pay_flag", 0));
                    switch (b.this.mym.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (b.this.bNL()) {
                                authen.fEo = 4;
                            } else {
                                authen.fEo = 1;
                            }
                            this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            return true;
                        case 2:
                            if (b.this.bNL()) {
                                authen.fEo = 5;
                            } else {
                                authen.fEo = 2;
                            }
                            if (b.this.mym.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.c(authen, orders, b.this.mym.getBoolean("key_isbalance", false)), true, 1);
                            } else {
                                this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            }
                            return true;
                        case 3:
                            if (b.this.bNL()) {
                                authen.fEo = 6;
                            } else {
                                authen.fEo = 3;
                            }
                            this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            return true;
                        default:
                            return false;
                    }
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final /* synthetic */ CharSequence uE(int i) {
                    boolean z = b.this.mym.getBoolean("key_is_changing_balance_phone_num");
                    boolean z2 = b.this.mym.getBoolean("key_is_return_from_switch_phone", false);
                    Authen authen = (Authen) b.this.mym.getParcelable("key_authen");
                    String str = (authen == null || authen.sQP == null) ? "" : authen.sQP;
                    int i2 = b.this.mym.getInt("key_pay_flag", 3);
                    Bankcard bankcard;
                    String oM;
                    MMActivity mMActivity;
                    int i3;
                    Object[] objArr;
                    if (!z2 || str.isEmpty()) {
                        if (!z || i2 == 2) {
                            str = bi.aD(b.this.mym.getString("key_mobile"), "");
                            return String.format(this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.vdQ), new Object[]{str});
                        }
                        bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                        oM = bi.oM(b.this.mym.getString("key_mobile"));
                        mMActivity = this.zRe;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.vdH;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = com.tencent.mm.wallet_core.ui.e.abl(bi.oN(oM) ? bankcard.field_mobile : oM);
                        return mMActivity.getString(i3, objArr);
                    } else if (str.equals("cft")) {
                        bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                        oM = bi.oM(b.this.mym.getString("key_mobile"));
                        mMActivity = this.zRe;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.vdH;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = com.tencent.mm.wallet_core.ui.e.abl(bi.oN(oM) ? bankcard.field_mobile : oM);
                        return mMActivity.getString(i3, objArr);
                    } else {
                        str = bi.aD(b.this.mym.getString("key_mobile"), "");
                        return String.format(this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.vdQ), new Object[]{str});
                    }
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i == 0 && i2 == 0) {
                        if ((kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e) || (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.b)) {
                            com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                            if (eVar.sLK) {
                                b.this.mym.putParcelable("key_orders", eVar.sKw);
                            }
                            Parcelable parcelable = eVar.pbX;
                            if (parcelable != null) {
                                b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(10707, Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.wallet_core.e.c.bNW()));
                            return false;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            return true;
                        }
                    }
                    return false;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean k(java.lang.Object... r9) {
                    /*
                    r8 = this;
                    r3 = 0;
                    r2 = 1;
                    r0 = r9[r2];
                    r0 = (com.tencent.mm.plugin.wallet_core.model.p) r0;
                    r1 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r1 = r1.mym;
                    r4 = "key_orders";
                    r1 = r1.getParcelable(r4);
                    r1 = (com.tencent.mm.plugin.wallet_core.model.Orders) r1;
                    r4 = "MicroMsg.PayProcess";
                    r5 = new java.lang.StringBuilder;
                    r6 = "WalletVerifyCodeUI onNext pay_flag : ";
                    r5.<init>(r6);
                    r6 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r6 = r6.mym;
                    r7 = "key_pay_flag";
                    r6 = r6.getInt(r7, r3);
                    r5 = r5.append(r6);
                    r5 = r5.toString();
                    com.tencent.mm.sdk.platformtools.x.i(r4, r5);
                    r4 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r4 = r4.mym;
                    r5 = "key_is_changing_balance_phone_num";
                    r4 = r4.getBoolean(r5);
                    r5 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r5 = r5.mym;
                    r6 = "key_pay_flag";
                    r5 = r5.getInt(r6, r3);
                    switch(r5) {
                        case 1: goto L_0x0051;
                        case 2: goto L_0x0096;
                        case 3: goto L_0x00ea;
                        default: goto L_0x004f;
                    };
                L_0x004f:
                    r0 = r3;
                L_0x0050:
                    return r0;
                L_0x0051:
                    r3 = "1";
                    r0.flag = r3;
                    if (r4 != 0) goto L_0x007e;
                L_0x0058:
                    r3 = r0.pff;
                    r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
                    if (r3 != 0) goto L_0x008a;
                L_0x0060:
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r3 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r3 = r3.sWo;
                    if (r3 == 0) goto L_0x008a;
                L_0x006b:
                    r3 = r0.pff;
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r4 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r4 = r4.sWo;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x008a;
                L_0x007e:
                    r3 = r8.zRf;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x0088:
                    r0 = r2;
                    goto L_0x0050;
                L_0x008a:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x0088;
                L_0x0090:
                    r1 = r8.zRf;
                    r1.a(r0, r2, r2);
                    goto L_0x0088;
                L_0x0096:
                    r3 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r3 = r3.bNL();
                    if (r3 != 0) goto L_0x00d8;
                L_0x009e:
                    r3 = "2";
                    r0.flag = r3;
                L_0x00a3:
                    if (r4 != 0) goto L_0x00cb;
                L_0x00a5:
                    r3 = r0.pff;
                    r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
                    if (r3 != 0) goto L_0x00de;
                L_0x00ad:
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r3 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r3 = r3.sWo;
                    if (r3 == 0) goto L_0x00de;
                L_0x00b8:
                    r3 = r0.pff;
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r4 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r4 = r4.sWo;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x00de;
                L_0x00cb:
                    r3 = r8.zRf;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x00d5:
                    r0 = r2;
                    goto L_0x0050;
                L_0x00d8:
                    r3 = "5";
                    r0.flag = r3;
                    goto L_0x00a3;
                L_0x00de:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x00d5;
                L_0x00e4:
                    r1 = r8.zRf;
                    r1.a(r0, r2, r2);
                    goto L_0x00d5;
                L_0x00ea:
                    r3 = com.tencent.mm.plugin.wallet.pay.b.this;
                    r3 = r3.bNL();
                    if (r3 != 0) goto L_0x012c;
                L_0x00f2:
                    r3 = "3";
                    r0.flag = r3;
                L_0x00f7:
                    if (r4 != 0) goto L_0x011f;
                L_0x00f9:
                    r3 = r0.pff;
                    r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
                    if (r3 != 0) goto L_0x0132;
                L_0x0101:
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r3 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r3 = r3.sWo;
                    if (r3 == 0) goto L_0x0132;
                L_0x010c:
                    r3 = r0.pff;
                    com.tencent.mm.plugin.wallet.a.p.bKx();
                    r4 = com.tencent.mm.plugin.wallet.a.p.bKy();
                    r4 = r4.sWo;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x0132;
                L_0x011f:
                    r3 = r8.zRf;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x0129:
                    r0 = r2;
                    goto L_0x0050;
                L_0x012c:
                    r3 = "6";
                    r0.flag = r3;
                    goto L_0x00f7;
                L_0x0132:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x0129;
                L_0x0138:
                    r1 = r8.zRf;
                    r1.a(r0, r2, r2);
                    goto L_0x0129;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.b.13.k(java.lang.Object[]):boolean");
                }
            };
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    Orders orders = (Orders) objArr[0];
                    p.bKx();
                    Bankcard bankcard = p.bKy().sFY;
                    bankcard.sRo += orders.pTQ;
                    return false;
                }

                public final CharSequence uE(int i) {
                    switch (i) {
                        case 0:
                            return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uVW);
                        case 1:
                            return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uVV);
                        default:
                            return super.uE(i);
                    }
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final /* synthetic */ CharSequence uE(int i) {
                    return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.vdr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (!(kVar instanceof f) || i != 0 || i2 != 0) {
                        return false;
                    }
                    f fVar = (f) kVar;
                    if (fVar.sLK) {
                        b.this.mym.putParcelable("key_orders", fVar.sKw);
                    }
                    Parcelable parcelable = fVar.pbX;
                    if (parcelable != null) {
                        b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    b.this.a(this.zRe, 0, b.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    k kVar;
                    com.tencent.mm.plugin.wallet_core.model.p pVar = (com.tencent.mm.plugin.wallet_core.model.p) objArr[0];
                    Orders orders = (Orders) b.this.mym.getParcelable("key_orders");
                    if (pVar == null || orders == null) {
                        x.e("MicroMsg.CgiManager", "empty verify or orders");
                        kVar = null;
                    } else {
                        PayInfo payInfo = pVar.pHW;
                        String str = "";
                        if (payInfo != null) {
                            x.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.fvC;
                        }
                        if (bi.oN(str)) {
                            x.i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.fvC;
                        }
                        if (bi.oN(str)) {
                            x.i("MicroMsg.CgiManager", "empty reqKey!");
                            kVar = new f(pVar, orders);
                        } else {
                            if (payInfo != null) {
                                x.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.fvC, orders.fvC);
                            }
                            x.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", str);
                            x.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                            kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.e.a(pVar, orders) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.e.e(pVar, orders) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.e.b(pVar, orders) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.e.c(pVar, orders) : str.startsWith("sns_") ? new d(pVar, orders) : new f(pVar, orders);
                        }
                    }
                    if (kVar != null) {
                        this.zRf.a(kVar, true, 1);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletChangeBankcardUI) {
            return new c((WalletBaseUI) mMActivity, iVar) {
                public final boolean k(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSelectBankcardUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.c)) {
                        x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        b.this.a(this.zRe, 0, b.this.mym);
                        return true;
                    } else if (i != 0 || i2 != 0 || !(kVar instanceof t)) {
                        return false;
                    } else {
                        x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        bKB();
                        return false;
                    }
                }

                public final boolean k(Object... objArr) {
                    x.i("MicroMsg.PayProcess", "onNext for select bank card");
                    b.this.mym.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        x.i("MicroMsg.PayProcess", "directToBindNew()");
                        b.this.mym.putInt("key_pay_flag", 2);
                        b.this.a(this.zRe, 0, b.this.mym);
                    } else if (com.tencent.mm.plugin.wallet_core.model.o.bMk().Ny(bankcard.field_bankcardType) != null) {
                        bKB();
                    } else {
                        this.zRf.a(new t("", "", null), true, 1);
                    }
                    return false;
                }

                private void bKB() {
                    x.i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = b.this.mym.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) b.this.mym.getParcelable("key_authen");
                    Orders orders = (Orders) b.this.mym.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                    ElementQuery Ny = com.tencent.mm.plugin.wallet_core.model.o.bMk().Ny(bankcard.field_bankcardType);
                    b.this.mym.putParcelable("elemt_query", Ny);
                    if (z) {
                        authen.pff = bankcard.field_bankcardType;
                        authen.pfg = bankcard.field_bindSerial;
                        b.this.a(this.zRe, 0, b.this.mym);
                        return;
                    }
                    authen.sOP = "";
                    authen.pff = bankcard.field_bankcardType;
                    authen.pfg = bankcard.field_bindSerial;
                    b.this.mym.putString("key_mobile", bankcard.field_mobile);
                    if (Ny == null || Ny.sSD || Ny.sSE) {
                        x.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                        b.this.a(this.zRe, 0, b.this.mym);
                        return;
                    }
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.c(authen, orders, b.this.mym.getBoolean("key_isbalance", false)), true);
                }
            };
        }
        if (mMActivity instanceof WalletResetInfoUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean k(Object... objArr) {
                    x.i("MicroMsg.PayProcess", "start do authen");
                    fa faVar = (fa) objArr[0];
                    Authen authen = (Authen) b.this.mym.getParcelable("key_authen");
                    Parcelable bankcard = new Bankcard();
                    bankcard.field_bindSerial = faVar.pfg;
                    bankcard.field_mobile = faVar.sOP;
                    bankcard.field_desc = faVar.nHt;
                    bankcard.field_bankcardType = authen.pff;
                    x.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", authen.pff, faVar.pfg, authen.pfg);
                    b.this.mym.putString("key_mobile", bankcard.field_mobile);
                    b.this.mym.putParcelable("key_bankcard", bankcard);
                    Orders orders = (Orders) b.this.mym.getParcelable("key_orders");
                    authen.sQP = faVar.vRu;
                    authen.sQQ = faVar.pfg;
                    authen.sQR = faVar.pff;
                    authen.sQS = "1";
                    k a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
                    if (a != null) {
                        this.zRf.a(a, true, 1);
                    }
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    x.i("MicroMsg.PayProcess", "finish auth");
                    Authen authen = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).sKx;
                    Parcelable parcelable = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).sKw;
                    b.this.mym.putParcelable("key_authen", authen);
                    b.this.mym.putParcelable("key_orders", parcelable);
                    b.this.mym.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).token);
                    b.this.mym.putBoolean("key_is_return_from_switch_phone", true);
                    b.this.mym.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                    bankcard.field_bankcardType = authen.pff;
                    bankcard.field_bindSerial = authen.pfg;
                    b.this.a(this.zRe, 0, b.this.mym);
                    b.this.C(this.zRe);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletVerifyIdCardUI ? new a((WalletBaseUI) mMActivity, iVar) {
            public final boolean k(Object... objArr) {
                if (objArr.length > 0) {
                    this.zRf.a(com.tencent.mm.plugin.wallet.pay.a.a.a((com.tencent.mm.plugin.wallet_core.model.p) objArr[0], (Orders) b.this.mym.getParcelable("key_orders")), true, 1);
                }
                return false;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (super.d(i, i2, str, kVar) || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e)) {
                    return false;
                }
                com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                if (i != 0 || i2 != 0) {
                    return false;
                }
                if (eVar.sLK) {
                    b.this.mym.putParcelable("key_orders", eVar.sKw);
                }
                Parcelable parcelable = eVar.pbX;
                if (parcelable != null) {
                    b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                }
                b.this.a(this.zRe, 0, b.this.mym);
                this.zRe.finish();
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean a(final WalletBaseUI walletBaseUI, final int i, String str) {
        x.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", Integer.valueOf(i));
        switch (i) {
            case e.CTRL_INDEX /*402*/:
            case ap.CTRL_INDEX /*403*/:
            case av.CTRL_INDEX /*408*/:
                if (cCc() && this.mym.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.mym.getParcelable("key_bankcard");
                    if (bi.oN(str)) {
                        string = walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.vbB, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.vbA), walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.mym.putInt("key_pay_flag", 3);
                            b.this.mym.putInt("key_err_code", i);
                            b.this.a(walletBaseUI, 0, b.this.mym);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, null);
                    return true;
                }
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                x.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                p.bKx();
                ArrayList bMJ = p.bKy().bMJ();
                if (bMJ == null || bMJ.isEmpty()) {
                    h.a((Context) walletBaseUI, str, "", walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.vaV), walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.uWx), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.mym.putInt("key_err_code", -1003);
                            b.this.a(walletBaseUI, 0, b.this.mym);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.b(walletBaseUI, b.this.mym);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                } else {
                    h.a((Context) walletBaseUI, str, "", walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.vbl), walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.uWx), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) b.this.mym.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.sRn = payInfo.fvC;
                            }
                            b.this.mym.putInt("key_err_code", -1004);
                            b.this.a(walletBaseUI, 0, b.this.mym);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.b(walletBaseUI, b.this.mym);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
        }
        return false;
    }

    private String bKA() {
        if (this.mym == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.mym.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fvC;
        }
        return "";
    }

    public final int b(MMActivity mMActivity, int i) {
        return com.tencent.mm.plugin.wxpay.a.i.vbu;
    }

    public final String aLn() {
        return "PayProcess";
    }
}
