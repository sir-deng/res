package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView extends View {
    private static final Paint hca = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        hca.setAntiAlias(true);
        hca.setFilterBitmap(true);
        hca.setColor(737373);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        if (textSize == -1) {
            textSize = b.b(this.context, 12.0f);
            hca.setTextSize((float) textSize);
        }
        hca.setColor(this.context.getResources().getColor(c.black));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), hca);
    }
}
