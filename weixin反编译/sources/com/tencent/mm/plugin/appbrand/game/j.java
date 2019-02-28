package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.engine.JsEngine;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.g.f;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public enum j implements d, f {
    ;
    
    volatile f jaF;
    final AtomicInteger jaG;
    final TreeMap<Integer, a> jaH;

    private j(String str) {
        this.jaG = new AtomicInteger(0);
        this.jaH = new TreeMap();
    }

    public final a aej() {
        return this.jaF;
    }

    public final a aek() {
        int addAndGet = this.jaG.addAndGet(1);
        a fVar = new f(false, new b(this.jaF.jax.sC()), addAndGet);
        this.jaH.put(Integer.valueOf(addAndGet), fVar);
        return fVar;
    }

    public final void kh(int i) {
        a aVar = (a) this.jaH.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.destroy();
        }
        this.jaH.remove(Integer.valueOf(i));
    }

    public final int getNativeBufferId() {
        f fVar = this.jaF;
        return JsEngine.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        f fVar = this.jaF;
        if (byteBuffer == null) {
            c.f.d("JsVmContext", "JsVmContext setNativeBuffer failed. byteBuffer == null", new Object[0]);
            return;
        }
        if (!byteBuffer.isDirect()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            byteBuffer.rewind();
            allocateDirect.put(byteBuffer);
            byteBuffer = allocateDirect;
        }
        JsEngine.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer ef(int i) {
        return this.jaF.jax.ef(i);
    }

    public final boolean ael() {
        return true;
    }
}
