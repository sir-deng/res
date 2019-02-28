package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import java.nio.ByteBuffer;

final class c extends b {
    a jBu;

    c(a aVar) {
        this.jBu = aVar;
    }

    protected final void a(final f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                return Integer.valueOf(c.this.jBu.air());
            }
        }, "getNativeBufferId");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    return null;
                }
                ByteBuffer jw = c.this.jBu.jw(v8Array.getInteger(0));
                if (jw != null) {
                    return new V8ArrayBuffer(fVar.jBI, jw);
                }
                return null;
            }
        }, "getNativeBuffer");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                    V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                    if (v8ArrayBuffer != null) {
                        c.this.jBu.a(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                        v8ArrayBuffer.release();
                    }
                }
            }
        }, "setNativeBuffer");
    }
}
