package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bu.a;
import com.tencent.smtt.sdk.WebView;

public class c extends YANumberPicker implements e<String> {
    private String[] kiV;
    private int kiX;

    public final /* synthetic */ Object aoq() {
        return (this.kiV == null || this.kiV.length <= 0) ? "" : this.kiV[getValue()];
    }

    public c(Context context) {
        super(context);
        setDividerHeight(a.fromDPToPix(context, 2));
        int parseColor = Color.parseColor("#1AAD19");
        if (this.kjx != parseColor) {
            this.kjx = parseColor;
            this.kkd.setColor(this.kjx);
            postInvalidate();
        }
        parseColor = a.fromDPToPix(context, 8);
        if (this.kjv != parseColor) {
            this.kjv = parseColor;
            postInvalidate();
        }
        parseColor = Color.parseColor("#A5A5A5");
        if (this.kjl != parseColor) {
            this.kjl = parseColor;
            postInvalidate();
        }
        if (this.kjm != WebView.NIGHT_MODE_COLOR) {
            this.kjm = WebView.NIGHT_MODE_COLOR;
            postInvalidate();
        }
    }

    public final void j(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.kiV = strArr;
        int i = this.kjF;
        int length = strArr.length - 1;
        if ((length - i) + 1 > (this.kjG - i) + 1) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.kiX > 0) {
            i = MeasureSpec.makeMeasureSpec(this.kiX, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aoo() {
        aoC();
    }

    public final void b(d dVar) {
    }

    public final void aop() {
    }
}
