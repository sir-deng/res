package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.cc.j;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ak implements UncaughtExceptionHandler {
    private static ak xoa = null;
    private d xob;
    private com.tencent.mm.sdk.a.a xoc;
    public a xod;
    public Map<String, b> xoe;
    private UncaughtExceptionHandler xof;
    private boolean xog;
    private List<c> xoh;

    public interface a {
        void tS();
    }

    public interface b {
        String IU();
    }

    public interface c {
        void a(String str, Throwable th);
    }

    public interface d {
        void a(ak akVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (ak.class) {
            if (xoa == null) {
                xoa = new ak();
            }
            xoa.xob = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.a.a aVar) {
        synchronized (ak.class) {
            if (xoa == null) {
                xoa = new ak();
            }
            xoa.xoc = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ak.class) {
            if (xoa == null) {
                xoa = new ak();
            }
            xoa.xod = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (ak.class) {
            if (xoa == null) {
                xoa = new ak();
            }
            xoa.xoe.put(str, bVar);
        }
    }

    public static synchronized void s(String str, final String str2, boolean z) {
        synchronized (ak.class) {
            a(str, new b() {
                public final String IU() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (ak.class) {
            if (cVar != null) {
                if (xoa == null) {
                    xoa = new ak();
                }
                xoa.xoh.add(cVar);
            }
        }
    }

    private ak() {
        this.xob = null;
        this.xoc = null;
        this.xod = null;
        this.xoe = new HashMap();
        this.xof = null;
        this.xog = false;
        this.xoh = new LinkedList();
        this.xof = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String VM(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    public static String j(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String VM = VM(byteArrayOutputStream.toString());
        return VM;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.xog) {
            this.xog = true;
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                final String VM = VM(byteArrayOutputStream.toString());
                if (!(this.xoc == null || VM == null)) {
                    HandlerThread handlerThread = new HandlerThread("close-db-while-crash");
                    handlerThread.start();
                    final j jVar = new j();
                    new Handler(handlerThread.getLooper()).post(new Runnable() {
                        public final void run() {
                            ak.this.xoc.fK(VM);
                            j jVar = jVar;
                            synchronized (jVar.gPR) {
                                if (jVar.gPR[0] == (byte) 0) {
                                    jVar.gPR[0] = (byte) 1;
                                    jVar.gPR.notifyAll();
                                    x.i("MicroMsg.WxTimeoutLock", "notify done %s", jVar);
                                }
                            }
                        }
                    });
                    synchronized (jVar.gPR) {
                        if (jVar.gPR[0] != (byte) 0) {
                            x.i("MicroMsg.WxTimeoutLock", "no need lock %s", jVar);
                        } else {
                            try {
                                jVar.gPR.wait(3000);
                            } catch (Throwable th22) {
                                x.printErrStackTrace("MicroMsg.WxTimeoutLock", th22, "", new Object[0]);
                            }
                        }
                    }
                }
                if (!(this.xob == null || VM == null)) {
                    this.xob.a(this, VM, th);
                    this.xod.tS();
                }
                for (c cVar : this.xoh) {
                    if (cVar != null) {
                        try {
                            cVar.a(VM, th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            x.appenderClose();
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
