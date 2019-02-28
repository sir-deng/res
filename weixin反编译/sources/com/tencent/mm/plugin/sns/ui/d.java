package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends BaseAdapter {
    private final Context mContext;
    private String nWh = null;
    public b rwm = null;

    public d(Context context, b bVar) {
        this.mContext = context;
        this.rwm = bVar;
        this.nWh = w.eM(ad.getContext());
    }

    public final int getCount() {
        return this.rwm.qWL.rSq.rkj.bxc().size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        if (view == null) {
            view = View.inflate(this.mContext, g.qMu, null);
        }
        view.setTag(this.rwm);
        a aVar = (a) getItem(i);
        Object charSequence2;
        if ("zh_CN".equals(this.nWh)) {
            charSequence2 = aVar.rkt;
        } else if ("zh_TW".equals(this.nWh) || "zh_HK".equals(this.nWh)) {
            charSequence2 = aVar.rku;
        } else {
            charSequence2 = aVar.rkv;
        }
        ((TextView) view.findViewById(f.qGu)).setText(charSequence2);
        view.findViewById(f.qGt).setVisibility(i == getCount() + -1 ? 8 : 0);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        return this.rwm.qWL.rSq.rkj.bxc().get(i);
    }
}
