package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.k;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b extends com.tencent.liteav.basic.module.a {
    private static Integer r = Integer.valueOf(1);
    private static final String u = b.class.getSimpleName();
    private static int v = 0;
    private c a = null;
    private d b = null;
    private WeakReference<com.tencent.liteav.basic.c.a> c = null;
    private int d = 0;
    private int e = 2;
    private int f = 1;
    private Timer g = null;
    private TimerTask h = null;
    private LinkedList<Runnable> i = new LinkedList();
    private TXSVideoEncoderParam j;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private int o = 0;
    private com.tencent.liteav.basic.d.b p;
    private com.tencent.liteav.basic.util.b q;
    private boolean s;
    private k t;

    static class a extends TimerTask {
        private WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference(bVar);
        }

        public void run() {
            if (this.a != null) {
                b bVar = (b) this.a.get();
                if (bVar == null) {
                    return;
                }
                if (bVar.n < bVar.o) {
                    int[] a = com.tencent.liteav.basic.util.a.a();
                    b.j(bVar);
                    bVar.k = bVar.k + ((float) (a[0] / 10));
                    bVar.l = ((float) (a[1] / 10)) + bVar.l;
                    bVar.m = bVar.m + ((float) ((bVar.b() * 100) / ((long) bVar.j.fps)));
                    return;
                }
                if (com.tencent.liteav.basic.e.b.a().a(bVar.k / ((float) bVar.o), bVar.l / ((float) bVar.o), bVar.m / ((float) bVar.o)) && com.tencent.liteav.basic.e.b.a().c() != 0) {
                    bVar.e();
                }
                bVar.d();
            }
        }
    }

    static /* synthetic */ int j(b bVar) {
        int i = bVar.n + 1;
        bVar.n = i;
        return i;
    }

    public b(int i) {
        this.e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam r10) {
        /*
        r9 = this;
        r8 = 3;
        r7 = 2;
        r6 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        r5 = 0;
        r4 = 1;
        r9.j = r10;
        r0 = 10000002; // 0x989682 float:1.4012987E-38 double:4.9406574E-317;
        r1 = com.tencent.liteav.basic.e.b.a();
        r1 = r1.c();
        r2 = r9.e;
        if (r2 != r4) goto L_0x0060;
    L_0x0017:
        if (r1 == 0) goto L_0x0060;
    L_0x0019:
        r1 = new com.tencent.liteav.videoencoder.a;
        r1.<init>();
        r9.a = r1;
        r9.f = r4;
        r1 = "启动硬编";
        r9.a(r6, r1, r4);
    L_0x0028:
        r1 = 4004; // 0xfa4 float:5.611E-42 double:1.978E-320;
        r2 = r9.f;
        r2 = (long) r2;
        r2 = java.lang.Long.valueOf(r2);
        r9.setStatusValue(r1, r2);
        r1 = r9.a;
        if (r1 == 0) goto L_0x0092;
    L_0x0038:
        r0 = r9.b;
        if (r0 == 0) goto L_0x0043;
    L_0x003c:
        r0 = r9.a;
        r1 = r9.b;
        r0.setListener(r1);
    L_0x0043:
        r0 = r9.d;
        if (r0 == 0) goto L_0x004e;
    L_0x0047:
        r0 = r9.a;
        r1 = r9.d;
        r0.setBitrate(r1);
    L_0x004e:
        r0 = r9.a;
        r1 = r9.getID();
        r0.setID(r1);
        r0 = r9.a;
        r0 = r0.start(r10);
        if (r0 == 0) goto L_0x0092;
    L_0x005f:
        return r0;
    L_0x0060:
        r2 = r9.e;
        if (r2 != r8) goto L_0x0082;
    L_0x0064:
        r2 = r10.width;
        r3 = 720; // 0x2d0 float:1.009E-42 double:3.557E-321;
        if (r2 != r3) goto L_0x0082;
    L_0x006a:
        r2 = r10.height;
        r3 = 1280; // 0x500 float:1.794E-42 double:6.324E-321;
        if (r2 != r3) goto L_0x0082;
    L_0x0070:
        if (r1 == 0) goto L_0x0082;
    L_0x0072:
        r1 = new com.tencent.liteav.videoencoder.a;
        r1.<init>();
        r9.a = r1;
        r9.f = r4;
        r1 = "启动硬编";
        r9.a(r6, r1, r4);
        goto L_0x0028;
    L_0x0082:
        r1 = new com.tencent.liteav.videoencoder.TXCSWVideoEncoder;
        r1.<init>();
        r9.a = r1;
        r9.f = r7;
        r1 = "启动软编";
        r9.a(r6, r1, r7);
        goto L_0x0028;
    L_0x0092:
        r1 = r9.e;
        if (r1 != r8) goto L_0x005f;
    L_0x0096:
        r9.k = r5;
        r9.l = r5;
        r9.m = r5;
        r1 = 0;
        r9.n = r1;
        r1 = com.tencent.liteav.basic.e.b.a();
        r1 = r1.e();
        r9.o = r1;
        r9.c();
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam):int");
    }

    public void setID(String str) {
        super.setID(str);
        if (this.a != null) {
            this.a.setID(str);
        }
        setStatusValue(4004, Long.valueOf((long) this.f));
    }

    public EGLContext a(final int i, final int i2) {
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                StringBuilder stringBuilder = new StringBuilder("CVGLThread");
                Integer num = r;
                r = Integer.valueOf(r.intValue() + 1);
                this.q = new com.tencent.liteav.basic.util.b(stringBuilder.append(num).toString());
            }
            final boolean[] zArr = new boolean[1];
            this.q.a(new Runnable() {
                public void run() {
                    boolean z;
                    b.this.p = com.tencent.liteav.basic.d.b.a(null, null, null, i, i2);
                    boolean[] zArr = zArr;
                    if (b.this.p != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zArr[0] = z;
                }
            });
            if (zArr[0]) {
                return this.p.d();
            }
            return null;
        } else if (this.p != null) {
            return this.p.d();
        } else {
            return null;
        }
    }

    public void a(Runnable runnable) {
        if (this.q != null) {
            this.q.a(runnable);
        }
    }

    protected void b(Runnable runnable) {
        synchronized (this.i) {
            this.i.add(runnable);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(java.util.Queue):boolean");
    }

    public long a(byte[] bArr, int i, int i2, int i3, long j) {
        if (this.p == null) {
            return -1;
        }
        final int i4 = i2;
        final int i5 = i3;
        final int i6 = i;
        final byte[] bArr2 = bArr;
        final long j2 = j;
        this.q.b(new Runnable() {
            public void run() {
                if (!(b.this.t != null && b.this.t.n() == i4 && b.this.t.o() == i5)) {
                    if (b.this.t != null) {
                        b.this.t.d();
                        b.this.t = null;
                    }
                    b.this.t = new k(i6);
                    if (b.this.t.a()) {
                        b.this.t.a(true);
                        b.this.t.a(i4, i5);
                    } else {
                        b.this.p.c();
                        b.this.p = null;
                        b.this.t = null;
                        return;
                    }
                }
                b.this.t.a(bArr2);
                GLES20.glViewport(0, 0, i4, i5);
                int q = b.this.t.q();
                GLES20.glFlush();
                b.this.a(q, b.this.j.width, b.this.j.height, j2);
            }
        });
        return 0;
    }

    public void a() {
        this.i.clear();
        if (this.a != null) {
            this.a.stop();
        }
        if (this.q != null) {
            final c cVar = this.t;
            final com.tencent.liteav.basic.d.b bVar = this.p;
            this.q.b(new Runnable() {
                public void run() {
                    if (cVar != null) {
                        cVar.d();
                    }
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            });
            this.q = null;
            this.t = null;
            this.p = null;
        }
        if (this.e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            d();
        }
        this.b = null;
        this.d = 0;
    }

    public long a(int i, int i2, int i3, long j) {
        do {
        } while (a(this.i));
        if (this.a != null) {
            return this.a.pushVideoFrame(i, i2, i3, j);
        }
        return 10000002;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.c = new WeakReference(aVar);
    }

    public void a(d dVar) {
        this.b = dVar;
        b(new Runnable() {
            public void run() {
                if (b.this.a != null) {
                    b.this.a.setListener(b.this.b);
                }
            }
        });
    }

    public void a(int i) {
        this.d = i;
        b(new Runnable() {
            public void run() {
                if (b.this.a != null) {
                    b.this.a.setBitrate(b.this.d);
                }
            }
        });
    }

    public long b() {
        if (this.a != null) {
            return this.a.getRealFPS();
        }
        return 0;
    }

    private void c() {
        if (this.h == null) {
            this.h = new a(this);
        }
        this.g = new Timer();
        this.g.schedule(this.h, 1000, 1000);
    }

    private void d() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    private void a(int i, String str) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void a(int i, String str, int i2) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                bundle.putInt("EVT_PARAM1", i2);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void e() {
        b(new Runnable() {
            public void run() {
                b.this.a((int) TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW, "软编切硬编");
                if (b.this.a != null) {
                    b.this.a.setListener(null);
                    b.this.a.stop();
                }
                b.this.a = new a();
                b.this.f = 1;
                b.this.setStatusValue(4004, Long.valueOf((long) b.this.f));
                b.this.a.start(b.this.j);
                if (b.this.b != null) {
                    b.this.a.setListener(b.this.b);
                }
                if (b.this.d != 0) {
                    b.this.a.setBitrate(b.this.d);
                }
                b.this.a.setID(b.this.getID());
            }
        });
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    }
}
