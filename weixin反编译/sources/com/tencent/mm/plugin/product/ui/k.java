package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k extends BaseAdapter {
    private Context mContext;
    OnItemClickListener pmb;
    List<n> pmi;

    class a {
        public TextView pmc = null;
        public MaxGridView pmd = null;
        public l pmj = null;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return uZ(i);
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pmi != null ? this.pmi.size() : 0;
    }

    private n uZ(int i) {
        return (n) this.pmi.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        n uZ = uZ(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a();
            view = View.inflate(this.mContext, g.uKh, null);
            aVar2.pmc = (TextView) view.findViewById(f.uxx);
            aVar2.pmd = (MaxGridView) view.findViewById(f.uxw);
            aVar2.pmj = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pmc.setText(uZ.name);
        aVar.pmd.setOnItemClickListener(this.pmb);
        aVar.pmj.pml = uZ.pkd;
        aVar.pmj.notifyDataSetChanged();
        aVar.pmd.setAdapter(aVar.pmj);
        return view;
    }
}
