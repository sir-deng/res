package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public final class b implements f {
    XWAppBrandEngine ACb;
    HandlerThread ACc = new HandlerThread("v8_worker");
    private Handler ACd;
    boolean ACe = false;

    public b() {
        this.ACc.start();
        this.ACd = new Handler(this.ACc.getLooper());
    }

    public final void init(int i) {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (b.this.ACb == null) {
                    b.this.ACb = new XWAppBrandEngine();
                }
            }
        });
    }

    public final void pause() {
        if (!this.ACe) {
            this.ACe = true;
            this.ACd.post(new Runnable() {
                public final void run() {
                    while (b.this.ACe) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            });
        }
    }

    public final void resume() {
        this.ACe = false;
    }

    public final void cleanup() {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (b.this.ACb != null) {
                    XWAppBrandEngine xWAppBrandEngine = b.this.ACb;
                    xWAppBrandEngine.nativeFinalize(xWAppBrandEngine.mInstance);
                    b.this.ACb = null;
                    b.this.ACc.getLooper().quit();
                    b.this.ACc = null;
                }
            }
        });
    }

    public final boolean Cg() {
        return true;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        this.ACd.post(new Runnable() {
            public final void run() {
                if (b.this.ACb != null) {
                    XWAppBrandEngine xWAppBrandEngine = b.this.ACb;
                    String evaluateJavascript = xWAppBrandEngine.evaluateJavascript(xWAppBrandEngine.mInstance, str);
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(evaluateJavascript);
                    }
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
                if (b.this.ACb != null) {
                    XWAppBrandEngine xWAppBrandEngine = b.this.ACb;
                    xWAppBrandEngine.addJsInterface(xWAppBrandEngine.mInstance, obj, str);
                }
            }
        });
    }

    public final int getNativeBufferId() {
        if (this.ACb == null) {
            return 0;
        }
        XWAppBrandEngine xWAppBrandEngine = this.ACb;
        return xWAppBrandEngine.getNativeBufferId(xWAppBrandEngine.mInstance);
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        XWAppBrandEngine xWAppBrandEngine = this.ACb;
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
                byteBuffer.rewind();
                allocateDirect.put(byteBuffer);
                byteBuffer = allocateDirect;
            }
            xWAppBrandEngine.setNativeBuffer(xWAppBrandEngine.mInstance, i, byteBuffer);
        }
    }

    public final ByteBuffer ef(int i) {
        XWAppBrandEngine xWAppBrandEngine = this.ACb;
        ByteBuffer nativeBuffer = xWAppBrandEngine.getNativeBuffer(xWAppBrandEngine.mInstance, i);
        return nativeBuffer == null ? ByteBuffer.allocate(0) : nativeBuffer;
    }

    public final boolean cJu() {
        return true;
    }

    public final void a(d dVar) {
    }
}
