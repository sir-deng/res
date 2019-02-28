package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int piC;
    private static float piD = 16.0f;
    f jPY;
    private View mView = null;
    String piE;
    private String[] piF;
    private TruncateAt piG;
    private boolean piH = false;

    static /* synthetic */ TextView a(g gVar, String str) {
        TextView textView = new TextView(gVar.mContext);
        textView.setText(str);
        textView.setTextSize(piD);
        textView.setTextColor(piC);
        if (gVar.piH) {
            textView.setSingleLine(true);
            textView.setEllipsize(gVar.piG);
        } else {
            textView.setSingleLine(false);
        }
        return textView;
    }

    public g(Context context) {
        super(context);
        setLayoutResource(com.tencent.mm.plugin.wxpay.a.g.uJy);
        piC = context.getResources().getColor(c.uhD);
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
        final TextView textView = (TextView) view.findViewById(a.f.uwO);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.uwN);
        ((TextView) view.findViewById(a.f.uwP)).setText(getTitle());
        if (this.piF == null || this.piF.length <= 1) {
            textView.setTextColor(piC);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    textView.setVisibility(8);
                    for (String a : g.this.piF) {
                        linearLayout.addView(g.a(g.this, a), new LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (g.this.jPY != null) {
                        g.this.jPY.notifyDataSetChanged();
                    }
                }
            });
        }
        textView.setText(this.piE);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.piF = strArr;
        this.piG = truncateAt;
        this.piH = true;
    }
}
