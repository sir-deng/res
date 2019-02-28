package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private TextView jOY;
    private String mTitle;
    private TextView pnx;
    private String pny;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnK, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.jOY = (TextView) view.findViewById(R.h.title);
        this.pnx = (TextView) view.findViewById(R.h.cwy);
        if (this.jOY != null) {
            this.jOY.setText(this.mTitle);
        }
        if (this.pnx != null) {
            this.pnx.setText(this.pny);
        }
        super.onBindView(view);
    }
}
