package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.plugin.collect.b.p;
import com.tencent.mm.plugin.collect.b.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.q;
import java.util.List;

public class CollectBillUI extends WalletBaseUI {
    private int asN = 20;
    private int fromScene;
    private boolean hjU = false;
    private String ijC;
    private l jAo;
    private View lap;
    private long lom;
    private ListView lqY;
    private MMSwitchBtn lrA;
    private TextView lrB;
    private boolean lrC = false;
    private boolean lrD = true;
    private long lrE;
    private e lrF = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof j) {
                j jVar = (j) kVar;
                if (i == 0 && i2 == 0) {
                    List<cp> list = jVar.loq.waM;
                    if (list == null || list.isEmpty()) {
                        CollectBillUI.this.lrB.setVisibility(8);
                        return;
                    }
                    for (final cp cpVar : list) {
                        if (cpVar.type == 1 && !bi.oN(cpVar.fzT)) {
                            x.i("MicroMsg.CollectBillUI", "show notice");
                            CollectBillUI.this.lrB.setText(cpVar.fzT);
                            CollectBillUI.this.lrB.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (!bi.oN(cpVar.url)) {
                                        com.tencent.mm.wallet_core.ui.e.l(CollectBillUI.this.mController.xRr, cpVar.url, true);
                                    }
                                }
                            });
                            CollectBillUI.this.lrB.setVisibility(0);
                            return;
                        }
                    }
                    CollectBillUI.this.lrB.setVisibility(8);
                    return;
                }
                x.e("MicroMsg.CollectBillUI", "net error: %s", jVar);
                CollectBillUI.this.lrB.setVisibility(8);
            }
        }
    };
    private d lrG = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            if (menuItem.getItemId() == 0) {
                a aVar = (a) CollectBillUI.this.lqY.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
                if (aVar != null) {
                    CollectBillUI.a(CollectBillUI.this, aVar.lnP, aVar.timestamp);
                }
            }
        }
    };
    private boolean lrg = false;
    private a lru;
    private LinearLayout lrv;
    private CollectBillHeaderView lrw;
    private ImageView lrx;
    private MMSwitchBtn lry;
    private ImageView lrz;
    private int type;

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j) {
        x.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", str, Long.valueOf(j));
        k pVar = new p(str, collectBillUI.type, j);
        collectBillUI.lrD = true;
        collectBillUI.r(pVar);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        if (!collectBillUI.lrC) {
            x.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.lqY.addFooterView(collectBillUI.lap, null, false);
            collectBillUI.lrC = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lrE = q.Gd();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.lom = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        azQ();
        initView();
        setMMTitle(i.uOV);
        g.Dr();
        g.Dp().gRu.a(1256, this.lrF);
        k jVar = new j();
        g.Dr();
        g.Dp().gRu.a(jVar, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        g.Dr();
        g.Dp().gRu.b(1256, this.lrF);
    }

    protected final void initView() {
        this.lqY = (ListView) findViewById(f.uoK);
        this.lrv = (LinearLayout) findViewById(f.uow);
        this.lrB = (TextView) findViewById(f.uot);
        this.lap = v.fw(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uHX, this.lqY, false);
        this.lrw = new CollectBillHeaderView(this);
        this.lqY.addHeaderView(this.lrw, null, false);
        this.lru = new a(this);
        this.lqY.setAdapter(this.lru);
        this.lqY.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (CollectBillUI.this.lqY.getLastVisiblePosition() == CollectBillUI.this.lru.getCount() && CollectBillUI.this.lru.getCount() > 0 && !CollectBillUI.this.hjU && !CollectBillUI.this.lrg) {
                    CollectBillUI.f(CollectBillUI.this);
                    CollectBillUI.this.azQ();
                }
            }
        });
        this.jAo = new l(this);
        this.lqY.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    x.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                    return;
                }
                a aVar = (a) CollectBillUI.this.lqY.getItemAtPosition(i);
                if (aVar == null) {
                    x.w("MicroMsg.CollectBillUI", "invalid position: %d", Integer.valueOf(i));
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("scene", 2);
                intent.putExtra("trans_id", aVar.lnQ);
                intent.putExtra("bill_id", aVar.lnP);
                com.tencent.mm.bl.d.b(CollectBillUI.this.mController.xRr, "order", ".ui.MallOrderTransactionInfoUI", intent);
            }
        });
        this.lqY.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    x.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                    return false;
                }
                CollectBillUI.this.jAo.a(view, i, j, CollectBillUI.this, CollectBillUI.this.lrG);
                return true;
            }
        });
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(i.uOT), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    CollectBillUI.this.startActivity(new Intent(CollectBillUI.this.mController.xRr, CollectBillListUI.class));
                    return false;
                }
            });
        }
        if (this.fromScene == 2) {
            View findViewById = this.lrw.findViewById(f.upt);
            View findViewById2 = this.lrv.findViewById(f.ups);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        this.lrx = (ImageView) this.lrw.findViewById(f.upq);
        this.lry = (MMSwitchBtn) this.lrw.findViewById(f.upr);
        this.lrz = (ImageView) this.lrv.findViewById(f.upq);
        this.lrA = (MMSwitchBtn) this.lrv.findViewById(f.upr);
        com.tencent.mm.plugin.collect.a.a.azl();
        if (com.tencent.mm.plugin.collect.a.a.azn()) {
            this.lry.nJ(true);
            this.lrA.nJ(true);
            this.lrx.setImageResource(h.uMW);
            this.lrz.setImageResource(h.uMW);
        } else {
            this.lry.nJ(false);
            this.lrA.nJ(false);
            this.lrx.setImageResource(h.uMV);
            this.lrz.setImageResource(h.uMV);
        }
        MMSwitchBtn.a anonymousClass6 = new MMSwitchBtn.a() {
            public final void cy(boolean z) {
                int i;
                x.i("MicroMsg.CollectBillUI", "update switch: %B", Boolean.valueOf(z));
                CollectBillUI.this.lry.nJ(z);
                CollectBillUI.this.lrA.nJ(z);
                if (z) {
                    CollectBillUI.this.lrE = CollectBillUI.this.lrE | 32768;
                    CollectBillUI.this.lrx.setImageResource(h.uMW);
                    CollectBillUI.this.lrz.setImageResource(h.uMW);
                    Toast.makeText(CollectBillUI.this.mController.xRr, i.uPl, 1).show();
                    com.tencent.mm.plugin.report.service.g.pWK.h(13944, Integer.valueOf(11));
                    i = 1;
                } else {
                    CollectBillUI.this.lrE = CollectBillUI.this.lrE & -32769;
                    CollectBillUI.this.lrx.setImageResource(h.uMV);
                    CollectBillUI.this.lrz.setImageResource(h.uMV);
                    Toast.makeText(CollectBillUI.this.mController.xRr, i.uPe, 1).show();
                    com.tencent.mm.plugin.report.service.g.pWK.h(13944, Integer.valueOf(12));
                    i = 2;
                }
                g.Dr();
                g.Dq().Db().set(147457, Long.valueOf(CollectBillUI.this.lrE));
                com.tencent.mm.bp.a asn = new asn();
                asn.pWh = i;
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(c.CTRL_INDEX, asn));
                if (i == 1) {
                    com.tencent.mm.plugin.collect.a.a.azl().azo();
                } else {
                    com.tencent.mm.plugin.collect.a.a.azl().azp();
                }
            }
        };
        this.lry.zEt = anonymousClass6;
        this.lrA.zEt = anonymousClass6;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, i.uOU);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            r rVar = (r) kVar;
            if (this.lrC) {
                this.lqY.removeFooterView(this.lap);
                this.lrC = false;
            }
            if (i == 0 && i2 == 0) {
                this.hjU = rVar.hjU;
                this.type = rVar.type;
                this.lom = rVar.lom;
                d(rVar.lon, rVar.loo, rVar.lom);
                if (rVar.loQ.isEmpty()) {
                    this.hjU = true;
                    if (bi.oN(this.ijC)) {
                        x.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        azP();
                    }
                } else {
                    if (bi.oN(this.ijC)) {
                        x.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.lqY.setVisibility(0);
                        this.lrv.setVisibility(8);
                    }
                    a aVar = this.lru;
                    aVar.lqU.addAll(rVar.loQ);
                    aVar.notifyDataSetChanged();
                    this.ijC = ((a) rVar.loQ.get(rVar.loQ.size() - 1)).lnP;
                }
                this.lrg = false;
                return true;
            }
            x.i("MicroMsg.CollectBillUI", "net error!");
            this.lrg = false;
            Toast.makeText(this, i.uOQ, 1).show();
            if (bi.oN(this.ijC)) {
                x.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            return true;
        } else if (!(kVar instanceof p)) {
            return false;
        } else {
            p pVar = (p) kVar;
            if (i == 0 && i2 == 0) {
                a aVar2 = this.lru;
                String str2 = pVar.lnP;
                for (a aVar3 : aVar2.lqU) {
                    if (aVar3.lnP.equals(str2)) {
                        aVar2.lqU.remove(aVar3);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.lru.getCount() <= 0) {
                    x.i("MicroMsg.CollectBillUI", "delete all records");
                    azP();
                } else {
                    d(pVar.lon, pVar.loo, this.lom);
                }
                return false;
            }
            x.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", Integer.valueOf(i), Integer.valueOf(i2), str, pVar.lnP);
            Toast.makeText(this, i.uOP, 1).show();
            return false;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uHQ;
    }

    private void d(int i, int i2, long j) {
        if (this.lrD) {
            CollectBillHeaderView collectBillHeaderView = this.lrw;
            collectBillHeaderView.lqV.setText(com.tencent.mm.plugin.collect.b.e.a(collectBillHeaderView.getContext(), j, this.type));
            collectBillHeaderView.lqW.setText(com.tencent.mm.plugin.collect.b.e.oI(i2));
            collectBillHeaderView.lpZ.setText(collectBillHeaderView.getContext().getString(i.uOW, new Object[]{Integer.valueOf(i)}));
            this.lrD = false;
        }
    }

    private void azQ() {
        if (!this.hjU) {
            r(new r(this.type, this.lom, this.ijC, this.asN));
            this.lrg = true;
        }
    }

    private void azP() {
        this.lqY.setVisibility(8);
        this.lrv.setVisibility(0);
        findViewById(f.uox).setVisibility(0);
    }
}
