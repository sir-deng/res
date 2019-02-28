package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    List<com.tencent.mm.plugin.collect.b.a> lqU = new ArrayList();
    private Context mContext;

    private static class a {
        TextView lpZ;
        TextView lqV;
        WalletTextView lqW;

        public a(View view) {
            this.lqV = (TextView) view.findViewById(f.uou);
            this.lqW = (WalletTextView) view.findViewById(f.uoL);
            this.lpZ = (TextView) view.findViewById(f.uov);
        }
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.lqU.size();
    }

    public final Object getItem(int i) {
        return this.lqU.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fw(this.mContext).inflate(g.uHT, viewGroup, false);
            view.setTag(new a(view));
        }
        com.tencent.mm.plugin.collect.b.a aVar = (com.tencent.mm.plugin.collect.b.a) this.lqU.get(i);
        a aVar2 = (a) view.getTag();
        aVar2.lqV.setText(new SimpleDateFormat(this.mContext.getString(i.uOO)).format(new Date(aVar.timestamp * 1000)));
        aVar2.lqW.setText(e.oI(aVar.fqJ));
        if (bi.oN(aVar.desc)) {
            aVar2.lpZ.setVisibility(8);
        } else {
            aVar2.lpZ.setText(aVar.desc);
            aVar2.lpZ.setVisibility(0);
        }
        return view;
    }
}
