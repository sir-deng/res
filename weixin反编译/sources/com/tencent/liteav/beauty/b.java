package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.v;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class b extends HandlerThread {
    private float[] A;
    private int B = 0;
    private int C = 0;
    private com.tencent.liteav.basic.d.a D = null;
    private Bitmap E = null;
    private k F = null;
    private n G = null;
    private com.tencent.liteav.beauty.b.b H = null;
    private l I = null;
    private m J = null;
    private v K = null;
    private j L = null;
    private i M = null;
    private c N = null;
    private c O = null;
    private d P = null;
    private final Queue<Runnable> Q = new LinkedList();
    private boolean R;
    private Object S = new Object();
    private Object T = new Object();
    private Handler U;
    private a V;
    private float W = 0.5f;
    private int X = 0;
    private int Y = 0;
    private int Z = 0;
    boolean a = false;
    private int aa = 0;
    private int ab = 0;
    private boolean ac = false;
    private com.tencent.liteav.beauty.a.a.c ad = null;
    private com.tencent.liteav.beauty.a.a.a ae = null;
    private Bitmap af = null;
    private List<c.c> ag = null;
    private long ah = 0;
    private int ai = 0;
    private final int aj = 100;
    private final float ak = 1000.0f;
    private byte[] al = null;
    private int[] am = null;
    private boolean an = false;
    private byte[] ao = null;
    private int ap = -1;
    private int aq = 0;
    private int ar = 1;
    private int as = this.ap;
    private d at = null;
    private com.tencent.liteav.basic.c.a au = null;
    private com.tencent.liteav.basic.d.e.a av = new com.tencent.liteav.basic.d.e.a() {
    };
    protected int[] b = null;
    protected int[] c = null;
    com.tencent.liteav.beauty.b.a d = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a e = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a f = new com.tencent.liteav.beauty.b.a();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private Context m = null;
    private boolean n = true;
    private c.c o = null;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = 0;
    private int y = 0;
    private boolean z = false;

    private class a extends Handler {
        private String b = "EGLDrawThreadHandler";

        a(Looper looper, Context context) {
            super(looper);
        }

        private void a(Object obj) {
            TXCLog.i(this.b, "come into InitEGL");
            a aVar = (a) obj;
            a();
            b.this.ae = new com.tencent.liteav.beauty.a.a.a();
            b.this.ad = new com.tencent.liteav.beauty.a.a.c(b.this.ae, aVar.g, aVar.f, false);
            b.this.ad.b();
            if (b.this.c(aVar)) {
                TXCLog.i(this.b, "come out InitEGL");
            } else {
                TXCLog.e(this.b, "initInternal failed!");
            }
        }

        public void a() {
            TXCLog.i(this.b, "come into releaseEGL");
            if (b.this.am != null && b.this.am[0] > 0) {
                GLES20.glDeleteBuffers(1, b.this.am, 0);
                b.this.am = null;
            }
            b.this.b();
            if (b.this.ad != null) {
                b.this.ad.c();
                b.this.ad = null;
            }
            if (b.this.ae != null) {
                b.this.ae.a();
                b.this.ae = null;
            }
            b.this.ac = false;
            NativeLoad.getInstance();
            NativeLoad.nativeDeleteYuv2Yuv();
            TXCLog.i(this.b, "come out releaseEGL");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r10) {
            /*
            r9 = this;
            r7 = 1;
            super.handleMessage(r10);
            r8 = 0;
            r0 = r10.what;
            switch(r0) {
                case 0: goto L_0x0013;
                case 1: goto L_0x001f;
                case 2: goto L_0x002b;
                case 3: goto L_0x0038;
                case 4: goto L_0x0041;
                case 5: goto L_0x0066;
                case 6: goto L_0x000a;
                case 7: goto L_0x0071;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r8;
        L_0x000b:
            monitor-enter(r9);
            if (r7 != r0) goto L_0x0011;
        L_0x000e:
            r9.notify();	 Catch:{ all -> 0x009d }
        L_0x0011:
            monitor-exit(r9);	 Catch:{ all -> 0x009d }
            return;
        L_0x0013:
            r0 = r10.obj;
            r9.a(r0);
            r0 = com.tencent.liteav.beauty.b.this;
            r0.ac = r7;
            r0 = r7;
            goto L_0x000b;
        L_0x001f:
            r9.a();
            r0 = com.tencent.liteav.beauty.b.this;
            r0 = r0.d;
            r0.a();
            r0 = r8;
            goto L_0x000b;
        L_0x002b:
            r1 = com.tencent.liteav.beauty.b.this;
            r0 = r10.obj;
            r0 = (byte[]) r0;
            r0 = (byte[]) r0;
            r1.b(r0);
            r0 = r8;
            goto L_0x000b;
        L_0x0038:
            r0 = com.tencent.liteav.beauty.b.this;
            r1 = r10.arg1;
            r0.n(r1);
            r0 = r7;
            goto L_0x000b;
        L_0x0041:
            r0 = com.tencent.liteav.beauty.b.this;
            r1 = r10.arg1;
            r2 = (double) r1;
            r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
            r2 = r2 / r4;
            r1 = (float) r2;
            r0.W = r1;
            r0 = com.tencent.liteav.beauty.b.this;
            r0 = r0.I;
            if (r0 == 0) goto L_0x000a;
        L_0x0055:
            r0 = com.tencent.liteav.beauty.b.this;
            r0 = r0.I;
            r1 = com.tencent.liteav.beauty.b.this;
            r1 = r1.W;
            r0.a(r1);
            r0 = r8;
            goto L_0x000b;
        L_0x0066:
            r0 = r10.obj;
            r0 = (com.tencent.liteav.beauty.c.a) r0;
            r1 = com.tencent.liteav.beauty.b.this;
            r1.d(r0);
            r0 = r8;
            goto L_0x000b;
        L_0x0071:
            r0 = com.tencent.liteav.beauty.b.this;
            r1 = com.tencent.liteav.beauty.b.this;
            r1 = r1.t;
            r2 = com.tencent.liteav.beauty.b.this;
            r2 = r2.u;
            r3 = com.tencent.liteav.beauty.b.this;
            r3 = r3.x;
            r4 = r10.arg1;
            r5 = r10.arg2;
            r6 = r10.obj;
            r6 = (java.lang.Integer) r6;
            r6 = r6.intValue();
            r0.a(r1, r2, r3, r4, r5, r6);
            r0 = com.tencent.liteav.beauty.b.this;
            r0 = r0.f;
            r0.a();
            goto L_0x000a;
        L_0x009d:
            r0 = move-exception;
            monitor-exit(r9);	 Catch:{ all -> 0x009d }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.b.a.handleMessage(android.os.Message):void");
        }

        void b() {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    b(Context context, boolean z) {
        super("TXCFilterDrawer");
        this.m = context;
        this.U = new Handler(this.m.getMainLooper());
        this.R = z;
    }

    public synchronized boolean a(a aVar) {
        boolean z;
        z = true;
        if (aVar.j) {
            z = c(aVar);
        } else {
            if (this.V == null) {
                start();
                this.V = new a(getLooper(), this.m);
            }
            this.V.obtainMessage(0, aVar).sendToTarget();
            this.V.b();
        }
        return z;
    }

    public int a(int i, int i2) {
        a(this.Q);
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.O != null) {
            if (4 == i2) {
                this.O.a(this.A);
            }
            i = this.O.b(i);
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.H != null && (this.Y > 0 || this.Z > 0 || this.ab > 0)) {
            i = this.H.b(i);
        }
        if (this.I != null) {
            i = this.I.b(i);
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.L != null) {
            i = this.L.a(i);
        }
        if (this.M != null) {
            i = this.M.b(i);
        }
        if (this.at != null) {
            int a = this.at.a(i, this.t, this.u);
            if (a > 0) {
                i = a;
            }
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.K != null) {
            i = this.K.b(i);
        }
        if (this.N != null) {
            GLES20.glViewport(0, 0, this.v, this.w);
            i = this.N.b(i);
        }
        m(i);
        return i;
    }

    public int a(byte[] bArr, int i) {
        a(bArr);
        if (this.R) {
            b(bArr);
            return n(i);
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        this.V.obtainMessage(2, bArr2).sendToTarget();
        if (!this.an) {
            TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
            NativeLoad.getInstance();
            NativeLoad.nativeClearQueue();
        }
        this.V.obtainMessage(3, i, 0).sendToTarget();
        a(bArr2, this.an);
        this.an = true;
        return -1;
    }

    public void a(final float f) {
        a(new Runnable() {
            public void run() {
                if (b.this.I != null) {
                    b.this.I.a(f);
                }
            }
        });
    }

    public void a(final float[] fArr) {
        a(new Runnable() {
            public void run() {
                b.this.A = fArr;
            }
        });
    }

    private void a(com.tencent.liteav.basic.d.a aVar, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        int i7;
        if (this.O == null) {
            TXCLog.i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i6) {
                this.O = new c("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.O = new c();
            }
            if (true == this.O.a()) {
                this.O.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        }
        this.O.a(i3, i4);
        float[] a = this.O.a(this.p, this.q, null, aVar, i6);
        int i8 = (720 - i5) % 360;
        if (i8 == 90 || i8 == 270) {
            i7 = i4;
        } else {
            i7 = i3;
        }
        if (i8 == 90 || i8 == 270) {
            i4 = i3;
        }
        this.O.a(i, i2, i8, a, ((float) i7) / ((float) i4), z, false);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6) {
        synchronized (this.T) {
            int i7 = ((i6 - i3) + 360) % 360;
            TXCLog.i("TXCFilterDrawer", "real outputAngle " + i7);
            if (this.N == null) {
                if (i == i4 && i2 == i5 && i7 == 0) {
                    TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                    return;
                }
                this.N = new c();
                if (true == this.N.a()) {
                    this.N.a(true);
                } else {
                    TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                }
            }
            this.N.a(i4, i5);
            this.N.a((720 - i7) % 360, null);
        }
    }

    public void a(Bitmap bitmap, float f, float f2, float f3) {
        if (this.o == null) {
            this.o = new c.c();
        }
        if (this.o.a == null || bitmap == null || true != this.o.a.equals(bitmap) || f != this.o.b || f2 != this.o.c || f3 != this.o.d) {
            this.o.a = bitmap;
            this.o.b = f;
            this.o.c = f2;
            this.o.d = f3;
            final Bitmap bitmap2 = bitmap;
            final float f4 = f;
            final float f5 = f2;
            final float f6 = f3;
            a(new Runnable() {
                public void run() {
                    if (bitmap2 != null) {
                        a.a().e();
                    }
                    if (bitmap2 == null) {
                        TXCLog.i("TXCFilterDrawer", "Cancel WaterMark");
                        if (b.this.K != null) {
                            b.this.K.d();
                            b.this.K = null;
                            return;
                        }
                        return;
                    }
                    if (b.this.K == null) {
                        if (b.this.t <= 0 || b.this.u <= 0) {
                            TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
                            return;
                        }
                        b.this.K = new v();
                        b.this.K.a(true);
                        if (b.this.K.a()) {
                            b.this.K.a(b.this.t, b.this.u);
                        } else {
                            TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                            b.this.K.d();
                            b.this.K = null;
                            return;
                        }
                    }
                    b.this.K.c(true);
                    b.this.K.a(bitmap2, f4, f5, f6);
                }
            });
        }
    }

    void a(d dVar) {
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.at = dVar;
    }

    private int m(int i) {
        if (this.C == 0) {
            if (this.at == null) {
                return i;
            }
            this.at.a(i, this.v, this.w, TXCTimeUtil.getTimeTick());
            return i;
        } else if (1 == this.C || 3 == this.C || 2 == this.C) {
            GLES20.glViewport(0, 0, this.v, this.w);
            if (this.G == null) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                return i;
            }
            GLES20.glBindFramebuffer(36160, this.b[0]);
            this.G.a(i);
            if (2 == this.C) {
                b(this.v, this.w);
            } else {
                b(this.v, (this.w * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            return i;
        } else {
            TXCLog.e("TXCFilterDrawer", "Don't support format!");
            return -1;
        }
    }

    private int b(int i, int i2) {
        ByteBuffer byteBuffer = null;
        if (true == this.R) {
            if (this.at != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.al);
                this.at.a(this.al, this.v, this.w, this.C, TXCTimeUtil.getTimeTick());
            } else if (this.ao != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.ao);
            }
        } else if (3 == e.a()) {
            if (0 == this.ah) {
                this.ah = TXCTimeUtil.getTimeTick();
            }
            int i3 = this.ai + 1;
            this.ai = i3;
            if (i3 >= 100) {
                TXCLog.i("TXCFilterDrawer", "Real fps " + (100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.ah)) / 1000.0f)));
                this.ai = 0;
                this.ah = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(1029);
            }
            GLES30.glBindBuffer(35051, this.am[0]);
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixs(i, i2, null);
            if (VERSION.SDK_INT >= 18) {
                byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, (i * i2) * 4, 1);
                if (byteBuffer == null) {
                    TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
                    return -1;
                }
            }
            NativeLoad.getInstance();
            NativeLoad.nativeGlMapBufferToQueue(i, i2, byteBuffer);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glUnmapBuffer(35051);
            }
            GLES30.glBindBuffer(35051, 0);
        } else {
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixsToQueue(i, i2);
        }
        return 0;
    }

    public void a(final int i) {
        a(new Runnable() {
            public void run() {
                b.this.C = i;
            }
        });
    }

    private void a(byte[] bArr, boolean z) {
        if (z) {
            int i = (this.w * 3) / 8;
            if (2 == this.C) {
                i = this.w;
            }
            if (this.at != null) {
                NativeLoad.getInstance();
                if (true == NativeLoad.nativeGlReadPixsFromQueue(this.v, i, this.al)) {
                    this.at.a(this.al, this.v, this.w, this.C, TXCTimeUtil.getTimeTick());
                    return;
                }
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
                this.at.a(bArr, this.v, this.w, this.C, TXCTimeUtil.getTimeTick());
                return;
            }
            NativeLoad.getInstance();
            if (!NativeLoad.nativeGlReadPixsFromQueue(this.v, i, this.ao)) {
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            }
        } else if (this.at != null) {
            this.at.a(bArr, this.v, this.w, this.C, TXCTimeUtil.getTimeTick());
        } else {
            TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
        }
    }

    private int n(int i) {
        GLES20.glViewport(0, 0, this.p, this.q);
        return a(this.F.q(), i);
    }

    public void a(byte[] bArr) {
        this.ao = bArr;
    }

    private void b(byte[] bArr) {
        if (this.F == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
        } else {
            this.F.a(bArr);
        }
    }

    public void a() {
        if (this.R) {
            b();
        } else if (this.V != null) {
            this.V.obtainMessage(1).sendToTarget();
            try {
                this.d.b();
            } catch (InterruptedException e) {
            }
        }
    }

    private void b() {
        TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
        this.an = false;
        if (this.F != null) {
            this.F.d();
            this.F = null;
        }
        if (this.G != null) {
            this.G.d();
            this.G = null;
        }
        c();
        if (this.I != null) {
            this.I.d();
            this.I = null;
        }
        if (this.J != null) {
            this.J.a();
            this.J = null;
        }
        if (this.P != null) {
            this.P.d();
            this.P = null;
        }
        if (this.O != null) {
            this.O.d();
            this.O = null;
        }
        if (this.N != null) {
            this.N.d();
            this.N = null;
        }
        if (this.K != null) {
            this.K.d();
            this.K = null;
        }
        if (this.L != null) {
            this.L.a();
            this.L = null;
        }
        if (this.M != null) {
            this.M.d();
            this.M = null;
        }
        if (this.b != null) {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
            this.b = null;
        }
        if (this.c != null) {
            GLES20.glDeleteTextures(1, this.c, 0);
            this.c = null;
        }
        this.o = null;
        TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    }

    private boolean c(a aVar) {
        boolean z;
        TXCLog.i("TXCFilterDrawer", "come into initInternal");
        b();
        this.R = aVar.j;
        this.p = aVar.d;
        this.q = aVar.e;
        this.D = aVar.m;
        this.r = aVar.g;
        this.s = aVar.f;
        this.x = aVar.h;
        this.z = aVar.i;
        this.v = aVar.b;
        this.w = aVar.c;
        this.y = aVar.a;
        this.t = aVar.g;
        this.u = aVar.f;
        if (this.x == 90 || this.x == 270) {
            this.t = aVar.f;
            this.u = aVar.g;
        }
        this.C = aVar.l;
        this.B = aVar.k;
        this.al = new byte[((this.v * this.w) * 4)];
        a(this.t, this.u, this.X);
        if (!(this.o == null || this.o.a == null || this.K != null)) {
            TXCLog.i("TXCFilterDrawer", "reset water mark!");
            a(this.o.a, this.o.b, this.o.c, this.o.d);
        }
        if (this.E == null || this.I != null) {
            z = true;
        } else {
            this.I = new l(this.E);
            boolean a = this.I.a();
            if (true == a) {
                this.I.a(true);
                this.I.a(this.t, this.u);
                z = a;
            } else {
                TXCLog.e("TXCFilterDrawer", "mLookupFilter init failed!");
                z = a;
            }
        }
        a(this.D, this.r, this.s, this.t, this.u, this.z, this.x, this.B);
        a(this.t, this.u, this.x, this.v, this.w, this.y);
        if (!z) {
            TXCLog.e("TXCFilterDrawer", "initInternal failed! releaseInternal!");
            b();
        }
        if (this.b == null) {
            this.b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
        }
        if (this.c == null) {
            this.c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, this.c, 0);
        }
        a(this.b, this.c, this.v, this.w);
        if (3 == e.a()) {
            if (this.am == null) {
                this.am = new int[1];
            } else {
                TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.am, 0);
            }
            TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            e.a(this.r, this.s, this.am);
        }
        TXCLog.i("TXCFilterDrawer", "come out initInternal");
        return z;
    }

    public boolean b(a aVar) {
        if (this.R) {
            d(aVar);
        } else if (this.V == null) {
            TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
            return false;
        } else {
            this.V.obtainMessage(5, 0, 0, aVar).sendToTarget();
        }
        return true;
    }

    private void a(int[] iArr, int[] iArr2, int i, int i2) {
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = e.a(i, i2, 6408, 6408, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private boolean d(a aVar) {
        if ((1 == aVar.k || 3 == aVar.k || 2 == aVar.k) && this.F == null) {
            this.F = new k(aVar.k);
            this.F.a(true);
            if (this.F.a()) {
                this.F.a(aVar.d, aVar.e);
            } else {
                TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                return false;
            }
        }
        if ((1 == aVar.l || 3 == aVar.l || 2 == aVar.l) && this.G == null) {
            this.G = new n(aVar.l);
            if (this.G.a()) {
                this.G.a(aVar.b, aVar.c);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                return false;
            }
        }
        return true;
    }

    public void b(final int i) {
        this.Y = i;
        a(new Runnable() {
            public void run() {
                if (i > 0) {
                    a.a().b();
                }
                if (b.this.H != null && i >= 0) {
                    b.this.H.c(i);
                }
            }
        });
    }

    public void c(final int i) {
        if (this.X != i && i <= 2 && i >= 0) {
            this.X = i;
            a(new Runnable() {
                public void run() {
                    b.this.c();
                    b.this.a(b.this.t, b.this.u, i);
                }
            });
        }
    }

    public void d(final int i) {
        this.Z = i;
        a(new Runnable() {
            public void run() {
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.H != null && i >= 0) {
                    b.this.H.d(i);
                }
            }
        });
    }

    public void e(final int i) {
        this.aa = i;
        a(new Runnable() {
            public void run() {
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.H != null && i >= 0) {
                    b.this.H.f(i);
                }
            }
        });
    }

    public void f(final int i) {
        this.ab = i;
        a(new Runnable() {
            public void run() {
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.H != null && i >= 0) {
                    b.this.H.e(i);
                }
            }
        });
    }

    public void a(String str) {
    }

    public void a(String str, boolean z) {
    }

    public void a(Bitmap bitmap) {
        if (this.E != bitmap) {
            this.E = bitmap;
            a(new Runnable() {
                public void run() {
                    if (b.this.E != null) {
                        a.a().d();
                    }
                    if (b.this.E == null) {
                        if (b.this.I != null) {
                            b.this.I.d();
                            b.this.I = null;
                        }
                    } else if (b.this.I == null) {
                        b.this.I = new l(b.this.E);
                        b.this.I.a();
                        b.this.I.a(true);
                        b.this.I.a(b.this.t, b.this.u);
                    } else {
                        b.this.I.a(b.this.E);
                    }
                }
            });
        }
    }

    public void g(int i) {
    }

    public void h(int i) {
    }

    public void i(int i) {
    }

    public void j(int i) {
    }

    public void k(int i) {
    }

    public void l(int i) {
    }

    private void a(int i, int i2, int i3) {
        if (this.H == null) {
            TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
            if (i3 == 0) {
                this.H = new com.tencent.liteav.beauty.b.a.a();
            } else if (1 == i3) {
                this.H = new com.tencent.liteav.beauty.b.b.a();
            } else if (2 == i3) {
                this.H = new com.tencent.liteav.beauty.b.c();
            }
            this.H.a(true);
            if (true == this.H.b(i, i2)) {
                if (this.Y > 0) {
                    this.H.c(this.Y);
                }
                if (this.Z > 0) {
                    this.H.d(this.Z);
                }
                if (this.ab > 0) {
                    this.H.e(this.ab);
                }
                if (this.aa > 0) {
                    this.H.f(this.aa);
                    return;
                }
                return;
            }
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
        }
    }

    private void c() {
        if (this.H != null) {
            this.H.d();
            this.H = null;
        }
    }

    private void a(Runnable runnable) {
        synchronized (this.Q) {
            this.Q.add(runnable);
        }
    }

    private void a(Queue<Runnable> queue) {
        while (true) {
            Runnable runnable = null;
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    runnable = (Runnable) queue.poll();
                }
            }
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }
}
