package com.tencent.mm.ap.a;

import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> hEL;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        this.hEL = new WeakReference(imageView);
        this.url = str;
    }

    public final ImageView Jx() {
        if (this.hEL != null) {
            ImageView imageView = (ImageView) this.hEL.get();
            if (imageView != null) {
                return imageView;
            }
        }
        return null;
    }

    public final int PO() {
        Object obj = null;
        if (this.hEL != null) {
            obj = (View) this.hEL.get();
        }
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
