package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.v.a.m;
import com.tencent.smtt.sdk.WebView;

public class MMVerticalTextView extends View {
    private int direction;
    private TextPaint gu = new TextPaint();
    private String kav;
    Rect ymV = new Rect();

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gu.setAntiAlias(true);
        this.gu.setTextSize(15.0f);
        this.gu.setColor(WebView.NIGHT_MODE_COLOR);
        this.gu.setTextAlign(Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fbs);
        int resourceId = obtainStyledAttributes.getResourceId(m.hbp, 0);
        if (resourceId != 0) {
            this.kav = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelOffset(m.hbr, 15);
        if (resourceId > 0) {
            this.gu.setTextSize((float) resourceId);
        }
        this.gu.setColor(obtainStyledAttributes.getColor(m.hbq, WebView.NIGHT_MODE_COLOR));
        this.direction = obtainStyledAttributes.getInt(m.hbs, 0);
        this.gu.setFakeBoldText(obtainStyledAttributes.getBoolean(m.hbt, false));
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }

    public final void setText(String str) {
        this.kav = str;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int height;
        this.gu.getTextBounds(this.kav, 0, this.kav.length(), this.ymV);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            height = this.ymV.height();
            size = mode == Integer.MIN_VALUE ? Math.min(height, size) : height;
        }
        int mode2 = MeasureSpec.getMode(i2);
        height = MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            mode = this.ymV.width();
            height = mode2 == Integer.MIN_VALUE ? Math.min(mode, height) : mode;
        }
        setMeasuredDimension(size, height);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int width;
        if (this.direction == 0) {
            width = (getWidth() >> 1) - (this.ymV.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            width = (getWidth() >> 1) + (this.ymV.height() >> 1);
            path.moveTo((float) width, (float) height);
            path.lineTo((float) width, 0.0f);
        }
        canvas.drawTextOnPath(this.kav, path, 0.0f, 0.0f, this.gu);
    }
}
