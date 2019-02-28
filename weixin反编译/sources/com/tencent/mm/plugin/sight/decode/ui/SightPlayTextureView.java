package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private Surface mSurface;
    private com.tencent.mm.plugin.sight.decode.a.b qAD;
    private int qAF;
    private boolean qAL;
    private int qAQ;
    private int videoHeight;
    private int videoWidth;

    private static final class a implements Runnable {
        Surface qAS;

        private a() {
            this.qAS = null;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            if (this.qAS != null) {
                this.qAS.release();
            }
        }
    }

    private static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> qAT;

        protected final int btt() {
            return R.a.bqx;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            this.qAT = new WeakReference(sightPlayTextureView);
        }

        public final void cl(int i, int i2) {
            if (this.qAT.get() == null) {
                x.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                return;
            }
            ((SightPlayTextureView) this.qAT.get()).videoWidth = i;
            ((SightPlayTextureView) this.qAT.get()).videoHeight = i2;
            x.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.qAT.get()).qAL));
            final LayoutParams layoutParams = ((SightPlayTextureView) this.qAT.get()).getLayoutParams();
            if (((SightPlayTextureView) this.qAT.get()).qAL && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.qAT.get()).qAF = com.tencent.mm.bu.a.fromDPToPix(((SightPlayTextureView) this.qAT.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.qAT.get()).qAF = com.tencent.mm.bu.a.fromDPToPix(((SightPlayTextureView) this.qAT.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.qAT.get()).qAF * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.qAT.get()).qAF;
                layoutParams.height = (((SightPlayTextureView) this.qAT.get()).qAF * i2) / i;
                if (((SightPlayTextureView) this.qAT.get()).qAL && layoutParams.height < com.tencent.mm.bu.a.fromDPToPix(((SightPlayTextureView) this.qAT.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bu.a.fromDPToPix(((SightPlayTextureView) this.qAT.get()).getContext(), 50);
                }
                x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                if (ah.isMainThread()) {
                    ((SightPlayTextureView) this.qAT.get()).setLayoutParams(layoutParams);
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            ((SightPlayTextureView) b.this.qAT.get()).setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            this.qzu = com.tencent.mm.plugin.sight.decode.a.b.b(((SightPlayTextureView) this.qAT.get()).getContext(), ((SightPlayTextureView) this.qAT.get()).qAQ, ((SightPlayTextureView) this.qAT.get()).qAF, i, i2);
        }

        public final void D(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qAL = false;
        setOpaque(false);
        this.qAD = new b(this);
        setSurfaceTextureListener(new SurfaceTextureListener() {
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                x.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
                SightPlayTextureView.this.qAD.d(null);
                SightPlayTextureView.this.qAD.clear();
                Runnable aVar = new a();
                aVar.qAS = SightPlayTextureView.this.mSurface;
                o.c(aVar, 0);
                SightPlayTextureView.this.mSurface = null;
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", Integer.valueOf(i), Integer.valueOf(i2));
                Runnable aVar = new a();
                aVar.qAS = SightPlayTextureView.this.mSurface;
                o.c(aVar, 0);
                SightPlayTextureView.this.mSurface = new Surface(surfaceTexture);
                SightPlayTextureView.this.qAD.d(SightPlayTextureView.this.mSurface);
                SightPlayTextureView.this.cqy();
            }
        });
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Uy() {
        return this.qAD.qzp;
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
        x.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qAD.clear();
        com.tencent.mm.sdk.b.a.xmy.c(this.qAD.btx());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xmy.b(this.qAD.btx());
    }

    public final void wB(int i) {
        this.qAF = i;
        p(0.75d);
    }

    private void p(double d) {
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.qAF) * d))) {
            layoutParams.width = this.qAF;
            layoutParams.height = (int) (((double) this.qAF) * d);
            if (this.qAL && layoutParams.height < com.tencent.mm.bu.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bu.a.fromDPToPix(getContext(), 50);
            }
            x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if (ah.isMainThread()) {
                setLayoutParams(layoutParams);
            } else {
                ah.y(new Runnable() {
                    public final void run() {
                        SightPlayTextureView.this.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public final void B(Bitmap bitmap) {
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        x.d(str, str2, objArr);
        if (bitmap != null) {
            x.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (this.qAL) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.qAF = com.tencent.mm.bu.a.fromDPToPix(getContext(), 150);
                } else {
                    this.qAF = com.tencent.mm.bu.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap b = com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.qAQ, this.qAF, bitmap.getWidth(), bitmap.getHeight());
            p(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.qAD.qzu = b;
            this.qAD.C(bitmap);
            return;
        }
        this.qAD.C(null);
    }

    public final void btn() {
        SightVideoJNI.drawSurfaceThumb(this.mSurface, com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), R.g.bEj, this.qAF, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.qAQ, this.qAF, 320, 240));
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

    public final void dx(int i, int i2) {
        final LayoutParams layoutParams = getLayoutParams();
        this.qAF = i;
        layoutParams.width = this.qAF;
        layoutParams.height = (this.qAF * i2) / i;
        x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (ah.isMainThread()) {
            setLayoutParams(layoutParams);
        } else {
            ah.y(new Runnable() {
                public final void run() {
                    SightPlayTextureView.this.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public final void id(boolean z) {
        this.qAD.qzK = z;
    }

    public final void a(e eVar) {
        this.qAD.qzV = eVar;
    }

    public final void bts() {
    }

    public final void h(TextView textView) {
        this.qAD.h(textView);
    }

    public final void btr() {
    }

    public final void a(f fVar) {
        this.qAD.qzW = fVar;
    }
}
