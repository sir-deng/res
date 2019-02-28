package com.tencent.mm.s;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.smtt.sdk.WebView;

public final class a implements Cloneable {
    public static Rect gO = new Rect();
    private static int gOZ = ((int) ad.getResources().getDimension(c.vhE));
    private static int gPa = ((int) ad.getResources().getDimension(c.vhD));
    public static float gPb = ad.getResources().getDimension(c.vhI);
    public static float gPc = ad.getResources().getDimension(c.vhH);
    public static Path gPd = new Path();
    public static Path gPe = new Path();
    public static Paint gPf = new Paint();
    public static Paint gPg = new Paint();
    public static Paint gPh = new Paint();
    public static Paint gPi = new Paint();
    public static Paint gPj = new Paint();
    public Rect fdj;
    public Rect gPk = new Rect();
    public Rect gPl = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        gPh.setColor(WebView.NIGHT_MODE_COLOR);
        gPf.setColor(-1);
        gPf.setStrokeWidth((float) gOZ);
        gPf.setStyle(Style.STROKE);
        gPf.setAntiAlias(true);
        gPi.set(gPf);
        gPi.setStrokeWidth((float) gPa);
        gPj.set(gPf);
        gPj.setStrokeWidth(gPb);
        gPg.set(gPf);
        gPg.setStrokeWidth((float) (gOZ * 7));
        gPg.setColor(549174203);
    }

    public a(Rect rect) {
        this.fdj = rect;
    }

    public static void gm(int i) {
        gPj.setAlpha(i);
        gPf.setAlpha(i);
        gPi.setAlpha((int) (0.7058824f * ((float) i)));
    }

    public static void gn(int i) {
        gPh.setAlpha((int) (0.9019608f * ((float) i)));
    }

    public final Object clone() {
        return super.clone();
    }
}
