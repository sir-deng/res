package com.tencent.pb.common.c;

public abstract class e<T> {
    private T mInstance;

    public abstract T cDM();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = cDM();
            }
            t = this.mInstance;
        }
        return t;
    }
}
