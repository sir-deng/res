package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a {
    public boolean jAP = false;
    public BroadcastReceiver jAQ = null;
    public String jAT;
    public String jAU;
    private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a jBd;
    public Context jBe;
    a jBf = null;
    b jBg = null;
    public WifiConfiguration jBh = null;
    ConnectivityManager jBi;
    private int jBj = 0;
    private final int jBk = 13000;
    public Handler mHandler = null;

    class a implements InvocationHandler {
        a() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().compareTo("onSuccess") != 0 && method.getName().compareTo("onFailure") == 0) {
                final int intValue = (objArr == null || !(objArr[0] instanceof Integer)) ? -1 : ((Integer) objArr[0]).intValue();
                a.this.mHandler.post(new Runnable() {
                    public final void run() {
                        a.this.e(false, "fail to connect wifi:actionListener" + intValue);
                    }
                });
            }
            return null;
        }
    }

    class b implements InvocationHandler {
        b() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            new StringBuilder("Method:").append(method).append(" getName:").append(method.getName()).append(" ,Args:").append(objArr);
            return null;
        }
    }

    private static Object a(a aVar, String str) {
        return Proxy.newProxyInstance(Class.forName(str).getClassLoader(), new Class[]{r0}, aVar);
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar, Context context) {
        this.jBd = aVar;
        this.jBe = context;
        try {
            this.jBi = (ConnectivityManager) this.jBe.getSystemService("connectivity");
        } catch (Exception e) {
        }
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message != null) {
                    switch (message.what) {
                        case 1:
                            if (!a.this.aiq()) {
                                a.this.tA("fail to connect wifi:time out");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId == d.jBn || this.jBi == null) {
            return false;
        }
        try {
            Class cls = Class.forName("android.net.wifi.WifiManager");
            String str;
            Object a;
            Class cls2;
            if (VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", new Class[]{Context.class, Handler.class}).invoke(c.bgP, new Object[]{this.jBe, this.mHandler});
                cls.getMethod("connectNetwork", new Class[]{Integer.TYPE}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId)});
                return true;
            } else if (VERSION.SDK_INT == 16) {
                str = "android.net.wifi.WifiManager$ChannelListener";
                if (this.jBg == null) {
                    this.jBg = new b();
                }
                a = a(this.jBf, str);
                cls2 = Class.forName(str);
                Object invoke = cls.getMethod("initialize", new Class[]{Context.class, Looper.class, cls2}).invoke(c.bgP, new Object[]{this.jBe, this.jBe.getMainLooper(), a});
                String str2 = "android.net.wifi.WifiManager$ActionListener";
                if (this.jBf == null) {
                    this.jBf = new a();
                }
                Object a2 = a(this.jBf, str2);
                Class cls3 = Class.forName(str2);
                cls.getMethod("connect", new Class[]{Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, cls3}).invoke(c.bgP, new Object[]{invoke, Integer.valueOf(wifiConfiguration.networkId), a2});
                return true;
            } else {
                if (this.jBf == null) {
                    this.jBf = new a();
                }
                str = "android.net.wifi.WifiManager$ActionListener";
                a = a(this.jBf, str);
                cls2 = Class.forName(str);
                cls.getMethod("connect", new Class[]{Integer.TYPE, cls2}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId), a});
                return true;
            }
        } catch (Exception e) {
            return c.lf(wifiConfiguration.networkId);
        }
    }

    public final boolean aiq() {
        return this.jBj == 3 || this.jBj == 2;
    }

    public final void tA(String str) {
        if (this.jBh != null) {
            b.le(this.jBh.networkId);
            e(false, str);
            new StringBuilder("cancelConnect, ").append(d.tB(this.jBh.SSID)).append(" networkId:").append(this.jBh.networkId);
        }
    }

    public final void ld(int i) {
        if (this.jBj != i) {
            String str;
            this.jBj = i;
            StringBuilder stringBuilder = new StringBuilder("switchState:");
            switch (this.jBj) {
                case 0:
                    str = "STATE_NONE";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_FAIL";
                    break;
                default:
                    str = "UnknowState";
                    break;
            }
            stringBuilder.append(str);
        }
    }

    public final void e(boolean z, String str) {
        if (!aiq()) {
            if (this.jBd != null) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar = this.jBd;
                if (z) {
                    str = "ok";
                }
                aVar.tz(str);
            }
            this.mHandler.removeMessages(1);
            if (this.jAP) {
                this.jBe.unregisterReceiver(this.jAQ);
                this.jAP = false;
            }
            ld(z ? 2 : 3);
            if (!z && this.jBh != null) {
                b.le(this.jBh.networkId);
            }
        }
    }
}
