package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.ca.a.j;

public class MMAutoAdjustTextView extends TextView {
    private float gPL;
    private float gVS;
    private Paint nx;
    private float zCe;
    private boolean zCf = true;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, j.faT));
        init();
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context.obtainStyledAttributes(attributeSet, j.faT));
        init();
    }

    private void init() {
        this.zCe = (float) a.aa(getContext(), c.bvX);
        this.gVS = getTextSize();
        this.gPL = a.ev(getContext());
        this.nx = new Paint();
        this.nx.set(getPaint());
    }

    private void b(TypedArray typedArray) {
        if (typedArray != null) {
            this.zCf = typedArray.getBoolean(j.zJF, true);
            typedArray.recycle();
        }
    }

    private void Hp(int i) {
        if (i > 0) {
            measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            int measuredWidth = getMeasuredWidth();
            while (((float) measuredWidth) > ((float) i)) {
                this.gVS -= a.getDensity(getContext());
                setTextSize(0, this.gVS * this.gPL);
                measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                measuredWidth = getMeasuredWidth();
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        Hp(getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            Hp(i);
        }
    }
}
