package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView jOY;
    private e pjH;
    private m pjs;
    private ImageView plR;
    private TextView plS;
    private TextView plT;
    private Button plU;
    private ListView plV;
    private MallProductSelectAmountView plW = null;
    private i plX = null;
    private f plY;
    private c plp;

    protected final int getLayoutId() {
        return g.uKf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.plY = new f(this.mController.xRr, new f.a() {
            public final void m(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    MallProductSelectSkuUI.this.av();
                } else {
                    MallProductSelectSkuUI.this.HY(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.bjs();
        this.plp = com.tencent.mm.plugin.product.a.a.bjt();
        this.pjs = this.plp.pjs;
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
        setMMTitle(i.uSd);
        this.plR = (ImageView) findViewById(f.uxl);
        this.jOY = (TextView) findViewById(f.uxp);
        this.plS = (TextView) findViewById(f.uxn);
        this.plT = (TextView) findViewById(f.uxk);
        this.plU = (Button) findViewById(f.uxm);
        this.plV = (ListView) findViewById(f.uxs);
        this.plW = (MallProductSelectAmountView) findViewById(f.uCQ);
        MallProductSelectAmountView mallProductSelectAmountView = this.plW;
        mallProductSelectAmountView.plO = this.plp.mCount;
        if (mallProductSelectAmountView.bjU()) {
            mallProductSelectAmountView.ikp.setText(mallProductSelectAmountView.plO);
            if (mallProductSelectAmountView.plP != null) {
                mallProductSelectAmountView.plP.es(mallProductSelectAmountView.plO);
            }
        }
        this.plX = new i(this);
        if (this.pjs == null || this.pjs.pjW == null || this.pjs.pjW.pkr == null) {
            x.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.plX.pma = this.pjs.pjW.pkr;
        }
        this.plX.pmb = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e eVar = null;
                Pair pair = (Pair) view.getTag();
                MallProductSelectSkuUI mallProductSelectSkuUI = MallProductSelectSkuUI.this;
                c b = MallProductSelectSkuUI.this.plp;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                x.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
                if (b.pjE.containsKey(str) && ((String) b.pjE.get(str)).equals(str2)) {
                    b.pjE.remove(str);
                    b.pjw = c.L(b.pjE);
                    b.pjH = b.pjD != null ? (e) b.pjD.get(b.pjw) : null;
                } else {
                    b.pjE.put(str, str2);
                    b.pjw = c.L(b.pjE);
                    x.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.pjw + ")");
                    if (b.pjD != null) {
                        b.pjH = (e) b.pjD.get(b.pjw);
                    }
                    mallProductSelectSkuUI.pjH = eVar;
                    MallProductSelectSkuUI.this.av();
                }
                b.bjK();
                eVar = b.pjH;
                mallProductSelectSkuUI.pjH = eVar;
                MallProductSelectSkuUI.this.av();
            }
        };
        this.plV.setAdapter(this.plX);
        this.plW.plP = new MallProductSelectAmountView.a() {
            public final void es(int i) {
                MallProductSelectSkuUI.this.plp.mCount = i;
                MallProductSelectSkuUI.this.plT.setVisibility(8);
            }

            public final void dm(int i, int i2) {
                switch (i2) {
                    case 1:
                        MallProductSelectSkuUI.this.plT.setText(i.uSb);
                        MallProductSelectSkuUI.this.plT.setVisibility(0);
                        return;
                    case 3:
                        MallProductSelectSkuUI.this.plT.setText(MallProductSelectSkuUI.this.getString(i.uSc, new Object[]{Integer.valueOf(i)}));
                        MallProductSelectSkuUI.this.plT.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
        };
        this.plU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f d = MallProductSelectSkuUI.this.plY;
                if (d.pln) {
                    u.makeText(d.iTL, i.uRY, 1).show();
                } else if (!d.plp.bjG()) {
                    String str;
                    c cVar = d.plp;
                    if (cVar.pjE != null && cVar.pjE.size() < cVar.pjC && cVar.pjC > 0) {
                        Iterator it = cVar.pjs.pjW.pkr.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.product.c.m mVar = (com.tencent.mm.plugin.product.c.m) it.next();
                            if (!cVar.pjE.containsKey(mVar.pkD)) {
                                str = mVar.pkE;
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!bi.oN(str)) {
                        u.makeText(d.iTL, d.iTL.getString(i.uxk, new Object[]{str}), 0).show();
                    }
                } else if (d.plp.pjy != null) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(new j(d.plp.bjI(), f.itU), 0);
                } else {
                    d.c(d.iTL, "address", ".ui.WalletAddAddressUI", 2);
                }
            }
        });
        this.plR.setFocusable(true);
        this.plR.setFocusableInTouchMode(true);
        this.plR.requestFocus();
    }

    private void av() {
        if (this.pjs != null) {
            if (this.pjH == null || this.pjs.pjW == null) {
                this.plS.setText(b.l(this.pjs.pjW.pki, this.pjs.pjW.pkj, this.pjs.pjW.pgf));
            } else {
                this.plS.setText(b.l(this.pjH.pjL, this.pjH.pjM, this.pjs.pjW.pgf));
            }
            if (this.pjs.pjW != null) {
                this.jOY.setText(this.pjs.pjW.name);
            }
        }
        if (!bi.oN(this.plp.bjw())) {
            this.plR.setImageBitmap(com.tencent.mm.platformtools.j.a(new c(this.plp.bjw())));
            com.tencent.mm.platformtools.j.a((a) this);
        }
        this.plT.setVisibility(8);
        MallProductSelectAmountView mallProductSelectAmountView = this.plW;
        int bjE = this.plp.bjE();
        int i = this.plp.pjs.pjV;
        if (bjE > i) {
            mallProductSelectAmountView.plM = 3;
            mallProductSelectAmountView.plL = i;
        } else {
            mallProductSelectAmountView.plM = 1;
            mallProductSelectAmountView.plL = bjE;
        }
        mallProductSelectAmountView.bjU();
        if (mallProductSelectAmountView.plP != null) {
            mallProductSelectAmountView.plP.es(mallProductSelectAmountView.plO);
        }
        this.plX.notifyDataSetChanged();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.plY.onActivityResult(i, i2, intent);
    }

    public final void l(String str, final Bitmap bitmap) {
        x.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (!bi.oN(this.plp.bjw())) {
            this.plR.post(new Runnable() {
                public final void run() {
                    MallProductSelectSkuUI.this.plR.setImageBitmap(bitmap);
                }
            });
        }
    }
}
