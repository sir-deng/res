package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b implements h {
    private Intent Ks;
    int jeh = 0;

    protected final boolean c(AppBrandInitConfig appBrandInitConfig) {
        Class cls;
        try {
            cls = Class.forName(bi.oM(this.Ks.getStringExtra("extra_launch_source_context")));
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            return super.c(appBrandInitConfig);
        }
        return false;
    }

    public d(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        setBaseContext(appBrandLaunchProxyUI);
    }

    public final void w(Intent intent) {
        this.Ks = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
        } else {
            a(launchParcel);
        }
    }

    public final void onResume() {
        int i = this.jeh + 1;
        this.jeh = i;
        if (i > 1) {
            aiQ();
        }
    }

    public final void onPause() {
        aiQ();
    }

    protected final String aiN() {
        return this.Ks.getStringExtra("extra_launch_source_context");
    }

    protected final void d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        super.d(appBrandInitConfig, appBrandStatObject);
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", Boolean.valueOf(d.this.isFinishing()), Boolean.valueOf(d.this.aiP()));
                        ResultReceiver resultReceiver = (ResultReceiver) d.this.Ks.getParcelableExtra("extra_result_receiver");
                        if (resultReceiver != null) {
                            resultReceiver.send(-1, Bundle.EMPTY);
                        }
                        d.this.aiQ();
                    }
                }.run();
            }
        };
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            ah.y(anonymousClass1);
        } else {
            this.jEt.offer(anonymousClass1);
        }
    }

    protected final void aiO() {
    }

    private void aiQ() {
        if (!isFinishing() && !aiP()) {
            super.aiO();
        }
    }
}
