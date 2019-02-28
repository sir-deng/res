package com.tencent.mm.ap.a.a;

import com.tencent.mm.ap.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a {

    private static class a implements ThreadFactory {
        private static final AtomicInteger hEM = new AtomicInteger(1);
        private final ThreadGroup hEN;
        private final AtomicInteger hEO = new AtomicInteger(1);
        private final String hEP;
        private final int hEQ;

        a(int i, String str) {
            this.hEQ = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.hEN = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.hEP = str + hEM.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.hEN, runnable, this.hEP + this.hEO.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.hEQ);
            return thread;
        }
    }

    private static class b extends ThreadPoolExecutor implements h {
        private ReentrantLock hER = new ReentrantLock();
        private Condition hES = this.hER.newCondition();
        private BlockingQueue<Runnable> hET;
        private boolean isPaused;

        public b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
            this.hET = blockingQueue;
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            this.hER.lock();
            while (this.isPaused) {
                try {
                    this.hES.await();
                } catch (Exception e) {
                    thread.interrupt();
                    x.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.hER.unlock();
                }
            }
        }

        public final void pause() {
            this.hER.lock();
            try {
                this.isPaused = true;
            } finally {
                this.hER.unlock();
            }
        }

        public final void resume() {
            this.hER.lock();
            try {
                this.isPaused = false;
                this.hES.signalAll();
            } finally {
                this.hER.unlock();
            }
        }

        public final void execute(Runnable runnable) {
            super.execute(runnable);
        }

        public final boolean vh() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            if (this.hET != null) {
                this.hET.remove(obj);
            }
        }
    }

    public static h bb(int i, int i2) {
        BlockingQueue aVar = new com.tencent.mm.ap.a.e.a();
        return new b(i, i, TimeUnit.MILLISECONDS, aVar, new a(i2, "image_loader_"));
    }
}
