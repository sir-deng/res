package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.mm.ap.o;
import com.tencent.mm.ay.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.mm.y.d.c;
import java.io.File;
import java.lang.reflect.Field;

public final class k {
    public static k ffR;
    public boolean ffS;
    public ag ffT = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == -1999) {
                if (!k.this.ffS) {
                    LauncherUI cnu = LauncherUI.cnu();
                    if (cnu != null && cnu.xPx) {
                        Resources resources;
                        Field declaredField;
                        cnu.xPu.xOK.YW("tab_main");
                        HomeUI homeUI = cnu.xPu;
                        if (homeUI.xOz) {
                            homeUI.xOB = true;
                        }
                        try {
                            resources = ad.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mDrawableCache");
                                declaredField.setAccessible(true);
                                ((LongSparseArray) declaredField.get(resources)).clear();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e, "", new Object[0]);
                        }
                        try {
                            resources = ad.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mColorStateListCache");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(resources);
                                if (obj instanceof SparseArray) {
                                    ((SparseArray) obj).clear();
                                } else {
                                    ((LongSparseArray) obj).clear();
                                }
                            }
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e2, "", new Object[0]);
                        }
                        try {
                            if (VERSION.SDK_INT >= 16) {
                                Resources resources2 = ad.getContext().getResources();
                                if (resources2 != null) {
                                    Field declaredField2 = resources2.getClass().getDeclaredField("mColorDrawableCache");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                    declaredField2 = resources2.getClass().getDeclaredField("sPreloadedColorDrawables");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                }
                            }
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e22, "", new Object[0]);
                        }
                        f fVar = n.qWB;
                        if (fVar != null) {
                            fVar.buQ();
                        }
                        for (Fragment fragment : cnu.xPu.xOK.xTm.values()) {
                            if (!(fragment instanceof j)) {
                                ((l) fragment).cmr();
                            }
                        }
                    }
                    System.gc();
                }
            } else if (message.what == -2999 && !k.this.ffS) {
                LauncherUI cnu2 = LauncherUI.cnu();
                if (cnu2 != null) {
                    w wVar = cnu2.xPu.xOK;
                    if (wVar.xTm.containsKey(Integer.valueOf(0))) {
                        ((l) wVar.xTm.get(Integer.valueOf(0))).cmr();
                    }
                }
                if (g.Do().CF()) {
                    as.Hg();
                    ap ib = bq.ib("plugin.emoji");
                    if (ib != null) {
                        ib.ge(0);
                    }
                    as.Hg();
                    if (((o) bq.ib(o.class.getName())) != null) {
                        o.PI();
                    }
                    a IV = b.IV();
                    a IO = a.IO();
                    c IX = c.IX();
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            File file = new File(b.hkN + "MMSQL.trace");
                            if (!file.exists()) {
                                x.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                            } else if (g.Do().CF()) {
                                long currentTimeMillis = System.currentTimeMillis();
                                long ba = b.ba(ad.getContext());
                                boolean z = false;
                                if (ba > currentTimeMillis) {
                                    z = true;
                                } else if (currentTimeMillis - ba > 86400000) {
                                    z = true;
                                } else if (currentTimeMillis - ba > b.this.hkU && b.this.hkt) {
                                    z = true;
                                }
                                x.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(file.length()), Boolean.valueOf(z));
                                if (z && r2 > b.this.hkT) {
                                    b bVar = b.this;
                                    Context context = ad.getContext();
                                    String packageName = ad.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub() {
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                b.this.ffK[0] = packageStats.cacheSize;
                                                b.this.ffK[1] = packageStats.dataSize;
                                                b.this.ffK[2] = packageStats.codeSize;
                                                x.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                            }
                                        }});
                                    } catch (Exception e) {
                                        bVar.ffK[0] = -1;
                                        bVar.ffK[1] = -1;
                                        bVar.ffK[2] = -1;
                                    }
                                    if (b.this.ffK[1] != 0 || b.this.hks > 1) {
                                        x.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(file.length()));
                                        if (file.length() > b.this.hkS) {
                                            x.e("MicroMsg.SQLTraceManager", "log file invaild format");
                                        } else {
                                            String iv = b.is(b.hkN + "MMSQL.trace");
                                            x.i("MicroMsg.SQLTraceManager", "read content success");
                                            b.this.iu(iv);
                                        }
                                        x.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                                        b.this.a(file, true);
                                        b.this.hkt = false;
                                        b.this.hks = 0;
                                        b.c(ad.getContext(), System.currentTimeMillis());
                                        return;
                                    }
                                    x.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                                    b.this.hks = 1 + b.this.hks;
                                }
                            } else {
                                x.w("MicroMsg.SQLTraceManager", "acc not ready ");
                            }
                        }
                    });
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            File file = new File(a.hkr);
                            if (!file.exists()) {
                                x.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                            } else if (g.Do().CF()) {
                                long j = a.this.hbz.getLong("handler_report_lastUploadTime", 0);
                                long currentTimeMillis = System.currentTimeMillis();
                                Object obj = (currentTimeMillis - j > a.this.hkz || j > currentTimeMillis) ? 1 : null;
                                if (a.this.hkt && obj != null) {
                                    x.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(file.length()), Boolean.valueOf(true));
                                    a aVar = a.this;
                                    Context context = ad.getContext();
                                    String packageName = ad.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub() {
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                a.this.ffK[0] = packageStats.cacheSize;
                                                a.this.ffK[1] = packageStats.dataSize;
                                                a.this.ffK[2] = packageStats.codeSize;
                                                x.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                            }
                                        }});
                                    } catch (Exception e) {
                                        aVar.ffK[0] = -1;
                                        aVar.ffK[1] = -1;
                                        aVar.ffK[2] = -1;
                                    }
                                    if (a.this.ffK[1] != 0 || a.this.hks > 1) {
                                        if (file.length() > a.this.hky) {
                                            x.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                                        } else {
                                            String it = a.is(a.hkr);
                                            a aVar2 = a.this;
                                            Intent intent = new Intent();
                                            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                                            intent.setAction("uncatch_exception");
                                            intent.putExtra("exceptionPid", Process.myPid());
                                            String str = "userName";
                                            String H = ar.hhz.H("login_weixin_username", "");
                                            if (bi.oN(H)) {
                                                H = ar.hhz.H("login_user_name", "never_login_crash");
                                            }
                                            intent.putExtra(str, H);
                                            intent.putExtra("tag", "handler");
                                            intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.IP() + it).getBytes(), 2));
                                            ad.getContext().startService(intent);
                                        }
                                        a.this.a(file, true);
                                        a.this.hkt = false;
                                        a.this.hks = 0;
                                        a.this.hbz.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                                        return;
                                    }
                                    a.this.hks = 1 + a.this.hks;
                                }
                            } else {
                                x.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|checkAndUpload";
                        }
                    });
                    IX.a(IV);
                    IX.a(IO);
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            if (c.this.hlc) {
                                x.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                                return;
                            }
                            long j = c.this.hbz.getLong("trace_config_last_update_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                                c.this.release();
                                c.this.hlc = true;
                                as.CN().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, c.this);
                                as.CN().a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, c.this);
                                as.CN().a(new k(21), 0);
                                return;
                            }
                            x.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
                        }
                    });
                }
                System.gc();
            }
        }
    };

    public static k tY() {
        if (ffR == null) {
            ffR = new k();
        }
        return ffR;
    }
}
