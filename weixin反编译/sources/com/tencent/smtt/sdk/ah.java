package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public final class ah {
    private static int AiX = a.Aja;
    private static int AiY = a.Aja;
    private static int AiZ = a.Aja;
    public WebView AeA = null;
    private final Context mContext;
    public Object wD = null;

    private enum a {
        ;

        static {
            Aja = 1;
            Ajb = 2;
            Ajc = 3;
            Ajd = new int[]{Aja, Ajb, Ajc};
        }
    }

    @Deprecated
    public ah(Context context) {
        this.mContext = context;
        if (hH(context)) {
            Object a = a("createX5JavaBridge", new Class[]{Context.class}, context);
            if (a != null) {
                this.wD = a;
                return;
            }
        }
        this.AeA = new WebView(context);
        this.AeA.getSettings().setJavaScriptEnabled(true);
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        if (hH(context)) {
            Object a = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, null);
            if (a != null) {
                return (IX5JsVirtualMachine) a;
            }
        }
        return null;
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            af cFZ = af.cFZ();
            if (cFZ != null && cFZ.cGa()) {
                return cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            new StringBuilder("X5Jscore#").append(str).append(" - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (Exception e) {
        }
    }

    protected static Object cGe() {
        return a("currentContextData", new Class[0], new Object[0]);
    }

    public static boolean hG(Context context) {
        if (AiZ != a.Aja) {
            return AiZ == a.Ajc;
        } else {
            AiZ = a.Ajb;
            Object a = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            AiZ = a.Ajc;
            return true;
        }
    }

    public static boolean hH(Context context) {
        if (AiX != a.Aja) {
            return AiX == a.Ajc;
        } else {
            AiX = a.Ajb;
            Object a = a("canUseX5JsCore", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            a("setJsValueFactory", new Class[]{Object.class}, e.cEJ());
            AiX = a.Ajc;
            return true;
        }
    }

    public static boolean hI(Context context) {
        if (AiY != a.Aja) {
            return AiY == a.Ajc;
        } else {
            AiY = a.Ajb;
            if (!hH(context)) {
                return false;
            }
            Object a = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            AiY = a.Ajc;
            return true;
        }
    }

    @Deprecated
    public final ByteBuffer ef(int i) {
        if (this.wD != null && hI(this.mContext)) {
            Object a = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.wD, Integer.valueOf(i));
            if (a != null && (a instanceof ByteBuffer)) {
                return (ByteBuffer) a;
            }
        }
        return null;
    }

    @Deprecated
    public final void evaluateJavascript(String str, ab<String> abVar) {
        if (this.wD != null) {
            a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, abVar, this.wD);
        } else if (this.AeA != null) {
            this.AeA.evaluateJavascript(str, abVar);
        }
    }

    @Deprecated
    public final int getNativeBufferId() {
        if (this.wD != null && hI(this.mContext)) {
            Object a = a("getNativeBufferId", new Class[]{Object.class}, this.wD);
            if (a != null && (a instanceof Integer)) {
                return ((Integer) a).intValue();
            }
        }
        return -1;
    }

    @Deprecated
    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        if (this.wD != null && hI(this.mContext)) {
            a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.wD, Integer.valueOf(i), byteBuffer);
        }
    }
}
