package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.c.k;
import com.google.android.gms.c.l;
import com.google.android.gms.common.internal.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public abstract class a {
    final a aMS;
    protected int aMT;
    protected int aMU;

    static final class a {
        public final Uri uri;

        public a(Uri uri) {
            this.uri = uri;
        }

        public final boolean equals(Object obj) {
            return !(obj instanceof a) ? false : this == obj ? true : v.b(((a) obj).uri, this.uri);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.uri});
        }
    }

    public static final class b extends a {
        private WeakReference<com.google.android.gms.common.images.ImageManager.a> aMV;

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            com.google.android.gms.common.images.ImageManager.a aVar = (com.google.android.gms.common.images.ImageManager.a) this.aMV.get();
            com.google.android.gms.common.images.ImageManager.a aVar2 = (com.google.android.gms.common.images.ImageManager.a) bVar.aMV.get();
            return aVar2 != null && aVar != null && v.b(aVar2, aVar) && v.b(bVar.aMS, this.aMS);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.aMS});
        }

        protected final void oE() {
            this.aMV.get();
        }
    }

    final void a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("null reference");
        }
        if ((this.aMU & 1) != 0) {
            bitmap = k.c(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        oE();
    }

    final void a(Context context, l lVar) {
        if (this.aMT != 0) {
            int i = this.aMT;
            Resources resources = context.getResources();
            if (this.aMU > 0) {
                com.google.android.gms.c.l.a aVar = new com.google.android.gms.c.l.a(i, this.aMU);
                if (((Drawable) lVar.get(aVar)) == null) {
                    Object drawable = resources.getDrawable(i);
                    if ((this.aMU & 1) != 0) {
                        Bitmap bitmap;
                        if (drawable == null) {
                            bitmap = null;
                        } else if (drawable instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                            bitmap = createBitmap;
                        }
                        drawable = new BitmapDrawable(resources, k.c(bitmap));
                    }
                    lVar.put(aVar, drawable);
                }
            } else {
                resources.getDrawable(i);
            }
        }
        oE();
    }

    protected abstract void oE();
}
