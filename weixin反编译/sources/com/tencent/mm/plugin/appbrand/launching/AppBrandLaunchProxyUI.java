package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.launching.precondition.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;

@a(7)
public final class AppBrandLaunchProxyUI extends MMBaseActivity implements l {
    private r jCh;
    private h jCi;
    private MMActivity.a jCj = null;

    public static boolean v(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null || !intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, LaunchParamsOptional launchParamsOptional) {
        a(context, str, null, str2, i, i2, appBrandStatObject, null, launchParamsOptional);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        if (bi.oN(str) && bi.oN(str2)) {
            return false;
        }
        return g.jEI.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        h fVar;
        j.a(getWindow());
        j.a(getWindow(), true);
        if (getIntent().getBooleanExtra("extra_from_mm", true)) {
            fVar = new f(this);
        } else {
            fVar = new d(this);
        }
        this.jCi = fVar;
        if (this.jCi != null) {
            x.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", this.jCi.getClass().getSimpleName());
            this.jCi.w(getIntent());
            if (!isFinishing()) {
                getString(q.j.dGZ);
                this.jCh = com.tencent.mm.ui.base.h.a((Context) this, getString(q.j.ctG), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppBrandLaunchProxyUI.this.finish();
                    }
                });
                if (this.jCh != null && this.jCh.getWindow() != null) {
                    LayoutParams attributes = this.jCh.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.jCh.getWindow().setAttributes(attributes);
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    protected final void onResume() {
        super.onResume();
        if (this.jCi != null) {
            this.jCi.onResume();
        } else {
            super.finish();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.jCi != null) {
            this.jCi.onPause();
        } else {
            super.finish();
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.jCh != null) {
            this.jCh.dismiss();
            this.jCh = null;
        }
    }

    public final void a(MMActivity.a aVar, Intent intent, int i) {
        this.jCj = aVar;
        startActivityForResult(intent, i);
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jCj != null) {
            this.jCj.b(i, i2, intent);
        }
        this.jCj = null;
    }

    public final boolean ais() {
        return !isFinishing();
    }
}
