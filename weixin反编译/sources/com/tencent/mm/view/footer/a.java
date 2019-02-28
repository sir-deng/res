package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.api.d;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.bi.a.e;
import com.tencent.mm.bi.a.g;
import com.tencent.mm.bn.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.smtt.sdk.WebView;

public abstract class a extends View {
    public static final int[] zOu = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    b fio;
    private Paint gPm;
    protected int kal = -1;
    protected Paint zMK;
    final float zOe = getResources().getDimension(c.vhP);
    private Bitmap zOf;
    private Bitmap zOg;
    private Bitmap zOh;
    private Bitmap zOi;
    private Bitmap zOj;
    private Bitmap zOk;
    protected Bitmap zOl;
    protected Bitmap zOm;
    protected int zOn = -1;
    protected int zOo = -1;
    private Rect[] zOp;
    private Rect[] zOq;
    protected Rect zOr;
    protected boolean zOs;
    protected Paint zOt;
    protected int zOv = -1;
    protected int zOw = -1;
    private boolean zOx = true;

    protected abstract Bitmap a(d dVar, boolean z);

    public a(Context context, b bVar) {
        super(context);
        setId(e.vih);
        this.fio = bVar;
        cBq();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        k(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r7 = 1;
        r0 = 0;
        r6 = -1;
        r1 = r9.getX();
        r2 = (int) r1;
        r1 = r9.getY();
        r3 = (int) r1;
        r1 = r9.getAction();
        switch(r1) {
            case 0: goto L_0x002e;
            case 1: goto L_0x0048;
            case 2: goto L_0x0014;
            case 3: goto L_0x0048;
            default: goto L_0x0014;
        };
    L_0x0014:
        return r7;
    L_0x0015:
        r1 = r8.cBr();
        if (r1 == 0) goto L_0x002c;
    L_0x001b:
        r1 = r8.zOr;
        if (r1 == 0) goto L_0x0044;
    L_0x001f:
        r1 = r8.zOr;
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x0044;
    L_0x0027:
        r8.zOs = r7;
        r8.postInvalidate();
    L_0x002c:
        r0 = r0 + 1;
    L_0x002e:
        r1 = r8.cBs();
        if (r0 >= r1) goto L_0x0014;
    L_0x0034:
        r1 = r8.zOp;
        r1 = r1[r0];
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x0015;
    L_0x003e:
        r8.zOv = r0;
        r8.postInvalidate();
        goto L_0x0014;
    L_0x0044:
        r8.fu(r2, r3);
        goto L_0x002c;
    L_0x0048:
        r1 = r0;
    L_0x0049:
        r4 = r8.cBs();
        if (r1 >= r4) goto L_0x008a;
    L_0x004f:
        r4 = r8.zOp;
        r4 = r4[r1];
        r4 = r4.contains(r2, r3);
        if (r4 == 0) goto L_0x00ce;
    L_0x0059:
        r4 = r8.zOv;
        if (r4 != r1) goto L_0x00ce;
    L_0x005d:
        r4 = r8.HM(r1);
        if (r4 == 0) goto L_0x006d;
    L_0x0063:
        r4 = r8.zOv;
        r5 = r8.kal;
        if (r4 == r5) goto L_0x00bb;
    L_0x0069:
        r4 = r8.zOv;
        r8.kal = r4;
    L_0x006d:
        r4 = r8.zOn;
        r8.zOo = r4;
        r4 = r8.HM(r1);
        if (r4 == 0) goto L_0x00be;
    L_0x0077:
        r1 = r8.kal;
        r8.zOn = r1;
        r1 = r8.fio;
        r1 = r1.cdS();
        r4 = r8.kal;
        r4 = r8.HL(r4);
        r1.a(r4);
    L_0x008a:
        r1 = r8.cBr();
        if (r1 == 0) goto L_0x00af;
    L_0x0090:
        r1 = r8.zOr;
        if (r1 == 0) goto L_0x00d2;
    L_0x0094:
        r1 = r8.zOr;
        r1 = r1.contains(r2, r3);
        if (r1 == 0) goto L_0x00d2;
    L_0x009c:
        r1 = r8.zOs;
        if (r1 == 0) goto L_0x00d2;
    L_0x00a0:
        r1 = r8.fio;
        r1 = r1.cdS();
        r2 = r8.kal;
        r2 = r8.HL(r2);
        r1.a(r2, r6);
    L_0x00af:
        r8.zOs = r0;
        r8.zOv = r6;
        r8.requestLayout();
        r8.postInvalidate();
        goto L_0x0014;
    L_0x00bb:
        r8.kal = r6;
        goto L_0x006d;
    L_0x00be:
        r8.zOn = r1;
        r4 = r8.fio;
        r4 = r4.cdS();
        r1 = r8.HL(r1);
        r4.a(r1);
        goto L_0x008a;
    L_0x00ce:
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x00d2:
        r8.fv(r2, r3);
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.footer.a.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int dimension = (int) getResources().getDimension(c.vhS);
        if (cBr()) {
            dimension += cBv();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(dimension, 1073741824));
        cBw();
    }

    protected void cBq() {
        this.zMK = new Paint(1);
        this.zMK.setColor(-16711936);
        this.zOt = new Paint(1);
        this.zOt.setColor(getResources().getColor(com.tencent.mm.bi.a.b.vhC));
        this.zOt.setStrokeWidth(0.6f);
        this.gPm = new Paint(1);
        this.gPm.setStyle(Style.FILL);
        this.gPm.setStrokeCap(Cap.ROUND);
        this.zOm = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viG));
        this.zOl = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viF));
        this.zOf = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viw));
        this.zOg = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viv));
        this.zOh = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viE));
        this.zOi = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.viD));
        this.zOj = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bi.a.d.vhY);
        this.zOk = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bi.a.d.vhX);
    }

    protected void fu(int i, int i2) {
        switch (HL(this.kal)) {
            case DOODLE:
                for (int i3 = 0; i3 < this.zOq.length; i3++) {
                    if (this.zOq[i3].contains(i, i2)) {
                        this.zOw = i3;
                        this.zOx = false;
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    protected void fv(int i, int i2) {
        switch (HL(this.kal)) {
            case DOODLE:
                int i3 = 0;
                while (this.zOq != null && i3 < this.zOq.length) {
                    if (this.zOq[i3].contains(i, i2) && i3 == this.zOw) {
                        this.fio.cdS().a(d.DOODLE, i3);
                        return;
                    }
                    i3++;
                }
                return;
            default:
                return;
        }
    }

    private boolean cBr() {
        return cBv() > 0;
    }

    private Bitmap b(d dVar, boolean z) {
        Bitmap bitmap = null;
        switch (dVar) {
            case DOODLE:
                if (!z) {
                    bitmap = this.zOf;
                    break;
                }
                bitmap = this.zOg;
                break;
            case TEXT:
                if (!z) {
                    bitmap = this.zOh;
                    break;
                }
                bitmap = this.zOi;
                break;
            case EMOJI:
                if (!z) {
                    bitmap = this.zOj;
                    break;
                }
                bitmap = this.zOk;
                break;
        }
        if (bitmap == null) {
            return a(dVar, z);
        }
        return bitmap;
    }

    private int cBs() {
        return this.fio.cdR().length;
    }

    private float cBt() {
        Bitmap b = b(d.DOODLE, false);
        return b == null ? 0.0f : (float) b.getWidth();
    }

    public static int getColor(int i) {
        if (i < 0 || i >= zOu.length) {
            return -65536;
        }
        return zOu[i];
    }

    private float cBu() {
        return ((((float) getMeasuredWidth()) - (((float) cBs()) * cBt())) - ((float) ((int) (2.0f * this.zOe)))) / ((float) (cBs() - 1));
    }

    protected int cBv() {
        if (HL(this.kal) == d.DOODLE) {
            return (int) getResources().getDimension(c.vhR);
        }
        return 0;
    }

    protected final d HL(int i) {
        if (i < 0 || i >= cBs()) {
            return d.DEFAULT;
        }
        return this.fio.cdR()[i];
    }

    protected void cBw() {
        if (this.zOp == null) {
            this.zOp = new Rect[cBs()];
        }
        int cBt = (int) (this.zOe + (cBt() / 2.0f));
        int cBt2 = (int) cBt();
        for (int i = 0; i < cBs(); i++) {
            this.zOp[i] = new Rect(cBt - cBt2, cBv(), cBt + cBt2, cBv() + getMeasuredHeight());
            cBt = (int) (((float) cBt) + (cBu() + cBt()));
        }
        if (HL(this.kal) == d.DOODLE) {
            cBx();
        }
    }

    private void cBx() {
        int i;
        if (this.zOq == null) {
            this.zOq = new Rect[zOu.length];
        }
        if (this.zOr == null) {
            this.zOr = new Rect();
        }
        float dimension = getResources().getDimension(c.vhL);
        float measuredWidth = (((float) ((getMeasuredWidth() - ((int) (this.zOe * 2.0f))) - this.zOl.getWidth())) - ((2.0f * dimension) * ((float) zOu.length))) / ((float) zOu.length);
        int i2 = (int) (dimension * 2.0f);
        int cBv = (int) (((((float) cBv()) - (dimension * 2.0f)) / 2.0f) + dimension);
        int i3 = (int) ((((float) (((int) (this.zOe * 2.0f)) / 2)) + dimension) + 5.0f);
        for (i = 0; i < zOu.length; i++) {
            this.zOq[i] = new Rect(i3 - i2, cBv - i2, i3 + i2, cBv + i2);
            i3 = (int) (((float) i3) + ((2.0f * dimension) + measuredWidth));
        }
        i = (getMeasuredWidth() - (((int) (this.zOe * 2.0f)) / 2)) - (this.zOl.getWidth() / 2);
        this.zOr.set(i - this.zOl.getWidth(), 0, i + this.zOl.getWidth(), cBv());
    }

    protected void k(Canvas canvas) {
        if (cBr()) {
            canvas.drawLine(0.0f, (float) cBv(), (float) getMeasuredWidth(), (float) cBv(), this.zOt);
            l(canvas);
        }
        float f = this.zOe;
        float measuredHeight = ((((float) (getMeasuredHeight() - cBv())) - cBt()) / 2.0f) + ((float) cBv());
        int i = 0;
        while (true) {
            float f2 = f;
            if (i < cBs()) {
                boolean z;
                d dVar = this.fio.cdR()[i];
                if (this.zOv == i || i == this.kal) {
                    z = true;
                } else {
                    z = false;
                }
                Bitmap b = b(dVar, z);
                if (b != null) {
                    canvas.drawBitmap(b, f2, measuredHeight, null);
                }
                f2 += cBu() + cBt();
                f = i + 1;
            } else {
                return;
            }
        }
    }

    protected void l(Canvas canvas) {
        if (HL(this.kal) == d.DOODLE) {
            float dimension = getResources().getDimension(c.vhL);
            float measuredWidth = (((float) ((getMeasuredWidth() - ((int) (this.zOe * 2.0f))) - this.zOl.getWidth())) - ((2.0f * dimension) * ((float) zOu.length))) / ((float) zOu.length);
            float cBv = ((((float) cBv()) - (dimension * 2.0f)) / 2.0f) + dimension;
            float aJ = (((float) (((int) (this.zOe * 2.0f)) / 2)) + dimension) + ((float) com.tencent.mm.cb.a.aJ(1.5f));
            int i = 0;
            while (i < zOu.length) {
                float f = 0.0f;
                if (this.zOw == i) {
                    f = (float) com.tencent.mm.cb.a.aJ(2.0f);
                    this.zOx = false;
                } else if (this.zOx && i == 2) {
                    f = (float) com.tencent.mm.cb.a.aJ(2.0f);
                }
                this.gPm.setColor(-1);
                canvas.drawCircle(aJ, cBv, (((float) com.tencent.mm.cb.a.aJ(1.5f)) + dimension) + f, this.gPm);
                this.gPm.setColor(zOu[i]);
                canvas.drawCircle(aJ, cBv, f + dimension, this.gPm);
                aJ += (2.0f * dimension) + measuredWidth;
                i++;
            }
            Paint paint = new Paint();
            if (uN()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
            }
            Bitmap bitmap = (this.zOs && uN()) ? this.zOm : this.zOl;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (((int) (this.zOe * 2.0f)) / 2)) - this.zOl.getWidth()), (float) ((cBv() - this.zOl.getHeight()) / 2), paint);
        }
    }

    protected final boolean uN() {
        com.tencent.mm.d.b b = this.fio.b(cBy());
        return b == null ? false : b.uN();
    }

    protected boolean HM(int i) {
        switch (HL(i)) {
            case DOODLE:
                return true;
            default:
                return false;
        }
    }

    public final d cBy() {
        return HL(this.zOn);
    }

    public final void c(d dVar) {
        int i = 0;
        while (i < cBs()) {
            if (this.fio.cdR()[i] == dVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (HM(i)) {
            this.kal = i;
        } else {
            this.kal = -1;
        }
        this.zOn = i;
        requestLayout();
        invalidate();
    }

    public final void cBz() {
        this.zOn = this.zOo;
        requestLayout();
        invalidate();
    }
}
