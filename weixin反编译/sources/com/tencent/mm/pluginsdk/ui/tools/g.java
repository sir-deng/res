package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class g {
    public byte[] gUq = new byte[0];
    ag hbP;
    volatile boolean vDO = false;
    private HandlerThread vDP = com.tencent.mm.sdk.f.e.WL("ImageEngine_handlerThread" + System.currentTimeMillis());
    private ag vDQ;
    public HashMap<String, ImageView> vDR = new HashMap();
    public HashMap<ImageView, String> vDS = new HashMap();
    c<String, Bitmap> vDT;
    private SparseArray<Bitmap> vDU;
    a<e> vDV;
    a<b> vDW;
    private boolean vDX = true;
    private com.tencent.mm.platformtools.j.a vDY = new com.tencent.mm.platformtools.j.a() {
        public final void l(String str, final Bitmap bitmap) {
            boolean z = false;
            String str2 = "MicroMsg.ImageEngine";
            String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.v(str2, str3, objArr);
            if (bitmap != null) {
                g.this.vDT.put(str, bitmap);
                final ImageView imageView = (ImageView) g.this.vDR.get(str);
                if (imageView != null) {
                    g.this.vDS.remove(imageView);
                    g.this.hbP.post(new Runnable() {
                        public final void run() {
                            d.b(imageView, bitmap);
                        }
                    });
                }
                g.this.vDR.remove(str);
            }
        }
    };

    private abstract class a<T> {
        private ag handler;
        final int vEe = Math.max(1, 16);
        LinkedList<T> vEf = new LinkedList();

        protected abstract T cdl();

        public a(int i, Looper looper) {
            this.handler = new ag(looper, g.this) {
                public final void handleMessage(Message message) {
                    a aVar = a.this;
                    Object obj = message.obj;
                    if (obj != null && aVar.vEf.size() < aVar.vEe) {
                        aVar.vEf.add(obj);
                    }
                }
            };
        }

        public final T cdm() {
            if (this.vEf.isEmpty()) {
                return cdl();
            }
            return this.vEf.removeFirst();
        }

        public final void C(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    private class e implements Runnable {
        ImageView fwa;
        Bitmap mZu;

        private e() {
        }

        /* synthetic */ e(g gVar, byte b) {
            this();
        }

        public final void run() {
            if (this.fwa != null) {
                if (this.mZu == null || !this.mZu.isRecycled()) {
                    d.b(this.fwa, this.mZu);
                } else {
                    d.d(this.fwa);
                }
            }
            this.fwa = null;
            this.mZu = null;
            g.this.vDV.C(this);
        }
    }

    private class b implements Runnable {
        private int mBg;
        private int nZY;
        private String url;
        private String[] vEi;
        private String vEj;

        private b() {
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }

        private Bitmap Tu(String str) {
            if (str == null) {
                return null;
            }
            if (this.mBg <= 0 || this.nZY <= 0) {
                return j.oH(str);
            }
            String str2 = str + "_" + this.nZY + "_" + this.mBg;
            Bitmap m = j.m(str2, this.nZY, this.mBg);
            if (m != null) {
                return m;
            }
            int Vo = ExifHelper.Vo(str);
            if (90 == Vo || 270 == Vo) {
                m = com.tencent.mm.sdk.platformtools.d.d(str, this.nZY, this.mBg, true);
            } else {
                m = com.tencent.mm.sdk.platformtools.d.d(str, this.mBg, this.nZY, true);
            }
            if (m == null) {
                return m;
            }
            m = com.tencent.mm.sdk.platformtools.d.b(m, (float) Vo);
            try {
                com.tencent.mm.sdk.platformtools.d.a(m, 100, CompressFormat.PNG, str2, false);
                return m;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
                return m;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r6 = this;
            r2 = 0;
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r0 = r0.vDO;
            if (r0 == 0) goto L_0x0011;
        L_0x0007:
            r0 = "MicroMsg.ImageEngine";
            r1 = "on load image jog, isQuit, return";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        L_0x0010:
            return;
        L_0x0011:
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r1 = r0.gUq;
            monitor-enter(r1);
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x0035 }
            r0 = r0.vDR;	 Catch:{ all -> 0x0035 }
            r3 = r6.vEj;	 Catch:{ all -> 0x0035 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0038;
        L_0x0022:
            r0 = "MicroMsg.ImageEngine";
            r2 = "check before decode, no match wait to render view, renderKey is %s, return";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0035 }
            r4 = 0;
            r5 = r6.vEj;	 Catch:{ all -> 0x0035 }
            r3[r4] = r5;	 Catch:{ all -> 0x0035 }
            com.tencent.mm.sdk.platformtools.x.w(r0, r2, r3);	 Catch:{ all -> 0x0035 }
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            goto L_0x0010;
        L_0x0035:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            throw r0;
        L_0x0038:
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            r0 = 0;
            r1 = r6.vEi;
            if (r1 == 0) goto L_0x0059;
        L_0x003e:
            r1 = r2;
        L_0x003f:
            r3 = r6.vEi;
            r3 = r3.length;
            if (r1 >= r3) goto L_0x0059;
        L_0x0044:
            if (r1 != 0) goto L_0x00c5;
        L_0x0046:
            r0 = r6.vEi;
            r0 = r0[r2];
            r0 = r6.Tu(r0);
            if (r0 == 0) goto L_0x00f2;
        L_0x0050:
            r1 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r1 = r1.vDT;
            r2 = r6.vEj;
            r1.put(r2, r0);
        L_0x0059:
            if (r0 != 0) goto L_0x0080;
        L_0x005b:
            r1 = r6.url;
            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
            if (r1 != 0) goto L_0x0080;
        L_0x0063:
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r1 = r6.vEj;
            r2 = r6.url;
            r3 = r6.nZY;
            r4 = r6.mBg;
            r0 = r0.i(r1, r2, r3, r4);
            r0 = com.tencent.mm.platformtools.j.a(r0);
            if (r0 == 0) goto L_0x0080;
        L_0x0077:
            r1 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r1 = r1.vDT;
            r2 = r6.vEj;
            r1.put(r2, r0);
        L_0x0080:
            r2 = r0;
            if (r2 == 0) goto L_0x00bc;
        L_0x0083:
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r3 = r0.gUq;
            monitor-enter(r3);
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x00f6 }
            r0 = r0.vDR;	 Catch:{ all -> 0x00f6 }
            r1 = r6.vEj;	 Catch:{ all -> 0x00f6 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00f6 }
            r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00b2;
        L_0x0096:
            r1 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x00f6 }
            r1 = r1.vDS;	 Catch:{ all -> 0x00f6 }
            r1.remove(r0);	 Catch:{ all -> 0x00f6 }
            r1 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x00f6 }
            r1 = r1.vDV;	 Catch:{ all -> 0x00f6 }
            r1 = r1.cdm();	 Catch:{ all -> 0x00f6 }
            r1 = (com.tencent.mm.pluginsdk.ui.tools.g.e) r1;	 Catch:{ all -> 0x00f6 }
            r1.fwa = r0;	 Catch:{ all -> 0x00f6 }
            r1.mZu = r2;	 Catch:{ all -> 0x00f6 }
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x00f6 }
            r0 = r0.hbP;	 Catch:{ all -> 0x00f6 }
            r0.post(r1);	 Catch:{ all -> 0x00f6 }
        L_0x00b2:
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;	 Catch:{ all -> 0x00f6 }
            r0 = r0.vDR;	 Catch:{ all -> 0x00f6 }
            r1 = r6.vEj;	 Catch:{ all -> 0x00f6 }
            r0.remove(r1);	 Catch:{ all -> 0x00f6 }
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
        L_0x00bc:
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r0 = r0.vDW;
            r0.C(r6);
            goto L_0x0010;
        L_0x00c5:
            r0 = r6.vEi;
            r0 = r0[r1];
            r3 = r6.url;
            r4 = r6.nZY;
            r5 = r6.mBg;
            r3 = com.tencent.mm.pluginsdk.ui.tools.g.q(r0, r3, r4, r5);
            r0 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r0 = r0.vDT;
            r0 = r0.get(r3);
            r0 = (android.graphics.Bitmap) r0;
            if (r0 != 0) goto L_0x00e7;
        L_0x00df:
            r0 = r6.vEi;
            r0 = r0[r1];
            r0 = r6.Tu(r0);
        L_0x00e7:
            if (r0 == 0) goto L_0x00f2;
        L_0x00e9:
            r1 = com.tencent.mm.pluginsdk.ui.tools.g.this;
            r1 = r1.vDT;
            r1.put(r3, r0);
            goto L_0x0059;
        L_0x00f2:
            r1 = r1 + 1;
            goto L_0x003f;
        L_0x00f6:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.g.b.run():void");
        }
    }

    private abstract class c<K, V> {
        private HashMap<K, a> qqu = new HashMap();
        private final int vEe;
        private a vEk = new a(this);
        private a vEl = new a(this);
        private int vEm = 0;

        private class a {
            public V jXv;
            public a vEn = this.vEk;
            public a vEo = this.vEl;
            public K vEp;

            public a(c cVar) {
                this(null, null, (byte) 0);
            }

            public a(c cVar, K k, V v) {
                this(k, v, (byte) 0);
            }

            private a(a aVar, V v, byte b) {
                this.vEn = null;
                this.vEo = null;
                this.vEp = aVar;
                this.jXv = v;
            }
        }

        protected abstract void bU(V v);

        public c(int i) {
            this.vEe = Math.max(1, i);
        }

        private void a(a aVar) {
            aVar.vEo = this.vEk.vEo;
            aVar.vEo.vEn = aVar;
            this.vEk.vEo = aVar;
            aVar.vEn = this.vEk;
        }

        private static void b(a aVar) {
            aVar.vEn.vEo = aVar.vEo;
            aVar.vEo.vEn = aVar.vEn;
            aVar.vEo = null;
            aVar.vEn = null;
        }

        public final void clear() {
            while (this.vEm > 0) {
                a aVar = this.vEl.vEn;
                b(aVar);
                this.qqu.remove(aVar.vEp);
                bU(aVar.jXv);
                this.vEm--;
            }
        }

        public final V put(K k, V v) {
            synchronized (this) {
                a aVar = (a) this.qqu.get(k);
                if (aVar != null) {
                    b(aVar);
                    V v2 = aVar.jXv;
                    aVar.jXv = v;
                    a(aVar);
                    return v2;
                }
                aVar = new a(this, k, v);
                a(aVar);
                this.qqu.put(k, aVar);
                this.vEm++;
                while (this.vEe < this.vEm) {
                    aVar = this.vEl.vEn;
                    b(aVar);
                    this.qqu.remove(aVar.vEp);
                    bU(aVar.jXv);
                    this.vEm--;
                }
                return null;
            }
        }

        public final V get(K k) {
            V v;
            synchronized (this) {
                a aVar = (a) this.qqu.get(k);
                if (aVar != null) {
                    b(aVar);
                    a(aVar);
                    v = aVar.jXv;
                } else {
                    v = null;
                }
            }
            return v;
        }

        public String toString() {
            String stringBuilder;
            synchronized (this) {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (a aVar = this.vEk.vEo; aVar != this.vEl; aVar = aVar.vEo) {
                    stringBuilder2.append("[key:").append(aVar.vEp).append(", value:").append(aVar.jXv).append("]");
                }
                stringBuilder = stringBuilder2.toString();
            }
            return stringBuilder;
        }
    }

    public static class d extends Drawable {
        static final Paint vEr = new Paint(6);
        final Rect uk = new Rect();
        WeakReference<Bitmap> vEs = new WeakReference(null);
        private boolean vEt = false;
        private boolean vEu = false;

        public static void b(ImageView imageView, Bitmap bitmap) {
            boolean z;
            boolean z2 = true;
            Drawable dVar = imageView.getDrawable() instanceof d ? (d) imageView.getDrawable() : new d();
            dVar.vEs = new WeakReference(bitmap);
            if (imageView.getScaleType() == ScaleType.FIT_XY) {
                z = true;
            } else {
                z = false;
            }
            dVar.vEt = z;
            if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
                z2 = false;
            }
            dVar.vEu = z2;
            imageView.setImageDrawable(dVar);
            imageView.postInvalidate();
        }

        public static void d(ImageView imageView) {
            b(imageView, null);
        }

        public final void draw(Canvas canvas) {
            Object obj;
            Bitmap bitmap = (Bitmap) this.vEs.get();
            if (bitmap == null || bitmap.isRecycled()) {
                obj = null;
            } else {
                copyBounds(this.uk);
                canvas.drawBitmap(bitmap, null, this.uk, vEr);
                obj = 1;
            }
            if (obj == null) {
            }
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }
    }

    public g(int i) {
        this.vDP.start();
        this.vDQ = new ag(this.vDP.getLooper());
        this.hbP = new ag(Looper.getMainLooper());
        this.vDV = new a<e>(this.vDP.getLooper()) {
            protected final /* synthetic */ Object cdl() {
                return new e(g.this, (byte) 0);
            }
        };
        this.vDW = new a<b>(Looper.getMainLooper()) {
            protected final /* synthetic */ Object cdl() {
                return new b(g.this, (byte) 0);
            }
        };
        this.vDU = new SparseArray();
        this.vDT = new c<String, Bitmap>(i) {
            protected final /* synthetic */ void bU(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    x.i("MicroMsg.ImageEngine", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        };
        j.b(this.vDY);
    }

    public final void destory() {
        x.d("MicroMsg.ImageEngine", "do destory");
        this.vDO = true;
        this.vDP.quit();
        j.c(this.vDY);
        final SparseArray sparseArray = this.vDU;
        final c cVar = this.vDT;
        this.vDU = new SparseArray();
        this.vDT = new c<String, Bitmap>() {
            protected final /* bridge */ /* synthetic */ void bU(Object obj) {
            }
        };
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i = 0; i < sparseArray.size(); i++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i);
                    if (bitmap != null) {
                        x.d("MicroMsg.ImageEngine", "recycled def bmp %s", bitmap.toString());
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                x.i("MicroMsg.ImageEngine", "clear drawable cache");
                cVar.clear();
                x.i("MicroMsg.ImageEngine", "end do recycled");
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
    }

    public i i(String str, String str2, int i, int i2) {
        return null;
    }

    private void a(ImageView imageView, int i) {
        if (i == 0) {
            d.d(imageView);
            return;
        }
        Bitmap bitmap = (Bitmap) this.vDU.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.g.a.decodeResource(imageView.getResources(), i);
            this.vDU.put(i, bitmap);
        }
        d.b(imageView, bitmap);
    }

    static String q(String str, String str2, int i, int i2) {
        return bi.aD(str, "null") + "_" + bi.aD(str2, "null") + "_" + i + "_" + i2;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        int i4 = 0;
        if (!this.vDX) {
            return;
        }
        if (this.vDO) {
            x.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
        } else if (imageView == null) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
        } else if ((strArr == null || strArr.length <= 0) && bi.oN(str)) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            a(imageView, i);
        } else {
            String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String q = q(str2, str, i2, i3);
            synchronized (this.gUq) {
                str2 = (String) this.vDS.get(imageView);
                if (str2 != null) {
                    this.vDR.remove(str2);
                }
                this.vDS.put(imageView, q);
            }
            Bitmap bitmap = (Bitmap) this.vDT.get(q);
            if (bitmap == null || bitmap.isRecycled()) {
                x.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", q);
                if (strArr != null && strArr.length > 1) {
                    for (int i5 = 1; i5 < strArr.length; i5++) {
                        bitmap = (Bitmap) this.vDT.get(q(strArr[i5], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = q;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        x.v(str3, str4, objArr);
                        if (bitmap != null) {
                            d.b(imageView, bitmap);
                            i4 = 1;
                            break;
                        }
                    }
                }
                if (i4 == 0) {
                    x.v("MicroMsg.ImageEngine", "use default res to render");
                    a(imageView, i);
                }
                synchronized (this.gUq) {
                    this.vDR.put(q, imageView);
                }
                b bVar = (b) this.vDW.cdm();
                bVar.vEi = strArr;
                bVar.url = str;
                bVar.vEj = q;
                bVar.nZY = i2;
                bVar.mBg = i3;
                this.vDQ.postAtFrontOfQueueV2(bVar);
                return;
            }
            d.b(imageView, bitmap);
        }
    }
}
