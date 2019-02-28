package com.tencent.mm.plugin.favorite.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static a mvf = null;
    private long endTime = -1;
    private boolean lGi = false;
    ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            Iterator it = a.this.mve.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
            a.this.mve.clear();
        }
    };
    public ArrayList<a> mve = new ArrayList();
    private Object mvg = new Object();
    private Runnable mvh = new Runnable() {
        public final void run() {
            h.getFavItemInfoStorage().aIO();
            a.this.endTime = System.currentTimeMillis();
            x.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", Long.valueOf(a.this.endTime - a.this.startTime));
            a.this.endTime = -1;
            a.this.startTime = -1;
            synchronized (a.this.mvg) {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.valueOf(true));
                a.this.lGi = false;
            }
            a.this.mHandler.sendEmptyMessage(0);
        }
    };
    private long startTime = -1;

    public interface a {
        void onFinish();
    }

    private a() {
    }

    public static synchronized a aJd() {
        a aVar;
        synchronized (a.class) {
            if (mvf == null) {
                mvf = new a();
            }
            aVar = mvf;
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.favorite.a.a.a r5) {
        /*
        r4 = this;
        r1 = r4.mvg;
        monitor-enter(r1);
        com.tencent.mm.y.as.Hm();	 Catch:{ all -> 0x003a }
        r0 = com.tencent.mm.y.c.Db();	 Catch:{ all -> 0x003a }
        r2 = com.tencent.mm.storage.w.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN;	 Catch:{ all -> 0x003a }
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x003a }
        r0 = r0.get(r2, r3);	 Catch:{ all -> 0x003a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x003a }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0024;
    L_0x001d:
        if (r5 == 0) goto L_0x0022;
    L_0x001f:
        r5.onFinish();	 Catch:{ all -> 0x003a }
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0023:
        return;
    L_0x0024:
        if (r5 == 0) goto L_0x002b;
    L_0x0026:
        r0 = r4.mve;	 Catch:{ all -> 0x003a }
        r0.add(r5);	 Catch:{ all -> 0x003a }
    L_0x002b:
        r0 = r4.lGi;	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x003d;
    L_0x002f:
        r0 = "MicroMsg.FavCleanFirstLoader";
        r2 = "isLoading is true, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x0023;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        r0 = 1;
        r4.lGi = r0;	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        r0 = java.lang.System.currentTimeMillis();
        r4.startTime = r0;
        r0 = r4.mvh;
        r1 = "FavCleanFirstLoader_CalFavDataLength";
        com.tencent.mm.sdk.f.e.post(r0, r1);
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.a.a.a(com.tencent.mm.plugin.favorite.a.a$a):void");
    }
}
