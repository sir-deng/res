package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class d extends e implements OnFrameAvailableListener, Renderer {
    private int A = 0;
    private boolean B = true;
    private a C = null;
    private final Queue<Runnable> D = new LinkedList();
    i a;
    j b;
    WeakReference<com.tencent.liteav.basic.c.a> c;
    private SurfaceTexture i;
    private EGLContext j;
    private c k;
    private boolean l = false;
    private int[] m;
    private float[] n = new float[16];
    private int o = 0;
    private boolean p = false;
    private float q = 1.0f;
    private float r = 1.0f;
    private int s = 20;
    private long t = 0;
    private long u = 0;
    private int v = 12288;
    private boolean w = true;
    private boolean x = false;
    private Object y = new Object();
    private int z = 0;

    public interface a {
        void onTakePhotoComplete(Bitmap bitmap);
    }

    public d(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
    }

    public void setFPS(final int i) {
        a(new Runnable() {
            public void run() {
                d.this.s = i;
                if (d.this.s <= 0) {
                    d.this.s = 1;
                } else if (d.this.s > 60) {
                    d.this.s = 60;
                }
                d.this.u = 0;
                d.this.t = 0;
            }
        });
    }

    protected void a() {
        if (this.a != null) {
            this.a.b(null);
        }
    }

    protected void setRunInBackground(boolean z) {
        if (z) {
            synchronized (this) {
                TXCLog.d("TXCGLSurfaceView", "background capture enter background");
                this.e = true;
            }
            return;
        }
        a(new Runnable() {
            public void run() {
                synchronized (this) {
                    TXCLog.d("TXCGLSurfaceView", "background capture exit background");
                    d.this.e = false;
                }
            }
        });
    }

    public void setListener(i iVar) {
        this.a = iVar;
    }

    public void setTextureListener(j jVar) {
        this.b = jVar;
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.c = new WeakReference(aVar);
    }

    public void a(a aVar) {
        this.C = aVar;
        this.B = true;
    }

    public void b() {
        this.l = false;
        this.C = null;
        this.B = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r11, int r12, int r13, boolean r14, int r15, int r16, int r17) {
        /*
        r10 = this;
        r1 = r10.k;
        if (r1 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        monitor-enter(r10);
        r1 = r10.e;	 Catch:{ all -> 0x000c }
        if (r1 == 0) goto L_0x000f;
    L_0x000a:
        monitor-exit(r10);	 Catch:{ all -> 0x000c }
        goto L_0x0004;
    L_0x000c:
        r1 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x000c }
        throw r1;
    L_0x000f:
        monitor-exit(r10);	 Catch:{ all -> 0x000c }
        r10.z = r12;
        r10.A = r13;
        r1 = 0;
        r2 = 0;
        android.opengl.GLES20.glViewport(r1, r2, r12, r13);
        r2 = r10.getWidth();
        r3 = r10.getHeight();
        if (r3 == 0) goto L_0x008b;
    L_0x0023:
        r1 = (float) r2;
        r4 = (float) r3;
        r1 = r1 / r4;
        r4 = r1;
    L_0x0027:
        if (r17 == 0) goto L_0x008f;
    L_0x0029:
        r0 = r16;
        r1 = (float) r0;
        r0 = r17;
        r5 = (float) r0;
        r1 = r1 / r5;
    L_0x0030:
        r5 = r10.p;
        if (r5 != r14) goto L_0x0044;
    L_0x0034:
        r5 = r10.o;
        if (r5 != r15) goto L_0x0044;
    L_0x0038:
        r5 = r10.q;
        r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r5 != 0) goto L_0x0044;
    L_0x003e:
        r5 = r10.r;
        r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r5 == 0) goto L_0x0084;
    L_0x0044:
        r10.p = r14;
        r10.o = r15;
        r10.q = r4;
        r10.r = r1;
        r1 = r10.o;
        r1 = 720 - r1;
        r4 = r1 % 360;
        r1 = 90;
        if (r4 == r1) goto L_0x005a;
    L_0x0056:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        if (r4 != r1) goto L_0x0092;
    L_0x005a:
        r1 = 1;
        r9 = r1;
    L_0x005c:
        if (r9 == 0) goto L_0x0095;
    L_0x005e:
        r6 = r3;
    L_0x005f:
        if (r9 == 0) goto L_0x0097;
    L_0x0061:
        r1 = r10.k;
        r3 = com.tencent.liteav.basic.d.f.NORMAL;
        r5 = 0;
        r7 = 1;
        r5 = com.tencent.liteav.basic.d.g.a(r3, r5, r7);
        r3 = (float) r6;
        r2 = (float) r2;
        r6 = r3 / r2;
        if (r9 == 0) goto L_0x0099;
    L_0x0071:
        r7 = 0;
    L_0x0072:
        if (r9 == 0) goto L_0x009c;
    L_0x0074:
        r8 = r10.p;
    L_0x0076:
        r2 = r16;
        r3 = r17;
        r1.a(r2, r3, r4, r5, r6, r7, r8);
        if (r9 == 0) goto L_0x009e;
    L_0x007f:
        r1 = r10.k;
        r1.g();
    L_0x0084:
        r1 = r10.k;
        r1.a(r11);
        goto L_0x0004;
    L_0x008b:
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = r1;
        goto L_0x0027;
    L_0x008f:
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        goto L_0x0030;
    L_0x0092:
        r1 = 0;
        r9 = r1;
        goto L_0x005c;
    L_0x0095:
        r6 = r2;
        goto L_0x005f;
    L_0x0097:
        r2 = r3;
        goto L_0x0061;
    L_0x0099:
        r7 = r10.p;
        goto L_0x0072;
    L_0x009c:
        r8 = 0;
        goto L_0x0076;
    L_0x009e:
        r1 = r10.k;
        r1.h();
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.a(int, int, int, boolean, int, int, int):void");
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.i;
    }

    public EGLContext getGLContext() {
        return this.j;
    }

    protected int c() {
        if (this.v != 12288) {
            TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.v);
        }
        return this.v;
    }

    public void a(Runnable runnable) {
        synchronized (this.D) {
            this.D.add(runnable);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r3) {
        /*
        r2 = this;
        r1 = 0;
        monitor-enter(r3);
        r0 = r3.isEmpty();	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        r0 = r1;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r3.poll();	 Catch:{ all -> 0x0016 }
        r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x0016 }
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0019;
    L_0x0014:
        r0 = r1;
        goto L_0x000a;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        throw r0;
    L_0x0019:
        r0.run();
        r0 = 1;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.a(java.util.Queue):boolean");
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.j = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.m = new int[1];
        this.m[0] = e.b();
        if (this.m[0] <= 0) {
            this.m = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            return;
        }
        this.i = new SurfaceTexture(this.m[0]);
        this.i.setOnFrameAvailableListener(this);
        this.k = new c();
        if (this.k.a()) {
            this.k.a(g.e, g.a(f.NORMAL, false, false));
            if (this.a != null) {
                this.a.a(this.i);
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 r13) {
        /*
        r12 = this;
        r10 = 1;
        r0 = 0;
        r1 = r12.D;
        r12.a(r1);
    L_0x0008:
        r2 = java.lang.System.currentTimeMillis();
        r4 = r12.u;
        r6 = 0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x0016;
    L_0x0014:
        r12.u = r2;
    L_0x0016:
        r4 = r12.u;
        r4 = r2 - r4;
        r6 = r12.t;
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r8;
        r1 = r12.s;
        r8 = (long) r1;
        r6 = r6 / r8;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x002b;
    L_0x0027:
        r12.g();
        goto L_0x0008;
    L_0x002b:
        r4 = r12.t;
        r4 = r4 + r10;
        r12.t = r4;
        r4 = r12.u;
        r2 = r2 - r4;
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x0041;
    L_0x0039:
        r12.t = r10;
        r2 = java.lang.System.currentTimeMillis();
        r12.u = r2;
    L_0x0041:
        r1 = r12.w;
        if (r1 == 0) goto L_0x0046;
    L_0x0045:
        return;
    L_0x0046:
        monitor-enter(r12);
        r1 = r12.x;	 Catch:{ all -> 0x004d }
        if (r1 != 0) goto L_0x0050;
    L_0x004b:
        monitor-exit(r12);	 Catch:{ all -> 0x004d }
        goto L_0x0045;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x004d }
        throw r0;
    L_0x0050:
        r1 = r12.i;	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x0060;
    L_0x0054:
        r1 = r12.i;	 Catch:{ all -> 0x004d }
        r1.updateTexImage();	 Catch:{ all -> 0x004d }
        r1 = r12.i;	 Catch:{ all -> 0x004d }
        r2 = r12.n;	 Catch:{ all -> 0x004d }
        r1.getTransformMatrix(r2);	 Catch:{ all -> 0x004d }
    L_0x0060:
        r1 = 0;
        r12.x = r1;	 Catch:{ all -> 0x004d }
        monitor-exit(r12);	 Catch:{ all -> 0x004d }
        r1 = r12.b;	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0074;
    L_0x0068:
        r1 = r12.b;	 Catch:{ Exception -> 0x008a }
        r2 = r12.m;	 Catch:{ Exception -> 0x008a }
        r3 = 0;
        r2 = r2[r3];	 Catch:{ Exception -> 0x008a }
        r3 = r12.n;	 Catch:{ Exception -> 0x008a }
        r1.a(r2, r3);	 Catch:{ Exception -> 0x008a }
    L_0x0074:
        r12.f();
        monitor-enter(r12);
        r1 = r12.e;	 Catch:{ all -> 0x0087 }
        if (r1 != 0) goto L_0x007d;
    L_0x007c:
        r0 = 1;
    L_0x007d:
        monitor-exit(r12);	 Catch:{ all -> 0x0087 }
        if (r0 == 0) goto L_0x0045;
    L_0x0080:
        r0 = r12.d();
        r12.v = r0;
        goto L_0x0045;
    L_0x0087:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0087 }
        throw r0;
    L_0x008a:
        r1 = move-exception;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
    }

    private void f() {
        if (this.B) {
            if (!(this.z == 0 || this.A == 0)) {
                boolean z = getWidth() <= getHeight();
                int i = this.A >= this.z ? this.A : this.z;
                int i2 = this.A >= this.z ? this.z : this.A;
                if (z) {
                    int i3 = i;
                    i = i2;
                    i2 = i3;
                }
                final Buffer allocate = ByteBuffer.allocate((i * i2) * 4);
                final Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                allocate.position(0);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocate);
                final int i4 = i;
                final int i5 = i2;
                new Thread(new Runnable() {
                    public void run() {
                        allocate.position(0);
                        createBitmap.copyPixelsFromBuffer(allocate);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, i4, i5, matrix, false);
                        if (d.this.C != null) {
                            d.this.C.onTakePhotoComplete(createBitmap);
                            d.this.C = null;
                        }
                        createBitmap.recycle();
                    }
                }).start();
            }
            this.B = false;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.l) {
            com.tencent.liteav.basic.util.a.a(this.c, 1007, "首帧画面采集完成");
            this.l = true;
        }
        this.w = false;
        synchronized (this) {
            this.x = true;
        }
    }

    public void a(boolean z) {
        this.w = true;
        if (z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            this.v = d();
        }
        synchronized (this) {
            if (this.x) {
                this.x = false;
                if (this.i != null) {
                    this.i.updateTexImage();
                }
            }
        }
    }

    public void b(final boolean z) {
        synchronized (this.y) {
            a(new Runnable() {
                public void run() {
                    synchronized (d.this.y) {
                        d.this.a(z);
                        d.this.y.notifyAll();
                    }
                }
            });
            try {
                this.y.wait(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void g() {
        try {
            Thread.sleep(15);
        } catch (Exception e) {
        }
    }
}
