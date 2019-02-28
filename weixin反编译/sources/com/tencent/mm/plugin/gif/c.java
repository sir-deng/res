package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.bu.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class c extends a {
    private final Paint fC;
    private int hGs;
    private ag lKV;
    private float mDensity;
    boolean mIsRunning;
    private long nEA;
    private long nEB;
    private int nEC;
    private boolean nED;
    int nEE;
    private int nEF;
    h nEG;
    private final Runnable nEH;
    final Runnable nEI;
    private final Runnable nEJ;
    private final Runnable nEK;
    private final Runnable nEL;
    private final Runnable nEM;
    boolean nEm;
    private volatile long nEn;
    private AssetFileDescriptor nEo;
    private final int[] nEp;
    private float nEq;
    private float nEr;
    private boolean nEs;
    private int[] nEt;
    private int nEu;
    private int nEv;
    private long nEw;
    private long nEx;
    private long nEy;
    private long nEz;
    private final Rect uk;

    final void e(Runnable runnable, long j) {
        this.nEB = SystemClock.uptimeMillis() + j;
        if (this.lKV != null) {
            this.lKV.postAtTime(runnable, this.nEB);
        }
    }

    public c(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    public c(String str) {
        int i = 0;
        this.mIsRunning = true;
        this.nEm = false;
        this.nEo = null;
        this.nEp = new int[6];
        this.nEq = 1.0f;
        this.nEr = 1.0f;
        this.uk = new Rect();
        this.fC = new Paint(6);
        this.nEu = 0;
        this.nEv = -1;
        this.nEw = 0;
        this.nEx = 0;
        this.nEy = 0;
        this.nEz = 0;
        this.nEB = 0;
        this.nED = false;
        this.nEE = 0;
        this.nEF = 0;
        this.lKV = new ag();
        this.nEH = new Runnable() {
            public final void run() {
            }
        };
        this.nEI = new Runnable() {
            public final void run() {
                if ((c.this.isRunning() || c.this.nEv == 0) && SystemClock.uptimeMillis() >= c.this.nEB) {
                    c.this.nEz = System.currentTimeMillis();
                    c.this.invalidateSelf();
                    if (c.this.nEG != null) {
                        c.this.nEG.invalidate();
                    }
                }
            }
        };
        this.nEJ = new Runnable() {
            public final void run() {
                MMGIFJNI.restoreRemainder(c.this.nEn);
                c.this.e(c.this.nEI, c.this.nEy);
            }
        };
        this.nEK = new Runnable() {
            public final void run() {
                MMGIFJNI.reset(c.this.nEn);
            }
        };
        this.nEL = new Runnable() {
            public final void run() {
                MMGIFJNI.saveRemainder(c.this.nEn);
            }
        };
        this.nEM = new Runnable() {
            public final void run() {
                if (c.this.nEm) {
                    x.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.nEv + 1 > c.this.nEu - 1) {
                    c.this.nEv = -1;
                }
                c.this.nEv = c.this.nEv + 1;
                if (MMGIFJNI.drawFramePixels(c.this.nEn, c.this.nEt, c.this.nEp)) {
                    c.this.nEF = c.this.nEF + 1;
                }
                c.this.nEw = System.currentTimeMillis() - currentTimeMillis;
                if (c.this.nEx != 0) {
                    c.this.nEy = (c.this.nEx - c.this.nEw) - c.this.nEA;
                    if (c.this.nEy < 0) {
                        x.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(c.this.nEw), Long.valueOf(c.this.nEA), Long.valueOf(c.this.nEy), Long.valueOf(c.this.nEx), Integer.valueOf(c.this.nEp[5]));
                        g.pWK.a(401, 0, 1, false);
                        g.pWK.a(401, 1, Math.abs(c.this.nEy), false);
                        if (c.this.nEy < -100) {
                            boolean z = HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable;
                            HardCoderJNI.stopPerformace(z, c.this.hGs);
                            c.this.hGs = HardCoderJNI.startPerformance(HardCoderJNI.hcGifFrameEnable, HardCoderJNI.hcGifFrameDelay, HardCoderJNI.hcGifFrameCPU, HardCoderJNI.hcGifFrameIO, HardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, HardCoderJNI.hcGifFrameTimeout, 602, HardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                c.this.e(c.this.nEI, c.this.nEy > 0 ? c.this.nEy : 0);
                if (c.this.nEp[2] == 1) {
                    c.this.nEx = 5000;
                } else {
                    c.this.nEx = (long) c.this.nEp[4];
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("file path is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hGs = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nEn = MMGIFJNI.openByFilePath(str, this.nEp);
        init();
    }

    private c(AssetFileDescriptor assetFileDescriptor) {
        int i = 0;
        this.mIsRunning = true;
        this.nEm = false;
        this.nEo = null;
        this.nEp = new int[6];
        this.nEq = 1.0f;
        this.nEr = 1.0f;
        this.uk = new Rect();
        this.fC = new Paint(6);
        this.nEu = 0;
        this.nEv = -1;
        this.nEw = 0;
        this.nEx = 0;
        this.nEy = 0;
        this.nEz = 0;
        this.nEB = 0;
        this.nED = false;
        this.nEE = 0;
        this.nEF = 0;
        this.lKV = new ag();
        this.nEH = /* anonymous class already generated */;
        this.nEI = /* anonymous class already generated */;
        this.nEJ = /* anonymous class already generated */;
        this.nEK = /* anonymous class already generated */;
        this.nEL = /* anonymous class already generated */;
        this.nEM = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            throw new NullPointerException("assert file Descriptor is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hGs = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nEo = assetFileDescriptor;
        this.nEn = MMGIFJNI.openByFileDescroptor(this.nEo.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.nEp);
        init();
    }

    public c(InputStream inputStream) {
        int i = 0;
        this.mIsRunning = true;
        this.nEm = false;
        this.nEo = null;
        this.nEp = new int[6];
        this.nEq = 1.0f;
        this.nEr = 1.0f;
        this.uk = new Rect();
        this.fC = new Paint(6);
        this.nEu = 0;
        this.nEv = -1;
        this.nEw = 0;
        this.nEx = 0;
        this.nEy = 0;
        this.nEz = 0;
        this.nEB = 0;
        this.nED = false;
        this.nEE = 0;
        this.nEF = 0;
        this.lKV = new ag();
        this.nEH = /* anonymous class already generated */;
        this.nEI = /* anonymous class already generated */;
        this.nEJ = /* anonymous class already generated */;
        this.nEK = /* anonymous class already generated */;
        this.nEL = /* anonymous class already generated */;
        this.nEM = /* anonymous class already generated */;
        if (inputStream == null) {
            throw new NullPointerException("input stream is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hGs = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nEn = MMGIFJNI.openByInputStrem(inputStream, this.nEp);
        init();
    }

    public c(byte[] bArr) {
        int i = 0;
        this.mIsRunning = true;
        this.nEm = false;
        this.nEo = null;
        this.nEp = new int[6];
        this.nEq = 1.0f;
        this.nEr = 1.0f;
        this.uk = new Rect();
        this.fC = new Paint(6);
        this.nEu = 0;
        this.nEv = -1;
        this.nEw = 0;
        this.nEx = 0;
        this.nEy = 0;
        this.nEz = 0;
        this.nEB = 0;
        this.nED = false;
        this.nEE = 0;
        this.nEF = 0;
        this.lKV = new ag();
        this.nEH = /* anonymous class already generated */;
        this.nEI = /* anonymous class already generated */;
        this.nEJ = /* anonymous class already generated */;
        this.nEK = /* anonymous class already generated */;
        this.nEL = /* anonymous class already generated */;
        this.nEM = /* anonymous class already generated */;
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hGs = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nEn = MMGIFJNI.openByByteArray(bArr, this.nEp);
        init();
    }

    private void init() {
        x.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.nEn));
        this.nEu = this.nEp[2];
        this.nEC = a.aa(ad.getContext(), com.tencent.mm.plugin.m.a.c.ltv);
        if (this.nEp[0] > 1024 || this.nEp[1] > 1024) {
            x.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.nEp[0]), Integer.valueOf(this.nEp[1]));
            this.nEt = new int[(this.nEC * this.nEC)];
            this.nED = true;
            g.pWK.a(401, 2, 1, false);
            return;
        }
        this.nEt = new int[(this.nEp[0] * this.nEp[1])];
    }

    private float aSS() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ad.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    public final int getIntrinsicWidth() {
        return (int) (((float) this.nEp[0]) * aSS());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.nEp[1]) * aSS());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nEs = true;
    }

    public final void draw(Canvas canvas) {
        if (this.nEs) {
            this.uk.set(getBounds());
            this.nEq = ((float) this.uk.width()) / ((float) this.nEp[0]);
            this.nEr = ((float) this.uk.height()) / ((float) this.nEp[1]);
            this.nEs = false;
        }
        if (this.fC.getShader() == null) {
            if (this.nEz == 0) {
                this.nEz = System.currentTimeMillis();
            }
            canvas.scale(this.nEq, this.nEr);
            int[] iArr = this.nEt;
            if (iArr == null) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.nEp[0] * this.nEp[1]) {
                canvas.drawBitmap(iArr, 0, this.nEp[0], 0.0f, 0.0f, this.nEp[0], this.nEp[1], true, this.fC);
            } else {
                canvas.drawRGB(bs.CTRL_INDEX, bs.CTRL_INDEX, bs.CTRL_INDEX);
                x.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.nEp[0]), Integer.valueOf(this.nEp[1]));
            }
            this.nEA = System.currentTimeMillis() - this.nEz;
            if (this.nED || this.nEp[2] <= 0) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.nEp[2]), Integer.valueOf(this.nEp[4]), Boolean.valueOf(this.nED));
                return;
            }
            if (this.nEp[4] < 0) {
                x.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
            }
            if (this.nEE == 0 || this.nEF <= this.nEE - 1) {
                com.tencent.mm.an.a.b(this.nEM, 0);
                return;
            } else {
                e(this.nEH, 0);
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.uk, this.fC);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.an.a.b(this.nEJ, 0);
    }

    public final void stop() {
        boolean z = true;
        x.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.hGs != 0) {
            x.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformace startPerformance:%x ", Integer.valueOf(this.hGs));
            if (!(HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            HardCoderJNI.stopPerformace(z, this.hGs);
            this.hGs = 0;
        }
        com.tencent.mm.an.a.b(this.nEL, 300);
    }

    public final void reset() {
        this.nEm = false;
        this.mIsRunning = true;
        com.tencent.mm.an.a.b(this.nEK, 300);
    }

    public final void recycle() {
        x.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.nEm = true;
        this.mIsRunning = false;
        long j = this.nEn;
        this.nEn = 0;
        MMGIFJNI.recycle(j);
        this.nEt = null;
        if (this.nEo != null) {
            try {
                this.nEo.close();
            } catch (Exception e) {
            }
        }
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
