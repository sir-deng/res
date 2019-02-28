package com.tencent.mm.d;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.mm.s.b;
import com.tencent.mm.view.footer.a;

public final class d extends b {
    private float YR;
    private float YS;
    private boolean fiT = false;
    private float fiU;
    private float fiV;
    private float fjq;
    private boolean fjr = true;
    private Path mY = new Path();
    public int su = a.zOu[2];

    public final void uK() {
        super.uK();
        this.fjq = this.fio.cdX();
    }

    public final a uH() {
        return a.DOODLE;
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!uP()) {
            return false;
        }
        float[] l = l(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.fiq.contains((int) l[0], (int) l[1])) {
                    float f = l[0];
                    this.fiU = f;
                    this.YR = f;
                    float f2 = l[1];
                    this.fiV = f2;
                    this.YS = f2;
                    this.fjr = true;
                } else {
                    this.fjr = false;
                }
                this.fiT = false;
                break;
            case 1:
            case 5:
                if (this.fjr && this.fiT) {
                    uJ().add(new b(new Path(this.mY), (this.fjq / this.fio.cdX()) / this.fio.cdY(), this.su));
                    aK(false);
                }
                uU();
                this.mY.reset();
                this.fiT = false;
                this.fjr = false;
                break;
            case 2:
                if (!this.fjr || !this.fiT) {
                    if (this.fjr && !this.fiT) {
                        this.mY.moveTo(l[0], l[1]);
                        this.fiT = true;
                        break;
                    }
                }
                this.fiU = this.YR;
                this.fiV = this.YS;
                this.YR = l[0];
                this.YS = l[1];
                this.mY.quadTo(this.fiU, this.fiV, (this.YR + this.fiU) / 2.0f, (this.YS + this.fiV) / 2.0f);
                uT();
                break;
                break;
        }
        return this.fjr;
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.fiq);
        b(canvas);
        if (!this.mY.isEmpty()) {
            new b(this.mY, (this.fjq / this.fio.cdX()) / this.fio.cdY(), this.su).draw(canvas);
        }
        canvas.restore();
    }

    public final void uI() {
        aK(true);
    }
}
