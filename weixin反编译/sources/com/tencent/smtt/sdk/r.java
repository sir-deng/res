package com.tencent.smtt.sdk;

import android.os.HandlerThread;

final class r extends HandlerThread {
    private static r AgP;

    private r(String str) {
        super(str);
    }

    public static synchronized r cFx() {
        r rVar;
        synchronized (r.class) {
            if (AgP == null) {
                rVar = new r("TbsHandlerThread");
                AgP = rVar;
                rVar.start();
            }
            rVar = AgP;
        }
        return rVar;
    }
}
