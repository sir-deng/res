package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class au {
    private static final ConcurrentLinkedQueue<Runnable> xpN = new ConcurrentLinkedQueue();
    private static ExecutorService xpO = null;

    au() {
    }

    public static ExecutorService cgH() {
        ExecutorService executorService;
        synchronized (au.class) {
            if (xpO == null) {
                xpO = Executors.newSingleThreadExecutor();
            }
            executorService = xpO;
        }
        return executorService;
    }

    public static void M(Runnable runnable) {
        xpN.add(runnable);
    }

    public static void N(Runnable runnable) {
        xpN.remove(runnable);
    }
}
