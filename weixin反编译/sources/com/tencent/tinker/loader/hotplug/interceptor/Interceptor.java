package com.tencent.tinker.loader.hotplug.interceptor;

public abstract class Interceptor<T_TARGET> {
    private T_TARGET Atx = null;
    private volatile boolean mInstalled = false;

    protected interface ITinkerHotplugProxy {
    }

    protected abstract void cB(T_TARGET t_target);

    protected abstract T_TARGET cHW();

    protected T_TARGET cC(T_TARGET t_target) {
        return t_target;
    }

    public final synchronized void cHX() {
        try {
            Object cHW = cHW();
            this.Atx = cHW;
            Object cC = cC(cHW);
            if (cC != cHW) {
                cB(cC);
            } else {
                new StringBuilder("target: ").append(cHW).append(" was already hooked.");
            }
            this.mInstalled = true;
        } catch (Throwable th) {
            this.Atx = null;
            InterceptFailedException interceptFailedException = new InterceptFailedException(th);
        }
    }

    public final synchronized void cHV() {
        if (this.mInstalled) {
            try {
                cB(this.Atx);
                this.Atx = null;
                this.mInstalled = false;
            } catch (Throwable th) {
                InterceptFailedException interceptFailedException = new InterceptFailedException(th);
            }
        }
    }
}
