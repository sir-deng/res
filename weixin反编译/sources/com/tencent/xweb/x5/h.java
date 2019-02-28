package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.sdk.c;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public final class h implements f {
    private c ABf;
    private a ABg;
    d jBV;
    private Context mContext;

    public static class a {
        private static final AtomicInteger ABi = new AtomicInteger(1);
        HashMap<Integer, byte[]> jBS = new HashMap();

        @JavascriptInterface
        public final int getNativeBufferId() {
            int i;
            int i2;
            do {
                i = ABi.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!ABi.compareAndSet(i, i2));
            return i;
        }

        @JavascriptInterface
        public final void setNativeBuffer(int i, byte[] bArr) {
            this.jBS.put(Integer.valueOf(i), bArr);
        }

        @JavascriptInterface
        public final byte[] getNativeBuffer(int i) {
            return (byte[]) this.jBS.remove(Integer.valueOf(i));
        }
    }

    public h(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.ABf = new c(this.mContext);
        this.ABg = new a();
        this.ABf.addJavascriptInterface(this.ABg, "nativeBufferCompat");
        this.ABf.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                Log.i("MicroMsg.X5V8JsRuntime", "on inject nativeBufferCompat Object finished.");
            }
        }), null);
        c cVar = this.ABf;
        cVar.AeD = new com.tencent.smtt.sdk.c.a() {
            public final void a(com.tencent.smtt.sdk.d dVar) {
                Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[]{dVar.AeF.getMessage()}));
                if (h.this.jBV != null) {
                    h.this.jBV.aN(r0, "");
                }
            }
        };
        cVar.AeC.setExceptionHandler(new ValueCallback<IX5JsError>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                c.this.AeD.a(new d((IX5JsError) obj));
            }
        });
    }

    public final void pause() {
        com.tencent.smtt.sdk.f fVar = this.ABf.AeB;
        if (fVar.AeI != null) {
            fVar.AeI.onPause();
            return;
        }
        Iterator it = fVar.AeJ.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                a aVar = (a) weakReference.get();
                if (aVar.AeA != null) {
                    aVar.AeA.onPause();
                }
            }
        }
    }

    public final void resume() {
        com.tencent.smtt.sdk.f fVar = this.ABf.AeB;
        if (fVar.AeI != null) {
            fVar.AeI.onResume();
            return;
        }
        Iterator it = fVar.AeJ.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                a aVar = (a) weakReference.get();
                if (aVar.AeA != null) {
                    aVar.AeA.onResume();
                }
            }
        }
    }

    public final boolean Cg() {
        return true;
    }

    public final void cleanup() {
        this.ABf.AeC.destroy();
        this.ABg.jBS.clear();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.ABf.evaluateJavascript(str, new a.d(valueCallback), null);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        Log.i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[]{url}));
        this.ABf.evaluateJavascript(str, new a.d(valueCallback), url);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.ABf.addJavascriptInterface(obj, str);
    }

    public final int getNativeBufferId() {
        return this.ABg.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        byte[] bArr;
        a aVar = this.ABg;
        if (byteBuffer == null) {
            bArr = new byte[0];
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
        } else {
            bArr = byteBuffer.array();
        }
        aVar.setNativeBuffer(i, bArr);
    }

    public final ByteBuffer ef(int i) {
        byte[] nativeBuffer = this.ABg.getNativeBuffer(i);
        if (nativeBuffer == null || nativeBuffer.length <= 0) {
            return null;
        }
        return ByteBuffer.wrap(nativeBuffer);
    }

    public final boolean cJu() {
        return true;
    }

    public final void a(d dVar) {
        this.jBV = dVar;
    }
}
