package com.c.a;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.tencent.rtmp.TXLiveConstants;

public final class a {
    public c bfY;
    public b bfZ;
    public a bga;
    private int bgb;
    b bgc;
    int bgd = -1;
    public DeathRecipient bge = new DeathRecipient() {
        public final void binderDied() {
            if (a.this.bgc != null) {
                a.this.bgc.aH(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL, -1);
            }
        }
    };

    public interface b {
        void aH(int i, int i2);
    }

    private class a extends Handler {
        private final int bgg = 2001;
        private final int bgh = 2002;
        private final int bgi = 2003;
        private final int bgj = TXLiveConstants.PLAY_EVT_PLAY_BEGIN;
        private final int bgk = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        private final int bgl = TXLiveConstants.PLAY_EVT_PLAY_END;

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(android.os.Message r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = 2005; // 0x7d5 float:2.81E-42 double:9.906E-321;
            r4 = -1;
            r3 = 8;
            r1 = new java.lang.StringBuilder;
            r2 = "what = ";
            r1.<init>(r2);
            r2 = r6.what;
            r1.append(r2);
            r1 = r6.what;
            switch(r1) {
                case 1: goto L_0x0018;
                case 2: goto L_0x001f;
                case 3: goto L_0x0026;
                case 4: goto L_0x0017;
                case 5: goto L_0x0017;
                case 6: goto L_0x002d;
                case 7: goto L_0x0041;
                case 8: goto L_0x0065;
                default: goto L_0x0017;
            };
        L_0x0017:
            return;
        L_0x0018:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            if (r0 == 0) goto L_0x0017;
        L_0x001e:
            goto L_0x0017;
        L_0x001f:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            if (r0 == 0) goto L_0x0017;
        L_0x0025:
            goto L_0x0017;
        L_0x0026:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            if (r0 == 0) goto L_0x0017;
        L_0x002c:
            goto L_0x0017;
        L_0x002d:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            if (r0 == 0) goto L_0x003d;
        L_0x0033:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            r1 = 0;
            r2 = r6.arg1;
            r0.aH(r1, r2);
        L_0x003d:
            r5.removeMessages(r3);
            goto L_0x0017;
        L_0x0041:
            r1 = com.c.a.a.this;
            r1 = r1.bgc;
            if (r1 == 0) goto L_0x0055;
        L_0x0047:
            r1 = r6.arg1;
            switch(r1) {
                case 2001: goto L_0x0059;
                case 2002: goto L_0x005c;
                case 2003: goto L_0x004e;
                case 2004: goto L_0x005f;
                case 2005: goto L_0x0062;
                case 2006: goto L_0x004e;
                default: goto L_0x004c;
            };
        L_0x004c:
            r0 = 2020; // 0x7e4 float:2.83E-42 double:9.98E-321;
        L_0x004e:
            r1 = com.c.a.a.this;
            r1 = r1.bgc;
            r1.aH(r0, r4);
        L_0x0055:
            r5.removeMessages(r3);
            goto L_0x0017;
        L_0x0059:
            r0 = 2002; // 0x7d2 float:2.805E-42 double:9.89E-321;
            goto L_0x004e;
        L_0x005c:
            r0 = 2003; // 0x7d3 float:2.807E-42 double:9.896E-321;
            goto L_0x004e;
        L_0x005f:
            r0 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            goto L_0x004e;
        L_0x0062:
            r0 = 2006; // 0x7d6 float:2.811E-42 double:9.91E-321;
            goto L_0x004e;
        L_0x0065:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            if (r0 == 0) goto L_0x0074;
        L_0x006b:
            r0 = com.c.a.a.this;
            r0 = r0.bgc;
            r1 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;
            r0.aH(r1, r4);
        L_0x0074:
            r5.removeMessages(r3);
            r0 = com.c.a.a.this;
            r0.abort();
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.handleMessage(android.os.Message):void");
        }
    }

    public static a rN() {
        c rQ = rQ();
        if (rQ == null) {
            return null;
        }
        try {
            return new a(rQ, Looper.getMainLooper(), 1);
        } catch (Exception e) {
            return null;
        }
    }

    private a(c cVar, Looper looper, int i) {
        this.bfY = cVar;
        a aVar = new a(looper);
        this.bgb = 1;
        this.bfZ = new com.c.a.b.a() {
            public final void a(int i, int i2, int i3, byte[] bArr) {
                a.this.bga.sendMessage(a.this.bga.obtainMessage(i, i2, i3, bArr));
            }
        };
        if (this.bfY.a(this.bfZ, 1)) {
            this.bga = aVar;
            cVar.asBinder().linkToDeath(this.bge, 0);
            return;
        }
        throw new RuntimeException();
    }

    public final int[] rO() {
        try {
            return this.bfY.c(this.bfZ);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public final int a(b bVar, int i, int[] iArr) {
        int i2 = -1;
        if (iArr == null || bVar == null) {
            return i2;
        }
        if (i > 0) {
            new StringBuilder("startIdentify send message timeout after ").append(i).append(" ms");
            this.bga.sendMessageDelayed(this.bga.obtainMessage(8), (long) i);
        }
        this.bgc = bVar;
        this.bgd = 0;
        try {
            return this.bfY.a(this.bfZ, iArr, null);
        } catch (RemoteException e) {
            return i2;
        }
    }

    public final void abort() {
        if (this.bga != null) {
            this.bga.removeMessages(8);
        }
        try {
            this.bfY.a(this.bfZ);
        } catch (RemoteException e) {
        }
    }

    public static int[] rP() {
        c rQ = rQ();
        if (rQ == null) {
            return new int[0];
        }
        try {
            return rQ.rR();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    private static c rQ() {
        return com.c.a.c.a.x(ServiceManager.getService("authentication_service"));
    }
}
