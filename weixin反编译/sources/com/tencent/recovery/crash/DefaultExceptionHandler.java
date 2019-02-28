package com.tencent.recovery.crash;

import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private UncaughtExceptionHandler AaC;

    public DefaultExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.AaC = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.AaC != null) {
            this.AaC.uncaughtException(thread, th);
        }
    }
}
