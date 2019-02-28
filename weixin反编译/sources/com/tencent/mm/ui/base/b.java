package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b {

    public interface a {
        void ml(boolean z);
    }

    private static class b implements InvocationHandler {
        public WeakReference<a> yfn;

        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            if (this.yfn == null) {
                x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
            } else {
                a aVar = (a) this.yfn.get();
                if (aVar == null) {
                    x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.ml(z);
                }
            }
            return null;
        }
    }

    public static int Zk(String str) {
        Class Zl = Zl(str);
        if (Zl != null) {
            return H(Zl);
        }
        return 0;
    }

    public static int H(Class<?> cls) {
        Class cls2;
        do {
            a aVar = (a) cls2.getAnnotation(a.class);
            if (aVar != null) {
                return aVar.value();
            }
            cls2 = cls2.getSuperclass();
        } while (cls2 != null);
        return 0;
    }

    private static Class<?> Zl(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            x.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            return null;
        }
    }

    public static boolean I(Class<?> cls) {
        return (H(cls) & 1) == 0;
    }

    public static void Z(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
        }
    }

    public static void fF(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.v.a.a.bqk, com.tencent.mm.v.a.a.bpQ);
        }
    }

    public static void fG(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.v.a.a.bqk, com.tencent.mm.v.a.a.bql);
        }
    }

    public static void B(Context context, Intent intent) {
        if (intent != null && context != null && (context instanceof Activity) && intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.v.a.a.bqk, com.tencent.mm.v.a.a.bpQ);
        }
    }

    public static void fH(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.v.a.a.bpQ, com.tencent.mm.v.a.a.bql);
        }
    }

    public static void fI(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.v.a.a.bpQ, com.tencent.mm.v.a.a.bpQ);
        }
    }
}
