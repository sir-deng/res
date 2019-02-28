package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public class HighlightRectSideView extends View {
    private al ind = new al(new a() {
        public final boolean uG() {
            HighlightRectSideView.this.qbp = HighlightRectSideView.this.qbp + 1;
            HighlightRectSideView.this.invalidate();
            return true;
        }
    }, true);
    private Paint nd;
    private boolean[] qbk;
    private Rect qbl;
    private int qbm;
    private int qbn;
    private int qbo;
    private int qbp = 0;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap decodeResource = com.tencent.mm.compatible.g.a.decodeResource(getResources(), R.g.bFD);
        this.qbm = decodeResource.getWidth();
        this.qbn = decodeResource.getHeight();
        if (this.qbn != this.qbm) {
            x.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.qbo = (this.qbm * 6) / 24;
        this.qbk = new boolean[4];
        this.nd = new Paint();
        this.nd.setColor(6676738);
        this.nd.setAlpha(255);
        this.nd.setStrokeWidth((float) this.qbo);
        this.nd.setStyle(Style.STROKE);
        this.ind.K(300, 300);
    }

    public final void i(Rect rect) {
        this.qbl = rect;
        x.d("MicroMsg.HighlightRectSideView", "rect:%s", rect);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ind != null) {
            this.ind.TN();
            this.ind = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.qbk[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.qbo / 2;
        if (this.qbk[0] && (1 == i || this.qbp % 2 == 0)) {
            canvas.drawLine((float) (this.qbl.left + i3), (float) (this.qbl.top + this.qbn), (float) (this.qbl.left + i3), (float) (this.qbl.bottom - this.qbn), this.nd);
        }
        if (this.qbk[1] && (1 == i || this.qbp % 2 == 0)) {
            canvas.drawLine((float) (this.qbl.right - i3), (float) (this.qbl.top + this.qbn), (float) (this.qbl.right - i3), (float) (this.qbl.bottom - this.qbn), this.nd);
        }
        if (this.qbk[2] && (1 == i || this.qbp % 3 == 0)) {
            canvas.drawLine((float) (this.qbl.left + this.qbm), (float) (this.qbl.top + i3), (float) (this.qbl.right - this.qbm), (float) (this.qbl.top + i3), this.nd);
        }
        if (!this.qbk[3]) {
            return;
        }
        if (1 == i || this.qbp % 3 == 0) {
            canvas.drawLine((float) (this.qbl.left + this.qbm), (float) (this.qbl.bottom - i3), (float) (this.qbl.right - this.qbm), (float) (this.qbl.bottom - i3), this.nd);
        }
    }

    public final void b(boolean[] zArr) {
        int i = 0;
        if (zArr != null && 4 == zArr.length) {
            x.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3]));
            while (i < 4) {
                this.qbk[i] = zArr[i];
                i++;
            }
            invalidate();
        }
    }
}
