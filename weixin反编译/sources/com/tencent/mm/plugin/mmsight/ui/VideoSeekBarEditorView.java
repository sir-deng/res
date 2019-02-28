package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.ui.v;

public class VideoSeekBarEditorView extends LinearLayout {
    Button mpV;
    RecyclerThumbSeekBar oJb;
    Button oJc;
    private LinearLayout oJd;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.oJd = (LinearLayout) v.fw(context).inflate(e.oKH, this, true);
        this.oJb = (RecyclerThumbSeekBar) findViewById(d.oKA);
        this.mpV = (Button) findViewById(d.oKf);
        this.oJc = (Button) findViewById(d.oKg);
    }

    public final void bco() {
        this.oJb.release();
        ViewParent parent = this.oJb.getParent();
        if (parent instanceof LinearLayout) {
            LayoutParams layoutParams = (LayoutParams) this.oJb.getLayoutParams();
            ((LinearLayout) parent).removeView(this.oJb);
            this.oJb = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.oJb, 0, layoutParams);
        }
    }
}
