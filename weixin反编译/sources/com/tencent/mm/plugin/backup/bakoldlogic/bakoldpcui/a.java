package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jg;
import com.tencent.mm.f.a.lm;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private ag handler = new ag(Looper.getMainLooper());
    private View kvL = null;
    private int kwO = -1;
    private int kxs = 0;
    private c kxt;

    static /* synthetic */ boolean a(a aVar) {
        aVar.kxs = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().ard();
        x.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO), Integer.valueOf(aVar.kxs));
        return aVar.dR(false);
    }

    static /* synthetic */ void d(a aVar) {
        Intent intent = new Intent((Context) aVar.vvl.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.A((Context) aVar.vvl.get(), intent);
    }

    static /* synthetic */ void e(a aVar) {
        Intent intent = new Intent((Context) aVar.vvl.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.A((Context) aVar.vvl.get(), intent);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.kvL = this.view.findViewById(R.h.bMC);
            this.kvL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.kwO = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO;
                    if (2 == a.this.kwO || 3 == a.this.kwO || 5 == a.this.kwO || 6 == a.this.kwO) {
                        x.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO), Integer.valueOf(a.this.kxs));
                        a.d(a.this);
                    } else if (4 == a.this.kwO) {
                        x.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO), Integer.valueOf(a.this.kxs));
                        a.e(a.this);
                    }
                }
            });
        }
        alN();
        this.kxt = new c<lm>() {
            {
                this.xmG = lm.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                a.this.getView().post(new Runnable() {
                    public final void run() {
                        if (a.a(a.this)) {
                            com.tencent.mm.sdk.b.a.xmy.m(new jg());
                        }
                    }
                });
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xmy.b(this.kxt);
    }

    public final int getLayoutId() {
        return R.i.bMC;
    }

    private boolean dR(boolean z) {
        this.kwO = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO;
        x.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", Integer.valueOf(this.kwO), Boolean.valueOf(z));
        if (this.kwO < 2 || this.kwO > 6) {
            this.kvL.setVisibility(8);
            return false;
        }
        this.kvL.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().ara()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().a((d) this);
        }
        if (2 == this.kwO) {
            ((ImageView) this.view.findViewById(R.h.bMD)).setImageResource(R.k.dxI);
            ((TextView) this.view.findViewById(R.h.bME)).setText(ad.getContext().getString(R.l.dKe, new Object[]{Integer.valueOf(this.kxs)}));
        } else if (3 == this.kwO) {
            ((ImageView) this.view.findViewById(R.h.bMD)).setImageResource(R.k.dxI);
            ((TextView) this.view.findViewById(R.h.bME)).setText(ad.getContext().getString(R.l.dKh, new Object[]{Integer.valueOf(this.kxs)}));
        } else if (4 == this.kwO) {
            ((TextView) this.view.findViewById(R.h.bME)).setText(ad.getContext().getString(R.l.dKg));
            ((ImageView) this.view.findViewById(R.h.bMD)).setImageResource(R.k.dxH);
        } else if (5 == this.kwO) {
            ((ImageView) this.view.findViewById(R.h.bMD)).setImageResource(R.k.dxI);
            ((TextView) this.view.findViewById(R.h.bME)).setText(ad.getContext().getString(R.l.dKd, new Object[]{Integer.valueOf(this.kxs)}));
        } else if (6 == this.kwO) {
            ((TextView) this.view.findViewById(R.h.bME)).setText(ad.getContext().getString(R.l.dKf));
            ((ImageView) this.view.findViewById(R.h.bMD)).setImageResource(R.k.dxH);
        }
        return true;
    }

    public final boolean alN() {
        this.kxs = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().ard();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().a((d) this);
        return dR(true);
    }

    public final void release() {
        this.kwO = -1;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().arb();
    }

    public final void onError(int i) {
    }

    public final void no(int i) {
        x.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO), Integer.valueOf(i));
        this.kxs = i;
        this.handler.post(new Runnable() {
            public final void run() {
                a.this.alN();
            }
        });
    }

    public final void np(int i) {
        x.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO), Integer.valueOf(i));
    }

    public final void arg() {
        x.d(TAG, "onNetFinish PCBannerStatus:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT().kwO));
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS().aqT();
        e.nk(17);
        this.handler.post(new Runnable() {
            public final void run() {
                a.this.alN();
            }
        });
    }

    public final void aoR() {
    }

    public final void arh() {
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.kxt);
    }

    public final int getOrder() {
        return 3;
    }
}
