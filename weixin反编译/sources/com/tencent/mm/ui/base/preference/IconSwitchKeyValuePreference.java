package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.v.a.j;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView ppv;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ppv = (TextView) view.findViewById(16908304);
        av();
    }

    public final void Fx(int i) {
        this.status = i;
        av();
    }

    private void av() {
        if (this.ppv != null) {
            int b = b.b(this.mContext, 2.0f);
            this.ppv.setTextColor(r.gd(this.mContext));
            if (this.status == 0) {
                this.ppv.setCompoundDrawablesWithIntrinsicBounds(j.haf, 0, 0, 0);
                this.ppv.setCompoundDrawablePadding(b);
            } else if (this.status == 1) {
                this.ppv.setCompoundDrawablesWithIntrinsicBounds(j.had, 0, 0, 0);
                this.ppv.setCompoundDrawablePadding(b);
            } else if (this.status == 2) {
                this.ppv.setCompoundDrawablesWithIntrinsicBounds(j.hae, 0, 0, 0);
                this.ppv.setCompoundDrawablePadding(b);
            } else {
                this.ppv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }
}
