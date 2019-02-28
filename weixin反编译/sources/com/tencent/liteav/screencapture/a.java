package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.mm.BuildConfig;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a {
    protected Handler a;
    protected volatile HandlerThread b;
    protected volatile a c;
    protected volatile WeakReference<c> d;
    protected volatile int e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    private Object j;

    protected class a extends Handler {
        public int a = 0;
        public int[] b = null;
        public Surface c = null;
        public SurfaceTexture d = null;
        public int e = 720;
        public int f = BuildConfig.VERSION_CODE;
        public int g = 25;
        protected boolean h = false;
        protected long i = 0;
        protected long j = 0;
        protected b k = null;
        protected d l = null;
        float[] m = new float[16];

        public a(Looper looper, a aVar) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null) {
                if (this.a == a.this.e || 101 == message.what) {
                    switch (message.what) {
                        case 100:
                            a(message);
                            break;
                        case 101:
                            b(message);
                            break;
                        case 102:
                            c(message);
                            break;
                        case 103:
                            d(message);
                            break;
                    }
                    if (message != null && message.obj != null) {
                        ((Runnable) message.obj).run();
                    }
                }
            }
        }

        protected void a(Message message) {
            this.i = 0;
            this.j = 0;
            if (a()) {
                a.this.a(0, this.k.d());
                return;
            }
            b();
            a.this.b();
            a.this.a(20000003, null);
        }

        protected void b(Message message) {
            c c = a.this.c();
            if (c != null) {
                c.a(a.this.j);
            }
            b();
        }

        protected void c(Message message) {
            a.this.a(102, 5);
            if (!a.this.i) {
                return;
            }
            if (this.h) {
                long nanoTime = System.nanoTime();
                if (nanoTime >= this.j + ((((this.i * 1000) * 1000) * 1000) / ((long) this.g))) {
                    if (this.j == 0) {
                        this.j = nanoTime;
                    } else if (nanoTime > this.j + 1000000000) {
                        this.i = 0;
                        this.j = nanoTime;
                    }
                    this.i++;
                    if (this.d != null && this.b != null) {
                        this.d.getTransformMatrix(this.m);
                        this.d.updateTexImage();
                        this.l.a(this.m);
                        GLES20.glViewport(0, 0, this.e, this.f);
                        a.this.a(0, this.l.b(this.b[0]), this.e, this.f, TXCTimeUtil.getTimeTick());
                        return;
                    }
                    return;
                }
                return;
            }
            this.i = 0;
            this.j = System.nanoTime();
        }

        protected void d(Message message) {
            if (message != null) {
                this.g = message.arg1 <= 0 ? 1 : message.arg1;
                this.i = 0;
                this.j = 0;
            }
        }

        protected boolean a() {
            this.k = b.a(null, null, null, this.e, this.f);
            if (this.k == null) {
                return false;
            }
            this.b = new int[1];
            this.b[0] = e.b();
            if (this.b[0] <= 0) {
                this.b = null;
                return false;
            }
            this.d = new SurfaceTexture(this.b[0]);
            this.c = new Surface(this.d);
            this.d.setDefaultBufferSize(this.e, this.f);
            this.d.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    a.this.a(104, new Runnable() {
                        public void run() {
                            a.this.h = true;
                            a.this.a(102);
                        }
                    });
                    surfaceTexture.setOnFrameAvailableListener(null);
                }
            });
            this.l = new d();
            if (!this.l.a()) {
                return false;
            }
            this.l.a(true);
            this.l.a(this.e, this.f);
            this.l.a(g.e, g.a(f.NORMAL, false, false));
            b.a().a(this.c, this.e, this.f);
            return true;
        }

        protected void b() {
            c();
            if (this.l != null) {
                this.l.d();
                this.l = null;
            }
            if (this.k != null) {
                this.k.c();
                this.k = null;
            }
        }

        protected void c() {
            if (this.d != null) {
                this.d.setOnFrameAvailableListener(null);
                this.d.release();
                this.h = false;
                this.d = null;
            }
            b.a().a(this.c);
            if (this.c != null) {
                this.c.release();
                this.c = null;
            }
            if (this.b != null) {
                GLES20.glDeleteTextures(1, this.b, 0);
                this.b = null;
            }
        }
    }

    public a(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 720;
        this.g = BuildConfig.VERSION_CODE;
        this.h = 20;
        this.i = false;
        this.j = null;
        this.a = new Handler(Looper.getMainLooper());
        if (VERSION.SDK_INT >= 21) {
            b.a().a(context);
        }
    }

    public int a(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        if (VERSION.SDK_INT < 21) {
            a(20000004, null);
            return 20000004;
        }
        a();
        return 0;
    }

    public void a(Object obj) {
        this.j = obj;
        b();
    }

    public void a(final boolean z) {
        if (this.c != null) {
            this.c.post(new Runnable() {
                public void run() {
                    a.this.i = z;
                }
            });
        } else {
            this.i = z;
        }
    }

    public void a(c cVar) {
        this.d = new WeakReference(cVar);
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        b.a().a(aVar);
    }

    protected void a() {
        b();
        synchronized (this) {
            this.b = new HandlerThread("HWVideoEncoder");
            this.b.start();
            this.c = new a(this.b.getLooper(), this);
            this.e++;
            this.c.a = this.e;
            this.c.e = this.f;
            this.c.f = this.g;
            this.c.g = this.h <= 0 ? 1 : this.h;
        }
        a(100);
    }

    protected void b() {
        synchronized (this) {
            this.e++;
            if (this.c != null) {
                final HandlerThread handlerThread = this.b;
                final Handler handler = this.c;
                a(101, new Runnable() {
                    public void run() {
                        a.this.a.post(new Runnable() {
                            public void run() {
                                if (handler != null) {
                                    handler.removeCallbacksAndMessages(null);
                                }
                                if (handlerThread == null) {
                                    return;
                                }
                                if (VERSION.SDK_INT >= 18) {
                                    handlerThread.quitSafely();
                                } else {
                                    handlerThread.quit();
                                }
                            }
                        });
                    }
                });
            }
            this.c = null;
            this.b = null;
        }
    }

    protected c c() {
        return this.d == null ? null : (c) this.d.get();
    }

    protected void a(int i, long j) {
        synchronized (this) {
            if (this.c != null) {
                this.c.sendEmptyMessageDelayed(i, j);
            }
        }
    }

    protected void a(int i) {
        synchronized (this) {
            if (this.c != null) {
                this.c.sendEmptyMessage(i);
            }
        }
    }

    protected void a(int i, Runnable runnable) {
        synchronized (this) {
            if (this.c != null) {
                Message message = new Message();
                message.what = i;
                message.obj = runnable;
                this.c.sendMessage(message);
            }
        }
    }

    protected void a(int i, EGLContext eGLContext) {
        c c = c();
        if (c != null) {
            c.a(i, eGLContext);
        }
    }

    protected void a(int i, int i2, int i3, int i4, long j) {
        c c = c();
        if (c != null) {
            c.a(i, i2, i3, i4, j);
        }
    }
}
