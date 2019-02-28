package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, a {
    private static final String[] sYK = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private String jyE;
    private ag mHandler = new ag();
    private String odk;
    private Orders pVi = null;
    private Dialog qb = null;
    private Button sIX;
    private PayInfo sKT = null;
    private Authen sKx = new Authen();
    private WalletFormView sNi;
    private int sNm = 1;
    private ElementQuery sPU = new ElementQuery();
    private WalletFormView sXs;
    private CheckBox sYD;
    private String sYE;
    private TextView sYL;
    private MMScrollView sYM;
    private Bankcard sYN = null;
    private CheckBox sYO;
    private BaseAdapter sYP = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            return zF(i);
        }

        public final int getCount() {
            return WalletCardImportUI.this.sPU.bLO() != null ? WalletCardImportUI.this.sPU.bLO().size() : 0;
        }

        private Integer zF(int i) {
            return (Integer) WalletCardImportUI.this.sPU.bLO().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardImportUI.this, g.uLG, null);
            checkedTextView.setText(o.bMk().O(WalletCardImportUI.this, zF(i).intValue()));
            if (WalletCardImportUI.this.sNm == zF(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(e.bBy);
            return checkedTextView;
        }
    };
    private WalletFormView sYj;
    private WalletFormView sYk;
    private WalletFormView sYl;
    private WalletFormView sYm;
    private WalletFormView sYn;
    private WalletFormView sYq;
    private WalletFormView sYr;
    private WalletFormView sYs;
    private WalletFormView sYt;
    private WalletFormView sYu;
    private WalletFormView sYv;
    private WalletFormView sYw;
    private WalletFormView sYy = null;
    private WalletFormView sYz;

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        b bVar = walletFormView.zSV;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).HY(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uXW);
        this.sPU = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.pVi = (Orders) this.vf.getParcelable("key_orders");
        this.sKT = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.sYN = (Bankcard) this.vf.getParcelable("key_import_bankcard");
        if (this.sKT == null) {
            this.sKT = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.sKT);
        initView();
        this.sYM.pageScroll(33);
        c.b(this, this.vf, 3);
    }

    protected final void initView() {
        this.sYz = (WalletFormView) findViewById(f.uER);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sYz);
        this.sYn = (WalletFormView) findViewById(f.uyb);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sYn);
        this.sXs = (WalletFormView) findViewById(f.uyk);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sXs);
        this.sYm = (WalletFormView) findViewById(f.uFi);
        this.sNi = (WalletFormView) findViewById(f.urs);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sNi);
        this.sYj = (WalletFormView) findViewById(f.uEZ);
        this.sYl = (WalletFormView) findViewById(f.upy);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sYl);
        this.sYk = (WalletFormView) findViewById(f.upz);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.sYk);
        this.sYL = (TextView) findViewById(f.uGu);
        this.sYq = (WalletFormView) findViewById(f.urg);
        this.sYr = (WalletFormView) findViewById(f.urS);
        this.sYs = (WalletFormView) findViewById(f.ulg);
        this.sYt = (WalletFormView) findViewById(f.ukU);
        this.sYu = (WalletFormView) findViewById(f.uzU);
        this.sYv = (WalletFormView) findViewById(f.uAb);
        this.sYw = (WalletFormView) findViewById(f.uqv);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.sYw);
        this.sYO = (CheckBox) findViewById(f.ukX);
        this.sYD = (CheckBox) findViewById(f.ukV);
        this.sIX = (Button) findViewById(f.cAl);
        this.sYM = (MMScrollView) findViewById(f.cYF);
        Object obj = this.sYM;
        obj.a(obj, obj);
        this.sYM.zSc = new MMScrollView.a() {
            public final void jQ(boolean z) {
                final int i = z ? 8 : 0;
                x.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + z);
                WalletCardImportUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (i != WalletCardImportUI.this.sYL.getVisibility()) {
                            WalletCardImportUI.this.sYL.setVisibility(i);
                        }
                    }
                });
            }
        };
        this.sXs.zST = this;
        this.sYz.zST = this;
        this.sYm.zST = this;
        this.sNi.zST = this;
        this.sYn.zST = this;
        this.sYl.zST = this;
        this.sYk.zST = this;
        this.sYq.zST = this;
        this.sYr.zST = this;
        this.sYs.zST = this;
        this.sYt.zST = this;
        this.sYu.zST = this;
        this.sYv.zST = this;
        this.sYw.zST = this;
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
        this.sYj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardImportUI.this.vf.getInt("key_support_bankcard", 3));
                bundle.putString("key_bank_type", WalletCardImportUI.this.sPU.pff);
                bundle.putInt("key_bankcard_type", WalletCardImportUI.this.sPU.sSI);
                com.tencent.mm.wallet_core.a.ag(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, bundle, 1);
            }
        });
        this.sYm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardImportUI.this.showDialog(1);
            }
        });
        this.sYO.setChecked(true);
        this.sYO.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WalletCardImportUI.this.XT();
            }
        });
        this.sYD.setChecked(true);
        findViewById(f.bJD).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(WalletCardImportUI.this.getString(i.uWz));
                linkedList2.add(Integer.valueOf(0));
                if (WalletCardImportUI.this.sPU != null && WalletCardImportUI.this.sPU.sTa) {
                    linkedList.add(WalletCardImportUI.this.getString(i.uWy));
                    linkedList2.add(Integer.valueOf(1));
                }
                h.a(WalletCardImportUI.this, "", linkedList, linkedList2, "", new d() {
                    public final void cr(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", WalletCardImportUI.this.getString(i.uVk, new Object[]{w.cfV()}));
                                break;
                            case 1:
                                if (WalletCardImportUI.this.sPU != null) {
                                    intent.putExtra("rawUrl", WalletCardImportUI.this.getString(i.uVj, new Object[]{w.cfV(), WalletCardImportUI.this.sPU.pff}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bl.d.b(WalletCardImportUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
        this.sYs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
            }
        });
        this.sIX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardImportUI.this.bNh();
            }
        });
        av();
        XT();
    }

    private void av() {
        WalletFormView walletFormView = null;
        if (this.sYN != null) {
            WalletFormView walletFormView2;
            findViewById(f.uEY).setVisibility(0);
            if (bi.oN(this.vf.getString("key_bank_username"))) {
                this.sYD.setVisibility(8);
            } else {
                CharSequence string = this.vf.getString("key_recommand_desc");
                if (bi.oN(string)) {
                    this.sYD.setText(getString(i.uWP, new Object[]{this.sYN.field_bankName}));
                } else {
                    this.sYD.setText(string);
                }
                this.sYD.setVisibility(0);
            }
            this.sYq.setVisibility(8);
            this.sYr.setVisibility(8);
            this.sYs.setVisibility(8);
            this.sYt.setVisibility(8);
            this.sYu.setVisibility(8);
            this.sYv.setVisibility(8);
            this.sYw.setVisibility(8);
            if (bi.oN(this.sYN.field_bankcardTail) || !b(this.sYz, this.sYN.sRk)) {
                this.sYz.setVisibility(8);
                walletFormView2 = null;
            } else {
                walletFormView2 = this.sYz;
                walletFormView = this.sYz;
            }
            String string2;
            if (this.sYN.bLD()) {
                string2 = getString(i.uXF);
            } else {
                string2 = getString(i.uXU);
            }
            if (bi.oN(this.sYN.field_bankName) || !b(this.sYj, this.sYN.field_bankName + " " + string2)) {
                this.sYj.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sYj;
                }
                walletFormView = this.sYj;
            }
            if (b(this.sXs, this.sYN.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sXs;
                }
                walletFormView = this.sXs;
            }
            if (b(this.sYm, o.bMk().O(this.mController.xRr, this.sYN.sQF))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sYm;
                }
                walletFormView = this.sYm;
            }
            if (b(this.sNi, this.sYN.sRj)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sNi;
                }
                walletFormView = this.sNi;
            }
            if (b(this.sYn, this.sYN.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sYn;
                }
                walletFormView = this.sYn;
            }
            if (b(this.sYl, this.sYN.sQH)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sYl;
                }
                walletFormView = this.sYl;
            }
            if (b(this.sYk, this.sYN.sRl)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sYk;
                }
                walletFormView = this.sYk;
            }
            walletFormView2.setBackgroundResource(e.bBy);
            walletFormView.setBackgroundResource(e.bBy);
            if (o.bMc().bMv()) {
                this.sIX.setText(i.uWW);
            } else {
                this.sIX.setText(i.uWU);
            }
        }
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        if (bi.oN(str)) {
            walletFormView.setVisibility(8);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        return true;
    }

    private void bNh() {
        if (XT()) {
            c.bNV();
            this.sKx = new Authen();
            this.vf.putBoolean("key_is_follow_bank_username", this.sYD.isChecked());
            if (this.sYN == null || bi.oN(this.sYN.sRu)) {
                String text;
                boolean z;
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
                this.vf.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.abl(this.sKx.sOP));
                Bundle bundle = this.vf;
                String str = "key_is_oversea";
                if (this.sPU.sOT == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.sKx.sQE = this.sNi.getText();
                this.sKx.sQD = this.sXs.getText();
                this.sKx.sQI = this.sYk.getText();
                x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.sKx.pHW + " elemt.bankcardTag : " + this.sPU.sOT);
            } else {
                this.sKx.sHU = this.sYN.sRu;
                this.sKx.pfg = this.sYN.field_bindSerial;
                this.sKx.pff = this.sYN.field_bankcardType;
                this.sKx.sQF = this.sYN.sQF;
                this.sKx.sQC = this.vf.getString("key_pwd1");
                this.sKx.token = this.vf.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.ag(this);
            if (cCU().k(this.sKx, this.pVi)) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.vf;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.sKT);
        if (!(kVar instanceof y)) {
            return false;
        }
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
        h.bu(this, getString(i.uWh));
        return true;
    }

    protected final int getLayoutId() {
        return g.uLk;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.sPU = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    av();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.sYE = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bi.oN(intent.getStringExtra("Contact_City"))) {
                        this.odk = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.jyE = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        this.sYs.setText(stringExtra + " " + stringExtra4);
                    } else if (bi.oN(intent.getStringExtra("Contact_Province"))) {
                        this.jyE = this.sYE;
                        this.sYs.setText(stringExtra);
                    } else {
                        this.jyE = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.sYs.setText(stringExtra + " " + stringExtra3);
                    }
                    if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.sPU.sSV) {
                        this.sYv.setVisibility(8);
                        break;
                    } else {
                        this.sYv.setVisibility(0);
                        break;
                    }
                    break;
            }
            XT();
        }
    }

    private boolean XT() {
        boolean z;
        if (this.sYO.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.sIX.setEnabled(true);
            this.sIX.setClickable(true);
        } else {
            this.sIX.setEnabled(false);
            this.sIX.setClickable(false);
        }
        return z;
    }

    public final void hB(boolean z) {
        XT();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.sYy == null) {
                    bNh();
                } else if (this.sYy.isEnabled() && !this.sYy.isClickable() && this.sYy.cDd()) {
                    this.sYy.cDf();
                } else {
                    this.sYy.performClick();
                }
                return true;
            default:
                if (this.sYy == null) {
                    bNh();
                }
                return false;
        }
    }

    public void onDestroy() {
        if (this.qb != null && this.qb.isShowing()) {
            this.qb.dismiss();
            this.qb = null;
        }
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                Dialog kVar = new com.tencent.mm.ui.base.k(this, j.vfh);
                kVar.setContentView(g.uLF);
                ListView listView = (ListView) kVar.findViewById(f.bJf);
                listView.setAdapter(this.sYP);
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletCardImportUI.this.dismissDialog(1);
                        int intValue = ((Integer) WalletCardImportUI.this.sPU.bLO().get(i)).intValue();
                        if (WalletCardImportUI.this.sNm != intValue) {
                            WalletCardImportUI.this.sNm = intValue;
                            WalletCardImportUI.this.sYm.setText(((CheckedTextView) view).getText().toString());
                            WalletCardImportUI.c(WalletCardImportUI.this.sNi, WalletCardImportUI.this.sNm);
                            WalletCardImportUI.this.sNi.bnq();
                            WalletCardImportUI.this.av();
                        }
                    }
                });
                return kVar;
            default:
                return super.onCreateDialog(i);
        }
    }
}
