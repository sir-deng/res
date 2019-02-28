package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.statusbar.b;

public final class e extends b implements l {
    private final com.tencent.mm.plugin.appbrand.e iuk;
    private final Bitmap jRr;

    static /* synthetic */ void a(e eVar) {
        ProgressBar progressBar = (ProgressBar) eVar.findViewById(g.progress);
        if (progressBar != null && (progressBar.getIndeterminateDrawable() instanceof Animatable)) {
            ((Animatable) progressBar.getIndeterminateDrawable()).stop();
        }
    }

    public e(Context context, com.tencent.mm.plugin.appbrand.e eVar, Bitmap bitmap) {
        super(context);
        this.jRr = bitmap;
        this.iuk = eVar;
        boolean YI = this.iuk.YI();
        Activity ch = j.ch(getContext());
        if (ch != null) {
            Window window = ch.getWindow();
            if (window != null) {
                j.c(window, YI);
            }
        }
        nv(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(h.izJ, this, false);
        addView(inflate, new LayoutParams(-2, -2, 17));
        ((TextView) inflate.findViewById(g.title)).setText(j.iCq);
        inflate.findViewById(g.iyl).setVisibility(8);
    }

    public final void bH(String str, String str2) {
    }

    public final void alg() {
        post(new Runnable() {
            public final void run() {
                final View view = e.this;
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup = (ViewGroup) view.getParent();
                    view.animate().alpha(0.0f).withEndAction(new Runnable() {
                        public final void run() {
                            view.setVisibility(8);
                            viewGroup.removeView(view);
                        }
                    }).withStartAction(new Runnable() {
                        public final void run() {
                            e.a(e.this);
                        }
                    }).start();
                }
            }
        });
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.jRr.recycle();
    }

    public final void alh() {
    }

    public final void a(d dVar) {
    }

    public final View getView() {
        return this;
    }
}
