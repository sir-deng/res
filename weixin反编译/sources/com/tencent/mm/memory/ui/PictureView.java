package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i hcf = null;
    private boolean hcg = false;
    private Runnable hch = new Runnable() {
        public final void run() {
            PictureView.a(PictureView.this);
        }
    };

    static /* synthetic */ void a(PictureView pictureView) {
        aQ(pictureView.hcf);
        pictureView.hcf = null;
        super.setImageDrawable(null);
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static String aP(Object obj) {
        if (obj == null) {
            return "NULL";
        }
        if (obj instanceof a) {
            return obj + " hashcode " + obj.hashCode() + " " + ((a) obj).EO() + " " + ((a) obj).EO().hashCode();
        }
        return String.valueOf(obj);
    }

    public void setImageDrawable(Drawable drawable) {
        removeCallbacks(this.hch);
        if (drawable != null && !drawable.equals(this.hcf)) {
            if (this.DEBUG) {
                x.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + aP(this.hcf) + " new:" + aP(drawable) + " " + bi.chl().toString());
            }
            aQ(this.hcf);
            if (drawable instanceof i) {
                this.hcf = (i) drawable;
            } else {
                this.hcf = null;
            }
            if (drawable != null && (drawable instanceof i)) {
                ((i) drawable).EF();
            }
            super.setImageDrawable(drawable);
        }
    }

    private static void aQ(Object obj) {
        if (obj != null && (obj instanceof i)) {
            ((i) obj).EG();
        }
    }

    private void EP() {
        removeCallbacks(this.hch);
        if (this.DEBUG) {
            x.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bi.chl().toString());
        }
        if (!this.hcg) {
            this.hcg = true;
        }
    }

    private void onDetach() {
        if (this.DEBUG) {
            x.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bi.chl().toString());
        }
        if (this.hcg) {
            this.hcg = false;
            removeCallbacks(this.hch);
            postDelayed(this.hch, 500);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EP();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        EP();
    }
}
