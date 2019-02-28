package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class a {
    public static boolean gLM = false;
    private static final int[] gLN = new int[]{0, 1, 2, 3};
    private static final int[] gLO = new int[]{0, 1, 2, 3};
    private static final Map<Integer, Integer> gLP;
    private boolean fmm;
    private b gLQ;
    LinkedBlockingQueue<Object> gLR;

    static class a {
        public int delay = 0;
        public int gLT = 0;
        public int gLU = 0;
        public int gLV = 0;
        public int gLW = 0;
        public long gLX = 0;
        public long gLY = 0;
        public long gLZ = 0;
        public int gMa = 0;
        int gMb = 0;
        int gMc = 0;
        public int[] gMd = new int[a.gLN.length];
        public int[] gMe = new int[a.gLO.length];
        public int[] gMf = null;
        public long[] gMg = null;
        public long[] gMh = null;
        public long gMi = 0;
        public int gMj = 0;
        public long gMk = 0;
        public com.tencent.mm.hardcoder.e.a gMl = null;
        public com.tencent.mm.hardcoder.e.a gMm = null;
        public long gMn = 0;
        public long gMo = 0;
        long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;

        a() {
        }

        public final String toString(long j) {
            return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.gLY - j), Long.valueOf(this.startTime - j), Long.valueOf(this.gLZ - j), Integer.valueOf(this.delay), Integer.valueOf(this.gLT), Integer.valueOf(this.scene), Long.valueOf(this.gLX), Integer.valueOf(this.gMa), Integer.valueOf(this.gLU), Integer.valueOf(this.gLV), Integer.valueOf(this.gLW), this.tag});
        }
    }

    static final class b {
        public int aen = 0;
        public long gMo = 0;

        b() {
        }
    }

    static /* synthetic */ void a(a aVar) {
        x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread[%d] running", Long.valueOf(Thread.currentThread().getId()));
        HashSet hashSet = new HashSet();
        long j = 30000;
        ArrayList arrayList = new ArrayList();
        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
        if (myProcCpuTime == null || myProcCpuTime.length < 2) {
            myProcCpuTime = new long[]{0, 0};
            x.i("MicroMsg.HardCoderReporter", "process jiffes info is invalid");
        }
        x.i("MicroMsg.HardCoderReporter", "process:[" + myProcCpuTime[0] + "," + myProcCpuTime[1] + "]");
        HashMap hashMap = new HashMap();
        HashSet hashSet2 = new HashSet();
        a aVar2 = null;
        a aVar3 = null;
        Collection collection = hashSet;
        while (aVar.fmm) {
            int i;
            a aVar4;
            int i2;
            int i3;
            long j2;
            int min;
            long currentTimeMillis = System.currentTimeMillis();
            int size = aVar.gLR.size();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "StartLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j);
            }
            int i4 = 0;
            while (true) {
                if (i4 >= (size == 0 ? 1 : size)) {
                    break;
                }
                Object poll;
                try {
                    poll = aVar.gLR.poll(j, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    x.e("MicroMsg.HardCoder.HCPerfManager", "queueTask poll: " + e.getMessage());
                    poll = null;
                }
                if (poll == null) {
                    break;
                }
                if (!(poll instanceof a)) {
                    if (!(poll instanceof b)) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.fmm = false;
                            break;
                        }
                        Assert.fail("queueTask poll invalid object");
                    } else {
                        i = ((b) poll).aen;
                        if (hashSet2.contains(Integer.valueOf(i))) {
                            hashMap.put(Integer.valueOf(i), (b) poll);
                        }
                    }
                } else {
                    arrayList.add((a) poll);
                    hashSet2.add(Integer.valueOf(((a) poll).hashCode()));
                }
                i4++;
            }
            long j3 = 30000;
            a aVar5 = null;
            a aVar6 = null;
            HashSet hashSet3 = new HashSet();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
            }
            i = 0;
            while (true) {
                int i5 = i;
                if (i5 >= arrayList.size()) {
                    break;
                }
                aVar4 = (a) arrayList.get(i5);
                if (aVar4 != null) {
                    if (hashMap.containsKey(Integer.valueOf(aVar4.hashCode()))) {
                        aVar4.gLZ = currentTimeMillis2;
                        aVar4.gMo = ((b) hashMap.get(Integer.valueOf(aVar4.hashCode()))).gMo;
                        hashMap.remove(Integer.valueOf(aVar4.hashCode()));
                        aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
                        if (HardCoderJNI.hcDebug) {
                            x.i("MicroMsg.HardCoder.HCPerfManager", "reportPerformanceTask:" + aVar4.hashCode());
                        }
                        aVar.gLQ.aq(aVar4);
                    }
                    long j4 = aVar4.gLZ - currentTimeMillis2;
                    if (j4 <= 0) {
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop STOP:" + i5 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                        }
                        arrayList.remove(aVar4);
                        hashSet2.remove(Integer.valueOf(aVar4.hashCode()));
                        i5--;
                    } else {
                        j3 = Math.min(j3, j4);
                        j4 = aVar4.startTime - currentTimeMillis2;
                        if (j4 > 0) {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop WAIT:" + i5 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                            }
                            j3 = Math.min(j3, j4);
                        } else {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop  RUN:" + i5 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                            }
                            if (aVar4.gLU > 0 && (aVar5 == null || aVar5.gLU > aVar4.gLU || (aVar5.gLU == aVar4.gLU && aVar5.gLZ < aVar4.gLZ))) {
                                aVar5 = aVar4;
                            }
                            if (aVar4.gLV > 0 && (aVar6 == null || aVar6.gLV > aVar4.gLV || (aVar6.gLV == aVar4.gLV && aVar6.gLZ < aVar4.gLZ))) {
                                aVar6 = aVar4;
                            }
                            if (aVar4.gLW > 0) {
                                hashSet3.add(aVar4);
                            }
                        }
                    }
                }
                i = i5 + 1;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrCpu:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> MaxCpu:" + (aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrIO:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> MaxIO:" + (aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[]{Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
            }
            if (aVar5 == aVar3 && aVar6 == aVar2 && collection.size() == hashSet3.size()) {
                HashSet hashSet4 = new HashSet();
                hashSet4.addAll(collection);
                hashSet4.removeAll(hashSet3);
                if (hashSet4.isEmpty()) {
                    if (HardCoderJNI.hcDebug) {
                        x.i("MicroMsg.HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
                        j = j3;
                    } else {
                        j = j3;
                    }
                }
            }
            j = 0;
            HashSet hashSet5 = new HashSet();
            hashSet5.addAll(collection);
            hashSet5.removeAll(hashSet3);
            i = hashSet5.size();
            if (i > 0) {
                int[] iArr = new int[i];
                i = 0;
                Iterator it = hashSet5.iterator();
                while (true) {
                    i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar4 = (a) it.next();
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelBindCore task:" + aVar4.toString(currentTimeMillis2));
                    if (aVar4.gLZ > currentTimeMillis2) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.fmm = false;
                            break;
                        }
                        Assert.fail("stopTime:" + (aVar4.gLZ - currentTimeMillis2));
                    }
                    if (aVar4.gLW == 0) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.fmm = false;
                            break;
                        }
                        Assert.fail("bindTid:" + aVar4.gLW);
                    }
                    iArr[i2] = aVar4.gLW;
                    i = i2 + 1;
                }
                if (!gLM && HardCoderJNI.checkEnv) {
                    HardCoderJNI.cancelCpuCoreForThread(iArr, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                }
                aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
            }
            int[] iArr2 = new int[hashSet3.size()];
            Iterator it2 = hashSet3.iterator();
            i2 = 0;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = 0;
            while (it2.hasNext()) {
                aVar4 = (a) it2.next();
                x.i("MicroMsg.HardCoder.HCPerfManager", "requestBindCore task:" + aVar4.toString(currentTimeMillis2));
                if (aVar4.gLZ <= currentTimeMillis2) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.fmm = false;
                        break;
                    }
                    Assert.fail("stopTime:" + (aVar4.gLZ - currentTimeMillis2));
                }
                if (aVar4.gLW == 0) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.fmm = false;
                        break;
                    }
                    Assert.fail("bindTid:" + aVar4.gLW);
                }
                iArr2[i6] = aVar4.gLW;
                i6++;
                i2 = aVar4.scene;
                j = aVar4.gLX;
                i4 = aVar4.gMa;
                i7 = Math.min((int) (aVar4.gLZ - currentTimeMillis2), i7);
                i8 = i4;
            }
            if (aVar6 == null) {
                if (aVar2 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + aVar2.toString(currentTimeMillis2));
                    if (!gLM && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelHighIOFreq(aVar2.gMa, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -2, -1, null);
                }
            } else if (aVar2 != aVar6 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "IOReq:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> " + aVar6.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar6.startTime));
            }
            if (aVar6 != null) {
                i6 = aVar6.gLV;
                i2 = aVar6.scene;
                j = aVar6.gLX;
                i8 = aVar6.gMa;
                i7 = Math.min((int) (aVar6.gLZ - currentTimeMillis2), i7);
            } else {
                i6 = 0;
            }
            if (aVar5 == null) {
                if (aVar3 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + aVar3.toString(currentTimeMillis2));
                    if (!gLM && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelCpuHighFreq(aVar3.gMa, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -1, -2, null);
                }
            } else if (aVar3 != aVar5 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "CPUReq:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> " + aVar5.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar5.startTime));
            }
            if (aVar5 != null) {
                i3 = aVar5.gLU;
                i = aVar5.scene;
                j2 = aVar5.gLX;
                i4 = aVar5.gMa;
                min = Math.min((int) (aVar5.gLZ - currentTimeMillis2), i7);
            } else {
                i = i2;
                min = i7;
                i4 = i8;
                j2 = j;
                i3 = 0;
            }
            if (min < Integer.MAX_VALUE) {
                String str = "MicroMsg.HardCoder.HCPerfManager";
                String str2 = "!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s";
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Long.valueOf(j2);
                objArr[2] = Integer.valueOf(i4);
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = Integer.valueOf(i6);
                objArr[5] = Integer.valueOf(iArr2.length);
                objArr[6] = Integer.valueOf(min);
                objArr[7] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                objArr[8] = aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2);
                objArr[9] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                objArr[10] = aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2);
                x.i(str, String.format(str2, objArr));
                Assert.assertTrue(min > 0);
                boolean z = i > 0 || j2 > 0;
                Assert.assertTrue(z);
                Assert.assertTrue(i4 > 0);
                z = i3 > 0 || i6 > 0 || iArr2.length > 0;
                Assert.assertTrue(z);
                if (!gLM && HardCoderJNI.checkEnv) {
                    HardCoderJNI.requestUnifyCpuIOThreadCore(i, j2, i3, i6, iArr2, min, i4, SystemClock.elapsedRealtimeNanos());
                    i4 = ((Integer) gLP.get(Integer.valueOf(i))).intValue();
                    String str3 = "MicroMsg.HardCoder.HCPerfManager";
                    str = "hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d] running[j %b, c %b]";
                    Object[] objArr2 = new Object[5];
                    objArr2[0] = Integer.valueOf(i);
                    objArr2[1] = Long.valueOf(j2);
                    objArr2[2] = Integer.valueOf(i4);
                    objArr2[3] = Boolean.valueOf(HardCoderJNI.isHCEnable());
                    boolean z2 = HardCoderJNI.checkEnv && HardCoderJNI.isRunning() > 0;
                    objArr2[4] = Boolean.valueOf(z2);
                    x.i(str3, str, objArr2);
                    HardCoderJNI.reportIDKey(false, i4, 1, false);
                }
                aVar.a(currentTimeMillis2, arrayList, i3, i6, iArr2);
            }
            if (gLM) {
                Assert.assertTrue(aVar5 == aVar5);
                Assert.assertTrue(aVar6 == aVar6);
                if (arrayList.isEmpty()) {
                    Assert.assertTrue(j3 == 30000);
                    Assert.assertTrue(min == Integer.MAX_VALUE);
                    Assert.assertTrue(hashSet3.isEmpty());
                    Assert.assertTrue(aVar5 == null);
                    Assert.assertTrue(aVar6 == null);
                }
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    aVar4 = (a) arrayList.get(i2);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoder.HCPerfManager", "CheckTask:" + i2 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                    }
                    boolean z3 = aVar4.gLU > 0 || aVar4.gLV > 0 || aVar4.gLW > 0;
                    Assert.assertTrue(z3);
                    z3 = aVar4.gLX > 0 || aVar4.scene > 0;
                    Assert.assertTrue(z3);
                    Assert.assertTrue("taskInintTime:" + (aVar4.gLY - currentTimeMillis2), aVar4.gLY <= currentTimeMillis2);
                    Assert.assertTrue("taskStopTime:" + (aVar4.gLZ - currentTimeMillis2), aVar4.gLZ >= currentTimeMillis2);
                    Assert.assertTrue("taskHash:" + aVar4.hashCode(), !hashMap.containsKey(Integer.valueOf(aVar4.hashCode())));
                    if (aVar4.startTime > currentTimeMillis2) {
                        Assert.assertTrue(aVar4 != aVar5);
                        Assert.assertTrue(aVar4 != aVar6);
                        Assert.assertTrue(!hashSet3.contains(aVar4));
                        Assert.assertTrue("next:" + j3 + " start:" + (aVar4.startTime - currentTimeMillis2), j3 <= aVar4.startTime - currentTimeMillis2);
                    } else {
                        Assert.assertTrue("nextWake:" + j3 + " stop:" + (aVar4.gLZ - currentTimeMillis2), j3 <= aVar4.gLZ - currentTimeMillis2);
                        String str4 = "reqTimeStamp:" + min;
                        z3 = min > 0 && ((long) min) < Long.MAX_VALUE;
                        Assert.assertTrue(str4, z3);
                        Assert.assertTrue("reqTimeStamp:" + min + " stop:" + (aVar4.gLZ - currentTimeMillis2), ((long) min) <= aVar4.gLZ - currentTimeMillis2);
                        Assert.assertTrue("reqCpu:" + i3 + " task:" + aVar4.gLU, i3 <= aVar4.gLU);
                        Assert.assertTrue("reqIO:" + i6 + " task:" + aVar4.gLV, i6 <= aVar4.gLV);
                        if (aVar4.gLW > 0) {
                            Assert.assertTrue(hashSet3.contains(aVar4));
                            Assert.assertTrue(!hashSet5.contains(aVar4));
                        }
                    }
                    i = i2 + 1;
                }
                j = j3;
                collection = hashSet3;
                aVar2 = aVar6;
                aVar3 = aVar5;
            } else {
                j = j3;
                collection = hashSet3;
                aVar2 = aVar6;
                aVar3 = aVar5;
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        gLP = hashMap;
        hashMap.clear();
        gLP.put(Integer.valueOf(101), Integer.valueOf(1));
        gLP.put(Integer.valueOf(201), Integer.valueOf(2));
        gLP.put(Integer.valueOf(202), Integer.valueOf(3));
        gLP.put(Integer.valueOf(203), Integer.valueOf(4));
        gLP.put(Integer.valueOf(301), Integer.valueOf(5));
        gLP.put(Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING), Integer.valueOf(6));
        gLP.put(Integer.valueOf(401), Integer.valueOf(7));
        gLP.put(Integer.valueOf(HardCoderJNI.SCENE_DB), Integer.valueOf(8));
        gLP.put(Integer.valueOf(601), Integer.valueOf(9));
        gLP.put(Integer.valueOf(602), Integer.valueOf(10));
        gLP.put(Integer.valueOf(603), Integer.valueOf(11));
        gLP.put(Integer.valueOf(701), Integer.valueOf(12));
        gLP.put(Integer.valueOf(702), Integer.valueOf(13));
        gLP.put(Integer.valueOf(703), Integer.valueOf(14));
    }

    public a() {
        this.gLQ = new b();
        this.gLR = new LinkedBlockingQueue();
        this.fmm = false;
        this.fmm = true;
        e.d(new Runnable() {
            public final void run() {
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run start[%d, %s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
                a.a(a.this);
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run end");
            }
        }, "HCPerfManager", 10).start();
        x.i("MicroMsg.HardCoder.HCPerfManager", "hardcoder HCPerfManager new thread[%s]", r0);
        this.gLQ.start();
    }

    private void a(long j, List<a> list, int i, int i2, int[] iArr) {
        this.gLQ.aq(new com.tencent.mm.hardcoder.b.b(j, new ArrayList(list), i, i2, iArr));
    }

    final void reportIDKey(boolean z, int i, int i2, boolean z2) {
        this.gLQ.aq(new com.tencent.mm.hardcoder.b.a(z, i, i2, z2));
    }
}
