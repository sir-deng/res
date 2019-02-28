package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class f {
    private static f sqB = new f();
    private ReentrantLock fcT = new ReentrantLock();
    private e sqC;

    private f() {
    }

    public static e bHm() {
        if (sqB.sqC == null) {
            sqB.fcT.lock();
            try {
                if (sqB.sqC == null) {
                    sqB.sqC = new e();
                }
                sqB.fcT.unlock();
            } catch (Throwable th) {
                sqB.fcT.unlock();
            }
        }
        return sqB.sqC;
    }
}
