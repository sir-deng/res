package com.tencent.mm.plugin.normsg.utils;

import android.content.Context;
import android.support.annotation.Keep;
import android.widget.Toast;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public final class NativeLogic {

    @Keep
    private static final class JInvocationHandler implements InvocationHandler {
        @Keep
        private volatile long mCInstancePtr;

        private native void nativeCleanup();

        public final native Object invoke(Object obj, Method method, Object[] objArr);

        private JInvocationHandler(long j) {
            if (j == 0) {
                throw new IllegalArgumentException("Bad cInstancePtr.");
            }
            this.mCInstancePtr = j;
        }

        protected final void finalize() {
            try {
                nativeCleanup();
                this.mCInstancePtr = 0;
            } catch (Throwable th) {
            } finally {
                super.finalize();
            }
        }
    }

    @Keep
    public interface CProxyMarker {
    }

    public enum a implements com.tencent.mm.plugin.normsg.a.a {
        ;

        private a(String str) {
        }

        public final void ur(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkMsgLevel();
            }
        }

        public final void us(int i) {
            String str = ad.getContext().getApplicationInfo().sourceDir;
            g.Do();
            int Cn = com.tencent.mm.kernel.a.Cn();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType(str, Cn);
            }
        }

        public final void ut(int i) {
            Context context = ad.getContext();
            String str = context.getApplicationInfo().sourceDir;
            g.Do();
            int Cn = com.tencent.mm.kernel.a.Cn();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType2(context, str, Cn);
            }
        }

        public final void uu(int i) {
            Context context = ad.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType3(context);
            }
        }

        public final void uv(int i) {
            int i2 = 0;
            Context context = ad.getContext();
            Set treeSet = new TreeSet();
            for (int i3 = 0; i3 < i; i3++) {
                treeSet.clear();
                NativeLogic.checkSoftType4(context, treeSet, false);
            }
            Toast.makeText(context, treeSet.toString(), 1).show();
            while (i2 < i) {
                treeSet.clear();
                NativeLogic.checkSoftType4(context, treeSet, true);
                i2++;
            }
            Toast.makeText(context, treeSet.toString(), 1).show();
        }

        public final void uw(int i) {
            Context context = ad.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType5()), 1).show();
            }
        }

        public final void ux(int i) {
            Context context = ad.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType6(",")), 1).show();
            }
        }

        public final void uy(int i) {
            Context context = ad.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType7()), 1).show();
            }
        }
    }

    private static native boolean checkMsgLevel();

    private static native byte[] checkSoftType(String str, int i);

    private static native byte[] checkSoftType2(Context context, String str, int i);

    private static native byte[] checkSoftType3(Context context);

    private static native void checkSoftType4(Context context, Set<String> set, boolean z);

    private static native long checkSoftType5();

    private static native String checkSoftType6(String str);

    private static native boolean checkSoftType7();

    private static native boolean checkSoftType8(Object obj);

    private static native boolean checkSoftType9(Object obj, Class<? extends b> cls);

    private static native boolean secretMsgCheck(Object obj, Class cls);

    private static native int setLog(int i);

    public static boolean bgo() {
        long nanoTime = System.nanoTime();
        boolean checkMsgLevel = checkMsgLevel();
        x.i("MicroMsg.NativeLogic", "call checkMsgLevel, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 1, 2, (int) r8, false);
        return checkMsgLevel;
    }

    public static byte[] bR(String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType = checkSoftType(str, i);
        x.i("MicroMsg.NativeLogic", "call checkSoftType, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 4, 5, (int) r8, false);
        return checkSoftType;
    }

    public static byte[] i(Context context, String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType2 = checkSoftType2(context, str, i);
        x.i("MicroMsg.NativeLogic", "call checkSoftType2, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 7, 8, (int) r8, false);
        return checkSoftType2;
    }

    public static byte[] dl(Context context) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType3 = checkSoftType3(context);
        x.i("MicroMsg.NativeLogic", "call checkSoftType3, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 10, 11, (int) r8, false);
        return checkSoftType3;
    }

    public static void a(Context context, Set<String> set, boolean z) {
        long nanoTime = System.nanoTime();
        checkSoftType4(context, set, z);
        x.i("MicroMsg.NativeLogic", "call checkSoftType4, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 13, 14, (int) r6, false);
    }

    public static long bgM() {
        long nanoTime = System.nanoTime();
        long checkSoftType5 = checkSoftType5();
        x.i("MicroMsg.NativeLogic", "call checkSoftType5, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 16, 17, (int) r8, false);
        return checkSoftType5;
    }

    public static String Ho(String str) {
        long nanoTime = System.nanoTime();
        String checkSoftType6 = checkSoftType6(str);
        x.i("MicroMsg.NativeLogic", "call checkSoftType6, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 19, 20, (int) r8, false);
        return checkSoftType6;
    }

    public static boolean b(Object obj, Class cls) {
        return secretMsgCheck(obj, cls);
    }

    public static boolean bgN() {
        long nanoTime = System.nanoTime();
        boolean checkSoftType7 = checkSoftType7();
        x.i("MicroMsg.NativeLogic", "call checkSoftType7, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 22, 23, (int) r8, false);
        return checkSoftType7;
    }

    public static boolean bB(Object obj) {
        long nanoTime = System.nanoTime();
        boolean checkSoftType8 = checkSoftType8(obj);
        x.i("MicroMsg.NativeLogic", "call checkSoftType8, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 25, 26, (int) r8, false);
        return checkSoftType8;
    }

    public static void c(Object obj, Class<? extends b> cls) {
        long nanoTime = System.nanoTime();
        checkSoftType9(obj, cls);
        x.i("MicroMsg.NativeLogic", "call checkSoftType9, duration: %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
        d.pVE.c(415, 28, 29, (int) r6, false);
    }

    static {
        k.b("wechatnormsg", NativeLogic.class.getClassLoader());
    }
}
