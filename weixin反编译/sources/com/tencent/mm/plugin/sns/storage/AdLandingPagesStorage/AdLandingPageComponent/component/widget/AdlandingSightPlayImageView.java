package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView extends QPictureView {
    private int qAF;
    private int qAG;
    private int qAH;
    private int qAI;
    public com.tencent.mm.pluginsdk.ui.tools.f.a qAJ;
    public boolean qAK;
    private boolean qAL;
    private boolean qAM;
    a rsu;

    private static final class a extends a {
        private WeakReference<AdlandingSightPlayImageView> qAE;

        protected final int btt() {
            return com.tencent.mm.plugin.sns.i.a.bqx;
        }

        public a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
            super(0, adlandingSightPlayImageView);
            this.qAE = new WeakReference(adlandingSightPlayImageView);
        }

        public final void cl(int i, int i2) {
            final AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qAE.get();
            if (adlandingSightPlayImageView == null) {
                x.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
            } else if (!adlandingSightPlayImageView.qAM) {
                adlandingSightPlayImageView.qAH = i;
                adlandingSightPlayImageView.qAI = i2;
                if (adlandingSightPlayImageView.qAJ != null) {
                    adlandingSightPlayImageView.qAJ.cl(i, i2);
                }
                if (adlandingSightPlayImageView.qAL) {
                    if (adlandingSightPlayImageView.qAH >= adlandingSightPlayImageView.qAI) {
                        adlandingSightPlayImageView.qAF = com.tencent.mm.bu.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150);
                    } else {
                        adlandingSightPlayImageView.qAF = com.tencent.mm.bu.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85);
                    }
                }
                if (adlandingSightPlayImageView.qAF > 0) {
                    final LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == adlandingSightPlayImageView.qAF && layoutParams.height == (adlandingSightPlayImageView.qAF * i2) / i)) {
                        layoutParams.width = adlandingSightPlayImageView.qAF;
                        layoutParams.height = (adlandingSightPlayImageView.qAF * i2) / i;
                        ah.y(new Runnable() {
                            public final void run() {
                                adlandingSightPlayImageView.setLayoutParams(layoutParams);
                            }
                        });
                        adlandingSightPlayImageView.postInvalidate();
                    }
                    x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(adlandingSightPlayImageView.qAF), Integer.valueOf(i), Integer.valueOf(i2));
            }
        }

        public final void D(Bitmap bitmap) {
            AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qAE.get();
            if (adlandingSightPlayImageView == null) {
                x.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            adlandingSightPlayImageView.setImageBitmap(bitmap);
        }
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qAK = true;
        this.qAL = false;
        this.qAM = false;
        this.rsu = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", new aj().toString());
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Uy() {
        return this.rsu.qzp;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.qAM) {
            int height = bitmap == null ? this.qAG == 0 ? 240 : this.qAG : bitmap.getHeight();
            int width = bitmap == null ? this.qAF == 0 ? 320 : this.qAF : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != ((float) (this.qAF * height)) / ((float) width)) {
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
                if (((float) layoutParams.height) != (((float) this.qAF) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                    layoutParams.width = this.qAF;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.qAF)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void aA(String str, boolean z) {
        a aVar = this.rsu;
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(aVar.hashCode()), str, aVar.qzp, Boolean.valueOf(z), Integer.valueOf(aVar.qzr), Boolean.valueOf(aVar.qzT), Boolean.valueOf(aVar.qzK));
        if (aVar.qzT) {
            aVar.ie(false);
        } else if (aVar.btv()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            aVar.clear();
        } else if (!aVar.qzK) {
            aVar.clear();
        } else if (z) {
            aVar.qzq = str;
            aVar.ie(false);
        } else if (aVar.qzp.equals(str)) {
            aVar.qzq = "ERROR#PATH";
            aVar.ie(false);
            aVar.restart();
        } else {
            aVar.clear();
            if (str == null) {
                str = "";
            }
            aVar.qzp = str;
            if (bi.oN(aVar.qzp)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                aVar.byh();
            } else if (a.JY(aVar.qzp)) {
                aVar.rsd = new h(aVar, (byte) 0);
                o.c(aVar.rsd, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                aVar.clear();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.rsu.clear();
        com.tencent.mm.sdk.b.a.xmy.c(this.rsu.btx());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xmy.b(this.rsu.btx());
    }

    public final void wB(int i) {
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

    public final void a(f fVar) {
        this.rsu.rsm = fVar;
    }

    public final void if(boolean z) {
        a aVar = this.rsu;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (aVar.rsf != null) {
                aVar.rsf.type = 0;
                o.c(aVar.rsf, 0);
            }
            aVar.rsf = null;
        } else if (aVar.rsf == null) {
            aVar.rsf = new i(aVar, (byte) 0);
        }
    }

    public int getDuration() {
        if (this.rsu == null) {
            return 0;
        }
        a aVar = this.rsu;
        return (int) (aVar.qzr == -1 ? 0.0d : SightVideoJNI.getVideoDuration(aVar.qzr));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
