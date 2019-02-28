package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;

abstract class b extends MutableContextWrapper {
    final Queue<Runnable> jEt = new LinkedList();
    private ah jEu;

    protected abstract String aiN();

    static /* synthetic */ void a(b bVar, AppBrandInitConfig appBrandInitConfig) {
        String aiN = bVar.aiN();
        if (!bi.oN(aiN)) {
            boolean z = aiN.contains("WebView") || k.tI(aiN).contains(":tools");
            appBrandInitConfig.iRd = z;
        }
    }

    public b() {
        super(ad.getContext());
    }

    public final void setBaseContext(Context context) {
        super.setBaseContext(context);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            while (!this.jEt.isEmpty()) {
                ((Runnable) this.jEt.poll()).run();
            }
        }
    }

    private void q(Runnable runnable) {
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            runnable.run();
        } else {
            this.jEt.offer(runnable);
        }
    }

    protected void aiO() {
        q(new Runnable() {
            public final void run() {
                ((AppBrandLaunchProxyUI) b.this.getBaseContext()).finish();
            }
        });
    }

    protected final void finish() {
        d(null, null);
    }

    protected void d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null) {
            k.a(getBaseContext(), appBrandInitConfig, appBrandStatObject);
        }
        aiO();
        if (this.jEu != null) {
            this.jEu.F(new Runnable() {
                public final void run() {
                    Looper.myLooper().quit();
                }
            });
        }
    }

    protected final boolean isFinishing() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isFinishing();
    }

    protected final boolean aiP() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isDestroyed();
    }

    protected boolean c(AppBrandInitConfig appBrandInitConfig) {
        boolean z;
        if (appBrandInitConfig.iRd || d.uT(appBrandInitConfig.appId) || appBrandInitConfig.YI()) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    protected final void a(final LaunchParcel launchParcel) {
        ah ahVar = new ah("AppBrandLaunchProxyUI-PrepareThread");
        this.jEu = ahVar;
        ahVar.F(new Runnable() {
            public final void run() {
                c.amo();
                new com.tencent.mm.plugin.appbrand.launching.c(launchParcel, new a() {
                    public final void c(final AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
                        if (!b.this.isFinishing()) {
                            if (appBrandInitConfig == null) {
                                b.this.finish();
                                return;
                            }
                            launchParcel.b(appBrandInitConfig);
                            b.a(b.this, appBrandInitConfig);
                            Runnable anonymousClass1 = new Runnable() {
                                public final void run() {
                                    b.this.d(appBrandInitConfig, launchParcel.jEr);
                                }
                            };
                            if (b.this.c(appBrandInitConfig)) {
                                b.this.q(new Runnable(anonymousClass1) {
                                    public final void run() {
                                        w anonymousClass1 = new w() {
                                            public final void aiE() {
                                                b.this.finish();
                                            }

                                            public final void onReady() {
                                                r2.run();
                                            }
                                        };
                                        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) b.this.getBaseContext();
                                        long Wy = bi.Wy();
                                        x.d("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, cost = %d, cheTBSRet = %d", Long.valueOf(bi.Wy() - Wy), Integer.valueOf(com.tencent.mm.pluginsdk.model.x.a.bZk()));
                                        switch (com.tencent.mm.pluginsdk.model.x.a.bZk()) {
                                            case 0:
                                                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), onReady");
                                                anonymousClass1.onReady();
                                                return;
                                            case 1:
                                                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), goProxyUI");
                                                if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.ais()) {
                                                    anonymousClass1.aiF();
                                                    return;
                                                } else {
                                                    appBrandLaunchProxyUI.a(anonymousClass1, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandTBSDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), anonymousClass1.fzQ);
                                                    return;
                                                }
                                            case 2:
                                                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), dealCannotDownload");
                                                anonymousClass1.aiF();
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                });
                            } else {
                                anonymousClass1.run();
                            }
                        }
                    }
                }).run();
            }
        });
    }
}
