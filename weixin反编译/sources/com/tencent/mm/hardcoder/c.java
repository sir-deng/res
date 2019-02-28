package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class c implements Runnable {
    private g gMq;
    private Set<Integer> gMw;
    private e gMx;
    private long gMy;
    private long gMz;

    public static class a {
        public final int gME;
        public final long gMF;
        public final int gMG;
        public final long startTime;

        public a(long j, int i, long j2, int i2) {
            this.startTime = j;
            this.gME = i;
            this.gMF = j2;
            this.gMG = i2;
        }

        public final String toString() {
            return String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[]{Long.valueOf(this.startTime), Integer.valueOf(this.gME), Long.valueOf(this.gMF), Integer.valueOf(this.gMG)});
        }
    }

    public static class b {
        public final Map<Integer, a> gMH;
        public final Map<Integer, c> gMI;
        public final long time;

        public b(long j, Map<Integer, a> map, Map<Integer, c> map2) {
            this.time = j;
            this.gMH = map;
            this.gMI = map2;
        }
    }

    public static class c {
        public final int gMJ;
        public final int gMK;
        public final long gML;
        public long gMM = 0;
        public final long[] gMg;
        public long gMi = 0;
        public final long startTime;

        public c(int i, long j, int i2, long j2, long[] jArr) {
            this.gMJ = i;
            this.startTime = j;
            this.gMK = i2;
            this.gML = j2;
            this.gMg = jArr;
            this.gMi = this.gML;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[]{Integer.valueOf(this.gMJ), Long.valueOf(this.startTime), Integer.valueOf(this.gMK), Long.valueOf(this.gML)}));
            stringBuilder.append(String.format(",sumJiffies:%s", new Object[]{Long.valueOf(this.gMM)}));
            return stringBuilder.toString();
        }
    }

    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis < this.gMy || currentTimeMillis > this.gMz) {
                    synchronized (this) {
                        wait(60000);
                        x.i("MicroMsg.HardCoderMonitor", "Monitor thread wait(no in time):60000");
                    }
                } else {
                    Object obj;
                    int intValue;
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "get cpu current freq,begin:" + SystemClock.elapsedRealtime());
                    }
                    Map a = a(currentTimeMillis, this.gMq);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "get cpu current freq,end:" + SystemClock.elapsedRealtime());
                    }
                    Collection hashSet = new HashSet();
                    File file = new File("/proc/" + Process.myPid() + "/task");
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            obj = 1;
                        } else {
                            if (HardCoderJNI.hcDebug) {
                                x.i("MicroMsg.HardCoderMonitor", "thread size:" + listFiles.length);
                            }
                            for (File file2 : listFiles) {
                                try {
                                    hashSet.add(Integer.valueOf(bi.getInt(file2.getName(), 0)));
                                } catch (Exception e) {
                                    x.e("MicroMsg.HardCoderMonitor", "integer parse error:" + e.getMessage());
                                } catch (InterruptedException e2) {
                                    x.e("MicroMsg.HardCoderMonitor", "Monitor thread need to interrupt:" + e2.getMessage());
                                    Thread.currentThread().interrupt();
                                    return;
                                }
                            }
                            obj = null;
                        }
                    } else {
                        x.e("MicroMsg.HardCoderMonitor", "impossible as usual");
                        int obj2 = 1;
                    }
                    Map treeMap = new TreeMap();
                    this.gMw.addAll(hashSet);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "get thread current stat,end:" + SystemClock.elapsedRealtime());
                    }
                    if (obj2 != null) {
                        synchronized (this) {
                            wait(60000);
                            x.i("MicroMsg.HardCoderMonitor", "Monitor thread wait(pid/task error):60000");
                        }
                    } else if (this.gMw.isEmpty()) {
                        synchronized (this) {
                            wait();
                        }
                    } else {
                        for (Integer intValue2 : this.gMw) {
                            intValue = intValue2.intValue();
                            long[] threadCpuJiffies = HardCoderJNI.getThreadCpuJiffies(intValue);
                            int threadCoreId = HardCoderJNI.getThreadCoreId(intValue);
                            long cpuFreqByCoreId = HardCoderJNI.getCpuFreqByCoreId(threadCoreId);
                            if (treeMap.containsKey(Integer.valueOf(intValue))) {
                                treeMap.get(Integer.valueOf(intValue));
                            } else {
                                treeMap.put(Integer.valueOf(intValue), new c(intValue, currentTimeMillis, threadCoreId, cpuFreqByCoreId, threadCpuJiffies));
                            }
                        }
                        e eVar = this.gMx;
                        b bVar = new b(currentTimeMillis, a, treeMap);
                        if (eVar.gMO != null) {
                            eVar.gMO.add(bVar);
                            synchronized (eVar) {
                                eVar.notify();
                            }
                        }
                        synchronized (this) {
                            wait(50);
                        }
                    }
                }
            } catch (InterruptedException e22) {
                x.e("MicroMsg.HardCoderMonitor", "Monitor thread need to interrupt:" + e22.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e3) {
                x.e("MicroMsg.HardCoderMonitor", "exception:" + e3.getMessage());
            }
        }
    }

    public static Map<Integer, a> a(long j, g gVar) {
        Exception e;
        InputStream inputStream;
        Throwable th;
        final Map<Integer, a> treeMap = new TreeMap();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors; i++) {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                final g gVar2 = gVar;
                final long j2 = j;
                com.tencent.mm.hardcoder.f.a anonymousClass1 = new com.tencent.mm.hardcoder.f.a() {
                    public final boolean ff(String str) {
                        int intValue;
                        a aVar;
                        long j = bi.getLong(str.trim(), 0);
                        if (gVar2.gMX.containsKey(Integer.valueOf(i))) {
                            Integer num = (Integer) ((com.tencent.mm.hardcoder.g.a) gVar2.gMX.get(Integer.valueOf(i))).gNd.get(Long.valueOf(j));
                            if (num != null) {
                                intValue = num.intValue();
                                aVar = new a(j2, i, j, intValue);
                                treeMap.put(Integer.valueOf(i), aVar);
                                if (HardCoderJNI.hcDebug) {
                                    x.d("MicroMsg.HardCoderMonitor", aVar.toString());
                                }
                                return false;
                            }
                        }
                        intValue = 0;
                        aVar = new a(j2, i, j, intValue);
                        treeMap.put(Integer.valueOf(i), aVar);
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoderMonitor", aVar.toString());
                        }
                        return false;
                    }
                };
                try {
                    InputStream fileInputStream = new FileInputStream(absolutePath);
                    try {
                        f.a(fileInputStream, anonymousClass1);
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            x.e("MicroMsg.HardCoderUtil", "exception:" + e2.getMessage());
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        inputStream = fileInputStream;
                        try {
                            x.e("MicroMsg.HardCoderUtil", "exception:" + e2.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e22) {
                                    x.e("MicroMsg.HardCoderUtil", "exception:" + e22.getMessage());
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = fileInputStream;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    inputStream = null;
                    x.e("MicroMsg.HardCoderUtil", "exception:" + e22.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
        }
        return treeMap;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e5) {
                x.e("MicroMsg.HardCoderUtil", "exception:" + e5.getMessage());
            }
        }
        throw th;
        throw th;
    }

    protected final void finalize() {
        super.finalize();
        this.gMw = null;
        this.gMq = null;
        this.gMx = null;
    }
}
