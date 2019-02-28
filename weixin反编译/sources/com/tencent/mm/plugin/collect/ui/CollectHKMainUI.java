package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.y.q;

public class CollectHKMainUI extends CollectMainUI {
    private boolean lrQ = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsM.setVisibility(8);
        findViewById(f.uoT).setVisibility(0);
        findViewById(f.upl).setVisibility(8);
        cCY().jl(1335);
        addIconOptionMenu(0, e.ukw, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.wallet_core.ui.e.l(CollectHKMainUI.this.mController.xRr, "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        cCY().jm(1335);
    }

    protected final void azV() {
        g.Dr();
        this.lso = (String) g.Dq().Db().get(a.USERINFO_WALLET_HK_PAY_URL_STRING, (Object) "");
        k mVar = new m(q.Gf());
        if (bi.oN(this.lso)) {
            x.i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.lrQ = true;
            cCY().a(mVar, true, 1);
            return;
        }
        cCY().a(mVar, false, 1);
    }

    protected final String azW() {
        return this.lsp;
    }

    protected final String azX() {
        if (bi.oN(this.lsq)) {
            this.lsq = u.cCu();
        }
        return this.lsq;
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (kVar instanceof m) {
            final m mVar = (m) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.CollectHKMainUI", "net error: %s", kVar);
            } else if (mVar.lot == 0) {
                this.lso = mVar.lov;
                this.lsp = mVar.loH;
                this.lsq = mVar.loE;
                amN();
                if (bi.oN(mVar.loB)) {
                    this.lsM.setVisibility(8);
                } else {
                    this.lsJ.setText(mVar.loB);
                    this.lsM.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.wallet_core.ui.e.l(CollectHKMainUI.this.mController.xRr, mVar.loC, false);
                        }
                    });
                    this.lsM.setVisibility(0);
                }
                if (bi.oN(mVar.loF)) {
                    this.lsl.setVisibility(8);
                } else {
                    this.lsl.setText(mVar.loF);
                    this.lsl.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (!bi.oN(mVar.loG)) {
                                com.tencent.mm.wallet_core.ui.e.l(CollectHKMainUI.this.mController.xRr, mVar.loG, true);
                            }
                        }
                    });
                    this.lsl.setVisibility(0);
                }
                return true;
            }
            if (!this.lrQ) {
                return true;
            }
        }
        return false;
    }

    protected final void azY() {
        ImageView imageView = (ImageView) this.lqd.findViewById(f.upi);
        ImageView imageView2 = (ImageView) this.lqd.findViewById(f.uoZ);
        LayoutParams layoutParams = (LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (w.cfV().equals("zh_HK")) {
            imageView.setImageResource(h.uMY);
            imageView2.setImageResource(h.uMU);
            return;
        }
        imageView.setImageResource(h.uMX);
        imageView2.setImageResource(h.uMT);
    }

    protected final void azZ() {
        super.azZ();
        if (this.lsw) {
            findViewById(f.uoT).setVisibility(8);
        } else {
            findViewById(f.uoT).setVisibility(0);
        }
    }
}
