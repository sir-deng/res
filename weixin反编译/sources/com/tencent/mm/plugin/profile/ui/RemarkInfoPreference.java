package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity fnF;
    private TextView ikn;
    private ImageView jTd;
    private String now;
    private TextView ppv;
    private boolean pqG = false;
    private String title;

    public final /* synthetic */ CharSequence getSummary() {
        return this.ppv.getText().toString();
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
        setWidgetLayoutResource(R.i.doj);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnR, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ikn = (TextView) view.findViewById(R.h.title);
        this.ppv = (TextView) view.findViewById(R.h.summary);
        this.jTd = (ImageView) view.findViewById(R.h.cpm);
        if (this.pqG) {
            this.jTd.setVisibility(0);
        } else {
            this.jTd.setVisibility(8);
        }
        if (this.ikn != null) {
            this.ikn.setText(this.title);
        }
        if (this.ppv != null) {
            this.ppv.setText(this.now);
        }
        super.onBindView(view);
    }
}
