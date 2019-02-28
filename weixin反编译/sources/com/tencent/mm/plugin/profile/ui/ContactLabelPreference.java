package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private TextView ikn;
    private MMSingelLinePanel pnv;
    private ArrayList<String> pnw;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pnw = new ArrayList();
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnI, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.ikn = (TextView) view.findViewById(R.h.title);
        this.pnv = (MMSingelLinePanel) view.findViewById(R.h.bYm);
        this.pnv.cqk();
        this.pnv.ymf = false;
        this.pnv.mz(false);
        if (this.ikn != null) {
            this.ikn.setText(this.title);
        }
        if (!(this.pnv == null || this.pnw == null || this.pnw.size() <= 0)) {
            this.pnv.a(this.pnw, this.pnw);
        }
        super.onBindView(view);
    }
}
