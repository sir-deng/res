package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.v.a.h;

public class SwitchKeyValuePreference extends Preference {
    public boolean frK;
    private TextView ppv;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.frK = true;
        setLayoutResource(h.dnz);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ppv = (TextView) view.findViewById(16908304);
        av();
    }

    public final void av() {
        if (this.ppv != null) {
            if (this.frK) {
                this.ppv.setTextColor(r.gc(this.mContext));
            } else {
                this.ppv.setTextColor(r.gd(this.mContext));
            }
        }
    }
}
