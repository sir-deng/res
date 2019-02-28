package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.e;

public class MMTagPanelScrollView extends ScrollView {
    private Runnable mBe = new Runnable() {
        public final void run() {
            MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
        }
    };
    private int mBg = 0;
    private a ymJ = new a();
    public int ymK = 2;

    private static class a implements Runnable {
        public MMTagPanel ymM;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            if (this.ymM != null) {
                this.ymM.cqt();
            }
            this.ymM = null;
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof MMTagPanel)) {
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            boolean cqs = mMTagPanel.cqs();
            if (mMTagPanel.ygt.size() == this.ymK) {
                this.mBg = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(e.bvU);
            }
            if (mMTagPanel.ygt.size() >= this.ymK) {
                int size = MeasureSpec.getSize(i);
                x.d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(Math.max(mMTagPanel.EH(this.ymK), this.mBg)));
                setMeasuredDimension(size, r3);
                if (cqs) {
                    this.ymJ.ymM = mMTagPanel;
                    removeCallbacks(this.ymJ);
                    post(this.ymJ);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
    }
}
