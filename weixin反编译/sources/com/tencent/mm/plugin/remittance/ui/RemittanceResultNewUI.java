package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private PayInfo pHW;
    private int pRF;
    private c pSQ;
    private WalletSuccPageAwardWidget pSR;
    private Orders pVi;
    private String pVj;
    private boolean pVk;
    private TextView pVl;
    private ViewGroup pVm;
    private TextView pVn;
    private WalletTextView pVo;
    private ViewGroup pVp;
    private ViewGroup pVq;
    private ViewGroup pVr;
    private TextView pVs;
    private TextView pVt;
    private WalletTextView pVu;
    private lg pVv;
    private Button pVw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fN(21)) {
            if (d.fN(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.pVi = (Orders) this.vf.getParcelable("key_orders");
        this.pHW = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (this.pHW == null) {
            x.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        String str2 = "";
        if (this.pHW.vGl != null) {
            this.pVk = this.pHW.vGl.getBoolean("extinfo_key_4");
            str = this.pHW.vGl.getString("extinfo_key_1");
            str2 = this.pHW.vGl.getString("extinfo_key_16");
        }
        this.pRF = this.pHW.fDQ;
        this.pVj = str;
        x.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", Integer.valueOf(r2));
        initView();
        if (this.pRF == 31) {
            x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str2);
            b.bnS().bnV().dW(str2, this.pVj);
        }
    }

    protected final int getLayoutId() {
        return g.uKF;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boG();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        boolean z = false;
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pVl = (TextView) findViewById(f.uzs);
        this.pVm = (ViewGroup) findViewById(f.uqK);
        this.pVn = (TextView) findViewById(f.uqE);
        this.pVo = (WalletTextView) findViewById(f.uqD);
        this.pVp = (ViewGroup) findViewById(f.uqI);
        this.pVq = (ViewGroup) findViewById(f.uqJ);
        this.pVr = (ViewGroup) findViewById(f.uyt);
        this.pVs = (TextView) findViewById(f.uys);
        this.pVt = (TextView) findViewById(f.uyr);
        this.pVu = (WalletTextView) findViewById(f.uyq);
        this.pVw = (Button) findViewById(f.uDO);
        this.pVw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RemittanceResultNewUI.this.boG();
            }
        });
        this.pSR = (WalletSuccPageAwardWidget) findViewById(f.uli);
        String gw = e.gw(this.pVj);
        if (this.pRF == 31 || this.pRF == 5) {
            this.pVt.setText(e.abh(this.pVi.pgf));
            this.pVu.setText(e.t(this.pVi.pTQ));
            if (this.pRF == 31) {
                CharSequence string = getString(i.uCF, new Object[]{gw});
                if (bi.oN(string)) {
                    this.pVs.setVisibility(8);
                } else {
                    this.pVs.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string, this.pVs.getTextSize()));
                }
            } else {
                boolean z2;
                if (this.pHW.vGl == null || !this.pHW.vGl.getBoolean("extinfo_key_10")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                x.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", Boolean.valueOf(z2));
                if (z2) {
                    this.pVs.setText(getString(i.uUq));
                } else if (!(this.pVi.sUf == null || this.pVi.sUf.get(0) == null || TextUtils.isEmpty(((Commodity) this.pVi.sUf.get(0)).pfU))) {
                    this.pVs.setText(((Commodity) this.pVi.sUf.get(0)).pfU);
                }
            }
            this.pVr.setVisibility(0);
            if (this.pVi.pQx > 0.0d) {
                boF();
                ((MarginLayoutParams) this.pVp.getLayoutParams()).topMargin = com.tencent.mm.bu.a.fromDPToPix(this, 20);
                this.pVp.setVisibility(0);
                this.pVq.setVisibility(0);
            }
        } else {
            byte[] byteArray = this.vf.getByteArray("key_succpage_resp");
            if (byteArray != null) {
                this.pVv = new lg();
                try {
                    this.pVv.aH(byteArray);
                    this.pSQ = this.pVv.sUS;
                } catch (Throwable e) {
                    this.pVv = null;
                    this.pSQ = null;
                    x.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e, "parse f2FPaySucPageResp error: %s", e.getMessage());
                }
            }
            gw = e.gw(this.pVj);
            this.pVn.setText(e.abh(this.pVi.pgf));
            this.pVo.setText(e.t(this.pVi.pTQ));
            this.pVq.removeAllViews();
            if (this.pRF == 32 || this.pRF == 33 || this.pRF == 48) {
                CharSequence charSequence;
                ViewGroup viewGroup;
                TextView textView;
                String str = "";
                if (this.pHW.vGl != null) {
                    str = this.pHW.vGl.getString("extinfo_key_2");
                }
                if (gw != null && gw.length() > 10) {
                    gw = gw.substring(0, 10) + "...";
                }
                Object charSequence2;
                if (bi.oN(str)) {
                    charSequence2 = gw;
                } else if (bi.oN(gw)) {
                    charSequence2 = str;
                } else {
                    charSequence2 = gw + "(" + e.abk(str) + ")";
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
                ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(g.uIu, this.pVq, false);
                TextView textView2 = (TextView) viewGroup2.findViewById(f.uBk);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) viewGroup2.findViewById(f.uBW), this.pVj, 0.06f, false);
                textView2.setText(charSequence2);
                this.pVq.addView(viewGroup2);
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
                CharSequence string2 = this.pHW.vGl.getString("extinfo_key_3");
                CharSequence string3 = this.pHW.vGl.getString("extinfo_key_8");
                if (!bi.oN(string2)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uIt, this.pVq, false);
                    textView2 = (TextView) viewGroup.findViewById(f.cSB);
                    textView = (TextView) viewGroup.findViewById(f.caU);
                    if (bi.oN(string3)) {
                        textView2.setText(getString(i.uOY));
                    } else {
                        textView2.setText(string3);
                    }
                    textView.setText(string2);
                    this.pVq.addView(viewGroup);
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
                string2 = this.pHW.vGl.getString("extinfo_key_6");
                string3 = this.pHW.vGl.getString("extinfo_key_7");
                if (!bi.oN(string3)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uIt, this.pVq, false);
                    textView2 = (TextView) viewGroup.findViewById(f.cSB);
                    textView = (TextView) viewGroup.findViewById(f.caU);
                    if (bi.oN(string2)) {
                        textView2.setText(getString(i.uOX));
                    } else {
                        textView2.setText(string2);
                    }
                    textView.setText(string3);
                    this.pVq.addView(viewGroup);
                }
                boF();
                this.pVp.setVisibility(0);
                this.pVq.setVisibility(0);
                if (WalletSuccPageAwardWidget.a(this.pSQ)) {
                    String str2 = "";
                    if (this.pVi.sUf.size() > 0) {
                        str2 = ((Commodity) this.pVi.sUf.get(0)).fvD;
                    }
                    x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str2);
                    this.pSR.a(this, this.pSQ, str2, true, (ImageView) findViewById(f.background));
                    this.pSR.init();
                    this.pSR.setVisibility(0);
                } else {
                    this.pSR.setVisibility(8);
                    if (this.pVq.getChildCount() == 1) {
                        LayoutParams layoutParams = (LayoutParams) this.pVp.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b((Context) this, 78.0f);
                        this.pVp.setLayoutParams(layoutParams);
                        View findViewById = viewGroup2.findViewById(f.uCr);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b((Context) this, 24.0f);
                        layoutParams.bottomMargin = 0;
                        findViewById.setLayoutParams(layoutParams);
                        ImageView imageView = (ImageView) viewGroup2.findViewById(f.uBW);
                        ((TextView) viewGroup2.findViewById(f.uBk)).setVisibility(8);
                        findViewById(f.uBm).setVisibility(0);
                        ((TextView) findViewById(f.uBl)).setText(charSequence2);
                        LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
                        int b = BackwardSupportUtil.b.b((Context) this, 52.0f);
                        layoutParams2.width = b;
                        layoutParams2.height = b;
                        imageView.setLayoutParams(layoutParams2);
                        this.pVo.setTextSize(1, 42.0f);
                        this.pVn.setTextSize(1, 42.0f);
                        ((TextView) findViewById(f.uBo)).setTextSize(1, 16.0f);
                        ImageView imageView2 = (ImageView) findViewById(f.uHp);
                        layoutParams = (LayoutParams) imageView2.getLayoutParams();
                        layoutParams.width = BackwardSupportUtil.b.b((Context) this, 26.0f);
                        layoutParams.height = BackwardSupportUtil.b.b((Context) this, 22.0f);
                        imageView2.setLayoutParams(layoutParams);
                        View findViewById2 = findViewById(f.cPk);
                        if (findViewById2 != null) {
                            findViewById2.setVisibility(8);
                        }
                    }
                }
            }
            this.pVm.setVisibility(0);
        }
        com.tencent.mm.kernel.g.Dr();
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultNewUI", "has show the finger print auth guide!");
            return;
        }
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        Bundle bundle = new Bundle();
        if (ag != null) {
            bundle = ag.mym;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultNewUI", "pwd is empty, not show the finger print auth guide!");
        } else if (ag != null) {
            ag.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void boF() {
        boolean z = true;
        if (this.pVi != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.pVi.pQx <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.pVi.pQx > 0.0d) {
                CharSequence string = getString(i.uUH);
                CharSequence d = e.d(this.pVi.pQx, this.pVi.pgf);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(g.uIs, this.pVq, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(f.bLM);
                TextView textView = (TextView) viewGroup.findViewById(f.caU);
                ((TextView) viewGroup.findViewById(f.cSB)).setText(string);
                imageView.setVisibility(8);
                textView.setText(d);
                this.pVq.addView(viewGroup);
            }
        }
    }

    private void boG() {
        x.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceResultNewUI.this.boH();
                    }
                });
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceResultNewUI.this.boH();
                    }
                });
                this.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        boH();
    }

    private void boH() {
        x.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        cCT().b((Activity) this, this.vf);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                if (RemittanceResultNewUI.this.pRF == 33 || RemittanceResultNewUI.this.pRF == 32 || RemittanceResultNewUI.this.pRF == 48) {
                    RemittanceResultNewUI.this.finish();
                } else if (bi.oN(RemittanceResultNewUI.this.pVj) || RemittanceResultNewUI.this.pVk) {
                    RemittanceResultNewUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultNewUI.this.pVj);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.bl.d.a(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", intent);
                }
            }
        }, 100);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            return this.pSR.d(i, i2, str, kVar);
        }
        return super.d(i, i2, str, kVar);
    }

    public final void uV(int i) {
        this.mController.contentView.setVisibility(i);
    }

    protected final boolean boI() {
        return false;
    }

    public void onResume() {
        super.onResume();
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            this.pSR.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            this.pSR.onDestroy();
        }
    }
}
