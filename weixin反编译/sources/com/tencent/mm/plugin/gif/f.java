package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.a.e;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private final Paint fC;
    private ag lKV;
    private float mDensity;
    private int mHeight;
    private boolean mIsRunning;
    private int mWidth;
    private long nEA;
    private long nEB;
    private final Runnable nEI;
    private final Runnable nEJ;
    private final Runnable nEM;
    private volatile long nEY;
    private int[] nEZ;
    private boolean nEm;
    private int[] nEp;
    private float nEq;
    private float nEr;
    private boolean nEs;
    private int nEu;
    private int nEv;
    private long nEw;
    private long nEx;
    private long nEy;
    private long nEz;
    private Bitmap nFa;
    private boolean nFb;
    private final Rect uk;

    static /* synthetic */ void a(f fVar, Runnable runnable, long j) {
        fVar.nEB = SystemClock.uptimeMillis() + j;
        if (fVar.lKV != null) {
            fVar.lKV.postAtTime(runnable, fVar.nEB);
        }
    }

    public f(String str) {
        this(e.d(str, 0, e.bN(str)));
    }

    public f(byte[] bArr) {
        this.mIsRunning = false;
        this.nEm = false;
        this.nEp = new int[4];
        this.nEZ = new int[4];
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
        this.nFb = false;
        this.lKV = new ag();
        this.nEI = new Runnable() {
            public final void run() {
                if (!f.this.nEm) {
                    if ((f.this.isRunning() || f.this.nEv == 0) && SystemClock.uptimeMillis() >= f.this.nEB) {
                        f.this.nEz = System.currentTimeMillis();
                        f.this.invalidateSelf();
                    }
                }
            }
        };
        this.nEJ = new Runnable() {
            public final void run() {
                f.a(f.this, f.this.nEI, f.this.nEy);
            }
        };
        this.nEM = new Runnable() {
            public final void run() {
                if (f.this.nFb) {
                    x.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
                } else if (f.this.nEm) {
                    x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
                } else if (f.this.nFa == null || f.this.nFa.isRecycled()) {
                    x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
                } else if (f.this.nEY == 0) {
                    x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
                    g.pWK.a(401, 18, 1, false);
                } else {
                    f.this.nFb = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(f.this.nEY, null, 0, f.this.nFa, f.this.nEZ);
                    if (nativeDecodeBufferFrame == -904) {
                        x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
                        g.pWK.a(401, 8, 1, false);
                        return;
                    }
                    if (nativeDecodeBufferFrame == -909) {
                        x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
                        g.pWK.a(401, 11, 1, false);
                    } else if (nativeDecodeBufferFrame == -1) {
                        x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
                        return;
                    }
                    f.this.nEv = f.this.nEv + 1;
                    if (f.this.nEv >= f.this.nEu - 1 || nativeDecodeBufferFrame == 1) {
                        f.this.nEv = -1;
                        nativeDecodeBufferFrame = MMWXGFJNI.nativeRewindBuffer(f.this.nEY);
                        if (nativeDecodeBufferFrame != 0) {
                            if (nativeDecodeBufferFrame == -905) {
                                g.pWK.a(711, 9, 1, false);
                            }
                            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                            return;
                        }
                    }
                    f.this.nEw = System.currentTimeMillis() - currentTimeMillis;
                    if (f.this.nEx != 0) {
                        f.this.nEy = (f.this.nEx - f.this.nEw) - f.this.nEA;
                        if (f.this.nEy < 0) {
                            x.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(f.this.nEw), Long.valueOf(f.this.nEA), Long.valueOf(f.this.nEy), Long.valueOf(f.this.nEx), Integer.valueOf(f.this.nEv));
                            if (f.this.nEy < -100) {
                                g.pWK.a(401, 16, 1, false);
                                g.pWK.a(401, 17, Math.abs(f.this.nEy), false);
                            }
                        }
                    }
                    f.a(f.this, f.this.nEI, f.this.nEy > 0 ? f.this.nEy : 0);
                    f.this.nEx = (long) (f.this.nEZ[0] > 0 ? f.this.nEZ[0] : 100);
                    f.this.nFb = false;
                }
            }
        };
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        this.nEY = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.nEY == 0 || this.nEY == -901) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.nEY));
            if (this.nEY == -901) {
                g.pWK.a(711, 5, 1, false);
            }
            g.pWK.a(711, 4, 1, false);
            throw new MMGIFException(201);
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.nEY, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                g.pWK.a(711, 8, 1, false);
            } else {
                g.pWK.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.nEY, bArr, bArr.length, this.nEp);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                g.pWK.a(711, 7, 1, false);
            } else {
                g.pWK.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        this.nEu = this.nEp[0];
        this.mWidth = this.nEp[1];
        this.mHeight = this.nEp[2];
        if (this.mWidth == 0 || this.mHeight == 0) {
            nativeDecodeBufferHeader = a.aa(ad.getContext(), c.ltv);
            this.mHeight = nativeDecodeBufferHeader;
            this.mWidth = nativeDecodeBufferHeader;
        }
        this.nFa = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
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
        return (int) (((float) this.mWidth) * aSS());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.mHeight) * aSS());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nEs = true;
    }

    public final void draw(Canvas canvas) {
        if (this.nEs) {
            this.uk.set(getBounds());
            this.nEq = ((float) this.uk.width()) / ((float) this.mWidth);
            this.nEr = ((float) this.uk.height()) / ((float) this.mHeight);
            this.nEs = false;
        }
        if (this.fC.getShader() == null) {
            if (this.nEz == 0) {
                this.nEz = System.currentTimeMillis();
            }
            canvas.scale(this.nEq, this.nEr);
            if (this.nFa == null || this.nFa.isRecycled() || this.nEm) {
                x.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
            } else {
                canvas.drawBitmap(this.nFa, 0.0f, 0.0f, null);
            }
            this.nEA = System.currentTimeMillis() - this.nEz;
            com.tencent.mm.an.a.b(this.nEM, 0);
            return;
        }
        canvas.drawRect(this.uk, this.fC);
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.an.a.b(this.nEJ, 0);
    }

    public final void stop() {
        this.mIsRunning = false;
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
        }
    }

    public final void reset() {
        this.mIsRunning = true;
    }

    public final synchronized void recycle() {
        x.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.nEY));
        this.nEm = true;
        this.mIsRunning = false;
        long j = this.nEY;
        this.nEY = 0;
        this.lKV.removeCallbacks(this.nEI);
        int nativeUninit = MMWXGFJNI.nativeUninit(j);
        if (nativeUninit == -906) {
            g.pWK.a(401, 10, 1, false);
        }
        x.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j), Boolean.valueOf(this.nFb));
        if (!(j == 0 || nativeUninit != 0 || this.nFa == null)) {
            this.nFa.isRecycled();
        }
        this.nFa = null;
    }
}
