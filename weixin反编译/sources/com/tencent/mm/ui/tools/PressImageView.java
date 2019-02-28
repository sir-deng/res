package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;
import junit.framework.Assert;

public class PressImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private int r = 0;
    private ag rxb = new ag();
    private Runnable rxc = new Runnable() {
        public final void run() {
            PressImageView.this.setPressed(false);
            PressImageView.this.invalidate();
        }
    };

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        PressImageView.this.rxb.removeCallbacks(PressImageView.this.rxc);
                        break;
                    case 1:
                    case 3:
                        PressImageView.this.rxb.post(PressImageView.this.rxc);
                        break;
                }
                if (PressImageView.this.isClickable() || PressImageView.this.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
