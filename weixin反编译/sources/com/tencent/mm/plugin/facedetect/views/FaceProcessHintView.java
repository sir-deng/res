package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class FaceProcessHintView extends LinearLayout {
    private h msU;
    private int msV;
    private Animation msW;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.msU = null;
        this.msV = 0;
        this.msW = null;
        setOrientation(0);
        setMinimumHeight(b.b(getContext(), 36.0f));
        this.msW = AnimationUtils.loadAnimation(context, a.mid);
        this.msW.setInterpolator(new AccelerateDecelerateInterpolator());
    }
}
