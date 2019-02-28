package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletIconImageView extends ImageView {
    private int lT;
    private int vGd;
    private OnClickListener vGe;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vGd = -1;
        this.lT = 4;
        this.vGe = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        this.vGd = i;
        super.setImageResource(i);
    }

    public void setVisibility(int i) {
        this.lT = i;
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.vGe = onClickListener;
    }

    public final void n(OnClickListener onClickListener) {
        super.setVisibility(0);
        super.setImageResource(e.bDp);
        super.setContentDescription(getContext().getString(i.bWi));
        super.setOnClickListener(onClickListener);
    }

    public final void cdF() {
        super.setVisibility(this.lT);
        super.setImageResource(this.vGd);
        super.setOnClickListener(this.vGe);
    }
}
