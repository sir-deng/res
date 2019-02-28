package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.c.ei;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;

public class GameIndexWxagView extends LinearLayout implements OnClickListener {
    LayoutInflater DF = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    ViewGroup mContainer = this;
    int niV;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexWxagView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nrE;

        AnonymousClass1(int i) {
            this.nrE = i;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof ei)) {
                ei eiVar = (ei) view.getTag();
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((d) g.h(d.class)).a(GameIndexWxagView.this.getContext(), eiVar.kyG, eiVar.nlV, eiVar.nqf, 0, eiVar.nqe, appBrandStatObject);
                ap.a(GameIndexWxagView.this.getContext(), 10, 1025, 999, 30, eiVar.nlV, this.nrE, null);
            }
        }
    }

    private static class a {
        public int njZ;
        public ei nwV;

        public a(int i, ei eiVar) {
            this.njZ = i;
            this.nwV = eiVar;
        }
    }

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameIndexWxagView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (aVar.nwV != null) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((d) g.h(d.class)).a(getContext(), aVar.nwV.kyG, aVar.nwV.nlV, aVar.nwV.nqf, 0, aVar.nwV.nqe, appBrandStatObject);
                ap.a(getContext(), 10, 1025, aVar.njZ, 30, aVar.nwV.nlV, this.niV, null);
            }
        }
    }
}
