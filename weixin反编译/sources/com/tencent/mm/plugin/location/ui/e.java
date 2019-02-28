package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends ImageView {
    private static int nYF;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private boolean bgH;
    private double bhG;
    public a gAn = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            if (e.this.nYG) {
                return false;
            }
            x.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", Float.valueOf(f2), Float.valueOf(f));
            e.this.nYy = true;
            e.this.bhG = d2;
            e.this.nYz = (double) f2;
            e.this.nYA = (double) f;
            if (e.this.nYC != null) {
                if (e.this.nYD) {
                    e.this.nYC.updateViewLayout(e.this, e.this.nYz, e.this.nYA, -2);
                } else {
                    e.this.nYD = true;
                    e.this.nYC.addView(e.this, e.this.nYz, e.this.nYA, -2);
                }
            }
            if (e.this.nYw != null) {
                e.this.nYw.a(z, f, f2, i, d, d2, d3);
            }
            e.this.invalidate();
            e.this.postInvalidate();
            e.this.requestLayout();
            e.this.nYG = true;
            return true;
        }
    };
    private Activity mActivity;
    private double nYA;
    public c nYB;
    private d nYC;
    private boolean nYD = false;
    private final int nYE = 689208551;
    private boolean nYG = false;
    private a nYw;
    private Bitmap nYx;
    private boolean nYy;
    private double nYz;

    public e(Activity activity, int i, d dVar) {
        super(activity);
        this.nYC = dVar;
        this.nYw = null;
        this.mActivity = activity;
        this.nYx = com.tencent.mm.sdk.platformtools.d.Ds(i);
        this.bgH = false;
        this.nYy = false;
        this.nYB = c.OV();
        nYF = b.b((Context) activity, 80.0f);
        setImageResource(i);
        setScaleType(ScaleType.FIT_CENTER);
        x.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.bgH = true;
        this.nYB.a(this.gAn);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x.d("MicroMsg.MyPoiPoint", "onDraw");
    }
}
