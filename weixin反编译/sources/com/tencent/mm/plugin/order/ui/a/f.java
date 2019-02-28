package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private View mView = null;
    private OnClickListener mdb;
    private String niK;
    private boolean niO;
    private int piA = -1;
    private int piy = Integer.MAX_VALUE;
    private int piz = -1;

    public f(Context context) {
        super(context);
        setLayoutResource(g.uJx);
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
        TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uwK);
        ((TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uwL)).setText(getTitle());
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
            a aVar = new a(this.mContext);
            CharSequence spannableString = new SpannableString(this.niK);
            aVar.piR = new a.a() {
                public final void onClick(View view) {
                    if (f.this.mdb != null) {
                        f.this.mdb.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.piz, this.piA, 33);
            textView.setText(spannableString);
        }
    }

    public final void HT(String str) {
        try {
            this.piy = Color.parseColor(str);
        } catch (Exception e) {
            this.piy = Integer.MAX_VALUE;
        }
    }

    public final void setContent(String str) {
        this.niK = str;
        this.niO = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.niK = str;
        this.niO = true;
        this.piz = i;
        this.piA = i2;
        this.mdb = onClickListener;
    }
}
