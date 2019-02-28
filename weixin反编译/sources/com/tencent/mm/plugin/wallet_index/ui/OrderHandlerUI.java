package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class OrderHandlerUI extends MMActivity implements e {
    private String fvC;
    private int itU = 0;
    private String kBe;
    private long kBf = 0;
    private Options options;
    private c plr = new c<tb>() {
        {
            this.xmG = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tb tbVar = (tb) bVar;
            if (tbVar instanceof tb) {
                OrderHandlerUI.this.thv = true;
                x.e("MicroMsg.OrderHandlerUI", "onPayEnd, isOk = %s notifyPay %s", Integer.valueOf(tbVar.fMn.result), Boolean.valueOf(OrderHandlerUI.this.thx));
                if (!OrderHandlerUI.this.thx) {
                    if (bi.oN(tbVar.fMn.fvC) || tbVar.fMn.fvC.equals(OrderHandlerUI.this.fvC)) {
                        if (tbVar.fMn.result == -1) {
                            Bundle extras = tbVar.fMn.intent.getExtras();
                            String string = extras.getString("intent_pay_app_url");
                            OrderHandlerUI.this.thw = extras.getString("intent_wap_pay_jump_url");
                            x.d("MicroMsg.OrderHandlerUI", "onPayEnd, returnUrl = " + string);
                            OrderHandlerUI.this.thu.errCode = 0;
                            OrderHandlerUI.this.thu.returnKey = string;
                        } else {
                            OrderHandlerUI.this.thu.errCode = -2;
                        }
                        if (OrderHandlerUI.this.itU == 1) {
                            OrderHandlerUI.aJ(OrderHandlerUI.this, OrderHandlerUI.this.thw);
                        } else {
                            e.a(OrderHandlerUI.this, OrderHandlerUI.this.kBe, OrderHandlerUI.this.thu, OrderHandlerUI.this.options);
                        }
                        OrderHandlerUI.this.thx = true;
                        OrderHandlerUI.this.finish();
                    } else {
                        x.e("MicroMsg.OrderHandlerUI", "pass notify this req1 %s req2 %s", tbVar.fMn.fvC, OrderHandlerUI.this.fvC);
                    }
                }
            } else {
                x.f("MicroMsg.OrderHandlerUI", "mismatched event");
            }
            return false;
        }
    };
    private PayReq tht;
    private PayResp thu;
    private boolean thv = false;
    private String thw = "";
    private boolean thx = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBf = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        uV(8);
        p.cCn();
        com.tencent.mm.sdk.b.a.xmy.b(this.plr);
    }

    protected void onResume() {
        Throwable e;
        k eVar;
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.tht == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.tht.prepayId))) {
            this.tht = payReq;
            this.itU = getIntent().getIntExtra("key_scene", 0);
            x.i("MicroMsg.OrderHandlerUI", "onCreate() mScene is " + this.itU);
            if (this.itU == 0) {
                this.kBe = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (this.kBe == null || this.kBe.length() == 0) {
                    x.e("MicroMsg.OrderHandlerUI", "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    return;
                }
            }
            this.options = new Options();
            this.options.fromBundle(getIntent().getExtras());
            this.thu = new PayResp();
            this.thu.prepayId = payReq.prepayId;
            this.thu.extData = payReq.extData;
            String str = "";
            if (this.itU == 0) {
                if (!payReq.checkArgs()) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, PayReq checkArgs fail");
                    this.thu.errCode = -1;
                    this.thu.errStr = getString(i.uSI);
                    e.a(this, this.kBe, this.thu, this.options);
                    finish();
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, checkAppResult fail");
                    this.thu.errCode = -1;
                    e.a(this, this.kBe, this.thu, this.options);
                    finish();
                    return;
                }
            } else if (this.itU == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] aX = com.tencent.mm.pluginsdk.model.app.p.aX(this, stringExtra);
                    if (aX == null || aX.length == 0) {
                        x.e("MicroMsg.AppUtil", "signs is null");
                        str2 = null;
                    } else {
                        str2 = g.s(aX[0].toByteArray());
                    }
                    str3 = str2;
                    str2 = str4;
                } catch (Throwable e2) {
                    Throwable th = e2;
                    str2 = str4;
                    e = th;
                }
            } catch (NameNotFoundException e3) {
                e = e3;
                x.printErrStackTrace("MicroMsg.OrderHandlerUI", e, "", new Object[0]);
                x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(397, (e) this);
                eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(eVar, 0);
            }
            x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(397, (e) this);
            eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(eVar, 0);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(397, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.plr);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJJ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 397) {
            PayInfo payInfo = new PayInfo();
            if (this.itU == 1) {
                payInfo.fDQ = 36;
            } else {
                payInfo.fDQ = 2;
            }
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b(397, (e) this);
            x.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.e eVar = (com.tencent.mm.plugin.wallet_index.c.e) kVar;
            awp awp = (awp) eVar.gLB.hnR.hnY;
            this.thw = awp == null ? null : awp.wKM;
            int i3;
            String str2;
            if (i == 4 && i2 == -5) {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
                this.thu.errCode = -1;
                aN(str, true);
                i3 = payInfo.fDQ;
                if (this.tht == null) {
                    str2 = "";
                } else {
                    str2 = this.tht.prepayId;
                }
                t.j(i3, str2, i2);
            } else if (i == 0 && i2 == 0) {
                awp = (awp) eVar.gLB.hnR.hnY;
                i3 = awp == null ? -1 : awp.lUc;
                awp = (awp) eVar.gLB.hnR.hnY;
                String str3 = awp == null ? null : awp.lUd;
                awp = (awp) eVar.gLB.hnR.hnY;
                String str4 = awp == null ? null : awp.wov;
                awp = (awp) eVar.gLB.hnR.hnY;
                x.d("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", Integer.valueOf(i3), str3, str4, awp == null ? null : awp.wow);
                if (bi.oN(str4)) {
                    x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
                    this.thu.errCode = -1;
                    aN(str, true);
                    return;
                }
                t.j(payInfo.fDQ, str4, i2);
                payInfo.appId = this.tht.appId;
                payInfo.fvC = str4;
                payInfo.partnerId = this.tht.partnerId;
                payInfo.tgP = str2;
                payInfo.vGk = String.valueOf(i3);
                payInfo.foE = str3;
                if (this.kBf > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 1, 1, true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 2, bi.bA(this.kBf), true);
                    if (payInfo.vGl == null) {
                        payInfo.vGl = new Bundle();
                    }
                    payInfo.vGl.putLong("wallet_pay_key_check_time", this.kBf);
                }
                this.fvC = payInfo.fvC;
                h.a((Context) this, payInfo, 123);
                this.thv = false;
            } else {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
                this.thu.errCode = -1;
                aN(str, true);
                t.j(payInfo.fDQ, this.tht == null ? "" : this.tht.prepayId, i2);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.thu != null && !this.thv) {
            x.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
            this.thu.errCode = -2;
            aN("", false);
        }
    }

    private void aN(String str, boolean z) {
        if (this.itU != 1) {
            e.a(this, this.kBe, this.thu, this.options);
            finish();
        } else if (TextUtils.isEmpty(this.thw) && z) {
            uV(0);
            if (TextUtils.isEmpty(str)) {
                str = getString(i.vdG);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    OrderHandlerUI.this.finish();
                }
            });
        } else {
            aJ(this, this.thw);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
    }

    private static void aJ(Context context, String str) {
        if (context == null) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        } else {
            x.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bi.k(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
