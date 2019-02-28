package com.tencent.mm.plugin.appbrand.g.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements a {
    private final AtomicInteger jBR = new AtomicInteger(0);
    private final HashMap<Integer, ByteBuffer> jBS = new HashMap();

    public final int air() {
        Integer valueOf = Integer.valueOf(this.jBR.addAndGet(1));
        this.jBS.put(valueOf, null);
        return valueOf.intValue();
    }

    public final ByteBuffer jw(int i) {
        if (!this.jBS.containsKey(Integer.valueOf(i))) {
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.jBS.get(Integer.valueOf(i));
        this.jBS.remove(Integer.valueOf(i));
        return byteBuffer;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.isDirect() && this.jBS.containsKey(Integer.valueOf(i))) {
            this.jBS.put(Integer.valueOf(i), byteBuffer);
        }
    }
}
