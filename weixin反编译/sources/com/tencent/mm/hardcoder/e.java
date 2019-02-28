package com.tencent.mm.hardcoder;

import com.tencent.mm.hardcoder.c.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public final class e implements Runnable {
    Queue<com.tencent.mm.hardcoder.c.b> gMO;
    private b gMP;
    private Deque<b> gMQ;
    private boolean gMr;
    private Thread thread;

    public static class a {
        public final long gMR;
        public final long gMS;
        public long gMT = 0;
        public long gMU = 0;

        public a(long j, long j2) {
            this.gMR = j;
            this.gMS = j2;
            this.gMT = this.gMR;
            this.gMU = this.gMS;
        }

        public final void l(long j, long j2) {
            this.gMT = (this.gMT + j) / 2;
            this.gMU = (this.gMU + j2) / 2;
        }

        public final String toString() {
            return String.format("startFreq:%s,startPower:%s,averageFreq:%s,averagePower:%s", new Object[]{Long.valueOf(this.gMR), Long.valueOf(this.gMS), Long.valueOf(this.gMT), Long.valueOf(this.gMU)});
        }
    }

    public static class b {
        public final Map<Integer, com.tencent.mm.hardcoder.c.a> gMH;
        public final Map<Integer, c> gMV = new TreeMap();
        public long gMW = 0;
        public final a gMl;
        public final a gMm;
        public final long startTime;

        public b(long j, Map<Integer, com.tencent.mm.hardcoder.c.a> map, Map<Integer, c> map2) {
            int[] k = k(map);
            this.gMH = map;
            this.gMl = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gMG);
            if (k[1] < 0) {
                x.e("MicroMsg.HardCoderStatThread", "cluster one is unused?may be possible.");
                this.gMm = null;
            } else {
                this.gMm = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gMG);
            }
            this.startTime = j;
            this.gMW = this.startTime;
            l(map2);
        }

        public static int[] k(Map<Integer, com.tencent.mm.hardcoder.c.a> map) {
            if (map == null) {
                throw new NullPointerException("cpuStatusMap can not be null");
            }
            int i;
            int i2;
            for (i = g.gMZ; i >= 0; i--) {
                if (map.containsKey(Integer.valueOf(i))) {
                    i2 = i;
                    break;
                }
            }
            i2 = -1;
            if (i2 < 0) {
                throw new NullPointerException("cluster zero is unused?impossible.");
            }
            i = g.gNa;
            while (i > g.gMZ) {
                if (map.containsKey(Integer.valueOf(i))) {
                    break;
                }
                i--;
            }
            i = -1;
            return new int[]{i2, i};
        }

        final void l(Map<Integer, c> map) {
            if (map == null) {
                throw new NullPointerException("threadStatusMap can not be null");
            }
            for (Integer num : map.keySet()) {
                c cVar;
                c cVar2 = (c) map.get(num);
                if (this.gMV.containsKey(num)) {
                    cVar = (c) this.gMV.get(num);
                } else {
                    cVar = new c(cVar2.gMJ, cVar2.startTime, cVar2.gMK, cVar2.gML, cVar2.gMg);
                    this.gMV.put(num, cVar);
                }
                long j = cVar2.gML;
                long[] jArr = cVar2.gMg;
                cVar.gMi = (j + cVar.gMi) / 2;
                if (jArr != null) {
                    cVar.gMM = (jArr[0] - cVar.gMg[0]) + (jArr[1] - cVar.gMg[1]);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "thread id:" + cVar.gMJ + ",start jiffies:[" + cVar.gMg[0] + "," + cVar.gMg[1] + "], end jiffies:[" + jArr[0] + "," + jArr[1] + "]");
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("startTime:%s,updateTime:%s", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.gMW)}));
            stringBuilder.append(",");
            stringBuilder.append(this.gMl);
            if (this.gMm != null) {
                stringBuilder.append(",");
                stringBuilder.append(this.gMm);
            }
            stringBuilder.append(",");
            stringBuilder.append(this.gMV.toString());
            return stringBuilder.toString();
        }
    }

    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.gMO.isEmpty()) {
                    synchronized (this) {
                        if (this.gMr) {
                            x.i("MicroMsg.HardCoderStatThread", "snapshotStatDeque size:" + this.gMQ.size());
                            if (this.thread != null) {
                                this.thread.interrupt();
                                this.thread = null;
                                this.gMr = false;
                            }
                        }
                        wait();
                    }
                } else {
                    com.tencent.mm.hardcoder.c.b bVar = (com.tencent.mm.hardcoder.c.b) this.gMO.poll();
                    if (bVar != null) {
                        b bVar2;
                        long j = bVar.time;
                        Map map = bVar.gMH;
                        Map map2 = bVar.gMI;
                        if (this.gMP == null) {
                            this.gMP = new b(j, map, map2);
                        } else {
                            bVar2 = this.gMP;
                            int[] k = b.k(map);
                            bVar2.gMW = j;
                            bVar2.gMl.l(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gMG);
                            if (bVar2.gMm != null) {
                                bVar2.gMm.l(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gMF, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gMG);
                            }
                            bVar2.l(map2);
                        }
                        x.i("MicroMsg.HardCoderStatThread", this.gMP.toString());
                        bVar2 = new b(j, map, map2);
                        b bVar3 = (b) this.gMQ.peekFirst();
                        b bVar4 = (b) this.gMQ.peekLast();
                        if (bVar3 == null || bVar4 == null) {
                            this.gMQ.add(bVar2);
                        } else {
                            if (bVar4.startTime - bVar3.startTime >= 30000) {
                                this.gMQ.removeFirst();
                            }
                            this.gMQ.add(bVar2);
                        }
                    } else {
                        continue;
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HardCoderStatThread", "Stat thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HardCoderStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.gMO = null;
        this.gMP = null;
        this.gMQ = null;
    }
}
