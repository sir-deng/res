package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public final class b {

    private static class a implements Runnable {
        private List<Object> mUI;
        private String[] slo;

        public a(String[] strArr, List<Object> list) {
            this.slo = strArr;
            this.mUI = list;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r12 = this;
            r4 = 0;
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r0 = new java.lang.ProcessBuilder;
            r1 = r12.slo;
            r0.<init>(r1);
            r1 = 1;
            r0.redirectErrorStream(r1);
            r8 = com.tencent.mm.sdk.platformtools.bi.Wy();
            r2 = com.tencent.mm.sdk.platformtools.bi.Wy();
            r5 = r0.start();	 Catch:{ IOException -> 0x00ff, InterruptedException -> 0x0096, Exception -> 0x00b9, all -> 0x00dc }
            r0 = r5.getOutputStream();	 Catch:{ IOException -> 0x0106, InterruptedException -> 0x00f5, Exception -> 0x00eb }
            com.tencent.mm.sdk.platformtools.bi.d(r0);	 Catch:{ IOException -> 0x0106, InterruptedException -> 0x00f5, Exception -> 0x00eb }
            r0 = com.tencent.mm.sdk.platformtools.bi.Wy();	 Catch:{ IOException -> 0x0106, InterruptedException -> 0x00f5, Exception -> 0x00eb }
            r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x010e, InterruptedException -> 0x00fa, Exception -> 0x00f0 }
            r2 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x010e, InterruptedException -> 0x00fa, Exception -> 0x00f0 }
            r7 = r5.getInputStream();	 Catch:{ IOException -> 0x010e, InterruptedException -> 0x00fa, Exception -> 0x00f0 }
            r2.<init>(r7);	 Catch:{ IOException -> 0x010e, InterruptedException -> 0x00fa, Exception -> 0x00f0 }
            r7 = 8096; // 0x1fa0 float:1.1345E-41 double:4.0E-320;
            r3.<init>(r2, r7);	 Catch:{ IOException -> 0x010e, InterruptedException -> 0x00fa, Exception -> 0x00f0 }
        L_0x0038:
            r2 = r3.readLine();	 Catch:{ IOException -> 0x0042, InterruptedException -> 0x00fc, Exception -> 0x00f2, all -> 0x00e4 }
            if (r2 == 0) goto L_0x008f;
        L_0x003e:
            r6.append(r2);	 Catch:{ IOException -> 0x0042, InterruptedException -> 0x00fc, Exception -> 0x00f2, all -> 0x00e4 }
            goto L_0x0038;
        L_0x0042:
            r2 = move-exception;
            r4 = r5;
        L_0x0044:
            r5 = "MicroMsg.MMTraceRoute";
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e7 }
            r10 = "run cmd err, io exception: ";
            r7.<init>(r10);	 Catch:{ all -> 0x00e7 }
            r2 = r2.getMessage();	 Catch:{ all -> 0x00e7 }
            r2 = r7.append(r2);	 Catch:{ all -> 0x00e7 }
            r2 = r2.toString();	 Catch:{ all -> 0x00e7 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r2);	 Catch:{ all -> 0x00e7 }
            com.tencent.mm.plugin.traceroute.b.b.a(r4, r3);
        L_0x0061:
            r2 = r12.mUI;
            r3 = r6.toString();
            r2.add(r3);
            r2 = r12.mUI;
            r0 = r0 - r8;
            r0 = java.lang.Long.valueOf(r0);
            r2.add(r0);
            r0 = "MicroMsg.MMTraceRoute";
            r1 = new java.lang.StringBuilder;
            r2 = "stringbuilder: ";
            r1.<init>(r2);
            r2 = r6.toString();
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            return;
        L_0x008f:
            r5.waitFor();	 Catch:{ IOException -> 0x0042, InterruptedException -> 0x00fc, Exception -> 0x00f2, all -> 0x00e4 }
            com.tencent.mm.plugin.traceroute.b.b.a(r5, r3);
            goto L_0x0061;
        L_0x0096:
            r0 = move-exception;
            r5 = r4;
            r11 = r0;
            r0 = r2;
            r2 = r11;
        L_0x009b:
            r3 = "MicroMsg.MMTraceRoute";
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r10 = "run cmd err, interruptedexception: ";
            r7.<init>(r10);	 Catch:{ all -> 0x00e2 }
            r2 = r2.getMessage();	 Catch:{ all -> 0x00e2 }
            r2 = r7.append(r2);	 Catch:{ all -> 0x00e2 }
            r2 = r2.toString();	 Catch:{ all -> 0x00e2 }
            com.tencent.mm.sdk.platformtools.x.e(r3, r2);	 Catch:{ all -> 0x00e2 }
            com.tencent.mm.plugin.traceroute.b.b.a(r5, r4);
            goto L_0x0061;
        L_0x00b9:
            r0 = move-exception;
            r5 = r4;
            r11 = r0;
            r0 = r2;
            r2 = r11;
        L_0x00be:
            r3 = "MicroMsg.MMTraceRoute";
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r10 = "run cmd err: ";
            r7.<init>(r10);	 Catch:{ all -> 0x00e2 }
            r2 = r2.getMessage();	 Catch:{ all -> 0x00e2 }
            r2 = r7.append(r2);	 Catch:{ all -> 0x00e2 }
            r2 = r2.toString();	 Catch:{ all -> 0x00e2 }
            com.tencent.mm.sdk.platformtools.x.e(r3, r2);	 Catch:{ all -> 0x00e2 }
            com.tencent.mm.plugin.traceroute.b.b.a(r5, r4);
            goto L_0x0061;
        L_0x00dc:
            r0 = move-exception;
            r5 = r4;
        L_0x00de:
            com.tencent.mm.plugin.traceroute.b.b.a(r5, r4);
            throw r0;
        L_0x00e2:
            r0 = move-exception;
            goto L_0x00de;
        L_0x00e4:
            r0 = move-exception;
            r4 = r3;
            goto L_0x00de;
        L_0x00e7:
            r0 = move-exception;
            r5 = r4;
            r4 = r3;
            goto L_0x00de;
        L_0x00eb:
            r0 = move-exception;
            r11 = r0;
            r0 = r2;
            r2 = r11;
            goto L_0x00be;
        L_0x00f0:
            r2 = move-exception;
            goto L_0x00be;
        L_0x00f2:
            r2 = move-exception;
            r4 = r3;
            goto L_0x00be;
        L_0x00f5:
            r0 = move-exception;
            r11 = r0;
            r0 = r2;
            r2 = r11;
            goto L_0x009b;
        L_0x00fa:
            r2 = move-exception;
            goto L_0x009b;
        L_0x00fc:
            r2 = move-exception;
            r4 = r3;
            goto L_0x009b;
        L_0x00ff:
            r0 = move-exception;
            r11 = r0;
            r0 = r2;
            r3 = r4;
            r2 = r11;
            goto L_0x0044;
        L_0x0106:
            r0 = move-exception;
            r11 = r0;
            r0 = r2;
            r3 = r4;
            r2 = r11;
            r4 = r5;
            goto L_0x0044;
        L_0x010e:
            r2 = move-exception;
            r3 = r4;
            r4 = r5;
            goto L_0x0044;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.traceroute.b.b.a.run():void");
        }
    }

    static /* synthetic */ void a(Process process, BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.MMTraceRoute", th, "close reader failed", new Object[0]);
            }
        }
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable th2) {
                x.printErrStackTrace("MicroMsg.MMTraceRoute", th2, "destroy process failed", new Object[0]);
            }
        }
    }

    public static String Na(String str) {
        x.i("MicroMsg.MMTraceRoute", "output string: " + str);
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            return null;
        }
        indexOf += 5;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return str.substring(indexOf, indexOf2);
        }
        return null;
    }

    public static int Nb(String str) {
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            return -1;
        }
        indexOf += 4;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return bi.getInt(str.substring(indexOf, indexOf2), 0);
        }
        return -1;
    }

    public static List<Object> A(String[] strArr) {
        String str = " ";
        for (int i = 0; i < 4; i++) {
            str = str + strArr[i] + " ";
        }
        x.i("MicroMsg.MMTraceRoute", str);
        List<Object> arrayList = new ArrayList();
        Runnable aVar = new a(strArr, arrayList);
        e.a(aVar, "MMTraceRouteCMDExecutor_watcher");
        try {
            e.U(aVar);
            x.i("MicroMsg.MMTraceRoute", "watcher thread stopped" + str);
        } catch (InterruptedException e) {
            e.Q(aVar);
            x.i("MicroMsg.MMTraceRoute", "interrupt thread" + str);
        }
        return arrayList;
    }
}
