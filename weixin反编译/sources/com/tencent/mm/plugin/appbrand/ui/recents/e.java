package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.i.b;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class e extends h implements OnClickListener, b {
    View VU;
    private Activity fBA;
    private final int jVK;
    private final int jVL;
    private final int jVM;
    private final int jVN = -1;
    private View jVV;
    private int jVZ = a.jWk;
    private ThreeDotsLoadingView jVr;
    private f jWa;
    private final int jWb;
    private TextView jWc;
    private AppBrandNearbyShowcaseView jWd;
    private View jWe;
    private ImageView jWf;
    private boolean jWg = false;

    private enum a {
        ;

        static {
            jWi = 1;
            jWj = 2;
            jWk = 3;
            jWl = 4;
            jWm = 5;
            jWn = new int[]{jWi, jWj, jWk, jWl, jWm};
        }
    }

    e(Activity activity, ViewGroup viewGroup) {
        this.fBA = activity;
        this.jVK = com.tencent.mm.bu.a.fromDPToPix(activity, 25);
        this.jVL = com.tencent.mm.bu.a.fromDPToPix(activity, 19);
        this.jVM = com.tencent.mm.bu.a.fromDPToPix(activity, 2);
        this.VU = LayoutInflater.from(activity).inflate(h.izD, viewGroup, false);
        View findViewById = this.VU.findViewById(g.ixX);
        this.jWe = findViewById;
        findViewById.setOnClickListener(this);
        this.jVV = this.VU.findViewById(g.iyt);
        this.jWc = (TextView) this.VU.findViewById(g.iyu);
        this.jWd = (AppBrandNearbyShowcaseView) this.VU.findViewById(g.iyq);
        this.jWd.mh(4);
        this.jWd.mf(this.jVK + (this.jVM * 2));
        this.jWd.mg(this.jVL);
        this.jVr = (ThreeDotsLoadingView) this.VU.findViewById(g.iyr);
        this.jWf = (ImageView) this.VU.findViewById(g.iys);
        this.jWb = com.tencent.mm.bu.a.c(activity, d.iuX);
        if (!com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.jVZ = a.jWm;
        }
    }

    final View amc() {
        return this.VU;
    }

    final void onResume() {
        if (a.jWm == this.jVZ && com.tencent.mm.pluginsdk.g.a.aZ(this.fBA, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.jVZ = a.jWk;
            amb();
        }
    }

    final void amb() {
        dn(i.abc());
        if (a.jWm == this.jVZ) {
            ame();
            return;
        }
        i.a((b) this);
        if (!i.abh()) {
            this.VU.post(new Runnable() {
                public final void run() {
                    e.this.ame();
                }
            });
        } else if (i.refresh()) {
            amd();
        } else {
            dn(false);
        }
    }

    final void onDetached() {
        i.b(this);
        this.fBA = null;
        this.VU = null;
        this.jWd = null;
        this.jVV = null;
    }

    private void amd() {
        this.jVZ = a.jWl;
        bL(this.jVV);
        bL(this.jWf);
        bM(this.jVr);
        this.jVr.czW();
    }

    private void ame() {
        boolean z = true;
        int i = 0;
        if (this.VU != null) {
            j.d dVar;
            if (i.abc()) {
                dn(true);
                dVar = ((AppBrandLauncherUI) this.fBA).jQB;
                if (dVar != null) {
                    dVar.iMM[5] = "1";
                }
            } else {
                dn(false);
            }
            this.jVr.ajR();
            bL(this.jVr);
            if (a.jWm == this.jVZ) {
                bL(this.jVV);
                bL(this.jWf);
                return;
            }
            ajc abg = i.abg();
            if (abg == null) {
                this.jVZ = a.jWi;
                bL(this.jVV);
                bM(this.jWf);
            } else if (abg.kqh <= 0 || bi.cC(abg.wxe)) {
                this.jVZ = a.jWk;
                bL(this.jVV);
            } else {
                this.jVZ = a.jWj;
                dVar = ((AppBrandLauncherUI) this.fBA).jQB;
                if (dVar != null) {
                    dVar.iMM[3] = "1";
                }
                if (this.jWc != null) {
                    this.jWc.setText(abg.wxk);
                    this.jWc.setTextColor(aM(abg.wxl, this.jWb));
                }
                this.jWd.mh(Math.min(abg.wxe.size(), 4));
                if (this.jVV.getVisibility() == 0) {
                    z = false;
                }
                if (z) {
                    this.jWd.amL();
                }
                if (this.jWa == null) {
                    this.jWa = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.jVK, this.jVM);
                }
                while (i < this.jWd.getChildCount()) {
                    com.tencent.mm.modelappbrand.a.b.Jp().a(this.jWd.mi(i), ((atj) abg.wxe.get(i)).wHQ, com.tencent.mm.modelappbrand.a.a.Jo(), this.jWa);
                    i++;
                }
                bM(this.jVV);
                if (z) {
                    if (this.jWd != null) {
                        this.jWd.amM();
                    }
                    if (this.jWc != null) {
                        this.jWc.setAlpha(0.0f);
                        this.jWc.animate().alpha(1.0f).setDuration(500).start();
                    }
                }
            }
        }
    }

    private static int aM(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            return i;
        }
    }

    private void bL(final View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    view.setVisibility(8);
                }
            }).start();
        }
    }

    private static void bM(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }

    public final void abj() {
        if (this.VU != null) {
            this.VU.post(new Runnable() {
                public final void run() {
                    e.this.ame();
                    if (e.this.jWg) {
                        e.this.jWe.performClick();
                        e.this.jWg = false;
                    }
                }
            });
        }
    }

    public final void onClick(View view) {
        int i = 0;
        if (view.getId() == g.ixX && this.fBA != null && a.jWl != this.jVZ) {
            if (a.jWk == this.jVZ) {
                amf();
                this.fBA.startActivityForResult(new Intent(this.fBA, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
            } else if (a.jWm == this.jVZ) {
                amf();
                this.fBA.startActivityForResult(new Intent(this.fBA, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
            } else {
                boolean z = i.abg() != null && i.abh();
                this.jWg = z;
                if (a.jWi == this.jVZ || this.jWg) {
                    i = 1;
                }
                Runnable anonymousClass4 = new Runnable() {
                    public final void run() {
                        int i = 0;
                        if (e.this.fBA != null) {
                            ajc abg = i.abg();
                            if (abg != null) {
                                int i2 = abg.wxn == 1 ? 1 : 0;
                                if (i2 != 0) {
                                    atj atj = abg.wxo;
                                    if (atj == null) {
                                        x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
                                        return;
                                    }
                                    if (com.tencent.mm.sdk.a.b.cfx()) {
                                        i = atj.type;
                                    }
                                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                    appBrandStatObject.scene = 1001;
                                    com.tencent.mm.plugin.appbrand.launching.precondition.g.jEI.a(e.this.fBA, atj.username, null, atj.path, i, atj.vVm, appBrandStatObject, null, null);
                                } else if (bi.oN(abg.wxc)) {
                                    x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
                                    return;
                                } else {
                                    ((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).J(e.this.fBA, abg.wxc);
                                }
                                e.this.amf();
                                com.tencent.mm.plugin.appbrand.report.a.h hVar = new com.tencent.mm.plugin.appbrand.report.a.h();
                                hVar.jNW = com.tencent.mm.plugin.appbrand.report.a.h.b.TOP_ENTRANCE_IN_DESKTOP;
                                hVar.jNX = abg.kqh;
                                hVar.jNY = abg.wxa;
                                hVar.jOa = i2 != 0 ? com.tencent.mm.plugin.appbrand.report.a.h.a.NEARBY_MINI_PROGRAM : com.tencent.mm.plugin.appbrand.report.a.h.a.NEARBY_H5;
                                hVar.xd();
                            }
                        }
                    }
                };
                if (i != 0) {
                    amd();
                    i.refresh();
                    return;
                }
                anonymousClass4.run();
                if (i.abg() != null && i.abg().wxm == 1 && this.jWc != null) {
                    this.jWc.animate().alpha(0.0f).setDuration(200);
                }
            }
        }
    }

    private void amf() {
        if (this.fBA != null) {
            j.d dVar = ((AppBrandLauncherUI) this.fBA).jQB;
            if (dVar != null) {
                dVar.iMM[8] = "1";
            }
        }
    }
}
