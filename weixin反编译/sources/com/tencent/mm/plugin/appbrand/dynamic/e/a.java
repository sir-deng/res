package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.b.d;
import com.tencent.xweb.g;
import java.util.concurrent.CountDownLatch;

public final class a implements d {
    g iXa;
    private volatile boolean iXb;
    private volatile boolean iXc = false;
    private volatile CountDownLatch iXd;
    private ag mHandler;

    public final boolean Ch() {
        return this.iXa.isValid();
    }

    public a(Object obj, String str, g gVar) {
        this.iXa = gVar;
        this.iXb = false;
        this.iXa.addJavascriptInterface(obj, str);
        this.mHandler = new ag(Looper.getMainLooper());
        this.iXa.addJavascriptInterface(this, "WeixinJsThreadCaller");
    }

    @JavascriptInterface
    public final int callFromJsThread() {
        x.d("MicroMsg.AppBrandX5BasedJsEngine", "enter callFromJsThread, pendingPause %b", Boolean.valueOf(this.iXc));
        if (this.iXc) {
            x.i("MicroMsg.AppBrandX5BasedJsEngine", "pause await threadId %d", Long.valueOf(Thread.currentThread().getId()));
            this.iXc = false;
            this.iXd = new CountDownLatch(1);
            try {
                this.iXd.await();
            } catch (InterruptedException e) {
                x.e("MicroMsg.AppBrandX5BasedJsEngine", "pause await e = %s", e);
            }
        }
        return 1;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (!this.iXb) {
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    a.this.iXa.evaluateJavascript(str, valueCallback);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                this.mHandler.post(anonymousClass1);
            }
        }
    }

    public final void cleanup() {
        if (!this.iXb) {
            this.iXa.cleanup();
        }
        this.iXb = true;
    }

    public final void pause() {
        if (this.iXa.Cg()) {
            this.iXa.pause();
            return;
        }
        this.iXc = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                x.d("MicroMsg.AppBrandX5BasedJsEngine", "invoke callFromJsThread ret %s", (String) obj);
            }
        });
    }

    public final void resume() {
        if (this.iXa.Cg()) {
            this.iXa.resume();
            return;
        }
        this.iXc = false;
        if (this.iXd != null) {
            this.iXd.countDown();
            this.iXd = null;
        }
    }

    public final boolean Cg() {
        return true;
    }
}
