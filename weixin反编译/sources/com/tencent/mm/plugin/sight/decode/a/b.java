package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> qzM = new HashMap();
    private static Map<String, Integer> qzQ = new ConcurrentHashMap();
    private boolean hNJ = false;
    private ag lKV;
    private Surface mSurface;
    public boolean nJb = true;
    public int position;
    private Animation qzA;
    private Animation qzB;
    private volatile h qzC;
    private volatile b qzD;
    public volatile i qzE;
    private volatile c qzF;
    private k qzG;
    private j qzH;
    private d qzI;
    public boolean qzJ = true;
    public boolean qzK = true;
    public boolean qzL = false;
    public boolean qzN = false;
    public double qzO = -1.0d;
    boolean qzP = false;
    public double qzR = -1.0d;
    private boolean qzS = false;
    public boolean qzT = false;
    private a qzU;
    public e qzV;
    public f qzW;
    public g qzX;
    private int qzn = 0;
    private int qzo = 0;
    public String qzp = "";
    private String qzq = "";
    private int qzr = -1;
    protected int qzs = 41;
    private Bitmap qzt;
    public Bitmap qzu;
    private Bitmap qzv;
    private WeakReference<View> qzw;
    private WeakReference<TextView> qzx;
    private long qzy;
    public WeakReference<View> qzz;

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ double qzZ;

        public AnonymousClass3(double d) {
            this.qzZ = d;
        }

        public final void run() {
            x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qzZ), bi.chl().toString());
            b.this.qzR = this.qzZ;
        }
    }

    public interface e {
        void d(b bVar, int i);
    }

    public interface g {
        int btB();

        View btC();

        int btD();
    }

    private class i implements Runnable {
        MediaPlayer qAh;
        double qzR;
        public int type;

        private i() {
            this.qzR = -1.0d;
        }

        public /* synthetic */ i(b bVar, byte b) {
            this();
        }

        private void bdS() {
            x.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qAh != null) {
                    this.qAh.stop();
                    this.qAh.release();
                    this.qAh = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qAh = null;
            }
        }

        public final double btE() {
            if (this.qAh == null) {
                return 0.0d;
            }
            return (double) this.qAh.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            x.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bdS();
                    return;
                case 1:
                    bdS();
                    if (!bi.oN(b.this.qzp)) {
                        try {
                            this.qAh = new com.tencent.mm.compatible.b.j();
                            this.qAh.setDisplay(null);
                            this.qAh.reset();
                            this.qAh.setDataSource(b.this.qzp);
                            this.qAh.setAudioStreamType(3);
                            this.qAh.setOnErrorListener(new OnErrorListener() {
                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", b.this.qzp, Integer.valueOf(i), Integer.valueOf(i2));
                                    b.this.clear();
                                    if (b.this.qzV != null) {
                                        b.this.qzV.d(b.this, -1);
                                    }
                                    return true;
                                }
                            });
                            this.qAh.prepare();
                            this.qAh.start();
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", b.this.qzp);
                            b.this.clear();
                            if (b.this.qzV != null) {
                                b.this.qzV.d(b.this, -1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.qAh != null && this.qAh.isPlaying()) {
                            this.qAh.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bdS();
                        return;
                    }
                case 3:
                    try {
                        if (this.qAh != null) {
                            this.qAh.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bdS();
                        return;
                    }
                case 4:
                    try {
                        x.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qzR));
                        this.qAh.seekTo((int) (this.qzR * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b) {
            this();
        }

        public final void run() {
            if (b.this.qzr >= 0 && b.this.qzx != null && b.this.qzx.get() != null) {
                ((TextView) b.this.qzx.get()).setText(SightVideoJNI.getVideoInfo(b.this.qzr));
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> qAj;

        private k() {
            this.qAj = new WeakReference(null);
        }

        /* synthetic */ k(b bVar, byte b) {
            this();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x020a;
        L_0x0017:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r7 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r7 = 2;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00c9;
        L_0x0041:
            r0 = r2;
        L_0x0042:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 3;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00cc;
        L_0x0051:
            r0 = r2;
        L_0x0052:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 4;
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ce;
        L_0x0061:
            r0 = r2;
        L_0x0062:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 5;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzu;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00d0;
        L_0x0071:
            r0 = r2;
        L_0x0072:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzu;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ec;
        L_0x0083:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzw;	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x009f;
        L_0x0093:
            r1 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r1 = r1.qzw;	 Catch:{ Exception -> 0x00df }
            r1 = r1.get();	 Catch:{ Exception -> 0x00df }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00df }
        L_0x009f:
            if (r1 == 0) goto L_0x00a9;
        L_0x00a1:
            if (r0 == 0) goto L_0x00a9;
        L_0x00a3:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x00d6;
        L_0x00a9:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            if (r1 != 0) goto L_0x00d2;
        L_0x00b5:
            r1 = r2;
        L_0x00b6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00df }
            r1 = 1;
            if (r0 != 0) goto L_0x00d4;
        L_0x00bf:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
        L_0x00c8:
            return;
        L_0x00c9:
            r0 = r3;
            goto L_0x0042;
        L_0x00cc:
            r0 = r3;
            goto L_0x0052;
        L_0x00ce:
            r0 = r3;
            goto L_0x0062;
        L_0x00d0:
            r0 = r3;
            goto L_0x0072;
        L_0x00d2:
            r1 = r3;
            goto L_0x00b6;
        L_0x00d4:
            r2 = r3;
            goto L_0x00bf;
        L_0x00d6:
            r2 = new com.tencent.mm.plugin.sight.decode.a.b$k$1;	 Catch:{ Exception -> 0x00df }
            r2.<init>(r1, r0);	 Catch:{ Exception -> 0x00df }
            r1.post(r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x00df:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00c8;
        L_0x00ec:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0120;
        L_0x00f4:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00df }
            if (r0 != r4) goto L_0x0120;
        L_0x010a:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00df }
            if (r0 == r4) goto L_0x013f;
        L_0x0120:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x018a }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x018a }
            r5 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r5 = r5.qzu;	 Catch:{ Exception -> 0x018a }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x018a }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x018a }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x018a }
            r0.qzv = r4;	 Catch:{ Exception -> 0x018a }
        L_0x013f:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x0147:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x014f:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x01a9;
        L_0x015d:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r6 = 0;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x01a5;
        L_0x016f:
            r0 = r2;
        L_0x0170:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r6 = r6.get();	 Catch:{ Exception -> 0x00df }
            if (r6 != 0) goto L_0x01a7;
        L_0x017f:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x018a:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00df }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = 0;
            r0.qzv = r4;	 Catch:{ Exception -> 0x00df }
            goto L_0x013f;
        L_0x01a5:
            r0 = r3;
            goto L_0x0170;
        L_0x01a7:
            r2 = r3;
            goto L_0x017f;
        L_0x01a9:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.qzv;	 Catch:{ Exception -> 0x00df }
            r6 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.qzu;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0208;
        L_0x01ee:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
        L_0x01fa:
            if (r0 == 0) goto L_0x00c8;
        L_0x01fc:
            if (r2 == 0) goto L_0x00c8;
        L_0x01fe:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$2;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r0, r2);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0208:
            r0 = r1;
            goto L_0x01fa;
        L_0x020a:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r6 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r6 = 2;
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0270;
        L_0x0234:
            r0 = r2;
        L_0x0235:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0246:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0254:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$3;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r0);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
        L_0x025c:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0272;
        L_0x0264:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0270:
            r0 = r3;
            goto L_0x0235;
        L_0x0272:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r1 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.qzu;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.k.run():void");
        }
    }

    private static class a extends com.tencent.mm.sdk.b.c<rv> {
        int mxY = 0;
        int qAa = 0;
        int qAb = 0;
        WeakReference<b> qAc;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r5 = 0;
            r9 = (com.tencent.mm.f.a.rv) r9;
            r0 = r8.qAc;
            r0 = r0.get();
            if (r0 == 0) goto L_0x0082;
        L_0x000d:
            r1 = "MicroMsg.SightPlayController";
            r2 = "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B";
            r0 = 7;
            r3 = new java.lang.Object[r0];
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.hashCode();
            r0 = java.lang.Integer.valueOf(r0);
            r3[r5] = r0;
            r0 = r9.fKt;
            r0 = r0.type;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r6] = r0;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.position;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r7] = r0;
            r0 = 3;
            r4 = r9.fKt;
            r4 = r4.fKu;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 4;
            r4 = r9.fKt;
            r4 = r4.fKv;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 5;
            r4 = r9.fKt;
            r4 = r4.fKw;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r4 = 6;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzT;
            r0 = java.lang.Boolean.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
            r0 = r9.fKt;
            r0 = r0.type;
            switch(r0) {
                case 0: goto L_0x00bf;
                case 1: goto L_0x009a;
                case 2: goto L_0x0082;
                case 3: goto L_0x0083;
                case 4: goto L_0x0082;
                case 5: goto L_0x00e2;
                case 6: goto L_0x008f;
                case 7: goto L_0x00a6;
                default: goto L_0x0082;
            };
        L_0x0082:
            return r5;
        L_0x0083:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x0082;
        L_0x008f:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.qzT = r6;
        L_0x009a:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.ie(r5);
            goto L_0x0082;
        L_0x00a6:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzT;
            if (r0 == 0) goto L_0x0082;
        L_0x00b4:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.qzT = r5;
        L_0x00bf:
            r8.a(r9);
            r0 = r8.btA();
            if (r0 == 0) goto L_0x0082;
        L_0x00c8:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzT;
            if (r0 != 0) goto L_0x0082;
        L_0x00d6:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x0082;
        L_0x00e2:
            r8.a(r9);
            r0 = r8.btA();
            if (r0 == 0) goto L_0x01a4;
        L_0x00eb:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzT;
            if (r0 != 0) goto L_0x01a4;
        L_0x00f9:
            r1 = "ERROR#PATH";
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzq;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x010e:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = r0.qzp;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzq;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x012c:
            r1 = "MicroMsg.SightPlayController";
            r2 = "match diff path, change %s to %s";
            r3 = new java.lang.Object[r7];
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzp;
            r3[r5] = r0;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzq;
            r3[r6] = r0;
            com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzq;
            if (r0 != 0) goto L_0x0196;
        L_0x0161:
            r0 = "";
            r1 = r0;
        L_0x0165:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.qzp = r1;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = "ERROR#PATH";
            r0.qzq = r1;
        L_0x0189:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x0082;
        L_0x0196:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.qzq;
            r1 = r0;
            goto L_0x0165;
        L_0x01a4:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x0082;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.a.a(com.tencent.mm.sdk.b.b):boolean");
        }

        public a(b bVar) {
            super(0);
            this.qAc = new WeakReference(bVar);
            this.xmG = rv.class.getName().hashCode();
        }

        private void a(rv rvVar) {
            this.qAa = rvVar.fKt.fKw;
            this.qAb = rvVar.fKt.fKu;
            this.mxY = rvVar.fKt.fKv;
        }

        private boolean btA() {
            if (this.qAc.get() == null) {
                return false;
            }
            int D = ((b) this.qAc.get()).position + this.qAa;
            if (D < this.qAb || D > this.mxY) {
                return false;
            }
            return true;
        }
    }

    private class b implements Runnable {
        volatile boolean ozn;
        c qAd;

        private b() {
            this.ozn = false;
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void run() {
            if (!(b.this.qzX == null || b.this.qzX.btC() == null || b.this.qzX.btC().getVisibility() != 0)) {
                b.this.lKV.post(new Runnable() {
                    public final void run() {
                        b.this.qzX.btC().setVisibility(8);
                    }
                });
            }
            if (b.this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.this.qzp);
            } else if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
            } else {
                float f;
                double btE;
                if (b.this.qzy == 0) {
                    if (b.this.qzE != null) {
                        b.this.qzE.type = 1;
                        b.this.qzE.run();
                    }
                    b.this.qzy = System.currentTimeMillis();
                }
                Object obj = null;
                if (b.this.qzR != -1.0d) {
                    if (b.this.qzL) {
                        if (b.this.qzE != null) {
                            b.this.qzE.type = 4;
                            b.this.qzE.qzR = b.this.qzR;
                            b.this.qzE.run();
                            b.this.lKV.postDelayed(new Runnable() {
                                public final void run() {
                                    b.this.qzS = true;
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(b.this.qzR, b.this.qzr) > 0) {
                            if (b.this.qzE == null) {
                                b.this.qzE = new i(b.this, (byte) 0);
                            }
                            b.this.qzE.type = 4;
                            b.this.qzE.qzR = b.this.qzR;
                            b.this.qzE.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(b.this.qzR, b.this.qzr) > 0) {
                        if (b.this.qzE == null) {
                            b.this.qzE = new i(b.this, (byte) 0);
                        }
                        b.this.qzE.type = 4;
                        b.this.qzE.qzR = b.this.qzR;
                        b.this.qzE.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - b.this.qzy);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) b.this.qzs)) + 0.5f;
                }
                if (b.this.qzL && b.this.qzS) {
                    b.this.qzS = false;
                    if (b.this.qzE != null) {
                        btE = b.this.qzE.btE() / 1000.0d;
                        if (SightVideoJNI.seekStream(btE, b.this.qzr) > 0) {
                            f = 0.0f;
                            x.i("MicroMsg.SightPlayController", "seek to " + btE + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (b.this.hNJ) {
                    x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.qzr), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                b.this.qzy = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    b.this.qzn = b.this.qzn + 1;
                } else {
                    b.this.qzn = Math.max(0, b.this.qzn - 1);
                }
                if (b.this.btv()) {
                    x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(b.this.qzn));
                    b.this.clear();
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == b.this.qzo) {
                    Object obj3;
                    if (b.this.mSurface == null || b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(b.this.qzr, b.this.mSurface, (int) f2, b.this.qzu, b.this.nJb);
                        if (b.this.qzW != null) {
                            btE = SightVideoJNI.getVideoPlayTime(b.this.qzr);
                            i = (int) btE;
                            if (i != ((int) b.this.qzO)) {
                                b.this.qzW.b(b.this, (long) i);
                            }
                            b.this.qzO = btE;
                        }
                        if (i2 == 0) {
                            b.this.qzR = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            b.this.qzR = -1.0d;
                            obj3 = 1;
                            b.this.qzy = 0;
                            b.A(b.this);
                        } else if (-7 == i2) {
                            x.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ozn = true;
                            if (this.qAd != null) {
                                this.qAd.ozn = true;
                            }
                            b.this.C(null);
                            if (b.this.qzV != null) {
                                b.this.qzV.d(b.this, -1);
                            }
                            obj3 = null;
                        }
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ozn = true;
                        if (this.qAd != null) {
                            this.qAd.ozn = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (b.this.qzE != null) {
                        x.d("MicroMsg.SightPlayController", "voice time is" + (b.this.qzE.btE() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(b.this.qzr, b.this.qzt, (int) f2, null, false, b.this.nJb);
                    if (b.this.qzW != null) {
                        btE = SightVideoJNI.getVideoPlayTime(b.this.qzr);
                        i = (int) btE;
                        if (i != ((int) b.this.qzO)) {
                            b.this.qzW.b(b.this, (long) i);
                        }
                        b.this.qzO = btE;
                        if (b.this.hNJ) {
                            x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(btE));
                        }
                    } else if (b.this.hNJ) {
                        btE = SightVideoJNI.getVideoPlayTime(b.this.qzr);
                        if (b.this.hNJ) {
                            x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(btE));
                        }
                    } else if (b.this.hNJ) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        b.this.qzR = -1.0d;
                    } else if (1 == i2) {
                        b.this.qzR = -1.0d;
                        obj2 = 1;
                        b.this.qzy = 0;
                        b.A(b.this);
                    } else {
                        b.this.qzR = -1.0d;
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ozn = true;
                        if (this.qAd != null) {
                            this.qAd.ozn = true;
                        }
                        b.this.lKV.post(new Runnable() {
                            public final void run() {
                                b.this.D(null);
                            }
                        });
                        if (b.this.qzV != null) {
                            b.this.qzV.d(b.this, -1);
                        }
                    }
                }
                if (1 == i2) {
                    b.this.lKV.post(new Runnable() {
                        public final void run() {
                            if (b.this.qzV != null) {
                                b.this.qzV.d(b.this, 0);
                            }
                        }
                    });
                }
                if (this.ozn) {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (b.this.qzE != null) {
                        b.this.qzE.type = 0;
                        b.this.qzE.run();
                        return;
                    }
                    return;
                }
                if (1 == b.this.qzo) {
                    long currentTimeMillis2 = ((long) b.this.qzs) - (System.currentTimeMillis() - b.this.qzy);
                    if (b.this.qzy == 0) {
                        o.c(this, (long) (b.this.qzs * 5));
                    } else if (currentTimeMillis2 > 0) {
                        o.c(this, currentTimeMillis2);
                    } else {
                        o.c(this, 0);
                    }
                } else if (obj2 == null || b.this.qzX == null) {
                    this.qAd.qAf = i2;
                    b.this.lKV.post(this.qAd);
                } else {
                    i = b.this.qzX.btB();
                    b.this.lKV.post(new Runnable() {
                        public final void run() {
                            if (b.this.qzX != null) {
                                View btC = b.this.qzX.btC();
                                if (btC != null) {
                                    if (!(b.this.qzB != null || b.this.qzX.btD() == -1 || b.this.qzz.get() == null)) {
                                        b.this.qzB = AnimationUtils.loadAnimation(((View) b.this.qzz.get()).getContext(), b.this.qzX.btD());
                                    }
                                    if (b.this.qzB != null) {
                                        btC.startAnimation(b.this.qzB);
                                    }
                                    btC.setVisibility(0);
                                }
                            }
                        }
                    });
                    this.qAd.qAf = i2;
                    b.this.lKV.postDelayed(this.qAd, (long) i);
                }
                if (b.this.qzE != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (b.this.qzE.btE() / 1000.0d));
                }
            }
        }
    }

    private class c implements Runnable {
        volatile boolean ozn = false;
        int qAf;
        b qAg;

        public c() {
            x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
        }

        public final void run() {
            if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                return;
            }
            b.this.D(b.this.qzt);
            if (b.this.qzy == 0) {
                o.c(this.qAg, 0);
                return;
            }
            long currentTimeMillis = ((long) b.this.qzs) - (System.currentTimeMillis() - b.this.qzy);
            if (currentTimeMillis > 0) {
                o.c(this.qAg, currentTimeMillis);
            } else {
                o.c(this.qAg, 0);
            }
        }
    }

    private class h implements Runnable {
        volatile boolean ozn;

        private h() {
            this.ozn = false;
        }

        /* synthetic */ h(b bVar, byte b) {
            this();
        }

        public final void run() {
            if (b.this.btv()) {
                x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                return;
            }
            b.this.qzr = SightVideoJNI.openFile(b.this.qzp, 1 == b.this.qzo ? 0 : 1, 1, false);
            if (b.this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.qzr), b.this.qzp);
                b.this.C(null);
                if (b.this.qzV != null) {
                    b.this.qzV.d(b.this, -1);
                    return;
                }
                return;
            }
            if (((Boolean) com.tencent.mm.kernel.g.Dq().Db().get(344065, Boolean.valueOf(false))).booleanValue()) {
                if (b.this.qzH == null) {
                    b.this.qzH = new j(b.this, (byte) 0);
                }
                b.this.lKV.removeCallbacks(b.this.qzH);
                b.this.lKV.post(b.this.qzH);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(b.this.qzr));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.this.qzr));
            if (b.this.qzo == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    return;
                }
                b.a(b.this, max, max2);
            }
            b.this.btw();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!bi.oN(b.this.qzp)) {
                    b.qzQ.put(b.this.qzp, Integer.valueOf(2));
                }
                b.this.qzy = 0;
                b.this.wC(b.this.qzr);
                b.this.qzr = -1;
                b.this.qzp = "";
                b.this.qzq = "ERROR#PATH";
                b.this.qzv = null;
                this.ozn = true;
                if (b.this.qzV != null) {
                    b.this.qzV.d(b.this, -1);
                    return;
                }
                return;
            }
            b.this.cl(max, max2);
            if (1 == b.this.qzo) {
                b.this.qzD = new b(b.this, (byte) 0);
                b.this.qzF = null;
                if (!this.ozn) {
                    o.c(b.this.qzD, 0);
                }
            } else {
                b.this.qzD = new b(b.this, (byte) 0);
                b.this.qzF = new c();
                b.this.qzD.qAd = b.this.qzF;
                b.this.qzF.qAg = b.this.qzD;
                if (!this.ozn) {
                    o.c(b.this.qzD, 0);
                }
            }
            if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ozn));
            }
        }
    }

    private class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(b bVar, byte b) {
            this();
        }

        public final void run() {
            if (b.this.qzz.get() != null) {
                ((View) b.this.qzz.get()).startAnimation(b.this.qzA);
            }
        }
    }

    public interface f {
        void b(b bVar, long j);
    }

    public abstract void D(Bitmap bitmap);

    public abstract void cl(int i, int i2);

    static /* synthetic */ void A(b bVar) {
        if (bVar.qzz != null && -1 != bVar.btt() && bVar.qzJ) {
            if (bVar.qzA == null && bVar.qzz.get() != null) {
                bVar.qzA = AnimationUtils.loadAnimation(((View) bVar.qzz.get()).getContext(), bVar.btt());
            }
            if (bVar.qzI == null) {
                bVar.qzI = new d(bVar, (byte) 0);
            }
            bVar.lKV.post(bVar.qzI);
        }
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(bVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (bVar.qzt == null) {
            bVar.qzt = com.tencent.mm.memory.o.hbY.a(new com.tencent.mm.memory.o.b(i, i2));
            x.j("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", bVar.qzp);
        } else if (bVar.qzt.getWidth() != i || bVar.qzt.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.qzt.getWidth() + "*" + bVar.qzt.getHeight());
            if (!com.tencent.mm.compatible.util.d.fN(19) || bVar.qzt.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.qzt.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                com.tencent.mm.memory.o.hbY.g(bVar.qzt);
                bVar.qzt = com.tencent.mm.memory.o.hbY.a(new com.tencent.mm.memory.o.b(i, i2));
            }
            x.j("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", bVar.qzp);
        }
    }

    public static Bitmap b(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) qzM.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long Wz = bi.Wz();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            qzM.put(format, new WeakReference(createBitmap));
            x.d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(bi.bB(Wz)));
            return createBitmap;
        }
    }

    public static void Ez() {
        o.c(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    SightVideoJNI.freeAll();
                } catch (Throwable e) {
                    x.e("MicroMsg.SightPlayController", "free all sight error");
                    x.printErrStackTrace("MicroMsg.SightPlayController", e, "", new Object[0]);
                }
                x.i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public b(int i, View view) {
        this.qzo = i;
        this.lKV = new ag(Looper.getMainLooper());
        this.qzz = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i));
    }

    public int btt() {
        return -1;
    }

    public final void ie(boolean z) {
        if (this.qzC != null) {
            o.k(this.qzC);
            this.qzC.ozn = true;
        }
        if (this.qzF != null) {
            this.lKV.removeCallbacks(this.qzF);
            this.qzF.ozn = true;
        }
        if (this.qzD != null) {
            o.k(this.qzD);
            this.qzD.ozn = true;
        }
        if (this.qzE != null) {
            this.qzE.type = z ? 0 : 2;
            o.c(this.qzE, 0);
        }
    }

    public final boolean btu() {
        if (1 == this.qzo) {
            if (this.qzD == null || this.qzD.ozn) {
                return false;
            }
            return true;
        } else if (this.qzF == null || this.qzF.ozn || this.qzD == null || this.qzD.ozn) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.qzK), this.qzp, Integer.valueOf(this.qzr));
        if (!this.qzK) {
            clear();
        } else if (btu()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.qzp);
        } else {
            boolean z;
            if (this.qzr < 0) {
                z = true;
            } else {
                z = false;
            }
            ie(z);
            this.qzy = 0;
            if (btv()) {
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.qzp);
                if (!bi.oN(this.qzp)) {
                    if (JY(this.qzp)) {
                        this.qzC = new h();
                        o.c(this.qzC, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qzo) {
                this.qzD = new b();
                this.qzF = null;
                o.c(this.qzD, 0);
            } else {
                this.qzD = new b();
                this.qzF = new c();
                this.qzD.qAd = this.qzF;
                this.qzF.qAg = this.qzD;
                o.c(this.qzD, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qzr), Boolean.valueOf(btu()));
        ie(true);
        this.qzy = 0;
        wC(this.qzr);
        this.qzr = -1;
        this.qzp = "";
        this.qzq = "ERROR#PATH";
        this.qzv = null;
        this.qzO = 0.0d;
        this.qzP = false;
        com.tencent.mm.memory.o.hbY.g(this.qzt);
        this.qzt = null;
    }

    private void wC(final int i) {
        o.c(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                x.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(b.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public final void aA(String str, boolean z) {
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.qzp, Boolean.valueOf(z), Integer.valueOf(this.qzr), Boolean.valueOf(this.qzT), Boolean.valueOf(this.qzK));
        if (this.qzT) {
            ie(false);
        } else if (btv()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.qzK) {
            clear();
        } else if (z) {
            this.qzq = str;
            ie(false);
        } else if (this.qzp.equals(str)) {
            this.qzq = "ERROR#PATH";
            ie(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.qzp = str;
            if (bi.oN(this.qzp)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                C(null);
            } else if (JY(this.qzp)) {
                this.qzC = new h();
                o.c(this.qzC, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    public static boolean JY(String str) {
        if (bi.oN(str)) {
            return false;
        }
        Integer num = (Integer) qzQ.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean btv() {
        if (this.qzN) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.qzn < 3) {
                return false;
            }
            x.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.qzn = 0;
            return false;
        } else if (this.qzn >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void btw() {
        this.qzs = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.qzr));
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qzs));
    }

    public final void d(Surface surface) {
        x.v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.mSurface = surface;
        o.c(this.qzG, 0);
    }

    public final void h(TextView textView) {
        this.qzx = new WeakReference(textView);
    }

    public final void C(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        o.k(this.qzG);
        if (this.qzG == null) {
            this.qzG = new k();
        }
        this.qzG.qAj = new WeakReference(bitmap);
        o.c(this.qzG, 0);
    }

    public final com.tencent.mm.sdk.b.c btx() {
        if (this.qzU == null) {
            this.qzU = new a(this);
        }
        return this.qzU;
    }

    public final double bty() {
        if (this.qzr == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.qzr);
    }
}
