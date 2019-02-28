package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h extends Preference {
    boolean kjW = true;
    private View mView = null;
    boolean piL = false;
    boolean piM = false;

    public h(Context context) {
        super(context);
        setLayoutResource(g.uJA);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        int i;
        super.onBindView(view);
        View findViewById = view.findViewById(f.uwQ);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int b = b.b(this.mContext, 10.0f);
        if (this.piL) {
            i = b;
        } else {
            i = 0;
        }
        if (!this.piM) {
            b = 0;
        }
        layoutParams.setMargins(0, i, 0, b);
        findViewById.setLayoutParams(layoutParams);
        if (this.kjW) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }
}
