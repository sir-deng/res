package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.n;
import com.tencent.mm.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;

public final class c extends Preference {
    String gBJ = null;
    private TextView jOY = null;
    private ImageView lpW = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public c(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(g.uIe);
    }

    public c(Context context, int i) {
        super(context);
        this.mContext = context;
        setLayoutResource(i);
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
        this.jOY = (TextView) view.findViewById(16908310);
        this.lpW = (ImageView) view.findViewById(f.upm);
        this.jOY.setText(i.b(this.mContext, this.mTitle, this.jOY.getTextSize()));
        if (bi.oN(this.gBJ)) {
            this.lpW.setVisibility(8);
            return;
        }
        this.lpW.setVisibility(0);
        com.tencent.mm.kernel.g.Dr();
        a Xu = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xu(this.gBJ);
        if (Xu == null || ((int) Xu.gKO) <= 0) {
            x.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            final long Wy = bi.Wy();
            ak.a.hhv.a(this.gBJ, "", new b.a() {
                public final void v(String str, boolean z) {
                    if (z) {
                        x.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bi.Wy() - Wy) + " ms");
                        com.tencent.mm.ac.b.I(str, 3);
                        n.JY().jb(str);
                    } else {
                        x.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.a(c.this.lpW, c.this.gBJ);
                }
            });
            return;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lpW, this.gBJ);
    }
}
