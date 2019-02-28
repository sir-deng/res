package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.splash.a.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class e {
    public static final ArrayList<f> xtQ = new ArrayList();
    public static final ArrayList<Message> xtR = new ArrayList();
    static Application xtS;
    static c xtT;
    static Set<SplashActivity> xtU = new HashSet();
    private static boolean xtV = false;
    private static volatile boolean xtW = false;
    private static boolean xtX = false;
    private static k xtY;
    private static boolean xtZ = false;
    static b xua;
    private static Class<? extends SplashActivity> xub;
    private static Class<? extends Activity> xuc;
    private static j xud = new j();
    private static boolean xue = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler xuf = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                e.cij();
                return;
            }
            a.fh(e.xtS);
            a.a(new a() {
                public final void chY() {
                    e.cij();
                }

                public final void bvf() {
                    e.a("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                    e.cif();
                }

                public final void chZ() {
                    e.a("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                    e.cif();
                }
            });
        }
    };

    static /* synthetic */ void akt() {
        xtW = true;
        a("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(xtW));
        cih();
    }

    static /* synthetic */ void ud() {
        boolean z = true;
        try {
            Object cd = cd(xtS);
            String str = "WxSplash.Splash";
            String str2 = "spy, activityThread %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cd == i.xuA);
            a(str, str2, objArr);
            Field declaredField = cd.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(cd);
            str = "WxSplash.Splash";
            str2 = "spy, ActivityThread_mH %s";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(handler == i.xuB);
            a(str, str2, objArr);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Callback callback = (Callback) declaredField2.get(handler);
            String str3 = "WxSplash.Splash";
            str = "spy, callback %s %s";
            Object[] objArr2 = new Object[2];
            if (callback != i.xuG) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            objArr2[1] = callback;
            a(str3, str, objArr2);
        } catch (Throwable e) {
            a(e, "spy failed.");
        }
    }

    static void a(SplashActivity splashActivity) {
        xtU.add(splashActivity);
    }

    static void b(SplashActivity splashActivity) {
        xtU.remove(splashActivity);
    }

    public static String U(Activity activity) {
        if (activity instanceof f) {
            return ((f) activity).xul;
        }
        return "";
    }

    public static void a(k kVar) {
        xtY = kVar;
    }

    public static void E(Class<? extends SplashActivity> cls) {
        xub = cls;
    }

    public static void F(Class<? extends Activity> cls) {
        xuc = cls;
    }

    public static void a(b bVar) {
        xua = bVar;
    }

    public static void a(c cVar) {
        xtT = cVar;
    }

    public static void fl(Context context) {
        Object obj = 1;
        try {
            ComponentName fd = bi.fd(ad.getContext());
            if (fd != null && fd.getPackageName().equals(ad.getPackageName()) && fd.getClassName().equals(ad.cgd())) {
                a("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            } else if (fd == null || !fd.getPackageName().startsWith("com.excelliance")) {
                obj = null;
            } else {
                a("WxSplash.Splash", "it is dual open", new Object[0]);
            }
            if (obj == null) {
                a("WxSplash.Splash", "do nothing and return.", new Object[0]);
                return;
            }
            xud.e(675, 36, 1);
            String chU = a.chU();
            File file = new File(chU);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(chU + "/main-process-blocking");
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                Intent intent = new Intent(context, xuc);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        } catch (Throwable e) {
            a(e, "request fig leaf failed.");
        }
    }

    public static synchronized boolean e(Application application) {
        boolean z;
        synchronized (e.class) {
            if (xtX) {
                a("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
                z = true;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                xtS = application;
                xud.e(675, 4, 1);
                try {
                    Class cls = Class.forName("android.app.ActivityManagerNative");
                    Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(cls, new Object[0]);
                    if (invoke != null) {
                        a("WxSplash.Splash", "getDefault %s", invoke);
                        if (invoke.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin")) {
                            xud.e(675, 33, 1);
                            a("WxSplash.Splash", "found using droidplugin", new Object[0]);
                        }
                        if (Proxy.isProxyClass(invoke.getClass())) {
                            a("WxSplash.Splash", "found ActivityManager is a Proxy class, " + invoke.getClass(), new Object[0]);
                        }
                    }
                    try {
                        String canonicalName;
                        Object obj;
                        RuntimeException runtimeException;
                        int[] iArr;
                        Field declaredField;
                        Handler handler;
                        Field declaredField2;
                        Callback callback;
                        g gVar;
                        Method declaredMethod2;
                        Field declaredField3;
                        Object cd = cd(application);
                        Field declaredField4 = cd.getClass().getDeclaredField("mInstrumentation");
                        declaredField4.setAccessible(true);
                        Instrumentation instrumentation = (Instrumentation) declaredField4.get(cd);
                        if (Object.class != instrumentation.getClass().getSuperclass()) {
                            canonicalName = instrumentation.getClass().getCanonicalName();
                            if (canonicalName.startsWith("android.support.test") || canonicalName.startsWith("android.test")) {
                                a("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
                                obj = 1;
                                if (obj != null) {
                                    z = false;
                                } else if (instrumentation == null) {
                                    throw new NullPointerException("Instrumentation original should not be null.");
                                } else if (Object.class == instrumentation.getClass().getSuperclass()) {
                                    xud.e(675, 7, 1);
                                    a("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                                    canonicalName = instrumentation.getClass().getCanonicalName();
                                    runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                                    iArr = new int[]{40, 41, 42, 43, 44, 45, 46};
                                    if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                        xud.e(675, 30, 1);
                                        a("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                                    }
                                    xud.e(675, 0, 1);
                                    throw runtimeException;
                                } else {
                                    if (instrumentation instanceof h) {
                                        declaredField4.set(cd, new h(instrumentation));
                                    } else {
                                        a("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                                    }
                                    i.xuA = cd;
                                    declaredField = cd.getClass().getDeclaredField("mH");
                                    declaredField.setAccessible(true);
                                    handler = (Handler) declaredField.get(cd);
                                    if (handler != null) {
                                        throw new RuntimeException("mH is null!");
                                    }
                                    i.xuB = handler;
                                    declaredField2 = Handler.class.getDeclaredField("mCallback");
                                    declaredField2.setAccessible(true);
                                    callback = (Callback) declaredField2.get(handler);
                                    i.xuH = declaredField2;
                                    if (callback != null) {
                                        a("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                        xud.e(675, 8, 1);
                                    }
                                    if (callback == null && (callback instanceof g)) {
                                        a("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                                    } else {
                                        gVar = new g(application, callback);
                                        declaredField2.setAccessible(true);
                                        declaredField2.set(handler, gVar);
                                        i.xuG = gVar;
                                    }
                                    handler = new Handler();
                                    g.Y(new Runnable() {
                                        public final void run() {
                                            e.xue = true;
                                            handler.removeCallbacksAndMessages(null);
                                            e.a("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
                                        }
                                    });
                                    i.xuB.sendEmptyMessage(987654321);
                                    handler.postDelayed(new Runnable() {
                                        public final void run() {
                                            if (!e.xue) {
                                                e.a("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
                                                e.cil().e(675, 32, 1);
                                                e.ud();
                                            }
                                        }
                                    }, 2000);
                                    if (!com.tencent.mm.e.a.oG) {
                                        declaredMethod2 = cd.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                        declaredMethod2.setAccessible(true);
                                        i.xuF = declaredMethod2;
                                        declaredField = cd.getClass().getDeclaredField("mBoundApplication");
                                        declaredField.setAccessible(true);
                                        invoke = declaredField.get(cd);
                                        i.xuC = invoke;
                                        declaredField3 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                        declaredField3.setAccessible(true);
                                        declaredField3.set(invoke, Boolean.valueOf(true));
                                        declaredField3 = invoke.getClass().getDeclaredField("providers");
                                        declaredField3.setAccessible(true);
                                        i.xuE = (List) declaredField3.get(invoke);
                                    }
                                    xtX = true;
                                    xtV = true;
                                    a("WxSplash.Splash", "splash hack success.", new Object[0]);
                                    a("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            z = false;
                        } else if (instrumentation == null) {
                            throw new NullPointerException("Instrumentation original should not be null.");
                        } else if (Object.class == instrumentation.getClass().getSuperclass()) {
                            if (instrumentation instanceof h) {
                                a("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                            } else {
                                declaredField4.set(cd, new h(instrumentation));
                            }
                            i.xuA = cd;
                            declaredField = cd.getClass().getDeclaredField("mH");
                            declaredField.setAccessible(true);
                            handler = (Handler) declaredField.get(cd);
                            if (handler != null) {
                                i.xuB = handler;
                                declaredField2 = Handler.class.getDeclaredField("mCallback");
                                declaredField2.setAccessible(true);
                                callback = (Callback) declaredField2.get(handler);
                                i.xuH = declaredField2;
                                if (callback != null) {
                                    a("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                    xud.e(675, 8, 1);
                                }
                                if (callback == null) {
                                }
                                gVar = new g(application, callback);
                                declaredField2.setAccessible(true);
                                declaredField2.set(handler, gVar);
                                i.xuG = gVar;
                                handler = new Handler();
                                g.Y(/* anonymous class already generated */);
                                i.xuB.sendEmptyMessage(987654321);
                                handler.postDelayed(/* anonymous class already generated */, 2000);
                                if (com.tencent.mm.e.a.oG) {
                                    declaredMethod2 = cd.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                    declaredMethod2.setAccessible(true);
                                    i.xuF = declaredMethod2;
                                    declaredField = cd.getClass().getDeclaredField("mBoundApplication");
                                    declaredField.setAccessible(true);
                                    invoke = declaredField.get(cd);
                                    i.xuC = invoke;
                                    declaredField3 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                    declaredField3.setAccessible(true);
                                    declaredField3.set(invoke, Boolean.valueOf(true));
                                    declaredField3 = invoke.getClass().getDeclaredField("providers");
                                    declaredField3.setAccessible(true);
                                    i.xuE = (List) declaredField3.get(invoke);
                                }
                                xtX = true;
                                xtV = true;
                                a("WxSplash.Splash", "splash hack success.", new Object[0]);
                                a("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                z = true;
                            } else {
                                throw new RuntimeException("mH is null!");
                            }
                        } else {
                            xud.e(675, 7, 1);
                            a("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                            canonicalName = instrumentation.getClass().getCanonicalName();
                            runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                            iArr = new int[]{40, 41, 42, 43, 44, 45, 46};
                            if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                xud.e(675, 30, 1);
                                a("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                            }
                            xud.e(675, 0, 1);
                            throw runtimeException;
                        }
                    } catch (Throwable e) {
                        a(e, "splash hack error!");
                        z = false;
                    }
                } catch (Throwable e2) {
                    a(e2, "validateEnvironment found some thing.");
                }
            }
        }
        return z;
    }

    public static void cib() {
        boolean z = true;
        if (xtX) {
            try {
                Callback callback = (Callback) i.xuH.get(i.xuB);
                String str = "WxSplash.Splash";
                String str2 = "double check, callback %s %s";
                Object[] objArr = new Object[2];
                if (callback != i.xuG) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                a(str, str2, objArr);
                if (callback != i.xuG) {
                    a("WxSplash.Splash", "double check found problem!", new Object[0]);
                    Field field = i.xuH;
                    i.xuG.oYQ = callback;
                    field.setAccessible(true);
                    field.set(i.xuB, i.xuG);
                    xud.e(675, 31, 1);
                    i.xuB.sendEmptyMessage(987654321);
                }
            } catch (Throwable e) {
                a(e, "double check exception.");
            }
        }
    }

    public static boolean cic() {
        return true;
    }

    public static boolean cid() {
        if (xtV) {
            return true;
        }
        return false;
    }

    public static boolean cie() {
        return xtW;
    }

    public static void cif() {
        Process.killProcess(Process.myPid());
    }

    public static void cig() {
        if (com.tencent.mm.e.a.oG) {
            xuf.sendEmptyMessage(0);
        } else {
            xuf.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            e.xuf.sendEmptyMessage(a.ff(e.xtS) ? 1 : 0);
                        }
                    }, "checking-need-dexopt");
                }
            }, 150);
        }
    }

    private static void cih() {
        a("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(xtR.size()));
        Iterator it = xtR.iterator();
        while (it.hasNext()) {
            i.xuB.sendMessage((Message) it.next());
        }
        xtR.clear();
    }

    private static void cii() {
        a("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        xtV = false;
        for (SplashActivity splashActivity : xtU) {
            a("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.cip();
        }
        a("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(xtR.size()));
        if (!xtW) {
            cih();
        }
        xtY = null;
        a("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (e.class) {
            xtZ = false;
        }
        j jVar = xud;
        if (jVar.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - jVar.mStartTimestamp;
            if (com.tencent.mm.e.a.oG) {
                jVar.e(676, 1, 1);
                jVar.e(676, 3, currentTimeMillis);
                return;
            }
            jVar.e(676, 0, 1);
            jVar.e(676, 2, currentTimeMillis);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void cij() {
        /*
        r10 = com.tencent.mm.splash.e.class;
        monitor-enter(r10);
        r2 = xtS;	 Catch:{ all -> 0x002e }
        com.tencent.mm.splash.a.fg(r2);	 Catch:{ all -> 0x002e }
        r3 = com.tencent.mm.splash.e.class;
        monitor-enter(r3);	 Catch:{ all -> 0x002e }
        r2 = xtZ;	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
    L_0x0010:
        monitor-exit(r10);
        return;
    L_0x0012:
        r2 = 1;
        xtZ = r2;	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r2 = xtX;	 Catch:{ Exception -> 0x0045 }
        if (r2 != 0) goto L_0x0034;
    L_0x001a:
        r2 = "WxSplash.Splash";
        r3 = "not hacked, return.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        a(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
    L_0x0026:
        r2 = xtY;	 Catch:{ all -> 0x002e }
        if (r2 != 0) goto L_0x00e9;
    L_0x002a:
        cii();	 Catch:{ all -> 0x002e }
        goto L_0x0010;
    L_0x002e:
        r2 = move-exception;
        monitor-exit(r10);
        throw r2;
    L_0x0031:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r2;	 Catch:{ all -> 0x002e }
    L_0x0034:
        r2 = com.tencent.mm.e.a.oG;	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0058;
    L_0x0038:
        r2 = "WxSplash.Splash";
        r3 = "not hack content provider, return.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        a(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
        goto L_0x0026;
    L_0x0045:
        r2 = move-exception;
        r3 = xud;	 Catch:{ all -> 0x002e }
        r4 = 675; // 0x2a3 float:9.46E-43 double:3.335E-321;
        r6 = 11;
        r8 = 1;
        r3.e(r4, r6, r8);	 Catch:{ all -> 0x002e }
        r3 = "install provider failed!";
        a(r2, r3);	 Catch:{ all -> 0x002e }
        goto L_0x0026;
    L_0x0058:
        r2 = com.tencent.mm.splash.i.xuE;	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0026;
    L_0x005c:
        r2 = com.tencent.mm.splash.i.xuE;	 Catch:{ Exception -> 0x0045 }
        r2 = r2.size();	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0026;
    L_0x0064:
        r3 = xud;	 Catch:{ Exception -> 0x0045 }
        r4 = 675; // 0x2a3 float:9.46E-43 double:3.335E-321;
        r6 = 10;
        r8 = 1;
        r3.e(r4, r6, r8);	 Catch:{ Exception -> 0x0045 }
        r4 = com.tencent.mm.splash.i.xuA;	 Catch:{ Exception -> 0x0045 }
        r2 = r4.getClass();	 Catch:{ Exception -> 0x0045 }
        r3 = "mInitialApplication";
        r2 = r2.getDeclaredField(r3);	 Catch:{ Exception -> 0x0045 }
        r3 = 1;
        r2.setAccessible(r3);	 Catch:{ Exception -> 0x0045 }
        r3 = r2.get(r4);	 Catch:{ Exception -> 0x0045 }
        r0 = r3;
        r0 = (android.app.Application) r0;	 Catch:{ Exception -> 0x0045 }
        r2 = r0;
        com.tencent.mm.splash.i.xuD = r2;	 Catch:{ Exception -> 0x0045 }
        if (r3 != 0) goto L_0x009a;
    L_0x008c:
        r2 = "WxSplash.Splash";
        r3 = "mInitialApplication is null, use mine. ";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0045 }
        a(r2, r3, r5);	 Catch:{ Exception -> 0x0045 }
        r3 = xtS;	 Catch:{ Exception -> 0x0045 }
    L_0x009a:
        r2 = "com.tencent.mm.plugin.base.stub.WXCommProvider";
        java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x00e1 }
        r2 = "com.tencent.mm.plugin.base.stub.WXCommProvider$1";
        java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x00e1 }
        r2 = "WxSplash.Splash";
        r5 = "WXCommProvider is ok";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e1 }
        a(r2, r5, r6);	 Catch:{ Throwable -> 0x00e1 }
    L_0x00b2:
        r2 = "WxSplash.Splash";
        r5 = "before delay install ContentProviders. ";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0045 }
        a(r2, r5, r6);	 Catch:{ Exception -> 0x0045 }
        r2 = com.tencent.mm.splash.i.xuF;	 Catch:{ Exception -> 0x0045 }
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0045 }
        r6 = 0;
        r5[r6] = r3;	 Catch:{ Exception -> 0x0045 }
        r3 = 1;
        r6 = com.tencent.mm.splash.i.xuE;	 Catch:{ Exception -> 0x0045 }
        r5[r3] = r6;	 Catch:{ Exception -> 0x0045 }
        r2.invoke(r4, r5);	 Catch:{ Exception -> 0x0045 }
        r2 = "WxSplash.Splash";
        r3 = "delay install ContentProviders. ";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        a(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
        r2 = com.tencent.mm.splash.i.xuE;	 Catch:{ Exception -> 0x0045 }
        r2.clear();	 Catch:{ Exception -> 0x0045 }
        goto L_0x0026;
    L_0x00e1:
        r2 = move-exception;
        r5 = "before install provider, we found a weird thing.";
        a(r2, r5);	 Catch:{ Exception -> 0x0045 }
        goto L_0x00b2;
    L_0x00e9:
        r2 = xtY;	 Catch:{ all -> 0x002e }
        r3 = new com.tencent.mm.splash.e$5;	 Catch:{ all -> 0x002e }
        r3.<init>();	 Catch:{ all -> 0x002e }
        r2.b(r3);	 Catch:{ all -> 0x002e }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.splash.e.cij():void");
    }

    public static Class<? extends Activity> cik() {
        return xub;
    }

    private static Object cd(Context context) {
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(invoke);
    }

    public static void a(String str, String str2, Object... objArr) {
        if (xua != null) {
            xua.a(str, str2, objArr);
        }
    }

    public static void a(Throwable th, String str) {
        if (xua != null) {
            xua.a(th, str);
        }
    }

    public static j cil() {
        return xud;
    }
}
