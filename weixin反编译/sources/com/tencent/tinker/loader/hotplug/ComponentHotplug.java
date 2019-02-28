package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;

public final class ComponentHotplug {
    private static volatile boolean ArK = false;
    private static ServiceBinderInterceptor Atk;
    private static ServiceBinderInterceptor Atl;
    private static HandlerMessageInterceptor Atm;

    public static synchronized void a(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) {
        synchronized (ComponentHotplug.class) {
            if (!ArK) {
                try {
                    if (IncrementComponentManager.a((Context) tinkerApplication, shareSecurityCheck)) {
                        Atk = new ServiceBinderInterceptor(tinkerApplication, "activity", new AMSInterceptHandler(tinkerApplication));
                        Atl = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                        Atm = new HandlerMessageInterceptor(iz(tinkerApplication), new MHMessageHandler(tinkerApplication));
                        Atk.cHX();
                        Atl.cHX();
                        Atm.cHX();
                        ArK = true;
                    }
                } catch (Throwable th) {
                    cHV();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    public static synchronized void cHU() {
        synchronized (ComponentHotplug.class) {
            if (ArK) {
                try {
                    Atk.cHX();
                    Atl.cHX();
                    Atm.cHX();
                } catch (Throwable th) {
                    cHV();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    private static Handler iz(Context context) {
        Object c = ShareReflectUtil.c(context, null);
        if (c == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.a(c, "mH").get(c);
        } catch (Throwable th) {
            IllegalStateException illegalStateException = new IllegalStateException(th);
        }
    }

    private static synchronized void cHV() {
        synchronized (ComponentHotplug.class) {
            if (ArK) {
                try {
                    Atk.cHV();
                    Atl.cHV();
                    Atm.cHV();
                } catch (Throwable th) {
                }
                ArK = false;
            }
        }
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
