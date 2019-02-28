package com.tencent.mm.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.a;

public abstract class b<T extends d> {
    public static final b fiu = new b() {
        public final a uH() {
            return a.DEFAULT;
        }

        public final void uI() {
        }

        public final void onDraw(Canvas canvas) {
        }
    };
    public com.tencent.mm.bn.b fio;
    private Matrix fip;
    Rect fiq;
    private boolean fir;
    public boolean fis;
    private Bitmap fit;
    private Canvas fiv = new Canvas();
    private Runnable fiw;
    PointF fix = new PointF();
    private PointF fiy = new PointF();
    private Context mContext;
    float[] values = new float[9];

    public abstract void onDraw(Canvas canvas);

    public abstract a uH();

    public abstract void uI();

    public final void b(Canvas canvas) {
        if (this.fit != null && !this.fit.isRecycled()) {
            canvas.drawBitmap(this.fit, 0.0f, 0.0f, null);
        }
    }

    public final T uJ() {
        return this.fio.a(uH());
    }

    public void a(com.tencent.mm.bn.b bVar, Matrix matrix, Rect rect) {
        x.i("MicroMsg.BaseArtist" + uH(), "[onCreate]");
        this.fis = true;
        this.mContext = bVar.getContext();
        this.fio = bVar;
        this.fip = matrix;
        this.fiq = rect;
    }

    public void uK() {
        x.i("MicroMsg.BaseArtist" + uH(), "[onAlive] isAlive:%s", Boolean.valueOf(this.fir));
        if (!this.fir) {
            this.fir = true;
            d uJ = uJ();
            if (uJ != null) {
                uJ.xC();
                uJ.ba(false);
            } else {
                x.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", uH());
            }
            this.fit = uO();
        }
    }

    public void uL() {
        x.i("MicroMsg.BaseArtist" + uH(), "[onSelected] ");
    }

    public final void onFinish() {
        x.i("MicroMsg.BaseArtist", "[onFinish] type:%s", uH());
        this.fir = false;
        this.fis = false;
        d uJ = uJ();
        if (uJ != null) {
            uJ.ba(true);
        } else {
            x.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", uH());
        }
        uM();
    }

    public void onDestroy() {
        this.fis = false;
        this.fir = false;
        x.i("MicroMsg.BaseArtist" + uH(), "[onDestroy]");
        uM();
    }

    public final void uM() {
        if (this.fit != null && !this.fit.isRecycled()) {
            this.fit.recycle();
        }
    }

    public boolean uN() {
        try {
            if (uJ().bb(true) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void aK(boolean z) {
        this.fiv.setBitmap(uO());
        uJ().a(this.fiv, z);
    }

    protected final Bitmap uO() {
        if (this.fit == null || this.fit.isRecycled()) {
            int width;
            int height;
            Rect rect = this.fio.cdU().cAW().gPl;
            if (rect.isEmpty() || !this.fio.cdU().cAW().cBk()) {
                width = this.fio.cdU().cAW().zNL.width();
                height = this.fio.cdU().cAW().zNL.height();
            } else {
                width = rect.width();
                height = rect.height();
            }
            this.fit = Bitmap.createBitmap(width, height, Config.ARGB_4444);
        }
        return this.fit;
    }

    protected final void d(Bitmap bitmap) {
        if (!(uO() == null || uO().isRecycled())) {
            uO().recycle();
        }
        this.fit = bitmap;
    }

    public final void aL(boolean z) {
        this.fio.cdU().cAW().zNQ = z;
    }

    public final boolean isAlive() {
        return this.fis && this.fir;
    }

    protected final boolean uP() {
        return this.fio.cdW().uH() == uH();
    }

    public final void uQ() {
        if (uJ().pop() != null) {
            uJ().uQ();
        }
        this.fio.cdU().removeCallbacks(this.fiw);
        a cdU = this.fio.cdU();
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                b.this.uI();
                b.this.uT();
                b.this.fiw = null;
            }
        };
        this.fiw = anonymousClass2;
        cdU.postDelayed(anonymousClass2, 66);
    }

    public boolean q(MotionEvent motionEvent) {
        if (u(motionEvent)) {
            t(motionEvent);
        }
        return false;
    }

    protected final Rect uR() {
        return this.fio.cdU().cAW().zNL;
    }

    public final Matrix uS() {
        return this.fio.cdU().cAW().uS();
    }

    public final void uT() {
        this.fio.cdU().cAW().postInvalidate();
    }

    public final void uU() {
        this.fio.cdU().cAV().postInvalidate();
    }

    public final float getScale() {
        float a = a(this.fip, 3);
        float a2 = a(this.fip, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.fip, 1), (double) a(this.fip, 0)) * 57.29577951308232d);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    protected final float[] l(float f, float f2) {
        Matrix matrix = new Matrix(this.fip);
        this.fip.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    protected final float[] m(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.fip.mapPoints(fArr);
        return fArr;
    }

    protected static int r(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected static int[] s(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    protected final void t(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.fiy.x = motionEvent.getX(1);
            this.fiy.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerCount() == 1) {
            this.fix.x = motionEvent.getX(0);
            this.fix.y = motionEvent.getY(0);
        }
        if (motionEvent.getActionMasked() != 6) {
            return;
        }
        if (motionEvent.getPointerCount() <= 1 || 1 - motionEvent.getActionIndex() < 0 || 1 - motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
            this.fix.x = motionEvent.getX(0);
            this.fix.y = motionEvent.getY(0);
            return;
        }
        this.fix.x = motionEvent.getX(1 - motionEvent.getActionIndex());
        this.fix.y = motionEvent.getY(1 - motionEvent.getActionIndex());
    }

    protected final boolean u(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (Math.abs(this.fix.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.fix.y - motionEvent.getY(0)) > 3.0f || Math.abs(this.fiy.x - motionEvent.getX(1)) > 3.0f || Math.abs(this.fiy.y - motionEvent.getY(1)) > 3.0f) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            if (Math.abs(this.fix.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.fix.y - motionEvent.getY(0)) > 3.0f) {
                return true;
            }
            return false;
        }
    }
}
