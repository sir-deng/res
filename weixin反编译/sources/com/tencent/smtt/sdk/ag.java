package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import java.lang.reflect.Method;
import java.util.Map;

final class ag {
    DexLoader Ain;

    public ag(DexLoader dexLoader) {
        this.Ain = dexLoader;
    }

    public final int a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        if (p.gM(context)) {
            return -103;
        }
        Object invokeStaticMethod;
        if (str2 == null) {
            invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            return invokeStaticMethod == null ? -104 : ((Integer) invokeStaticMethod).intValue();
        } else {
            invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            return invokeStaticMethod == null ? -104 : ((Integer) invokeStaticMethod).intValue();
        }
    }

    public final boolean cGc() {
        Method method = this.Ain.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        return invoke instanceof Boolean ? ((Boolean) invoke).booleanValue() : ((Boolean) invoke).booleanValue();
    }

    public final Object cGd() {
        return this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public final IX5WebViewBase hF(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Object invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    m.cEY().a(context, 325, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    m.cEY().a(context, 325, new Throwable((String) invokeStaticMethod2));
                }
                iX5WebViewBase = null;
                invokeStaticMethod = null;
            } catch (Exception e) {
                iX5WebViewBase = null;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        m.cEY().a(context, 325, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e2) {
                }
            }
        }
        return invokeStaticMethod == null ? null : iX5WebViewBase;
    }
}
