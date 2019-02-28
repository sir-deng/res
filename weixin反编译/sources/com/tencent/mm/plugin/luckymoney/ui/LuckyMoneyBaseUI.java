package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.f;

public abstract class LuckyMoneyBaseUI extends MMActivity implements f {
    public i olU = null;
    private j olV = null;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.olU = new i(this, this);
        this.olU.jl(1554);
        this.olU.jl(1575);
        this.olU.jl(1668);
        this.olU.jl(1581);
        this.olU.jl(1685);
        this.olU.jl(1585);
        this.olU.jl(1514);
        this.olU.jl(1682);
        this.olU.jl(1612);
        this.olU.jl(1643);
        this.olU.jl(1558);
        this.olV = new j(this);
        this.olV.opS = 1;
        j jVar = this.olV;
        a G = j.G(jVar.isO, jVar.opS);
        if (jVar.isO.getSupportActionBar() != null) {
            if (G.opU != null) {
                jVar.isO.getSupportActionBar().setBackgroundDrawable(G.opU);
            }
            View customView = jVar.isO.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
                if (!(findViewById == null || G.kjx == 0)) {
                    findViewById.setBackgroundColor(G.kjx);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || G.opV == 0)) {
                    textView.setTextColor(G.opV);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || G.opW == 0)) {
                    textView.setTextColor(G.opW);
                }
                ImageView imageView = (ImageView) customView.findViewById(com.tencent.mm.plugin.wxpay.a.f.bIX);
                if (!(imageView == null || G.opX == 0)) {
                    imageView.setImageResource(G.opX);
                }
            }
            if (G.opY != 0) {
                jVar.sE(G.opY);
            }
        }
        getLayoutId();
    }

    public final void r(Drawable drawable) {
        j jVar = this.olV;
        if (jVar.isO.getSupportActionBar() != null) {
            jVar.isO.getSupportActionBar().setBackgroundDrawable(drawable);
        }
    }

    public final void aYe() {
        j jVar = this.olV;
        if (jVar.isO.getSupportActionBar() != null) {
            jVar.isO.getSupportActionBar().show();
        }
        jVar = this.olV;
        a G = j.G(jVar.isO, jVar.opS);
        if (G.opY != 0) {
            jVar.sE(G.opY);
        }
    }

    public final void aYf() {
        j jVar = this.olV;
        if (jVar.isO.getSupportActionBar() != null) {
            jVar.isO.getSupportActionBar().hide();
        }
        jVar = this.olV;
        jVar.sE(jVar.opT);
    }

    public void onDestroy() {
        this.olU.jm(1554);
        this.olU.jm(1575);
        this.olU.jm(1668);
        this.olU.jm(1581);
        this.olU.jm(1685);
        this.olU.jm(1585);
        this.olU.jm(1514);
        this.olU.jm(1682);
        this.olU.jm(1612);
        this.olU.jm(1643);
        this.olU.jm(1558);
        this.olV = null;
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.olU.aXJ()) {
                this.olU.aXI();
            }
            if (this.mController.contentView.getVisibility() == 8 || this.mController.contentView.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!d(i, i2, str, kVar)) {
            if (i != 0 || i2 != 0) {
                h.bu(this, str);
                finish();
            }
        }
    }

    public final void jl(int i) {
        this.olU.jl(i);
    }

    public final void jm(int i) {
        this.olU.jm(i);
    }

    public final void b(k kVar, boolean z) {
        this.olU.b(kVar, z);
    }

    public final void l(k kVar) {
        this.olU.b(kVar, true);
    }
}
