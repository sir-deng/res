package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.th;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemittanceBusiUI extends WalletBaseUI {
    private int oli;
    private ScrollView pOM;
    private int pRF;
    private LinearLayout pRR;
    private String pSE;
    private String pSF;
    private String pSJ;
    private BusiRemittanceResp pSN;
    private String pSa;
    private boolean pSd;
    private boolean pSg;
    private String pSz;
    private boolean pTA;
    private String pTB;
    private int pTC;
    private int pTD;
    private String pTE;
    private bpk pTF;
    private String pTG;
    private int pTH = 0;
    private int pTI = 0;
    private int pTJ = 0;
    private int pTK = 0;
    private String pTL;
    private a pTM = new a();
    private String pTN = "";
    private String pTO = "";
    boolean pTP = false;
    private double pTQ = -1.0d;
    private boolean pTR = false;
    g pTS = null;
    private a pTT;
    private a pTU;
    private Runnable pTV = new Runnable() {
        public final void run() {
            RemittanceBusiUI.D(RemittanceBusiUI.this);
        }
    };
    private c<l> pTW = new c<l>() {
        public final /* bridge */ /* synthetic */ boolean a(int i, int i2, d dVar) {
            return RemittanceBusiUI.a(RemittanceBusiUI.this, i, i2, (l) dVar);
        }

        public final void a(d dVar) {
            if (dVar instanceof l) {
                RemittanceBusiUI.this.hF(true);
            }
        }
    };
    private b pTX = new b();
    private com.tencent.mm.sdk.b.c pTY = new com.tencent.mm.sdk.b.c<th>() {
        {
            this.xmG = th.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            th thVar = (th) bVar;
            com.tencent.mm.sdk.b.a.xmy.c(RemittanceBusiUI.this.pTY);
            if (thVar.fMD.result == -1) {
                RemittanceBusiUI.this.pTn.performClick();
            }
            return false;
        }
    };
    private TextView pTd;
    private TextView pTe;
    private TextView pTf;
    private TextView pTg;
    private TextView pTh;
    private TextView pTi;
    private TextView pTj;
    private View pTk;
    private CdnImageView pTl;
    private WalletFormView pTm;
    private Button pTn;
    private LinearLayout pTo;
    private LinearLayout pTp;
    private TextView pTq;
    private View pTr;
    private TextView pTs;
    private String pTt;
    private double pTu;
    private String pTv;
    private String pTw;
    private String pTx;
    private String pTy;
    private int pTz;
    private String pbT;

    class b implements Runnable {
        public d pUn;

        b() {
        }

        public final void run() {
            e F = RemittanceBusiUI.this.pTW;
            d dVar = this.pUn;
            x.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", Integer.valueOf(F.rtType));
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(F.rtType, F);
            F.a(dVar);
        }
    }

    class a {
        private View kvL;
        private float pUh;
        private float pUi;
        private float pUj;
        private TenpaySecureEditText pUk;
        private TextView pUl;
        private View pUm;

        a(int i, int i2, float f) {
            this.pUh = (float) i;
            this.pUi = (float) i2;
            this.pUj = f;
        }

        final void update() {
            RemittanceBusiUI.this.pTg.setTextSize(1, RemittanceBusiUI.this.pTT.pUi);
            RemittanceBusiUI.this.pTq.setTextSize(1, RemittanceBusiUI.this.pTT.pUh);
            if (this.pUl == null) {
                this.pUl = (TextView) RemittanceBusiUI.this.pTm.findViewById(f.uGK);
            }
            if (this.pUl != null) {
                this.pUl.setTextSize(this.pUh);
            }
            if (this.pUk == null) {
                this.pUk = (TenpaySecureEditText) RemittanceBusiUI.this.pTm.findViewById(f.uFa);
            }
            if (this.pUk != null) {
                this.pUk.setTextSize(this.pUi);
            }
            if (this.kvL == null) {
                this.kvL = this.pUk.findViewById(f.uyd);
            }
            if (this.kvL != null) {
                this.kvL.setMinimumHeight(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, RemittanceBusiUI.this.pTT.pUi));
            }
            if (this.pUm == null) {
                this.pUm = RemittanceBusiUI.this.findViewById(f.uHf);
            }
            if (this.pUm != null) {
                ((LayoutParams) this.pUm.getLayoutParams()).topMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, this.pUj);
            }
        }
    }

    static /* synthetic */ void A(RemittanceBusiUI remittanceBusiUI) {
        List list = null;
        if (remittanceBusiUI.pRF == 33) {
            if (remittanceBusiUI.pSN.pPQ != null) {
                list = remittanceBusiUI.pSN.pPQ.vVE;
            }
        } else if (remittanceBusiUI.pTM.bol()) {
            list = remittanceBusiUI.pTM.bok();
            if (list.size() == 0) {
                x.i("MicroMsg.RemittanceBusiUI", "can not find favor %s", Integer.valueOf(list.size()));
                return;
            }
        } else {
            list = remittanceBusiUI.pSN.pPP;
        }
        remittanceBusiUI.pTu = remittanceBusiUI.boz();
        if (((int) Math.round(remittanceBusiUI.pTu * 100.0d)) <= 0) {
            remittanceBusiUI.bD(list);
        } else if (!remittanceBusiUI.pTM.bol()) {
            remittanceBusiUI.a(new com.tencent.mm.plugin.remittance.model.c() {
                public final void bC(List<we> list) {
                    if (list.size() > 0) {
                        RemittanceBusiUI.this.bD(list);
                    }
                }
            }, new com.tencent.mm.plugin.remittance.model.d() {
                public final void a(int i, int i2, g gVar) {
                    if (i != 0 || i2 != 0) {
                        u.makeText(RemittanceBusiUI.this.mController.xRr, RemittanceBusiUI.this.getString(i.uXI), 0).show();
                    } else if (gVar.pPX.kRz != 0) {
                        u.makeText(RemittanceBusiUI.this.mController.xRr, gVar.pPX.kRA, 0).show();
                    }
                }
            }, 0);
        } else if (remittanceBusiUI.pTS == null) {
            remittanceBusiUI.bD(list);
        } else if (remittanceBusiUI.pTS.pQa) {
            remittanceBusiUI.bD(list);
        } else {
            remittanceBusiUI.pTS.pPY = new com.tencent.mm.plugin.remittance.model.c() {
                public final void bC(List<we> list) {
                    RemittanceBusiUI.this.bD(list);
                }
            };
        }
    }

    static /* synthetic */ void D(RemittanceBusiUI remittanceBusiUI) {
        boolean z = false;
        if (remittanceBusiUI.pSN == null) {
            x.e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.pTS != null) {
                remittanceBusiUI.pTS.pQc = true;
                return;
            }
            return;
        }
        remittanceBusiUI.pTu = remittanceBusiUI.boz();
        x.i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", Integer.valueOf((int) Math.round(remittanceBusiUI.pTu * 100.0d)));
        if (((int) Math.round(remittanceBusiUI.pTu * 100.0d)) <= 0) {
            remittanceBusiUI.pTS.pQc = true;
            remittanceBusiUI.pTM.boj();
            remittanceBusiUI.pTj.setTextColor(-7829368);
            remittanceBusiUI.pTj.setText(remittanceBusiUI.pSN.pPL);
            if (remittanceBusiUI.pTS != null) {
                remittanceBusiUI.pTS.pQc = true;
                return;
            }
            return;
        }
        remittanceBusiUI.pTj.setText(i.uTz);
        k kVar = remittanceBusiUI.pTS;
        if (remittanceBusiUI.pTS.pPY != null) {
            z = true;
        }
        remittanceBusiUI.b(kVar, z);
    }

    static /* synthetic */ boolean a(RemittanceBusiUI remittanceBusiUI, int i, int i2, l lVar) {
        long j = 0;
        if (remittanceBusiUI.pTI == 0) {
            return false;
        }
        if (remittanceBusiUI.pTK >= remittanceBusiUI.pTI) {
            x.i("MicroMsg.RemittanceBusiUI", "mZero_start_time %s >= mZero_try_time %s say bye bye", Integer.valueOf(remittanceBusiUI.pTK), Integer.valueOf(remittanceBusiUI.pTI));
            return false;
        }
        remittanceBusiUI.pTX.pUn = lVar;
        Runnable runnable;
        if (i != 0 || i2 != 0) {
            remittanceBusiUI.pTK++;
            x.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTK), Integer.valueOf(remittanceBusiUI.pTJ));
            ah.K(remittanceBusiUI.pTX);
            runnable = remittanceBusiUI.pTX;
            if (remittanceBusiUI.pTJ >= 0) {
                j = (long) remittanceBusiUI.pTJ;
            }
            ah.h(runnable, j);
            return true;
        } else if (lVar.pQi.kRz == 0) {
            return false;
        } else {
            if (lVar.pQi.kRz == 0 || !lVar.mla) {
                return false;
            }
            remittanceBusiUI.pTK++;
            x.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTK), Integer.valueOf(remittanceBusiUI.pTJ));
            ah.K(remittanceBusiUI.pTX);
            runnable = remittanceBusiUI.pTX;
            if (remittanceBusiUI.pTJ >= 0) {
                j = (long) remittanceBusiUI.pTJ;
            }
            ah.h(runnable, j);
            return true;
        }
    }

    static /* synthetic */ void e(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.b(new s(remittanceBusiUI.pTv, remittanceBusiUI.pTt, remittanceBusiUI.pTy, remittanceBusiUI.pSa), false);
    }

    static /* synthetic */ void m(RemittanceBusiUI remittanceBusiUI) {
        if (bi.oN(remittanceBusiUI.pSF)) {
            remittanceBusiUI.pTh.setText("");
            remittanceBusiUI.pTi.setText(i.uBN);
            return;
        }
        remittanceBusiUI.pTh.setText(remittanceBusiUI.getString(i.uTB, new Object[]{remittanceBusiUI.pSF}));
        remittanceBusiUI.pTi.setText(i.uUp);
    }

    static /* synthetic */ void p(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.pSN == null) {
            x.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            return;
        }
        if (!remittanceBusiUI.pTA) {
            remittanceBusiUI.Xj();
        }
        int round = (int) Math.round(remittanceBusiUI.pTu * 100.0d);
        iu iuVar = remittanceBusiUI.pTM.pRv;
        remittanceBusiUI.b(new com.tencent.mm.plugin.remittance.model.i(remittanceBusiUI.pSa, remittanceBusiUI.pTt, remittanceBusiUI.pRF, remittanceBusiUI.pTx, remittanceBusiUI.pSF, round, remittanceBusiUI.oli, remittanceBusiUI.pTy, remittanceBusiUI.pTB, remittanceBusiUI.pTD, remittanceBusiUI.pTC, remittanceBusiUI.pTv, remittanceBusiUI.pTM.pRu, iuVar == null ? "" : iuVar.vVH, remittanceBusiUI.pSN.pPM), true);
    }

    private double boz() {
        if (this.pTA || this.pRF == 33) {
            return this.pTu;
        }
        this.pTu = bi.getDouble(this.pTm.getText(), 0.0d);
        return this.pTu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(1));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhN)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsL));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhN));
        }
        if (com.tencent.mm.compatible.util.d.fN(21)) {
            if (com.tencent.mm.compatible.util.d.fN(23)) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (RemittanceBusiUI.this.bKK()) {
                    RemittanceBusiUI.this.aWY();
                    RemittanceBusiUI.this.showDialog(1000);
                } else {
                    RemittanceBusiUI.this.finish();
                }
                return true;
            }
        }, h.dvZ);
        jl(1633);
        jl(1241);
        jl(2677);
        jl(2504);
        jl(2702);
        jl(2682);
        c cVar = this.pTW;
        Object obj = this.zSi;
        cVar.rtType = 2682;
        cVar.zRc = obj;
        obj.zRj.put(Integer.valueOf(2682), cVar);
        setMMTitle(i.uTA);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RemittanceBusiUI.e(RemittanceBusiUI.this);
                RemittanceBusiUI.this.finish();
                return false;
            }
        });
        this.pRF = getIntent().getIntExtra("pay_scene", 31);
        this.pTt = getIntent().getStringExtra("scan_remittance_id");
        this.pTu = getIntent().getDoubleExtra("fee", 0.0d);
        this.pTv = getIntent().getStringExtra("receiver_name");
        this.pTw = getIntent().getStringExtra("receiver_true_name");
        this.oli = getIntent().getIntExtra("pay_channel", 0);
        this.pTx = getIntent().getStringExtra("desc");
        this.pTz = getIntent().getIntExtra("busi_type", 0);
        this.pSz = getIntent().getStringExtra("mch_name");
        this.pTB = getIntent().getStringExtra("mch_type");
        this.pTD = getIntent().getIntExtra("mch_time", 0);
        this.pTC = getIntent().getIntExtra("get_pay_wifi", 0);
        this.pSa = getIntent().getStringExtra("rcvr_open_id");
        this.pTy = getIntent().getStringExtra("rcvr_ticket");
        this.pTL = getIntent().getStringExtra("receiver_tips");
        this.pSN = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        if (this.pSN != null) {
            boolean z = this.pRF == 32 && (this.pSN.pPR == 1 || (this.pSN != null && this.pSN.pPP.size() > 0));
            this.pTP = z;
        }
        if (this.pTu > 0.0d) {
            this.pTA = true;
        } else {
            this.pTA = false;
        }
        if (this.pTz == 0) {
            x.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
            finish();
        }
        this.pTT = new a(28, 28, 2.0f);
        this.pTU = new a(50, 50, 8.0f);
        initView();
    }

    protected final void initView() {
        this.pOM = (ScrollView) findViewById(f.uCJ);
        this.pTd = (TextView) findViewById(f.uBY);
        this.pTe = (TextView) findViewById(f.uBZ);
        this.pTf = (TextView) findViewById(f.uBV);
        this.pTg = (TextView) findViewById(f.uBT);
        this.pTh = (TextView) findViewById(f.uBO);
        this.pTi = (TextView) findViewById(f.uBN);
        this.pTl = (CdnImageView) findViewById(f.uBW);
        this.pTm = (WalletFormView) findViewById(f.uBX);
        this.pTn = (Button) findViewById(f.uCa);
        this.pTo = (LinearLayout) findViewById(f.uBU);
        this.pRR = (LinearLayout) findViewById(f.uBQ);
        this.pTp = (LinearLayout) findViewById(f.uBP);
        this.pTj = (TextView) findViewById(f.uqP);
        this.pTk = findViewById(f.uBR);
        this.pTq = (TextView) findViewById(f.uBS);
        this.pTr = findViewById(f.uqY);
        this.pTs = (TextView) findViewById(f.uqX);
        if (this.pTA) {
            if (!bi.oN(this.pTx)) {
                this.pTf.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, this.pTx, this.pTf.getTextSize()));
            }
            this.pTg.setText(com.tencent.mm.wallet_core.ui.e.t(this.pTu));
            this.pTo.setVisibility(0);
            this.pRR.setVisibility(8);
        } else {
            boolean z;
            if (this.pSN != null) {
                if (this.pSN.pPP.size() > 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.pSN.pPQ != null && this.pSN.pPQ.vVE.size() > 0) {
                    z = false;
                }
            } else {
                z = true;
            }
            b(this.pTm, 2, false, z);
            this.pTm.a(new TextWatcher() {
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
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                    if (RemittanceBusiUI.this.pRF == 32) {
                        RemittanceBusiUI.this.a(null, null, RemittanceBusiUI.this.pSN == null ? 400 : RemittanceBusiUI.this.pSN.pPT);
                    }
                }
            });
            this.pTo.setVisibility(8);
            this.pRR.setVisibility(0);
        }
        if (com.tencent.mm.kernel.g.Do().CF()) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.k.a Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(this.pTv);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                com.tencent.mm.y.ak.a.hhv.a(this.pTv, "", new com.tencent.mm.y.ak.b.a() {
                    public final void v(String str, boolean z) {
                        x.i("MicroMsg.RemittanceBusiUI", "getContact %s", Boolean.valueOf(z));
                        RemittanceBusiUI.this.bow();
                    }
                });
            }
        }
        bow();
        this.pTp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!RemittanceBusiUI.this.pTA) {
                    RemittanceBusiUI.this.Xj();
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(6));
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(i.uBN), RemittanceBusiUI.this.pSF, RemittanceBusiUI.this.getString(i.uTx), 20, new com.tencent.mm.ui.base.h.b() {
                    public final boolean v(CharSequence charSequence) {
                        RemittanceBusiUI.this.pSF = charSequence.toString();
                        RemittanceBusiUI.m(RemittanceBusiUI.this);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ah.h(new Runnable() {
                            public final void run() {
                                RemittanceBusiUI.this.aWY();
                            }
                        }, 500);
                    }
                });
            }
        });
        this.pTn.setOnClickListener(new r() {
            public final void azE() {
                com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(5));
                if (!RemittanceBusiUI.this.pTA) {
                    RemittanceBusiUI.this.pTu = RemittanceBusiUI.this.boz();
                }
                if (RemittanceBusiUI.this.pTu <= 0.0d) {
                    u.makeText(RemittanceBusiUI.this.mController.xRr, i.uWd, 0).show();
                    return;
                }
                String str;
                String str2 = "MicroMsg.RemittanceBusiUI";
                String str3 = "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s";
                Object[] objArr = new Object[3];
                objArr[0] = RemittanceBusiUI.this.pTS;
                if (RemittanceBusiUI.this.pTS == null) {
                    str = "";
                } else {
                    str = RemittanceBusiUI.this.pTS.pQa;
                }
                objArr[1] = str;
                objArr[2] = Boolean.valueOf(RemittanceBusiUI.this.pTP);
                x.i(str2, str3, objArr);
                if (RemittanceBusiUI.this.pRF == 32) {
                    if (!RemittanceBusiUI.this.pTP) {
                        RemittanceBusiUI.p(RemittanceBusiUI.this);
                        return;
                    } else if (RemittanceBusiUI.this.pTS == null || RemittanceBusiUI.this.pTS.pQd != ((int) (RemittanceBusiUI.this.pTu * 100.0d))) {
                        RemittanceBusiUI.this.a(new com.tencent.mm.plugin.remittance.model.c() {
                            public final void bC(List<we> list) {
                                RemittanceBusiUI.p(RemittanceBusiUI.this);
                            }
                        }, null, 0);
                        return;
                    } else if (RemittanceBusiUI.this.pTS == null || !RemittanceBusiUI.this.pTS.pQa) {
                        if (RemittanceBusiUI.this.pTS != null) {
                            RemittanceBusiUI.this.pTS.pPY = new com.tencent.mm.plugin.remittance.model.c() {
                                public final void bC(List<we> list) {
                                    RemittanceBusiUI.p(RemittanceBusiUI.this);
                                }
                            };
                            return;
                        }
                        return;
                    }
                }
                RemittanceBusiUI.p(RemittanceBusiUI.this);
            }
        });
        this.pOM.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (RemittanceBusiUI.this.pTR) {
                    RemittanceBusiUI.this.Xj();
                }
                return false;
            }
        });
        this.olj = new com.tencent.mm.wallet_core.ui.a() {
            public final void hE(boolean z) {
                RemittanceBusiUI.this.pTR = z;
                if (z) {
                    RemittanceBusiUI.this.a(RemittanceBusiUI.this.pOM, RemittanceBusiUI.this.pTn, 30);
                    return;
                }
                RemittanceBusiUI.this.pOM.scrollTo(0, 0);
                if (RemittanceBusiUI.this.pTm != null && RemittanceBusiUI.this.pTm.getVisibility() == 0) {
                    RemittanceBusiUI.this.pTm.setFocusable(false);
                    RemittanceBusiUI.this.pTm.setFocusable(true);
                }
            }
        };
        if (!(this.pSN == null || this.pSN.pPQ == null)) {
            this.pTM.pRv = this.pSN.pPQ;
            this.pTM.IY(this.pSN.pPQ.vVG);
        }
        if (boA()) {
            com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(2));
        }
    }

    private void bow() {
        ah.y(new Runnable() {
            public final void run() {
                RemittanceBusiUI.this.pTd.setText(RemittanceBusiUI.this.pTL);
                CharSequence dF = com.tencent.mm.wallet_core.ui.e.dF(com.tencent.mm.wallet_core.ui.e.gw(RemittanceBusiUI.this.pTv), 10);
                if (!bi.oN(RemittanceBusiUI.this.pTw)) {
                    dF = RemittanceBusiUI.this.getString(i.uTC, new Object[]{dF, RemittanceBusiUI.this.pTw});
                }
                RemittanceBusiUI.this.pTe.setText(com.tencent.mm.pluginsdk.ui.d.i.b(RemittanceBusiUI.this, dF, RemittanceBusiUI.this.pTe.getTextSize()));
                if (RemittanceBusiUI.this.pSN != null) {
                    if (RemittanceBusiUI.this.pSN.pPJ != 1) {
                        RemittanceBusiUI.this.pTl.setVisibility(8);
                        return;
                    } else if (!bi.oN(RemittanceBusiUI.this.pSN.pPK)) {
                        if (RemittanceBusiUI.this.pSN.pPS == 1) {
                            RemittanceBusiUI.this.pTl.vtN = true;
                        } else {
                            RemittanceBusiUI.this.pTl.vtN = false;
                        }
                        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, 36.0f);
                        RemittanceBusiUI.this.pTl.i(RemittanceBusiUI.this.pSN.pPK, b, b, -1);
                        return;
                    } else if (!bi.oN(RemittanceBusiUI.this.pTv)) {
                        if (RemittanceBusiUI.this.pSN.pPS == 1) {
                            com.tencent.mm.pluginsdk.ui.a.b.o(RemittanceBusiUI.this.pTl, RemittanceBusiUI.this.pTv);
                            return;
                        } else {
                            com.tencent.mm.pluginsdk.ui.a.b.a(RemittanceBusiUI.this.pTl, RemittanceBusiUI.this.pTv);
                            return;
                        }
                    }
                }
                RemittanceBusiUI.this.pTl.setVisibility(8);
            }
        });
    }

    private boolean boA() {
        if (this.pTk == null || this.pSN == null) {
            return false;
        }
        boolean z;
        x.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if (this.pSN.pPQ == null || this.pSN.pPQ.vVF.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (this.pSN.pPP.size() > 0) {
            z = true;
        }
        if (this.pTM.bok().size() > 0) {
            z = true;
        }
        if (z) {
            this.pTr.setVisibility(0);
            this.pTT.update();
            this.pTk.setVisibility(0);
            this.pTj.setText(this.pSN.pPL);
            this.pTj.setTextColor(-7829368);
            this.pTs.setText(com.tencent.mm.wallet_core.ui.e.t(boz()));
            wd wdVar = this.pTM.pRu;
            if (wdVar != null) {
                this.pTj.setTextColor(-30434);
                this.pTj.setText(wdVar.pPL);
                this.pTs.setText(com.tencent.mm.wallet_core.ui.e.t(((double) wdVar.wmK) / 100.0d));
            } else {
                a aVar = this.pTM;
                CharSequence charSequence = aVar.pRv == null ? "" : aVar.pRv.vVI;
                if (!bi.oN(charSequence)) {
                    this.pTj.setTextColor(-7829368);
                    this.pTj.setText(charSequence);
                }
            }
            findViewById(f.uqM).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(3));
                    RemittanceBusiUI.A(RemittanceBusiUI.this);
                }
            });
            return true;
        }
        this.pTk.setVisibility(8);
        this.pTU.update();
        this.pTr.setVisibility(8);
        return false;
    }

    private void bD(final List<we> list) {
        final com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(this);
        ArrayList arrayList = new ArrayList();
        wd wdVar = this.pTM.pRu;
        HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        if (this.pTM.bom() && wdVar != null) {
            Iterator it = wdVar.vVE.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((we) it.next()).wmR));
            }
        }
        int i = 0;
        for (we weVar : list) {
            if (hashSet.contains(Long.valueOf(weVar.wmR))) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        CharSequence string = getString(i.uUr);
        if (string != null && string.length() > 0) {
            cVar.zHl.setVisibility(0);
            cVar.zHm.setText(string);
        }
        cVar.zHn = arrayList;
        cVar.rQF = new p.c() {
            public final void a(n nVar) {
                int i = 0;
                RemittanceBusiUI.this.pTu = RemittanceBusiUI.this.boz();
                if (!RemittanceBusiUI.this.pTM.bom() || RemittanceBusiUI.this.pTu <= 0.0d) {
                    for (we weVar : list) {
                        nVar.a(i, weVar.wmS, weVar.wmU, null, true);
                        hashSet2.add(Integer.valueOf(i));
                        i++;
                    }
                    return;
                }
                for (we weVar2 : list) {
                    if (weVar2.wna == 1) {
                        nVar.a(i, weVar2.wmS, weVar2.wmU, null, true);
                        hashSet2.add(Integer.valueOf(i));
                    } else {
                        nVar.a(i, weVar2.wmS, weVar2.wmU);
                    }
                    i++;
                }
            }
        };
        cVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (!hashSet2.contains(Integer.valueOf(i)) && i < list.size()) {
                    boolean z;
                    int intValue;
                    com.tencent.mm.plugin.report.service.g.pWK.h(15235, Integer.valueOf(4));
                    we weVar = (we) list.get(i);
                    com.tencent.mm.ui.widget.picker.c cVar = cVar;
                    List<Integer> cAo = cVar.zHo != null ? cVar.zHo.cAo() : new ArrayList();
                    boolean contains = cAo.contains(Integer.valueOf(i));
                    if (contains) {
                        z = false;
                    } else {
                        z = true;
                    }
                    List linkedList = new LinkedList();
                    for (Integer intValue2 : cAo) {
                        intValue = intValue2.intValue();
                        if (intValue < list.size() && (z || i != intValue)) {
                            linkedList.add((we) list.get(intValue));
                        }
                    }
                    if (z) {
                        linkedList.add(weVar);
                    }
                    a B = RemittanceBusiUI.this.pTM;
                    if (!z) {
                        weVar = null;
                    }
                    B.a(linkedList, weVar);
                    wd wdVar = RemittanceBusiUI.this.pTM.pRu;
                    HashSet hashSet = new HashSet();
                    if (wdVar != null) {
                        Iterator it = wdVar.vVE.iterator();
                        while (it.hasNext()) {
                            hashSet.add(Long.valueOf(((we) it.next()).wmR));
                        }
                    }
                    HashMap hashMap = new HashMap();
                    intValue = 0;
                    for (we weVar2 : list) {
                        if (hashSet.contains(Long.valueOf(weVar2.wmR))) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(true));
                        } else {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(false));
                        }
                        if (intValue == i) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(contains));
                        }
                        intValue++;
                    }
                    com.tencent.mm.ui.widget.picker.c cVar2 = cVar;
                    if (cVar2.zHo != null) {
                        cVar2.zHo.zHr = hashMap;
                        cVar2.zHo.notifyDataSetChanged();
                    }
                }
            }
        };
        cVar.zHp = new com.tencent.mm.ui.widget.picker.c.b() {
            public final void hG(boolean z) {
                if (z) {
                    wd wdVar = RemittanceBusiUI.this.pTM.pRu;
                    String str = "MicroMsg.RemittanceBusiUI";
                    String str2 = "onFavorSelected %s ";
                    Object[] objArr = new Object[1];
                    objArr[0] = wdVar == null ? "" : com.tencent.mm.plugin.remittance.model.a.a(wdVar);
                    x.i(str, str2, objArr);
                    RemittanceBusiUI.this.boA();
                }
            }
        };
        if (cVar.rQF != null) {
            cVar.rQF.a(cVar.rQH);
        }
        cVar.zHo = new com.tencent.mm.ui.widget.picker.c.a(cVar.mContext);
        cVar.zHo.cAn();
        cVar.zHk.setAdapter(cVar.zHo);
        cVar.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c.a(c.this, true, c.this.zHo.cAo());
                c.this.hide();
            }
        });
        cVar.kxL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c.a(c.this, false, null);
                c.this.hide();
            }
        });
        if (cVar.yQT != null) {
            if (cVar.rQH != null && cVar.rQH.size() > 3) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.lHV.getLayoutParams();
                layoutParams.height = cVar.yQU;
                cVar.lHV.setLayoutParams(layoutParams);
            }
            cVar.yQT.show();
        }
    }

    private void a(com.tencent.mm.plugin.remittance.model.c cVar, com.tencent.mm.plugin.remittance.model.d dVar, int i) {
        if (this.pTP) {
            this.pTs.setText(com.tencent.mm.wallet_core.ui.e.t(boz()));
            ah.K(this.pTV);
            this.pTu = boz();
            long round = Math.round(this.pTu * 100.0d);
            if (round <= 0) {
                this.pTM.boj();
                this.pTj.setTextColor(-7829368);
                this.pTj.setText(this.pSN.pPL);
                if (this.pTS != null) {
                    this.pTS.pQc = true;
                    return;
                }
                return;
            }
            this.pTS = new g((int) round, this.oli, this.pSN.pPM, this.pTx, this.pSz, this.pSN.pPN, this.pSa, this.pTv, this.pSN.pPO, cVar == null ? 0 : 1, cVar, dVar);
            ah.h(this.pTV, (long) i);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.pTY);
        jm(1633);
        jm(1241);
        jm(2677);
        jm(2504);
        jm(2702);
        jm(2682);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = true;
        if (kVar instanceof com.tencent.mm.plugin.remittance.model.i) {
            com.tencent.mm.plugin.remittance.model.i iVar = (com.tencent.mm.plugin.remittance.model.i) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiUI", "net error: %s", kVar);
            } else if (iVar.pQf.kRz == 0) {
                this.pSE = iVar.pQf.vOg;
                this.pbT = iVar.pQf.vOh;
                this.pSJ = iVar.pQf.vOi;
                this.pTN = iVar.pQf.vVW;
                this.pTO = iVar.pQf.vVV;
                this.pTE = iVar.pQf.vWb;
                this.pTF = iVar.pQf.vWa;
                this.pTH = iVar.pQf.vWe;
                this.pTI = iVar.pQf.vWc;
                this.pTJ = iVar.pQf.vWd;
                x.i("MicroMsg.RemittanceBusiUI", "touch_challenge %s need_change_auth_key %s", iVar.pQf.vWf, Integer.valueOf(iVar.pQf.vWg));
                if (iVar.pQf.vWf != null) {
                    com.tencent.mm.plugin.wallet_core.model.s.sVy.mFv = iVar.pQf.vWf.cec();
                }
                com.tencent.mm.plugin.wallet_core.model.s sVar = com.tencent.mm.plugin.wallet_core.model.s.sVy;
                if (iVar.pQf.vWg != 1) {
                    z = false;
                }
                sVar.mFw = z;
                if (!a(iVar)) {
                    b(iVar);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", Integer.valueOf(iVar.pQf.kRz), iVar.pQf.kRA);
                if (iVar.pQf.vVU == null || bi.oN(iVar.pQf.vVU.ojb)) {
                    Toast.makeText(this, iVar.pQf.kRA, 1).show();
                } else {
                    a(iVar);
                }
                if (iVar.pQf.vVX == 1) {
                    a(null, null, 0);
                }
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.h) {
            x.i("MicroMsg.RemittanceBusiUI", "pay check callback");
            return true;
        } else if (kVar instanceof g) {
            x.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", kVar, Integer.valueOf(i), Integer.valueOf(i2));
            g gVar = (g) kVar;
            if (!gVar.pQb.equals(this.pTS.pQb) || gVar.pQc) {
                gVar.pQa = true;
                x.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", Boolean.valueOf(gVar.pQc));
                return true;
            }
            com.tencent.mm.plugin.remittance.model.d dVar;
            if (i != 0 || i2 != 0) {
                this.pTM.boj();
                if (!(this.pSN == null || bi.oN(this.pSN.pPL))) {
                    this.pTj.setText(this.pSN.pPL);
                }
                this.pTj.setTextColor(-7829368);
                this.pTj.setText(getString(i.uTy));
                dVar = gVar.pPZ;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            } else if (gVar.pPX.kRz == 0) {
                this.pTM.pRv = gVar.pPX.pPQ;
                this.pTM.IY(gVar.pPX.pPQ.vVG);
                boA();
                com.tencent.mm.plugin.remittance.model.c cVar = gVar.pPY;
                x.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", cVar);
                if (cVar != null) {
                    cVar.bC(this.pTM.bok());
                }
            } else {
                this.pTM.boj();
                this.pTj.setTextColor(-7829368);
                this.pTj.setText(gVar.pPX.kRA);
                dVar = gVar.pPZ;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            }
            gVar.pQa = true;
            return true;
        } else if (kVar instanceof l) {
            l lVar = (l) kVar;
            x.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", Boolean.valueOf(lVar.pQj));
            if (i != 0 || i2 != 0) {
                com.tencent.mm.ui.base.h.a((Context) this, getString(i.vdG), null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (lVar.pQi.kRz == 0) {
                boC();
            } else {
                boB();
                com.tencent.mm.ui.base.h.a((Context) this, lVar.pQi.kRA, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        String stringExtra;
        if (i == 1) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("key_trans_id");
                double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
                x.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", stringExtra, Double.valueOf(doubleExtra));
                if (bi.oN(this.pbT)) {
                    this.pbT = stringExtra;
                }
                if (doubleExtra >= 0.0d) {
                    this.pTQ = doubleExtra;
                }
                boC();
                x.i("MicroMsg.RemittanceBusiUI", "do pay check");
                int round = (int) Math.round(this.pTu * 100.0d);
                cg cgVar = new cg();
                cgVar.fDM = this.oli;
                cgVar.vOg = this.pSE;
                cgVar.vOh = this.pbT;
                cgVar.pPM = this.pSN.pPM;
                cgVar.scene = this.pRF;
                cgVar.vOi = this.pSJ;
                cgVar.vOj = this.pTM.pRu;
                cgVar.vOk = this.pTv;
                cgVar.pQZ = this.pSa;
                cgVar.vOl = round;
                b(new com.tencent.mm.plugin.remittance.model.h(cgVar, this.pTN), false);
            } else {
                x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
                boB();
            }
        } else if (i == 2) {
            if (i2 == -1) {
                this.pTG = intent.getStringExtra("INTENT_RESULT_TOKEN");
                this.pTQ = 0.0d;
                x.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", stringExtra);
                hF(false);
            }
            boB();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void hF(boolean z) {
        x.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", Boolean.valueOf(z));
        wd wdVar = this.pTM.pRu;
        int round = (int) Math.round(this.pTu * 100.0d);
        cg cgVar = new cg();
        cgVar.fDM = this.oli;
        cgVar.vOg = this.pSE;
        cgVar.vOh = this.pbT;
        cgVar.pPM = this.pSN.pPM;
        cgVar.scene = this.pRF;
        cgVar.vOi = this.pSJ;
        cgVar.vOj = wdVar;
        cgVar.vOk = this.pTv;
        cgVar.pQZ = this.pSa;
        cgVar.vOl = round;
        k lVar = new l(this.pTF, cgVar, this.pTE, z ? 1 : 0, this.pTG);
        if (z) {
            lVar.pQj = true;
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(lVar, 0);
            return;
        }
        this.pTK = 0;
        r(lVar);
    }

    private void boB() {
        wd wdVar = this.pTM.pRu;
        if (wdVar == null) {
            x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            return;
        }
        int round = (int) Math.round(this.pTu * 100.0d);
        cg cgVar = new cg();
        cgVar.fDM = this.oli;
        cgVar.vOg = this.pSE;
        cgVar.vOh = this.pbT;
        cgVar.pPM = this.pSN.pPM;
        cgVar.scene = this.pRF;
        cgVar.vOi = this.pSJ;
        cgVar.vOj = wdVar;
        cgVar.vOk = this.pTv;
        cgVar.pQZ = this.pSa;
        cgVar.vOl = round;
        b(new com.tencent.mm.plugin.remittance.model.k(cgVar, this.pTN), false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uKA;
    }

    private void boC() {
        x.i("MicroMsg.RemittanceBusiUI", "goto busi result");
        Intent intent = new Intent(this, RemittanceBusiResultUI.class);
        intent.putExtra("key_pay_desc", this.pSF);
        intent.putExtra("key_rcv_desc", this.pTx);
        if (this.pSN != null) {
            intent.putExtra("BusiRemittanceResp", this.pSN);
        }
        intent.putExtra("key_mch_name", this.pSz);
        intent.putExtra("key_rcver_name", this.pTv);
        intent.putExtra("key_rcver_true_name", this.pTw);
        if (this.pTQ >= 0.0d) {
            intent.putExtra("key_money", this.pTQ);
        } else {
            intent.putExtra("key_money", this.pTu);
        }
        intent.putExtra("key_f2f_id", this.pSE);
        intent.putExtra("key_trans_id", this.pbT);
        intent.putExtra("key_check_sign", this.pSJ);
        intent.putExtra("key_rcvr_open_id", this.pSa);
        intent.putExtra("key_channel", this.oli);
        if (this.pSN != null) {
            intent.putExtra("key_succ_show_avatar_type", this.pSN.pPS);
            intent.putExtra("key_succ_show_avatar_show", this.pSN.pPJ);
            intent.putExtra("key_succ_show_avatar_url", this.pSN.pPK);
        }
        if (this.pSN != null) {
            intent.putExtra("key_scan_sceen", this.pSN.pPM);
        }
        intent.putExtra("key_succ_page_extend", this.pTO);
        wd wdVar = this.pTM.pRu;
        int round = (int) Math.round(this.pTu * 100.0d);
        cg cgVar = new cg();
        cgVar.fDM = this.oli;
        cgVar.vOg = this.pSE;
        cgVar.vOh = this.pbT;
        cgVar.pPM = this.pSN.pPM;
        cgVar.scene = this.pRF;
        cgVar.vOi = this.pSJ;
        cgVar.vOj = wdVar;
        cgVar.vOk = this.pTv;
        cgVar.pQZ = this.pSa;
        cgVar.vOl = round;
        try {
            intent.putExtra("AfterPlaceOrderCommReq", cgVar.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
        }
        startActivity(intent);
        finish();
    }

    private boolean a(final com.tencent.mm.plugin.remittance.model.i iVar) {
        boolean z;
        if (this.pSd) {
            z = false;
        } else if (bi.oN(iVar.pQf.vVT)) {
            z = false;
        } else {
            this.pSd = true;
            com.tencent.mm.ui.base.h.a((Context) this, iVar.pQf.vVT, getString(i.dGE), getString(i.uTw), getString(i.dEy), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (RemittanceBusiUI.this.a(iVar)) {
                        RemittanceBusiUI.this.boB();
                    } else {
                        RemittanceBusiUI.this.b(iVar);
                    }
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RemittanceBusiUI.this.boB();
                }
            });
            z = true;
        }
        if (z) {
            return z;
        }
        if (iVar.pQf.vVU == null) {
            return false;
        }
        this.pSg = true;
        com.tencent.mm.ui.base.h.a((Context) this, iVar.pQf.kRA, "", iVar.pQf.vVU.ojc, iVar.pQf.vVU.ojb, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", iVar.pQf.vVU.loA);
                com.tencent.mm.wallet_core.ui.e.l(RemittanceBusiUI.this.mController.xRr, iVar.pQf.vVU.loA, false);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected void onNewIntent(Intent intent) {
        x.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    }

    private void b(com.tencent.mm.plugin.remittance.model.i iVar) {
        x.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", Integer.valueOf(iVar.pQf.vVY));
        Bundle bundle;
        if (iVar.pQf.vVY == 1) {
            ja jaVar = iVar.pQf;
            x.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", Integer.valueOf(jaVar.vVZ));
            if (jaVar.vVZ == 1) {
                bundle = new Bundle();
                com.tencent.mm.sdk.b.a.xmy.b(this.pTY);
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putInt("entry_scene", this.pRF);
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                return;
            }
            String str;
            Intent intent = new Intent();
            String str2 = "";
            if (bi.oN(this.pTL)) {
                String string = getString(i.vbW);
                if (bi.oN(this.pTv)) {
                    x.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    str = str2;
                } else {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.storage.x Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(this.pTv);
                    if (Xt != null) {
                        Object[] objArr = new Object[1];
                        objArr[0] = com.tencent.mm.wallet_core.ui.e.abr(Xt.AX()) + (bi.oN(this.pTw) ? "" : "(" + this.pTw + ")");
                        str = bi.j(string, objArr);
                    } else {
                        x.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.pTv);
                        str = str2;
                    }
                }
            } else {
                str = this.pTL;
            }
            intent.putExtra("INTENT_TITLE", str);
            intent.putExtra("INTENT_CAN_TOUCH", this.pTH);
            intent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.e.t(0.0d));
            try {
                intent.putExtra("INTENT_TOKENMESS", jaVar.vWa.toByteArray());
                com.tencent.mm.bl.d.b(this.mController.xRr, "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", intent, 2);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
                return;
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = iVar.pQf.fxT;
        payInfo.fDQ = this.pRF;
        if (this.oli > 0) {
            payInfo.fDM = this.oli;
        }
        bundle = new Bundle();
        bundle.putString("extinfo_key_1", this.pTv);
        bundle.putString("extinfo_key_2", this.pTw);
        bundle.putString("extinfo_key_3", this.pTx);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_7", this.pSF);
        payInfo.vGl = bundle;
        payInfo.pQV = 1;
        com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, this.pTw, new Intent(), 1);
    }
}
