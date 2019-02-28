package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    public final ByteBuffer jMu;
    private int jMv;

    public a(ByteBuffer byteBuffer) {
        this.jMu = byteBuffer;
    }

    public final int available() {
        return this.jMu.remaining();
    }

    public final int read() {
        return this.jMu.hasRemaining() ? this.jMu.get() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!this.jMu.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.jMu.remaining());
        this.jMu.get(bArr, i, min);
        return min;
    }

    public final void close() {
        super.close();
        i(this.jMu);
    }

    public final synchronized void mark(int i) {
        this.jMv = this.jMu.position();
    }

    public final synchronized void seek(int i) {
        this.jMu.position(i);
    }

    public final synchronized void reset() {
        this.jMu.position(this.jMv);
    }

    public final boolean markSupported() {
        return true;
    }

    public static void i(ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                x.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", e);
            }
        }
        System.gc();
    }
}
