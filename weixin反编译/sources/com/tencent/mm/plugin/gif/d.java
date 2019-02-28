package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final Paint fC = new Paint(6);
    private ag lKV = new ag(Looper.getMainLooper());
    public int lNI = 0;
    private Context mContext;
    private int mHeight;
    public boolean mIsPlaying = true;
    private Resources mResources;
    private int mWidth;
    private long nEB = 0;
    private final Runnable nEH = new Runnable() {
        public final void run() {
        }
    };
    private final Runnable nEI = new Runnable() {
        public final void run() {
            if (SystemClock.uptimeMillis() >= d.this.nEB) {
                d.this.invalidateSelf();
            }
        }
    };
    private volatile boolean nEO = false;
    private int nEP;
    private int nEQ;
    private int[] nER;
    private Bitmap nES = null;
    private boolean nET = false;
    private String nEU;
    public int nEV = 0;
    private h nEW;
    private float nEq = 1.0f;
    private float nEr = 1.0f;
    private boolean nEs;
    private final Rect uk = new Rect();

    public d(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.nET = false;
        this.mIsPlaying = z2;
        this.nEU = str;
        this.nEQ = i;
        this.nER = iArr;
        if (z2) {
            this.nES = rw(this.nER[0]);
        } else {
            this.nES = rw(CW(str));
        }
        this.mWidth = this.nES.getWidth();
        this.mHeight = this.nES.getHeight();
        if (this.nER.length == 3) {
            this.nEP = 300;
        } else {
            this.nEP = 100;
        }
        this.nEV = 0;
    }

    public final void draw(Canvas canvas) {
        if (this.nEs) {
            this.uk.set(getBounds());
            this.nEq = ((float) this.uk.width()) / ((float) this.mWidth);
            this.nEr = ((float) this.uk.height()) / ((float) this.mHeight);
            this.nEs = false;
        }
        if (this.fC.getShader() == null) {
            canvas.scale(this.nEq, this.nEr);
            if (this.nET) {
                this.nES = rw(this.nEQ);
                if (this.nES != null && !this.nES.isRecycled()) {
                    canvas.drawBitmap(this.nES, 0.0f, 0.0f, this.fC);
                    return;
                }
                return;
            } else if (this.mIsPlaying) {
                x.i("MicroMsg.GIF.MMGIFGameDrawable", "mCurrentIndex:%d mNextInvaliteTime:%d mLoop:%d", Integer.valueOf(this.lNI), Integer.valueOf(this.nEP), Integer.valueOf(this.nEV));
                this.nES = rw(this.nER[this.lNI]);
                if (!(this.nES == null || this.nES.isRecycled())) {
                    canvas.drawBitmap(this.nES, 0.0f, 0.0f, this.fC);
                }
                this.lNI++;
                if (this.nEV < 3) {
                    if (this.lNI >= this.nER.length) {
                        this.lNI = 0;
                        this.nEV++;
                    }
                    e(this.nEI, (long) this.nEP);
                    return;
                }
                this.mIsPlaying = false;
                e(this.nEI, (long) this.nEP);
                e(this.nEH, 0);
                return;
            } else {
                this.nES = rw(CW(this.nEU));
                if (this.nES != null && !this.nES.isRecycled()) {
                    canvas.drawBitmap(this.nES, 0.0f, 0.0f, this.fC);
                    return;
                }
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.uk, this.fC);
    }

    private void e(Runnable runnable, long j) {
        this.nEB = SystemClock.uptimeMillis() + j;
        if (this.lKV != null) {
            this.lKV.postDelayed(runnable, j);
        }
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
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

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nEs = true;
    }

    public final void start() {
        this.nEO = true;
        this.lKV.post(this.nEI);
    }

    public final void stop() {
        this.nEO = false;
    }

    public final boolean isRunning() {
        return this.nEO;
    }

    private Bitmap rw(int i) {
        return BitmapFactory.decodeResource(this.mResources, i);
    }

    private int CW(String str) {
        return this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
    }

    protected final void finalize() {
        this.nEW = null;
        super.finalize();
    }

    public final void recycle() {
    }

    public final void reset() {
    }
}
