package com.tencent.mm.splash;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mm.blink.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import java.lang.reflect.Field;

final class g implements Callback {
    public static int xum = 100;
    public static int xun = 113;
    public static int xuo = 114;
    public static int xup = 115;
    public static int xuq = 116;
    public static int xur = 121;
    public static int xus = 122;
    public static int xut = 126;
    public static int xuu = c.CTRL_INDEX;
    private static boolean xuv = false;
    private static Runnable xuw;
    private static boolean xuy = false;
    private Context mContext;
    Callback oYQ;
    private boolean xux = false;

    public g(Context context, Callback callback) {
        this.mContext = context;
        this.oYQ = callback;
    }

    public static void Y(Runnable runnable) {
        xuv = true;
        xuw = runnable;
    }

    public static boolean cir() {
        return xuy;
    }

    public final boolean handleMessage(Message message) {
        if (this.xux) {
            e.a("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
            return true;
        }
        xuy = false;
        e.a("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", Integer.valueOf(message.what), Boolean.valueOf(e.cid()), Boolean.valueOf(e.cie()));
        if (xuv && message.what == 987654321) {
            if (xuw != null) {
                e.a("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
                xuw.run();
            }
            return true;
        }
        if (e.cid() && !e.cie()) {
            e.a("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", Integer.valueOf(message.what), Boolean.valueOf(e.cid()));
            if (message.what == xun || message.what == xuo || message.what == xup || message.what == xuq || message.what == xur || message.what == xus || message.what == xuu) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                e.xtR.add(obtain);
                a.wq();
                return true;
            }
        }
        if (message.what == xut) {
            if (e.xtU.size() > 0) {
                xuy = true;
            }
            e.a("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", Integer.valueOf(e.xtU.size()));
            Object obj = message.obj;
            if (d.fP(25)) {
                try {
                    if (i.xuI == null) {
                        Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
                        declaredField.setAccessible(true);
                        i.xuI = declaredField;
                    }
                    e.a("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", Boolean.valueOf(((Boolean) i.xuI.get(obj)).booleanValue()));
                    i.xuI.set(obj, Boolean.valueOf(false));
                } catch (Throwable e) {
                    e.a(e, "");
                }
            }
        }
        if (this.oYQ == null) {
            return false;
        }
        this.xux = true;
        boolean handleMessage = this.oYQ.handleMessage(message);
        this.xux = false;
        return handleMessage;
    }
}
