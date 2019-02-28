package com.tencent.mm.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.api.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    private float gPA;
    private Rect gPk;
    public String gPn;
    private i gPo;
    public Bitmap gPp;
    public PointF gPq;
    public int gPr = 0;
    private float gPs = 1.0f;
    public boolean gPt;
    public PointF gPu;
    private float gPv;
    private float gPw;
    public boolean gPx = false;
    public List<PointF> gPy = new ArrayList();
    public float gPz;
    public float gr = 1.0f;
    protected Context mContext;
    private Matrix mMatrix;

    private class a {
        public float[] gPB = new float[this.gPD];
        public float[] gPC = new float[this.gPD];
        public int gPD;

        public a(List<PointF> list) {
            this.gPD = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gPD) {
                    this.gPB[i2] = ((PointF) list.get(i2)).x;
                    this.gPC[i2] = ((PointF) list.get(i2)).y;
                    i = i2 + 1;
                } else {
                    new StringBuilder("lasso size:").append(this.gPD);
                    return;
                }
            }
        }
    }

    public /* synthetic */ Object clone() {
        return BT();
    }

    public c(Context context, Matrix matrix, String str, i iVar, Rect rect) {
        this.gPn = str;
        this.mMatrix = matrix;
        this.gPo = iVar;
        this.mContext = context;
        this.gPk = rect;
        this.gPq = new PointF();
        this.gPu = new PointF();
    }

    public c(Context context, Matrix matrix, String str, Rect rect) {
        this.gPn = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.gPk = rect;
        this.gPq = new PointF();
        this.gPu = new PointF();
    }

    public final void a(float f, float f2, float f3, int i) {
        this.gPp = e(BR());
        this.gPv = (1.2f * ((float) this.gPk.width())) / ((float) this.gPp.getWidth());
        this.gPw = (0.1f * ((float) this.gPk.width())) / ((float) this.gPp.getWidth());
        this.gPs = f3;
        this.gPr = i;
        this.gr *= f3;
        x.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", Float.valueOf(this.gPv), Float.valueOf(this.gPw), Float.valueOf(this.gPs));
        this.gPq.set(f, f2);
        x.d("MicroMsg.EmojiItem", "[setPoint] point:%s", this.gPq);
        BS();
    }

    public final boolean BO() {
        x.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.gPp != null && !this.gPp.isRecycled()) {
            return false;
        }
        this.gPp = e(BR());
        return true;
    }

    public void setSelected(boolean z) {
        this.gPt = z;
    }

    public final void b(float f, float f2, float f3, int i) {
        this.gPq.offset(f, f2);
        if (0.0f != f3) {
            this.gr = f3;
        }
        this.gPr = i;
    }

    public final void clear() {
        x.i("MicroMsg.EmojiItem", "[clear]");
        if (this.gPp != null && !this.gPp.isRecycled()) {
            this.gPp.recycle();
            this.gPp = null;
        }
    }

    public final void draw(Canvas canvas) {
        if (this.gPp == null || this.gPp.isRecycled()) {
            x.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.gPv < this.gr * this.gPs) {
            this.gr = this.gPv / this.gPs;
        } else if (this.gPw > this.gr * this.gPs) {
            this.gr = this.gPw / this.gPs;
        }
        canvas.save();
        canvas.translate(this.gPq.x, this.gPq.y);
        canvas.rotate((float) this.gPr);
        canvas.scale(this.gr, this.gr);
        if (this.gPt) {
            canvas.drawBitmap(this.gPp, (float) ((-BP()) / 2), (float) ((-BQ()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-BP()) / 2)) + 40.0f, ((float) ((-BQ()) / 2)) + 40.0f, ((float) (this.gPp.getWidth() / 2)) - 40.0f, ((float) (this.gPp.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.gPp, (float) ((-BP()) / 2), (float) ((-BQ()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
    }

    private int BP() {
        if (this.gPp != null) {
            return this.gPp.getWidth();
        }
        return 0;
    }

    private int BQ() {
        if (this.gPp != null) {
            return this.gPp.getHeight();
        }
        return 0;
    }

    protected Bitmap BR() {
        if (this.gPp == null || this.gPp.isRecycled()) {
            this.gPp = this.gPo.aj(this.mContext);
        }
        if (this.gPp == null) {
            x.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            d dVar = new d();
            this.gPp = d.createBitmap(120, 120, Config.ARGB_4444);
            new Canvas(this.gPp).drawColor(-7829368);
        }
        return this.gPp;
    }

    private Bitmap e(Bitmap bitmap) {
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), com.tencent.mm.bi.a.d.vhW), BitmapFactory.decodeResource(this.mContext.getResources(), com.tencent.mm.bi.a.d.vhW).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        return createBitmap;
    }

    public final void BS() {
        double BP = (double) ((((float) BP()) * 1.0f) / 2.0f);
        double BQ = (double) ((((float) BQ()) * 1.0f) / 2.0f);
        this.gPA = (float) Math.sqrt((BP * BP) + (BQ * BQ));
        this.gPA *= this.gr / this.gPs;
        this.gPz = (float) Math.toDegrees(Math.atan(BQ / BP));
    }

    public PointF N(float f) {
        PointF pointF = new PointF();
        double d = (((double) (((float) this.gPr) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.gPq.x + ((float) (((double) this.gPA) * Math.cos(d)));
        pointF.y = this.gPq.y + ((float) (Math.sin(d) * ((double) this.gPA)));
        return pointF;
    }

    public final c BT() {
        c cVar;
        Throwable e;
        try {
            cVar = (c) super.clone();
            try {
                cVar.gPq = new PointF(this.gPq.x, this.gPq.y);
                cVar.gPo = this.gPo;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                return cVar;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            cVar = null;
            e = th;
            x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            return cVar;
        }
        return cVar;
    }
}
