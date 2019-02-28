package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static ag fcV;
    File fcS;
    private ReentrantLock fcT = new ReentrantLock();
    private Condition fcU = this.fcT.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (fcV == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                fcV = new ag(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.fcS = file;
            return;
        }
        x.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        fcV.post(new Runnable() {
            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.bU(str);
                    x.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    x.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                b.this.fcT.lock();
                try {
                    b.this.fcS = file;
                    b.this.fcU.signal();
                    x.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    b.this.fcT.unlock();
                }
            }
        });
    }

    public final File sW() {
        this.fcT.lock();
        while (this.fcS == null) {
            try {
                x.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.fcU.await();
            } catch (Exception e) {
            } finally {
                this.fcT.unlock();
            }
        }
        return this.fcS;
    }
}
