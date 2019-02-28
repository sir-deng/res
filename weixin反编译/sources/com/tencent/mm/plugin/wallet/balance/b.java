package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends c {
    static /* synthetic */ String n(b bVar) {
        if (bVar.mym != null) {
            PayInfo payInfo = (PayInfo) bVar.mym.getParcelable("key_pay_info");
            if (payInfo != null) {
                return payInfo.fvC;
            }
        }
        return "";
    }

    public final c a(Activity activity, Bundle bundle) {
        o.HS(14);
        if (activity instanceof WalletBalanceFetchUI) {
            p.bKx();
            if (!p.bKy().bMy()) {
                this.mym.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.mym.getParcelable("key_bankcard")) != null) {
                this.mym.putInt("key_pay_flag", 3);
                this.mym.putString("key_pwd_cash_title", activity.getString(i.uVH));
                Orders orders = (Orders) this.mym.getParcelable("key_orders");
                if (orders != null) {
                    this.mym.putString("key_pwd_cash_money", e.u(orders.pTQ));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.mym.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            c(activity, WalletBalanceFetchUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            p.bKx();
            if (!p.bKy().bMy()) {
                this.mym.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.mym.getParcelable("key_bankcard")) != null) {
                this.mym.putInt("key_pay_flag", 3);
                this.mym.putString("key_pwd_cash_title", activity.getString(i.uVH));
                Orders orders = (Orders) this.mym.getParcelable("key_orders");
                if (orders != null) {
                    this.mym.putString("key_pwd_cash_money", e.u(orders.pTQ));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.mym.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                c(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            c(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletCardElementUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            p.bKx();
            if (p.bKy().bMy()) {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletBalanceFetchResultUI.class, bundle);
        } else if (activity instanceof WalletBalanceFetchResultUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else if (activity instanceof WalletBalanceResultUI) {
            o.cCm();
            b(activity, this.mym);
        } else {
            o.cCm();
            C(activity);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletBalanceManagerUI.class, -1, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        if (mMActivity instanceof WalletBalanceFetchUI) {
            return new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    String str = null;
                    p.bKx();
                    b.this.mym.putParcelable("key_history_bankcard", p.bKy().sWj);
                    PayInfo payInfo = (PayInfo) b.this.mym.get("key_pay_info");
                    if (a.bLr()) {
                        this.zRf.a(new v(payInfo == null ? null : payInfo.fvC), true);
                    } else {
                        com.tencent.mm.wallet_core.d.i iVar = this.zRf;
                        if (payInfo != null) {
                            str = payInfo.fvC;
                        }
                        iVar.a(new y(str, 4), true);
                    }
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean k(Object... objArr) {
                    b.this.a(this.zRe, 0, b.this.mym);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    boolean z = false;
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    b.this.mym.putString("kreq_token", bVar.token);
                    b.this.mym.putParcelable("key_authen", bVar.sKx);
                    Bundle d = b.this.mym;
                    String str2 = "key_need_verify_sms";
                    if (!bVar.sKv) {
                        z = true;
                    }
                    d.putBoolean(str2, z);
                    Parcelable parcelable = bVar.pbX;
                    if (parcelable != null) {
                        b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    com.tencent.mm.wallet_core.a.j(this.zRe, b.this.mym);
                    this.zRe.finish();
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                    b.this.mym.putString("key_pwd1", (String) objArr[0]);
                    b.this.mym.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.fEo = 3;
                    authen.sQC = (String) objArr[0];
                    authen.pfg = bankcard.field_bindSerial;
                    authen.pff = bankcard.field_bankcardType;
                    authen.pHW = (PayInfo) b.this.mym.getParcelable("key_pay_info");
                    authen.sQK = bankcard.field_arrive_type;
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.mym.getParcelable("key_orders")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        b.this.mym.putString("kreq_token", bVar.token);
                        if (bVar.sLK) {
                            b.this.mym.putParcelable("key_orders", bVar.sKw);
                        }
                    }
                    if (b.this.c(this.zRe, null)) {
                        this.zRf.a(new y(b.n(b.this), 13), true, 1);
                        return true;
                    }
                    b.this.a(this.zRe, 0, b.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (b.this.mym.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!b.this.bNL()) {
                                authen.fEo = 1;
                                break;
                            }
                            authen.fEo = 4;
                            break;
                        case 2:
                            if (!b.this.bNL()) {
                                authen.fEo = 2;
                                break;
                            }
                            authen.fEo = 5;
                            break;
                        case 3:
                            if (!b.this.bNL()) {
                                authen.fEo = 3;
                                break;
                            }
                            authen.fEo = 6;
                            break;
                        default:
                            return false;
                    }
                    b.this.mym.putParcelable("key_authen", authen);
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final /* synthetic */ CharSequence uE(int i) {
                    String str;
                    String aD = bi.aD(b.this.mym.getString("key_mobile"), "");
                    if (bi.oN(aD)) {
                        Bankcard bankcard = (Bankcard) b.this.mym.getParcelable("key_bankcard");
                        if (bankcard != null) {
                            str = bankcard.field_mobile;
                            return this.zRe.getString(i.vdP, new Object[]{str});
                        }
                    }
                    str = aD;
                    return this.zRe.getString(i.vdP, new Object[]{str});
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e) {
                            com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) kVar;
                            if (eVar.sLK) {
                                b.this.mym.putParcelable("key_orders", eVar.sKw);
                            }
                            com.tencent.mm.wallet_core.a.j(this.zRe, b.this.mym);
                            return true;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                            Parcelable parcelable = bVar.pbX;
                            if (parcelable != null) {
                                b.this.mym.putParcelable("key_realname_guide_helper", parcelable);
                            }
                            b.this.mym.putString("kreq_token", bVar.token);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.p pVar = (com.tencent.mm.plugin.wallet_core.model.p) objArr[1];
                    if (!(pVar == null || pVar.pHW == null)) {
                        pVar.pHW.fDQ = 21;
                    }
                    Orders orders = (Orders) b.this.mym.getParcelable("key_orders");
                    switch (b.this.mym.getInt("key_pay_flag", 0)) {
                        case 1:
                            pVar.flag = "1";
                            break;
                        case 2:
                            if (!b.this.bNL()) {
                                pVar.flag = "2";
                                break;
                            }
                            pVar.flag = "5";
                            break;
                        case 3:
                            if (!b.this.bNL()) {
                                pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                break;
                            }
                            pVar.flag = "6";
                            break;
                        default:
                            return false;
                    }
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.d.e(pVar, orders), true, 1);
                    return true;
                }

                public final boolean q(Object... objArr) {
                    Authen authen = (Authen) b.this.mym.getParcelable("key_authen");
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.mym.getParcelable("key_orders")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceFetchResultUI) {
            return new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    Orders orders = (Orders) b.this.mym.getParcelable("key_orders");
                    Bankcard bankcard = com.tencent.mm.plugin.wallet_core.model.o.bMc().sFY;
                    bankcard.sRo -= orders.pTQ;
                    b.this.mym.putInt("key_balance_result_logo", h.uNj);
                    return super.p(objArr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }

                public final CharSequence uE(int i) {
                    Orders orders;
                    switch (i) {
                        case 0:
                            return this.zRe.getString(i.uVU);
                        case 1:
                            orders = (Orders) b.this.mym.getParcelable("key_orders");
                            if (orders == null || bi.oN(orders.sUa)) {
                                return this.zRe.getString(i.uVT);
                            }
                            return orders.sUa;
                        case 2:
                            orders = (Orders) b.this.mym.getParcelable("key_orders");
                            if (orders != null && orders.sTZ > 0) {
                                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.sTZ));
                            }
                    }
                    return super.uE(i);
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new g(mMActivity, iVar) {
            public final /* synthetic */ CharSequence uE(int i) {
                return this.zRe.getString(i.vdr);
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
                    return false;
                }
                f fVar = (f) kVar;
                if (fVar.sLK) {
                    b.this.mym.putParcelable("key_orders", fVar.sKw);
                }
                b.this.a(this.zRe, 0, b.this.mym);
                return true;
            }

            public final boolean k(Object... objArr) {
                this.zRf.a(new f((com.tencent.mm.plugin.wallet_core.model.p) objArr[0], (Orders) b.this.mym.getParcelable("key_orders")), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uVC;
    }

    public final String aLn() {
        return "BalanceFetchProcess";
    }
}
