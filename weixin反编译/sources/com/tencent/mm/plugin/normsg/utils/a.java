package com.tencent.mm.plugin.normsg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.mm.plugin.normsg.utils.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a implements g {
    public static final a<String> oYb;
    private long oYc;
    private long oYd;
    private long oYe;
    private int oYf;

    private static final class b {
        static final a oYg = new a();
    }

    private static final class c {
        private c() {
        }

        public static boolean isEnabled() {
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(c.Hl("Úà¯ßºÔ"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(dK(stringBuilder2, stringBuilder.toString()))) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(dK(stringBuilder2, stringBuilder.toString()))) {
                    return false;
                }
                return true;
            }
        }

        static boolean bgv() {
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(c.Hl("Þä¦Ê¡ã¡"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(dK(stringBuilder2, stringBuilder.toString()))) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(dK(stringBuilder2, stringBuilder.toString()))) {
                    return false;
                }
                return true;
            }
        }

        public static int bgw() {
            Throwable th;
            Throwable th2;
            StringBuilder stringBuilder = new StringBuilder();
            int hashCode;
            String stringBuilder2;
            int hashCode2;
            try {
                stringBuilder.append(c.Hl("S\u0000D\u000fF(\\\tK"));
                hashCode = (c.class.hashCode() >>> 31) | 1;
                stringBuilder2 = stringBuilder.toString();
                if (hashCode == 0) {
                    return hashCode;
                }
                try {
                    hashCode2 = ((c.class.hashCode() >>> 31) | 1) ^ 1;
                    try {
                        stringBuilder.delete(0, stringBuilder.length());
                        stringBuilder.append(hashCode2);
                        return bi.getInt(dK(stringBuilder2, stringBuilder.toString()), hashCode2);
                    } catch (Throwable th3) {
                        th = th3;
                        stringBuilder.append(hashCode2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    hashCode2 = hashCode;
                    th = th2;
                    stringBuilder.append(hashCode2);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                stringBuilder.append(hashCode2);
                throw th;
            }
        }

        private static String dK(String str, String str2) {
            try {
                com.tencent.mm.kernel.g.Do().CA();
                try {
                    com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.gOV;
                    com.tencent.mm.storage.c fp = com.tencent.mm.ipcinvoker.wx_extension.a.a.fp("100373");
                    if (fp == null || !fp.isValid()) {
                        x.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                        return str2;
                    }
                    Map civ = fp.civ();
                    if (civ == null) {
                        x.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                        return str2;
                    }
                    String str3 = (String) civ.get(str);
                    if (str3 == null || str3.length() <= 0) {
                        return str2;
                    }
                    return str3;
                } catch (Throwable e) {
                    x.printErrStackTrace("MircoMsg.AEDHLP", e, "check point 1-1, explained by src code.", new Object[0]);
                    return str2;
                }
            } catch (com.tencent.mm.y.b e2) {
                x.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
                return str2;
            }
        }
    }

    private static final class a<T> extends HashSet<T> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean add(T t) {
            if (!contains(t)) {
                return super.add(t);
            }
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            throw new UnsupportedOperationException();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    static {
        a aVar = new a();
        oYb = aVar;
        aVar.add("");
        oYb.add(":tools");
        oYb.add(":appbrand");
    }

    public static a bgq() {
        return b.oYg;
    }

    private a() {
        this.oYc = 0;
        this.oYd = 0;
        this.oYe = 0;
        this.oYf = 0;
        bgt();
    }

    public final synchronized void uq(int i) {
        this.oYf = i;
    }

    public final void a(int i, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        int i2 = 0;
        String view2 = view != null ? view.toString() : "";
        String uz = uz(i);
        String str = "MircoMsg.AEDHLP";
        String str2 = "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = uz;
        objArr[2] = view2;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (list != null) {
            i2 = list.size();
        }
        bQ(uz, i2);
        if (c.bgv() && uz != null && uz.contains(c.Hl(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
    }

    public final boolean a(int i, int i2, View view) {
        String view2 = view != null ? view.toString() : "";
        String uz = uz(i2);
        x.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", Integer.valueOf(i2), uz, view2, Integer.valueOf(i));
        f(i, view);
        n(i, uz, view2);
        if (c.bgv() && uz != null && uz.contains(c.Hl(">\u0010r\u001bc\u0001xV"))) {
            return false;
        }
        return true;
    }

    public final void f(Throwable th) {
        x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        g(th);
    }

    public final synchronized long bgr() {
        return this.oYe;
    }

    public final synchronized void bgs() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oYd >= 259200000) {
            this.oYe = 0;
            this.oYd = currentTimeMillis;
            bgu();
        }
    }

    private synchronized void bgt() {
        Throwable th;
        Closeable dataInputStream;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(ad.getContext().getCacheDir(), c.Hl("ãçÜºÈ­Üòù")))));
            try {
                this.oYc = dataInputStream.readLong();
                this.oYd = dataInputStream.readLong();
                long readLong = dataInputStream.readLong();
                if (readLong > 0 && this.oYe <= 0) {
                    this.oYe = readLong;
                }
                bi.d(dataInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.oYc = 0;
                    this.oYd = System.currentTimeMillis();
                    this.oYe = 0;
                    bgu();
                    bi.d(dataInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            bi.d(dataInputStream);
            throw th;
        }
    }

    private synchronized void bgu() {
        Throwable th;
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ad.getContext().getCacheDir(), c.Hl("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeLong(this.oYc);
                dataOutputStream.writeLong(this.oYd);
                dataOutputStream.writeLong(this.oYe);
                bi.d(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to save rec.", new Object[0]);
                    bi.d(dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(dataOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            bi.d(dataOutputStream);
            throw th;
        }
    }

    private synchronized void f(int i, View view) {
        if (view != null && i == 16) {
            synchronized (this) {
                if (this.oYf != 0) {
                    if ((view instanceof Button) && view.getId() == this.oYf) {
                        this.oYe++;
                        bgu();
                    }
                }
            }
        }
    }

    private synchronized void bQ(String str, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oYc > 86400000) {
            com.tencent.mm.plugin.report.service.g.pWK.c("Normsg_AED", "findview, pkg: " + str + ", res_count: " + i, null);
            this.oYc = currentTimeMillis;
            bgu();
        }
    }

    private synchronized void n(int i, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oYc > 86400000) {
            com.tencent.mm.plugin.report.service.g.pWK.c("Normsg_AED", "action: " + i + ", pkg: " + str + ", view: " + str2, null);
            this.oYc = currentTimeMillis;
            bgu();
        }
    }

    public final synchronized void g(Throwable th) {
        Throwable th2;
        Closeable closeable = null;
        synchronized (this) {
            if (th != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oYc > 86400000) {
                    Writer stringWriter = new StringWriter();
                    Closeable printWriter;
                    try {
                        printWriter = new PrintWriter(stringWriter);
                        try {
                            th.printStackTrace(printWriter);
                            bi.d(printWriter);
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            closeable = printWriter;
                            th2 = th4;
                            bi.d(closeable);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        bi.d(closeable);
                        throw th2;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.c("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                    this.oYc = currentTimeMillis;
                    bgu();
                }
            }
        }
    }

    private static String uz(int i) {
        Throwable th;
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable th2) {
            x.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i) {
                        return runningServiceInfo.process;
                    }
                }
            }
        } catch (Throwable th3) {
            x.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step2.", new Object[0]);
        }
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, c.Hl("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[]{Integer.valueOf(i)})));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                    bi.d(bufferedReader);
                    return readLine;
                }
                bi.d(bufferedReader);
                return "";
            } catch (Throwable th4) {
                th3 = th4;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step3.", new Object[0]);
                    bi.d(bufferedReader);
                    return "";
                } catch (Throwable th5) {
                    th3 = th5;
                    closeable = bufferedReader;
                    bi.d(closeable);
                    throw th3;
                }
            }
        } catch (Throwable th6) {
            th3 = th6;
            bi.d(closeable);
            throw th3;
        }
    }

    public static String Hn(String str) {
        int indexOf = str.indexOf(58);
        return indexOf != -1 ? str.substring(indexOf) : "";
    }
}
