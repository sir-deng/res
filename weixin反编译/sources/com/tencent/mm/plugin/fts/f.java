package com.tencent.mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

public final class f implements l {
    a mOU = new a();

    private class a extends Thread {
        int mOV = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> mOW = new PriorityBlockingQueue();
        volatile boolean mOX = false;
        com.tencent.mm.plugin.fts.a.a.a mOY;
        private boolean mOZ;
        Runnable mPa;
        d mPb;
        boolean mPc = false;
        private int mTid = 0;

        public a() {
            super("SearchDaemon");
        }

        final synchronized void qs(int i) {
            if (this.mOV != i && isAlive()) {
                if (i < 0) {
                    if (this.mOV >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.mOV = i;
                    }
                }
                if (i >= 0) {
                    if (this.mOV < 0) {
                        Process.setThreadPriority(this.mTid, this.mOZ ? 10 : 0);
                    }
                }
                this.mOV = i;
            }
        }

        public final synchronized void quit() {
            this.mOX = true;
            interrupt();
        }

        public final synchronized void fs(boolean z) {
            int i = 0;
            synchronized (this) {
                if (this.mOZ != z) {
                    this.mOZ = z;
                    if (this.mOV >= 0 && isAlive() && this.mTid != 0) {
                        if (this.mOZ) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            x.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.mOZ ? "foreground" : "background"));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", Integer.valueOf(this.mTid), Integer.valueOf(i));
                        }
                    }
                }
            }
            return;
        }

        public final void run() {
            com.tencent.mm.plugin.fts.a.a.a aVar;
            Throwable e;
            Object obj;
            this.mTid = Process.myTid();
            while (true) {
                try {
                    Thread.interrupted();
                    if (this.mOX) {
                        a.aNu();
                        this.mTid = 0;
                        return;
                    }
                    this.mOY = null;
                    com.tencent.mm.plugin.fts.a.a.a aVar2 = (com.tencent.mm.plugin.fts.a.a.a) this.mOW.take();
                    if (aVar2 == null) {
                        a.aNu();
                    } else {
                        try {
                            this.mOY = aVar2;
                            qs(aVar2.getPriority());
                            String name = aVar2.getName();
                            String str;
                            try {
                                String obj2;
                                if (bi.oN(name)) {
                                    obj2 = aVar2.toString();
                                } else {
                                    obj2 = name;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    String format;
                                    int size;
                                    aVar2.execute();
                                    aVar2.mQV = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mQV;
                                    e.u(aVar2.getId(), aVar2.mQV);
                                    e.v(aVar2.getId(), aVar2.mQV);
                                    if (((aVar2.mQW & 1) > 0 ? 1 : 0) != 0 && aVar2.mQV > 1000 && aVar2.mQV < 3600000) {
                                        e.u(27, aVar2.mQV);
                                        e.v(27, aVar2.mQV);
                                    }
                                    if (aVar2 instanceof com.tencent.mm.plugin.fts.a.a.f) {
                                        format = String.format("[%s][Request=%s][Result=%s] Done, %dms", new Object[]{obj2, ((com.tencent.mm.plugin.fts.a.a.f) aVar2).mRy.toString(), ((com.tencent.mm.plugin.fts.a.a.f) aVar2).mRz.toString(), Long.valueOf(aVar2.mQV)});
                                        size = r3.mRz.mRN.size();
                                    } else {
                                        format = String.format("[%s] Done, %dms", new Object[]{obj2, Long.valueOf(aVar2.mQV)});
                                        size = 0;
                                    }
                                    e.h(aVar2.getId(), aVar2.mQV, (long) size);
                                    if (aVar2.mQX == null || aVar2.mQX.size() <= 1) {
                                        try {
                                            str = "";
                                        } catch (Throwable e2) {
                                            aVar = aVar2;
                                            e = e2;
                                            obj = obj2;
                                        }
                                    } else {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        for (int i = 1; i < aVar2.mQX.size(); i++) {
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar3 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mQX.get(i - 1);
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar4 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mQX.get(i);
                                            stringBuffer.append("{");
                                            stringBuffer.append(aVar4.mQZ);
                                            stringBuffer.append(":");
                                            stringBuffer.append(aVar4.timestamp - aVar3.timestamp);
                                            stringBuffer.append("}");
                                        }
                                        str = String.format("%s", new Object[]{stringBuffer.toString()});
                                    }
                                    if (bi.oN(str)) {
                                        str = format;
                                    } else {
                                        str = format + " " + str;
                                    }
                                    name = aVar2.adF();
                                    if (!bi.oN(name)) {
                                        str = str + " " + name;
                                    }
                                    x.i("MicroMsg.FTS.FTSTaskDaemon", str);
                                    a.aNu();
                                } catch (Exception e3) {
                                    throw e3;
                                } catch (Throwable th) {
                                    aVar2.mQV = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mQV;
                                }
                            } catch (Throwable e22) {
                                Throwable th2 = e22;
                                str = name;
                                aVar = aVar2;
                                e = th2;
                                if (aVar != null) {
                                    try {
                                        if (e instanceof InterruptedException) {
                                            if (!aVar.isCancelled()) {
                                                this.mOW.put(aVar);
                                            }
                                            x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", obj, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mQV));
                                        } else if (e instanceof SQLiteDatabaseCorruptException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", obj);
                                            if (this.mPb != null) {
                                                this.mPb.aNx();
                                            }
                                            e.qt(18);
                                            if (!this.mPc) {
                                                g.pWK.c("FTS", aVar + ": " + Log.getStackTraceString(e), null);
                                                this.mPc = true;
                                            }
                                        } else if (e instanceof com.tencent.mm.plugin.fts.a.a.l) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                                            e.qt(6);
                                        } else if (e instanceof SQLiteDiskIOException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                                            e.qt(7);
                                        } else if (e instanceof NullPointerException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                                            e.qt(3);
                                            if (this.mPa != null) {
                                                this.mPa.run();
                                            }
                                        } else if (e instanceof SQLiteException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                                            if (e.getMessage() == null) {
                                            }
                                            e.qt(4);
                                            if (this.mPa != null) {
                                                this.mPa.run();
                                            }
                                        } else {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                                            e.qt(5);
                                            if (this.mPa != null) {
                                                this.mPa.run();
                                            }
                                        }
                                        a.aNu();
                                    } catch (Throwable th3) {
                                        a.aNu();
                                    }
                                } else {
                                    a.aNu();
                                }
                            }
                        } catch (Throwable e222) {
                            aVar = aVar2;
                            e = e222;
                            obj = null;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    obj = null;
                    aVar = null;
                    if (aVar != null) {
                        a.aNu();
                    } else {
                        if (e instanceof InterruptedException) {
                            if (aVar.isCancelled()) {
                                this.mOW.put(aVar);
                            }
                            x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", obj, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mQV));
                        } else if (e instanceof SQLiteDatabaseCorruptException) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", obj);
                            if (this.mPb != null) {
                                this.mPb.aNx();
                            }
                            e.qt(18);
                            if (this.mPc) {
                                g.pWK.c("FTS", aVar + ": " + Log.getStackTraceString(e), null);
                                this.mPc = true;
                            }
                        } else if (e instanceof com.tencent.mm.plugin.fts.a.a.l) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                            e.qt(6);
                        } else if (e instanceof SQLiteDiskIOException) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                            e.qt(7);
                        } else if (e instanceof NullPointerException) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                            e.qt(3);
                            if (this.mPa != null) {
                                this.mPa.run();
                            }
                        } else if (e instanceof SQLiteException) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                            if (e.getMessage() == null && e.getMessage().contains("the connection is read-only")) {
                                e.qt(17);
                            } else {
                                e.qt(4);
                            }
                            if (this.mPa != null) {
                                this.mPa.run();
                            }
                        } else {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", obj);
                            e.qt(5);
                            if (this.mPa != null) {
                                this.mPa.run();
                            }
                        }
                        a.aNu();
                    }
                }
            }
        }
    }

    public final boolean agz() {
        return this.mOU != null && this.mOU.isAlive();
    }

    public final void quit() {
        if (this.mOU != null && this.mOU.isAlive()) {
            this.mOU.quit();
            try {
                this.mOU.join();
            } catch (InterruptedException e) {
            }
            this.mOU = null;
            x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(int i, com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (this.mOU == null) {
            return null;
        }
        aVar.mPriority = i;
        a aVar2 = this.mOU;
        if (aVar2.mOX) {
            return aVar;
        }
        int priority = aVar.getPriority();
        aVar2.mOW.put(aVar);
        if (aVar2.mOY == null) {
            aVar2.qs(priority);
            return aVar;
        } else if (priority >= aVar2.mOV) {
            return aVar;
        } else {
            aVar2.interrupt();
            aVar2.qs(priority);
            return aVar;
        }
    }
}
