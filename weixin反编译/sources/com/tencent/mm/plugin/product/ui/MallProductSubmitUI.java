package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ad.n;
import com.tencent.mm.bl.d;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private TextView jOY;
    private Button lXK;
    private e pjH;
    private ImageView plR;
    private TextView plS;
    private f plY;
    private c plp;
    private RelativeLayout pmo;
    private TextView pmp;
    private TextView pmq;
    private MallProductItemView pmr;
    private MallProductItemView pms;
    private TextView pmt;
    private TextView pmu;
    private TextView pmv;
    private TextView pmw;
    private ListView pmx;
    private a pmy;

    protected final int getLayoutId() {
        return g.uKi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.plY = new f(this.mController.xRr, new f.a() {
            public final void m(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    MallProductSubmitUI.this.av();
                } else {
                    MallProductSubmitUI.this.HY(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.bjs();
        this.plp = com.tencent.mm.plugin.product.a.a.bjt();
        this.pjH = this.plp.pjH;
        initView();
        av();
    }

    public void onStart() {
        this.plY.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.plY.onStop();
        super.onStop();
    }

    protected final void initView() {
        setMMTitle(i.uSo);
        this.pmo = (RelativeLayout) findViewById(f.uxA);
        this.pmp = (TextView) findViewById(f.uxC);
        this.pmq = (TextView) findViewById(f.uxB);
        this.pmr = (MallProductItemView) findViewById(f.uxD);
        this.pms = (MallProductItemView) findViewById(f.uxF);
        this.plR = (ImageView) findViewById(f.uxE);
        this.jOY = (TextView) findViewById(f.uxM);
        this.pmt = (TextView) findViewById(f.uxG);
        this.plS = (TextView) findViewById(f.uxK);
        this.pmu = (TextView) findViewById(f.uxJ);
        this.pmv = (TextView) findViewById(f.uxI);
        this.pmw = (TextView) findViewById(f.uxN);
        this.pmx = (ListView) findViewById(f.uxH);
        this.pmy = new a(this);
        this.pmx.setAdapter(this.pmy);
        this.pmx.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 1:
                        if (bVar.pkW instanceof String) {
                            MallProductSubmitUI.this.plp.pjB = (String) bVar.pkW;
                            break;
                        }
                        break;
                    case 2:
                        m mVar = MallProductSubmitUI.this.plp.pjs;
                        if (mVar.pjW.pkk != null && mVar.pjW.pkk.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.pjW.pkk.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.pkW = arrayList;
                            break;
                        }
                }
                MallProductSubmitUI.this.pmy.a(MallProductSubmitUI.this, view, i);
            }
        });
        this.lXK = (Button) findViewById(f.uxL);
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f d = MallProductSubmitUI.this.plY;
                if (d.plp.bjH()) {
                    int i;
                    if (d.plp.bjy() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Dr();
                        n nVar = com.tencent.mm.kernel.g.Dp().gRu;
                        bke bjJ = d.plp.bjJ();
                        d.plp.getAppId();
                        nVar.a(new k(bjJ), 0);
                        return;
                    }
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(new l(d.plp.bjJ(), d.plp.getAppId()), 0);
                }
            }
        });
        this.pmo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f d = MallProductSubmitUI.this.plY;
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", true);
                d.a(d.iTL, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
            }
        });
        this.pmr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MallProductSubmitUI.this.showDialog(1);
            }
        });
        this.pms.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f d = MallProductSubmitUI.this.plY;
                d.iTL.startActivityForResult(new Intent(d.iTL, MallProductReceiptUI.class), 4);
            }
        });
        MallProductItemView mallProductItemView = this.pms;
        boolean z = (this.plp.bjv().plm & 2) > 0;
        x.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + z);
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.plp.bjv().bjR()) {
            this.pmr.setEnabled(false);
            this.pmr.setClickable(false);
            this.pmr.Ia(getString(i.uSn));
        }
    }

    private void av() {
        m mVar = this.plp.pjs;
        if (this.pjH != null) {
            this.plS.setText(b.l(this.pjH.pjL, this.pjH.pjL, mVar.pjW.pgf) + " x " + this.plp.mCount);
        } else {
            this.plS.setText(b.l(mVar.pjW.pki, mVar.pjW.pkj, mVar.pjW.pgf));
        }
        if (!bi.oN(this.plp.bjw())) {
            this.plR.setImageBitmap(j.a(new c(this.plp.bjw())));
            j.a((a) this);
        }
        this.jOY.setText(mVar.pjW.name);
        this.pmt.setText(this.plp.bjx());
        bcn bjA = this.plp.bjA();
        if (bjA == null || bi.oN(bjA.nlZ)) {
            this.pms.Ia("");
        } else {
            this.pms.Ia(bjA.nlZ);
        }
        String str = "";
        if (!this.plp.bjv().bjR()) {
            tr trVar = this.plp.pjx;
            if (trVar != null) {
                this.pmr.setEnabled(true);
                this.pmr.setClickable(true);
                this.pmr.Ia(b.a(this, trVar));
                str = getString(i.uSl, new Object[]{b.c((double) trVar.vWH, trVar.whH)});
                this.pmq.setVisibility(8);
            } else {
                this.pmr.setEnabled(false);
                this.pmr.setClickable(false);
                this.pmr.Ia(getString(i.uSm));
                this.pmq.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.plp.bjz() > 0) {
            bi.oN(str);
            str2 = getString(i.uSk, new Object[]{b.c((double) r3, mVar.pjW.pgf)});
        }
        List G = this.plp.G(this);
        if (G.size() > 0) {
            this.pmx.setVisibility(0);
            this.pmy.bp(G);
            this.pmy.notifyDataSetChanged();
        } else {
            this.pmx.setVisibility(8);
        }
        if (this.plp.pjy != null) {
            this.pmp.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.kyG, r3.vOc, r3.hxf, r3.hxg, r3.nlZ})));
        }
        if (bi.oN(str + str2)) {
            this.pmv.setVisibility(0);
            this.pmu.setVisibility(8);
        } else {
            this.pmu.setText(getString(i.uSj, new Object[]{str}));
            this.pmv.setVisibility(8);
            this.pmu.setVisibility(0);
        }
        this.pmw.setText(b.c((double) this.plp.bjy(), mVar.pjW.pgf));
        this.lXK.setEnabled(this.plp.bjH());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.plY.onActivityResult(i, i2, intent);
    }

    public final void l(String str, final Bitmap bitmap) {
        x.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (!bi.oN(this.plp.bjw())) {
            this.plR.post(new Runnable() {
                public final void run() {
                    MallProductSubmitUI.this.plR.setImageBitmap(bitmap);
                }
            });
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                List<tr> list = this.plp.pjF;
                if (list != null) {
                    List arrayList = new ArrayList();
                    for (tr a : list) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(i.uxD);
                    OnItemClickListener anonymousClass8 = new OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            MallProductSubmitUI.this.dismissDialog(1);
                            MallProductSubmitUI.this.plp.uU(i);
                            MallProductSubmitUI.this.av();
                        }
                    };
                    ListAdapter aVar = new a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, g.gZk, null);
                    listViewInScrollView.setOnItemClickListener(new com.tencent.mm.plugin.product.ui.d.AnonymousClass1(anonymousClass8, aVar));
                    aVar.plg = arrayList;
                    aVar.plh = 0;
                    listViewInScrollView.setAdapter(aVar);
                    com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(this);
                    aVar2.Zm(string);
                    aVar2.dk(listViewInScrollView);
                    aVar2.d(null);
                    Dialog ale = aVar2.ale();
                    ale.show();
                    return ale;
                }
                break;
        }
        return super.onCreateDialog(i);
    }
}
