package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public interface a extends Serializable {
    void a(Canvas canvas, TextPaint textPaint, float f);

    float[] cDi();

    RectF cDj();

    float cDk();

    boolean cDl();

    float cDm();

    int getEnd();

    float getHeight();

    int getStart();

    float getWidth();
}
