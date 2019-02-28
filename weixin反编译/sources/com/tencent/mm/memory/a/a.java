package com.tencent.mm.memory.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class a extends Drawable implements i {
    public static final Paint hca;
    private static final ag hcb = new ag(Looper.getMainLooper());
    boolean DEBUG = false;
    public n hcc;
    private Runnable hcd = new Runnable() {
        public final void run() {
            x.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", a.this.tag);
            a.this.invalidateSelf();
        }
    };
    protected String tag;

    static {
        Paint paint = new Paint();
        hca = paint;
        paint.setAntiAlias(true);
        hca.setFilterBitmap(false);
        hca.setColor(-1118482);
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.hcc = nVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        n nVar = this.hcc;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, hca);
    }

    public final void EF() {
        if (this.hcc != null) {
            this.hcc.EF();
        }
    }

    public final void EG() {
        if (this.hcc != null) {
            this.hcc.EG();
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        if (this.hcc == null) {
            return 0;
        }
        n nVar = this.hcc;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        if (this.hcc == null) {
            return 0;
        }
        n nVar = this.hcc;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getHeight();
    }

    public final n EO() {
        if (this.hcc != null) {
            return this.hcc;
        }
        return null;
    }

    public String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode();
        if (this.hcc != null) {
            return str + this.hcc;
        }
        return str;
    }
}
