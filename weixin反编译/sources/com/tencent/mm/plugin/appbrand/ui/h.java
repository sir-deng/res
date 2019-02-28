package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.statusbar.c;

public final class h extends LinearLayout implements com.tencent.mm.ui.statusbar.c.a {
    private final a[] jSL = new a[4];
    private final SparseArray<b> jSM = new SparseArray();
    private final SparseArray<b> jSN = new SparseArray();
    private int jSO;
    public final String mAppId;

    private class a extends TextView {
        public a(Context context) {
            super(context);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), 5);
            layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(-7171438);
        }
    }

    private class b extends TextView {
        private String mTitle;
        private String mValue;

        static /* synthetic */ void a(b bVar, String str) {
            bVar.mValue = str;
            bVar.update();
        }

        static /* synthetic */ void b(b bVar, String str) {
            bVar.mTitle = str;
            bVar.update();
        }

        public b(Context context) {
            super(context);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(-419430401);
        }

        private void update() {
            setText(String.format("%s: %s", new Object[]{this.mTitle, this.mValue}));
        }
    }

    static /* synthetic */ void a(h hVar, int i, String str) {
        Integer num = (Integer) com.tencent.mm.plugin.appbrand.performance.b.jLE.get(i);
        if (num == null) {
            x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", Integer.valueOf(i));
            return;
        }
        String string = hVar.getContext().getString(num.intValue());
        b bVar = (b) hVar.jSN.get(i);
        if (bVar == null) {
            bVar = new b(hVar.getContext());
            b.b(bVar, string);
            int i2 = (i / 100) - 1;
            if (i2 >= 4) {
                x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
                bVar = null;
            } else {
                if (i2 == 3) {
                    hVar.addView(bVar);
                } else {
                    hVar.addView(bVar, hVar.indexOfChild(hVar.jSL[i2 + 1]));
                }
                hVar.jSN.put(i, bVar);
            }
        }
        if (bVar == null) {
            x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
        } else {
            b.a(bVar, str);
        }
    }

    static /* synthetic */ void a(h hVar, String str, String str2) {
        b bVar = (b) hVar.jSM.get(str.hashCode());
        if (bVar == null) {
            bVar = new b(hVar.getContext());
            b.b(bVar, str);
            hVar.addView(bVar);
            hVar.jSM.put(str.hashCode(), bVar);
        }
        b.a(bVar, str2);
    }

    public h(Context context, String str) {
        super(context);
        this.mAppId = str;
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.bu.a.fromDPToPix(getContext(), 4);
        LayoutParams layoutParams = new FrameLayout.LayoutParams((i * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        alA();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 2);
        View textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(j.iDd));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.bu.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        alB();
        c.ac((Activity) getContext()).a(this);
    }

    private void alA() {
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.a.cj(getContext()) + this.jSO;
            requestLayout();
        }
    }

    private void alB() {
        for (int i = 0; i < 4; i++) {
            View aVar = new a(getContext());
            aVar.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.b.jLD[i]));
            this.jSL[i] = aVar;
            addView(aVar);
        }
    }

    public final void T(final int i, final String str) {
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new Runnable() {
            public final void run() {
                h.a(h.this, i, str);
            }
        });
    }

    public final void bJ(final String str, final String str2) {
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new Runnable() {
            public final void run() {
                h.a(h.this, str, str2);
            }
        });
    }

    public final void lS(int i) {
        this.jSO = i;
        alA();
    }
}
