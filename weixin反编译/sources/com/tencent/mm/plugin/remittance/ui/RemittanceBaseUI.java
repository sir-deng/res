package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.fl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public abstract class RemittanceBaseUI extends WalletBaseUI implements com.tencent.mm.ac.d.a {
    public String gBJ;
    protected String gCB;
    private final int ild = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 270);
    public int itU;
    protected Button lXK;
    protected WalletFormView lrK;
    private int oli;
    protected ScrollView pOM;
    private double pQB;
    protected com.tencent.mm.plugin.wallet.a pRC = null;
    public double pRD;
    protected String pRE;
    public int pRF;
    public String pRG;
    protected ImageView pRH;
    protected TextView pRI;
    protected TextView pRJ;
    protected TextView pRK;
    protected TextView pRL;
    protected TextView pRM;
    private TextView pRN;
    private TextView pRO;
    protected TextView pRP;
    private LinearLayout pRQ;
    private LinearLayout pRR;
    protected String pRS;
    private String pRT;
    private String pRU;
    protected String pRV;
    protected String pRW = null;
    protected String pRX = null;
    protected int pRY;
    private int pRZ;
    protected String pSa;
    private Map<String, a> pSb = new HashMap();
    private String pSc;
    private boolean pSd = false;
    private boolean pSe = false;
    private boolean pSf = false;
    private boolean pSg = false;
    private c<fl> pSh = new c<fl>() {
        {
            this.xmG = fl.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fl flVar = (fl) bVar;
            RemittanceBaseUI.a(RemittanceBaseUI.this, flVar.fvB.fvC, flVar.fvB.fvD);
            return false;
        }
    };

    private static class a {
        String fFn;
        String fvD;
        String lnQ;
        String lpF;
        int oeK;
        String pQG;
        String pQH;
        String pQL;
        long pSo;

        a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j) {
            this.pQG = str;
            this.lnQ = str2;
            this.lpF = str3;
            this.pQH = str4;
            this.oeK = i;
            this.fFn = str5;
            this.fvD = str6;
            this.pQL = str7;
            this.pSo = j;
        }
    }

    public abstract void boo();

    public abstract void bor();

    public abstract void bou();

    public abstract void dX(String str, String str2);

    static /* synthetic */ void a(RemittanceBaseUI remittanceBaseUI, String str, String str2) {
        a aVar = (a) remittanceBaseUI.pSb.get(str);
        x.d("MicroMsg.RemittanceBaseUI", "match reqKey: %s, %d", str, Integer.valueOf(remittanceBaseUI.pSb.size()));
        if (aVar == null) {
            x.i("MicroMsg.RemittanceBaseUI", "no data for: %s", str);
        } else {
            x.i("MicroMsg.RemittanceBaseUI", "pay check: %d", Integer.valueOf(remittanceBaseUI.pRF));
            if (bi.oN(aVar.fvD)) {
                aVar.fvD = str2;
            }
            if (bi.oN(aVar.lnQ)) {
                aVar.lnQ = str2;
            }
            if (remittanceBaseUI.pRF == 31) {
                g.CN().a(new r(str, aVar.fFn, aVar.fvD, aVar.pQL, aVar.pSo, aVar.lpF), 0);
            } else {
                g.CN().a(new m(aVar.pQG, aVar.lnQ, aVar.lpF, aVar.pQH, aVar.oeK), 0);
            }
        }
        remittanceBaseUI.pSb.clear();
    }

    static /* synthetic */ void c(RemittanceBaseUI remittanceBaseUI) {
        if (bi.oN(remittanceBaseUI.gCB)) {
            remittanceBaseUI.pRL.setVisibility(8);
            if (remittanceBaseUI.itU == 1) {
                remittanceBaseUI.pRM.setText(i.uTu);
            } else {
                remittanceBaseUI.pRM.setText(i.uTt);
            }
            remittanceBaseUI.pRM.setVisibility(0);
            return;
        }
        com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(remittanceBaseUI.mController.xRr);
        String string = remittanceBaseUI.getString(i.uUp);
        CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a((Context) remittanceBaseUI, remittanceBaseUI.getString(i.uPb, new Object[]{remittanceBaseUI.gCB, string}));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(a);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wxpay.a.c.btd), a.length() - string.length(), a.length(), 34);
        remittanceBaseUI.pRL.setText(spannableStringBuilder);
        remittanceBaseUI.pRM.setVisibility(8);
        remittanceBaseUI.pRL.setVisibility(0);
    }

    protected int getLayoutId() {
        if (this.pRF == 33 || this.pRF == 32) {
            return com.tencent.mm.plugin.wxpay.a.g.uKE;
        }
        return com.tencent.mm.plugin.wxpay.a.g.uKD;
    }

    public void onCreate(Bundle bundle) {
        this.itU = getIntent().getIntExtra("scene", 0);
        this.pRF = getIntent().getIntExtra("pay_scene", 31);
        super.onCreate(bundle);
        this.pRC = com.tencent.mm.plugin.wallet.a.X(getIntent());
        this.pRG = getIntent().getStringExtra("scan_remittance_id");
        this.pRD = getIntent().getDoubleExtra("fee", 0.0d);
        this.gBJ = getIntent().getStringExtra("receiver_name");
        this.pRE = getIntent().getStringExtra("receiver_nick_name");
        this.pRV = getIntent().getStringExtra("receiver_true_name");
        this.oli = getIntent().getIntExtra("pay_channel", 0);
        this.pSa = bi.aD(getIntent().getStringExtra("rcvr_open_id"), "");
        x.i("MicroMsg.RemittanceBaseUI", "mUserName %s", this.gBJ);
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.pRZ = 1;
        } else if ((longValue & 32) != 0) {
            this.pRZ = 2;
        } else {
            this.pRZ = 0;
        }
        boo();
        n.JF().a((com.tencent.mm.ac.d.a) this);
        initView();
        this.pSh.cfB();
    }

    public void onDestroy() {
        super.onDestroy();
        n.JF().b(this);
        this.pSh.dead();
    }

    public void bop() {
        k sVar = new s(this.gBJ, this.pRG);
        sVar.gQd = "RemittanceProcess";
        l(sVar);
    }

    public void boq() {
    }

    protected final void initView() {
        if (this.pRF == 33 || this.pRF == 32) {
            setMMTitle(i.uTA);
        } else {
            setMMTitle(i.uUN);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (RemittanceBaseUI.this.itU == 1 || RemittanceBaseUI.this.itU == 6) {
                    RemittanceBaseUI.this.bop();
                    RemittanceBaseUI.this.finish();
                } else if (RemittanceBaseUI.this.itU == 2 || RemittanceBaseUI.this.itU == 5) {
                    RemittanceBaseUI.this.finish();
                } else {
                    RemittanceBaseUI.this.boy();
                }
                RemittanceBaseUI.this.boq();
                return true;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
        this.okX = findViewById(f.uDn);
        this.pOM = (ScrollView) findViewById(f.uCJ);
        this.pRH = (ImageView) findViewById(f.uCt);
        this.pRI = (TextView) findViewById(f.uCu);
        this.pRJ = (TextView) findViewById(f.uCv);
        this.pRJ.setVisibility(8);
        this.pRR = (LinearLayout) findViewById(f.uCl);
        this.pRQ = (LinearLayout) findViewById(f.uCq);
        this.pRO = (TextView) findViewById(f.uCo);
        this.pRP = (TextView) findViewById(f.uCp);
        this.pRN = (TextView) findViewById(f.uCn);
        bov();
        this.lrK = (WalletFormView) findViewById(f.uye);
        if (this.pRF == 33) {
            this.pRO.setText(e.t(this.pRD));
            this.pRP.setText(u.cCu());
            this.pRS = getIntent().getStringExtra("desc");
            if (bi.oN(this.pRS)) {
                this.pRN.setVisibility(8);
            } else {
                this.pRN.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xRr, this.pRS, this.pRN.getTextSize()));
                this.pRN.setVisibility(0);
            }
            this.pRQ.setVisibility(0);
            this.pRR.setVisibility(8);
        } else {
            this.lrK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    RemittanceBaseUI.this.Xj();
                }
            });
            this.lrK.jOY.setText(String.format(getString(i.uUs), new Object[]{"¥"}));
            this.lrK.a(new TextWatcher() {
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
                }
            });
            e(this.lrK, 2, false);
            findViewById(f.uzY);
            findViewById(f.uCs).setVisibility(0);
            this.pRQ.setVisibility(8);
            this.pRR.setVisibility(0);
            this.olj = new com.tencent.mm.wallet_core.ui.a() {
                public final void hE(boolean z) {
                    if (z) {
                        RemittanceBaseUI.this.a(RemittanceBaseUI.this.pOM, RemittanceBaseUI.this.lXK, 30);
                    } else {
                        RemittanceBaseUI.this.pOM.scrollTo(0, 0);
                    }
                }
            };
        }
        this.lXK = (Button) findViewById(f.cAl);
        this.lXK.setOnClickListener(new com.tencent.mm.ui.r() {
            public final void azE() {
                if (RemittanceBaseUI.this.pRF == 33) {
                    RemittanceBaseUI.this.dX(RemittanceBaseUI.this.gCB, RemittanceBaseUI.this.pRS);
                } else {
                    RemittanceBaseUI.this.pRD = bi.getDouble(RemittanceBaseUI.this.lrK.getText(), 0.0d);
                    if (!RemittanceBaseUI.this.lrK.XX()) {
                        com.tencent.mm.ui.base.u.makeText(RemittanceBaseUI.this.mController.xRr, i.uWd, 0).show();
                    } else if (RemittanceBaseUI.this.pRD < 0.01d) {
                        RemittanceBaseUI.this.bor();
                    } else {
                        RemittanceBaseUI.this.dX(RemittanceBaseUI.this.gCB, null);
                    }
                }
                if (RemittanceBaseUI.this.pQB == 0.0d) {
                    if (RemittanceBaseUI.this.itU == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(15), Integer.valueOf(1));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(6), Integer.valueOf(1));
                    }
                }
                if (RemittanceBaseUI.this.itU == 1 && !bi.oN(RemittanceBaseUI.this.gCB)) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14074, Integer.valueOf(2));
                }
            }
        });
        this.pRL = (TextView) findViewById(f.uCc);
        this.pRM = (TextView) findViewById(f.ukT);
        if (this.itU == 1 || this.itU == 6) {
            this.pRM.setText(i.uTu);
        } else {
            this.pRM.setText(i.uTt);
        }
        if (!q.Gl()) {
            findViewById(f.uCd).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String string;
                    String string2;
                    RemittanceBaseUI.this.Xj();
                    com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(9), Integer.valueOf(1));
                    if (RemittanceBaseUI.this.itU == 1 || RemittanceBaseUI.this.itU == 6) {
                        string = RemittanceBaseUI.this.getString(i.uTu);
                        string2 = RemittanceBaseUI.this.getString(i.uTJ);
                        com.tencent.mm.plugin.report.service.g.pWK.h(14074, Integer.valueOf(1));
                    } else {
                        string = RemittanceBaseUI.this.getString(i.uTt);
                        string2 = RemittanceBaseUI.this.getString(i.uTx);
                    }
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, string, RemittanceBaseUI.this.gCB, string2, 20, new h.b() {
                        public final boolean v(CharSequence charSequence) {
                            if (bi.oN(charSequence.toString())) {
                                RemittanceBaseUI.this.gCB = null;
                                RemittanceBaseUI.c(RemittanceBaseUI.this);
                            } else {
                                RemittanceBaseUI.this.gCB = charSequence.toString();
                                RemittanceBaseUI.c(RemittanceBaseUI.this);
                            }
                            return true;
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ah.h(new Runnable() {
                                public final void run() {
                                    RemittanceBaseUI.this.aWY();
                                }
                            }, 500);
                        }
                    });
                }
            });
        }
        if (this.itU == 1) {
            g.Dr();
            if (((String) g.Dq().Db().get(327732, (Object) "0")).equals("0")) {
                h.a(this.mController.xRr, i.uUt, i.uUu, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                g.Dr();
                g.Dq().Db().set(327732, "1");
                g.Dr();
                g.Dq().Db().lO(true);
            }
        }
        this.pRK = (TextView) findViewById(f.uzY);
        bot();
        bou();
        bos();
    }

    private void bos() {
        if (!box() || bi.oN(this.pRX) || this.pRZ == 0 || this.pRY != 1) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.ukw, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.l(RemittanceBaseUI.this.mController.xRr, RemittanceBaseUI.this.pRX, false);
                    return false;
                }
            });
        }
    }

    private void bot() {
        if (bi.oN(this.pRW) || this.pRZ == 0) {
            this.pRK.setText("");
            this.pRK.setVisibility(8);
            return;
        }
        int i;
        if (this.pRZ == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.pRK.setText(String.format(this.pRW, new Object[]{Integer.valueOf(i)}));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.pRK.setText(getString(i.uUx, new Object[]{Integer.valueOf(i)}));
        }
        this.pRK.setVisibility(0);
    }

    protected final void bov() {
        int i;
        CharSequence dF = e.dF(e.gw(this.gBJ), 10);
        if (!bi.oN(this.pRV)) {
            dF = getString(i.uTC, new Object[]{dF, this.pRV});
        }
        String stringExtra;
        if (this.itU == 1) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            this.pRI.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
            this.pRJ.setVisibility(0);
            if (bi.oN(this.gBJ)) {
                dF = getString(i.uTF, new Object[]{this.pRV});
            } else {
                dF = getString(i.uTE, new Object[]{e.dF(e.gw(this.gBJ), 10), this.pRV});
            }
            this.pRJ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, dF, this.pRJ.getTextSize()));
            dF = stringExtra;
        } else if (this.itU == 6) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            if (bi.oN(stringExtra)) {
                dF = getString(i.uTD, new Object[]{dF});
            } else {
                dF = bi.j(stringExtra, dF);
            }
        }
        this.pRI.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, dF, this.pRI.getTextSize()));
        this.pRH.setImageResource(com.tencent.mm.plugin.wxpay.a.e.bBC);
        if (g.Do().CF()) {
            com.tencent.mm.ac.i JW = n.JW();
            if (!(JW == null || bi.oN(this.gBJ))) {
                com.tencent.mm.ac.h jp = JW.jp(this.gBJ);
                if (jp == null || bi.oN(jp.JN())) {
                    final long Wy = bi.Wy();
                    com.tencent.mm.y.ak.a.hhv.a(this.gBJ, "", new com.tencent.mm.y.ak.b.a() {
                        public final void v(String str, boolean z) {
                            if (z) {
                                x.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bi.Wy() - Wy) + " ms");
                                com.tencent.mm.ac.b.I(str, 3);
                            } else {
                                x.w("MicroMsg.RemittanceBaseUI", "getContact failed");
                            }
                            RemittanceBaseUI.this.bow();
                        }
                    });
                    i = 1;
                    if (i == 0) {
                        bow();
                    }
                }
            }
        }
        i = 0;
        if (i == 0) {
            bow();
        }
    }

    private void bow() {
        ah.y(new Runnable() {
            public final void run() {
                Bitmap a = com.tencent.mm.ac.b.a(RemittanceBaseUI.this.gBJ, false, -1);
                if (a == null) {
                    RemittanceBaseUI.this.pRH.setImageResource(com.tencent.mm.plugin.wxpay.a.e.bBC);
                } else {
                    RemittanceBaseUI.this.pRH.setImageBitmap(a);
                }
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.remittance.model.u) {
                com.tencent.mm.plugin.remittance.model.u uVar = (com.tencent.mm.plugin.remittance.model.u) kVar;
                t.j(this.pRF, uVar.fxT, i2);
                this.pRU = uVar.pQw;
                this.pRV = uVar.pQF;
                if (this.pRF == 32 || this.pRF == 33) {
                    this.pSc = uVar.lnQ;
                } else {
                    this.pSc = uVar.fFn;
                }
                if (this.pRC != null) {
                    this.pRC.i(10000, Integer.valueOf(this.pRF), this.gBJ, Double.valueOf(uVar.pQI));
                }
                if (!a(uVar)) {
                    a(uVar.fxT, this.gBJ, this.pRV, uVar);
                }
                this.pSb.put(uVar.fxT, new a(uVar.pQG, uVar.lnQ, uVar.lpF, uVar.pQH, uVar.oeK, uVar.fFn, uVar.fvD, uVar.pQL, bi.getLong(uVar.pQJ, 0)));
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.ad) {
                com.tencent.mm.plugin.wallet_core.c.ad adVar = (com.tencent.mm.plugin.wallet_core.c.ad) kVar;
                if (!bi.oN(adVar.sPa)) {
                    ((TextView) findViewById(f.uCG)).setText(adVar.sPa);
                    View findViewById = findViewById(f.uDF);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            b.a(RemittanceBaseUI.this, RemittanceBaseUI.this.itU, RemittanceBaseUI.this.pRT, RemittanceBaseUI.this.pQB);
                            if (RemittanceBaseUI.this.itU == 1) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(13), Integer.valueOf(1));
                                return;
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(4), Integer.valueOf(1));
                        }
                    });
                }
                this.pRT = adVar.pRT;
                this.pQB = adVar.pQB;
                if (this.pQB == 0.0d) {
                    if (this.itU == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(14), Integer.valueOf(1));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(5), Integer.valueOf(1));
                    }
                }
            } else if (kVar instanceof ae) {
                this.pRW = ((ae) kVar).sPc;
                this.pRX = ((ae) kVar).sPg;
                this.pRY = ((ae) kVar).sPh;
                bot();
                bos();
            }
            return true;
        }
        if (kVar instanceof ae) {
            x.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.pRK.setText("");
            this.pRK.setVisibility(8);
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.u) {
            t.j(this.pRF, "", i2);
            if (b((com.tencent.mm.plugin.remittance.model.u) kVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(final com.tencent.mm.plugin.remittance.model.u uVar) {
        String str;
        boolean z = false;
        if (!this.pSd) {
            if (bi.oN(uVar.pQv)) {
                z = false;
            } else {
                this.pSd = true;
                h.a((Context) this, uVar.pQv, getString(i.dGE), getString(i.uTI), getString(i.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!RemittanceBaseUI.this.a(uVar)) {
                            RemittanceBaseUI.this.a(uVar.fxT, RemittanceBaseUI.this.gBJ, RemittanceBaseUI.this.pRV, uVar);
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = true;
            }
        }
        if (!(z || this.pSe)) {
            if (uVar.pQu > 0) {
                this.pSe = true;
                h.a((Context) this, getString(i.uUC, new Object[]{Integer.valueOf(uVar.pQu)}), getString(i.dGE), getString(i.uTI), getString(i.uUz), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!RemittanceBaseUI.this.a(uVar)) {
                            RemittanceBaseUI.this.a(uVar.fxT, RemittanceBaseUI.this.gBJ, RemittanceBaseUI.this.pRV, uVar);
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.pSf)) {
            if (uVar.pQA) {
                this.pSf = true;
                int i = this.itU;
                double d = uVar.pQE / 100.0d;
                str = uVar.pQC;
                b.a(this, i, d, uVar.pQD / 100.0d, uVar.pQx / 100.0d, uVar.pQz, new OnClickListener() {
                    public final void onClick(View view) {
                        RemittanceBaseUI.this.a(uVar.fxT, RemittanceBaseUI.this.gBJ, RemittanceBaseUI.this.pRV, uVar);
                        if (RemittanceBaseUI.this.itU == 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(12), Integer.valueOf(1));
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(3), Integer.valueOf(1));
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.pSg)) {
            z = b(uVar);
        }
        if (z || bi.oN(uVar.pQJ) || bi.oN(uVar.pQK)) {
            return z;
        }
        CharSequence string;
        str = e.dF(e.gw(this.gBJ), 10);
        if (bi.oN(this.pRV)) {
            Object string2 = str;
        } else {
            string2 = getString(i.uTC, new Object[]{str, this.pRV});
        }
        final String str2 = uVar.fxT;
        CharSequence charSequence = uVar.pQK;
        String str3 = uVar.pQJ;
        View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKH, null);
        TextView textView = (TextView) inflate.findViewById(f.uCL);
        TextView textView2 = (TextView) inflate.findViewById(f.uCK);
        ((TextView) inflate.findViewById(f.uCM)).setText(charSequence);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string2, textView.getTextSize()));
        Double valueOf = Double.valueOf(bi.getDouble(str3, 0.0d));
        textView2.setText(String.format("%s%.2f", new Object[]{u.cCu(), Double.valueOf(valueOf.doubleValue() / 100.0d)}));
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        aVar.mp(false);
        aVar.ES(i.uUL);
        aVar.dk(inflate);
        aVar.EV(i.uTI);
        aVar.EW(i.uOF);
        aVar.a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RemittanceBaseUI.this.a(str2, RemittanceBaseUI.this.gBJ, RemittanceBaseUI.this.pRV, uVar);
            }
        });
        aVar.ale().show();
        return true;
    }

    private boolean b(final com.tencent.mm.plugin.remittance.model.u uVar) {
        if (uVar.fIb == null || !uVar.fIb.bLz()) {
            return false;
        }
        this.pSg = true;
        h.a((Context) this, uVar.fIb.fzT, "", uVar.fIb.ojc, uVar.fIb.ojb, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", uVar.fIb.loA);
                e.l(RemittanceBaseUI.this.mController.xRr, uVar.fIb.loA, false);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected final boolean box() {
        return this.itU == 0 || this.itU == 2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gBJ);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (this.itU != 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(7), Integer.valueOf(1));
                        break;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(16), Integer.valueOf(1));
                    break;
                }
                stringExtra = intent.getStringExtra("key_trans_id");
                if (bi.oN(this.pSc)) {
                    this.pSc = stringExtra;
                }
                if (!(this.pRF == 33 || this.pRF == 32)) {
                    ab.IX(this.gBJ);
                }
                if (this.pQB == 0.0d) {
                    if (this.itU == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(17), Integer.valueOf(1));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(8), Integer.valueOf(1));
                    }
                }
                finish();
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oN(stringExtra)) {
                        this.gBJ = stringExtra;
                        bov();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(String str, String str2, String str3, com.tencent.mm.plugin.remittance.model.u uVar) {
        boolean z;
        if (this.pRF == 31) {
            Object obj = this.pRU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            } else {
                String decode = URLDecoder.decode(obj);
                x.i("MicroMsg.RemittanceBaseUI", "helios:" + decode);
                String str4 = (String) bj.y(decode, "msg").get(".msg.appmsg.wcpayinfo.transferid");
                if (TextUtils.isEmpty(str4)) {
                    x.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
                } else {
                    aa bnV = com.tencent.mm.plugin.remittance.a.b.bnS().bnV();
                    if (bi.oN(str4) || bi.oN(decode)) {
                        x.e(aa.TAG, "saveMsgContent param error");
                    } else {
                        bnV.pRt.put(str4, decode);
                    }
                }
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = str;
        payInfo.fDQ = this.pRF;
        if (this.oli > 0) {
            payInfo.fDM = this.oli;
        }
        if (this.itU == 2 || this.itU == 5) {
            z = true;
        } else {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str2);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", this.pRS);
        bundle.putBoolean("extinfo_key_4", z);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
        bundle.putString("extinfo_key_7", this.gCB);
        bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
        bundle.putString("extinfo_key_16", this.pSc);
        if (this.itU == 1 && uVar != null) {
            bundle.putString("extinfo_key_11", uVar.pQG);
            bundle.putInt("extinfo_key_12", uVar.pQM);
            bundle.putString("extinfo_key_13", uVar.pQN);
            bundle.putString("extinfo_key_14", uVar.pQO);
        }
        if (uVar != null) {
            bundle.putInt("extinfo_key_15", uVar.oeK);
        }
        payInfo.vGl = bundle;
        Intent intent = new Intent();
        com.tencent.mm.plugin.wallet.a.a(this.pRC, intent);
        com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, str3, intent, 1);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void boy() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", ab.boi());
        intent.setClass(this.mController.xRr, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void jk(String str) {
        x.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (bi.oM(str).length() <= 0) {
            x.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = " + str);
        } else if (str.equals(this.gBJ)) {
            bow();
        }
    }
}
