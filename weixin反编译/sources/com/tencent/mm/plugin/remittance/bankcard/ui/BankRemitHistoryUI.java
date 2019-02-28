package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRemitHistoryUI extends BankRemitBaseUI implements d {
    private int asN = 20;
    private boolean ikx = false;
    private boolean iky = false;
    private l jAo;
    private View lLV;
    private int offset = 0;
    private ListView pOA;
    private a pOB;
    private List<akr> pOC = new ArrayList();

    private class a extends BaseAdapter {
        private SimpleDateFormat pOG;

        private a() {
            this.pOG = new SimpleDateFormat(BankRemitHistoryUI.this.mController.xRr.getString(i.uOn));
        }

        /* synthetic */ a(BankRemitHistoryUI bankRemitHistoryUI, byte b) {
            this();
        }

        public final int getCount() {
            return BankRemitHistoryUI.this.pOC.size();
        }

        public final Object getItem(int i) {
            return BankRemitHistoryUI.this.pOC.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            if (view == null) {
                view = LayoutInflater.from(BankRemitHistoryUI.this.mController.xRr).inflate(g.uHC, viewGroup, false);
                view.setTag(new b(view));
            }
            b bVar = (b) view.getTag();
            akr akr = (akr) getItem(i);
            Object bq = bq(akr.wyB);
            if (i == 0) {
                z = true;
            } else if (bq.equals(bq(((akr) getItem(i - 1)).wyB))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar.pOH.setText(bq);
                bVar.pOH.setVisibility(0);
            } else {
                bVar.pOH.setVisibility(8);
            }
            bVar.pOK.setUrl(akr.pMZ);
            bVar.jbl.setText(akr.title);
            bVar.pOI.setText(akr.wyC);
            bVar.iko.setText(akr.wyA);
            if (bi.oN(akr.wyD)) {
                bVar.pOJ.setVisibility(8);
            } else {
                if (!bi.oN(akr.wyE)) {
                    bVar.pOJ.setTextColor(Color.parseColor(akr.wyE));
                }
                bVar.pOJ.setText(akr.wyD);
                bVar.pOJ.setVisibility(0);
            }
            return view;
        }

        private String bq(long j) {
            return this.pOG.format(new Date(1000 * j));
        }
    }

    private class b {
        TextView iko;
        TextView jbl;
        TextView pOH;
        TextView pOI;
        TextView pOJ;
        CdnImageView pOK;

        public b(View view) {
            this.pOH = (TextView) view.findViewById(f.umT);
            this.jbl = (TextView) view.findViewById(f.umS);
            this.pOI = (TextView) view.findViewById(f.umU);
            this.iko = (TextView) view.findViewById(f.umR);
            this.pOJ = (TextView) view.findViewById(f.umV);
            this.pOK = (CdnImageView) view.findViewById(f.umQ);
        }
    }

    static /* synthetic */ void a(BankRemitHistoryUI bankRemitHistoryUI, String str) {
        for (int size = bankRemitHistoryUI.pOC.size() - 1; size >= 0; size--) {
            if (((akr) bankRemitHistoryUI.pOC.get(size)).vWn.equals(str)) {
                bankRemitHistoryUI.pOC.remove(size);
                bankRemitHistoryUI.pOB.notifyDataSetChanged();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1511);
        jl(1737);
        setMMTitle(i.uOo);
        initView();
        boc();
    }

    protected final void initView() {
        this.pOA = (ListView) findViewById(f.umW);
        this.lLV = LayoutInflater.from(this).inflate(g.uHv, null);
        this.jAo = new l(this);
        this.pOB = new a();
        this.pOA.addFooterView(this.lLV);
        this.pOA.setAdapter(this.pOB);
        this.pOA.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.BankRemitHistoryUI", "click item, %s", ((akr) adapterView.getAdapter().getItem(i)).title);
                BankRemitHistoryUI.this.jAo.a(view, i, j, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
                return false;
            }
        });
        this.pOA.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (BankRemitHistoryUI.this.pOA.getLastVisiblePosition() == BankRemitHistoryUI.this.pOA.getCount() - 1 && BankRemitHistoryUI.this.pOA.getCount() > 0 && !BankRemitHistoryUI.this.iky && !BankRemitHistoryUI.this.ikx) {
                    BankRemitHistoryUI.this.boc();
                }
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, i.uOw);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        akr akr = (akr) this.pOA.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && akr != null) {
            x.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", akr.vWn);
            k eVar = new e(r0);
            eVar.k(this);
            l(eVar);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.i) {
            final com.tencent.mm.plugin.remittance.bankcard.a.i iVar = (com.tencent.mm.plugin.remittance.bankcard.a.i) kVar;
            iVar.a(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    if (iVar.pMT.wxD != null) {
                        x.i("MicroMsg.BankRemitHistoryUI", "history size: %s", Integer.valueOf(iVar.pMT.wxD.size()));
                        if (iVar.pMT.wxD.size() < iVar.asN) {
                            x.i("MicroMsg.BankRemitHistoryUI", "is last: %s", Integer.valueOf(BankRemitHistoryUI.this.offset));
                            BankRemitHistoryUI.this.iky = true;
                            BankRemitHistoryUI.this.pOA.removeFooterView(BankRemitHistoryUI.this.lLV);
                        }
                        if (iVar.pMT.wxD != null) {
                            BankRemitHistoryUI.this.offset = BankRemitHistoryUI.this.offset + iVar.pMT.wxD.size();
                            BankRemitHistoryUI.this.pOC.addAll(iVar.pMT.wxD);
                            BankRemitHistoryUI.this.pOB.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.BankRemitHistoryUI", "return history is null");
                    BankRemitHistoryUI.this.iky = true;
                    BankRemitHistoryUI.this.pOA.removeFooterView(BankRemitHistoryUI.this.lLV);
                }
            }).b(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", Integer.valueOf(iVar.pMT.lot), iVar.pMT.lou);
                }
            }).c(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "net error: %s", kVar);
                }
            });
            this.ikx = false;
        } else if (kVar instanceof e) {
            final e eVar = (e) kVar;
            eVar.a(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    BankRemitHistoryUI.a(BankRemitHistoryUI.this, eVar.lnP);
                }
            }).b(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", Integer.valueOf(eVar.pMP.lot), eVar.pMP.lou);
                }
            }).c(new com.tencent.mm.wallet_core.c.g.a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "net error: %s", kVar);
                }
            });
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uHD;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1511);
        jm(1737);
    }

    private void boc() {
        x.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", Integer.valueOf(this.asN), Integer.valueOf(this.offset));
        this.ikx = true;
        k iVar = new com.tencent.mm.plugin.remittance.bankcard.a.i(this.asN, this.offset);
        iVar.k(this);
        b(iVar, false);
    }
}
