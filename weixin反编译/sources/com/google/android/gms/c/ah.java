package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.w;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah {
    private static volatile ah aYm;
    private volatile aj aGG;
    private final List<Object> aYn = new CopyOnWriteArrayList();
    private final ad aYo = new ad();
    public final a aYp = new a();
    public UncaughtExceptionHandler aYq;
    public final Context mContext;

    private static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.google.android.gms.c.ah$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ae aYr;

        public AnonymousClass1(ae aeVar) {
            this.aYr = aeVar;
        }

        public final void run() {
            this.aYr.aXZ.a(this.aYr);
            Iterator it = ah.this.aYn.iterator();
            while (it.hasNext()) {
                it.next();
            }
            ah.d(this.aYr);
        }
    }

    private class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }

        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new FutureTask<T>(runnable, t) {
                protected final void setException(Throwable th) {
                    UncaughtExceptionHandler b = ah.this.aYq;
                    if (b != null) {
                        b.uncaughtException(Thread.currentThread(), th);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        new StringBuilder("MeasurementExecutor: job failed with ").append(th);
                    }
                    super.setException(th);
                }
            };
        }
    }

    private static class b implements ThreadFactory {
        private static final AtomicInteger aYu = new AtomicInteger();

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + aYu.incrementAndGet());
        }
    }

    private ah(Context context) {
        Context applicationContext = context.getApplicationContext();
        w.ag(applicationContext);
        this.mContext = applicationContext;
    }

    public static ah S(Context context) {
        w.ag(context);
        if (aYm == null) {
            synchronized (ah.class) {
                if (aYm == null) {
                    aYm = new ah(context);
                }
            }
        }
        return aYm;
    }

    static /* synthetic */ void d(ae aeVar) {
        w.aO("deliver should be called from worker thread");
        w.e(aeVar.aYa, "Measurement must be submitted");
        List<ai> list = aeVar.aYi;
        if (!list.isEmpty()) {
            Set hashSet = new HashSet();
            for (ai aiVar : list) {
                Uri nM = aiVar.nM();
                if (!hashSet.contains(nM)) {
                    hashSet.add(nM);
                    aiVar.b(aeVar);
                }
            }
        }
    }

    public static void mZ() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> a(Callable<V> callable) {
        w.ag(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.aYp.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void d(Runnable runnable) {
        w.ag(runnable);
        this.aYp.submit(runnable);
    }

    public final aj pS() {
        if (this.aGG == null) {
            synchronized (this) {
                if (this.aGG == null) {
                    aj ajVar = new aj();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    ajVar.aYv = packageName;
                    ajVar.aYw = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                    ajVar.aEW = packageName;
                    ajVar.aEX = str;
                    this.aGG = ajVar;
                }
            }
        }
        return this.aGG;
    }
}
