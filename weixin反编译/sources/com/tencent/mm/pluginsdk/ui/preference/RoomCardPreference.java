package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean fpU = false;
    public CharSequence iZk;
    private LinearLayout jTf;
    private TextView vAL;
    public CharSequence vAM;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.i.doh, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.h.content).findViewById(R.h.cGo);
        if (this.jTf == null) {
            this.jTf = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.vAL == null) {
            this.vAL = (TextView) viewGroup.findViewById(R.h.cIs);
        }
        if (this.fpU) {
            this.jTf.setVisibility(0);
            this.vAL.setVisibility(0);
        } else {
            this.jTf.setVisibility(8);
            this.vAL.setVisibility(8);
        }
        if (this.vAM != null) {
            this.vAL.setText(this.vAM);
        }
    }
}
