package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.f.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.y.q;

@a(7)
public class WalletIapUI extends MMActivity implements e {
    private Dialog jRG;
    private c plr = new c<st>() {
        {
            this.xmG = st.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            st stVar = (st) bVar;
            x.i("MicroMsg.WalletIapUI", "payListener callback to close progress");
            if (stVar instanceof st) {
                if (WalletIapUI.this.jRG != null && WalletIapUI.this.jRG.isShowing()) {
                    WalletIapUI.this.jRG.dismiss();
                    WalletIapUI.this.jRG = null;
                }
                return true;
            }
            x.f("MicroMsg.WalletIapUI", "mismatched event");
            return false;
        }
    };
    private boolean thG = false;
    private b thH;
    private d thI = new d() {
        public final void a(com.tencent.mm.plugin.wallet_index.c.a aVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
            x.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + aVar + ", purchase: " + cVar);
            if (WalletIapUI.this.thH instanceof a) {
                if (cVar != null) {
                    p.c(cVar.tgG, cVar.lEs, cVar.tgM, aVar.nFO, aVar.mMessage);
                } else {
                    a aVar2 = (a) WalletIapUI.this.thH;
                    p.c(aVar2.thi, aVar2.lEs, aVar2.tgM, aVar.nFO, aVar.mMessage);
                }
            }
            Intent intent;
            if (aVar.isFailure()) {
                x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + aVar.nFO + " , errMsg: " + aVar.mMessage);
                intent = new Intent();
                intent.putExtra("key_err_code", aVar.nFO);
                intent.putExtra("key_err_msg", aVar.mMessage);
                intent.putExtra("key_launch_ts", a.the);
                intent.putExtra("key_gw_error_code", aVar.tgN);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
            } else if (aVar.bOa()) {
                x.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                WalletIapUI.this.thH.c(WalletIapUI.this, false);
            } else if (cVar != null) {
                x.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + cVar.lEs + ",billNo:" + cVar.tgJ);
                g.Dr();
                g.Dp().gRu.a(WalletIapUI.this.thd.a(cVar, false), 0);
            } else {
                intent = new Intent();
                com.tencent.mm.plugin.wallet_index.c.a.aR(6, "");
                intent.putExtra("key_err_code", aVar.nFO);
                intent.putExtra("key_err_msg", aVar.mMessage);
                intent.putExtra("key_launch_ts", a.the);
                intent.putExtra("key_gw_error_code", aVar.tgN);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
            }
        }
    };
    private c thd;
    private d thf = new d() {
        public final void a(com.tencent.mm.plugin.wallet_index.c.a aVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
            x.d("MicroMsg.WalletIapUI", "Consume finished: " + aVar + ", purchase: " + cVar);
            if (aVar.isFailure()) {
                x.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                x.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", aVar.nFO);
            intent.putExtra("key_err_msg", aVar.mMessage);
            intent.putStringArrayListExtra("key_response_product_ids", WalletIapUI.this.thd.thl);
            intent.putStringArrayListExtra("key_response_series_ids", WalletIapUI.this.thd.thm);
            intent.putExtra("key_launch_ts", a.the);
            WalletIapUI.this.setResult(-1, intent);
            WalletIapUI.this.finish();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.v("MicroMsg.WalletIapUI", "onCreate");
        g.Dr();
        g.Dp().gRu.a(422, (e) this);
        g.Dr();
        g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, (e) this);
        g.Dr();
        g.Dp().gRu.a(1130, (e) this);
        g.Dr();
        g.Dp().gRu.a(1306, (e) this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            this.jRG = com.tencent.mm.wallet_core.ui.g.a(this, getString(i.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    WalletIapUI.this.setResult(0);
                    WalletIapUI.this.finish();
                }
            });
        }
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_mini_program", false);
        this.thd = new c();
        this.thd.thq = booleanExtra;
        if (getIntent().getBooleanExtra("key_force_google", false) || q.Gk()) {
            x.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.thH = new a(this, this.thd, this.thf);
        } else {
            x.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.thH = new f(this.thd, this.plr);
        }
        this.thd.pil = this.thH.bOb();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        x.d("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        x.d("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.thG) {
            this.thG = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                x.d("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.thH.c(this, true);
                return;
            }
            c cVar = this.thd;
            String stringExtra = intent.getStringExtra("key_product_id");
            cVar.lEs = stringExtra;
            cVar.thp.add(stringExtra);
            x.d("MicroMsg.IapData", "prepare pay product: " + stringExtra);
            this.thd.tgM = intent.getStringExtra("key_price");
            this.thd.tgL = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.thd.mCount = intent.getIntExtra("key_count", 1);
            stringExtra = intent.getStringExtra("key_appid");
            String stringExtra3 = intent.getStringExtra("key_desc");
            String stringExtra4 = intent.getStringExtra("key_busiid");
            this.thd.thr = intent.getStringExtra("key_virtual_pay_sign");
            this.thd.ths = intent.getStringExtra("key_attach");
            g.Dr();
            n nVar = g.Dp().gRu;
            c cVar2 = this.thd;
            int bOb = this.thH.bOb();
            nVar.a(cVar2.thq ? new d(bOb, stringExtra, cVar2.tgM, stringExtra3, cVar2.mCount, cVar2.tgL, stringExtra4, cVar2.thr, cVar2.ths) : new j(cVar2.lEs, cVar2.tgM, cVar2.tgL, cVar2.mCount, bOb, stringExtra2), 0);
        }
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        x.d("MicroMsg.WalletIapUI", "onDestroy");
        if (this.jRG != null && this.jRG.isShowing()) {
            this.jRG.dismiss();
            this.jRG = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : " + i2);
        if (this.thH != null) {
            this.thH.a((MMActivity) this, i, i2, intent);
            x.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            return;
        }
        x.e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(6, "");
        intent2.putExtra("key_err_code", aR.nFO);
        intent2.putExtra("key_err_msg", aR.mMessage);
        intent2.putExtra("key_launch_ts", a.the);
        setResult(-1, intent2);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        alo alo = null;
        boolean z = true;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd ErrType:" + i + ", errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(i2, str);
        int i3 = aR.nFO;
        String str2 = aR.mMessage;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + kVar.getType() + " errCode:" + i3 + ",errMsg:" + str2);
        int type = kVar.getType();
        Intent intent;
        switch (type) {
            case com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX /*414*/:
            case 1306:
                boolean z2;
                c cVar = this.thd;
                if (kVar instanceof com.tencent.mm.wallet_core.c.k) {
                    com.tencent.mm.wallet_core.c.k kVar2 = (com.tencent.mm.wallet_core.c.k) kVar;
                    cVar.lEs = kVar2.lEs;
                    cVar.thn = kVar2.lEu;
                    cVar.tho = kVar2.tho;
                    z2 = false;
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.g) {
                    com.tencent.mm.plugin.wallet_index.c.g gVar = (com.tencent.mm.plugin.wallet_index.c.g) kVar;
                    cVar.lEs = gVar.frQ;
                    z2 = gVar.errCode == 0;
                } else {
                    z2 = false;
                }
                cVar.thp.remove(cVar.lEs);
                if (z2) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lEs + " OK");
                    cVar.thl.add(cVar.lEs);
                    cVar.thm.add(cVar.thn);
                } else if (!cVar.lEs.startsWith("com.tencent.xin.wco")) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lEs + " fail");
                } else if (cVar.tho > 0) {
                    cVar.thl.add(cVar.lEs);
                    cVar.thm.add(cVar.thn);
                    x.i("MicroMsg.IapData", "Verify " + cVar.lEs + " fail and cosume");
                    if (this.thd.thp.isEmpty()) {
                        x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                        if (this.thd.thl.isEmpty()) {
                            x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.thd.thl.size() + ", Consume ...");
                            this.thH.a((MMActivity) this, this.thd.thl, this.thf, z);
                            return;
                        }
                        x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", a.the);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    return;
                } else {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lEs + " fail");
                }
                z = false;
                if (this.thd.thp.isEmpty()) {
                    x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                    if (this.thd.thl.isEmpty()) {
                        x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", a.the);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.thd.thl.size() + ", Consume ...");
                    this.thH.a((MMActivity) this, this.thd.thl, this.thf, z);
                    return;
                }
                return;
            case 422:
            case 1130:
                c cVar2 = this.thd;
                com.tencent.mm.plugin.wallet_index.c.a aR2 = com.tencent.mm.plugin.wallet_index.c.a.aR(i3, str2);
                type = aR2.nFO;
                if (kVar instanceof j) {
                    j jVar = (j) kVar;
                    if (type == 0) {
                        aza aza;
                        if (cVar2.bOc()) {
                            alp alp;
                            aza = (aza) jVar.gLB.hnR.hnY;
                            if (aza != null) {
                                alp alp2 = new alp();
                                alp2.wzy = aza.wMB;
                                alp2.wzz = aza.wMC;
                                alp2.fDQ = 5;
                                alp2.wzA = aza.wMD;
                                x.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + aza.wMD);
                                alp = alp2;
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
                                alp = null;
                            }
                            cVar2.tgR = alp;
                        } else {
                            aza = (aza) jVar.gLB.hnR.hnY;
                            if (aza != null) {
                                alo = new alo();
                                alo.wpq = jVar.tgL;
                                alo.pjS = jVar.lEs;
                                alo.pht = jVar.tgM;
                                alo.wzu = aza.wMA;
                                x.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + aza.wMA);
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
                            }
                            cVar2.tgQ = alo;
                        }
                    }
                } else if (kVar instanceof d) {
                    d dVar = (d) kVar;
                    if (type == 0 && dVar.errCode == 0) {
                        cVar2.tgR = dVar.tgR;
                        cVar2.tgQ = dVar.tgQ;
                        if (cVar2.bOc()) {
                            if (cVar2.tgR != null) {
                                cVar2.thi = cVar2.tgR.wzu;
                            } else {
                                x.e("MicroMsg.IapData", "iapWxPayData is null");
                            }
                        } else if (cVar2.tgQ != null) {
                            cVar2.thi = cVar2.tgQ.wzu;
                        } else {
                            x.e("MicroMsg.IapData", "iapGoogleData is null");
                        }
                    }
                }
                if (aR2.nFO == 0) {
                    this.thH.a(this, this.thI);
                    return;
                }
                x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + aR2.nFO + " , errMsg: " + aR2.mMessage);
                intent = new Intent();
                intent.putExtra("key_err_code", aR2.nFO);
                intent.putExtra("key_err_msg", aR2.mMessage);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                return;
            default:
                x.w("MicroMsg.WalletIapUI", "get a wrong sceneType : " + type);
                return;
        }
    }

    public void finish() {
        x.i("MicroMsg.WalletIapUI", "finish");
        if (this.jRG != null && this.jRG.isShowing()) {
            this.jRG.dismiss();
            this.jRG = null;
        }
        if (this.thH != null) {
            this.thH.g(this);
        }
        g.Dr();
        g.Dp().gRu.b(422, (e) this);
        g.Dr();
        g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, (e) this);
        g.Dr();
        g.Dp().gRu.b(1130, (e) this);
        g.Dr();
        g.Dp().gRu.b(1306, (e) this);
        super.finish();
    }
}
