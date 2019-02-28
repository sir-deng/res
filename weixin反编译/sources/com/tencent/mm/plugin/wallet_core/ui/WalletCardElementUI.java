package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.y.s;
import com.tenpay.ndk.Encrypt;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, a {
    private String countryCode;
    private String hjg;
    private String hjh;
    private String jyE;
    private String odk;
    private Orders pVi = null;
    private TextView rLs;
    private Button sIX;
    private PayInfo sKT = null;
    private Authen sKx = new Authen();
    a sLI = null;
    private c sNf = new c<oj>() {
        {
            this.xmG = oj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oj ojVar = (oj) bVar;
            if (ojVar instanceof oj) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletCardElementUI.a(WalletCardElementUI.this, encrypt.desedeEncode(ojVar.fHc.cardId, randomKey), randomKey, ojVar.fHc.fHd);
                return true;
            }
            x.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    private WalletFormView sNi;
    private TextView sNj;
    private TextView sNk;
    private int sNm = 1;
    private Profession[] sOW;
    private ElementQuery sPU = new ElementQuery();
    private Profession sPV;
    private WalletFormView sXs;
    private Bankcard sXt = null;
    private Map<String, a.a> sYA = null;
    private boolean sYB = false;
    private CheckBox sYC;
    private CheckBox sYD;
    private String sYE;
    private boolean sYF;
    private boolean sYG;
    private BaseAdapter sYH = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            return zF(i);
        }

        public final int getCount() {
            return WalletCardElementUI.this.sPU.bLO() != null ? WalletCardElementUI.this.sPU.bLO().size() : 0;
        }

        private Integer zF(int i) {
            return (Integer) WalletCardElementUI.this.sPU.bLO().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardElementUI.this, g.uLG, null);
            checkedTextView.setText(o.bMk().O(WalletCardElementUI.this, zF(i).intValue()));
            if (WalletCardElementUI.this.sNm == zF(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    };
    private OnClickListener sYI = new OnClickListener() {
        public final void onClick(View view) {
            com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(2), Integer.valueOf(0));
            e.e(WalletCardElementUI.this, o.bMc().azW());
        }
    };
    private TextView sYb;
    private TextView sYc;
    private TextView sYd;
    private TextView sYe;
    private TextView sYf;
    private TextView sYg;
    private TextView sYh;
    private TextView sYi;
    private WalletFormView sYj;
    private WalletFormView sYk;
    private WalletFormView sYl;
    private WalletFormView sYm;
    private WalletFormView sYn;
    private WalletFormView sYo;
    private WalletFormView sYp;
    private WalletFormView sYq;
    private WalletFormView sYr;
    private WalletFormView sYs;
    private WalletFormView sYt;
    private WalletFormView sYu;
    private WalletFormView sYv;
    private WalletFormView sYw;
    private ScrollView sYx;
    private WalletFormView sYy = null;
    private WalletFormView sYz;

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putString("key_bankcard_des", str2);
        bundle.putString("key_bankcard_id", str);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletCardElementUI);
        if (ag != null) {
            ag.a((Activity) walletCardElementUI, WalletConfirmCardIDUI.class, bundle, 3);
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(g.uLF, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJf);
                listViewInScrollView.setAdapter(this.sYH);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletCardElementUI.this.dismissDialog(1);
                        int intValue = ((Integer) WalletCardElementUI.this.sPU.bLO().get(i)).intValue();
                        if (WalletCardElementUI.this.sNm != intValue) {
                            WalletCardElementUI.this.sNm = intValue;
                            WalletCardElementUI.this.sYm.setText(((CheckedTextView) view).getText().toString());
                            WalletCardElementUI.a(WalletCardElementUI.this.sNi, WalletCardElementUI.this.sNm);
                            WalletCardElementUI.this.sNi.bnq();
                            WalletCardElementUI.this.av();
                            WalletCardElementUI.this.zE(WalletCardElementUI.this.sNm);
                        }
                    }
                });
                i.a aVar = new i.a(this);
                aVar.ES(com.tencent.mm.plugin.wxpay.a.i.uWI);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.ale();
            default:
                return h.b(this, getString(com.tencent.mm.plugin.wxpay.a.i.uWI), "", true);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.sPU = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.pVi = (Orders) this.vf.getParcelable("key_orders");
        this.sKT = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.sNm = o.bMc().bME();
        this.sXt = (Bankcard) this.vf.getParcelable("key_history_bankcard");
        this.sYF = this.vf.getBoolean("key_need_area", false);
        this.sYG = this.vf.getBoolean("key_need_profession", false);
        if (this.sYF || this.sYG) {
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uXX);
        } else {
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uXW);
        }
        Parcelable[] parcelableArray = this.vf.getParcelableArray("key_profession_list");
        if (parcelableArray != null) {
            this.sOW = new Profession[parcelableArray.length];
            while (i < parcelableArray.length) {
                this.sOW[i] = (Profession) parcelableArray[i];
                i++;
            }
        }
        if (this.sKT == null) {
            this.sKT = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.sKT);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
        if (!(this.pVi == null || favorPayInfo == null)) {
            this.sLI = b.sXj.a(this.pVi);
            if (this.sLI != null) {
                this.sYA = this.sLI.NL(this.sLI.NP(favorPayInfo.sTc));
            } else {
                x.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.sYx.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 3);
        com.tencent.mm.sdk.b.a.xmy.b(this.sNf);
    }

    protected final void initView() {
        this.sYb = (TextView) findViewById(f.uET);
        this.sYz = (WalletFormView) findViewById(f.uER);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sYz);
        this.sYc = (TextView) findViewById(f.uES);
        this.sNj = (TextView) findViewById(f.uEV);
        this.sXs = (WalletFormView) findViewById(f.uyk);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sXs);
        this.sYn = (WalletFormView) findViewById(f.uyb);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sYn);
        this.sYm = (WalletFormView) findViewById(f.uFi);
        this.sNi = (WalletFormView) findViewById(f.urs);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sNi);
        this.sNk = (TextView) findViewById(f.uEU);
        this.sYd = (TextView) findViewById(f.uEL);
        this.sYj = (WalletFormView) findViewById(f.uEZ);
        this.sYe = (TextView) findViewById(f.uEM);
        this.sYi = (TextView) findViewById(f.uEP);
        this.sYf = (TextView) findViewById(f.uEO);
        this.sYl = (WalletFormView) findViewById(f.upy);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sYl);
        this.sYk = (WalletFormView) findViewById(f.upz);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.sYk);
        this.sYg = (TextView) findViewById(f.uEN);
        this.rLs = (TextView) findViewById(f.uEJ);
        this.sYq = (WalletFormView) findViewById(f.urg);
        this.sYr = (WalletFormView) findViewById(f.urS);
        this.sYs = (WalletFormView) findViewById(f.ulg);
        this.sYt = (WalletFormView) findViewById(f.ukU);
        this.sYu = (WalletFormView) findViewById(f.uzU);
        this.sYv = (WalletFormView) findViewById(f.uAb);
        this.sYw = (WalletFormView) findViewById(f.uqv);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.sYw);
        this.sYh = (TextView) findViewById(f.uEI);
        this.sYC = (CheckBox) findViewById(f.ukX);
        this.sYD = (CheckBox) findViewById(f.ukV);
        this.sIX = (Button) findViewById(f.cAl);
        this.sYx = (ScrollView) findViewById(f.cYF);
        this.sYo = (WalletFormView) findViewById(f.uAe);
        this.sYp = (WalletFormView) findViewById(f.uAd);
        this.sXs.zST = this;
        this.sYz.zST = this;
        this.sYm.zST = this;
        this.sNi.zST = this;
        this.sYn.zST = new a() {
            public final void hB(boolean z) {
                if (!z) {
                    WalletCardElementUI.this.sXt = null;
                    WalletCardElementUI.this.vf.putParcelable("key_history_bankcard", null);
                }
                WalletCardElementUI.this.XT();
            }
        };
        this.sYl.zST = this;
        this.sYk.zST = this;
        this.sYq.zST = this;
        this.sYr.zST = this;
        this.sYs.zST = this;
        this.sYt.zST = this;
        this.sYu.zST = this;
        this.sYv.zST = this;
        this.sYw.zST = this;
        this.sYo.zST = this;
        this.sYp.zST = this;
        this.sXs.setOnEditorActionListener(this);
        this.sYz.setOnEditorActionListener(this);
        this.sYm.setOnEditorActionListener(this);
        this.sNi.setOnEditorActionListener(this);
        this.sYn.setOnEditorActionListener(this);
        this.sYl.setOnEditorActionListener(this);
        this.sYk.setOnEditorActionListener(this);
        this.sYq.setOnEditorActionListener(this);
        this.sYr.setOnEditorActionListener(this);
        this.sYs.setOnEditorActionListener(this);
        this.sYt.setOnEditorActionListener(this);
        this.sYu.setOnEditorActionListener(this);
        this.sYv.setOnEditorActionListener(this);
        this.sYw.setOnEditorActionListener(this);
        this.sYp.setOnEditorActionListener(this);
        this.sYo.setOnEditorActionListener(this);
        this.sYj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardElementUI.this.vf.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletCardElementUI.this.vf.getInt("key_bind_scene", -1));
                if (!bi.oN(WalletCardElementUI.this.sYj.getText())) {
                    bundle.putString("key_bank_type", WalletCardElementUI.this.sPU.pff);
                    bundle.putInt("key_bankcard_type", WalletCardElementUI.this.sPU.sSI);
                }
                com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(WalletCardElementUI.this);
                if (ag != null) {
                    ag.a(WalletCardElementUI.this, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.sYm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardElementUI.this.showDialog(1);
            }
        });
        this.sYp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (!Bankcard.zy(WalletCardElementUI.this.sPU.sOT)) {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                WalletCardElementUI.this.startActivityForResult(putExtra, 4);
            }
        });
        this.sYo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(WalletCardElementUI.this.mController.xRr, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletCardElementUI.this.sOW);
                WalletCardElementUI.this.startActivityForResult(intent, 5);
            }
        });
        this.sYC.setChecked(true);
        this.sYC.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WalletCardElementUI.this.XT();
            }
        });
        findViewById(f.bJD).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.a(WalletCardElementUI.this, WalletCardElementUI.this.sPU.pff, WalletCardElementUI.this.sPU.nHt, false, WalletCardElementUI.this.sPU.sTa);
            }
        });
        this.sYs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (Bankcard.zy(WalletCardElementUI.this.sPU.sOT)) {
                    putExtra.putExtra("IsAutoPosition", false);
                } else {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                WalletCardElementUI.this.startActivityForResult(putExtra, 2);
            }
        });
        this.sIX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardElementUI.this.bNh();
            }
        });
        e(this.sYz, 0, false);
        e(this.sNi, 1, false);
        e(this.sYn, 0, false);
        if (this.sPU != null && !bi.oN(this.sPU.sSO)) {
            h.a((Context) this, this.sPU.sSO, null, true, null);
            this.sPU = null;
        } else if (this.vf.getInt("key_bind_scene", -1) == 5 && !this.sPU.sTb) {
            h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.vet), null, true, null);
            this.sPU.nHt = null;
        }
        av();
        XT();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null && ag.cCb()) {
            Orders orders = (Orders) this.vf.getParcelable("key_orders");
            if (orders == null || orders.sTP != 1) {
                this.sYB = false;
                return;
            }
            this.sYB = true;
            this.sXs.setText(e.abk(orders.sQD));
            this.sXs.setEnabled(false);
            this.sXs.setFocusable(false);
            this.sNm = orders.sTR;
            this.sYm.setText(o.bMk().O(this, this.sNm));
            this.sYm.setEnabled(false);
            this.sNi.setText(orders.sTQ);
            this.sNi.setEnabled(false);
            this.sNi.setFocusable(false);
            this.sNj.setText(com.tencent.mm.plugin.wxpay.a.i.uWC);
            this.sYn.cDf();
        }
    }

    private void av() {
        if (this.sPU == null) {
            this.sPU = new ElementQuery();
        }
        if (this.sPU == null || this.sYA == null || !this.sYA.containsKey(this.sPU.pff)) {
            this.sYi.setVisibility(8);
        } else {
            double d;
            a.a aVar = (a.a) this.sYA.get(this.sPU.pff);
            if (aVar == null || aVar.sXg == null) {
                d = 0.0d;
            } else {
                d = aVar.sXh;
            }
            this.sYi.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uWD, new Object[]{e.u(d)}));
            this.sYi.setVisibility(0);
        }
        com.tencent.mm.wallet_core.a.ag(this);
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        if (!bNi() || bankcard == null) {
            if (bi.oN(this.sPU.nHt)) {
                this.sYj.setText("");
            } else if (!bi.oN(this.sPU.sSJ)) {
                this.sYj.setText(this.sPU.nHt + " " + this.sPU.sSJ);
            } else if (2 == this.sPU.sSI) {
                this.sYj.setText(this.sPU.nHt + " " + getString(com.tencent.mm.plugin.wxpay.a.i.uXF));
            } else {
                this.sYj.setText(this.sPU.nHt + " " + getString(com.tencent.mm.plugin.wxpay.a.i.uXU));
            }
            a(new boolean[]{false}, new WalletFormView[]{this.sYz}, this.sYb, this.sYc, true);
            a(new boolean[]{true}, new WalletFormView[]{this.sYj}, this.sYd, this.sYe, true);
            this.sYz.q(this.sYI);
            if (o.bMc().bMC().bMq()) {
                this.sYz.pJR.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNn);
                this.sYz.pJR.setVisibility(0);
            } else {
                this.sYz.pJR.setVisibility(4);
            }
        } else {
            this.sYz.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uWQ, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.sYz}, this.sYb, this.sYc);
            a(new boolean[]{false}, new WalletFormView[]{this.sYj}, this.sYd, this.sYe);
        }
        if (Bankcard.zy(this.sPU.sOT)) {
            a(new boolean[]{false, false, false}, new WalletFormView[]{this.sXs, this.sYm, this.sNi}, this.sNj, this.sNk);
            this.sYn.setVisibility(8);
            jP(true);
            this.sYp.setVisibility(8);
            this.sYo.setVisibility(8);
            findViewById(f.uEX).setVisibility(8);
        } else {
            boolean z = this.sPU.bLO() != null && this.sPU.bLO().size() > 0;
            if (bNi() || o.bMc().bMv()) {
                if (bi.oN(o.bMc().azW())) {
                    this.sXs.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uXh));
                } else {
                    this.sXs.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uXi, new Object[]{e.abk(o.bMc().azW())}));
                }
                a(new boolean[]{true, z, true}, new WalletFormView[]{this.sXs, this.sYm, this.sNi}, this.sNj, this.sNk);
                this.sYn.setVisibility(0);
            } else {
                boolean[] zArr = new boolean[3];
                zArr[0] = this.sPU.sSB;
                if (z && this.sPU.sSC) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.sPU.sSC;
                a(zArr, new WalletFormView[]{this.sXs, this.sYm, this.sNi}, this.sNj, this.sNk);
                this.sYn.setVisibility(0);
                x.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.sPU.sSB + " canModifyIdentity:" + this.sPU.sSC);
            }
            if (this.sXt != null) {
                if (!bi.oN(this.sXt.field_mobile)) {
                    a(this.sYn, this.sXt.field_mobile);
                }
                if (!bi.oN(this.sXt.sQH)) {
                    a(this.sYl, this.sXt.sQH);
                }
                if (!bi.oN(this.sXt.sRl)) {
                    a(this.sYk, this.sXt.sRl);
                }
            }
            if (this.sPU.sSB) {
                this.sNk.setText("");
            } else {
                this.sNk.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uWT));
            }
            if (!bNi() || o.bMc().bME() <= 0) {
                if (this.sYH.getCount() <= 1) {
                    this.sYm.setClickable(false);
                    this.sYm.setEnabled(false);
                } else {
                    this.sYm.setClickable(true);
                    this.sYm.setEnabled(true);
                }
                List bLO = this.sPU.bLO();
                if (bLO == null || !bLO.contains(Integer.valueOf(this.sNm))) {
                    this.sNm = 1;
                }
                this.sYm.setText(o.bMk().O(this, this.sNm));
            } else {
                this.sYm.setClickable(false);
                this.sYm.setText(o.bMk().O(this, o.bMc().bME()));
                this.sYm.setEnabled(false);
                a(this.sNi, this.sNm);
            }
            zE(this.sNm);
            jP(false);
            if (this.sYF) {
                this.sYp.setVisibility(0);
            } else {
                this.sYp.setVisibility(8);
            }
            if (this.sYG) {
                this.sYo.setVisibility(0);
            } else {
                this.sYo.setVisibility(8);
            }
            if (this.sYF || this.sYG) {
                findViewById(f.uEX).setVisibility(0);
            } else {
                findViewById(f.uEX).setVisibility(8);
            }
        }
        a(new boolean[]{this.sPU.sSD, this.sPU.sSE}, new WalletFormView[]{this.sYl, this.sYk}, this.sYf, this.sYg);
        if (this.sYj.getVisibility() == 0) {
            switch (this.sPU.sSH) {
                case 1:
                    this.sYe.setVisibility(8);
                    break;
                case 2:
                    this.sYe.setVisibility(8);
                    break;
                case 3:
                    this.sYe.setText(com.tencent.mm.plugin.wxpay.a.i.uWG);
                    this.sYe.setVisibility(0);
                    break;
                case 4:
                    this.sYe.setVisibility(8);
                    break;
                default:
                    this.sYe.setVisibility(8);
                    break;
            }
            this.sYe.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bts));
        } else {
            this.sYe.setVisibility(8);
        }
        if (bi.oN(this.sPU.sSM) || !s.gH(this.sPU.sSM) || bNi()) {
            this.sYD.setVisibility(8);
            return;
        }
        this.sYD.setText(this.sPU.sSN);
        this.sYD.setVisibility(0);
    }

    private static void a(WalletFormView walletFormView, String str) {
        if (bi.oN(str)) {
            walletFormView.setVisibility(8);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
    }

    private void jP(boolean z) {
        int i = 0;
        if (z) {
            int i2;
            this.rLs.setVisibility(this.sPU.sSP ? 0 : 8);
            WalletFormView walletFormView = this.sYq;
            if (this.sPU.sSP) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sYr;
            if (this.sPU.sSQ) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sYs;
            if (this.sPU.sSR) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sYt;
            if (this.sPU.sSU) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sYu;
            if (this.sPU.sSW) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sYv;
            if (this.sPU.sSV) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.sYw;
            if (!this.sPU.sSX) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.sYh.setVisibility(4);
            return;
        }
        this.rLs.setVisibility(8);
        this.sYq.setVisibility(8);
        this.sYr.setVisibility(8);
        this.sYs.setVisibility(8);
        this.sYt.setVisibility(8);
        this.sYu.setVisibility(8);
        this.sYv.setVisibility(8);
        this.sYw.setVisibility(8);
        this.sYh.setVisibility(8);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 == null) {
                return;
            }
            if (z) {
                textView2.setVisibility(8);
                return;
            } else {
                textView2.setVisibility(4);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        a(zArr, walletFormViewArr, textView, textView2, false);
    }

    private void bNh() {
        if (XT()) {
            String text;
            com.tencent.mm.plugin.wallet_core.e.c.bNV();
            if (!bi.oN(this.sPU.sSM)) {
                Bundle bundle = this.vf;
                String str = "key_is_follow_bank_username";
                boolean z = this.sYD.getVisibility() == 0 && this.sYD.isChecked();
                bundle.putBoolean(str, z);
                this.vf.putString("key_bank_username", this.sPU.sSM);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
            if (!(this.sPU == null || favorPayInfo == null || this.sLI == null || this.sYA == null)) {
                if (this.sYA.containsKey(this.sPU.pff)) {
                    favorPayInfo.sTc = ((a.a) this.sYA.get(this.sPU.pff)).sXg.sJI;
                } else {
                    favorPayInfo.sTc = this.sLI.aM(favorPayInfo.sTc, false);
                }
                this.vf.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.sKx = new Authen();
            if (this.sXt != null) {
                this.sKx.pfg = this.sXt.sRm;
                this.sKx.sQJ = this.sXt.field_bankcardTail;
            }
            String string = this.vf.getString("key_card_id");
            if (this.sYz.getVisibility() == 0) {
                text = this.sYz.getText();
            } else {
                text = string;
            }
            this.sKx.pHW = (PayInfo) this.vf.getParcelable("key_pay_info");
            this.sKx.sQG = text;
            this.sKx.pff = this.sPU.pff;
            this.sKx.sQF = this.sNm;
            this.sKx.sQC = this.vf.getString("key_pwd1");
            if (!bi.oN(this.sYl.getText())) {
                this.sKx.sQH = this.sYl.getText();
            }
            this.sKx.sOP = this.sYn.getText();
            this.sKx.sQL = this.sYq.getText();
            this.sKx.sQM = this.sYr.getText();
            this.sKx.country = this.sYE;
            this.sKx.fXk = this.odk;
            this.sKx.fXl = this.jyE;
            this.sKx.hzf = this.sYt.getText();
            this.sKx.nHv = this.sYu.getText();
            this.sKx.iot = this.sYv.getText();
            this.sKx.fXd = this.sYw.getText();
            text = e.abl(this.sKx.sOP);
            this.vf.putString("key_mobile", text);
            this.vf.putBoolean("key_is_oversea", this.sPU.sOT == 2);
            this.sKx.sQE = this.sNi.getText();
            this.sKx.sQD = this.sXs.getText();
            this.sKx.sQI = this.sYk.getText();
            favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.sKx.sQN = favorPayInfo.sTf;
                this.sKx.sQO = favorPayInfo.sTc;
            }
            x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.sKx.pHW + " elemt.bankcardTag : " + this.sPU.sOT);
            x.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.sPU.sOT);
            Bundle bundle2 = this.vf;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.sKx);
            bundle2.putString("key_bank_phone", this.sPU.sSL);
            bundle2.putString("key_country_code", this.countryCode);
            bundle2.putString("key_province_code", this.hjh);
            bundle2.putString("key_city_code", this.hjg);
            bundle2.putParcelable("key_profession", this.sPV);
            bundle2.putString("key_bind_card_type", this.sKx.pff);
            bundle2.putString("key_bind_card_show1", this.sPU.nHt);
            bundle2.putString("key_bind_card_show2", 2 == this.sPU.sSI ? getString(com.tencent.mm.plugin.wxpay.a.i.uXF) : getString(com.tencent.mm.plugin.wxpay.a.i.uXU));
            if (cCU().k(this.sKx, this.pVi)) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.vf;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.sKT);
        if (!(kVar instanceof y)) {
            return false;
        }
        x.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected final int getLayoutId() {
        return g.uLj;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            switch (i) {
                case 1:
                    this.sPU = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    this.sXt = null;
                    av();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.sYE = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bi.oN(intent.getStringExtra("Contact_City"))) {
                        this.odk = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.jyE = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (bi.oN(stringExtra)) {
                            this.sYs.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.sYs.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (bi.oN(intent.getStringExtra("Contact_Province"))) {
                        this.jyE = this.sYE;
                        this.sYs.setText(stringExtra);
                    } else {
                        this.jyE = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.sYs.setText(stringExtra + " " + stringExtra3);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.sPU.sSV) {
                        this.sYv.setVisibility(0);
                    } else {
                        this.sYv.setVisibility(8);
                    }
                    x.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, this.jyE);
                    break;
                case 3:
                    this.sYz.abs(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("ProviceName");
                    stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.hjh = intent.getStringExtra("Contact_Province");
                    this.hjg = intent.getStringExtra("Contact_City");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bi.oN(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!bi.oN(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!bi.oN(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.sYp.setText(stringBuilder.toString());
                    break;
                case 5:
                    this.sPV = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.sYo.setText(this.sPV.sQn);
                    break;
            }
            XT();
        }
    }

    private boolean XT() {
        boolean z;
        boolean z2;
        WalletFormView walletFormView = this.sYy;
        this.sYy = null;
        if (this.sYj.dQ(null)) {
            z = true;
        } else {
            if (this.sYy == null && walletFormView != this.sYj) {
                this.sYy = this.sYj;
            }
            this.sYe.setText(com.tencent.mm.plugin.wxpay.a.i.uWE);
            this.sYe.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            z = false;
        }
        if (!this.sXs.dQ(null)) {
            if (this.sYy == null && walletFormView != this.sXs) {
                this.sYy = this.sXs;
            }
            z = false;
        }
        if (!this.sYz.dQ(this.sYc)) {
            if (this.sYy == null && walletFormView != this.sYz) {
                this.sYy = this.sYz;
            }
            z = false;
        }
        if (this.sNi.dQ(this.sNk) || this.sYB) {
            z2 = z;
            z = false;
        } else {
            if (this.sYy == null && walletFormView != this.sNi) {
                this.sYy = this.sNi;
            }
            this.sNk.setText(com.tencent.mm.plugin.wxpay.a.i.uEU);
            this.sNk.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            z = true;
            z2 = false;
        }
        if (!this.sYn.dQ(this.sNk)) {
            if (z) {
                this.sNk.setText(com.tencent.mm.plugin.wxpay.a.i.uWN);
                this.sNk.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            } else {
                this.sNk.setText(com.tencent.mm.plugin.wxpay.a.i.uWO);
                this.sNk.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            }
            if (this.sYy == null && walletFormView != this.sYn) {
                this.sYy = this.sYn;
            }
            z2 = false;
        } else if (z) {
            this.sNk.setVisibility(0);
        }
        if (this.sNk.getVisibility() == 4) {
            if (this.sPU.sSB) {
                this.sNk.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uWR));
            } else {
                this.sNk.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uWT));
            }
            this.sNk.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
            this.sNk.setVisibility(0);
        }
        if (this.sYl.dQ(this.sYg)) {
            z = false;
        } else {
            if (this.sYy == null && walletFormView != this.sYl) {
                this.sYy = this.sYl;
            }
            z = true;
            z2 = false;
        }
        if (!this.sYk.dQ(this.sYg)) {
            if (this.sYy == null && walletFormView != this.sYk) {
                this.sYy = this.sYk;
            }
            z2 = false;
        } else if (z) {
            this.sYg.setVisibility(4);
        }
        if (!this.sYC.isChecked()) {
            z2 = false;
        }
        if (!this.sYq.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYq) {
                this.sYy = this.sYq;
            }
            z2 = false;
        }
        if (!this.sYr.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYr) {
                this.sYy = this.sYr;
            }
            z2 = false;
        }
        if (!this.sYs.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYs) {
                this.sYy = this.sYs;
            }
            z2 = false;
        }
        if (!this.sYt.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYt) {
                this.sYy = this.sYt;
            }
            z2 = false;
        }
        if (!this.sYu.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYu) {
                this.sYy = this.sYu;
            }
            z2 = false;
        }
        if (!this.sYv.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYv) {
                this.sYy = this.sYv;
            }
            z2 = false;
        }
        if (!this.sYw.dQ(this.sYh)) {
            if (this.sYy == null && walletFormView != this.sYw) {
                this.sYy = this.sYw;
            }
            z2 = false;
        }
        if (this.sYG && !this.sYo.dQ(null)) {
            if (this.sYy == null && walletFormView != this.sYo) {
                this.sYy = this.sYo;
            }
            z2 = false;
        }
        if (this.sYF && !this.sYp.dQ(null)) {
            if (this.sYy == null && walletFormView != this.sYp) {
                this.sYy = this.sYp;
            }
            z2 = false;
        }
        if (z2) {
            this.sIX.setEnabled(true);
            this.sIX.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.sIX.setEnabled(false);
            this.sIX.setClickable(false);
        }
        return z2;
    }

    public final void hB(boolean z) {
        XT();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.sYy != null) {
                    WalletFormView walletFormView = this.sYy;
                    if (walletFormView.zSS != null ? walletFormView.zSS.isFocusable() : false) {
                        walletFormView = this.sYy;
                        if (walletFormView.zSS != null) {
                            z = walletFormView.zSS.isClickable();
                        }
                        if (z && this.sYy.cDd()) {
                            this.sYy.cDf();
                        }
                    }
                    this.sYy.performClick();
                } else {
                    bNh();
                }
                return true;
            default:
                if (this.sYy != null) {
                    return false;
                }
                bNh();
                return false;
        }
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sNf);
        super.onDestroy();
    }

    private static void a(WalletFormView walletFormView, int i) {
        com.tencent.mm.wallet_core.ui.formview.a.b bVar = walletFormView.zSV;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).HY(i);
        }
    }

    private void zE(int i) {
        if (i == 1) {
            e(this.sNi, 1, false);
        } else {
            e(this.sNi, 1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private boolean bNi() {
        return this.vf.getBoolean("key_is_forgot_process", false);
    }
}
