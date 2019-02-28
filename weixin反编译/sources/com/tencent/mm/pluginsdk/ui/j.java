package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class j extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final Paint hca;
    protected static final ag hcb = new ag(Looper.getMainLooper());
    private Runnable hcd;
    private Paint jbA = new Paint();
    protected boolean oCI = false;
    protected final a prd;
    private Rect rect = new Rect();
    protected String tag;
    protected boolean vqL = false;
    private int vqM = 0;
    private int vqN = 0;
    protected boolean vqO;
    protected boolean vqP;
    protected float vqQ = 1.0f;
    private PaintFlagsDrawFilter vqR = new PaintFlagsDrawFilter(0, 3);
    private Path vqS;

    public interface a {
        void a(j jVar);

        Bitmap b(String str, int i, int i2, int i3);

        Bitmap cm(String str);

        Bitmap cn(String str);

        Bitmap tK();
    }

    static {
        Paint paint = new Paint();
        hca = paint;
        paint.setAntiAlias(true);
        hca.setFilterBitmap(true);
    }

    public j(a aVar, String str) {
        super(aVar.tK());
        this.jbA.setStyle(Style.STROKE);
        this.jbA.setFlags(1);
        this.jbA.setAntiAlias(true);
        this.vqS = new Path();
        this.hcd = new Runnable() {
            public final void run() {
                j.this.invalidateSelf();
            }
        };
        this.prd = aVar;
        this.tag = str;
        this.prd.a(this);
    }

    public j(a aVar, String str, boolean z) {
        super(aVar.tK());
        this.jbA.setStyle(Style.STROKE);
        this.jbA.setFlags(1);
        this.jbA.setAntiAlias(true);
        this.vqS = new Path();
        this.hcd = /* anonymous class already generated */;
        this.oCI = false;
        this.prd = aVar;
        this.tag = str;
        this.prd.a(this);
    }

    public final void qR(String str) {
        if (str != null && str.length() > 0 && !str.equals(this.tag)) {
            this.tag = str;
            hcb.post(this.hcd);
        }
    }

    public final void la(boolean z) {
        this.vqL = z;
    }

    public void draw(Canvas canvas) {
        Bitmap b;
        if (this.vqL) {
            b = this.prd.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.vqO) {
            b = this.prd.cn(this.tag);
        } else {
            b = this.prd.cm(this.tag);
        }
        if (b == null || b.isRecycled()) {
            b = this.prd.tK();
            if (this.vqO) {
                this.vqP = true;
            } else {
                this.vqP = false;
            }
        } else {
            this.vqP = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vqQ > 1.0f || this.oCI) {
            int height = (b.getHeight() / 15) / 2;
            int width = (b.getWidth() / 15) / 2;
            rect = new Rect(width, height, b.getWidth() - width, b.getHeight() - height);
        }
        canvas.drawBitmap(b, rect, bounds, hca);
    }

    public void jk(String str) {
        if (str != null && str.equals(this.tag)) {
            x.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            hcb.post(this.hcd);
        }
    }

    public final void caP() {
        this.vqO = true;
    }

    public final void caQ() {
        if (this.vqO) {
            this.vqO = false;
            if (this.vqP) {
                this.vqP = false;
                invalidateSelf();
            }
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            this.vqO = true;
        } else {
            caQ();
        }
    }
}
