package com.tencent.mm.bz;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    static ag hbP = new ag() {
        public final void handleMessage(Message message) {
            x.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                d.xLF.b((a) message.obj);
            } else if (message.what != 1) {
                d.xLF.a((a) message.obj);
            } else if (d.xLF.xLL != null) {
                b bVar = (b) d.xLF.xLL.get();
                if (bVar != null) {
                    bVar.cmh();
                }
            }
            super.handleMessage(message);
        }
    };
    public static a xLA = null;
    public static d xLF;
    private static int xLG = 5242880;
    public static final String xLI = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean hPX;
    private volatile boolean xLH;
    private LinkedBlockingQueue<a> xLJ;
    ExecutorService xLK;
    public WeakReference<b> xLL;

    public interface b {
        void cmh();
    }

    public static final class a {
        String className;
        int fKi;
        String savePath;
        int xLO;
        int xLP;

        public a(String str, int i, int i2, int i3) {
            this.className = str;
            this.fKi = i;
            this.xLO = i2;
            this.xLP = i3;
            StringBuilder stringBuilder = new StringBuilder();
            if (bi.oN(str)) {
                stringBuilder.append(d.xLI).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = stringBuilder.append(d.xLI).append(str).append("_");
                String str2 = "";
                switch (i) {
                    case 1:
                        str2 = "onResume";
                        break;
                    case 2:
                        str2 = "onPause";
                        break;
                    case 3:
                        str2 = "onCreate";
                        break;
                    case 4:
                        str2 = "onScrool";
                        break;
                    case 5:
                        str2 = "all";
                        break;
                }
                append.append(str2).append(".trace");
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", stringBuilder.toString(), Integer.valueOf(i2));
            this.savePath = stringBuilder.toString();
        }
    }

    public static d cmf() {
        if (xLF == null) {
            xLF = new d();
        }
        return xLF;
    }

    private void a(a aVar) {
        if (!this.xLH) {
            if (c.zl()) {
                cmg();
                try {
                    File file = new File(xLI);
                    if (aVar.fKi != 6 && file.exists()) {
                        x.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                        K(file);
                    }
                    file.mkdirs();
                    Debug.startMethodTracing(aVar.savePath, aVar.xLO <= 0 ? xLG : (aVar.xLO * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    this.xLH = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable e2) {
                    this.xLH = false;
                    x.printErrStackTrace("MicroMsg.TraceDebugManager", e2, "TRACE startMethodTracing ERROR", new Object[0]);
                }
                if (aVar.fKi == 6) {
                    x.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                    return;
                } else if (this.xLH) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = aVar;
                    if (bi.oN(aVar.className) || aVar.fKi == 5) {
                        hbP.sendMessageDelayed(obtain, 15000);
                        return;
                    } else {
                        hbP.sendMessageDelayed(obtain, 10000);
                        return;
                    }
                } else {
                    return;
                }
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        }
    }

    private static void cmg() {
        hbP.removeMessages(0);
        hbP.removeMessages(2);
        hbP.removeMessages(1);
    }

    private static void K(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File K : listFiles) {
                K(K);
            }
            file.delete();
        }
    }

    public final boolean b(final a aVar) {
        cmg();
        if (!this.xLH || this.hPX) {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.xLH), Boolean.valueOf(this.hPX));
            return false;
        } else if (c.zl()) {
            this.xLK.execute(new Runnable() {
                public final void run() {
                    try {
                        Debug.stopMethodTracing();
                        String str = aVar.savePath;
                        int i = aVar.xLP;
                        if (aVar.savePath == null) {
                            d.this.xLH = false;
                            return;
                        }
                        File file = new File(str);
                        File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        file.renameTo(file2);
                        file.delete();
                        x.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (aVar.fKi == 6) {
                            Collection arrayList = new ArrayList();
                            arrayList.add(file2);
                            try {
                                p.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                                d.hbP.sendEmptyMessage(1);
                                d.this.xLH = false;
                                return;
                            } catch (Throwable e) {
                                x.e("MicroMsg.TraceDebugManager", "exception:%s", bi.i(e));
                                x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                                d.this.xLH = false;
                                return;
                            }
                        }
                        if (d.this.xLJ == null || d.this.xLJ.size() == 0) {
                            str = d.d(file2, true);
                            if (!bi.oN(str)) {
                                d dVar = d.this;
                                if (i == 1 || (i == 3 && ao.isWifi(ad.getContext()))) {
                                    dVar.YS(str);
                                }
                            }
                        }
                        d.this.xLH = false;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
                    } catch (Throwable th) {
                        d.this.xLH = false;
                    }
                }
            });
            return true;
        } else {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            return false;
        }
    }

    private static String d(File file, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            x.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                x.e("MicroMsg.TraceDebugManager", " get file list failed");
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(xLI + bi.Wy() + ".zip");
        try {
            p.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() <= 3145728) {
                return file2.getAbsolutePath();
            }
            x.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(file2.length()));
            return null;
        } catch (Throwable e) {
            x.e("MicroMsg.TraceDebugManager", "exception:%s", bi.i(e));
            x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
            return null;
        }
    }

    private d() {
    }

    public final void dh(String str, int i) {
        if (this.xLJ != null && this.xLJ.size() > 0) {
            x.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.hPX), Boolean.valueOf(this.xLH), str, Integer.valueOf(i));
            if (!this.hPX && !this.xLH) {
                Iterator it = this.xLJ.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.xLJ.remove(aVar);
                        return;
                    } else if (aVar.className.equals(str) && aVar.fKi == i) {
                        a(aVar);
                        this.xLJ.remove(aVar);
                        return;
                    }
                }
            }
        }
    }

    final void YS(String str) {
        if (str != null) {
            this.hPX = true;
            if (bi.oN(str)) {
                x.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
            } else if (c.zl()) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        str = d(file, true);
                    }
                    if (str != null && new File(str).length() >= HardCoderJNI.ACTION_NET_RX) {
                        if (xLA == null) {
                            x.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                        } else {
                            x.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(xLA.HW(str)));
                            if (xLA.HW(str)) {
                                e.g(new File(xLI));
                            }
                        }
                    }
                } else {
                    x.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
                }
            } else {
                x.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
            }
            this.hPX = false;
        }
    }

    public final void c(a aVar) {
        if (aVar.fKi > 0) {
            if (this.xLK == null) {
                this.xLK = Executors.newSingleThreadExecutor();
            }
            if (this.hPX || this.xLH) {
                x.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.hPX), Boolean.valueOf(this.xLH));
                return;
            }
            hbP.removeMessages(0);
            if (aVar.xLP == 4 || aVar.xLP == 5) {
                final int i = aVar.xLP;
                this.xLK.execute(new Runnable() {
                    public final void run() {
                        d.this.YS(i == 4 ? "/data/anr/" : d.xLI);
                    }
                });
            } else if (aVar.fKi == 6 || aVar.fKi == 5) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = aVar;
                if (aVar.fKi == 5) {
                    hbP.sendMessage(obtain);
                } else {
                    hbP.sendMessageDelayed(obtain, 500);
                }
            } else {
                if (this.xLJ == null) {
                    this.xLJ = new LinkedBlockingQueue();
                }
                this.xLJ.clear();
                this.xLJ.add(aVar);
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", aVar.className, Integer.valueOf(aVar.fKi), Integer.valueOf(aVar.xLP));
        }
    }
}
