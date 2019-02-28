package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.platformtools.a.a;

public class BorderNumView extends View {
    private static int xMt = 22;
    private static int xMu = 105;
    private static int xMv = 100;
    private Context context = null;
    private Paint fC;
    private int xMs = 100;

    public BorderNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public BorderNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.fC = new Paint();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.xMs < 100) {
            xMt += 15;
        }
        if (this.xMs >= 1000) {
            xMv -= 20;
        }
        float b = (float) a.b(this.context, (float) xMt);
        float b2 = (float) a.b(this.context, (float) xMu);
        String str = this.xMs;
        this.fC.setAntiAlias(true);
        this.fC.setTextSize((float) xMv);
        this.fC.setColor(-11491572);
        this.fC.setStyle(Style.STROKE);
        this.fC.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.fC);
        this.fC.setTextSize((float) xMv);
        this.fC.setColor(-1770573);
        this.fC.setStyle(Style.FILL);
        this.fC.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.fC);
    }
}
