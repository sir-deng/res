package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.mall.a.c;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bym;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.protocal.c.byq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;

public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean jsh = false;
    private long lastUpdateTime = 0;
    private a[] orN = new a[4];
    private ac orO = new ac();
    private TextView orP = null;
    private View orQ = null;
    private boolean orR = false;

    class a {
        public TextView lhD;
        public CdnImageView oqI;
        public TextView orX;
        public View view;

        a() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.orQ = View.inflate(this, g.uJn, null);
        this.orQ.setClickable(false);
        this.orQ.setEnabled(false);
        this.orP = (TextView) this.orQ.findViewById(f.uGD);
        this.orO = o.bMi().zD(this.oqv);
        jl(1577);
        x.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        k cVar = new c();
        if (this.orO != null) {
            ac acVar = this.orO;
            boolean z = acVar.sVW == null || acVar.sVW.wpO == null || acVar.sVW.wpO.size() == 0;
            if (!z) {
                b(cVar, false);
                return;
            }
        }
        r(cVar);
    }

    protected final void aYR() {
        e.a(this.orB, "1", this.orO.sWb, this.orO.oiM);
    }

    public final void a(MallFunction mallFunction, int i) {
        super.a(mallFunction, i);
        com.tencent.mm.plugin.report.service.g.pWK.h(13720, mallFunction.nAW, Long.valueOf(bi.Wp(mallFunction.pHt)));
    }

    protected final void aYI() {
        String str = this.orO.sVZ;
        String str2 = this.orO.sWa;
        setMMTitle(str);
        setMMSubTitle(str2);
    }

    protected final void cp(View view) {
        this.orN[0] = new a();
        this.orN[0].view = view.findViewById(f.uyw);
        this.orN[0].oqI = (CdnImageView) view.findViewById(f.uyx);
        this.orN[0].lhD = (TextView) view.findViewById(f.uyz);
        this.orN[0].orX = (TextView) view.findViewById(f.uqz);
        this.orN[0].oqI.setVisibility(4);
        this.orN[1] = new a();
        this.orN[1].view = view.findViewById(f.ulj);
        this.orN[1].oqI = (CdnImageView) view.findViewById(f.uls);
        this.orN[1].lhD = (TextView) view.findViewById(f.ulv);
        this.orN[1].orX = (TextView) view.findViewById(f.ulr);
        this.orN[1].oqI.setVisibility(4);
        this.orN[2] = new a();
        this.orN[2].view = view.findViewById(f.ulC);
        this.orN[2].oqI = (CdnImageView) view.findViewById(f.ulT);
        this.orN[2].lhD = (TextView) view.findViewById(f.ulW);
        this.orN[2].orX = (TextView) view.findViewById(f.uqA);
        this.orN[2].oqI.setVisibility(4);
        this.orN[3] = new a();
        this.orN[3].view = view.findViewById(f.usv);
        this.orN[3].oqI = (CdnImageView) view.findViewById(f.usP);
        this.orN[3].lhD = (TextView) view.findViewById(f.utb);
        this.orN[3].oqI.setVisibility(4);
        this.orN[3].view.setVisibility(8);
    }

    protected final void aYJ() {
    }

    protected final void aYK() {
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", Integer.valueOf(com.tencent.mm.j.g.Af().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (com.tencent.mm.j.g.Af().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            b(new c(), false);
        }
        aYI();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1577);
    }

    protected final boolean aYM() {
        bym bym = this.orO.sVW;
        for (int i = 0; i < this.orN.length; i++) {
            this.orN[i].view.setVisibility(8);
            this.orN[i].oqI.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < bym.wpO.size() && i2 < this.orN.length) {
            final byn byn = (byn) bym.wpO.get(i2);
            this.orN[i2].view.setVisibility(0);
            this.orN[i2].oqI.setUrl(n.a(byn.xfH));
            this.orN[i2].oqI.setVisibility(0);
            this.orN[i2].lhD.setText(n.a(byn.xfG));
            x.i("MicroMsg.MallIndexOSUI", "item %d url %s", Integer.valueOf(i2), n.a(byn.xfH));
            this.orN[i2].orX.setVisibility(8);
            CharSequence a = n.a(byn.xfJ);
            if (!bi.oN(a)) {
                this.orN[i2].orX.setText(a);
                this.orN[i2].orX.setVisibility(0);
            }
            this.orN[i2].view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(13867, n.a(byn.xfI), Integer.valueOf(MallIndexOSUI.this.oqv));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", n.a(byn.xfI));
                    intent.putExtra("geta8key_username", q.FY());
                    intent.putExtra("pay_channel", 1);
                    d.b(MallIndexOSUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            });
            i2++;
        }
        if (!(this.orw == null || this.orQ == null || this.orR)) {
            this.orw.addFooterView(this.orQ);
            this.orR = true;
        }
        if (!bi.oN(this.orO.sWc)) {
            this.orP.setText(this.orO.sWc);
            this.orP.setVisibility(0);
        }
        return true;
    }

    protected final void aYS() {
    }

    protected final void aYU() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                final byp byp = MallIndexOSUI.this.orO.sVX;
                final boolean z = MallIndexOSUI.this.orO.sVY;
                if (z) {
                    strArr = new String[(byp.wpO.size() + 1)];
                    strArr[byp.wpO.size()] = MallIndexOSUI.this.getString(i.uYC);
                } else {
                    strArr = new String[byp.wpO.size()];
                }
                for (int i = 0; i < byp.wpO.size(); i++) {
                    strArr[i] = n.a(((byq) byp.wpO.get(i)).xfG);
                }
                h.a(MallIndexOSUI.this.mController.xRr, null, strArr, null, false, new h.c() {
                    public final void jo(int i) {
                        if (i < byp.wpO.size()) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", n.a(((byq) byp.wpO.get(i)).xfL));
                            d.b(MallIndexOSUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (z) {
                            MallIndexOSUI.this.aYW();
                        }
                    }
                });
                return true;
            }
        });
    }

    protected final void aYV() {
    }

    public void finish() {
        this.jsh = true;
        super.finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar.getType() == 1577) {
            this.orO = o.bMi().zD(this.oqv);
            aYR();
            aYM();
            aYI();
        }
        return true;
    }
}
