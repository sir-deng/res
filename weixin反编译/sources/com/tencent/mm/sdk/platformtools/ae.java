package com.tencent.mm.sdk.platformtools;

public final class ae {
    public volatile boolean xnO;

    public ae() {
        this.xnO = false;
    }

    public ae(boolean z) {
        this.xnO = z;
    }

    public final void open() {
        synchronized (this) {
            boolean z = this.xnO;
            this.xnO = true;
            if (!z) {
                notifyAll();
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.xnO = false;
        }
    }

    public final void block() {
        synchronized (this) {
            while (!this.xnO) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final boolean cgo() {
        if (500 != 0) {
            boolean z;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 500 + currentTimeMillis;
                while (!this.xnO && currentTimeMillis < j) {
                    try {
                        wait(j - currentTimeMillis);
                    } catch (InterruptedException e) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                }
                z = this.xnO;
            }
            return z;
        }
        block();
        return true;
    }

    public final String toString() {
        return "MMConditionVariable[" + hashCode() + "," + this.xnO + "]";
    }
}
