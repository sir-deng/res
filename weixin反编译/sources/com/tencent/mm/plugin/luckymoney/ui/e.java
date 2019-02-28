package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class e extends d {
    private Context mContext = null;

    class a {
        TextView jOY;
        TextView lpZ;
        TextView omb;
        TextView onI;
        int wn;

        a() {
        }
    }

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(g.uJb, viewGroup, false);
            a aVar2 = new a();
            aVar2.jOY = (TextView) view.findViewById(f.uuT);
            aVar2.lpZ = (TextView) view.findViewById(f.uuR);
            aVar2.onI = (TextView) view.findViewById(f.uuS);
            aVar2.omb = (TextView) view.findViewById(f.uuQ);
            aVar2.wn = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h sz = sz(i);
        aVar.jOY.setText(sz.ohY);
        aVar.onI.setText(sz.ohZ);
        aVar.omb.setText(this.mContext.getString(i.uQn, new Object[]{com.tencent.mm.wallet_core.ui.e.t(((double) sz.ohA) / 100.0d)}));
        CharSequence string = this.mContext.getString(i.uRu, new Object[]{Long.valueOf(sz.ohy), Long.valueOf(sz.oia)});
        if (sz.status == 5) {
            string = this.mContext.getString(i.uRv) + " " + string;
        }
        aVar.lpZ.setText(string);
        return view;
    }
}
