package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView ikn;
    private boolean lXm;
    private String title;
    private String zbi;
    private TextView zbj;
    private TextView zbk;
    private TextView zbl;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.lXm = false;
        this.title = "";
        this.zbi = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnE, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ikn = (TextView) view.findViewById(R.h.title);
        this.zbj = (TextView) view.findViewById(R.h.cig);
        this.zbk = (TextView) view.findViewById(R.h.cKo);
        this.zbl = (TextView) view.findViewById(R.h.cQV);
        this.lXm = true;
        if (this.lXm) {
            this.ikn.setText(t.oM(this.title));
            String[] split = this.zbi.split(";");
            if (t.oM(this.zbi).length() <= 0) {
                this.zbj.setVisibility(8);
                this.zbk.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.zbj.setVisibility(0);
                    this.zbj.setText(t.oM(split[0]));
                } else {
                    this.zbj.setVisibility(8);
                }
                if (split.length > 1) {
                    this.zbk.setVisibility(0);
                    this.zbk.setText(t.oM(split[1]));
                } else {
                    this.zbk.setVisibility(8);
                }
                if (split.length > 2) {
                    this.zbl.setVisibility(0);
                    this.zbl.setText(t.oM(split[2]));
                }
            }
            this.zbl.setVisibility(8);
        } else {
            x.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
    }
}
