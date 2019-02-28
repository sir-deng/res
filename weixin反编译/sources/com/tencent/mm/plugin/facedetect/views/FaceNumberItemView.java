package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class FaceNumberItemView extends View {
    static final long msA = 29;
    private boolean msB;
    private Paint msC;
    private RectF msD;
    private Bitmap msE;
    public int msF;
    int msG;
    Runnable msH;
    Timer msz;

    private class a extends TimerTask {
        private WeakReference<Runnable> msJ;

        /* synthetic */ a(FaceNumberItemView faceNumberItemView, Runnable runnable, byte b) {
            this(runnable);
        }

        private a(Runnable runnable) {
            this.msJ = null;
            this.msJ = new WeakReference(runnable);
        }

        public final void run() {
            if (this.msJ == null || this.msJ.get() == null) {
                cancel();
            } else {
                ah.y((Runnable) this.msJ.get());
            }
        }
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.msz = null;
        this.msB = false;
        this.msC = null;
        this.msD = null;
        this.msE = null;
        this.msF = 17;
        this.msG = 0;
        this.msH = new Runnable() {
            public final void run() {
                if (FaceNumberItemView.this.msG <= 30) {
                    FaceNumberItemView.this.msG = FaceNumberItemView.this.msG + 1;
                    FaceNumberItemView.this.invalidate();
                    return;
                }
                FaceNumberItemView.this.aIn();
            }
        };
        setLayerType(1, null);
        this.msC = new Paint();
        this.msC.setColor(context.getResources().getColor(b.mif));
        this.msC.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.msD = new RectF();
    }

    public final void setImageResource(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (i == d.miA) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(c.mij) - com.tencent.mm.bu.a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, null);
            this.msE = createBitmap;
            return;
        }
        this.msE = Bitmap.createScaledBitmap(decodeResource, com.tencent.mm.bu.a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
    }

    public final void aIn() {
        if (this.msz != null) {
            this.msz.cancel();
            this.msz = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        float width;
        float height;
        super.onDraw(canvas);
        if (this.msF == 17) {
            width = (float) ((getWidth() - this.msE.getWidth()) >> 1);
            height = (float) ((getHeight() - this.msE.getHeight()) >> 1);
        } else if (this.msF == 3) {
            height = (float) ((getHeight() - this.msE.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.msF == 5) {
            width = (float) (getWidth() - this.msE.getWidth());
            height = (float) ((getHeight() - this.msE.getHeight()) >> 1);
        } else {
            x.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.msE.getWidth()) >> 1);
            height = (float) ((getHeight() - this.msE.getHeight()) >> 1);
        }
        if (!this.msB) {
            canvas.drawBitmap(this.msE, width, height, null);
        }
        this.msD.set(width, 0.0f, ((((float) this.msE.getWidth()) * ((float) this.msG)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.msD, this.msC);
    }
}
