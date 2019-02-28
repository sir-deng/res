package com.tencent.mm.wallet_core.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.q;

public final class h {
    public static boolean a(final WalletBaseUI walletBaseUI, k kVar, int i, final int i2, String str) {
        boolean z = false;
        if (i == 1000) {
            String string;
            if (bi.oN(str)) {
                string = walletBaseUI.getString(i.vdG);
            } else {
                string = str;
            }
            c ag = a.ag(walletBaseUI);
            switch (i2) {
                case -100869:
                    com.tencent.mm.ui.base.h.a((Context) walletBaseUI, walletBaseUI.getString(i.uYc), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.c(walletBaseUI, walletBaseUI.vf, i2);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                    z = true;
                    break;
                case -100868:
                    com.tencent.mm.ui.base.h.a((Context) walletBaseUI, walletBaseUI.getString(i.uYd), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.c(walletBaseUI, walletBaseUI.vf, i2);
                            if (walletBaseUI.aYL()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                    z = true;
                    break;
                case 401:
                    int i3;
                    if (kVar instanceof j) {
                        i3 = ((j) kVar).sUo;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(i.uYo), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (walletBaseUI.aYL()) {
                                    walletBaseUI.finish();
                                }
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, false, string, "", walletBaseUI.getString(i.uYp), walletBaseUI.getString(i.dGH), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (q.Gl()) {
                                    a.b(walletBaseUI, "PayUForgotPwdProcess", null);
                                } else {
                                    a.b(walletBaseUI, "ForgotPwdProcess", null);
                                }
                                if (walletBaseUI.aYL()) {
                                    walletBaseUI.finish();
                                }
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                walletBaseUI.uO(1);
                            }
                        });
                    }
                    z = true;
                    break;
                case e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    if (ag != null) {
                        z = ag.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (ag != null) {
                        z = ag.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case 405:
                    if (kVar instanceof j) {
                        z = ((j) kVar).sUo;
                    }
                    if (z) {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(i.uYo), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (walletBaseUI.aYL()) {
                                    walletBaseUI.finish();
                                }
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(i.vcN), walletBaseUI.getString(i.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                walletBaseUI.nR(true);
                            }
                        }, null);
                    }
                    z = true;
                    break;
                case JsApiPrivateAddContact.CTRL_INDEX /*407*/:
                    cCA();
                    if (q.Gl()) {
                        b(walletBaseUI, i2, string);
                    } else {
                        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, null, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                a.c(walletBaseUI, null, i2);
                                if (walletBaseUI.aYL()) {
                                    walletBaseUI.finish();
                                }
                            }
                        });
                    }
                    z = true;
                    break;
                case 412:
                    com.tencent.mm.ui.base.h.a((Context) walletBaseUI, string, "", walletBaseUI.getString(i.vdV), walletBaseUI.getString(i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("key_is_bind_bankcard", false);
                            a.a(walletBaseUI, "BindCardProcess", bundle, new c.a() {
                                public final Intent l(int i, Bundle bundle) {
                                    return null;
                                }
                            });
                        }
                    }, null);
                    z = true;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX /*414*/:
                    cCA();
                    b(walletBaseUI, i2, string);
                    z = true;
                    break;
            }
        }
        if (kVar instanceof com.tencent.mm.wallet_core.c.h) {
            ((com.tencent.mm.wallet_core.c.h) kVar).zQI = z;
        }
        return z;
    }

    private static void cCA() {
        k bVar;
        if (q.Gl()) {
            bVar = new b();
        } else {
            bVar = new m();
        }
        g.Dr();
        g.Dp().gRu.a(bVar, 0);
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i, String str) {
        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, false, str, "", walletBaseUI.getString(i.uYb), walletBaseUI.getString(i.dEy), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
                d.b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                if (walletBaseUI.aYL() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.c(walletBaseUI, walletBaseUI.vf, i);
                if (walletBaseUI.aYL() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        });
    }
}
