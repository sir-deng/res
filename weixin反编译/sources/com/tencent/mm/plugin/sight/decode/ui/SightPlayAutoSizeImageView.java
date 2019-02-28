package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView extends ImageView implements com.tencent.mm.plugin.sight.decode.a.a {
    private b qAD;

    private static final class a extends b {
        private WeakReference<SightPlayAutoSizeImageView> qAE;

        protected final int btt() {
            return R.a.bqx;
        }

        public a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            this.qAE = new WeakReference(sightPlayAutoSizeImageView);
        }

        public final void cl(int i, int i2) {
        }

        public final void D(Bitmap bitmap) {
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.qAE.get();
            if (sightPlayAutoSizeImageView == null) {
                x.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qAD = new a(this);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
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
        x.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qAD.clear();
        com.tencent.mm.sdk.b.a.xmy.c(this.qAD.btx());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xmy.b(this.qAD.btx());
    }

    public final void wB(int i) {
    }

    public final void B(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void btn() {
        setImageBitmap(null);
        setImageResource(R.g.bEj);
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
        this.qAD.qzT = false;
    }

    public final void a(f fVar) {
        this.qAD.qzW = fVar;
    }
}
