package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> qsM = null;
    private int hZI = 0;
    private float kHQ = 0.0f;
    private float nrl = 0.0f;
    private int oSH = 0;
    private List<b> qsN = new ArrayList(4);
    private int qsO = 0;
    private int qsP = 0;
    private int qsQ = 0;
    private int qsR = 0;
    public int qsT = 0;
    private boolean qsW = false;
    private boolean qsX = false;
    public a tQw = null;
    private int topOffset = 0;

    private static class b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface a {
        void wk(int i);
    }

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        brV();
        this.qsN.clear();
        setClickable(true);
        this.qsO = com.tencent.mm.bu.a.fromDPToPix(getContext(), 50);
        this.topOffset = com.tencent.mm.bu.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.oSH = (getHeight() / 2) + this.topOffset;
        this.hZI = (width - (this.qsO * 2)) / 3;
        Bitmap bitmap = (Bitmap) qsM.get();
        for (int i5 = 0; i5 < 4; i5++) {
            b bVar = new b();
            bVar.left = (this.qsO + (this.hZI * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.oSH - (bitmap.getHeight() / 2);
            bVar.right = (this.qsO + (this.hZI * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.oSH + (bitmap.getHeight() / 2);
            this.qsN.add(bVar);
        }
        this.qsP = this.qsT;
        this.qsQ = ((b) this.qsN.get(this.qsP)).left;
        this.qsR = ((b) this.qsN.get(this.qsP)).top;
        invalidate();
    }

    private void brV() {
        if (qsM == null || qsM.get() == null) {
            qsM = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.bCi));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        brV();
        Paint paint = new Paint();
        paint.setARGB(255, d.CTRL_INDEX, d.CTRL_INDEX, d.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.qsO, (float) this.oSH, (float) (width - this.qsO), (float) this.oSH, paint);
        width = 0;
        while (true) {
            int i = width;
            if (i < 4) {
                canvas.drawLine((float) (this.qsO + (this.hZI * i)), (float) (this.oSH - fromDPToPix), (float) (this.qsO + (this.hZI * i)), (float) (this.oSH + fromDPToPix), paint);
                width = i + 1;
            } else {
                Bitmap bitmap = (Bitmap) qsM.get();
                canvas.drawBitmap(bitmap, (float) this.qsQ, (float) this.qsR, null);
                String string = getResources().getString(R.l.eWY);
                String string2 = getResources().getString(R.l.eWZ);
                String string3 = getResources().getString(R.l.eWW);
                String string4 = getResources().getString(R.l.eWX);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bxn);
                Paint paint2 = new Paint();
                paint2.setTextSize((float) dimensionPixelSize);
                fromDPToPix = (int) paint2.measureText(string);
                dimensionPixelSize = Bx(dimensionPixelSize);
                paint2.setColor(getResources().getColor(R.e.bug));
                paint2.setAntiAlias(true);
                canvas.drawText(string, (float) (this.qsO - (fromDPToPix / 2)), (float) ((this.oSH - dimensionPixelSize) - (bitmap.getHeight() / 3)), paint2);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxo);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string2, (float) ((this.qsO + (this.hZI * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.oSH - Bx(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxl);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string3, (float) ((this.qsO + (this.hZI * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.oSH - Bx(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxm);
                paint2.setTextSize((float) dimensionPixelSize2);
                canvas.drawText(string4, (float) ((this.qsO + (this.hZI * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.oSH - Bx(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        b bVar;
        b bVar2;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                this.nrl = motionEvent.getX();
                this.kHQ = motionEvent.getY();
                bVar = (b) this.qsN.get(this.qsP);
                if (this.nrl >= ((float) bVar.left) && this.nrl <= ((float) bVar.right) && this.kHQ >= ((float) bVar.top) && this.kHQ <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i == 0) {
                    this.qsX = true;
                    break;
                }
                this.qsW = true;
                return true;
            case 1:
                if (this.qsW) {
                    int i2 = 0;
                    while (i2 < 3) {
                        bVar = (b) this.qsN.get(i2);
                        bVar2 = (b) this.qsN.get(i2 + 1);
                        if (this.qsQ <= bVar.left + (this.hZI / 2) && this.qsQ >= bVar.left) {
                            this.qsP = i2;
                            this.qsQ = bVar.left;
                            this.qsT = this.qsP;
                            if (this.tQw != null) {
                                this.tQw.wk(this.qsP);
                            }
                            invalidate();
                            this.qsW = false;
                            return true;
                        } else if (this.qsQ < bVar2.left - (this.hZI / 2) || this.qsQ > bVar2.left) {
                            i2++;
                        } else {
                            this.qsP = i2 + 1;
                            this.qsQ = bVar2.left;
                            this.qsT = this.qsP;
                            if (this.tQw != null) {
                                this.tQw.wk(this.qsP);
                            }
                            invalidate();
                            this.qsW = false;
                            return true;
                        }
                    }
                    this.qsT = this.qsP;
                    if (this.tQw != null) {
                        this.tQw.wk(this.qsP);
                    }
                    invalidate();
                    this.qsW = false;
                    return true;
                } else if (this.qsX) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.nrl) <= 10.0f && Math.abs(y - this.kHQ) <= 10.0f) {
                        int i3 = 0;
                        while (i3 < 4) {
                            bVar = (b) this.qsN.get(i3);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i3++;
                            } else {
                                this.qsP = i3;
                                this.qsT = this.qsP;
                                this.qsQ = bVar.left;
                                if (this.tQw != null) {
                                    this.tQw.wk(this.qsP);
                                }
                            }
                        }
                    }
                    this.qsX = false;
                    invalidate();
                    return true;
                }
                break;
            case 2:
                if (!this.qsW) {
                    return super.onTouchEvent(motionEvent);
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.qsQ += (int) (y - this.nrl);
                this.nrl = y;
                this.kHQ = y2;
                bVar = (b) this.qsN.get(0);
                bVar2 = (b) this.qsN.get(3);
                if (this.qsQ <= bVar.left) {
                    this.qsQ = bVar.left;
                } else if (this.qsQ >= bVar2.left) {
                    this.qsQ = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.qsN.get(i);
                        if (this.qsQ < bVar.left - 5 || this.qsQ > bVar.right + 5) {
                            i++;
                        } else {
                            this.qsP = i;
                            this.qsT = this.qsP;
                            if (this.tQw != null) {
                                this.tQw.wk(this.qsP);
                            }
                        }
                    }
                }
                invalidate();
                return true;
            default:
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private static int Bx(int i) {
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
