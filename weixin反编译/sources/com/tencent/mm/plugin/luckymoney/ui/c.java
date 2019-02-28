package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

public final class c extends d {
    private Context mContext;

    class a {
        TextView nwk;
        ImageView omY;
        TextView omb;
        TextView onI;

        a() {
        }
    }

    public c(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(g.uIZ, viewGroup, false);
            a aVar2 = new a();
            aVar2.nwk = (TextView) view.findViewById(f.uuO);
            aVar2.onI = (TextView) view.findViewById(f.uuP);
            aVar2.omb = (TextView) view.findViewById(f.uuK);
            aVar2.omY = (ImageView) view.findViewById(f.uuM);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h sz = sz(i);
        n.a(this.mContext, aVar.nwk, sz.ohV);
        aVar.onI.setText(sz.ohX);
        aVar.omb.setText(this.mContext.getString(i.uvJ, new Object[]{e.t(((double) sz.ohW) / 100.0d)}));
        if (sz.ohq == 1) {
            aVar.omY.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujy);
            aVar.omY.setVisibility(0);
        } else if (sz.ohq == 2) {
            aVar.omY.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujw);
            aVar.omY.setVisibility(0);
        } else {
            aVar.omY.setVisibility(8);
        }
        return view;
    }
}
