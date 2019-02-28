package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;

public class TextProgressBar extends ProgressBar {
    private Paint fC;
    private int jxg;
    private String kav;
    private Context mContext;
    private int sm;

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void setProgress(int i) {
        this.sm = i;
        this.kav = String.valueOf(i) + "%";
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fC = new Paint();
        this.fC.setAntiAlias(true);
        this.fC.setColor(Color.rgb(69, ar.CTRL_INDEX, 26));
        this.fC.setTextSize((float) this.jxg);
        Rect rect = new Rect();
        this.fC.getTextBounds(this.kav, 0, this.kav.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        canvas.drawText(this.kav, width, height, this.fC);
        float width2 = (((float) this.sm) / 100.0f) * ((float) getWidth());
        if (width2 > width) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.jxg);
            RectF rectF = new RectF(0.0f, 0.0f, width2, (float) getHeight());
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawText(this.kav, width, height, paint);
            canvas.restore();
        }
    }

    public final void rv(int i) {
        this.jxg = a.fromDPToPix(this.mContext, i);
    }
}
