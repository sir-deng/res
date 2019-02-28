package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ag;

public class FirstScreenFrameLayout extends FrameLayout {
    public a gzo;

    public interface a {
        void wF();
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gzo != null) {
            new ag(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable() {
                public final void run() {
                    if (FirstScreenFrameLayout.this.gzo != null) {
                        FirstScreenFrameLayout.this.gzo.wF();
                        FirstScreenFrameLayout.this.gzo = null;
                    }
                }
            });
        }
    }
}
