package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b implements Runnable {
    private Queue<Object> gMp = new ConcurrentLinkedQueue();
    private g gMq = new g();
    private boolean gMr = false;
    private Thread thread = null;

    public static class a {
        public final boolean fIB;
        public final boolean gMs;
        public final int key;
        public final int value;

        public a(boolean z, int i, int i2, boolean z2) {
            this.gMs = z;
            this.key = i;
            this.value = i2;
            this.fIB = z2;
        }
    }

    public static class b {
        public final int[] gMf;
        public final List<a> gMt;
        public final int gMu;
        public final int gMv;
        public final long time;

        public b(long j, List<a> list, int i, int i2, int[] iArr) {
            this.time = j;
            this.gMt = list;
            this.gMu = i;
            this.gMv = i2;
            this.gMf = iArr;
        }
    }

    public b() {
        this.gMq.initialize();
    }

    public final synchronized void start() {
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.setPriority(5);
            this.thread.start();
        }
    }

    public final void run() {
        x.i("MicroMsg.HCPerfStatThread", "[oneliang]HCPerfStatThread running");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.gMp.isEmpty()) {
                    synchronized (this) {
                        if (this.gMr && this.thread != null) {
                            this.thread.interrupt();
                            this.thread = null;
                            this.gMr = false;
                        }
                        wait();
                    }
                } else {
                    Object poll = this.gMp.poll();
                    if (poll instanceof b) {
                        long[] jArr;
                        b bVar = (b) poll;
                        long j = bVar.time;
                        List list = bVar.gMt;
                        int i = bVar.gMu;
                        int i2 = bVar.gMv;
                        int[] iArr = bVar.gMf;
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoderReporter", "[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s", Long.valueOf(j), Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        Map a = c.a(j, this.gMq);
                        int[] k = com.tencent.mm.hardcoder.e.b.k(a);
                        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
                        if (myProcCpuTime == null) {
                            jArr = new long[]{0, 0};
                        } else {
                            jArr = myProcCpuTime;
                        }
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                continue;
                                break;
                            }
                            a aVar = (a) list.get(i4);
                            if (aVar.gLW != 0) {
                                int[] iArr2;
                                int i5;
                                long j2 = j - aVar.lastUpdateTime;
                                aVar.lastUpdateTime = j;
                                if (i == -1) {
                                    aVar.gMb = 0;
                                    iArr2 = aVar.gMd;
                                    i5 = aVar.gMb;
                                    iArr2[i5] = (int) (((long) iArr2[i5]) + j2);
                                } else if (i == -2) {
                                    iArr2 = aVar.gMd;
                                    i5 = aVar.gMb;
                                    iArr2[i5] = (int) (((long) iArr2[i5]) + j2);
                                } else {
                                    aVar.gMb = i;
                                    iArr2 = aVar.gMd;
                                    iArr2[i] = (int) (((long) iArr2[i]) + j2);
                                }
                                if (i2 == -1) {
                                    aVar.gMc = 0;
                                    iArr2 = aVar.gMe;
                                    i5 = aVar.gMc;
                                    iArr2[i5] = (int) (j2 + ((long) iArr2[i5]));
                                } else if (i2 == -2) {
                                    iArr2 = aVar.gMe;
                                    i5 = aVar.gMc;
                                    iArr2[i5] = (int) (j2 + ((long) iArr2[i5]));
                                } else {
                                    aVar.gMc = i2;
                                    iArr2 = aVar.gMe;
                                    iArr2[i2] = (int) (j2 + ((long) iArr2[i2]));
                                }
                                if (iArr != null && iArr.length > 0) {
                                    aVar.gMf = iArr;
                                }
                                long[] threadCpuJiffies = HardCoderJNI.getThreadCpuJiffies(aVar.gLW);
                                if (threadCpuJiffies == null) {
                                    threadCpuJiffies = new long[]{0, 0};
                                }
                                j2 = HardCoderJNI.getCpuFreqByCoreId(HardCoderJNI.getThreadCoreId(aVar.gLW));
                                if (aVar.gMi == 0) {
                                    aVar.gMi = j2;
                                }
                                if (aVar.gMg == null) {
                                    aVar.gMg = threadCpuJiffies;
                                }
                                if (aVar.gMh == null) {
                                    aVar.gMh = jArr;
                                }
                                aVar.gMi = (j2 + aVar.gMi) / 2;
                                if (threadCpuJiffies != null && aVar.gLW > 0) {
                                    aVar.gMj = (int) ((threadCpuJiffies[0] - aVar.gMg[0]) + (threadCpuJiffies[1] - aVar.gMg[1]));
                                    if (HardCoderJNI.hcDebug) {
                                        x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.gLW + ",start jiffies:[" + aVar.gMg[0] + "," + aVar.gMg[1] + "], end jiffies:[" + threadCpuJiffies[0] + "," + threadCpuJiffies[1] + "],sum thread jiffies:" + aVar.gMj);
                                    }
                                }
                                if (jArr != null && aVar.gLW > 0 && HardCoderJNI.hcDebug) {
                                    aVar.gMk = (jArr[0] - aVar.gMh[0]) + (jArr[1] - aVar.gMh[1]);
                                    x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.gLW + ",process start jiffies:[" + aVar.gMh[0] + "," + aVar.gMh[1] + "], process end jiffies:[" + jArr[0] + "," + jArr[1] + "],sum process jiffies:" + aVar.gMk);
                                }
                                if (aVar.gMl == null && aVar.gMm == null) {
                                    aVar.gMl = new com.tencent.mm.hardcoder.e.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gMG);
                                    if (k[1] < 0) {
                                        x.e("MicroMsg.HCPerfStatThread", "cluster one is unused?may be possible.");
                                        aVar.gMm = null;
                                    } else {
                                        aVar.gMm = new com.tencent.mm.hardcoder.e.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gMG);
                                    }
                                } else {
                                    if (aVar.gMl != null) {
                                        aVar.gMl.l(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gMG);
                                    }
                                    if (aVar.gMm != null) {
                                        aVar.gMm.l(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gMG);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    } else if (poll instanceof a) {
                        d.a((a) poll);
                    } else if (poll instanceof a) {
                        a aVar2 = (a) poll;
                        d.reportIDKey(aVar2.gMs, aVar2.key, aVar2.value, aVar2.fIB);
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HCPerfStatThread", "Performance status thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HCPerfStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    public final void aq(Object obj) {
        if (this.gMp != null) {
            this.gMp.add(obj);
            synchronized (this) {
                notify();
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.gMp = null;
    }
}
