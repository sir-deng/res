package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;

public final class a extends d {
    private static final int jdI = g.iwV;

    public static a ce(View view) {
        return (a) view.getRootView().findViewById(jdI);
    }

    public a(Context context) {
        super(context);
        super.setId(jdI);
        setBackgroundResource(d.bsK);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.hide();
            }
        });
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                ca(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setId(int i) {
    }

    public final void show() {
        super.show();
    }

    public final void hide() {
        super.hide();
    }
}
