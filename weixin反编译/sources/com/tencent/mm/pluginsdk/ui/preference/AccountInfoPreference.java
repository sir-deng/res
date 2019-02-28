package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class AccountInfoPreference extends Preference {
    public String userName;
    public SpannableString vzD;
    public String vzE;
    private int vzF;
    public OnClickListener vzG;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vzG = null;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.bLM);
        if (!(this.userName == null || imageView == null || !g.Do().CF())) {
            b.a(imageView, this.userName);
        }
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) view.findViewById(R.h.cAp);
        if (!(this.userName == null || noMeasuredTextView == null)) {
            noMeasuredTextView.yoG = true;
            noMeasuredTextView.O((float) a.aa(this.mContext, R.f.bvL));
            noMeasuredTextView.setTextColor(a.Z(this.mContext, R.e.btv));
            noMeasuredTextView.setText(this.vzD == null ? this.userName : this.vzD);
        }
        TextView textView = (TextView) view.findViewById(R.h.cUr);
        if (this.vzE != null && textView != null) {
            textView.setText(view.getResources().getString(R.l.dDU, new Object[]{this.vzE}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(R.h.cIl);
        if (textView != null) {
            if (this.vzF > 99) {
                textView.setText(this.mContext.getString(R.l.eQI));
                textView.setBackgroundResource(s.ge(this.mContext));
                textView.setVisibility(0);
            } else if (this.vzF > 0) {
                textView.setText(this.vzF);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (this.vzG != null) {
            ((ImageView) view.findViewById(R.h.bIx)).setOnClickListener(this.vzG);
        }
    }
}
