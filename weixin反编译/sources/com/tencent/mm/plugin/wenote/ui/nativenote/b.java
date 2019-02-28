package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b {
    private TextView ikn = null;

    public b(Context context) {
        super(context);
        if (this.view != null) {
            this.ikn = (TextView) this.view.findViewById(R.h.cZz);
            this.ikn.setTextSize(0, (float) a.aa(this.ikn.getContext(), R.f.bvt));
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.i("WNNoteBanner", "click WNNoteBanner");
                    p bXx = h.bXw().bXx();
                    if (bXx == null) {
                        x.i("WNNoteBanner", "keepTopItem is null");
                        b.this.setVisibility(8);
                    } else if (bXx.tYq) {
                        if (bXx.tYt) {
                            g.pWK.h(14789, Integer.valueOf(3));
                        } else {
                            g.pWK.h(14789, Integer.valueOf(2));
                        }
                        x.i("WNNoteBanner", "isOpenFromSession: true");
                        d jVar = new j();
                        c.bWA().tWL = jVar;
                        vp vpVar = new vp();
                        vpVar.scene = 8;
                        jVar.a(bXx.tYv, Long.valueOf(bXx.tYs), true, (Context) b.this.vvl.get(), bXx.tYw, bXx.tYx, vpVar);
                    } else {
                        g.pWK.h(14789, Integer.valueOf(1));
                        x.i("WNNoteBanner", "isOpenFromSession: false");
                        d gVar = new com.tencent.mm.plugin.wenote.model.g();
                        c.bWA().tWL = gVar;
                        vp vpVar2 = new vp();
                        vpVar2.scene = 8;
                        gVar.a(bXx.tYr, (Context) b.this.vvl.get(), Boolean.valueOf(true), bXx.tYw, bXx.tYx, vpVar2);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.cZA;
    }

    public final int getOrder() {
        return 0;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cZA).setVisibility(i);
        }
    }

    public final boolean alN() {
        boolean z;
        p bXx = h.bXw().bXx();
        if (bXx != null && bXx.tYq && bXx.tYs > 0 && !bi.oN(bXx.tYv)) {
            z = true;
        } else if (bXx == null || bXx.tYq || f.eb(bXx.tYr) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            CharSequence charSequence = bXx.tYu;
            if (this.ikn != null) {
                this.ikn.setText(charSequence);
            }
            setVisibility(0);
            return true;
        }
        if (bXx != null) {
            h.bXw().a(null);
        }
        setVisibility(8);
        return false;
    }
}
