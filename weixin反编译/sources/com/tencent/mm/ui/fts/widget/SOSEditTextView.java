package com.tencent.mm.ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;

public class SOSEditTextView extends FTSEditTextView {
    public View znA;

    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void cxQ() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.i.dsX, this, true);
    }

    @SuppressLint({"WrongViewCast"})
    protected final void init() {
        super.init();
        this.znA = findViewById(R.h.cWq);
        this.yqL.setOnFocusChangeListener(null);
    }

    public final void cyb() {
        this.yqL.setOnFocusChangeListener(this.yiW);
    }

    public final void w(Drawable drawable) {
        this.jIs.setImageDrawable(drawable);
    }

    public final void GR(int i) {
        if (this.znA != null) {
            this.znA.setVisibility(i);
        }
    }
}
