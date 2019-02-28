package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private boolean lGi = false;
    private ImageView lpW;
    private TextView lrc;
    private int mType;
    public String oiV = "";
    private MMLoadMoreListView omV;
    private d omW;
    private TextView omb;
    private boolean omh = true;
    private List<h> omo = new LinkedList();
    private Map<String, Integer> omp = new HashMap();
    public String omr = "";
    private TextView onK;
    private TextView onL;
    private TextView onM;
    private TextView onN;
    private TextView onO;
    private TextView onP;
    private TextView onQ;
    private View onR;
    private String onS;
    private int onT = -1;
    public List<String> onU = new ArrayList();
    private int wn = 0;

    class a extends BaseAdapter {
        int atq;
        List<String> onU;

        a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public final int getCount() {
            return this.onU.size();
        }

        public final String kF(int i) {
            return (String) this.onU.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(LuckyMoneyMyRecordUI.this.mController.xRr).inflate(g.uLG, viewGroup, false);
            checkedTextView.setText(kF(i));
            if (i == this.atq) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, h hVar, int i) {
        if (hVar == null || i < 0 || i > luckyMoneyMyRecordUI.omW.getCount()) {
            x.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            return;
        }
        luckyMoneyMyRecordUI.l(new z(hVar.oeH, hVar.ohB, luckyMoneyMyRecordUI.mType, i, "v1.0"));
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        if (luckyMoneyMyRecordUI.omo != null) {
            luckyMoneyMyRecordUI.omo.clear();
        }
        if (luckyMoneyMyRecordUI.omp != null) {
            luckyMoneyMyRecordUI.omp.clear();
        }
        luckyMoneyMyRecordUI.wn = 0;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(g.uJl, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.uwl);
                final a aVar = new a();
                List list = this.onU;
                if (list == null) {
                    aVar.onU = new ArrayList();
                } else {
                    aVar.onU = list;
                }
                aVar.notifyDataSetChanged();
                aVar.atq = 0;
                listViewInScrollView.setAdapter(aVar);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        LuckyMoneyMyRecordUI.this.dismissDialog(1);
                        String kF = aVar.kF(i);
                        aVar.atq = i;
                        if (!kF.equals(LuckyMoneyMyRecordUI.this.onS)) {
                            LuckyMoneyMyRecordUI.this.onS = kF;
                            LuckyMoneyMyRecordUI.this.onP.setText(LuckyMoneyMyRecordUI.this.getString(i.uRk, new Object[]{LuckyMoneyMyRecordUI.this.onS}));
                            LuckyMoneyMyRecordUI.this.wn = 0;
                            LuckyMoneyMyRecordUI.this.omo.clear();
                            LuckyMoneyMyRecordUI.this.omp.clear();
                            LuckyMoneyMyRecordUI.this.aYg();
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(LuckyMoneyMyRecordUI.this.aYq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), kF);
                    }
                });
                com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(this);
                aVar2.ES(i.uRo);
                aVar2.dk(inflate);
                aVar2.d(null);
                return aVar2.ale();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        aYg();
        com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(aYq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyMyRecordUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(LuckyMoneyMyRecordUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                gVar.rQF = new c() {
                    public final void a(n nVar) {
                        nVar.eT(1, i.uQV);
                        nVar.eT(2, i.uQW);
                    }
                };
                gVar.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                if (LuckyMoneyMyRecordUI.this.mType != 2) {
                                    LuckyMoneyMyRecordUI.this.mType = 2;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.this.aYp();
                                    LuckyMoneyMyRecordUI.this.aYg();
                                    return;
                                }
                                return;
                            case 2:
                                if (LuckyMoneyMyRecordUI.this.mType != 1) {
                                    LuckyMoneyMyRecordUI.this.mType = 1;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.this.aYp();
                                    LuckyMoneyMyRecordUI.this.aYg();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                gVar.bUX();
                return false;
            }
        });
        this.lrc = (TextView) findViewById(f.uuL);
        this.omV = (MMLoadMoreListView) findViewById(f.uuN);
        this.onR = LayoutInflater.from(this).inflate(g.uIY, null);
        this.omV.addHeaderView(this.onR);
        this.lpW = (ImageView) this.onR.findViewById(f.uuz);
        this.onK = (TextView) this.onR.findViewById(f.uuC);
        this.omb = (TextView) this.onR.findViewById(f.uuy);
        this.onL = (TextView) this.onR.findViewById(f.uuD);
        this.onM = (TextView) this.onR.findViewById(f.uuE);
        this.onN = (TextView) this.onR.findViewById(f.uuA);
        this.onO = (TextView) this.onR.findViewById(f.uuB);
        this.onP = (TextView) this.onR.findViewById(f.uuH);
        this.onQ = (TextView) this.onR.findViewById(f.uuG);
        this.omV.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 3;
                int i3 = (int) j;
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(LuckyMoneyMyRecordUI.this.aYq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.this.omW.getCount()) {
                    h sz = LuckyMoneyMyRecordUI.this.omW.sz(i3);
                    if (sz != null && !bi.oN(sz.oeH)) {
                        Intent intent = new Intent();
                        if (sz.ohM == 2) {
                            x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                            intent.setClass(LuckyMoneyMyRecordUI.this.mController.xRr, LuckyMoneyBusiDetailUI.class);
                        } else {
                            x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                            intent.setClass(LuckyMoneyMyRecordUI.this.mController.xRr, LuckyMoneyDetailUI.class);
                        }
                        intent.putExtra("key_sendid", sz.oeH);
                        if (LuckyMoneyMyRecordUI.this.mType != 1) {
                            i2 = 1;
                        }
                        intent.putExtra("key_jump_from", i2);
                        LuckyMoneyMyRecordUI.this.startActivity(intent);
                    }
                }
            }
        });
        this.omV.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i > 0 && i <= LuckyMoneyMyRecordUI.this.omW.getCount()) {
                    final int i2 = i - 1;
                    com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(i.uQQ), null, LuckyMoneyMyRecordUI.this.getResources().getString(i.dEH), new com.tencent.mm.ui.base.h.c() {
                        public final void jo(int i) {
                            switch (i) {
                                case 0:
                                    h sz = LuckyMoneyMyRecordUI.this.omW.sz(i2);
                                    if (sz != null) {
                                        LuckyMoneyMyRecordUI.this.onT = i2;
                                        LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, sz, i2);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.omV.ykC = new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void ayD() {
                if (!LuckyMoneyMyRecordUI.this.olU.aXJ()) {
                    LuckyMoneyMyRecordUI.this.lGi = false;
                }
                if (LuckyMoneyMyRecordUI.this.omh && !LuckyMoneyMyRecordUI.this.lGi) {
                    LuckyMoneyMyRecordUI.this.aYg();
                }
            }
        };
        this.lpW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (bi.oN(LuckyMoneyMyRecordUI.this.oiV)) {
                    x.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                } else {
                    com.tencent.mm.wallet_core.ui.e.l(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.oiV, true);
                }
            }
        });
        aYp();
    }

    private void aYp() {
        this.onQ.setVisibility(8);
        this.onR.findViewById(f.uuF).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(i.uQW));
            com.tencent.mm.plugin.luckymoney.b.n.a(this.mController.xRr, this.onK, getString(i.uRp, new Object[]{q.Ga()}));
            this.onM.setText(i.uRt);
            this.omW = new e(this.mController.xRr);
            this.onQ.setVisibility(0);
        } else {
            setMMTitle(getString(i.uQV));
            com.tencent.mm.plugin.luckymoney.b.n.a(this.mController.xRr, this.onK, getString(i.uRi, new Object[]{q.Ga()}));
            this.onM.setText(i.uRj);
            this.omW = new c(this.mController.xRr);
            this.onR.findViewById(f.uuF).setVisibility(0);
        }
        this.omV.setAdapter(this.omW);
        b.a(this.lpW, q.FY(), 0.0f, false);
        this.onP.setText(getString(i.uRk, new Object[]{bi.oM(this.onS)}));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        h hVar;
        if (kVar instanceof y) {
            if (i == 0 && i2 == 0) {
                y yVar = (y) kVar;
                List list = yVar.oiS.ohN;
                this.omr = yVar.oiI;
                this.oiV = yVar.oiV;
                if (this.wn == 0) {
                    this.onU = yVar.oiT;
                    this.onS = yVar.oiU;
                    View findViewById = findViewById(f.uuJ);
                    ImageView imageView = (ImageView) findViewById(f.uuI);
                    if (this.onU.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                LuckyMoneyMyRecordUI.this.showDialog(1);
                            }
                        });
                    }
                    this.onP.setText(getString(i.uRk, new Object[]{this.onS}));
                }
                com.tencent.mm.plugin.luckymoney.b.g gVar = yVar.oiS;
                if (gVar != null) {
                    if (this.mType == 1) {
                        this.omb.setText(com.tencent.mm.wallet_core.ui.e.t(((double) gVar.ohU) / 100.0d));
                        String str2 = gVar.ohT;
                        CharSequence string = getString(i.uRs, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhp));
                        int indexOf = string.indexOf(str2);
                        CharSequence spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.onQ.setText(spannableString);
                    } else {
                        this.omb.setText(com.tencent.mm.wallet_core.ui.e.t(((double) gVar.ohS) / 100.0d));
                        this.onL.setText(gVar.ohR);
                        this.onN.setText(gVar.hMB);
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        hVar = (h) list.get(i3);
                        if (!this.omp.containsKey(hVar.oeH)) {
                            this.omo.add(list.get(i3));
                            this.omp.put(hVar.oeH, Integer.valueOf(1));
                        }
                    }
                    this.wn += list.size();
                    this.omh = yVar.aXO();
                    this.lGi = false;
                    this.omW.bf(this.omo);
                }
                if (this.omo == null || this.omo.size() == 0) {
                    this.lrc.setVisibility(0);
                } else {
                    this.lrc.setVisibility(8);
                }
                if (this.omh) {
                    this.omV.cqd();
                } else {
                    this.omV.cqe();
                }
                return true;
            }
            this.oiV = null;
            return false;
        } else if (!(kVar instanceof z)) {
            return false;
        } else {
            int i4 = this.onT;
            this.onT = -1;
            if (i != 0 || i2 != 0) {
                return false;
            }
            hVar = this.omW.sz(i4);
            if (hVar != null) {
                Toast.makeText(this, i.uQR, 0).show();
                this.omW.a(hVar);
                this.omW.notifyDataSetChanged();
            } else {
                x.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return g.uJa;
    }

    private void aYg() {
        this.lGi = true;
        if (this.wn == 0) {
            this.omr = "";
        }
        l(new y(11, this.wn, this.mType, this.onS, "v1.0", this.omr));
    }

    private int aYq() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }
}
