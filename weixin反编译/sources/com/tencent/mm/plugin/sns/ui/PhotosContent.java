package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent extends MMFrameLayout {
    private int jbu = 120;
    public ArrayList<TagImageView> rBE = new ArrayList();
    private float rBF;

    public final void bAH() {
        this.rBE.clear();
    }

    public final void a(TagImageView tagImageView) {
        this.rBE.add(tagImageView);
    }

    public final void xP(int i) {
        if (i > 0) {
            this.rBF = getResources().getDisplayMetrics().density;
            this.jbu = (int) (((float) this.jbu) * this.rBF);
            if (i >= this.jbu) {
                i = this.jbu;
            }
            for (int i2 = 0; i2 < this.rBE.size(); i2++) {
                View childAt = getChildAt(i2);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(childAt.getLayoutParams());
                marginLayoutParams.width = i;
                marginLayoutParams.height = i;
                marginLayoutParams.leftMargin = (int) (((float) (i2 % 3)) * (((float) i) + (this.rBF * 3.0f)));
                marginLayoutParams.topMargin = (int) (((float) (i2 / 3)) * (((float) i) + (this.rBF * 3.0f)));
                LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
                layoutParams.gravity = 51;
                childAt.setLayoutParams(layoutParams);
            }
            int size = this.rBE.size() / 3;
            if (size > 0) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
                marginLayoutParams2.height = (int) ((((float) (size - 1)) * (this.rBF * 3.0f)) + ((float) (i * size)));
                setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public final TagImageView xQ(int i) {
        if (i < this.rBE.size()) {
            return (TagImageView) this.rBE.get(i);
        }
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
