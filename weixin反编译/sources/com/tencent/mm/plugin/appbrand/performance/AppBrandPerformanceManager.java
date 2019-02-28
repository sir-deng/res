package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import android.view.Choreographer.FrameCallback;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.c.h;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;

@SuppressLint({"DefaultLocale"})
public final class AppBrandPerformanceManager {
    private static SparseArray<a> jLq = new SparseArray();

    private static class a implements Runnable {
        volatile boolean AW = true;
        volatile boolean itm = false;
        private volatile double jLs = 0.0d;
        private volatile int jLt = 4;
        volatile boolean jLu = false;
        d jLv;
        com.tencent.mm.plugin.appbrand.performance.d.a jLw = new com.tencent.mm.plugin.appbrand.performance.d.a() {
            public final void j(double d) {
                if (Math.round(a.this.jLs) != Math.round(d)) {
                    a.this.jLs = d;
                    AppBrandPerformanceManager.o(a.this.mAppId, 303, Math.round(a.this.jLs) + " fps");
                    a.a(a.this.mAppId, "Hardware", "FPS", a.this.jLs);
                }
            }
        };
        b jLx = new b() {
            public final void onDestroy() {
                super.onDestroy();
                a aVar = a.this;
                aVar.AW = false;
                c.b(aVar.mAppId, aVar.jLx);
                if (a.ajX() && aVar.jLv != null) {
                    FrameCallback frameCallback = aVar.jLv;
                    frameCallback.AW = false;
                    frameCallback.jLM = 0;
                    frameCallback.jLN = 0;
                    frameCallback.jLL.removeFrameCallback(frameCallback);
                }
            }

            public final void a(c.c cVar) {
                super.a(cVar);
                a aVar = a.this;
                aVar.itm = true;
                if (a.ajX() && aVar.jLv != null) {
                    aVar.jLv.itm = true;
                }
            }

            public final void onResume() {
                super.onResume();
                a aVar = a.this;
                aVar.itm = false;
                if (a.ajX() && aVar.jLv != null) {
                    aVar.jLv.itm = false;
                }
            }
        };
        private c jcq;
        private volatile boolean jvX = false;
        final String mAppId;

        public a(String str) {
            this.mAppId = str;
            this.jcq = new c(Process.myPid());
            e pi = com.tencent.mm.plugin.appbrand.a.pi(str);
            if (pi != null && pi.YI()) {
                this.jvX = true;
            }
            if (ajX()) {
                this.jLv = new d();
                this.jLv.mInterval = 100;
                this.jLv.jLw = this.jLw;
            }
        }

        static boolean ajX() {
            return VERSION.SDK_INT >= 16;
        }

        public final void run() {
            if (this.AW && !this.itm) {
                double ajZ = this.jcq.ajZ();
                AppBrandPerformanceManager.o(this.mAppId, 101, ((int) ajZ) + "%");
                a.a(this.mAppId, "Hardware", "CPU", ajZ);
                int chq = bi.chq();
                AppBrandPerformanceManager.o(this.mAppId, 102, chq + "m");
                a.a(this.mAppId, "Hardware", "MEMORY", (double) chq);
                if (this.jvX) {
                    synchronized (i.jcB) {
                        if (i.jcB.jcJ) {
                            h aey = i.jcB.aey();
                            if (aey != null) {
                                chq = aey.a(h.aex());
                            }
                        }
                        chq = Integer.MAX_VALUE;
                    }
                    if (chq != Integer.MAX_VALUE) {
                        AppBrandPerformanceManager.o(this.mAppId, 103, chq + "m");
                    }
                }
                this.jLt++;
                if (this.jLt >= 4) {
                    this.jLt = 0;
                    final MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
                    jsApiGetStorageInfoTask.appId = this.mAppId;
                    jsApiGetStorageInfoTask.jfW = new Runnable() {
                        public final void run() {
                            AppBrandPerformanceManager.o(a.this.mAppId, 401, bi.by((long) jsApiGetStorageInfoTask.size));
                            jsApiGetStorageInfoTask.afz();
                        }
                    };
                    jsApiGetStorageInfoTask.afy();
                    AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
                }
            }
            if (this.AW) {
                com.tencent.mm.plugin.appbrand.r.c.Dt().g(this, 3000);
            }
        }
    }

    private static class GetPkgDownloadCostTask extends MainProcessTask {
        public static final Creator<GetPkgDownloadCostTask> CREATOR = new Creator<GetPkgDownloadCostTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetPkgDownloadCostTask getPkgDownloadCostTask = new GetPkgDownloadCostTask();
                getPkgDownloadCostTask.f(parcel);
                return getPkgDownloadCostTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetPkgDownloadCostTask[i];
            }
        };
        private long jLr;
        private String mAppId;

        private GetPkgDownloadCostTask() {
        }

        /* synthetic */ GetPkgDownloadCostTask(byte b) {
            this();
        }

        public final void YA() {
            x.d("MicroMsg.AppBrandPerformanceManager", "try to get pkg download cost in main process.");
            String str = this.mAppId + "_PkgDownloadCost";
            com.tencent.mm.plugin.appbrand.config.c Zw = com.tencent.mm.plugin.appbrand.app.e.Zw();
            if (Zw == null) {
                x.e("MicroMsg.AppBrandPerformanceManager", "appBrandCommonKVDataStorage is null, return");
                afF();
                return;
            }
            String str2 = Zw.get(str, null);
            if (str2 != null) {
                com.tencent.mm.plugin.appbrand.app.e.Zw().aY(str, null);
                try {
                    this.jLr = Long.parseLong(str2);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandPerformanceManager", "GetPkgDownloadCost error.");
                }
            }
            afF();
        }

        public final void YB() {
            x.d("MicroMsg.AppBrandPerformanceManager", "received pkg download cost from main process: %d ms", Long.valueOf(this.jLr));
            if (this.jLr != 0) {
                AppBrandPerformanceManager.a(this.mAppId, 201, this.jLr);
            }
            afz();
        }

        public final void f(Parcel parcel) {
            this.mAppId = parcel.readString();
            this.jLr = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAppId);
            parcel.writeLong(this.jLr);
        }
    }

    private static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Creator<SetAppPerformanceModeTask> CREATOR = new Creator<SetAppPerformanceModeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
                setAppPerformanceModeTask.f(parcel);
                return setAppPerformanceModeTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppPerformanceModeTask[i];
            }
        };
        private String mAppId;
        private boolean mEnable;

        private SetAppPerformanceModeTask() {
        }

        /* synthetic */ SetAppPerformanceModeTask(byte b) {
            this();
        }

        public final void YA() {
            com.tencent.mm.plugin.appbrand.app.e.Zw().aY(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : "0");
        }

        public final void f(Parcel parcel) {
            this.mAppId = parcel.readString();
            this.mEnable = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAppId);
            parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
        }
    }

    public static final void uv(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", str);
        a aVar = (a) jLq.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(str);
            jLq.put(str.hashCode(), aVar);
        }
        aVar.AW = true;
        com.tencent.mm.plugin.appbrand.r.c.Dt().F(aVar);
        c.a(aVar.mAppId, aVar.jLx);
        if (a.ajX() && aVar.jLv != null) {
            FrameCallback frameCallback = aVar.jLv;
            frameCallback.AW = true;
            frameCallback.jLL.postFrameCallback(frameCallback);
        }
        if (!aVar.jLu) {
            MainProcessTask getPkgDownloadCostTask = new GetPkgDownloadCostTask();
            getPkgDownloadCostTask.mAppId = aVar.mAppId;
            AppBrandMainProcessService.a(getPkgDownloadCostTask);
            aVar.jLu = true;
        }
    }

    public static final void uw(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final void ux(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", str);
        MainProcessTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final boolean uy(String str) {
        if (DebuggerShell.acx()) {
            return true;
        }
        AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(str);
        if (pk != null && pk.iRv && pk.iRU.iJa == 1) {
            return true;
        }
        return false;
    }

    public static final void a(String str, int i, long j) {
        o(str, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
    }

    public static final void o(String str, int i, String str2) {
        com.tencent.mm.plugin.appbrand.ui.h pm = com.tencent.mm.plugin.appbrand.a.pm(str);
        if (pm == null) {
            u.GQ().t(str.hashCode() + "performance_data", true).o(String.valueOf(i), str2);
        } else {
            pm.T(i, str2);
        }
    }

    public static final void E(String str, String str2, String str3) {
        com.tencent.mm.plugin.appbrand.ui.h pm = com.tencent.mm.plugin.appbrand.a.pm(str);
        if (pm == null) {
            u.GQ().t(str.hashCode() + "performance_custom_data", true).o(str2, str3);
        } else {
            pm.bJ(str2, str3);
        }
    }

    public static final void uz(String str) {
        com.tencent.mm.plugin.appbrand.ui.h pm = com.tencent.mm.plugin.appbrand.a.pm(str);
        u.b hB = u.GQ().hB(str.hashCode() + "performance_data");
        if (pm == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (hB == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : hB.GR()) {
                String str3 = (String) hB.get(str2);
                if (str3 != null) {
                    pm.T(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        uA(str);
    }

    private static final void uA(String str) {
        com.tencent.mm.plugin.appbrand.ui.h pm = com.tencent.mm.plugin.appbrand.a.pm(str);
        u.b hB = u.GQ().hB(str.hashCode() + "performance_custom_data");
        if (pm == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
        } else if (hB == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
        } else {
            for (String str2 : hB.GR()) {
                String str3 = (String) hB.get(str2);
                if (str3 != null) {
                    pm.bJ(str2, str3);
                }
            }
        }
    }

    public static final void u(String str, long j) {
        com.tencent.mm.plugin.appbrand.app.e.Zw().aY(str + "_PkgDownloadCost", String.valueOf(j));
    }
}
