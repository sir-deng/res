package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<l> ugb;
    private List<l> ugc = new ArrayList();
    private l ugd;
    private l uge;
    private int ugf = -1;
    private boolean ugg;
    private boolean ugh;
    private TextView ugi;
    private TextView ugj;
    private TextView ugk;
    private TextView ugl;
    private TextView ugm;
    private TextView ugn;
    private EditText ugo;
    private EditText ugp;
    private EditText ugq;
    private EditText ugr;
    private BaseAdapter ugs = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            return BP(i);
        }

        public final int getCount() {
            return WalletWXCreditChangeAmountUI.this.ugc != null ? WalletWXCreditChangeAmountUI.this.ugc.size() : 0;
        }

        private l BP(int i) {
            return (l) WalletWXCreditChangeAmountUI.this.ugc.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, g.uLG, null);
            l BP = BP(i);
            checkedTextView.setText(BP.desc);
            checkedTextView.setChecked(BP.ufS != 0);
            return checkedTextView;
        }
    };
    private BaseAdapter ugt = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            return (l) WalletWXCreditChangeAmountUI.this.ugc.get(i);
        }

        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, g.uLG, null);
            if (i == 0) {
                checkedTextView.setText(i.dHo);
            } else {
                checkedTextView.setText(i.dGc);
            }
            if (WalletWXCreditChangeAmountUI.this.ugh) {
                if (WalletWXCreditChangeAmountUI.this.ugd.ufV == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.ugd.oik)) {
                    if (i == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (WalletWXCreditChangeAmountUI.this.uge.ufV == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.uge.oik)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            return checkedTextView;
        }
    };

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        walletWXCreditChangeAmountUI.ugc.clear();
        if (walletWXCreditChangeAmountUI.ugg) {
            for (l lVar : walletWXCreditChangeAmountUI.ugb) {
                if (lVar.ufS != 2) {
                    walletWXCreditChangeAmountUI.ugc.add(lVar);
                }
            }
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.ugb) {
            if (lVar2.ufS != 1) {
                walletWXCreditChangeAmountUI.ugc.add(lVar2);
            }
        }
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        if (walletWXCreditChangeAmountUI.ugd == null || walletWXCreditChangeAmountUI.uge == null) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.ugo.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugo.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.ugp.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugp.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.ugm.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugm.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.ugq.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugq.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.ugr.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugr.getText().toString())) {
            return false;
        }
        return (walletWXCreditChangeAmountUI.ugn.getVisibility() == 0 && bi.oN(walletWXCreditChangeAmountUI.ugn.getText().toString())) ? false : true;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate;
        ListViewInScrollView listViewInScrollView;
        a aVar;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(g.uLF, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJf);
                listViewInScrollView.setAdapter(this.ugs);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletWXCreditChangeAmountUI.this.dismissDialog(1);
                        if (WalletWXCreditChangeAmountUI.this.ugg) {
                            WalletWXCreditChangeAmountUI.this.ugd.ufS = 0;
                            WalletWXCreditChangeAmountUI.this.ugd = (l) WalletWXCreditChangeAmountUI.this.ugc.get(i);
                            WalletWXCreditChangeAmountUI.this.ugd.ufS = 1;
                        } else {
                            WalletWXCreditChangeAmountUI.this.uge.ufS = 0;
                            WalletWXCreditChangeAmountUI.this.uge = (l) WalletWXCreditChangeAmountUI.this.ugc.get(i);
                            WalletWXCreditChangeAmountUI.this.uge.ufS = 2;
                        }
                        WalletWXCreditChangeAmountUI.this.av();
                    }
                });
                aVar = new a(this);
                aVar.ES(i.veO);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.ale();
            case 2:
                inflate = getLayoutInflater().inflate(g.uLF, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJf);
                listViewInScrollView.setAdapter(this.ugt);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletWXCreditChangeAmountUI.this.dismissDialog(2);
                        if (WalletWXCreditChangeAmountUI.this.ugh) {
                            if (i == 0) {
                                WalletWXCreditChangeAmountUI.this.ugd.oik = "Y";
                            } else {
                                WalletWXCreditChangeAmountUI.this.ugd.oik = "N";
                            }
                        } else if (i == 0) {
                            WalletWXCreditChangeAmountUI.this.uge.oik = "Y";
                        } else {
                            WalletWXCreditChangeAmountUI.this.uge.oik = "N";
                        }
                        WalletWXCreditChangeAmountUI.this.av();
                    }
                });
                aVar = new a(this);
                aVar.ES(i.veK);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.ale();
            case 3:
                String string = getString(i.veN);
                if (this.ugf > 0) {
                    string = getString(i.veL, new Object[]{Integer.valueOf(this.ugf)});
                }
                return h.a((Context) this, string, null, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c ag = com.tencent.mm.wallet_core.a.ag(WalletWXCreditChangeAmountUI.this);
                        if (ag != null) {
                            ag.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.vf);
                        } else {
                            WalletWXCreditChangeAmountUI.this.finish();
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletWXCreditChangeAmountUI.this.showVKB();
                    }
                });
            default:
                return h.b(this, "", "", true);
        }
    }

    public final int getLayoutId() {
        return g.uMD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        av();
    }

    protected final void initView() {
        setMMTitle(i.veP);
        this.ugi = (TextView) findViewById(f.uHa);
        this.ugk = (TextView) findViewById(f.uHb);
        this.ugj = (TextView) findViewById(f.uHc);
        this.ugl = (TextView) findViewById(f.uHd);
        this.ugo = (EditText) findViewById(f.uGQ);
        this.ugp = (EditText) findViewById(f.uGR);
        this.ugq = (EditText) findViewById(f.uGS);
        this.ugr = (EditText) findViewById(f.uGT);
        this.ugm = (TextView) findViewById(f.uGU);
        this.ugn = (TextView) findViewById(f.uGV);
        this.ugm.setOnClickListener(this);
        this.ugn.setOnClickListener(this);
        this.ugi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletWXCreditChangeAmountUI.this.ugg = true;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
            }
        });
        this.ugj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletWXCreditChangeAmountUI.this.ugg = false;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletWXCreditChangeAmountUI.this.aWY();
                WalletWXCreditChangeAmountUI.this.showDialog(3);
                return true;
            }
        });
        findViewById(f.cAl).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
                    if (WalletWXCreditChangeAmountUI.this.ugd.ufV == null) {
                        WalletWXCreditChangeAmountUI.this.ugd.oik = WalletWXCreditChangeAmountUI.this.ugo.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.ugp.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.ugd.ufV.oik = WalletWXCreditChangeAmountUI.this.ugp.getText().toString();
                    }
                    if (WalletWXCreditChangeAmountUI.this.uge.ufV == null) {
                        WalletWXCreditChangeAmountUI.this.uge.oik = WalletWXCreditChangeAmountUI.this.ugq.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.ugr.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.uge.ufV.oik = WalletWXCreditChangeAmountUI.this.ugr.getText().toString();
                    }
                    List arrayList = new ArrayList();
                    arrayList.add(WalletWXCreditChangeAmountUI.this.ugd);
                    arrayList.add(WalletWXCreditChangeAmountUI.this.uge);
                    String string = WalletWXCreditChangeAmountUI.this.vf.getString("kreq_token");
                    WalletWXCreditChangeAmountUI.this.vf.getString("key_bank_type");
                    WalletWXCreditChangeAmountUI.this.r(new com.tencent.mm.plugin.wxcredit.a.c(arrayList, string));
                    return;
                }
                u.makeText(WalletWXCreditChangeAmountUI.this.mController.xRr, i.veM, 0).show();
            }
        });
    }

    private void av() {
        if (this.ugd != null) {
            this.ugi.setText(this.ugd.desc);
            if (this.ugd.ufV != null) {
                this.ugm.setVisibility(0);
                this.ugo.setVisibility(8);
                this.ugk.setText(this.ugd.ufV.desc);
                this.ugp.setHint(this.ugd.ufV.kTd);
                if ("Y".equals(this.ugd.oik)) {
                    this.ugk.setVisibility(0);
                    this.ugp.setVisibility(0);
                    this.ugm.setText(i.dHo);
                } else {
                    this.ugk.setVisibility(8);
                    this.ugp.setVisibility(8);
                    if ("N".equals(this.ugd.oik)) {
                        this.ugm.setText(i.dGc);
                    }
                }
            } else {
                this.ugm.setVisibility(8);
                this.ugo.setVisibility(0);
                this.ugo.setHint(this.ugd.kTd);
                this.ugk.setVisibility(8);
                this.ugp.setVisibility(8);
            }
        }
        if (this.uge != null) {
            this.ugj.setText(this.uge.desc);
            if (this.uge.ufV != null) {
                this.ugn.setVisibility(0);
                this.ugq.setVisibility(8);
                this.ugl.setText(this.uge.ufV.desc);
                this.ugr.setHint(this.uge.ufV.kTd);
                if ("Y".equals(this.uge.oik)) {
                    this.ugl.setVisibility(0);
                    this.ugr.setVisibility(0);
                    this.ugn.setText(i.dHo);
                    return;
                }
                this.ugl.setVisibility(8);
                this.ugr.setVisibility(8);
                if ("N".equals(this.uge.oik)) {
                    this.ugn.setText(i.dGc);
                    return;
                }
                return;
            }
            this.ugn.setVisibility(8);
            this.ugq.setVisibility(0);
            this.ugq.setHint(this.uge.kTd);
            this.ugl.setVisibility(8);
            this.ugr.setVisibility(8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                this.ugb = ((e) kVar).ufz;
                this.ugf = ((e) kVar).ufA;
                if (this.ugb != null && this.ugb.size() >= 2) {
                    this.ugd = (l) this.ugb.get(0);
                    this.uge = (l) this.ugb.get(1);
                    this.ugd.ufS = 1;
                    this.uge.ufS = 2;
                }
                av();
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.c) {
            h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    c ag = com.tencent.mm.wallet_core.a.ag(WalletWXCreditChangeAmountUI.this);
                    if (ag != null) {
                        ag.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.vf);
                    } else {
                        WalletWXCreditChangeAmountUI.this.finish();
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == f.uGU) {
            this.ugh = true;
            showDialog(2);
        } else if (view.getId() == f.uGV) {
            this.ugh = false;
            showDialog(2);
        }
    }
}
