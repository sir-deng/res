package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI extends MMActivity implements f {

    public static final class a implements ActivityLifecycleCallbacks, f {
        public boolean jQs = false;
        public String jQt;

        public static Application ali() {
            return (Application) ad.getContext().getApplicationContext();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppBrandGuideUI) {
                this.jQs = false;
            }
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
                this.jQs = false;
            }
            if (g.Do().CF() && this.jQs) {
                RunningTaskInfo ah = bi.ah(activity, activity.getTaskId());
                boolean z = (ah == null || ah.baseActivity == null) ? false : ah.baseActivity.getClassName().endsWith(".LauncherUI") || !ah.baseActivity.getClassName().contains(".AppBrandUI");
                if (z) {
                    this.jQs = false;
                    activity.startActivity(new Intent(activity, AppBrandGuideUI.class));
                }
            }
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void al(String str, int i) {
            this.jQs = false;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        setTheme(k.iEw);
        super.onCreate(bundle);
        ae.a(getWindow());
        a Zq = e.Zq();
        if (Zq == null) {
            super.finish();
            return;
        }
        b.d(this);
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        aVar.ES(j.dEe);
        View imageView = new ImageView(this);
        imageView.setImageResource(q.f.ivy);
        View textView = new TextView(this);
        textView.setText(j.iBS);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.bu.a.fromDPToPix(this, 16);
        aVar.dk(linearLayout);
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppBrandGuideUI.this.finish();
            }
        });
        aVar.EW(j.bWm);
        aVar.b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                m.a(com.tencent.mm.plugin.appbrand.report.a.m.a.GUIDE_CLOSE, "");
                AppBrandGuideUI.this.finish();
            }
        });
        aVar.EV(j.iBR);
        aVar.a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppBrandGuideUI.this.startActivity(new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
                m.a(com.tencent.mm.plugin.appbrand.report.a.m.a.TO_APP_LAUNCHER, "");
                AppBrandGuideUI.this.finish();
            }
        });
        aVar.mp(false);
        aVar.mq(true);
        Dialog ale = aVar.ale();
        ale.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (4 != i) {
                    return false;
                }
                if (1 != keyEvent.getAction()) {
                    return true;
                }
                m.a(com.tencent.mm.plugin.appbrand.report.a.m.a.GUIDE_CLOSE_BY_BACK, "");
                AppBrandGuideUI.this.finish();
                return true;
            }
        });
        ale.show();
        m.a(com.tencent.mm.plugin.appbrand.report.a.m.a.GUIDE_EXPOSE, Zq.jQt);
        Zq.jQs = false;
        Zq.jQt = null;
    }

    protected final void onDestroy() {
        super.onDestroy();
        b.c(this);
    }

    public final void al(String str, int i) {
        finish();
    }
}
