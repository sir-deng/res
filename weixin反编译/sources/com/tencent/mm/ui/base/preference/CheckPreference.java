package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class CheckPreference extends Preference {
    private TextView sOj;
    private int sOk;
    private String sOl;
    private int sOm;
    public boolean tYU;
    private CheckBox yqA;
    public int yqB;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tYU = false;
        this.sOk = -1;
        this.sOl = "";
        this.sOm = 8;
        this.yqB = -1;
        setLayoutResource(h.gZD);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.yqA = (CheckBox) view.findViewById(g.checkbox);
        this.yqA.setChecked(this.tYU);
        this.sOj = (TextView) view.findViewById(g.gYl);
        String str = this.sOl;
        int i = this.sOk;
        this.sOk = i;
        this.sOl = str;
        if (this.sOj != null) {
            if (i > 0) {
                this.sOj.setBackgroundResource(this.sOk);
            }
            if (!TextUtils.isEmpty(this.sOl)) {
                this.sOj.setText(this.sOl);
            }
        }
        this.sOm = this.sOm;
        if (this.sOj != null) {
            this.sOj.setVisibility(this.sOm);
        }
        LayoutParams layoutParams = (LayoutParams) this.yqA.getLayoutParams();
        if (-1 != this.yqB) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.yqB, layoutParams.bottomMargin);
        }
    }
}
