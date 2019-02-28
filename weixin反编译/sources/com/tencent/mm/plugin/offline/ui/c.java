package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    Vibrator kJP;
    Activity mActivity;
    a pdj;
    n pdk;
    float pdl = 0.0f;
    int pdm = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ g pdp;

        AnonymousClass11(g gVar) {
            this.pdp = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (c.this.pdj != null) {
                c.this.pdj.o(1, this.pdp.id, "");
            }
            x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$15 */
    class AnonymousClass15 implements a {
        final /* synthetic */ g pdp;

        AnonymousClass15(g gVar) {
            this.pdp = gVar;
        }

        public final void bhU() {
            if (c.this.pdj != null) {
                c.this.pdj.o(0, this.pdp.id, "");
            }
            com.tencent.mm.plugin.offline.g.bT(this.pdp.fxT, com.tencent.mm.plugin.offline.g.pbd);
            x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$1 */
    class AnonymousClass1 extends com.tencent.mm.sdk.b.c<tb> {
        final /* synthetic */ PayInfo pdn;

        AnonymousClass1(PayInfo payInfo) {
            this.pdn = payInfo;
            this.xmG = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tb tbVar = (tb) bVar;
            com.tencent.mm.sdk.b.a.xmy.c(this);
            if (tbVar.fMn.result == 0) {
                k cVar = new com.tencent.mm.plugin.offline.a.c(this.pdn.fvC, this.pdn.fDQ, this.pdn.fDM);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(cVar, 0);
                com.tencent.mm.plugin.offline.g.bhz();
                c.this.pdj.bhR();
            } else if (tbVar.fMn.result == -1) {
                com.tencent.mm.plugin.offline.g.bhz();
                c.this.pdj.bhR();
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$13 */
    class AnonymousClass13 implements com.tencent.mm.plugin.wallet_core.ui.n.c {
        final /* synthetic */ g pdp;

        AnonymousClass13(g gVar) {
            this.pdp = gVar;
        }

        public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
            if (c.this.mActivity instanceof MMActivity) {
                ((MMActivity) c.this.mActivity).aWY();
            }
            if (c.this.pdj != null) {
                c.this.pdj.o(1, this.pdp.id, str);
            }
            x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$12 */
    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ g pdp;

        AnonymousClass12(g gVar) {
            this.pdp = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (c.this.pdj != null) {
                c.this.pdj.o(0, this.pdp.id, "");
            }
            com.tencent.mm.plugin.offline.g.bT(this.pdp.fxT, com.tencent.mm.plugin.offline.g.pbd);
            x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    static /* synthetic */ void a(c cVar) {
        x.i("MicroMsg.OfflineLogicMgr", "closeOffline");
        if (cVar.pdj != null) {
            cVar.pdj.bhP();
        }
    }

    public c(Activity activity, a aVar) {
        this.mActivity = activity;
        this.pdj = aVar;
    }

    public final void a(k kVar, int i, String str) {
        a(kVar, i, str, null);
    }

    public final void a(k kVar, int i, String str, String str2) {
        x.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        bhS();
        if (i == 409) {
            x.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + str);
            h.a(this.mActivity, str, "", getString(i.vev), getString(i.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.pluginsdk.wallet.h.X(c.this.mActivity, 0);
                    x.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == JsApiBatchGetContact.CTRL_INDEX) {
            x.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + str);
            h.a(this.mActivity, str, "", getString(i.vaV), getString(i.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.pluginsdk.wallet.h.X(c.this.mActivity, 0);
                    x.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 413) {
            x.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + str);
            h.a(this.mActivity, str, "", getString(i.vee), getString(i.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    c.this.pdj.bhO();
                    x.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 411) {
            if (o.bMc().bMv() || o.bMc().bMz()) {
                x.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                return;
            }
            if (com.tencent.mm.plugin.offline.k.pbH && (this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = (WalletOfflineCoinPurseUI) this.mActivity;
                walletOfflineCoinPurseUI.pdK.setVisibility(4);
                walletOfflineCoinPurseUI.pdZ.a(walletOfflineCoinPurseUI.pdC, new View.OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.biy();
                        com.tencent.mm.plugin.offline.c.a.h(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.kKY);
                        WalletOfflineCoinPurseUI.this.finish();
                    }
                }, 6);
            } else {
                com.tencent.mm.plugin.offline.c.a.c(this.mActivity, str);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(135, 1, 1, true);
        } else if (!(this.mActivity instanceof WalletBaseUI)) {
            b.b(this.mActivity, str);
        } else if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI) this.mActivity, kVar, 1000, i, str)) {
            String string;
            Context context = this.mActivity;
            if (TextUtils.isEmpty(str)) {
                string = context.getString(i.vdG);
            } else {
                string = str;
            }
            if (bi.oN(str2)) {
                b.b(context, string);
                return;
            }
            x.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            h.a(context, string, null, context.getResources().getString(i.uXY), context.getResources().getString(i.dGf), true, new com.tencent.mm.plugin.offline.ui.b.AnonymousClass2(str2, context), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + kVar.getType());
        e eVar;
        if (i == 0 && i2 == 0) {
            if (!(kVar instanceof e)) {
                return false;
            }
            eVar = (e) kVar;
            String str2 = eVar.pbT;
            bhS();
            if (eVar.pbU != 0 || TextUtils.isEmpty(str2)) {
                if (!(eVar.pbU == 0 || eVar.lot == 0 || eVar.pbW != 1)) {
                    x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                    a(eVar, eVar.pbU, eVar.pbV);
                }
                return true;
            }
            com.tencent.mm.plugin.offline.c.a.a(this.mActivity, str2, kVar);
            this.mActivity.setResult(-1);
            this.mActivity.finish();
            return true;
        } else if (!(kVar instanceof e)) {
            return false;
        } else {
            eVar = (e) kVar;
            bhS();
            if (eVar.pbW == 1) {
                x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(kVar, i2, str);
            }
            return true;
        }
    }

    public final void bhS() {
        if (this.pdk != null) {
            this.pdk.dismiss();
            this.pdk = null;
        }
    }

    public final void a(s.b bVar) {
        if (bVar != null) {
            x.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
            if ("1".equals(bVar.pcK)) {
                h.a(this.mActivity, false, bVar.pcM, "", getString(i.vep), getString(i.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.tencent.mm.plugin.offline.c.a.D(c.this.mActivity);
                        x.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        c.this.mActivity.finish();
                    }
                });
            }
        }
    }

    public static boolean bhT() {
        com.tencent.mm.plugin.offline.k.bhD();
        if (com.tencent.mm.plugin.offline.k.bhE().pcG != null) {
            return true;
        }
        return false;
    }

    final String getString(int i) {
        return this.mActivity.getString(i);
    }
}
