package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    public View lzm;
    private View mView = null;
    private OnClickListener mdb;
    public String niK;
    public boolean niO;
    private int piA = -1;
    private int piy = Integer.MAX_VALUE;
    private int piz = -1;

    public d(Context context) {
        super(context, null);
        setLayoutResource(g.uIC);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(f.uDR);
        ((TextView) view.findViewById(f.urR)).setText(getTitle());
        this.lzm = view;
        if (this.piy != Integer.MAX_VALUE) {
            textView.setTextColor(this.piy);
        }
        if (!this.niO) {
            textView.setOnClickListener(null);
            textView.setText(i.b(this.mContext, this.niK, textView.getTextSize()));
        } else if (this.piz < 0 || this.piA <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(c.uhA));
            textView.setOnClickListener(this.mdb);
            textView.setText(i.b(this.mContext, this.niK, textView.getTextSize()));
        } else {
            g gVar = new g(this.mContext);
            CharSequence spannableString = new SpannableString(this.niK);
            gVar.sZF = new a() {
                public final void onClick(View view) {
                    if (d.this.mdb != null) {
                        d.this.mdb.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(gVar, this.piz, this.piA, 33);
            textView.setText(spannableString);
        }
    }
}
