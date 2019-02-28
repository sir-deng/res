package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.st;
import com.tencent.mm.f.a.ta;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.f.a.ti;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.a.c.d;
import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUI extends WalletBaseUI implements com.tencent.mm.plugin.wallet.pay.ui.a.a {
    private static boolean sLH = false;
    public int mCount = 0;
    public String mFy = null;
    protected com.tencent.mm.plugin.wallet.a pRC = null;
    private String pRV;
    private c pTY = new c<ti>() {
        {
            this.xmG = ti.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.WalletPayUI", "WalletRealNameResultNotifyMoreEvent %s", Integer.valueOf(((ti) bVar).fME.result));
            if (((ti) bVar).fME.result == -1) {
                WalletPayUI.this.sMo = true;
                WalletPayUI.this.sMp = true;
                WalletPayUI.this.bKS();
            }
            return false;
        }
    };
    public Button pTn;
    public Orders pVi = null;
    public n sFl;
    public ArrayList<Bankcard> sFo = null;
    public Bankcard sFp = null;
    private com.tencent.mm.plugin.wallet.pay.a.c sKK = null;
    public PayInfo sKT = null;
    public FavorPayInfo sKV = null;
    private a sKW;
    com.tencent.mm.plugin.wallet_core.ui.c sKX;
    protected com.tencent.mm.plugin.wallet_core.ui.a sLI = null;
    private boolean sLJ = false;
    private boolean sLK = false;
    public boolean sLL = false;
    protected boolean sLM = false;
    protected String sLN = "";
    protected boolean sLO = false;
    public Bundle sLP = null;
    protected boolean sLQ = false;
    protected TextView sLR;
    protected TextView sLS;
    private TextView sLT;
    protected TextView sLU;
    protected TextView sLV;
    protected TextView sLW;
    protected ImageView sLX;
    private TextView sLY;
    private TextView sLZ;
    protected LinearLayout sMa;
    protected a sMb;
    private long sMc = 0;
    private TextView sMd;
    private LinearLayout sMe;
    private boolean sMf = true;
    private boolean sMg = false;
    private boolean sMh = false;
    private boolean sMi = false;
    private boolean sMj = false;
    private int sMk = -1;
    private boolean sMl = false;
    private boolean sMm = false;
    private e sMn;
    private boolean sMo = false;
    private boolean sMp = false;
    private long sMq = 0;

    protected class a {
        protected a() {
        }

        public final void notifyDataSetChanged() {
            WalletPayUI.this.sMa.removeAllViews();
            int i = WalletPayUI.this.mCount == 0 ? 0 : WalletPayUI.this.sLO ? WalletPayUI.this.mCount : 1;
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            for (int i2 = 0; i2 < i; i2++) {
                View inflate = ((LayoutInflater) WalletPayUI.this.getSystemService("layout_inflater")).inflate(g.uMd, null);
                TextView textView = (TextView) inflate.findViewById(f.uFM);
                TextView textView2 = (TextView) inflate.findViewById(f.uGe);
                Commodity commodity = (Commodity) WalletPayUI.this.pVi.sUf.get(i2);
                Object obj = "";
                if (WalletPayUI.this.sKT != null && (WalletPayUI.this.sKT.fDQ == 32 || WalletPayUI.this.sKT.fDQ == 33 || WalletPayUI.this.sKT.fDQ == 31 || WalletPayUI.this.sKT.fDQ == 48)) {
                    String string = WalletPayUI.this.sKT.vGl.getString("extinfo_key_1", "");
                    if (bi.oN(string)) {
                        x.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    } else {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.storage.x Xt = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xt(string);
                        if (Xt != null) {
                            obj = Xt.AX();
                        } else {
                            x.e("MicroMsg.WalletPayUI", "can not found contact for user::" + string);
                        }
                    }
                }
                if (commodity != null) {
                    if (!bi.oN(obj)) {
                        textView2.setText(obj);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(f.uGf)).setVisibility(0);
                    } else if (bi.oN(commodity.pfU)) {
                        ((TextView) inflate.findViewById(f.uGf)).setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(commodity.pfU);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(f.uGf)).setVisibility(0);
                    }
                    if (bi.oN(commodity.desc)) {
                        ((TextView) inflate.findViewById(f.uFO)).setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(f.uFO)).setVisibility(8);
                    }
                    if (bi.oN(obj) && bi.oN(commodity.pfU)) {
                        inflate.setVisibility(8);
                    } else {
                        inflate.setVisibility(0);
                    }
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                WalletPayUI.this.sMa.addView(inflate);
            }
        }
    }

    static /* synthetic */ void f(WalletPayUI walletPayUI) {
        Bundle bundle = new Bundle();
        if (walletPayUI.pVi != null) {
            bundle.putString("key_reqKey", walletPayUI.pVi.fvC);
            if (walletPayUI.pVi.sUf != null && walletPayUI.pVi.sUf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.pVi.sUf.get(0)).fvD);
            }
            bundle.putLong("key_SessionId", walletPayUI.sMc);
        }
        if (walletPayUI.sKT != null) {
            bundle.putInt("key_scene", walletPayUI.sKT.fDQ);
        }
        if (walletPayUI.sKT == null || walletPayUI.sKT.fDQ != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putBoolean("key_is_oversea", !walletPayUI.bKX());
        com.tencent.mm.wallet_core.a.a((Activity) walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (sLH) {
            x.w("MicroMsg.WalletPayUI", "has Undestory WalletPayUI!");
            finish();
        }
        sLH = true;
        if (com.tencent.mm.kernel.g.Do().CF()) {
            getWindow().getDecorView().postDelayed(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.WalletPayUI", "auto reset create flag");
                    WalletPayUI.sLH = false;
                }
            }, 600);
            this.sMq = bi.Wy();
            com.tencent.mm.sdk.b.a.xmy.b(this.pTY);
            i.i(this, 5);
            this.pRC = com.tencent.mm.plugin.wallet.a.X(getIntent());
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.vbC);
            this.sKT = bLe();
            this.sLM = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.sLN = bi.aD(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.pRV = getIntent().getStringExtra("key_receiver_true_name");
            if (this.sKT == null || this.sKT.vGn == 0) {
                this.sMc = System.currentTimeMillis();
            } else {
                this.sMc = this.sKT.vGn;
            }
            p.bKx();
            if (!p.bKy().bMy()) {
                t.d(this.sKT == null ? 0 : this.sKT.fDQ, this.sKT == null ? "" : this.sKT.fvC, 1, "");
            }
            if (bKR()) {
                x.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
                finish();
                return;
            }
            x.d("MicroMsg.WalletPayUI", "PayInfo = " + this.sKT);
            if (this.sKT == null || bi.oN(this.sKT.fvC)) {
                String string;
                if (this.sKT == null || bi.oN(this.sKT.foE)) {
                    string = getString(com.tencent.mm.plugin.wxpay.a.i.vbx);
                } else {
                    string = this.sKT.foE;
                }
                com.tencent.mm.ui.base.h.a((Context) this, string, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletPayUI.this.finish();
                    }
                });
            } else {
                bKS();
            }
            initView();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
        finish();
    }

    private boolean bKR() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                x.d("MicroMsg.WalletPayUI", "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                c(-1, getIntent());
                this.sLK = true;
                return true;
            }
            x.d("MicroMsg.WalletPayUI", "pay cancel");
            c(0, getIntent());
            this.sLK = false;
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay not end");
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    return true;
                default:
                    return false;
            }
        }
    }

    public void onDestroy() {
        if (this.sKW != null) {
            this.sKW.bKF();
            this.sKW.release();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.pTY);
        this.sKX = null;
        sLH = false;
        super.onDestroy();
    }

    public void bKS() {
        int i;
        k kVar;
        int i2 = 2;
        com.tencent.mm.plugin.report.service.g.pWK.h(11850, Integer.valueOf(2), Integer.valueOf(this.sKT.fDQ));
        if (this.sKT.fDQ == 11) {
            i = 3;
            if (com.tencent.mm.plugin.wallet.b.a.bLr()) {
                this.pVi = new Orders();
                Commodity commodity = new Commodity();
                commodity.pfU = getString(com.tencent.mm.plugin.wxpay.a.i.uVQ);
                this.pVi.sUf.add(commodity);
                this.pVi.pTQ = this.sKT.vGs;
                this.pVi.pgf = "CNY";
                jJ(true);
                this.sLQ = true;
                return;
            }
        }
        i = 2;
        PayInfo payInfo = this.sKT;
        if (payInfo == null || bi.oN(payInfo.fvC)) {
            x.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            kVar = null;
        } else {
            String str = payInfo.fvC;
            x.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", str);
            x.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.c.a(payInfo, i) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.c.g(payInfo, i) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.c.b(payInfo, i) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.c.c(payInfo, i) : str.startsWith("sns_") ? new com.tencent.mm.plugin.wallet.pay.a.c.f(payInfo, i) : str.startsWith("offline_") ? new d(payInfo, i) : new e(payInfo, i);
        }
        if (kVar != null) {
            boolean z;
            kVar.gQd = "PayProcess";
            kVar.mmh = this.sMc;
            if (this.sKT.fDQ == 6 && this.sKT.vGi == 100) {
                kVar.itU = 100;
            } else {
                kVar.itU = this.sKT.fDQ;
            }
            if (this.sKT.vGj) {
                z = true;
            } else {
                z = false;
            }
            super.cCV();
            if (z) {
                i2 = 1;
            }
            this.zSi.a(kVar, true, i2);
        }
    }

    public void onResume() {
        x.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", Boolean.valueOf(this.sMo));
        if (!this.zSi.aXJ()) {
            if (this.sFp == null) {
                p.bKx();
                this.sFp = p.bKy().a(null, null, bKG(), false);
            } else {
                p.bKx();
                this.sFp = p.bKy().a(null, this.sFp.field_bindSerial, bKG(), false);
            }
        }
        if (this.sMp) {
            x.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
            this.sMp = false;
        } else if (this.sLL && this.mController.contentView.getVisibility() != 0 && (this.sFl == null || !this.sFl.isShowing())) {
            x.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.sKX != null) {
            this.sKX.bNb();
        }
        super.onResume();
    }

    protected final int getLayoutId() {
        return g.uMf;
    }

    public void finish() {
        int i = 0;
        cCQ();
        if (!(this.pVi == null || this.pVi.sUf.isEmpty())) {
            getIntent().putExtra("key_trans_id", ((Commodity) this.pVi.sUf.get(0)).fvD);
        }
        if (this.sKT != null) {
            getIntent().putExtra("key_reqKey", this.sKT.fvC);
        }
        if (this.sLK) {
            if (this.pVi != null) {
                getIntent().putExtra("key_total_fee", this.pVi.pTQ);
            }
            c(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.sKT == null || this.sKT.fDQ != 8 || this.pVi == null)) {
                this.sKT.vGr = 0;
                b(com.tencent.mm.plugin.wallet.pay.a.a.a(bKW(), this.pVi, true), false);
                if (this.sKT.vGl != null) {
                    long j = this.sKT.vGl.getLong("extinfo_key_9");
                    com.tencent.mm.plugin.report.service.g.pWK.h(13956, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j));
                }
            }
            c(0, getIntent());
            setResult(0, getIntent());
            p.bKx();
            if (p.bKy().bMv()) {
                t.d(this.sKT == null ? 0 : this.sKT.fDQ, this.sKT == null ? "" : this.sKT.fvC, 18, "");
            } else {
                p.bKx();
                if (p.bKy().bMz()) {
                    if (this.sKT != null) {
                        i = this.sKT.fDQ;
                    }
                    t.d(i, this.sKT == null ? "" : this.sKT.fvC, 4, "");
                } else {
                    if (this.sKT != null) {
                        i = this.sKT.fDQ;
                    }
                    t.d(i, this.sKT == null ? "" : this.sKT.fvC, 7, "");
                }
            }
        }
        super.finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.sFl == null || this.sKT == null || !this.sKT.niF) {
            aWY();
            showDialog(1000);
        } else {
            finish();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        x.v("MicroMsg.WalletPayUI", "onNewIntent");
        setIntent(intent);
        if (!bKR()) {
            x.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            c(0, getIntent());
            this.sLK = false;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.sMg = true;
            z = true;
        }
        if (z) {
            x.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
            bKS();
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.sMh = true;
        }
        if (z2) {
            x.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
            finish();
        } else {
            x.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
    }

    private void c(int i, Intent intent) {
        b tbVar = new tb();
        tbVar.fMn.intent = intent;
        tbVar.fMn.result = i;
        tbVar.fMn.fvC = this.sKT == null ? "" : this.sKT.fvC;
        if (this.sKT != null && i == 0) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.V(this.sKT.fvC, this.sKT.fDQ, this.sKT.fDM);
        }
        com.tencent.mm.sdk.b.a.xmy.m(tbVar);
    }

    protected final void initView() {
        MMScrollView mMScrollView = (MMScrollView) findViewById(f.cYF);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.pTn = (Button) findViewById(f.uGs);
        this.pTn.setClickable(false);
        this.pTn.setEnabled(false);
        this.sLR = (TextView) findViewById(f.uGj);
        this.sLS = (TextView) findViewById(f.uGi);
        this.sLU = (TextView) findViewById(f.uFS);
        this.sLZ = (TextView) findViewById(f.uFQ);
        this.sLT = (TextView) findViewById(f.uFY);
        this.sLY = (TextView) findViewById(f.uGp);
        this.sLT.getPaint().setFlags(16);
        this.sLV = (TextView) findViewById(f.uGt);
        this.sLW = (TextView) findViewById(f.uGq);
        this.sLW.setOnClickListener(new r() {
            public final void azE() {
                WalletPayUI.this.b(false, 0, "");
            }
        });
        this.sLX = (ImageView) findViewById(f.uFN);
        this.sLX.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (WalletPayUI.this.sLO) {
                    WalletPayUI.this.sLX.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujS);
                    WalletPayUI.this.sLO = false;
                } else {
                    WalletPayUI.this.sLX.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujT);
                    WalletPayUI.this.sLO = true;
                }
                WalletPayUI.this.sMb.notifyDataSetChanged();
            }
        });
        this.sMa = (LinearLayout) findViewById(f.uFV);
        this.sMb = new a();
        this.pTn.setOnClickListener(new r() {
            public final void azE() {
                p.bKx();
                if (!p.bKy().bMz()) {
                    t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 6, "");
                }
                WalletPayUI.this.bKY();
            }
        });
        this.pTn.setText(com.tencent.mm.plugin.wxpay.a.i.vaT);
        this.sMd = (TextView) findViewById(f.uzO);
        this.sMe = (LinearLayout) findViewById(f.uzN);
        av();
    }

    public final void av() {
        boolean z;
        LinearLayout linearLayout;
        if (!(this.pVi == null || this.pVi.sUf == null || this.pVi.sUf.size() <= 0)) {
            this.sLR.setText(com.tencent.mm.wallet_core.ui.e.t(this.pVi.pTQ));
            this.sLU.setText(com.tencent.mm.wallet_core.ui.e.abi(this.pVi.pgf));
            this.sMb.notifyDataSetChanged();
            if (this.pVi.sUf.size() > 1) {
                this.sLX.setVisibility(0);
                this.sLS.setText(getString(com.tencent.mm.plugin.wxpay.a.i.vbD, new Object[]{((Commodity) this.pVi.sUf.get(0)).desc, this.pVi.sUf.size()}));
            } else {
                this.sLS.setText(((Commodity) this.pVi.sUf.get(0)).desc);
                this.sLX.setVisibility(8);
            }
            this.sLO = false;
            int i = this.pVi.sTP;
        }
        if (this.sKT != null && this.sKT.fDQ == 48) {
            this.sLS.setText(com.tencent.mm.plugin.wxpay.a.i.uTc);
        }
        this.sLV.setVisibility(8);
        this.sLW.setVisibility(8);
        this.sMd.setVisibility(8);
        this.sMe.setVisibility(8);
        this.pTn.setText(com.tencent.mm.plugin.wxpay.a.i.vaT);
        if (this.sFp == null || !this.sFp.bLB()) {
            p.bKx();
            if (p.bKy().bMv()) {
                bKT();
            }
        } else if (bi.oN(this.sFp.field_forbidWord)) {
            p.bKx();
            if (p.bKy().bMz()) {
                bKT();
            }
        } else {
            this.sLV.setText(this.sFp.field_forbidWord);
            this.sLV.setVisibility(4);
            this.sLW.setVisibility(8);
            p.bKx();
            if (p.bKy().bMz()) {
                bKT();
            }
        }
        p.bKx();
        if (!p.bKy().bMz()) {
            p.bKx();
            if (!p.bKy().bMv()) {
                z = false;
                linearLayout = (LinearLayout) findViewById(f.uFR);
                if (z || this.sKV == null || this.sLI == null || !this.sLJ || this.pVi == null) {
                    linearLayout.setVisibility(8);
                } else {
                    bKV();
                    this.sLZ.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 12, "");
                            com.tencent.mm.plugin.wallet_core.ui.i.a(WalletPayUI.this.mController.xRr, WalletPayUI.this.pVi, WalletPayUI.this.sKV.sTc, new com.tencent.mm.plugin.wallet_core.ui.i.b() {
                                public final void a(FavorPayInfo favorPayInfo) {
                                    int i = 1;
                                    WalletPayUI.this.sKV = favorPayInfo;
                                    String str = "MicroMsg.WalletPayUI";
                                    String str2 = "WalletFavorDialog onSelectionDone %s";
                                    Object[] objArr = new Object[1];
                                    objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
                                    x.i(str, str2, objArr);
                                    if (WalletPayUI.this.sKV != null) {
                                        int i2;
                                        boolean z;
                                        if (WalletPayUI.this.sKT == null) {
                                            i2 = 0;
                                        } else {
                                            i2 = WalletPayUI.this.sKT.fDQ;
                                        }
                                        if (WalletPayUI.this.sKT == null) {
                                            str = "";
                                        } else {
                                            str = WalletPayUI.this.sKT.fvC;
                                        }
                                        t.d(i2, str, 15, WalletPayUI.this.sKV.sTc);
                                        if (WalletPayUI.this.sFp == null || com.tencent.mm.plugin.wallet_core.ui.a.a(WalletPayUI.this.sKV, WalletPayUI.this.sFp)) {
                                            WalletPayUI.this.sLW.setVisibility(8);
                                            WalletPayUI.this.pTn.setOnClickListener(new View.OnClickListener() {
                                                public final void onClick(View view) {
                                                    x.i("MicroMsg.WalletPayUI", "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                                                    WalletPayUI.this.b(false, 0, "");
                                                }
                                            });
                                            z = true;
                                        } else {
                                            com.tencent.mm.plugin.wallet.a.h NN = WalletPayUI.this.sLI.NN(WalletPayUI.this.sKV.sTc);
                                            if (NN != null && WalletPayUI.this.sFp.bLB()) {
                                                p.bKx();
                                                Bankcard bankcard = p.bKy().sFY;
                                                double d = NN.sJt;
                                                if (bankcard != null && bankcard.sRo < d) {
                                                    x.i("MicroMsg.WalletPayUI", "balance not meet");
                                                    WalletPayUI.this.sLW.setVisibility(8);
                                                    WalletPayUI.this.pTn.setOnClickListener(new View.OnClickListener() {
                                                        public final void onClick(View view) {
                                                            x.i("MicroMsg.WalletPayUI", "Balance amount not meet, after favor selection! payWithNewBankcard");
                                                            WalletPayUI.this.b(false, 0, "");
                                                        }
                                                    });
                                                    z = true;
                                                }
                                            }
                                            z = false;
                                        }
                                        x.i("MicroMsg.WalletPayUI", "needBindBankCard %s", Boolean.valueOf(z));
                                        WalletPayUI.this.sMe.setVisibility(0);
                                        WalletPayUI.this.sMd.setVisibility(0);
                                        if (WalletPayUI.this.sKV != null) {
                                            WalletPayUI.this.sLI = com.tencent.mm.plugin.wallet_core.ui.b.sXj.a(WalletPayUI.this.pVi);
                                            com.tencent.mm.plugin.wallet.a.h NN2 = WalletPayUI.this.sLI.NN(WalletPayUI.this.sKV.sTc);
                                            if (NN2 != null && NN2.sJt == 0.0d) {
                                                WalletPayUI.this.sMe.setVisibility(8);
                                                WalletPayUI.this.sMd.setVisibility(8);
                                                z = false;
                                                if (!z) {
                                                    WalletPayUI.this.sLV.setVisibility(8);
                                                    WalletPayUI.this.sLW.setVisibility(0);
                                                    WalletPayUI.this.pTn.setOnClickListener(new View.OnClickListener() {
                                                        public final void onClick(View view) {
                                                            WalletPayUI.this.bKY();
                                                        }
                                                    });
                                                }
                                                if (i != 0) {
                                                    WalletPayUI.this.sLW.setVisibility(8);
                                                }
                                                WalletPayUI.this.bKV();
                                            }
                                        }
                                        i = 0;
                                        if (z) {
                                            WalletPayUI.this.sLV.setVisibility(8);
                                            WalletPayUI.this.sLW.setVisibility(0);
                                            WalletPayUI.this.pTn.setOnClickListener(/* anonymous class already generated */);
                                        }
                                        if (i != 0) {
                                            WalletPayUI.this.sLW.setVisibility(8);
                                        }
                                        WalletPayUI.this.bKV();
                                    }
                                }
                            });
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.pVi != null || this.sFo == null || this.sKT == null) {
                    this.pTn.setClickable(false);
                    this.pTn.setEnabled(false);
                } else {
                    this.pTn.setClickable(true);
                    this.pTn.setEnabled(true);
                }
                if (this.pVi == null) {
                    this.sLW.setVisibility(8);
                }
            }
        }
        z = true;
        linearLayout = (LinearLayout) findViewById(f.uFR);
        if (z) {
        }
        linearLayout.setVisibility(8);
        if (this.pVi != null) {
        }
        this.pTn.setClickable(false);
        this.pTn.setEnabled(false);
        if (this.pVi == null) {
            this.sLW.setVisibility(8);
        }
    }

    private void bKT() {
        if (this.pVi == null) {
            x.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
            return;
        }
        boolean z;
        this.sLW.setVisibility(8);
        this.sLV.setVisibility(8);
        this.pTn.setText(com.tencent.mm.plugin.wxpay.a.i.vaT);
        this.sMd.setVisibility(0);
        this.sMe.setVisibility(0);
        View findViewById = this.sMe.findViewById(f.ulq);
        View findViewById2 = this.sMe.findViewById(f.ukR);
        if ("CFT".equals(this.pVi.sUb)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        final CheckedTextView checkedTextView = (CheckedTextView) this.sMe.findViewById(f.ulm);
        final CheckedTextView checkedTextView2 = (CheckedTextView) this.sMe.findViewById(f.ukQ);
        findViewById.setEnabled(true);
        boolean z2;
        if (this.pVi == null || this.pVi.sUf == null || this.pVi.sUf.size() <= 0) {
            z2 = false;
        } else if (this.pVi.sTP == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.sFp == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    WalletPayUI.this.sMf = false;
                    WalletPayUI.this.bKU();
                }
            });
        }
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                WalletPayUI.this.sMf = true;
                WalletPayUI.this.bKU();
            }
        });
        this.sMd.setVisibility(0);
        this.sMe.setVisibility(0);
        if (this.sKV != null) {
            this.sLI = com.tencent.mm.plugin.wallet_core.ui.b.sXj.a(this.pVi);
            com.tencent.mm.plugin.wallet.a.h NN = this.sLI.NN(this.sKV.sTc);
            if (NN != null && NN.sJt == 0.0d) {
                this.sMe.setVisibility(8);
                this.sMd.setVisibility(8);
                z = true;
                this.sMf = true;
                if (z) {
                    this.sMf = false;
                }
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                x.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pVi.sUh);
                if (this.pVi.sUh != 1) {
                    this.sMe.findViewById(f.uqf).setVisibility(0);
                    ((TextView) this.sMe.findViewById(f.uqe)).setText(this.pVi.sUi);
                    if (TextUtils.isEmpty(this.pVi.sUj)) {
                        ((TextView) this.sMe.findViewById(f.uqO)).setText(" (" + this.pVi.sUj + ")");
                    } else {
                        ((TextView) this.sMe.findViewById(f.uqO)).setText("");
                    }
                    if (!(this.sFp == null || !this.sFp.bLB() || TextUtils.isEmpty(this.sFp.field_forbidWord))) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.sMe.findViewById(f.ulu)).setText(this.sFp.field_forbidWord);
                    }
                } else {
                    this.sMe.findViewById(f.uqf).setVisibility(8);
                    if (this.sFp == null && this.sFp.bLB() && !TextUtils.isEmpty(this.sFp.field_forbidWord)) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.sMe.findViewById(f.ulu)).setText(this.sFp.field_forbidWord);
                    } else if (this.sFp != null && this.sFp.bLB() && TextUtils.isEmpty(this.sFp.field_forbidWord) && !z2) {
                        checkedTextView.setChecked(true);
                        checkedTextView2.setChecked(false);
                        this.sMf = false;
                    }
                }
                bKU();
            }
        }
        z = false;
        this.sMf = true;
        if (z) {
            this.sMf = false;
        }
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        x.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pVi.sUh);
        if (this.pVi.sUh != 1) {
            this.sMe.findViewById(f.uqf).setVisibility(8);
            if (this.sFp == null) {
            }
            checkedTextView.setChecked(true);
            checkedTextView2.setChecked(false);
            this.sMf = false;
        } else {
            this.sMe.findViewById(f.uqf).setVisibility(0);
            ((TextView) this.sMe.findViewById(f.uqe)).setText(this.pVi.sUi);
            if (TextUtils.isEmpty(this.pVi.sUj)) {
                ((TextView) this.sMe.findViewById(f.uqO)).setText("");
            } else {
                ((TextView) this.sMe.findViewById(f.uqO)).setText(" (" + this.pVi.sUj + ")");
            }
            findViewById.setEnabled(false);
            checkedTextView.setVisibility(8);
            ((TextView) this.sMe.findViewById(f.ulu)).setText(this.sFp.field_forbidWord);
        }
        bKU();
    }

    private void bKU() {
        if (this.sMf) {
            this.pTn.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int i = 0;
                    p.bKx();
                    if (p.bKy().bMz()) {
                        t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 6, "");
                    }
                    if (WalletPayUI.this.pVi.sUh == 1) {
                        p.bKx();
                        if (p.bKy().bMz()) {
                            if (WalletPayUI.this.sKT != null) {
                                i = WalletPayUI.this.sKT.fDQ;
                            }
                            t.d(i, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 5, "");
                        }
                        WalletPayUI.f(WalletPayUI.this);
                        return;
                    }
                    x.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
                    p.bKx();
                    if (p.bKy().bMz()) {
                        t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 5, "");
                    }
                    WalletPayUI.this.b(false, 0, "");
                }
            });
        } else {
            this.pTn.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    WalletPayUI.this.bKY();
                }
            });
        }
    }

    public final void bKV() {
        double d;
        int i;
        com.tencent.mm.plugin.wallet.a.h NN = this.sLI.NN(this.sKV.sTc);
        List bNa = this.sLI.bNa();
        com.tencent.mm.plugin.wallet.a.f fVar = this.sLI.sXd;
        CharSequence charSequence = "";
        if (NN != null) {
            d = NN.sJB;
            if (d > 0.0d) {
                String str = NN.sJD;
                if (bi.oN(NN.sJE)) {
                    Object charSequence2 = str;
                    i = 1;
                } else {
                    charSequence2 = str + "," + NN.sJE;
                    i = 1;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && bNa.size() > 0) {
            charSequence2 = charSequence2 + this.mController.xRr.getString(com.tencent.mm.plugin.wxpay.a.i.vbU);
        }
        if (d <= 0.0d || fVar == null || fVar.sJx != 0) {
            this.sLR.setText(com.tencent.mm.wallet_core.ui.e.t(this.pVi.pTQ));
            this.sLU.setText(com.tencent.mm.wallet_core.ui.e.abi(this.pVi.pgf));
            this.sLT.setVisibility(8);
        } else {
            if (NN != null) {
                this.sLR.setText(com.tencent.mm.wallet_core.ui.e.t(NN.sJA));
            }
            this.sLU.setText(com.tencent.mm.wallet_core.ui.e.abi(this.pVi.pgf));
            this.sLT.setText(com.tencent.mm.wallet_core.ui.e.d(this.pVi.pTQ, this.pVi.pgf));
            this.sLT.setVisibility(0);
        }
        if (!bi.oN(charSequence2)) {
            this.sLZ.setText(charSequence2);
        }
    }

    public final Authen bKW() {
        Authen authen = new Authen();
        if (bKX()) {
            authen.fEo = 3;
        } else {
            authen.fEo = 6;
        }
        if (!bi.oN(this.mFy)) {
            authen.sQC = this.mFy;
        }
        if (this.sFp != null) {
            authen.pfg = this.sFp.field_bindSerial;
            authen.pff = this.sFp.field_bankcardType;
        }
        if (this.sKV != null) {
            authen.sQO = this.sKV.sTc;
            authen.sQN = this.sKV.sTf;
        }
        authen.pHW = this.sKT;
        return authen;
    }

    public final boolean bKX() {
        if (this.sFp == null || this.pVi == null || this.pVi.sOT != 3) {
            if (this.pVi == null || Bankcard.zy(this.pVi.sOT)) {
                return false;
            }
            return true;
        } else if (this.sFp.bLE()) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bKY() {
        jJ(true);
    }

    protected final void jJ(boolean z) {
        boolean z2;
        if (z) {
            if (this.pVi != null && this.pVi.sTX) {
                com.tencent.mm.kernel.g.Dr();
                if (((Boolean) com.tencent.mm.kernel.g.Dq().Db().get(196614, Boolean.valueOf(true))).booleanValue()) {
                    View inflate = getLayoutInflater().inflate(g.uMe, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(f.uDH);
                    TextView textView = (TextView) inflate.findViewById(f.czp);
                    textView.setText(Html.fromHtml(String.format(getResources().getString(com.tencent.mm.plugin.wxpay.a.i.vby), new Object[]{getResources().getString(com.tencent.mm.plugin.wxpay.a.i.uVn)})));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) inflate.findViewById(f.cSl)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            checkBox.setChecked(!checkBox.isChecked());
                        }
                    });
                    final com.tencent.mm.ui.base.i a = com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.vbz), inflate, getString(com.tencent.mm.plugin.wxpay.a.i.uXk), getString(com.tencent.mm.plugin.wxpay.a.i.vcD), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (checkBox.isChecked()) {
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(196614, Boolean.valueOf(false));
                            }
                            WalletPayUI.this.jJ(false);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPayUI.this.finish();
                        }
                    });
                    a.setCancelable(false);
                    checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Button button = a.getButton(-2);
                            if (z) {
                                button.setEnabled(false);
                            } else {
                                button.setEnabled(true);
                            }
                        }
                    });
                    z2 = false;
                    if (!z2) {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return;
            }
        }
        if (this.sKV != null) {
            this.sLI = com.tencent.mm.plugin.wallet_core.ui.b.sXj.a(this.pVi);
            com.tencent.mm.plugin.wallet.a.h NN = this.sLI.NN(this.sKV.sTc);
            if (NN != null && NN.sJt == 0.0d) {
                z2 = true;
                if (this.sMn != null) {
                    if (this.sMn.sKJ != 0) {
                        x.i("MicroMsg.WalletPayUI", "need real name,stop");
                        a(this.sMn);
                        return;
                    } else if (this.sMn.sKJ == 1 && r0) {
                        x.i("MicroMsg.WalletPayUI", "need real name, zero stop");
                        a(this.sMn);
                    }
                }
                if (this.sKK != null) {
                    if (this.sKK.sKr != 1 && !bi.oN(this.sKK.ojb) && !bi.oN(this.sKK.ojc) && !bi.oN(this.sKK.sKs)) {
                        com.tencent.mm.ui.base.h.a(this.mController.xRr, this.sKK.sKs, "", this.sKK.ojc, this.sKK.ojb, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                x.i("MicroMsg.WalletPayUI", "click continue pay");
                                WalletPayUI.this.bKZ();
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                x.i("MicroMsg.WalletPayUI", "click cancel pay");
                                WalletPayUI.this.finish();
                            }
                        });
                        return;
                    } else if (!(this.sKK.sKr != 2 || bi.oN(this.sKK.sKs) || bi.oN(this.sKK.sKt))) {
                        x.i("MicroMsg.WalletPayUI", "pay has been blocked");
                        com.tencent.mm.ui.base.h.a(this.mController.xRr, this.sKK.sKs, "", this.sKK.sKt, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                WalletPayUI.this.finish();
                            }
                        });
                        return;
                    }
                }
                bKZ();
            }
        }
        z2 = false;
        if (this.sMn != null) {
            if (this.sMn.sKJ != 0) {
                x.i("MicroMsg.WalletPayUI", "need real name, zero stop");
                a(this.sMn);
            } else {
                x.i("MicroMsg.WalletPayUI", "need real name,stop");
                a(this.sMn);
                return;
            }
        }
        if (this.sKK != null) {
            if (this.sKK.sKr != 1) {
            }
            x.i("MicroMsg.WalletPayUI", "pay has been blocked");
            com.tencent.mm.ui.base.h.a(this.mController.xRr, this.sKK.sKs, "", this.sKK.sKt, false, /* anonymous class already generated */);
            return;
        }
        bKZ();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bKZ() {
        /*
        r12 = this;
        r11 = 5;
        r10 = 3;
        r6 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 13958; // 0x3686 float:1.956E-41 double:6.896E-320;
        r4 = new java.lang.Object[r1];
        r5 = java.lang.Integer.valueOf(r1);
        r4[r0] = r5;
        r2.h(r3, r4);
        r2 = r12.sKT;
        if (r2 == 0) goto L_0x005b;
    L_0x0018:
        r2 = 8;
        r3 = r12.sKT;
        r3 = r3.fDQ;
        if (r2 != r3) goto L_0x005b;
    L_0x0020:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 13955; // 0x3683 float:1.9555E-41 double:6.8947E-320;
        r4 = new java.lang.Object[r1];
        r5 = java.lang.Integer.valueOf(r6);
        r4[r0] = r5;
        r2.h(r3, r4);
        r2 = r12.sKT;
        r2 = r2.vGl;
        if (r2 == 0) goto L_0x005b;
    L_0x0035:
        r2 = r12.sKT;
        r2 = r2.vGl;
        r3 = "extinfo_key_9";
        r2 = r2.getLong(r3);
        r4 = com.tencent.mm.plugin.report.service.g.pWK;
        r5 = 13956; // 0x3684 float:1.9557E-41 double:6.895E-320;
        r6 = new java.lang.Object[r6];
        r7 = java.lang.Integer.valueOf(r1);
        r6[r0] = r7;
        r8 = java.lang.System.currentTimeMillis();
        r2 = r8 - r2;
        r2 = java.lang.Long.valueOf(r2);
        r6[r1] = r2;
        r4.h(r5, r6);
    L_0x005b:
        r2 = r12.sKV;
        if (r2 == 0) goto L_0x0268;
    L_0x005f:
        r2 = com.tencent.mm.plugin.wallet_core.ui.b.sXj;
        r3 = r12.pVi;
        r2 = r2.a(r3);
        r12.sLI = r2;
        r2 = r12.sLI;
        r3 = r12.sKV;
        r3 = r3.sTc;
        r2 = r2.NN(r3);
        if (r2 == 0) goto L_0x0268;
    L_0x0075:
        r2 = r2.sJt;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0268;
    L_0x007d:
        if (r1 == 0) goto L_0x00c1;
    L_0x007f:
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMz();
        if (r1 == 0) goto L_0x00b4;
    L_0x008c:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "payWithoutPassword zeroPay";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x00aa;
    L_0x0099:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x00af;
    L_0x009d:
        r1 = "";
    L_0x00a0:
        r2 = "";
        com.tencent.mm.wallet_core.c.t.d(r0, r1, r10, r2);
        r12.bLa();
    L_0x00a9:
        return;
    L_0x00aa:
        r0 = r12.sKT;
        r0 = r0.fDQ;
        goto L_0x0099;
    L_0x00af:
        r1 = r12.sKT;
        r1 = r1.fvC;
        goto L_0x00a0;
    L_0x00b4:
        r0 = "MicroMsg.WalletPayUI";
        r1 = "has useful bankcard ! payWithOldBankcard zeroPay";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r12.bKJ();
        goto L_0x00a9;
    L_0x00c1:
        r1 = r12.sLM;
        if (r1 == 0) goto L_0x013c;
    L_0x00c5:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "hy: start do pay with force use given bankcard";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.sLN;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x00e0;
    L_0x00d6:
        r0 = r12.bLc();
        r12.sFp = r0;
        r12.bKJ();
        goto L_0x00a9;
    L_0x00e0:
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMv();
        if (r1 == 0) goto L_0x0112;
    L_0x00ed:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x0108;
    L_0x00f1:
        r1 = r0;
    L_0x00f2:
        r2 = r12.sKT;
        if (r2 != 0) goto L_0x010d;
    L_0x00f6:
        r2 = "";
    L_0x00f9:
        r3 = 17;
        r4 = "";
        com.tencent.mm.wallet_core.c.t.d(r1, r2, r3, r4);
    L_0x0101:
        r1 = "";
        r12.b(r0, r0, r1);
        goto L_0x00a9;
    L_0x0108:
        r1 = r12.sKT;
        r1 = r1.fDQ;
        goto L_0x00f2;
    L_0x010d:
        r2 = r12.sKT;
        r2 = r2.fvC;
        goto L_0x00f9;
    L_0x0112:
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMz();
        if (r1 == 0) goto L_0x0101;
    L_0x011f:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x0132;
    L_0x0123:
        r1 = r0;
    L_0x0124:
        r2 = r12.sKT;
        if (r2 != 0) goto L_0x0137;
    L_0x0128:
        r2 = "";
    L_0x012b:
        r3 = "";
        com.tencent.mm.wallet_core.c.t.d(r1, r2, r11, r3);
        goto L_0x0101;
    L_0x0132:
        r1 = r12.sKT;
        r1 = r1.fDQ;
        goto L_0x0124;
    L_0x0137:
        r2 = r12.sKT;
        r2 = r2.fvC;
        goto L_0x012b;
    L_0x013c:
        r1 = r12.getIntent();
        r2 = "key_is_use_default_card";
        r1 = r1.getStringExtra(r2);
        r2 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 != 0) goto L_0x015a;
    L_0x0154:
        r1 = Nt(r1);
        r12.sFp = r1;
    L_0x015a:
        r1 = r12.sFp;
        if (r1 != 0) goto L_0x01e3;
    L_0x015e:
        r1 = r12.sFo;
        if (r1 == 0) goto L_0x017d;
    L_0x0162:
        r1 = r12.sFo;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x017d;
    L_0x016a:
        r1 = "MicroMsg.WalletPayUI";
        r2 = " no last pay bankcard ! jump to select bankcard!";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = 8;
        r2 = "";
        r12.c(r0, r1, r2);
        goto L_0x00a9;
    L_0x017d:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "default bankcard not found! payWithNewBankcard";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMv();
        if (r1 == 0) goto L_0x01b9;
    L_0x0193:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x01af;
    L_0x0197:
        r1 = r0;
    L_0x0198:
        r2 = r12.sKT;
        if (r2 != 0) goto L_0x01b4;
    L_0x019c:
        r2 = "";
    L_0x019f:
        r3 = 17;
        r4 = "";
        com.tencent.mm.wallet_core.c.t.d(r1, r2, r3, r4);
    L_0x01a7:
        r1 = "";
        r12.b(r0, r0, r1);
        goto L_0x00a9;
    L_0x01af:
        r1 = r12.sKT;
        r1 = r1.fDQ;
        goto L_0x0198;
    L_0x01b4:
        r2 = r12.sKT;
        r2 = r2.fvC;
        goto L_0x019f;
    L_0x01b9:
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMz();
        if (r1 == 0) goto L_0x01a7;
    L_0x01c6:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x01d9;
    L_0x01ca:
        r1 = r0;
    L_0x01cb:
        r2 = r12.sKT;
        if (r2 != 0) goto L_0x01de;
    L_0x01cf:
        r2 = "";
    L_0x01d2:
        r3 = "";
        com.tencent.mm.wallet_core.c.t.d(r1, r2, r11, r3);
        goto L_0x01a7;
    L_0x01d9:
        r1 = r12.sKT;
        r1 = r1.fDQ;
        goto L_0x01cb;
    L_0x01de:
        r2 = r12.sKT;
        r2 = r2.fvC;
        goto L_0x01d2;
    L_0x01e3:
        r1 = r12.sFp;
        r2 = r12.pVi;
        r2 = r2.sOT;
        r3 = r12.pVi;
        r1 = r1.a(r2, r3);
        r2 = r12.pRC;
        if (r2 == 0) goto L_0x01fd;
    L_0x01f3:
        r2 = r12.pRC;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r4 = "";
        r2.aQ(r3, r4);
    L_0x01fd:
        if (r1 == 0) goto L_0x0224;
    L_0x01ff:
        r2 = "MicroMsg.WalletPayUI";
        r3 = new java.lang.StringBuilder;
        r4 = "main bankcard(";
        r3.<init>(r4);
        r3 = r3.append(r1);
        r4 = ") is useless! jump to select bankcard!";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = "";
        r12.c(r0, r1, r2);
        goto L_0x00a9;
    L_0x0224:
        com.tencent.mm.plugin.wallet.a.p.bKx();
        r1 = com.tencent.mm.plugin.wallet.a.p.bKy();
        r1 = r1.bMz();
        if (r1 == 0) goto L_0x025a;
    L_0x0231:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "payWithoutPassword";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x0250;
    L_0x023e:
        r1 = r12.sKT;
        if (r1 != 0) goto L_0x0255;
    L_0x0242:
        r1 = "";
    L_0x0245:
        r2 = "";
        com.tencent.mm.wallet_core.c.t.d(r0, r1, r10, r2);
        r12.bLa();
        goto L_0x00a9;
    L_0x0250:
        r0 = r12.sKT;
        r0 = r0.fDQ;
        goto L_0x023e;
    L_0x0255:
        r1 = r12.sKT;
        r1 = r1.fvC;
        goto L_0x0245;
    L_0x025a:
        r0 = "MicroMsg.WalletPayUI";
        r1 = "has useful bankcard ! payWithOldBankcard";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r12.bKJ();
        goto L_0x00a9;
    L_0x0268:
        r1 = r0;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.bKZ():void");
    }

    private void bLa() {
        jK(true);
        com.tencent.mm.plugin.wallet_core.e.c.bNV();
    }

    public void bKJ() {
        boolean z = false;
        if (XT()) {
            x.i("MicroMsg.WalletPayUI", "pay with old bankcard! from statck %s", bi.chl().toString());
            t.d(this.sKT == null ? 0 : this.sKT.fDQ, this.sKT == null ? "" : this.sKT.fvC, 8, "");
            if (!this.sLM) {
                z = true;
            }
            this.sFl = n.a(this, z, this.pVi, this.sKV, this.sFp, this.sKT, this.pRV, new n.c() {
                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    String str2;
                    WalletPayUI.this.aWY();
                    WalletPayUI.this.sKV = favorPayInfo;
                    String str3 = "MicroMsg.WalletPayUI";
                    String str4 = "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s";
                    Object[] objArr = new Object[2];
                    if (WalletPayUI.this.sKV == null) {
                        str2 = "";
                    } else {
                        str2 = WalletPayUI.this.sKV.toString();
                    }
                    objArr[0] = str2;
                    objArr[1] = Boolean.valueOf(z);
                    x.i(str3, str4, objArr);
                    if (WalletPayUI.this.sKV == null || !z) {
                        t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 9, "");
                        WalletPayUI.this.mFy = str;
                        WalletPayUI.this.jK(false);
                        com.tencent.mm.plugin.wallet_core.e.c.bNV();
                        WalletPayUI.this.sKX = null;
                        return;
                    }
                    WalletPayUI.this.R(-100, true);
                }
            }, new View.OnClickListener() {
                public final void onClick(View view) {
                    WalletPayUI.this.sKV = (FavorPayInfo) view.getTag();
                    if (WalletPayUI.this.sKV != null) {
                        WalletPayUI.this.sKV.sTg = "";
                    }
                    t.d(WalletPayUI.this.sKT == null ? 0 : WalletPayUI.this.sKT.fDQ, WalletPayUI.this.sKT == null ? "" : WalletPayUI.this.sKT.fvC, 10, "");
                    WalletPayUI.this.c(false, 0, "");
                    WalletPayUI.this.sFl.dismiss();
                    WalletPayUI.this.mFy = null;
                    WalletPayUI.this.sFl = null;
                    WalletPayUI.this.sKX = null;
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    WalletPayUI.this.mFy = null;
                    WalletPayUI.this.sFl = null;
                    if (WalletPayUI.this.aYL()) {
                        WalletPayUI.this.finish();
                    }
                    WalletPayUI.this.sKX = null;
                }
            });
            this.sKX = this.sFl;
        }
    }

    public final void b(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        p.bKx();
        x.d("MicroMsg.WalletPayUI", stringBuilder.append(p.bKy().bMy()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String N;
            if (bi.oN(str)) {
                N = Bankcard.N(this, i);
            } else {
                N = str;
            }
            com.tencent.mm.ui.base.h.a((Context) this, N, "", getString(com.tencent.mm.plugin.wxpay.a.i.vaV), getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPayUI.this.bLb();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (WalletPayUI.this.aYL()) {
                        WalletPayUI.this.finish();
                    }
                }
            });
            return;
        }
        bLb();
    }

    public final void c(boolean z, final int i, String str) {
        x.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + z);
        if (z) {
            String N;
            if (bi.oN(str)) {
                N = Bankcard.N(this, i);
            } else {
                N = str;
            }
            com.tencent.mm.ui.base.h.a((Context) this, N, "", getString(com.tencent.mm.plugin.wxpay.a.i.vbl), getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPayUI.this.R(i, false);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (WalletPayUI.this.aYL()) {
                        WalletPayUI.this.finish();
                    }
                }
            });
            return;
        }
        R(i, false);
    }

    protected final void bLb() {
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        p.bKx();
        extras.putInt(str, p.bKy().bMy() ? 2 : 1);
        extras.putParcelable("key_orders", this.pVi);
        extras.putParcelable("key_pay_info", this.sKT);
        extras.putParcelable("key_favor_pay_info", this.sKV);
        I(extras);
    }

    protected final void R(int i, boolean z) {
        int i2 = 0;
        com.tencent.mm.plugin.report.service.g.pWK.h(13958, Integer.valueOf(2));
        com.tencent.mm.plugin.report.service.g.pWK.h(13955, Integer.valueOf(4));
        if (this.sKT != null) {
            i2 = this.sKT.fDQ;
        }
        t.d(i2, this.sKT == null ? "" : this.sKT.fvC, 11, "");
        Bundle bundle = this.vf;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.pVi);
        bundle.putParcelable("key_pay_info", this.sKT);
        bundle.putParcelable("key_authen", bKW());
        bundle.putString("key_pwd1", this.mFy);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.sKV);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.sFp != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.sFp.field_bindSerial);
        }
        I(bundle);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletPayUI", "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        Bundle bundle;
        Bundle bundle2;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                com.tencent.mm.plugin.report.service.g gVar;
                Object[] objArr;
                long j;
                e eVar = (e) kVar;
                x.i("MicroMsg.WalletPayUI", "stopRealname realnameGuideFlag %s guide_type %s", eVar.fLK, Integer.valueOf(eVar.sKJ));
                if ("1".equals(eVar.fLK) || "2".equals(eVar.fLK)) {
                    this.sMn = eVar;
                } else {
                    this.sMn = null;
                }
                this.sKK = eVar.sKK;
                this.sMl = true;
                this.pVi = ((e) kVar).pVi;
                this.mCount = this.pVi != null ? this.pVi.sUf.size() : 0;
                x.d("MicroMsg.WalletPayUI", "get mOrders! bankcardTag : " + (this.pVi != null ? Integer.valueOf(this.pVi.sOT) : ""));
                XT();
                if (!(this.pVi == null || this.pVi.sUg == null)) {
                    this.sLI = com.tencent.mm.plugin.wallet_core.ui.b.sXj.a(this.pVi);
                    if (this.sLI != null) {
                        if (this.sLI.bNa().size() > 0) {
                            this.sLJ = true;
                        }
                        this.sKV = this.sLI.NQ(this.pVi.sUg.sJu);
                        this.sKV.sTc = this.sLI.NR(this.sKV.sTc);
                        x.i("MicroMsg.WalletPayUI", "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", this.pVi.sUg.sJu, this.sKV.sTc, this.sKV.sTc, this.sKV.toString());
                    }
                }
                if (!(this.pVi == null || this.sFo == null || this.sKT == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sKT, this.pVi);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sKT.fDQ);
                    objArr[1] = Integer.valueOf(0);
                    p.bKx();
                    objArr[2] = Integer.valueOf(p.bKy().bMy() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pVi.pTQ * 100.0d));
                    objArr[4] = this.pVi.pgf;
                    gVar.h(10690, objArr);
                }
                if (!(this.pVi == null || this.pVi.sUf == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pVi.sUf) {
                        linkedList.add(commodity.fvD);
                    }
                    if (linkedList.size() > 0) {
                        b taVar = new ta();
                        taVar.fMk.fMm = linkedList;
                        com.tencent.mm.sdk.b.a.xmy.m(taVar);
                        if (this.pRC != null) {
                            this.pRC.aQ(10001, (String) linkedList.get(0));
                        }
                    }
                }
                p.bKx();
                this.sFo = p.bKy().jG(bKG());
                p.bKx();
                this.sFp = p.bKy().a(null, null, bKG(), false);
                String aD = bi.aD(getIntent().getStringExtra("key_is_use_default_card"), "");
                if (!bi.oN(aD)) {
                    this.sFp = Nt(aD);
                }
                this.pTn.setClickable(true);
                if (bi.oN(o.bMc().sWv)) {
                    this.sLY.setVisibility(8);
                    this.sLY.setText("");
                } else {
                    this.sLY.setVisibility(0);
                    this.sLY.setText(o.bMc().sWv);
                }
                if (!(this.pVi == null || this.sFo == null || this.sKT == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sKT, this.pVi);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sKT.fDQ);
                    objArr[1] = Integer.valueOf(0);
                    p.bKx();
                    objArr[2] = Integer.valueOf(p.bKy().bMy() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pVi.pTQ * 100.0d));
                    objArr[4] = this.pVi.pgf;
                    gVar.h(10690, objArr);
                }
                if (this.sMg) {
                    R(0, false);
                }
                if (bLe().vGl == null) {
                    j = 0;
                } else {
                    j = bLe().vGl.getLong("wallet_pay_key_check_time");
                }
                if (j > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 4, 1, true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 5, bi.bA(j), true);
                }
                if (this.sMq > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 7, 1, true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(641, 8, bi.bA(this.sMq), true);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                j jVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                bundle = this.vf;
                bundle.putParcelable("key_pay_info", this.sKT);
                bundle.putParcelable("key_bankcard", this.sFp);
                bundle.putString("key_bank_type", this.sFp.field_bankcardType);
                if (!bi.oN(this.mFy)) {
                    bundle.putString("key_pwd1", this.mFy);
                }
                bundle.putString("kreq_token", jVar.token);
                bundle.putParcelable("key_authen", jVar.sKx);
                bundle.putBoolean("key_need_verify_sms", !jVar.sKv);
                bundle.putInt("key_can_verify_tail", jVar.sKB);
                bundle.putString("key_verify_tail_wording", jVar.sKC);
                this.vf.putBoolean("key_block_bind_new_card", jVar.sKD == 1);
                if (bi.oN(jVar.sKy)) {
                    bundle.putString("key_mobile", this.sFp.field_mobile);
                } else {
                    bundle.putString("key_mobile", jVar.sKy);
                }
                bundle.putString("key_QADNA_URL", jVar.sKz);
                if (jVar.sLK) {
                    if (this.pRC != null) {
                        this.pRC.aQ(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.pRC;
                        com.tencent.mm.plugin.report.service.g.pWK.h(13455, aVar.sEc, Long.valueOf(System.currentTimeMillis()), aVar.sEd);
                    }
                    bundle.putParcelable("key_orders", jVar.sKw);
                    if (this.sKT != null) {
                        x.i("MicroMsg.WalletPayUI", "payscene %d", Integer.valueOf(this.sKT.fDQ));
                        if (8 == this.sKT.fDQ) {
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.pVi);
                }
                bundle2 = new Bundle();
                bundle2.putString("pwd", this.mFy);
                ((l) com.tencent.mm.kernel.g.h(l.class)).a(jVar.bKC(), true, bundle2);
                bundle.putInt("key_pay_flag", 3);
                Parcelable parcelable = jVar.pbX;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                I(bundle);
                return true;
            }
            av();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            bundle2 = new Bundle();
            bundle2.putString("pwd", this.mFy);
            ((l) com.tencent.mm.kernel.g.h(l.class)).a(this.sKT.tcd == 1, false, bundle2);
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    String string;
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.sLP = this.vf;
                    this.sLP.putParcelable("key_pay_info", this.sKT);
                    this.sLP.putParcelable("key_bankcard", this.sFp);
                    if (!bi.oN(this.mFy)) {
                        this.sLP.putString("key_pwd1", this.mFy);
                    }
                    this.sLP.putString("kreq_token", bVar.token);
                    this.sLP.putParcelable("key_authen", bVar.sKx);
                    this.sLP.putBoolean("key_need_verify_sms", !bVar.sKv);
                    this.sLP.putString("key_mobile", this.sFp.field_mobile);
                    this.sLP.putInt("key_err_code", i2);
                    this.sLP.putParcelable("key_orders", this.pVi);
                    if (bi.oN(str)) {
                        string = getString(com.tencent.mm.plugin.wxpay.a.i.vbB, new Object[]{this.sFp.field_desc, this.sFp.field_mobile});
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, "", getString(com.tencent.mm.plugin.wxpay.a.i.vbA), getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPayUI.this.sLP.putInt("key_pay_flag", 3);
                            WalletPayUI.this.I(WalletPayUI.this.sLP);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (WalletPayUI.this.aYL()) {
                                WalletPayUI.this.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.sFp == null || this.pVi == null)) {
                        this.sFp.sRn = this.pVi.fvC;
                        if (this.sFo == null || this.sFo.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.sKT.vGm = i2;
                    bKJ();
                    return true;
                case 100100:
                case 100101:
                    this.sKT.vGm = i2;
                    boolean z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.sKW == null) {
                        this.sKW = new a(this, this);
                    }
                    this.sKW.a(z, this.sKT.fxS, this.sKT.fvC);
                    x.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof e) {
            this.sMl = true;
            bLd();
            if (i2 == 416) {
                x.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
                this.sMi = true;
                bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle, this.sKT != null ? this.sKT.fDQ : 0);
            }
            x.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", Integer.valueOf(i2));
        }
        return false;
    }

    public final boolean aYP() {
        return false;
    }

    public final boolean XT() {
        if (this.pVi == null || this.pVi.sUf == null || this.pVi.sUf.size() <= 0) {
            x.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
            com.tencent.mm.ui.base.h.a(this.mController.xRr, com.tencent.mm.plugin.wxpay.a.i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPayUI.this.finish();
                }
            });
            return false;
        } else if (!this.sLM || bi.oN(this.sLN) || bLc() != null) {
            return true;
        } else {
            x.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
            com.tencent.mm.ui.base.h.a(this.mController.xRr, com.tencent.mm.plugin.wxpay.a.i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPayUI.this.finish();
                }
            });
            return false;
        }
    }

    private Bankcard bLc() {
        p.bKx();
        ArrayList jG = p.bKy().jG(true);
        if (jG.size() != 0) {
            Iterator it = jG.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bi.oM(this.sLN).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    private static Bankcard Nt(String str) {
        p.bKx();
        ArrayList jG = p.bKy().jG(true);
        if (jG.size() != 0) {
            Iterator it = jG.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bi.oM(str).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.sMk = intent.getIntExtra("auto_deduct_flag", -1);
                        this.pVi.sUk.sMk = this.sMk;
                        bLe().vGo = this.sMk;
                        if (this.sMk == 1) {
                            bLe().vGp = intent.getStringExtra("deduct_bank_type");
                            bLe().vGq = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.sMj = true;
                    aYO();
                } else {
                    finish();
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13958, Integer.valueOf(3));
                return;
            default:
                return;
        }
    }

    protected final boolean aYO() {
        x.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", Boolean.valueOf(this.sMo));
        com.tencent.mm.sdk.b.a.xmy.m(new st());
        boolean z = (this.pVi == null || this.pVi.sUk == null || this.sMj) ? false : true;
        if (!(z || bLd())) {
            t.d(this.sKT == null ? 0 : this.sKT.fDQ, this.sKT == null ? "" : this.sKT.fvC, 2, "");
        }
        if (this.sMo) {
            jJ(true);
            return true;
        } else if (this.sMi) {
            return true;
        } else {
            if (z) {
                Intent intent = new Intent(this, WalletPayDeductUI.class);
                intent.putExtra("orders", this.pVi);
                startActivityForResult(intent, 0);
                return true;
            } else if (this.mController.contentView.getVisibility() != 0) {
                if (!this.sLQ && XT()) {
                    jJ(true);
                    this.sLQ = true;
                }
                return true;
            } else if (this.mController.contentView.getVisibility() != 0 || this.pVi == null || this.pVi.sUk == null || !this.pTn.isEnabled() || this.sMm) {
                return false;
            } else {
                this.pTn.performClick();
                this.sMm = true;
                return false;
            }
        }
    }

    public final boolean aYL() {
        if (this.sMl) {
            String str = "MicroMsg.WalletPayUI";
            String str2 = "case 1 %s,";
            Object[] objArr = new Object[1];
            boolean z = bLe() == null || !bLe().niF;
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 2 %s,";
            objArr = new Object[1];
            p.bKx();
            if (p.bKy().bMy()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.sFo == null ? 0 : this.sFo.size());
            objArr[1] = this.sFp == null ? "" : this.sFp.field_forbidWord;
            x.d(str, str2, objArr);
            if (bLe() == null || !bLe().niF) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent1");
                return false;
            }
            p.bKx();
            if (!p.bKy().bMy()) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent2");
                return false;
            } else if (this.sFo == null || (this.sFo.size() != 0 && (this.sFp == null || bi.oN(this.sFp.field_forbidWord)))) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent4");
                return true;
            } else {
                str = "MicroMsg.WalletPayUI";
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                z = this.sFo != null && this.sFo.size() == 0;
                objArr[0] = Boolean.valueOf(z);
                z = (this.sFp == null || bi.oN(this.sFp.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                return false;
            }
        }
        x.i("MicroMsg.WalletPayUI", "get isTransparent5");
        return true;
    }

    private boolean bLd() {
        if (aYL()) {
            uV(4);
            return false;
        }
        uV(0);
        return true;
    }

    protected final boolean bKK() {
        return true;
    }

    public final void uO(int i) {
        if (i == 0) {
            if (aYL()) {
                finish();
            }
        } else if (i == 1) {
            bKJ();
        }
    }

    public void jK(boolean z) {
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(bKW(), this.pVi, z);
        if (this.pVi != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.pVi.fvC);
            if (this.pVi.sUf != null && this.pVi.sUf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pVi.sUf.get(0)).fvD);
            }
            bundle.putLong("key_SessionId", this.sMc);
            a.gQd = "PayProcess";
            a.vf = bundle;
        }
        if (this.sKT != null) {
            if (this.sKT.fDQ == 6 && this.sKT.vGi == 100) {
                a.itU = 100;
            } else {
                a.itU = this.sKT.fDQ;
            }
        }
        l(a);
        if (this.sKT != null && 8 == this.sKT.fDQ && this.sKT.vGl != null) {
            long j = this.sKT.vGl.getLong("extinfo_key_9");
            com.tencent.mm.plugin.report.service.g.pWK.h(13956, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j));
        }
    }

    public final boolean bKG() {
        return (this.sKT == null || this.sKT.fDQ == 11) ? false : true;
    }

    public final PayInfo bLe() {
        if (this.sKT == null) {
            this.sKT = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        return this.sKT;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void I(Bundle bundle) {
        boolean z;
        this.sLL = true;
        if (this.pVi != null) {
            bundle.putInt("key_support_bankcard", this.pVi.sOT);
            bundle.putString("key_reqKey", this.pVi.fvC);
            if (this.pVi.sUf != null && this.pVi.sUf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pVi.sUf.get(0)).fvD);
            }
            bundle.putLong("key_SessionId", this.sMc);
        }
        if (this.sKT != null) {
            bundle.putInt("key_scene", this.sKT.fDQ);
        }
        String str = "key_is_oversea";
        if (bKX()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("is_deduct_open", this.sMk);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, null);
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletPayUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
            this.sKT.fxU = str;
            this.sKT.fxV = str2;
            jK(false);
            com.tencent.mm.plugin.wallet_core.e.c.bNV();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
        jK(false);
        com.tencent.mm.plugin.wallet_core.e.c.bNV();
    }

    public void onPause() {
        super.onPause();
        if (this.sKX != null) {
            this.sKX.bNc();
        }
    }

    private boolean a(e eVar) {
        int i = 0;
        if ("1".equals(eVar.fLK)) {
            x.i("MicroMsg.WalletPayUI", "need realname verify");
            this.sMi = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            String str = eVar.fLL;
            str = eVar.fLM;
            str = eVar.fLN;
            aYL();
            if (this.sKT != null) {
                i = this.sKT.fDQ;
            }
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, i);
        } else if ("2".equals(eVar.fLK)) {
            x.i("MicroMsg.WalletPayUI", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, eVar.fLL, eVar.fLO, eVar.fLM, eVar.fLN, aYL(), null);
        } else {
            x.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + eVar.fLK);
            return false;
        }
    }
}
