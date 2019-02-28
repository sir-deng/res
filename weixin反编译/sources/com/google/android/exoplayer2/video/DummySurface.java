package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.i.t;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean aCS;
    private static boolean aCT;
    private final a aCU;
    private boolean aCV;
    public final boolean apo;

    private static class a extends HandlerThread implements OnFrameAvailableListener, Callback {
        private final int[] aCW = new int[1];
        private EGLDisplay aCX;
        private EGLContext aCY;
        private EGLSurface aCZ;
        private SurfaceTexture aDa;
        private Error aDb;
        private RuntimeException aDc;
        private DummySurface aDd;
        Handler handler;

        public a() {
            super("dummySurface");
        }

        public final DummySurface aq(boolean z) {
            Object obj = null;
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                while (this.aDd == null && this.aDc == null && this.aDb == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            if (this.aDc != null) {
                throw this.aDc;
            } else if (this.aDb == null) {
                return this.aDd;
            } else {
                throw this.aDb;
            }
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.handler.sendEmptyMessage(2);
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        boolean z;
                        boolean z2 = message.arg1 != 0;
                        this.aCX = EGL14.eglGetDisplay(0);
                        if (this.aCX != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.google.android.exoplayer2.i.a.c(z, "eglGetDisplay failed");
                        int[] iArr = new int[2];
                        com.google.android.exoplayer2.i.a.c(EGL14.eglInitialize(this.aCX, iArr, 0, iArr, 1), "eglInitialize failed");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        int[] iArr2 = new int[1];
                        if (!EGL14.eglChooseConfig(this.aCX, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
                            z = false;
                        } else {
                            z = true;
                        }
                        com.google.android.exoplayer2.i.a.c(z, "eglChooseConfig failed");
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        if (z2) {
                            iArr = new int[]{12440, 2, 12992, 1, 12344};
                        } else {
                            iArr = new int[]{12440, 2, 12344};
                        }
                        this.aCY = EGL14.eglCreateContext(this.aCX, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                        if (this.aCY != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.google.android.exoplayer2.i.a.c(z, "eglCreateContext failed");
                        if (z2) {
                            iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr = new int[5];
                            iArr = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        this.aCZ = EGL14.eglCreatePbufferSurface(this.aCX, eGLConfig, iArr, 0);
                        if (this.aCZ != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.google.android.exoplayer2.i.a.c(z, "eglCreatePbufferSurface failed");
                        com.google.android.exoplayer2.i.a.c(EGL14.eglMakeCurrent(this.aCX, this.aCZ, this.aCZ, this.aCY), "eglMakeCurrent failed");
                        GLES20.glGenTextures(1, this.aCW, 0);
                        this.aDa = new SurfaceTexture(this.aCW[0]);
                        this.aDa.setOnFrameAvailableListener(this);
                        this.aDd = new DummySurface(this, this.aDa, z2, (byte) 0);
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e) {
                        this.aDc = e;
                        synchronized (this) {
                            notify();
                            break;
                        }
                    } catch (Error e2) {
                        this.aDb = e2;
                        synchronized (this) {
                            notify();
                            break;
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                        }
                    }
                    break;
                case 2:
                    this.aDa.updateTexImage();
                    break;
                case 3:
                    try {
                        if (this.aDa != null) {
                            this.aDa.release();
                            GLES20.glDeleteTextures(1, this.aCW, 0);
                        }
                        if (this.aCZ != null) {
                            EGL14.eglDestroySurface(this.aCX, this.aCZ);
                        }
                        if (this.aCY != null) {
                            EGL14.eglDestroyContext(this.aCX, this.aCY);
                        }
                        this.aCZ = null;
                        this.aCY = null;
                        this.aCX = null;
                        this.aDd = null;
                        this.aDa = null;
                        quit();
                        break;
                    } catch (Throwable th2) {
                        quit();
                    }
            }
            return true;
        }
    }

    /* synthetic */ DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z, byte b) {
        this(aVar, surfaceTexture, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean v(android.content.Context r6) {
        /*
        r5 = 24;
        r0 = 1;
        r1 = 0;
        r3 = com.google.android.exoplayer2.video.DummySurface.class;
        monitor-enter(r3);
        r2 = aCT;	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x002d;
    L_0x000b:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        if (r2 < r5) goto L_0x0059;
    L_0x000f:
        r2 = 0;
        r2 = android.opengl.EGL14.eglGetDisplay(r2);	 Catch:{ all -> 0x005b }
        r4 = 12373; // 0x3055 float:1.7338E-41 double:6.113E-320;
        r2 = android.opengl.EGL14.eglQueryString(r2, r4);	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x0025;
    L_0x001c:
        r4 = "EGL_EXT_protected_content";
        r2 = r2.contains(r4);	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x0031;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        if (r2 == 0) goto L_0x0059;
    L_0x0028:
        aCS = r0;	 Catch:{ all -> 0x005b }
        r0 = 1;
        aCT = r0;	 Catch:{ all -> 0x005b }
    L_0x002d:
        r0 = aCS;	 Catch:{ all -> 0x005b }
        monitor-exit(r3);
        return r0;
    L_0x0031:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        if (r2 != r5) goto L_0x0042;
    L_0x0035:
        r2 = "samsung";
        r4 = com.google.android.exoplayer2.i.t.MANUFACTURER;	 Catch:{ all -> 0x005b }
        r2 = r2.equals(r4);	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x0042;
    L_0x0040:
        r2 = r1;
        goto L_0x0026;
    L_0x0042:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        r4 = 26;
        if (r2 >= r4) goto L_0x0057;
    L_0x0048:
        r2 = r6.getPackageManager();	 Catch:{ all -> 0x005b }
        r4 = "android.hardware.vr.high_performance";
        r2 = r2.hasSystemFeature(r4);	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x0057;
    L_0x0055:
        r2 = r1;
        goto L_0x0026;
    L_0x0057:
        r2 = r0;
        goto L_0x0026;
    L_0x0059:
        r0 = r1;
        goto L_0x0028;
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DummySurface.v(android.content.Context):boolean");
    }

    public static DummySurface a(Context context, boolean z) {
        if (t.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        boolean z2 = !z || v(context);
        com.google.android.exoplayer2.i.a.ap(z2);
        return new a().aq(z);
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.aCU = aVar;
        this.apo = z;
    }

    public final void release() {
        super.release();
        synchronized (this.aCU) {
            if (!this.aCV) {
                this.aCU.handler.sendEmptyMessage(3);
                this.aCV = true;
            }
        }
    }
}
