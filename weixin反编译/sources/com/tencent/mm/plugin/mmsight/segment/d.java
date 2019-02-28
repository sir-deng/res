package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface d {

    public static class a {
        Lock mHC = new ReentrantLock();
        LinkedBlockingQueue<d> oDa = new LinkedBlockingQueue(4);
        private final int oDb = 4;
        private Callable<d> oDc;
        private volatile int size = 0;

        public a(Callable<d> callable) {
            this.oDc = callable;
        }

        public final d bbI() {
            d dVar = null;
            long Wz = bi.Wz();
            x.d("FetcherPool", "acquireFetcher");
            if (this.oDa == null) {
                x.d("FetcherPool", "acquireFetcher no pool directly return null");
            } else {
                this.mHC.lock();
                x.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", Integer.valueOf(this.oDa.size()), Integer.valueOf(this.size), Integer.valueOf(this.oDb));
                if (this.oDa == null) {
                    this.mHC.unlock();
                } else {
                    if (!this.oDa.isEmpty() || this.size >= this.oDb) {
                        x.d("FetcherPool", "waiting fetcher");
                        this.mHC.unlock();
                        dVar = (d) this.oDa.poll(5, TimeUnit.SECONDS);
                    } else {
                        x.d("FetcherPool", "new fetcher");
                        this.size++;
                        this.mHC.unlock();
                        dVar = bbJ();
                    }
                    x.d("FetcherPool", "time flee, acquireFetcher cost time %d", Long.valueOf(bi.bB(Wz)));
                }
            }
            return dVar;
        }

        private d bbJ() {
            if (this.oDc == null) {
                throw new IllegalStateException("fetcher generator can not be null.");
            }
            try {
                d dVar = (d) this.oDc.call();
                x.d("FetcherPool", "time flee, construct fetcher instance cost %d", Long.valueOf(bi.bB(bi.Wz())));
                return dVar;
            } catch (Throwable e) {
                x.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", e.getMessage());
                throw e;
            }
        }

        public final void a(d dVar) {
            x.d("FetcherPool", "reuseFetcher");
            if (dVar == null) {
                x.e("FetcherPool", "Null object can not be reused.");
            } else if (this.oDa == null) {
                dVar.release();
            } else if (this.oDa.contains(dVar)) {
                throw new IllegalStateException("fetcher already in pool");
            } else {
                this.oDa.offer(dVar);
            }
        }
    }

    int getDurationMs();

    Bitmap getFrameAtTime(long j);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i, int i2, int i3);

    void release();

    void reuseBitmap(Bitmap bitmap);
}
