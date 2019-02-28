package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;

final class a extends AppCompatButton {
    private RectF jbw;
    private boolean jbx;
    private float jby;
    private float jbz;

    private class a extends Drawable {
        Paint jbA;
        RectF jbB;

        private a() {
            this.jbA = new Paint(1);
            this.jbB = new RectF();
            this.jbA.setColor(-12748166);
            this.jbA.setStyle(Style.FILL);
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void draw(Canvas canvas) {
            float height = ((float) canvas.getHeight()) / 2.0f;
            RectF rectF = this.jbB;
            this.jbB.top = 0.0f;
            rectF.left = 0.0f;
            rectF = this.jbB;
            float f = height * 2.0f;
            this.jbB.bottom = f;
            rectF.right = f;
            canvas.drawArc(this.jbB, 90.0f, 180.0f, false, this.jbA);
            this.jbB.left = ((float) canvas.getWidth()) - (height * 2.0f);
            this.jbB.top = 0.0f;
            this.jbB.right = (float) canvas.getWidth();
            this.jbB.bottom = (float) canvas.getHeight();
            canvas.drawArc(this.jbB, -90.0f, 180.0f, false, this.jbA);
            canvas.drawRect(height - 1.0f, 0.0f, (((float) a.this.getWidth()) - height) + 1.0f, (float) a.this.getHeight(), this.jbA);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -1;
        }
    }

    public a(Context context) {
        super(context);
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f = getContext().getResources().getDisplayMetrics().density;
        setPadding((int) (13.0f * f), (int) (4.0f * f), (int) (13.0f * f), (int) (f * 6.0f));
        setBackgroundDrawable(new a());
    }

    private boolean q(float f, float f2) {
        if (this.jbw == null) {
            return false;
        }
        return this.jbw.contains(f, f2);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jbw = new RectF(getX(), getY(), getX() + ((float) getWidth()), getY() + ((float) getHeight()));
                this.jbx = false;
                break;
            case 1:
                if (!this.jbx && q(motionEvent.getRawX(), motionEvent.getRawY())) {
                    performClick();
                    break;
                }
            case 2:
                if (this.jbx || !q(motionEvent.getRawX(), motionEvent.getRawY())) {
                    setX(getX() + (motionEvent.getRawX() - this.jby));
                    setY(getY() + (motionEvent.getRawY() - this.jbz));
                    requestLayout();
                    this.jbx = true;
                    break;
                }
        }
        this.jby = motionEvent.getRawX();
        this.jbz = motionEvent.getRawY();
        return true;
    }
}
