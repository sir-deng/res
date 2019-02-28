package com.tencent.mm.kernel.c;

public final class d<T extends a> implements b, c<T> {
    private T gUA;

    public d(T t) {
        this.gUA = t;
    }

    public final T Ec() {
        return this.gUA;
    }

    public final void Ea() {
        if (this.gUA instanceof b) {
            ((b) this.gUA).Ea();
        }
    }

    public final void Eb() {
        if (this.gUA instanceof b) {
            ((b) this.gUA).Eb();
        }
    }
}
