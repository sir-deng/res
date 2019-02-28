package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a extends j implements com.tencent.mm.ac.d.a {

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.j.a prd;

        public static com.tencent.mm.pluginsdk.ui.j.a caI() {
            Assert.assertTrue(prd != null);
            return prd;
        }

        public static void a(ImageView imageView, String str) {
            if (imageView == null) {
                x.e("MicroMsg.AvatarDrawable", "imageView is null");
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.qR(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void o(ImageView imageView, String str) {
            a(imageView, str, 0.5f, false);
        }

        public static void p(ImageView imageView, String str) {
            a(imageView, str, 0.5f, true);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, f);
                drawable.la(z);
            } else {
                drawable = (b) drawable;
            }
            drawable.qR(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void b(ImageView imageView, String str, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, (short) 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.qR(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void a(a aVar, String str) {
            Drawable drawable = aVar.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.qR(str);
            aVar.setImageDrawable(drawable);
            aVar.doInvalidate();
        }

        public static void g(ImageView imageView, String str, int i) {
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof c)) {
                    drawable = new c(str);
                } else {
                    drawable = (c) drawable;
                }
                if (drawable.vpV != i || drawable.vpU == null || drawable.vpU.kNe == null || drawable.vpU.kNe.isRecycled()) {
                    drawable.vpV = i;
                    Bitmap Ds = d.Ds(i);
                    if (drawable.vpU != null) {
                        drawable.vpU.kNe = Ds;
                    }
                }
                drawable.qR(str);
                imageView.setImageDrawable(drawable);
                imageView.invalidate();
            }
        }
    }

    /* synthetic */ a(String str, char c) {
        this(str);
    }

    /* synthetic */ a(String str, short s) {
        this(str, (byte) 0);
    }

    private a(String str) {
        super(b.prd, str);
    }

    private a(String str, byte b) {
        super(b.prd, str, false);
    }

    public final void jk(String str) {
        super.jk(str);
    }
}
