package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements com.tencent.liteav.basic.c.a {
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    Surface e;
    d f;
    private ByteBuffer g;
    private ByteBuffer h;
    private long i;
    private boolean j = false;
    private ArrayList<com.tencent.liteav.basic.f.b> k = new ArrayList();
    private a l;
    private WeakReference<com.tencent.liteav.basic.c.a> m;

    private static class a extends Handler {
        a a;
        d b;
        WeakReference<com.tencent.liteav.basic.c.a> c;
        boolean d;
        boolean e;
        Surface f;
        private ByteBuffer g;
        private ByteBuffer h;

        public a(Looper looper) {
            super(looper);
        }

        public void a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, d dVar, com.tencent.liteav.basic.c.a aVar) {
            this.e = z;
            this.d = z2;
            this.f = surface;
            this.g = byteBuffer;
            this.h = byteBuffer2;
            this.b = dVar;
            this.c = new WeakReference(aVar);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    a(((Boolean) message.obj).booleanValue());
                    return;
                case 101:
                    try {
                        Bundle data = message.getData();
                        a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 102:
                    b();
                    return;
                default:
                    return;
            }
        }

        public int a() {
            a aVar = this.a;
            if (aVar != null) {
                return aVar.getDecoderCacheNum();
            }
            return 0;
        }

        private void a(byte[] bArr, long j, long j2, int i) {
            com.tencent.liteav.basic.f.b bVar = new com.tencent.liteav.basic.f.b();
            bVar.a = bArr;
            bVar.g = j;
            bVar.h = j2;
            bVar.i = i;
            if (this.a != null) {
                this.a.decode(bVar);
            }
        }

        private void b() {
            if (this.a != null) {
                this.a.stop();
                this.a.setListener(null);
                this.a.setNotifyListener(null);
                this.a = null;
            }
            Looper.myLooper().quit();
            TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
        }

        private void a(boolean z) {
            if (this.a != null) {
                TXCLog.w("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.d);
                return;
            }
            if (this.d) {
                this.a = new c();
            } else {
                this.a = new TXCVideoFfmpegDecoder();
            }
            this.a.setListener(this.b);
            this.a.setNotifyListener(this.c);
            this.a.config(this.f);
            this.a.start(this.g, this.h, z, this.e);
            TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", hevc: " + this.e);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        com.tencent.liteav.basic.util.a.a(this.m, this.i, i, bundle);
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public boolean a() {
        return this.b;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.m = new WeakReference(aVar);
    }

    public int a(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        return a(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z, z2);
    }

    public int a(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        this.e = surface;
        this.g = byteBuffer;
        this.h = byteBuffer2;
        this.b = z;
        this.a = z2;
        return 0;
    }

    private void b(com.tencent.liteav.basic.f.b bVar) {
        boolean z = bVar.b == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", bVar.a);
        bundle.putLong("pts", bVar.g);
        bundle.putLong("dts", bVar.h);
        bundle.putInt("codecId", bVar.i);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        Handler handler = this.l;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        try {
            Object obj = bVar.b == 0 ? 1 : null;
            if (this.d || obj != null) {
                if (!(this.d || obj == null)) {
                    TXCLog.e("TXCVideoDecoder", "play:decode: push first i frame");
                    this.d = true;
                }
                if (!(this.j || bVar.i != 1 || this.b)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
                    com.tencent.liteav.basic.util.a.a(this.m, (int) TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
                    this.j = true;
                }
                if (this.l != null) {
                    if (!this.k.isEmpty()) {
                        Iterator it = this.k.iterator();
                        while (it.hasNext()) {
                            b((com.tencent.liteav.basic.f.b) it.next());
                        }
                    }
                    this.k.clear();
                    b(bVar);
                    return;
                }
                if (!(obj == null || this.k.isEmpty())) {
                    this.k.clear();
                }
                this.k.add(bVar);
                if (!this.j) {
                    b();
                    return;
                }
                return;
            }
            TXCLog.e("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b() {
        /*
        r10 = this;
        r9 = 2008; // 0x7d8 float:2.814E-42 double:9.92E-321;
        r8 = 0;
        r0 = -1;
        r1 = r10.e;
        if (r1 != 0) goto L_0x0012;
    L_0x0008:
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decoder error when not setup surface";
        com.tencent.liteav.basic.log.TXCLog.e(r1, r2);
    L_0x0011:
        return r0;
    L_0x0012:
        monitor-enter(r10);
        r1 = r10.l;	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x0025;
    L_0x0017:
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decoder error when decoder is started";
        com.tencent.liteav.basic.log.TXCLog.e(r1, r2);	 Catch:{ all -> 0x0022 }
        monitor-exit(r10);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r0 = 0;
        r10.j = r0;	 Catch:{ all -> 0x0022 }
        r1 = new android.os.HandlerThread;	 Catch:{ all -> 0x0022 }
        r0 = "VDecoder";
        r1.<init>(r0);	 Catch:{ all -> 0x0022 }
        r1.start();	 Catch:{ all -> 0x0022 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0022 }
        r2 = "VDecoder";
        r0.<init>(r2);	 Catch:{ all -> 0x0022 }
        r2 = r1.getId();	 Catch:{ all -> 0x0022 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0022 }
        r0 = r0.toString();	 Catch:{ all -> 0x0022 }
        r1.setName(r0);	 Catch:{ all -> 0x0022 }
        r0 = new com.tencent.liteav.videodecoder.b$a;	 Catch:{ all -> 0x0022 }
        r1 = r1.getLooper();	 Catch:{ all -> 0x0022 }
        r0.<init>(r1);	 Catch:{ all -> 0x0022 }
        r1 = r10.c;	 Catch:{ all -> 0x0022 }
        r2 = r10.b;	 Catch:{ all -> 0x0022 }
        r3 = r10.e;	 Catch:{ all -> 0x0022 }
        r4 = r10.g;	 Catch:{ all -> 0x0022 }
        r5 = r10.h;	 Catch:{ all -> 0x0022 }
        r6 = r10.f;	 Catch:{ all -> 0x0022 }
        r7 = r10;
        r0.a(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0022 }
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decode thread";
        com.tencent.liteav.basic.log.TXCLog.w(r1, r2);	 Catch:{ all -> 0x0022 }
        r1 = android.os.Message.obtain();	 Catch:{ all -> 0x0022 }
        r2 = 100;
        r1.what = r2;	 Catch:{ all -> 0x0022 }
        r2 = r10.a;	 Catch:{ all -> 0x0022 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x0022 }
        r1.obj = r2;	 Catch:{ all -> 0x0022 }
        r0.sendMessage(r1);	 Catch:{ all -> 0x0022 }
        r10.l = r0;	 Catch:{ all -> 0x0022 }
        monitor-exit(r10);	 Catch:{ all -> 0x0022 }
        r1 = new android.os.Bundle;
        r1.<init>();
        r0 = "EVT_ID";
        r1.putInt(r0, r9);
        r0 = "EVT_TIME";
        r2 = com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick();
        r1.putLong(r0, r2);
        r2 = "EVT_MSG";
        r0 = r10.b;
        if (r0 == 0) goto L_0x00b9;
    L_0x009e:
        r0 = "启动硬解";
    L_0x00a1:
        r1.putCharSequence(r2, r0);
        r2 = "EVT_PARAM1";
        r0 = r10.b;
        if (r0 == 0) goto L_0x00bd;
    L_0x00ab:
        r0 = 1;
    L_0x00ac:
        r1.putInt(r2, r0);
        r0 = r10.m;
        r2 = r10.i;
        com.tencent.liteav.basic.util.a.a(r0, r2, r9, r1);
        r0 = r8;
        goto L_0x0011;
    L_0x00b9:
        r0 = "启动软解";
        goto L_0x00a1;
    L_0x00bd:
        r0 = 2;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.b.b():int");
    }

    public void c() {
        synchronized (this) {
            if (this.l != null) {
                this.l.sendEmptyMessage(102);
            }
            this.l = null;
        }
        this.k.clear();
        this.d = false;
    }

    public void a(byte[] bArr, long j, int i) {
        a aVar = this.l;
        if (aVar != null && !aVar.d && aVar.a != null) {
            ((TXCVideoFfmpegDecoder) aVar.a).loadNativeData(bArr, j, i);
        }
    }

    public int d() {
        a aVar = this.l;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }
}
