package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g {

    public static class a {
        public long gJu = SystemClock.elapsedRealtime();

        public final long zp() {
            return SystemClock.elapsedRealtime() - this.gJu;
        }
    }

    public static int getLine() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    public static String zn() {
        return new Throwable().getStackTrace()[1].toString();
    }

    public static String zo() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}
