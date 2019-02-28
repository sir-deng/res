package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> hbC = new ConcurrentLinkedQueue();
    protected S hbD;

    public d(S s) {
        this.hbD = s;
    }

    public final T pop() {
        return this.hbC.poll();
    }

    public final void put(T t) {
        this.hbC.add(t);
    }

    public final int size() {
        return this.hbC.size();
    }

    public final S EA() {
        return this.hbD;
    }
}
