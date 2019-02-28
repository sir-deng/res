package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    final int priority;
    public int xmG;
    private b<c> xmH;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.xmG = 0;
        this.priority = i;
    }

    final int cfA() {
        if (this.xmG == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.xmG = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            x.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.xmG;
    }

    public final synchronized b<c> cfB() {
        if (this.xmH == null) {
            ListenerInstanceMonitor.bV(this);
            this.xmH = a.xmy.a(this);
        }
        return this.xmH;
    }

    public final synchronized void dead() {
        if (this.xmH != null) {
            ListenerInstanceMonitor.bW((c) this.xmH.zKW);
            this.xmH.dead();
            this.xmH = null;
        }
    }
}
