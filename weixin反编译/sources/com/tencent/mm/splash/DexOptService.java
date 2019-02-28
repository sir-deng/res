package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.tencent.mm.e.a;
import java.io.File;

public class DexOptService extends Service {
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
    private Handler xtJ;
    private volatile boolean xtK = false;
    private Handler xtL = new Handler() {
        public final void handleMessage(Message message) {
            e.a("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            DexOptService.this.stopSelf();
        }
    };
    private volatile Throwable xtM;

    static /* synthetic */ void aPm() {
        File file = new File(a.chU());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.getName().startsWith("DexOpt_Request")) {
                    e.a("WxSplash.DexOptService", "remove temp file %s result %s", file2, Boolean.valueOf(file2.delete()));
                    if (!file2.delete()) {
                        throw new RuntimeException("remove temp file failed");
                    }
                }
            }
            e.a("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
    }

    static /* synthetic */ void akX() {
        File file = new File(a.chU() + "/DexOpt_Failed");
        if (file.exists()) {
            boolean delete = file.delete();
            e.a("WxSplash.DexOptService", "remove failed file %s result %s", file, Boolean.valueOf(delete));
        }
        e.a("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
    }

    static /* synthetic */ void c(DexOptService dexOptService) {
        if (dexOptService.xtM != null) {
            throw new RuntimeException(dexOptService.xtM);
        }
    }

    static /* synthetic */ void uk() {
        String chU = a.chU();
        File file = new File(chU);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(chU + "/DexOpt_Failed");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            e.a("WxSplash.DexOptService", "addFailedFile", new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void onCreate() {
        e.a("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.xtJ = new Handler(this.mHandlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                if (DexOptService.this.xtK) {
                    e.a("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    return;
                }
                DexOptService.this.xtK = true;
                if (DexOptService.this.cia()) {
                    DexOptService.akX();
                } else {
                    DexOptService.uk();
                    DexOptService.c(DexOptService.this);
                }
                DexOptService.aPm();
                DexOptService.this.xtK = false;
            }
        };
    }

    private boolean cia() {
        boolean ay;
        e.a("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            ay = a.ay(getApplicationContext());
        } catch (Throwable th) {
            this.xtM = th;
            ay = false;
        }
        e.a("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.xtL.removeCallbacksAndMessages(null);
        this.xtL.sendEmptyMessageDelayed(0, 120000);
        e.a("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(ay));
        return ay;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.xtJ.sendEmptyMessage(0);
        e.a("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        e.a("WxSplash.DexOptService", "onBind", new Object[0]);
        return null;
    }

    public void onDestroy() {
        e.a("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
    }
}
