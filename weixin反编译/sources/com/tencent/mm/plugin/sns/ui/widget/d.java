package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static d rXQ = new d();
    public int rXM = 0;
    private a rXR = null;
    private a rXS = null;

    public static d bDp() {
        return rXQ;
    }

    public final a bDo() {
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), (int) (15.0f * com.tencent.mm.bu.a.ev(ad.getContext())));
        if (this.rXR == null || ((int) this.rXR.gVS) != fromDPToPix) {
            this.rXR = b.Er().gG(19).gH(ad.getContext().getResources().getColor(c.btv)).P((float) fromDPToPix).gVC;
        }
        return this.rXR;
    }

    public final a bDq() {
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), (int) (15.0f * com.tencent.mm.bu.a.ev(ad.getContext())));
        if (this.rXS == null || ((int) this.rXS.gVS) != fromDPToPix) {
            b P = b.Er().gG(19).gH(ad.getContext().getResources().getColor(c.btv)).P((float) fromDPToPix);
            P.gVC.maxLines = 6;
            this.rXS = P.gVC;
        }
        return this.rXS;
    }

    public final int bDr() {
        if (this.rXM <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK) + ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK));
            int dimension2 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qEP);
            int dimension3 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK);
            this.rXM = (i - dimension2) - dimension;
            x.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rXM + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.rXM;
    }

    public static float getTextSize() {
        return (float) com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), (int) (15.0f * com.tencent.mm.bu.a.ev(ad.getContext())));
    }
}
