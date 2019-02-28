package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.bp.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;
import java.util.List;

@a(19)
public class RemittanceBusiResultUI extends WalletBaseUI {
    private TextView jOY;
    private int oli;
    private Button pOv;
    private int pPJ;
    private String pPK;
    private String pSA;
    private String pSB;
    private String pSC;
    private double pSD;
    private String pSE;
    private String pSF;
    private String pSG;
    private int pSH;
    private String pSI;
    private String pSJ;
    private b pSK;
    private boolean pSL = false;
    private String pSM;
    private BusiRemittanceResp pSN;
    private cg pSO = new cg();
    private int pSP;
    private c pSQ;
    private WalletSuccPageAwardWidget pSR;
    private CdnImageView pSS;
    private TextView pST;
    private View pSU;
    private TextView pSV;
    private ViewGroup pSW;
    private ViewGroup pSX;
    private ViewGroup pSY;
    private TextView pSZ;
    private String pSa;
    private TextView pSp;
    private TextView pSq;
    private TextView pSr;
    private CdnImageView pSs;
    private TextView pSt;
    private TextView pSu;
    private Button pSv;
    private ViewGroup pSw;
    private ViewGroup pSx;
    private ViewGroup pSy;
    private String pSz;
    private String pbT;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1537);
        jl(1680);
        jl(2504);
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
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pSz = getIntent().getStringExtra("key_mch_name");
        this.pSN = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        this.pSD = getIntent().getDoubleExtra("key_money", 0.0d);
        this.pSC = getIntent().getStringExtra("key_rcver_name");
        this.pSM = getIntent().getStringExtra("key_rcver_true_name");
        this.pSA = getIntent().getStringExtra("key_rcv_desc");
        this.pSB = getIntent().getStringExtra("key_pay_desc");
        this.pSE = getIntent().getStringExtra("key_f2f_id");
        this.pbT = getIntent().getStringExtra("key_trans_id");
        this.pSa = getIntent().getStringExtra("key_rcvr_open_id");
        this.pSJ = getIntent().getStringExtra("key_check_sign");
        this.pSF = getIntent().getStringExtra("key_pay_desc");
        this.pSG = getIntent().getStringExtra("key_rcv_desc");
        this.pSH = getIntent().getIntExtra("key_scan_sceen", 0);
        this.oli = getIntent().getIntExtra("key_channel", 0);
        this.pSI = getIntent().getStringExtra("key_succ_page_extend");
        try {
            this.pSO.aH(getIntent().getByteArrayExtra("AfterPlaceOrderCommReq"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e, "", new Object[0]);
        }
        this.pSP = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.pPJ = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.pPK = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.pSL = false;
        x.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        l(new j(this.pSO, this.pSI));
        initView();
    }

    protected final void initView() {
        CharSequence string;
        this.jOY = (TextView) findViewById(f.uBn);
        this.pSp = (TextView) findViewById(f.uBe);
        this.pSq = (TextView) findViewById(f.uBi);
        this.pSr = (TextView) findViewById(f.uBg);
        this.pSw = (LinearLayout) findViewById(f.uBh);
        this.pSx = (LinearLayout) findViewById(f.uBf);
        this.pSs = (CdnImageView) findViewById(f.uBa);
        this.pSt = (TextView) findViewById(f.uBc);
        this.pSu = (TextView) findViewById(f.uBb);
        this.pSv = (Button) findViewById(f.uAY);
        this.pSy = (ViewGroup) findViewById(f.uAZ);
        this.pOv = (Button) findViewById(f.uBd);
        this.pSp.setText(e.t(this.pSD));
        String dF;
        Object string2;
        if (bi.oN(this.pSz)) {
            dF = e.dF(e.gw(this.pSC), 6);
            if (!bi.oN(this.pSM)) {
                string2 = getString(i.uTC, new Object[]{dF, this.pSM});
            }
            string2 = dF;
        } else {
            dF = e.dF(this.pSz, 6);
            if (!bi.oN(this.pSM)) {
                string2 = getString(i.uTC, new Object[]{dF, this.pSM});
            }
            string2 = dF;
        }
        if (bi.oN(this.pSA)) {
            this.pSw.setVisibility(8);
        } else {
            this.pSq.setText(this.pSA);
            this.pSw.setVisibility(0);
        }
        if (bi.oN(this.pSB)) {
            this.pSx.setVisibility(8);
        } else {
            this.pSr.setText(this.pSB);
            this.pSx.setVisibility(0);
        }
        this.pOv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RemittanceBusiResultUI.this.finish();
            }
        });
        this.pSR = (WalletSuccPageAwardWidget) findViewById(f.uli);
        this.pSW = (ViewGroup) findViewById(f.uqb);
        this.pSX = (ViewGroup) findViewById(f.upZ);
        this.pSY = (ViewGroup) findViewById(f.uzk);
        this.pSZ = (TextView) findViewById(f.uzj);
        this.pSS = (CdnImageView) findViewById(f.uBW);
        this.pST = (TextView) findViewById(f.uBk);
        this.pSU = findViewById(f.usn);
        this.pSV = (TextView) findViewById(f.uBj);
        this.pST.setText(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, string2));
        this.pSS.setVisibility(0);
        if (!bi.oN(this.pPK)) {
            if (this.pSP == 1) {
                this.pSS.vtN = true;
            }
            this.pSS.setUrl(this.pPK);
        } else if (this.pSP == 1) {
            com.tencent.mm.pluginsdk.ui.a.b.o(this.pSS, this.pSC);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.pSS, this.pSC);
        }
        this.pSU.setVisibility(8);
        this.pSV.setVisibility(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", jVar);
            } else if (jVar.pQg.kRz == 0) {
                x.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", jVar.pQg.sUS);
                this.pSQ = jVar.pQg.sUS;
                if (WalletSuccPageAwardWidget.a(this.pSQ)) {
                    x.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", this.pbT);
                    this.pSR.a(this, this.pSQ, this.pbT, true, (ImageView) findViewById(f.background));
                    this.pSR.init();
                    this.pSR.setVisibility(0);
                    final ImageView imageView = (ImageView) findViewById(f.background);
                    imageView.post(new Runnable() {
                        public final void run() {
                            ViewGroup viewGroup = (ViewGroup) RemittanceBusiResultUI.this.findViewById(f.uCP);
                            LayoutParams layoutParams = imageView.getLayoutParams();
                            layoutParams.width = viewGroup.getWidth();
                            layoutParams.height = viewGroup.getHeight();
                            imageView.setLayoutParams(layoutParams);
                        }
                    });
                    this.pSR.post(new Runnable() {
                        public final void run() {
                            View findViewById = RemittanceBusiResultUI.this.findViewById(f.ump);
                            if (findViewById != null) {
                                int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(RemittanceBusiResultUI.this, 25);
                                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                                marginLayoutParams.topMargin = fromDPToPix;
                                marginLayoutParams.bottomMargin = fromDPToPix;
                                findViewById.setLayoutParams(marginLayoutParams);
                                findViewById.setVisibility(0);
                            }
                        }
                    });
                } else {
                    this.pSR.setVisibility(8);
                }
                this.pSX.setVisibility(8);
                this.pSW.setVisibility(8);
                this.pSY.setVisibility(8);
                if (jVar.pQg.vWk == 1) {
                    this.pSU.setVisibility(0);
                    this.pSV.setVisibility(0);
                    this.pSV.setText(e.u(((double) jVar.pQg.vWh) / 100.0d));
                } else {
                    this.pSU.setVisibility(8);
                    this.pSV.setVisibility(8);
                }
                if (!(jVar == null || jVar.pQg == null || jVar.pQg.vWi.size() <= 0)) {
                    int size;
                    List list = jVar.pQg.vWi;
                    String str2 = "MicroMsg.RemittanceBusiResultUI";
                    String str3 = "discountInfoList: %s, size: %s received_amount: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = list;
                    if (list != null) {
                        size = list.size();
                    } else {
                        size = 0;
                    }
                    objArr[1] = Integer.valueOf(size);
                    objArr[2] = Long.valueOf(jVar.pQg.vWh);
                    x.i(str2, str3, objArr);
                    if (list != null && list.size() > 0) {
                        this.pSX.removeAllViews();
                        size = 0;
                        while (true) {
                            int i3 = size;
                            if (i3 >= list.size()) {
                                break;
                            }
                            String str4 = (String) list.get(i3);
                            View textView = new TextView(this.mController.xRr);
                            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.bottomMargin = com.tencent.mm.bu.a.fromDPToPix(this, 6);
                            textView.setLayoutParams(layoutParams);
                            textView.setTextSize(1, 12.0f);
                            textView.setTextColor(Color.parseColor("#FA962A"));
                            textView.setText(str4);
                            this.pSX.addView(textView);
                            size = i3 + 1;
                        }
                        this.pSX.setVisibility(0);
                        this.pSW.setVisibility(0);
                    }
                    if (jVar.pQg.vWh > 0) {
                        this.pSZ.setText(e.u(((double) jVar.pQg.vWh) / 100.0d));
                        this.pSZ.getPaint().setFlags(16);
                        this.pSY.setVisibility(0);
                    }
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", Integer.valueOf(jVar.pQg.kRz), jVar.pQg.kRA);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.f) {
            com.tencent.mm.plugin.remittance.model.f fVar = (com.tencent.mm.plugin.remittance.model.f) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", fVar);
            } else if (fVar.pPV.kRz == 0) {
                final jv jvVar = fVar.pPV.vVD;
                if (jvVar != null) {
                    this.pSs.setUrl(jvVar.fED);
                    this.pSt.setText(jvVar.title);
                    this.pSu.setText(jvVar.sTH);
                    this.pSv.setText(jvVar.taB);
                    this.pSv.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", Integer.valueOf(jvVar.type));
                            if (jvVar.type == 1) {
                                RemittanceBusiResultUI.this.pSL = true;
                                com.tencent.mm.sdk.b.b qrVar = new qr();
                                qrVar.fJd.userName = jvVar.vWU;
                                qrVar.fJd.fJf = bi.aD(jvVar.vWV, "");
                                qrVar.fJd.scene = 1034;
                                qrVar.fJd.fJg = 0;
                                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                            } else if (jvVar.type == 2) {
                                RemittanceBusiResultUI.this.pSL = true;
                                e.l(RemittanceBusiResultUI.this.mController.xRr, jvVar.url, true);
                            } else {
                                int i = jvVar.type;
                            }
                        }
                    });
                    this.pSv.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ukd);
                    this.pSv.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bul));
                    this.pSy.setVisibility(0);
                } else {
                    x.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.pSy.setVisibility(8);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", Integer.valueOf(fVar.pPV.kRz), fVar.pPV.kRA);
                Toast.makeText(this, fVar.pPV.kRA, 1).show();
            }
        }
        if (this.pSQ != null) {
            return this.pSR.d(i, i2, str, kVar);
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        if (this.pSL) {
            x.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            b(new com.tencent.mm.plugin.remittance.model.f(this.pSE, this.pbT, this.pSa, (int) Math.round(this.pSD * 100.0d), this.pSK, this.pSJ), false);
            this.pSL = false;
        }
        if (this.pSQ != null) {
            this.pSR.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1537);
        jm(1680);
        jm(2504);
        if (this.pSQ != null) {
            this.pSR.onDestroy();
        }
    }

    protected final int getLayoutId() {
        return g.uKz;
    }

    public final void uV(int i) {
        this.mController.contentView.setVisibility(i);
    }
}
