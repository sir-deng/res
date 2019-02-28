package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.bu.a;

public final class e {
    Bitmap bitmap = null;
    int jyc = -1;

    public final void e(ImageView imageView) {
        if (imageView != null) {
            if (this.jyc != -1) {
                imageView.setImageDrawable(a.b(imageView.getContext(), this.jyc));
            }
            if (this.bitmap != null) {
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }
}
