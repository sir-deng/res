package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point rot = new Point(0, 0);
    private Rect fD = new Rect();
    private Path mY = new Path();
    private int roA = 80;
    private Point roB = rot;
    private Spannable[] roD;
    private List<PointF> roE;
    private int roo = 4;
    private int rop = 4;
    private float ror = 1.0f;
    public c ros;

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bxA();
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bxA();
    }

    public RadarGrid(Context context, int i, int i2, float f, Spannable[] spannableArr, c cVar) {
        super(context);
        this.ror = f;
        this.roo = i;
        this.rop = i2;
        this.ror = f;
        this.roD = spannableArr;
        this.ros = cVar;
    }

    private void bxA() {
        setMinimumHeight(JsApiSetBackgroundAudioState.CTRL_INDEX);
        setMinimumWidth(JsApiSetBackgroundAudioState.CTRL_INDEX);
    }

    protected final int bxx() {
        return this.roA * 2;
    }

    protected final int bxy() {
        return this.roA * 2;
    }

    private List<PointF> av(float f) {
        List<PointF> arrayList = new ArrayList();
        for (int i = 0; i < this.roo; i++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.roB.x) - (((double) (((float) this.roA) * f)) * Math.sin((((double) (i * 2)) * 3.141592653589793d) / ((double) this.roo)))), (float) (((double) this.roB.y) - (((double) (((float) this.roA) * f)) * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) this.roo)))));
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        int i;
        PointF pointF;
        float f;
        float f2;
        float f3;
        float f4;
        Paint paint;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.roA = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.roB.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.ros.roe != null) {
            width = (int) (((float) width) / 2.0f);
            height = (int) (((float) height) / 2.0f);
            i = (int) (((float) (this.roA * 2)) + (this.ros.rob * 2.0f));
            int width2 = (this.ros.roe.getWidth() * i) / this.ros.roe.getHeight();
            if (this.ros.roe != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(this.ros.roe, width2, i, false), (float) (width - (width2 >>> 1)), (float) (height - (i >>> 1)), null);
            }
        }
        if (this.ros.rnL) {
            switch (this.ros.rnK) {
                case 0:
                    this.roE = av(1.0f);
                    height = 0;
                    while (true) {
                        width = height;
                        if (width >= this.roo) {
                            this.mY.close();
                            if (this.ros.backgroundColor != 0 && this.ros.roe == null) {
                                canvas.drawPath(this.mY, bxB());
                                break;
                            }
                        }
                        pointF = (PointF) this.roE.get(width);
                        if (width == 0) {
                            this.mY.moveTo(pointF.x, pointF.y);
                        } else {
                            this.mY.lineTo(pointF.x, pointF.y);
                        }
                        height = width + 1;
                    }
                case 1:
                    canvas.drawCircle((float) this.roB.x, (float) this.roB.y, (float) this.roA, bxB());
                    break;
            }
        }
        if (this.ros.rnM) {
            this.roE = av(1.0f);
            height = 0;
            while (true) {
                int i2 = height;
                if (i2 < this.roo) {
                    pointF = (PointF) this.roE.get(i2);
                    f = (float) this.roB.x;
                    f2 = (float) this.roB.y;
                    f3 = pointF.x;
                    f4 = pointF.y;
                    paint = new Paint();
                    paint.setColor(this.ros.rnR);
                    paint.setStrokeWidth(this.ros.rnS);
                    canvas.drawLine(f, f2, f3, f4, paint);
                    height = i2 + 1;
                }
            }
        }
        if (this.ros.rnL) {
            switch (this.ros.rnK) {
                case 0:
                    canvas.drawPath(this.mY, bxC());
                    this.mY.reset();
                    height = 1;
                    while (true) {
                        width = height;
                        if (width >= this.rop) {
                            break;
                        }
                        this.roE = av((((float) width) * 1.0f) / ((float) this.rop));
                        height = 0;
                        while (true) {
                            i = height;
                            if (i < this.roo) {
                                pointF = (PointF) this.roE.get(i);
                                if (i == 0) {
                                    this.mY.moveTo(pointF.x, pointF.y);
                                } else {
                                    this.mY.lineTo(pointF.x, pointF.y);
                                }
                                f3 = pointF.x;
                                float f5 = pointF.y;
                                f4 = (float) this.ros.rod;
                                paint = new Paint();
                                paint.setColor(this.ros.roc);
                                paint.setStyle(Style.FILL);
                                paint.setAntiAlias(true);
                                canvas.drawCircle(f3, f5, f4, paint);
                                height = i + 1;
                            } else {
                                this.mY.close();
                                canvas.drawPath(this.mY, bxD());
                                this.mY.reset();
                                height = width + 1;
                            }
                        }
                    }
                case 1:
                    canvas.drawCircle((float) this.roB.x, (float) this.roB.y, (float) this.roA, bxC());
                    for (height = 1; height < this.rop; height++) {
                        canvas.drawCircle((float) this.roB.x, (float) this.roB.y, ((float) this.roA) * ((((float) height) * 1.0f) / ((float) this.rop)), bxD());
                    }
                    break;
            }
        }
        if (this.roD != null && this.ros.rnO) {
            if (this.roD.length != this.roo) {
                throw new RuntimeException("Labels array length not matches longitude lines number.");
            }
            height = 0;
            while (true) {
                int i3 = height;
                if (i3 < this.roo) {
                    CharSequence charSequence = this.roD[i3];
                    if (!charSequence.equals(null)) {
                        float f6;
                        float f7;
                        if (i3 == 0 || i3 == (this.roo >>> 1)) {
                            f6 = 0.5f;
                        } else if (i3 <= 0 || i3 >= (this.roo >>> 1)) {
                            f6 = 1.0f;
                        } else {
                            f6 = 0.0f;
                        }
                        if (i3 == 0) {
                            f7 = this.ros.rnW;
                        } else if (i3 == (this.roo >>> 1)) {
                            f7 = -this.ros.rnW;
                        } else {
                            f7 = 0.0f;
                        }
                        TextPaint textPaint = new TextPaint();
                        textPaint.setColor(this.ros.rnU);
                        textPaint.setTextSize(this.ros.rnV);
                        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, 1000, Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                        f = (float) (((double) (((float) this.roB.x) - (staticLayout.getLineWidth(0) * f6))) - (((double) (((float) this.roA) + this.ros.rnW)) * Math.sin(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.roo)))));
                        f2 = (float) ((((double) (this.roB.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.roA) + this.ros.rnW)) * Math.cos(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.roo))))) - ((double) f7));
                        canvas.save();
                        canvas.translate(f, f2);
                        staticLayout.draw(canvas);
                        canvas.restore();
                    }
                    height = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private Paint bxB() {
        Paint paint = new Paint();
        paint.setColor(this.ros.backgroundColor);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bxC() {
        Paint paint = new Paint();
        c cVar = this.ros;
        paint.setColor(cVar.rnP == -1 ? cVar.rnQ : cVar.rnP);
        paint.setStyle(Style.STROKE);
        cVar = this.ros;
        paint.setStrokeWidth(cVar.rnT == -1.0f ? cVar.rnS : cVar.rnT);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bxD() {
        Paint paint = new Paint();
        paint.setColor(this.ros.rnQ);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.ros.rnS);
        paint.setAntiAlias(true);
        return paint;
    }

    public void setBackgroundColor(int i) {
        this.ros.backgroundColor = i;
        invalidate();
    }
}
