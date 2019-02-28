package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.v.a.d;

public class MMImageButton extends FrameLayout {
    private ImageView fzb;
    private TextView pli;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.fzb = new ImageView(context);
        this.fzb.setLayoutParams(layoutParams);
        addView(this.fzb);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.pli = new TextView(context);
        this.pli.setLayoutParams(layoutParams);
        this.pli.setClickable(false);
        this.pli.setFocusable(false);
        this.pli.setFocusableInTouchMode(false);
        this.pli.setTextColor(a.Z(context, d.gWm));
        addView(this.pli);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.pli.setEnabled(z);
        this.fzb.setEnabled(z);
    }
}
