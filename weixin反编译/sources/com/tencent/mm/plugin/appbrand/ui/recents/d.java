package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

final class d implements OnClickListener {
    b jVD;
    int jVE = c.jVP;
    final d jVF = new d();
    private final int jVG;
    private final int jVH = 200;
    private final a jVI;

    enum c {
        ;

        static {
            jVP = 1;
            jVQ = 2;
            jVR = 3;
            jVS = 4;
            jVT = new int[]{jVP, jVQ, jVR, jVS};
        }
    }

    private static class d {
        View VU;
        TextView jVU;
        View jVV;
        AppBrandNearbyShowcaseView jVW;
        TextView jVX;
        ImageView jVY;
        ThreeDotsLoadingView jVr;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private class a {
        final int jVK;
        final int jVL;
        final int jVM;
        private final int jVN;
        com.tencent.mm.plugin.appbrand.ui.widget.a jVO;

        /* synthetic */ a(d dVar, Context context, byte b) {
            this(context);
        }

        private a(Context context) {
            this.jVN = -1;
            this.jVK = com.tencent.mm.bu.a.fromDPToPix(context, 25);
            this.jVL = com.tencent.mm.bu.a.fromDPToPix(context, 19);
            this.jVM = com.tencent.mm.bu.a.fromDPToPix(context, 2);
        }
    }

    interface b {
        void b(int i, View view);
    }

    public d(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        this.jVI = new a(this, context, (byte) 0);
        View inflate = LayoutInflater.from(context).inflate(h.izD, viewGroup, false);
        this.jVF.VU = inflate;
        this.jVF.jVU = (TextView) inflate.findViewById(g.title);
        this.jVF.jVV = inflate.findViewById(g.iyt);
        this.jVF.jVX = (TextView) inflate.findViewById(g.iyu);
        this.jVF.jVW = (AppBrandNearbyShowcaseView) inflate.findViewById(g.iyq);
        this.jVF.jVr = (ThreeDotsLoadingView) inflate.findViewById(g.iyr);
        this.jVF.jVY = (ImageView) inflate.findViewById(g.iys);
        this.jVF.VU.setOnClickListener(this);
        this.jVF.jVU.setText(i);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.jVF.jVW;
        if (appBrandNearbyShowcaseView != null) {
            appBrandNearbyShowcaseView.mh(4);
            appBrandNearbyShowcaseView.mf(this.jVI.jVK + (this.jVI.jVM * 2));
            appBrandNearbyShowcaseView.mg(this.jVI.jVL);
        }
        this.jVG = com.tencent.mm.bu.a.c(context, com.tencent.mm.plugin.appbrand.q.d.iuX);
    }

    protected final void amd() {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
        this.jVE = c.jVQ;
        bL(this.jVF.jVV);
        bL(this.jVF.jVY);
        bM(this.jVF.jVr);
        this.jVF.jVr.czW();
    }

    protected final void a(List<String> list, String str, Integer num) {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
        this.jVE = c.jVR;
        this.jVF.jVr.ajR();
        bL(this.jVF.jVr);
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
            return;
        }
        int i;
        if (list != null) {
            this.jVF.jVW.mh(Math.min(list.size(), 4));
            this.jVF.jVW.amL();
            a aVar = this.jVI;
            if (aVar.jVO == null) {
                aVar.jVO = new com.tencent.mm.plugin.appbrand.ui.widget.a(aVar.jVK, aVar.jVM);
            }
            f fVar = aVar.jVO;
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jVF.jVW.getChildCount()) {
                    break;
                }
                com.tencent.mm.modelappbrand.a.b.Jp().a(this.jVF.jVW.mi(i2), (String) list.get(i2), com.tencent.mm.modelappbrand.a.a.Jo(), fVar);
                i = i2 + 1;
            }
        } else {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
        }
        i = num == null ? this.jVG : num.intValue();
        if (this.jVF.jVX != null) {
            this.jVF.jVX.setText(str);
            this.jVF.jVX.setTextColor(i);
        }
        if (this.jVF.jVV != null) {
            bM(this.jVF.jVV);
            if (this.jVF.jVW != null) {
                this.jVF.jVW.amM();
            }
            if (this.jVF.jVX != null) {
                this.jVF.jVX.setAlpha(0.0f);
                this.jVF.jVX.animate().alpha(1.0f).setDuration(500).start();
            }
        }
    }

    public final void onClick(View view) {
        if (this.jVD != null) {
            this.jVD.b(this.jVE, view);
        }
    }

    final void bL(final View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    view.setVisibility(8);
                }
            }).start();
        }
    }

    static void bM(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }
}
