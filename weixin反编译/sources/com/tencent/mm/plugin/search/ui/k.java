package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class k implements g {
    private static int qjn = 32;
    private ag hbP = new ag(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> qjo;
    private Vector<String> qjp;
    private boolean qjq = true;
    private int qjr = 0;
    private ag[] qjs = new ag[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> qjt = null;
    private ConcurrentHashMap<Long, byte[]> qju = null;
    private ag qjv = null;
    private Set<String> qjw;

    class a {
        Bitmap bitmap;
        String fCV;

        a() {
        }
    }

    interface c {
        void ay(String str, boolean z);
    }

    class b implements Runnable {
        private String fCV;
        private int height;
        private String iXq;
        private c qjA;
        private boolean qjz;
        private String url;
        private int width;

        public b(String str, String str2, String str3, boolean z, int i, int i2, c cVar) {
            this.iXq = str;
            this.url = str2;
            this.fCV = str3;
            this.qjA = cVar;
            this.qjz = z;
            this.width = i;
            this.height = i2;
        }

        public final void run() {
            x.d("MicroMsg.FTS.SearchImageLoader", "Start to run load bitmap job %s", this.iXq);
            if (bi.oN(this.fCV)) {
                this.fCV = as.Hm();
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap T = k.T(this.fCV, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (T != null) {
                x.d("MicroMsg.FTS.SearchImageLoader", "Found image in local %s | localPath %s | use time %d", this.url, this.fCV, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                k.a(k.this, this.iXq, this.fCV, T);
                this.qjA.ay(this.iXq, true);
                return;
            }
            Bitmap a = k.this.c(this.url, this.qjz, this.width, this.height);
            long currentTimeMillis3 = System.currentTimeMillis();
            x.d("MicroMsg.FTS.SearchImageLoader", "Get image from net %s | localPath %s | use time %d", this.url, this.fCV, Long.valueOf(currentTimeMillis3 - currentTimeMillis2));
            if (a != null) {
                k.a(k.this, this.iXq, this.fCV, a);
                this.qjA.ay(this.iXq, true);
                return;
            }
            this.qjA.ay(this.iXq, false);
        }
    }

    class d implements Runnable {
        private a qjB;

        public d(a aVar) {
            this.qjB = aVar;
        }

        public final void run() {
            x.d("MicroMsg.FTS.SearchImageLoader", "Start to run save bitmap job");
            try {
                if (!new File(this.qjB.fCV).exists()) {
                    if (this.qjB.bitmap == null || this.qjB.bitmap.isRecycled()) {
                        x.d("MicroMsg.FTS.SearchImageLoader", "Save Bitmap is Recycled");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.sdk.platformtools.d.a(this.qjB.bitmap, 100, CompressFormat.PNG, this.qjB.fCV, false);
                    x.d("MicroMsg.FTS.SearchImageLoader", "Save bitmap use time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e, "", new Object[0]);
            }
        }
    }

    static /* synthetic */ Bitmap T(String str, int i, int i2) {
        if (bi.oN(str) || !new File(str).exists()) {
            return null;
        }
        return (i <= 0 || i2 <= 0) ? j.oH(str) : j.m(str, i, i2);
    }

    static /* synthetic */ void a(k kVar, String str, String str2, Bitmap bitmap) {
        if (kVar.qjo.size() > qjn) {
            kVar.JA((String) kVar.qjp.lastElement());
        }
        a aVar = new a();
        aVar.fCV = str2;
        aVar.bitmap = bitmap;
        kVar.qjo.put(str, aVar);
        if (!new File(aVar.fCV).exists()) {
            kVar.qjv.postDelayed(new d(aVar), 200);
        }
    }

    public k() {
        int i = 0;
        x.i("MicroMsg.FTS.SearchImageLoader", "create SearchImageLoader");
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            qjn = 64;
        } else {
            qjn = 32;
        }
        this.qjo = new ConcurrentHashMap();
        this.qjp = new Vector();
        this.qjt = new ConcurrentHashMap();
        this.qju = new ConcurrentHashMap();
        this.qjw = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.qjs[i] == null) {
                e.d(new Runnable() {
                    public final void run() {
                        Looper.prepare();
                        k.this.qjs[i] = new ag();
                        Looper.loop();
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        e.d(new Runnable() {
            public final void run() {
                Looper.prepare();
                k.this.qjv = new ag();
                Looper.loop();
            }
        }, "SearchImageLoader_saveImage_handler", 1).start();
    }

    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String a = a(imageView, str, str2, z, i, i2);
        if (this.qjq) {
            Runnable bVar = new b(a, str, str2, z, i, i2, new c() {
                public final void ay(final String str, boolean z) {
                    x.v("MicroMsg.FTS.SearchImageLoader", "LoadBitmapJob finish: %s %b", str, Boolean.valueOf(z));
                    k.this.qjw.remove(str);
                    if (z) {
                        final Bitmap a = k.this.lC(str);
                        if (str.equals(imageView.getTag())) {
                            k.this.hbP.post(new Runnable() {
                                public final void run() {
                                    if (str.equals(imageView.getTag())) {
                                        com.tencent.mm.plugin.fts.d.g.a.a(context.getResources(), a, imageView);
                                    }
                                }
                            });
                        }
                    }
                }
            });
            if (this.qjw.add(a)) {
                this.qjr++;
                this.qjr %= 2;
                this.qjs[this.qjr].post(bVar);
                return;
            }
            x.v("MicroMsg.FTS.SearchImageLoader", "cacheKey: %s | runningJobTask: %s", a, this.qjw.toString());
        }
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        x.d("MicroMsg.FTS.SearchImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", Integer.valueOf(imageView.hashCode()), b);
        return b;
    }

    public final void aNX() {
        x.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.qjs[i] != null) {
                this.qjs[i].removeCallbacksAndMessages(null);
            }
        }
    }

    public final void aNY() {
        x.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImage");
        this.qjq = false;
        aNX();
    }

    public final boolean aNZ() {
        return this.qjq;
    }

    public final void aOa() {
        x.d("MicroMsg.FTS.SearchImageLoader", "startLoadImage");
        this.qjq = true;
    }

    public final void aOb() {
        x.d("MicroMsg.FTS.SearchImageLoader", "clearCacheAndTask %s", Integer.valueOf(this.qjo.size()));
        aNX();
        for (Entry key : this.qjo.entrySet()) {
            JA((String) key.getKey());
        }
        this.qjp.clear();
        this.qjw.clear();
    }

    public final void aOc() {
        aOb();
        x.d("MicroMsg.FTS.SearchImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.qjs[i] != null) {
                this.qjs[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.qjt.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.qjt.clear();
        this.qju.clear();
        this.qjv.getLooper().quit();
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        return lC(b(str, str2, z, i, i2));
    }

    private Bitmap lC(String str) {
        a aVar = (a) this.qjo.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.qjp.remove(str);
            this.qjp.add(0, str);
        }
        return aVar == null ? null : aVar.bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        bArr = (byte[]) this.qju.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            this.qju.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        return "fts_search_" + com.tencent.mm.a.g.s((bi.aD(str, "null") + bi.aD(str2, "null") + z + i + "_" + i2).getBytes());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap c(java.lang.String r10, boolean r11, int r12, int r13) {
        /*
        r9 = this;
        r1 = 0;
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = r1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r9.qjt;
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        r2 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r2);
        r0 = (java.io.ByteArrayOutputStream) r0;
        if (r0 != 0) goto L_0x0039;
    L_0x0020:
        r0 = new java.io.ByteArrayOutputStream;
        r2 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        r0.<init>(r2);
        r2 = r9.qjt;
        r3 = java.lang.Thread.currentThread();
        r6 = r3.getId();
        r3 = java.lang.Long.valueOf(r6);
        r2.put(r3, r0);
    L_0x0039:
        r0.reset();
        r5 = r9.getBuffer();
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r2 = com.tencent.mm.network.b.l(r10, r2, r3);	 Catch:{ Exception -> 0x0136, all -> 0x011f }
        if (r2 != 0) goto L_0x013a;
    L_0x004a:
        r0 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "download %s error, can not open http stream";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x007a }
        r6 = 0;
        r5[r6] = r10;	 Catch:{ Exception -> 0x007a }
        com.tencent.mm.sdk.platformtools.x.w(r0, r3, r5);	 Catch:{ Exception -> 0x007a }
        if (r2 == 0) goto L_0x005e;
    L_0x005b:
        r2.close();	 Catch:{ IOException -> 0x0060 }
    L_0x005e:
        r0 = r1;
        goto L_0x0009;
    L_0x0060:
        r0 = move-exception;
        r2 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "";
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x005e;
    L_0x006d:
        r6 = r2.read(r5);	 Catch:{ Exception -> 0x007a }
        r7 = -1;
        if (r6 == r7) goto L_0x009e;
    L_0x0074:
        r3 = r3 + r6;
        r7 = 0;
        r0.write(r5, r7, r6);	 Catch:{ Exception -> 0x007a }
        goto L_0x006d;
    L_0x007a:
        r0 = move-exception;
    L_0x007b:
        r3 = "MicroMsg.FTS.SearchImageLoader";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0134 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r5, r6);	 Catch:{ all -> 0x0134 }
        r0 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "get url:%s failed.";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0134 }
        r6 = 0;
        r5[r6] = r10;	 Catch:{ all -> 0x0134 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r3, r5);	 Catch:{ all -> 0x0134 }
        if (r2 == 0) goto L_0x009b;
    L_0x0098:
        r2.close();	 Catch:{ IOException -> 0x0111 }
    L_0x009b:
        r0 = r1;
        goto L_0x0009;
    L_0x009e:
        r0 = r0.toByteArray();	 Catch:{ Exception -> 0x007a }
        if (r12 <= 0) goto L_0x00f7;
    L_0x00a4:
        if (r13 <= 0) goto L_0x00f7;
    L_0x00a6:
        r0 = com.tencent.mm.sdk.platformtools.d.decodeByteArray(r0, r12, r13);	 Catch:{ Exception -> 0x007a }
    L_0x00aa:
        r5 = "MicroMsg.FTS.SearchImageLoader";
        r6 = "get url[%s] ok, bufSize[%d], bitmap size %d * %d";
        r7 = 4;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x007a }
        r8 = 0;
        r7[r8] = r10;	 Catch:{ Exception -> 0x007a }
        r8 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x007a }
        r7[r8] = r3;	 Catch:{ Exception -> 0x007a }
        r3 = 2;
        r8 = r0.getWidth();	 Catch:{ Exception -> 0x007a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x007a }
        r7[r3] = r8;	 Catch:{ Exception -> 0x007a }
        r3 = 3;
        r8 = r0.getHeight();	 Catch:{ Exception -> 0x007a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x007a }
        r7[r3] = r8;	 Catch:{ Exception -> 0x007a }
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);	 Catch:{ Exception -> 0x007a }
        if (r11 == 0) goto L_0x00fc;
    L_0x00d8:
        r3 = 1;
        r5 = r0.getWidth();	 Catch:{ Exception -> 0x007a }
        r5 = (float) r5;	 Catch:{ Exception -> 0x007a }
        r0 = com.tencent.mm.sdk.platformtools.d.a(r0, r3, r5);	 Catch:{ Exception -> 0x007a }
        if (r2 == 0) goto L_0x0009;
    L_0x00e4:
        r2.close();	 Catch:{ IOException -> 0x00e9 }
        goto L_0x0009;
    L_0x00e9:
        r1 = move-exception;
        r2 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "";
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0009;
    L_0x00f7:
        r0 = com.tencent.mm.sdk.platformtools.d.bn(r0);	 Catch:{ Exception -> 0x007a }
        goto L_0x00aa;
    L_0x00fc:
        if (r2 == 0) goto L_0x0009;
    L_0x00fe:
        r2.close();	 Catch:{ IOException -> 0x0103 }
        goto L_0x0009;
    L_0x0103:
        r1 = move-exception;
        r2 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "";
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0009;
    L_0x0111:
        r0 = move-exception;
        r2 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "";
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x009b;
    L_0x011f:
        r0 = move-exception;
        r2 = r1;
    L_0x0121:
        if (r2 == 0) goto L_0x0126;
    L_0x0123:
        r2.close();	 Catch:{ IOException -> 0x0127 }
    L_0x0126:
        throw r0;
    L_0x0127:
        r1 = move-exception;
        r2 = "MicroMsg.FTS.SearchImageLoader";
        r3 = "";
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0126;
    L_0x0134:
        r0 = move-exception;
        goto L_0x0121;
    L_0x0136:
        r0 = move-exception;
        r2 = r1;
        goto L_0x007b;
    L_0x013a:
        r3 = r4;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.k.c(java.lang.String, boolean, int, int):android.graphics.Bitmap");
    }

    private void JA(String str) {
        a aVar = (a) this.qjo.get(str);
        this.qjp.remove(str);
        this.qjo.remove(str);
        if (aVar != null && aVar.bitmap != null) {
            if (!aVar.bitmap.isRecycled()) {
                x.i("MicroMsg.FTS.SearchImageLoader", "bitmap recycle %s", aVar.bitmap);
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
    }
}
