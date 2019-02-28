package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;

class m {
    private static volatile m gOt;
    private ag gOu;
    private n gOv;
    private ag mHandler;
    private HandlerThread mHandlerThread = e.WL("IPCThreadCaller#Worker-" + hashCode());

    private static m BD() {
        if (gOt == null) {
            synchronized (m.class) {
                if (gOt == null) {
                    gOt = new m();
                }
            }
        }
        return gOt;
    }

    private m() {
        this.mHandlerThread.start();
        this.mHandler = new ag(this.mHandlerThread.getLooper());
        this.gOu = new ag(Looper.getMainLooper());
        this.gOv = n.BF();
    }

    public static boolean g(Runnable runnable) {
        BD().gOv.gOx.execute(runnable);
        return true;
    }
}
