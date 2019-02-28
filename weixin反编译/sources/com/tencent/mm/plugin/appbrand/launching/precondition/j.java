package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j {
    static int jEK = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    private static Object jEL;
    private static Handler jEM;

    public static void cc(Context context) {
        try {
            Handler bf = bf(cd(context));
            Field declaredField = bf.getClass().getDeclaredField("NEW_INTENT");
            declaredField.setAccessible(true);
            jEK = ((Integer) declaredField.get(bf)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hack constants in ActivityThread$H", new Object[0]);
        }
    }

    private static Handler bf(Object obj) {
        if (jEM != null) {
            return jEM;
        }
        Field declaredField = obj.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(obj);
        jEM = handler;
        return handler;
    }

    private static Object cd(Context context) {
        if (jEL != null) {
            return jEL;
        }
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            jEL = invoke;
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        invoke = declaredField.get(invoke);
        jEL = invoke;
        return invoke;
    }

    static boolean lj(int i) {
        Handler bf;
        try {
            bf = bf(cd(ad.getContext()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hasPendingMessageInQueue, hack mH", new Object[0]);
            bf = null;
        }
        if (bf == null) {
            return false;
        }
        return bf.hasMessages(i);
    }
}
