package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h extends c {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            C(activity);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        C(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.F((WalletBaseUI) activity);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final void C(Activity activity) {
        int i = 2;
        if (activity != null) {
            int i2 = this.mym.getInt("offline_from_scene", -1);
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 1;
                } else if (i2 == 3) {
                    i = 3;
                } else if (i2 == 4) {
                    i = 6;
                } else if (i2 == 8) {
                    i = 4;
                } else {
                    i = 1;
                }
            }
            g.pWK.h(14096, Integer.valueOf(i));
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i2);
            intent.putExtra("is_offline_create", true);
            a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
            public final /* synthetic */ CharSequence uE(int i) {
                switch (i) {
                    case 0:
                        return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uXz);
                    case 1:
                        return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uXy);
                    default:
                        return "";
                }
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                        x.i("MicroMsg.OfflineProcess", "Offline is Create ");
                        bhB();
                        h.this.mym.putBoolean("is_offline_create", true);
                    } else if (kVar instanceof n) {
                        x.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                        i iVar = this.zRf;
                        if (iVar.ion == null || !(iVar.ion == null || iVar.ion.isShowing())) {
                            if (iVar.ion != null) {
                                iVar.ion.dismiss();
                            }
                            if (iVar.mContext == null) {
                                x.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                            } else {
                                iVar.ion = com.tencent.mm.wallet_core.ui.g.a(iVar.mContext, false, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        i.this.aXI();
                                    }
                                });
                            }
                        }
                        b swVar = new sw();
                        swVar.fLz.scene = 8;
                        swVar.fLA.fLu = new Runnable() {
                            public final void run() {
                                x.d("MicroMsg.OfflineProcess", "tofutest do callback");
                                h.this.a(AnonymousClass1.this.zRe, 0, h.this.mym);
                                AnonymousClass1.this.zRf.bKF();
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.m(swVar);
                    } else if (kVar instanceof com.tencent.mm.plugin.offline.a.i) {
                        com.tencent.mm.plugin.offline.a.i iVar2 = (com.tencent.mm.plugin.offline.a.i) kVar;
                        if ("1".equals(iVar2.pcd)) {
                            Activity activity = this.zRe;
                            String str2 = iVar2.fBa;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("key_authen", new Authen());
                            bundle.putString("key_pwd1", h.this.mym.getString("key_pwd1"));
                            bundle.putString("key_mobile", str2);
                            bundle.putInt("verify_scene", 1);
                            bundle.putInt("offline_add_fee", h.this.mym.getInt("offline_chg_fee", 0));
                            com.tencent.mm.wallet_core.a.a(activity, l.class, bundle);
                            h.this.a(activity, 0, h.this.mym);
                        } else {
                            h.this.mym.putBoolean("back_to_coin_purse_ui", true);
                            bhB();
                        }
                    } else if (kVar instanceof p) {
                        a.Hy("");
                        k.bhD();
                        k.bhE().pcG = null;
                        h.this.a(this.zRe, 0, h.this.mym);
                    }
                    return true;
                } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.k)) {
                    return false;
                } else {
                    x.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                    com.tencent.mm.plugin.offline.a.k kVar2 = (com.tencent.mm.plugin.offline.a.k) kVar;
                    if (i2 != JsApiBatchGetContact.CTRL_INDEX) {
                        return false;
                    }
                    final Context context = this.zRe;
                    final int i3 = kVar2.pcr;
                    com.tencent.mm.ui.base.h.a(context, str, "", context.getString(com.tencent.mm.plugin.wxpay.a.i.vaV), context.getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.pluginsdk.wallet.h.X(context, i3);
                            h.this.a(context, 0, h.this.mym);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            h.this.a(context, 0, h.this.mym);
                        }
                    });
                    return true;
                }
            }

            public final boolean k(Object... objArr) {
                String str = (String) objArr[0];
                h.this.mym.putString("key_pwd1", str);
                Bankcard biq = a.biq();
                if (biq == null) {
                    x.e("MicroMsg.OfflineProcess", "no support bank car for offline");
                    biq = a.bir();
                }
                if (biq == null) {
                    x.e("MicroMsg.OfflineProcess", "no any bank car for offline");
                    return false;
                }
                String string = h.this.mym.getString("oper");
                if (!a.bin()) {
                    x.i("MicroMsg.OfflineProcess", "Offline is not Create ");
                    this.zRf.a(new com.tencent.mm.plugin.offline.a.k(biq, (String) objArr[0], h.this.mym.getInt("offline_chg_fee", 0)), true, 1);
                } else if (string != null) {
                    x.i("MicroMsg.OfflineProcess", "oper == " + string);
                    if (string.equals("create")) {
                        this.zRf.a(new com.tencent.mm.plugin.offline.a.k(biq, (String) objArr[0], h.this.mym.getInt("offline_chg_fee", 0)), true, 1);
                    } else if (string.equals("clr")) {
                        this.zRf.a(new com.tencent.mm.plugin.offline.a.i(biq, str, "clr", 0, ""), true, 1);
                    } else if (string.equals("changeto")) {
                        this.zRf.a(new com.tencent.mm.plugin.offline.a.i(biq, str, "changeto", h.this.mym.getInt("offline_chg_fee"), ""), true, 1);
                    } else if (!string.equals("freeze")) {
                        return false;
                    } else {
                        this.zRf.a(new p(str), true, 1);
                    }
                }
                return true;
            }

            private void bhB() {
                this.zRf.a(new n(System.currentTimeMillis(), a.peW), false, 1);
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aLn() {
        return "OfflineProcess";
    }
}
