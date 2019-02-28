package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor {
    private static final Map<Object, Set<a>> xng = new WeakHashMap();
    private static final byte[] xnh = new byte[0];
    private static Field xni;
    private static HandlerThread xnj;
    private static ag xnk;
    private static volatile boolean xnl;
    private static final String xnm = Activity.class.getName();
    private static Field xnn = null;
    private static final Runnable xno = new Runnable() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r11 = this;
            r4 = 1;
            r3 = 0;
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xno;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xnl;	 Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x000f;
        L_0x000d:
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
        L_0x000e:
            return;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xnh;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xng;	 Catch:{ all -> 0x0056 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0045;
        L_0x001f:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r2 = "[tomys] monitor task: no listener or cb was added, skip rest logic.";
            com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x0056 }
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        L_0x0029:
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xno;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xnl;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d;
        L_0x0034:
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xnk;	 Catch:{ all -> 0x003f }
            r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r0.postDelayed(r11, r2);	 Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            goto L_0x000e;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            throw r0;
        L_0x0045:
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
            r0 = android.os.Debug.isDebuggerConnected();
            if (r0 == 0) goto L_0x0059;
        L_0x004c:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            goto L_0x0029;
        L_0x0056:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
            throw r0;
        L_0x0059:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "[tomys] monitor task: triggering gc...";
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);
            r0 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x01dd }
            r0.gc();	 Catch:{ Throwable -> 0x01dd }
            r0 = 100;
            java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x01dd }
            r0 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x01dd }
            r0.runFinalization();	 Catch:{ Throwable -> 0x01dd }
        L_0x0075:
            r5 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xnh;
            monitor-enter(r5);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.xng;	 Catch:{ all -> 0x00d1 }
            r0 = r0.entrySet();	 Catch:{ all -> 0x00d1 }
            r6 = r0.iterator();	 Catch:{ all -> 0x00d1 }
        L_0x0086:
            r0 = r6.hasNext();	 Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x01da;
        L_0x008c:
            r0 = r6.next();	 Catch:{ all -> 0x00d1 }
            r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x00d1 }
            r0 = r0.getValue();	 Catch:{ all -> 0x00d1 }
            r0 = (java.util.Set) r0;	 Catch:{ all -> 0x00d1 }
            r7 = r0.iterator();	 Catch:{ all -> 0x00d1 }
        L_0x009c:
            r0 = r7.hasNext();	 Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x0086;
        L_0x00a2:
            r0 = r7.next();	 Catch:{ all -> 0x00d1 }
            r0 = (com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.a) r0;	 Catch:{ all -> 0x00d1 }
            r1 = r0.xnp;	 Catch:{ all -> 0x00d1 }
            r2 = r1.get();	 Catch:{ all -> 0x00d1 }
            r1 = r0.xnq;	 Catch:{ all -> 0x00d1 }
            r1 = r1.get();	 Catch:{ all -> 0x00d1 }
            r1 = (android.app.Activity) r1;	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x00d4;
        L_0x00b8:
            r1 = "MicroMsg.ListenerInstanceMonitor";
            r2 = "[tomys] monitor task: Ok, ui [%s] was recycled.";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00d1 }
            r9 = 0;
            r0 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r0 = r0.getName();	 Catch:{ all -> 0x00d1 }
            r8[r9] = r0;	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.i(r1, r2, r8);	 Catch:{ all -> 0x00d1 }
            r7.remove();	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x00d1:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x00d1 }
            throw r0;
        L_0x00d4:
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.AnonymousClass1.T(r1);	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x009c;
        L_0x00da:
            if (r2 != 0) goto L_0x009c;
        L_0x00dc:
            r1 = r0.xnu;	 Catch:{ all -> 0x00d1 }
            r2 = 3;
            if (r1 <= r2) goto L_0x01b4;
        L_0x00e1:
            r7.remove();	 Catch:{ all -> 0x00d1 }
            r1 = com.tencent.mm.sdk.platformtools.e.DEBUG;	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x00f4;
        L_0x00e8:
            r1 = com.tencent.mm.sdk.a.b.cfx();	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x00f4;
        L_0x00ee:
            r1 = com.tencent.mm.sdk.a.b.cfv();	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0137;
        L_0x00f4:
            r2 = r4;
        L_0x00f5:
            r8 = new com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor$ListenerLeakedException;	 Catch:{ all -> 0x00d1 }
            r1 = r0.xnq;	 Catch:{ all -> 0x00d1 }
            r1 = r1.get();	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x0157;
        L_0x00ff:
            r1 = r0.xns;	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0139;
        L_0x0103:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] held by\n [";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.cfQ();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] is recycled";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
        L_0x012f:
            r0 = r0.xnt;	 Catch:{ all -> 0x00d1 }
            r8.<init>(r1, r0);	 Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x01a6;
        L_0x0136:
            throw r8;	 Catch:{ all -> 0x00d1 }
        L_0x0137:
            r2 = r3;
            goto L_0x00f5;
        L_0x0139:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012f;
        L_0x0157:
            r1 = r0.xns;	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0188;
        L_0x015b:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] held by\n [";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.cfQ();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012f;
        L_0x0188:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012f;
        L_0x01a6:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r0, r8, r1, r2);	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x01b4:
            r1 = r0.xnu;	 Catch:{ all -> 0x00d1 }
            r1 = r1 + 1;
            r0.xnu = r1;	 Catch:{ all -> 0x00d1 }
            r1 = "MicroMsg.ListenerInstanceMonitor";
            r2 = "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.";
            r8 = 2;
            r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00d1 }
            r9 = 0;
            r10 = r0.xnr;	 Catch:{ all -> 0x00d1 }
            r10 = r10.getName();	 Catch:{ all -> 0x00d1 }
            r8[r9] = r10;	 Catch:{ all -> 0x00d1 }
            r9 = 1;
            r0 = r0.xnu;	 Catch:{ all -> 0x00d1 }
            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00d1 }
            r8[r9] = r0;	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.w(r1, r2, r8);	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x01da:
            monitor-exit(r5);	 Catch:{ all -> 0x00d1 }
            goto L_0x0029;
        L_0x01dd:
            r0 = move-exception;
            goto L_0x0075;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.1.run():void");
        }

        private static boolean T(Activity activity) {
            boolean z;
            Window window = activity.getWindow();
            if (ListenerInstanceMonitor.xnn == null) {
                try {
                    ListenerInstanceMonitor.xnn = Window.class.getDeclaredField("mDestroyed");
                    ListenerInstanceMonitor.xnn.setAccessible(true);
                } catch (Throwable th) {
                    x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "unexpected exception.", new Object[0]);
                    return false;
                }
            }
            try {
                z = ListenerInstanceMonitor.xnn.getBoolean(window);
            } catch (Throwable th2) {
                z = false;
            }
            if (!z) {
                return false;
            }
            for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                if (ListenerInstanceMonitor.xnm.equals(stackTraceElement.getClassName()) && "performDestroy".equals(stackTraceElement.getMethodName())) {
                    return false;
                }
            }
            return z;
        }
    };

    private static final class ListenerLeakedException extends RuntimeException {
        ListenerLeakedException(String str, Throwable th) {
            super(str + "\n See stacktrace to find where is the holder(listener) being added.");
            setStackTrace(th.getStackTrace());
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    private static class a {
        final WeakReference<Object> xnp = new WeakReference(new Object());
        WeakReference<Activity> xnq;
        Class<?> xnr;
        Field xns;
        Throwable xnt;
        int xnu;

        a(Activity activity, Field field, Throwable th) {
            this.xnq = new WeakReference(activity);
            this.xnr = activity.getClass();
            this.xns = field;
            this.xnt = th;
            this.xnu = 0;
        }

        public final String toString() {
            return cfQ() + "@" + cfP().replace(10, '|');
        }

        private String cfP() {
            Throwable th;
            Writer stringWriter = new StringWriter();
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    this.xnt.printStackTrace(printWriter);
                    bi.d(printWriter);
                    return stringWriter.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(printWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                bi.d(printWriter);
                throw th;
            }
        }

        final String cfQ() {
            if (this.xns == null) {
                return "#null#";
            }
            Object declaringClass = this.xns.getDeclaringClass();
            if (!declaringClass.isAnonymousClass()) {
                return "field " + this.xns.getName() + " defined in " + declaringClass.getName();
            }
            Type genericSuperclass = declaringClass.getGenericSuperclass();
            if (Object.class.equals(genericSuperclass)) {
                declaringClass = declaringClass.getGenericInterfaces()[0];
            } else if (genericSuperclass != null) {
                Type declaringClass2 = genericSuperclass;
            }
            return "field " + this.xns.getName() + " define in anonymous class of " + declaringClass2.toString().replace('<', '#').replace('>', '#');
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            Object obj = this.xnq.get();
            if (obj != null) {
                hashCode = obj.hashCode();
            } else {
                hashCode = 0;
            }
            if (this.xns != null) {
                hashCode2 = this.xns.hashCode();
            } else {
                hashCode2 = 0;
            }
            if (this.xnt != null) {
                i = this.xnt.hashCode();
            }
            return (hashCode + hashCode2) + i;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.xnq.get();
            Object obj3 = aVar.xnq.get();
            boolean equals = (obj2 == null && obj3 == null) ? true : (obj2 == null || obj3 == null) ? false : obj2.equals(obj3);
            if (!equals) {
                return false;
            }
            Field field = this.xns;
            Field field2 = aVar.xns;
            equals = (field == null && field2 == null) ? true : (field == null || field2 == null) ? false : field.equals(field2);
            if (!equals) {
                return false;
            }
            Throwable th = this.xnt;
            Throwable th2 = aVar.xnt;
            if (!(th == null && th2 == null)) {
                z = (th == null || th2 == null) ? false : th.equals(th2);
            }
            return z;
        }
    }

    static {
        xni = null;
        xnj = null;
        xnk = null;
        xnl = false;
        if (!e.DEBUG && !b.cfx() && !b.cfv()) {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
        } else if (ad.cgj()) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                xni = declaredField;
                declaredField.setAccessible(true);
                synchronized (xno) {
                    if (!xnl) {
                        HandlerThread WL = e.WL("ListenerInstanceMonitor");
                        xnj = WL;
                        WL.start();
                        ag agVar = new ag(xnj.getLooper());
                        xnk = agVar;
                        agVar.postDelayed(xno, 10000);
                        xnl = true;
                    }
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "init failed, keep disabled.", new Object[0]);
            }
        } else {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
        }
    }

    public static void bV(Object obj) {
        if (obj != null) {
            Throwable th = new Throwable();
            for (Class cls = obj.getClass(); !Object.class.equals(cls); cls = cls.getSuperclass()) {
                if (Activity.class.isAssignableFrom(cls)) {
                    a(obj, null, th);
                } else if (View.class.isAssignableFrom(cls)) {
                    b(obj, null, th);
                } else {
                    for (Field field : cls.getDeclaredFields()) {
                        Class type = field.getType();
                        if (Activity.class.isAssignableFrom(type)) {
                            a(obj, field, th);
                        } else if (View.class.isAssignableFrom(type)) {
                            b(obj, field, th);
                        }
                    }
                }
            }
        }
    }

    private static void a(Object obj, Field field, Throwable th) {
        Activity activity;
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                activity = (Activity) field.get(obj);
                if (activity == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            return;
        }
        a(obj, activity, field, th);
    }

    private static void b(Object obj, Field field, Throwable th) {
        Object obj2;
        if (field == null) {
            if (obj instanceof View) {
                obj2 = (View) obj;
            } else {
                return;
            }
        } else if (xni != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                View obj22 = (View) field.get(obj);
                if (obj22 == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else {
            return;
        }
        try {
            obj22 = xni.get(obj22);
            if (obj22 instanceof Activity) {
                a(obj, (Activity) obj22, field, th);
            }
        } catch (Throwable th3) {
        }
    }

    private static void a(Object obj, Activity activity, Field field, Throwable th) {
        int length;
        g gVar = null;
        if (obj.getClass().isAnnotationPresent(g.class)) {
            gVar = (g) obj.getClass().getAnnotation(g.class);
        } else {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(g.class)) {
                    gVar = (g) method.getAnnotation(g.class);
                    break;
                }
            }
        }
        if (gVar != null) {
            int i;
            Class cls = activity.getClass();
            Class[] cfE = gVar.cfE();
            if (cfE != null && cfE.length > 0) {
                length = cfE.length;
                i = 0;
                while (i < length) {
                    if (!cls.equals(cfE[i])) {
                        i++;
                    }
                }
                i = 0;
                if (i != 0) {
                    x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                    return;
                }
            }
            i = 1;
            if (i != 0) {
                x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                return;
            }
        }
        synchronized (xnh) {
            Set set = (Set) xng.get(obj);
            if (set == null) {
                set = new HashSet();
                xng.put(obj, set);
            }
            set.add(new a(activity, field, th));
        }
    }

    public static void bW(Object obj) {
        if (obj != null) {
            synchronized (xnh) {
                xng.remove(obj);
            }
        }
    }
}
