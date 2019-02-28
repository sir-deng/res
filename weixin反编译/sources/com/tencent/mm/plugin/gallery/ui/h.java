package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class h extends Drawable {
    private static final Paint hca = new Paint();
    private static Rect rect = null;
    protected int fuz = 0;
    protected ImageView lNZ;
    private Bitmap mBitmap;
    protected String mFilePath = "";
    private int mWidth;
    protected String mWj = "";
    protected long mWk = 0;
    protected boolean naE = false;
    public a naF;
    long naG;
    boolean naH = false;
    private Rect naI = new Rect();

    public interface a {
        void aOU();
    }

    private static final class b implements Runnable {
        final WeakReference<h> naJ;

        b(h hVar) {
            this.naJ = new WeakReference(hVar);
        }

        public final void run() {
            h hVar = (h) this.naJ.get();
            if (hVar == null) {
                x.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this task.");
                return;
            }
            x.v("MicroMsg.ThumbDrawable", "invalidateSelf");
            com.tencent.mm.plugin.gallery.model.a aOk = com.tencent.mm.plugin.gallery.model.c.aOk();
            String str = hVar.mFilePath;
            String str2 = hVar.mWj;
            long j = hVar.mWk;
            hVar.mBitmap = aOk.BW(str);
            if (!(hVar.naF == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                hVar.naF.aOU();
            }
            hVar.naG = SystemClock.uptimeMillis();
            hVar.invalidateSelf();
        }
    }

    private static final class c implements com.tencent.mm.plugin.gallery.model.b.b {
        final WeakReference<h> naJ;

        c(h hVar) {
            this.naJ = new WeakReference(hVar);
        }

        public final void BX(String str) {
            h hVar = (h) this.naJ.get();
            if (hVar == null) {
                x.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this event.");
            } else if (bi.oN(str)) {
                x.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
            } else if (hVar.mFilePath.equals(str)) {
                x.d("MicroMsg.ThumbDrawable", "notify thumb get " + str);
                hVar.lNZ.post(new b(hVar));
            } else {
                x.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", str);
            }
        }
    }

    static {
        hca.setAntiAlias(true);
        hca.setFilterBitmap(true);
    }

    private h(ImageView imageView) {
        this.lNZ = imageView;
        this.mFilePath = "";
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        x.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        x.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", rect.toString());
        super.setBounds(rect);
    }

    public final void draw(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.naG)) / 200.0f;
        if (this.naG == 0) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", this.mFilePath);
            uptimeMillis = 0.0f;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.naH), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis)));
        if (!this.naH) {
            c(canvas, 255);
            setAlpha(255);
        } else if (uptimeMillis >= 1.0f) {
            this.naH = false;
            c(canvas, 255);
        } else if (c(canvas, (int) (uptimeMillis * 255.0f))) {
            invalidateSelf();
        }
    }

    private boolean c(Canvas canvas, int i) {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.naH = true;
                this.naG = 0;
                this.mBitmap = com.tencent.mm.plugin.gallery.model.c.aOk().b(this.mFilePath, this.fuz, this.mWj, this.mWk);
                if (!(this.naF == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.naF.aOU();
                }
            }
            return false;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.naI;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        hca.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.naI, getBounds(), hca);
        x.v("MicroMsg.ThumbDrawable", "Bounts:%s", getBounds().toString());
        return true;
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        a(imageView, i, str, str2, j, -1, null);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        Drawable hVar;
        String str3;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof h)) {
            hVar = new h(imageView);
        } else {
            hVar = (h) drawable;
        }
        if (i2 > 0) {
            hVar.mWidth = i2;
        }
        hVar.naF = aVar;
        if (bi.oN(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (bi.oN(str3)) {
            x.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
        } else {
            if (bi.oN(str)) {
                hVar.naE = false;
            } else {
                hVar.naE = true;
            }
            com.tencent.mm.plugin.gallery.model.c.aOk().a(new c(hVar));
            String str4;
            String str5;
            Object[] objArr;
            if (!hVar.mFilePath.equals(str3) || hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                hVar.mFilePath = str3;
                hVar.mWj = str2;
                hVar.mWk = j;
                hVar.fuz = i;
                hVar.mBitmap = com.tencent.mm.plugin.gallery.model.c.aOk().BW(hVar.mFilePath);
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
                if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                    hVar.naH = true;
                    hVar.naG = 0;
                    hVar.mBitmap = com.tencent.mm.plugin.gallery.model.c.aOk().b(str3, i, str2, j);
                } else {
                    hVar.naH = false;
                }
                if (!(hVar.naF == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                    hVar.naF.aOU();
                }
                hVar.lNZ.invalidate();
            } else {
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
            }
        }
        imageView.setImageDrawable(hVar);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
