package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap hmD = null;
    OnClickListener mOnClickListener;
    private View mView = null;
    private TextView pdF;
    private ImageView piv;
    String piw = "";

    public c(Context context) {
        super(context);
        setLayoutResource(g.uJu);
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
        this.pdF = (TextView) view.findViewById(f.uwF);
        this.piv = (ImageView) view.findViewById(f.uwE);
        this.pdF.setText(this.piw);
        this.piv.setImageBitmap(this.hmD);
        this.piv.setOnClickListener(this.mOnClickListener);
        if (this.piw != null && this.piw.length() > 48) {
            this.pdF.setTextSize(0, (float) a.aa(this.mContext, d.bvt));
        }
    }
}
