package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.ah.a.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class SightPlayImageView extends QPictureView implements com.tencent.mm.plugin.sight.decode.a.a {
    public b qAD;
    private int qAF;
    private int qAG;
    private int qAH;
    private int qAI;
    public com.tencent.mm.pluginsdk.ui.tools.f.a qAJ;
    public boolean qAK;
    private boolean qAL;
    public boolean qAM;

    private static final class a extends b {
        private WeakReference<SightPlayImageView> qAE;

        protected final int btt() {
            return com.tencent.mm.plugin.ah.a.a.bqx;
        }

        public a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            this.qAE = new WeakReference(sightPlayImageView);
        }

        public final void cl(int i, int i2) {
            final SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qAE.get();
            if (sightPlayImageView == null) {
                x.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
            } else if (!sightPlayImageView.qAM) {
                sightPlayImageView.qAH = i;
                sightPlayImageView.qAI = i2;
                if (sightPlayImageView.qAJ != null) {
                    sightPlayImageView.qAJ.cl(i, i2);
                }
                if (sightPlayImageView.qAL) {
                    if (sightPlayImageView.qAH >= sightPlayImageView.qAI) {
                        sightPlayImageView.qAF = com.tencent.mm.bu.a.fromDPToPix(sightPlayImageView.getContext(), 150);
                    } else {
                        sightPlayImageView.qAF = com.tencent.mm.bu.a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.qAF > 0) {
                    final LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.qAF && layoutParams.height == (sightPlayImageView.qAF * i2) / i)) {
                        layoutParams.width = sightPlayImageView.qAF;
                        layoutParams.height = (sightPlayImageView.qAF * i2) / i;
                        ah.y(new Runnable() {
                            public final void run() {
                                sightPlayImageView.setLayoutParams(layoutParams);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.qAF), Integer.valueOf(i), Integer.valueOf(i2));
            }
        }

        public final void D(Bitmap bitmap) {
            SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qAE.get();
            if (sightPlayImageView == null) {
                x.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
        }
    }

    public final void btL() {
        this.qAM = true;
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qAK = true;
        this.qAL = false;
        this.qAM = false;
        this.qAD = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", new aj().toString());
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public final String Uy() {
        return this.qAD.qzp;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.qAM) {
            int height = bitmap == null ? this.qAG == 0 ? 240 : this.qAG : bitmap.getHeight();
            int width = bitmap == null ? this.qAF == 0 ? 320 : this.qAF : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height != ((int) (((float) (this.qAF * height)) / ((float) width)))) {
                layoutParams.width = this.qAF;
                layoutParams.height = (int) ((((float) height) * ((float) this.qAF)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.qAM) {
            int intrinsicHeight = drawable == null ? this.qAG == 0 ? 240 : this.qAG : drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable == null ? this.qAF == 0 ? 320 : this.qAF : drawable.getIntrinsicWidth();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (layoutParams.height != ((int) ((((float) this.qAF) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)))) {
                    layoutParams.width = this.qAF;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.qAF)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void E(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public final void clear() {
        this.qAD.clear();
    }

    public final void aA(String str, boolean z) {
        this.qAD.aA(str, z);
    }

    public final boolean btq() {
        return this.qAD.btv();
    }

    public final void cR(int i) {
        this.qAD.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qAD.clear();
        com.tencent.mm.sdk.b.a.xmy.c(this.qAD.btx());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xmy.b(this.qAD.btx());
    }

    public void wB(int i) {
        this.qAK = false;
        this.qAF = i;
        if (this.qAH > 0 && this.qAI > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.qAG = (this.qAF * this.qAI) / this.qAH;
            if (layoutParams.width != this.qAF || layoutParams.height != this.qAG) {
                layoutParams.width = this.qAF;
                layoutParams.height = this.qAG;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void B(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void btn() {
        setImageBitmap(null);
        setImageResource(d.bEj);
    }

    public final void bI(Object obj) {
        setTag(obj);
    }

    public final Object bto() {
        return getTag();
    }

    public final Context btp() {
        return getContext();
    }

    public void dx(int i, int i2) {
        this.qAK = false;
        LayoutParams layoutParams = getLayoutParams();
        this.qAF = i;
        this.qAG = (this.qAF * i2) / i;
        layoutParams.width = this.qAF;
        layoutParams.height = this.qAG;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public final void id(boolean z) {
        this.qAD.qzK = z;
    }

    public final void a(e eVar) {
        this.qAD.qzV = eVar;
    }

    public final void bts() {
        this.qAD.qzX = null;
    }

    public final void a(f fVar) {
        this.qAD.qzW = fVar;
    }

    public final void h(TextView textView) {
        this.qAD.h(textView);
    }

    public final void if(boolean z) {
        b bVar = this.qAD;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.qzE != null) {
                bVar.qzE.type = 0;
                o.c(bVar.qzE, 0);
            }
            bVar.qzE = null;
        } else if (bVar.qzE == null) {
            bVar.qzE = new i(bVar, (byte) 0);
        }
    }

    public final void btr() {
    }

    public int getDuration() {
        if (this.qAD == null) {
            return 0;
        }
        return (int) this.qAD.bty();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
