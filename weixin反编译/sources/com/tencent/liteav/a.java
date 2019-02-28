package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.beauty.d;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.mm.BuildConfig;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class a implements d, com.tencent.liteav.videoencoder.d {
    private static final String a = a.class.getSimpleName();
    private int b = 300;
    private long c = 0;
    private a d;
    private HandlerThread e;
    private boolean f = false;
    private com.tencent.liteav.videoencoder.b g;
    private com.tencent.liteav.basic.f.b h;
    private c i = null;
    private WeakReference<b> j = null;

    public interface b {
        void a();

        void a(com.tencent.liteav.basic.f.b bVar);

        void a(com.tencent.liteav.videoencoder.b bVar);
    }

    private class a extends Handler {
        private int b = 300;
        private long c = 0;

        public a(Looper looper, int i, long j) {
            super(looper);
            this.b = i;
            this.c = j;
        }

        public void handleMessage(Message message) {
            if (message.what == 1001) {
                try {
                    a.this.f();
                    if (System.currentTimeMillis() < this.c) {
                        sendEmptyMessageDelayed(1001, (long) this.b);
                        return;
                    }
                    TXCLog.w(a.a, "bkgpush:stop background publish when timeout");
                    if (a.this.j != null && a.this.f) {
                        b bVar = (b) a.this.j.get();
                        if (bVar != null) {
                            bVar.a();
                        }
                        a.this.f = false;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public int a(int i, int i2, int i3) {
        return 0;
    }

    public void a(int i, int i2, int i3, long j) {
        TXCLog.w(a, "bkgpush: got texture");
        if (this.g != null) {
            this.g.a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    public void a(com.tencent.liteav.basic.f.b bVar, int i) {
        Object bVar2;
        this.h = bVar2;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("bkgpush: got nal type: ");
        if (bVar2 != null) {
            bVar2 = Integer.valueOf(bVar2.b);
        }
        TXCLog.w(str, stringBuilder.append(bVar2).toString());
        if (this.g != null) {
            this.g.a(null);
            com.tencent.liteav.videoencoder.b bVar3 = this.g;
            try {
                if (this.j != null) {
                    b bVar4 = (b) this.j.get();
                    if (bVar4 != null) {
                        bVar4.a(bVar3);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(MediaFormat mediaFormat) {
    }

    public a(b bVar) {
        this.j = new WeakReference(bVar);
    }

    public void a(int i, int i2) {
        if (this.f) {
            TXCLog.w(a, "bkgpush: start background publish return when started");
            return;
        }
        this.f = true;
        b(i, i2);
        d();
        if (this.d != null) {
            this.d.sendEmptyMessageDelayed(1001, (long) this.b);
        }
        TXCLog.w(a, "bkgpush: start background publish with time:" + ((this.c - System.currentTimeMillis()) / 1000) + ", interval:" + this.b);
    }

    public void a() {
        this.f = false;
        TXCLog.w(a, "bkgpush: stop background publish");
        e();
    }

    public boolean b() {
        return this.h != null;
    }

    public void a(EGLContext eGLContext, Context context, Bitmap bitmap, int i, int i2) {
        TXCLog.w(a, "bkgpush: generate background push");
        if (bitmap == null) {
            try {
                TXCLog.w(a, "bkgpush: background publish img is empty, add default img");
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Exception e) {
                return;
            } catch (Error e2) {
                return;
            }
        }
        TXCLog.w(a, "bkgpush: generate nal");
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = i;
        tXSVideoEncoderParam.height = i2;
        tXSVideoEncoderParam.fps = 1;
        tXSVideoEncoderParam.gop = 1;
        tXSVideoEncoderParam.enableBFrame = false;
        tXSVideoEncoderParam.realTime = true;
        tXSVideoEncoderParam.encoderProfile = 1;
        tXSVideoEncoderParam.encoderMode = 1;
        tXSVideoEncoderParam.glContext = eGLContext;
        this.g = new com.tencent.liteav.videoencoder.b(2);
        this.g.a((com.tencent.liteav.videoencoder.d) this);
        this.g.a(tXSVideoEncoderParam);
        if (i == 720 || i == BuildConfig.VERSION_CODE) {
            this.g.a(1800);
        } else if (i == 960 || i == 544) {
            this.g.a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        } else {
            this.g.a(800);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Buffer allocateDirect = ByteBuffer.allocateDirect((width * height) * 4);
        bitmap.copyPixelsToBuffer(allocateDirect);
        allocateDirect.rewind();
        if (this.i == null) {
            this.i = new c(context, true);
            this.i.a((d) this);
        }
        this.i.a(com.tencent.liteav.basic.util.a.a(width, height, i, i2));
        this.i.a(false);
        this.i.a(i, i2);
        this.i.a(0);
        this.i.a(allocateDirect.array(), width, height, 0, 2, 0);
        this.i.a();
        this.i.a(null);
        this.i = null;
    }

    private void b(int i, int i2) {
        if (i > 0) {
            if (i >= 8) {
                i = 8;
            } else if (i <= 3) {
                i = 3;
            }
            this.b = 1000 / i;
        } else {
            this.b = 200;
        }
        long j = (long) i2;
        if (i2 > 0) {
            this.c = (j * 1000) + System.currentTimeMillis();
            return;
        }
        this.c = System.currentTimeMillis() + 300000;
    }

    private void d() {
        e();
        this.e = new HandlerThread("TXImageCapturer");
        this.e.start();
        this.d = new a(this.e.getLooper(), this.b, this.c);
    }

    private void e() {
        if (this.d != null) {
            this.d.removeCallbacksAndMessages(null);
            this.d = null;
        }
        if (this.e != null) {
            this.e.quit();
            this.e = null;
        }
    }

    private void f() {
        try {
            if (this.j != null && this.f) {
                b bVar = (b) this.j.get();
                if (bVar != null) {
                    bVar.a(this.h);
                }
            }
        } catch (Exception e) {
        }
    }
}
