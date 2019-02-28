package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.fl;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI extends QrRewardBaseUI {
    private int fDM;
    private String fvC;
    private String jhS;
    private String lnQ;
    private int lpA;
    private int lpB;
    private String lpC;
    private String lpD;
    private String lpE;
    private String lpF;
    private String lpG;
    private String lpH;
    private String lpI;
    private String lpJ;
    private String lpK;
    private int lpL;
    private c<fl> lpM = new c<fl>() {
        {
            this.xmG = fl.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fl flVar = (fl) bVar;
            QrRewardGrantUI.this.ci(flVar.fvB.fvC, flVar.fvB.fvD);
            return false;
        }
    };
    private ImageView lps;
    private TextView lpt;
    private TextView lpu;
    private WalletTextView lpv;
    private LinearLayout lpw;
    private WalletFormView lpx;
    private MMEditText lpy;
    private Button lpz;

    static /* synthetic */ boolean a(QrRewardGrantUI qrRewardGrantUI, int i) {
        boolean z;
        boolean z2;
        if (qrRewardGrantUI.lpB == 1) {
            z = false;
            z2 = true;
        } else if (((double) i) <= 0.0d) {
            z = true;
            z2 = false;
        } else if (i <= qrRewardGrantUI.lpL) {
            qrRewardGrantUI.lpx.HZ(a.c.black);
            z = false;
            z2 = true;
        } else {
            qrRewardGrantUI.lpx.HZ(a.c.ugW);
            z = false;
            z2 = false;
        }
        if (z2) {
            if (qrRewardGrantUI.lpu.isShown()) {
                qrRewardGrantUI.lpu.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, a.a.ugN));
                qrRewardGrantUI.lpu.setVisibility(8);
            }
            qrRewardGrantUI.lpz.setEnabled(true);
        } else {
            if (!(z || qrRewardGrantUI.lpu.isShown())) {
                qrRewardGrantUI.lpu.startAnimation(AnimationUtils.loadAnimation(qrRewardGrantUI, a.a.ugM));
                qrRewardGrantUI.lpu.setVisibility(0);
            }
            qrRewardGrantUI.lpz.setEnabled(false);
        }
        return z2;
    }

    static /* synthetic */ void b(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s", Integer.valueOf(qrRewardGrantUI.lpA), Integer.valueOf(qrRewardGrantUI.lpB), qrRewardGrantUI.lpy.getText().toString().replace("\n", ""));
        k eVar = new e(qrRewardGrantUI.lpA, qrRewardGrantUI.lpB, qrRewardGrantUI.lpG, qrRewardGrantUI.lpC, r5, qrRewardGrantUI.fDM, qrRewardGrantUI.lpI, qrRewardGrantUI.lpE, qrRewardGrantUI.jhS, qrRewardGrantUI.lpJ, qrRewardGrantUI.lpK);
        eVar.m(qrRewardGrantUI);
        qrRewardGrantUI.l(eVar);
    }

    static /* synthetic */ void c(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = qrRewardGrantUI.fvC;
        payInfo.fDQ = 48;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.lpG);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.lpH);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.lpC);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.lpy.getText().toString().replace("\n", ""));
        payInfo.vGl = bundle;
        h.a((Context) qrRewardGrantUI, payInfo, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1336);
        this.lpM.cfB();
        setMMTitle(i.uTd);
        this.lpA = getIntent().getIntExtra("key_money_amt", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        this.lpB = getIntent().getIntExtra("key_amt_type", 0);
        this.lpC = getIntent().getStringExtra("key_qrcode_desc");
        this.fDM = getIntent().getIntExtra("key_channel", 0);
        this.lpE = getIntent().getStringExtra("key_rcvr_open_id");
        this.lpG = getIntent().getStringExtra("key_rcvr_name");
        this.lpH = getIntent().getStringExtra("key_rcvr_true_name");
        this.lpI = getIntent().getStringExtra("key_scan_id");
        this.jhS = getIntent().getStringExtra("key_web_url");
        this.lpJ = getIntent().getStringExtra("key_sxtend_1");
        this.lpK = getIntent().getStringExtra("key_sxtend_2");
        this.lpL = getIntent().getIntExtra("key_max_amt", HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        x.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", Integer.valueOf(this.lpB), Integer.valueOf(this.fDM), Integer.valueOf(this.lpL));
        initView();
    }

    public final void initView() {
        this.lps = (ImageView) findViewById(f.uAj);
        this.lpt = (TextView) findViewById(f.uAk);
        this.lpv = (WalletTextView) findViewById(f.uAo);
        this.lpw = (LinearLayout) findViewById(f.uAn);
        this.lpx = (WalletFormView) findViewById(f.uAl);
        this.lpy = (MMEditText) findViewById(f.uAm);
        this.lpz = (Button) findViewById(f.uAp);
        this.lpu = (TextView) findViewById(f.uAi);
        this.lpu.setText(getString(i.uTm, new Object[]{Math.round(((float) this.lpL) / 100.0f)}));
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lps, this.lpG, 0.03f, false);
        String dF = com.tencent.mm.wallet_core.ui.e.dF(com.tencent.mm.wallet_core.ui.e.gw(this.lpG), 10);
        this.lpt.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, getString(i.uTe, new Object[]{dF})));
        if (this.lpB == 2) {
            x.i("MicroMsg.QrRewardGrantUI", "edit layout");
            e(this.lpx, 2, false);
            this.lpx.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 3) {
                        editable.delete(indexOf + 3, length);
                    } else if (indexOf > 6) {
                        editable.delete(6, indexOf);
                    } else if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    length = (int) Math.round(bi.getDouble(editable.toString(), 0.0d) * 100.0d);
                    QrRewardGrantUI.a(QrRewardGrantUI.this, length);
                    QrRewardGrantUI.this.lpA = length;
                }
            });
            this.lpx.setVisibility(0);
            this.lpw.setVisibility(8);
            this.lpx.cDf();
            this.lpz.setEnabled(false);
        } else {
            this.lpv.setText(com.tencent.mm.wallet_core.ui.e.t(((double) this.lpA) / 100.0d));
            this.lpx.setVisibility(8);
            this.lpw.setVisibility(0);
        }
        this.lpz.setOnClickListener(new r() {
            public final void azE() {
                if (QrRewardGrantUI.a(QrRewardGrantUI.this, (int) Math.round(bi.getDouble(QrRewardGrantUI.this.lpx.getText(), 0.0d) * 100.0d))) {
                    QrRewardGrantUI.b(QrRewardGrantUI.this);
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof e) {
            final e eVar = (e) kVar;
            eVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    QrRewardGrantUI.this.fvC = eVar.lpi.fxT;
                    QrRewardGrantUI.this.lpD = eVar.lpi.wbr;
                    QrRewardGrantUI.this.lnQ = eVar.lpi.vOh;
                    QrRewardGrantUI.this.lpE = eVar.lpi.wbp;
                    QrRewardGrantUI.this.lpF = eVar.lpi.wbo;
                    x.i("MicroMsg.QrRewardGrantUI", "remind str: %s", eVar.lpi.wbz);
                    if (bi.oN(eVar.lpi.wbz)) {
                        QrRewardGrantUI.c(QrRewardGrantUI.this);
                    } else {
                        com.tencent.mm.ui.base.h.a(QrRewardGrantUI.this.mController.xRr, eVar.lpi.wbz, "", QrRewardGrantUI.this.getString(i.uTI), QrRewardGrantUI.this.getString(i.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                QrRewardGrantUI.c(QrRewardGrantUI.this);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", Integer.valueOf(eVar.lpi.lot), eVar.lpi.lou);
                    if (!bi.oN(eVar.lpi.lou)) {
                        Toast.makeText(QrRewardGrantUI.this, eVar.lpi.lou, 0).show();
                    }
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardGrantUI", "net error: %s", kVar);
                }
            });
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1336);
        this.lpM.dead();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            if (intent != null) {
                ci(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
        }
    }

    protected final int getLayoutId() {
        return g.uKk;
    }

    private void ci(String str, String str2) {
        x.i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (bi.oN(this.fvC)) {
            this.fvC = str;
        }
        if (bi.oN(this.lnQ)) {
            this.lnQ = str2;
        }
        b(new d(this.fvC, this.lpD, this.lnQ, this.lpA, this.lpE, this.lpF), false);
    }
}
