package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.t;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r {
    final ExecutorService aBH;
    b<? extends c> aBI;
    IOException atf;

    @SuppressLint({"HandlerLeak"})
    private final class b<T extends c> extends Handler implements Runnable {
        private final T aBJ;
        private final a<T> aBK;
        public final int aBL;
        private final long aBM;
        IOException aBN;
        int aBO;
        private volatile Thread aBP;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.aBJ = t;
            this.aBK = aVar;
            this.aBL = i;
            this.aBM = j;
        }

        public final void start(long j) {
            com.google.android.exoplayer2.i.a.ap(r.this.aBI == null);
            r.this.aBI = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public final void an(boolean z) {
            this.released = z;
            this.aBN = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.aBJ.kr();
                if (this.aBP != null) {
                    this.aBP.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.aBK.a(this.aBJ, elapsedRealtime, elapsedRealtime - this.aBM, true);
            }
        }

        public final void run() {
            try {
                this.aBP = Thread.currentThread();
                if (!this.aBJ.ks()) {
                    com.google.android.exoplayer2.i.r.beginSection("load:" + this.aBJ.getClass().getSimpleName());
                    this.aBJ.kt();
                    com.google.android.exoplayer2.i.r.endSection();
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                com.google.android.exoplayer2.i.a.ap(this.aBJ.ks());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Throwable e3) {
                if (!this.released) {
                    obtainMessage(3, new f(e3)).sendToTarget();
                }
            } catch (Throwable e32) {
                if (!this.released) {
                    obtainMessage(3, new f(e32)).sendToTarget();
                }
            } catch (Error e4) {
                if (!this.released) {
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            } catch (Throwable th) {
                com.google.android.exoplayer2.i.r.endSection();
            }
        }

        public final void handleMessage(Message message) {
            if (!this.released) {
                if (message.what == 0) {
                    execute();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.aBM;
                    if (this.aBJ.ks()) {
                        this.aBK.a(this.aBJ, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.aBK.a(this.aBJ, elapsedRealtime, j, false);
                            return;
                        case 2:
                            this.aBK.a(this.aBJ, elapsedRealtime, j);
                            return;
                        case 3:
                            this.aBN = (IOException) message.obj;
                            int a = this.aBK.a(this.aBJ, elapsedRealtime, j, this.aBN);
                            if (a == 3) {
                                r.this.atf = this.aBN;
                                return;
                            } else if (a != 2) {
                                if (a == 1) {
                                    a = 1;
                                } else {
                                    a = this.aBO + 1;
                                }
                                this.aBO = a;
                                start((long) Math.min((this.aBO - 1) * 1000, 5000));
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }

        private void execute() {
            this.aBN = null;
            r.this.aBH.execute(r.this.aBI);
        }

        private void finish() {
            r.this.aBI = null;
        }
    }

    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface c {
        void kr();

        boolean ks();

        void kt();
    }

    private static final class e extends Handler implements Runnable {
        private final d aBR;

        public e(d dVar) {
            this.aBR = dVar;
        }

        public final void run() {
            sendEmptyMessage(0);
        }

        public final void handleMessage(Message message) {
            this.aBR.kC();
        }
    }

    public interface d {
        void kC();
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public r(String str) {
        this.aBH = t.ag(str);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.i.a.ap(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public final boolean id() {
        return this.aBI != null;
    }

    public final void lz() {
        this.aBI.an(false);
    }

    public final boolean a(d dVar) {
        boolean z = false;
        if (this.aBI != null) {
            this.aBI.an(true);
            if (dVar != null) {
                this.aBH.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.kC();
            z = true;
        }
        this.aBH.shutdown();
        return z;
    }

    public final void kd() {
        if (this.atf != null) {
            throw this.atf;
        } else if (this.aBI != null) {
            b bVar = this.aBI;
            int i = this.aBI.aBL;
            if (bVar.aBN != null && bVar.aBO > i) {
                throw bVar.aBN;
            }
        }
    }
}
