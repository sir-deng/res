package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> pjK = null;
    private List<String> plC = null;
    Filter plD = new Filter() {
        protected final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
            h.this.pjK = (List) filterResults.values;
            h.this.notifyDataSetChanged();
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : h.this.plC) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }
    };

    class a {
        TextView pli;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kF(i);
    }

    public h(Context context) {
        this.mContext = context;
        this.plC = com.tencent.mm.plugin.product.a.a.bjs().bju().pjK;
    }

    public final int getCount() {
        return this.pjK != null ? this.pjK.size() : 0;
    }

    private String kF(int i) {
        return (String) this.pjK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.pli = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pli.setText(kF(i));
        return view;
    }

    public final Filter getFilter() {
        return this.plD;
    }
}
