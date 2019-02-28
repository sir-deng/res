package com.tencent.c.e.a.a;

public abstract class c implements Runnable {
    public abstract void cEs();

    public abstract void cEt();

    public void run() {
        try {
            cEs();
        } catch (Throwable th) {
            cEt();
        }
    }
}
