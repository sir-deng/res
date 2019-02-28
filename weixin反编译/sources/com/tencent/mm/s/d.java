package com.tencent.mm.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d implements Cloneable {
    private static int gPF = com.tencent.mm.cb.a.aJ(12.0f);
    private static Paint gPH;
    private LinkedList<b> fjG;
    public int fjH;
    private Bitmap gPG;
    private float gr;
    private Path mY;

    public enum a {
        ;

        static {
            gPI = 1;
            gPJ = 2;
            gPK = new int[]{gPI, gPJ};
        }
    }

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float gPL = 0.0f;
        public float rotation = 0.0f;

        public b(float f, int i, float f2, float f3, float f4) {
            this.gPL = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        Paint paint = new Paint();
        gPH = paint;
        paint.setAntiAlias(true);
        gPH.setStyle(Style.STROKE);
        gPH.setColor(-16776961);
        gPH.setStrokeCap(Cap.ROUND);
    }

    public d(int i, Path path, float f, Bitmap bitmap) {
        this.fjH = i;
        this.gPG = bitmap;
        this.mY = path;
        this.gr = f;
        gPH.setStrokeWidth(((float) com.tencent.mm.cb.a.aJ(24.0f)) * f);
    }

    public d(int i, a<LinkedList> aVar, float f) {
        this.fjH = i;
        this.fjG = aVar;
        this.gr = f;
        gPH.setStrokeWidth(((float) com.tencent.mm.cb.a.aJ(24.0f)) * f);
    }

    public final void draw(Canvas canvas) {
        float f = 0.0f;
        Bitmap bitmap;
        if (this.fjH == a.gPI) {
            bitmap = this.gPG;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.mY, gPH);
                gPH.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, gPH);
                gPH.setXfermode(null);
                canvas.restore();
            }
        } else if (this.fjH == a.gPJ && this.fjG.size() > 0) {
            b bVar = (b) this.fjG.getLast();
            float f2 = bVar.gPL;
            int i = bVar.color;
            int random = (int) (Math.random() * 100.0d);
            float f3 = ((float) gPF) * f2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.bi.a.d.vhZ, options);
            options.inSampleSize = com.tencent.mm.cb.a.a(options, Math.round((((float) options.outWidth) * f2) * 0.7f), Math.round((f2 * ((float) options.outHeight)) * 0.7f));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.bi.a.d.vhZ, options);
            gPH.setStyle(Style.FILL);
            gPH.setColorFilter(new LightingColorFilter(i, 1));
            if (bitmap != null) {
                f2 = bVar.centerX - ((((float) bitmap.getWidth()) * 1.0f) / 2.0f);
                f = bVar.centerY - ((((float) bitmap.getHeight()) * 1.0f) / 2.0f);
            } else {
                f2 = 0.0f;
            }
            if (random > 0 && random <= 20) {
                f2 += f3;
                f += f3;
            } else if (80 < random) {
                f2 -= f3;
                f -= f3;
            }
            canvas.save();
            canvas.rotate(-bVar.rotation, bVar.centerX, bVar.centerY);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, f2, f, gPH);
            }
            canvas.restore();
            gPH.setStyle(Style.STROKE);
            gPH.setColorFilter(null);
        }
    }

    public static void clear() {
    }
}
