package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;

public final class t extends LinearLayout {
    private static final int jdI = g.iwI;
    AppBrandNumberKeyboardView jTJ;
    EditText kT;
    private boolean keb = false;
    a kec;

    public interface a {
        void onDone();
    }

    public static t bW(View view) {
        return (t) view.getRootView().findViewById(jdI);
    }

    public static t bX(View view) {
        t bW = bW(view);
        if (bW != null) {
            return bW;
        }
        l bS = l.bS(view);
        if (bS == null) {
            return null;
        }
        bW = new t(view.getContext());
        bS.g(bW, false);
        return bW;
    }

    private t(Context context) {
        super(context);
        super.setId(jdI);
        setOrientation(1);
        setBackgroundResource(d.btq);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(getContext(), 30));
        View relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                t.this.onDone();
                t.this.setVisibility(8);
            }
        });
        relativeLayout.setBackgroundResource(f.ivI);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(f.ivH);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(getContext(), 240));
        relativeLayout = new AppBrandNumberKeyboardView(getContext());
        this.jTJ = relativeLayout;
        addView(relativeLayout, layoutParams);
    }

    private void onDone() {
        if (!this.keb && this.kec != null) {
            this.keb = true;
            this.kec.onDone();
            this.keb = false;
        }
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        if (getVisibility() != i || (getVisibility() != 0 && getVisibility() != 8)) {
            if (i != 0) {
                super.setVisibility(8);
                onDone();
                return;
            }
            super.setVisibility(i);
        }
    }

    public final void setInputEditText(EditText editText) {
        this.kT = editText;
        this.jTJ.setInputEditText(editText);
    }

    final void anx() {
        if (this.kT != null) {
            this.kT.clearFocus();
            this.kT = null;
            this.kec = null;
            this.keb = false;
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(com.tencent.mm.bu.a.fromDPToPix(getContext(), 270), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}
