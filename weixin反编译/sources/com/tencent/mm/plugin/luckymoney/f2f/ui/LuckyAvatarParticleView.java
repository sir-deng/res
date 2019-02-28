package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView extends View {
    private Paint jbA = new Paint();
    private List<Rect> oeZ = new ArrayList();
    private List<Integer> ofa = new ArrayList();
    private List<Integer> ofb = new ArrayList();

    public LuckyAvatarParticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oeZ.size()) {
                canvas.drawRect((Rect) this.oeZ.get(i2), this.jbA);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
