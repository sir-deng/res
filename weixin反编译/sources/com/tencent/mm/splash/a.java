package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public final class a {
    private static String xtE;
    private static String xtF;
    private static File xtG;
    private static long xtH;
    @SuppressLint({"HandlerLeak"})
    private static Handler xtI = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (a.chV()) {
                if (!a.fO(a.xtH)) {
                    a.b(aVar);
                    return;
                } else if (a.ff(e.xtS)) {
                    if (!a.fi(e.xtS)) {
                        e.cil().e(675, 18, 1);
                    }
                    e.cil().e(675, 17, 1);
                    aVar.chZ();
                } else {
                    e.cil().e(675, 25, 1);
                    aVar.chY();
                    return;
                }
            } else if (!a.chW()) {
                e.cil().e(675, 15, 1);
                aVar.chY();
            } else if (a.ff(e.xtS)) {
                e.cil().e(675, 16, 1);
                aVar.bvf();
            } else {
                e.cil().e(675, 26, 1);
                e.cil().e(675, 15, 1);
                aVar.chY();
            }
            a.xtH = 0;
        }
    };

    public interface a {
        void bvf();

        void chY();

        void chZ();
    }

    static /* synthetic */ boolean fO(long j) {
        return System.currentTimeMillis() - j > 180000;
    }

    public static void d(Application application) {
        xtE = new File(application.getFilesDir(), "dexopt_service").getAbsolutePath();
    }

    public static String chU() {
        if (xtE == null) {
            throw new IllegalStateException("data directory should not be null, give one.");
        }
        File file = new File(xtE);
        if (!(file.exists() || file.mkdirs())) {
            e.a("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        return xtE;
    }

    public static boolean ff(Context context) {
        e.a("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(com.tencent.mm.e.a.ax(context)));
        return com.tencent.mm.e.a.ax(context);
    }

    public static void fg(Context context) {
        if (!com.tencent.mm.e.a.oG) {
            boolean ay;
            e.cil().e(675, 22, 1);
            try {
                ay = com.tencent.mm.e.a.ay(context);
            } catch (Throwable th) {
                e.a(th, "multidex install failed");
                ay = false;
            }
            e.a("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(ay));
            if (!ay) {
                e.a("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
                e.cif();
            }
        }
    }

    public static void fh(Context context) {
        e.a("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String r = d.r(context, Process.myPid());
        r.replace(':', '_');
        xtF = "DexOpt_Request_" + r;
        e.cil().e(675, 14, 1);
        try {
            WT(xtF);
        } catch (Throwable e) {
            Throwable th = e;
            if (VERSION.SDK_INT <= 19 && th.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = th.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(th)).intValue() == OsConstants.ENOSPC) {
                        int i;
                        File file = new File(chU());
                        if (file.exists()) {
                            e.a("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(file.listFiles().length));
                            i = file.listFiles().length < 10000 ? 1 : 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            com.tencent.mm.e.a.aw(context);
                        } else {
                            e.a("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            file = new File(chU());
                            if (file.exists()) {
                                b.h(file);
                            }
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("WxSplash.DexOpt", e2, "", new Object[0]);
                }
            }
            throw new RuntimeException(th);
        }
        context.startService(new Intent(context, DexOptService.class));
    }

    private static synchronized void WT(String str) {
        synchronized (a.class) {
            String chU = chU();
            File file = new File(chU);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(chU + "/" + str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            xtG = file;
        }
    }

    private static boolean fi(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                e.a("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                return false;
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        e.a("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        return false;
    }

    public static boolean fj(Context context) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        e.a("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (chV()) {
            j++;
            Thread.sleep(100);
            if (j >= 5) {
                j = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    e.a("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (ff(context)) {
                        if (!fi(context)) {
                            e.cil().e(675, 18, 1);
                        }
                        e.cil().e(675, 17, 1);
                        return false;
                    }
                    e.cil().e(675, 25, 1);
                    e.cil().e(675, 15, 1);
                    return true;
                }
            }
        }
        if (!chW()) {
            e.cil().e(675, 15, 1);
            return true;
        } else if (ff(context)) {
            e.cil().e(675, 16, 1);
            return false;
        } else {
            e.cil().e(675, 26, 1);
            e.cil().e(675, 15, 1);
            return true;
        }
    }

    public static void a(a aVar) {
        b(aVar);
    }

    private static void b(a aVar) {
        if (xtH == 0) {
            xtH = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        xtI.sendMessageDelayed(obtain, 100);
    }

    private static boolean chV() {
        if (xtG != null) {
            return xtG.exists();
        }
        throw new IllegalStateException("tmp file field should not be null");
    }

    private static boolean chW() {
        return new File(chU() + "/DexOpt_Failed").exists();
    }
}
