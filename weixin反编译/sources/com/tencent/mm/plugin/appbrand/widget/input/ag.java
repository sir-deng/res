package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.platformtools.ad;

final class ag extends com.tencent.mm.plugin.appbrand.widget.input.panel.c {
    private static final int kfB = ad.getContext().getResources().getDimensionPixelSize(e.bvL);
    private com.tencent.mm.bw.e kfA = null;

    private static final class a extends com.tencent.mm.bw.e {
        private String[] kfC;

        a() {
            super(new c(ad.getContext()));
            this.kfC = null;
            this.kfC = ad.getContext().getResources().getStringArray(com.tencent.mm.plugin.appbrand.q.b.iuR);
        }

        public final int anS() {
            return 0;
        }

        public final int anT() {
            return this.kfC != null ? this.kfC.length : 0;
        }

        public final Drawable mx(int i) {
            return new b(my(i), ag.kfB, (byte) 0);
        }

        public final String my(int i) {
            if (this.kfC == null || i < 0 || i > this.kfC.length - 1) {
                return "";
            }
            String[] split = this.kfC[i].split(" ");
            char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
            return toChars + Character.toChars(Integer.decode(split[1]).intValue());
        }

        public final String getText(int i) {
            return my(i);
        }

        public final String mz(int i) {
            return my(i);
        }
    }

    private static final class b extends Drawable {
        private final int hX;
        private final String kav;
        private final TextPaint kfD;
        private Rect kfE;

        /* synthetic */ b(String str, int i, byte b) {
            this(str, i);
        }

        private b(String str, int i) {
            this.kav = str;
            this.hX = i;
            this.kfD = new TextPaint();
            this.kfD.setAntiAlias(true);
            this.kfD.setTextAlign(Align.CENTER);
            this.kfD.setTextSize((float) this.hX);
            this.kfE = new Rect();
            this.kfD.getTextBounds(this.kav, 0, this.kav.length(), this.kfE);
        }

        public final int getIntrinsicWidth() {
            return this.kfE.width();
        }

        public final int getIntrinsicHeight() {
            return this.kfE.height();
        }

        public final void draw(Canvas canvas) {
            canvas.drawText(this.kav, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.kfD.descent() + this.kfD.ascent()) / 2.0f), this.kfD);
        }

        public final void setAlpha(int i) {
            this.kfD.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.kfD.setColorFilter(colorFilter);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    private static final class c extends ContextWrapper {
        private Resources mResources;

        public c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            if (this.mResources != null && (this.mResources instanceof d)) {
                return this.mResources;
            }
            Resources resources = super.getResources();
            this.mResources = new d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
            return this.mResources;
        }
    }

    private static final class d extends Resources {
        d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        public final String[] getStringArray(int i) {
            if (com.tencent.mm.plugin.appbrand.q.b.bqU == i) {
                return new String[0];
            }
            if (com.tencent.mm.plugin.appbrand.q.b.bqV == i) {
                return new String[0];
            }
            return super.getStringArray(i);
        }
    }

    ag() {
    }

    protected final com.tencent.mm.bw.e anR() {
        if (this.kfA == null) {
            this.kfA = new a();
        }
        return this.kfA;
    }
}
