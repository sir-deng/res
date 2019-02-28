package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static Class<?> AtB;
    private static Field AtC;
    private static Method AtD;
    private final BinderInvocationHandler AtA;
    private final Context Aty;
    private final String Atz;

    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr);
    }

    private static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler AtA;
        private final IBinder AtF;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.AtF = iBinder;
            this.AtA = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.AtF, objArr);
            }
            String interfaceDescriptor = this.AtF.getInterfaceDescriptor();
            if (interfaceDescriptor.equals("android.app.IActivityManager")) {
                interfaceDescriptor = "android.app.ActivityManagerNative";
            } else {
                interfaceDescriptor = interfaceDescriptor + "$Stub";
            }
            IInterface iInterface = (IInterface) ShareReflectUtil.c(Class.forName(interfaceDescriptor), "asInterface", IBinder.class).invoke(null, new Object[]{this.AtF});
            return ServiceBinderInterceptor.a(ServiceBinderInterceptor.O(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.AtA));
        }
    }

    private static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler AtA;
        private final IBinder AtF;
        private final IInterface AtG;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.AtG = iInterface;
            this.AtF = iBinder;
            this.AtA = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("asBinder".equals(method.getName())) {
                return this.AtF;
            }
            return this.AtA.invoke(this.AtG, method, objArr);
        }
    }

    protected final /* synthetic */ void cB(Object obj) {
        IBinder iBinder = (IBinder) obj;
        ((Map) AtC.get(null)).put(this.Atz, iBinder);
        Field a;
        IInterface iInterface;
        if ("activity".equals(this.Atz)) {
            Object obj2;
            try {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
            } catch (Throwable th) {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
            }
            a = ShareReflectUtil.a(obj2, "mInstance");
            iInterface = (IInterface) a.get(obj2);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(obj2, iInterface);
            }
        } else if ("package".equals(this.Atz)) {
            Context context = this.Aty;
            a = ShareReflectUtil.d(Class.forName("android.app.ActivityThread"), "sPackageManager");
            iInterface = (IInterface) a.get(null);
            if (!(iInterface == null || ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass()))) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(null, iInterface);
            }
            a = ShareReflectUtil.d(Class.forName("android.app.ApplicationPackageManager"), "mPM");
            PackageManager packageManager = context.getPackageManager();
            iInterface = (IInterface) a.get(packageManager);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(packageManager, iInterface);
            }
        }
    }

    protected final /* synthetic */ Object cC(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder != null) {
            return ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass()) ? iBinder : (IBinder) a(O(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.AtA));
        } else {
            throw new IllegalStateException("target is null.");
        }
    }

    protected final /* synthetic */ Object cHW() {
        return (IBinder) AtD.invoke(null, new Object[]{this.Atz});
    }

    static {
        AtB = null;
        AtC = null;
        AtD = null;
        synchronized (ServiceBinderInterceptor.class) {
            if (AtB == null) {
                try {
                    Class cls = Class.forName("android.os.ServiceManager");
                    AtB = cls;
                    AtC = ShareReflectUtil.d(cls, "sCache");
                    AtD = ShareReflectUtil.c(AtB, "getService", String.class);
                } catch (Throwable th) {
                }
            }
        }
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        Context context2 = context;
        while (context2 != null && (context2 instanceof ContextWrapper)) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        this.Aty = context2;
        this.Atz = str;
        this.AtA = binderInvocationHandler;
    }

    private static <T> T a(Class<?>[] clsArr, InvocationHandler invocationHandler) {
        Throwable th;
        Object obj;
        Object obj2 = new Class[(clsArr.length + 1)];
        System.arraycopy(clsArr, 0, obj2, 0, clsArr.length);
        obj2[clsArr.length] = ITinkerHotplugProxy.class;
        try {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), obj2, invocationHandler);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("cl: " + obj, th);
        }
    }

    private static Class<?>[] O(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Set hashSet = new HashSet(10);
        Class cls2;
        while (!Object.class.equals(cls2)) {
            hashSet.addAll(Arrays.asList(cls2.getInterfaces()));
            cls2 = cls2.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }
}
