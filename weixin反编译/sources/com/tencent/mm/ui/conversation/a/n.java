package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.kd;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

public final class n extends b {
    private boolean hGJ = false;
    TextView ikL;
    private TextView ikM;
    private ProgressDialog inI = null;
    private ImageView jIs;
    View kvL = null;
    private TextView sej;
    int slp = 0;
    c<kd> zkA;
    boolean zkB = false;
    private TextView zkm;
    private TextView zkn;
    private ImageView zko;
    private ImageView zkp;
    private ImageView zkq;
    private ProgressBar zkr;
    String zks;
    private boolean zkt = false;
    int zku;
    boolean zkv;
    boolean zkw;
    boolean zkx;
    String zky;
    al zkz;

    static /* synthetic */ void a(n nVar, int i) {
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i);
        intent.putExtra("diagnose_percent", nVar.zku);
        intent.putExtra("diagnose_kvInfo", nVar.zky);
        x.i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", Integer.valueOf(i), Integer.valueOf(nVar.zku), nVar.zky);
        d.b((Context) nVar.vvl.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
    }

    public n(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.doV;
    }

    private void initialize() {
        if (!this.zkt && this.view != null) {
            this.kvL = this.view.findViewById(R.h.cBD);
            this.ikL = (TextView) this.view.findViewById(R.h.cBy);
            this.ikM = (TextView) this.view.findViewById(R.h.cBz);
            this.sej = (TextView) this.view.findViewById(R.h.cBA);
            this.zkm = (TextView) this.view.findViewById(R.h.cBx);
            this.zkr = (ProgressBar) this.view.findViewById(R.h.cBC);
            this.jIs = (ImageView) this.view.findViewById(R.h.cBB);
            this.zko = (ImageView) this.view.findViewById(R.h.bWn);
            this.zkp = (ImageView) this.view.findViewById(R.h.cje);
            this.zkq = (ImageView) this.view.findViewById(R.h.cOF);
            this.zkn = (TextView) this.view.findViewById(R.h.cer);
            this.zko.setVisibility(8);
            this.zkt = true;
        }
    }

    final void cxJ() {
        if (this.zkz != null) {
            this.zkz.TN();
            this.zkz = null;
        }
    }

    public final boolean alN() {
        boolean z;
        int i = 0;
        int Ks = as.CN().Ks();
        String networkServerIp = as.CN().getNetworkServerIp();
        this.zks = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.vHl), com.tencent.mm.protocal.d.DEVICE_TYPE, q.FY(), networkServerIp, w.cfV()});
        initialize();
        x.i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(Ks));
        switch (Ks) {
            case 0:
                this.ikL.setText(R.l.exR);
                this.ikM.setVisibility(8);
                this.zkm.setVisibility(8);
                this.zkr.setVisibility(8);
                this.jIs.setVisibility(0);
                this.kvL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("title", ((Context) n.this.vvl.get()).getString(R.l.exR));
                        intent.putExtra("rawUrl", ((Context) n.this.vvl.get()).getString(R.l.exO));
                        intent.putExtra("showShare", false);
                        d.b((Context) n.this.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                z = true;
                break;
            case 2:
                if (this.slp == 1) {
                    this.ikL.setText(((Context) this.vvl.get()).getResources().getString(R.l.exQ, new Object[]{Integer.valueOf(this.zku)}));
                } else {
                    this.ikL.setText(R.l.exP);
                }
                this.ikM.setVisibility(8);
                this.zkm.setVisibility(8);
                this.zkr.setVisibility(8);
                this.jIs.setVisibility(0);
                this.kvL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        n nVar;
                        n.a(n.this, n.this.slp);
                        n.this.slp = 1;
                        if (n.this.zkA == null) {
                            nVar = n.this;
                            nVar.zkA = new c<kd>() {
                                {
                                    this.xmG = kd.class.getName().hashCode();
                                }

                                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                    boolean z = true;
                                    kd kdVar = (kd) bVar;
                                    x.v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", Integer.valueOf(kdVar.fCm.fCn), Integer.valueOf(kdVar.fCm.status));
                                    n nVar;
                                    if (kdVar.fCm.fCn == 0) {
                                        n.this.zku = 33;
                                        nVar = n.this;
                                        if (kdVar.fCm.status != 0) {
                                            z = false;
                                        }
                                        nVar.zkv = z;
                                    } else if (kdVar.fCm.fCn == 1) {
                                        n.this.zku = 66;
                                        nVar = n.this;
                                        if (kdVar.fCm.status != 0) {
                                            z = false;
                                        }
                                        nVar.zkw = z;
                                    } else if (kdVar.fCm.fCn == 2) {
                                        nVar = n.this;
                                        if (kdVar.fCm.status != 0) {
                                            z = false;
                                        }
                                        nVar.zkx = z;
                                    }
                                    if (kdVar.fCm.fCo) {
                                        n.this.zku = 0;
                                        n.this.slp = 0;
                                        n.this.zky = kdVar.fCm.fCp;
                                        n.this.cxJ();
                                        ah.y(new Runnable() {
                                            public final void run() {
                                                x.i("MicroMsg.NetWarnView", "curr top activity is: %s", m.by((Context) n.this.vvl.get()));
                                                if (!m.by((Context) n.this.vvl.get()).endsWith("NetworkDiagnoseAllInOneUI")) {
                                                    int i;
                                                    if (n.this.zkv) {
                                                        i = 2;
                                                    } else if (n.this.zkw) {
                                                        i = 4;
                                                    } else if (n.this.zkx) {
                                                        i = 5;
                                                    } else {
                                                        i = 3;
                                                    }
                                                    n.a(n.this, i);
                                                }
                                            }
                                        });
                                    }
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            n.this.alN();
                                        }
                                    });
                                    return false;
                                }
                            };
                            a.xmy.a(nVar.zkA);
                        }
                        if (n.this.zkz == null) {
                            nVar = n.this;
                            nVar.zkz = new al(new al.a() {
                                public final boolean uG() {
                                    n.this.zku++;
                                    x.v("MicroMsg.NetWarnView", "timer fired, percent:%d", Integer.valueOf(n.this.zku));
                                    if (n.this.zku > 99) {
                                        return false;
                                    }
                                    if (n.this.slp == 1) {
                                        n.this.ikL.setText(((Context) n.this.vvl.get()).getResources().getString(R.l.exQ, new Object[]{Integer.valueOf(n.this.zku)}));
                                    }
                                    return true;
                                }
                            }, true);
                            nVar.zkz.K(1000, 1000);
                        }
                    }
                });
                z = true;
                break;
            case 3:
                this.ikL.setText(R.l.exN);
                this.ikM.setVisibility(8);
                this.zkm.setVisibility(8);
                this.zkr.setVisibility(0);
                this.jIs.setVisibility(0);
                z = true;
                break;
            case 5:
                this.ikL.setText(R.l.exS);
                this.ikM.setText(((Context) this.vvl.get()).getString(R.l.exT));
                this.ikM.setVisibility(0);
                this.zkm.setVisibility(8);
                this.zkr.setVisibility(8);
                this.jIs.setVisibility(0);
                this.kvL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (!t.F((Context) n.this.vvl.get(), n.this.zks)) {
                            Intent intent = new Intent();
                            intent.putExtra("title", ((Context) n.this.vvl.get()).getString(R.l.exU));
                            intent.putExtra("rawUrl", ((Context) n.this.vvl.get()).getString(R.l.exO));
                            intent.putExtra("showShare", false);
                            d.b((Context) n.this.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                });
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.sej.setVisibility(8);
            this.ikL.setVisibility(0);
            this.kvL.setBackgroundResource(R.g.bGT);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jIs.getLayoutParams());
            layoutParams.setMargins(com.tencent.mm.bu.a.fromDPToPix((Context) this.vvl.get(), 10), 0, com.tencent.mm.bu.a.fromDPToPix((Context) this.vvl.get(), 4), 0);
            this.jIs.setLayoutParams(layoutParams);
            this.jIs.setImageResource(R.k.dBt);
            this.zkp.setVisibility(8);
            this.zkq.setVisibility(8);
            this.zkn.setVisibility(8);
        } else {
            as.Hm();
            if (com.tencent.mm.y.c.Fa()) {
                as.Hm();
                if (com.tencent.mm.modelsimple.q.iu(com.tencent.mm.y.c.Fb())) {
                    com.tencent.mm.ad.n CN = as.CN();
                    as.Hm();
                    CN.a(new com.tencent.mm.modelsimple.q(com.tencent.mm.y.c.Fb()), 0);
                }
            }
            as.Hm();
            if (!(!com.tencent.mm.y.c.Fa() || t.oN(com.tencent.mm.modelsimple.q.hOU) || com.tencent.mm.modelsimple.q.RY())) {
                this.kvL.setBackgroundResource(R.g.bGU);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.jIs.getLayoutParams());
                layoutParams2.setMargins(com.tencent.mm.bu.a.fromDPToPix((Context) this.vvl.get(), 22), 0, com.tencent.mm.bu.a.fromDPToPix((Context) this.vvl.get(), 20), 0);
                this.jIs.setLayoutParams(layoutParams2);
                this.ikL.setVisibility(8);
                this.ikM.setVisibility(8);
                this.sej.setVisibility(0);
                if (q.gM(q.Ge())) {
                    if (com.tencent.mm.modelsimple.q.Sb() || !com.tencent.mm.modelsimple.q.RZ()) {
                        this.sej.setText(com.tencent.mm.modelsimple.q.hOU);
                    } else {
                        this.sej.setText(com.tencent.mm.modelsimple.q.hPb);
                    }
                } else if (com.tencent.mm.modelsimple.q.Sb() || !com.tencent.mm.modelsimple.q.RZ()) {
                    this.sej.setText(com.tencent.mm.modelsimple.q.hOX);
                } else {
                    this.sej.setText(com.tencent.mm.modelsimple.q.hPc);
                }
                this.zkm.setVisibility(8);
                this.zkr.setVisibility(8);
                this.jIs.setPadding(0, 0, 0, 0);
                if (com.tencent.mm.modelsimple.q.RX() == 1) {
                    this.jIs.setImageResource(R.k.dyt);
                } else if (com.tencent.mm.modelsimple.q.RX() == 2) {
                    if (com.tencent.mm.modelsimple.q.RZ()) {
                        this.jIs.setImageResource(R.k.dys);
                    } else {
                        this.jIs.setImageResource(R.k.dyr);
                    }
                } else if (com.tencent.mm.modelsimple.q.RX() == 3) {
                    this.jIs.setImageResource(R.k.dyq);
                } else {
                    this.jIs.setImageResource(R.k.dBp);
                }
                this.jIs.setVisibility(0);
                this.zkp.setVisibility(8);
                this.zkq.setVisibility(8);
                TextView textView = this.zkn;
                if (q.gM(q.Ge())) {
                    Ks = 8;
                } else {
                    Ks = 0;
                }
                textView.setVisibility(Ks);
                final Intent intent = new Intent();
                intent.putExtra("intent.key.online_version", com.tencent.mm.modelsimple.q.Sa());
                this.kvL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.b((Context) n.this.vvl.get(), "webwx", ".ui.WebWXLogoutUI", intent);
                    }
                });
                z = true;
            }
        }
        if (!z) {
            this.zko.setVisibility(8);
            if (r.ifh) {
                boolean z2;
                final int backgroundLimitType = ao.getBackgroundLimitType((Context) this.vvl.get());
                if (!ao.isLimited(backgroundLimitType) || this.zkB) {
                    this.zko.setVisibility(8);
                    z2 = z;
                } else {
                    this.ikL.setText(((Context) this.vvl.get()).getString(R.l.eBq));
                    this.ikM.setText(((Context) this.vvl.get()).getString(R.l.eBp));
                    this.ikM.setVisibility(0);
                    this.zkm.setVisibility(8);
                    this.zkr.setVisibility(8);
                    this.jIs.setVisibility(0);
                    this.zko.setVisibility(0);
                    this.kvL.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            try {
                                ao.startSettingItent((Context) n.this.vvl.get(), backgroundLimitType);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                            }
                        }
                    });
                    this.zko.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            MMAppMgr.a((Context) n.this.vvl.get(), backgroundLimitType, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        n.this.kvL.setVisibility(8);
                                        n.this.zkB = true;
                                        ao.startSettingItent((Context) n.this.vvl.get(), backgroundLimitType);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                    }
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    n.this.kvL.setVisibility(8);
                                    n.this.zkB = true;
                                }
                            });
                        }
                    });
                    z2 = true;
                }
                z = z2;
            }
        }
        this.zkq.setImageResource(R.k.dxy);
        this.zko.setImageResource(R.g.bzG);
        View view = this.kvL;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return z;
    }

    public final void destroy() {
        cxJ();
        if (this.zkA != null) {
            a.xmy.c(this.zkA);
        }
    }

    public final void setVisibility(int i) {
        if (this.kvL != null) {
            this.kvL.setVisibility(i);
        }
    }

    public final int getOrder() {
        return 2;
    }
}
