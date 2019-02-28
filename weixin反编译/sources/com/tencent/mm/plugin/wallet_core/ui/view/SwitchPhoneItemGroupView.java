package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> tdI = new ArrayList();
    public a tdJ;
    private OnClickListener tdK = new OnClickListener() {
        public final void onClick(View view) {
            for (SwitchPhoneItemView switchPhoneItemView : SwitchPhoneItemGroupView.this.tdI) {
                switchPhoneItemView.tdO.setImageResource(h.dAB);
            }
            ((SwitchPhoneItemView) view).tdO.setImageResource(h.dAC);
            if (SwitchPhoneItemGroupView.this.tdJ != null) {
                SwitchPhoneItemGroupView.this.tdJ.cT(view);
            }
        }
    };

    public interface a {
        void cT(View view);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        addView(switchPhoneItemView, i);
        this.tdI.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.tdK);
    }
}
