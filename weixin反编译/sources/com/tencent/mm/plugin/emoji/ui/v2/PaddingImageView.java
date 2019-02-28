package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;

public class PaddingImageView extends FrameLayout {
    ImageView lNZ;
    ImageView lOa;
    private int lOb;

    public PaddingImageView(Context context) {
        super(context);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lOb = a.aa(getContext(), R.f.bvK);
        this.lNZ = new ImageView(context);
        this.lNZ.setPadding(this.lOb, this.lOb, this.lOb, this.lOb);
        this.lOa = new ImageView(context);
    }
}
