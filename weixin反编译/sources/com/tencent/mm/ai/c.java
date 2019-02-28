package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bv;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c implements Runnable {
    int hwn = 0;
    private d hwo = null;
    b hwp = new b();
    private long hwq = 0;
    private long hwr = 0;
    private long hws = 0;
    String hwt = null;
    private String hwu = null;
    boolean hwv = false;

    static class a implements Serializable {
        long hwf = 0;
        long time = 0;
        int type = 0;

        a(long j, long j2, int i) {
            this.hwf = j;
            this.time = j2;
            this.type = i;
        }

        public final String toString() {
            return String.format("serverTime:%s,time:%s,type:%s", new Object[]{a.bd(this.hwf), a.bd(this.time), Integer.valueOf(this.type)});
        }
    }

    static class c implements Serializable {
        long hwA = 0;
        long hwf = 0;
        long hwk = 0;
        long hwl = 0;
        long hwm = 0;
        int pid = 0;

        c(int i, long j, long j2, long j3, long j4, long j5) {
            this.pid = i;
            this.hwf = j;
            this.hwA = j2;
            this.hwk = j3;
            this.hwl = j4;
            this.hwm = j5;
        }

        public final String toString() {
            return String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[]{Integer.valueOf(this.pid), a.bd(this.hwf), a.bd(this.hwA), a.bd(this.hwk), Long.valueOf(this.hwl), Long.valueOf(this.hwm)});
        }
    }

    static class b implements Serializable {
        final List<d> hww = new CopyOnWriteArrayList();
        final List<a> hwx = new CopyOnWriteArrayList();
        final List<a> hwy = new CopyOnWriteArrayList();
        final List<c> hwz = new CopyOnWriteArrayList();

        b() {
        }
    }

    public static class d implements Serializable {
        long endTime = 0;
        long hwB = 0;
        int hwg = 0;
        boolean hwh = true;
        boolean hwi = false;
        int pid = 0;
        long startTime = 0;

        final void a(int i, long j, long j2, int i2) {
            this.pid = i;
            if (this.startTime <= 0) {
                this.startTime = j;
                this.hwB = bv.Ik();
            }
            this.endTime = j2;
            this.hwg = i2;
        }

        static d b(int i, long j, long j2, int i2) {
            d dVar = new d();
            dVar.pid = i;
            dVar.startTime = j;
            dVar.endTime = j2;
            dVar.hwg = i2;
            return dVar;
        }

        public final String toString() {
            return String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[]{Integer.valueOf(this.pid), a.bd(this.hwB), a.bd(this.startTime), a.bd(this.endTime), Boolean.valueOf(this.hwh), Boolean.valueOf(this.hwi), Integer.valueOf(this.hwg)});
        }
    }

    c() {
        if (this.hwt == null) {
            this.hwt = com.tencent.mm.loader.stub.a.hbv + "ProcessDetector";
            File file = new File(this.hwt);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (ad.cgj()) {
            this.hwu = this.hwt + "/mm";
        } else if (ad.cgk()) {
            this.hwu = this.hwt + "/push";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r12.clear();
        r0 = java.lang.System.currentTimeMillis();
        r12.hwr = r0;
        r0 = r12.hwr;
        r12.hws = r0;
        r0 = new com.tencent.mm.ai.c$d;
        r0.<init>();
        r12.hwo = r0;
        r0 = r12.hwo;
        r1 = android.os.Process.myPid();
        r2 = r12.hwr;
        r4 = r12.hws;
        r6 = r12.hwn;
        r0.a(r1, r2, r4, r6);
        r0 = r12.hwp;
        r0 = r0.hww;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0059;
    L_0x002d:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x01a4 }
        r1 = r12.hwu;	 Catch:{ Exception -> 0x01a4 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x01a4 }
        r0 = com.tencent.mm.ai.b.h(r0);	 Catch:{ Exception -> 0x01a4 }
        r0 = (com.tencent.mm.ai.c.b) r0;	 Catch:{ Exception -> 0x01a4 }
        if (r0 == 0) goto L_0x0059;
    L_0x003c:
        r1 = r0.hwx;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.hwp;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.hwx;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r1 = r0.hwy;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.hwp;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.hwy;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r1 = r0.hwz;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.hwp;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.hwz;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r12.hwp = r0;	 Catch:{ Exception -> 0x01a4 }
    L_0x0059:
        r0 = r12.hwp;
        a(r0);
        r0 = r12.hwp;
        r0 = r0.hww;
        r1 = r12.hwo;
        r0.add(r1);
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]exist process status data size:%s,send broadcast size:%s, receive broadcast size:%s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.hwp;
        r4 = r4.hww;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.hwp;
        r4 = r4.hwx;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r12.hwp;
        r4 = r4.hwy;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
    L_0x00a0:
        r0 = r12.hwv;
        if (r0 == 0) goto L_0x02cb;
    L_0x00a4:
        r0 = java.lang.Thread.currentThread();
        r0 = r0.isInterrupted();
        if (r0 != 0) goto L_0x02cb;
    L_0x00ae:
        r1 = android.os.Process.myPid();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.hwo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = r12.hws;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r12.hwn;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r8 = r4 - r2;
        r7 = r0.hwg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r7 != r6) goto L_0x00c8;
    L_0x00c2:
        r10 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x01c9;
    L_0x00c8:
        r1 = com.tencent.mm.ai.c.d.b(r1, r2, r4, r6);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.hwg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == r6) goto L_0x00d3;
    L_0x00d0:
        r0 = 1;
        r1.hwi = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00d3:
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00dc;
    L_0x00d9:
        r0 = 0;
        r1.hwh = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00dc:
        r0 = r1;
    L_0x00dd:
        if (r0 == 0) goto L_0x01cf;
    L_0x00df:
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = "[oneliang]create process status:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = 0;
        r3[r6] = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r12.hwo = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.hww;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r1 = r12.hwo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0.add(r1);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00f9:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]send broadcast:%s,receive broadcast:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r6 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r6.hwx;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 1;
        r6 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r6.hwy;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r12.hws = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.hwq;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0128;
    L_0x011d:
        r0 = r12.hwq;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r4 - r0;
        r2 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0179;
    L_0x0128:
        r12.hwq = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x013e;
    L_0x012e:
        r0 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.hww;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x013e;
    L_0x0134:
        r0 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.hww;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x01f8;
    L_0x013e:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]one 3*minute per log, current process status:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.hwo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.hwx;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.size();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 1;
        r4 = r12.hwp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.hwy;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.size();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x0179:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x00a0;
    L_0x0180:
        r0 = move-exception;
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "process detector thread interrupt.thread id:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = android.os.Process.myTid();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = 0;
        r12.hwv = r0;
        goto L_0x00a0;
    L_0x01a4:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = new java.lang.StringBuilder;
        r3 = "%s,read exception:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.hwu;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r1, r0, r2);
        goto L_0x0059;
    L_0x01c9:
        r0.a(r1, r2, r4, r6);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = 0;
        goto L_0x00dd;
    L_0x01cf:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]current process status:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r6 = r12.hwo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x00f9;
    L_0x01e2:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = "exception,%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r0.getMessage();
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x00a0;
    L_0x01f8:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]save data to %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.hwu;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.hwp;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r12.hwu;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        if (r0 == 0) goto L_0x013e;
    L_0x0214:
        r2 = 0;
        r1 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0267, all -> 0x02a7 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0267, all -> 0x02a7 }
        r1.writeObject(r0);	 Catch:{ Exception -> 0x02ce }
        r1.flush();	 Catch:{ Exception -> 0x02ce }
        r1.close();	 Catch:{ Exception -> 0x0225, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x0225:
        r0 = move-exception;
        r1 = "MicroMsg.ObjectUtil";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = "Write close exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x0242:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = "%s,write exception:";
        r2.<init>(r3);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.getMessage();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r2.append(r0);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.toString();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.hwu;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.e(r1, r0, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x013e;
    L_0x0267:
        r0 = move-exception;
        r1 = r2;
    L_0x0269:
        r2 = "MicroMsg.ObjectUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02cc }
        r4 = "Write exception:";
        r3.<init>(r4);	 Catch:{ all -> 0x02cc }
        r0 = r0.getMessage();	 Catch:{ all -> 0x02cc }
        r0 = r3.append(r0);	 Catch:{ all -> 0x02cc }
        r0 = r0.toString();	 Catch:{ all -> 0x02cc }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x02cc }
        if (r1 == 0) goto L_0x013e;
    L_0x0285:
        r1.close();	 Catch:{ Exception -> 0x028a, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x028a:
        r0 = move-exception;
        r1 = "MicroMsg.ObjectUtil";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = "Write close exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x02a7:
        r0 = move-exception;
        r1 = r2;
    L_0x02a9:
        if (r1 == 0) goto L_0x02ae;
    L_0x02ab:
        r1.close();	 Catch:{ Exception -> 0x02af, InterruptedException -> 0x0180 }
    L_0x02ae:
        throw r0;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
    L_0x02af:
        r1 = move-exception;
        r2 = "MicroMsg.ObjectUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r4 = "Write close exception:";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x02ae;
    L_0x02cb:
        return;
    L_0x02cc:
        r0 = move-exception;
        goto L_0x02a9;
    L_0x02ce:
        r0 = move-exception;
        goto L_0x0269;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ai.c.run():void");
    }

    final void clear() {
        this.hwv = false;
        this.hwr = 0;
        this.hws = 0;
    }

    private static void a(b bVar) {
        if (bVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                for (d dVar : bVar.hww) {
                    if (dVar != null) {
                        if (currentTimeMillis - dVar.endTime < 86400000) {
                            break;
                        }
                        bVar.hww.remove(dVar);
                    } else {
                        bVar.hww.remove(dVar);
                    }
                }
                for (a aVar : bVar.hwx) {
                    if (aVar != null) {
                        if (currentTimeMillis - aVar.time < 86400000) {
                            break;
                        }
                        bVar.hwx.remove(aVar);
                    } else {
                        bVar.hwx.remove(aVar);
                    }
                }
                for (a aVar2 : bVar.hwy) {
                    if (aVar2 != null) {
                        if (currentTimeMillis - aVar2.time < 86400000) {
                            break;
                        }
                        bVar.hwy.remove(aVar2);
                    } else {
                        bVar.hwy.remove(aVar2);
                    }
                }
                for (c cVar : bVar.hwz) {
                    if (cVar == null) {
                        bVar.hwz.remove(cVar);
                    } else if (currentTimeMillis - cVar.hwA >= 86400000) {
                        bVar.hwz.remove(cVar);
                    } else {
                        return;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e, "check data exception.", new Object[0]);
            }
        }
    }
}
