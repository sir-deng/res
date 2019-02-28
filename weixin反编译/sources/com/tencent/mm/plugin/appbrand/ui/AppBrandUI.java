package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a, m {
    private static HashSet<MMActivity> jSx = new HashSet();
    private c itM = new c() {
        public final void finish() {
            AppBrandUI.this.mController.xRr.finish();
        }

        public final void a(AppBrandRemoteTaskController appBrandRemoteTaskController) {
            AppBrandUI.a(AppBrandUI.this, appBrandRemoteTaskController);
        }
    };
    private Boolean jSA;
    private i jSB = null;
    private final com.tencent.mm.plugin.appbrand.widget.input.a jSt = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    private f jSu;
    private i jSv;
    private d jSw;
    private Intent jSy = null;
    public boolean jSz = false;

    private static class ProcessRestartTask extends MainProcessTask {
        public static final Creator<ProcessRestartTask> CREATOR = new Creator<ProcessRestartTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ProcessRestartTask processRestartTask = new ProcessRestartTask();
                processRestartTask.f(parcel);
                return processRestartTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ProcessRestartTask[i];
            }
        };
        public String gQd;
        public String jPp;

        private ProcessRestartTask() {
        }

        /* synthetic */ ProcessRestartTask(byte b) {
            this();
        }

        public final void YA() {
            b.ix(this.gQd);
            com.tencent.mm.plugin.appbrand.task.d.uQ(this.jPp);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gQd);
            parcel.writeString(this.jPp);
        }

        public final void f(Parcel parcel) {
            this.gQd = parcel.readString();
            this.jPp = parcel.readString();
        }
    }

    static /* synthetic */ void a(AppBrandUI appBrandUI, final AppBrandRemoteTaskController appBrandRemoteTaskController) {
        if (appBrandUI.jSB == null || !appBrandUI.jSB.isShowing()) {
            i.a aVar = new a(appBrandUI.mController.xRr);
            aVar.ES(j.dGZ);
            aVar.ET(j.iAJ);
            aVar.mp(false);
            aVar.EV(j.iBf).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    AppBrandUI.this.mController.xRr.finish();
                    MainProcessTask mainProcessTask = appBrandRemoteTaskController;
                    mainProcessTask.jPq = a.jPA;
                    mainProcessTask.jPr = 0;
                    AppBrandMainProcessService.a(mainProcessTask);
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("Intro_Switch", true);
                    com.tencent.mm.bl.d.a(AppBrandUI.this.mController.xRr, ".ui.LauncherUI", intent);
                }
            });
            appBrandUI.jSB = aVar.ale();
            appBrandUI.jSB.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandUI", "onCreate");
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4);
        String str = ad.By() + ":start_time";
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            com.tencent.mm.plugin.report.d.pVE.a(365, 2, 1, false);
        }
        com.tencent.mm.plugin.report.d.pVE.a(365, 4, 1, false);
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
        x.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.boM();
        View frameLayout = new FrameLayout(this.mController.xRr);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(frameLayout);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jSt;
        if (!(aVar.activity == null || aVar.activity.getWindow() == null || frameLayout.getParent() == null || !(frameLayout.getParent() instanceof ViewGroup))) {
            aVar.kcq = true;
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            viewGroup.removeView(frameLayout);
            Context context = aVar.activity;
            aVar.activity.getWindow().getDecorView();
            View lVar = new l(context, frameLayout);
            viewGroup.addView(lVar, new LayoutParams(-1, -1));
            if (VERSION.SDK_INT < 20) {
                af.a.a(aVar.activity, viewGroup);
                aVar.a(lVar);
            }
        }
        this.jSu = new f(this, this.itM, frameLayout);
        this.jSv = new i(this, this.jSu);
        e eVar = this.jSv;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            ad.getContext().registerReceiver(eVar.iKv, intentFilter);
        } catch (Exception e) {
            x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = " + e);
        }
        this.jSw = new d(this) {
            protected final void aaM() {
                com.tencent.mm.plugin.appbrand.e YR = AppBrandUI.this.jSu.YR();
                if (YR != null) {
                    com.tencent.mm.plugin.appbrand.c.a(YR.mAppId, com.tencent.mm.plugin.appbrand.c.c.HOME_PRESSED);
                }
            }
        };
        d dVar = this.jSw;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        try {
            ad.getContext().registerReceiver(dVar.tP, intentFilter);
        } catch (Exception e2) {
            x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = " + e2);
        }
        jSx.add(this);
        com.tencent.mm.plugin.appbrand.config.d ace = e.iQr;
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
        synchronized (ace) {
            ace.mFinished = false;
        }
        com.tencent.mm.plugin.appbrand.r.a.a.jYg.init(this);
        this.jSy = getIntent();
    }

    public void onNewIntent(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
            x.i("MicroMsg.AppBrandUI", "onNewIntent");
            this.jSy = intent;
            this.jSz = true;
        } else if (this.jSu == null || this.jSu.itK.size() == 0) {
            finish();
        }
    }

    protected final void afw() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationChanged(android.content.res.Configuration r11) {
        /*
        r10 = this;
        r6 = 1;
        r7 = 0;
        r0 = "MicroMsg.AppBrandUI";
        r1 = "onConfigurationChanged newConfig: %s";
        r2 = new java.lang.Object[r6];
        r3 = r11.orientation;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        super.onConfigurationChanged(r11);
        r0 = r10.jSt;
        if (r11 == 0) goto L_0x0032;
    L_0x001c:
        r1 = "MicroMsg.AppBrandFixInputIssuesActivityHelper";
        r2 = "onActivityConfigurationChanged, orientation %d";
        r3 = new java.lang.Object[r6];
        r4 = r11.orientation;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r0.anb();
    L_0x0032:
        r0 = r10.jSu;
        r1 = "MicroMsg.AppBrandRuntimeContainer";
        r2 = "AppBrandRuntimeContainer.onConfigurationChanged newConfig [%d]";
        r3 = new java.lang.Object[r6];
        r4 = r11.orientation;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
        r1 = r0.itK;
        if (r1 == 0) goto L_0x005b;
    L_0x004b:
        r0 = r0.itK;
        r0 = r0.iterator();
    L_0x0051:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x005b;
    L_0x0057:
        r0.next();
        goto L_0x0051;
    L_0x005b:
        r8 = com.tencent.mm.plugin.appbrand.config.d.e.iQr;
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "AppBrandDeviceOrientationHandler.onConfigurationChanged";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        if (r10 == 0) goto L_0x006c;
    L_0x006a:
        if (r11 != 0) goto L_0x008f;
    L_0x006c:
        r1 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = new java.lang.RuntimeException;
        r2.<init>();
        r3 = "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]";
        r0 = 2;
        r4 = new java.lang.Object[r0];
        if (r10 != 0) goto L_0x00a4;
    L_0x007c:
        r0 = r6;
    L_0x007d:
        r0 = java.lang.Boolean.valueOf(r0);
        r4[r7] = r0;
        if (r11 != 0) goto L_0x00a6;
    L_0x0085:
        r0 = r6;
    L_0x0086:
        r0 = java.lang.Boolean.valueOf(r0);
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r2, r3, r4);
    L_0x008f:
        r9 = new java.util.LinkedList;
        r9.<init>();
        monitor-enter(r8);
        r0 = r8.mFinished;	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x00a8;
    L_0x0099:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "onConfigurationChanged Finished = true";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x00b7 }
        monitor-exit(r8);	 Catch:{ all -> 0x00b7 }
    L_0x00a3:
        return;
    L_0x00a4:
        r0 = r7;
        goto L_0x007d;
    L_0x00a6:
        r0 = r7;
        goto L_0x0086;
    L_0x00a8:
        r0 = r8.iQi;	 Catch:{ all -> 0x00b7 }
        if (r0 != 0) goto L_0x00ba;
    L_0x00ac:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "No current request..., dismiss";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ all -> 0x00b7 }
        monitor-exit(r8);	 Catch:{ all -> 0x00b7 }
        goto L_0x00a3;
    L_0x00b7:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00b7 }
        throw r0;
    L_0x00ba:
        r2 = com.tencent.mm.plugin.appbrand.config.d.b(r11);	 Catch:{ all -> 0x00b7 }
        r1 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r3 = "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]";
        r0 = 1;
        r4 = new java.lang.Object[r0];	 Catch:{ all -> 0x00b7 }
        r5 = 0;
        if (r2 != 0) goto L_0x0144;
    L_0x00ca:
        r0 = "null";
    L_0x00cd:
        r4[r5] = r0;	 Catch:{ all -> 0x00b7 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);	 Catch:{ all -> 0x00b7 }
        r0 = r8.iQi;	 Catch:{ all -> 0x00b7 }
        r0 = r0.iQo;	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x00ef;
    L_0x00d8:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00b7 }
        r1 = r8.iQi;	 Catch:{ all -> 0x00b7 }
        r1 = r1.iQo;	 Catch:{ all -> 0x00b7 }
        r3 = r8.iQi;	 Catch:{ all -> 0x00b7 }
        r3 = r3.iQp;	 Catch:{ all -> 0x00b7 }
        if (r2 != r3) goto L_0x0149;
    L_0x00e4:
        r3 = r6;
    L_0x00e5:
        r4 = "CurrentRequest.listener result received";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x00b7 }
        r9.add(r0);	 Catch:{ all -> 0x00b7 }
    L_0x00ef:
        r0 = 0;
        r8.iQi = r0;	 Catch:{ all -> 0x00b7 }
        r0 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x0116;
    L_0x00f6:
        r0 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r0 = r0.iQp;	 Catch:{ all -> 0x00b7 }
        if (r2 != r0) goto L_0x014b;
    L_0x00fc:
        r0 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r0 = r0.iQo;	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x0113;
    L_0x0102:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00b7 }
        r1 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r1 = r1.iQo;	 Catch:{ all -> 0x00b7 }
        r3 = 1;
        r4 = "PendingRequest.Listener orientation equal direct";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x00b7 }
        r9.add(r0);	 Catch:{ all -> 0x00b7 }
    L_0x0113:
        r0 = 0;
        r8.iQj = r0;	 Catch:{ all -> 0x00b7 }
    L_0x0116:
        monitor-exit(r8);	 Catch:{ all -> 0x00b7 }
        r1 = r9.iterator();
    L_0x011b:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00a3;
    L_0x0121:
        r0 = r1.next();
        r0 = (com.tencent.mm.plugin.appbrand.config.d.c) r0;
        r2 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r3 = "Notify Listener[%s]";
        r4 = new java.lang.Object[r6];
        r5 = r0.name;
        r4[r7] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = r0.iQo;
        if (r2 != 0) goto L_0x017b;
    L_0x013a:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = "PendingNotify: Listener is null when execute.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x011b;
    L_0x0144:
        r0 = r2.name();	 Catch:{ all -> 0x00b7 }
        goto L_0x00cd;
    L_0x0149:
        r3 = r7;
        goto L_0x00e5;
    L_0x014b:
        if (r10 != 0) goto L_0x016e;
    L_0x014d:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "No Activity when handle pending request";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00b7 }
        r0 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r0 = r0.iQo;	 Catch:{ all -> 0x00b7 }
        if (r0 == 0) goto L_0x0116;
    L_0x015c:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00b7 }
        r1 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r1 = r1.iQo;	 Catch:{ all -> 0x00b7 }
        r3 = 0;
        r4 = "PendingRequest.Listener activity == null";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x00b7 }
        r9.add(r0);	 Catch:{ all -> 0x00b7 }
        goto L_0x0116;
    L_0x016e:
        r0 = r8.iQj;	 Catch:{ all -> 0x00b7 }
        r8.iQi = r0;	 Catch:{ all -> 0x00b7 }
        r0 = 0;
        r8.iQj = r0;	 Catch:{ all -> 0x00b7 }
        r0 = r8.iQi;	 Catch:{ all -> 0x00b7 }
        com.tencent.mm.plugin.appbrand.config.d.a(r10, r0);	 Catch:{ all -> 0x00b7 }
        goto L_0x0116;
    L_0x017b:
        r2 = r0.iQo;
        r3 = r0.iQp;
        r0 = r0.success;
        r2.a(r3, r0);
        goto L_0x011b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onConfigurationChanged(android.content.res.Configuration):void");
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jSt;
        if (layoutParams != null) {
            x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", Integer.valueOf(aVar.kcr), Integer.valueOf(layoutParams.flags));
            if (layoutParams.flags != aVar.kcr) {
                aVar.kcr = layoutParams.flags;
                aVar.anb();
            }
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Object obj = 1;
        Object obj2 = (intent == null || (intent.getFlags() & SQLiteDatabase.CREATE_IF_NECESSARY) <= 0) ? null : 1;
        if (intent == null || !com.tencent.mm.plugin.appbrand.r.c.b(intent.getComponent()).equals(com.tencent.mm.plugin.appbrand.r.c.b(getComponentName()))) {
            obj = null;
        }
        boolean u = AppBrandProcessProxyUI.u(intent);
        boolean v = AppBrandLaunchProxyUI.v(intent);
        if (this.jSu.YR() != null) {
            String str = this.jSu.YR().mAppId;
            if (v) {
                com.tencent.mm.plugin.appbrand.c.a(str, com.tencent.mm.plugin.appbrand.c.c.LAUNCH_MINI_PROGRAM);
            } else if ((obj2 == null || obj != null || u) && com.tencent.mm.plugin.appbrand.c.c.HIDE == com.tencent.mm.plugin.appbrand.c.px(str)) {
                com.tencent.mm.plugin.appbrand.c.a(str, com.tencent.mm.plugin.appbrand.c.c.LAUNCH_NATIVE_PAGE);
            }
        }
        try {
            this.jSu.YR().isX.jIP.jMX = intent;
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.AppBrandUI", "onStart");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        x.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", Boolean.valueOf(z));
        if (!z) {
            this.jSz = false;
        }
    }

    public void onResume() {
        AppBrandInitConfig appBrandInitConfig;
        Exception e;
        Object appBrandInitConfig2;
        com.tencent.mm.plugin.appbrand.e eVar;
        com.tencent.mm.plugin.appbrand.e YR;
        super.onResume();
        x.i("MicroMsg.AppBrandUI", "onResume");
        if (this.jSy != null) {
            setIntent(this.jSy);
            Bundle extras = this.jSy.getExtras();
            if (extras == null) {
                finish();
            } else {
                AppBrandStatObject appBrandStatObject;
                try {
                    extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
                    appBrandInitConfig2 = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
                    try {
                        appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
                    } catch (Exception e2) {
                        Exception exception = e2;
                        Object eVar2 = appBrandInitConfig2;
                        e = exception;
                        x.e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
                        appBrandInitConfig2 = eVar2;
                        appBrandStatObject = null;
                        if (appBrandInitConfig2 == null) {
                        }
                        finish();
                        this.jSy = null;
                        YR = this.jSu.YR();
                        if (YR != null) {
                            YR.onResume();
                        }
                        com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jSu.YR().mAppId, hashCode());
                    }
                } catch (Exception e3) {
                    e = e3;
                    eVar2 = null;
                    x.e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
                    appBrandInitConfig2 = eVar2;
                    appBrandStatObject = null;
                    if (appBrandInitConfig2 == null) {
                    }
                    finish();
                    this.jSy = null;
                    YR = this.jSu.YR();
                    if (YR != null) {
                        YR.onResume();
                    }
                    com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jSu.YR().mAppId, hashCode());
                }
                if (appBrandInitConfig2 == null && appBrandStatObject != null) {
                    if (!bi.oN(appBrandInitConfig2.iRe)) {
                        e.iQr.a((Activity) this, com.tencent.mm.plugin.appbrand.config.d.a(appBrandInitConfig2, null), new com.tencent.mm.plugin.appbrand.config.d.a() {
                            public final void a(com.tencent.mm.plugin.appbrand.config.d.b bVar, boolean z) {
                                x.i("MicroMsg.AppBrandUI", "onOrientationChanged");
                                if (!z) {
                                    String str;
                                    String str2 = "MicroMsg.AppBrandUI";
                                    String str3 = "OnOrientationChanged failure  ret:[%s]";
                                    Object[] objArr = new Object[1];
                                    if (bVar == null) {
                                        str = "null";
                                    } else {
                                        str = bVar.name();
                                    }
                                    objArr[0] = str;
                                    x.e(str2, str3, objArr);
                                }
                            }
                        });
                    }
                    x.i("MicroMsg.AppBrandUI", "load() config %s , stat %s", appBrandInitConfig2, appBrandStatObject);
                    if (appBrandInitConfig2.YI()) {
                        com.tencent.mm.plugin.appbrand.app.b.Zj();
                    }
                    this.jSu.a(null, appBrandInitConfig2, appBrandStatObject);
                    initActivityOpenAnimation(getIntent());
                } else if (this.jSu == null || this.jSu.YR() == null) {
                    finish();
                }
            }
            this.jSy = null;
        }
        YR = this.jSu.YR();
        if (YR != null) {
            YR.onResume();
        }
        try {
            com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jSu.YR().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.AppBrandUI", "onPause");
        com.tencent.mm.plugin.appbrand.e YR = this.jSu.YR();
        if (YR != null) {
            YR.onPause();
        }
        try {
            com.tencent.mm.modelstat.d.b(4, "AppBrandUI_" + this.jSu.YR().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    protected void initActivityOpenAnimation(Intent intent) {
        AppBrandStatObject appBrandStatObject;
        try {
            appBrandStatObject = (AppBrandStatObject) (intent == null ? null : intent.getParcelableExtra("key_appbrand_stat_object"));
        } catch (Exception e) {
            appBrandStatObject = null;
        }
        if (appBrandStatObject != null) {
            f.a(this, appBrandStatObject);
        } else if (!AppBrandLaunchProxyUI.v(intent)) {
            super.initActivityOpenAnimation(intent);
        }
    }

    protected void initActivityCloseAnimation() {
        if (this != null) {
            overridePendingTransition(q.a.iuH, q.a.iuI);
        }
    }

    public void finish() {
        if (!isFinishing() && !this.xQV) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            initActivityCloseAnimation();
            int chq = bi.chq();
            x.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", Integer.valueOf(bi.chq()));
            chq = chq <= 90 ? 2 : chq <= 130 ? 3 : chq <= 170 ? 4 : chq <= com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX ? 5 : 6;
            g.pWK.a(386, 1, 1, false);
            g.pWK.a(386, (long) chq, 1, false);
        }
    }

    public boolean moveTaskToBack(boolean z) {
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            initActivityCloseAnimation();
            return moveTaskToBack;
        } catch (NullPointerException e) {
            jSx.remove(this);
            if (!alj()) {
                finish();
            }
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AppBrandUI", "onDestroy");
        this.jSu.cleanup();
        jSx.remove(this);
        if (this.jSw != null) {
            try {
                ad.getContext().unregisterReceiver(this.jSw.tP);
            } catch (Exception e) {
                x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = " + e);
            }
        }
        if (this.jSv != null) {
            try {
                ad.getContext().unregisterReceiver(this.jSv.iKv);
            } catch (Exception e2) {
                x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = " + e2);
            }
        }
        alj();
        com.tencent.mm.plugin.appbrand.config.d ace = e.iQr;
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
        synchronized (ace) {
            if (ace.iQi == null && ace.iQj == null) {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
            } else {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", ace.iQi, ace.iQj);
                ace.iQi = null;
                ace.iQj = null;
                ace.mFinished = true;
            }
        }
        com.tencent.mm.plugin.appbrand.r.a.a.jYg.release();
    }

    public void onBackPressed() {
        com.tencent.mm.plugin.appbrand.e YR = this.jSu.YR();
        if (YR == null) {
            return;
        }
        if (YR.isZ == null) {
            if (YR.itb != null) {
                Object obj;
                com.tencent.mm.plugin.appbrand.widget.c.e eVar = YR.itb;
                h hVar = (h) eVar.kch.peekLast();
                if (hVar == null) {
                    eVar.setVisibility(8);
                    obj = null;
                } else {
                    hVar.onCancel();
                    eVar.b(hVar);
                    obj = 1;
                }
                if (obj != null) {
                    return;
                }
            }
            if (YR.isX != null) {
                n nVar = YR.isX;
                if (!nVar.ajy().aeO().aeX()) {
                    nVar.ajx();
                    return;
                }
                return;
            }
            return;
        }
        YR.finish();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jSt;
        if (aVar.activity != null && aVar.activity.getWindow() != null) {
            aVar.activity.getWindow().setSoftInputMode(16);
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.plugin.appbrand.e YR = this.jSu.YR();
        if (YR != null) {
            com.tencent.mm.plugin.appbrand.a.a(YR.mAppId, i, strArr, iArr);
        }
    }

    public final boolean aly() {
        boolean z = true;
        if (this.jSA != null) {
            return this.jSA.booleanValue();
        }
        ActivityInfo activityInfo;
        try {
            activityInfo = ad.getContext().getPackageManager().getActivityInfo(getComponentName(), FileUtils.S_IWUSR);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", e);
            activityInfo = null;
        }
        if (activityInfo == null) {
            return true;
        }
        if (ad.getPackageName().equals(activityInfo.taskAffinity)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.jSA = valueOf;
        return valueOf.booleanValue();
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        if (aly()) {
            super.setTaskDescription(taskDescription);
        }
    }

    protected boolean alj() {
        final Runnable anonymousClass5 = new Runnable() {
            public final void run() {
                try {
                    KVCommCrossProcessReceiver.boQ();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandUI", e, "sendKV", new Object[0]);
                }
            }
        };
        if (!jSx.isEmpty()) {
            x.i("MicroMsg.AppBrandUI", "Activity running");
            com.tencent.mm.by.a.post(anonymousClass5);
            return false;
        } else if (DebuggerShell.acx()) {
            return false;
        } else {
            com.tencent.mm.by.a.post(new Runnable() {
                public final void run() {
                    anonymousClass5.run();
                    x.i("MicroMsg.AppBrandUI", "tryRestartProcess, %s", u.GQ().toString());
                    x.cfY();
                    if (((Boolean) new bd<Boolean>() {
                        protected final /* synthetic */ Object run() {
                            return Boolean.valueOf(AppBrandUI.jSx.isEmpty());
                        }
                    }.b(new ag(Looper.getMainLooper()))).booleanValue()) {
                        MainProcessTask processRestartTask = new ProcessRestartTask();
                        processRestartTask.gQd = ad.By();
                        processRestartTask.jPp = AppBrandUI.this.getClass().getName();
                        AppBrandMainProcessService.b(processRestartTask);
                        System.exit(0);
                    }
                }
            });
            return true;
        }
    }
}
