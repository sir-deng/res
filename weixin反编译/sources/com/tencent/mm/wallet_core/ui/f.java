package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.m;

public final class f {
    private static String jfR = null;
    private static int lPJ = 0;
    private static int lPV = 0;

    static /* synthetic */ void c(WalletBaseUI walletBaseUI) {
        if (lPV == 1000) {
            switch (lPJ) {
                case 1:
                    if (!walletBaseUI.aYO()) {
                        walletBaseUI.uV(0);
                    }
                    walletBaseUI.uO(0);
                    break;
                case 3:
                    a.c(walletBaseUI.mController.xRr, walletBaseUI.vf, lPJ);
                    break;
                default:
                    if (!walletBaseUI.aYL() && walletBaseUI.cCP() == 0) {
                        walletBaseUI.uO(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.m(walletBaseUI.mController.xRr, lPJ);
        lPV = 0;
        lPJ = 0;
        jfR = null;
    }

    public static void a(final WalletBaseUI walletBaseUI, int i, int i2, String str, k kVar, boolean z) {
        boolean bhJ;
        boolean z2;
        boolean z3 = true;
        if (bi.oN(str)) {
            str = walletBaseUI.getString(i.vdG);
        }
        if (kVar instanceof h) {
            bhJ = ((h) kVar).bhJ();
        } else {
            bhJ = true;
        }
        if (kVar instanceof com.tencent.mm.wallet_core.c.f) {
            z2 = ((com.tencent.mm.wallet_core.c.f) kVar).fIo;
        } else {
            z2 = bhJ;
        }
        x.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), kVar);
        if (!((kVar instanceof m) || (kVar instanceof b))) {
            if (kVar instanceof h) {
                h hVar = (h) kVar;
                Bundle bundle;
                if (hVar.zQB == null ? false : "1".equals(hVar.zQB.trim())) {
                    x.d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    bundle = walletBaseUI.vf;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", hVar.zQC);
                    bundle.putString("intent_wap_pay_jump_url", hVar.zQD);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                } else if ((kVar instanceof l) && ((l) kVar).sLK) {
                    x.i("MicroMsg.WalletDispatcher", "delay order pay end");
                    bundle = walletBaseUI.vf;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", hVar.zQC);
                    bundle.putString("intent_wap_pay_jump_url", hVar.zQD);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                }
                if (z2 && com.tencent.mm.wallet_core.d.h.a(walletBaseUI, kVar, i, i2, str) && !hVar.bLw()) {
                    bhJ = false;
                } else {
                    bhJ = true;
                }
                if (!bhJ) {
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.cCT() == null || !walletBaseUI.cCU().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, (h) kVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        x.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        lPV = i;
                        lPJ = i2;
                        jfR = str;
                        x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if ((walletBaseUI.cCT() == null || !walletBaseUI.cCU().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, kVar) && z2) {
                if (i == 0 && i2 == 0) {
                    x.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    lPV = i;
                    lPJ = i2;
                    jfR = str;
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            x.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", Boolean.valueOf(z2));
            if (lPJ != 0) {
                x.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lPJ);
                if (kVar instanceof h) {
                    final String cCg = ((h) kVar).cCg();
                    if (!bi.oN(cCg)) {
                        x.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xRr, jfR, null, walletBaseUI.getResources().getString(i.uXY), walletBaseUI.getResources().getString(i.dGf), true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f.c(walletBaseUI);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", cCg);
                                d.b(walletBaseUI.mController.xRr, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                e.HX(3);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f.c(walletBaseUI);
                            }
                        });
                        cCR();
                        e.HX(4);
                        if (z3) {
                            x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                            com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xRr, jfR, null, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    f.c(walletBaseUI);
                                }
                            });
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                    com.tencent.mm.ui.base.h.a(walletBaseUI.mController.xRr, jfR, null, false, /* anonymous class already generated */);
                }
            } else if (!walletBaseUI.aYO()) {
                walletBaseUI.uV(0);
            }
        }
    }

    public static void cCR() {
        lPV = 0;
        lPJ = 0;
        jfR = null;
    }
}
