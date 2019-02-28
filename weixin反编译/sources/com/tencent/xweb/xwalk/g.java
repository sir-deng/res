package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

public final class g implements f {
    HandlerThread ACc = new HandlerThread("j2v8");
    private Handler ACd;
    XWalkV8 ACq;

    public g() {
        this.ACc.start();
        this.ACd = new Handler(this.ACc.getLooper());
    }

    public final void init(final int i) {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (g.this.ACq == null) {
                    g.this.ACq = new XWalkV8();
                    g.this.ACq.init(i);
                }
            }
        });
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void cleanup() {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (g.this.ACq != null) {
                    g.this.ACq.cleanup();
                    g.this.ACq = null;
                    g.this.ACc.getLooper().quit();
                    g.this.ACc = null;
                }
            }
        });
    }

    public final boolean Cg() {
        return false;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (g.this.ACq != null) {
                    g.this.ACq.evaluateJavascript(str, valueCallback);
                }
            }
        });
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        evaluateJavascript(str, valueCallback);
    }

    public final void addJavascriptInterface(final Object obj, final String str) {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (g.this.ACq != null) {
                    g.this.ACq.addJavascriptInterface(obj, str);
                }
            }
        });
    }

    public final int getNativeBufferId() {
        return 0;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
    }

    public final ByteBuffer ef(int i) {
        return null;
    }

    public final boolean cJu() {
        return false;
    }

    public final void a(d dVar) {
    }
}
