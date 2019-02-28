package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.sdk.platformtools.ag;

public class MaskImageButton extends ImageButton {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private int r = 0;
    private ag rxb = new ag(Looper.getMainLooper());
    private Runnable rxc = new Runnable() {
        public final void run() {
            MaskImageButton.this.setPressed(false);
            MaskImageButton.this.invalidate();
        }
    };
    public Object zuL;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        MaskImageButton.this.rxb.removeCallbacks(MaskImageButton.this.rxc);
                        break;
                    case 1:
                    case 3:
                        MaskImageButton.this.rxb.post(MaskImageButton.this.rxc);
                        break;
                }
                if (MaskImageButton.this.isClickable() || MaskImageButton.this.isLongClickable()) {
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
}
