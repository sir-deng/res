package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.u;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.bz;
import com.tencent.recovery.Recovery;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i implements c, d {
    private static final String ffG;
    private static final String ffH;
    private static String ffI = "";
    private static final String ffJ = ("version:" + com.tencent.mm.protocal.d.vHl);
    private static long[] ffK = new long[]{0, 0, 0};
    public static final long ffy = bi.Wy();
    private a ffA;
    private volatile long ffB = 0;
    HashSet<String> ffC;
    String ffD;
    String ffE;
    ConditionVariable ffF;
    volatile b ffL;
    private ak ffz = null;

    private class a extends FileObserver {
        a(String str) {
            super(str, 712);
        }

        public final void onEvent(int i, String str) {
            Object obj = null;
            if (System.currentTimeMillis() - i.this.ffB < 120000) {
                obj = 1;
            }
            if (obj == null) {
                synchronized (i.this.ffC) {
                    switch (i) {
                        case 8:
                            x.i("MicroMsg.MMCrashReporter", "Detected trace file changed: " + str);
                            i.this.ffF.open();
                            if (i.this.ffL == null) {
                                i.this.ffL = new b(i.this, (byte) 0);
                                e.post(i.this.ffL, "MMCrashReporter_parseANRTrace");
                                break;
                            }
                            break;
                        case 64:
                        case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                            i.this.ffC.remove(str);
                            break;
                        case FileUtils.S_IWUSR /*128*/:
                            break;
                    }
                    i.this.ffC.add(str);
                }
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b) {
            this();
        }

        private static ProcessErrorStateInfo tX() {
            List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) ad.getContext().getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return null;
            }
            for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        }

        public final void run() {
            ArrayList arrayList;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ProcessErrorStateInfo processErrorStateInfo = null;
            while (i.this.ffF.block(10000)) {
                i.this.ffF.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                processErrorStateInfo = tX();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null) {
                processErrorStateInfo = tX();
                if (processErrorStateInfo == null) {
                    x.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                    i.this.ffL = null;
                    return;
                }
            }
            ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
            x.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
            synchronized (i.this.ffC) {
                arrayList = new ArrayList(i.this.ffC.size());
                int lastIndexOf = i.this.ffE.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str = i.this.ffE.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + i.this.ffE.substring(lastIndexOf);
                    if (i.this.ffC.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (i.this.ffC.remove(i.this.ffE)) {
                    arrayList.add(i.this.ffE);
                }
                arrayList.addAll(i.this.ffC);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str = i.a(i.this.ffD + '/' + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
                if (str != null) {
                    x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", r0);
                    i.this.r(str, processErrorStateInfo2.pid);
                    break;
                }
                x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", r0);
            }
            x.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            i.this.ffL = null;
        }
    }

    static {
        String yM = q.yM();
        ffG = yM;
        ffH = o.getString(yM.hashCode());
    }

    private static String tU() {
        String H = ar.hhz.H("login_weixin_username", "");
        if (bi.oN(H)) {
            return ar.hhz.H("login_user_name", "never_login_crash");
        }
        return H;
    }

    public static boolean cq(String str) {
        Object obj = null;
        ffI = str;
        if (com.tencent.mm.pluginsdk.q.x.bYQ() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ad.getContext().getClassLoader());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + ffI);
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + ffI);
            Class fq = com.tencent.mm.bl.d.fq("sandbox", ".SubCoreSandBox");
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + fq + " thisProcName: " + ffI);
            if (fq != null) {
                try {
                    u uVar = (u) fq.newInstance();
                    com.tencent.mm.pluginsdk.q.x.a(uVar);
                    x.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + uVar + " thisProcName: " + ffI);
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    x.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        c cVar;
        try {
            cVar = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar.ap(ad.getContext());
            ar.hhz.H("last_login_uin", ffH);
            com.tencent.mm.sdk.a.b.a(cVar);
            AnonymousClass1 anonymousClass1 = new Object() {
            };
            return true;
        } catch (Exception e4) {
            x.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            cVar = new i();
            cVar.ap(ad.getContext());
            com.tencent.mm.sdk.a.b.a(cVar);
            String str2 = y.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                k.b("wechatCrashForJni", i.class.getClassLoader());
                CrashMonitorForJni.setClientVersionMsg(ffJ);
            }
            bz.ig(com.tencent.mm.compatible.util.e.hbv);
            return false;
        }
    }

    public static void a(ak.c cVar) {
        ak.a(cVar);
    }

    private static void cr(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    break;
                }
                x.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.MMCrashReporter", str);
    }

    public final void ap(final Context context) {
        Throwable e;
        BufferedReader bufferedReader;
        ak.a((d) this);
        if (ffI.endsWith(":push")) {
            String str;
            try {
                str = y.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.ffD = file.getParent();
            if (this.ffD == null || this.ffD.length() == 0) {
                this.ffD = "/";
            }
            this.ffE = file.getName();
            this.ffF = new ConditionVariable();
            x.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: " + str);
            this.ffC = new HashSet();
            this.ffA = new a(this.ffD);
            this.ffA.startWatching();
            File[] listFiles = new File(context.getFilesDir(), "crash").listFiles(new FilenameFilter() {
                String ffM = context.getPackageName();

                public final boolean accept(File file, String str) {
                    return str.startsWith(this.ffM);
                }
            });
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (File file2 : listFiles) {
                    int i = -1;
                    x.i("MicroMsg.MMCrashReporter", "Uploading previous crash: " + file2);
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            stringBuilder.setLength(0);
                            while (true) {
                                Object readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = bi.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append(10);
                            }
                            if (stringBuilder.toString().startsWith(ffJ)) {
                                String substring = stringBuilder.toString().substring(stringBuilder.toString().indexOf(ffJ) + ffJ.length());
                                if (substring != null && substring.trim().length() > 0) {
                                    b(i, substring, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                file2.delete();
                            } catch (Throwable th) {
                                e2 = th;
                            }
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedReader = null;
                        x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        file2.delete();
                    } catch (Throwable th2) {
                        e2 = th2;
                        bufferedReader = null;
                    }
                    file2.delete();
                }
                return;
            }
            return;
        }
        return;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
            }
        }
        throw e2;
        throw e2;
    }

    public final void z(String str, String str2) {
        if (com.tencent.mm.pluginsdk.q.x.bYQ() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", tU());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            com.tencent.mm.pluginsdk.q.x.bYQ().r(ad.getContext(), intent);
        }
    }

    public final void a(com.tencent.mm.sdk.a.a aVar) {
        ak.a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.platformtools.ak r8, java.lang.String r9, java.lang.Throwable r10) {
        /*
        r7 = this;
        r6 = 0;
        r2 = "";
        r0 = r10 instanceof junit.framework.AssertionFailedError;
        if (r0 == 0) goto L_0x0072;
    L_0x0008:
        r3 = r10.getMessage();
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 != 0) goto L_0x0072;
    L_0x0012:
        r0 = r8.xoe;
        r0 = r0.entrySet();
        r4 = r0.iterator();
        if (r4 == 0) goto L_0x006e;
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x006e;
    L_0x0024:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x001e;
    L_0x0036:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x001e;
    L_0x003c:
        r1 = r3.startsWith(r1);
        if (r1 == 0) goto L_0x001e;
    L_0x0042:
        r0 = r0.getValue();
        r0 = (com.tencent.mm.sdk.platformtools.ak.b) r0;
        r0 = r0.IU();
    L_0x004c:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 != 0) goto L_0x0072;
    L_0x0052:
        com.tencent.mm.app.n.b(r10);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = cs(r0);
        r0 = r1.append(r0);
        r0 = r0.append(r9);
        r0 = r0.toString();
        b(r0, r6, r6);
        return;
    L_0x006e:
        r0 = "";
        goto L_0x004c;
    L_0x0072:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.i.a(com.tencent.mm.sdk.platformtools.ak, java.lang.String, java.lang.Throwable):void");
    }

    private static void b(String str, int i, boolean z) {
        cr(str);
        g.pWK.a(11338, true, true, Integer.valueOf(2));
        g.pWK.a(25, 0, 1, true);
        if (ad.By().endsWith(":push")) {
            g.pWK.a(25, 2, 1, true);
        } else if (ad.By().endsWith(":tools")) {
            g.pWK.a(25, 3, 1, true);
        } else if (ad.By().endsWith(":exdevice")) {
            g.pWK.a(25, 4, 1, true);
        } else if (ad.cgj()) {
            g.pWK.a(25, 1, 1, true);
        }
        g gVar = g.pWK;
        g.boV();
        if (e.an(ad.getContext()) == 1) {
            int ao = e.ao(ad.getContext());
            x.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", Integer.valueOf(ao));
            if (str.length() > ao) {
                str = str.substring(0, ao);
            }
        }
        e.e(ad.getContext(), ad.By(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (com.tencent.mm.pluginsdk.q.x.bYQ() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", tU());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            com.tencent.mm.pluginsdk.q.x.bYQ().r(ad.getContext(), intent);
        }
    }

    public final void l(int i, String str) {
        b(i, str, false);
    }

    private static void b(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String tV = tV();
                if (tV != null) {
                    str2 = a(tV, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("#[jin_crash]sig=").append(i).append(10);
        stringBuilder.append("#crash.previous=").append(z).append(10);
        stringBuilder.append(cs(""));
        stringBuilder.append(str).append(10);
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        b(stringBuilder.toString(), i == 6 ? 0 : 8192, true);
        x.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            x.appenderClose();
        }
    }

    private static String tV() {
        String str;
        try {
            str = y.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String By = ad.By();
            if (By == null || By.length() == 0) {
                By = "com.tencent.mm";
            }
            By = str.substring(0, lastIndexOf) + '_' + By + str.substring(lastIndexOf);
            if (new File(By).isFile()) {
                return By;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append(10);
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    switch (obj) {
                        case null:
                            if (!readLine.startsWith(str2)) {
                                break;
                            }
                            int length = str2.length();
                            long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                            if (time >= -60000 && time <= 60000) {
                                obj = 1;
                                break;
                            }
                        case 1:
                            stringBuilder.append(readLine).append(10);
                            if (!readLine.startsWith("DALVIK THREADS")) {
                                if (!readLine.startsWith("-----")) {
                                    break;
                                }
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                                return null;
                            }
                            obj = 2;
                            break;
                        case 2:
                            try {
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append(10);
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                break;
                            }
                        default:
                            break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
        return null;
    }

    final void r(String str, int i) {
        Recovery.cDW();
        g.pWK.a(11339, true, true, Integer.valueOf(5000), Integer.valueOf(0));
        g.pWK.a(26, 0, 1, true);
        cr(str);
        g gVar = g.pWK;
        g.boV();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ffB >= 120000) {
            this.ffB = currentTimeMillis;
            e.e(ad.getContext(), ad.By(), "anr");
            StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
            stringBuilder.append(cs(""));
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str);
            if (com.tencent.mm.pluginsdk.q.x.bYQ() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", ar.hhz.H("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                com.tencent.mm.pluginsdk.q.x.bYQ().r(ad.getContext(), intent);
            }
        }
    }

    private static String cs(String str) {
        String crashExtraMessage;
        Throwable e;
        Throwable e2;
        int[] iArr;
        MemoryInfo[] processMemoryInfo;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ad.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.vHl);
        stringBuilderPrinter.println("#client.verhistory=" + bz.Im());
        stringBuilderPrinter.println("#client.imei=" + q.yL());
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + ar.hhz.H("last_login_uin", ffH));
        stringBuilderPrinter.println("#accinfo.dev=" + ffG);
        stringBuilderPrinter.println("#accinfo.runtime=" + (bi.Wy() - ffy) + "(" + bi.oM(ffI) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fei);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#qbmin.ver=" + com.tencent.xweb.x5.sdk.d.getMiniQBVersion(context));
        if (ffI.contains(":tools") || ffI.contains(":appbrand")) {
            crashExtraMessage = WebView.getCrashExtraMessage(context);
            if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                if (crashExtraMessage.length() > 8192) {
                    crashExtraMessage = crashExtraMessage.substring(crashExtraMessage.length() - 8192);
                }
                stringBuilderPrinter.println("#qbrowser.crashmsg=" + Base64.encodeToString(crashExtraMessage.getBytes(), 2));
                x.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", crashExtraMessage);
            }
        }
        stringBuilderPrinter.println("#accinfo.env=" + (com.tencent.mm.sdk.a.b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.xmr);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            Context context2 = ad.getContext();
            String packageName = ad.getContext().getPackageName();
            synchronized (ffK) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context2.getPackageManager(), new Object[]{packageName, new Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            if (packageStats != null) {
                                try {
                                    i.ffK[0] = packageStats.cacheSize;
                                    i.ffK[1] = packageStats.dataSize;
                                    i.ffK[2] = packageStats.codeSize;
                                    x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                } catch (Throwable th) {
                                    x.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                                    return;
                                }
                            }
                            x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", Boolean.valueOf(z));
                            synchronized (i.ffK) {
                                i.ffK.notify();
                            }
                        }
                    }});
                    ffK.wait(500);
                } catch (Throwable e3) {
                    ffK[0] = -1;
                    ffK[1] = -1;
                    ffK[2] = -1;
                    x.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "crash e:", new Object[0]);
                    synchronized (ffK) {
                        ffK.notify();
                    }
                }
            }
            crashExtraMessage = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(ffK[0]), Long.valueOf(ffK[1]), Long.valueOf(ffK[2]), com.tencent.mm.compatible.util.e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e4) {
            x.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e4.getMessage());
            crashExtraMessage = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=" + crashExtraMessage);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = 0;
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            j = memoryInfo.totalMem;
        } else {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    char[] toCharArray = randomAccessFile.readLine().toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    while (i < length) {
                        if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                            stringBuffer.append(toCharArray[i]);
                        }
                        i++;
                    }
                    long j2 = bi.getLong(stringBuffer.toString(), -1);
                    if (j2 > 0) {
                        j = j2 << 10;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    try {
                        x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e7) {
                            }
                        }
                        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                        iArr = new int[]{Process.myPid()};
                        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                        if (processMemoryInfo != null) {
                        }
                        crashExtraMessage = str2;
                        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                        if (!bi.oN(str)) {
                            stringBuilderPrinter.println("#" + str);
                        }
                        stringBuilderPrinter.println("#crashContent=");
                        return stringBuilder.toString();
                    } catch (Throwable th) {
                        e3 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e8) {
                            }
                        }
                        throw e3;
                    }
                }
            } catch (Exception e9) {
                e2 = e9;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                iArr = new int[]{Process.myPid()};
                processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null) {
                }
                crashExtraMessage = str2;
                stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                if (bi.oN(str)) {
                    stringBuilderPrinter.println("#" + str);
                }
                stringBuilderPrinter.println("#crashContent=");
                return stringBuilder.toString();
            } catch (Throwable th2) {
                e3 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e3;
            }
        }
        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
        iArr = new int[]{Process.myPid()};
        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
        if (processMemoryInfo != null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            crashExtraMessage = str2;
        } else {
            MemoryInfo memoryInfo2 = processMemoryInfo[0];
            crashExtraMessage = str2 + "[pid(" + iArr[0] + "):" + (memoryInfo2.getTotalPss() << 10) + " " + (memoryInfo2.getTotalPrivateDirty() << 10) + " " + (memoryInfo2.getTotalSharedDirty() << 10) + "]";
        }
        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
        if (bi.oN(str)) {
            stringBuilderPrinter.println("#" + str);
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
