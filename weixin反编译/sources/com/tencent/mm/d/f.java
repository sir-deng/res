package com.tencent.mm.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.g;
import com.tencent.mm.cache.g.AnonymousClass1;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.s.d;
import com.tencent.mm.s.d.a;
import com.tencent.mm.s.d.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class f extends b<g> {
    private float YR;
    private float YS;
    private boolean fiT = false;
    private float fiU;
    private float fiV;
    private Bitmap fjF;
    private LinkedList<b> fjG = new LinkedList();
    public int fjH = a.gPI;
    private boolean fjr = true;
    private Path mY = new Path();

    public final a uH() {
        return a.MOSAIC;
    }

    public final void uK() {
        Bitmap bitmap;
        super.uK();
        d(((g) uJ()).xJ());
        Bitmap cdZ = this.fio.cdZ();
        if (cdZ == null) {
            x.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = cdZ.getWidth();
            int height = cdZ.getHeight();
            int aJ = com.tencent.mm.cb.a.aJ(6.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) aJ)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) aJ)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i = 0; i < ceil; i++) {
                for (int i2 = 0; i2 < ceil2; i2++) {
                    int i3 = aJ * i;
                    int i4 = aJ * i2;
                    int i5 = i3 + aJ;
                    int i6 = i5 > width ? width : i5;
                    i5 = i4 + aJ;
                    if (i5 > height) {
                        i5 = height;
                    }
                    int pixel = cdZ.getPixel(i3, i4);
                    Rect rect = new Rect(i3, i4, i6, i5);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.fjF = bitmap;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.fjF != null && !this.fjF.isRecycled()) {
            this.fjF.recycle();
        }
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.fiq);
        if (this.fjH == a.gPI) {
            b(canvas);
            new d(this.fjH, this.mY, 1.0f / getScale(), this.fjF).draw(canvas);
        } else if (this.fjH == a.gPJ) {
            new d(this.fjH, new LinkedList(this.fjG), 1.0f / getScale()).draw(new Canvas(uO()));
            b(canvas);
        }
        canvas.restore();
    }

    public final boolean q(MotionEvent motionEvent) {
        int i = 0;
        if (!uP()) {
            return false;
        }
        float[] l = l(motionEvent.getX(), motionEvent.getY());
        float f;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.fiq.contains((int) l[0], (int) l[1])) {
                    f = l[0];
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
                    if (this.fjH == a.gPI) {
                        ((g) uJ()).a(new d(this.fjH, new Path(this.mY), 1.0f / getScale(), this.fjF));
                        aK(false);
                    } else if (this.fjH == a.gPJ) {
                        ((g) uJ()).a(new d(this.fjH, new LinkedList(this.fjG), 1.0f / getScale()));
                        aK(false);
                    }
                    uU();
                }
                this.fjG.clear();
                this.mY.reset();
                this.fiT = false;
                this.fjr = false;
                break;
            case 2:
                if (!this.fjr || !this.fiT) {
                    if (this.fjr && !this.fiT) {
                        if (this.fjH == a.gPI) {
                            this.mY.moveTo(l[0], l[1]);
                        }
                        this.fiT = true;
                        break;
                    }
                }
                this.fiU = this.YR;
                this.fiV = this.YS;
                this.YR = l[0];
                this.YS = l[1];
                if (this.fjH == a.gPI) {
                    this.mY.quadTo(this.fiU, this.fiV, (this.YR + this.fiU) / 2.0f, (this.YS + this.fiV) / 2.0f);
                } else if (this.fjH == a.gPJ) {
                    int i2;
                    double toDegrees = Math.toDegrees(Math.atan((double) ((this.YR - this.fiU) / (this.YS - this.fiV))));
                    if (getRotation() == 180.0f) {
                        i2 = 180;
                    } else {
                        i2 = 0;
                    }
                    float f3 = ((float) (((double) i2) + toDegrees)) % 360.0f;
                    LinkedList linkedList = this.fjG;
                    f = 1.0f / getScale();
                    float f4 = this.YR;
                    float f5 = this.YS;
                    Bitmap cdZ = this.fio.cdZ();
                    if (cdZ == null || f4 >= ((float) cdZ.getWidth()) || f5 >= ((float) cdZ.getHeight()) || f4 <= 0.0f || f5 <= 0.0f) {
                        x.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", Float.valueOf(f4), Float.valueOf(f5));
                    } else {
                        i = cdZ.getPixel((int) f4, (int) f5);
                    }
                    linkedList.add(new b(f, i, f3, this.YR, this.YS));
                }
                uT();
                break;
                break;
        }
        return this.fjr;
    }

    public final void aK(boolean z) {
        super.aK(z);
        g gVar = (g) uJ();
        Bitmap copy = uO().copy(Config.ARGB_8888, true);
        String aVar = a.MOSAIC.toString();
        String str = e.gJe + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), aVar});
        x.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", str, Integer.valueOf(gVar.bb(true)));
        aVar = (String) gVar.gDk.get(gVar.bb(true));
        if (!bi.oN(aVar)) {
            FileOp.deleteFile(aVar);
            gVar.gDk.remove(gVar.bb(true));
        }
        gVar.gDk.put(gVar.bb(true), str);
        gVar.gDl.put(str, copy);
        com.tencent.mm.sdk.f.e.chE();
        com.tencent.mm.sdk.f.e.a(new AnonymousClass1(copy, str), "[saveCacheToLocal] mosaic path:" + str);
    }

    public final void uI() {
        if (!(uO() == null || uO().isRecycled())) {
            uO().recycle();
        }
        d(((g) uJ()).xJ());
    }
}
