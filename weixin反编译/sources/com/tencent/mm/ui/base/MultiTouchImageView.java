package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class MultiTouchImageView extends ImageView {
    public int imageHeight;
    public int imageWidth;
    protected ag mHandler;
    public int mdE;
    public int mdF;
    private boolean oCT;
    public float qdM;
    private a rID;
    public boolean rIg;
    protected Bitmap rtL;
    protected Matrix ynJ;
    protected Matrix ynK;
    private final Matrix ynL;
    private final float[] ynM;
    int ynN;
    int ynO;
    private float ynP;
    private float ynQ;
    private float ynR;
    private boolean ynS;
    private float ynT;
    private float ynU;
    private float ynV;
    public boolean ynW;
    public boolean ynX;
    public boolean ynY;
    private float ynZ;
    private float yoa;
    private float yob;
    float yoc;
    public boolean yod;
    public Drawable yoe;

    public interface a {
        void bBO();

        void bBP();
    }

    /* renamed from: com.tencent.mm.ui.base.MultiTouchImageView$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ float fjn;
        final /* synthetic */ float fjo;
        final /* synthetic */ long hCF;
        final /* synthetic */ float yof = 128.0f;
        final /* synthetic */ float yog;
        final /* synthetic */ float yoh;

        AnonymousClass1(float f, long j, float f2, float f3, float f4, float f5) {
            this.hCF = j;
            this.yog = f2;
            this.yoh = f3;
            this.fjn = f4;
            this.fjo = f5;
        }

        public final void run() {
            float min = Math.min(this.yof, (float) (System.currentTimeMillis() - this.hCF));
            MultiTouchImageView.this.h(this.yog + (this.yoh * min), this.fjn, this.fjo);
            if (min < this.yof) {
                MultiTouchImageView.this.mHandler.post(this);
            }
        }
    }

    public final void aE(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            x.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.ynV = f;
        }
    }

    public MultiTouchImageView(Context context, int i, int i2, a aVar) {
        super(context);
        this.ynJ = new Matrix();
        this.ynK = new Matrix();
        this.ynL = new Matrix();
        this.ynM = new float[9];
        this.rtL = null;
        this.ynN = -1;
        this.ynO = -1;
        this.ynP = 0.0f;
        this.ynQ = 0.0f;
        this.ynR = 0.0f;
        this.oCT = false;
        this.ynS = false;
        this.ynT = 2.0f;
        this.ynU = 0.75f;
        this.ynV = 20.0f;
        this.ynW = false;
        this.ynX = false;
        this.ynY = false;
        this.rIg = true;
        this.mHandler = new ag();
        this.yob = 1.0f;
        this.yoc = 0.0f;
        this.yod = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.rID = aVar;
        init();
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        this.ynJ = new Matrix();
        this.ynK = new Matrix();
        this.ynL = new Matrix();
        this.ynM = new float[9];
        this.rtL = null;
        this.ynN = -1;
        this.ynO = -1;
        this.ynP = 0.0f;
        this.ynQ = 0.0f;
        this.ynR = 0.0f;
        this.oCT = false;
        this.ynS = false;
        this.ynT = 2.0f;
        this.ynU = 0.75f;
        this.ynV = 20.0f;
        this.ynW = false;
        this.ynX = false;
        this.ynY = false;
        this.rIg = true;
        this.mHandler = new ag();
        this.yob = 1.0f;
        this.yoc = 0.0f;
        this.yod = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
    }

    public final void eV(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mdE == MeasureSpec.getSize(i) && this.mdF == MeasureSpec.getSize(i2)) {
            this.ynS = false;
        } else {
            this.ynS = true;
        }
        this.mdE = MeasureSpec.getSize(i);
        this.mdF = MeasureSpec.getSize(i2);
        if (!this.oCT) {
            this.oCT = true;
            init();
        }
        if (this.ynS) {
            cqG();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.yod = false;
        this.rtL = bitmap;
        this.oCT = false;
        super.setImageBitmap(bitmap);
    }

    protected void onDraw(Canvas canvas) {
        if (this.yod || this.rtL == null || !this.rtL.isRecycled()) {
            super.onDraw(canvas);
        } else {
            x.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        }
    }

    public final void cqG() {
        this.ynK.reset();
        cqH();
        h(this.qdM, 0.0f, 0.0f);
    }

    public final void I(float f, float f2) {
        cqH();
        i(this.qdM, f, f2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.oCT = false;
        }
    }

    private void cqH() {
        boolean z;
        boolean z2 = true;
        this.ynZ = ((float) this.mdE) / ((float) this.imageWidth);
        this.yoa = ((float) this.mdF) / ((float) this.imageHeight);
        this.ynX = ((float) this.imageWidth) > ((float) this.imageHeight) * 2.2f;
        if (((float) this.imageHeight) > ((float) this.imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.ynY = z;
        if (!this.ynX || this.imageWidth <= this.mdE) {
            z = false;
        } else {
            z = true;
        }
        this.ynX = z;
        if (!this.ynY || this.imageHeight <= this.mdF) {
            z2 = false;
        }
        this.ynY = z2;
        float f = ((float) this.imageHeight) / ((float) this.imageWidth);
        float f2 = 1.8f;
        if (!(this.mdE == 0 || this.mdF == 0)) {
            f2 = ((float) this.mdF) / ((float) this.mdE);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.qdM = this.ynZ;
        } else {
            this.qdM = this.yoa;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (g.cpy()) {
            f fVar = new f();
            keyEvent.startTracking();
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            boolean isTracking;
            if (g.cpy()) {
                f fVar = new f();
                isTracking = keyEvent.isTracking();
            } else {
                isTracking = false;
            }
            if (isTracking) {
                if (g.cpy()) {
                    f fVar2 = new f();
                    z = keyEvent.isCanceled();
                }
                if (!z && getScale() > 1.0f) {
                    h(1.0f, ((float) this.mdE) / 2.0f, ((float) this.mdF) / 2.0f);
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void U(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.rtL == null && !this.yod) {
            return;
        }
        if (this.yoe != null || !this.yod) {
            RectF rectF;
            Matrix cqI = cqI();
            if (this.yod) {
                rectF = new RectF(0.0f, 0.0f, (float) this.yoe.getIntrinsicWidth(), (float) this.yoe.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.rtL.getWidth(), (float) this.rtL.getHeight());
            }
            cqI.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (z2) {
                if (height < ((float) this.mdF)) {
                    height = ((((float) this.mdF) - height) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.mdF)) {
                        height = ((float) this.mdF) - rectF.bottom;
                    }
                    height = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                height = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.mdF)) {
                    height = ((float) this.mdF) - rectF.bottom;
                }
                height = 0.0f;
            }
            if (z) {
                if (width < ((float) this.mdE)) {
                    f = ((((float) this.mdE) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) this.mdE)) {
                    f = ((float) this.mdE) - rectF.right;
                }
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.mdE)) {
                f = ((float) this.mdE) - rectF.right;
            }
            K(f, height);
            Matrix cqI2 = cqI();
            setImageMatrix(cqI2);
            cqI2.mapRect(rectF);
            rectF.height();
            rectF.width();
        }
    }

    private void init() {
        x.d("dktest", "init screenWidth:" + this.mdE + " screenHeight :" + this.mdF);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.yob = f;
        }
        cqG();
    }

    public final float getScale() {
        this.ynK.getValues(this.ynM);
        cqH();
        this.ynQ = this.ynV * this.yob;
        this.ynR = this.qdM * this.ynU;
        if (this.ynQ < 1.0f) {
            this.ynQ = 1.0f;
        }
        if (this.ynR > 1.0f) {
            this.ynR = 1.0f;
        }
        return this.ynM[0];
    }

    private Matrix cqI() {
        this.ynL.set(this.ynJ);
        this.ynL.postConcat(this.ynK);
        return this.ynL;
    }

    public final void cqJ() {
        boolean z;
        boolean z2 = true;
        if (this.rIg && this.ynX) {
            z = false;
        } else {
            z = true;
        }
        if (this.ynY) {
            z2 = false;
        }
        U(z, z2);
    }

    public final void cqK() {
        if (this.ynW && 0.0f == this.ynP) {
            this.ynP = cqL();
        }
    }

    public final void h(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        float scale = getScale();
        if (this.ynW) {
            this.ynQ = 0.0f == this.ynP ? this.ynV * this.yob : this.ynP;
        }
        if (f > this.ynQ * 2.0f) {
            f = (this.ynQ * 2.0f) + ((f - this.ynQ) * 0.1f);
        } else if (f < this.ynR) {
            f = this.ynR;
        }
        scale = f / scale;
        if (!this.yod) {
            setImageMatrix(cqI());
            this.ynK.postScale(scale, scale, f2, f3);
        }
        if (this.rIg && this.ynX) {
            z = false;
        } else {
            z = true;
        }
        if (this.ynY) {
            z2 = false;
        }
        U(z, z2);
        if (this.rID == null) {
            return;
        }
        if (scale > 1.0f) {
            this.rID.bBP();
        } else if (scale < 1.0f) {
            this.rID.bBO();
        }
    }

    public final float cqL() {
        float f = this.qdM;
        if (this.ynZ * 0.7f > f) {
            f = this.ynZ;
        } else if (this.yoa * 0.7f > f) {
            f = this.yoa;
        } else {
            f = this.qdM * this.ynT;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.ynQ) {
            return this.ynQ;
        }
        return f;
    }

    public final void J(float f, float f2) {
        this.ynP = cqL();
        i(this.ynP, f, f2);
    }

    private void i(float f, float f2, float f3) {
        float scale = (f - getScale()) / 128.0f;
        float scale2 = getScale();
        this.mHandler.post(new AnonymousClass1(128.0f, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public final void K(float f, float f2) {
        this.ynK.postTranslate(f, f2);
        setImageMatrix(cqI());
    }
}
