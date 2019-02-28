package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.a.a;
import com.tencent.mm.plugin.webview.fts.topstory.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    static d tuI;
    boolean nhE;
    b tuJ;
    boolean tuK;
    f tuL;
    ViewGroup tuM;

    public static d bQo() {
        if (tuI == null) {
            tuI = new d();
        }
        return tuI;
    }

    public final void a(f fVar, boolean z) {
        if (this.nhE) {
            bQq();
            return;
        }
        this.nhE = true;
        this.tuK = z;
        this.tuL = fVar;
        this.tuL.tvz.bQV();
        this.tuM.removeAllViews();
        if (this.tuL.getParent() != null) {
            ((ViewGroup) this.tuL.getParent()).removeView(this.tuL);
        }
        this.tuM.addView(this.tuL, new LayoutParams(-1, -1));
        this.tuL.setX(0.0f);
        this.tuL.setY(0.0f);
        bQp();
        if (b.tuf || !b.tug || this.tuL.position + 1 < b.ttW.size()) {
            this.tuL.twe = true;
        } else {
            this.tuL.twe = false;
        }
        a.qq(6);
        if (com.tencent.mm.plugin.webview.fts.topstory.a.d.tun != null) {
            com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.sky = 1;
        }
    }

    public final void bQp() {
        if (this.tuM != null) {
            if (com.tencent.mm.compatible.util.d.fO(19)) {
                this.tuM.setSystemUiVisibility(2);
            } else {
                this.tuM.setSystemUiVisibility(4098);
            }
        }
        this.tuJ.bQk().getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (this.tuK) {
            this.tuJ.bQk().setRequestedOrientation(0);
        } else {
            this.tuJ.bQk().setRequestedOrientation(8);
        }
        if (this.tuJ.bQk().getSupportActionBar() != null) {
            this.tuJ.bQk().getSupportActionBar().hide();
        }
    }

    public final void bQq() {
        this.tuL.bQJ();
        this.tuL.tvz.agI();
        this.tuM.setSystemUiVisibility(0);
        this.tuM.removeView(this.tuL);
        this.tuJ.bQk().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (this.tuJ.bQk().getRequestedOrientation() == 0 || this.tuJ.bQk().getRequestedOrientation() == 6 || this.tuJ.bQk().getRequestedOrientation() == 8) {
            this.tuJ.bQk().setRequestedOrientation(1);
            if (this.tuJ.bQk().getSupportActionBar() != null) {
                this.tuJ.bQk().getSupportActionBar().hide();
            }
        }
        x.i("MicroMsg.WebSearch.TopStoryVideoFullScreenMgr", "exitFullScreen %d", Integer.valueOf(this.tuL.position + this.tuJ.getListView().getHeaderViewsCount()));
        this.tuJ.getListView().smoothScrollToPositionFromTop(r0, this.tuJ.bQk().getResources().getDimensionPixelSize(R.f.bxp));
        ah.h(new Runnable() {
            public final void run() {
                TopStoryVideoItemView a = com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.a(d.this.tuJ);
                if (a != null) {
                    ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).yG(a.hashCode());
                    View view = d.this.tuL;
                    a.tuQ = view.skA;
                    String str = "MicroMsg.WebSearch.TopStoryVideoItemView";
                    String str2 = "setVideoInfoFromResumeFullScreenView, videoInfo: %s, videoViewPosition: %s, position: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = a.tuQ != null ? a.tuQ.title : "";
                    objArr[1] = Integer.valueOf(view.position);
                    objArr[2] = Integer.valueOf(a.position);
                    x.i(str, str2, objArr);
                    if (a.tuQ != null) {
                        if (bi.oN(a.tuQ.title)) {
                            a.tuP.ikn.setVisibility(8);
                        } else {
                            a.tuP.ikn.setText(a.tuQ.title);
                            a.tuP.ikn.setVisibility(0);
                        }
                        a.tuP.qdW.setText(a.tuQ.bhd);
                        if (bi.oN(a.tuQ.skG)) {
                            a.tuP.twH.setVisibility(8);
                        } else {
                            a.tuP.twH.setText(a.tuQ.skG);
                            a.tuP.twH.setVisibility(0);
                        }
                        if (bi.oN(a.tuQ.skL)) {
                            a.tuP.twI.setVisibility(8);
                        } else {
                            a.tuP.twI.setText(a.tuQ.skL);
                            a.tuP.twI.setVisibility(0);
                        }
                        a.tuP.twE.removeAllViews();
                        if (view.getParent() != null) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        a.tuP.twE.addView(view, a.c(a.tuQ));
                        a.tuP.twD = view;
                        view.tvv = a;
                        if (g.bQQ().twx) {
                            view.bQB();
                        } else {
                            view.bQC();
                        }
                        a.bQr();
                        a.bQm();
                        a.bQl();
                        a.position = view.position;
                        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).yG(a.hashCode());
                    }
                    g bQQ = g.bQQ();
                    if (bQQ.twv != null) {
                        bQQ.twv.bZ(true);
                    }
                }
            }
        }, 300);
        this.nhE = false;
    }
}
