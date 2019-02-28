package com.tencent.mm.pluginsdk.i.a.d;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class f<T extends b> {
    final Map<String, b> voi = new ConcurrentHashMap();
    final Map<String, Future<?>> voj = new ConcurrentHashMap();

    protected class a extends ThreadPoolExecutor {
        public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, t tVar) {
            super(i, i2, j, timeUnit, blockingQueue, tVar);
        }

        protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            if (runnable instanceof d) {
                return new c(runnable, v, ((d) runnable).vol);
            }
            return super.newTaskFor(runnable, v);
        }

        protected final void terminated() {
            f.this.voj.clear();
            super.terminated();
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (f.this.voj.containsKey(cVar.vol.bZW())) {
                    cVar.cancel(false);
                } else {
                    f.this.voj.put(cVar.vol.bZW(), cVar);
                    f.this.voi.remove(cVar.vol.bZW());
                }
            } else {
                x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
        }

        protected final void afterExecute(Runnable runnable, Throwable th) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                f.this.voj.remove(cVar.vol.bZW());
                f.this.voi.remove(cVar.vol.bZW());
            } else {
                x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
        }
    }

    public interface b {
        String bZW();
    }

    protected static abstract class d<Req extends b> implements Runnable {
        private final Req vol;

        public Req aat() {
            return this.vol;
        }

        public d(Req req) {
            this.vol = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    protected static class c<V> extends FutureTask<V> {
        protected final b vol;

        public c(Runnable runnable, V v, b bVar) {
            super(runnable, v);
            this.vol = bVar;
        }
    }

    public abstract d a(T t);

    public abstract a cad();

    public final void b(T t) {
        this.voi.put(t.bZW(), t);
        cad().submit(a(t));
    }

    public final synchronized boolean Sz(String str) {
        boolean z;
        z = this.voj.containsKey(str) || this.voi.containsKey(str);
        return z;
    }
}
