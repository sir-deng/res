package com.tencent.e;

public abstract class d<T extends e> {
    public T[] AvJ = Jp(20);
    public final Object mLock = new Object();
    public int qAu;

    public abstract T[] Jp(int i);

    public abstract T cIj();

    public d(int i) {
    }

    public T cIk() {
        T t = null;
        synchronized (this.mLock) {
            if (this.qAu > 0) {
                this.qAu--;
                t = this.AvJ[this.qAu];
                this.AvJ[this.qAu] = null;
            }
        }
        return t;
    }
}
