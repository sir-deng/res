package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.n;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.plugin.appbrand.q.b.a;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference extends Preference {
    private ThreeDotsLoadingView jPb;
    private int jVK;
    private int jVL;
    private int jVM;
    private final int jVN = -1;
    private f jWa;
    private AppBrandNearbyShowcaseView jXf;
    private View jXg;
    public String jXh;
    private boolean jXi = false;
    private int jXj = -1;
    private LinkedList<d> jXk = new LinkedList();
    private Context mContext;
    private View mView = null;

    static /* synthetic */ void a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        b.reset();
        b.a(appBrandLoadIconPreference.jXh, new a() {
            public final void u(LinkedList<d> linkedList) {
                AppBrandLoadIconPreference.this.jXk = linkedList;
                AppBrandLoadIconPreference.b(AppBrandLoadIconPreference.this);
            }
        });
    }

    static /* synthetic */ void b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        int i = 0;
        appBrandLoadIconPreference.jPb.ajR();
        appBrandLoadIconPreference.bL(appBrandLoadIconPreference.jPb);
        if (appBrandLoadIconPreference.jXk.size() > 0) {
            appBrandLoadIconPreference.jXf.setVisibility(0);
            appBrandLoadIconPreference.jXf.mh(Math.min(appBrandLoadIconPreference.jXk.size(), 3));
            final boolean z = appBrandLoadIconPreference.jXg.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.jXf.amL();
            }
            if (appBrandLoadIconPreference.jWa == null) {
                appBrandLoadIconPreference.jWa = new a(appBrandLoadIconPreference.jVK, appBrandLoadIconPreference.jVM);
            }
            while (true) {
                int i2 = i;
                if (i2 < appBrandLoadIconPreference.jXf.getChildCount()) {
                    com.tencent.mm.modelappbrand.a.b.Jp().a(appBrandLoadIconPreference.jXf.mi(i2), appBrandLoadIconPreference.jXk.size() > i2 ? ((d) appBrandLoadIconPreference.jXk.get(i2)).imagePath : null, com.tencent.mm.modelappbrand.a.a.Jo(), appBrandLoadIconPreference.jWa);
                    i = i2 + 1;
                } else {
                    b(appBrandLoadIconPreference.jXg, new Runnable() {
                        public final void run() {
                            if (z && AppBrandLoadIconPreference.this.jXf != null) {
                                AppBrandLoadIconPreference.this.jXf.amM();
                            }
                        }
                    });
                    return;
                }
            }
        }
        appBrandLoadIconPreference.jXf.setVisibility(8);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ci(context);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ci(context);
    }

    private void ci(Context context) {
        setLayoutResource(n.b.iPD);
        this.mContext = context;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jVK = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 21);
        this.jVL = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 11);
        this.jVM = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 2);
        this.jXg = view.findViewById(n.a.iPB);
        this.jPb = (ThreeDotsLoadingView) view.findViewById(n.a.iwQ);
        this.jXf = (AppBrandNearbyShowcaseView) view.findViewById(n.a.iPC);
        this.jXf.mf(this.jVK + (this.jVM * 2));
        this.jXf.mg(this.jVL);
        if (this.jXh == null || this.jPb == null) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
        } else if (this.jXi) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
        } else {
            this.jXi = true;
            bL(this.jXg);
            b(this.jPb, null);
            this.jPb.czW();
            g.Dt().F(new Runnable() {
                public final void run() {
                    AppBrandLoadIconPreference.a(AppBrandLoadIconPreference.this);
                }
            });
        }
    }

    public static void onDestroy() {
        b.reset();
    }

    private static void b(View view, Runnable runnable) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
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
}
