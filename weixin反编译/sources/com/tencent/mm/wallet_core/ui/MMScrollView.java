package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    public a zSc;

    public interface a {
        void jQ(boolean z);
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
    }

    public void onFocusChange(final View view, boolean z) {
        x.d("MicroMsg.MMScrollView", "onFocusChange:" + z);
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    MMScrollView.this.scrollTo(0, view.getTop() - com.tencent.mm.bu.a.fromDPToPix(MMScrollView.this.getContext(), 10));
                }
            }, 200);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(this.zSc == null || i2 == i4)) {
            this.zSc.jQ(i2 < i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
