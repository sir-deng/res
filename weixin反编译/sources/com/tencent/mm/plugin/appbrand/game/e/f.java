package com.tencent.mm.plugin.appbrand.game.e;

import android.support.v4.e.i.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class f<T> implements a<T> {
    public ConcurrentLinkedQueue<T> jdG = new ConcurrentLinkedQueue();

    public abstract T aep();

    public T bH() {
        T poll = this.jdG.poll();
        if (poll == null) {
            return aep();
        }
        return poll;
    }

    public final boolean j(T t) {
        return this.jdG.offer(t);
    }
}
