package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.j;

public final class b extends j implements com.tencent.mm.ac.d.a {

    public static class a {
        static com.tencent.mm.pluginsdk.ui.j.a prd;

        public static void a(ImageView imageView, String str) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, (byte) 0);
            } else {
                drawable = (b) drawable;
            }
            drawable.qR(str);
            imageView.setImageDrawable(drawable);
        }
    }

    /* synthetic */ b(String str, byte b) {
        this(str);
    }

    private b(String str) {
        super(a.prd, str);
    }

    public final void jk(String str) {
        super.jk(str);
    }
}
