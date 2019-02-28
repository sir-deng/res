package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<TransferRecordParcel> pNk;
    private List<TransferRecordParcel> pNl = new ArrayList();
    private List<Pair<Integer, Integer>> pNm = new ArrayList();
    private Filter pNn;

    private class a extends Filter {
        List<TransferRecordParcel> pNo;

        private a() {
            this.pNo = new ArrayList();
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            this.pNo.clear();
            c.this.pNm.clear();
            x.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", charSequence);
            for (TransferRecordParcel transferRecordParcel : c.this.pNk) {
                if (!bi.N(charSequence) && transferRecordParcel.pNv.contains(charSequence)) {
                    int indexOf = transferRecordParcel.pNv.indexOf((String) charSequence);
                    x.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", transferRecordParcel.pNv, Integer.valueOf(indexOf), Integer.valueOf(charSequence.length() + indexOf));
                    c.this.pNm.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(r3)));
                    this.pNo.add(transferRecordParcel);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.count = this.pNo.size();
            filterResults.values = this.pNo;
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            c.this.pNl = (List) filterResults.values;
            x.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", Integer.valueOf(c.this.pNl.size()));
            c.this.notifyDataSetChanged();
        }
    }

    private class b {
        CdnImageView pNq;
        TextView pNr;
        TextView pNs;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    public c(Context context, List<TransferRecordParcel> list) {
        this.mContext = context;
        this.pNk = list;
    }

    public final int getCount() {
        return this.pNl.size();
    }

    public final Object getItem(int i) {
        return this.pNl.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(g.uHF, viewGroup, false);
            b bVar = new b();
            bVar.pNq = (CdnImageView) view.findViewById(f.unh);
            bVar.pNr = (TextView) view.findViewById(f.unj);
            bVar.pNs = (TextView) view.findViewById(f.uni);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
        Pair pair = (Pair) this.pNm.get(i);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
        CharSequence spannableString = new SpannableString(transferRecordParcel.pNv);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        bVar2.pNq.setUrl(transferRecordParcel.pMZ);
        bVar2.pNr.setText(spannableString);
        bVar2.pNs.setText(this.mContext.getString(i.uOx, new Object[]{transferRecordParcel.nHt, transferRecordParcel.pNu}));
        return view;
    }

    public final Filter getFilter() {
        if (this.pNn == null) {
            this.pNn = new a();
        }
        return this.pNn;
    }
}
