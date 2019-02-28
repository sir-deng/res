package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.ag;

public class MaskImageView extends TagImageView {
    private int a = 90;
    private int b = 0;
    boolean frK = true;
    private int g = 0;
    private int r = 0;
    private ag rxb = new ag(Looper.getMainLooper());
    private Runnable rxc = new Runnable() {
        public final void run() {
            MaskImageView.this.setPressed(false);
            MaskImageView.this.invalidate();
        }
    };

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (MaskImageView.this.frK) {
                    return MaskImageView.this.c(view, motionEvent);
                }
                return false;
            }
        });
        super.setContentDescription(getContext().getResources().getString(j.qRf));
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.rxb.removeCallbacks(this.rxc);
                break;
            case 1:
            case 3:
                this.rxb.post(this.rxc);
                break;
        }
        if (isClickable() || isLongClickable()) {
            return false;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
