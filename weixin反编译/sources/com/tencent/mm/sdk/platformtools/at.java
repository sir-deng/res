package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class at {
    boolean fDJ;
    Object lock;
    String name;
    int priority;
    public LinkedBlockingQueue<a> xpI;
    private int xpJ;
    Vector<b> xpK;
    ag xpL;

    public interface a {
        boolean JH();

        boolean JI();
    }

    final class b extends Thread {
        private int tCF;

        /* synthetic */ b(at atVar, byte b) {
            this();
        }

        private b() {
            super(at.this.name);
            this.tCF = 60;
            setPriority(at.this.priority);
            at.this.xpK.add(this);
        }

        public final void run() {
            while (this.tCF > 0) {
                a aVar;
                synchronized (at.this.lock) {
                    try {
                        if (at.this.fDJ) {
                            at.this.lock.wait();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
                    }
                }
                try {
                    aVar = (a) at.this.xpI.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Throwable e2) {
                    x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e2, "", new Object[0]);
                    aVar = null;
                }
                if (aVar == null) {
                    this.tCF--;
                } else {
                    this.tCF = 60;
                    if (aVar.JH()) {
                        at.this.xpL.sendMessage(at.this.xpL.obtainMessage(0, aVar));
                    }
                }
            }
            at.this.xpK.remove(this);
            x.d("QueueWorkerThread.QueueWorkerThread", "dktest Finish queueToReqSize:" + at.this.xpI.size() + " ThreadSize:" + at.this.xpK.size());
        }
    }

    public at(int i, String str) {
        this(i, str, 1);
    }

    public at(int i, String str, int i2) {
        this(i, str, i2, Looper.myLooper());
    }

    public at(int i, String str, int i2, Looper looper) {
        this.xpI = new LinkedBlockingQueue();
        this.fDJ = false;
        this.xpJ = 1;
        this.priority = 1;
        this.name = "";
        this.lock = new byte[0];
        this.xpK = new Vector();
        this.xpJ = i2;
        this.name = str;
        this.priority = i;
        if (looper == null && Looper.getMainLooper() != null) {
            looper = Looper.getMainLooper();
            x.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
        }
        this.xpL = new ag(looper) {
            public final void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    ((a) message.obj).JI();
                }
            }
        };
    }

    public final int c(a aVar) {
        if (aVar == null) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
            return -1;
        }
        try {
            if (!this.xpI.offer(aVar, 1, TimeUnit.MILLISECONDS)) {
                x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
                return -2;
            } else if (this.xpK.size() != 0 && (this.xpI.size() <= 0 || this.xpJ <= this.xpK.size())) {
                return 0;
            } else {
                new b().start();
                return 0;
            }
        } catch (Throwable e) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + e.getMessage());
            x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
            return -3;
        }
    }

    @Deprecated
    public final boolean cgG() {
        if (this.xpK == null || this.xpK.size() == 0) {
            return true;
        }
        return false;
    }

    public final void lK(boolean z) {
        synchronized (this.lock) {
            this.fDJ = z;
            if (!z) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                }
            }
        }
    }
}
