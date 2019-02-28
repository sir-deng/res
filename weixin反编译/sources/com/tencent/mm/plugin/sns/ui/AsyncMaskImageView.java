package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class AsyncMaskImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean frK = true;
    private int g = 0;
    private int r = 0;
    ag rxb = new ag();
    Runnable rxc = new Runnable() {
        public final void run() {
            AsyncMaskImageView.this.setPressed(false);
            AsyncMaskImageView.this.invalidate();
        }
    };

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!AsyncMaskImageView.this.frK) {
                    return false;
                }
                AsyncMaskImageView asyncMaskImageView = AsyncMaskImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        asyncMaskImageView.rxb.removeCallbacks(asyncMaskImageView.rxc);
                        break;
                    case 1:
                    case 3:
                        asyncMaskImageView.rxb.post(asyncMaskImageView.rxc);
                        break;
                }
                if (asyncMaskImageView.isClickable() || asyncMaskImageView.isLongClickable()) {
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

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    }
}
