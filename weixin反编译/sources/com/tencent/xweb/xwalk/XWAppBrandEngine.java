package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class XWAppBrandEngine {
    private boolean ABW = false;
    public ArrayList<Runnable> ABX = new ArrayList();
    private Timer bnp = new Timer();
    private int bnq = 0;
    private HashMap<Integer, a> bnr = new HashMap();
    private Handler mHandler = new Handler();
    long mInstance = nativeCreated();

    public class a extends TimerTask {
        public boolean ABY;
        public int bnv;

        public a(int i, boolean z) {
            this.bnv = i;
            this.ABY = z;
        }

        public final void run() {
            if (!XWAppBrandEngine.this.ABW) {
                XWAppBrandEngine.this.mHandler.post(new Runnable() {
                    public final void run() {
                        XWAppBrandEngine.this.notifyRunTimer(XWAppBrandEngine.this.mInstance, a.this.bnv);
                    }
                });
            } else if (!this.ABY) {
                synchronized (XWAppBrandEngine.this.ABX) {
                    XWAppBrandEngine.this.ABX.add(new Runnable() {
                        public final void run() {
                            XWAppBrandEngine.this.notifyRunTimer(XWAppBrandEngine.this.mInstance, a.this.bnv);
                        }
                    });
                }
            }
        }
    }

    private native long nativeCreated();

    private native void notifyClearTimer(long j, int i);

    private native boolean notifyRunTimer(long j, int i);

    private native boolean removeJsInterface(long j, String str);

    native void addJsInterface(long j, Object obj, String str);

    native String evaluateJavascript(long j, String str);

    native ByteBuffer getNativeBuffer(long j, int i);

    native int getNativeBufferId(long j);

    native void nativeFinalize(long j);

    native void setNativeBuffer(long j, int i, ByteBuffer byteBuffer);

    @Keep
    public int setTimer(int i, boolean z) {
        int i2 = this.bnq + 1;
        this.bnq = i2;
        TimerTask aVar = new a(i2, z);
        this.bnr.put(Integer.valueOf(i2), aVar);
        if (i <= 0) {
            i = 1;
        }
        if (z) {
            this.bnp.schedule(aVar, (long) i, (long) i);
        } else {
            this.bnp.schedule(aVar, (long) i);
        }
        return i2;
    }

    @Keep
    public void clearTimer(int i) {
        if (this.bnr.containsKey(Integer.valueOf(i))) {
            ((a) this.bnr.get(Integer.valueOf(i))).cancel();
            this.bnr.remove(Integer.valueOf(i));
        }
    }

    @Keep
    public void onLog(int i, String str) {
        String[] strArr = new String[]{"debug", "log", "info", "warn", "error"};
    }

    static {
        ClassLoader classLoader = XWAppBrandEngine.class.getClassLoader();
        k.b("mmv8", classLoader);
        k.b("jsengine", classLoader);
    }
}
